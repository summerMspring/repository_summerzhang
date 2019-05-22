package com.fubt.SaasChargeModule.api.copartner.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fubt.internals.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * copartner
 * @author 
 */
public class Copartner extends BaseEntity {
    private Long id;

    /**
     * 用户UID
     */
    private Long showId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 推荐人ID
     */
    private Long inviteId;

    /**
     * 推荐人UID
     */
    private Long inviteShowId;

    /**
     * 商户ID
     */
    private Long partnerId;

    /**
     * 交易额
     */
    private BigDecimal money;

    /**
     * 下级手续费
     */
    private BigDecimal fee;

    /**
     * 返佣金额
     */
    private BigDecimal commission;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 开始时间
     */


    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 赠送月数
     */
    private Integer giveNonth;

    /**
     * 有效月数
     */
    private Integer validNonth;

    /**
     * 是否过期;0过期，1未过期
            
     */
    private Integer validStatus;

    /**
     * 是否删除:1删除，0未删除
     */
    private Integer deleteStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getInviteId() {
        return inviteId;
    }

    public void setInviteId(Long inviteId) {
        this.inviteId = inviteId;
    }

    public Long getInviteShowId() {
        return inviteShowId;
    }

    public void setInviteShowId(Long inviteShowId) {
        this.inviteShowId = inviteShowId;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getStartTime() {
        return startTime;
    }

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public Integer getValidStatus() {
        return validStatus;
    }

    public void setValidStatus(Integer validStatus) {
        this.validStatus = validStatus;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}