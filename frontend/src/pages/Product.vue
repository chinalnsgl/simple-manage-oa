<template>
    <section>
      <el-table :data="productsPage.content" height="500" stripe highlight-current-row v-loading="loading" @selection-change="selsChange" style="width: 100%;">
        <el-table-column type="selection" width="55">
        </el-table-column>
        <el-table-column type="index">
        </el-table-column>
        <el-table-column prop="productName" label="名称" width="120" sortable>
        </el-table-column>
        <el-table-column label="操作" align="center" width="150" fixed="right">
          <template slot-scope="scope">
            <el-button size="small" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
            <el-button type="danger" size="small" @click="handleDel(scope.$index, scope.row)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        layout="prev, pager, next, jumper, total"
        :total="productsPage.totalElements" @current-change="handleCurrentChange" style="float: right;">
      </el-pagination>
    </section>
</template>

<script>
import {mapState,mapActions} from 'vuex'

export default {
  data () {
    return {
      pageNo: 1,
      total: 0,
      loading: false,
      sels: []
    }
  },
  computed: {
    ...mapState(['productsPage'])
  },
  mounted () {
    this.loading = true
    this.getProducts(this.pageNo)
    setTimeout( () => {this.loading = false}, 200)
  },
  methods: {
    ...mapActions(['getProducts']),
    handleCurrentChange(val) {
      this.loading = true
      this.pageNo = val;
      this.getProducts(this.pageNo);
      setTimeout( () => {this.loading = false}, 150)
    },
    handleDel: function (index, row) {
      console.log(index, row)
    },
    handleEdit: function (index, row) {
      console.log(index, row)
    },
    selsChange (selection) {
      this.sels = selection
    }
  }

}
</script>

<style>

</style>
