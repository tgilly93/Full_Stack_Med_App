package com.techelevator.dao;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Agenda;

@Component
public class JbdcAgendaDao implements AgendaDao {
    private final JdbcTemplate jdbcTemplate;

    public JbdcAgendaDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Agenda mapRowToAgenda(SqlRowSet rs) {
        Agenda newAgenda = new Agenda();
        newAgenda.setDate(rs.getDate("Date"));
        newAgenda.setDayOfWeek(rs.getString("Day_of_Week"));
        newAgenda.setDoctorName(rs.getString("Doctor"));
        newAgenda.setPatientName(rs.getString("Patient Name"));
        newAgenda.setPatientId(rs.getInt("Patient"));
        newAgenda.setAppointmentType(rs.getString("type"));
        newAgenda.setAppointmentStatus(rs.getString("status"));
        newAgenda.setScheduleBlock(rs.getInt("Time Block"));
        newAgenda.setAppointmentStartTime(rs.getTime("start_time"));
        newAgenda.setAppointmentEndTime(rs.getTime("end_time"));

        return newAgenda;

    }
// lots of mini updates are needed here to ensure correct sql queries. Columns names are not correct and need to be updated to match the database schema. 
    @Override
    public Agenda getAgendaByDate(Date date) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE date = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, date);
        if (results.next()) {
            return mapRowToAgenda(results);
        }
        return null;
    }

    @Override
    public Agenda getAgendaByDayOfWeek(String dayOfWeek) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE day_of_week = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, dayOfWeek);
        if (results.next()) {
            return mapRowToAgenda(results);
        }
        return null;
    }

    @Override 
    public Agenda getAgendaByDoctorName(String doctorName, Date date) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE doctor_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorName);
        if (results.next()) {
            return mapRowToAgenda(results);
        }
        return null;
    }

    @Override
    public Agenda getAgendaByPatientName(String patientName, Date date) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE patient_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientName);
        if (results.next()) {
            return mapRowToAgenda(results);
        }
        return null;
    }

    @Override
    public Agenda getAgendaByPatientId(int patientId, Date date) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE patient_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        if (results.next()) {
            return mapRowToAgenda(results);
        }
        return null;
    }

    @Override
    public Agenda getAgendaByAppointmentType(String appointmentType, Date date) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE appointment_type = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, appointmentType);
        if (results.next()) {
            return mapRowToAgenda(results);
        }
        return null;
    }

    @Override
    public Agenda getAgendaByAppointmentStatus(String appointmentStatus, Date date) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE appointment_status = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, appointmentStatus);
        if (results.next()) {
            return mapRowToAgenda(results);
        }
        return null;
    }

    @Override
    public Agenda getAgendaByScheduleBlock(int scheduleBlock, Date date) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE schedule_block = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, scheduleBlock);
        if (results.next()) {
            return mapRowToAgenda(results);
        }
        return null;
    }

    @Override
    public Agenda getAgendaByAppointmentStartTime(Date appointmentStartTime, Date date) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE appointment_start_time = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, appointmentStartTime);
        if (results.next()) {
            return mapRowToAgenda(results);
        }
        return null;
    }

    @Override
    public List<Agenda> getAllConfirmedByDoctor(String doctorName, String appointmentStatus) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE doctor_name = ? AND appointment_status = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorName, appointmentStatus);
        List<Agenda> agendas = new ArrayList<>();
        while (results.next()) {
            agendas.add(mapRowToAgenda(results));
        }
        return agendas;
    }

    @Override
    public List<Agenda> getAllConfirmedByPatient(String patientName, String appointmentStatus) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE patient_name = ? AND appointment_status = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientName, appointmentStatus);
        List<Agenda> agendas = new ArrayList<>();
        while (results.next()) {
            agendas.add(mapRowToAgenda(results));
        }
        return agendas;
    }

    @Override
    public List<Agenda> getAllConfirmedByPatientId(int patientId, String appointmentStatus) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE patient_id = ? AND appointment_status = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId, appointmentStatus);
        List<Agenda> agendas = new ArrayList<>();
        while (results.next()) {
            agendas.add(mapRowToAgenda(results));
        }
        return agendas;
    }

    @Override
    public List<Agenda> getAllUrgentByDoctor(String doctorName, String appointmentType) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE doctor_name = ? AND appointment_type = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorName, appointmentType);
        List<Agenda> agendas = new ArrayList<>();
        while (results.next()) {
            agendas.add(mapRowToAgenda(results));
        }
        return agendas;
    }

    @Override
    public List<Agenda> getAllUrgentByPatient(String patientName, String appointmentType) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE patient_name = ? AND appointment_type = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientName, appointmentType);
        List<Agenda> agendas = new ArrayList<>();
        while (results.next()) {
            agendas.add(mapRowToAgenda(results));
        }
        return agendas;
    }

    @Override
    public List<Agenda> getAllUrgentByPatientId(int patientId, String appointmentType) {
        String sql = "SELECT *\n" +
                "FROM public.daily_agenda WHERE patient_id = ? AND appointment_type = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId, appointmentType);
        List<Agenda> agendas = new ArrayList<>();
        while (results.next()) {
            agendas.add(mapRowToAgenda(results));
        }
        return agendas;
    }

    @Override
    public List<Agenda> getAllAgendas() {
        String sql = "SELECT * FROM daily_agenda;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        List<Agenda> agendas = new ArrayList<>();
        while (results.next()) {
            agendas.add(mapRowToAgenda(results));
        }
        return agendas;
    }

    @Override
    public List<Agenda> getAllAgendasByDoctorName(String doctorName) {
        String sql = "SELECT * FROM daily_agenda WHERE doctor_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorName);
        List<Agenda> agendas = new ArrayList<>();
        while (results.next()) {
            agendas.add(mapRowToAgenda(results));
        }
        return agendas;
    }

    @Override
    public List<Agenda> getAllAgendasByPatientName(String patientName) {
        String sql = "SELECT * FROM public.daily_agenda WHERE patient_name = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientName);
        List<Agenda> agendas = new ArrayList<>();
        while (results.next()) {
            agendas.add(mapRowToAgenda(results));
        }
        return agendas;
    }

    @Override
    public List<Agenda> getAllAgendasByPatientId(int patientId) {
        String sql = "SELECT * FROM public.daily_agenda WHERE \"Patient\" = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, patientId);
        List<Agenda> agendas = new ArrayList<>();
        while (results.next()) {
            agendas.add(mapRowToAgenda(results));
        }
        return agendas;
    }

    @Override
    public List<Agenda> getAllAgendasByAppointmentType(String appointmentType) {
        String sql = "SELECT * FROM public.daily_agenda WHERE appointment_type = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, appointmentType);
        List<Agenda> agendas = new ArrayList<>();
        while (results.next()) {
            agendas.add(mapRowToAgenda(results));
        }
        return agendas;
    }

    @Override
    public List<Agenda> getAllAgendasByAppointmentStatus(String appointmentStatus) {
        String sql = "SELECT * FROM public.daily_agenda WHERE appointment_status = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, appointmentStatus);
        List<Agenda> agendas = new ArrayList<>();
        while (results.next()) {
            agendas.add(mapRowToAgenda(results));
        }
        return agendas;
    }

    @Override
    public boolean updateAgenda(Agenda agenda) {
        String sql = "UPDATE public.daily_agenda SET date = ?, day_of_week = ?, doctor_name = ?, patient_name = ?, patient_id = ?, appointment_type = ?, appointment_status = ?, schedule_block = ?, appointment_start_time = ?, appointment_end_time = ? WHERE date = ?;";
        return jdbcTemplate.update(sql, agenda.getDate(), agenda.getDayOfWeek(), agenda.getDoctorName(), agenda.getPatientName(), agenda.getPatientId(), agenda.getAppointmentType(), agenda.getAppointmentStatus(), agenda.getScheduleBlock(), agenda.getAppointmentStartTime(), agenda.getAppointmentEndTime()) == 1;
    }

    @Override
    public boolean addAgenda(Agenda agenda) {
        String sql = "INSERT INTO public.daily_agenda (date, day_of_week, doctor_name, patient_name, patient_id, appointment_type, appointment_status, schedule_block, appointment_start_time, appointment_end_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        return jdbcTemplate.update(sql, agenda.getDate(), agenda.getDayOfWeek(), agenda.getDoctorName(), agenda.getPatientName(), agenda.getPatientId(), agenda.getAppointmentType(), agenda.getAppointmentStatus(), agenda.getScheduleBlock(), agenda.getAppointmentStartTime(), agenda.getAppointmentEndTime()) == 1;
    }

    @Override
    public boolean deleteAgenda(Date date) {
        String sql = "DELETE FROM public.daily_daily_agenda WHERE date = ?;";
        return jdbcTemplate.update(sql, date) == 1;
    }

    @Override
    public boolean deleteAgendaByPatientId(int patientId) {
        String sql = "DELETE FROM public.daily_agenda WHERE patient_id = ?;";
        return jdbcTemplate.update(sql, patientId) == 1;
    }

    @Override
    public boolean deleteAgendaByDoctorName(String doctorName) {
        String sql = "DELETE FROM public.daily_agenda WHERE doctor_name = ?;";
        return jdbcTemplate.update(sql, doctorName) == 1;
    }

    @Override
    public boolean deleteAgendaByPatientName(String patientName) {
        String sql = "DELETE FROM public.daily_agenda WHERE patient_name = ?;";
        return jdbcTemplate.update(sql, patientName) == 1;
    }

    @Override
    public boolean deleteAgendaByAppointmentType(String appointmentType) {
        String sql = "DELETE FROM public.daily_agenda WHERE appointment_type = ?;";
        return jdbcTemplate.update(sql, appointmentType) == 1;
    }

    @Override
    public boolean deleteAgendaByAppointmentStatus(String appointmentStatus) {
        String sql = "DELETE FROM public.daily_agenda WHERE appointment_status = ?;";
        return jdbcTemplate.update(sql, appointmentStatus) == 1;
    }

    @Override
    public boolean deleteAgendaByScheduleBlock(int scheduleBlock) {
        String sql = "DELETE FROM public.daily_agenda WHERE schedule_block = ?;";
        return jdbcTemplate.update(sql, scheduleBlock) == 1;
    }

    @Override
    public boolean deleteAgendaByAppointmentStartTime(Time appointmentStartTime) {
        String sql = "DELETE FROM public.daily_agenda WHERE appointment_start_time = ?;";
        return jdbcTemplate.update(sql, appointmentStartTime) == 1;
    }


}
