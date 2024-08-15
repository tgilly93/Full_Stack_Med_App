<template>
    <nav>
                <a href="/" class="btn">Home</a>
            </nav>
    <div class="contact-section">
      <h2>Contact Us</h2>
      <div class="contact-details">
        <div class="contact-item">
          <h3>Office Address</h3>
          <p>{{ address }}</p>
        </div>
        <div class="contact-item">
          <h3>Phone Number</h3>
          <p>{{ phoneNumber }}</p>
        </div>
        <div class="contact-item">
          <h3>Email</h3>
          <p>{{ email }}</p>
        </div>
      </div>
      <p class="contact-message">
        If you have any questions, feel free to reach out to us at 
        <a :href="'mailto:' + email">{{ email }}</a>.
      </p>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        address: '123 Test Lane, Newark, DE 19702',
        phoneNumber: '(302) 000-0000',
        email: 'info@doctorpatientconnect.com',
      };
    },
  };
  </script>
  
  <style scoped>
  .contact-section {
    text-align: center;
    padding: 20px;
    background-color: #14e9bb;
    border: 1px solid #ddd;
  }
  
  .contact-details {
    margin-bottom: 20px;
  }
  
  .contact-item {
    margin-bottom: 10px;
  }
  
  .contact-item h3 {
    margin: 0 0 5px;
  }
  
  .contact-item p {
    margin: 0;
  }
  
  .contact-message {
    margin-top: 20px;
  }
  
  .contact-message a {
    color: #007bff;
    text-decoration: none;
  }
  
  .contact-message a:hover {
    text-decoration: underline;
  }
  </style>
  