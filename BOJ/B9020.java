import java.io.*;
import java.util.Arrays;

public class B9020 {
    // 문제
    // 2부터 자연수의 범위까지 소수를 구하고 두 소수의 합이 자연수가 되는 경우 출력
    // 시간복잡도 : O(N)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            int k = Integer.parseInt(br.readLine());
            bw.write(solution(k)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static String solution(int n) {
        //n 범위의 소수 구하기
        StringBuilder sb = new StringBuilder();
        boolean[] array = new boolean[n + 1];
        Arrays.fill(array, true); // true로 초기화
        int[] num = new int[n+1];

        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (array[i]) {
                int j = 2;
                while (i * j <= n) {
                    array[i * j] = false;
                    j++;
                }
            }
        }
        int s=0;
        for (int i = 2; i < n + 1; i++) {
            if (array[i]) num[s++] = i;
        }
        //출력하기
        // 2 3 5 7 11
        s=0;
        int min =Integer.MIN_VALUE;
        for(int i=0;i<num.length-1;i++){
            for(int j=i;j<num.length;j++){
                if(num[i]+num[j]==n){
                    if(min < num[i] - num[j]){
                        min = num[i] - num[j];
                        sb.setLength(0);
                        sb.append(num[i] +" "+ num[j]);
                    }
                    break;
                }
            }
        }
        return sb.toString();
    }
}
