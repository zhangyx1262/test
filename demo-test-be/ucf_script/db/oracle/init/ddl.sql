-- drop table table1 cascade constraints;
create table table1
(
ID VARCHAR2(64) not null,
        constraint PK_table1 primary key (ID),
        table1_no VARCHAR2(64) null,
        table1_name VARCHAR2(64) null,
        TENANT_ID VARCHAR2(64) NULL,
        DR NUMBER(11) NULL,
        TS VARCHAR2(64) NULL,
        LAST_MODIFIED VARCHAR2(64) NULL,
        LAST_MODIFY_USER VARCHAR2(64) NULL,
        CREATE_TIME VARCHAR2(64) NULL,
        CREATE_USER VARCHAR2(64) NULL
);
        comment on column table1.table1_no is '表编号';
        comment on column table1.table1_name is '属性名称';
comment on column table1.DR is '是否删除';
comment on column table1.TS is '时间戳';
comment on column table1.LAST_MODIFIED is '修改时间';
comment on column table1.LAST_MODIFY_USER is '修改人';
comment on column table1.CREATE_TIME is '创建时间';
comment on column table1.CREATE_USER is '创建人';



ALTER TABLE table1 ADD CONSTRAINT C_table1_Utable1_no
UNIQUE (table1_no)
ENABLE;



