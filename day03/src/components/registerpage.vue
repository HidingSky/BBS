<template>

    <div class="register-container">
    <div class="register-form">
      <div class="register-title"> 用户注册</div><br/>
      <div class="register-font">用户名:</div>
      <div style="text-align: center"><input class="register-input"placeholder="请输入用户名" type="text" v-model="registername"/></div><br/>
      <div class="register-font">密码:</div>
      <div style="text-align: center"><input type="text" class="register-input" placeholder="请输入密码" v-model="registerpassword"/></div><br/>
      <div style="text-align: center"><input class="register-button" type="button" value="注册" @click="submitInfo()"/></div><br/>
      <div style="text-align: center"><router-link :to="{name:'loginpage'}">已有账号？返回登录界面</router-link></div><br/>
      <div style="text-align: center">{{register_text}}</div>
  </div>
    </div>


</template>

<script>
    export default {
        name: "registerpage",
      data(){
          return{
            user:[],
            register_text:''
          }
      },
      mounted(){

      },
      methods: {
        submitInfo() {//这个函数是用来注册的，判断的主体在后端里，如果service层查到已有注册，
          //则不会再向数据库里写入，而是返回一个“该用户已被注册”，这句话再下方可以看到被register_text接收，并用vue特有的方式实时显示

          var params = {
            name: this.registername,
            password: this.registerpassword
          }
          this.Axios.post('/api/user/addUser',params).then(res => {
              this.register_text = res.data
            if(this.register_text=='注册成功'){//对后端传过来的字符串进行判断，当返回登录成功的string时，说明查到了用户，允许跳转并将用户名和默认的“主板块”进行传参
              alert('注册成功，将跳转到登录页面')
              this.$router.push({name:'loginpage'})//把用户名给送到homepage
            }
            }, res => {
              alert('error')
            }
          )
        }
      },



        beforeDestroy() {

        }
      }

</script>

<style scoped>

  .register-form {/*登录框*/
    width:20%;
    margin: 220px auto; /* 上下间距300px，左右自动居中*/
    background-color: rgb(255, 255, 255, 0.8); /* 透明背景色 */
    padding: 30px;
    border-radius: 20px; /* 圆角 */
  }

  /* 背景 */
  .register-container {
    position: absolute;
    width: 100%;
    height: 100%;
    background: url("/static/1.jpg");
  }

  .register-title {
    color: #303133;
    text-align: center;
    font-size: 30px;
  }

  .register-font {
    font-size: 20px;
  }

  .register-input {
    width:90%;
    height:40px;
    border:1px solid #dbdbdb;
    outline:none;
    font-size:20px;
    text-indent:10px;
    margin: 10px auto;
  }
  .register-button {
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
