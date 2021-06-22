<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户UID" prop="Uid">
        <el-input
          v-model="queryParams.Uid"
          placeholder="请输入用户UID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户名" prop="Name">
        <el-input
          v-model="queryParams.Name"
          placeholder="请输入用户名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户显示昵称" prop="DisplayName">
        <el-input
          v-model="queryParams.DisplayName"
          placeholder="请输入用户显示昵称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="Gender">
        <el-input
          v-model="queryParams.Gender"
          placeholder="请输入性别"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="Mobile">
        <el-input
          v-model="queryParams.Mobile"
          placeholder="请输入手机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="邮件" prop="Email">
        <el-input
          v-model="queryParams.Email"
          placeholder="请输入邮件"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="地址" prop="Address">
        <el-input
          v-model="queryParams.Address"
          placeholder="请输入地址"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="公司名" prop="Company">
        <el-input
          v-model="queryParams.Company"
          placeholder="请输入公司名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="社交" prop="Social">
        <el-input
          v-model="queryParams.Social"
          placeholder="请输入社交"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="密码" prop="PasswdMd5">
        <el-input
          v-model="queryParams.PasswdMd5"
          placeholder="请输入密码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="密码salt" prop="Salt">
        <el-input
          v-model="queryParams.Salt"
          placeholder="请输入密码salt"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户类型" prop="Type">
        <el-select v-model="queryParams.Type" placeholder="请选择用户类型" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="时间" prop="Dt">
        <el-input
          v-model="queryParams.Dt"
          placeholder="请输入时间"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建时间" prop="Createtime">
        <el-date-picker clearable size="small"
          v-model="queryParams.Createtime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="删除" prop="Deleted">
        <el-input
          v-model="queryParams.Deleted"
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
      <el-table-column label="用户UID" align="center" prop="Uid" />
      <el-table-column label="用户名" align="center" prop="Name" />
      <el-table-column label="用户显示昵称" align="center" prop="DisplayName" />
      <el-table-column label="性别" align="center" prop="Gender" />
      <el-table-column label="用户portrait" align="center" prop="Portrait" />
      <el-table-column label="手机号" align="center" prop="Mobile" />
      <el-table-column label="邮件" align="center" prop="Email" />
      <el-table-column label="地址" align="center" prop="Address" />
      <el-table-column label="公司名" align="center" prop="Company" />
      <el-table-column label="社交" align="center" prop="Social" />
      <el-table-column label="密码" align="center" prop="PasswdMd5" />
      <el-table-column label="密码salt" align="center" prop="Salt" />
      <el-table-column label="额外的" align="center" prop="Extra" />
      <el-table-column label="用户类型" align="center" prop="Type" />
      <el-table-column label="时间" align="center" prop="Dt" />
      <el-table-column label="创建时间" align="center" prop="Createtime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.Createtime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="删除" align="center" prop="Deleted" />
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
        <el-form-item label="用户UID" prop="Uid">
          <el-input v-model="form.Uid" placeholder="请输入用户UID" />
        </el-form-item>
        <el-form-item label="用户名" prop="Name">
          <el-input v-model="form.Name" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="用户显示昵称" prop="DisplayName">
          <el-input v-model="form.DisplayName" placeholder="请输入用户显示昵称" />
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
        <el-form-item label="密码" prop="PasswdMd5">
          <el-input v-model="form.PasswdMd5" placeholder="请输入密码" />
        </el-form-item>
        <el-form-item label="密码salt" prop="Salt">
          <el-input v-model="form.Salt" placeholder="请输入密码salt" />
        </el-form-item>
        <el-form-item label="额外的" prop="Extra">
          <el-input v-model="form.Extra" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="用户类型" prop="Type">
          <el-select v-model="form.Type" placeholder="请选择用户类型">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="时间" prop="Dt">
          <el-input v-model="form.Dt" placeholder="请输入时间" />
        </el-form-item>
        <el-form-item label="删除" prop="Deleted">
          <el-input v-model="form.Deleted" placeholder="请输入删除" />
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
import { listUser, getUser, delUser, addUser, updateUser, exportUser } from "@/api/system/user";

export default {
  name: "User",
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
        Uid: null,
        Name: null,
        DisplayName: null,
        Gender: null,
        Portrait: null,
        Mobile: null,
        Email: null,
        Address: null,
        Company: null,
        Social: null,
        PasswdMd5: null,
        Salt: null,
        Extra: null,
        Type: null,
        Dt: null,
        Createtime: null,
        Deleted: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        Uid: [
          { required: true, message: "用户UID不能为空", trigger: "blur" }
        ],
        Gender: [
          { required: true, message: "性别不能为空", trigger: "blur" }
        ],
        Dt: [
          { required: true, message: "时间不能为空", trigger: "blur" }
        ],
        Createtime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
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
      listUser(this.queryParams).then(response => {
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
        Uid: null,
        Name: null,
        DisplayName: null,
        Gender: null,
        Portrait: null,
        Mobile: null,
        Email: null,
        Address: null,
        Company: null,
        Social: null,
        PasswdMd5: null,
        Salt: null,
        Extra: null,
        Type: null,
        Dt: null,
        Createtime: null,
        Deleted: null
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
      getUser(id).then(response => {
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
            updateUser(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addUser(this.form).then(response => {
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
          return delUser(ids);
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
