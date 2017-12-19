/*
SQLyog Ultimate v8.32 
MySQL - 5.5.29 : Database - openiot
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`openiot` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `openiot`;

/*Table structure for table `admin_settings` */

DROP TABLE IF EXISTS `admin_settings`;

CREATE TABLE `admin_settings` (
  `id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `key` varchar(50) DEFAULT NULL,
  `json_value` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin_settings` */

/*Table structure for table `attributes_kv_cf` */

DROP TABLE IF EXISTS `attributes_kv_cf`;

CREATE TABLE `attributes_kv_cf` (
  `entity_type` varchar(20) NOT NULL COMMENT '(DEVICE, CUSTOMER, TENANT)',
  `entity_id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `attribute_type` varchar(20) NOT NULL COMMENT '(CLIENT_SIDE, SHARED, SERVER_SIDE)',
  `attribute_key` varchar(30) NOT NULL,
  `bool_v` tinyint(1) DEFAULT NULL,
  `str_v` varchar(100) DEFAULT NULL,
  `long_v` bigint(20) DEFAULT NULL,
  `dbl_v` double DEFAULT NULL,
  `last_update_ts` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`entity_type`,`entity_id`,`attribute_type`,`attribute_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `attributes_kv_cf` */

/*Table structure for table `component_descriptor` */

DROP TABLE IF EXISTS `component_descriptor`;

CREATE TABLE `component_descriptor` (
  `id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `type` varchar(20) NOT NULL COMMENT '("FILTER", "PROCESSOR", "ACTION", "PLUGIN")',
  `scope` varchar(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `search_text` varchar(100) DEFAULT NULL,
  `clazz` varchar(100) NOT NULL,
  `configuration_descriptor` varchar(100) DEFAULT NULL,
  `actions` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`type`,`scope`,`clazz`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `component_descriptor` */

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `tenant_id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `title` varchar(50) DEFAULT NULL,
  `search_text` varchar(100) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `zip` varchar(10) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `additional_info` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`id`,`tenant_id`,`title`,`search_text`,`country`,`state`,`city`,`address`,`address2`,`zip`,`phone`,`email`,`additional_info`) values ('2d64bec7-2c8c-11e7-abdd-23324539a6ad','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','Customer A','Customer a',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('340d2633-2c8c-11e7-a9a8-ad927087b2cc','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','Customer B','Customer b',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('39645701-2c8c-11e7-b572-bb5c081a5519','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','Customer C','Customer c',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `dashboard` */

DROP TABLE IF EXISTS `dashboard`;

CREATE TABLE `dashboard` (
  `id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `tenant_id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `customer_id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `title` varchar(50) DEFAULT NULL,
  `search_text` varchar(100) DEFAULT NULL,
  `configuration` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`tenant_id`,`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dashboard` */

/*Table structure for table `device` */

DROP TABLE IF EXISTS `device`;

CREATE TABLE `device` (
  `id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `tenant_id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `customer_id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `name` varchar(50) DEFAULT NULL,
  `search_text` varchar(100) DEFAULT NULL,
  `additional_info` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`tenant_id`,`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `device` */

insert  into `device`(`id`,`tenant_id`,`customer_id`,`name`,`search_text`,`additional_info`) values ('1af16d81-2c8d-11e7-a436-8f8d5fae8043','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','2d64bec7-2c8c-11e7-abdd-23324539a6ad','Test Device A3','test device a3',NULL),('21265355-2c8d-11e7-9333-0fc10b40f813','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','340d2633-2c8c-11e7-a9a8-ad927087b2cc','Test Device B1','test device b1',NULL),('250b7c68-2c8d-11e7-a535-777323c06f93','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','39645701-2c8c-11e7-b572-bb5c081a5519','Test Device C1','test device c1',NULL),('505f0eac-2c8c-11e7-85d2-038873a99962','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','2d64bec7-2c8c-11e7-abdd-23324539a6ad','Test Device A1','test device a1',NULL),('552fa98d-2c8c-11e7-971f-6f1bc9bae0c6','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','2d64bec7-2c8c-11e7-abdd-23324539a6ad','Test Device A2','test device a2',NULL),('c8f1a6f0-b993-11e6-8a04-9ff4e1b7933c','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','2b00e814-2c8d-11e7-915b-81734b7ca9dc','DHT11 Demo Device','dht11 demo device','{\"description\":\"Demo device that is used in sample applications that upload data from DHT11 temperat'),('c8f1a6f0-b993-11e6-8a04-9ff4e1b7933d','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','2b00e814-2c8d-11e7-915b-81734b7ca9dc','Raspberry Pi Demo Device','raspberry pi demo device','{\"description\":\"Demo device that is used in Raspberry Pi GPIO control sample application\"}');

/*Table structure for table `device_credentials` */

DROP TABLE IF EXISTS `device_credentials`;

CREATE TABLE `device_credentials` (
  `id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `device_id` varchar(50) DEFAULT NULL COMMENT 'timeuuid',
  `credentials_type` varchar(50) DEFAULT NULL,
  `credentials_id` varchar(50) DEFAULT NULL,
  `credentials_value` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `device_credentials` */

insert  into `device_credentials`(`id`,`device_id`,`credentials_type`,`credentials_id`,`credentials_value`) values ('49b26bca-2c8d-11e7-b447-3ba653973234','505f0eac-2c8c-11e7-85d2-038873a99962','ACCESS_TOKEN','A1_TEST_TOKEN',NULL),('4e37a55a-2c8d-11e7-a7fa-dd552e55710d','552fa98d-2c8c-11e7-971f-6f1bc9bae0c6','ACCESS_TOKEN','A2_TEST_TOKEN',NULL),('52750117-2c8d-11e7-8a86-4b0a0a6aadc3','1af16d81-2c8d-11e7-a436-8f8d5fae8043','ACCESS_TOKEN','A3_TEST_TOKEN',NULL),('564c95e8-2c8d-11e7-bc9f-0ddcadf14831','21265355-2c8d-11e7-9333-0fc10b40f813','ACCESS_TOKEN','B1_TEST_TOKEN',NULL),('5a7494a5-2c8d-11e7-a479-731a4fb1a643','250b7c68-2c8d-11e7-a535-777323c06f93','ACCESS_TOKEN','C1_TEST_TOKEN',NULL),('5f0b3479-2c8d-11e7-b847-efb9029b5fdd','c8f1a6f0-b993-11e6-8a04-9ff4e1b7933c','ACCESS_TOKEN','DHT11_DEMO_TOKEN',NULL),('63520537-2c8d-11e7-83a8-3f6b7d8dcb34','c8f1a6f0-b993-11e6-8a04-9ff4e1b7933d','ACCESS_TOKEN','RASPBERRY_PI_DEMO_TOKEN',NULL);

/*Table structure for table `event` */

DROP TABLE IF EXISTS `event`;

CREATE TABLE `event` (
  `tenant_id` varchar(50) NOT NULL COMMENT 'timeuuid (tenant or system)',
  `id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `event_type` varchar(30) NOT NULL,
  `event_uid` varchar(50) NOT NULL,
  `entity_type` varchar(50) NOT NULL COMMENT '(device, customer, rule, plugin)',
  `entity_id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `body` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`tenant_id`,`event_type`,`event_uid`,`entity_type`,`entity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `event` */

/*Table structure for table `plugin` */

DROP TABLE IF EXISTS `plugin`;

CREATE TABLE `plugin` (
  `id` varchar(50) NOT NULL COMMENT 'uuid',
  `tenant_id` varchar(50) NOT NULL COMMENT 'uuid',
  `name` varchar(50) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `search_text` varchar(100) DEFAULT NULL,
  `api_token` varchar(100) DEFAULT NULL,
  `plugin_class` varchar(50) DEFAULT NULL,
  `public_access` tinyint(1) DEFAULT NULL,
  `configuration` varchar(100) DEFAULT NULL,
  `additional_info` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `plugin` */

/*Table structure for table `rule` */

DROP TABLE IF EXISTS `rule`;

CREATE TABLE `rule` (
  `id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `tenant_id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `name` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `search_text` varchar(100) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `plugin_token` varchar(100) DEFAULT NULL,
  `filters` varchar(200) DEFAULT NULL COMMENT 'Format: {"clazz":"A", "name": "Filter A", "configuration": {"types":["TELEMETRY"]}}',
  `processor` varchar(200) DEFAULT NULL COMMENT 'Format: {"clazz":"A", "name": "Processor A", "configuration": null}',
  `action` varchar(200) DEFAULT NULL COMMENT 'Format: {"clazz":"A", "name": "Action A", "configuration": null}',
  `additional_info` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rule` */

/*Table structure for table `tenant` */

DROP TABLE IF EXISTS `tenant`;

CREATE TABLE `tenant` (
  `id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `title` varchar(50) DEFAULT NULL,
  `search_text` varchar(100) DEFAULT NULL,
  `region` varchar(50) NOT NULL,
  `country` varchar(20) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `zip` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `additional_info` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`region`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tenant` */

insert  into `tenant`(`id`,`title`,`search_text`,`region`,`country`,`state`,`city`,`address`,`address2`,`zip`,`phone`,`email`,`additional_info`) values ('089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','Tenant','tenant','Global',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `ts_kv_cf` */

DROP TABLE IF EXISTS `ts_kv_cf`;

CREATE TABLE `ts_kv_cf` (
  `entity_type` varchar(20) NOT NULL COMMENT '(DEVICE, CUSTOMER, TENANT)',
  `entity_id` varchar(50) NOT NULL,
  `key` varchar(50) NOT NULL,
  `partition` varchar(50) NOT NULL,
  `ts` bigint(20) NOT NULL,
  `bool_v` tinyint(1) DEFAULT NULL,
  `str_v` varchar(100) DEFAULT NULL,
  `long_v` bigint(20) DEFAULT NULL,
  `dbl_v` double DEFAULT NULL,
  PRIMARY KEY (`entity_type`,`entity_id`,`key`,`partition`,`ts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_kv_cf` */

/*Table structure for table `ts_kv_latest_cf` */

DROP TABLE IF EXISTS `ts_kv_latest_cf`;

CREATE TABLE `ts_kv_latest_cf` (
  `entity_type` varchar(20) NOT NULL COMMENT '(DEVICE, CUSTOMER, TENANT)',
  `entity_id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `key` varchar(50) NOT NULL,
  `ts` bigint(20) DEFAULT NULL,
  `bool_v` tinyint(1) DEFAULT NULL,
  `str_v` varchar(50) DEFAULT NULL,
  `long_v` bigint(20) DEFAULT NULL,
  `dbl_v` double DEFAULT NULL,
  PRIMARY KEY (`entity_type`,`entity_id`,`key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ts_kv_latest_cf` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `tenant_id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `customer_id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `email` varchar(50) DEFAULT NULL,
  `search_text` varchar(100) DEFAULT NULL,
  `authority` varchar(50) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `additional_info` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`,`tenant_id`,`customer_id`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`tenant_id`,`customer_id`,`email`,`search_text`,`authority`,`first_name`,`last_name`,`additional_info`) values ('15a66835-2c8c-11e7-beb9-c718feb645ca','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','2b00e814-2c8d-11e7-915b-81734b7ca9dc','tenant@thingsboard.org','tenant@thingsboard.org','TENANT_ADMIN',NULL,NULL,NULL),('3d37a5ef-2c8c-11e7-beec-f1336faee06d','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','2d64bec7-2c8c-11e7-abdd-23324539a6ad','customer@thingsboard.org','customer@thingsboard.org','CUSTOMER_USER',NULL,NULL,NULL),('41d4ad0c-2c8c-11e7-82d7-fbceadae7f4e','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','2d64bec7-2c8c-11e7-abdd-23324539a6ad','customerA@thingsboard.org','customerA@thingsboard.org','CUSTOMER_USER',NULL,NULL,NULL),('46c74fab-2c8c-11e7-8eb6-e7a3e09b2cf5','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','340d2633-2c8c-11e7-a9a8-ad927087b2cc','customerB@thingsboard.org','customerB@thingsboard.org','CUSTOMER_USER',NULL,NULL,NULL),('4bbf4814-2c8c-11e7-b83e-0bb10685cfd9','089d4f3d-2c8c-11e7-8c50-9f1e9c9fc48e','39645701-2c8c-11e7-b572-bb5c081a5519','customerC@thingsboard.org','customerC@thingsboard.org','CUSTOMER_USER',NULL,NULL,NULL);

/*Table structure for table `user_credentials` */

DROP TABLE IF EXISTS `user_credentials`;

CREATE TABLE `user_credentials` (
  `id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `user_id` varchar(50) DEFAULT NULL COMMENT 'timeuuid',
  `enabled` tinyint(1) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `activate_token` varchar(100) DEFAULT NULL,
  `reset_token` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_credentials` */

insert  into `user_credentials`(`id`,`user_id`,`enabled`,`password`,`activate_token`,`reset_token`) values ('3069f2f7-2c8d-11e7-9340-2346b38c3535','15a66835-2c8c-11e7-beb9-c718feb645ca',1,'$2a$10$CUHks/PiEvxSGCKzrHCQGe/MoseIQw6qijIDjSa2sNoIyXkgJGyMO',NULL,NULL),('36e2e6a6-2c8d-11e7-a844-e34b2347dc73','3d37a5ef-2c8c-11e7-beec-f1336faee06d',1,'$2a$10$1Ki3Nl10pagxZncDQZtU.uHttir3HGKzLeovxCNKdSSJa3PU49L1C',NULL,NULL),('3b878f0a-2c8d-11e7-b3f3-af5ab34d69e8','41d4ad0c-2c8c-11e7-82d7-fbceadae7f4e',1,'$2a$10$1Ki3Nl10pagxZncDQZtU.uHttir3HGKzLeovxCNKdSSJa3PU49L1C',NULL,NULL),('401be42b-2c8d-11e7-a28b-bb648b877162','46c74fab-2c8c-11e7-8eb6-e7a3e09b2cf5',1,'$2a$10$1Ki3Nl10pagxZncDQZtU.uHttir3HGKzLeovxCNKdSSJa3PU49L1C',NULL,NULL),('44a871db-2c8d-11e7-aaa5-cf25e85129d7','4bbf4814-2c8c-11e7-b83e-0bb10685cfd9',1,'$2a$10$1Ki3Nl10pagxZncDQZtU.uHttir3HGKzLeovxCNKdSSJa3PU49L1C',NULL,NULL);

/*Table structure for table `widget_type` */

DROP TABLE IF EXISTS `widget_type`;

CREATE TABLE `widget_type` (
  `id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `tenant_id` varchar(50) NOT NULL,
  `bundle_alias` varchar(50) NOT NULL,
  `alias` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `descriptor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`tenant_id`,`bundle_alias`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `widget_type` */

/*Table structure for table `widgets_bundle` */

DROP TABLE IF EXISTS `widgets_bundle`;

CREATE TABLE `widgets_bundle` (
  `id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `tenant_id` varchar(50) NOT NULL COMMENT 'timeuuid',
  `alias` varchar(50) DEFAULT NULL,
  `title` varchar(50) DEFAULT NULL,
  `search_text` varchar(100) DEFAULT NULL,
  `image` blob,
  PRIMARY KEY (`id`,`tenant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `widgets_bundle` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
