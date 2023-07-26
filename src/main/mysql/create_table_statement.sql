CREATE TABLE `article` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `regDate` date NOT NULL,
  `title` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `body` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `memberId` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `hit` int(1) unsigned zerofill NOT NULL,
  `recommend` int(1) unsigned zerofill NOT NULL,
  `parkId` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `park_info_idx` (`parkId`),
  CONSTRAINT `park_info` FOREIGN KEY (`parkId`) REFERENCES `park_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `article_reply` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `regDate` date NOT NULL,
  `body` char(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `memberId` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `articleId` int unsigned NOT NULL,
  `recommend` int unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `articleId` (`articleId`),
  CONSTRAINT `article_reply_ibfk_1` FOREIGN KEY (`articleId`) REFERENCES `article` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `games` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `stadium` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `dateAndTime` datetime NOT NULL,
  `opponent_club_num` int DEFAULT NULL,
  `home_club_num` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `member` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `preferred_team_num` int unsigned DEFAULT '10',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `park_info` (
  `id` int unsigned NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `address` tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `food` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `traffic_busstop` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `traffic_bus` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `traffic_sub` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `traffic_parking` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `park_infocol` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `recommend_list` (
  `article_id` int NOT NULL,
  `member_user_id` varchar(45) COLLATE utf8mb4_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `reservations` (
  `reservationID` int NOT NULL AUTO_INCREMENT,
  `gameID` int NOT NULL,
  `seatType` char(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `seatBlock` int DEFAULT NULL,
  `userID` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `seat_id` int unsigned NOT NULL,
  PRIMARY KEY (`reservationID`)
) ENGINE=InnoDB AUTO_INCREMENT=120 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `seats` (
  `seat_id` int unsigned NOT NULL AUTO_INCREMENT,
  `game_id` int unsigned NOT NULL,
  `seat_type` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `seat_block` int unsigned NOT NULL,
  `seat_column` int unsigned NOT NULL,
  `seat_row` int unsigned NOT NULL,
  `status` tinyint unsigned NOT NULL DEFAULT '0' COMMENT 'status = 1\n-> reservation available\n\nstatus = 0\n-> reserved',
  PRIMARY KEY (`seat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=99226 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `seatType` (
  `seat_type_id` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `seatType` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `weekdayPrice` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `weekendPrice` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `block_scope` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`seatType`,`seat_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
