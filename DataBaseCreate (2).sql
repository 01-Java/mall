CREATE TABLE `brand`(
	`brand_id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '品牌唯一标识',
	`name` VARCHAR(255) NOT NULL COMMENT '品牌名'
);

CREATE TABLE `details`(
	`details_id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '商品详情唯一标识',
	`suitable_people` VARCHAR(128) DEFAULT NULL COMMENT '适用人群',
	`suitable_season` VARCHAR(128) DEFAULT NULL COMMENT '适用季节',
	`suitable_scene` VARCHAR(128) DEFAULT NULL COMMENT '适用场景',
	`style` VARCHAR(128) DEFAULT NULL COMMENT '风格'
);

CREATE TABLE `sloper`(
	`sloper_id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '版型唯一标识',
	`type` VARCHAR(20) NOT NULL COMMENT '版型值'
);

CREATE TABLE `spu`(
	`spu_id` INT PRIMARY KEY AUTO_INCREMENT COMMENT 'spu唯一标识',
	`name` VARCHAR(255) DEFAULT NULL COMMENT '商品名称',
	`brand_id` INT DEFAULT NULL COMMENT '品牌id，与品牌表相关联',
	`details_id` INT DEFAULT NULL COMMENT '详情id，与商品详情表相关联',
	`sloper_id` INT DEFAULT NULL COMMENT '版型id,与版型表相关联',
	`description` VARCHAR(255) DEFAULT 'sorry , no description' COMMENT '商品描述',
	`is_active` INT DEFAULT 0 COMMENT '商品是否上架，若上架为1，未上架为0',
	FOREIGN KEY (brand_id) REFERENCES brand(brand_id),
	FOREIGN KEY (details_id) REFERENCES details(details_id),
	FOREIGN KEY (sloper_id) REFERENCES sloper(sloper_id)
);

CREATE TABLE `sku`(
	`sku_id` INT PRIMARY KEY AUTO_INCREMENT COMMENT 'sku唯一标识',
	`spu_id` INT DEFAULT NULL COMMENT 'spu唯一标识，用于sku表与spu表的关联',
	`color_id` INT DEFAULT NULL COMMENT '颜色表id，与颜色表相关联',
	`size_id` INT DEFAULT NULL COMMENT '尺码表id，与尺码表相关联',
	`respository` INT DEFAULT 0 COMMENT '商品库存',
	FOREIGN KEY (spu_id) REFERENCES spu(spu_id)
);

CREATE TABLE `products`(
	`product_id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '商品唯一标识',
	`sku_id` INT NOT NULL COMMENT 'sku唯一标识，用于商品表与sku表的关联', 
	`spu_id` INT NOT NULL COMMENT 'spu唯一标识，用于商品表与spu表的关联', 
	`price` DOUBLE DEFAULT NULL COMMENT '价格',
	`sales` INT DEFAULT NULL COMMENT '销量',
	FOREIGN KEY (sku_id) REFERENCES sku(sku_id),
	FOREIGN KEY (spu_id) REFERENCES spu(spu_id)
);

CREATE TABLE `comment`(
	`comment_id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '评论唯一标识',
	`content` VARCHAR(512) DEFAULT NULL COMMENT '评论内容',
	`product_id`INT NOT NULL COMMENT '商品唯一标识，表示指定商品的评论',
	`time` DATETIME NOT NULL COMMENT '评论时间',
	FOREIGN KEY (product_id) REFERENCES products(product_id)
);

CREATE TABLE `picture`(
	`picture_id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '图片唯一标识',
	`url` VARCHAR(512) DEFAULT NULL COMMENT '图片地址',
	`product_id`INT NOT NULL COMMENT '商品唯一标识，表示指定商品的图片',
	FOREIGN KEY (product_id) REFERENCES products(product_id)
);

CREATE TABLE `user_info`(
	`user_id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '用户唯一标识',
	`phone` VARCHAR(255) DEFAULT NULL COMMENT '电话',
	`password` VARCHAR(128) DEFAULT '123456' COMMENT '密码',
	`name` VARCHAR(20) DEFAULT NULL COMMENT '姓名',
	`sex` VARCHAR(20) DEFAULT NULL CHECK(sex IN('male','female')) COMMENT '性别',
	`address1` VARCHAR(255) DEFAULT NULL COMMENT '地址1',
	`address2` VARCHAR(255) DEFAULT NULL COMMENT '地址2',
	`address3` VARCHAR(255) DEFAULT NULL COMMENT '地址3',
	`email` VARCHAR(255) DEFAULT NULL COMMENT '邮箱',
	`description` VARCHAR(255) DEFAULT '这个人很懒，什么都没留下' COMMENT '个人简介'
);


CREATE TABLE `order`(
	`order_id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '订单唯一标识',
	`status` INT NOT NULL DEFAULT '1' COMMENT '订单状态 1待付款 2待发货 3已发货 4派送中 5已送达 6已取消 7退款',
	`user_id` INT NOT NULL COMMENT '下单用户',
	`product_id` INT NOT NULL COMMENT '商品编号',
	`product_number` INT NOT NULL COMMENT '数目',
	`amount` DOUBLE NOT NULL COMMENT '金额',
	`order_time` DATETIME NOT NULL COMMENT '下单时间',
	`address` VARCHAR(255) DEFAULT NULL COMMENT '地址',
	`phone` VARCHAR(255) DEFAULT NULL COMMENT '手机号',
	`consignee` VARCHAR(255) DEFAULT NULL COMMENT '收货人',
	FOREIGN KEY (user_id) REFERENCES user_info(user_id),
	FOREIGN KEY (product_id) REFERENCES products(product_id)
);
CREATE TABLE `recommend`(
	`product_id` INT NOT NULL COMMENT '商品唯一标识',
	`price` DOUBLE DEFAULT NULL COMMENT '价格',
    `url` VARCHAR(512) DEFAULT NULL COMMENT '图片地址',
    `style` VARCHAR(128) DEFAULT NULL COMMENT '风格',
	FOREIGN KEY (product_id) REFERENCES products(product_id),
    FOREIGN KEY (url) REFERENCES picture(url),
    FOREIGN KEY (style) REFERENCES details(style)
);
CREATE TABLE `cart`(
	`cart_id` INT PRIMARY KEY AUTO_INCREMENT COMMENT '购物车唯一标识符',
	`user_id` INT COMMENT '关联到用户表，标识购物车所属的用户',
	`product_id` INT COMMENT '关联到商品表，标识购物车内添加的商品',
	`sku_id` INT COMMENT '关联到sku表，标识购物车内添加的商品的具体选择的信息',
	`product_number` INT NOT NULL COMMENT '商品数目',
	`add_time` DATETIME NOT NULL COMMENT '加入购物车时间',
	FOREIGN KEY (user_id) REFERENCES user_info(user_id),
	FOREIGN KEY (product_id) REFERENCES products(product_id),
	FOREIGN KEY (sku_id) REFERENCES sku(sku_id)
);



