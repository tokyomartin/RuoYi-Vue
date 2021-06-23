<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户UID" prop="uid">
        <el-input
          v-model="queryParams.uid"
          placeholder="请输入用户UID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入用户名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户显示昵称" prop="displayName">
        <el-input
          v-model="queryParams.displayName"
          placeholder="请输入用户显示昵称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-input
          v-model="queryParams.gender"
          placeholder="请输入性别"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="mobile">
        <el-input
          v-model="queryParams.mobile"
          placeholder="请输入手机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮件" prop="email">
        <el-input
          v-model="queryParams.email"
          placeholder="请输入邮件"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入地址"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公司名" prop="company">
        <el-input
          v-model="queryParams.company"
          placeholder="请输入公司名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="社交" prop="social">
        <el-input
          v-model="queryParams.social"
          placeholder="请输入社交"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="密码" prop="passwdMd5">
        <el-input
          v-model="queryParams.passwdMd5"
          placeholder="请输入密码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="密码salt" prop="salt">
        <el-input
          v-model="queryParams.salt"
          placeholder="请输入密码salt"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择用户类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="时间" prop="dt">
        <el-input
          v-model="queryParams.dt"
          placeholder="请输入时间"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="删除" prop="deleted">
        <el-input
          v-model="queryParams.deleted"
          placeholder="请输入删除"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:user:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:user:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:user:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
		  :loading="exportLoading"
          @click="handleExport"
          v-hasPermi="['system:user:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="userList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用户ID" align="center" prop="id" />
      <el-table-column label="用户UID" align="center" prop="uid" />
      <el-table-column label="用户名" align="center" prop="name" />
      <el-table-column label="用户显示昵称" align="center" prop="displayName" />
      <el-table-column label="性别" align="center" prop="gender" />
      <el-table-column label="用户portrait" align="center" prop="portrait" />
      <el-table-column label="手机号" align="center" prop="mobile" />
      <el-table-column label="邮件" align="center" prop="email" />
      <el-table-column label="地址" align="center" prop="address" />
      <el-table-column label="公司名" align="center" prop="company" />
      <el-table-column label="社交" align="center" prop="social" />
<!--      <el-table-column label="密码" align="center" prop="passwdMd5" />-->
<!--      <el-table-column label="密码salt" align="center" prop="salt" />-->
      <el-table-column label="额外的" align="center" prop="extra" />
      <el-table-column label="用户类型" align="center" prop="type" />
      <el-table-column label="时间" align="center" prop="dt" />

      <el-table-column label="删除" align="center" prop="deleted" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:user:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:user:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改【请填写功能名称】对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户UID" prop="uid">
          <el-input v-model="form.uid" placeholder="请输入用户UID" />
        </el-form-item>
        <el-form-item label="用户名" prop="Name">
          <el-input v-model="form.Name" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="用户显示昵称" prop="displayName">
          <el-input v-model="form.displayName" placeholder="请输入用户显示昵称" />
        </el-form-item>
        <el-form-item label="性别" prop="Gender">
          <el-input v-model="form.Gender" placeholder="请输入性别" />
        </el-form-item>
        <el-form-item label="用户portrait" prop="Portrait">
          <el-input v-model="form.Portrait" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="手机号" prop="Mobile">
          <el-input v-model="form.Mobile" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="邮件" prop="Email">
          <el-input v-model="form.Email" placeholder="请输入邮件" />
        </el-form-item>
        <el-form-item label="地址" prop="Address">
          <el-input v-model="form.Address" placeholder="请输入地址" />
        </el-form-item>
        <el-form-item label="公司名" prop="Company">
          <el-input v-model="form.Company" placeholder="请输入公司名" />
        </el-form-item>
        <el-form-item label="社交" prop="Social">
          <el-input v-model="form.Social" placeholder="请输入社交" />
        </el-form-item>

<!--        <el-form-item label="密码" prop="PasswdMd5"> -->
<!--          <el-input v-model="form.PasswdMd5" placeholder="请输入密码" /> -->
<!--        </el-form-item>-->
<!--        <el-form-item label="密码salt" prop="Salt"> -->
<!--          <el-input v-model="form.Salt" placeholder="请输入密码salt" /> -->
<!--        </el-form-item> -->

        <el-form-item label="额外的" prop="Extra">
          <el-input v-model="form.Extra" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="用户类型" prop="Type">
          <el-select v-model="form.Type" placeholder="请选择用户类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="时间" prop="dt">
          <el-input v-model="form.dt" placeholder="请输入时间" />
        </el-form-item>
        <el-form-item label="删除" prop="deleted">
          <el-input v-model="form.deleted" placeholder="请输入删除" />
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTUser, getTUser, delTUser, addTUser, updateTUser, exportTUser } from "@/api/system/tuser";

export default {
  name: "TUser",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 【请填写功能名称】表格数据
      userList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        uid: null,
        name: null,
        displayName: null,
        gender: null,
        portrait: null,
        mobile: null,
        email: null,
        address: null,
        company: null,
        social: null,
        passwdMd5: null,
        salt: null,
        extra: null,
        type: null,
        dt: null,

        deleted: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        uid: [
          { required: true, message: "用户UID不能为空", trigger: "blur" }
        ],
        gender: [
          { required: true, message: "性别不能为空", trigger: "blur" }
        ],
        dt: [
          { required: true, message: "时间不能为空", trigger: "blur" }
        ],

      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询【请填写功能名称】列表 */
    getList() {
      this.loading = true;
	  console.log("--------listTUser------------");
      listTUser(this.queryParams).then(response => {
        this.userList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        uid: null,
        name: null,
        displayName: null,
        gender: null,
        portrait: null,
        mobile: null,
        email: null,
        address: null,
        company: null,
        social: null,
        passwdMd5: null,
        salt: null,
        extra: null,
        type: null,
        dt: null,

        deleted: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加【请填写功能名称】";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getTUser(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改【请填写功能名称】";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateTUser(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTUser(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除【请填写功能名称】编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delTUser(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有【请填写功能名称】数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportUser(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
