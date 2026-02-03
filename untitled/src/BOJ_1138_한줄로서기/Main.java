package BOJ_1138_한줄로서기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        ArrayList<Integer> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            result.add(i);
        }

        for (int i = 0; i < N; i++) {
            int a = map[i];

            int idx = result.indexOf(i);
            result.remove(idx);
            result.add(idx + a, i);
        }

        StringBuilder sb = new StringBuilder();
        for (Integer integer : result) {
            sb.append(integer + 1).append(" ");
        }
        System.out.println(sb);
    }
}
