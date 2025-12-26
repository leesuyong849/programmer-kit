package BOJ_12865_평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][2];


        for (int k = 0; k < K; k++) {
            for (int i = 1; i < N; i++) {
                dp[i][k] = dp[i-1][k];          //이전의 것을 그대로 가져온다.(추가적인 넣기가 없는 케이스)
                if (k - map[i][0] >= 0) {       //아직 더 넣을 수 있으면
                    dp[i][k] = Math.max(dp[i-1][k], map[i-1][k - map[1][0]]);
                }
            }
        }
    }
}
