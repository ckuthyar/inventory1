create database inventory;
use inventory;
create table companies(company_id bigint primary key auto_increment, company_name varchar(100), country_id varchar(3));
create table locations(location_id bigint primary key auto_increment, location_name varchar(100), country_code varchar(3), pincode varchar(7));
create table items(item_id bigint primary key auto_increment, item_name varchar(100),  company_id bigint, location_id bigint, added_on date, updated_on date, updated_by bigint, foreign key(company_id)references companies(company_id), foreign key(location_id) references locations(location_id));
create table users(user_id bigint primary key auto_increment, username varchar(100), company_id bigint, created_on date, updated_on date, foreign key(company_id)references companies(company_id));
create table useless(id bigint primary key auto_increment, user_id bigint, md5 varchar(100),foreign key(user_id) references users(user_id));

insert into companies(company_name, country_id)values
('SangamOne', 'IND'),
('Karnataka Bank', 'IND'),
('British Gas', 'GBP');
select * from companies;

insert into locations(location_name, country_code,pincode)values
("Mangalore","IND",574001),("Udupi","IND", 574002),("London","GBR","SW1A1AA");
select * from locations;

insert into items(item_name,company_id,location_id)values
('Dell Latitude 4050',2,1),
('HP Pavillion G8',2,1),
('Assembled PC',2,2),
('Assembled PC',2,2),
('Assembled PC',2,2),
('Projector',2,2);
insert into items(item_name,company_id,location_id)values
('Dell Latitude 4050',3,1),
('HP Pavillion G8',3,1),
('Assembled PC',3,2),
('Assembled PC',3,2),
('Assembled PC',3,2),
('Projector',3,2);
select * from items;

insert into users(username,company_id)values
("CS",1),
("Sivashankar",1),
("Shashank",1),
("KBL1",2),
("KBL2",2),
("KBL3",2),
("BG1",3),
("BG2",3),
("BG3",3);
select * from users;

insert into useless(user_id,md5)values
(1,'8d7e99c73cd5a10adaaf4c9f9a520368'),
(2,'8907fc2282ea176b029fd7819a83dc2f'),
(3,'b3e808b0375fac7f3e052e623315e1e3');
select * from useless;


select * from items where company_id=1;
select * from items where company_id=1 and location_id=1;
select * from items where location_id=1;
select * from items where location_id=2;
select * from items inner join companies inner join locations where (items.company_id=companies.company_id) and (locations.location_id=2);
select * from items inner join companies inner join locations where (items.company_id=companies.company_id) and (locations.location_id=3);
select * from items inner join companies where (items.company_id=companies.company_id) and companies.company_id=2;
select * from items inner join companies where (items.company_id=companies.company_id) and companies.company_id=3;
select * from items inner join companies,locations where(items.company_id=companies.company_id) and
(items.location_id=locations.location_id) and (companies.company_id=2) and (locations.location_id=1);
select * from items inner join companies,locations where(items.company_id=companies.company_id) and
(items.location_id=locations.location_id) and (companies.company_id=2) and (locations.location_id=2);
select * from items inner join companies,locations where(items.company_id=companies.company_id) and
(items.location_id=locations.location_id) and (companies.company_id=2) and (locations.location_id=3);
select * from items inner join companies,locations where(items.company_id=companies.company_id) and
(items.location_id=locations.location_id) and (companies.company_id=2) and (locations.location_id=4);









