CREATE TABLE IF NOT EXISTS `notification` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT '0',
  `send_id` int DEFAULT '0',
  `pet_id` varchar(45) DEFAULT NULL,
  `notifi_contain` varchar(100) DEFAULT NULL,
  `msg` varchar(100) DEFAULT NULL,
  `isread` tinyint DEFAULT '0',
  `date_time` datetime DEFAULT NULL,
  `notifi_type` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `user_info` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `account` varchar(45) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  `profile` varchar(500) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `job_occupation` varchar(45) DEFAULT NULL,
  `family_status` varchar(500) DEFAULT NULL,
  `sentence_to_adopter` varchar(500) DEFAULT NULL,
  `user_photo` mediumblob COMMENT '12.20 更改成MEDIUMBLOB',
  `user_real_name` varchar(45) DEFAULT NULL,
  `permission` int DEFAULT NULL,
  `register_random_string` varchar(45) DEFAULT NULL,
  `random_string_time` datetime DEFAULT NULL,
  `has_opened` tinyint DEFAULT '0' COMMENT '新增認證邏輯 \n0=註冊，未開通\n1=註冊，已開通',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `pet_info` (
  `pet_id` varchar(45) NOT NULL,
  `user_id` int NOT NULL,
  `pet_name` varchar(45) DEFAULT NULL,
  `adopter_id_list` varchar(150) DEFAULT NULL,
  `final_adopter_id` int DEFAULT '0',
  `pet_breed` varchar(45) DEFAULT NULL,
  `pet_status` varchar(45) DEFAULT NULL,
  `adoption_status` varchar(45) DEFAULT NULL,
  `adoption_conditions` varchar(200) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `vaccine` varchar(45) DEFAULT NULL,
  `pet_profile` varchar(150) DEFAULT NULL,
  `ligation` tinyint DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `pet_photo` mediumblob COMMENT '12.20 pet_photo 更改為MEDIUMBLOB',
  `pet_other_photo` varchar(500) DEFAULT NULL,
  `location` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`pet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `map_search` (
  `serial_no` int NOT NULL AUTO_INCREMENT,
  `area` varchar(10) DEFAULT NULL,
  `city` varchar(10) DEFAULT NULL,
  `nature` varchar(20) DEFAULT NULL,
  `animal_species` varchar(20) DEFAULT NULL,
  `institution_name` varchar(20) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `business_hours` varchar(45) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `website` varchar(500) DEFAULT NULL,
  `img` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE IF NOT EXISTS `post_comment` (
  `comment_id` int NOT NULL AUTO_INCREMENT,
  `post_serial_no` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `comment_content` varchar(500) DEFAULT NULL,
  `comment_time` datetime DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `new_info` (
  `serial_no` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `image` mediumblob,
  `type` varchar(45) DEFAULT NULL COMMENT '12.27新增分類：新聞、科普',
  PRIMARY KEY (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `chat_message` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ent` int DEFAULT NULL,
  `time_stamp` datetime NOT NULL,
  `chat_room_id` varchar(45) NOT NULL,
  `sender` int NOT NULL,
  `text` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `chat_room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ent` int NOT NULL,
  `chat_room_id` varchar(45) NOT NULL,
  `last_time_stamp` datetime DEFAULT NULL,
  `last_message` varchar(200) DEFAULT NULL,
  `last_sender` int DEFAULT '0',
  `name` varchar(45) DEFAULT NULL,
  `subscriber_list` varchar(100) DEFAULT NULL,
  `creator` int NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `subscriber_list_UNIQUE` (`subscriber_list`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `chat_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sender` int NOT NULL,
  `receiver` int NOT NULL,
  `chat_room_id` varchar(45) NOT NULL,
  `is_read` tinyint DEFAULT '0',
  `read_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `forum_entrance` (
  `serial_no` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `post_content` varchar(500) DEFAULT NULL,
  `post_photo` mediumblob,
  `user_Id` int DEFAULT NULL,
  `post_time` datetime DEFAULT NULL,
  `post_modify_time` datetime DEFAULT NULL,
  `likes_count` int DEFAULT '0',
  PRIMARY KEY (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `likes_record` (
  `serial_no` int NOT NULL AUTO_INCREMENT,
  `post_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



