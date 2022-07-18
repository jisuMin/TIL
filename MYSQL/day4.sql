select e.first_name,e.department_id, d.deparment_name
from employees e inner join departments d
on e.department_id = d.department_id;

-- 급여 총합
select sum(salary)
from employees e inner join departments d
on e.department_id = d.department_id;

-- 부서별 급여 총합 
select d.department_name 부서이름, sum(e.salary)
from employees e inner join departments d
on e.department_id = d.department_id
group by d.department_name
having sum(e.salary) >=100000
order by 부서이름;

-- 부서 코드별 급여 총합 : 이 경우 join 필요 없음
select department_id 부서코드, sum(salary)
from employees
group by department_id
having sum(salary) >=100000
order by 부서코드;

-- 세 개의 테이블 join
-- employees : 사원 정보 / departments : 부서정보 / locations : 도시 정보 / countries : 국가 정보  / regions : 대륙 정보 

-- 사원명, 도시명 조회 
desc employees;
desc departments;
desc locations;

-- employees 와 location을 join 할 수 있는 컬럼이 없기 때문에 departments 테이블도 join 
select e.first_name, l.city,c.country_name
from employees e inner join departments d on e.department_id = d.department_id
inner join locations l on d.location_id = l.location_id -- 앞에 테이블명이 없을 땐 뒤에 테이블과 join
inner join countries c on l.country_id=c.country_id;

-- 사원명, 부서명, 도시명, 국가명 조회 
-- 50,80,100 부서, 급여 50000 이상인 사원만 조회 
select e.first_name 사원명, d.department_id 부서명,l.city 도시명,c.country_name 국가명 
from employees e inner join departments d on e.department_id = d.department_id
inner join locations l on d.location_id = l.location_id -- 앞에 테이블명이 없을 땐 뒤에 테이블과 join
inner join countries c on l.country_id=c.country_id
where d.department_id in (50,80,100) and e.salary >= 5000
order by 2 desc;

-- inner join : 2개 테이블 모두 존재하고, 조건 일치하는 데이터만 합침 
-- outer join : 2개 테이블 모두 존재하지만, 조건 일치하지 않아도 데이터만 합침 
-- lefr outer join / right outer join
select first_name, e.department_id, department_name
from employees e right outer join departments d -- d에 있기만 하면 다 가져오기 
on e.department_id = e.department_id
order by e.department_id;

-- 사원들 부서명을 조회하되, 부서 소속되지 않은 사원은 부서코드 '-' , 부서명 '소속 부서없음' 출력
select first_name, ifnull(e.department_id,'-') 부서코드, ifnull(department_name,'소속 부서 없음') 부서명 
from employees e left outer join departments d
on e.department_id = d.department_id
order by first_name;

-- 사원명, 상사명 ( 상사 없는 사원 포함 )
select me.first_name 사원명, man.first_name 상사명 
from employees me right outer join employees man on me.manager_id = man.employee_id;
-- 사원명, 상사명 ( 부하직원 없는 상사 포함 )
select ifnull(me.first_name,'신입사원') 사원명, man.first_name 상사명 
from employees me right outer join employees man on me.manager_id = man.employee_id;

-- join : 2개 이상의 테이블에 나누어졌을 때 컬럼 합침 
-- union : 중복 제거하고 레코드 합침 / union all : 중복된 레코드까지 합침 / not in

-- emp_dept_50 테이블은 50번 부서원들의 11개 칼럼들 저장 테이블 
create table emp_dept_50(select * from employees where department_id=50);
-- 직종 코드 manager 직정만 11개 칼럼 저장 테이블
create table emp_job_man (select * from employees where job_id like '%man%');

-- 50번 부서이거나 manager 직종 재난지원금 받을 대상 조회 (이름 사번 직종코드 부서코드 조회). 중복 허용 안 함
-- union (힙정렬 -a,b 테이블 중 한개 포함 조회 )
select employee_id, first_name, job_id, department_id
from emp_dept_50
union
select employee_id,first_name, job_id,department_id
from emp_job_man;

select * from employees 
where employee_id in (100,200,300,400,500);

-- employees 테이블에서 이름이 kelly와 같은 부서 근무 사원의 이름 근무부서코드 조회 
select first_name 이름, department_id 근무부서코드 
from employees
where department_id = (select department_id from employees where first_name ='kelly');
-- employees 테이블에서 이름이 kelly와 같은 부서이면서 같은 직종인 근무 사원의 이름 근무부서코드 조회 , 이때 kelly는 조회에서 제외
select first_name 이름, department_id 근무부서코드 
from employees
where (job_id,department_id) = (select job_id,department_id from employees where first_name ='kelly')
and first_name!='kelly';

select first_name 이름, department_id 근무부서코드 
from employees
where salary = (select avg(salary) from employees);

-- not in : 목록 중 일치하지 않는 것, in : 목록 중 일치하는 것
-- peter와 같은 부서원 조회
select first_name 이름, department_id 근무부서코드 
from employees
where department_id in (select department_id from employees where first_name='peter');