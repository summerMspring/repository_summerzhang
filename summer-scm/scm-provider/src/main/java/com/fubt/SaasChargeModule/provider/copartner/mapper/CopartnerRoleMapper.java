package com.fubt.SaasChargeModule.provider.copartner.mapper;

import com.fubt.SaasChargeModule.api.copartner.model.CopartnerRole;
import com.fubt.internals.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CopartnerRoleMapper extends BaseMapper<CopartnerRole,Long> {
    int deleteByPrimaryKey(Long roleId);

    int insert(CopartnerRole record);

    int insertSelective(CopartnerRole record);

    CopartnerRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(CopartnerRole record);

    int updateByPrimaryKey(CopartnerRole record);

    //根据childRoleId获取角色
    CopartnerRole findByChildRoleId(@Param("childRoleId") Long parentId,@Param("partnerId")Long partnerId);

    //不分页获取角色列表
    List<CopartnerRole> findList(@Param("partnerId")Long partnerId);

}