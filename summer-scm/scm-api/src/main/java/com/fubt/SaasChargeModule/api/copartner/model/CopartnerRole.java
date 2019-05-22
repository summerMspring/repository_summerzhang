package com.fubt.SaasChargeModule.api.copartner.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * copartner_role
 * @author 
 */
public class CopartnerRole implements Serializable {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 参与币种。多个币通过逗号分隔
     */
    private String participateCoin;

    /**
     * 返佣币种
     */
    private String backCoin;

    /**
     * 升级币种
     */
    private Long upgradeCoinId;

    /**
     * 升级费用
     */
    private BigDecimal upgradeCost;

    /**
     * 推荐升级
     */
    private Integer upgradeInvite;

    /**
     * 赠送月数
     */
    private Integer giveNonth;

    /**
     * 有效月数
     */
    private Integer validNonth;

    /**
     * 分红比例
     */
    private BigDecimal shareRate;

    /**
     * 是否删除:1删除，0未删除
     */
    private Integer deleteStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 处理时间
     */
    private Date handleTime;

    /**
     * 处理人id
     */
    private Long handleId;

    /**
     * 处理人名称
     */
    private String handleName;

    /**
     * 商户ID
     */
    private Long partnerId;

    private Long childRoleid;

    private Long parentRoleid;

    private static final long serialVersionUID = 1L;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getParticipateCoin() {
        return participateCoin;
    }

    public void setParticipateCoin(String participateCoin) {
        this.participateCoin = participateCoin;
    }

    public String getBackCoin() {
        return backCoin;
    }

    public void setBackCoin(String backCoin) {
        this.backCoin = backCoin;
    }

    public Long getUpgradeCoinId() {
        return upgradeCoinId;
    }

    public void setUpgradeCoinId(Long upgradeCoinId) {
        this.upgradeCoinId = upgradeCoinId;
    }

    public BigDecimal getUpgradeCost() {
        return upgradeCost;
    }

    public void setUpgradeCost(BigDecimal upgradeCost) {
        this.upgradeCost = upgradeCost;
    }

    public Integer getUpgradeInvite() {
        return upgradeInvite;
    }

    public void setUpgradeInvite(Integer upgradeInvite) {
        this.upgradeInvite = upgradeInvite;
    }

    public Integer getGiveNonth() {
        return giveNonth;
    }

    public void setGiveNonth(Integer giveNonth) {
        this.giveNonth = giveNonth;
    }

    public Integer getValidNonth() {
        return validNonth;
    }

    public void setValidNonth(Integer validNonth) {
        this.validNonth = validNonth;
    }

    public BigDecimal getShareRate() {
        return shareRate;
    }

    public void setShareRate(BigDecimal shareRate) {
        this.shareRate = shareRate;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Long getHandleId() {
        return handleId;
    }

    public void setHandleId(Long handleId) {
        this.handleId = handleId;
    }

    public String getHandleName() {
        return handleName;
    }

    public void setHandleName(String handleName) {
        this.handleName = handleName;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Long getChildRoleid() {
        return childRoleid;
    }

    public void setChildRoleid(Long childRoleid) {
        this.childRoleid = childRoleid;
    }

    public Long getParentRoleid() {
        return parentRoleid;
    }

    public void setParentRoleid(Long parentRoleid) {
        this.parentRoleid = parentRoleid;
    }
}