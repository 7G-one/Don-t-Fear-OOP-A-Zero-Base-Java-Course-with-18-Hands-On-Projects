// =============================================
// 第 04 课：循环语句
// =============================================
// 上节课我们学了条件语句。
// 这节课我们要学习"循环语句"——让程序重复做事情。
//
// 生活类比：
//   循环就像洗衣服——把衣服放进洗衣机，
//   按下启动键，机器就一遍遍地转，
//   直到衣服洗干净了才停下来。

class Loops {
    public static void main(String[] args) {
        // =============================================
        // 第一节：for 循环
        // =============================================

        // 【for 循环的语法】
        // for (初始化; 条件; 更新) {
        //     循环体
        // }

        System.out.println("=== for 循环 ===");

        // 基本 for 循环
        for (int i = 1; i <= 5; i++) {
            System.out.println("第 " + i + " 次循环");
        }

        // 计算 1 到 10 的和
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("1到10的和：" + sum);

        // =============================================
        // 第二节：while 循环
        // =============================================

        // 【while 循环的语法】
        // while (条件) {
        //     循环体
        // }

        System.out.println("\n=== while 循环 ===");

        int count = 1;
        while (count <= 5) {
            System.out.println("count = " + count);
            count++;
        }

        // =============================================
        // 第三节：do-while 循环
        // =============================================

        // 【do-while 至少执行一次】
        System.out.println("\n=== do-while 循环 ===");

        int num = 1;
        do {
            System.out.println("num = " + num);
            num++;
        } while (num <= 5);

        // =============================================
        // 第四节：break 和 continue
        // =============================================

        System.out.println("\n=== break 和 continue ===");

        // break：跳出循环
        System.out.println("break 示例：");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // continue：跳过本次
        System.out.println("continue 示例：");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // =============================================
        // 第五节：嵌套循环
        // =============================================

        System.out.println("\n=== 嵌套循环 ===");

        // 九九乘法表
        System.out.println("九九乘法表：");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d×%d=%-4d", j, i, i * j);
            }
            System.out.println();
        }

        // =============================================
        // 【练习题】
        // =============================================

        System.out.println("\n==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：求和
        System.out.println("--- 练习1 参考 ---");
        int total = 0;
        for (int i = 1; i <= 100; i++) {
            total += i;
        }
        System.out.println("1到100的和：" + total);

        // 练习2：找最大值
        System.out.println("\n--- 练习2 参考 ---");
        int[] numbers = {34, 67, 12, 89, 45, 23, 78};
        int max = numbers[0];
        for (int n : numbers) {
            if (n > max) {
                max = n;
            }
        }
        System.out.println("最大值：" + max);

        // 练习3：斐波那契数列
        System.out.println("\n--- 练习3 参考 ---");
        int n1 = 0, n2 = 1;
        System.out.print("斐波那契：");
        for (int i = 0; i < 10; i++) {
            System.out.print(n1 + " ");
            int temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
        System.out.println();

        // 练习4：打印三角形
        System.out.println("\n--- 练习4 参考 ---");
        int rows = 5;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - for 循环适合已知次数的场景
         * - while 循环适合条件驱动的场景
         * - break 跳出循环，continue 跳过本次
         *
         * 常见陷阱：
         * - while 循环忘记更新条件导致死循环
         * - for 循环边界搞错：<= 还是 <
         * - 嵌套循环层数过多导致性能问题
         *
         * 下节课预告：
         * - 学习数组，存储和处理多个同类型数据
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 04 课：循环语句！");
        System.out.println("下节课我们将学习数组。");
    }
}
