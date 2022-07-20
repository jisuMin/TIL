create table book (
bookNo char(10) primary key,
bookTitle varchar(30) not null,
bookAuthor varchar(20),
bookYear date,
bookPrice int,
bookPublisher varchar(10)
);

insert book values ('B001','자바프로그래밍','홍길동','2020-01-01',30000,'멀티출판사');
insert book values ('B002','MYSQL 이해','나이해','2022-02-02',25000,'캠퍼스출판');
insert book values ('B003','SPRING활용','김고수','2021-11-11',45000,'디지털출판사');

select bookNo '도서 번호',
bookTitle '도서 제목',
bookAuthor 저자,
date_format(bookYear,'%Y') 발행연도,
bookPrice 가격,
bookPublisher 출판사
from book;




