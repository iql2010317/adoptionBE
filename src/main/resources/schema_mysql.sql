
CREATE TABLE IF NOT EXISTS `notification` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT '0',
  `send_id` int DEFAULT '0',
  `pet_id` varchar(45) DEFAULT NULL,
  `notifi_contain` varchar(100) DEFAULT NULL,
  `msg` varchar(100) DEFAULT NULL,
  `isread` tinyint DEFAULT '0',
  `date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
