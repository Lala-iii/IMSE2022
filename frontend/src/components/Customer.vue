<template>
    <div class="container">
        <h1 class="text-center"> Customer list</h1>
        <table class="table table-striped"> 
         <thead> 
             <th> Customer ID </th>
             <th> Customer Firstname </th>
             <th> Customer Lastname </th>
             <th> Customer Company </th>
             <th> Customer E-Mail </th>
         </thead>
         <tbody> 
             <tr v-for= "customer in customers" v-bind:key = "customer.id"> 
                 <td> {{ customer.id }} </td>
                 <td> {{ customer.firstName }} </td>
                 <td> {{ customer.lastName }}</td>
                 <td> {{ customer.company }}</td>
                 <td> {{ customer.email }} </td>
             </tr>
         </tbody>
        </table>
         </div>
</template>

<script>
 import CustomerService from '../services/CustomerService'
  export default {
      name:'Customers',
      data() {
          return {
              customers : []
          }

      },
      methods: {
          getCustomers() {
              CustomerService.getCustomers().then((response) =>{
                  this.customers = response.data;
              });
          }
      },
      created() {
          this.getCustomers()
      }
    }
</script>

