package com.fubt.SaasChargeModule.provider.copartner.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fubt.SaasChargeModule.api.copartner.model.CopartnerRole;
import com.fubt.SaasChargeModule.api.copartner.service.CopartnerRoleService;
import com.fubt.SaasChargeModule.api.copartner.vo.CopartnerRoleVo;
import com.fubt.SaasChargeModule.provider.copartner.mapper.CopartnerRoleMapper;
import com.fubt.internals.BaseMapper;
import com.fubt.internals.BaseServiceImpl;
import com.fubt.worker.api.service.IdWorkerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CopartnerRoleServiceImpl extends BaseServiceImpl<CopartnerRole,Long> implements CopartnerRoleService {

    @Autowired
    private CopartnerRoleMapper roleMapper;

    @Reference
    private IdWorkerService idWorkerService;


    @Override
    public CopartnerRole findById(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public CopartnerRole findByChildRoleId(Long childRoleId, Long partnerId) {
        return roleMapper.findByChildRoleId(childRoleId,partnerId);
    }

    @Override
    public List<CopartnerRoleVo> findList(Long partnerId) {
        List<CopartnerRole> result = roleMapper.findList(partnerId);

        List<CopartnerRoleVo> list = new ArrayList<>();
        for (CopartnerRole copartnerRole : result) {
            CopartnerRoleVo copartnerRoleVo = new CopartnerRoleVo();
            BeanUtils.copyProperties(copartnerRole, copartnerRoleVo);
            list.add(copartnerRoleVo);
        }
        return list;
    }

    @Override
    public PageInfo<CopartnerRoleVo> pageList(Integer pageNum, Integer pageSize, Long partnerId) {
        if (pageNum == null || pageNum == 0) {
            pageNum = 1;
        }
        if (pageSize == null || pageNum == 0) {
            pageNum = 10;
        }

        PageHelper.startPage(pageNum,pageSize);
        List<CopartnerRole> result = roleMapper.findList(partnerId);
        PageInfo pageInfo = new PageInfo(result);
        List<CopartnerRole> list = pageInfo.getList();
        List<CopartnerRoleVo> roleVoList = new ArrayList<>();
        for (CopartnerRole copartnerRole : list) {

            CopartnerRoleVo copartnerRoleVo = new CopartnerRoleVo();
            BeanUtils.copyProperties(copartnerRole,copartnerRoleVo);
            roleVoList.add(copartnerRoleVo);
        }
        pageInfo.setList(roleVoList);

        return pageInfo;
    }

    @Override
    public void save(CopartnerRole copartnerRole) {
        //1.角色id随机生成
        Long id = idWorkerService.generatorId();

        System.out.println(id+"aaaaaaaaaaaaaaaa");
    }

    @Override
    protected BaseMapper<CopartnerRole, Long> getMapper() {
        return roleMapper;
    }




}
