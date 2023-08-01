import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P77484 {
    // 접근
    // 1. lottos 배열과 win_nums 배열 비교 후 일치하는 갯수를 최저순위번호로 저장
    // 2. lottos 배열 내부의 0의 갯수를 최저순위번호와 저장 후 최고순위번호로 리턴

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> winList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());

        int min = 0;
        int max = 0;

        for(int num : lottos){
            if(winList.contains(num)) min++;
            if(num == 0) max++;
        }
        answer[0] = 6-(max+min)+1; //최고
        answer[1] = 6-min+1; //최저

        if(answer[1] == 7) answer[1] = 6;
       // if(answer[0] == 0) answer[0] = 1;
        if(answer[0] == 7) answer[0] = 6;
        return answer;
    }

    public static void main(String[] args) {
        int[] lottos = new int[]{1, 2, 3, 4, 5, 6};
        int[] win_nums = new int[]{7, 8, 9, 10, 11, 12};
        int[] so = new P77484().solution(lottos,win_nums);

        for(int s:so){
            System.out.println(s);
        }
    }
}
