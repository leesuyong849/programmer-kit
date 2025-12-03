package BOJ_20920_영단어암기는어려워;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

    static int N, M;
    static String[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map<String, Integer> cntMap = new HashMap<>();

        map = new String[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() < M) continue;
            map[i] = s;
            Integer fromMap = cntMap.getOrDefault(s, 0);
            cntMap.put(s, fromMap + 1);
        }

        Collections.sort(Arrays.stream(map).toList(), (o1, o2) -> {
            int f1 = cntMap.get(o1), f2 = cntMap.get(o2);
            if (f1 != f2) return  Integer.compare(f2, f1);
            int l1 = o1.toString().length(), l2 = o2.toString().length();
            if (l1 != l2) return Integer.compare(l2, l1);
            return o1.toString().compareTo(o2.toString());
        });

        StringBuilder sb = new StringBuilder();
        for (String s : map) {
            sb.append(s).append("\n");
        }

        System.out.println(sb.toString());
    }
}
