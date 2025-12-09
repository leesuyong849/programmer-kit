package BOJ_9935_문자열폭발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static String s, t;
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        int sLength = s.length();
        int tLength = t.length();

        stack = new Stack<>();

        for (int i = 0; i < sLength; i++) {
            char c = s.charAt(i);
            stack.push(c);

            int count = 0;

            if (stack.size() >= tLength) {          //스택이 포발 문자열보다 길 때에만 가능성이 있다.
                for (int j = 0; j < tLength; j++) {     //폭발 문자열 하나씩 비교 시작

                    if (stack.get(stack.size() - tLength + j) == t.charAt(j)) {
                        count++;
                    }

                    if (count == tLength) {
                        for (int k = 0; k < tLength; k++) {
                            stack.pop();
                        }
                    }

                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            for (char ch : stack) {
                sb.append(ch);
            }
        }

        System.out.println(sb);
    }
}
