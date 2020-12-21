<template>
  <div id="app">
    <!--<img src="./assets/logo.png">-->
    <!--<router-view style="width: 100%;height: 100px;background-color: red" name="headers"/>-->
    <!--<input type="button" value="父传子" @click="sendChild()"/><br/>-->
    <!--<router-view :tochild="tochildData" @getChild="getChildData"/>-->
    <!--子传父的值：{{getchildData}}-->
    <!--<router-view style="width: 100%;height: 100px;background-color: green" name="footers"/>-->
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App',
  data(){
    return{
      tochildData:'123456798',
      getchildData:''
    }
  },
  methods:{
    sendChild(){
      this.tochildData = "123"
    },
    getChildData(data){
      this.getchildData = data
    }
  }
}
</script>

<style>
#app {
  /*font-family: 'Avenir', Helvetica, Arial, sans-serif;*/
  /*-webkit-font-smoothing: antialiased;*/
  /*-moz-osx-font-smoothing: grayscale;*/
  /*text-align: center;*/
  /*color: #2c3e50;*/
  /*margin-top: 60px;*/
}
</style>
