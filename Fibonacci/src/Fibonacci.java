import java.util.Date;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 40;

        long time1 = System.nanoTime();
        System.out.println("Fast algorithm: " + getFibonacci(n));
        long diff1 = (System.nanoTime() - time1) / 1000000;
        System.out.println("Took: " + diff1 + " milliseconds.");

        long time2 = System.nanoTime();
        System.out.println("Slow algorithm: " + slowFibonacci(n));
        long diff2 = (System.nanoTime() - time2) / 1000000;
        System.out.println("Took: " + diff2 + " milliseconds.");
    }

    private static long getFibonacci(int n) {
        return findFibonacci(n, 0, 0, 1);
    }

    private static long findFibonacci(int n, int count, long f1, long f2) {
        if(count == n){
            return f1;
        } else {
            long f3 = f1 + f2;
            return findFibonacci(n, count + 1, f2, f3);
        }
    }

    private static long slowFibonacci(int n){
        if(n <= 1){
            return n;
        }
        return (slowFibonacci(n - 1) + slowFibonacci(n - 2));
    }

}
