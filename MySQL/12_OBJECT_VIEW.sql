/*
	뷰(View)
    - SELECT문을 저장할 수 있는 객체
    - 가상 테이블 (실제 데이터가 담겨 있는 건 X => 논리적인 테이블)
    - DML(INSERT, UPDATE, DELETE) 작업이 가능하다. 
    
    * 사용 목적
    - 편리성 : SELECT문의 복잡도 완화
    - 보안성 : 테이블의 특정 열을 노출하고 싶지 않은 경우
*/
-- '한국'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
-- '러시아'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
-- '일본'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회

-- >> employee, department, location, national
SELECT * FROM employee; -- emp_id, emp_name, dept_code
SELECT * FROM department; -- dept_id, location_id
SELECT * FROM location; -- local_code, national_code
SELECT * FROM national; -- national_code, national_name

-- '한국'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT emp_id, emp_name, dept_title, salary, national_name
FROM employee, department, location l, national n
WHERE dept_code = dept_id
	AND location_id = local_code
    AND l.national_code = n.national_code
	AND national_name = '한국';

SELECT emp_id, emp_name, dept_title, salary, national_name
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN location ON (location_id = local_code)
    JOIN national USING (national_code)
WHERE national_name = '한국';


-- '러시아'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT * FROM employee; -- emp_id, emp_name, dept_code
SELECT * FROM department; -- dept_id, location_id
SELECT * FROM location; -- local_code, national_code
SELECT * FROM national; -- national_code, national_name

SELECT emp_id, emp_name, dept_title, salary, national_name
FROM employee, department, location l, national n
WHERE dept_code = dept_id
	AND location_id = local_code
    AND l.national_code = n.national_code
	AND national_name = '러시아';

SELECT emp_id, emp_name, dept_title, salary, national_name
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN location ON (location_id = local_code)
    JOIN national USING (national_code)
WHERE national_name = '러시아';


-- '일본'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회

SELECT * FROM employee; -- emp_id, emp_name, dept_code
SELECT * FROM department; -- dept_id, location_id
SELECT * FROM location; -- local_code, national_code
SELECT * FROM national; -- national_code, national_name

SELECT emp_id, emp_name, dept_title, salary, national_name
FROM employee, department, location l, national n
WHERE dept_code = dept_id
	AND location_id = local_code
    AND l.national_code = n.national_code
	AND national_name = '일본';

SELECT emp_id, emp_name, dept_title, salary, national_name
FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN location ON (location_id = local_code)
    JOIN national USING (national_code)
WHERE national_name = '일본';

/*
	1. VIEW 생성
    CREATE [OR REPLACE] VIEW 뷰명
    AS 서브쿼리(뷰에 저장된다);
    
    - OR REPLACE : 뷰 생성 시 기존에 중복된 이름의 뷰가 없다면 새로 뷰 생성,
						    기존에 중복된 이름의 뷰가 있다면 해당 뷰 갱신
*/
CREATE OR REPLACE VIEW VW_EMPLOYEE
AS SELECT emp_id, emp_name, dept_title, salary, national_name, job_name
    FROM employee
	JOIN department ON (dept_code = dept_id)
    JOIN location ON (location_id = local_code)
    JOIN national USING (national_code)
    JOIN job USING (job_code);

SELECT * FROM vw_employee;


-- '한국'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT * 
FROM vw_employee
WHERE national_name = '한국';

-- '러시아'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT * 
FROM vw_employee
WHERE national_name = '러시아';

-- '일본'에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT * 
FROM vw_employee
WHERE national_name = '일본';

/*
	2. 뷰 컬럼에 별칭 부여
    - 서브쿼리의 SELECT절에 함수식이나 산술연산식이 기술되어 있을 경우 반드시 별칭 지정!
*/
-- 사원의 사번, 사원명, 직급명, 성별(남/여), 근무년수를 조회할 수 있는
-- SELECT 문을 뷰(vw_emp_job)으로 정의

-- > emp_id, emp_name, job_name, substr(emp_no, 8, 1) = 2, hire_date
SELECT * FROM employee; -- emp_id, emp_name, job_code 
SELECT * FROM job; -- job_code, job_name

CREATE OR REPLACE VIEW vw_emp_job
SELECT  emp_id, 
		emp_name, 
        job_name, 
        emp_no, 
        timestampdiff(year, hire_date, now()) "근무년수",
	    IF(substr(emp_no, 8, 1) = 1 , '남자', '여자')"성별"
FROM employee
	JOIN job USING (job_code);

SELECT * FROM vw_emp_job;    

-- 성별이 남자인 사원의 사원명과 직급명 조회 
SELECT 사원명, 직급명
FROM vw_emp_job
WHERE 성별 = '남';

-- 근무년수가 20년 이상인 사원 조회
SELECT *
FROM vw_emp_job
WHERE 근무년수 >= 20;

/*
	3. VIEW를 이용해서 DML(INSERT, UPDATE, DELETE) 사용
		- 뷰를 통해서 조작하게 되면 실제 데이터가 담겨있는 베이스테이블에 반영됨
*/
CREATE OR REPLACE VIEW vw_job
AS SELECT job_code, job_name
	FROM job;

SELECT * FROM vw_job; -- 논리적인 테이블 (실제데이터가 담겨있지 x)
SELECT * FROM job;	  -- 베이스 테이블 (실제데이터가 담겨있음)

-- 뷰를 통해서 INSERT
INSERT INTO vw_job
VALUES('J8', '인턴'); -- job 테이블에 추가

-- 뷰를 통해서 UPDATE
UPDATE vw_job
SET job_name = '알바'
WHERE job_code = 'J8';

-- 뷰를 통해서 DELETE
DELETE FROM vw_job
WHERE job_code = 'J8';

/*
	4. DML 구문으로 VIEW 조작이 불가능한 경우
*/
-- 1) 뷰 정의에 포함되지 않은 컬럼을 조작하는 경우
CREATE OR REPLACE VIEW vw_job
AS SELECT job_code
	FROM job;
    
SELECT * FROM vw_job; -- job_code
SELECT * FROM job;

-- INSERT (에러)
INSERT INTO vw_job(job_code, job_name)
VALUES('J8', '인턴');

INSERT INTO vw_job
VALUES('J8'); -- 가능 !

-- UPDATE(에러)
UPDATE vw_job
SET job_name = '인턴'
WHERE job_code = 'J8';

UPDATE vw_job
SET job_code = 'J0'
WHERE job_code = 'J8'; -- 가능

-- DELETE 
DELETE FROM vw_job
WHERE job_name = '사원';

DELETE FROM vw_job
WHERE job_code = 'J0'; -- 가능!

-- 2) 뷰에 포함되지 않은 컬럼 중에 베이스가 되는 컬럼이 NOT NULL 제약조건이 지정된 경우
CREATE OR REPLACE VIEW vw_job
AS SELECT job_name
	FROM job;
    
-- INSERT -- job_code가 primary key ! 즉 not null 제약조건에 걸림 !
INSERT INTO vw_job
VALUES('인턴');

-- UPDATE
UPDATE vw_job
SET job_name = '알바'
WHERE job_name = '사원';

-- DELETE (에러) : 삭제가 되는 조건 - 자식 데이터가 존재하지 않은 경우
DELETE FROM vw_job
WHERE job_name = '알바';

SELECT * FROM job;
SELECT * FROM employee ;

-- 방금 삭제되신 분들!
INSERT INTO job
VALUES('J7', '사원');

-- 3. 산술표현식 또는 함수식으로 정의된 경우
-- 사번, 사원명, 급여, 연봉(salary * 12)을 조회한 SELECT 문으로 vw_emp_sal 뷰로 정의
CREATE OR REPLACE VIEW vw_emp_sal
AS SELECT emp_id, emp_name, salary, salary * 12 연봉
	FROM employee;
    
-- INSERT (에러) : 산술연산식으로 정의된 컬럼은 데이터 추가 불가능 !
INSERT INTO vw_emp_sal
VALUES(300, '홍길동', 3000000, 36000000);    

INSERT INTO vw_emp_sal(emp_id, emp_name, salary)
VALUES(300, '홍길동', 3000000, 36000000);

-- UPDATE (에러) : 산술연산으로 정의된 컬럼은 데이터 변경 불가능
UPDATE vw_emp_sal
SET 연봉 = 80000000
WHERE emp_id = 200;

UPDATE vw_emp_sal
SET salary = 7000000
WHERE emp_id = 200; -- 산술연산과 무관한 컬럼은 데이터 변경이 가능 !

START transaction;
-- DELETE 
DELETE FROM vw_emp_sal
WHERE 연봉 = 84000000 ;

SELECT * FROM employee;
ROLLBACK;
SELECT * FROM vw_emp_sal;

-- 4. 그룹함수나 GROUP BY 절을 포함한 경우
-- 부서별 급여의 합계, 평균을 조회한 SELECT 문을 vw_groupdept 뷰를 정의

CREATE OR REPLACE VIEW vw_groupdept
	AS SELECT dept_code, 
    format(sum(salary), 0) "합계", 
    format(avg(ifnull(salary, 0)), 0) "평균"
FROM employee	
GROUP BY dept_code;

SELECT * FROM vw_groupdept;

-- INSERT INTO
INSERT INTO vw_groupdept
VALUES('D11', 8000000, 4000000);

-- UPDATE (에러)
UPDATE vw_groupdept
SET 합계 = 8000000
WHERE dept_code = 'D1';

-- DELETE
DELETE FROM vw_groupdept
WHERE 합계 = 5210000;

-- 5. DISTINCT 구문이 포함된 경우
-- employee 테이블로 job_code만 중복없이 조회한 SELECT문을 vw_dt_job 뷰 정의

CREATE OR REPLACE VIEW vw_dt_job
	AS SELECT DISTINCT job_code
	FROM employee;

SELECT * FROM vw_dt_job;

-- INSERT (에러)
INSERT INTO vw_dt_job
VALUES('J8');

-- UPDATE (에러)
UPDATE vw_dt_job
SET job_code = 'J8'
WHERE job_code = 'J7';

-- DELETE
DELETE FROM vw_dt_job
WHERE job_code = 'J4';    


-- 6. JOIN을 이용해서 여러 테이블을 연결한 경우
-- 사원들의 사번, 사원명, 부서명 조회한 SELECT문을 vw_joinemp 뷰 정의

CREATE OR REPLACE VIEW vw_joinemp
AS SELECT emp_id, emp_name, dept_title
	FROM employee
			JOIN department ON (dept_code = dept_id) ;

SELECT * FROM vw_joinemp;
-- INSERT (에러)
INSERT INTO vw_joinemp
VALUES(300, '조세오', '총무부');

INSERT INTO vw_joinemp(emp_id, emp_name)
VALUES(300, '조세오');

-- UPDATE
UPDATE vw_joinemp
SET emp_name = '서동일'
WHERE emp_id = 200;

UPDATE vw_joinemp
SET dept_title = '회계부'
WHERE emp_id = 200;

-- DELETE (에러)
DELETE FROM vw_joinemp
WHERE emp_id = 200;

SELECT * FROM employee;
SELECT * FROM department;

-- 5. VIEW 옵션
-- WITH CHECK OPTION : 서브쿼리에 기술된 조건에 부합하지 않은 값으로 수정시 에러 발생 !!
-- 급여가 3000000원 이상인 사원들만 조회한 SELECT 문을 vw_emp 뷰 정의
CREATE OR REPLACE VIEW vw_emp
AS SELECT *
FROM employee
WHERE salary >= 3000000;

SELECT * FROM vw_emp;
SELECT * FROM employee;

START transaction;

-- 200번 사원의 급여를 200만원으로 변경 (뷰를 사용해서)

UPDATE vw_emp
SET salary = 2000000
WHERE emp_id = 200;

ROLLBACK;

-- WITH CHECK OPTION 사용 !
CREATE OR REPLACE VIEW vw_emp
AS SELECT *
		FROM employee
		WHERE salary >= 3000000
WITH CHECK OPTION;

UPDATE vw_emp
SET salary = 2000000
WHERE emp_id = 200; -- 에러 !!

UPDATE vw_emp
SET salary = 4000000
WHERE emp_id = 200;

