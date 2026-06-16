// =============================================
// 第 06 课：方法
// =============================================
// 上节课我们学了数组。
// 这节课我们要学习"方法"——代码的"积木"。
//
// 生活类比：
//   方法就像菜谱——你把做法写好（定义方法），
//   以后每次做这道菜，只要翻开菜谱照着做（调用方法）就行。
//   不用每次都从头想怎么做，省时省力！

class Methods {
    public static void main(String[] args) {
        // =============================================
        // 第一节：定义和调用方法
        // =============================================

        System.out.println("=== 定义和调用方法 ===");

        // 调用方法
        sayHello();
        greet("小明");

        // 有返回值的方法
        int result = add(3, 5);
        System.out.println("3 + 5 = " + result);

        // =============================================
        // 第二节：参数详解
        // =============================================

        System.out.println("\n=== 参数详解 ===");

        // 固定参数
        System.out.println("10 + 20 = " + add(10, 20));

        // 可变参数
        System.out.println("求和：" + sum(1, 2, 3, 4, 5));

        // =============================================
        // 第三节：方法重载
        // =============================================

        System.out.println("\n=== 方法重载 ===");

        // 同名方法，不同参数
        System.out.println("add(3, 5) = " + add(3, 5));
        System.out.println("add(3.5, 5.5) = " + add(3.5, 5.5));

        // =============================================
        // 第四节：递归
        // =============================================

        System.out.println("\n=== 递归 ===");

        // 阶乘
        System.out.println("5! = " + factorial(5));
        System.out.println("10! = " + factorial(10));

        // 斐波那契
        System.out.println("斐波那契第10项 = " + fibonacci(10));

        // =============================================
        // 【练习题】
        // =============================================

        System.out.println("\n==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：温度转换
        System.out.println("--- 练习1 参考 ---");
        System.out.println("0°C = " + celsiusToFahrenheit(0) + "°F");
        System.out.println("100°C = " + celsiusToFahrenheit(100) + "°F");
        System.out.println("36.6°C = " + String.format("%.1f", celsiusToFahrenheit(36.6)) + "°F");

        // 练习2：成绩统计
        System.out.println("\n--- 练习2 参考 ---");
        int[] scores = {85, 92, 78, 95, 88};
        printScores(scores);

        // 练习3：判断素数
        System.out.println("\n--- 练习3 参考 ---");
        for (int i = 2; i <= 20; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        // 练习4：字符串反转
        System.out.println("\n--- 练习4 参考 ---");
        System.out.println("反转：" + reverseString("Hello"));

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - 方法的定义和调用，参数和返回值
         * - 方法重载：同名方法不同参数列表
         * - 递归：方法调用自身，必须有终止条件
         *
         * 常见陷阱：
         * - 递归忘记写终止条件导致栈溢出
         * - 方法重载区分条件是参数列表，不是返回值
         * - 值传递：方法内修改参数不影响外部变量
         *
         * 下节课预告：
         * - 学习面向对象编程（OOP），Java 的核心思想
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 06 课：方法！");
        System.out.println("下节课我们将学习面向对象编程。");
    }

    // =============================================
    // 辅助方法
    // =============================================

    static void sayHello() {
        System.out.println("Hello, Java!");
    }

    static void greet(String name) {
        System.out.println("你好，" + name + "！");
    }

    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    static int fibonacci(int n) {
        if (n <= 2) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    static void printScores(int[] scores) {
        int sum = 0;
        for (int s : scores) {
            sum += s;
        }
        System.out.println("平均分：" + (double) sum / scores.length);
        System.out.println("最高分：" + findMax(scores));
        System.out.println("最低分：" + findMin(scores));
    }

    static int findMax(int[] arr) {
        int max = arr[0];
        for (int n : arr) {
            if (n > max) max = n;
        }
        return max;
    }

    static int findMin(int[] arr) {
        int min = arr[0];
        for (int n : arr) {
            if (n < min) min = n;
        }
        return min;
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
