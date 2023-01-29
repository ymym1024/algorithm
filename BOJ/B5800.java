import java.io.*;
import java.util.Arrays;

public class B5800 {
    //시간복잡도 : O(n^2)
    //1. Array.sort 를 활용해 오름차순 정렬
    //2. 정렬한 배열에서 반복해서 gap 구하기
    //3. 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String[] s = br.readLine().split(" ");
            int M = Integer.parseInt(s[0]);
            int[] score = new int[M];
            for(int j=1;j<=M;j++){
                score[j-1] = Integer.parseInt(s[j]);
            }
            Arrays.sort(score);
            int gap = 0;
            for(int k=0;k< score.length-1;k++){
                gap = Math.max(gap,score[k+1]-score[k]);
            }
            bw.write("Class "+(i+1)+"\n");
            bw.write("Max "+score[score.length-1]+", Min "+score[0]+", Largest gap "+gap+"\n");
        }
        bw.flush();
        bw.close();
    }
}
