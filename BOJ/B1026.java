import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1026 {
    // 특징 : A배열의 최솟값 * B배열의 최댓값
    // 시간복잡도 : O(nlogn) -> Arrays.sort 는 퀵정렬 nlogn, 배열 길이 최대 50 으로 정해져 있기 때문에 n 시간복잡도 소요
    // 1. N 크기의 배열 두개 선언
    // 2. 첫번째 오름차순 으로 정렬, 두번째 내림차순으로 정렬
    // 3. 배열 반복문 돌면서 두 배열 곱하고 더해줌
    // 4. 반환
    public static int[] inputData(BufferedReader br, int[] arr,int N) throws IOException {
        StringTokenizer st =new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
    public static int solution(int[] num1, int[] num2){
        int answer = 0;
        //첫번째 배열 오름차순
        Arrays.sort(num1);
        //두번째 배열 내림차순
        Integer[] arr = Arrays.stream(num2).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, Collections.reverseOrder());

        for(int i=0;i<num1.length;i++){
            answer+=num1[i]*arr[i];
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num1 =  new int[N];
        inputData(br,num1,N);

        int[] num2 =  new int[N];
        inputData(br,num2,N);

        System.out.println(solution(num1,num2));
    }
}
