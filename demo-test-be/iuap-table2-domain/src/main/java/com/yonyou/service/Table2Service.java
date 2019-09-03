package com.yonyou.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yonyou.iuap.baseservice.intg.support.ServiceFeature;
import static com.yonyou.iuap.baseservice.intg.support.ServiceFeature.*;

import com.yonyou.iuap.baseservice.service.GenericAssoService;
import com.yonyou.dao.Table2Mapper;
import com.yonyou.po.Table2;

/**
 * 基础CRUD及主子表联合操作服务
 */
@Service("com.yonyou.service.Table2Service")
public class Table2Service extends GenericAssoService<Table2,String>{

    private Table2Mapper table2Mapper;

    @Autowired
    public void setTable2Mapper(Table2Mapper table2Mapper) {
        this.table2Mapper = table2Mapper;
        super.setGenericMapper(table2Mapper);
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