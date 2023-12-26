/*
  함수 : 전달된 컬럼값을 읽어들여서 함수를 실행한 결과를 반환
  
  - 단일행 함수 : N 개의 값을 읽어서 N개의 결과값을 리턴(매 행마다 함수 실행 결과 반환)  
  - 그룹 함수 : N 개의 값을 읽어서 1개의 결과값을 리턴(그룹별로 함수 실행 결과 반환)
  >> SELECT 절에 단일행 함수와 그룹 함수는 함께 사용하지 못함!
	왜? - 결과 행의 개수가 다르기 때문에 !!!!
    
  >> 함수를 사용할 수 있는 위치 : SELECT, WHERE, ORDER BY, GROUP BY, HAVING
  */
  
-- 단일행 함수


/* 
	문자 처리 함수
    
    LENGTH(컬럼|'문자열'): 해당 문자열값의 BYTE 길이 수 반환
    - 한글 한 글자 -> 3BYTE
    - 영문자, 숫자, 특수문자 한 글자 -> 1BYTE

	CHAR_LENGHT(컬럼|'문자열') : 해당 문자열값의 글자 수 반환
*/
SELECT
	length('데이터베이스'),char_length('데이터베이스'),
	length('데이터베이스'), char_length('database');
-- FROM DUAL; -- 가상 테이블: 데이터베이스 자체에서 제공하는 테이블 (MySQL 생략 가능!)
-- 사원명, 사원명의 글자수, 이메일, 이메일의 글자수 조회
SELECT emp_name, char_length(emp_name), email, char_length(email)
FROM employee;
/*
	INSTR(컬럼|'문자열', '찾으려는 문자열')
    - 특정 문자열에서 찾고자 하는 문자열의 위치 반환
    - 없으면 0 반환
*/
SELECT instr('AABAACAABBAA', 'B'); -- 3
SELECT instr('AABAACAABBAA', 'D'); -- 0
-- 's'가 포함되어 있는 이메일 중 이메일, 이메일의 @ 위치 조회
SELECT email, instr(email,'@')
FROM employee
WHERE email LIKE '%s%';
/*
	LPAD|RPAD(컬럼|'문자열', 최종적으로 반환할 문자의 길이, '덧붙이고자 하는 문자')
    - 문자열에 덧붙이고자 하는 문자를 왼쪽 또는 오른쪽에 덧붙여서
	최종적으로 반환할 문자의 길이만큼 문자열 반환	
*/
SELECT lpad('HELLO',10,'A');
SELECT rpad('HELLO',10,'*');
/*
	TRIM(컬럼|'문자열')
    TRIM([LEADING|TRAILING|BOTH] 제거하고자 하는 문자들 FROM 컬럼|'문자열')
    - 문자열의 앞/뒤/양쪽에 있는 지정한 문자들을 제거한 나머지 문자열 반환
*/
SELECT trim('        K H      '); -- 기본적으로 양쪽에 있는 공백 제거
SELECT trim(BOTH ' ' FROM '        K H      ');
SELECT trim(LEADING 'Z' FROM 'ZZZKHZZZ'); -- KHZZZ
SELECT trim(TRAILING 'Z' FROM 'ZZZKHZZZ'); -- ZZZKH
SELECT trim(BOTH 'Z' FROM 'ZZZKHZZZ'); -- KH
-- LTRIM : 앞쪽 공백만 제거
SELECT trim(LEADING ' ' FROM '        K H      ');
SELECT ltrim('        K H      ');
-- RTRIM : 뒤쪽 공백만 제거
SELECT trim(TRAILING ' ' FROM '        K H      ');
SELECT rtrim('        K H      ');
 
 /*
   SUBSTR|SUBSTRING(컬럼|'문자열', 시작 위치 값, 추출할 문자 개수)
   - 문자열에서 특정 문자열을 추출해서 반환 
 */
SELECT substr('PROGRAMMING',5,2); -- RA
SELECT substring('PROGRAMMING',1,6); -- PROGRA
SELECT substr('PROGRAMMING',-8,3); -- GRA
 
SELECT *  FROM employee;

-- 여자 사원들의 이름(emp_name), 주민등록번호(emp_no) 조회

SELECT emp_name, emp_no
FROM employee
WHERE substr(emp_no, instr(emp_no,'-') + 1 , 1) = 2;

-- 남자 사원들의 이름, 주민등록번호 조회 
 
SELECT emp_name, emp_no
FROM employee
WHERE substr(emp_no, 8, 1) = 1;
 
/*
 LOWER|UPPER(컬럼|'문자열')
 - LOWER : 다 소문자로 변경한 문자열 반환
 - UPPER : 다 대문자로 변경한 문자열 반환

*/ 
SELECT lower('Welcome To My World!'),
       upper('Welcome To My World!');
       
/*
	REPLACE(컬럼|'문자열','바꾸고 싶은 문자열','바꿀 문자열')
	- 특정 문자열로 변경하여 반환
*/
SELECT replace('서울특별시 강남구 역삼동', '역삼동', '삼성동');

/*
	CONCAT(컬럼|'문자열', 컬럼|'문자열', ...)
    - 문자열 하나로 합친 후 결과 반환
*/
SELECT concat('가나다라','ABCD'); -- 가나다라ABCD
SELECT concat('가나다라','ABCD','1234'); -- 가나다라ABCD1234



--  실습문제 -----------------------------------------
-- 1. 이메일의 kh.or.kr을 gmail.com으로 변경해서 이름, 변경 전 이메일, 변경 후 이베일 조회
SELECT emp_name, email"변경전", replace(email,'kh.or.kr','gmail.com')
FROM employee;


-- 2. 사원명과 주민등록번호(000000-0******)으로 조회
-- replace, concat, rpad, substr
SELECT emp_name, replace(emp_no,'-0000000','-0******')
FROM employee;


-- 3. 사원명, 이메일, 이메일에서 추출한 아이디 조회 (@ 앞)
-- replace, trim, substr
SELECT emp_name, email, substr(email,1,)
FROM employee
WHERE 


SELECT * FROM employee;

SELECT name