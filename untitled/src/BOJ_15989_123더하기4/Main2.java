package BOJ_15989_123더하기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

    static int T, N;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(bf.readLine());
        map = new int[100001];
        map[1] = 1;
        map[2] = 2;


        for (int i = 0; i < T; i++) {
            int max3 = (int) Math.floor( N / 3);
            int cnt = 0;

            for (int j = max3; j >= 0; j--) {

            }

        }
    }
}
