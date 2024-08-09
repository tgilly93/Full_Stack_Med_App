<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <p>{{ office.officeName }}</p>
  </div>
</template>

<script>
import OfficeService from '../services/OfficeService';

export default {
  data(){
   return{
    office: null
   }
    
  },
  methods:{
    getOffice(){
      OfficeService.getOfficeById()
      .then((response)=>(
        this.office = response.data
      ))
      .catch((error)=> {
        alert(error.response)
      })
    }

  },
  created(){
    this.getOffice();
  }


};
</script>
