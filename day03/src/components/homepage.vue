<template>
    <div class="home-container">

      <div class="home-form" style="font-size: 30px">当前板块名：{{bangdingbankuaifromloginpage}}</div>
      <div class="home-form" style="font-size: 25px">您的用户名为：{{namefromloginpage}}</div>
      <img class="home-form" src="/static/2.png" >
      <div class="home-form1">
      <input class="home-button" type="button" value="主板块" @click="gozhu()"/>
      <input class="home-button" type="button" value="日常生活" @click="gorichang()"/>
      <input class="home-button" type="button" value="文章分享" @click="gowenzhang()"/>
      <input class="home-button" type="button" value="技术杂谈" @click="gojishu()"/>
      <input class="home-button" type="button" value="萌新报到" @click="gomengxin()"/>
      <input class="home-button" type="button" value="灌水闲聊" @click="goguanshui()"/>
      <input class="home-button" type="button" value="任务活动" @click="gorenwu()"/>
      <input class="home-button" type="button" value="论坛事务" @click="goluntanshiwu()"/>
      </div>

      <div>
      <table class="table">
        <tr>
          <td>贴名</td>
          <td>内容</td>
          <td>发帖人</td>
        </tr>
        <tr v-for="item in tiezi">
          <td><router-link :to="{path:'tiezineibupage', query:{tieziid:item.id,yonghu:namefromloginpage,givebiaoti:item.biaoti,giveneirong:item.neirong,givefatieren:item.fatieren,givebankuai:bangdingbankuaifromloginpage}}">{{item.biaoti}}</router-link></td>
          <td>{{item.neirong}}</td>
          <td>{{item.fatieren}}</td>
        </tr>
      </table>
      </div>

      <div class="home-form1">
      <div style="font-size: 15px">标题:</div>
        <input class="home-input" type="text" v-model="tiezibiaoti"/><br/>
        <div style="font-size: 15px">内容：</div>
        <textarea class="home-textarea" type="text" v-model="tiezineirong"></textarea>
      <input class="home-button" type="button" value="发帖" @click="fatietry()"/>
        <div style="font-size: 15px">{{tiezitext}}</div>
      </div>



    </div>
<!--vue前端只能有一个div，要想用多个必须嵌在第一个div里边
 -->

</template>

<script>
    export default {
        name: "homepage",
      data(){
          return {
            tiezi:[],
            tiezitext:'',
            id:'',
          }
      },
      mounted(){//钩子函数，代表一旦进入本界面就执行一次init()函数，函数在下边有定义
        this.init();
        var namefromloginpage = this.$route.params.namefromloginpage//用于接收由loginpage页送过来的用户名
        this.namefromloginpage = namefromloginpage//放在这钩子函数里，送过来赶紧就用上
        var bangdingbankuaifromloginpage = this.$route.params.givebangdingbankuai
        this.bangdingbankuaifromloginpage = bangdingbankuaifromloginpage
        var namefromneibupage = this.$route.query.neibugivetohomeyonghu
        if(namefromneibupage!=null){this.namefromloginpage = namefromneibupage}

        var bangdingbankuaifromneibupage = this.$route.query.neibubackbankuai
        if(bangdingbankuaifromneibupage!=null){this.bangdingbankuaifromloginpage = bangdingbankuaifromneibupage}//同上，这是奇迹的延续
        this.init()
      },
      methods: {
        init() {//先从login页接收了板块为“主板块”的参数，然后用此参数查出所有bangdingbankuai属性为“主板块”的帖子
          var params3 = {
            bangdingbankuai:this.bangdingbankuaifromloginpage
          }
          this.Axios.post('/api/tiezi/getAllTiezi', params3).then(res => {
              debugger
              this.tiezi = res.data
            }, res => {
              alert('信息初始化失败！')
            }
          )

        },
        gozhu(){//点击后强行更改bangdingbankuaifromloginpage的值，而这个值都是用this实时使用的，然后查贴，以达到更改板块的目的
          var params4 = {
            bangdingbankuai:'主板块'
          }
          this.bangdingbankuaifromloginpage='主板块'
          this.Axios.post('/api/tiezi/getAllTiezi', params4).then(res => {
              this.tiezi = res.data
            }, res => {
              alert('信息初始化失败！')
            }
          )
        },
        gorichang(){//类似，实现点击跳转到“校园生活”板块的效果
          var params4 = {
            bangdingbankuai:'日常生活'
          }
          this.bangdingbankuaifromloginpage='日常生活'
          this.Axios.post('/api/tiezi/getAllTiezi', params4).then(res => {
              this.tiezi = res.data
            }, res => {
              alert('信息初始化失败！')
            }
          )
        },
        gowenzhang(){//类似上方的函数，点击对应按钮后跳转到文章分享板块，不得不说，bangdingbankuaifromloginpage这个参数，绑定了5个传参
          var params4 = {
            bangdingbankuai:'文章分享'
          }
          this.bangdingbankuaifromloginpage='文章分享'
          this.Axios.post('/api/tiezi/getAllTiezi', params4).then(res => {
              this.tiezi = res.data
            }, res => {
              alert('信息初始化失败！')
            }
          )
        },
        gojishu(){
          var params4 = {
            bangdingbankuai:'技术杂谈'
          }
          this.bangdingbankuaifromloginpage='技术杂谈'
          this.Axios.post('/api/tiezi/getAllTiezi', params4).then(res => {
              this.tiezi = res.data
            }, res => {
              alert('信息初始化失败！')
            }
          )
        },
        gomengxin(){
          var params4 = {
            bangdingbankuai:'萌新报到'
          }
          this.bangdingbankuaifromloginpage='萌新报到'
          this.Axios.post('/api/tiezi/getAllTiezi', params4).then(res => {
              this.tiezi = res.data
            }, res => {
              alert('信息初始化失败！')
            }
          )
        },
        goluntanshiwu(){
          var params4 = {
            bangdingbankuai:'论坛事务'
          }
          this.bangdingbankuaifromloginpage='论坛事务'
          this.Axios.post('/api/tiezi/getAllTiezi', params4).then(res => {
              this.tiezi = res.data
            }, res => {
              alert('信息初始化失败！')
            }
          )
        },
        gorenwu(){
          var params4 = {
            bangdingbankuai:'任务活动'
          }
          this.bangdingbankuaifromloginpage='任务活动'
          this.Axios.post('/api/tiezi/getAllTiezi', params4).then(res => {
              this.tiezi = res.data
            }, res => {
              alert('信息初始化失败！')
            }
          )
        },
        goguanshui(){
          var params4 = {
            bangdingbankuai:'灌水闲聊'
          }
          this.bangdingbankuaifromloginpage='灌水闲聊'
          this.Axios.post('/api/tiezi/getAllTiezi', params4).then(res => {
              this.tiezi = res.data
            }, res => {
              alert('信息初始化失败！')
            }
          )
        },
        fatietry(){
          var params2 = {
            biaoti: this.tiezibiaoti,
            neirong: this.tiezineirong,
            fatieren: this.namefromloginpage,
            bangdingbankuai:this.bangdingbankuaifromloginpage
          }
          this.Axios.post('/api/tiezi/addTiezi',params2).then(res => {
              this.init()//用来在发帖后及时刷新帖子列表
              this.tiezitext = res.data
            }, res => {
              alert('error')
            }
          )
        },
        beforeDestroy() {

        }
      }
    }
</script>

<style scoped>
  /* 背景 */
  .home-container {
    background-color: #DCEFFE;
    width:100%;
    height:100%;
    background-size:100% 100%;
  }

  .home-form {/*框*/
    width:20%;
    height: auto;
    margin: 5px 5px;
    background-color: rgb(255, 255, 255,0.7); /* 透明背景色 */
    padding: 5px;
    border-radius: 20px; /* 圆角 */
  }

  .home-form1 {/*框*/
    width:70%;
    height: auto;
    margin: 5px 5px; /* 上下间距300px，左右自动居中*/
    background-color: rgb(255, 255, 255,0.6); /* 透明背景色 */
    padding: 5px;
    border-radius: 20px; /* 圆角 */
  }
  .home-form2 {/*框*/
    width:30%;
    height: auto;
    margin: 5px 5px; /* 上下间距300px，左右自动居中*/
    background-color: rgb(255, 255, 255,0.6); /* 透明背景色 */
    padding: 5px;
    border-radius: 20px; /* 圆角 */
  }

  .home-button {
    width: 150px;/*设置按钮宽度*/
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

  .home-input {
    width:95%;
    height:40px;
    border:1px solid #dbdbdb;
    outline:none;
    font-size:20px;
    text-indent:10px;
    margin: 10px auto;
  }
  .home-textarea {
    width:95%;
    height:150px;
    border:1px solid #dbdbdb;
    outline:none;
    font-size:20px;
    text-indent:10px;
    margin: 10px auto;
  }




  table

  {

    border-collapse: collapse;

    margin: 5px 5px;

    text-align: left;

    width: 70%;

  }

  table td, table th

  {

    border: 1px solid #cad9ea;

    color: #666;

    height: 30px;

  }

  table thead th

  {

    background-color: #CCE8EB;

    width: 100px;

  }

  table tr:nth-child(odd)

  {

    background: #fff;

  }

  table tr:nth-child(even)

  {

    background: #F5FAFA;

  }


</style>
