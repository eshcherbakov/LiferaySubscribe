create table Subscribe_Subscribe (
	subscribeId LONG not null primary key,
	email VARCHAR(75) null,
	subscribeDate DATE null,
	isActivated BOOLEAN
);