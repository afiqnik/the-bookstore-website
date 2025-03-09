CREATE TABLE `product`
(
    `id`              bigint NOT NULL AUTO_INCREMENT,
    `title`           varchar(255) DEFAULT NULL,
    `author`          varchar(255) DEFAULT NULL,
    `publisher`       varchar(255) DEFAULT NULL,
    `published_date`  datetime(6) DEFAULT NULL,
    `description`     text,
    `isbn_identifier` varchar(255) DEFAULT NULL,
    `page_Count`      int          DEFAULT NULL,
    `categories`      varchar(255) DEFAULT NULL,
    `language`        varchar(255) DEFAULT NULL,
    `image_links`     varchar(255) DEFAULT NULL,
    `list_Price` DOUBLE DEFAULT NULL,
    `retail_Price` DOUBLE DEFAULT NULL,
    `is_Bestseller`   tinyint(1) DEFAULT NULL,
    `is_New_Arrival`  tinyint(1) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=234 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
