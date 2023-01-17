import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1946 {
    // A 서류,면접 성적 < B 서류,면접 성적 -> A 선발 x, 서류나 면접기준으로 정렬하고 하나씩 비교하면서 해를 구해야함
    // 시간복잡도 : O(n)
    // 1. T 만큼 입력받고, 반복문을 돌면서 성적을 받는다
    // 2. 서류나 면접이 일등이면 반드시 선발 -> 서류점수 기준으로 오름차순 정렬
    // 3. 서류점수 1등은 무조건 선발이므로 신입사원의 최대 인원수를 저장할 변수 answer 선언, 1로 초기화
    // 4. 1등의 면접점수와 2등의 면접점수를 비교함, 1등의 면접점수 > 2등의 면접점수 일 경우 +1
    // 5. 1등 면점점수 > 2등 면접점수 인경우 면접 등수 갱신한다
    // 6. 면접점수 반환
    public static int solution(int apply,int[][] score){
        int answer = 1;
        // 정렬
        Arrays.sort(score,new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int m_score = score[0][1];
        for(int i=1;i<score.length;i++){
            if(m_score > score[i][1]){
                answer++;
                m_score = score[i][1];
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i = 0;i<T;i++){
            int n = Integer.parseInt(br.readLine());
            int[][] score = new int[n][2];
            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                score[j][0] = Integer.parseInt(st.nextToken());
                score[j][1] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(n,score));
        }
    }
}
