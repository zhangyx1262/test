package com.yonyou.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.po.Table2;

@MyBatisRepository("com.yonyou.dao.Table2Mapper")
public interface Table2Mapper extends BaseDAO<Table2,String> {

}
