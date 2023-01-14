import java.util.Arrays;

public class P135808 {
    //1. score 배열 내림차순 정렬
    //2. score 배열을 돌면서 m 만큼 끊고, 새 배열 에서 (최소값 * m *1) 값을 만듦
    //3. 해당 값을 answer에 더해줌
    public int solution(int k, int m, int[] score) {
        int[] nScore = new int[score.length];
        int idx = 0;
        int answer = 0;

        Arrays.sort(score);
        for(int i=0;i<score.length;i++){
            nScore[i] = score[score.length-i-1];
        }

        while(true){
            if(idx >= nScore.length || idx+m > nScore.length) break;
            int[] arr = Arrays.copyOfRange(nScore, idx, idx+m);
            answer +=arr[arr.length-1] * m;
            idx +=m;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        System.out.println(new P135808().solution(4,3,arr));
    }
}
