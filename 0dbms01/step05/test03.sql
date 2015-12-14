-- 페이징 처리

-- 1) 페이징 적용 전
select bno, title
from board
order by bno desc;

-- 2) 페이징 적용 후
-- limit 시작인덱스, 개수
select bno, title
from board
order by bno desc
limit ((페이지번호-1) * 페이지당개수), 페이지당개수;

