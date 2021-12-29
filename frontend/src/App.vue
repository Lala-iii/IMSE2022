<template>
  <div id="app">
    <Customer />
  </div>
</template>

<script>
import Customer from './components/Customer.vue'
export default {
  name: 'App',
  components: {
    Customer
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
