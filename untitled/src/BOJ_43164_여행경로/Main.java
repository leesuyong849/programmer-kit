package BOJ_43164_여행경로;

import java.util.*;

public class Main {
}

class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        HashMap<String, List<String>> graph = new HashMap<>();

        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            graph.computeIfAbsent(from, k -> List.of()).add(to);
        }

        //알파벳 순서로 가기로 했으므로 하나의 출발지에서 갈 수 있는 목적지들을 정렬
        for (List<String> value : graph.values()) {
            Collections.sort(value);
        }

        ArrayDeque<String> stack = new ArrayDeque<>();
        LinkedList<String> route = new LinkedList<>();

        //여행의 시작은 인천
        stack.push("INC");

        while(!stack.isEmpty()) {
            String cur = stack.peek();
            List<String> des = graph.get(cur);

            if (des != null && !des.isEmpty()) {
                String next = des.remove(0);
                stack.push(next);
            } else {
                route.addFirst(stack.pop());
            }
        }

        return route.toArray(new String[0]);
    }
}
