import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2512 {
    /*
    * 시간복잡도 : O(nlogn) -> 매개변수 탐색의 시간복잡도는 o(logn)이지만, Array.sort 함수는 평균적으로 O(nlogn) 지원하기 때문에 시간복잡도는 O(nlogn)이다
    * 로직
    * 모든 예산을 배정받을 수 있는 최대 예산을 구해야 함
    * 최대 예산을 이분탐색으로 구해야 하므로 매개변수탐색 아이디어를 활용
    * 모든 예산요청을 배정해주는 예산 상한액을 최적 해로 생각
    * sub값 전체예산 / n 으로 설정
    * sub 값이 전체 예산보다 같거나 큰 경우 전체 예산에서 sub값을 뺀다
    * sub 값이 전체 예산보다 작은경우 n값에서 예산을 계산한 k 인덱스 값을 빼고, 나머지 예산에서 /n 으로 설정
    * 배열의 인덱스가 가르키는 값이 예산/n 값보다 크면 반복문을 빠져 나오고 아닌 경우 인덱스 값을 1 감소시킴
    * */
     public static int solution(int N, int[] arr, int budget){
         int sub = budget / N;
         int sum = 0;
         int k=0;

         for(int i=0;i<arr.length;i++) sum+=arr[i];

         Arrays.sort(arr);

         if(budget >= sum){
             return arr[N-1];
         }else{
             while(k<N){
                 if(arr[k] <= sub){
                     budget-=arr[k];
                 }
                 else{
                     int remain = N - k;
                     sub = budget/remain;
                     if(arr[k] > sub){
                         break;
                     }
                     k--;
                 }
                 k++;
             }
             return sub;
         }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        int budget = Integer.parseInt(br.readLine());

        System.out.println(solution(N,arr,budget));
    }
}
