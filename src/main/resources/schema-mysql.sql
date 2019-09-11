
CREATE TABLE `holes` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `factor` float DEFAULT NULL,
    `latitude` float DEFAULT NULL,
    `longitude` float DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `holes_buffer` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `factor` float DEFAULT NULL,
    `latitude` float DEFAULT NULL,
    `longitude` float DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `sections` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `factor` float DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `sections_buffer` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `factor` float DEFAULT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE `sections_holes` (
    `section_id` bigint(20) NOT NULL,
    `holes_id` bigint(20) NOT NULL,
    UNIQUE KEY (`holes_id`),
    KEY (`section_id`)
);

CREATE TABLE `users` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `authorities` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `second_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `surname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`id`)
);