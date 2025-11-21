package BOJ_13305_주유소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Long> W;        //이동에 필요한 값
    static ArrayList<Long> price;        //기름 값

    /**
     * Long.MAX_VALUE, Long.parseLong이 존재하는 거 처음 알음
     */


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        W = new ArrayList<>();
        price = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N - 1; i++) {
            Long a = Long.parseLong(st.nextToken());
            W.add(a);
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            Long a = Long.parseLong(st.nextToken());
            price.add(a);
        }

        Long lowestPrice = Long.MAX_VALUE;
        Long totalPrice = 0L;
        for (int i = 0; i < N - 1; i++) {
            //앞으로 필요한 양 계산
            if (price.get(i) < lowestPrice) {
                totalPrice += W.get(i) * price.get(i);
                lowestPrice = price.get(i);
            } else {
                totalPrice += lowestPrice * W.get(i);
            }
        }

        System.out.println(totalPrice);
    }
}
