import java.util.HashMap;

public class P92334 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        HashMap<String,Integer> map = new HashMap<>();
        return answer;
    }
    public static void main(String[] args) {
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        System.out.println(new P92334().solution(id_list,report,2));
    }
}
