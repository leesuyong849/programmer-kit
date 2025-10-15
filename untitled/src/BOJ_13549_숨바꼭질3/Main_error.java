package BOJ_13549_숨바꼭질3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_error {

    static class Node implements Comparator<Node> {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compare(Node o1, Node o2) {
            return o1.y - o2.y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Node> que = new ArrayDeque<>();
        que.add(new Node(N, 0));

        while (!que.isEmpty()) {
            Node poll = que.poll();
            int pos = poll.x;
            int cnt = poll.y;

            if (pos * 2 == M) {
                System.out.println(cnt);
                break;
            } else {
                que.add(new Node(pos * 2, cnt));
            }

            if (pos - 1 == M) {
                System.out.println(cnt++);
                break;
            } else {
                que.add(new Node(pos - 1, cnt++));
            }

            if (pos + 1 == M) {
                System.out.println(cnt++);
                break;
            } else {
                que.add(new Node(pos + 1, cnt++));
            }
        }


    }
}
