public class P12943 {
    //dp로 dp[N] 배열 리턴
    public int solution(int num) {
        int n = 0;
        if(num == 1){
            return 0;
        }
        for(int i=0;i<500;i++){
            if(num%2 == 0) num=num/2;
            else num=(num*3)+1;
            n++;
            if(num == 1){
                return n;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(new P12943().solution(1));

    }
}
