package com.yonyou.constant;

import com.yonyou.iuap.ucf.common.enums.I18nEnum;
import java.io.Serializable;


/**
 * 表2枚举定义,约定为po的fieldName_key为匹配原则
 * @since v5.0.0
 * @date 2019-9-7 23:02:13
 */
public class Table2Constant   {
                public enum StuteEnum implements I18nEnum {
                
    STUTE_0("0","待申请","iuap.enum.stute0"),
    STUTE_1("1","已申请","iuap.enum.stute1");

        private String code;
        private String defaultText;
        private String i18nTextCode;

        StuteEnum(String code,String defaultText,String i18nTextCode){
            this.code=code;
            this.defaultText=defaultText;
            this.i18nTextCode=i18nTextCode;
        }
        @Override
        public String getI18nTextCode() {
            return i18nTextCode;
        }

        @Override
        public String getI18nDefaultText() {
            return defaultText;
        }

        @Override
        public Serializable code() {
            return code;
        }

        }
    ;

}
