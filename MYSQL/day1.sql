show databases;

use mysql;

create table employees 
(
EMPLOYEE_ID int(10),
EMPLOYEE_name varchar(20),
salary decimal(10,2),
hire_date date,
department_id int(5)
);

select * from employees;

insert into employees values(100,'이사원',45000.99,now(),10);
insert into employees values(101,'김사원',45000.99,now(),10);
insert into employees values(102,'촤사원',45000.99,now(),10);
insert into employees values(200,'박대리',55000.99,'2020-12-12',10);
insert into employees values(201,'홍대리',55000.99,'2021-12-12',10);
insert into employees values(202,'최대리',55000.99,'2020-12-12',10);
insert into employees values(300,'김과장',65000.99,'2018-12-12',10);
insert into employees values(301,'이과장',65000.99,'2011-12-12',10);
insert into employees values(302,'최부장',75000.99,'2010-12-12',10);
insert into employees values(303,'백이사',85000.99,'2008-12-12',10);

select distinct department_id from employees;
select employee_name, salary*12 from employees;

-- 이름이 이사원이고 급여가 40000이상인 사원의 이름과 급여 추출 
select employee_name, salary from employees
where employee_name = '이사원' and salary >= 40000;

-- 입사일이 2008-12-12 이거나 급여가 100000 이상인 사원의 이름과 급여, 입사일 추출 
select employee_name, salary, hire_date from employees
where hire_date='2008-12-12' or salary>=100000;

-- 이름이 최씨인 사원의 이름과 보너스 ( *0.05) 
-- like : 문자열 패턴 유사
-- % : 자릿수 무관, 모든 문자,  _ : 1자리, 모든 문자
select employee_name, salary *0.05 from employees
where employee_name like '최%';

-- 입사일이 2020년도 입사한 사원의 이름과 입사일 조회
-- 날짜 대소비교 가능 
select employee_name, hire_date from employees
where hire_date like '2020%';
-- where hire_date >= '2020-01-01' and hire_date <=2020-12-31

-- 급여가 5만 이상이고 7만 이하의 사원 이름과 급여 조회
select employee_name, salary from employees
where salary between 50000 and 70000;
-- where salary >= 50000 and salary <=70000;

-- 사번이 100,300,250,204 사원의 사번과 이름 조회 
select * from employees
where employee_id in (100,300,250,204);


insert into employees values(400, '최신입',40000.0 , null, null);
insert into employees values(401, '김신입',40000.0 , now(), 20);
insert into employees values(402, '오신입',40000.0 , now(), 30);
insert into employees values(403, '강신입',40000.0 , now(), 40);
insert into employees values(404, '최신입',40000.0 , null, null);

-- 입사일이 null인 사원 조회
select * from employees
where hire_date is null;

-- 조회시 별명 
select employee_name 사원명, salary 월급,salary*12 '사원의 연봉' from employees;
insert into employees values(405, '김경력',null , now(), 30);       
select employee_name 사원명, salary 월급, ifnull(salary,1000)*12 '사원의 연봉' from employees;

select concat(employee_name, ' 사원은 ',salary,'의 월급을 받습니다.') '급여 정보'
from employees;

-- order by 정렬 
-- asc : 오름차순, desc : 내림차순
select * from employees
order by employee_id asc;

select * from employees
order by salary desc;

-- 급여가 같으면 사번이 큰 사원부터 정렬
select * from employees
order by salary desc, employee_id desc;

select employee_id, salary from employees
order by 2 desc, 1 desc;

-- null 값 ( asc : 처음에 출력, desc : 마지막에 출력 )
select employee_id, salary from employees
order by salary desc;

-- 급여가 많은 사원부터 상위 3명만 조회
select employee_id, salary from employees
order by salary desc
limit 3; -- 3개 까지만 가져옴

select employee_id, salary from employees
order by salary desc
limit 3,4; -- 정렬된 데이터 3번 인덱스에서 4개

show databases;

select database();

show tables;

-- 데이터 복사하여 테이블 생성
create table emp_copy (select employee_name, salary, hire_date from employees);

select * from emp_copy;

create table empdb;