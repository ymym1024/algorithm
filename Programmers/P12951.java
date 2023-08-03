import java.util.StringTokenizer;

public class P12951 {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s," ",true);
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()){
            String str = st.nextToken();
            if(str.equals(" ")){
                sb.append(" ");
            }else{
                sb.append(str.substring(0,1).toUpperCase());
                sb.append(str.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new P12951().solution("for the last week"));
    }
}
