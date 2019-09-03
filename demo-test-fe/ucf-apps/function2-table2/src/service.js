import request from "utils/request";


//定义接口地址
const URL = {
    "GET_table2": `${GROBAL_HTTP_CTX}` + '/function2/table2/list', // 获取主表
    "SAVE_table2": `${GROBAL_HTTP_CTX}` + '/function2/table2/insertSelective', // 保存主表
    "UPDATE_table2": `${GROBAL_HTTP_CTX}` + '/function2/table2/updateSelective', // 更新主表
    "DEL_table2": `${GROBAL_HTTP_CTX}` + '/function2/table2/deleteBatch', // 删除主表
    "GET_QUERYPRINTTEMPLATEALLOCATE": `/eiap-plus/appResAllocate/queryPrintTemplateAllocate`,  // 查询打印模板
    "PRINTSERVER": '/print_service/print/preview',                                              // 打印
}

/**
 * 获取主列表
 * @param {*} params
 */
export const gettable2 = (param) => {
    return request(URL.GET_table2, {
        method: "get",
        param
    });
}
/**
 * 保存主表数据
 * @param {*} params
 */
export const savetable2 = (params) => {
    return request(URL.SAVE_table2, {
        method: "post",
        data: params
    });
}
/**
 * 更新主表数据
 * @param {*} params
 */
export const updatetable2 = (params) => {
    return request(URL.UPDATE_table2, {
        method: "post",
        data: params
    });
}
/**
 * 删除主表数据
 * @param {*} params
 */
export const deltable2 = (params) => {
    return request(URL.DEL_table2, {
        method: "post",
        data: params
    });
}


/**
 *
 * 查询打印模板
 * @param {*} params
 * @returns
 */
export const queryPrintTemplateAllocate = (params) => {
    return request(URL.GET_QUERYPRINTTEMPLATEALLOCATE, {
        method: "get",
        param: params
    });
}

export const printDocument = (params) => {
    let search = [];
    for (let key in params) {
        search.push(`${key}=${params[key]}`)
    }
    let exportUrl = `${URL.PRINTSERVER}?${search.join('&')}`;
    
    window.open(exportUrl);
}
