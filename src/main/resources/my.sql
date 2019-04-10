--
SET FOREIGN_KEY_CHECKS=0;
--
-- 用户表
CREATE TABLE  IF NOT EXISTS `user` (
  `userId` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(255),
  `phone` varchar(11),
  `password` varchar(16)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
-- 商品表
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
`productId` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '商品主键',
`categoryId` int(11) NOT NULL COMMENT '类别',
`productName` varchar(100) NOT NULL COMMENT '商品名称',
`productPrice` decimal(16,4) NOT NULL COMMENT '商品价格',
`stock` int(16) NOT NULL COMMENT '库存',
`describe` varchar(255) COMMENT '描述',
`picture` longtext COMMENT '图片'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='商品表';
-- 类别表
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `categoryId` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '类别主键',
  `categoryName` varchar(255) COMMENT '类别名'
) DEFAULT CHARSET=utf8 COMMENT='用户表';
-- 订单表
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '订单主键（订单号）',
  `userId` int (11) NOT NULL COMMENT '用户主键',
  `addressId` int(11) NOT NULL COMMENT '收货地址主键',
  `sales` decimal(16,4) COMMENT '销售额',
  `createDate` datetime NOT NULL COMMENT '创建时间（下单时间）',
  `payDate` datetime COMMENT '付款时间',
  `deliveryDate` datetime COMMENT '开始送货时间',
  `confirmDate` datetime COMMENT '确认送达时间',
  `describe` varchar(255) COMMENT '描述',
  `status` int (11) NOT NULL DEFAULT 0 COMMENT '订单状态（0：待支付，1：待派送，2：撤销中，3：派送中，4：已完成）'
)DEFAULT CHARSET=utf8 COMMENT='订单表';
-- 购物车表
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cartId` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '购物车主键',
  `userId` int(11) NOT NULL COMMENT '用户主键（所属用户）',
  `productId` int(11) COMMENT '商品主键',
  `number` int(16) COMMENT '购买数量'
) DEFAULT CHARSET=utf8 COMMENT='购物车表';
-- 用户收货地址表
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `addressId` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '收货地址主键',
  `address` varchar(255) COMMENT '详细收货地址',
  `recipient` varchar(10) COMMENT '收件人',
  `recipientPhone` varchar(11) COMMENT '收件人电话',
  `userId` int(11) NOT NULL COMMENT '用户主键'
)DEFAULT CHARSET=utf8 COMMENT='收货地址表';