import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listTUser(query) {
  return request({
    url: '/system/tuser/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getTUser(id) {
  return request({
    url: '/system/tuser/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addTUser(data) {
  return request({
    url: '/system/tuser',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateTUser(data) {
  return request({
    url: '/system/tuser',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delTUser(id) {
  return request({
    url: '/system/tuser/' + id,
    method: 'delete'
  })
}

// 导出【请填写功能名称】
export function exportTUser(query) {
  return request({
    url: '/system/tuser/export',
    method: 'get',
    params: query
  })
}