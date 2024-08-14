import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API
});

export default {
    getAppointmentId(){
        return http.get('/api/appointments/');
    }
}