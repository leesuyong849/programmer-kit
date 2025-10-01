package BOJ_2292;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int range = 1;
        int cnt = 1;
        while (true) {
//            if (N == 1) {
//                break;
//            }
            int thisTime = range + 6 * (cnt);
            int nextTime = thisTime + 6 * (cnt + 1);

            if (N < nextTime) {
                break;
            }

            cnt++;
            range = thisTime;
        }

        System.out.println(cnt + 1);
    }
}
