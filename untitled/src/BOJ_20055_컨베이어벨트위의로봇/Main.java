package BOJ_20055_컨베이어벨트위의로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int level = 0;                              //몇 단계인지 저장

        map = new int[N * 2 + 1];
        map[0] = Integer.MAX_VALUE;
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N * 2; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] robots = new boolean[N + 1];


        while (true) {
            level++;

            //1
            int temp = map[2 * N];
            for (int i = 1; i < 2 * N; i++) {
                map[i + 1] = map[i];
            }
            map[1] = temp;

            if (robots[N - 1]) robots[N - 1] = false;
            for (int i = N - 1; i >= 1; i--) {
                robots[i + 1] = robots[i];
            }

            //2.
            for (int i = N - 1; i >= 1; i--) {
                if (robots[i] && !robots[i + 1] && map[i + 1] >= 1) {
                    robots[i + 1] = true;
                    robots[i] = false;
                }

                if (robots[N]) robots[N] = false;
            }

            //3.
            if (!robots[1] && map[1] != 0) {
                robots[1] = true;
                map[1]--;
            }

            //4.
            int zeroCnt = 0;
            for (int i = 1; i <= 2 * N; i++) if (map[i] == 0) zeroCnt++;
            if (zeroCnt >= K) break;
        }

        System.out.println(level);
    }
}
