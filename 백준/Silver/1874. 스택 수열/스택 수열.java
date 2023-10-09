import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        int j = 1;
        StringBuffer sb = new StringBuffer();
        boolean err = false;

        for(int i=0; i<n;i++){
            int num = Integer.parseInt(br.readLine());

            while (j<=num){
                stack.push(j++);
                sb.append("+\n");
            }

            if (!stack.empty() && stack.pop()==num){
                sb.append("-\n");
            } else {
                err = true;
                break;
            }
        }
        if(!err){
            System.out.print(sb);
        } else {
            System.out.print("NO");
        }

    }
}
