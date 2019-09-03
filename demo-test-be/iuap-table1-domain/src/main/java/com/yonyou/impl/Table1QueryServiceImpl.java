package com.yonyou.impl;

import com.yonyou.api.Table1QueryService;
import com.yonyou.dto.Table1DTO;
import com.yonyou.po.Table1;
import com.yonyou.service.Table1Service;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.iuap.ucf.dao.support.SqlParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RPC provider端
 * @author  
 * @date 2019-9-3 22:00:52
 */
@Service("com.yonyou.impl.Table1QueryServiceImpl")
public class Table1QueryServiceImpl implements Table1QueryService {

    private Table1Service table1Service;

    @Autowired
    public void setTable1Service(Table1Service table1Service) {
        this.table1Service = table1Service;
    }


    @Override
    public List<Table1DTO> listTable1(SearchParams searchParams) {
        List<Table1>  list = table1Service.queryList(searchParams);
        List<Table1DTO> result = new ArrayList<>();
        if (list!=null){
            for (Table1 model:list){
                Table1DTO dto = new Table1DTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
