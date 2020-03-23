/*
 Navicat Premium Data Transfer

 Source Server         : dbmay
 Source Server Type    : SQL Server
 Source Server Version : 11002100
 Source Host           : DESKTOP-G9KC5O3\SQLEXPRESS:1433
 Source Catalog        : Ewallet
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 11002100
 File Encoding         : 65001

 Date: 23/03/2020 15:33:13
*/


-- ----------------------------
-- Table structure for roles
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[roles]') AND type IN ('U'))
	DROP TABLE [dbo].[roles]
GO

CREATE TABLE [dbo].[roles] (
  [id] int  NOT NULL,
  [role] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[roles] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of roles
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[roles] VALUES (N'1', N'Admin'), (N'2', N'User')
GO

COMMIT
GO


-- ----------------------------
-- Table structure for setting
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[setting]') AND type IN ('U'))
	DROP TABLE [dbo].[setting]
GO

CREATE TABLE [dbo].[setting] (
  [deposit_lim] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [withdraw_lim] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [trans_lim] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[setting] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of setting
-- ----------------------------
BEGIN TRANSACTION
GO

COMMIT
GO


-- ----------------------------
-- Table structure for tuition
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[tuition]') AND type IN ('U'))
	DROP TABLE [dbo].[tuition]
GO

CREATE TABLE [dbo].[tuition] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [id_student] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [id_uni] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [name] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [tuition] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[tuition] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of tuition
-- ----------------------------
BEGIN TRANSACTION
GO

SET IDENTITY_INSERT [dbo].[tuition] ON
GO

INSERT INTO [dbo].[tuition] ([id], [id_student], [id_uni], [name], [tuition]) VALUES (N'1', N'CE140196', N'1', N'Nguyen Duc Tong', N'16500000'), (N'2', N'CE140037', N'1', N'Quan Duc Loc', N'16500000'), (N'3', N'CE140085', N'1', N'Tranh Minh Thang', N'16500000')
GO

SET IDENTITY_INSERT [dbo].[tuition] OFF
GO

COMMIT
GO


-- ----------------------------
-- Table structure for universities
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[universities]') AND type IN ('U'))
	DROP TABLE [dbo].[universities]
GO

CREATE TABLE [dbo].[universities] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [name] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[universities] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of universities
-- ----------------------------
BEGIN TRANSACTION
GO

SET IDENTITY_INSERT [dbo].[universities] ON
GO

INSERT INTO [dbo].[universities] ([id], [name]) VALUES (N'1', N'FPT University
'), (N'2', N'Can Tho University'), (N'3', N'Can Tho University of Medicine and Pharmacy'), (N'4', N'Tay Do University'), (N'5', N'Nam Can Tho University')
GO

SET IDENTITY_INSERT [dbo].[universities] OFF
GO

COMMIT
GO


-- ----------------------------
-- Table structure for user_deposit
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[user_deposit]') AND type IN ('U'))
	DROP TABLE [dbo].[user_deposit]
GO

CREATE TABLE [dbo].[user_deposit] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [user_id] int  NULL,
  [deposit_money] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [created_at] timestamp  NULL,
  [type] int  NULL,
  [description] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[user_deposit] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_deposit
-- ----------------------------
BEGIN TRANSACTION
GO

SET IDENTITY_INSERT [dbo].[user_deposit] ON
GO

SET IDENTITY_INSERT [dbo].[user_deposit] OFF
GO

COMMIT
GO


-- ----------------------------
-- Table structure for user_money
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[user_money]') AND type IN ('U'))
	DROP TABLE [dbo].[user_money]
GO

CREATE TABLE [dbo].[user_money] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [user_id] int  NULL,
  [total_money] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[user_money] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_money
-- ----------------------------
BEGIN TRANSACTION
GO

SET IDENTITY_INSERT [dbo].[user_money] ON
GO

INSERT INTO [dbo].[user_money] ([id], [user_id], [total_money]) VALUES (N'1', N'1', N'0')
GO

SET IDENTITY_INSERT [dbo].[user_money] OFF
GO

COMMIT
GO


-- ----------------------------
-- Table structure for user_role
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[user_role]') AND type IN ('U'))
	DROP TABLE [dbo].[user_role]
GO

CREATE TABLE [dbo].[user_role] (
  [user_id] int  NOT NULL,
  [role_id] int  NULL
)
GO

ALTER TABLE [dbo].[user_role] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[user_role] VALUES (N'1', N'2')
GO

COMMIT
GO


-- ----------------------------
-- Table structure for user_withdraw
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[user_withdraw]') AND type IN ('U'))
	DROP TABLE [dbo].[user_withdraw]
GO

CREATE TABLE [dbo].[user_withdraw] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [user_id] int  NULL,
  [withdraw_money] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [created_at] timestamp  NULL,
  [type] int  NULL,
  [description] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[user_withdraw] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_withdraw
-- ----------------------------
BEGIN TRANSACTION
GO

SET IDENTITY_INSERT [dbo].[user_withdraw] ON
GO

SET IDENTITY_INSERT [dbo].[user_withdraw] OFF
GO

COMMIT
GO


-- ----------------------------
-- Table structure for users
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[users]') AND type IN ('U'))
	DROP TABLE [dbo].[users]
GO

CREATE TABLE [dbo].[users] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [username] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [password] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [fullname] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [address] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [phone] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [mail] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [gender] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[users] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of users
-- ----------------------------
BEGIN TRANSACTION
GO

SET IDENTITY_INSERT [dbo].[users] ON
GO

INSERT INTO [dbo].[users] ([id], [username], [password], [fullname], [address], [phone], [mail], [gender]) VALUES (N'1', N'ductong', N'202cb962ac59075b964b07152d234b70', N'Nguyen Duc Tong', N'null', N'0787816931', NULL, N'1')
GO

SET IDENTITY_INSERT [dbo].[users] OFF
GO

COMMIT
GO


-- ----------------------------
-- Primary Key structure for table roles
-- ----------------------------
ALTER TABLE [dbo].[roles] ADD CONSTRAINT [PK__roles__3213E83FEB67F782] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for tuition
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[tuition]', RESEED, 3)
GO


-- ----------------------------
-- Primary Key structure for table tuition
-- ----------------------------
ALTER TABLE [dbo].[tuition] ADD CONSTRAINT [PK__tuition__3213E83F5DA22183] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for universities
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[universities]', RESEED, 5)
GO


-- ----------------------------
-- Primary Key structure for table universities
-- ----------------------------
ALTER TABLE [dbo].[universities] ADD CONSTRAINT [PK__Universi__3213E83FF71786FC] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for user_deposit
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[user_deposit]', RESEED, 1)
GO


-- ----------------------------
-- Primary Key structure for table user_deposit
-- ----------------------------
ALTER TABLE [dbo].[user_deposit] ADD CONSTRAINT [PK__user_dep__3213E83F15BDF5AF] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for user_money
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[user_money]', RESEED, 1)
GO


-- ----------------------------
-- Primary Key structure for table user_money
-- ----------------------------
ALTER TABLE [dbo].[user_money] ADD CONSTRAINT [PK__user_mon__3213E83F3C5B13B3] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Primary Key structure for table user_role
-- ----------------------------
ALTER TABLE [dbo].[user_role] ADD CONSTRAINT [PK__user_rol__B9BE370FCA0EE53D] PRIMARY KEY CLUSTERED ([user_id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for user_withdraw
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[user_withdraw]', RESEED, 1)
GO


-- ----------------------------
-- Primary Key structure for table user_withdraw
-- ----------------------------
ALTER TABLE [dbo].[user_withdraw] ADD CONSTRAINT [PK__user_wit__3213E83F072311FB] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO


-- ----------------------------
-- Auto increment value for users
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[users]', RESEED, 1)
GO


-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE [dbo].[users] ADD CONSTRAINT [PK__users__3213E83FBD7D1E71] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

