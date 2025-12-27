package BOJ_1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> map = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.add(new int[]{a,b});
        }

        map.sort(Comparator.comparingInt((int[] o) -> o[1]).thenComparingInt((int[] o) -> o[0]));

        int cnt = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            int[] cur = map.get(i);
            int s = cur[0];
            int e = cur[1];

            if (s >= end) {
                cnt++;
                end = e;
            }
        }

        System.out.println(cnt);
    }
}
