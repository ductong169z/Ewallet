/*
 Navicat Premium Data Transfer

 Source Server         : SQL Server
 Source Server Type    : SQL Server
 Source Server Version : 13005026
 Source Host           : localhost:1433
 Source Catalog        : Ewallet
 Source Schema         : dbo

 Target Server Type    : SQL Server
 Target Server Version : 13005026
 File Encoding         : 65001

 Date: 25/03/2020 23:00:09
*/


-- ----------------------------
-- Table structure for roles
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[roles]') AND type IN ('U'))
	DROP TABLE [dbo].[roles]
GO

CREATE TABLE [dbo].[roles] (
  [id] int  NOT NULL,
  [role] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT  NULL
)
GO

ALTER TABLE [dbo].[roles] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO [dbo].[roles] ([id], [role]) VALUES (N'1', N'Admin')
GO

INSERT INTO [dbo].[roles] ([id], [role]) VALUES (N'2', N'User')
GO


-- ----------------------------
-- Table structure for setting
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[setting]') AND type IN ('U'))
	DROP TABLE [dbo].[setting]
GO

CREATE TABLE [dbo].[setting] (
  [deposit_lim] int  NOT NULL,
  [withdraw_lim] int  NOT NULL,
  [trans_lim] int  NOT NULL
)
GO

ALTER TABLE [dbo].[setting] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of setting
-- ----------------------------
INSERT INTO [dbo].[setting] ([deposit_lim], [withdraw_lim], [trans_lim]) VALUES (N'50000000', N'20000000', N'20000000')
GO


-- ----------------------------
-- Table structure for tuition
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[tuition]') AND type IN ('U'))
	DROP TABLE [dbo].[tuition]
GO

CREATE TABLE [dbo].[tuition] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [id_student] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT  NULL,
  [id_uni] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT  NULL,
  [name] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT  NULL,
  [tuition] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT  NULL
)
GO

ALTER TABLE [dbo].[tuition] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of tuition
-- ----------------------------
SET IDENTITY_INSERT [dbo].[tuition] ON
GO

INSERT INTO [dbo].[tuition] ([id], [id_student], [id_uni], [name], [tuition]) VALUES (N'1', N'CE140196', N'1', N'Nguyen Duc Tong', N'16500000')
GO

INSERT INTO [dbo].[tuition] ([id], [id_student], [id_uni], [name], [tuition]) VALUES (N'2', N'CE140037', N'1', N'Quan Duc Loc', N'8250000')
GO

INSERT INTO [dbo].[tuition] ([id], [id_student], [id_uni], [name], [tuition]) VALUES (N'3', N'CE140085', N'1', N'Tran Minh Thang', N'4950000')
GO

INSERT INTO [dbo].[tuition] ([id], [id_student], [id_uni], [name], [tuition]) VALUES (N'4', N'CE140102 ', N'1', N'Phan Le Trong Nghia', N'4950000')
GO

SET IDENTITY_INSERT [dbo].[tuition] OFF
GO


-- ----------------------------
-- Table structure for universities
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[universities]') AND type IN ('U'))
	DROP TABLE [dbo].[universities]
GO

CREATE TABLE [dbo].[universities] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [name] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS NOT  NULL
)
GO

ALTER TABLE [dbo].[universities] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of universities
-- ----------------------------
SET IDENTITY_INSERT [dbo].[universities] ON
GO

INSERT INTO [dbo].[universities] ([id], [name]) VALUES (N'1', N'FPT University')
GO

INSERT INTO [dbo].[universities] ([id], [name]) VALUES (N'2', N'Can Tho University')
GO

INSERT INTO [dbo].[universities] ([id], [name]) VALUES (N'3', N'Can Tho University of Medicine and Pharmacy')
GO

INSERT INTO [dbo].[universities] ([id], [name]) VALUES (N'4', N'Tay Do University')
GO

INSERT INTO [dbo].[universities] ([id], [name]) VALUES (N'5', N'Nam Can Tho University')
GO

SET IDENTITY_INSERT [dbo].[universities] OFF
GO


-- ----------------------------
-- Table structure for user_deposit
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[user_deposit]') AND type IN ('U'))
	DROP TABLE [dbo].[user_deposit]
GO

CREATE TABLE [dbo].[user_deposit] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [user_id] int NOT NULL,
  [money] int NOT NULL,
  [created_at] varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [type] int NOT NULL,
  [description] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[user_deposit] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_deposit
-- ----------------------------
SET IDENTITY_INSERT [dbo].[user_deposit] ON
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'1', N'1', N'100000', N'', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'2', N'4', N'1000', N'2020-03-24', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'3', N'4', N'2000', N'2020-03-24', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'4', N'4', N'2000', N'2020-03-24', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'5', N'4', N'2000', N'2020-03-24', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'6', N'4', N'83000', N'2020-03-24', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'7', N'4', N'110000', N'2020-03-24', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'8', N'4', N'50000', N'2020-03-24', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'9', N'4', N'1000', N'2020-03-24', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'10', N'4', N'4000', N'2020-03-24', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'11', N'4', N'30000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'12', N'4', N'200000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'13', N'4', N'15000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'14', N'4', N'20000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'15', N'4', N'20000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'16', N'4', N'20000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'17', N'4', N'20000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'18', N'4', N'20000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'19', N'4', N'20000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'20', N'4', N'20000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'21', N'4', N'20000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'22', N'4', N'20000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'23', N'4', N'600000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'24', N'4', N'200000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'25', N'4', N'222222', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'26', N'4', N'188888', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'27', N'4', N'88890', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'28', N'4', N'500000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'29', N'4', N'123123', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'30', N'4', N'200000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'31', N'4', N'20000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'32', N'4', N'30000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'33', N'4', N'47401877', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'34', N'5', N'5000000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'35', N'5', N'45000000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'36', N'6', N'200000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'37', N'6', N'30000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'38', N'6', N'50000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'39', N'6', N'2000000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'40', N'6', N'3000000', N'2020-03-25', N'0', NULL)
GO

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'41', N'6', N'5000000', N'2020-03-25', N'0', NULL)
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
  [user_id] int  NOT NULL,
  [total_money] int  NOT NULL
)
GO

ALTER TABLE [dbo].[user_money] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_money
-- ----------------------------
SET IDENTITY_INSERT [dbo].[user_money] ON
GO

INSERT INTO [dbo].[user_money] ([id], [user_id], [total_money]) VALUES (N'1', N'1', N'100000')
GO

INSERT INTO [dbo].[user_money] ([id], [user_id], [total_money]) VALUES (N'2', N'4', N'10255000')
GO

INSERT INTO [dbo].[user_money] ([id], [user_id], [total_money]) VALUES (N'3', N'5', N'50000000')
GO

INSERT INTO [dbo].[user_money] ([id], [user_id], [total_money]) VALUES (N'4', N'6', N'200000')
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
  [role_id] int  NOT NULL
)
GO

ALTER TABLE [dbo].[user_role] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO [dbo].[user_role] ([user_id], [role_id]) VALUES (N'1', N'1')
GO

INSERT INTO [dbo].[user_role] ([user_id], [role_id]) VALUES (N'4', N'2')
GO

INSERT INTO [dbo].[user_role] ([user_id], [role_id]) VALUES (N'5', N'2')
GO

INSERT INTO [dbo].[user_role] ([user_id], [role_id]) VALUES (N'6', N'2')
GO


-- ----------------------------
-- Table structure for user_transfer
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[user_transfer]') AND type IN ('U'))
	DROP TABLE [dbo].[user_transfer]
GO

CREATE TABLE [dbo].[user_transfer] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [send_id] int NOT  NULL,
  [receive_id] int  NOT NULL,
  [money] int NOT  NULL,
  [created_at] varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [type] int  NOT NULL
)
GO

ALTER TABLE [dbo].[user_transfer] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_transfer
-- ----------------------------
SET IDENTITY_INSERT [dbo].[user_transfer] ON
GO

INSERT INTO [dbo].[user_transfer] ([id], [send_id], [receive_id], [money], [created_at], [type]) VALUES (N'1', N'4', N'5', N'3000', N'2020-03-25', N'2')
GO

INSERT INTO [dbo].[user_transfer] ([id], [send_id], [receive_id], [money], [created_at], [type]) VALUES (N'2', N'4', N'5', N'252000', N'2020-03-25', N'2')
GO

INSERT INTO [dbo].[user_transfer] ([id], [send_id], [receive_id], [money], [created_at], [type]) VALUES (N'3', N'4', N'5', N'20000', N'2020-03-25', N'2')
GO

INSERT INTO [dbo].[user_transfer] ([id], [send_id], [receive_id], [money], [created_at], [type]) VALUES (N'4', N'4', N'5', N'19725000', N'2020-03-25', N'2')
GO

SET IDENTITY_INSERT [dbo].[user_transfer] OFF
GO


-- ----------------------------
-- Table structure for user_withdraw
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[user_withdraw]') AND type IN ('U'))
	DROP TABLE [dbo].[user_withdraw]
GO

CREATE TABLE [dbo].[user_withdraw] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [user_id] int NOT  NULL,
  [money] int  NOT NULL,
  [created_at] varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT  NULL,
  [type] int  NOT NULL,
  [description] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL
)
GO

ALTER TABLE [dbo].[user_withdraw] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_withdraw
-- ----------------------------
SET IDENTITY_INSERT [dbo].[user_withdraw] ON
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'1', N'4', N'20000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'2', N'4', N'100000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'3', N'4', N'20000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'4', N'4', N'20000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'5', N'4', N'600000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'6', N'4', N'520000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'7', N'4', N'200000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'8', N'4', N'100000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'9', N'4', N'300000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'10', N'4', N'223123', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'11', N'4', N'500000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'12', N'4', N'10000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'13', N'4', N'10000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'14', N'4', N'17376877', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'15', N'5', N'20000000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'16', N'6', N'30000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'17', N'6', N'50000', N'2020-03-25', N'1', NULL)
GO

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'18', N'6', N'10000000', N'2020-03-25', N'1', NULL)
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
  [username] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [password] varchar(32) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [fullname] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [address] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NULL,
  [phone] varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [mail] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [gender] varchar(6) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [status] int  NOT NULL
)
GO

ALTER TABLE [dbo].[users] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of users
-- ----------------------------
SET IDENTITY_INSERT [dbo].[users] ON
GO

INSERT INTO [dbo].[users] ([id], [username], [password], [fullname], [address], [phone], [mail], [gender], [status]) VALUES (N'1', N'ductong', N'202cb962ac59075b964b07152d234b70', N'Nguyen Duc Tong', N'', N'0787816931', N'tongu@gmail.com', N'Male', N'1')
GO

INSERT INTO [dbo].[users] ([id], [username], [password], [fullname], [address], [phone], [mail], [gender], [status]) VALUES (N'4', N'loc', N'202cb962ac59075b964b07152d234b70', N'Quan Duc Loc', N'Can Tho', N'0835600799', N'loc@gmail.com', N'Male', N'1')
GO

INSERT INTO [dbo].[users] ([id], [username], [password], [fullname], [address], [phone], [mail], [gender], [status]) VALUES (N'5', N'loc2', N'202cb962ac59075b964b07152d234b70', N'Quan Duc Loc', N'Can Tho', N'0123456789', N'loc@gmail.com', N'Male', N'1')
GO

INSERT INTO [dbo].[users] ([id], [username], [password], [fullname], [address], [phone], [mail], [gender], [status]) VALUES (N'6', N'loc3', N'81dc9bdb52d04dc20036dbd8313ed055', N'Quan Duc Loc', N'Can Tho', N'000000000', N'loc3@gmail.com', N'Male', N'1')
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
-- Auto increment value for tuition
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[tuition]', RESEED, 4)
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
DBCC CHECKIDENT ('[dbo].[user_deposit]', RESEED, 41)
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
DBCC CHECKIDENT ('[dbo].[user_money]', RESEED, 4)
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
-- Auto increment value for user_transfer
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[user_transfer]', RESEED, 4)
GO


-- ----------------------------
-- Auto increment value for user_withdraw
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[user_withdraw]', RESEED, 18)
GO


-- ----------------------------
-- Auto increment value for users
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[users]', RESEED, 6)
GO


-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE [dbo].[users] ADD CONSTRAINT [PK__users__3213E83FBD7D1E71] PRIMARY KEY CLUSTERED ([id], [phone])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

