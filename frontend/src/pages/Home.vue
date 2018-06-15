<template>
  <el-row class="home-container">
    <!--header-->
    <el-col :span="24" class="header">
      <el-col :span="20">图标Logo</el-col>
      <el-col :span="4">退出</el-col>
    </el-col>
    <!--main-->
    <el-col :span="24" class="main">
      <aside class="aside" >
        <el-menu default-active="product" router unique-opened>
          <el-menu-item index="product">
            <i class="el-icon-menu"></i>
            <template slot="title">产品管理</template>
          </el-menu-item>
          <el-menu-item index="2">
            <i class="el-icon-menu"></i>
            <template slot="title">工序管理</template>
          </el-menu-item>
          <el-menu-item index="employee">
            <i class="el-icon-menu"></i>
            <template slot="title">员工管理</template>
          </el-menu-item>
          <el-menu-item index="info">
            <i class="el-icon-menu"></i>
            <template slot="title">统计信息</template>
          </el-menu-item>
        </el-menu>
      </aside>
      <section class="content">
        <el-col :span="24">
          <router-view></router-view>
        </el-col>
      </section>
    </el-col>
  </el-row>
</template>

<script>
export default {
  data () {
    return {
      isCollapse: true
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="stylus" rel="stylesheet/stylus">
.home-container
  position absolute
  top 0
  bottom 0
  width 100%
  .header
    height 60px
    line-height 60px
    background-color #b3d8ff
  .main
    display: flex
    position absolute
    top 60px
    bottom 0
    overflow hidden
    aside
      min-width: 50px;
  .content
    flex 1
    background-color white
    padding 10px
    padding-bottom 1px
</style>
