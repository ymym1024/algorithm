import java.util.*;

public class P42889 {
    public int[] solution(int N, int[] stages) {
        // 실패율 = 클리어 못한 사람 수 / (총 유저 수-스테이지n에 있는 유저 수)
        // 사용할 자료구조 : Map(각 단계의 실패율을 담고 있음)
        // 로직
        // 1. map을 선언한 후 N크기 이하의 키와 값을 생성
        // 2. stages를 돌면서 각 stage의 유저 수를 구함
        // 3. map을 돌면서 stages의 실패율을 구하고, 다시 map을 초기화 해줌
        // 4. map을 실패율 기준으로 내림차순 했을 때 키를 answer에 담아주어 리턴
        int[] answer = new int[N];

        Map<Integer,Double> map = new HashMap<>();

        for(int i=1;i<=N;i++){
            map.put(i,0.0);
        }

        for(int i=0;i<stages.length;i++){
            if(map.containsKey(stages[i])){
                map.put(stages[i],map.getOrDefault(stages[i],0.0)+1);
            }
        }

        List<Integer> keySet = new ArrayList<>(map.keySet());
        int users = stages.length;
        for (int key : keySet){
            if(map.get(key) == 0.0) continue;
            double value = map.getOrDefault(key,0.0) / users;
            users-= map.getOrDefault(key,0.0).intValue();
            map.put(key,value);
        }

        Collections.sort(keySet, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        int index = 0;
        for(int key : keySet){
            answer[index++] = key;
        }

        return answer;
    }

    public static void main(String[] args) {
        int N = 2;
        int[] stages = new int[]{1,1,1,1};
        System.out.println(new P42889().solution(N,stages));
    }
}
