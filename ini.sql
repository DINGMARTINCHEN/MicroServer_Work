-- 创建数据库
CREATE DATABASE IF NOT EXISTS db2024 CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 使用数据库
USE db2024;

-- 创建支付交易表 t_pay（根据实体类 Pay 中的字段定义）
CREATE TABLE IF NOT EXISTS t_pay (
                                     id INT NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                     pay_no VARCHAR(50) NOT NULL COMMENT '支付流水号',
    order_no VARCHAR(50) NOT NULL COMMENT '订单流水号',
    user_id INT NOT NULL COMMENT '用户账号ID',
    amount DECIMAL(10,2) NOT NULL COMMENT '交易金额',
    deleted TINYINT(1) DEFAULT 0 COMMENT '删除标志（0-未删除，1-已删除）',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (id)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='支付交易表';

-- 可选：插入一条测试数据
INSERT INTO t_pay (pay_no, order_no, user_id, amount) VALUES ('PAY20240001', 'ORD20240001', 1, 19.90);