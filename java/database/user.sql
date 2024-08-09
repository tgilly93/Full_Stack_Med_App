SELECT users.user_id, 
       username, password_hash, role,
patient_id, patient_first_name, patient_last_name, patient_date_of_birth, patient_address, patient_city, patient_state, zip_code, patient_phone_number
FROM public.users 
INNER JOIN public.patient ON users.user_id = patient.user_id
WHERE users.username ILIKE ?;