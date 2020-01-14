class MyCalculator {
   
    public long power(int n, int p) throws Exception{
        if (p == 0) return 1;
        if (p == 1 || n == 0) return n;
        if (n < 0 || p < 0) throw new Exception("n or p should not be negative.");
        if (n == 0 && p == 0) throw new Exception("n and p should not be zero.");
        return n * power(n, p-1);
    }    
}

