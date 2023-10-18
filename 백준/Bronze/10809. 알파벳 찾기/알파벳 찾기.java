import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[26];
        char[] c = br.readLine().toCharArray();

        for(int i=0; i<26; i++) arr[i] = -1; 

        for(int i=0; i<c.length; i++) {
            int idx = c[i] - 'a';
            if (arr[idx] == -1){
                arr[idx] = i;
            }
        }

        for(int i=0; i<26; i++){
            System.out.print(arr[i] + " ");
        }
        
    }
}