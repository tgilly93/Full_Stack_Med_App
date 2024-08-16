import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API
});

export default {
    getAppointments(){
        return http.get('/api/agendas/agenda/all/patient/name/test');
    },

    submitAppointment(){
        return http.post('/api/agendas/create/agenda');
    }
}