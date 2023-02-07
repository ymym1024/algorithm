import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463 {
    // 시간복잡도
    // 로직
    // 1. dp를 저장할 배열을 선언하고, 최대값을 10^6+1 선언 arr[i]에는 최소 연산의 횟수
    // 2. 초기값 arr[1] = 0 로 선언
    // 3. 최소연산을 구하기 위해선 n 값을 n/3, n/2, n-1 로 나눴을 때 값을 저장
    // 4. 연산의 최소값을 값을 구해서 1을 더해준다
    // 5. 2부터 n까지 메모제이션 실행 후 arr[n] 값 출력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1000001];
        dp[1] = 0;

        int v = 0;
        for(int i=2;i<N+1;i++){
            v = dp[i-1];
            if(i%3==0) v = Math.min(v,dp[i/3]);
            if(i%2==0) v = Math.min(v,dp[i/2]);
            dp[i] = v+1;
        }
        System.out.println(dp[N]);
    }
}
