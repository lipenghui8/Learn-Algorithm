package 二刷_t2018;

import java.util.Scanner;

public class 螺旋折线 {
    static long x, y;
    static long df = 0L;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();

        if (x > 0 && y >= 0) {
        	long dx = Math.max(x, y);
        	long dy = dx;
            df = (dx + dy) * (dx + dy);
            if (x < dx) {
                df -= (dx - x);
            }
            if (y < dy) {
                df += (dy - y);
            }
        } else if (x >= 0 && y < 0) {
        	long dx = Math.max(Math.abs(x), Math.abs(y));
        	long dy = -dx;
            df = (dx + Math.abs(dy)) * (dx + Math.abs(dy) + 1);
            if (x < dx) {
                df += (dx - x);
            }
            if (y > dy) {
                df -= (y - dy);
            }
        } else if (x < 0 && y <= 0) {
        	long dx = -Math.max(Math.abs(x), Math.abs(y));
        	long dy = dx + 1;
            df = (Math.abs(dx) + Math.abs(dy)) * (Math.abs(dx) + Math.abs(dy));
            if (x > dx) {
                df -= (x - dx);
            }
            if (y > dy) {
                df += (y - dy);
            }
        } else  if (x <= 0 && y > 0) {
        	long dx = -Math.max(Math.abs(x), Math.abs(y));
        	long dy = -dx;
            df = (Math.abs(dx) + Math.abs(dy)) * (Math.abs(dx) + Math.abs(dy) - 1);
            if (x > dx) {
                df += (x - dx);
            }
            if (y < dy) {
                df -= (y - dy);
            }
        }
        System.out.println(df);
    }
}
