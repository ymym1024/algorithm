public class P142086 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alpha = new int[26];
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i);
            if(alpha[c-97] == 0) {
                answer[i] = -1;
            }else{
                answer[i]= (i+1)-alpha[c-97];
            }
            alpha[c-97] = i+1;
        }

        return answer;
    }

    public static void main(String[] args) {
        new P142086().solution("baaab");
    }
}
