/*
MySQL Backup
Source Server Version: 8.0.27
Source Database: shop
Date: 3/6/2023 21:35:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `transactions`
-- ----------------------------
DROP TABLE IF EXISTS `transactions`;
CREATE TABLE `transactions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `wallet_id` int NOT NULL,
  `transaction_type` varchar(20) NOT NULL,
  `amount` double NOT NULL,
  `transaction_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `wallet_id` (`wallet_id`),
  CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`wallet_id`) REFERENCES `wallets` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Table structure for `wallets`
-- ----------------------------
DROP TABLE IF EXISTS `wallets`;
CREATE TABLE `wallets` (
  `id` int NOT NULL,
  `user_id` int NOT NULL,
  `balance` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `wallets_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `transactions` VALUES ('125','1','1','10','2023-03-06 19:18:35'), ('126','1','1','10','2023-03-06 19:18:36'), ('127','1','1','1211','2023-03-06 20:13:33'), ('128','1','0','1205','2023-03-06 20:24:14');
INSERT INTO `users` VALUES ('11','test1','1234567678','1212@abc.com');
INSERT INTO `wallets` VALUES ('1','11','1212');
