SELECT * FROM memberdb.member;

desc member;

-- drop table member;
create table member 
(
id varchar(30),
password int(4),
name varchar(30),
phone char(13),
email varchar(30),
regdate datetime
);

create table c_member 
(
id varchar(30) primary key , -- unique + not null
password int(4) not null, -- null값 삽입 불가능
name varchar(30),
phone char(13) unique, -- 같은 데이터가 있으면 안됨
email varchar(30) check (email like '%@%'), -- 양식에 @가 있는지 확인
regdate datetime
);

insert into member values ('id1',1111,'홍길동','010-1234-1234','hong@multi',now());
insert into member values ('id2',2222,'박길동','010-5678-5678','park@multi',now());
insert into member values ('id3','333333','김길동','010-3333-3333','kim@multi',now()); 
-- passwork를 문자, 길이를 넘어도 자동 형변환, 자릿수를 잘라서 insert 됨. 
insert into member values ('id4',4444,'김한국','010-1234-1235','korea@multi',curdate()); -- 시간은 필요 없을 때 

-- c_member에 삽입해보기 , 제약 조건 효력 발생 
insert into c_member values ('id1',1111,'홍길동','010-1234-1234','hong@multi',now()); -- 중복 삽입 안됨 
insert into c_member values ('id2',2222,'박길동','010-5678-5678','park@multi',now());
insert into c_member values ('id3','333333','김길동','010-3333-3333','kim@multi',now()); 
insert into c_member values ('id4',4444,'김한국','010-1234-1235','korea@multi',curdate());

select * from member;

-- 폰 번호 국번이 1234인 회원의 id, phone, password 조회 단, 암호 "-" 로 변환 
select id, phone, insert(password,1,length(password),repeat('-',length(password)))
from member
where phone like '%-1234-%';
-- where phone like '_____1234%'

-- 메모테이블 정의 (글 번호, 제목, 내용, 글쓴시각, 작성자)
create table c_memo
( memo_id int primary key auto_increment, -- 글 번호 자동 증가 
title varchar(50) not null,
contents varchar(4000),
time datetime default now(), -- now()함수를 명시하지 않아도 기본 명시
writer varchar(30)); -- c_member id에 있는 값들만 참조
-- 제약조건 변경 / 추가 / 삭제 
alter table c_memo add constraint foreign key(writer) references c_member(id);
-- 제약 조건 추가 
select * from c_memo;
select * from c_member;

insert into c_member values('id2',2222,'박대한','010-1111-2222','id2@mul.com',now());
insert into c_memo values(1,'1번글 제목','1번글 내용',default,'id2');
insert into c_memo(title,contents,time,writer) values('2번글 제목','2번글 내용',default,'id1'); 
-- 글 번호는 primary 이기 때문에 값을 줘야하지만, auto increment로 되어있는 경우 값을 삽입하지 않아도 됨 
insert into c_memo(title,contents,time,writer) values('3번글 제목','3번글 내용',default,'id3'); 

-- 이름이 홍길동 회원의 글쓴 제목, 내용 조회 - join
-- 회원명 글제목 글내용 출력 
select c_member.name , c_memo.title, c_memo.contents
from c_member inner join c_memo
on c_member.id = c_memo.writer
where c_member.name = '홍길동';

