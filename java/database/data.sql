BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role, name, address, city, state_code, zip) VALUES
    ('user', '$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_USER',  'Jack O''Lantern', null, 'Cleveland', 'OH', '44123'),
    ('admin','$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_ADMIN', 'Jill O''Lantern', null, 'Beverly Hills', 'CA', '90210');

---------------------------------------------------------------------------
--------------------------test data for view modeling----------------------

INSERT INTO users (username,password_hash,role, name, address, city, state_code, zip) VALUES
    ('clinician_test', '$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_CLINICIAN',  'Jack O''Lantern', null, 'Cleveland', 'OH', '44123');


INSERT INTO users (username, password_hash, role) VALUES ('patient_test', '$2y$10$LSUmYkcPkE7jIr/f/7nf4u5hLYPXDM3qTT3gOmZdoYLVS0OVyw.7S', 'ROLE_PATIENT');

INSERT INTO office (office_name, office_address, office_phone_number, office_city, state, zip_code, office_open, office_close) VALUES ('test_name', '123 test lane', '000-555-5555', 'Newark', 'DE', '19702', '08:00:00', '19:00:00');

INSERT INTO patient (user_id, patient_first_name, patient_last_name, patient_date_of_birth, patient_address, patient_phone_number) VALUES ('4', 'patient_test_fname', 'patient_test_lname', '01/01/1900', '123 test lane', '555-000-5555'); 

---------------------------------------------------------------------------------------------------
------------------------------------Views----------------------------------------------------------

CREATE VIEW patient_contact AS
SELECT
	patient_first_name,
	patient_last_name,
	patient_address,
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
	date as "Selected Date",
	patient_id as Patient,
	s.staff_last_name ||', ' || s.staff_first_name AS Doctor,
	sc.block_id as "Time Block",
	appointment_type as Type,
	appointment_status as Status
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
	
	
	

--------------------------------------------------------------------------------
COMMIT TRANSACTION;
