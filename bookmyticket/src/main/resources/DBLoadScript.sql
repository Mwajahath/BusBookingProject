
CREATE TABLE `booking`(
                          `booking_id` varchar(255) NOT NULL,
                          `bus_id` varchar (225) DEFAULT NULL,
                          `bus_name` varchar(255) DEFAULT NULL,
                          `user_email_id` varchar(255) DEFAULT NULL,
                          `user_id` varchar(255) DEFAULT NULL,
                          `user_name` varchar(255) DEFAULT NULL,
                          `booking_date` varchar(255) DEFAULT NULL,
                          `create_date` varchar(255) DEFAULT NULL,
                          PRIMARY KEY (`booking_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bus` (
                       `id` varchar(255) NOT NULL,
                       `bus_name` varchar(255) DEFAULT NULL,
                       `source` varchar(255) DEFAULT NULL,
                       `destination` varchar(255) DEFAULT NULL,
                       PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `user` (
                        `email_id` varchar(255) NOT NULL,
                        `created_date` varchar(255) DEFAULT NULL,
                        `dob` varchar(255) DEFAULT NULL,
                        `first_name` varchar(255) DEFAULT NULL,
                        `last_name` varchar(255) DEFAULT NULL,
                        `mobile` varchar(255) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `salt` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_auth_token` (
                                   `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                   `access_token` varchar(1000) DEFAULT NULL,
                                   `expires_at` datetime DEFAULT NULL,
                                   `login_at` datetime DEFAULT NULL,
                                   `logout_at` datetime DEFAULT NULL,
                                   `user_id` varchar(255) DEFAULT NULL,
                                   PRIMARY KEY (`id`),
                                   KEY `FKsgoqgsfs8lfll3g069mei5l13` (`user_id`),
                                   CONSTRAINT `FKsgoqgsfs8lfll3g069mei5l13` FOREIGN KEY (`user_id`) REFERENCES `user` (`email_id`)
)ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



INSERT INTO `bus` (`id`,`bus_Name`,`source`,`destination`) VALUES ("UUID-1","Rajdhani Express","HYDERABAD","BANGLORE"),("UUID-2","Garuda","HYDERABAD","BANGLORE"), ("UUID-3","TSRTC","HYDERABAD","CHENNAI"),("UUID-4","NAIN","HYDERABAD","CHENNAI"),("UUID-5","Garuda","HYDERABAD","BANGLORE"),("UUID-6","SAMA EXPRESS","BANGLORE","HYDERABAD");
INSERT INTO `bus` (`id`,`bus_Name`,`source`,`destination`) VALUES ("UUID-7","NEHAL TRAVELS","BANGLORE","HYDERABAD"),("UUID-8","TSRTC","BANGLORE","CHENNAI"),("UUID-9","Rajdhani Express","BANGLORE","HYDERABAD"),("UUID-10","Garuda","BANGLORE","CHENNAI"),("UUID-11","SAMA EXPRESS","BANGLORE","HYDERABAD"),("12","RajdhaniExpress","BANGLORE","HYDERABAD");
INSERT INTO `bus` (`id`,`bus_Name`,`source`,`destination`) VALUES ("UUID-13","NEHAL TRAVELS","CHENNAI","HYDERABAD"),("UUID-14","TSRTC","CHENNAI","HYDERABAD"),("UUID-15","Rajdhani Express","CHENNAI","HYDERABAD"),("UUID-16","Garuda","CHENNAI","BANGLORE"),("UUID-17","SAMA EXPRESS","CHENNAI","HYDERABAD"),("18","RajdhaniExpress","CHENNAI","BANGLORE");