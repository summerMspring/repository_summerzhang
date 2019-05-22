package com.fubt.SaasChargeModule.api.copartner.service;

import com.fubt.SaasChargeModule.api.copartner.model.Copartner;
import com.fubt.internals.BaseService;

import java.util.List;
import java.util.Map;

public interface CopartnerService extends BaseService<Copartner,Long> {

    Copartner findById(Long id);

    /*
    分页条件查询
     */
    List<Copartner> pageQuery(Map searchMap);

    /*
    根据邀请人id获取合伙人列表
     */
    List<Copartner> findByInviteId(Long inviteId);

    /*
    升级合伙人
     */
    Copartner upgradePartner(Copartner copartner);


}
