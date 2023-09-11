import java.util.Date;

public class examples {
    public static int sum(int n){
        // Sum(1, N) = N * (N + 1) / 2 // O(1)
        int sum = 0;
        for(int i=1; i<=n; i++){ // O(n)
            sum += i;
        }
        return sum;
    }

    public static void simple(int n){
        for(int num = 2; num <= n; num++){ // O(n sqrt(n))
            boolean ok = true;
            for(int j = 2; j*j <= num; j++){
                if(num % j == 0){
                    ok = false;
                    break;
                }
            }
            if(ok){
                System.out.printf("%d, ", num);
            }
        }
    }

    public static int[] nums = new int[100]; // 1 2 3 4
    public static void cobes(int d, int K, int N){ // O(N^K)
        if(d == 0){
            for(int i=1; i<=K; i++){
                System.out.printf("%d ", nums[i]);
            }
            System.out.println();
            return ;
        }

        for(int i=1; i<=N; i++){
            nums[d] = i;
            cobes(d-1, K, N);
        }
    }

    public static int fib1(int n){ // РіР»СѓР±РёРЅР° - n, С€РёСЂРёРЅР° - 2 // O(2^n)
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib1(n-1) + fib1(n-2);
    }
    public static int fib2(int n){ // O(n)
        int[] F = new int[n+1];
        F[0] = 0;
        F[1] = 1;
        for(int i=2; i<=n; i++){
            F[i] = F[i-1] + F[i-2];
        }
        return F[n];
    }

    public static void test(){
        for(int i = 20; i<=50; i++) {
            Date start = new Date();
            fib1(i);
            Date end = new Date();
            long time1 = end.getTime() - start.getTime();

            start = new Date();
            fib2(i);
            end = new Date();
            long time2 = end.getTime() - start.getTime();

            System.out.printf("i: %d, time1: %d, time2: %d%n", i, time1, time2);
        }
    }
    public static void main(String[] args) {
        //simple(1000000);
        //cobes(4, 4, 6);
        //System.out.println(fib2(10));
        test();
    }
}