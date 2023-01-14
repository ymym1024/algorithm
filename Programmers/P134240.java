public class P134240 {
    public String solution(int[] food) {
        int size = 1;
        for(int i=1;i< food.length;i++){
            int cnt = food[i]%2==1?food[i]-1 :food[i];
            size+= cnt; food[i] = cnt;
        }
        int[] foodSet = new int[size];
        foodSet[size/2] = 0;
        int cnt = 1;
        for(int i=0;i<size/2;i++){
            while(true){
                if(food[cnt]<2){
                    cnt++;
                }else{
                    break;
                }
            }
            foodSet[i] = foodSet[size-1-i] = cnt;
            food[cnt]-=2;
        }

        String answer = numberToString(foodSet);
        return answer;
    }

    public String numberToString(int[] arr){
        String answer = "";
        for(int c : arr){
            answer+=String.valueOf(c);
        }
        return answer;
    }

    public static void main(String[] args) {
        int food[] = {1,3,4,6};
        System.out.println(new P134240().solution(food));
    }
}
