package BOJ_2666_벽장문의이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {

    static int N, M;
    static int open1, open2;
    static ArrayList<Integer> map;
    static int[][][] dp;
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        open1 = Integer.parseInt(st.nextToken());
        open2 = Integer.parseInt(st.nextToken());

        String s;
        if ((s = br.readLine()) != null) {
            map.add(Integer.parseInt(s));
        }
        M = map.size();

        dp = new int[M + 1][N + 1][N + 1];

        Integer tar = map.get(0);
        dp[0][open1][open2] = 0;

        for (int i = 0; i < M; i++) {
            Integer target = map.get(i);

            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    int cur = dp[i][a][b];
                    if (cur == MAX) continue;   //기존에 사용하지 않은 방법

                    int moveA = cur + Math.abs(target - a);
                    if (moveA < dp[i + 1][target][b]) dp[i + 1][target][b] = moveA;

                    int moveB = cur + Math.abs(target - b);
                    if (moveB < dp[i + 1][a][target]) dp[i + 1][a][target] = moveB;
                }
            }
        }


        int ans = MAX;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                ans = Math.min(ans, dp[M][i][j]);
            }
        }

        System.out.println(ans);
    }
}
