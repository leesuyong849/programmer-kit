package BOJ_5073;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<int[]> list = new ArrayList<>();
        StringTokenizer  st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            list.add(new int[]{a,b,c});
        }

        for (int[] ints : list) {
            int[] sorted = Arrays.stream(ints).sorted().toArray();

            //성립 안함
            if (sorted[2] >= sorted[1] + sorted[0]) {
                System.out.println("Invalid");
                continue;
            }

            //세변의 길이가 모두 같은경우
            if (sorted[2] == sorted[1] && sorted[1] == sorted[0]) {
                System.out.println("Equilateral");
                continue;
            }

            //두개만 같은 경우
            if (sorted[2] == sorted[1] || sorted[1] == sorted[0]) {
                System.out.println("Isosceles");
                continue;
            }

            //셋 다 다른 경우
            System.out.println("Scalene");
        }
    }
}
