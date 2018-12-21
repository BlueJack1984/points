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

 Date: 21/12/2018 14:34:04
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
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES (1, 'admin', '权限实体保存', '/authority/save', 'authority:save', 0, '权限实体保存', 0, '2018-12-17 07:00:43', 110, '2018-12-17 07:00:43', 110);
INSERT INTO `authority` VALUES (2, 'admin', '获取管理员用户列表', '/admin/list/page', 'admin:list', 0, '获取管理员用户列表，分页展示', 0, '2018-12-18 01:45:26', 110, '2018-12-18 01:45:26', 110);
INSERT INTO `authority` VALUES (3, 'admin', '根据id获取管理员用户信息', '/admin/get/\\d+{1,}', 'admin:query', 0, '根据id获取管理员用户信息', 0, '2018-12-18 02:20:00', 110, '2018-12-18 02:20:00', 110);
INSERT INTO `authority` VALUES (4, 'admin', '根据id删除管理员用户', '/admin/delete/\\d+{1,}', 'admin:delete', 0, '根据id删除管理员用户', 0, '2018-12-18 02:23:04', 110, '2018-12-18 02:23:04', 110);
INSERT INTO `authority` VALUES (5, 'admin', '根据id修改管理员用户信息', '/admin/update', 'admin:update', 0, '根据id修改管理员用户信息', 0, '2018-12-18 02:27:07', 110, '2018-12-18 02:27:07', 110);
INSERT INTO `authority` VALUES (6, 'admin', '新建保存管理员用户', '/admin/save', 'admin:save', 0, '新建保存管理员用户', 0, '2018-12-18 02:28:16', 110, '2018-12-18 02:28:16', 110);
INSERT INTO `authority` VALUES (7, 'admin', '获取首页公告列表', '/announcement/list/page', 'announcement:list', 0, '获取首页公告列表，分页展示', 0, '2018-12-18 02:33:37', 110, '2018-12-18 02:33:37', 110);
INSERT INTO `authority` VALUES (8, 'admin', '保存一条首页公告信息', '/announcement/save', 'announcement:save', 0, '保存一条首页公告信息', 0, '2018-12-18 02:39:13', 110, '2018-12-18 02:39:13', 110);
INSERT INTO `authority` VALUES (9, 'admin', '根据id查询一条首页公告信息', '/announcement/get/\\d+{1,}', 'announcement:query', 0, '根据id查询一条首页公告信息', 0, '2018-12-18 02:54:41', 110, '2018-12-18 02:54:41', 110);
INSERT INTO `authority` VALUES (10, 'admin', '根据id集合批量删除首页公告信息', '/announcement/delete', 'announcement:delete', 0, '根据id集合批量删除首页公告信息', 0, '2018-12-18 03:01:40', 110, '2018-12-18 03:01:40', 110);
INSERT INTO `authority` VALUES (11, 'admin', '根据系统积分id查询个人积分列表', '/personal/bonus/list/page/\\d+{1,}', 'personal:bonus:list', 0, '根据系统积分id查询个人积分列表', 0, '2018-12-18 03:08:13', 110, '2018-12-18 03:08:13', 110);
INSERT INTO `authority` VALUES (12, 'admin', '根据id删除个人积分数据', '/personal/bonus/delete/\\d+{1,}', 'personal:bonus:delete', 0, '根据id删除个人积分数据', 0, '2018-12-18 03:10:17', 110, '2018-12-18 03:10:17', 110);
INSERT INTO `authority` VALUES (13, 'admin', '根据id更改个人积分数据可见性', '/personal/bonus/visible/\\d+{1,}', 'personal:bonus:visible', 0, '根据id更改个人积分数据可见性', 0, '2018-12-18 03:13:53', 110, '2018-12-18 03:13:53', 110);
INSERT INTO `authority` VALUES (14, 'admin', '根据系统积分id模糊条件查询个人积分数据', '/personal/bonus/list/page/condition/\\d+{1,}', 'personal:bonus:list:condition', 0, '根据系统积分id模糊条件查询个人积分数据，分页展示', 0, '2018-12-18 03:18:08', 110, '2018-12-18 03:18:08', 110);
INSERT INTO `authority` VALUES (15, 'admin', '获取当前管理员用户的个人信息', '/admin/personal/info', 'admin:personal:info', 0, '获取当前管理员用户的个人信息', 0, '2018-12-18 03:21:38', 110, '2018-12-18 03:21:38', 110);
INSERT INTO `authority` VALUES (16, 'admin', '修改当前管理员用户的登录密码', '/admin/personal/password', 'admin:personal:password', 0, '修改当前管理员用户的登录密码', 0, '2018-12-18 03:23:43', 110, '2018-12-18 03:23:43', 110);
INSERT INTO `authority` VALUES (17, 'admin', '修改超级管理员用户的超级密码', '/admin/personal/super/password', 'admin:personal:super:password', 0, '修改超级管理员用户的超级密码', 0, '2018-12-18 03:25:28', 110, '2018-12-18 03:25:28', 110);
INSERT INTO `authority` VALUES (18, 'admin', '获取会员等级列表', '/rank/list/page', 'rank:list', 0, '获取会员等级列表，分页展示', 0, '2018-12-18 03:31:01', 110, '2018-12-18 03:31:01', 110);
INSERT INTO `authority` VALUES (19, 'admin', '根据id查询会员等级信息', '/rank/get/\\d+{1,}', 'rank:query', 0, '根据id查询会员等级信息', 0, '2018-12-18 03:32:37', 110, '2018-12-18 03:32:37', 110);
INSERT INTO `authority` VALUES (20, 'admin', '根据id修改会员等级信息', '/rank/update', 'rank:update', 0, '根据id修改会员等级信息', 0, '2018-12-18 03:34:09', 110, '2018-12-18 03:34:09', 110);
INSERT INTO `authority` VALUES (21, 'admin', '新建保存一条会员等级信息', '/rank/save', 'rank:save', 0, '新建保存一条会员等级信息', 0, '2018-12-18 03:35:00', 110, '2018-12-18 03:35:00', 110);
INSERT INTO `authority` VALUES (22, 'admin', '获取角色列表', '/role/list/page', 'role:list', 0, '获取角色列表，分页展示', 0, '2018-12-18 03:43:27', 110, '2018-12-18 03:43:27', 110);
INSERT INTO `authority` VALUES (23, 'admin', '根据id查询相关角色信息', '/role/get/\\d+{1,}', 'role:query', 0, '根据id查询相关角色信息', 0, '2018-12-18 03:51:46', 110, '2018-12-18 03:51:46', 110);
INSERT INTO `authority` VALUES (24, 'admin', '根据id删除相关角色信息', '/role/delete/\\d+{1,}', 'role:delete', 0, '根据id删除相关角色信息', 0, '2018-12-18 03:54:24', 110, '2018-12-18 03:54:24', 110);
INSERT INTO `authority` VALUES (25, 'admin', '根据id修改相关角色信息', '/role/update', 'role:update', 0, '根据id修改相关角色信息', 0, '2018-12-18 03:55:23', 110, '2018-12-18 03:55:23', 110);
INSERT INTO `authority` VALUES (26, 'admin', '新建保存一条角色数据', '/role/save', 'role:save', 0, '新建保存一条角色数据', 0, '2018-12-18 03:56:06', 110, '2018-12-18 03:56:06', 110);

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '顶级管理员', '最高权限', 0, 1, 1, '2018-11-29 17:11:29', 110, '2018-11-29 17:11:41', 110);
INSERT INTO `role` VALUES (2, '一级管理员', '一级管理员', 0, NULL, NULL, '2018-12-12 13:56:01', 110, '2018-12-12 13:56:03', 110);
INSERT INTO `role` VALUES (3, '二级管理员', '二级管理员', 0, NULL, NULL, '2018-12-12 14:08:52', 110, '2018-12-12 14:18:41', 110);

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
INSERT INTO `role_authority` VALUES (1, 1, 7, 0, '2018-12-20 11:25:18', 110, '2018-12-20 11:25:30', 110);
INSERT INTO `role_authority` VALUES (2, 1, 18, 0, '2018-12-20 13:27:45', 110, '2018-12-20 13:27:50', 110);

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES (1, '6205-12-29 18:32:05', 0, 1333.12, 4343.79, 1566.90, 6566.57, 8234.79, 7678.25, 9687.01, 4453.57, '2018-12-08 11:24:38', 110, '2018-12-08 11:54:39', 110);
INSERT INTO `stock` VALUES (2, '1205-12-30 14:12:05', 0, 2333.12, 2343.79, 1766.90, 1566.57, 2342.90, 2333.12, 2333.12, 2333.12, '2018-12-08 12:16:14', 110, '2018-12-08 12:16:14', 110);
INSERT INTO `stock` VALUES (3, '4205-12-30 14:12:05', 0, 23533.12, 25343.79, 1756.90, 15656.57, 23452.90, 2333.12, 2533.12, 23533.12, '2018-12-08 12:16:46', 110, '2018-12-08 12:16:46', 110);

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (12, 'durant', 'WzXkKCAtRn6E9O1ZrBq2xQ==', '', 'green', '2454243535434', 'death', NULL, '66666666', 'durant@gmail.com', 0, 3, 0, 2, 'funny', '127.0.0.1', '2018-12-12 11:32:32', '2018-12-12 11:32:43', 110, '2018-12-12 05:35:29', 110, '北京', '北京', '呼家楼32号', NULL);
INSERT INTO `user` VALUES (110, 'curry', 'T/vD2pMEqpNZEaLYcB6Lkw==', 'T/vD2pMEqpNZEaLYcB6Lkw==', 'curry', '123456789', 'curry', NULL, '12345678911', 'curry@facebook.com', 0, 1, 0, 1, '答案', '127.0.0.1', '2018-11-20 17:09:05', '2018-11-28 17:08:57', 110, '2018-12-08 10:59:05', 110, NULL, NULL, NULL, NULL);
INSERT INTO `user` VALUES (1073061220271620096, '赵丽颖', 'CK3lybfMbkuD23jgrbTvXQ==', NULL, '林志玲', '11011011101349348', NULL, NULL, '199998843345', 'zhiling@gmail.com', NULL, 3, 0, NULL, NULL, NULL, NULL, '2018-12-13 03:45:07', 110, '2018-12-13 04:47:55', 110, NULL, NULL, NULL, NULL);

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
