public class P147355 {
    //1. p의 문자열 길이 파악
    //2. substring 함수로 p의 문자열 길이만큼 자름
    //3. 자른 문자열을 int형으로 변경 한 후 p와 비교
    //4. 큰 경우 cnt변수를 선언해서 1 증가시킴
    //5. 출력
    // 문자열 -> int형 변수로 바꿀 때 int 형 범위에 벗어나지 않는지 파악하자
    public int solution(String t, String p) {
        int answer = 0;
        int wordSize = p.length();
        for(int i=0;i<=t.length()-wordSize;i++){
            String word = t.substring(i,i+wordSize);
            if(Long.parseLong(word)<=Long.parseLong(p)){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new P147355().solution("10203","15"));
    }
}
