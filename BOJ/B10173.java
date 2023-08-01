import java.io.*;

public class B10173 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(br.readLine()!="EOI"){
            String str = br.readLine();
            if(str.indexOf("Nemo")!=0) bw.write("Found\n");
            else bw.write("Missing\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
