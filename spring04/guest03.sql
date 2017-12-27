create table guest03(
	sabun integer,
	name varchar(30),
	nalja timestamp,
	pay integer
);
-- 테스트용 가상 데이터
insert into guest03 values (1111,'test01',now(),1000);
insert into guest03 values (2222,'test02',now(),2000);
insert into guest03 values (3333,'test03',now(),3000);
insert into guest03 values (4444,'test04',now(),4000);
commit;
select * from guest03;
delete from guest03 where sabun=666;