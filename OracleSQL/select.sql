-- bwriter가 헝그리인 모든 컬럼의 값을 가져오시오
select *
from board
where bwriter='헝그리';

-- bwriter가 '헝그리'인 bno, btitle,bwriter을 가져오시오
select bno, btitle, bwriter
from board
where bwriter='헝그리';

-- bno가 1에서 10사이의 게시물을 가져오시오
select bno, btitle, bwriter
from board
where bno between 1 and 10;
-- where bno>=1 and bno<=10;

-- bwriter가 '그'을 포함하는 시작하는 게시물의 bno, btitle, bwriter을 가져오시오
select bno, btitle, bwriter
from board
where bwriter LIKE '%스%';

--게시물의 제목 중에 '제목'가 포함되어 있는 게시물의 번호, 제목,글쓴이을 가져오시오
select bno, btitle, bwriter
from board
where btitle LIKE '%제목%';

--게시물의 제목,내용 중에 '자바'가 포함되어 있는 게시물의 번호, 제목,글쓴이, 내용을 가져오시오
select bno, btitle, bwriter,bcontent
from board
where btitle LIKE '%자바%' or bcontent LIKE '%자바%';

-- 글쓴이가 '감자바', '김길동' ,'라즈베리' 인 게시물의 번호, 제목, 글쓴이를 가져오시오
select bno, btitle, bwriter
from board
where bwriter IN('감자바', '김길동' , '라즈베리');
-- where bwriter='감자바' or bwriter='김길동' or bwriter='라즈베리';

-- 첨부파일이 없는 게시물을 가져오시오
select *
from board
where boriginalfilename is null;
-- 주의: null에선 비교연산자 =를 쓰면 안됨

-- 첨부파일이 있는 게시물을 가져오시오
select *
from board
where boriginalfilename is not null; -- <> 다르냐고 물어보는 것

-- 게시물을 작성한 사람의 이름을 가져오시오(중복 제거하고=> "distinct")
select distinct bwriter from board;

-- 게시글을 쓴 날짜가 2016년인 게시글을 가져오시오.
select *
from board
-- where '2016.01.01' <= bdate and bdate <='2016.12.31';
where bdate between '2016.01.01' and '2016.12.31';

-- bno->번호, btitle->제목, bwriter->글쓴이 로 컬럼 이름을 변경하여 가져오시오
select bno as 번호, btitle as 제목, bwriter 글쓴이 --  as는 생략이 가능하다, 결과 셋에서만 이름바뀌게 한다
from board;

/*
  정렬
*/

-- 게시물의 번호를 기준으로 올림차순으로 가져오시오
select * 
from board
order by bno asc; --  생략해도 기본적으로 asc

-- 2017년에 작성한 게시물의 번호를 기준으로 내림차순으로 가져오시오
select *
from board
where bdate between '2017.01.01' and '2017.12.31'
order by bno desc;

-- 글쓴이를 기준으로 1차 올림차순정렬하고 쓴 날짜를 기준으로 2차 내림차순정렬 하시오
select *
from board
order by bwriter, bdate desc;

/* 
  페이징 처리 : 한 페이지에 보여줄 수 있는 것
  rownum : 실제 데이터 베이스 목록 번호가 아니라 select하면서 번호가 매겨진 것
*/
-- 저장되어 있는 순서대로 행 번호 매기기
select rownum, bno, btitle, bwriter, bdate, bhitcount
from board;

-- 정렬 후 행 번호 매기기
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select rownum, bno, btitle, bwriter, bdate, bhitcount from board order by bno desc); -- 서브 쿼리 : select 안의 또 select, 서브쿼리는 테이블 내용으로 쓰기도 함


-- 특정 행번호 이하만 가져오기(Top n(위에서 부터 n개)를 가져오기)
select rownum, bno, btitle, bwriter, bdate, bhitcount
from (select rownum, bno, btitle, bwriter, bdate, bhitcount from board order by bno desc) -- 서브 쿼리 : select 안의 또 select, 서브쿼리는 테이블 내용으로 쓰기도 함
where rownum <=10;
--where rownum >=10; 앞으로 몇개 더 가져와야 할 지 모름

-- 시작 행 번호와 끝 행 번호 사이의 게시물 가져오기*****
select r,bno, btitle, bwriter, bdate, bhitcount
from(
  select rownum as r, bno, btitle, bwriter, bdate, bhitcount
  from (select rownum, bno, btitle, bwriter, bdate, bhitcount from board order by bno desc) -- 서브 쿼리 : select 안의 또 select, 서브쿼리는 테이블 내용으로 쓰기도 함
  --where rownum <=(pageNo*rowsPerPage)
   where rownum <=(2*10)
)
--where r>=((pageNo-1)*rowsPerPage + 1);
where r>=((2-1)*10 + 1);

/*
  행 수 구하기
*/
-- 전체 행 수 구하기
select count (*) from board;

-- bno 개수 (bno 중 널이 아닌 것들)
select count(bno) from board;

-- boriginalfilename 개수 (  boriginalfilename 중 널이 아닌 것들)
select count(boriginalfilename) from board;

-- 특정 조건에 맞는 행 수 구하기
select count(*) from board where bwriter <> '홍길동';

