create table userInfo(
	CreateTime			timestamp NOT NULL,
	CreateBy			bigint NOT NULL,
	ModifyTime			timestamp NOT NULL,
	ModifyBy			bigint NOT NULL,
	Active				BOOLEAN NOT NULL,
	Id					serial,
	Username			varchar(15) not null,
	Password			text not null,
	Nickname			varchar(15) not null,
	Email				varchar(25) not null,
	Gender				enum('male', 'female'),
	DOB					timestamp,
	ServiceStatus		boolean,
	LastSigninTime		timestamp,
	Activeness			int,
	EmailVerified		boolean,
	
	primary key (Id)
);

alter table userInfo add unique index(username);
alter table userInfo add unique index(nickname);
alter table userInfo add unique index(email);

create table address(
	CreateTime			timestamp NOT NULL,
	CreateBy			bigint NOT NULL,
	ModifyTime			timestamp NOT NULL,
	ModifyBy			bigint NOT NULL,
	Active				BOOLEAN NOT NULL,
	Id					serial,
	UserId				BIGINT UNSIGNED NOT NULL,
	Stree				text,
	Suburb				text,
	Province			text,
	Nation				text,
	Postcode			text,
	
	primary key (Id)
);

ALTER TABLE address 
ADD CONSTRAINT FK_address 
FOREIGN KEY (userId) REFERENCES userInfo(id)
ON DELETE CASCADE
ON UPDATE CASCADE;

create table car(
	CreateTime			timestamp NOT NULL,
	CreateBy			bigint NOT NULL,
	ModifyTime			timestamp NOT NULL,
	ModifyBy			bigint NOT NULL,
	Active				BOOLEAN NOT NULL,
	Id					serial,
	UserId				BIGINT UNSIGNED NOT NULL,
	MaxSeats			int not null,
	MaxLuggages			int,
	ImageURI			text,
	
	primary key (id)
);

ALTER TABLE car
ADD CONSTRAINT FK_car
FOREIGN KEY (UserId) REFERENCES userInfo(id)
ON DELETE CASCADE
ON UPDATE CASCADE; 

create table avaliableTime(
	CreateTime			timestamp NOT NULL,
	CreateBy			bigint NOT NULL,
	ModifyTime			timestamp NOT NULL,
	ModifyBy			bigint NOT NULL,
	Active				BOOLEAN NOT NULL,
	Id					serial,
	UserId				BIGINT UNSIGNED NOT NULL,
	TimeFrameStart		int not null,
	TimeFrameEnd		int not null,
	
	primary key (id)
);

ALTER TABLE avaliableTime
ADD CONSTRAINT FK_avaliableTime
FOREIGN KEY (UserId) REFERENCES userInfo(id)
ON DELETE CASCADE
ON UPDATE CASCADE; 