public class P136798 {
    // 문제 파악
    // 1. 각 숫자에 해당하는 약수 갯수 구함
    // 2. 갯수 반복하면서 limit 이내의 값은 result 변수에 합
    // 3. limit 벗어나는 경우엔 result에 power 대신 더함
    // 4. result 출력

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for(int i=1;i<=number;i++){
            int cnt = 0;
            for(int k=1;k<=Math.sqrt(i);k++){
                if(i % k == 0){
                    cnt++;
                    if(i / k != k) cnt++;
                }
            }
            if(cnt <= limit) answer+=cnt;
            else answer+=power;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new P136798().solution(10,3,2));
    }
}
