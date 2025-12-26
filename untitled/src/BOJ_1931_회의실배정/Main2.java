package BOJ_1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<int[]> meetings = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new int[]{start, end});
        }

        meetings.sort(
                Comparator.comparingInt((int[] o) -> o[1])
                        .thenComparingInt((int[] o) -> o[0])
        );
        int end = 0;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int s = meetings.get(i)[0];
            int e = meetings.get(i)[1];

            if (s >= end) {
                end = e;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
