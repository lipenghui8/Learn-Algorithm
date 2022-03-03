package 算法练习;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class feibo{

    public static void main(String[] arg){
        Scanner scan = new Scanner(new BufferedInputStream(System.in));
        while(scan.hasNextInt()){
            int n =scan.nextInt();
            if(check(n)){
                System.out.println("yes");
                continue;
            }
            System.out.println("no");
        }
        
        scan.close();

    }
    
    static boolean check(int n){//检测F(n)能不能整除3
        int result = getResult(n);
        return result%3==0;
    }
    
    static int getResult(int n){
        if(n==0){
            return 7;
        }
        if(n==1){
            return 11;
        }
        return (getResult(n-1) + getResult(n-2))%3;
    }

}