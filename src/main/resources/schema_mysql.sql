CREATE TABLE IF NOT EXISTS `notification` (
  `id` int NOT NULL,
  `user_id` int DEFAULT '0',
  `send_id` int DEFAULT '0',
  `pet_id` int DEFAULT '0',
  `msg` varchar(100) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  `isread` tinyint DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `isread_UNIQUE` (`isread`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
