import java.io.*;
import java.util.Arrays;

public class B1920 {
    // 시간복잡도 : O(nlogn)
    // 로직
    // m의 수가 n개의 정수 안에 있는지 확인하면 되므로 m의수를 정렬 없이 이분탐색을 통해 풀이
    // 이분탐색은 정렬된 배열에서 진행해야 하므로 n개의 수를 정렬
    // 이분탐색을 통해 정렬된 배열에서 값을 찾고 값 존재 -> return 1, 존재 x -> return 0
    public static int solution(int[] arr, int value){
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while(left <= right){
            mid = (left+right)/2;
            if(arr[mid]<value) left = mid+1;
            else if(arr[mid] > value) right = mid-1;
            else return 1;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] s1 =br.readLine().split(" ");
        int[] arr1 = new int[N];
        for(int i=0;i<N;i++) arr1[i] = Integer.parseInt(s1[i]);
        Arrays.sort(arr1);

        int M = Integer.parseInt(br.readLine());
        String[] s2 =br.readLine().split(" ");

        for(int i =0;i<M;i++){
            int ii = Integer.parseInt(s2[i]);
            bw.write(solution(arr1,ii)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
