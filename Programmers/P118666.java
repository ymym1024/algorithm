import java.util.HashMap;
import java.util.Map;

public class P118666 {
    // survey 접근 후 파라미터의 해당 글자가
    // choices[i]/4 -> 0이면 왼쪽인자 배열에 증가 , 1이면 오른쪽 인자 배열에 값 증가
    // 같은 지표가 동점인 경우 각 글자 charat 함수 이용해서 사전 순 출력
    // 출력된 글자를 모두 더해 return
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"TR", "RT", "TR"},
                new int[]{7,1,3}));
    }
    public static String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<Character,Integer> type = new HashMap<>();

        type.put('R',0); type.put('T',0);
        type.put('C',0); type.put('F',0);
        type.put('J',0); type.put('M',0);
        type.put('A',0); type.put('N',0);

        for(int i=0;i<choices.length;i++){
            if(choices[i]> 4) type.put(survey[i].charAt(1),type.get(survey[i].charAt(1))+choices[i] - 4);
            else if(choices[i] < 4) type.put(survey[i].charAt(0),type.get(survey[i].charAt(0))+ (4-choices[i]));
        }

        answer.append(type.get('R')<type.get('T') ? 'T':'R'); //같은 경우에는 사전 순 출력
        answer.append(type.get('C')<type.get('F') ? 'F':'C');
        answer.append(type.get('J')<type.get('M') ? 'M':'J');
        answer.append(type.get('A')<type.get('N') ? 'N':'A');

        return answer.toString();
    }
}
