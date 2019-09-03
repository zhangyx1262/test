package com.yonyou.dto;

import cn.hutool.core.util.ReflectUtil;
import com.yonyou.iuap.baseservice.support.condition.Condition;
import com.yonyou.iuap.baseservice.support.condition.Match;
import com.yonyou.iuap.ucf.common.entity.Identifier;
import com.yonyou.iuap.ucf.common.rest.SearchParams;
import com.yonyou.iuap.ucf.core.utils.EntityUtil;
import com.yonyou.iuap.ucf.dao.support.SqlParam;
import com.yonyou.iuap.ucf.dao.utils.FieldUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

 /**
  * 用于构造查询条件
  * @since v5.0.0
  * @date 2019-9-3 22:00:52
  */
public class SimpleSearchDTO {
    private static Logger logger = LoggerFactory.getLogger(SimpleSearchDTO.class);
    private static String PARAM_SEARCH_PREFIX = "search_";
        private String search_table1_no;     //表编号

        public void setSearch_table1_no(String table1_no){
            this.search_table1_no = table1_no;
        }
        public String getSearch_table1_no(){
            return this.search_table1_no;
        }

        private String search_table1_name;     //属性名称

        public void setSearch_table1_name(String table1_name){
            this.search_table1_name = table1_name;
        }
        public String getSearch_table1_name(){
            return this.search_table1_name;
        }


        private String search_table1_no;     //外键

        public void setSearch_table1_no(String fk){
            this.search_table1_no = fk;
        }
        public String getSearch_table1_no(){
            return this.search_table1_no;
        }

    private Set<String> likeFields = new HashSet<>(); // 使用like的field名
    private Set<String> inFields = new HashSet<>();  //使用in的field名
    private LinkedHashMap<String, String> sorts = new LinkedHashMap<>();

    public Set<String> getLikeFields() {
        return likeFields;
    }

    public void setLikeFields(Set<String> likeFields) {
        this.likeFields = likeFields;
    }

    public Set<String> getInFields() {
        return inFields;
    }

    public void setInFields(Set<String> inFields) {
        this.inFields = inFields;
    }

    public LinkedHashMap<String, String> getSorts() {
        return sorts;
    }

    public void setSorts(LinkedHashMap<String, String> sorts) {
        this.sorts = sorts;
    }


    public SearchParams toSearchParams(Class<? extends Identifier> entityClass) {

        String table=EntityUtil.getTableName(entityClass);
        SqlParam result = SqlParam.of().table(table);
        for (Field searchField : ReflectUtil.getFields(SimpleSearchDTO.class)) {
            if (ReflectUtil.getFieldValue(this, searchField) != null) {
                Field keyField;
                if (searchField.getName().toLowerCase().startsWith(PARAM_SEARCH_PREFIX)) {
                    keyField = ReflectUtil.getField(entityClass, searchField.getName().replace(PARAM_SEARCH_PREFIX, ""));
                } else {
                    keyField = ReflectUtil.getField(entityClass, searchField.getName());
                }
                if (keyField != null) {
                    Condition cond = keyField.getAnnotation(Condition.class);
                    String keyCol = FieldUtil.getColumnName(keyField);
                    if (cond == null || cond.match() == Match.EQ) {
                        result.eq(keyCol, ReflectUtil.getFieldValue(this, searchField));
                    } else if (cond.match() == Match.IN) {
                        try {
                            @SuppressWarnings("unchecked")
                            List<Object> ls = (List<Object>) ReflectUtil.getFieldValue(this, searchField);
                            result.in(keyCol, ls);
                        } catch (Exception e) {
                            logger.error("error happened while reading IN param from search params:" + keyField.getName(), e);
                        }
                    } else if (cond.match() == Match.LIKE) {
                        try {
                            result.like(keyCol,ReflectUtil.getFieldValue(this, searchField).toString());
                        } catch (Exception e) {
                            logger.error("error happened while reading Like param from search params:" + keyField.getName(), e);
                        }
                    } else if (cond.match() == Match.BETWEEN) {
                        try {
                            Object[] values = (Object[]) ReflectUtil.getFieldValue(this, searchField);
                            result.between(keyCol, values[0], values[1]);
                        } catch (Exception e) {
                            logger.error("error happened while reading BETWEEN param from search params:" + keyField.getName(), e);
                        }
                    } else {
                        result.and(keyCol + " " + cond.match()+ " "  + ReflectUtil.getFieldValue(this, searchField));
                    }

                }

            }

        }


        return result;
    }
}
