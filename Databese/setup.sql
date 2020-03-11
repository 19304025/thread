create user Matumura identified by kouhei account unlock;
grant dba to Matumura;

conn Matumura/kouhei


create table thread(
	threadid number(6) PRIMARY KEY,
	title varchar2(100) NOT NULL,
	Name varchar2(40) default '–¼–³‚µ',
	postdate Date default sysdate);

create table Response(
	threadid number(6) NOT NULL references thread(threadid),
	responseid number(10) PRIMARY KEY ,
	Name varchar2(40) default '–¼–³‚µ',
	Comments varchar2(1000) NOT NULL,
	ResponseDate Date default sysdate);

create sequence Thread_sequence
start with 1
increment by 1
maxvalue 1000000
minvalue 1;

create sequence Response_sequence
start with 1
increment by 1
maxvalue 10000000000
minvalue 1;