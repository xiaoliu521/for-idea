package org.example.alg;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xianr
 * @date 2023-10-30
 * @Description TODO
 */
public class DfsTest {

    static int[][] map;
    static int[][] book;

    static int nx;
    static int ny; // nx, ny定义迷宫大小

    static int start_x;
    static int start_y; // 开始坐标

    static int end_x;
    static int end_y; // 结束坐标

    static int step; // 存储步数
    static int min = 99999; // 最小步数， 默认99999

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        nx = scanner.nextInt();
//        ny = scanner.nextInt();
        nx = 5;
        ny = 4;
        map = new int[nx+1][ny+1];
         book = new int[nx+1][ny+1];
        for (int i = 1; i <= nx; i++) {
            for (int j = 1; j <= ny; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        start_x = scanner.nextInt();
        start_y = scanner.nextInt();
        end_x = scanner.nextInt();
        end_y = scanner.nextInt();

        step = 0;
        dfs(start_x, start_y, step);
        System.out.println(min);
    }

    private static void dfs(int x, int y, int step) {

        if (x == end_x && y == end_y) {
                if (step < min) {
                min = step;
            }
            return;
        }


        int tx, ty;

        // 定义下一步的优先级
        int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < next.length; i++) {
            tx = x + next[i][0];
            ty = y + next[i][1];
            // 是否出界， 出界则返回
            if (tx < 0 || tx > nx || ty < 0 || ty > ny) {
                continue;
            }
            // 有路且没有访问过
            if (map[tx][ty] == 1 && book[tx][ty] == 0) {
                book[tx][ty] = 1;
                dfs(tx, ty, step + 1);
                book[tx][ty] = 0; // 路走完了，则初始化为未访问
            }
        }
    }
}
