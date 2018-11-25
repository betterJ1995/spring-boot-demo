/*
 Navicat MySQL Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : spring_cloud

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 25/11/2018 22:49:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `business_id` int(11) NOT NULL COMMENT '商家id',
  `price` decimal(12, 2) NOT NULL DEFAULT 0.00 COMMENT '价格',
  `num` int(11) NOT NULL DEFAULT 0 COMMENT '数量',
  `detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '详情',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 1, 99.00, 0, '详情');
INSERT INTO `product` VALUES (2, 1, 44.00, 3, '学会撒娇觉得');
INSERT INTO `product` VALUES (3, 11, 10.00, 5, '测试11101');
INSERT INTO `product` VALUES (4, 11, 10.00, 5, '测试11101');
INSERT INTO `product` VALUES (5, 11, 10.00, 5, '测试不加事务');
INSERT INTO `product` VALUES (6, 11, 10.00, 5, '测试不加事务');
INSERT INTO `product` VALUES (7, 11, 10.00, 5, '测试不加事务');
INSERT INTO `product` VALUES (8, 11, 10.00, 5, '测试不加事务');

-- ----------------------------
-- Table structure for product_order
-- ----------------------------
DROP TABLE IF EXISTS `product_order`;
CREATE TABLE `product_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL COMMENT '买家id',
  `business_id` int(11) NOT NULL COMMENT '卖家id',
  `amount` decimal(12, 2) NOT NULL DEFAULT 0.00 COMMENT '订单金额',
  `pay_status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '支付状态  0待支付 1已支付',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_business
-- ----------------------------
DROP TABLE IF EXISTS `user_business`;
CREATE TABLE `user_business`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `balance` decimal(12, 2) NOT NULL DEFAULT 0.00 COMMENT '余额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商家表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_customer
-- ----------------------------
DROP TABLE IF EXISTS `user_customer`;
CREATE TABLE `user_customer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `balance` decimal(12, 2) NOT NULL DEFAULT 0.00 COMMENT '余额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '买家表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
