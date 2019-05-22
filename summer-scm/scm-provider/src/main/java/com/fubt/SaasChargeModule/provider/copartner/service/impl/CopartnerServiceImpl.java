package com.fubt.SaasChargeModule.provider.copartner.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fubt.SaasChargeModule.api.copartner.model.Copartner;
import com.fubt.SaasChargeModule.api.copartner.model.CopartnerRole;
import com.fubt.SaasChargeModule.api.copartner.service.CopartnerRoleService;
import com.fubt.SaasChargeModule.api.copartner.service.CopartnerService;
import com.fubt.SaasChargeModule.provider.copartner.mapper.CopartnerMapper;
import com.fubt.internals.BaseMapper;
import com.fubt.internals.BaseServiceImpl;
import com.fubt.user.api.service.UserService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CopartnerServiceImpl extends BaseServiceImpl<Copartner,Long> implements CopartnerService {

    @Autowired
    private CopartnerMapper copartnerMapper;

    @Autowired
    private CopartnerRoleService roleService;

    //可以远程注入UserService
    //@Reference
    //private UserService userService;

    @Override
    protected BaseMapper<Copartner, Long> getMapper() {
        return copartnerMapper;
    }


    @Override
    public Copartner findById(Long id) {
        return copartnerMapper.selectByPrimaryKey(id);
    }

    //Long uid, Long roleId,String startTime,String endTime
    //Long uid, Long roleId,String startTime,String endTime,Integer pageNum,Integer pageSize
    @Override
    public List<Copartner> pageQuery(Map searchMap) {
        Integer pageNum = (Integer) searchMap.get("pageNum");
        if(pageNum==null){
            pageNum = 1;
        }

        Integer pageSize = (Integer) searchMap.get("pageSize");
        if(pageSize==null){
            pageSize=10;
        }
        PageHelper.startPage(pageNum,pageSize);
        Map map = new HashMap();
        Long uid = (Long) searchMap.get("uid");
        String roleId = (String) searchMap.get("roleId");
        String startTime = (String) searchMap.get("startTime");
        String endTime = (String) searchMap.get("endTime");
        map.put("uid",uid);
        map.put("roleId",roleId);
        try {
            if(StringUtils.isNotBlank(startTime)){
                Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
                map.put("startTime",startDate);
            }
            if(StringUtils.isNotBlank(endTime)){
                Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
                map.put("endTime",endDate);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return copartnerMapper.pageQuery(map);
    }

    @Override
    public List<Copartner> findByInviteId(Long inviteId){
        return copartnerMapper.findByInviteId(inviteId);
    }

    @Override
    public Copartner upgradePartner(Copartner copartner) {
        //1.根据id获取合伙人
        Copartner exist_partner = copartnerMapper.selectByPrimaryKey(copartner.getId());
        if(exist_partner==null){
            return null;
        }
        //2.查询合伙人对应的角色
        CopartnerRole role = roleService.selectByPrimaryKey(copartner.getRoleId());

        //3.根据该角色的parentId获取升级的角色
        CopartnerRole parentRole = roleService.findByChildRoleId(role.getRoleId(),role.getPartnerId());

        //获取当下合伙人的推荐人数
        List<Copartner> childList = copartnerMapper.findByInviteId(exist_partner.getId());

        //3.判断该合伙人升级的条件十分符合升级的角色
        if(exist_partner.getMoney().compareTo(parentRole.getUpgradeCost())>-1 &&
                childList.size()>=parentRole.getUpgradeInvite()){ //符合购买费用及推荐人数
            //3.1符合升级 修改合伙人的角色id
            exist_partner.setRoleId(parentRole.getRoleId());
            copartnerMapper.updateByPrimaryKey(exist_partner);
            return exist_partner;
        }else{
            //3.2不符合不升级
            return exist_partner;
        }

    }

}
