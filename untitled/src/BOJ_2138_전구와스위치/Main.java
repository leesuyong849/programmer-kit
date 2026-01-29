package BOJ_2138_전구와스위치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[] map;
    static char[] answer;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N];
        answer = new char[N];

        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            map[i] = s.charAt(i);
        }

        s = br.readLine();
        for (int i = 0; i < N; i++) {
            answer[i] = s.charAt(i);
        }

        int a = simulate(map.clone(), false); // 0번 스위치 안 누름
        int b = simulate(map.clone(), true);  // 0번 스위치 누름

        int ans = Integer.MAX_VALUE;
        if (a != -1) ans = Math.min(ans, a);
        if (b != -1) ans = Math.min(ans, b);

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static int simulate(char[] arr, boolean pressFrist) {
        int cnt = 0;

        if (pressFrist) {
            tog(arr, 0);
            cnt++;
        }

        for (int i = 1; i < N; i++) {
            if (arr[i-1] != answer[i-1]) {
                tog(arr, i);
                cnt++;
            }
        }

        //정답 체크
        for (int i = 0; i < N; i++) {
            if (arr[i] != answer[i]) return -1;
        }

        return cnt;
    }


    static void tog(char[] arr, int i) {
        change(arr, i - 1);
        change(arr, i);
        change(arr, i + 1);
    }

    static void change(char[] arr, int i) {
        if (i < 0 || i >= N) return;

        arr[i] = (arr[i] == '0') ? '1' : '0';
    }
}
