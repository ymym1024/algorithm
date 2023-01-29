import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B10816 {
    // 시간복잡도
    // 1. 둘쨋줄에 입력받은 데이터를 array.sort 메소드를 통해 정렬한다
    // 2. lower, upper 함수를 통해 정렬한 데이터의 원소 위치를 파악한다
    // 3. upper 인덱스 위치 - lower 인덱스 위치 로 원소 갯수 구함
    // 4. stringbuilder로 출력
    public static int lower(int[] arr, int target){
        int start = 0;
        int end = arr.length;

        while(start < end){
            int mid = (start+end) / 2;
            if(arr[mid] >= target) end = mid;
            else start = mid+1;
        }
        return end;
    }

    public static int upper(int[] arr, int target){
        int start = 0;
        int end = arr.length;

        while(start < end){
            int mid = (start+end) / 2;
            if(arr[mid] <= target) start = mid+1;
            else end = mid;
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] nTemp = br.readLine().split(" ");
        int[] cardN = new int[N];
        for(int i = 0;i<N;i++){
            cardN[i] = Integer.parseInt(nTemp[i]);
        }
        Arrays.sort(cardN);

        int M = Integer.parseInt(br.readLine());
        String[] mTemp = br.readLine().split(" ");
        for(int i=0;i<M;i++){
            int target = Integer.parseInt(mTemp[i]);
            int lower = lower(cardN,target);
            int upper = upper(cardN,target);
            sb.append(upper-lower).append(" ");
        }
        System.out.println(sb);
    }

}
