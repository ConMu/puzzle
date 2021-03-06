package nums;

public class uniquePaths {
   /* 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。

    问总共有多少条不同的路径？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/unique-paths
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] grid = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j ==0){
                        grid[i][j] = 1;
                    } else if (i == 0){
                        grid[i][j] = grid[i][j-1];
                    }else if (j == 0){
                        grid[i][j] = grid[i-1][j];
                    }else {
                        grid[i][j] = grid[i-1][j] + grid[i][j-1];
                    }
                }
            }
            return grid[m-1][n-1];
        }
    }
}
