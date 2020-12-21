<template>
  <div class="login-container" >

    <div class="login-form">
      <div class="login-title">用户登录</div><br/>
      <div class="login-font">用户名:</div>
      <div style="text-align: center"><input class="login-input" type="text" placeholder="请输入用户名" v-model="loginname"/></div><br/>
      <div class="login-font">密码:</div>
      <div style="text-align: center"><input class="login-input" type="text" placeholder="请输入密码" v-model="loginpassword"/></div><br/>
    <div style="text-align: center"><input class="login-button" type="button" value="登录" @click="LoginTry()"/></div><br/>
    <div style="text-align: center"><router-link :to="{name:'registerpage'}">还未注册？</router-link></div>
    <div style="text-align: center">{{Login_text}}</div>
  </div>

  </div>

</template>

<script>
    export default {
        name: "loginpage",
      data(){
          return {
            Login_text: '',

          }
      },
      methods: {
          LoginTry(){
            var senttoAPI = {
              name: this.loginname,
              password: this.loginpassword
            }//把参数打包，并结合下方语句，传入后端api接口
            this.Axios.post('/api/user/getOneUser',senttoAPI).then(res => {
                this.Login_text = res.data
                if(this.Login_text=='登录成功'){//对后端传过来的字符串进行判断，当返回登录成功的string时，说明查到了用户，允许跳转并将用户名和默认的“主板块”进行传参
                  alert('登录成功，将跳转到论坛主页')
                  this.$router.push({name:'homepage',params:{namefromloginpage:senttoAPI.name,givebangdingbankuai:'主板块'}})//把用户名给送到homepage
                }
              }, res => {
                alert('error')
              }
            )
          }
      }

    }

</script>

<style scoped>

  .login-form {/*登录框*/
    width:20%;
    margin: 220px auto; /* 上下间距300px，左右自动居中*/
    background-color: rgb(255, 255, 255, 0.8); /* 透明背景色 */
    padding: 30px;
    border-radius: 20px; /* 圆角 */
  }

  /* 背景 */
  .login-container {
    position: absolute;
    width: 100%;
    height: 100%;
    background: url("/static/1.jpg");
  }

  .login-title {
    color: #303133;
    text-align: center;
    font-size: 30px;
  }

  .login-font {
    font-size: 20px;
  }

  .login-input {
    width:90%;
    height:40px;
    border:1px solid #dbdbdb;
    outline:none;
    font-size:20px;
    text-indent:10px;
    margin: 10px auto;
  }
  .login-button {
    width: 200px;/*设置按钮宽度*/
    height: 40px;/*设置按钮高度*/
    color:white;/*字体颜色*/
    background-color:cornflowerblue;/*按钮背景颜色*/
    border-radius: 5px;/*让按钮变得圆滑一点*/
    border-width: 0;/*消去按钮丑的边框*/
    margin: 10px auto;
    outline: none;/*取消轮廓*/
    font-size: 17px;/*设置字体大小*/
    text-align: center;/*字体居中*/
    cursor: pointer;/*设置鼠标箭头手势*/

  }


</style>
