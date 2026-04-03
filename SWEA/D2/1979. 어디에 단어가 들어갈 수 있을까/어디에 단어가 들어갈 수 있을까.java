import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution {
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[][] puzzle = new int[N][N];
 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int e = sc.nextInt();
                    puzzle[i][j] = e;
                }
            }
 
            int answer = 0;
 
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (puzzle[y][x] == 1) {
                        boolean match = true;
                        if (x == 0 || puzzle[y][x - 1] == 0) {
                            for (int row = 1; row < K; row++) {
                                int nx = x + row;
                                if (nx >= N || puzzle[y][nx] == 0) {
                                    match = false;
                                    break;
                                }
                                if (row == K - 1 && nx + 1 < N) {
                                    if (puzzle[y][nx + 1] == 1) {
                                        match = false;
                                        break;
                                    }
                                }
                            }
                            if (match) answer++;
                        }
                            match = true;
                            if (y == 0 || puzzle[y - 1][x] == 0) {
                                for (int col = 1; col < K; col++) {
                                    int ny = y + col;
                                    if (ny >= N || puzzle[ny][x] == 0) {
                                        match = false;
                                        break;
                                    }
                                    if (col == K - 1 && ny + 1 < N) {
                                        if (puzzle[ny + 1][x] == 1) {
                                            match = false;
                                            break;
                                        }
                                    }
                                }
                                if (match) answer++;
                            }
                        }
                    }
                }
            System.out.println("#" + tc + " " + answer);
        }
    }
}