package BOJ_1027_고층건물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            int count = 0;

            // 왼쪽 보기
            double maxSlope = Double.NEGATIVE_INFINITY;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double) (map[j] - map[i]) / (j - i);
                if (slope > maxSlope) {
                    maxSlope = slope;
                    count++;
                }
            }

            // 오른쪽 보기
            maxSlope = Double.NEGATIVE_INFINITY;
            for (int j = i + 1; j < N; j++) {
                double slope = (double) (map[j] - map[i]) / (j - i);
                if (slope > maxSlope) {
                    maxSlope = slope;
                    count++;
                }
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);

    }
}
