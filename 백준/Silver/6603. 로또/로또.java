import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static int[] selNum;
    static boolean[] visited;
    static StringBuffer sb = new StringBuffer();

    public static void choiceNumber(int idx, int cnt){
        if (cnt==6){
            for(int i=0; i<k; i++){
                if (visited[i]){
                    sb.append(selNum[i]).append(" ");
                }
            }
            sb.append("\n");

            return;
        }

        for(int i=idx; i<k; i++){
            if (!visited[i]) {
                visited[i] = true;
                choiceNumber(i + 1, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k==0) break;

            selNum = new int[k];
            visited = new boolean[k];
            for(int i=0; i<k; i++) selNum[i] = Integer.parseInt(st.nextToken());

            choiceNumber(0, 0);

            sb.append("\n");
        }

        System.out.print(sb);

    }
}
