package mathUtils;
public class MathUtils {
    public static long abs (long n) {
        if(n < 0) {
            return -n;
        }
        return n;
    }

    public static short sign (long n) {
        if(n < 0) return -1;
        if(n > 0) return 1;
        return 0;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long factorial(int n) {
        if (n <= 2) {
            return n;
        }
        return n * factorial(n - 1);
    }
}