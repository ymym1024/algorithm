import java.io.*;
import java.util.*;

public class B10825 {
    //시간복잡도 : O(nlogn)
    // 로직
    // Collection sort 의 Comparator 인터페이스를 구현하여 국어, 영어, 수학, 이름 순으로 비교해서 정렬

    static class Grade{
        String name;
        int korean;
        int math;
        int english;

        public Grade(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.math = math;
            this.english = english;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<Grade> gradeList = new ArrayList<>();
        for(int i=0;i<N;i++){
            String[] s = br.readLine().split(" ");
            Grade e = new Grade(s[0],Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]));
            gradeList.add(e);
        }
        //국어 내림차순, 영어 오름차순, 수학 내림차순, 이름 사전순
        Collections.sort(gradeList, new Comparator<Grade>() {
            @Override
            public int compare(Grade g1, Grade g2) {
                if(g1.korean != g2.korean) {
                    return g2.korean - g1.korean;
                }else{
                    if(g1.english != g2.english){
                        return g1.english - g2.english;
                    }else{
                        if(g1.math!=g2.math){
                            return g2.math - g1.math;
                        }else{
                            return g1.name.compareTo(g2.name);
                        }
                    }

                }
            }
        });

        for(Grade g : gradeList){
            bw.write(g.name+"\n");
        }
        bw.flush();
        bw.close();
    }
}
