import java.util.Arrays;

public class P14743 {
    // lost - reserve 배열 돌면서 lost+1 , lost-1 숫자가 배열에 있으면
    // reserve 배열 해당 숫자 초기화
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0; // 체육복 대여 학생수 체크 변수
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i =0; i<reserve.length;i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == lost[j]) {
                    reserve[i] = -1;
                    lost[j] = -1;
                    answer++;
                    break;
                }
            }
        }

        for(int i =0; i<lost.length;i++) {
            for(int j=0;j<reserve.length;j++){
                if(reserve[j] == lost[i]+1 || reserve[j] == lost[i]-1){
                    reserve[j] = -1;
                    answer++;
                    break;
                }
            }
        }
        return n- lost.length + answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(5,new int[]{2,4},new int[]{3}));
    }
}
