create table if not exists content (
	id integer auto_increment primary key,
	title varchar(255) not null,
	description text not null,
	status varchar(20) not null,
	type varchar(20) not null,
	date_created timestamp not null,
	date_updated timestamp,
	url varchar(255)
);

insert into content (title, description, status, type, date_created)
values ('Spring data demo', 'First data demo', 'IDEA', 'IN_PROGRESS', CURRENT_TIMESTAMP);