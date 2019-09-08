package com.yonyou.dto;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.iuap.baseservice.entity.AuditTrail;
import com.yonyou.iuap.baseservice.entity.annotation.*;
import com.yonyou.iuap.baseservice.support.condition.Condition;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 表2
 * @since v5.0.0
 * @date 2019-9-8 21:57:13
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Table2DTO  implements AuditTrail{

    private String id;
    private String tenantId;
    private Date ts;
    private Integer dr;
    private String createTime;
    private String createUser;
    private String lastModified;
    private String lastModifyUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }
    @Override
    public String getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getCreateUser() {
        return createUser;
    }

    @Override
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Override
    public String getLastModified() {
        return lastModified;
    }

    @Override
    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String getLastModifyUser() {
        return lastModifyUser;
    }

    @Override
    public void setLastModifyUser(String lastModifyUser) {
        this.lastModifyUser = lastModifyUser;
    }


    private String table2_no;        //表编号2

    public void setTable2_no(String table2_no){
        this.table2_no = table2_no;
    }
    public String getTable2_no(){
        return this.table2_no;
    }



    private String table1_no;        //表编号1

    public void setTable1_no(String table1_no){
        this.table1_no = table1_no;
    }
    public String getTable1_no(){
        return this.table1_no;
    }



    private String table2_name;        //属性名

    public void setTable2_name(String table2_name){
        this.table2_name = table2_name;
    }
    public String getTable2_name(){
        return this.table2_name;
    }



    private String stute;        //状态

    public void setStute(String stute){
        this.stute = stute;
    }
    public String getStute(){
        return this.stute;
    }

    private String stuteEnumValue;   //状态

    public void setStuteEnumValue(String stuteEnumValue){
        this.stuteEnumValue = stuteEnumValue;
    }
    public String getStuteEnumValue(){
        return this.stuteEnumValue;
    }

}



