-- 데이터 변경
-- 1) 특정 컬럼 값 변경
-- 조건이 없으면 모든 데이터의 컬럼 값을 변경한다. 주의하라!
update board set views=views+1 where bno=1;

-- 2) 여러 개의 컬럼 값 변경
update board set 
  views=views+1, 
  cre_dt=now()
where bno=1;