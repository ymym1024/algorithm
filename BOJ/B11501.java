import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11501 {
    // 최대값이 나올 때 팔아버려야 최대 이익이 나옴
    // 1. 배열을 끝 부터 돌면서 최대값 저장
    // 2. 배열의 마지막 원소를 최대값으로 초기화, 그 다음 원소부터 값 비교
    // 3. 최대값 < 배열원소 -> 최대값으로 초기화
    // 4. 그 외의 경우엔 현재 최대값으로 가지고 있는 값이 최대 주가, 최대 주가에서 배열 원소 빼서 이익 저장
    // 5. 해당 이익을 저장한 값 반환
    public static long solution(int[] arr){
        long answer = 0;
        long max = 0;
        for(int i=arr.length-1;i>=0;i--){
            if(max < arr[i]) max = arr[i];
            else answer+= max - arr[i];
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i= 0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            int[] num = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                num[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solution(num));
        }
    }
}
