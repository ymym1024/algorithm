import java.util.HashMap;

public class P178871 {
    public static String[] solution(String[] players, String[] callings) {
        HashMap<String,Integer> arr = new HashMap<>();
        for(int i=0;i<players.length;i++) arr.put(players[i], i);

        for(String call:callings){
            int index = arr.get(call);
            String swap = players[index-1];
            players[index-1] = players[index];
            players[index] = swap;
            System.out.println(players[index-1]+" "+players[index]);
            arr.put(call,index-1);
            arr.put(players[index-1],index);
        }
        for(String p:players) System.out.println(p);
        return players;
    }

    public static void main(String[] args) {
        String[] aa= solution(new String[]{"mumu", "soe", "poe", "kai", "mine"},new String[]{"kai", "kai", "mine", "mine"});
        for(String a:aa){
            System.out.print(a+" ");
        }
    }
}
