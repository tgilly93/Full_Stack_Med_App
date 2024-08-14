<template>
  <div class="home">
    <header-vue />
    <features-vue />
    <office-info-vue />
  </div>
</template>
<script>
import HeaderVue from '../components/Header.vue';
import FeaturesVue from '../components/Features.vue';
import OfficeInfoVue from '../components/OfficeInfo.vue';


export default {
  components: {
    HeaderVue, 
    FeaturesVue, 
    OfficeInfoVue,
    

  }
};
</script>