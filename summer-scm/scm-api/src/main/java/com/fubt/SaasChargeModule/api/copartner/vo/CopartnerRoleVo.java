package com.fubt.SaasChargeModule.api.copartner.vo;

import com.fubt.internals.BaseEntity;
import lombok.Data;

@Data
public class CopartnerRoleVo extends BaseEntity {

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 商户ID
     */
    private Long partnerId;

    /**
     * 子角色id
     */
    private Long childRoleid;

    /**
     * 推荐升级人数
     */
    private Integer upgradeInvite;

}
