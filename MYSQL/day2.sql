select * from employees;
select salary from employees;

-- 급여 총합
select sum(salary) '사원 급여 총합' from employees; -- 1개

-- 급여 평균
select avg(salary) '사원 급여 평균' from employees;

-- 총합, 평균 한 번에 출력 
select sum(salary) '사원 급여 총합', avg(salary) '사원 급여 평균' from employees;

-- 급여 갯수 ( 사원 수) , 최대 급여 , 최소 급여    
-- count : not null 컬럼 갯수만 
select count(salary) '사원 수' ,max(salary), min(salary) from employees;

-- 보너스 받는 사람
select first_name, commission_pct from employees
where commission_pct is not null;

select  first_name, department_id, salary from employees;

-- 90번 부서 급여 총합
select sum(salary) from employees 
where department_id =90;

-- 모든 부서에 대해 각 부서별 급여 총합 조회, 부서로 오름차순
select department_id, sum(salary) from employees
group by department_id
order by department_id asc;

-- 모든 부서에 대해 각 부서별 급여 총합 조회하되,
-- 급여 총합이 100000 이상인 결과만 조회
-- group by 사용 시 where 절에는 집계합수조건식 불가능 => having 사용
select department_id, sum(salary) from employees
group by department_id 
having sum(salary) >= 100000;

select first_name, job_id from employees;

-- 직종별로 사원의 급여 평균을 구하되, IT_PROG 직종은 제외하고 조회
-- 조회 컬럼은 직종코드, 부서 평균 급여 조회
-- 부서평균 급여가 많은 직종부터 보여주도록 조회
select job_id 직종코드, avg(salary) '부서 평균 급여' from employees
where job_id != 'IT_PROG'
group by job_id
order by avg(salary) desc;
-- = 2 desc


-- 2006년도 이후 입사 사원에 대해서 부서별 보너스 평균 상황
-- 보너스 = salary + salary * commission_pct
-- 보너스 받지 못하는 사원 제외, 부서 없는 사원 제외
select department_id, avg(salary + salary * commission_pct) from employees
where hire_date >= '2008-01-01 00:00:00' 
and commission_pct is not null 
and job_id is not null
group by department_id;


-- 테이블 정의 동시에 데이터 복사
create table emp_copy
(select employee_id, first_name, last_name,salary,hire_date 
from employees);

select count(*) from emp_copy;

describe emp_copy; -- 구조 확인

-- 1, 이사원, 15000, '2000-12-10 00:00:00'
insert into emp_copy values (1,'사원','이',150000,'2000-12-10 00:00:00');
insert into emp_copy values (2,'길동','홍',250000,'2022-12-10');
insert into emp_copy values (3,'대리','박',260000,now());
insert into emp_copy values (4,'신입','김',100000,current_date());

select * from emp_copy where employee_id in(1,2,3,4,5,6);

-- 나열되지 않은 값 = 자동 null 
insert into emp_copy (employee_id,hire_date,last_name) values (5,now(),'김'); 
-- null 명시
insert into emp_copy values (6,null,'박',null,now());

insert into emp_copy values(6,'부징','심',5000,now());

select * from emp_copy;
-- Update
update emp_copy set first_name='수정' where employee_id =5;

-- 키 중복 시 업데이트
insert into emp_copy values(6,'부징','심',5000,now())
on duplicate key update hire_date=now();

select * from emp_copy
where first_name='부징'
order by 1 desc;

update emp_copy
set salary = salary + salary*0.2
where first_name='부징'
limit 2; -- 상위 두 레코드의 값만 변경됨.