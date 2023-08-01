import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B6236 {
    /*
    * 시간복잡도 : O(logn)
    * 로직
    * 최적 해 : K의 최솟값
    * 최소 : 입력값의 최대값(인출 횟수를 줄이기 위해)
    * 최대 : 10,000 * 100,000 (입력값으로 들어올 수 있는 가장 큰 값)
    * 결정 조건 : 인출 횟수 <= 지정한 횟수(M) -> 인출금액이 적은 경우 답이 있는지 탐색 / 지정한 횟수
     */
    static int[] arr;
    public static int solution(int N, int M){
        int answer = 0;
        int left = 0, right = 10000 * 100000, mid;
        for(int a : arr) left = Math.max(left,a);

        while(left <= right){
            mid = (left+right) / 2;
            if(M >=isCheck(mid)){
                answer = mid;
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        return answer;
    }

    public static int isCheck(int mount){
        int cnt = 1;
        int money = mount;

        for(int m : arr){
            money -= m;
            if(money < 0){
                ++cnt;
                money = mount - m;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);

        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(N,M));
    }
}
