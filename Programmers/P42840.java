import java.util.ArrayList;
import java.util.List;

class P42480 {
    public int[] solution(int[] answers) {
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {2,1,2,3,2,4,2,5};
        int[] num3 = {3,3,1,1,2,2,4,4,5,5};

        int[] cnt = new int[3];

        for(int i=0;i<answers.length;i++){
            if(answers[i] == num1[i%5]) cnt[0]++;
            if(answers[i] == num2[i%8]) cnt[1]++;
            if(answers[i] == num3[i%10]) cnt[2]++;
        }

        int max = Math.max(cnt[0],Math.max(cnt[1],cnt[2]));
        List<Integer> list = new ArrayList<>(cnt.length);
        for(int i=0;i<cnt.length;i++){
            if(max == cnt[i]) list.add(i+1);
        }

        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        int[] answer = new P42480().solution(answers);
        for(int a : answer){
            System.out.print(a+" ");
        }
    }
}
