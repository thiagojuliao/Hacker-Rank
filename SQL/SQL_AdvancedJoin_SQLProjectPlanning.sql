SELECT
    B.START_DATE,
    B.END_DATE
FROM
(SELECT DISTINCT
    START_DATE,
    MAX(END_DATE) OVER(PARTITION BY START_DATE ORDER BY START_DATE) AS END_DATE
FROM
    (   SELECT
            P1.START_DATE,
            P2.END_DATE,
            ROW_NUMBER() OVER(PARTITION BY P1.START_DATE ORDER BY P1.START_DATE, P2.END_DATE) AS RANK
        FROM
        (   SELECT
                1 AS ID,
                START_DATE
            FROM
                PROJECTS
        ) AS P1
        FULL JOIN
        (   SELECT
                1 AS ID,
                END_DATE
            FROM
                PROJECTS
        ) AS P2
        ON  P1.ID = P2.ID AND P1.START_DATE < P2.END_DATE) AS A
WHERE
    DATEDIFF(day, START_DATE, END_DATE) = RANK) AS B
LEFT JOIN
    PROJECTS AS C
ON B.START_DATE = C.END_DATE
WHERE
    C.END_DATE IS NULL
ORDER BY
    DATEDIFF(day, B.START_DATE, B.END_DATE), B.START_DATE