package BOJ_20055_컨베이어벨트위의로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    class Node {
        int position, durability;

        public void Node(int p, int durability) {
            this.position = p;
            this.durability = durability;
        }
    }

    static int N, K;
    static int[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int level = 0;                              //몇 단계인지 저장

        map = new int[N * 2 + 1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= N * 2; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> robots = new ArrayList<>();


        while (true) {
            level++;

            int[] nextMap = new int[N * 2 + 1];
            nextMap[1] = map[N * 2];

            for (int i = 1; i < 2 * N; i++) {
                nextMap[i + 1] = map[i];
            }

            for (Integer robot : robots) {
                robot++;
            }

            //2.
            for (Integer robot : robots) {
                if (!robots.contains(robot + 1) && nextMap[robot + 1] >= 1) {
                    robot++;
                }
            }

            //3.
            if (!robots.contains(1)) {
                robots.add(1);
            }

            //4.
            long count = Arrays.stream(nextMap).filter(o -> o == 0).count();
            if (count >= K) break;
        }

        System.out.println(level);
    }
}
