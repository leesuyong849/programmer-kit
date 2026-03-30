package BOJ_2179_비슷한단어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static String[] map;   // 원래 입력 순서대로 출력하기 위한 배열
    static Node[] nodes;

    static class Node {
        String str;
        int index; // 원래 입력 순서

        Node(String str, int index) {
            this.str = str;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new String[N];
        nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            map[i] = s;
            nodes[i] = new Node(s, i);
        }

        // 1. 문자열 기준 사전순 정렬
        Arrays.sort(nodes, (a, b) -> a.str.compareTo(b.str));

        // 2. 인접한 단어끼리 비교해서 최대 공통 접두사 길이 구하기
        int maxLcp = 0;
        for (int i = 0; i < N - 1; i++) {
            maxLcp = Math.max(maxLcp, lcp(nodes[i].str, nodes[i + 1].str));
        }

        // 3. maxLcp 길이의 접두사가 같은 연속 구간을 찾고,
        //    각 구간에서 원래 인덱스가 가장 작은 두 개를 후보로 선택
        int answer1 = Integer.MAX_VALUE;
        int answer2 = Integer.MAX_VALUE;

        int i = 0;
        while (i < N) {
            int j = i;
            String p = prefix(nodes[i].str, maxLcp);

            while (j + 1 < N && prefix(nodes[j + 1].str, maxLcp).equals(p)) {
                j++;
            }

            // 구간 크기가 2 이상이면 후보가 될 수 있음
            if (j - i + 1 >= 2) {
                int first = Integer.MAX_VALUE;
                int second = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    int idx = nodes[k].index;
                    if (idx < first) {
                        second = first;
                        first = idx;
                    } else if (idx < second) {
                        second = idx;
                    }
                }

                // 더 앞선 쌍인지 비교
                if (first < answer1 || (first == answer1 && second < answer2)) {
                    answer1 = first;
                    answer2 = second;
                }
            }

            i = j + 1;
        }

        System.out.println(map[answer1]);
        System.out.println(map[answer2]);
    }

    static int lcp(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                cnt++;
            } else {
                break;
            }
        }
        return cnt;
    }

    static String prefix(String s, int len) {
        return s.substring(0, Math.min(len, s.length()));
    }
}