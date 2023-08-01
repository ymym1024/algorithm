public class P140108 {
    // 문제 이해
    // s에서 charAt 함수를 이용해 인덱스에 접근하면서 첫번째 문자 카운트를 위한 cnt1변수 선언
    // 첫번째 문자가 아닌 다른 문자 카운트 변수 cnt2 선언
    // 첫번째 문자인 경우 cnt1에 +1, 첫번째 문자가 아닌 다른 문자가 나왔을 때 cnt2변수에 +1
    // cnt1 = cnt2 인 경우 현재 인덱스 기준으로 split
    public int solution(String s) {
        String[] arr = {};
        for(int i=0;i<s.length();i++){
            arr = s.split("");

        }

        String first = arr[0];
        int answer = 0;
        char c =s.charAt(0);
        int cnt1 =0;
        int cnt2 =0;

        for(int i=0;i<arr.length;i++){
            if(cnt1==cnt2) {

                answer++;
               // System.out.println(first+" "+arr[i]+" "+answer);
                first = arr[i];

            }
            if(first.equals(arr[i])) cnt1++;
            else cnt2++;
            System.out.println(first+" "+arr[i]+" "+cnt1+" "+cnt2);
        }
        System.out.println();
        answer = 0;
        for(int i=0;i<s.length();i++){
            if(cnt1==cnt2) {
                answer++;
                c=s.charAt(i);
                System.out.println(c+" "+s.charAt(i)+" "+answer);
                cnt1=0; cnt2=0;
            }
            if(c == s.charAt(i)) cnt1++;
            else cnt2++;
            System.out.println(c+" "+s.charAt(i)+" "+cnt1+" "+cnt2);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new P140108().solution("aaabbaccccabba"));
    }
}
