<template>
    <div class="neibu-container">
      <div class="neibu-form">所属板块：{{bankuaifromhomepage}}</div>
     <div class="neibu-form">帖子原标题：{{biaotifromhomepage}}</div>
      <div class="neibu-form">您的用户名为：{{yonghufromhomepage}}</div>
      <table class="table" >
        <tr>
          <td>内容</td>
          <td>来自用户</td>
        </tr>
        <tr>
          <td>{{neirongfromhomepage}}</td>
          <td>{{fatierenfromhomepage}}(楼主)</td>
        </tr>
        <tr v-for="item in huitie">
          <td>{{item.huitieneirong}}</td>
          <td>{{item.yonghu}}</td>
        </tr>
      </table>
      <div class="neibu-form1">
        回复内容：
        <textarea class="neibu-textarea" type="text" v-model="huitie_neirong"></textarea>
        <input class="neibu-button" type="button" value="回帖" @click="Huitietry()"/>
        <router-link :to="{path:'homepage', query: {neibugivetohomeyonghu:yonghufromhomepage,neibubackbankuai:bankuaifromhomepage}}">返回上页</router-link>
      </div>
    </div>

</template>

<script>
    export default {
        name: "tiezineibupage",
      data(){
        return{
          huitie:[],
        }
      },
      mounted() {//这玩意代表钩子函数，代表一旦进入本界面就执行一次init()函数，函数在下边有定义
        this.init();
        var tieziidfromhomepage = this.$route.query.tieziid
        this.tieziidfromhomepage = tieziidfromhomepage
        var yonghufromhomepage = this.$route.query.yonghu
        this.yonghufromhomepage = yonghufromhomepage
        var biaotifromhomepage = this.$route.query.givebiaoti
        this.biaotifromhomepage = biaotifromhomepage
        var neirongfromhomepage = this.$route.query.giveneirong
        this.neirongfromhomepage = neirongfromhomepage
        var fatierenfromhomepage = this.$route.query.givefatieren
        this.fatierenfromhomepage = fatierenfromhomepage
        var bankuaifromhomepage = this.$route.query.givebankuai
        this.bankuaifromhomepage = bankuaifromhomepage//这些地方都是接入了homepage页传过来的值，其中如绑定板块，和用户又使用router-linkto的方式传回给了homepage页，以便返回homepage页时登录用户以及当前板块的信息不丢失
        this.init()//此处为神来之笔，在没有此行的情况下，程序先执行一次init()，然后才获取tieziid等值
        //，导致init()里边var的justgo没有更新，实际为null，传回api的值为null，导致无用
        //其实把第一行的this.init()挪到最后一行就行，这也算是一个大坑了
      },
      methods: {
        init() {//很显然，是用来查询帖子内的回帖的，使用了bangdingtiezi参数来查询，其中所含的值其实是homepage传过来的唯一的帖子的id，保证了“这些回帖只属于这个帖子”
          var justgo = {
            bangdingtiezi:this.tieziidfromhomepage
          }
          this.Axios.post('/api/huitie/getAllHuitie',justgo).then(res => {
              this.huitie = res.data
            }, res => {
              alert('信息初始化失败！')
            }
          )
        },
        Huitietry(){//帖子内部关于回帖的函数
          var params2 = {
            huitieneirong: this.huitie_neirong,
            bangdingtiezi:this.tieziidfromhomepage,
            //还缺个用户，等会传
            //弄上了，直接在homepage也的query里加，这边再多加个接收就ok
            yonghu:this.yonghufromhomepage

          }
          this.Axios.post('/api/huitie/addHuitie',params2).then(res => {
              this.init()//用来在发帖后及时刷新帖子列表
              this.tiezitext = res.data
              this,init()
            }, res => {
              alert('error')
            }
          )
        },

      },
    }
</script>

<style scoped>
  /* 背景 */
  .neibu-container {
    background-color: #DCEFFE;
    width:100%;
    height:100%;
    background-size:100% 100%;
  }

  .neibu-form {/*框*/
    width:20%;
    height: auto;
    margin: 5px 5px; /* 上下间距300px，左右自动居中*/
    background-color: rgb(255, 255, 255,0.6); /* 透明背景色 */
    padding: 5px;
    border-radius: 20px; /* 圆角 */
  }

  .neibu-form1 {/*框*/
    width:70%;
    height: auto;
    margin: 5px 5px; /* 上下间距300px，左右自动居中*/
    background-color: rgb(255, 255, 255,0.6); /* 透明背景色 */
    padding: 5px;
    border-radius: 20px; /* 圆角 */
  }

  .neibu-button {
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

  .neibu-input {
    width:95%;
    height:40px;
    border:1px solid #dbdbdb;
    outline:none;
    font-size:20px;
    text-indent:10px;
    margin: 10px auto;
  }
  .neibu-textarea {
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
