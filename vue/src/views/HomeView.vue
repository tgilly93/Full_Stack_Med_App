<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
    <p>{{ office.officeName }}</p>
  </div>
</template>

<script>
<<<<<<< HEAD
import OfficeInfo from "../components/OfficeInfo";

export default {
  components: {
    // eslint-disable-next-line vue/no-unused-components
    OfficeInfo 
  }
  
=======
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


>>>>>>> 803adae045b7d5802eed7fe36ca496c6efa9fd18
};
</script>
