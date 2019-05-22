package com.fubt.SaasChargeModule.provider.copartner.mapper;

import com.fubt.SaasChargeModule.api.copartner.model.Copartner;
import com.fubt.internals.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CopartnerMapper extends BaseMapper<Copartner,Long> {
    int deleteByPrimaryKey(Long id);

    int insert(Copartner record);

    int insertSelective(Copartner record);

    Copartner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Copartner record);

    int updateByPrimaryKey(Copartner record);

    //List<Copartner> pageQuery(@Param("uid")Long uid, @Param("roleId") Long roleId);

    /*
        条件查询
     */
    List<Copartner> pageQuery(Map map);

    /*
    根据邀请人id查询合伙人列表
     */
    List<Copartner> findByInviteId(@Param("inviteId") Long inviteId);

}