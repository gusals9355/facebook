CREATE DATABASE facebook;

CREATE TABLE t_user(
   iuser INT PRIMARY KEY AUTO_INCREMENT,
   email VARCHAR(50) UNIQUE NOT NULL,
   pw VARCHAR(100) NOT NULL,
   nm VARCHAR(5) NOT NULL,
   tel VARCHAR(13),
   authcd CHAR(5) COMMENT '회원가입 인증코드',
   mainprofile varchar(50),
   regdt DATETIME DEFAULT NOW(),
   INDEX idx_auth_cd (authcd)
);

CREATE TABLE t_user_profile(
   iprofile INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
   iuser INT UNSIGNED,
   img VARCHAR(50),
   regdt DATETIME DEFAULT NOW(),
   FOREIGN KEY(iuser) REFERENCES t_user(iuser)
);

create table t_feed(
   ifeed int unsigned primary key auto_increment,
   location varchar(20),
   ctnt text,
   iuser int unsigned not null,
   regdt datetime default now(),
   foreign key (iuser) references t_user(iuser)
);

create table t_feed_img(
   ifeedimg int unsigned primary key auto_increment,
   ifeed int unsigned not null,
   img varchar(50) not null,
   foreign key (ifeed) references t_feed(ifeed)
);