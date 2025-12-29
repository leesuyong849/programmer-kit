package BOJ_17352_여러분의다리가되어드리겠습니다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Integer>[] map;
    static int[] resultMap;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new ArrayList[N+1];
        for (int i = 1; i < N + 1; i++) map[i] = new ArrayList<>();

        StringTokenizer st;
        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        resultMap = new int[N + 1];

        int mark = 1;
        for (int i = 1; i < N + 1; i++) {
            if (resultMap[i] == 0) dfs(i, mark++);
        }

        int a = findIndex(resultMap, 1);
        int b = findIndex(resultMap, 2);


        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append(a).append(" ").append(b));
    }

    static void dfs(int x, int mark) {
        resultMap[x] = mark;
        ArrayList<Integer> next = map[x];
        if (next == null) return;

        for (Integer i : next) {
            if (resultMap[i] == 0) dfs(i, mark);
        }
    }

    static int findIndex(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1; // 못 찾았을 경우
    }
}
