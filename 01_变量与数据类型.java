// -*- coding: utf-8 -*-
// =============================================
// 第 01 课：变量与数据类型
// =============================================
// 上节课我们认识了 Java，写了第一个 Hello World 程序。
// 这节课我们要深入学习变量的声明方式、各种数据类型，
// 以及类型转换——这些是 Java 编程的核心基础。
//
// 生活类比：
//   变量就像盒子——不同类型是不同大小的盒子。
//   int 像小盒子，只能放整数；
//   double 像大一点的盒子，能放小数；
//   String 像透明盒子，能放一串文字。

class Variables {
    public static void main(String[] args) {

        // =============================================
        // 第一节：变量声明
        // =============================================
        // 变量就是给内存中的数据起一个名字，方便我们使用。
        // Java 中声明变量有三种常见方式：

        // 方式一：先声明，后赋值
        int age;           // 声明一个整数变量，此时还没有值
        age = 18;          // 给它赋值为 18
        System.out.println("方式一 - 先声明后赋值：age = " + age);

        // 方式二：声明的同时赋值（最常用，推荐！）
        int score = 95;
        System.out.println("方式二 - 声明并赋值：score = " + score);

        // 方式三：同时声明多个同类型变量
        int a = 10, b = 20, c = 30;
        System.out.println("方式三 - 多变量声明：a=" + a + ", b=" + b + ", c=" + c);
        // 注意：Java 中变量必须先声明再使用，不能直接写 x = 5;
        // 也不能重复声明同名变量，比如再写 int a = 5; 就会报错

        System.out.println();

        // =============================================
        // 第二节：整数类型
        // =============================================
        // Java 有 4 种整数类型，区别在于占用的内存大小不同：

        // byte：1 字节（8 位），范围 -128 ~ 127
        // 适合存储很小的整数，比如人的年龄
        byte myAge = 25;
        System.out.println("byte（年龄）：" + myAge);

        // short：2 字节（16 位），范围 -32768 ~ 32767
        // 实际开发中很少使用，了解即可
        short temperature = -10;
        System.out.println("short（温度）：" + temperature);

        // int：4 字节（32 位），范围约 -21亿 ~ 21亿
        // 最常用的整数类型！大多数整数场景都用它
        int population = 1400000000;
        System.out.println("int（人口）：" + population);

        // long：8 字节（64 位），范围非常大
        // 用于超大整数，注意：值后面必须加 L 或 l（推荐大写 L）
        long distance = 384400000L;
        System.out.println("long（地月距离/米）：" + distance);
        // 如果不加 L，Java 默认当 int 处理，超出 int 范围就会报错

        System.out.println();

        // =============================================
        // 第三节：浮点数类型
        // =============================================
        // 浮点数就是我们常说的"小数"

        // float：4 字节（32 位），精度约 6-7 位有效数字
        // 注意：值后面必须加 f 或 F，否则 Java 会当成 double
        float height = 1.75f;
        System.out.println("float（身高/米）：" + height);

        // double：8 字节（64 位），精度约 15 位有效数字
        // Java 中的小数默认就是 double 类型，最常用！
        double pi = 3.141592653589793;
        System.out.println("double（圆周率）：" + pi);

        // 对比：不加后缀默认是 double
        double x = 3.14;     // 正确，3.14 默认就是 double
        // float y = 3.14;   // 错误！3.14 是 double，不能直接赋给 float
        float y = 3.14f;     // 正确，加 f 后缀才行
        System.out.println("x = " + x + ", y = " + y);

        System.out.println();

        // =============================================
        // 第四节：布尔类型
        // =============================================
        // boolean 只有两个值：true（真）和 false（假）
        // 主要用于条件判断

        boolean isStudent = true;
        boolean isRich = false;
        System.out.println("是学生吗？" + isStudent);
        System.out.println("有钱吗？" + isRich);

        // 常见用法：配合 if 语句做判断
        int examScore = 85;
        if (examScore >= 60) {
            System.out.println("考试及格了！");
        } else {
            System.out.println("考试没及格...");
        }
        // if 语句的小括号里放的就是一个 boolean 表达式
        // examScore >= 60 的结果是 true，所以会执行 if 里面的代码

        System.out.println();

        // =============================================
        // 第五节：字符类型
        // =============================================
        // char 表示单个字符，用单引号 '' 包裹

        char letter = 'A';           // 英文字母
        char chinese = '你';         // 中文字符（Java 的 char 支持 Unicode）
        char digit = '9';           // 数字字符（注意：是字符 '9'，不是数字 9）
        char symbol = '+';          // 符号字符
        System.out.println("字母：" + letter);
        System.out.println("中文：" + chinese);
        System.out.println("数字字符：" + digit);
        System.out.println("符号：" + symbol);

        // '9' 和 9 的区别：
        // '9' 是字符，本质上存储的是它的 Unicode 编码值（57）
        // 9 是整数，就是数学上的数字九
        System.out.println("字符 '9' 的编码值：" + (int) digit);  // 输出 57
        System.out.println();

        // =============================================
        // 第六节：字符串类型
        // =============================================
        // String 是字符串类型，用双引号 "" 包裹
        // 注意：String 不是基本类型，而是引用类型（后面会详细讲）
        // 但因为太常用了，我们先学着用

        String name = "Mimo";
        String greeting = "Hello, World!";
        String empty = "";           // 空字符串也是合法的
        System.out.println("名字：" + name);
        System.out.println("问候：" + greeting);

        // 字符串拼接：用 + 号可以把多个字符串连起来
        String firstName = "张";
        String lastName = "三";
        String fullName = firstName + lastName;
        System.out.println("全名：" + fullName);

        // 字符串和其他类型拼接：+ 会自动把其他类型转成字符串
        int myAge2 = 20;
        String info = "我叫" + fullName + "，今年" + myAge2 + "岁";
        System.out.println(info);
        // 这就是为什么前面一直在用 "文字" + 变量 的写法

        System.out.println();

        // =============================================
        // 第七节：类型转换
        // =============================================
        // 不同数据类型之间可以互相转换，分为自动转换和强制转换

        // ----- 7.1 自动类型转换（小转大，安全） -----
        // 规则：小范围类型可以自动转成大范围类型
        // byte -> short -> int -> long -> float -> double
        int myInt = 100;
        double myDouble = myInt;     // int 自动转成 double，不需要任何操作
        System.out.println("int 值：" + myInt);
        System.out.println("自动转成 double：" + myDouble);  // 100.0

        // ----- 7.2 强制类型转换（大转小，可能丢失精度） -----
        // 需要在值前面加 (目标类型)，像一个"关卡"
        double price = 99.99;
        int intPrice = (int) price;  // 强制转成 int，小数部分直接截断（不是四舍五入！）
        System.out.println("double 值：" + price);
        System.out.println("强制转成 int：" + intPrice);  // 99，小数部分丢失了

        // 经典陷阱：精度丢失
        double d = 3.99;
        int i = (int) d;
        System.out.println("3.99 强制转 int = " + i);  // 结果是 3，不是 4！

        // ----- 7.3 字符串转数字 -----
        // 有时候用户输入的是字符串 "123"，我们需要转成数字 123 来计算
        String numStr = "256";
        int numFromStr = Integer.parseInt(numStr);       // 字符串转 int
        double dFromStr = Double.parseDouble("3.14");    // 字符串转 double
        System.out.println("字符串 \"256\" 转 int：" + numFromStr);
        System.out.println("字符串 \"3.14\" 转 double：" + dFromStr);
        // 注意：如果字符串内容不是合法数字（如 "abc"），程序会崩溃报错

        // ----- 7.4 数字转字符串 -----
        // 把数字变成字符串，方便拼接或显示
        String strFromInt = String.valueOf(42);
        String strFromDouble = String.valueOf(3.14);
        System.out.println("数字 42 转字符串：\"" + strFromInt + "\"");
        System.out.println("数字 3.14 转字符串：\"" + strFromDouble + "\"");
        // 另一种简单方式：直接和空字符串拼接 "" + 42 结果也是 "42"

        System.out.println();

        // =============================================
        // 第八节：常量
        // =============================================
        // 常量就是"不可改变的变量"，用 final 关键字声明
        // 声明时必须赋值，之后不能再修改

        final double PI = 3.14159;
        final int MAX_SCORE = 100;
        final String SCHOOL_NAME = "Mimo 大学";
        // PI = 3.14;  // 取消注释这行会报错：无法为最终变量赋值

        System.out.println("圆周率：" + PI);
        System.out.println("满分：" + MAX_SCORE);
        System.out.println("学校名：" + SCHOOL_NAME);

        // 常量命名规范：全大写，多个单词用下划线连接
        // 好的命名：MAX_VALUE, PI, SCHOOL_NAME
        // 不好的命名：maxValue, pi, schoolName（这是变量的命名风格）

        // 常量的用途：那些在程序运行中不应该改变的值
        // 比如数学常数、配置信息、最大最小限制等
        double radius = 5.0;
        double area = PI * radius * radius;
        System.out.println("半径 " + radius + " 的圆面积 = " + area);

        System.out.println();

        // =============================================
        // 第九节：变量的作用域
        // =============================================
        // 作用域就是变量"能被访问的范围"
        // Java 中，在 {} 里面声明的变量，只在 {} 内部有效

        int outerVar = 100;
        System.out.println("外部变量 outerVar = " + outerVar);

        // 下面用一对 {} 创建一个代码块
        {
            int innerVar = 200;
            System.out.println("  内部变量 innerVar = " + innerVar);
            System.out.println("  在内部也能访问 outerVar = " + outerVar);
        }
        // 代码块结束后，innerVar 就"消失"了
        // System.out.println(innerVar);  // 取消注释会报错：找不到符号 innerVar
        System.out.println("出了代码块，innerVar 已经不存在了");

        // 方法中的参数也有自己的作用域
        // main 方法的 args 参数，只在 main 方法内有效
        // 这个概念后面学方法时会更深入理解

        System.out.println();

        // =============================================
        // 练习题（动手试试吧！）
        // =============================================
        System.out.println("==========================================");
        System.out.println("练习题");
        System.out.println("==========================================");
        System.out.println();
        System.out.println("练习1：类型转换");
        System.out.println("  把字符串 \"3.14\" 转成 double，再强制转成 int，分别输出三个值");
        System.out.println();
        System.out.println("练习2：常量练习");
        System.out.println("  用 final 定义圆周率 PI = 3.14159 和满分 MAX_SCORE = 100");
        System.out.println();
        System.out.println("练习3：温度转换");
        System.out.println("  编写方法 celsiusToFahrenheit，将摄氏度转为华氏度（公式：C * 9/5 + 32）");
        System.out.println("  分别转换 0°C 和 100°C 并输出结果");
        System.out.println();
        System.out.println("练习4：BMI 计算与判断");
        System.out.println("  已知体重 70kg，身高 1.75m，计算 BMI 并用 if-else 判断等级");
        System.out.println("  BMI = 体重 / 身高的平方");
        System.out.println("  偏瘦 < 18.5 | 正常 18.5~24 | 偏胖 24~28 | 肥胖 >= 28");
        System.out.println();

        System.out.println("==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：类型转换
        System.out.println("--- 练习1 参考 ---");
        String numStr2 = "3.14";
        double numDouble = Double.parseDouble(numStr2);
        int numInt = (int) numDouble;
        System.out.println("字符串：" + numStr2);
        System.out.println("double：" + numDouble);
        System.out.println("int：" + numInt);

        // 练习2：常量练习
        System.out.println("\n--- 练习2 参考 ---");
        final double PI2 = 3.14159;
        final int MAX_SCORE2 = 100;
        System.out.println("圆周率：" + PI2);
        System.out.println("最大分数：" + MAX_SCORE2);

        // 练习3：温度转换
        System.out.println("\n--- 练习3 参考 ---");
        System.out.println("0°C = " + celsiusToFahrenheit(0) + "°F");
        System.out.println("100°C = " + celsiusToFahrenheit(100) + "°F");

        // 练习4：BMI 计算与判断
        System.out.println("\n--- 练习4 参考 ---");
        double weight = 70;
        double height2 = 1.75;
        double bmi = weight / (height2 * height2);
        System.out.printf("BMI: %.1f\n", bmi);
        if (bmi < 18.5) {
            System.out.println("偏瘦");
        } else if (bmi < 24) {
            System.out.println("正常");
        } else if (bmi < 28) {
            System.out.println("偏胖");
        } else {
            System.out.println("肥胖");
        }

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - 三种变量声明方式，推荐声明时直接赋值
         * - 8 种基本数据类型：byte/short/int/long/float/double/boolean/char
         * - 自动类型转换（小转大）和强制类型转换（大转小）
         *
         * 常见陷阱：
         * - long 类型忘记加 L 后缀
         * - float 类型忘记加 f 后缀
         * - 强制类型转换时丢失精度（如 3.14 变成 3）
         *
         * 下节课预告：
         * - 学习运算符与表达式，让数据真正"动起来"
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 01 课：变量与数据类型！");
        System.out.println("下节课我们将学习运算符与表达式。");
    }

    // 温度转换辅助方法：摄氏度转华氏度
    static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }
}
