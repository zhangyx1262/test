-- drop table table2 cascade constraints;
create table table2
(
ID VARCHAR2(64) not null,
        constraint PK_table2 primary key (ID),
        table2_no VARCHAR2(64) null,
        table1_no VARCHAR2(64) null,
        table2_name VARCHAR2(64) null,
        stute VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column table2.table2_no is '表编号2';
        comment on column table2.table1_no is '表编号1';
        comment on column table2.table2_name is '属性名';
        comment on column table2.stute is '状态';
comment on column table2.DR is '是否删除';
comment on column table2.TS is '时间戳';
comment on column table2.LAST_MODIFIED is '修改时间';
comment on column table2.LAST_MODIFY_USER is '修改人';
comment on column table2.CREATE_TIME is '创建时间';
comment on column table2.CREATE_USER is '创建人';



ALTER TABLE table2 ADD CONSTRAINT C_table2_Utable2_no
UNIQUE (table2_no)
ENABLE;
ALTER TABLE table2 ADD CONSTRAINT C_table2_Utable1_no
UNIQUE (table1_no)
ENABLE;



