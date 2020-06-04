/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80017
Source Host           : 127.0.0.1:3306
Source Database       : twohands

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2020-05-25 20:19:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理者id',
  `admin_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理者姓名',
  `admin_login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理者账号',
  `admin_login_pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管理者密码',
  `admin_state` int(2) DEFAULT NULL COMMENT '管理者状态  0正常  1禁用',
  `admin_role` int(15) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'susie', 'susie', '123', '0', null);
INSERT INTO `admin` VALUES ('2', '多个权限', 'admin', '123456', '0', null);
INSERT INTO `admin` VALUES ('6', '普通管理员权限', 'adminffss', '666666', '0', null);
INSERT INTO `admin` VALUES ('7', '基本设置权限', 'adminjb', '123456', '0', null);
INSERT INTO `admin` VALUES ('8', '冯涛（无权限）', 'root', '123456', '0', null);
INSERT INTO `admin` VALUES ('17', '系统管理', 'jbsz', '123456', '1', null);

-- ----------------------------
-- Table structure for admin_log
-- ----------------------------
DROP TABLE IF EXISTS `admin_log`;
CREATE TABLE `admin_log` (
  `alid` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员日志id',
  `aid` int(11) DEFAULT NULL COMMENT '管理员外键',
  `operation_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '操作时间',
  `date` datetime DEFAULT NULL COMMENT '操作日期',
  PRIMARY KEY (`alid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin_log
-- ----------------------------
INSERT INTO `admin_log` VALUES ('1', null, '变身', '2020-01-16 21:17:59');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `fbid` int(11) NOT NULL AUTO_INCREMENT COMMENT '反馈表主键',
  `uid` int(11) DEFAULT NULL COMMENT '用户外键',
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '反馈类型',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '反馈内容',
  `fbTime` datetime DEFAULT NULL COMMENT '相关照片',
  `state` int(2) DEFAULT NULL COMMENT '反馈状态 0审核中  1审核完',
  PRIMARY KEY (`fbid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('1', '1', '界面问题', '三次成功', '2020-05-19 11:36:28', '1');
INSERT INTO `feedback` VALUES ('2', '1', '其他', '这是一条建议', '2020-05-20 11:01:16', '0');

-- ----------------------------
-- Table structure for good
-- ----------------------------
DROP TABLE IF EXISTS `good`;
CREATE TABLE `good` (
  `good_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物品id',
  `gtid` int(11) DEFAULT NULL COMMENT '物品类型外键',
  `good_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '物品名称',
  `good_count` int(8) DEFAULT NULL COMMENT '物品数量',
  `good_price` decimal(8,2) DEFAULT NULL COMMENT '物品价格',
  `good_photo` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '物品图片',
  `good_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '物品介绍',
  `good_state` int(2) DEFAULT NULL COMMENT '物品状态 0正常  1不显示  3管理员上架',
  PRIMARY KEY (`good_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of good
-- ----------------------------
INSERT INTO `good` VALUES ('28', '1', '运动手表', '1', '70.00', '/upload/f6ef305827b54ed5b5701103c912c422.jpg', '小米的远动手表，由于原主人换新的了，现在低价出售，质量经官方检验，没有问题，请放心购买。', '53');
INSERT INTO `good` VALUES ('29', '1', '蓝牙耳机', '1', '110.00', '/upload/02abe960f8be4a9cb0b713f255705ec5.jpg', '   没开封的蓝牙耳机出售，原价120，买多了又回去要15，想剩个邮费，请大家帮帮忙。', '53');
INSERT INTO `good` VALUES ('32', '2', '魔鬼经济学', '1', '1.00', '/upload/d4dd259660cf4d82a96c82e41286ebd6.jpg', '二手书', '0');
INSERT INTO `good` VALUES ('33', '5', '抱枕', '1', '70.00', '/upload/b1ab4805d2c74b71a066735fc561237b.jpg', '二手抱枕', '50');
INSERT INTO `good` VALUES ('34', '5', '拉姆抱枕', '1', '20.00', '/upload/abf8176c78884341af471a62237bcd6e.jpg', '没有损坏，很新。请大家放心购买。', '3');
INSERT INTO `good` VALUES ('35', '5', '佩奇抱枕', '1', '20.00', '/upload/6d6c0cf0cb7b4c9381b7107a54535f05.jpg', '一直以为佩奇是国产动画，查了才知道是英国的，未损坏，非常柔软。', '3');
INSERT INTO `good` VALUES ('36', '5', '抱枕', '1', '20.00', '/upload/57c542b399b64e8da0e4ea663eec8f1f.jpg', '封面不知道是谁的抱枕~~~', '3');
INSERT INTO `good` VALUES ('37', '1', '系统优盘', '2', '60.00', '/upload/43f67a5ad7c641948ba8b8fa2b4f95af.jpg', '两个优盘，每内存16G，3.0接口内含5个G的“学习材料”', '50');
INSERT INTO `good` VALUES ('38', '1', '耳机', '1', '60.00', '/upload/9b4f161566b0410dbb562dcd5a2bd1ee.jpg', '运动耳机，防尘，挂耳设计。', '0');
INSERT INTO `good` VALUES ('39', '1', '惠普U盘', '1', '50.00', '/upload/dd9b78cc57e7448895d905bbac699ae6.jpg', '正版U盘，请放心购买。', '0');
INSERT INTO `good` VALUES ('40', '1', '苹果耳机', '1', '100.00', '/upload/0880f99fc95144038abd5fb82b2981fa.jpg', '换手机了，原装苹果耳机对音质有极高要求的人不要放过这个。', '0');
INSERT INTO `good` VALUES ('41', '2', '英语四级', '1', '1.00', '/upload/c277cac52a8342f6bd67aa0276147d3f.jpg', '英语四级已过低价甩卖庆祝自己过四级！！！', '0');
INSERT INTO `good` VALUES ('42', '2', '英语四级（单词）', '1', '10.00', '/upload/adfbb9d271824d1987e116c23f34d673.jpg', '里面有很多记得笔记，希望能帮助到用的人。', '0');
INSERT INTO `good` VALUES ('43', '4', '塑料盆栽', '1', '5.00', '/upload/f7749de1457440618e8d5889b6541cb3.jpg', '摆在窗台上当装饰也不错。', '0');
INSERT INTO `good` VALUES ('44', '4', '仙人掌多肉种', '1', '30.00', '/upload/9aa70bb6120e4490ae379bb5fe26bd51.jpg', '      买回去十天半月不交水也不会死，特别适合一学起来就啥都忘了的同学。', '0');
INSERT INTO `good` VALUES ('45', '1', '盆栽', '2', '20.00', '/upload/2d3000f3493d489f9646e31c2ec9370f.jpg', '正是开花的时候，多晒太阳少浇水。', '50');
INSERT INTO `good` VALUES ('46', '6', '握力器', '2', '10.00', '/upload/3b74a8b7f1f444f0afdca27fd9086b74.jpg', '15斤的握力器，成对卖。', '0');
INSERT INTO `good` VALUES ('47', '6', '臂力器', '1', '20.00', '/upload/ab3ad10278f84bc395aefe91d7e3b1e8.jpg', '强身健体', '0');
INSERT INTO `good` VALUES ('48', '6', '臂力器', '1', '20.00', '/upload/354044351c104d61870e4372b7446928.jpg', '也能强身健体。', '0');
INSERT INTO `good` VALUES ('49', '5', '蕾姆抱枕', '1', '70.00', '/upload/e3b31e06201e469484d26065ec3dd1bb.jpg', '蕾姆抱枕，淘宝买的原价100多', '0');
INSERT INTO `good` VALUES ('50', '5', '书', '1', '10.00', '/upload/c92432888f914142b95ec4cf8469a9e5.jpg', '简介', '0');
INSERT INTO `good` VALUES ('51', '8', '新商品', '1', '1.00', '/upload/d8e49e6ed1244d898c99c7ca60e38d3d.jpg', '22', '3');

-- ----------------------------
-- Table structure for good_type
-- ----------------------------
DROP TABLE IF EXISTS `good_type`;
CREATE TABLE `good_type` (
  `good_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '物品类型id',
  `good_type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '物品类型名称',
  `good_type_state` int(2) DEFAULT NULL COMMENT '物品类型状态 0正常  1异常',
  PRIMARY KEY (`good_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of good_type
-- ----------------------------
INSERT INTO `good_type` VALUES ('1', '电子产品', '0');
INSERT INTO `good_type` VALUES ('2', '学习材料', '0');
INSERT INTO `good_type` VALUES ('3', '书籍', '1');
INSERT INTO `good_type` VALUES ('4', '植株盆景', '0');
INSERT INTO `good_type` VALUES ('5', '床上用品', '0');
INSERT INTO `good_type` VALUES ('6', '运动器械', '0');
INSERT INTO `good_type` VALUES ('7', '生活用品', '0');
INSERT INTO `good_type` VALUES ('8', '新的类型', '0');

-- ----------------------------
-- Table structure for integral(wait)
-- ----------------------------
DROP TABLE IF EXISTS `integral(wait)`;
CREATE TABLE `integral(wait)` (
  `iid` int(11) NOT NULL AUTO_INCREMENT COMMENT '积分表id',
  `uid` int(11) DEFAULT NULL COMMENT '用户外键',
  `integral_type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '积分类型名',
  `integral_number` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '积分数量',
  `in_state` int(2) DEFAULT NULL COMMENT '状态  0买货  1卖货',
  `in_flag` int(2) DEFAULT NULL COMMENT '积分表标志 0增加  1 减少',
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of integral(wait)
-- ----------------------------

-- ----------------------------
-- Table structure for integral_type(wait)
-- ----------------------------
DROP TABLE IF EXISTS `integral_type(wait)`;
CREATE TABLE `integral_type(wait)` (
  `itid` int(11) NOT NULL COMMENT '积分类型表id',
  `integral_type_name` varchar(20) DEFAULT NULL COMMENT '积分类型名称',
  PRIMARY KEY (`itid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of integral_type(wait)
-- ----------------------------

-- ----------------------------
-- Table structure for news(wait)
-- ----------------------------
DROP TABLE IF EXISTS `news(wait)`;
CREATE TABLE `news(wait)` (
  `new_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '新闻主键',
  `new_title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '新闻标题',
  `new_text` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '新闻内容',
  `new_date` datetime DEFAULT NULL COMMENT '新闻发布时间',
  `aid` int(11) DEFAULT NULL COMMENT '管理者外键',
  `new_state` int(2) DEFAULT NULL COMMENT '新闻状态 0审核 1发布 2删除',
  PRIMARY KEY (`new_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of news(wait)
-- ----------------------------

-- ----------------------------
-- Table structure for purchase_order
-- ----------------------------
DROP TABLE IF EXISTS `purchase_order`;
CREATE TABLE `purchase_order` (
  `poid` int(11) NOT NULL AUTO_INCREMENT COMMENT '购买单id',
  `ouid` int(11) DEFAULT NULL COMMENT '卖出用户外键',
  `iuid` int(11) DEFAULT NULL COMMENT '购买用户外键',
  `gid` int(11) DEFAULT NULL COMMENT '物品id外键',
  `po_price` decimal(8,2) DEFAULT NULL COMMENT '订单价格合计',
  `po_number` int(11) DEFAULT NULL COMMENT '订单物品数量',
  `po_time_start` datetime DEFAULT NULL COMMENT '订单生成时间',
  `po_time_end` datetime DEFAULT NULL COMMENT '订单完成时间',
  `po_state` int(2) DEFAULT NULL COMMENT '订单状态 0未完成 1完成',
  PRIMARY KEY (`poid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of purchase_order
-- ----------------------------
INSERT INTO `purchase_order` VALUES ('28', '1', '1', '29', '110.00', '1', '2020-05-19 03:31:55', null, '99');
INSERT INTO `purchase_order` VALUES ('29', '1', '1', '28', '70.00', '1', '2020-05-21 03:10:39', null, '99');
INSERT INTO `purchase_order` VALUES ('30', '1', '2', '33', '70.00', '1', '2020-05-22 08:40:49', null, '0');
INSERT INTO `purchase_order` VALUES ('31', '2', '1', '45', '20.00', '2', '2020-05-23 08:01:15', null, '0');
INSERT INTO `purchase_order` VALUES ('32', '1', '8', '37', '60.00', '2', '2020-05-24 01:31:28', null, '0');
INSERT INTO `purchase_order` VALUES ('33', '1', '8', '37', '60.00', '2', '2020-05-24 01:31:50', null, '0');
INSERT INTO `purchase_order` VALUES ('34', '1', '8', '37', '60.00', '2', '2020-05-24 01:33:43', null, '0');

-- ----------------------------
-- Table structure for reward_order(wait)
-- ----------------------------
DROP TABLE IF EXISTS `reward_order(wait)`;
CREATE TABLE `reward_order(wait)` (
  `rid` int(11) NOT NULL AUTO_INCREMENT COMMENT '悬赏表主键',
  `good_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '悬赏物品名称',
  `type` int(11) DEFAULT NULL COMMENT '物品类型外键',
  `price` decimal(8,2) DEFAULT NULL COMMENT '悬赏金',
  `photo` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '照片路径',
  `state` int(2) DEFAULT NULL COMMENT '悬赏单状态 0正在进行 1结束',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of reward_order(wait)
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '角色名称',
  `role_state` int(2) DEFAULT NULL COMMENT '角色状态',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', '0');
INSERT INTO `role` VALUES ('2', '普通管理员', '0');
INSERT INTO `role` VALUES ('25', '基本设置', '0');
INSERT INTO `role` VALUES ('26', '用户管理', '0');
INSERT INTO `role` VALUES ('27', '系统管理', '0');

-- ----------------------------
-- Table structure for sales_order
-- ----------------------------
DROP TABLE IF EXISTS `sales_order`;
CREATE TABLE `sales_order` (
  `soid` int(11) NOT NULL AUTO_INCREMENT COMMENT '卖出单id',
  `ouid` int(11) DEFAULT NULL COMMENT '卖出用户外键',
  `iuid` int(11) DEFAULT NULL COMMENT '购买用户外键',
  `gid` int(11) DEFAULT NULL COMMENT '物品id外键',
  `so_price` decimal(8,2) DEFAULT NULL COMMENT '订单价格合计',
  `so_number` int(11) DEFAULT NULL COMMENT '订单物品数量',
  `so_time_start` datetime DEFAULT NULL COMMENT '订单生成时间',
  `so_time_end` datetime DEFAULT NULL COMMENT '订单完成时间',
  `so_state` int(2) DEFAULT NULL COMMENT '订单状态 0未完成 1完成  3未完成的官方发布 4官方发布完成  删除操作2加状态  ',
  PRIMARY KEY (`soid`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of sales_order
-- ----------------------------
INSERT INTO `sales_order` VALUES ('20', '1', '1', '28', '70.00', '1', '2020-05-18 14:09:49', '2020-05-21 03:10:39', '53');
INSERT INTO `sales_order` VALUES ('21', '1', '1', '29', '110.00', '1', '2020-05-18 14:12:39', '2020-05-19 03:31:55', '53');
INSERT INTO `sales_order` VALUES ('24', '1', null, '32', '1.00', '1', '2020-05-19 11:33:33', null, '0');
INSERT INTO `sales_order` VALUES ('25', '1', '2', '33', '70.00', '1', '2020-05-21 03:11:55', '2020-05-22 08:40:49', '98');
INSERT INTO `sales_order` VALUES ('26', '1', null, '34', '20.00', '1', '2020-05-22 11:32:06', null, '3');
INSERT INTO `sales_order` VALUES ('27', '1', null, '35', '20.00', '1', '2020-05-22 11:33:55', null, '3');
INSERT INTO `sales_order` VALUES ('28', '1', null, '36', '20.00', '1', '2020-05-22 11:35:17', null, '3');
INSERT INTO `sales_order` VALUES ('29', '1', '8', '37', '60.00', '2', '2020-05-23 06:41:33', '2020-05-24 01:33:43', '50');
INSERT INTO `sales_order` VALUES ('30', '1', null, '38', '60.00', '1', '2020-05-23 06:43:29', null, '0');
INSERT INTO `sales_order` VALUES ('31', '1', null, '39', '50.00', '1', '2020-05-23 06:44:37', null, '0');
INSERT INTO `sales_order` VALUES ('32', '1', null, '40', '100.00', '1', '2020-05-23 06:46:09', null, '0');
INSERT INTO `sales_order` VALUES ('33', '1', null, '41', '1.00', '1', '2020-05-23 06:47:53', null, '0');
INSERT INTO `sales_order` VALUES ('34', '1', null, '42', '10.00', '1', '2020-05-23 06:49:04', null, '0');
INSERT INTO `sales_order` VALUES ('35', '2', null, '43', '5.00', '1', '2020-05-23 06:54:17', null, '0');
INSERT INTO `sales_order` VALUES ('36', '2', null, '44', '30.00', '1', '2020-05-23 06:55:58', null, '0');
INSERT INTO `sales_order` VALUES ('37', '2', '1', '45', '20.00', '2', '2020-05-23 06:58:07', '2020-05-23 08:01:15', '50');
INSERT INTO `sales_order` VALUES ('38', '2', null, '46', '10.00', '2', '2020-05-23 07:01:25', null, '0');
INSERT INTO `sales_order` VALUES ('39', '2', null, '47', '20.00', '1', '2020-05-23 07:02:29', null, '0');
INSERT INTO `sales_order` VALUES ('40', '2', null, '48', '20.00', '1', '2020-05-23 07:03:42', null, '0');
INSERT INTO `sales_order` VALUES ('41', '1', null, '49', '70.00', '1', '2020-05-23 12:08:44', null, '0');
INSERT INTO `sales_order` VALUES ('42', '8', null, '50', '10.00', '1', '2020-05-24 01:33:27', null, '0');
INSERT INTO `sales_order` VALUES ('43', '1', null, '51', '1.00', '1', '2020-05-24 01:35:10', null, '3');

-- ----------------------------
-- Table structure for statistical(wait)
-- ----------------------------
DROP TABLE IF EXISTS `statistical(wait)`;
CREATE TABLE `statistical(wait)` (
  `sid` int(11) NOT NULL AUTO_INCREMENT COMMENT '统计id',
  `s_type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '统计类型名称',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `money` decimal(8,2) DEFAULT NULL COMMENT '金钱',
  `in_state` int(2) DEFAULT NULL COMMENT '统计表状态 0正常  1异常',
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of statistical(wait)
-- ----------------------------

-- ----------------------------
-- Table structure for t_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_role`;
CREATE TABLE `t_admin_role` (
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `admin_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin_role
-- ----------------------------
INSERT INTO `t_admin_role` VALUES ('8', 'text');
INSERT INTO `t_admin_role` VALUES ('1', 'susie');
INSERT INTO `t_admin_role` VALUES ('2', 'adminffss');
INSERT INTO `t_admin_role` VALUES ('25', 'admin');
INSERT INTO `t_admin_role` VALUES ('26', 'admin');
INSERT INTO `t_admin_role` VALUES ('2', 'ss');
INSERT INTO `t_admin_role` VALUES ('27', 'jbsz');
INSERT INTO `t_admin_role` VALUES ('25', 'adminjb');

-- ----------------------------
-- Table structure for t_autho
-- ----------------------------
DROP TABLE IF EXISTS `t_autho`;
CREATE TABLE `t_autho` (
  `autho_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `autho_name` varchar(20) DEFAULT NULL COMMENT '权限名称',
  `autho_perms` varchar(20) DEFAULT NULL COMMENT '权限描述',
  `autho_level` int(11) DEFAULT NULL COMMENT '级别',
  `autho_father_id` int(11) DEFAULT NULL COMMENT '父级别id',
  PRIMARY KEY (`autho_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_autho
-- ----------------------------
INSERT INTO `t_autho` VALUES ('1', '类型添加', 'basic:addGoodType', '1', '17');
INSERT INTO `t_autho` VALUES ('2', '物品添加', 'basic:addGood', '1', '17');
INSERT INTO `t_autho` VALUES ('3', '物品列表', 'basic:toGetAllGood', '1', '17');
INSERT INTO `t_autho` VALUES ('5', '用户列表', 'basic:userList', '1', '18');
INSERT INTO `t_autho` VALUES ('6', '首页轮播添加', 'basic:a:add', '2', '3');
INSERT INTO `t_autho` VALUES ('7', '首页轮播删除', 'basic:a:del', '2', '3');
INSERT INTO `t_autho` VALUES ('8', '首页轮播修改', 'basic:a:upd', '2', '3');
INSERT INTO `t_autho` VALUES ('10', '反馈管理', 'feed:getAllFeedBack', '1', '18');
INSERT INTO `t_autho` VALUES ('12', '添加角色', 'system:addRole', '1', '19');
INSERT INTO `t_autho` VALUES ('13', '修改角色', 'system:updRole', '1', '19');
INSERT INTO `t_autho` VALUES ('14', '角色管理', 'system:roleManage', '1', '19');
INSERT INTO `t_autho` VALUES ('15', '添加用户', 'system:addUser', '1', '19');
INSERT INTO `t_autho` VALUES ('16', '修改用户角色', 'system:updUser', '1', '19');
INSERT INTO `t_autho` VALUES ('17', '基本设置', null, '0', null);
INSERT INTO `t_autho` VALUES ('18', '用户管理', null, '0', null);
INSERT INTO `t_autho` VALUES ('19', '系统管理', null, '0', null);
INSERT INTO `t_autho` VALUES ('20', '用户管理', 'system:userManage', '1', '19');
INSERT INTO `t_autho` VALUES ('21', '修改密码', 'system:updPass', '1', '19');

-- ----------------------------
-- Table structure for t_role_autho
-- ----------------------------
DROP TABLE IF EXISTS `t_role_autho`;
CREATE TABLE `t_role_autho` (
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `autho_id` int(11) DEFAULT NULL COMMENT '权限id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_autho
-- ----------------------------
INSERT INTO `t_role_autho` VALUES ('24', '1');
INSERT INTO `t_role_autho` VALUES ('24', '2');
INSERT INTO `t_role_autho` VALUES ('21', '14');
INSERT INTO `t_role_autho` VALUES ('21', '20');
INSERT INTO `t_role_autho` VALUES ('21', '21');
INSERT INTO `t_role_autho` VALUES ('1', '1');
INSERT INTO `t_role_autho` VALUES ('1', '2');
INSERT INTO `t_role_autho` VALUES ('1', '3');
INSERT INTO `t_role_autho` VALUES ('1', '4');
INSERT INTO `t_role_autho` VALUES ('1', '5');
INSERT INTO `t_role_autho` VALUES ('1', '10');
INSERT INTO `t_role_autho` VALUES ('1', '11');
INSERT INTO `t_role_autho` VALUES ('1', '12');
INSERT INTO `t_role_autho` VALUES ('1', '13');
INSERT INTO `t_role_autho` VALUES ('1', '14');
INSERT INTO `t_role_autho` VALUES ('1', '15');
INSERT INTO `t_role_autho` VALUES ('1', '16');
INSERT INTO `t_role_autho` VALUES ('1', '20');
INSERT INTO `t_role_autho` VALUES ('1', '21');
INSERT INTO `t_role_autho` VALUES ('27', '12');
INSERT INTO `t_role_autho` VALUES ('27', '13');
INSERT INTO `t_role_autho` VALUES ('27', '14');
INSERT INTO `t_role_autho` VALUES ('27', '15');
INSERT INTO `t_role_autho` VALUES ('27', '16');
INSERT INTO `t_role_autho` VALUES ('27', '20');
INSERT INTO `t_role_autho` VALUES ('27', '21');
INSERT INTO `t_role_autho` VALUES ('2', '1');
INSERT INTO `t_role_autho` VALUES ('2', '2');
INSERT INTO `t_role_autho` VALUES ('2', '3');
INSERT INTO `t_role_autho` VALUES ('2', '5');
INSERT INTO `t_role_autho` VALUES ('2', '10');
INSERT INTO `t_role_autho` VALUES ('2', '21');
INSERT INTO `t_role_autho` VALUES ('25', '1');
INSERT INTO `t_role_autho` VALUES ('25', '2');
INSERT INTO `t_role_autho` VALUES ('25', '3');
INSERT INTO `t_role_autho` VALUES ('26', '5');
INSERT INTO `t_role_autho` VALUES ('26', '10');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名称',
  `user_sex` int(2) DEFAULT NULL COMMENT '用户性别  0男  1女',
  `user_login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户登陆名',
  `user_login_pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户登陆密码',
  `user_tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户电话',
  `user_mail` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'E—mail',
  `user_photo` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '照片',
  `user_state` int(2) DEFAULT NULL COMMENT '用户状态 0正常 1可用',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '冯涛susie', '0', 'admin', 'admin', '1784896486', '789444657@qq.com', '/upload/6ddd99bc6e9743e0afc06c7da55e565e.JPG', '0');
INSERT INTO `t_user` VALUES ('2', '冯涛', '0', 'user', 'user', '18347476196', '17684896411@qq.com', '/upload/50c852d3a6424df8b2ab8d98ca38615f.jpg', '0');
INSERT INTO `t_user` VALUES ('6', '冯涛', '0', 'susie123', '123456', '17684896486', '2687444281@qq.com', '/upload/9b00454f114f43fca00c51877c758408.jpg', '1');
INSERT INTO `t_user` VALUES ('8', '', '0', 'ftuser', '123456', '', '1134926410@qq.com', '/upload/1d47241d1ba243b7a5ae8e8f880f8f7a.jpg', '0');
