package BOJ_2666_벽장문의이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

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

        String s;
        if ((s = br.readLine()) != null) {
            map.add(Integer.parseInt(s));
        }
        M = map.size();

        dp = new int[map.size()][N + 1][N + 1];

        System.out.println(dfs(0, open1, open2));
    }

    public static int dfs(int idx, int x, int y) {
        if (idx == M) return 0;

        if (dp[idx][x][y] != 0) {
            return dp[idx][x][y];
        }

        int target = map.get(idx);

        int moveLeft = Math.abs(x - target) + dfs(idx + 1, target, y);
        int moveRight = Math.abs(y - target) + dfs(idx + 1, x, target);

        dp[idx][x][y] = Math.min(moveLeft, moveRight);
        return dp[idx][x][y];
    }
}
