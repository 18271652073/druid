package com.nbdeli.demo.dom.blob.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * t_system_constant
 *
 * @author
 */
public class SystemConstant implements Serializable {
    private Integer id;

    private String constantType;

    private String typeName;

    private String constantKey;

    private String constantValue;

    private String status;

    private String addNo;

    private Date addTime;

    private String updateNo;

    private Date updateTime;

    private byte[] constantName;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConstantType() {
        return constantType;
    }

    public void setConstantType(String constantType) {
        this.constantType = constantType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getConstantKey() {
        return constantKey;
    }

    public void setConstantKey(String constantKey) {
        this.constantKey = constantKey;
    }

    public String getConstantValue() {
        return constantValue;
    }

    public void setConstantValue(String constantValue) {
        this.constantValue = constantValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddNo() {
        return addNo;
    }

    public void setAddNo(String addNo) {
        this.addNo = addNo;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getUpdateNo() {
        return updateNo;
    }

    public void setUpdateNo(String updateNo) {
        this.updateNo = updateNo;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public byte[] getConstantName() {
        return constantName;
    }

    public void setConstantName(byte[] constantName) {
        this.constantName = constantName;
    }

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
        SystemConstant other = (SystemConstant) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getConstantType() == null ? other.getConstantType() == null : this.getConstantType().equals(other.getConstantType()))
                && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
                && (this.getConstantKey() == null ? other.getConstantKey() == null : this.getConstantKey().equals(other.getConstantKey()))
                && (this.getConstantValue() == null ? other.getConstantValue() == null : this.getConstantValue().equals(other.getConstantValue()))
                && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
                && (this.getAddNo() == null ? other.getAddNo() == null : this.getAddNo().equals(other.getAddNo()))
                && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
                && (this.getUpdateNo() == null ? other.getUpdateNo() == null : this.getUpdateNo().equals(other.getUpdateNo()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (Arrays.equals(this.getConstantName(), other.getConstantName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getConstantType() == null) ? 0 : getConstantType().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getConstantKey() == null) ? 0 : getConstantKey().hashCode());
        result = prime * result + ((getConstantValue() == null) ? 0 : getConstantValue().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getAddNo() == null) ? 0 : getAddNo().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateNo() == null) ? 0 : getUpdateNo().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + (Arrays.hashCode(getConstantName()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", constantType=").append(constantType);
        sb.append(", typeName=").append(typeName);
        sb.append(", constantKey=").append(constantKey);
        sb.append(", constantValue=").append(constantValue);
        sb.append(", status=").append(status);
        sb.append(", addNo=").append(addNo);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateNo=").append(updateNo);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", constantName=").append(constantName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}