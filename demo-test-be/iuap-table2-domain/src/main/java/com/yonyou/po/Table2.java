package com.yonyou.po;
import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yonyou.constant.Table2Constant;
import com.yonyou.iuap.baseservice.entity.AuditTrail;
import com.yonyou.iuap.baseservice.entity.annotation.*;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.ucf.dao.BasePO;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;
/**
 * 表2
 * @since v5.0.0
 * @date 2019-9-7 23:16:02
 */

@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "table2")
@Associative(fkName = "table2_no")
public class Table2 extends BasePO implements AuditTrail{

    @Column(name="create_time")
    private String createTime;

    @Column(name="create_user")
    @Condition
    private String createUser;

    @Column(name="last_modified")
    private String lastModified;

    @Column(name="last_modify_user")
    @Condition
    private String lastModifyUser;

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

    @Condition(match=Match.EQ)
    @Column(name="table2_no")
    private String table2_no;        //表编号2

    public void setTable2_no(String table2_no){
        this.table2_no = table2_no;
    }
    public String getTable2_no(){
        return this.table2_no;
    }


    @Condition(match=Match.EQ)
    @Column(name="table1_no")
    private String table1_no;        //表编号1

    public void setTable1_no(String table1_no){
        this.table1_no = table1_no;
    }
    public String getTable1_no(){
        return this.table1_no;
    }


    @Condition(match=Match.LIKE)
    @Column(name="table2_name")
    private String table2_name;        //属性名

    public void setTable2_name(String table2_name){
        this.table2_name = table2_name;
    }
    public String getTable2_name(){
        return this.table2_name;
    }


    @Condition
    @Column(name="stute")
    @I18nEnumCode(clazz = Table2Constant.StuteEnum.class,target ="stuteEnumValue" )
    private String stute;        //状态

    public void setStute(String stute){
        this.stute = stute;
    }
    public String getStute(){
        return this.stute;
    }

    @Transient
    private String stuteEnumValue;   //状态

    public void setStuteEnumValue(String stuteEnumValue){
        this.stuteEnumValue = stuteEnumValue;
    }
    public String getStuteEnumValue(){
        return this.stuteEnumValue;
    }

}



