import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char star[] = new char[n];

        for(int i=0; i<n; i++) star[i] = '*';

        StringBuffer sb = new StringBuffer();

        for(int i=0; i<n; i++){
            if (i>0) star[i-1] = ' ';
            sb.append(star).append("\n");
        }

        System.out.print(sb);

    }
}
