package BOJ_14719_빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int H, W, result;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        result = 0;
        map = new int[W];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right =  W - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;
        while (left < right) {
            if (map[left] <= map[right]) {
                leftMax = Math.max(leftMax, map[left]);
                water += leftMax - map[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, map[right]);
                water += rightMax - map[right];
                right--;
            }
        }

        System.out.println(water);
    }
}
