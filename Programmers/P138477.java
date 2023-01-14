import java.util.Arrays;

public class P138477 {
    // 1. k크기의 arr 배열, 발표점수를 담을 answer 배열 선언
    // 2. score 배열을 순차적으로 반복
    // 3. k되기 전 까지 score에 순차적으로 넣어줌
    // 4. k+1 인덱스 에서 score를 가져옴. arr 정렬, 최솟값 가져옴
    // 5. 최솟값이 score 보다 작은경우 arr에 추가해줌
    // 6. arr 배열 정렬 후 인덱스 0 출력
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int[] arr = new int[k];
        Arrays.fill(arr,2001);
        for(int i=0;i<score.length;i++){
            if(i < k) arr[i]=score[i];
            if(i >=k && arr[0] < score[i]) arr[0] = score[i];
            Arrays.sort(arr);
            answer[i] = arr[0]; //최솟값 출력
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        new P138477().solution(4, arr);
    }
}
