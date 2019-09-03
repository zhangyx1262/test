package com.yonyou.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.dao.Table1Mapper;
import com.yonyou.po.Table1;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.service.Table1Service")
public class Table1Service extends GenericAssoService<Table1,String>{

    private Table1Mapper table1Mapper;

    @Autowired
    public void setTable1Mapper(Table1Mapper table1Mapper) {
        this.table1Mapper = table1Mapper;
        super.setGenericMapper(table1Mapper);
    }



    /**
     * 可插拔设计
     * @return 向父类 提供可插拔的特性声明
     */
    @Override
    protected ServiceFeature[] getFeats() {
        return new ServiceFeature[]{ AUDIT,I18N_ENUM };
    }
}