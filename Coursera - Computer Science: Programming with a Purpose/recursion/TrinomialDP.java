public class TrinomialDP {
    
    public static long trinomial(int n, int k) {
        long[][] arr = new long[n + 1][n + 1];
        arr[0][0] = 1;
        
        if ((k < -n) || (k > n)) {
            return 0;
        }
        
        k = Math.abs(k);
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                //What I am doing here is making use of the fact that T(n, k) = T(n, -k), i.e., arr[i][-j] = arr[i][j] as negative indices cannot exist in Java arrays!
                //Alternatively, if I needed an array that allowed for negative indices, like in the program I needed an array from -n to n, I could have used an array with indices from 0 to 2n + 1
                if (((j - 1) < 0) && (-(j - 1) <= (i - 1))) {
                    arr[i][j] += arr[i - 1][-(j - 1)];
                }
                else if (((j - 1) <= (i - 1)) && ((j - 1) >= 0)) {
                    arr[i][j] += arr[i - 1][j - 1];
                }
                if (j <= (i - 1)) {
                    arr[i][j] += arr[i - 1][j];
                }
                if ((j + 1) <= (i - 1)) {
                    arr[i][j] += arr[i - 1][j + 1];
                }
            }
        }
        return arr[n][k];
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        System.out.println(trinomial(n, k));
    }
}
