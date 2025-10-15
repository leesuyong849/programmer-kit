package BOJ_1283_단축키지정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        Set<Character> keys = new HashSet<Character>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] strings = bf.readLine().split(" ");
            int size = strings.length;


            boolean flag = false;
            for (int j = 0; j < size; j++) {
                flag = false;
                String word = strings[j];
                char lowerCase = Character.toLowerCase(word.charAt(0));

                if (!keys.contains(lowerCase)) {
                    keys.add(lowerCase);
                    flag = true;
                    strings[j] = "[" + word.charAt(0) + "]" + word.substring(1);
                    break;
                }
            }

            //만약 단어의 첫 글자에서 단툭어를 찾는데 실패하였다면  flag = false
            if (flag) {
                sb.append(String.join(" ", strings)).append("\n");
            } else {

                //전체 문자열의 왼쪽에서부터 시작
                String joinedString = String.join(" ", strings);
                boolean done = false;                                       //단축어를 만들수 있는지

                for (int j = 0; j < joinedString.length(); j++) {
                    char lower = Character.toLowerCase(joinedString.charAt(j));
                    if (lower == ' ') continue;
                    if (!Character.isLetter(lower)) continue;

                    if (!keys.contains(Character.toLowerCase(lower))) {
                        joinedString = joinedString.substring(0, j) + "[" + joinedString.charAt(j) + "]" + joinedString.substring(j+1);
                        sb.append(joinedString).append("\n");
                        keys.add(lower);
                        done = true;
                        break;
                    }
                }

                //단축어를 만들수 없는 경우는 그냥 출력
                if (!done) sb.append(joinedString).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
