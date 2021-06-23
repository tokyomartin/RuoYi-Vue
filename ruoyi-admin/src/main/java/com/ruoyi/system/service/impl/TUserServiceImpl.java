package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TUserMapper;
import com.ruoyi.system.domain.TUser;
import com.ruoyi.system.service.ITUserService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
@Service
public class TUserServiceImpl implements ITUserService 
{
    @Autowired
    private TUserMapper tUserMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public TUser selectTUserById(Long id)
    {
        return tUserMapper.selectTUserById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tUser 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TUser> selectTUserList(TUser tUser)
    {
        return tUserMapper.selectTUserList(tUser);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tUser 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTUser(TUser tUser)
    {
        return tUserMapper.insertTUser(tUser);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tUser 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTUser(TUser tUser)
    {
        return tUserMapper.updateTUser(tUser);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteTUserByIds(Long[] ids)
    {
        return tUserMapper.deleteTUserByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteTUserById(Long id)
    {
        return tUserMapper.deleteTUserById(id);
    }
}
