package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TChannelMapper;
import com.ruoyi.system.domain.TChannel;
import com.ruoyi.system.service.ITChannelService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
@Service
public class TChannelServiceImpl implements ITChannelService 
{
    @Autowired
    private TChannelMapper tChannelMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public TChannel selectTChannelById(Long id)
    {
        return tChannelMapper.selectTChannelById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tChannel 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TChannel> selectTChannelList(TChannel tChannel)
    {
        return tChannelMapper.selectTChannelList(tChannel);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tChannel 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTChannel(TChannel tChannel)
    {
        return tChannelMapper.insertTChannel(tChannel);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tChannel 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTChannel(TChannel tChannel)
    {
        return tChannelMapper.updateTChannel(tChannel);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteTChannelByIds(Long[] ids)
    {
        return tChannelMapper.deleteTChannelByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteTChannelById(Long id)
    {
        return tChannelMapper.deleteTChannelById(id);
    }
}
