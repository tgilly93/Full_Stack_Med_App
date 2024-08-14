<template>
  <router-link class="btn" v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link>
    <div class="appointment-container">
      <div class="appointment-form">
        <h1>Book an Appointment</h1>
        <form @submit.prevent="submitAppointment">
          <div class="form-group">
            <label for="patientName">Full Name</label>
            <input
              type="text"
              id="patientName"
              v-model="patientName"
              :class="{ 'is-invalid': errors.patientName }"
              required
            />
            <div v-if="errors.patientName" class="error">{{ errors.patientName }}</div>
          </div>
  
          <div class="form-group">
            <label for="email">Email</label>
            <input
              type="email"
              id="email"
              v-model="email"
              :class="{ 'is-invalid': errors.email }"
              required
            />
            <div v-if="errors.email" class="error">{{ errors.email }}</div>
          </div>
  
          <div class="form-group">
            <label for="phoneNumber">Phone Number</label>
            <input
              type="text"
              id="phoneNumber"
              v-model="phoneNumber"
              :class="{ 'is-invalid': errors.phoneNumber }"
              required
            />
            <div v-if="errors.phoneNumber" class="error">{{ errors.phoneNumber }}</div>
          </div>
  
          <div class="form-group">
            <label for="appointmentDate">Appointment Date</label>
            <input
              type="date"
              id="appointmentDate"
              v-model="appointmentDate"
              :class="{ 'is-invalid': errors.appointmentDate }"
              required
            />
            <div v-if="errors.appointmentDate" class="error">{{ errors.appointmentDate }}</div>
          </div>
  
          <div class="form-group">
            <label for="notes">Additional Notes</label>
            <textarea
              id="notes"
              v-model="notes"
            ></textarea>
          </div>
  
          <button type="submit" :disabled="!isFormValid">Book New Appointment</button>
        </form>
      </div>
  
      <div class="current-appointments">
        <h2>Current Appointments</h2>
        <ul>
          <li v-if="appointments.length === 0">No appointments found.</li>
          <li v-for="appointment in appointments" :key="appointment.id">
            <strong>{{ appointment.date }}</strong>
            <p>Name: {{ appointment.name }}</p>
            <p>Email: {{ appointment.email }}</p>
            <p>Phone: {{ appointment.phone }}</p>
            <p>Notes: {{ appointment.notes }}</p>
          </li>
        </ul>
      </div>
    </div>
  </template>
  
  <script>
  import AppointmentService from '../services/AppointmentService';

  export default {
    data() {
      return {
        patientName: '',
        email: '',
        phoneNumber: '',
        appointmentDate: '',
        notes: '',
        errors: {},
        appointments: []
      };
    },
    computed: {
      isFormValid() {
        return this.patientName && this.email && this.phoneNumber && this.appointmentDate && !Object.keys(this.errors).length;
      }
    },
    methods: {
      validateForm() {
        this.errors = {};
  
        if (!this.patientName) {
          this.errors.patientName = 'Name is required';
        }
  
        if (!this.email) {
          this.errors.email = 'Email is required';
        } else if (!/.+@.+/.test(this.email)) {
          this.errors.email = 'Email must be valid';
        }
  
        if (!this.phoneNumber) {
          this.errors.phoneNumber = 'Phone number is required';
        } else if (!/^\d{10}$/.test(this.phoneNumber)) {
          this.errors.phoneNumber = 'Phone number must be 10 digits';
        }
  
        if (!this.appointmentDate) {
          this.errors.appointmentDate = 'Appointment date is required';
        }
      },
      submitAppointment() {
        this.validateForm();
  
        if (this.isFormValid) {
          const appointmentData = {
            name: this.patientName,
            email: this.email,
            phone: this.phoneNumber,
            date: this.appointmentDate,
            notes: this.notes
          };
  
          // Replace with your API call to submit the appointment
          console.log('Submitting appointment:', appointmentData);
  
          // Optionally reset the form
          this.resetForm();
          this.fetchAppointments();  // Refresh the list of current appointments
        }
      },
      resetForm() {
        this.patientName = '';
        this.email = '';
        this.phoneNumber = '';
        this.appointmentDate = '';
        this.notes = '';
      },
      async fetchAppointments() {
        try {
          // Replace with your API endpoint
          const response = await fetch('/api/appointments');
          if (!response.ok) {
            throw new Error('Failed to fetch appointments');
          }
          this.appointments = await response.json();
        } catch (error) {
          console.error('Error fetching appointments:', error);
        }
      }
    },
    mounted() {
      this.fetchAppointments();
    }
  };
  </script>
  
  <style scoped>
  .appointment-container {
    max-width: 800px;
    margin: auto;
    padding: 20px;
  }
  
  .appointment-form,
  .current-appointments {
    margin-bottom: 30px;
  }
  
  h1, h2 {
    text-align: center;
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  label {
    display: block;
    margin-bottom: 5px;
    font-weight: bold;
  }
  
  input,
  textarea {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }

  button {
  padding: 10px 20px;
  background-color: #42b983;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button:hover {
  background-color: #368a6d;
}
  
  input.is-invalid,
  textarea.is-invalid {
    border-color: red;
  }
  
  .error {
    color: red;
    font-size: 0.875em;
  }
  
  button {
    display: block;
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
    font-size: 1em;
    cursor: pointer;
  }
  
  button:disabled {
    background-color: #6c757d;
    cursor: not-allowed;
  }
  
  ul {
    list-style-type: none;
    padding: 0;
  }
  
  li {
    background: #f9f9f9;
    border: 1px solid #ddd;
    border-radius: 4px;
    padding: 10px;
    margin-bottom: 10px;
  }
  </style>
  