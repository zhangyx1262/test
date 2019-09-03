package com.yonyou.api;
import com.yonyou.dto.Table1DTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-3 22:00:52
 */
@RemoteCall("iuap-demo-test-server")
public interface Table1QueryService {

    /**
     * 查询表1列表
     */
    List<Table1DTO> listTable1(SearchParams searchParams);

}
