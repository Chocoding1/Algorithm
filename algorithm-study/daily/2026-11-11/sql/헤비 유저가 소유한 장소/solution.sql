-- 프로그래머스 SQL Lv.3
-- MySQL
SELECT ID, NAME, HOST_ID
FROM PLACES
WHERE HOST_ID IN (SELECT HOST_ID
                 FROM PLACES
                 GROUP BY HOST_ID
                    HAVING COUNT(*) > 1)
ORDER BY ID;
-- 코드를 입력하세요
