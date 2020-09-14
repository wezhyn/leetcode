package com.glodon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 在一个 2D 横版游戏中，所有的怪物都是在 X 轴上的，每个怪物有两个属性 X 和 HP，分别代表怪物的位置和生命值。
 * <p>
 * 玩家控制的角色有一个 AOE（范围攻击）技能，玩家每次释放技能可以选择一个位置 x，技能会对 [x-y,x+y] 范围内的所有怪物造成 1 点伤害，
 * 请问，玩家最少需要使用多少次技能，才能杀死所有怪物，怪物血量清 0 即视为被杀死
 * <p>
 * 输入描述
 * 输入第一行包含一个两个正整数 n 和 y，分别表示怪物的数量和技能的范围。（1<=n<=100000）
 * 接下来有 n 行，每行有两个正整数 x 和 hp 分别表示一只怪物的位置和血量。(1<=x,hp<=10^9)
 * <p>
 * 输出描述
 * 输出仅包含一个整数，表示最少使用的技能次数
 * <p>
 * 未写
 *
 * @author wezhyn
 * @since 07.22.2020
 */
public class AOE {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt(), y = scanner.nextInt();
            int[][] monsters = new int[n][2];
            for (int i = 0; i < n; i++) {
                monsters[i][0] = scanner.nextInt();
                monsters[i][1] = scanner.nextInt();
            }
            Arrays.sort(monsters, Comparator.comparingInt(p -> p[0]));
            int result = 0;
            for (int i = 0; i < n; i++) {
                int blood = monsters[i][1];
                if (blood > 0) {
                    result += blood;
                    for (int j = i + 1; j < n; j++) {
                        if (monsters[j][0] - monsters[i][0] <= 2 * y) {
                            monsters[j][1] -= blood;
                        } else {
                            break;
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }

}
