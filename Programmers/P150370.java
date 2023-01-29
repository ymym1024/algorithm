import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class P150370 {
    //1. terms를 순회하면서 terms를 해시테이블로 만듦
    //2. privacies의 배열을 하나씩 조회하면서 문자열을 빈칸 기준으로 분리
    //3. 등급을 가져 온 후 월에 해당하는 숫자를 더함
    //4. 월이 12를 넘어가면 년도를 하나 더해주고, 월에 12를 빼준다
    //5. today와 현재 년월일 비교해서 today보다 적으면 인덱스를 더해줌
    //6. list를 선언하고 배열을 순회하는 인덱스를 더해줌
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Hashtable<String,Integer> gradList = new Hashtable<String,Integer>();

        for(String t:terms){
          String g = t.split(" ")[0];
          int m = Integer.parseInt(t.split(" ")[1]);
          gradList.put(g,m);
        }

        int tYear = Integer.parseInt(today.split("[.]")[0]);
        int tMonth = Integer.parseInt(today.split("[.]")[1]);
        int tDay = Integer.parseInt(today.split("[.]")[2]);

        for(int i=0;i<privacies.length;i++){
            String pDay = privacies[i].split(" ")[0];
            String grade = privacies[i].split(" ")[1];

            int year = Integer.parseInt(pDay.split("[.]")[0]);
            int month = Integer.parseInt(pDay.split("[.]")[1]);
            int day = Integer.parseInt(pDay.split("[.]")[2]);

            month+=gradList.get(grade);

            if(month > 12){
                year+=1; month-=13;
            }
            day-=1;

            if(day == 0) day=28;
            System.out.println("Y"+year+"M"+month+"D"+day);
            //year, month, day
            if(tYear<=year && tMonth<=month && tDay <=day) answer.add(i);
        }

        int[] nAnswer = new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            nAnswer[i] = answer.get(i);
            System.out.println(nAnswer[i]);
        }
        return nAnswer;
    }

    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        new P150370().solution(today,terms,privacies);
    }
}
