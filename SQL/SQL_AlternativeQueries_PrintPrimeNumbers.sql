DECLARE @MAX_NUM INT = 1000
DECLARE @NUM INT = 3
DECLARE @PRIMES VARCHAR(1000) = "2"
DECLARE @ITER INT = 0
DECLARE @MAX_ITER INT = 0
DECLARE @IS_PRIME INT = 1

WHILE @NUM <= @MAX_NUM
BEGIN
    SET @ITER = 2
    SET @MAX_ITER = @NUM / 2
    SET @IS_PRIME = 1
    
    WHILE @ITER <= @MAX_ITER
    BEGIN
        IF @NUM % @ITER = 0
            SET @IS_PRIME = 0
        SET @ITER += 1
    END;
    
    IF @IS_PRIME = 1
        SET @PRIMES += "&" + CAST(@NUM AS VARCHAR)
    SET @NUM += 1
END;

PRINT @PRIMES