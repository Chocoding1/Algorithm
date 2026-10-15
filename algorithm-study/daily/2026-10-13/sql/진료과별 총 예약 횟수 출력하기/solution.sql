-- 프로그래머스 SQL Lv.2
-- MySQL
SELECT MCDP_CD AS '진료과코드', COUNT(*) AS '5월예약건수'
FROM APPOINTMENT
WHERE '2022-05-01' <= APNT_YMD AND APNT_YMD < '2022-06-01'
GROUP BY MCDP_CD
ORDER BY `5월예약건수`, `진료과코드`;
-- 코드를 작성하세요.
