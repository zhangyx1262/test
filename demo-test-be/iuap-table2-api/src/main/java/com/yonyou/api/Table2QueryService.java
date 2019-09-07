package com.yonyou.api;
import com.yonyou.dto.Table2DTO;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.cloud.middleware.rpc.RemoteCall;

import java.util.List;

/**
 * RPC 调用接口声明
 * @author  
 * @date 2019-9-7 23:16:03
 */
@RemoteCall("iuap-demo-test-server")
public interface Table2QueryService {

    /**
     * 查询表2列表
     */
    List<Table2DTO> listTable2(SearchParams searchParams);

}
