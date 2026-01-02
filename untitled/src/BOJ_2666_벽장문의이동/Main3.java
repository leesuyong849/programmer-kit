package BOJ_2666_벽장문의이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main3 {

    static int N, M;
    static int open1, open2;
    static ArrayList<Integer> map;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        open1 = Integer.parseInt(st.nextToken());
        open2 = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        M = N - 2;
        for (int i = 0; i < M; i++) {
            map.add(Integer.parseInt(br.readLine()));
        }

        dp = new int[M + 1][N + 1][N + 1];


    }

    public static void dfs(int time, int x, int y) {
        if (time == M) return;

        int cur = dp[time][x][y];
        Integer next = map.get(time);

        int cal = Math.abs(x - next);
        if (cal < dp[time + 1][x][next]) dp[time + 1][x][next] = cal;

        cal = Math.abs(y - next);
        if (cal < dp[time + 1][next][y]) {}
    }
}
