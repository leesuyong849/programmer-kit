package BOJ_11501_주식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int T, N;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            map = new int[N];
            for (int a = 0; a < N; a++) {
                map[a] = Integer.parseInt(st.nextToken());
            }

            int std = map[N - 1];
            long result = 0;
            for (int a = N - 2; a >= 0; a--) {
                if (map[a] > std) {
                    std = map[a];
                } else {
                    result += (long) std - map[a];
                }
            }

            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }

    public static void teat() {
        int[][] dp = new int[N][3];
        int[][] dp_cnt = new int[N][3];
        dp[0][0] -= map[0];
        dp_cnt[0][0] = 1;

        dp[0][1] = 0;
        dp[0][2] = 0;

        dp_cnt[0][1] = 1;
        dp_cnt[0][2] = 1;

        for (int i = 1; i < N; i++) {

        }

    }
}
