public class PowXN {
    // TC -> O(n) SC -> O(1) for positive numbers only
    public int brute(int n, int x, int m) {
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = ans * x;
        }
        return ans % m;
    }

    // TC -> O(logn) SC -> O(1) for both negative and positive no
    public int optimal(int n, int x, int m) {
        int ans = 1;
        int nn = n;
        if (nn < 0)
            nn = nn * (-1);
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans = ans * x;
                nn = nn - 1;
            } else {
                x = x * x;
                nn = nn / 2;
            }
        }
        if(n < 0){
            ans = 1 / ans;
        }
        return ans % m;
    }

    public static int modularExponentiation(int x, int n, int m) {
        // Write your code here. 
         long ans = 1;
         long nx = x;
        while (n > 0) {
            if (n % 2 != 0) {
                ans = (ans%m * nx%m)%m;
            } 
                nx = (nx%m * nx%m)%m;
                n = n / 2;
        }
     
        return (int)(ans % m);       
    }
}
