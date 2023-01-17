import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1931 {
    // 회의실을 최대로 사용하기 위해서는 회의시간이 최소인 것 위주로 찾아야 함
    // 시간복잡도 : O(n) -> Array.sort로 시간복잡도 o(n) 소요, 반복문으로 o(n) 소요, o(2n) -> o(n)
    // 1. 입력 받은 시간을 종료시간 기준으로 오름차순 정렬
    // 2. 최대개수를 체크할 변수 answer 을 선언
    // 3. 배열 길이 만큼 반복문을 돌면서 직전 종료시간 <= 시작시간 일 경우 answer를 1 증가 시킨다
    // 4. answer 값을 리턴한다

    public static int solution(int[][] room){
        int answer = 0;
        int prev = 0;
        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] != o2[1] ? o1[1]-o2[1] : o1[0]-o2[0];
            }
        });

        for(int i =0;i<room.length;i++){
            if(prev <= room[i][0]){
                prev = room[i][1];
                answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] room = new int[N][2];
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            room[i][0] = Integer.parseInt(st.nextToken());
            room[i][1] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(room));
    }
}
