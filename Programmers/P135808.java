import java.util.Arrays;

public class P135808 {
    // 1. score 내림차순 정렬
    // 2. score 배열 길이 m만큼 자름
    // 3. (자른 배열의 마지막 인덱스 * 사과 갯수 * 상자 갯수)로 최대 이익을 구함
    // 4. answer에 최대 이익 더해줌
    // 5. k 보다 score[0] 이 작은 경우엔 0으로 return
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int count = 0;

        Arrays.sort(score);
        for(int i=score.length-1;i>=0;i--){
            count++;
            if(count==m) {
                answer += (score[i] * m);
                count = 0;
            }
            if(k<score[score.length-1]) return 0;
        }
        return answer;
    }
    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int[] score = new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println(new P135808().solution(k,m,score));
    }
}
