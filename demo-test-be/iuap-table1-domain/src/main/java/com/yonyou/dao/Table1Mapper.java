package com.yonyou.dao;
import com.yonyou.iuap.persistence.mybatis.anotation.MyBatisRepository;
import com.yonyou.iuap.ucf.dao.BaseDAO;

import com.yonyou.po.Table1;

@MyBatisRepository("com.yonyou.dao.Table1Mapper")
public interface Table1Mapper extends BaseDAO<Table1,String> {

}
