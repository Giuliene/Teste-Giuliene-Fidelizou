<template>
  <div class="corpo">
    <h1 class="centralizado">{{titulo}}</h1>
    <meu-painel> 
      <table>     
        <thead>
          <tr>
            <th>abv</th>
            <th>address</th>
            <th>category</th>
            <th>city</th>
            <th>coordinates</th>
            <th>country</th>
            <th>description</th>
            <th>ibu</th>
            <th>name</th>
            <th>state</th>
            <th>website</th>
          </tr>
            <tr>
              <th>
                <input type="search" class="filtroAbv" v-on:input="filtroAbv = $event.target.value" placeholder="search...">
              </th>
              <th>
                 <input type="search" class="filtroAddress" v-on:input="filtroAddress = $event.target.value" placeholder="search...">
              </th>
              <th>
                 <input type="search" class="filtroCategory" v-on:input="filtroCategory = $event.target.value" placeholder="search...">
              </th>
              <th>
                 <input type="search" class="filtroCity" v-on:input="filtroCity = $event.target.value" placeholder="search...">
              </th>
              <th>
                 <input type="search" class="filtroCoordinates" v-on:input="filtroCoordinates = $event.target.value" placeholder="search...">
              </th>
              <th>
                 <input type="search" class="filtroCountry" v-on:input="filtroCountry = $event.target.value" placeholder="search...">
              </th>
              <th>
                 <input type="search" class="filtroDescription" v-on:input="filtroDescription = $event.target.value" placeholder="search...">
              </th>
              <th>
                 <input type="search" class="filtroIbu" v-on:input="filtroIbu = $event.target.value" placeholder="search...">
              </th>
              <th>
                 <input type="search" class="filtroName" v-on:input="filtroName = $event.target.value" placeholder="search...">
              </th>
              <th>
                 <input type="search" class="filtroState" v-on:input="filtroState = $event.target.value" placeholder="search...">
              </th>
              <th>
                 <input type="search" class="filtroWebsite" v-on:input="filtroWebsite = $event.target.value" placeholder="search...">
              </th>
            </tr>     
        </thead>
        <tbody>
          <tr  v-for="dado of dadosComFiltro">
            <td>{{dado.abv}}</td>
            <td>{{dado.address}}</td>
            <td>{{dado.category}}</td>
            <td>{{dado.city}}</td>
            <td>{{dado.coordinates}}</td>
            <td>{{dado.country}}</td>
            <td>{{dado.description}}</td>
            <td>{{dado.ibu}}</td>
            <td>{{dado.name}}</td>
            <td>{{dado.state}}</td>
            <td>{{dado.website}}</td>
          </tr> 
        </tbody>
        
      </table> 
    </meu-painel>
  </div>

</template>


<script>
import Painel from './components/shared/painel/Painel.vue'

export default {

  components: {
    'meu-painel' : Painel
  },

  data() {
    return {
      titulo: 'Teste Front',
      dados: [],
      resultado: [],
      filtroAbv: '',
      filtroAddress: '',
      filtroCategory: '',
      filtroCity: '',
      filtroCoordinates: '',
      filtroCountry: '',
      filtroDescription: '',
      filtroIbu: '',
      filtroName: '',
      filtroState: '',
      filtroWebsite: ''      
    }
  },
  
  computed: {
    dadosComFiltro() {
      this.resultado = this.dados
      if(this.filtroAbv) {
        let exp = new RegExp(this.filtroAbv.trim(), 'i')
        this.resultado = this.dados.filter(dado => exp.test(dado.abv))
      } 
      if(this.filtroAddress) {
        let exp = new RegExp(this.filtroAddress.trim(), 'i')
        this.resultado = this.resultado.filter(dado => exp.test(dado.address))
      } 
      if(this.filtroCategory) {
        let exp = new RegExp(this.filtroCategory.trim(), 'i')
        this.resultado = this.resultado.filter(dado => exp.test(dado.category))
      } 
      if(this.filtroCity) {
        let exp = new RegExp(this.filtroCity.trim(), 'i')
        this.resultado = this.resultado.filter(dado => exp.test(dado.city))
      }if(this.filtroCoordinates) {
        let exp = new RegExp(this.filtroCoordinates.trim(), 'i')
        this.resultado = this.resultado.filter(dado => exp.test(dado.coordinates))
      }
      if(this.filtroCountry) {
        let exp = new RegExp(this.filtroCountry.trim(), 'i')
        this.resultado = this.resultado.filter(dado => exp.test(dado.country))
      }
      if(this.filtroDescription) {
        let exp = new RegExp(this.filtroDescription.trim(), 'i')
        this.resultado = this.resultado.filter(dado => exp.test(dado.description))
      }
      if(this.filtroIbu) {
        let exp = new RegExp(this.filtroIbu.trim(), 'i')
        this.resultado = this.resultado.filter(dado => exp.test(dado.ibu))
      }
      if(this.filtroName) {
        let exp = new RegExp(this.filtroName.trim(), 'i')
        this.resultado = this.resultado.filter(dado => exp.test(dado.name))
      }
      if(this.filtroState) {
        let exp = new RegExp(this.filtroState.trim(), 'i')
        this.resultado = this.resultado.filter(dado => exp.test(dado.state))
      }
      if(this.filtroWebsite) {
        let exp = new RegExp(this.filtroWebsite.trim(), 'i')
        this.resultado = this.resultado.filter(dado => exp.test(dado.website))
      }
      return this.resultado
    }   
  },

  created() {
    this.$http.get('http://localhost:3000')
      .then(res => res.json())
      .then(dados => this.dados = dados, err => console.log(err))
  }
}
</script>

<style>
  .corpo{
    font-family: Helvetica, sans-serif;
    width: 96%;
    margin: 0 auto;
  }

  .centralizado {
    text-align: center;
  }

  .lista-dados {
    list-style: none;
  }

  .filtro {
    display: block;
    width: 100%;
  }

</style>
