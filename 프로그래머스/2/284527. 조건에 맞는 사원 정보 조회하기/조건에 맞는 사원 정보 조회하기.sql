SELECT
    SUM(B.SCORE) AS SCORE,
    B.EMP_NO,
    A.EMP_NAME,
    A.POSITION,
    A.EMAIL
FROM
    HR_EMPLOYEES A JOIN HR_GRADE B
    ON
        A.EMP_NO = B.EMP_NO
GROUP BY
    B.EMP_NO
HAVING
    SUM(B.SCORE) = (
        SELECT 
            MAX(SCORE)
        FROM
            (
                SELECT
                    SUM(SCORE) AS SCORE
                FROM
                    HR_GRADE
                WHERE
                    YEAR = 2022
                GROUP BY
                    EMP_NO
            ) AS TOTAL_SCORE
    )