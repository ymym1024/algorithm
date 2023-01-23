import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class B3085 {
    static int N = 0, answer = 0,MAX = 52;
    static char candy[][] = new char[MAX][MAX];
    // 시간복잡도
    // 1. 문자열의 위치를 바꿈
    // 2. 바꾸고 난 후 행을 돌면서 같은 색 사탕의 크기가 최대인 값을 찾음
    // 3. 열을 돌면서 같은 색 사탕의 크기가 최대인 값을 찾음
    // 4. 1번에서 바꿨던 문자를 다시 원상복귀

    public static int solution(char[][] candy){
        for(int i=0;i<N;i++){
            for(int j=0;j<N-1;j++){
                swap(i,j,i,j+1);
                checkRow();
                checkCol();
                swap(i,j,i,j+1);

                swap(j,i,j+1,i);
                checkRow();
                checkCol();
                swap(j,i,j+1,i);
            }
        }
        return answer;
    }

    public static void checkCol(){
        int temp;
        for(int k=0;k<N;k++){
            temp = 1;
            for(int l=0;l<N;l++){
                if(candy[l][k] == candy[l+1][k]){
                    temp+=1;
                }else{
                    answer = Math.max(answer,temp);
                    temp = 1;
                }
            }
        }
    }

    public static void checkRow(){
        int temp;
        for(int k=0;k<N;k++){
            temp = 1;
            for(int l=0;l<N;l++){
                if(candy[k][l] == candy[k][l+1]){
                    temp++;
                }else{
                    answer = Math.max(answer,temp);
                    temp = 1;
                }
            }
        }
    }
    public static void swap(int x1,int y1,int x2,int y2){
        char temp = candy[x1][y1];
        candy[x1][y1] = candy[x2][y2];
        candy[x2][y2] = temp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<N;j++){
                candy[i][j] = s.charAt(j);
            }
        }

        System.out.println(solution(candy));
    }
}
