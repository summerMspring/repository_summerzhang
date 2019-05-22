package com.fubt.SaasChargeModule.api.copartner.service;

import com.fubt.SaasChargeModule.api.copartner.model.CopartnerRole;
import com.fubt.SaasChargeModule.api.copartner.vo.CopartnerRoleVo;
import com.fubt.internals.BaseService;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CopartnerRoleService extends BaseService<CopartnerRole, Long> {

    /*
    根据主键查询角色
     */
    CopartnerRole findById(Long id);

    /*
    根据角色childRoleId获取角色
     */
    CopartnerRole findByChildRoleId(Long childRoleId,Long partnerId);

    /**
     * 不分页查询所有角色列表
     * @param partnerId
     * @return
     */
    List<CopartnerRoleVo> findList(Long partnerId);

    /**
     * 分页查询角色列表
     * @param pageNum
     * @param pageSize
     * @param partnerId
     * @return
     */
    PageInfo<CopartnerRoleVo> pageList(Integer pageNum,Integer pageSize,Long partnerId);

    void save(CopartnerRole copartnerRole);



}
