import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class B11508 {
    // 시간복잡도 : O(logn)
    // !! 할인받는건 큰 비용이여야 하므로 내림차순으로 정렬해서 3으로 묶기
    // 1. 입력받은 값들을 array.sort로 정렬
    // 2. 3개씩 묶고, 마지막 원소는 더하지 않는다
    // 3. 반복문을 돌면서 i%3 == 0 일 때 최소비용에 더하지 않음
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] product = new Integer[N];
        for(int i=0;i<N;i++){
            product[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(product, Collections.reverseOrder());
        int sum = 0;
        for(int i=0;i<N;i++){
            if(i>0 && (i+1)%3 == 0) continue;
            sum+=product[i];
        }
        System.out.println(sum);
    }
}
