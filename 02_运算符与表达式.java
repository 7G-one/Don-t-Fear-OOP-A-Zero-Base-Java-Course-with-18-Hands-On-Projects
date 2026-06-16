// =============================================
// 第 02 课：运算符与表达式
// =============================================
// 上节课我们学了变量和数据类型。
// 这节课我们要学习"运算符"——让数据"动起来"的工具。
//
// 生活类比：
//   运算符就像计算器上的按钮——
//   + 是加法键，- 是减法键，* 是乘法键。
//   你按下不同的按钮，计算器就会做不同的运算。

class Operators {
    public static void main(String[] args) {
        // =============================================
        // 第一节：算术运算符
        // =============================================

        // 【算术运算符列表】
        // +   加法
        // -   减法
        // *   乘法
        // /   除法
        // %   取余
        // ++  自增
        // --  自减

        System.out.println("=== 算术运算符 ===");

        int a = 10;
        int b = 3;

        System.out.println(a + " + " + b + " = " + (a + b));   // 13
        System.out.println(a + " - " + b + " = " + (a - b));   // 7
        System.out.println(a + " * " + b + " = " + (a * b));   // 30
        System.out.println(a + " / " + b + " = " + (a / b));   // 3（整数除法）
        System.out.println(a + " % " + b + " = " + (a % b));   // 1

        // 【自增自减】
        int x = 5;
        System.out.println("\nx = " + x);
        x++;  // 等价于 x = x + 1
        System.out.println("x++ 后: " + x);  // 6
        x--;  // 等价于 x = x - 1
        System.out.println("x-- 后: " + x);  // 5

        // =============================================
        // 第二节：比较运算符
        // =============================================

        // 【比较运算符列表】
        // ==  等于
        // !=  不等于
        // >   大于
        // <   小于
        // >=  大于等于
        // <=  小于等于

        System.out.println("\n=== 比较运算符 ===");

        int num1 = 10;
        int num2 = 20;

        System.out.println(num1 + " == " + num2 + " → " + (num1 == num2));  // false
        System.out.println(num1 + " != " + num2 + " → " + (num1 != num2));  // true
        System.out.println(num1 + " > " + num2 + " → " + (num1 > num2));    // false
        System.out.println(num1 + " < " + num2 + " → " + (num1 < num2));    // true
        System.out.println(num1 + " >= " + num2 + " → " + (num1 >= num2));  // false
        System.out.println(num1 + " <= " + num2 + " → " + (num1 <= num2));  // true

        // =============================================
        // 第三节：逻辑运算符
        // =============================================

        // 【逻辑运算符列表】
        // &&  与（两个条件都满足）
        // ||  或（满足一个就行）
        // !   非（取反）

        System.out.println("\n=== 逻辑运算符 ===");

        boolean p = true;
        boolean q = false;

        System.out.println("p && q = " + (p && q));  // false
        System.out.println("p || q = " + (p || q));  // true
        System.out.println("!p = " + (!p));          // false

        // 【实际应用】
        int age = 25;
        int income = 10000;

        if (age >= 18 && income >= 5000) {
            System.out.println("符合条件");
        }

        if (age < 18 || age > 60) {
            System.out.println("特殊年龄段");
        }

        // =============================================
        // 第四节：赋值运算符
        // =============================================

        // 【赋值运算符列表】
        // =    赋值
        // +=   加法赋值
        // -=   减法赋值
        // *=   乘法赋值
        // /=   除法赋值
        // %=   取余赋值

        System.out.println("\n=== 赋值运算符 ===");

        int num = 100;
        System.out.println("初始值：" + num);

        num += 10;   // 等价于 num = num + 10
        System.out.println("num += 10: " + num);

        num -= 5;    // 等价于 num = num - 5
        System.out.println("num -= 5: " + num);

        num *= 2;    // 等价于 num = num * 2
        System.out.println("num *= 2: " + num);

        num /= 3;    // 等价于 num = num / 3
        System.out.println("num /= 3: " + num);

        // =============================================
        // 第五节：三元运算符
        // =============================================

        // 【三元运算符】
        // 语法：条件 ? 值1 : 值2
        // 如果条件为真，返回值1，否则返回值2

        System.out.println("\n=== 三元运算符 ===");

        int score = 85;
        String result = (score >= 60) ? "及格" : "不及格";
        System.out.println("分数" + score + "：" + result);

        int age2 = 20;
        String status = (age2 >= 18) ? "成年" : "未成年";
        System.out.println("年龄" + age2 + "：" + status);

        // =============================================
        // 第六节：运算符优先级
        // =============================================

        // 【优先级从高到低】
        // 1. () 括号
        // 2. ++ -- 自增自减
        // 3. * / % 乘除取余
        // 4. + - 加减
        // 5. > < >= <= 比较
        // 6. == != 等于
        // && 逻辑与
        // || 逻辑或
        // = += -= 赋值

        System.out.println("\n=== 运算符优先级 ===");

        // 先乘后加
        int result1 = 2 + 3 * 4;
        System.out.println("2 + 3 * 4 = " + result1);  // 14

        // 括号优先
        int result2 = (2 + 3) * 4;
        System.out.println("(2 + 3) * 4 = " + result2);  // 20

        // =============================================
        // 【练习题】
        // =============================================

        System.out.println("\n==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：温度转换
        System.out.println("--- 练习1 参考 ---");
        double celsius = 36.6;
        double fahrenheit = celsius * 9 / 5 + 32;
        System.out.println(celsius + "°C = " + fahrenheit + "°F");

        // 练习2：判断奇偶
        System.out.println("\n--- 练习2 参考 ---");
        int num3 = 7;
        if (num3 % 2 == 0) {
            System.out.println(num3 + " 是偶数");
        } else {
            System.out.println(num3 + " 是奇数");
        }

        // 练习3：成绩等级
        System.out.println("\n--- 练习3 参考 ---");
        int score2 = 85;
        String grade;
        if (score2 >= 90) {
            grade = "A";
        } else if (score2 >= 80) {
            grade = "B";
        } else if (score2 >= 60) {
            grade = "C";
        } else {
            grade = "F";
        }
        System.out.println("分数" + score2 + "，等级：" + grade);

        // 练习4：BMI 计算
        System.out.println("\n--- 练习4 参考 ---");
        double weight = 70;
        double height = 1.75;
        double bmi = weight / (height * height);
        System.out.println("BMI：" + String.format("%.1f", bmi));

        // 练习5：判断闰年
        System.out.println("\n--- 练习5 参考 ---");
        int year = 2024;
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println(year + "年是闰年吗？" + isLeap);

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - 算术、比较、逻辑、赋值运算符的用法
         * - 三元运算符简化条件判断
         * - 运算符优先级：括号 > 乘除 > 加减 > 比较 > 逻辑
         *
         * 常见陷阱：
         * - == 和 = 混淆（==是比较，=是赋值）
         * - 整数除法截断：10/3=3 不是 3.33
         * - && 和 || 的短路特性
         *
         * 下节课预告：
         * - 学习条件语句（if/switch），让程序学会"思考"
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 02 课：运算符与表达式！");
        System.out.println("下节课我们将学习条件语句。");
    }
}
