package com.techelevator.controller;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.techelevator.dao.AgendaDao;
import com.techelevator.model.Agenda;

@RestController
@CrossOrigin
@RequestMapping("/api/agendas")
public class AgendaController {
    @Autowired
    private AgendaDao agendaDao;

    @RequestMapping(path = "/{date}", method = RequestMethod.GET)
    public Agenda getAgendaByDate(@PathVariable Date date) {
        return agendaDao.getAgendaByDate(date);
    }

    @RequestMapping(path = "/dayOfWeek/{dayOfWeek}", method = RequestMethod.GET)
    public Agenda getAgendaByDayOfWeek(@PathVariable String dayOfWeek) {
        return agendaDao.getAgendaByDayOfWeek(dayOfWeek);
    }

    @RequestMapping(path = "/doctor/{doctorName}/{date}", method = RequestMethod.GET)
    public Agenda getAgendaByDoctorName(@PathVariable String doctorName, @PathVariable Date date) {
        return agendaDao.getAgendaByDoctorName(doctorName, date);
    }

    @RequestMapping(path = "/patient/{patientName}/{date}", method = RequestMethod.GET)
    public Agenda getAgendaByPatientName(@PathVariable String patientName, @PathVariable Date date) {
        return agendaDao.getAgendaByPatientName(patientName, date);
    }
    
    @RequestMapping(path = "/patient/{patientId}/{date}", method = RequestMethod.GET)
    public Agenda getAgendaByPatientId(@PathVariable int patientId, @PathVariable Date date) {
        return agendaDao.getAgendaByPatientId(patientId, date);
    }

    @RequestMapping(path = "/appointment/{appointmentType}/{date}", method = RequestMethod.GET)
    public Agenda getAgendaByAppointmentType(@PathVariable String appointmentType, @PathVariable Date date) {
        return agendaDao.getAgendaByAppointmentType(appointmentType, date);
    }

    @RequestMapping(path = "/appointment/{appointmentStatus}/{date}", method = RequestMethod.GET)
    public Agenda getAgendaByAppointmentStatus(@PathVariable String appointmentStatus, @PathVariable Date date) {
        return agendaDao.getAgendaByAppointmentStatus(appointmentStatus, date);
    }

    @RequestMapping(path = "/appointment/{scheduleBlock}/{date}", method = RequestMethod.GET)
    public Agenda getAgendaByScheduleBlock(@PathVariable int scheduleBlock, @PathVariable Date date) {
        return agendaDao.getAgendaByScheduleBlock(scheduleBlock, date);
    }

    @RequestMapping(path = "/appointment/{appointmentStartTime}/{date}", method = RequestMethod.GET)
    public Agenda getAgendaByAppointmentStartTime(@PathVariable Time appointmentStartTime, @PathVariable Date date) {
        return agendaDao.getAgendaByAppointmentStartTime(appointmentStartTime, date);
    }

    @RequestMapping(path = "/doctor/{doctorName}/{appointmentStatus}", method = RequestMethod.GET)
    public List<Agenda> getAllConfirmedByDoctor(@PathVariable String doctorName, @PathVariable String appointmentStatus) {
        return agendaDao.getAllConfirmedByDoctor(doctorName, appointmentStatus);
    }

    @RequestMapping(path = "/patient/{patientName}/{appointmentStatus}", method = RequestMethod.GET)
    public List<Agenda> getAllConfirmedByPatient(@PathVariable String patientName, @PathVariable String appointmentStatus) {
        return agendaDao.getAllConfirmedByPatient(patientName, appointmentStatus);
    }

    @RequestMapping(path = "/patient/{patientId}/{appointmentStatus}", method = RequestMethod.GET)
    public List<Agenda> getAllConfirmedByPatientId(@PathVariable int patientId, @PathVariable String appointmentStatus) {
        return agendaDao.getAllConfirmedByPatientId(patientId, appointmentStatus);
    }

    @RequestMapping(path = "/doctor/{doctorName}/{appointmentType}", method = RequestMethod.GET)
    public List<Agenda> getAllUrgentByDoctor(@PathVariable String doctorName, @PathVariable String appointmentType) {
        return agendaDao.getAllUrgentByDoctor(doctorName, appointmentType);
    }

    @RequestMapping(path = "/patient/{patientName}/{appointmentType}", method = RequestMethod.GET)
    public List<Agenda> getAllUrgentByPatient(@PathVariable String patientName, @PathVariable String appointmentType) {
        return agendaDao.getAllUrgentByPatient(patientName, appointmentType);
    }

    @RequestMapping(path = "/patient/{patientId}/{appointmentType}", method = RequestMethod.GET)
    public List<Agenda> getAllUrgentByPatientId(@PathVariable int patientId, @PathVariable String appointmentType) {
        return agendaDao.getAllUrgentByPatientId(patientId, appointmentType);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Agenda> getAllAgendas() {
        return agendaDao.getAllAgendas();
    }

    @RequestMapping(path = "/doctor/{doctorName}", method = RequestMethod.GET)
    public List<Agenda> getAllAgendasByDoctorName(@PathVariable String doctorName) {
        return agendaDao.getAllAgendasByDoctorName(doctorName);
    }

    @RequestMapping(path = "/patient/name/{patientName}", method = RequestMethod.GET)
    public List<Agenda> getAllAgendasByPatientName(@PathVariable String patientName) {
        return agendaDao.getAllAgendasByPatientName(patientName);
    }

    @RequestMapping(path = "/patient/id/{patientId}", method = RequestMethod.GET)
    public List<Agenda> getAllAgendasByPatientId(@PathVariable int patientId) {
        return agendaDao.getAllAgendasByPatientId(patientId);
    }

    @RequestMapping(path = "/appointment/{appointmentType}", method = RequestMethod.GET)
    public List<Agenda> getAllAgendasByAppointmentType(@PathVariable String appointmentType) {
        return agendaDao.getAllAgendasByAppointmentType(appointmentType);
    }

    @RequestMapping(path = "/appointment/{appointmentStatus}", method = RequestMethod.GET)
    public List<Agenda> getAllAgendasByAppointmentStatus(@PathVariable String appointmentStatus) {
        return agendaDao.getAllAgendasByAppointmentStatus(appointmentStatus);
    }

    @RequestMapping(path = "/{date}", method = RequestMethod.PUT)
    public boolean updateAgenda(@PathVariable Agenda date) {
        return agendaDao.updateAgenda(date);
    }

    @RequestMapping(path = "/{date}", method = RequestMethod.POST)
    public boolean addAgenda(@PathVariable Agenda date) {
        return agendaDao.addAgenda(date);
    }

    @RequestMapping(path = "/{date}", method = RequestMethod.DELETE)
    public boolean deleteAgenda(@PathVariable Date date) {
        return agendaDao.deleteAgenda(date);
    }

    @RequestMapping(path = "/patient/{patientId}", method = RequestMethod.DELETE)
    public boolean deleteAgendaByPatientId(@RequestParam int patientId) {
        return agendaDao.deleteAgendaByPatientId(patientId);
    }

    @RequestMapping(path = "/doctor/{doctorName}", method = RequestMethod.DELETE)
    public boolean deleteAgendaByDoctorName(@PathVariable String doctorName) {
        return agendaDao.deleteAgendaByDoctorName(doctorName);
    }

    @RequestMapping(path = "/patient/{patientName}", method = RequestMethod.DELETE)
    public boolean deleteAgendaByPatientName(@PathVariable String patientName) {
        return agendaDao.deleteAgendaByPatientName(patientName);
    }

    @RequestMapping(path = "/appointment/{appointmentType}", method = RequestMethod.DELETE)
    public boolean deleteAgendaByAppointmentType(@PathVariable String appointmentType) {
        return agendaDao.deleteAgendaByAppointmentType(appointmentType);
    }

    @RequestMapping(path = "/appointment/{appointmentStatus}", method = RequestMethod.DELETE)
    public boolean deleteAgendaByAppointmentStatus(@PathVariable String appointmentStatus) {
        return agendaDao.deleteAgendaByAppointmentStatus(appointmentStatus);
    }
    
    @RequestMapping(path = "/appointment/{scheduleBlock}", method = RequestMethod.DELETE)
    public boolean deleteAgendaByScheduleBlock(@PathVariable int scheduleBlock) {
        return agendaDao.deleteAgendaByScheduleBlock(scheduleBlock);
    }

    @RequestMapping(path = "/appointment/{appointmentStartTime}", method = RequestMethod.DELETE)
    public boolean deleteAgendaByAppointmentStartTime(@PathVariable Time appointmentStartTime) {
        return agendaDao.deleteAgendaByAppointmentStartTime(appointmentStartTime);
    }
}
