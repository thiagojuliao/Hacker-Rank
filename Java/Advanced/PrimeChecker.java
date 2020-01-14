import static java.lang.System.*;

class Prime{

    private boolean isPrime(int n){
        
        if (n == 1) return false;
        for (int i = 2; i <= n/2; i++){
            if (n % i == 0) return false;
        }
        return true;
    }

    public void checkPrime(int... n){
        
        for (int number : n){
            if (isPrime(number)) System.out.print(number + " ");
        }
        System.out.println();
    }
}

