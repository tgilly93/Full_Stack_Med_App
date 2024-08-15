<template>
  <div class="office-info">
    <div class="office-hours">
      <h2>Office Hours</h2>
      <ul>
        <li v-for="(hours, day) in office.officeHours" :key="day">
          {{ day }}: {{ hours }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import OfficeService from '../services/OfficeService';

export default {
  name: 'OfficeInfo',
  data() {
    return {
      office: {
        officeId: 1,
    officeName: "Java Blue",
    officePhoneNumber: "302-000-0000",
    officeAddress: "123 test lane",
    officeCity: "Newark",
    state: "DE",
    zipCode: "19702",
    doctors: "Java Blue",
    costPerHour: 0.0,
      officeHours: {
        'Monday': '8:00am - 5:00pm',
        'Tuesday': '8:00am - 5:00pm',
        'Wednesday': '8:00am - 5:00pm',
        'Thursday': '8:00am - 5:00pm',
        'Friday': '8:00am - 4:00pm',
        'Saturday': 'Closed',
        'Sunday': 'Closed'
      }
    }
    };
  },
  methods: {
    getOffice(){
      OfficeService.getOfficeById()
        .then(response =>{
          this.office=response.data;
        })
        .catch(error =>{
          console.log(error);
        })
    }
  },
  created(){
   // this.getOffice();
  }
};
</script>

<style scoped>
.office-info {
  font-family: Arial, sans-serif;
  display: grid;
  text-align: center;
  margin: auto;
  width: 80%;
  padding: 20px;
  background: #fff;
  margin-bottom: 20px;
}

h1 {
  color: #333;
  font-size: 22px;
}

strong {
  color: #555;
}

.office-hours ul {
  list-style-type: none;
  padding: 0;
}

.office-hours li {
  padding: 5px 0;
}
</style>