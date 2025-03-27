import java.util.List;

public class DestructiveRobot {
    public static long PathCount(int nx, int ny, int numObstacles, int k, List<List<Integer>> obstacles) {
        // Create a grid representation
        int[][] grid = new int[nx][ny];
        // Mark obstacle cells
        for (List<Integer> obstacle : obstacles) {
            int x = obstacle.get(0);
            int y = obstacle.get(1);
            if (x < nx && y < ny) {
                grid[x][y] = 1;
            }
        }

        // Create a 3D DP array: dp[x][y][l] = paths to (x,y) having removed l obstacles
        long[][][] dp = new long[nx][ny][k + 1];

        // Base case: Starting cell (0,0)
        if (grid[0][0] == 1) {
            // If starting cell is obstacle, we must remove it (if k >= 1)
            if (k >= 1) {
                dp[0][0][1] = 1;
            }
        } else {
            // Starting cell is not obstacle
            dp[0][0][0] = 1;
        }

        // Fill the DP table
        for (int x = 0; x < nx; x++) {
            for (int y = 0; y < ny; y++) {
                // Skip the starting cell (already handled)
                if (x == 0 && y == 0) {
                    continue;
                }

                // Check if current cell is obstacle
                boolean isObstacle = grid[x][y] == 1;

                for (int l = 0; l <= k; l++) {
                    long paths = 0;

                    // Can come from the left (x-1)
                    if (x > 0) {
                        if (isObstacle) {
                            // Need to remove this obstacle
                            if (l > 0) {
                                paths += dp[x - 1][y][l - 1];
                            }
                        } else {
                            // No removal needed
                            paths += dp[x - 1][y][l];
                        }
                    }

                    // Can come from the top (y-1)
                    if (y > 0) {
                        if (isObstacle) {
                            // Need to remove this obstacle
                            if (l > 0) {
                                paths += dp[x][y - 1][l - 1];
                            }
                        } else {
                            // No removal needed
                            paths += dp[x][y - 1][l];
                        }
                    }

                    dp[x][y][l] = paths;
                }
            }
        }

        // Sum all possible paths with 0 to k removals at destination
        long totalPaths = 0;
        for (int l = 0; l <= k; l++) {
            totalPaths += dp[nx - 1][ny - 1][l];
        }

        return totalPaths;
    }
}