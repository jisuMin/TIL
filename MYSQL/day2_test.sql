use empdb;

select * from employees;

-- 1. 직원 중에서 연봉이 170000 이상인 직원들의 이름, 연봉을 조회하시오.
-- 연봉은 급여(salary)에 12를 곱한 값입니다.
-- 단, 이름은 "이름", 연봉은 "월급의 12배"로 출력 되도록 조회하시오.
select first_name 이름 ,salary*12 '월급의 12배'
from employees
where salary*12 >= 170000;

-- 2. 직원 중에서 부서id가 없는 직원의 이름과 급여를 조회하시오.
select first_name 이름, salary 급여
from employees
where department_id is null; 

-- 3. 2004년 이전에 입사한 직원의 이름, 급여, 입사일을 조회하시오.
select first_name 이름, salary 급여, hire_date 입사일
from employees
where hire_date <= '2004-12-31 00:00:00';

-- 4. departments 테이블에서 부서코드, 부서명을 조회하시오.
select department_id 부서코드, department_name 부서명 
from departments;

-- 5. jobs 테이블에서 직종코드와 직종명을 조회하시오.
select job_id 직종코드, job_title 직종명
from jobs;

-- 논리연산자
select * from employees;
-- 1. 80, 50 번 부서에 속해있으면서 급여가 13000 이상인 직원의 이름, 급여, 부서id 를 조회하시오.
select first_name 이름, salary 급여, department_id 부서id
from employees
where department_id in (80,50) and salary >= 13000;

-- 2. 2005년 이후에 입사한 직원들 중에서 급여가 1300 이상 20000 이하인 직원들의 이름, 급여, 부서id, 입사일을 조회하시오.
select first_name 이름, salary 급여, department_id 부서id, hire_date 입사일
from employees
where salary between 1300 and 20000 
and hire_date >= '2005-01-01';

-- sql 비교연산자
-- 1.2005년도 입사한 직원의 정보(이름, 급여, 부서코드, 입사일)만 출력하시오.
select first_name 이름, salary 급여, department_id 부서코드, hire_date 입사일
from employees
where hire_date between '2005-01-01' and '2005-12-31';

-- 2. 직종이 clerk 군인 직원의 이름, 급여, 직종코드를 조회하시오. (clerk 직종은 job_id에 CLERK을 포함하거나 CLERK으로 끝난다.)
select first_name 이름, salary 급여, job_id 직종코드
from employees
where job_id like '%clerk%';

-- 3.12월에 입사한 직원의 이름, 급여, 입사일을 조회하시오.
select first_name 이름, salary 급여, hire_date 입사일
from employees
where hire_date like '%-12-%';

-- 4.이름에 le 가 들어간 직원의 이름, 급여, 입사일을 조회하시오
select first_name 이름, salary 급여, hire_date 입사일
from employees
where first_name like '%le%';

-- 5.이름이 m으로 끝나는 직원의 이름, 급여, 입사일을 조회하시오.
select first_name 이름, salary 급여, hire_date 입사일
from employees
where first_name like '%m';

-- 6. 이름의 세번째 글자가 d인 이름, 급여, 입사일을 조회하시오.
select first_name 이름, salary 급여, hire_date 입사일
from employees
where first_name like '--d%'or last_name like '--d%';

-- 7. 커미션을 받는 직원의 이름, 커미션, 급여를 조회하시오.
select first_name 이름, commission_pct 커미션, salary 급여
from employees
where commission_pct is not null;

-- 8. 커미션을 받지 않는 직원의 이름, 커미션, 급여를 조회하시오.
select first_name 이름, commission_pct 커미션, salary 급여
from employees
where commission_pct is null;

-- 9. 30, 50, 80 번 부서에 속해있으면서,
-- 급여를 5000 이상 17000 이하를 받는 직원을 조회하시오.
-- 단, 커미션을 받지 않는 직원들은 검색 대상에서 제외시키며, 먼저 입사한 직원이
-- 먼저 출력되어야 하며 입사일이 같은 경우 급여가 많은 직원이 먼저 출력되록 하시오.
select first_name 이름, salary 급여, hire_date 입사일
from employees
where department_id in (9,30,50,80) 
and salary between 5000 and 17000
and commission_pct is not null
order by hire_date, salary asc;


-- 함수
-- 1. employees 테이블에서 각 사원의 이름과 직속상사의 사번을 조회한다. 
-- (직속상사의 사번은 manager_id 컬럼이다). 직속상사가 없으면 BOSS 로 출력한다.
select first_name 사원이름, ifnull(manager_id,'BOSS') 상사사번
from employees;

-- 2.모든 사원 출력 형식
-- 100 번 사번의 사원명은 LAST_NAME값 , FIRST_NAME값 이고 입사월은 07월입니다.
select concat(employee_id, '번 사번의 사원명은 '
,last_name,',',first_name,' 이고 입사월은 ',SUBSTR(hire_date,6,2),'월 입니다.') 사원정보
from employees;
