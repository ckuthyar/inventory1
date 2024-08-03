create database inventory;
use inventory;
drop table items;
create table items(item_id bigint primary key auto_increment, item_name varchar(100),  company_id bigint, location_id bigint, added_on date, updated_on date, updated_by bigint, foreign key(company_id)references companies(company_id), foreign key(location_id) references locations(location_id));
insert into items(item_name,company_id,location_id)values
('Dell Latitude 4050',1,1),
('HP Pavillion G8',1,1),
('Assembled PC',1,2),
('Assembled PC',1,2),
('Assembled PC',1,2),
('Projector',1,2);
insert into items(item_name,company_id,location_id)values
('Dell Latitude 4050',2,1),
('HP Pavillion G8',2,1),
('Assembled PC',2,2),
('Assembled PC',2,2),
('Assembled PC',2,2),
('Projector',2,2);

select * from items;
create table companies(company_id bigint primary key auto_increment, company_name varchar(100), country_id varchar(3), pincode varchar(7));
alter table companies drop column pincode;
insert into companies(company_name, country_id)values
('Karnataka Bank', 'IND'),
('British Gas', 'GBP');
select * from companies;
create table locations(location_id bigint primary key auto_increment, location_name varchar(100), country_code varchar(3), pincode varchar(7));
insert into locations(location_name, country_code,pincode)values
("Mangalore","IND",574001),("Udupi","IND", 574002),("London","GBR","SW1A1AA");
select * from locations;
select * from items;
select * from items where company_id=1;
select * from items where company_id=1 and location_id=1;
select * from items where location_id=1;
select * from items where location_id=2;
desc items;
desc companies;
desc locations;
select * from items inner join companies inner join locations where (items.company_id=companies.company_id) and (locations.location_id=2);
select * from items inner join companies inner join locations where (items.company_id=companies.company_id) and (location_name="Udupi");

select * from locations;
select * from companies;
select * from items;


select * from items inner join companies where (items.company_id=companies.company_id) and companies.company_id=1;
select * from items inner join companies where (items.company_id=companies.company_id) and companies.company_id=2;

select * from items inner join companies,locations where(items.company_id=companies.company_id) and
(items.location_id=locations.location_id) and (companies.company_id=1) and (locations.location_id=1);

select * from items inner join companies,locations where(items.company_id=companies.company_id) and
(items.location_id=locations.location_id) and (companies.company_id=1) and (locations.location_id=2);

select * from items inner join companies,locations where(items.company_id=companies.company_id) and
(items.location_id=locations.location_id) and (companies.company_id=1) and (locations.location_id=3);

select * from items inner join companies,locations where(items.company_id=companies.company_id) and
(items.location_id=locations.location_id) and (companies.company_id=1) and (locations.location_id=4);


