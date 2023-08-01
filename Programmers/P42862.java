import java.util.Arrays;
import java.util.PriorityQueue;

public class P42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer=0;
        int big=0;
        int small=0;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0;i<lost.length;i++) {
            for(int j=0;j<reserve.length;j++) {
                if(lost[i]==reserve[j]) {
                    lost[i]=-1;
                    reserve[j]=-1;
                    break;
                }
            }
        }
        for(int i=0;i<lost.length;i++) {
            for(int j=0;j<reserve.length;j++) {
                if(lost[i]==-1){
                    break;
                }
                big=lost[i]+1;
                small=lost[i]-1;
                if(big==reserve[j]||small==reserve[j]) {
                    answer++;
                    reserve[j]=-1;
                    break;
                }
            }
        }
        return n-(lost.length-answer);
    }
    public static void main(String[] args) {
        int[] lost = new int[]{2,3,4};
        int[] reserve = new int[]{1,2,3,6};
        System.out.println(new P42862().solution(7,lost,reserve));
    }
}
