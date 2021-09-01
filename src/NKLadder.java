public class NKLadder {


    public static int countNumberOfWaysTopDown(int n, int k, int[][] a) {
        int result = 0;
        if (n == 0) {
            a[n][2] = 1;
            return 1;
        }
        for (int i = 1; i <= k; i++) {
            if (n >= 0 && (n - i) > -1) {
                result = result + (a[n - i][2] > 0 ? a[n - i][2] : countNumberOfWaysTopDown(n - i, k, a));
                a[n][2] = result;
            }
        }
        return result;
    }

    public static int countNumberOfWaysBottomUp(int n, int k,int[] a) {
        int result;
        a[0] = a[1] = 1;
        a[2]=a[1]+a[0];
        int i = 0;
        for (int j = 3; j <= n; j++) {
            if(j==k){ a[j]=2*a[j-1]; }
            else { a[j] = 2 * a[j - 1] - a[i-1]; }
            i++;
        }
        result=a[n];
        return result;
    }

    public static void main(String[] args) {
        int n = 4, k = 3;
        int[] a = new int[n + 1];
        System.out.println(countNumberOfWaysBottomUp(n,k ,a));
    }
}
