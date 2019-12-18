SELECT
    B.HACKER_ID,
    C.NAME,
    B.TOTAL_SCORE
FROM
    (   SELECT
            HACKER_ID,
            SUM(MAX_SCORE_ON_CHALLENGE_ID) AS TOTAL_SCORE
        FROM
            (   SELECT DISTINCT
                    HACKER_ID,
                    CHALLENGE_ID,
                    MAX(SCORE) OVER(PARTITION BY HACKER_ID, CHALLENGE_ID) AS            MAX_SCORE_ON_CHALLENGE_ID
                FROM
                    SUBMISSIONS
            ) AS A
        GROUP BY
            HACKER_ID
        HAVING
            SUM(MAX_SCORE_ON_CHALLENGE_ID) > 0
    ) AS B
INNER JOIN
    HACKERS AS C
ON
    B.HACKER_ID = C.HACKER_ID
ORDER BY
    TOTAL_SCORE DESC, HACKER_ID