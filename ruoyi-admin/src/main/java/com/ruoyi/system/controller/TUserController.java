package com.ruoyi.system.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TUser;
import com.ruoyi.system.service.ITUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 聊天用户Controller
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
@RestController
@RequestMapping("/system/tuser")
public class TUserController extends BaseController
{
    @Autowired
    private ITUserService tUserService;

    /**
     * 查询聊天用户列表
     */
    @PreAuthorize("@ss.hasPermi('system:tuser:list')")
    @GetMapping("/list")
    public TableDataInfo list(TUser tUser)
    {
        System.out.println("---------tuserlist---------");
        startPage();
        List<TUser> list = tUserService.selectTUserList(tUser);
        return getDataTable(list);
    }

    /**
     * 导出聊天用户列表
     */
    @PreAuthorize("@ss.hasPermi('system:tuser:export')")
    @Log(title = "聊天用户", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TUser tUser)
    {
        List<TUser> list = tUserService.selectTUserList(tUser);
        ExcelUtil<TUser> util = new ExcelUtil<TUser>(TUser.class);
        return util.exportExcel(list, "聊天用户数据");
    }

    /**
     * 获取聊天用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:tuser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tUserService.selectTUserById(id));
    }

    /**
     * 新增聊天用户
     */
    @PreAuthorize("@ss.hasPermi('system:tuser:add')")
    @Log(title = "聊天用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TUser tUser)
    {
        return toAjax(tUserService.insertTUser(tUser));
    }

    /**
     * 修改聊天用户
     */
    @PreAuthorize("@ss.hasPermi('system:tuser:edit')")
    @Log(title = "聊天用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TUser tUser)
    {
        return toAjax(tUserService.updateTUser(tUser));
    }

    /**
     * 删除聊天用户
     */
    @PreAuthorize("@ss.hasPermi('system:tuser:remove')")
    @Log(title = "聊天用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tUserService.deleteTUserByIds(ids));
    }
}
