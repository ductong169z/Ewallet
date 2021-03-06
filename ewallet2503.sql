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

 Date: 28/03/2020 01:39:17
*/


-- ----------------------------
-- Table structure for roles
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[roles]') AND type IN ('U'))
	DROP TABLE [dbo].[roles]
GO

CREATE TABLE [dbo].[roles] (
  [id] int  NOT NULL,
  [role] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL
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
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[setting] VALUES (N'50000000', N'20000000', N'20000000')
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
  [id_student] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [id_uni] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [name] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [tuition] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL
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

INSERT INTO [dbo].[tuition] ([id], [id_student], [id_uni], [name], [tuition]) VALUES (N'1', N'CE140196', N'1', N'Nguyen Duc Tong', N'0'), (N'2', N'CE140037', N'1', N'Quan Duc Loc', N'8250000'), (N'3', N'CE140085', N'1', N'Tran Minh Thang', N'4950000'), (N'4', N'CE140102 ', N'1', N'Phan Le Trong Nghia', N'4950000')
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
  [name] varchar(255) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL
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

INSERT INTO [dbo].[universities] ([id], [name]) VALUES (N'1', N'FPT University'), (N'2', N'Can Tho University'), (N'3', N'Can Tho University of Medicine and Pharmacy'), (N'4', N'Tay Do University'), (N'5', N'Nam Can Tho University')
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
  [user_id] int  NOT NULL,
  [money] int  NOT NULL,
  [created_at] varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [type] int  NOT NULL,
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

INSERT INTO [dbo].[user_deposit] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'1', N'1', N'100000', N'', N'0', NULL), (N'2', N'4', N'1000', N'2020-03-24', N'0', NULL), (N'3', N'4', N'2000', N'2020-03-24', N'0', NULL), (N'4', N'4', N'2000', N'2020-03-24', N'0', NULL), (N'5', N'4', N'2000', N'2020-03-24', N'0', NULL), (N'6', N'4', N'83000', N'2020-03-24', N'0', NULL), (N'7', N'4', N'110000', N'2020-03-24', N'0', NULL), (N'8', N'4', N'50000', N'2020-03-24', N'0', NULL), (N'9', N'4', N'1000', N'2020-03-24', N'0', NULL), (N'10', N'4', N'4000', N'2020-03-24', N'0', NULL), (N'11', N'4', N'30000', N'2020-03-25', N'0', NULL), (N'12', N'4', N'200000', N'2020-03-25', N'0', NULL), (N'13', N'4', N'15000', N'2020-03-25', N'0', NULL), (N'14', N'4', N'20000', N'2020-03-25', N'0', NULL), (N'15', N'4', N'20000', N'2020-03-25', N'0', NULL), (N'16', N'4', N'20000', N'2020-03-25', N'0', NULL), (N'17', N'4', N'20000', N'2020-03-25', N'0', NULL), (N'18', N'4', N'20000', N'2020-03-25', N'0', NULL), (N'19', N'4', N'20000', N'2020-03-25', N'0', N'HELLO'), (N'20', N'4', N'20000', N'2020-03-25', N'0', N'HELLO'), (N'21', N'4', N'20000', N'2020-03-25', N'0', N'HELLO'), (N'22', N'4', N'20000', N'2020-03-25', N'0', N'HELLO'), (N'23', N'4', N'600000', N'2020-03-25', N'0', N'HELLO'), (N'24', N'4', N'200000', N'2020-03-25', N'0', N'HELLO'), (N'25', N'4', N'222222', N'2020-03-25', N'0', N'HELLO'), (N'26', N'4', N'188888', N'2020-03-25', N'0', N'HELLO'), (N'27', N'4', N'88890', N'2020-03-25', N'0', N'HELLO'), (N'28', N'4', N'500000', N'2020-03-25', N'0', N'HELLO'), (N'29', N'4', N'123123', N'2020-03-25', N'0', N'HELLO'), (N'30', N'4', N'200000', N'2020-03-25', N'0', N'HELLO'), (N'31', N'4', N'20000', N'2020-03-25', N'0', N'HELLO'), (N'32', N'4', N'30000', N'2020-03-25', N'0', N'HELLO'), (N'33', N'4', N'47401877', N'2020-03-25', N'0', N'HELLO'), (N'34', N'5', N'5000000', N'2020-03-25', N'0', N'HELLO'), (N'35', N'5', N'45000000', N'2020-03-25', N'0', N'HELLO'), (N'36', N'6', N'200000', N'2020-03-25', N'0', N'HELLO'), (N'37', N'6', N'30000', N'2020-03-25', N'0', N'HELLO'), (N'38', N'6', N'50000', N'2020-03-25', N'0', N'HELLO'), (N'39', N'6', N'2000000', N'2020-03-25', N'0', N'HELLO'), (N'40', N'6', N'3000000', N'2020-03-25', N'0', N'HELLO'), (N'41', N'6', N'5000000', N'2020-03-25', N'0', N'HELLO'), (N'42', N'4', N'200000', N'2020-03-26', N'0', N'HELLO'), (N'43', N'1', N'10000', N'2020-03-27', N'0', NULL), (N'44', N'1', N'16000000', N'2020-03-27', N'0', NULL), (N'45', N'1', N'66666', N'2020-03-27', N'0', NULL), (N'46', N'1', N'6666', N'2020-03-27', N'0', NULL), (N'47', N'1', N'90000', N'2020-03-27', N'0', NULL), (N'48', N'1', N'8999999', N'2020-03-27', N'0', NULL), (N'49', N'1', N'12112121', N'2020-03-27', N'0', NULL)
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
  [user_id] int  NOT NULL,
  [total_money] int  NOT NULL
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

INSERT INTO [dbo].[user_money] ([id], [user_id], [total_money]) VALUES (N'1', N'1', N'20965452'), (N'2', N'4', N'10255000'), (N'3', N'5', N'50000000'), (N'4', N'6', N'200000'), (N'6', N'8', N'20000'), (N'7', N'9', N'0'), (N'8', N'10', N'0')
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
  [role_id] int  NOT NULL
)
GO

ALTER TABLE [dbo].[user_role] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN TRANSACTION
GO

INSERT INTO [dbo].[user_role] VALUES (N'1', N'2'), (N'4', N'2'), (N'5', N'2'), (N'6', N'2'), (N'8', N'1'), (N'9', N'2'), (N'10', N'2')
GO

COMMIT
GO


-- ----------------------------
-- Table structure for user_transfer
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[user_transfer]') AND type IN ('U'))
	DROP TABLE [dbo].[user_transfer]
GO

CREATE TABLE [dbo].[user_transfer] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [send_id] int  NOT NULL,
  [receive_id] int  NOT NULL,
  [money] int  NOT NULL,
  [created_at] varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [type] int  NOT NULL
)
GO

ALTER TABLE [dbo].[user_transfer] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Records of user_transfer
-- ----------------------------
BEGIN TRANSACTION
GO

SET IDENTITY_INSERT [dbo].[user_transfer] ON
GO

INSERT INTO [dbo].[user_transfer] ([id], [send_id], [receive_id], [money], [created_at], [type]) VALUES (N'1', N'4', N'5', N'3000', N'2020-03-25', N'2'), (N'2', N'4', N'5', N'252000', N'2020-03-25', N'2'), (N'3', N'4', N'5', N'20000', N'2020-03-25', N'2'), (N'4', N'4', N'5', N'19725000', N'2020-03-25', N'2'), (N'5', N'1', N'8', N'10000', N'2020-03-27', N'2'), (N'6', N'1', N'8', N'10000', N'2020-03-27', N'2')
GO

SET IDENTITY_INSERT [dbo].[user_transfer] OFF
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
  [user_id] int  NOT NULL,
  [money] int  NOT NULL,
  [created_at] varchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS  NOT NULL,
  [type] int  NOT NULL,
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

INSERT INTO [dbo].[user_withdraw] ([id], [user_id], [money], [created_at], [type], [description]) VALUES (N'1', N'4', N'20000', N'2020-03-25', N'1', NULL), (N'2', N'4', N'100000', N'2020-03-25', N'1', NULL), (N'3', N'4', N'20000', N'2020-03-25', N'1', NULL), (N'4', N'4', N'20000', N'2020-03-25', N'1', NULL), (N'5', N'4', N'600000', N'2020-03-25', N'1', NULL), (N'6', N'4', N'520000', N'2020-03-25', N'1', NULL), (N'7', N'4', N'200000', N'2020-03-25', N'1', NULL), (N'8', N'4', N'100000', N'2020-03-25', N'1', NULL), (N'9', N'4', N'300000', N'2020-03-25', N'1', NULL), (N'10', N'4', N'223123', N'2020-03-25', N'1', NULL), (N'11', N'4', N'500000', N'2020-03-25', N'1', NULL), (N'12', N'4', N'10000', N'2020-03-25', N'1', NULL), (N'13', N'4', N'10000', N'2020-03-25', N'1', NULL), (N'14', N'4', N'17376877', N'2020-03-25', N'1', NULL), (N'15', N'5', N'20000000', N'2020-03-25', N'1', NULL), (N'16', N'6', N'30000', N'2020-03-25', N'1', NULL), (N'17', N'6', N'50000', N'2020-03-25', N'1', NULL), (N'18', N'6', N'10000000', N'2020-03-25', N'1', NULL), (N'19', N'1', N'100000', N'2020-03-27', N'1', N''), (N'20', N'1', N'16500000', N'2020-03-27', N'1', N'Name: Nguyen Duc Tong Tuition fee: 16500000 VND')
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
BEGIN TRANSACTION
GO

SET IDENTITY_INSERT [dbo].[users] ON
GO

INSERT INTO [dbo].[users] ([id], [username], [password], [fullname], [address], [phone], [mail], [gender], [status]) VALUES (N'1', N'ductong', N'202cb962ac59075b964b07152d234b70', N'Nguyen Duc Tong', N'', N'0787816931', N'tongngu@gmail.com', N'Male', N'1'), (N'4', N'loc', N'202cb962ac59075b964b07152d234b70', N'Quan Duc Loc', N'Can Tho', N'0835600799', N'loc@gmail.com', N'Male', N'0'), (N'5', N'loc2', N'202cb962ac59075b964b07152d234b70', N'Quan Duc Loc', N'Can Tho', N'0123456789', N'loc@gmail.com', N'Male', N'1'), (N'6', N'loc3', N'81dc9bdb52d04dc20036dbd8313ed055', N'Quan Duc Loc', N'Can Tho', N'000000000', N'loc3@gmail.com', N'Male', N'1'), (N'8', N'admin', N'202cb962ac59075b964b07152d234b70', N'admin', N'admin', N'0908081058', N'admin@admin.com', N'Male', N'1'), (N'9', N'admin1', N'202cb962ac59075b964b07152d234b70', N'Duplication phone number', N'Duplication phone number', N'0787816932', N'ducttonggmail.com', N'Male', N'1'), (N'10', N'admin12', N'44d9dbb60b6c2c24922cd62d249412f9', N'adadad', N'', N'0908081051', N'adad', N'Male', N'0')
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
DBCC CHECKIDENT ('[dbo].[user_deposit]', RESEED, 49)
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
DBCC CHECKIDENT ('[dbo].[user_money]', RESEED, 8)
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
DBCC CHECKIDENT ('[dbo].[user_transfer]', RESEED, 6)
GO


-- ----------------------------
-- Auto increment value for user_withdraw
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[user_withdraw]', RESEED, 20)
GO


-- ----------------------------
-- Auto increment value for users
-- ----------------------------
DBCC CHECKIDENT ('[dbo].[users]', RESEED, 10)
GO


-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE [dbo].[users] ADD CONSTRAINT [PK__users__3213E83FBD7D1E71] PRIMARY KEY CLUSTERED ([id], [phone])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

