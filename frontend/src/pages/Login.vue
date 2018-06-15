<template>
  <el-form :model="loginModel" ref="loginForm" :rules="rules" class="login-container">
    <h2 class="title">系统登录</h2>
    <el-form-item prop="account">
      <el-input type="text" v-model="loginModel.account" auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="password">
      <el-input type="password" v-model="loginModel.password" auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item style="width:100%;">
      <el-button type="primary" style="width:100%;" @click="valid" :loading="logining">登录</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import {login} from '../api'

export default {
  data () {
    return {
      logining: false,
      loginModel: {
        account: '',
        password: ''
      },
      rules: {
        account: [
          { required: true, message: '帐号必须指定', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '密码必须指定', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    valid () {
      this.$refs['loginForm'].validate(async (valid) => {
        if (valid) {
          this.login()
        }
      })
    },
    async login () {
      console.log(this.$router)
      console.log(this.$route)
      this.logining = true
      let result = await login(this.loginModel.account, this.loginModel.password)
      if (result.code === 200) {
        sessionStorage.setItem('user', JSON.stringify(result.data))
        this.$router.push('/home')
      } else {
        this.$alert('帐号或密码输入错误', '提示', {
          confirmButtonText: '确定'
        })
        this.logining = false
      }
    }
  }
}
</script>

<style lang="stylus" rel="stylesheet/stylus">
.login-container
  border 1px solid #eaeaea
  -webkit-border-radius 5px
  -moz-border-radius 5px
  border-radius 5px
  background-clip padding-box
  margin 180px auto
  width 350px
  padding 35px 35px 15px 35px
  background-color #FFFFFF
  box-shadow 0 0 25px #cac6c6
  .title
    margin 0 auto 40px auto
    text-align center
    color #505458
</style>
