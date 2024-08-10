-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER final_capstone_owner
WITH PASSWORD 'finalcapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;

CREATE USER final_capstone_appuser
WITH PASSWORD 'finalcapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;


/*SELECT users.user_id,
       username, password_hash, role,
patient_id, patient_first_name, patient_last_name, patient_date_of_birth, patient_address, patient_city, patient_state, zip_code, patient_phone_number
FROM public.users 
INNER JOIN public.patient ON users.user_id = patient.user_id
WHERE users.username ILIKE ?;*/