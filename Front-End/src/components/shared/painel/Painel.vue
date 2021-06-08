<template>
    <div class="painel">
      <h2 class="painel-titulo"></h2>
      <slot class="painel-conteudo"></slot>      
    </div>  
</template>

<script>
  export default {
    props: ['abv', 'address', 'category', 'city', 'coordinates', 'country', 'description', 'ibu', 'name', 'state', 'website']
  }
</script>

<style scoped>
  table{
    margin: 20px 0 40px;
    border: solid 1px;
    background: rgb(255, 255, 255);
    height: 100%;
    table-layout: fixed;
    text-align: left;
    border-collapse: collapse;
  }

  td {
    margin: 20px 0 40px;
    border: 1px solid #000000;
    height: 100%;
    text-align: left;
  }

  thead {
     background: beige;
  
  }
  input {
    border-collapse: collapse;
    height: 100%;
    width: 100%
  }
</style>
