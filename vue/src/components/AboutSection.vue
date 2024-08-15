<template>
    <div class="about-section">
      <h1>About Us</h1>
      <p>Welcome to our practice! At [Doctor-Patient Connect], we are committed to providing comprehensive and compassionate care to our patients. Our team of experienced general physicians is dedicated to addressing all your healthcare needs with the utmost professionalism and empathy.</p>
      
      <section class="mission">
        <h2>Our Mission</h2>
        <p>Our mission is to deliver high-quality, patient-centered care that promotes wellness and health. We strive to build long-lasting relationships with our patients and provide personalized treatment plans tailored to your individual health needs.</p>
      </section>
  
      <section class="services">
        <h2>Our Services</h2>
        <ul>
          <li>Routine Physical Exams</li>
          <li>Chronic Disease Management</li>
          <li>Preventive Care</li>
          <li>Vaccinations and Immunizations</li>
          <li>Health Screenings</li>
          <li>Diagnostic Services</li>
          <li>Patient Education</li>
        </ul>
      </section>
  
      <section class="team">
        <h2>Meet Our Team</h2>
        <div class="physician">
          <img src="/path/to/physician-photo.jpg" alt="Dr. John Doe">
          <h3>Dr. Java Blue</h3>
          <p>Dr. Java Blue is a board-certified general physician with over 15 years of experience in providing comprehensive healthcare. His areas of expertise include preventive medicine, chronic disease management, and patient education.</p>
        </div>
        <div class="physician">
          <img src="/path/to/physician-photo.jpg" alt="Dr. Jane Smith">
          <h3>Dr. Jane Smith</h3>
          <p>Dr. Jane Smith specializes in family medicine and is known for her compassionate approach to patient care. She has a strong background in managing both acute and chronic conditions and is dedicated to promoting health and wellness in the community.</p>
        </div>
      </section>
    </div>
  </template> 
  
  <script>
  export default {
    name: 'AboutSection',
  };
  </script>
  
  <style scoped>
  .about-section {
    padding: 20px;
    max-width: 800px;
    margin: 0 auto;
  }
  
  h1, h2, h3 {
    color: #333;
  }
  
  .mission, .services, .team {
    margin-bottom: 20px;
  }
  
  ul {
    list-style-type: none;
    padding: 0;
  }
  
  li {
    margin-bottom: 10px;
  }
  
  .physician {
    margin-bottom: 20px;
  }
  
  .physician img {
    width: 100px;
    height: 100px;
    border-radius: 50%;
    margin-right: 15px;
    vertical-align: middle;
  }
  
  .physician h3 {
    margin: 0;
  }
  </style>
  