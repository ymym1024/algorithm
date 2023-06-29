
public class P17682 {
    // 다트게임
    // 문제 요약
    // S-> 1제곱, D -> 2제곱, T -> 3제곱
    // * => 지금 점수와 바로전에 받은 점수 두배 / 처음에 나오면 스타상만 2배
    // # => 점수 마이너스 / 뒤나 앞에 * 나오면 -2 배

    // 알고리즘 => 문자열이라 정규식으로 문자 숫자 추출
    // 1. 입력받은 문자열을 정규식을 이용하여 숫자 부분과 연산부분을 배열로 추출
    // 2. 배열을 뒤부터 돌면서 제곱 값을 구해줌
    // 3. * 문자가 포함되어 있을 땐 제곱값에 *2 해주고, 앞에 값도 *2 해줘야 하므로 cnt로 세줌
    // 4. # 문자가 포함되어 있을 땐 제곱값에 -1 곱해줌
    // 5. cnt 가 1일땐(뒤에 *가 있는 경우) 제곱값에 *2, 초기화
    // 6. answer 변수에 연산된 값 더해줌
    // 7. answer 리턴

    public int solution(String dartResult) {
        int answer = 0;
        String[] num = dartResult.split("\\D+");
        String[] operate = dartResult.split("[0-9]+");

        double before = 0;
        int cnt=0;

        for(int i=operate.length-1;i>=1;i--){
            int score = Integer.parseInt(num[i-1]);
            int pow = 0;

            if(operate[i].contains("S")) pow = 1;
            if(operate[i].contains("D")) pow = 2;
            if(operate[i].contains("T")) pow = 3;

            before = Math.pow(score,pow);

            if(cnt == 1) {
                before*=2;
                cnt=0;
            }
            if(operate[i].contains("*")) {
                cnt++;
                before *= 2;
            }
            if(operate[i].contains("#")) before *= -1;

            answer+=before;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new P17682().solution("1D2S3T*"));
    }
}
