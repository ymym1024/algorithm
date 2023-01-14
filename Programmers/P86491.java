public class P86491 {
    public int solution(int[][] sizes) {
        int w = 0; //가로
        int h = 0; //세로
        for(int i=0;i< sizes.length;i++){
            int temp = 0;
            if(sizes[i][0] < sizes[i][1]){
                temp = sizes[i][0];
                sizes[i][0]= sizes[i][1];
                sizes[i][1] = temp;
            }
            if(w < sizes[i][0]) w = sizes[i][0];
            if(h < sizes[i][1]) h = sizes[i][1];
        }
        return w*h;
    }

    public static void main(String[] args) {
        int[][] arr = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7,11}};
        System.out.print(new P86491().solution(arr));
    }
}
