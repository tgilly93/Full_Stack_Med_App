import axios from 'axios';

const http = axios.create({
  baseURL: import.meta.env.VITE_REMOTE_API
});

export default {
  

  login(user) {
    return http.post('/login', user)
  },

  register(user) {
    return http.post('/register', user)
  },
  home(user) {
    return http.post('/home', user)
  }

}
