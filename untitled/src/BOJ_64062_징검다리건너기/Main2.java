package BOJ_64062_징검다리건너기;


public class Main2 {

}

class Solution64062_2 {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int low = 1, high = 200000000;

        //이분탐색
        while(low <= high) {
            int mid = (low + high) / 2;
            if (check(stones, k, mid)) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }

    private boolean check(int[] stones, int k, int mid) {
        int cnt = 0;
        for (int stone : stones) {
            if (stone - mid < 0) {
                cnt++;
                if (cnt >= k) return false;
            } else { cnt = 0; }
        }
        return true;
    }
}