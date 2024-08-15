<template>
    <div class="policy-container">
      <h1>Office Policies</h1>
  
      <div class="policy-section">
        <h2>Late Policy</h2>
        <p>
          If you arrive late to your appointment, we may need to reschedule
          your visit to ensure that we can provide adequate time for each
          patient. Please arrive at least 10 minutes before your scheduled
          appointment time. If you anticipate being late, please call our office
          as soon as possible to inform us.
        </p>
      </div>
  
      <div class="policy-section">
        <h2>Rescheduling Policy</h2>
        <p>
          If you need to reschedule your appointment, please provide at least
          24 hours notice. You can reschedule by calling our office or using
          our online scheduling system. Appointments rescheduled within 24 hours
          of the scheduled time may be subject to a rescheduling fee.
        </p>
      </div>
  
      <div class="policy-section">
        <h2>Missed Appointment Policy</h2>
        <p>
          Missed appointments are disruptive to our schedule and can impact other
          patients. If you miss your appointment without providing prior notice,
          a missed appointment fee may be charged. We understand that emergencies
          occur, and we will work with you if you have a valid reason for not
          being able to attend your appointment. Please contact our office as
          soon as you realize you will miss your appointment.
        </p>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'Policy'
  };
  </script>
  
  <style scoped>
  .policy-container {
    text-align: center;
    max-width: 800px;
    margin: auto;
    padding: 20px;
  }
  
  h1 {
    text-align: center;
    margin-bottom: 20px;
  }
  
  .policy-section {
    margin-bottom: 30px;
  }
  
  h2 {
    text-align: center;
    font-size: 1.5em;
    margin-bottom: 10px;
  }
  
  p {
    font-size: 1em;
    line-height: 1.6;
    color: #333;
  }
  </style>
  