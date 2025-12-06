-- 创建数据库（如果不存在）
CREATE DATABASE IF NOT EXISTS campus_lost CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 使用数据库
USE campus_lost;

-- 用户表
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `account` varchar(50) NOT NULL UNIQUE,
  `password` varchar(100) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `role` varchar(20) NOT NULL DEFAULT 'USER',
  `status` varchar(20) NOT NULL DEFAULT 'NORMAL',
  `create_time` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 分类表
CREATE TABLE IF NOT EXISTS `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `sort` int NOT NULL DEFAULT '0',
  `create_time` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 失物/招领信息表
CREATE TABLE IF NOT EXISTS `lost_found_post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(10) NOT NULL COMMENT 'LOST/FOUND',
  `title` varchar(200) NOT NULL,
  `category_id` bigint NOT NULL,
  `tags` varchar(200) DEFAULT NULL,
  `content` text NOT NULL,
  `happen_time` bigint NOT NULL,
  `location_text` varchar(200) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'PENDING',
  `user_id` bigint NOT NULL,
  `audit_reason` varchar(200) DEFAULT NULL,
  `create_time` bigint NOT NULL,
  `update_time` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_category_id` (`category_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 信息图片表
CREATE TABLE IF NOT EXISTS `post_image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `post_id` bigint NOT NULL,
  `url` varchar(500) NOT NULL,
  `sort` int NOT NULL DEFAULT '0',
  `create_time` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_post_id` (`post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 留言表
CREATE TABLE IF NOT EXISTS `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `post_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `content` text NOT NULL,
  `parent_id` bigint DEFAULT NULL,
  `create_time` bigint NOT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_post_id` (`post_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 站内信表
CREATE TABLE IF NOT EXISTS `message` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `from_user` bigint NOT NULL,
  `to_user` bigint NOT NULL,
  `content` text NOT NULL,
  `create_time` bigint NOT NULL,
  `read_flag` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `idx_from_user` (`from_user`),
  KEY `idx_to_user` (`to_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 举报表
CREATE TABLE IF NOT EXISTS `report` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `post_id` bigint NOT NULL,
  `reporter_id` bigint NOT NULL,
  `reason` varchar(100) NOT NULL,
  `detail` varchar(500) DEFAULT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'PENDING',
  `handler_id` bigint DEFAULT NULL,
  `handle_result` varchar(100) DEFAULT NULL,
  `handle_note` varchar(500) DEFAULT NULL,
  `create_time` bigint NOT NULL,
  `handle_time` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_post_id` (`post_id`),
  KEY `idx_reporter_id` (`reporter_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 插入分类数据
INSERT INTO category (id, name, description, sort, create_time) VALUES 
(1, '证件', '身份证、学生证、银行卡等', 1, UNIX_TIMESTAMP()*1000),
(2, '电子产品', '手机、电脑、平板等', 2, UNIX_TIMESTAMP()*1000),
(3, '钥匙', '宿舍钥匙、车钥匙等', 3, UNIX_TIMESTAMP()*1000),
(4, '书籍', '教材、小说、笔记等', 4, UNIX_TIMESTAMP()*1000),
(5, '衣物', '衣服、鞋子、包包等', 5, UNIX_TIMESTAMP()*1000),
(6, '其他', '其他物品', 6, UNIX_TIMESTAMP()*1000);

-- 插入测试用户
INSERT INTO user (id, account, password, nickname, role, status, create_time) VALUES 
(1, 'admin', '123456', '管理员', 'ADMIN', 'NORMAL', UNIX_TIMESTAMP()*1000),
(2, 'user1', 'user123', '张三', 'USER', 'NORMAL', UNIX_TIMESTAMP()*1000),
(3, 'user2', 'user456', '李四', 'USER', 'NORMAL', UNIX_TIMESTAMP()*1000),
(4, 'user3', 'user789', '王五', 'USER', 'NORMAL', UNIX_TIMESTAMP()*1000),
(5, 'user4', 'user000', '赵六', 'USER', 'NORMAL', UNIX_TIMESTAMP()*1000),
(6, 'user5', 'user111', '钱七', 'USER', 'BANNED', UNIX_TIMESTAMP()*1000);

-- 插入测试失物/拾到信息
INSERT INTO lost_found_post (id, type, title, category_id, tags, content, happen_time, location_text, lat, lng, status, user_id, audit_reason, create_time, update_time) VALUES
(1, 'LOST', '丢失黑色钱包', 1, '钱包,证件', '在图书馆自习室丢失一个黑色钱包，内有身份证和银行卡', UNIX_TIMESTAMP()*1000-86400000, '图书馆一楼自习室', 34.7687, 113.6512, 'PUBLISHED', 2, NULL, UNIX_TIMESTAMP()*1000-86400000, UNIX_TIMESTAMP()*1000-86400000),
(2, 'FOUND', '拾到银色手机', 2, '手机,iPhone', '在食堂二楼拾到一部银色iPhone，请失主联系', UNIX_TIMESTAMP()*1000-172800000, '第一食堂二楼', 34.7691, 113.6521, 'PUBLISHED', 3, NULL, UNIX_TIMESTAMP()*1000-172800000, UNIX_TIMESTAMP()*1000-172800000),
(3, 'LOST', '丢失宿舍钥匙', 3, '钥匙', '丢失一把宿舍钥匙，上面挂着一个小熊挂件', UNIX_TIMESTAMP()*1000-259200000, '宿舍楼A栋', 34.7702, 113.6508, 'PUBLISHED', 4, NULL, UNIX_TIMESTAMP()*1000-259200000, UNIX_TIMESTAMP()*1000-259200000),
(4, 'FOUND', '拾到Java教材', 4, '书籍,教材', '在教学楼B座拾到一本《Java核心技术》', UNIX_TIMESTAMP()*1000-345600000, '教学楼B座201教室', 34.7675, 113.6533, 'PUBLISHED', 5, NULL, UNIX_TIMESTAMP()*1000-345600000, UNIX_TIMESTAMP()*1000-345600000),
(5, 'LOST', '丢失蓝色外套', 5, '外套,衣服', '在体育馆丢失一件蓝色羽绒服', UNIX_TIMESTAMP()*1000-432000000, '体育馆', 34.7668, 113.6495, 'PUBLISHED', 2, NULL, UNIX_TIMESTAMP()*1000-432000000, UNIX_TIMESTAMP()*1000-432000000),
(6, 'FOUND', '拾到U盘', 6, 'U盘,存储设备', '在实验室拾到一个红色U盘', UNIX_TIMESTAMP()*1000-518400000, '计算机学院实验室', 34.7698, 113.6518, 'PENDING', 3, NULL, UNIX_TIMESTAMP()*1000-518400000, UNIX_TIMESTAMP()*1000-518400000);

-- 插入测试图片
INSERT INTO post_image (id, post_id, url, sort, create_time) VALUES
(1, 1, '/images/wallet.jpg', 0, UNIX_TIMESTAMP()*1000),
(2, 2, '/images/iphone.jpg', 0, UNIX_TIMESTAMP()*1000),
(3, 3, '/images/key.jpg', 0, UNIX_TIMESTAMP()*1000),
(4, 4, '/images/book.jpg', 0, UNIX_TIMESTAMP()*1000);

-- 插入测试留言
INSERT INTO comment (id, post_id, user_id, content, parent_id, create_time, deleted) VALUES
(1, 1, 3, '我在图书馆看到过这个钱包，好像是在座位上', NULL, UNIX_TIMESTAMP()*1000-43200000, 0),
(2, 1, 2, '谢谢提醒，我去确认一下', NULL, UNIX_TIMESTAMP()*1000-43000000, 0),
(3, 2, 2, '是我的手机，已经找到，谢谢！', NULL, UNIX_TIMESTAMP()*1000-129600000, 0),
(4, 3, 4, '我已经找到了，谢谢大家', NULL, UNIX_TIMESTAMP()*1000-216000000, 0);

-- 插入测试站内信
INSERT INTO message (id, from_user, to_user, content, create_time, read_flag) VALUES
(1, 3, 2, '关于您丢失的钱包，我在图书馆看到过，可以联系我详细确认', UNIX_TIMESTAMP()*1000-43200000, 1),
(2, 2, 3, '好的，我现在就去图书馆确认，谢谢您的帮助', UNIX_TIMESTAMP()*1000-43000000, 1),
(3, 2, 3, '确实是我的钱包，非常感谢！', UNIX_TIMESTAMP()*1000-42000000, 1);

-- 插入测试举报
INSERT INTO report (id, post_id, reporter_id, reason, detail, status, handler_id, handle_result, handle_note, create_time, handle_time) VALUES
(1, 5, 3, '虚假信息', '这件外套是我朋友的，不是丢失的', 'PROCESSED', 1, 'OFFLINE', '经核实为虚假信息，已下架', UNIX_TIMESTAMP()*1000-216000000, UNIX_TIMESTAMP()*1000-215000000);