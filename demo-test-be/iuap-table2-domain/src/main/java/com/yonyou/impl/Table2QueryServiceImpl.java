package com.yonyou.impl;

import com.yonyou.api.Table2QueryService;
import com.yonyou.dto.Table2DTO;
import com.yonyou.po.Table2;
import com.yonyou.service.Table2Service;
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
 * @date 2019-9-7 23:18:48
 */
@Service("com.yonyou.impl.Table2QueryServiceImpl")
public class Table2QueryServiceImpl implements Table2QueryService {

    private Table2Service table2Service;

    @Autowired
    public void setTable2Service(Table2Service table2Service) {
        this.table2Service = table2Service;
    }


    @Override
    public List<Table2DTO> listTable2(SearchParams searchParams) {
        List<Table2>  list = table2Service.queryList(searchParams);
        List<Table2DTO> result = new ArrayList<>();
        if (list!=null){
            for (Table2 model:list){
                Table2DTO dto = new Table2DTO();
                BeanUtils.copyProperties(model,dto);
                result.add(dto);
            }
        }
        return result;
    }


}
