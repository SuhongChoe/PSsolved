import java.io.*;
import java.util.*;

public class Main {
    public static int gcd(int a, int b){
        if(a<b) return gcd(b, a);
        int r = a%b;
        while(r>0){
            a = b;
            b = r;
            r = a%b;
        }
        return b;
    }

    public static int lcd(int a, int b){
        return a*b/gcd(a, b);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(gcd(a, b));
        System.out.print(lcd(a, b));

    }
}
