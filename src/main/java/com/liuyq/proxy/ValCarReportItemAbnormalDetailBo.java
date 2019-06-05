package com.liuyq.proxy;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by liuyq on 2019/1/18.
 */
public class ValCarReportItemAbnormalDetailBo implements Serializable{

    private static final long serialVersionUID = 1647084991069056676L;
    private Integer ID;
    private Integer reportResultDetailID; //验车报告结果检测明细表id
    private Integer resultID; // 验车报告结果id
    private Integer reportItemDetailID;
    private String carPartName;
    private Integer reportItemID;
    private String reportItemName;
    private Boolean isAbnormal;
    private Boolean isDelete;
    private Date createTime;
    private Integer reportItemDetailAbnormalID; //异常配置项id
    private String reportItemDetailAbnormalName;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getReportResultDetailID() {
        return reportResultDetailID;
    }

    public void setReportResultDetailID(Integer reportResultDetailID) {
        this.reportResultDetailID = reportResultDetailID;
    }

    public Integer getResultID() {
        return resultID;
    }

    public void setResultID(Integer resultID) {
        this.resultID = resultID;
    }

    public Integer getReportItemDetailID() {
        return reportItemDetailID;
    }

    public void setReportItemDetailID(Integer reportItemDetailID) {
        this.reportItemDetailID = reportItemDetailID;
    }

    public String getCarPartName() {
        return carPartName;
    }

    public void setCarPartName(String carPartName) {
        this.carPartName = carPartName;
    }

    public Integer getReportItemID() {
        return reportItemID;
    }

    public void setReportItemID(Integer reportItemID) {
        this.reportItemID = reportItemID;
    }

    public String getReportItemName() {
        return reportItemName;
    }

    public void setReportItemName(String reportItemName) {
        this.reportItemName = reportItemName;
    }

    public Boolean getAbnormal() {
        return isAbnormal;
    }

    public void setAbnormal(Boolean abnormal) {
        isAbnormal = abnormal;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getReportItemDetailAbnormalID() {
        return reportItemDetailAbnormalID;
    }

    public void setReportItemDetailAbnormalID(Integer reportItemDetailAbnormalID) {
        this.reportItemDetailAbnormalID = reportItemDetailAbnormalID;
    }

    public String getReportItemDetailAbnormalName() {
        return reportItemDetailAbnormalName;
    }

    public void setReportItemDetailAbnormalName(String reportItemDetailAbnormalName) {
        this.reportItemDetailAbnormalName = reportItemDetailAbnormalName;
    }
}
