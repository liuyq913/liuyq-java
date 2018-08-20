package com.liuyq.proxy;

import java.math.BigDecimal;

/**
 * Created by liuyq on 2018/7/10.
 */
public class HhdRemittanceVo {
    private static final long serialVersionUID = 2321951139870203079L;
    private BigDecimal repaymentAmount;
    private Long borrowId ;//标的id
    private Integer period ;//标的期数
    private BigDecimal hhdRemittance;//很好贷打款金额
    private Long hhdRemitteanceDate; //很好贷打款时间
    private Long hhdRemitteanceUserID; //很好贷打款人id
    private String hhdRemitteanceUserName ;//很好贷打款人名
    private String storeName;//门店名称
    private Integer status ;// 1 成功 0 失败

    public BigDecimal getRepaymentAmount() {
        return repaymentAmount;
    }

    public void setRepaymentAmount(BigDecimal repaymentAmount) {
        this.repaymentAmount = repaymentAmount;
    }


    public HhdRemittanceVo(){}

    public Long getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Long borrowId) {
        this.borrowId = borrowId;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public BigDecimal getHhdRemittance() {
        return hhdRemittance;
    }

    public void setHhdRemittance(BigDecimal hhdRemittance) {
        this.hhdRemittance = hhdRemittance;
    }

    public Long getHhdRemitteanceDate() {
        return hhdRemitteanceDate;
    }

    public void setHhdRemitteanceDate(Long hhdRemitteanceDate) {
        this.hhdRemitteanceDate = hhdRemitteanceDate;
    }

    public Long getHhdRemitteanceUserID() {
        return hhdRemitteanceUserID;
    }

    public void setHhdRemitteanceUserID(Long hhdRemitteanceUserID) {
        this.hhdRemitteanceUserID = hhdRemitteanceUserID;
    }

    public String getHhdRemitteanceUserName() {
        return hhdRemitteanceUserName;
    }

    public void setHhdRemitteanceUserName(String hhdRemitteanceUserName) {
        this.hhdRemitteanceUserName = hhdRemitteanceUserName;
    }

    public String getStoreName() {
        return storeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
