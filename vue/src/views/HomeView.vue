<template>
  <div class="home">
    <header-vue />
    <features-vue />
    <office-info-vue />
    <policy-section-vue />
  </div>
</template>
<script>
import HeaderVue from '../components/Header.vue';
import FeaturesVue from '../components/Features.vue';
import OfficeInfoVue from '../components/OfficeInfo.vue';
import PolicySectionVue from '../components/PolicySection.vue';



export default {
  components: {
    HeaderVue, 
    FeaturesVue, 
    OfficeInfoVue,
    PolicySectionVue

  }
};
</script>