/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : tianbaosystem

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 03/01/2019 14:51:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for announcement
-- ----------------------------
DROP TABLE IF EXISTS `announcement`;
CREATE TABLE `announcement`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言内容',
  `user_id` bigint(20) NOT NULL COMMENT '发布人id',
  `publish_time` datetime(0) NOT NULL COMMENT '发布时间',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示禁用该数据',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of announcement
-- ----------------------------
INSERT INTO `announcement` VALUES (1, '用于测试标题', '用于测试内容', 110, '2011-11-11 11:11:11', 0, '2018-11-28 10:29:39', 110, '2018-11-28 10:29:55', 110);
INSERT INTO `announcement` VALUES (2, '用于测试标题2', '用于测试内容2', 110, '2041-12-12 21:12:21', 0, '2018-11-28 11:14:49', 110, '2018-11-28 11:14:49', 110);
INSERT INTO `announcement` VALUES (3, 'curry', '用于测试内容2', 110, '2041-12-12 21:12:21', 0, '2018-11-28 13:03:51', 110, '2018-11-28 13:03:51', 110);
INSERT INTO `announcement` VALUES (4, 'durant', '用于测试内容2', 110, '2041-12-12 21:12:21', 0, '2018-11-28 14:13:22', 110, '2018-11-28 14:13:28', 110);
INSERT INTO `announcement` VALUES (5, 'jameshardern', '用于测试内容2', 110, '2023-12-22 11:17:21', 0, '2018-11-28 16:35:49', 110, '2018-11-28 16:35:50', 110);
INSERT INTO `announcement` VALUES (6, 'bill', '用于测试内容2', 110, '2023-12-22 03:17:21', 0, '2018-11-28 09:06:57', 110, '2018-11-28 09:06:57', 110);
INSERT INTO `announcement` VALUES (7, 'durant', '用于测试内容1111', 110, '2003-12-22 03:17:21', 1, '2018-12-08 06:00:56', 110, '2018-12-12 03:23:56', 110);
INSERT INTO `announcement` VALUES (8, '元旦快乐', '马上要过元旦了！', 110, '2008-08-08 10:18:18', 1, '2018-12-12 03:12:28', 110, '2018-12-12 03:24:00', 110);

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限请求对应的url地址',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限允许的名称',
  `type` int(10) NULL DEFAULT NULL COMMENT '权限类型，0表示菜单，1表示按钮',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示用户禁用此权限',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES (1, 'admin', '权限实体保存', '/authority/save', 'admin:authority:save', 0, '权限实体保存', 0, '2018-12-17 07:00:43', 110, '2018-12-17 07:00:43', 110);
INSERT INTO `authority` VALUES (2, 'admin', '获取管理员用户列表', '/admin/list/page', 'admin:list', 0, '获取管理员用户列表，分页展示', 0, '2018-12-18 01:45:26', 110, '2018-12-18 01:45:26', 110);
INSERT INTO `authority` VALUES (3, 'admin', '根据id获取管理员用户信息', '/admin/get/\\d+{1,}', 'admin:query', 0, '根据id获取管理员用户信息', 0, '2018-12-18 02:20:00', 110, '2018-12-18 02:20:00', 110);
INSERT INTO `authority` VALUES (4, 'admin', '根据id删除管理员用户', '/admin/delete/\\d+{1,}', 'admin:delete', 0, '根据id删除管理员用户', 0, '2018-12-18 02:23:04', 110, '2018-12-18 02:23:04', 110);
INSERT INTO `authority` VALUES (5, 'admin', '根据id修改管理员用户信息', '/admin/update', 'admin:update', 0, '根据id修改管理员用户信息', 0, '2018-12-18 02:27:07', 110, '2018-12-18 02:27:07', 110);
INSERT INTO `authority` VALUES (6, 'admin', '新建保存管理员用户', '/admin/save', 'admin:save', 0, '新建保存管理员用户', 0, '2018-12-18 02:28:16', 110, '2018-12-18 02:28:16', 110);
INSERT INTO `authority` VALUES (7, 'admin', '获取首页公告列表', '/announcement/list/page', 'admin:announcement:list', 0, '获取首页公告列表，分页展示', 0, '2018-12-18 02:33:37', 110, '2018-12-18 02:33:37', 110);
INSERT INTO `authority` VALUES (8, 'admin', '保存一条首页公告信息', '/announcement/save', 'admin:announcement:save', 0, '保存一条首页公告信息', 0, '2018-12-18 02:39:13', 110, '2018-12-18 02:39:13', 110);
INSERT INTO `authority` VALUES (9, 'admin', '根据id查询一条首页公告信息', '/announcement/get/\\d+{1,}', 'admin:announcement:query', 0, '根据id查询一条首页公告信息', 0, '2018-12-18 02:54:41', 110, '2018-12-18 02:54:41', 110);
INSERT INTO `authority` VALUES (10, 'admin', '根据id集合批量删除首页公告信息', '/announcement/delete', 'admin:announcement:delete', 0, '根据id集合批量删除首页公告信息', 0, '2018-12-18 03:01:40', 110, '2018-12-18 03:01:40', 110);
INSERT INTO `authority` VALUES (11, 'admin', '根据系统积分id查询个人积分列表', '/personal/bonus/list/page/\\d+{1,}', 'admin:personal:bonus:list', 0, '根据系统积分id查询个人积分列表', 0, '2018-12-18 03:08:13', 110, '2018-12-18 03:08:13', 110);
INSERT INTO `authority` VALUES (12, 'admin', '根据id删除个人积分数据', '/personal/bonus/delete/\\d+{1,}', 'admin:personal:bonus:delete', 0, '根据id删除个人积分数据', 0, '2018-12-18 03:10:17', 110, '2018-12-18 03:10:17', 110);
INSERT INTO `authority` VALUES (13, 'admin', '根据id更改个人积分数据可见性', '/personal/bonus/visible/\\d+{1,}', 'admin:personal:bonus:visible', 0, '根据id更改个人积分数据可见性', 0, '2018-12-18 03:13:53', 110, '2018-12-18 03:13:53', 110);
INSERT INTO `authority` VALUES (14, 'admin', '根据系统积分id模糊条件查询个人积分数据', '/personal/bonus/list/page/\\d+{1,}/condition', 'admin:personal:bonus:list:condition', 0, '根据系统积分id模糊条件查询个人积分数据，分页展示', 0, '2018-12-18 03:18:08', 110, '2018-12-18 03:18:08', 110);
INSERT INTO `authority` VALUES (15, 'admin', '获取当前管理员用户的个人信息', '/admin/personal/info', 'admin:personal:info', 0, '获取当前管理员用户的个人信息', 0, '2018-12-18 03:21:38', 110, '2018-12-18 03:21:38', 110);
INSERT INTO `authority` VALUES (16, 'admin', '修改当前管理员用户的登录密码', '/admin/personal/password', 'admin:personal:password', 0, '修改当前管理员用户的登录密码', 0, '2018-12-18 03:23:43', 110, '2018-12-18 03:23:43', 110);
INSERT INTO `authority` VALUES (17, 'admin', '修改超级管理员用户的超级密码', '/admin/personal/super/password', 'admin:personal:super:password', 0, '修改超级管理员用户的超级密码', 0, '2018-12-18 03:25:28', 110, '2018-12-18 03:25:28', 110);
INSERT INTO `authority` VALUES (18, 'admin', '获取会员等级列表', '/rank/list/page', 'admin:rank:list', 0, '获取会员等级列表，分页展示', 0, '2018-12-18 03:31:01', 110, '2018-12-18 03:31:01', 110);
INSERT INTO `authority` VALUES (19, 'admin', '根据id查询会员等级信息', '/rank/get/\\d+{1,}', 'admin:rank:query', 0, '根据id查询会员等级信息', 0, '2018-12-18 03:32:37', 110, '2018-12-18 03:32:37', 110);
INSERT INTO `authority` VALUES (20, 'admin', '根据id修改会员等级信息', '/rank/update', 'admin:rank:update', 0, '根据id修改会员等级信息', 0, '2018-12-18 03:34:09', 110, '2018-12-18 03:34:09', 110);
INSERT INTO `authority` VALUES (21, 'admin', '新建保存一条会员等级信息', '/rank/save', 'admin:rank:save', 0, '新建保存一条会员等级信息', 0, '2018-12-18 03:35:00', 110, '2018-12-18 03:35:00', 110);
INSERT INTO `authority` VALUES (22, 'admin', '获取角色列表', '/role/list/page', 'admin:role:list', 0, '获取角色列表，分页展示', 0, '2018-12-18 03:43:27', 110, '2018-12-18 03:43:27', 110);
INSERT INTO `authority` VALUES (23, 'admin', '根据id查询相关角色信息', '/role/get/\\d+{1,}', 'admin:role:query', 0, '根据id查询相关角色信息', 0, '2018-12-18 03:51:46', 110, '2018-12-18 03:51:46', 110);
INSERT INTO `authority` VALUES (24, 'admin', '根据id删除相关角色信息', '/role/delete/\\d+{1,}', 'admin:role:delete', 0, '根据id删除相关角色信息', 0, '2018-12-18 03:54:24', 110, '2018-12-18 03:54:24', 110);
INSERT INTO `authority` VALUES (25, 'admin', '根据id修改相关角色信息', '/role/update', 'admin:role:update', 0, '根据id修改相关角色信息', 0, '2018-12-18 03:55:23', 110, '2018-12-18 03:55:23', 110);
INSERT INTO `authority` VALUES (26, 'admin', '新建保存一条角色数据', '/role/save', 'admin:role:save', 0, '新建保存一条角色数据', 0, '2018-12-18 03:56:06', 110, '2018-12-18 03:56:06', 110);
INSERT INTO `authority` VALUES (27, 'admin', '获取股票证券指数列表', '/stock/list/page', 'admin:stock:list', 0, '获取股票证券指数列表', 0, '2019-01-01 14:44:19', 110, '2019-01-01 14:44:39', 110);
INSERT INTO `authority` VALUES (28, 'admin', '根据id查询一条股票证券指数信息', '/stock/get/\\d+{1,}', 'admin:stock:query', 0, '根据id查询一条股票证券指数信息', 0, '2019-01-01 14:46:10', 110, '2019-01-01 14:46:20', 110);
INSERT INTO `authority` VALUES (29, 'admin', '根据id删除一条股票证券指数', '/stock/delete/\\d+{1,}', 'admin:stock:delete', 0, '根据id删除一条股票证券指数', 0, '2019-01-01 14:47:58', 110, '2019-01-01 14:48:03', 110);
INSERT INTO `authority` VALUES (30, 'admin', '根据id修改一条股票证券指数数据', '/stock/update', 'admin:stock:update', 0, '根据id修改一条股票证券指数数据', 0, '2019-01-01 14:49:16', 110, '2019-01-01 14:49:24', 110);
INSERT INTO `authority` VALUES (31, 'admin', '新建保存一条股票证券指数数据', '/stock/save', 'admin:stock:save', 0, '新建保存一条股票证券指数数据', 0, '2019-01-01 14:50:31', 110, '2019-01-01 14:50:36', 110);
INSERT INTO `authority` VALUES (32, 'admin', '获取最新num数量的股票证券指数数据', '/stock/list/\\d+{1,}', 'admin:stock:list:num', 0, '获取最新num数量的股票证券指数数据', 0, '2019-01-01 14:51:56', 110, '2019-01-01 14:52:01', 110);
INSERT INTO `authority` VALUES (33, 'admin', '获取系统未结算前的总积分及随机产生一个系统权重比率系数', '/system/bonus/balance', 'admin:system:bonus:balance', 0, '获取系统未结算前的总积分及随机产生一个系统权重比率系数', 0, '2019-01-01 14:53:44', 110, '2019-01-01 14:53:50', 110);
INSERT INTO `authority` VALUES (34, 'admin', '系统积分结算，新建保存一条系统增值积分数据和多条个人增值积分数据', '/system/bonus/checkout', 'admin:system:bonus:checkout', 0, '系统积分结算，新建保存一条系统增值积分数据和多条个人增值积分数据', 0, '2019-01-01 14:54:51', 110, '2019-01-01 14:54:57', 110);
INSERT INTO `authority` VALUES (35, 'admin', '获取系统增值积分列表', '/system/bonus/list/page', 'admin:system:bonus:list', 0, '获取系统增值积分列表', 0, '2019-01-01 14:56:06', 110, '2019-01-01 14:56:13', 110);
INSERT INTO `authority` VALUES (36, 'admin', '根据id修改系统积分增值数据在客户端的可见性', '/system/bonus/visible/\\d+{1,}', 'admin:system:bonus:visible', 0, '根据id修改系统积分增值数据在客户端的可见性', 0, '2019-01-01 14:57:28', 110, '2019-01-01 14:57:37', 110);
INSERT INTO `authority` VALUES (37, 'admin', '根据id删除一条系统积分增值数据', '/system/bonus/delete/\\d+{1,}', 'admin:system:bonus:delete', 0, '根据id删除一条系统积分增值数据', 0, '2019-01-01 14:58:46', 110, '2019-01-01 14:58:52', 110);
INSERT INTO `authority` VALUES (38, 'admin', '获取全部已经审核的会员列表', '/user/list/page/audited', 'admin:user:list:audited', 0, '获取全部已经审核的会员列表', 0, '2019-01-01 14:59:58', 110, '2019-01-01 15:00:05', 110);
INSERT INTO `authority` VALUES (39, 'admin', '按条件查询会员列表', '/user/list/page/condition', 'admin:user:list:condition', 0, '按条件查询会员列表', 0, '2019-01-01 15:01:21', 110, '2019-01-01 15:01:28', 110);
INSERT INTO `authority` VALUES (40, 'admin', '根据用户id查询一条会员信息', '/user/get/\\d+{1,}', 'admin:user:query', 0, '根据用户id查询一条会员信息', 0, '2019-01-01 15:02:31', 110, '2019-01-01 15:02:37', 110);
INSERT INTO `authority` VALUES (41, 'admin', '根据id修改一条会员信息', '/user/update', 'admin:user:update', 0, '根据id修改一条会员信息', 0, '2019-01-01 15:04:25', 110, '2019-01-01 15:04:30', 110);
INSERT INTO `authority` VALUES (42, 'admin', '根据id重置会员的通用密码', '/user/reset/password/\\d+{1,}', 'admin:user:reset:password', 0, '根据id重置会员的通用密码', 0, '2019-01-01 15:05:23', 110, '2019-01-01 15:05:29', 110);
INSERT INTO `authority` VALUES (43, 'admin', '根据id集合批量逻辑删除会员禁止登陆', '/user/forbid/login', 'admin:user:forbid', 0, '根据id集合批量逻辑删除会员禁止登陆', 0, '2019-01-01 15:06:30', 110, '2019-01-01 15:06:36', 110);
INSERT INTO `authority` VALUES (44, 'admin', '获取当前管理员用户的留言列表', '/user/message/list/page/condition', 'admin:message:list', 0, '获取当前管理员用户的留言列表', 0, '2019-01-01 15:08:02', 110, '2019-01-01 15:08:09', 110);
INSERT INTO `authority` VALUES (45, 'admin', '根据id查询一条留言信息', '/user/message/get/\\d+{1,}', 'admin:message:query', 0, '根据id查询一条留言信息', 0, '2019-01-01 15:09:12', 110, '2019-01-01 15:09:17', 110);
INSERT INTO `authority` VALUES (46, 'admin', '根据id集合批量删除留言信息', '/user/message/delete', 'admin:message:delete', 0, '根据id集合批量删除留言信息', 0, '2019-01-01 15:10:11', 110, '2019-01-01 15:10:15', 110);
INSERT INTO `authority` VALUES (47, 'admin', '根据id修改更新留言的回复内容', '/user/message/reply', 'admin:message:reply', 0, '根据id修改更新留言的回复内容', 0, '2019-01-01 15:11:25', 110, '2019-01-01 15:11:30', 110);
INSERT INTO `authority` VALUES (48, 'app', '获取首页公告列表', '/announcement/list/page', 'app:announcement:list', 0, '获取首页公告列表', 0, '2019-01-01 15:13:10', 110, '2019-01-01 15:13:14', 110);
INSERT INTO `authority` VALUES (49, 'app', '根据id查询一条首页公告信息', '/announcement/get/\\d+{1,}', 'app:announcement:query', 0, '根据id查询一条首页公告信息', 0, '2019-01-01 15:14:17', 110, '2019-01-01 15:14:24', 110);
INSERT INTO `authority` VALUES (50, 'app', '获取当前会员用户的消费列表', '/consume/record/list/page', 'app:consume:record:list', 0, '获取当前会员用户的消费列表', 0, '2019-01-01 15:15:41', 110, '2019-01-01 15:15:46', 110);
INSERT INTO `authority` VALUES (51, 'app', '获取当前会员用户的留言列表', '/message/list/page', 'app:message:list', 0, '获取当前会员用户的留言列表', 0, '2019-01-01 15:16:44', 110, '2019-01-01 15:16:49', 110);
INSERT INTO `authority` VALUES (52, 'app', '根据id查询一条当前会员用户的留言', '/message/get/\\d+{1,}', 'app:message:query', 0, '根据id查询一条当前会员用户的留言', 0, '2019-01-01 15:17:42', 110, '2019-01-01 15:17:47', 110);
INSERT INTO `authority` VALUES (53, 'app', '新建保存一条会员用户的留言信息', '/message/save', 'app:message:save', 0, '新建保存一条会员用户的留言信息', 0, '2019-01-01 15:18:44', 110, '2019-01-01 15:18:49', 110);
INSERT INTO `authority` VALUES (54, 'app', '获取当前会员用户的个人增值积分列表', '/personal/bonus/list/page', 'app:personal:bonus:list', 0, '获取当前会员用户的个人增值积分列表', 0, '2019-01-01 15:19:44', 110, '2019-01-01 15:19:49', 110);
INSERT INTO `authority` VALUES (55, 'app', '获取当前会员用户的个人信息', '/user/personal/info', 'app:user:personal:info', 0, '获取当前会员用户的个人信息', 0, '2019-01-01 15:20:39', 110, '2019-01-01 15:20:44', 110);
INSERT INTO `authority` VALUES (56, 'app', '修改当前会员用户的登录密码', '/user/personal/password', 'app:user:personal:password', 0, '修改当前会员用户的登录密码', 0, '2019-01-01 15:21:43', 110, '2019-01-01 15:21:50', 110);
INSERT INTO `authority` VALUES (57, 'app', '新建保存一条会员信息(居住权登记)', '/user/save', 'app:user:save', 0, '新建保存一条会员信息(居住权登记)', 0, '2019-01-01 15:23:41', 110, '2019-01-01 15:23:46', 110);
INSERT INTO `authority` VALUES (58, 'app', '获取最新num数量的股票证券指数数据', '/stock/list/\\d+{1,}', 'app:stock:list:num', 0, '获取最新num数量的股票证券指数数据', 0, '2019-01-01 15:25:08', 110, '2019-01-01 15:25:14', 110);
INSERT INTO `authority` VALUES (59, 'app', '获取股票证券指数列表', '/stock/list/page', 'app:stock:list', 0, '获取股票证券指数列表', 0, '2019-01-01 15:26:11', 110, '2019-01-01 15:26:17', 110);
INSERT INTO `authority` VALUES (60, 'app', '根据id查询一条股票证券指数数据', '/stock/get/\\d+{1,}', 'app:stock:query', 0, '根据id查询一条股票证券指数数据', 0, '2019-01-01 15:27:09', 110, '2019-01-01 15:27:16', 110);

-- ----------------------------
-- Table structure for consume_record
-- ----------------------------
DROP TABLE IF EXISTS `consume_record`;
CREATE TABLE `consume_record`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `district` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地区',
  `location_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '基地名称',
  `amount` double(16, 2) NULL DEFAULT NULL COMMENT '消费金额',
  `consume_time` datetime(0) NOT NULL COMMENT '消费时间',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示禁用该数据',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consume_record
-- ----------------------------
INSERT INTO `consume_record` VALUES (1, 110, '上海', '浦东', 2000.00, '2019-01-01 11:24:59', 0, '2019-01-01 11:25:08', 110, '2019-01-01 11:25:20', 110);
INSERT INTO `consume_record` VALUES (2, 110, '北京', '朝阳', 10000.00, '2018-12-27 11:26:04', 0, '2018-11-27 11:26:15', 110, '2019-01-01 11:26:33', 110);
INSERT INTO `consume_record` VALUES (3, 110, '南京', '城隍庙', 2222.00, '2018-12-12 11:27:42', 0, '2018-12-18 11:27:51', 110, '2019-01-01 11:28:04', 110);
INSERT INTO `consume_record` VALUES (4, 110, '长春', '吉林大学', 34543.00, '2018-10-30 11:28:44', 0, '2018-12-10 11:28:54', 110, '2018-10-09 11:29:16', 110);
INSERT INTO `consume_record` VALUES (5, 12, '天津', '南开大学', 89098.00, '2018-08-07 11:29:58', 0, '2019-01-01 11:30:08', 110, '2019-01-01 11:30:21', 110);
INSERT INTO `consume_record` VALUES (6, 12, '成都', '火锅城', 12121.00, '2018-05-10 11:31:06', 0, '2019-01-01 11:31:22', 110, '2019-01-01 11:31:30', 110);
INSERT INTO `consume_record` VALUES (7, 12, '沈阳', '冰雪城', 656.00, '2018-09-01 11:32:31', 0, '2018-12-03 11:34:47', 110, '2019-01-01 11:35:01', NULL);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '直属上级部门id',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门描述',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示用户禁用该部门',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '研发部', 0, '研发技术部门', 0, '2018-11-29 17:15:31', 110, '2018-11-29 17:15:34', 110);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言内容',
  `url_type` int(10) NULL DEFAULT NULL COMMENT '跳转url类型：0表示内部跳转链接，1表示外部跳转链接，2表示无跳转',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'url地址',
  `reply` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员回复',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示禁用该数据',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  `reply_time` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (12321, '今天天冷', '零下20度', 2, '', '已处理', 0, '2018-12-11 17:41:23', 110, '2018-12-12 02:50:07', 110, NULL);
INSERT INTO `message` VALUES (34232, 'happy', '哈哈啊啪啪啪啪', 2, '', '完成', 0, '2018-12-11 17:42:19', 110, '2018-12-11 17:42:28', 110, NULL);
INSERT INTO `message` VALUES (12341434423, '什么玩意', '测试用的东西', 2, NULL, NULL, 0, '2018-12-11 17:43:19', 110, '2018-12-11 17:43:26', 110, NULL);

-- ----------------------------
-- Table structure for personal_bonus
-- ----------------------------
DROP TABLE IF EXISTS `personal_bonus`;
CREATE TABLE `personal_bonus`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上次结算的id',
  `system_bonus_id` bigint(20) NULL DEFAULT NULL COMMENT '系统积分表id',
  `start_points` double(16, 2) NULL DEFAULT NULL COMMENT '用户当日结算前积分值',
  `end_points` double(16, 2) NULL DEFAULT NULL COMMENT '用户当日结算后积分值',
  `ratio` double(16, 6) NULL DEFAULT NULL COMMENT '用户当日权重比率',
  `visible` int(10) NULL DEFAULT NULL COMMENT '在会员客户端是否可见：0表示正常可见，1表示不可见',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示禁用该数据',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of personal_bonus
-- ----------------------------
INSERT INTO `personal_bonus` VALUES (1110110110101, 110, 0, 0, 10000.00, 10115.00, 0.011500, 0, 0, '2018-12-08 23:19:43', 110, '2018-12-08 23:19:54', 110);
INSERT INTO `personal_bonus` VALUES (1071440605103017984, 110, 1110110110101, 1, 10115.00, 10126.11, 0.011700, 0, 0, '2018-12-08 16:25:24', 110, '2018-12-08 16:25:25', 110);
INSERT INTO `personal_bonus` VALUES (1072401340077973504, 110, 1110110110101, 6, 10115.00, 10126.11, 0.011700, 0, 0, '2018-12-11 08:02:58', 110, '2018-12-11 08:02:58', 110);
INSERT INTO `personal_bonus` VALUES (1072401894502047744, 110, 1072401340077973504, 7, 10126.11, 10137.23, 0.011700, 0, 0, '2018-12-11 08:05:15', 110, '2018-12-11 08:05:18', 110);
INSERT INTO `personal_bonus` VALUES (1072402877638516736, 110, 1072401894502047744, 8, 10137.23, 10148.34, 0.011700, 0, 0, '2018-12-11 08:09:05', 110, '2018-12-11 09:12:32', 110);

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位名称',
  `department_id` bigint(20) NULL DEFAULT NULL COMMENT '所属部门id',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位描述',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示用户禁用该职位',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of position
-- ----------------------------
INSERT INTO `position` VALUES (1, '助理', 1, '研发部助理', 0, '2018-11-29 17:13:49', 110, '2018-11-29 17:13:52', 110);

-- ----------------------------
-- Table structure for rank
-- ----------------------------
DROP TABLE IF EXISTS `rank`;
CREATE TABLE `rank`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '级别名称',
  `alias` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '别名',
  `base_points` int(10) NULL DEFAULT NULL COMMENT '基准积分',
  `base_money` double(16, 2) NULL DEFAULT NULL COMMENT '基准金额',
  `color` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '识别颜色',
  `max_bonus` double(16, 2) NULL DEFAULT NULL COMMENT '奖金封顶',
  `order` int(10) NULL DEFAULT NULL COMMENT '编排序号，这个唯一标识会员等级',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示禁用该数据',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rank
-- ----------------------------
INSERT INTO `rank` VALUES (1, '普卡会员', 'FFFFFF', 950, 10000.00, NULL, 10000.00, 1, 0, '2018-12-08 16:23:37', 110, '2018-12-08 16:23:37', 110);
INSERT INTO `rank` VALUES (2, '银卡会员', '银卡会员', 4750, 50000.00, 'FFFFFF', 50000.00, 2, 0, '2018-12-12 20:17:32', 110, '2018-12-12 12:56:31', 110);
INSERT INTO `rank` VALUES (3, '金卡会员', '金卡会员', 9500, 100000.00, 'FFFFFF', 100000.00, 3, 0, '2018-12-12 13:06:34', 110, '2018-12-12 13:06:35', 110);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示禁用该角色',
  `domain` int(10) NULL DEFAULT NULL COMMENT '平台作用域：0表示管理后台，1表示会员客户端app',
  `type` int(10) NULL DEFAULT NULL COMMENT '平台用户类型：具体参照设计文档',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '顶级管理员', '最高权限', 0, 0, 1, '2018-11-29 17:11:29', 110, '2018-11-29 17:11:41', 110);
INSERT INTO `role` VALUES (2, '一级管理员', '一级管理员', 0, NULL, NULL, '2018-12-12 13:56:01', 110, '2018-12-12 13:56:03', 110);
INSERT INTO `role` VALUES (3, '二级管理员', '二级管理员', 0, NULL, NULL, '2018-12-12 14:08:52', 110, '2018-12-12 14:18:41', 110);
INSERT INTO `role` VALUES (4, '普通会员用户', '普通会员用户', 0, 1, 2, '2019-01-01 16:15:13', 110, '2019-01-01 16:15:20', 110);

-- ----------------------------
-- Table structure for role_authority
-- ----------------------------
DROP TABLE IF EXISTS `role_authority`;
CREATE TABLE `role_authority`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `authority_id` bigint(20) NULL DEFAULT NULL COMMENT '权限id',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示当前角色禁用此权限',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_authority
-- ----------------------------
INSERT INTO `role_authority` VALUES (1, 1, 1, 0, '2018-12-20 11:25:18', 110, '2018-12-20 11:25:30', 110);
INSERT INTO `role_authority` VALUES (2, 1, 2, 0, '2018-12-20 13:27:45', 110, '2018-12-20 13:27:50', 110);
INSERT INTO `role_authority` VALUES (3, 1, 3, 0, '2019-01-01 15:30:57', 110, '2019-01-01 15:31:05', 110);
INSERT INTO `role_authority` VALUES (4, 1, 4, 0, '2019-01-01 15:45:35', 110, '2019-01-01 15:45:41', 110);
INSERT INTO `role_authority` VALUES (5, 1, 5, 0, '2019-01-01 15:45:58', 110, '2019-01-01 15:46:03', 110);
INSERT INTO `role_authority` VALUES (6, 1, 6, 0, '2019-01-01 15:46:20', 110, '2019-01-01 15:46:25', 110);
INSERT INTO `role_authority` VALUES (7, 1, 7, 0, '2019-01-01 15:46:41', 110, '2019-01-01 15:46:45', 110);
INSERT INTO `role_authority` VALUES (8, 1, 8, 0, '2019-01-01 15:47:08', 110, '2019-01-01 15:47:14', 110);
INSERT INTO `role_authority` VALUES (9, 1, 9, 0, '2019-01-01 15:47:26', 110, '2019-01-01 15:47:33', 110);
INSERT INTO `role_authority` VALUES (10, 1, 10, 0, '2019-01-01 15:47:45', 110, '2019-01-01 15:47:51', 110);
INSERT INTO `role_authority` VALUES (11, 1, 11, 0, '2019-01-01 15:48:03', 110, '2019-01-01 15:48:08', 110);
INSERT INTO `role_authority` VALUES (12, 1, 12, 0, '2019-01-01 15:48:20', 110, '2019-01-01 15:48:24', 110);
INSERT INTO `role_authority` VALUES (13, 1, 13, 0, '2019-01-01 15:48:35', 110, '2019-01-01 15:48:40', 110);
INSERT INTO `role_authority` VALUES (14, 1, 14, 0, '2019-01-01 15:48:56', 110, '2019-01-01 15:49:01', 110);
INSERT INTO `role_authority` VALUES (15, 1, 15, 0, '2019-01-01 15:49:16', 110, '2019-01-01 15:49:20', 110);
INSERT INTO `role_authority` VALUES (16, 1, 16, 0, '2019-01-01 15:49:35', 110, '2019-01-01 15:49:40', 110);
INSERT INTO `role_authority` VALUES (17, 1, 17, 0, '2019-01-01 15:49:54', 110, '2019-01-01 15:49:59', 110);
INSERT INTO `role_authority` VALUES (18, 1, 18, 0, '2019-01-01 15:50:10', 110, '2019-01-01 15:50:14', 110);
INSERT INTO `role_authority` VALUES (19, 1, 19, 0, '2019-01-01 15:50:25', 110, '2019-01-01 15:50:29', 110);
INSERT INTO `role_authority` VALUES (20, 1, 20, 0, '2019-01-01 15:50:41', 110, '2019-01-01 15:50:52', 110);
INSERT INTO `role_authority` VALUES (21, 1, 21, 0, '2019-01-01 15:51:11', 110, '2019-01-01 15:51:15', 110);
INSERT INTO `role_authority` VALUES (22, 1, 22, 0, '2019-01-01 15:51:27', 110, '2019-01-01 15:51:31', 110);
INSERT INTO `role_authority` VALUES (23, 1, 23, 0, '2019-01-01 15:51:44', 110, '2019-01-01 16:03:16', 110);
INSERT INTO `role_authority` VALUES (24, 1, 24, 0, '2019-01-01 16:03:30', 110, '2019-01-01 16:03:35', 110);
INSERT INTO `role_authority` VALUES (25, 1, 25, 0, '2019-01-01 16:03:47', 110, '2019-01-01 16:03:52', 110);
INSERT INTO `role_authority` VALUES (26, 1, 26, 0, '2019-01-01 16:04:03', 110, '2019-01-01 16:04:09', 110);
INSERT INTO `role_authority` VALUES (27, 1, 27, 0, '2019-01-01 16:04:22', 110, '2019-01-01 16:04:26', 110);
INSERT INTO `role_authority` VALUES (28, 1, 28, 0, '2019-01-01 16:04:39', 110, '2019-01-01 16:04:44', 110);
INSERT INTO `role_authority` VALUES (29, 1, 29, 0, '2019-01-01 16:04:58', 110, '2019-01-01 16:05:04', 110);
INSERT INTO `role_authority` VALUES (30, 1, 30, 0, '2019-01-01 16:05:18', 110, '2019-01-01 16:05:22', 110);
INSERT INTO `role_authority` VALUES (31, 1, 31, 0, '2019-01-01 16:05:34', 110, '2019-01-01 16:05:39', 110);
INSERT INTO `role_authority` VALUES (32, 1, 32, 0, '2019-01-01 16:05:51', 110, '2019-01-01 16:05:55', 110);
INSERT INTO `role_authority` VALUES (33, 1, 33, 0, '2019-01-01 16:06:09', 110, '2019-01-01 16:06:13', 110);
INSERT INTO `role_authority` VALUES (34, 1, 34, 0, '2019-01-01 16:06:25', 110, '2019-01-01 16:06:29', 110);
INSERT INTO `role_authority` VALUES (35, 1, 35, 0, '2019-01-01 16:06:43', 110, '2019-01-01 16:06:47', 110);
INSERT INTO `role_authority` VALUES (36, 1, 36, 0, '2019-01-01 16:07:01', 110, '2019-01-01 16:07:06', 110);
INSERT INTO `role_authority` VALUES (37, 1, 37, 0, '2019-01-01 16:07:21', 110, '2019-01-01 16:07:25', 110);
INSERT INTO `role_authority` VALUES (38, 1, 38, 0, '2019-01-01 16:07:37', 110, '2019-01-01 16:07:43', 110);
INSERT INTO `role_authority` VALUES (39, 1, 39, 0, '2019-01-01 16:07:58', 110, '2019-01-01 16:08:02', 110);
INSERT INTO `role_authority` VALUES (40, 1, 40, 0, '2019-01-01 16:08:15', 110, '2019-01-01 16:08:20', 110);
INSERT INTO `role_authority` VALUES (41, 1, 41, 0, '2019-01-01 16:08:37', 110, '2019-01-01 16:08:41', 110);
INSERT INTO `role_authority` VALUES (42, 1, 42, 0, '2019-01-01 16:08:54', 110, '2019-01-01 16:08:58', 110);
INSERT INTO `role_authority` VALUES (43, 1, 43, 0, '2019-01-01 16:09:12', 110, '2019-01-01 16:09:17', 110);
INSERT INTO `role_authority` VALUES (44, 1, 44, 0, '2019-01-01 16:09:33', 110, '2019-01-01 16:09:37', 110);
INSERT INTO `role_authority` VALUES (45, 1, 45, 0, '2019-01-01 16:09:54', 110, '2019-01-01 16:09:59', 110);
INSERT INTO `role_authority` VALUES (46, 1, 46, 0, '2019-01-01 16:10:13', 110, '2019-01-01 16:10:17', 110);
INSERT INTO `role_authority` VALUES (47, 1, 47, 0, '2019-01-01 16:10:31', 110, '2019-01-01 16:10:35', 110);
INSERT INTO `role_authority` VALUES (48, 4, 48, 0, '2019-01-01 16:22:36', 110, '2019-01-01 16:22:41', 110);
INSERT INTO `role_authority` VALUES (49, 4, 49, 0, '2019-01-01 16:23:02', 110, '2019-01-01 16:23:06', 110);
INSERT INTO `role_authority` VALUES (50, 4, 50, 0, '2019-01-01 16:23:26', 110, '2019-01-01 16:23:30', 110);
INSERT INTO `role_authority` VALUES (51, 4, 51, 0, '2019-01-01 16:23:49', 110, '2019-01-01 16:23:54', 110);
INSERT INTO `role_authority` VALUES (52, 4, 52, 0, '2019-01-01 16:24:05', 110, '2019-01-01 16:24:10', 110);
INSERT INTO `role_authority` VALUES (53, 4, 53, 0, '2019-01-01 16:24:24', 110, '2019-01-01 16:24:28', 110);
INSERT INTO `role_authority` VALUES (54, 4, 54, 0, '2019-01-01 16:24:40', 110, '2019-01-01 16:24:44', 110);
INSERT INTO `role_authority` VALUES (55, 4, 55, 0, '2019-01-01 16:24:55', 110, '2019-01-01 16:24:59', 110);
INSERT INTO `role_authority` VALUES (56, 4, 56, 0, '2019-01-01 16:25:12', 110, '2019-01-01 16:25:16', 110);
INSERT INTO `role_authority` VALUES (57, 4, 57, 0, '2019-01-01 16:25:28', 110, '2019-01-01 16:25:32', 110);
INSERT INTO `role_authority` VALUES (58, 4, 58, 0, '2019-01-01 16:25:48', 110, '2019-01-01 16:25:54', 110);
INSERT INTO `role_authority` VALUES (59, 4, 59, 0, '2019-01-01 16:26:08', 110, '2019-01-01 16:26:12', 110);
INSERT INTO `role_authority` VALUES (60, 4, 60, 0, '2019-01-01 16:26:27', 110, '2019-01-01 16:26:32', 110);

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `publish_time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示禁用该数据',
  `sh_open_exponent` double(16, 2) NULL DEFAULT NULL COMMENT '上证开盘指数',
  `sh_close_exponent` double(16, 2) NULL DEFAULT NULL COMMENT '上证收盘指数',
  `sh_max_exponent` double(16, 2) NULL DEFAULT NULL COMMENT '上证最高指数',
  `sh_min_exponent` double(16, 2) NULL DEFAULT NULL COMMENT '上证最低指数',
  `tb_open_exponent` double(16, 2) NULL DEFAULT NULL COMMENT '天宝开盘指数',
  `tb_close_exponent` double(16, 2) NULL DEFAULT NULL COMMENT '天宝收盘指数',
  `tb_max_exponent` double(16, 2) NULL DEFAULT NULL COMMENT '天宝最高指数',
  `tb_min_exponent` double(16, 2) NULL DEFAULT NULL COMMENT '天宝最低指数',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES (1, '6205-12-29 18:32:05', 0, 1333.12, 4343.79, 1566.90, 6566.57, 8234.79, 7678.25, 9687.01, 4453.57, '2018-12-08 11:24:38', 110, '2018-12-08 11:54:39', 110);
INSERT INTO `stock` VALUES (2, '1205-12-30 14:12:05', 0, 2333.12, 2343.79, 1766.90, 1566.57, 2342.90, 2333.12, 2333.12, 2333.12, '2018-12-08 12:16:14', 110, '2018-12-08 12:16:14', 110);
INSERT INTO `stock` VALUES (3, '4205-12-30 14:12:05', 0, 23533.12, 25343.79, 1756.90, 15656.57, 23452.90, 2333.12, 2533.12, 23533.12, '2018-12-08 12:16:46', 110, '2018-12-08 12:16:46', 110);
INSERT INTO `stock` VALUES (4, '2019-01-01 13:25:54', 0, 23178.07, 950695.59, 67567.59, 34489.34, 4534.34, 3454.31, 4549.23, 4534.67, '2019-01-01 13:27:52', 110, '2019-01-01 13:27:59', 110);
INSERT INTO `stock` VALUES (5, '2018-12-03 13:28:22', 0, 656.34, 234.56, 567.90, 909.70, 789.34, 45345.89, 112.56, 144.45, '2019-01-01 13:29:57', 110, '2019-01-01 13:30:04', 110);
INSERT INTO `stock` VALUES (6, '2018-12-04 13:30:32', 0, 567.20, 12.23, 1234.12, 65.89, 234.09, 67.84, 54.65, 8907.54, '2019-01-01 13:31:25', 110, '2019-01-01 13:31:31', 110);
INSERT INTO `stock` VALUES (7, '2018-12-05 13:31:43', 0, 490.32, 165.32, 245224.78, 3678.98, 897.05, 34553.65, 21.79, 54.21, '2019-01-01 13:32:50', 110, '2019-01-01 13:33:03', 110);
INSERT INTO `stock` VALUES (8, '2018-12-06 13:33:31', 0, 456.67, 523.66, 678.99, 321.44, 676.87, 43.09, 768.08, 543.84, '2019-01-01 13:34:23', 110, '2019-01-01 13:34:30', 110);
INSERT INTO `stock` VALUES (9, '2018-12-07 13:34:43', 0, 909.90, 808.76, 768.09, 7540.69, 349.02, 436.77, 216.98, 278.63, '2019-01-01 13:35:42', 110, '2019-01-01 13:35:47', 110);
INSERT INTO `stock` VALUES (10, '2018-12-08 13:36:03', 0, 33.44, 444.55, 111.21, 666.87, 87.66, 998.77, 333.22, 555.33, '2019-01-01 13:36:51', 110, '2019-01-01 13:36:58', 110);

-- ----------------------------
-- Table structure for system_bonus
-- ----------------------------
DROP TABLE IF EXISTS `system_bonus`;
CREATE TABLE `system_bonus`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `start_points` double(16, 2) NULL DEFAULT NULL COMMENT '系统当日结算前积分值',
  `end_points` double(16, 2) NULL DEFAULT NULL COMMENT '系统当日结算后积分值',
  `ratio` double(16, 6) NULL DEFAULT NULL COMMENT '系统当日权重比率，与当日的个人比率相同',
  `visible` int(10) NULL DEFAULT NULL COMMENT '在会员客户端是否可见：0表示正常可见，1表示不可见',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示禁用该数据',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_bonus
-- ----------------------------
INSERT INTO `system_bonus` VALUES (1, 10115.00, 10126.11, 0.011700, 0, 0, '2018-12-08 16:25:39', 110, '2018-12-08 16:25:39', 110);
INSERT INTO `system_bonus` VALUES (2, 10115.00, 10126.11, 0.011700, 0, 0, '2018-12-11 07:14:37', 110, '2018-12-11 07:14:37', 110);
INSERT INTO `system_bonus` VALUES (3, 10115.00, 10126.11, 0.011700, 0, 0, '2018-12-11 07:24:06', 110, '2018-12-11 07:24:09', 110);
INSERT INTO `system_bonus` VALUES (4, 10115.00, 10126.11, 0.011700, 0, 0, '2018-12-11 07:31:47', 110, '2018-12-11 07:31:47', 110);
INSERT INTO `system_bonus` VALUES (5, 10115.00, 10126.11, 0.011700, 0, 0, '2018-12-11 07:44:35', 110, '2018-12-11 07:44:35', 110);
INSERT INTO `system_bonus` VALUES (6, 10115.00, 10126.11, 0.011700, 0, 0, '2018-12-11 08:02:59', 110, '2018-12-11 08:02:59', 110);
INSERT INTO `system_bonus` VALUES (7, 10126.11, 10137.23, 0.011700, 0, 0, '2018-12-11 08:07:07', 110, '2018-12-11 08:07:12', 110);
INSERT INTO `system_bonus` VALUES (8, 10137.23, 10148.34, 0.011700, 0, 0, '2018-12-11 08:09:06', 110, '2018-12-11 08:49:37', 110);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `super_password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '超级密码，只有顶级管理员使用',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `identity_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `head_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像url地址',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机电话号码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱地址',
  `gender` int(10) NULL DEFAULT NULL COMMENT '性别',
  `rank_id` bigint(20) NULL DEFAULT NULL COMMENT '会员等级id',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态',
  `question_id` int(10) NULL DEFAULT NULL COMMENT '注册提问，id值为1~5',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提问的答案',
  `last_login_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上次登录ip地址',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '上次登录的时间',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  `province` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属省份',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属城市',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `certification_time` datetime(0) NULL DEFAULT NULL COMMENT '发证时间',
  `current_login_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本次登录ip地址',
  `current_login_time` datetime(0) NULL DEFAULT NULL COMMENT '本次登录的时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'lilong', 'T/vD2pMEqpNZEaLYcB6Lkw==', NULL, '李隆', '11034543593405345', '贱人', '', '2904852934', 'lilong@163.com', 0, 2, 0, 3, '无', '127.0.0.1', '2019-01-03 14:36:46', '2019-01-03 14:36:49', 110, '2019-01-03 14:36:55', 110, '北京', '北京', '团结湖', '2019-01-03 14:37:25', NULL, '2019-01-03 14:37:34');
INSERT INTO `user` VALUES (2, 'harden', 'T/vD2pMEqpNZEaLYcB6Lkw==', NULL, '哈登', '52495243953045', '大胡子', NULL, '45738945', 'harden@163.com', 0, 4, 0, 4, '火箭', '127.0.0.1', '2019-01-03 14:40:08', '2019-01-03 14:40:11', 110, '2019-01-03 14:40:17', 110, '美国休斯敦', '美国休斯敦', '火箭队', '2019-01-03 14:41:00', NULL, '2019-01-03 14:41:07');
INSERT INTO `user` VALUES (3, 'mayun', 'T/vD2pMEqpNZEaLYcB6Lkw==', NULL, '马云', '23049530845', '外星人', NULL, '3948539453', 'mayun@163.com', 0, 3, 0, 2, '阿里巴巴', '127.0.0.1', '2019-01-03 14:44:15', '2019-01-03 14:44:21', 110, '2019-01-03 14:44:26', 110, '杭州', '杭州', '阿里', '2019-01-03 14:45:07', NULL, '2019-01-03 14:45:20');
INSERT INTO `user` VALUES (12, 'durant', 'WzXkKCAtRn6E9O1ZrBq2xQ==', '', 'green', '2454243535434', 'death', NULL, '66666666', 'durant@gmail.com', 0, 3, 0, 2, 'funny', '127.0.0.1', '2018-12-12 11:32:32', '2018-12-12 11:32:43', 110, '2018-12-12 05:35:29', 110, '北京', '北京', '呼家楼32号', NULL, NULL, NULL);
INSERT INTO `user` VALUES (110, 'curry', 'T/vD2pMEqpNZEaLYcB6Lkw==', 'T/vD2pMEqpNZEaLYcB6Lkw==', 'curry', '123456789', 'curry', NULL, '12345678911', 'curry@facebook.com', 0, 1, 0, 1, '答案', '127.0.0.1', '2018-11-20 17:09:05', '2018-11-28 17:08:57', 110, '2018-12-08 10:59:05', 110, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (1073061220271620096, '赵丽颖', 'CK3lybfMbkuD23jgrbTvXQ==', NULL, '林志玲', '11011011101349348', NULL, NULL, '199998843345', 'zhiling@gmail.com', NULL, 3, 0, NULL, NULL, NULL, NULL, '2018-12-13 03:45:07', 110, '2018-12-13 04:47:55', 110, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_message
-- ----------------------------
DROP TABLE IF EXISTS `user_message`;
CREATE TABLE `user_message`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `message_id` bigint(20) NULL DEFAULT NULL COMMENT '留言id',
  `sender_id` bigint(20) NULL DEFAULT NULL COMMENT '发送留言者id',
  `receiver_id` bigint(20) NULL DEFAULT NULL COMMENT '接收留言者id',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示禁用此数据',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_message
-- ----------------------------
INSERT INTO `user_message` VALUES (1, 12321, 110, 110, 5, '2018-12-12 09:20:06', 110, '2018-12-12 02:49:48', 110);
INSERT INTO `user_message` VALUES (2, 12341434423, 110, 12, 6, '2018-12-12 09:35:08', 110, '2018-12-12 02:24:42', 110);

-- ----------------------------
-- Table structure for user_position
-- ----------------------------
DROP TABLE IF EXISTS `user_position`;
CREATE TABLE `user_position`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `position_id` bigint(20) NULL DEFAULT NULL COMMENT '职位id',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示用户禁用该职位',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_position
-- ----------------------------
INSERT INTO `user_position` VALUES (1, 110, 1, 0, '2018-11-29 17:14:12', 110, '2018-11-29 17:14:15', 110);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户id',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色id',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态：0表示正常，1表示用户禁用该角色',
  `create_time` datetime(0) NOT NULL COMMENT '最后创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人id',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `update_user_id` bigint(20) NULL DEFAULT NULL COMMENT '修改人id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 110, 1, 0, '2018-11-29 17:12:30', 110, '2018-11-29 17:12:37', 110);
INSERT INTO `user_role` VALUES (2, 12, 2, 0, '2018-12-13 09:04:09', 110, '2018-12-13 09:04:15', 110);
INSERT INTO `user_role` VALUES (1073061483078320128, 1073061220271620096, 3, 1, '2018-12-13 03:46:09', 110, '2018-12-13 04:48:04', 110);
INSERT INTO `user_role` VALUES (1073077084534439936, 1073061220271620096, 3, 0, '2018-12-13 04:48:08', 110, '2018-12-13 04:48:08', 110);

SET FOREIGN_KEY_CHECKS = 1;
