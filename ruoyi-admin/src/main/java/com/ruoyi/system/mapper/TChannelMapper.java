package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TChannel;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2021-06-23
 */
public interface TChannelMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public TChannel selectTChannelById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tChannel 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TChannel> selectTChannelList(TChannel tChannel);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tChannel 【请填写功能名称】
     * @return 结果
     */
    public int insertTChannel(TChannel tChannel);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tChannel 【请填写功能名称】
     * @return 结果
     */
    public int updateTChannel(TChannel tChannel);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTChannelById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTChannelByIds(Long[] ids);
}
