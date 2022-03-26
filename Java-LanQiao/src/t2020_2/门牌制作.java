package t2020_2;

public class 门牌制作 {
    public static void main(String[] args) {
        int cnt=0;
        for (int i = 1; i <= 2020; i++) {
            String s=i+"";
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)=='2') cnt++;
            }
        }
        System.out.println(cnt);
    }
}
