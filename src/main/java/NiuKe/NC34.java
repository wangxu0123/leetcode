package NiuKe;

import org.junit.Test;

import java.util.Arrays;

public class NC34 {
    public int uniquePaths(int m, int n) {
        // write code here
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    @Test
    public void test() {
        
        System.out.println(uniquePaths(2, 1));
        
        
    }
}
