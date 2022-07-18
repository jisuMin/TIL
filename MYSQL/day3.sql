-- 임시 변수 선언 : connetion이 끊어지면 사라짐
set @var1 = '문자열';
set @var2 = 100;
set @var3 = 10/3;
set @var4 = '2003-06-17 00:00:00';

-- 변수 선언
select @var1, @var2,@var3,@var4;

select hire_date, first_name
from employees
where hire_date = @var4;

-- 형변환 : cast. convert, format
select cast(10 as decimal(10,5)); -- 정수 10을 실수 타입으로 변환, 10자리 중 소수 5자리
select convert(10,decimal(10,5));
select format(10,5);

-- 정수로 변환
select avg(salary), cast(avg(salary) as signed integer);
select convert(avg(salary), signed integer);
select format(avg(salary),0); -- format은 뒤에 나타낼 소수점 자릿수를 지정 0= 정수

-- 자동 형변환
select '8888.1234' + 1 ;-- 문자열을 실수로 자동 형변환 되어 계산됨 
select '100' + '200' ; -- 정수로 자동 형변환
select 0=0; -- 같으면 1, 다르면 0

-- 100, 200을 문자열로 연결하려면?
select concat('100','200'); -- 100200 

-- 조건
-- IFNULL (데이터, 변환값) : 리턴결과 2개중 하나 ( Null이면 반환값, Not Null이면 원래의 데이터 값)
select commission_pct, ifnull(commission_pct,'보너스 없음') from employees;

-- NULLIF(데이터1, 데이터2) : 리턴결과는 데이터1과 데이터2가 동일하면 NULL 리턴, 다르면 데이터1 리턴
select nullif(100,100), nullif(100,200);

-- if(조건, 참결과, 거짓결과)
select if(10>20,'크다','작거나 같다');

-- 사원들 보너스 받는 직원, 받지 못하는 직원
select first_name,commission_pct, if(commission_pct is null, '보너스 받지 못하는 직원', '보너스 받는 직원')
from employees;

select first_name 사원명, salary 급여, 
if(salary >= 15000,'임원',
if(salary >= 10000,'부장',
if(salary >= 5000,'과장','대리나 사원')
)
) 직급
from employees
order by 급여 desc;

-- case 문법
set @casevar =1;
select
case @casevar
when 1 then '1이다'
when 10 then '10이다'
when 100 then '100이다'
end;
-- if문 case로 작성해보기
select first_name 사원명, salary 급여, 
case 
when salary >=15000 then '임원'
when salary >=10000 then '부장'
when salary >=5000 then '과장'
else '대리나 사원'
end 직급 from employees
order by 급여 desc;

-- concat : 두 개 문자 합침
select concat('a','b','cc'), concat_ws(':','b','cc','ddd'); -- :으로 구분하여 합침

-- 문자열 검색
select elt(2,'일','둘','3'); -- 두 번째 문자
select field('둘','일','둘','3'); -- 둘 이라는 문자 인덱스
select find_in_set('이','일,이,삼,사');-- 찾을 문자, 문장 - 인덱스 반환
select instr('일이삼사','이'); -- 문장, 찾을 문자 - 인덱스 봔환
select locate ('삼사','일이삼사'); -- 3

-- employees 테이블에서 2006년도 입사자 찾기-- 1. like
select first_name, hire_date
from employees
where hire_date like '2006%';
-- 2. between and
select first_name, hire_date
from employees
where hire_date between '2006-01-01' and '2006-12-31';
-- 3. 2006이 1번 문자인지 확인
select first_name, hire_date
from employees
where instr(hire_date,'2006')=1;
-- 4. 1번 문자가 2006인지 확인
select first_name, hire_date
from employees
where substr (hire_date,1,4) ='2006';
-- 5. left 함수 사용 
select first_name, hire_date
from employees
where left(hire_date,4)='2006';
-- employees 테이블에서 6월 입사자 찾기
-- 1. like
select first_name, hire_date
from employees
where hire_date like '-----06%';
-- 2. 2006이 1번 문자인지 확인
select first_name, hire_date
from employees
where instr(hire_date,'-06')=5;
-- 3. 1번 문자가 2006인지 확인
select first_name, hire_date
from employees
where substr (hire_date,6,2) ='06';

-- 기존 phone_number를 지우고 1번째 부터 12개를 *로 채워라
select first_name 이름, insert(phone_number,1,12,repeat('*',12)) 폰번호 from employees;
select first_name 이름, insert(phone_number,9,4,repeat('*',4)) 폰번호 from employees;

select first_name, length(first_name), char_length(first_name) from employees;

select insert(first_name,2,char_length(first_name)-1,repeat('*',char_length(first_name)-1)) from employees;

-- 글자수 잘라서 출력
select left('mysql',3),right('mysql',3);

-- round : 반올림, truncate : 버림 
select 1234.5678, round(1234.5678,3), truncate(1234.5678,3); 

-- MOD(나머지 함수)
select mod(100,3); -- 100/3 나머지

-- employees 테이블 사번컬럼이 홀수이면 홀수사번, 짝수이면 짝수사번 출력 
select employee_id 사번,
if(mod(employee_id,2)=0,'짝수사번','홀수사번') '사번의 성격'
from employees;

select now() 현재시각,
case weekday(now())
when 0 then '월요일'
when 1 then '화요일'
when 2 then '수요일'
else '목금토일 중 하나'
end 현재요일;

-- 모든 사원에 대하여 입사경과일수 구하기
select first_name, hire_date, datediff(now(),hire_date) 입사경과일수,
truncate(datediff(now(),hire_date)/7,0) 입사경과주수,
truncate(datediff(now(),hire_date)/365,0) 입사경과년수
from employees;

-- join
select first_name 사원명, employees.department_id, department_name 부서명
from employees,departments
where employees.department_id = departments.department_id
order by 1;
-- 명칭으로 간단하게
select first_name 사원명, e.department_id, department_name 부서명
from employees e,departments d
where e.department_id = d.department_id
order by 1;

-- 이름에 le 포함 사원들만 부서명 조회 
select first_name 사원명, e.department_id 부서코드, department_name 부서명
from employees e inner join departments d on e.department_id=d.department_id
where instr(first_name,'le') >= 1
order by 1;