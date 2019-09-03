

CREATE TABLE [table2] (

[ID] varchar(64)   NOT NULL ,
[TS] varchar(64)   NULL ,
[CREATE_TIME] varchar(64)   NULL ,
[CREATE_USER] varchar(64)   NULL ,
[LAST_MODIFIED] varchar(64)   NULL ,
[LAST_MODIFY_USER] varchar(64)   NULL ,

[table2_no] VARCHAR(64)   NULL ,
[table1_no] VARCHAR(64)   NULL ,
[table2_name] VARCHAR(64)   NULL ,
   PRIMARY KEY ([ID])
)
ON [PRIMARY]
GO

EXEC sp_addextendedproperty 'MS_Description',N'表编号2','user','dbo','TABLE','table2','COLUMN','table2_no'
GO
EXEC sp_addextendedproperty 'MS_Description',N'表编号1','user','dbo','TABLE','table2','COLUMN','table1_no'
GO
EXEC sp_addextendedproperty 'MS_Description',N'属性名','user','dbo','TABLE','table2','COLUMN','table2_name'
GO


EXEC sp_addextendedproperty 'MS_Description',N'主键 ID','user','dbo','TABLE','table2','COLUMN','ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'乐观锁时间戳','user','dbo','TABLE','table2','COLUMN','TS'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改时间','user','dbo','TABLE','table2','COLUMN','LAST_MODIFIED'
GO
EXEC sp_addextendedproperty 'MS_Description',N'修改人','user','dbo','TABLE','table2','COLUMN','LAST_MODIFY_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建时间','user','dbo','TABLE','table2','COLUMN','CREATE_TIME'
GO
EXEC sp_addextendedproperty 'MS_Description',N'创建人','user','dbo','TABLE','table2','COLUMN','CREATE_USER'
GO
EXEC sp_addextendedproperty 'MS_Description',N'租户标识','user','dbo','TABLE','table2','COLUMN','TENANT_ID'
GO
EXEC sp_addextendedproperty 'MS_Description',N'是否删除','user','dbo','TABLE','table2','COLUMN','DR'
GO

ALTER TABLE [dbo].[table2] ADD CONSTRAINT [UNIQ_TABLE2_NO] UNIQUE ([table2_no])
GO
ALTER TABLE [dbo].[table2] ADD CONSTRAINT [UNIQ_TABLE1_NO] UNIQUE ([table1_no])
GO


 


--------------------------------------------------------

