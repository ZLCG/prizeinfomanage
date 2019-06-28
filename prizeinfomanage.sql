/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : prizeinfomanage

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 28/06/2019 15:14:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES (1, '物联B20161');

-- ----------------------------
-- Table structure for college
-- ----------------------------
DROP TABLE IF EXISTS `college`;
CREATE TABLE `college`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of college
-- ----------------------------
INSERT INTO `college` VALUES (1, '信息学院');

-- ----------------------------
-- Table structure for prizeinfo
-- ----------------------------
DROP TABLE IF EXISTS `prizeinfo`;
CREATE TABLE `prizeinfo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentid` int(11) NULL DEFAULT NULL,
  `sort` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `measure` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of prizeinfo
-- ----------------------------
INSERT INTO `prizeinfo` VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `prizeinfo` VALUES (5, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `prizeinfo` VALUES (6, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `prizeinfo` VALUES (7, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `prizeinfo` VALUES (8, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `prizeinfo` VALUES (9, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `prizeinfo` VALUES (10, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `prizeinfo` VALUES (12, 2, '处分', '警告处分', '给与警告处分', '学期内旷课超过十节', '2019-05-02');
INSERT INTO `prizeinfo` VALUES (13, 2, '奖励', '国家奖学金', '授予国家奖学金', '符合国家奖学金评定条件', '2019-05-02');
INSERT INTO `prizeinfo` VALUES (14, 3, '奖励', '优秀党员', '评为优秀党员', '符合优秀党员评定条件', '2019-05-02');
INSERT INTO `prizeinfo` VALUES (18, 11, '奖励', '扣分', '素测分-5', '夜不归宿', '2019-05-10');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `classname` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `grade` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `college` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (2, '16446101', '123456', '王维', '男', '物联B20161', '16', '信息学院');
INSERT INTO `student` VALUES (3, '16446103', '123456', '王勃', '男', '物联B20161', '16', '信息学院');
INSERT INTO `student` VALUES (11, '16446106', '123456', '李牧', '男', '物联B20161', '16', '信息学院');
INSERT INTO `student` VALUES (12, '16446107', '123456', '鱼玄机', '女', '英语B20151', '15', '外国语学院');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 'libai', '123456', '李白');
INSERT INTO `teacher` VALUES (2, 'dufu', '123456', '杜甫');

SET FOREIGN_KEY_CHECKS = 1;
