insert into CUSTOMER (NAME, PASSWORD, EMAIL) VALUES ('Bob', 'B0bI$Cool', 'bob@gmail.com');
insert into CUSTOMER (NAME, PASSWORD, EMAIL) VALUES ('Sarah', 'Pa$$w0rd', 'sarah@gmail.com');
insert into CUSTOMER (NAME, PASSWORD, EMAIL) VALUES ('Joe', '$AfCat9&=uANt','joe@yahoo.com');

insert into EVENT (CODE, TITLE, DESCRIPTION) VALUES ('BEE', 'Best Event Ever', 'This event is great!');
insert into EVENT (CODE, TITLE, DESCRIPTION) VALUES ('JBP', 'Joes Birthday Party', 'Everyone is invited!');
insert into EVENT (CODE, TITLE, DESCRIPTION) VALUES ('SSN', 'Study Session', 'Math is Fun');

insert into REGISTRATION (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES)
values('2', '3', '2020-10-10', 'Hosting');

insert into REGISTRATION (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES)
values('1', '1', '2020-10-10', 'Excited');

insert into REGISTRATION (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES)
values('2', '2', '2020-10-10', 'Bringing snacks');

insert into REGISTRATION (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES)
values('1', '2', '2020-10-10', 'this is a note');

insert into REGISTRATION (EVENT_ID, CUSTOMER_ID, REGISTRATION_DATE, NOTES)
values('3', '1', '2020-10-10', 'Math is not fun');