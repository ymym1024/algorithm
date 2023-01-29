public class Subset {
    static int N, totalCnt;
    static int [] input;
    static boolean[] isSelected;

    public static void main(String[] args) {

        N = 4;
        input = new int[N];
        isSelected = new boolean[N];
        totalCnt = 0;

        for (int i = 0; i < N; i++) {
            input[i] = i+1;
        }
        gernerateSubSet(0);
        System.out.println("경우의 수: "+totalCnt);
    }

    private static void gernerateSubSet(int cnt) {
        if(cnt == N) {
            totalCnt++;
            for (int i = 0; i < N; i++) {
                //System.out.print(isSelected[i]?input[i]:"");
            }
            //System.out.println();
            return;
        }

        isSelected[cnt] = true;
        printSelect();
        gernerateSubSet(cnt+1);

        isSelected[cnt] = false;
        printSelect1();
        gernerateSubSet(cnt+1);
    }

    public static void printSelect(){
        for(boolean b:isSelected){
            System.out.print("왼 : "+b+" ");
        }
        System.out.println();
    }
    public static void printSelect1(){
        for(boolean b:isSelected){
            System.out.print("오 : "+b+" ");
        }
        System.out.println();
    }
}
