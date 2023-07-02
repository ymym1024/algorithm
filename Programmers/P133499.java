public class P133499 {
    // 접근 방식
    // 1. 문자열을 반복하면서 발음은 연속해서 발음 못하므로 발음 가능한 연속 문자를 "."로 replace
    // 2. 주어진 문자를 replace 했을 때 발음할 수 있는 문자가 지워지고 나서 발음 가능한 문자가 지워지면 안되기 때문에 ' '로 replace 해줌
    // 3. 마지막으로 trim을 해서 남아있는 문자의 길이를 재줌
    // 4. 문자의 길이가 0인 경우 발음할 수 있는 문자이기 때문에 answer 를 하나 증가시켜줌

    public int solution(String[] babbling) {
        int answer = 0;
        for(String b : babbling){
            b = b.replaceAll("ayaaya|yeye|woowoo|mama","$");
            b = b.replace("aya"," ").replace("ye"," ").replace("woo"," ").replace("ma"," ").replace(" ","");
            if(b.length() == 0) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] babbling = new String[]{"wooyemawooye"};
        System.out.println(new P133499().solution(babbling));
    }
}
