BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

---------------------------------------------------------------------------
--------------------------test data for view modeling----------------------

INSERT INTO users (username, password_hash, role) VALUES ('clinician_test', '$2y$10$LSUmYkcPkE7jIr/f/7nf4u5hLYPXDM3qTT3gOmZdoYLVS0OVyw.7S', 'ROLE_CLINICIAN');

INSERT INTO users (username, password_hash, role) VALUES ('patient_test', '$2y$10$LSUmYkcPkE7jIr/f/7nf4u5hLYPXDM3qTT3gOmZdoYLVS0OVyw.7S', 'ROLE_PATIENT');

INSERT INTO office (office_name, office_address, office_phone_number, office_city, state, zip_code, office_open, office_close) VALUES ('test_name', '123 test lane', '000-555-5555', 'Newark', 'DE', '19702', '08:00:00', '19:00:00');

INSERT INTO patient (user_id, patient_first_name, patient_last_name, patient_date_of_birth, patient_address, patient_city, patient_state, zip_code, patient_phone_number) VALUES ('4', 'patient_test_fname', 'patient_test_lname', '01/01/1900', '123 test lane', 'Newark', 'DE', '19702', '555-000-5555');

INSERT INTO staff (office_id, staff_first_name, staff_last_name, staff_address, staff_phone_number) VALUES ('1','test_fname', 'test_lname', '456 test lane', '555-000-5555');

INSERT INTO clinician (user_id, npi_number, staff_id, primary_office, clinician_rate_per_hour) VALUES ('3','1000004441', '1', '1', '89.00');

INSERT INTO prescription (prescription_name, patient_id, npi_number, prescription_details, prescription_cost, insurance_coverage, prescription_status) VALUES ('Zolof', '1', '1000004441', 'Treats depression, anxiety, obsessive-compulsive disorder (OCD), post-traumatic stress disorder (PTSD), and premenstrual dysphoric disorder (PMDD)', '22.98', 'Uninsured', 'Active');

INSERT INTO prescription (prescription_name, patient_id, npi_number, prescription_details, prescription_cost, insurance_coverage, prescription_status) VALUES ('Tylenol', '1', '1000004441', 'Pain reliever', '22.98', 'Uninsured', 'Active');

INSERT INTO appointment (npi_number, patient_id, date, start_time, end_time, appointment_type, appointment_status) VALUES ('1000004441', '1', '08/07/2024', '08:00', '09:00', 'Well Visit', 'Confirmed');

INSERT INTO availability (npi_number, office_id, date, day_of_week, start_time, end_time, is_available) VALUES ('1000004441','1', '08/07/2024', 'Wednesday', '08:00', '09:00', 'true');

---------------------------------------------------------------------------------------------------
------------------------------------Views----------------------------------------------------------

CREATE VIEW patient_contact AS
SELECT
	patient_first_name,
	patient_last_name,
	patient_address,
	patient_city,
	patient_state,
	zip_code,
	patient_phone_number
FROM
	patient;

CREATE VIEW clinician_availability AS
SELECT
	c.primary_office as Location,
	s.staff_last_name as Clinician,
	a.day_of_week AS Day_of_Week,
	a.start_time,
	a.end_time,
	a.is_available
FROM
	clinician c
	INNER JOIN availability a on a.npi_number = c.npi_number
	INNER JOIN staff s on s.staff_id = c.staff_id;

CREATE VIEW scheduling_blocks AS
SELECT
	start_time || ' - ' || end_time as "Time Block",
	Count(*) as block_id,
	start_time,
	end_time
FROM
	availability
GROUP BY
	start_time, end_time;

CREATE VIEW scheduled_appointments AS
SELECT
	a.date as "Selected Date",
	a.patient_id as Patient,
	s.staff_last_name ||', ' || s.staff_first_name AS Doctor,
	sc.block_id as "Time Block",
	a.appointment_type as Type,
	a.appointment_status as Status
FROM
	appointment a
	JOIN clinician c on c.npi_number = a.npi_number
	JOIN staff s on s.staff_id = c.staff_id
	JOIN scheduling_blocks sc on sc.start_time = a.start_time AND sc.end_time = a.end_time;

CREATE VIEW office_info AS
SELECT
	office_name as Name,
	office_address as Location,
	office_city as City,
	state as State,
	zip_code as "Zip Code",
	office_phone_number as "Phone Number",
	office_open || ' - ' || office_close as "Hours of Operation"
FROM
	office;

CREATE VIEW clinician_office_info AS
SELECT 
	s.staff_first_name ||' ' || s.staff_last_name AS Physician,
	o.office_name as "Primary Location",
	o.office_address as Address,
	o.office_city as City,
	o.state as State,
	o.zip_code as "Zip Code",
	o.office_phone_number as "Phone Number",
	o.office_open || ' - ' || o.office_close as "Hours of Operation"
FROM
	office o
	JOIN staff s on s.office_id = o.office_id
	JOIN clinician c on c.staff_id = s.staff_id;
	
CREATE VIEW patient_active_prescription AS
SELECT
	pr.patient_id as "Patient ID",
	p.patient_first_name || ' ' || p.patient_last_name as "Name",
	p.patient_date_of_birth as "DOB",
	p.patient_address as "Street Address",
	p.patient_city as "City",
	p.patient_state as "State",
	p.zip_code as "Zip Code",
	p.patient_phone_number as "Phone",
	pr.prescription_id as "Prescription ID",
	pr.prescription_name as "Common Name",
	pr.prescription_details as "Description",
	pr.prescription_status as "Prescription Status",
	pr.npi_number as "Prescribing Clinician"

FROM
	prescription pr
	JOIN patient p on p.patient_id = pr.patient_id;	
	

CREATE VIEW prescription_info AS
SELECT
	prescription_id as "Prescription ID",
	prescription_name as "Prescription Name",
	prescription_details as "Description",
	prescription_cost as "Cost"
FROM
	prescription;

CREATE VIEW daily_agenda AS
SELECT
	current_date AS "Date",
    	TO_CHAR(current_date, 'Day') AS "Day_of_Week",
	s.staff_last_name ||', ' || s.staff_first_name AS "Doctor",	
	a.patient_id as "Patient",
	p.patient_first_name || ' ' || p.patient_last_name AS "Patient Name",
	sc.block_id as "Time Block",
	sc.start_time,
	sc.end_time,
	a.appointment_type as Type,
	a.appointment_status as Status
FROM
	appointment a
	JOIN availability av on av.date = a.date
	JOIN clinician c on c.npi_number = av.npi_number
	JOIN staff s on s.staff_id = c.staff_id
	JOIN patient p on p.patient_id = a.patient_id
	JOIN scheduling_blocks sc on sc.start_time = a.start_time AND sc.end_time = a.end_time;
	
--------------------------------------------------------------------------------
COMMIT TRANSACTION;
