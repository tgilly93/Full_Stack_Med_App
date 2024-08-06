BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role, name, address, city, state_code, zip) VALUES
    ('user', '$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_USER',  'Jack O''Lantern', null, 'Cleveland', 'OH', '44123'),
    ('admin','$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_ADMIN', 'Jill O''Lantern', null, 'Beverly Hills', 'CA', '90210');

---------------------------------------------------------------------------
--------------------------test data for view modeling----------------------

INSERT INTO users (username,password_hash,role, name, address, city, state_code, zip) VALUES
    ('clinician_test', '$2a$10$tmxuYYg1f5T0eXsTPlq/V.DJUKmRHyFbJ.o.liI1T35TFbjs2xiem','ROLE_CLINICIAN',  'Jack O''Lantern', null, 'Cleveland', 'OH', '44123');


INSERT INTO office (office_name, office_address, office_phone_number, state, zip_code, office_open, office_close) VALUES ('test_name', '123 test lane', '000-555-5555', 'DE', '19702', '08:00:00', '19:00:00');

 

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

--------------------------------------------------------------------------------
COMMIT TRANSACTION;
