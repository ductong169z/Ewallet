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

 Date: 21/03/2020 09:30:50
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
  [type] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[user_deposit] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_deposit
-- ----------------------------
SET IDENTITY_INSERT [dbo].[user_deposit] ON
GO

SET IDENTITY_INSERT [dbo].[user_deposit] OFF
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
SET IDENTITY_INSERT [dbo].[user_money] ON
GO

SET IDENTITY_INSERT [dbo].[user_money] OFF
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
  [type] int  NULL
)
GO

ALTER TABLE [dbo].[user_withdraw] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_withdraw
-- ----------------------------
SET IDENTITY_INSERT [dbo].[user_withdraw] ON
GO

SET IDENTITY_INSERT [dbo].[user_withdraw] OFF
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
SET IDENTITY_INSERT [dbo].[users] ON
GO

SET IDENTITY_INSERT [dbo].[users] OFF
GO


-- ----------------------------
-- Primary Key structure for table roles
-- ----------------------------
ALTER TABLE [dbo].[roles] ADD CONSTRAINT [PK__roles__3213E83FEB67F782] PRIMARY KEY CLUSTERED ([id])
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

