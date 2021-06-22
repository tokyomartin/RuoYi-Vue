<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户ID" prop="Cid">
        <el-input
          v-model="queryParams.Cid"
          placeholder="请输入用户ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="频道名称" prop="Name">
        <el-input
          v-model="queryParams.Name"
          placeholder="请输入频道名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="频道拥有者" prop="Owner">
        <el-input
          v-model="queryParams.Owner"
          placeholder="请输入频道拥有者"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="频道状态" prop="Status">
        <el-select v-model="queryParams.Status" placeholder="请选择频道状态" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="频道验证码" prop="Secret">
        <el-input
          v-model="queryParams.Secret"
          placeholder="请输入频道验证码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="自动" prop="Automatic">
        <el-input
          v-model="queryParams.Automatic"
          placeholder="请输入自动"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:channel:add']"
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
          v-hasPermi="['system:channel:edit']"
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
          v-hasPermi="['system:channel:remove']"
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
          v-hasPermi="['system:channel:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="channelList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="频道ID" align="center" prop="id" />
      <el-table-column label="用户ID" align="center" prop="Cid" />
      <el-table-column label="频道名称" align="center" prop="Name" />
      <el-table-column label="频道portrait" align="center" prop="Portrait" />
      <el-table-column label="频道拥有者" align="center" prop="Owner" />
      <el-table-column label="频道状态" align="center" prop="Status" />
      <el-table-column label="频道描述" align="center" prop="Desc" />
      <el-table-column label="频道验证码" align="center" prop="Secret" />
      <el-table-column label="频道回调" align="center" prop="Callback" />
      <el-table-column label="频道extra" align="center" prop="Extra" />
      <el-table-column label="自动" align="center" prop="Automatic" />
      <el-table-column label="时间" align="center" prop="Dt" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:channel:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:channel:remove']"
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
        <el-form-item label="用户ID" prop="Cid">
          <el-input v-model="form.Cid" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="频道名称" prop="Name">
          <el-input v-model="form.Name" placeholder="请输入频道名称" />
        </el-form-item>
        <el-form-item label="频道portrait" prop="Portrait">
          <el-input v-model="form.Portrait" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="频道拥有者" prop="Owner">
          <el-input v-model="form.Owner" placeholder="请输入频道拥有者" />
        </el-form-item>
        <el-form-item label="频道状态">
          <el-radio-group v-model="form.Status">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="频道描述" prop="Desc">
          <el-input v-model="form.Desc" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="频道验证码" prop="Secret">
          <el-input v-model="form.Secret" placeholder="请输入频道验证码" />
        </el-form-item>
        <el-form-item label="频道回调" prop="Callback">
          <el-input v-model="form.Callback" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="频道extra" prop="Extra">
          <el-input v-model="form.Extra" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="自动" prop="Automatic">
          <el-input v-model="form.Automatic" placeholder="请输入自动" />
        </el-form-item>
        <el-form-item label="时间" prop="Dt">
          <el-input v-model="form.Dt" placeholder="请输入时间" />
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
import { listChannel, getChannel, delChannel, addChannel, updateChannel, exportChannel } from "@/api/system/channel";

export default {
  name: "Channel",
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
      channelList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        Cid: null,
        Name: null,
        Portrait: null,
        Owner: null,
        Status: null,
        Desc: null,
        Secret: null,
        Callback: null,
        Extra: null,
        Automatic: null,
        Dt: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        Cid: [
          { required: true, message: "用户ID不能为空", trigger: "blur" }
        ],
        Status: [
          { required: true, message: "频道状态不能为空", trigger: "blur" }
        ],
        Automatic: [
          { required: true, message: "自动不能为空", trigger: "blur" }
        ],
        Dt: [
          { required: true, message: "时间不能为空", trigger: "blur" }
        ]
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
      listChannel(this.queryParams).then(response => {
        this.channelList = response.rows;
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
        Cid: null,
        Name: null,
        Portrait: null,
        Owner: null,
        Status: 0,
        Desc: null,
        Secret: null,
        Callback: null,
        Extra: null,
        Automatic: null,
        Dt: null
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
      getChannel(id).then(response => {
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
            updateChannel(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addChannel(this.form).then(response => {
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
          return delChannel(ids);
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
          return exportChannel(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>
