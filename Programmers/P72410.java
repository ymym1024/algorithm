public class P72410 {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9\\-_.]","");
        answer = answer.replaceAll("\\.{2,}",".");
        answer = answer.replaceAll("^[.]|[.]$","");
        answer = answer.length()==0 ? "a":answer;
        answer = answer.length() >= 16 ? answer.substring(0,15) : answer;
        answer = answer.replaceAll("[.]$","");

        if(answer.length()<=2) {
            char c = answer.charAt(answer.length()-1);
            StringBuilder sb = new StringBuilder(answer);
            while(sb.length()<3){
                sb.append(c);
            }
            answer = sb.toString();
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new P72410().solution("123_.def"));
    }
}
