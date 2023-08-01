import java.util.HashMap;

public class P42576 {
    public String solution(String[] participant, String[] completion) {
        String answer="";

        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<participant.length;i++){
            int val = hm.getOrDefault(participant[i],0);
            hm.put(participant[i],++val);
        }
        for(int i=0;i<completion.length;i++){
            int val = hm.getOrDefault(completion[i],0);
            hm.put(completion[i],--val);
        }
        for(String key:hm.keySet()){
            if(hm.getOrDefault(key,0) != 0) answer = key;
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};
        System.out.println(new P42576().solution(participant,completion));
    }
}
