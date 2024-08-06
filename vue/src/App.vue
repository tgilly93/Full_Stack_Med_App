<template>
  <div id="capstone-app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>
import OfficeInfo from './components/officeinfo';

export default {
  components: {
    // eslint-disable-next-line vue/no-unused-components
    OfficeInfo
  }
};
</script>
