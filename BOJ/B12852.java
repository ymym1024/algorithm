import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12852 {
    // 시간복잡도
    // 로직
    // 1. 초기값 arr[1] = 0 로 선언
    // 2. 최소연산을 구하기 위해선 n 값을 n/3, n/2, n-1 로 나눴을 때 값을 저장
    // 3. 값을 저장한 후 N으로 만들기 위한 인덱스를 배열에 저장
    // 4. 연산의 최소값을 값을 구해서 1을 더해준다
    // 5. 2부터 n까지 메모제이션 실행 후 arr[n] 값 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        int[] arr = new int[N+1];
        dp[1] = 0;
        arr[1] = 1;
        for(int i=2;i<N+1;i++){
            dp[i] = dp[i-1]+1;
            arr[i] = i-1;
            if(i%3==0 && arr[i] > arr[i/3] + 1){
                dp[i] =dp[i/3]+1;
                arr[i] = i/3;
            }
            if(i%2==0 && arr[i] > arr[i/2] + 1){
                dp[i] =dp[i/2]+1;
                arr[i] = i/2;
            }
        }
        System.out.println(dp[N]);
        StringBuilder sb = new StringBuilder();
        while(N > 0){
            sb.append(N+" ");
            N = arr[N];
        }
        System.out.println(sb);
    }
}
