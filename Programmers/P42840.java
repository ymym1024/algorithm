public class P42840 {
    public int[] solution(int[] answers){
        int[] answer;
        int[] ans1={1,2,3,4,5};
        int[] ans2={2,1,2,3,2,4,2,5};
        int[] ans3={3,3,1,1,2,2,4,4,5,5};
        int a=0,b=0,c=0;

        for(int i=0;i<answers.length;i++){
            if(answers[i]==ans1[i%5]) a++;
            if(answers[i]==ans2[i%8]) b++;
            if(answers[i]==ans3[i%10]) c++;
        }

        if(a>b && a>c){
            answer=new int[1];
            answer[0]=1;
        }else if(b>a && b>c){
            answer=new int[1];
            answer[0]=2;
        }else if(c>a && c>b){
            answer=new int[1];
            answer[0]=3;
        }else if(a==b && b>c){
            answer=new int[2];
            answer[0]=1;
            answer[1]=2;

        }else if(a==c && c>b){
            answer=new int[2];
            answer[0]=1;
            answer[1]=3;
        }else if(b==c && b>a){
            answer=new int[2];
            answer[0]=2;
            answer[1]=3;
        }else{
            answer=new int[3];
            answer[0]=1;answer[1]=2;answer[2]=3;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] answer = new int[]{1,2,3,4,5};
        System.out.println(new P42840().solution(answer));
    }
}
