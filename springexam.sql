/*
 Navicat Premium Data Transfer

 Source Server         : 2
 Source Server Type    : MySQL
 Source Server Version : 100119
 Source Host           : localhost:3306
 Source Schema         : springexam

 Target Server Type    : MySQL
 Target Server Version : 100119
 File Encoding         : 65001

 Date: 04/07/2018 13:01:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for houseinfo
-- ----------------------------
DROP TABLE IF EXISTS `houseinfo`;
CREATE TABLE `houseinfo`  (
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `holdnum` int(5) NULL DEFAULT NULL,
  `price` int(10) NULL DEFAULT NULL,
  `ownerid` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `statusnote` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of houseinfo
-- ----------------------------
INSERT INTO `houseinfo` VALUES ('后街', '单间', 2, 400, '1234', '可供出租', '无', '1-200-1234-后街');
INSERT INTO `houseinfo` VALUES ('后街', '单间', 1, 500, '1234', '可供出租', '无', '1-400-1234-后街');
INSERT INTO `houseinfo` VALUES ('后街', '单间', 1, 400, '1235', '可供出租', '无', '1-400-1235-后街');
INSERT INTO `houseinfo` VALUES ('集美大道668号', '套房', 2, 800, '1234', '可供出租', '无', '2-800-1234-集美大道668号');
INSERT INTO `houseinfo` VALUES ('磐基名品中心12楼', '整层', 28, 30000, '1234', '可供出租', '无', '28-30000-1234-磐基名品中心12楼');
INSERT INTO `houseinfo` VALUES ('西街', '套房', 4, 2100, '1234', '不可出租', '我就挂着不租出去你能把我咋滴。╭(╯^╰)╮', '4-2100-1234-西街');
INSERT INTO `houseinfo` VALUES ('美岁天地楼下', '胶囊', 1, 200, '1234', '可供出租', '无', '1-200-1234-美岁天地');
INSERT INTO `houseinfo` VALUES ('厦门北站', '复式', 4, 6000, '1234', '可供出租', '无', '4-6000-1234-厦门北站');
INSERT INTO `houseinfo` VALUES ('美岁天地', '整层', 20, 13000, '1234', '不可出租', '太贵了你们这群穷逼肯定租不起', '20-13000-1234-美岁天地');
INSERT INTO `houseinfo` VALUES ('西街', '套房', 4, 3200, '1234', '可供出租', '无', '4-3200-1234-西街');
INSERT INTO `houseinfo` VALUES ('美岁天地', '单间', 1, 1000, '1234', '可供出租', '无', '1-1000-1234-美岁天地');
INSERT INTO `houseinfo` VALUES ('鼓浪屿钢琴码头', '别墅', 5, 12000, '1236', '可供出租', '无', '5-12000-1236-鼓浪屿钢琴码头');
INSERT INTO `houseinfo` VALUES ('虹桥机场', '套房', 4, 8000, '1234', '可供出租', '无', '4-8000-1234-虹桥机场');

-- ----------------------------
-- Table structure for meetinginfo
-- ----------------------------
DROP TABLE IF EXISTS `meetinginfo`;
CREATE TABLE `meetinginfo`  (
  `time` datetime(0) NULL DEFAULT NULL,
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `ownername` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `ownertel` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `studentname` varchar(25) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `studenttel` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `studentgender` varchar(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `finsh` varchar(1) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `houseid` varchar(225) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of meetinginfo
-- ----------------------------
INSERT INTO `meetinginfo` VALUES ('2018-06-18 17:43:12', '后街', '王大力', '1234567', '蔡小菜', '1234567', 'f', 'Y', '1-400-1234-后街');
INSERT INTO `meetinginfo` VALUES ('2018-05-18 18:16:30', '美岁天地', '王大力', '1234567', '蔡小菜', '1234567', 'f', 'Y', '2-800-1234-集美大道668号');
INSERT INTO `meetinginfo` VALUES ('2018-06-18 18:33:29', '磐基名品中心12楼', '王大力', '1234567', '蔡小菜', '1234567', 'f', 'Y', '28-30000-1234-磐基名品中心12楼');
INSERT INTO `meetinginfo` VALUES ('2018-06-19 13:15:25', '美岁天地', '王大力', '1234567', '韩大狗', '13176543232', 'm', 'Y', '1-1000-1234-美岁天地');
INSERT INTO `meetinginfo` VALUES ('2018-06-19 13:25:54', '鼓浪屿钢琴码头', '李二狗', '76543231', '韩大狗', '13176543232', 'm', 'Y', '5-12000-1236-鼓浪屿钢琴码头');
INSERT INTO `meetinginfo` VALUES ('2018-07-01 11:12:08', '虹桥机场', '王大力', '1234567', '蔡小菜', '1234567', 'f', 'N', '4-8000-1234-虹桥机场');

-- ----------------------------
-- Table structure for owner
-- ----------------------------
DROP TABLE IF EXISTS `owner`;
CREATE TABLE `owner`  (
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of owner
-- ----------------------------
INSERT INTO `owner` VALUES ('王大力', '集美大道668号', '1234567', '1234', '123456');
INSERT INTO `owner` VALUES ('王小力', '集美大道668号', '1234567', '1235', '1235');
INSERT INTO `owner` VALUES ('李二狗', '天上人间', '76543231', '1236', '123456');
INSERT INTO `owner` VALUES ('金鑫鑫', '汤臣一品A栋', '1388888888', '1237', '123456');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `tel` varchar(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `birthday` int(8) NULL DEFAULT NULL,
  `gender` varchar(1) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  `id` varchar(7) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(25) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('蔡小菜', '集美大道668号', '1234567', 19980701, 'f', '199807f', '123456');
INSERT INTO `student` VALUES ('韩大狗', '天上人间', '13176543232', 19980722, 'm', '199807m', '123456');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test`  (
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `id` int(5) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('test success!', 1);
INSERT INTO `test` VALUES ('中文乱码消失！', 2);
INSERT INTO `test` VALUES ('好不好啊', 3);

SET FOREIGN_KEY_CHECKS = 1;
