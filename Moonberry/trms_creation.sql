--reset lines
drop table employee;
--drop type grade_format;
drop table tr_request;
--drop type "position";
drop table status_code;
select * from tr_request;
select * from employee;
select * from approver ;
select * from department;
create type grade_format as enum('letter','pass_fail','percentage','completion');
create type event_type as enum('university_course','seminar','cert_prep_course','cert','tech_training','other');
create type approver_type as enum('supervisor','department_head','ben_co');
PERCE


create table department(
	department_id serial primary key,
	name varchar(30),
	department_head int,
	
	foreign key(department_head) references approver(approver_id)
);

create table approver(
	approver_id serial primary key,
	approver_type  approver_type not null,
	firstname varchar(30) not null,
	lastname varchar(30) not null,
	department varchar(50) not null,
	username varchar(30) unique not null, 
	password varchar(30) not null

);
create table employee(
	employee_id serial primary key, 
	firstname varchar(30),
	lastname varchar(30),
	department_id int not null,
	avail_rmbsment numeric(6,2) default 1000.00,
	direct_super int not null,
	username varchar(30) unique not null, 
	password varchar(30) not null,
	foreign key(direct_super) references approver(approver_id),
	foreign key(department_id) references department(department_id)
);

create table status_code(
	code int primary key,
	status varchar(50)
);

insert into status_code(code,status)
values
	(1, 'request created'),
	(2, 'awaiting supervisor approval'),
	(3, 'additional information requested'),
	(4, 'additional information submitted'),
	(5, 'awaiting department head approval'),
	(6, 'awaiting benefits co approval'),
	(7, 'awaiting employee approval'),
	(8, 'awaiting grade'),
	(9, 'awaiting presentation'),
	(10, 'awaiting grade confirmation'),
	(11, 'awaiting presentation confirmation'),
	(12, 'request escalated'),
	(13, 'request rejected'),
	(14, 'approved and awarded')
;

create table tr_request(
    request_id serial primary key,
	request_status int default 1,
	employee_id int not null,
	request_made_date timestamp without time zone not null default now(),
	event_start_date timestamp without time zone not null default '1111-11-11 11:11:11',
	event_end_date timestamp without time zone not null default '1111-11-11 11:11:11',
	event_name varchar(50) not null,
	event_location varchar(50) not null,
	event_description text default null,
	tuition_amount numeric(6,2) default 0.00,
	rmbsment_amount numeric(6,2) default 0.00 not null,
	grade_format grade_format not null,
	event_type event_type not null,
	work_just text not null,
	urgent boolean default false,
	request_arrival_date timestamp without time zone not null default now(),

	foreign key(employee_id) references employee(employee_id),
	foreign key(request_status) references status_code(code)
);


create table logs
   (user_id varchar(20)    not null,
    dated   date           not null,
    logger  varchar(50)    not null,
    level   varchar(10)    not null,
    message varchar(1000)  not null
   );
   
 insert into approver 
 values(
 	default,
 	'department_head',
 	'Lunar',
 	'Approver',
 	'test',
 	'lapp',
 	'lapp'
 );
insert into department
 values(
 	default,
 	'test',
 	1
 );
 
insert into employee 
	values( 
		default,
		'Blue',
		'Moon',
		1,
		default,
		1,
		'blue',
		'moon'
		
	);
	
insert into tr_request
	values( 
		default,
		1,
		1,
		default,
		'2019-05-05 04:05:06',
		'2019-05-22 04:05:06',
		'testing',
		'here',
		'more testing',
		50.00,
		5.00,
		'pass_fail',
		'other',
		'am broke',
		false,
		default
	);
	
update tr_request set request_arrival_date = '1111-11-11 11:11:11', request_made_date = '1111-11-11 11:11:11' where request_id = 3;