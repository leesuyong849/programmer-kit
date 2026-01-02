package BOJ_3758_KCPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k, t, m, i, j, S;
    static int[] score;
    static int[] submissionCnt;
    static int[] log;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (true) {
            String s = br.readLine();
            if (s == null) break;

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            score = new int[n];
            submissionCnt = new int[n];
            log = new int[n];

            for (int a = 0; a < m; a++) {
                st = new StringTokenizer(br.readLine());
                i = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());
                S = Integer.parseInt(st.nextToken());
            }
        }
    }
}
