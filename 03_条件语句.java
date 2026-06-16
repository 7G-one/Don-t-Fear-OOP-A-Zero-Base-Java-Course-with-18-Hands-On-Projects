// =============================================
// 第 03 课：条件语句
// =============================================
// 上节课我们学了运算符和表达式。
// 这节课我们要学习"条件语句"——让程序学会"思考"。
//
// 生活类比：
//   if-else 就像岔路口——走到路口时，
//   如果左边是学校就左转，否则就右转。
//   程序也是一样，根据条件走不同的路。

class Conditionals {
    public static void main(String[] args) {
        // =============================================
        // 第一节：if 语句
        // =============================================

        // 【基本语法】
        // if (条件) {
        //     要做的事情
        // }

        System.out.println("=== if 语句 ===");

        int age = 18;

        if (age >= 18) {
            System.out.println("你已经成年了");
        }

        // =============================================
        // 第二节：if-else 语句
        // =============================================

        // 【语法】
        // if (条件) {
        //     条件为真时做的事情
        // } else {
        //     条件为假时做的事情
        // }

        System.out.println("\n=== if-else 语句 ===");

        int score = 45;

        if (score >= 60) {
            System.out.println("恭喜，你及格了！");
        } else {
            System.out.println("很遗憾，你不及格");
        }

        // =============================================
        // 第三节：if-else if-else 语句
        // =============================================

        // 【多分支判断】
        System.out.println("\n=== if-else if-else ===");

        int score2 = 85;

        if (score2 >= 90) {
            System.out.println("优秀！");
        } else if (score2 >= 80) {
            System.out.println("良好！");
        } else if (score2 >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }

        // =============================================
        // 第四节：嵌套 if
        // =============================================

        System.out.println("\n=== 嵌套 if ===");

        int age2 = 25;
        boolean hasLicense = true;

        if (age2 >= 18) {
            System.out.println("已成年");
            if (hasLicense) {
                System.out.println("可以开车");
            } else {
                System.out.println("需要先考驾照");
            }
        } else {
            System.out.println("未成年，不能开车");
        }

        // =============================================
        // 第五节：switch 语句
        // =============================================

        // 【switch 语句】
        // 适合多个固定值的判断

        System.out.println("\n=== switch 语句 ===");

        int day = 3;
        String dayName;

        switch (day) {
            case 1:
                dayName = "星期一";
                break;
            case 2:
                dayName = "星期二";
                break;
            case 3:
                dayName = "星期三";
                break;
            case 4:
                dayName = "星期四";
                break;
            case 5:
                dayName = "星期五";
                break;
            case 6:
                dayName = "星期六";
                break;
            case 7:
                dayName = "星期日";
                break;
            default:
                dayName = "无效日期";
                break;
        }
        System.out.println("第" + day + "天是" + dayName);

        // 用 if-else 实现同样的功能（兼容 JDK 8）
        String dayName2;
        if (day == 1) {
            dayName2 = "星期一";
        } else if (day == 2) {
            dayName2 = "星期二";
        } else if (day == 3) {
            dayName2 = "星期三";
        } else if (day == 4) {
            dayName2 = "星期四";
        } else if (day == 5) {
            dayName2 = "星期五";
        } else if (day == 6) {
            dayName2 = "星期六";
        } else if (day == 7) {
            dayName2 = "星期日";
        } else {
            dayName2 = "无效日期";
        }
        System.out.println("if-else实现：" + dayName2);

        // =============================================
        // 【练习题】
        // =============================================

        System.out.println("\n==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：闰年判断
        System.out.println("\n--- 练习1 参考 ---");
        int year = 2024;
        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        System.out.println(year + "年是闰年：" + isLeap);

        // 练习2：BMI 判断
        System.out.println("\n--- 练习2 参考 ---");
        double weight = 70;
        double height = 1.75;
        double bmi = weight / (height * height);
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

        // 练习3：密码检查
        System.out.println("\n--- 练习3 参考 ---");
        String password = "123456";
        if (password.length() < 8) {
            System.out.println("密码太短");
        } else if (password.equals("123456")) {
            System.out.println("密码太简单");
        } else {
            System.out.println("密码强度OK");
        }

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - if / if-else / if-else if-else 三种条件结构
         * - switch 语句适合多值匹配场景
         * - 嵌套 if 处理复杂条件
         *
         * 常见陷阱：
         * - if 条件后误加分号：if (x > 0); { ... }
         * - switch 忘记写 break 导致穿透
         * - == 比较字符串应用 .equals() 方法
         *
         * 下节课预告：
         * - 学习循环语句（for/while），让程序重复做事情
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 03 课：条件语句！");
        System.out.println("下节课我们将学习循环语句。");
    }
}
