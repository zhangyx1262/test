
-- drop table if EXISTS table2;
CREATE TABLE `table2` (
`ID` VARCHAR(64) NOT NULL COMMENT '主键',
    PRIMARY KEY (`ID`),
    `table2_no` VARCHAR(64) DEFAULT NULL COMMENT '表编号2',
    `table1_no` VARCHAR(64) DEFAULT NULL COMMENT '表编号1',
    `table2_name` VARCHAR(64) DEFAULT NULL COMMENT '属性名',
    `stute` VARCHAR(64) DEFAULT NULL COMMENT '状态',
        `TENANT_ID` varchar(64) DEFAULT NULL,
        `DR` int(11) DEFAULT NULL COMMENT '是否删除',
        `TS` varchar(64) DEFAULT NULL COMMENT '时间戳',
        `LAST_MODIFIED` varchar(64) DEFAULT NULL COMMENT '修改时间',
        `LAST_MODIFY_USER` varchar(64) DEFAULT NULL COMMENT '修改人',
        `CREATE_TIME` varchar(64) DEFAULT NULL COMMENT '创建时间',
        `CREATE_USER` varchar(64) DEFAULT NULL COMMENT '创建人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

alter table table2 add unique(table2_no);
alter table table2 add unique(table1_no);



