package com.liuyq.easyExcel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductProcedureWorkshop implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_procedure_workshop.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_procedure_workshop.productId
     *
     * @mbg.generated
     */
    private Integer productId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_procedure_workshop.productNo
     *
     * @mbg.generated
     */
    private String productNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_procedure_workshop.sort
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_procedure_workshop.workshop
     *
     * @mbg.generated
     */
    private String workshop;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_procedure_workshop.procedureId
     *
     * @mbg.generated
     */
    private Integer procedureId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_procedure_workshop.procedureName
     *
     * @mbg.generated
     */
    private String procedureName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_procedure_workshop.price
     *
     * @mbg.generated
     */
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_procedure_workshop.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_procedure_workshop.operator
     *
     * @mbg.generated
     */
    private String operator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_procedure_workshop.createTime
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_procedure_workshop.lastModifyTime
     *
     * @mbg.generated
     */
    private Date lastModifyTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_product_procedure_workshop.isDelete
     *
     * @mbg.generated
     */
    private Integer isDelete;


    private Boolean isInspect;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_product_procedure_workshop
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_procedure_workshop.id
     *
     * @return the value of t_product_procedure_workshop.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_procedure_workshop.id
     *
     * @param id the value for t_product_procedure_workshop.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_procedure_workshop.productId
     *
     * @return the value of t_product_procedure_workshop.productId
     *
     * @mbg.generated
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_procedure_workshop.productId
     *
     * @param productId the value for t_product_procedure_workshop.productId
     *
     * @mbg.generated
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_procedure_workshop.productNo
     *
     * @return the value of t_product_procedure_workshop.productNo
     *
     * @mbg.generated
     */
    public String getProductNo() {
        return productNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_procedure_workshop.productNo
     *
     * @param productNo the value for t_product_procedure_workshop.productNo
     *
     * @mbg.generated
     */
    public void setProductNo(String productNo) {
        this.productNo = productNo == null ? null : productNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_procedure_workshop.sort
     *
     * @return the value of t_product_procedure_workshop.sort
     *
     * @mbg.generated
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_procedure_workshop.sort
     *
     * @param sort the value for t_product_procedure_workshop.sort
     *
     * @mbg.generated
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_procedure_workshop.workshop
     *
     * @return the value of t_product_procedure_workshop.workshop
     *
     * @mbg.generated
     */
    public String getWorkshop() {
        return workshop;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_procedure_workshop.workshop
     *
     * @param workshop the value for t_product_procedure_workshop.workshop
     *
     * @mbg.generated
     */
    public void setWorkshop(String workshop) {
        this.workshop = workshop == null ? null : workshop.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_procedure_workshop.procedureId
     *
     * @return the value of t_product_procedure_workshop.procedureId
     *
     * @mbg.generated
     */
    public Integer getProcedureId() {
        return procedureId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_procedure_workshop.procedureId
     *
     * @param procedureId the value for t_product_procedure_workshop.procedureId
     *
     * @mbg.generated
     */
    public void setProcedureId(Integer procedureId) {
        this.procedureId = procedureId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_procedure_workshop.procedureName
     *
     * @return the value of t_product_procedure_workshop.procedureName
     *
     * @mbg.generated
     */
    public String getProcedureName() {
        return procedureName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_procedure_workshop.procedureName
     *
     * @param procedureName the value for t_product_procedure_workshop.procedureName
     *
     * @mbg.generated
     */
    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName == null ? null : procedureName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_procedure_workshop.price
     *
     * @return the value of t_product_procedure_workshop.price
     *
     * @mbg.generated
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_procedure_workshop.price
     *
     * @param price the value for t_product_procedure_workshop.price
     *
     * @mbg.generated
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_procedure_workshop.remark
     *
     * @return the value of t_product_procedure_workshop.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_procedure_workshop.remark
     *
     * @param remark the value for t_product_procedure_workshop.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_procedure_workshop.operator
     *
     * @return the value of t_product_procedure_workshop.operator
     *
     * @mbg.generated
     */
    public String getOperator() {
        return operator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_procedure_workshop.operator
     *
     * @param operator the value for t_product_procedure_workshop.operator
     *
     * @mbg.generated
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_procedure_workshop.createTime
     *
     * @return the value of t_product_procedure_workshop.createTime
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_procedure_workshop.createTime
     *
     * @param createTime the value for t_product_procedure_workshop.createTime
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_procedure_workshop.lastModifyTime
     *
     * @return the value of t_product_procedure_workshop.lastModifyTime
     *
     * @mbg.generated
     */
    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_procedure_workshop.lastModifyTime
     *
     * @param lastModifyTime the value for t_product_procedure_workshop.lastModifyTime
     *
     * @mbg.generated
     */
    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_product_procedure_workshop.isDelete
     *
     * @return the value of t_product_procedure_workshop.isDelete
     *
     * @mbg.generated
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_product_procedure_workshop.isDelete
     *
     * @param isDelete the value for t_product_procedure_workshop.isDelete
     *
     * @mbg.generated
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Boolean getIsInspect() {
        return isInspect;
    }

    public void setIsInspect(Boolean inspect) {
        isInspect = inspect;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product_procedure_workshop
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ProductProcedureWorkshop other = (ProductProcedureWorkshop) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductId() == null ? other.getProductId() == null : this.getProductId().equals(other.getProductId()))
            && (this.getProductNo() == null ? other.getProductNo() == null : this.getProductNo().equals(other.getProductNo()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getWorkshop() == null ? other.getWorkshop() == null : this.getWorkshop().equals(other.getWorkshop()))
            && (this.getProcedureId() == null ? other.getProcedureId() == null : this.getProcedureId().equals(other.getProcedureId()))
            && (this.getProcedureName() == null ? other.getProcedureName() == null : this.getProcedureName().equals(other.getProcedureName()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastModifyTime() == null ? other.getLastModifyTime() == null : this.getLastModifyTime().equals(other.getLastModifyTime()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_product_procedure_workshop
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductId() == null) ? 0 : getProductId().hashCode());
        result = prime * result + ((getProductNo() == null) ? 0 : getProductNo().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getWorkshop() == null) ? 0 : getWorkshop().hashCode());
        result = prime * result + ((getProcedureId() == null) ? 0 : getProcedureId().hashCode());
        result = prime * result + ((getProcedureName() == null) ? 0 : getProcedureName().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastModifyTime() == null) ? 0 : getLastModifyTime().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }
}