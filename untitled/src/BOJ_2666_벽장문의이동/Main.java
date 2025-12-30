package BOJ_2666_벽장문의이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int open1, open2;
    static ArrayList<Integer> map;
    static int[][] dp;

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

        dp = new int[map.size()][2];

        dp[0][0] = Math.abs(open1 - map.get(0));
        int opt1_l = map.get(0);
        int opt1_r = open2;

        dp[0][1] = Math.abs(open2 - map.get(1));
        int opt2_l = open1;
        int opt2_r = map.get(0);

        for (int i = 1; i < map.size(); i++) {
            int min = Math.min(dp[i - 1][0], dp[i - 1][1]);

            dp[i][0] = Math.abs(opt1_l - map.get(0));
        }

    }
}
