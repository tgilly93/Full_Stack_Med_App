package com.techelevator.dao;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import com.techelevator.model.Agenda;

public interface AgendaDao {
    Agenda getAgendaByDate(Date date);
    Agenda getAgendaByDayOfWeek(String dayOfWeek);
    Agenda getAgendaByDoctorName(String doctorName, Date date);
    Agenda getAgendaByPatientName(String patientName, Date date);
    Agenda getAgendaByPatientId(int patientId, Date date) ;
    Agenda getAgendaByAppointmentType(String appointmentType, Date date);
    Agenda getAgendaByAppointmentStatus(String appointmentStatus, Date date);
    Agenda getAgendaByScheduleBlock(int scheduleBlock, Date date);
    Agenda getAgendaByAppointmentStartTime(Date appointmentStartTime, Date date);
    List<Agenda> getAllConfirmedByDoctor(String doctorName, String appointmentStatus);
    List<Agenda> getAllConfirmedByPatient(String patientName, String appointmentStatus);
    List<Agenda> getAllConfirmedByPatientId(int patientId, String appointmentStatus);
    List<Agenda> getAllUrgentByDoctor(String doctorName, String appointmentType);
    List<Agenda> getAllUrgentByPatient(String patientName, String appointmentType);
    List<Agenda> getAllUrgentByPatientId(int patientId, String appointmentType);
    List<Agenda> getAllAgendas();
    List<Agenda> getAllAgendasByDoctorName(String doctorName);
    List<Agenda> getAllAgendasByPatientName(String patientName);
    List<Agenda> getAllAgendasByPatientId(int patientId);
    List<Agenda> getAllAgendasByAppointmentType(String appointmentType);
    List<Agenda> getAllAgendasByAppointmentStatus(String appointmentStatus);
    boolean updateAgenda(Agenda agenda);
    boolean addAgenda(Agenda agenda);
    boolean deleteAgenda(Date date);
    boolean deleteAgendaByPatientId(int patientId);
    boolean deleteAgendaByDoctorName(String doctorName);
    boolean deleteAgendaByPatientName(String patientName);
    boolean deleteAgendaByAppointmentType(String appointmentType);
    boolean deleteAgendaByAppointmentStatus(String appointmentStatus);
    boolean deleteAgendaByScheduleBlock(int scheduleBlock);
    boolean deleteAgendaByAppointmentStartTime(Time appointmentStartTime);

}
