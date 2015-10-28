drop table `WEIXIN_USER`

CREATE TABLE `WEIXIN_USER` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `OPEN_ID` char(100) NOT NULL,
  `USER_ID` bigint(20),
  `NICK_NAME` varchar(300),
  `AVATAR` varchar(300),
  `FOLLOW_TIME` DATETIME,
  `GENDER` CHAR(2),
  `PRONVICE` varchar(300),
  `CITY` varchar(300),
  `UNION_ID` varchar(300),
   PRIMARY KEY (`ID`)
);

CREATE TABLE `WEIXIN_TAG` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ID` bigint(20),
  `TAG_NAME` varchar(300),
   PRIMARY KEY (`ID`)
);
