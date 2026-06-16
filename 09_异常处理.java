// =============================================
// 第 09 课：异常处理
// =============================================
// 上节课我们学了继承与多态。
// 这节课我们要学习"异常处理"——让程序更健壮。
//
// 生活类比：
//   异常处理就像开车时的安全气囊——
//   平时你感觉不到它的存在，但一旦发生意外（异常），
//   它就会自动弹出保护你（catch 捕获异常），
//   让你不会因为一次事故就车毁人亡（程序崩溃）。

class ExceptionHandling {
    public static void main(String[] args) {
        // =============================================
        // 第一节：什么是异常？
        // =============================================

        System.out.println("=== 什么是异常 ===");

        // 常见异常示例（注释掉避免崩溃）
        // int result = 10 / 0;  // ArithmeticException
        // int[] arr = new int[3];
        // arr[5] = 10;  // ArrayIndexOutOfBoundsException
        // String s = null;
        // s.length();  // NullPointerException

        // =============================================
        // 第二节：try-catch
        // =============================================

        System.out.println("\n=== try-catch ===");

        // 基本语法
        try {
            int result = 10 / 0;
            System.out.println("结果：" + result);
        } catch (ArithmeticException e) {
            System.out.println("错误：除数不能为零！");
            System.out.println("错误信息：" + e.getMessage());
        }

        // =============================================
        // 第三节：多个 catch
        // =============================================

        System.out.println("\n=== 多个 catch ===");

        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("错误：数组索引越界！");
        } catch (Exception e) {
            System.out.println("错误：" + e.getMessage());
        }

        // =============================================
        // 第四节：finally
        // =============================================

        System.out.println("\n=== finally ===");

        try {
            int result = 10 / 2;
            System.out.println("结果：" + result);
        } catch (ArithmeticException e) {
            System.out.println("错误：" + e.getMessage());
        } finally {
            System.out.println("finally：总是执行");
        }

        // =============================================
        // 第五节：throws 声明异常
        // =============================================

        System.out.println("\n=== throws ===");

        try {
            checkAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("错误：" + e.getMessage());
        }

        // =============================================
        // 第六节：自定义异常
        // =============================================

        System.out.println("\n=== 自定义异常 ===");

        try {
            validatePassword("123");
        } catch (WeakPasswordException e) {
            System.out.println("密码错误：" + e.getMessage());
        }

        // =============================================
        // 【练习题】
        // =============================================

        System.out.println("\n==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：安全除法
        System.out.println("--- 练习1 参考 ---");
        System.out.println("10 / 3 = " + safeDivide(10, 3));
        System.out.println("10 / 0 = " + safeDivide(10, 0));

        // 练习2：输入验证
        System.out.println("\n--- 练习2 参考 ---");
        try {
            parseAge("abc");
        } catch (NumberFormatException e) {
            System.out.println("错误：" + e.getMessage());
        }

        // 练习3：文件读取
        System.out.println("\n--- 练习3 参考 ---");
        readFile("不存在的文件.txt");

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - try-catch-finally 的完整异常处理流程
         * - throw 主动抛出异常，throws 声明异常
         * - 自定义异常类继承 Exception
         *
         * 常见陷阱：
         * - catch(Exception e) 吞掉所有异常不处理
         * - finally 中写 return 会覆盖 try 中的返回值
         * - 只 catch 不处理，什么都不做
         *
         * 下节课预告：
         * - 学习字符串操作，掌握处理文本的各种方法
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 09 课：异常处理！");
        System.out.println("下节课我们将学习字符串操作。");
    }

    // =============================================
    // 辅助方法
    // =============================================

    static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("年龄必须大于18岁");
        }
        System.out.println("年龄验证通过");
    }

    static void validatePassword(String password) throws WeakPasswordException {
        if (password.length() < 8) {
            throw new WeakPasswordException("密码长度不足");
        }
    }

    static double safeDivide(int a, int b) {
        try {
            return (double) a / b;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    static int parseAge(String s) {
        return Integer.parseInt(s);
    }

    static void readFile(String filename) {
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(
                new java.io.FileReader(filename)
            );
            reader.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("文件不存在：" + filename);
        } catch (java.io.IOException e) {
            System.out.println("读取错误：" + e.getMessage());
        }
    }
}

// 自定义异常
class WeakPasswordException extends Exception {
    WeakPasswordException(String message) {
        super(message);
    }
}
