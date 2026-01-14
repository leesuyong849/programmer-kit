package BOJ_19637_IF문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Item implements Comparable<Item> {
        String name;
        int value;

        Item(String name, int value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public int compareTo(Item o) {
            return Integer.compare(this.value, o.value);
        }
    }

    static int N, M;
    static List<Item> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            map.add(new Item(s, num));
        }

        Collections.sort(map);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            int anInt = Integer.parseInt(s);

            String answer = map.get(0).name;
            for (Item item : map) {
                if (anInt <= item.value) {
                    answer = item.name;
                    break;
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
