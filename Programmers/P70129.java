public class P70129 {
    public int[] solution(String s) {
        int binary_cnt = 0;
        int zero_cnt = 0;

        while(s.length()!=1){
            int cnt = 0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0') cnt++;
            }
            s = Integer.toBinaryString(s.length()-cnt);
            binary_cnt++;
            zero_cnt+= cnt;
        }
        int[] answer = {binary_cnt,zero_cnt};
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new P70129().solution("1111111"));
    }
}
