// =============================================
// 第 10 课：字符串操作
// =============================================
// 上节课我们学了异常处理。
// 这节课我们要学习"字符串操作"——处理文字的方法。
//
// 生活类比：
//   字符串就像一串珠子——每颗珠子是一个字符。
//   你可以数珠子（length）、找某颗珠子（indexOf）、
//   截取一段珠子（substring）、把珠子换成别的（replace）。

class StringOperations {
    public static void main(String[] args) {
        // =============================================
        // 第一节：创建字符串
        // =============================================

        System.out.println("=== 创建字符串 ===");

        String s1 = "Hello";           // 字面量
        String s2 = new String("World");  // 构造方法
        String s3 = s1 + " " + s2;     // 拼接

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        // =============================================
        // 第二节：字符串长度
        // =============================================

        System.out.println("\n=== 字符串长度 ===");

        String text = "Hello Java";
        System.out.println("字符串：" + text);
        System.out.println("长度：" + text.length());

        // =============================================
        // 第三节：字符串查找
        // =============================================

        System.out.println("\n=== 字符串查找 ===");

        String str = "Hello Java World";

        System.out.println("charAt(0)：" + str.charAt(0));  // H
        System.out.println("indexOf('Java')：" + str.indexOf("Java"));  // 6
        System.out.println("contains('Java')：" + str.contains("Java"));  // true
        System.out.println("startsWith('Hello')：" + str.startsWith("Hello"));  // true
        System.out.println("endsWith('World')：" + str.endsWith("World"));  // true

        // =============================================
        // 第四节：字符串截取
        // =============================================

        System.out.println("\n=== 字符串截取 ===");

        String str2 = "Hello Java World";

        System.out.println("substring(6)：" + str2.substring(6));  // Java World
        System.out.println("substring(6, 10)：" + str2.substring(6, 10));  // Java

        // =============================================
        // 第五节：字符串转换
        // =============================================

        System.out.println("\n=== 字符串转换 ===");

        String str3 = "  Hello Java  ";

        System.out.println("toUpperCase()：" + str3.toUpperCase());
        System.out.println("toLowerCase()：" + str3.toLowerCase());
        System.out.println("trim()：'" + str3.trim() + "'");
        System.out.println("replace('Java', 'World')：" + str3.replace("Java", "World"));

        // =============================================
        // 第六节：字符串分割
        // =============================================

        System.out.println("\n=== 字符串分割 ===");

        String csv = "苹果,香蕉,橘子,葡萄";
        String[] fruits = csv.split(",");

        System.out.println("分割结果：");
        for (String fruit : fruits) {
            System.out.println("  " + fruit);
        }

        // =============================================
        // 第七节：StringBuilder
        // =============================================

        System.out.println("\n=== StringBuilder ===");

        StringBuilder sb = new StringBuilder();
        sb.append("Hello");
        sb.append(" ");
        sb.append("Java");
        sb.append(" ");
        sb.append("World");

        System.out.println("结果：" + sb.toString());
        System.out.println("长度：" + sb.length());

        // StringBuilder 效率更高
        StringBuilder sb2 = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            sb2.append(i).append(" ");
        }
        System.out.println("数字：" + sb2.toString());

        // =============================================
        // 第八节：格式化输出
        // =============================================

        System.out.println("\n=== 格式化输出 ===");

        String name = "小明";
        int age = 18;
        double score = 95.678;

        // printf 格式化
        System.out.printf("姓名：%s，年龄：%d岁%n", name, age);
        System.out.printf("成绩：%.1f分%n", score);
        System.out.printf("宽度10：%10s%n", name);
        System.out.printf("左对齐：%-10s%n", name);

        // String.format
        String formatted = String.format("我叫%s，今年%d岁", name, age);
        System.out.println(formatted);

        // =============================================
        // 【练习题】
        // =============================================

        System.out.println("\n==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：字符串反转
        System.out.println("--- 练习1 参考 ---");
        String original = "Hello";
        String reversed = new StringBuilder(original).reverse().toString();
        System.out.println("原字符串：" + original);
        System.out.println("反转后：" + reversed);

        // 练习2：统计字符
        System.out.println("\n--- 练习2 参考 ---");
        String text2 = "Hello Java";
        int count = 0;
        for (char c : text2.toCharArray()) {
            if (c == 'a') count++;
        }
        System.out.println("'a'出现次数：" + count);

        // 练习3：隐藏手机号
        System.out.println("\n--- 练习3 参考 ---");
        String phone = "13812345678";
        String hidden = phone.substring(0, 3) + "****" + phone.substring(7);
        System.out.println("原手机号：" + phone);
        System.out.println("隐藏后：" + hidden);

        // 练习4：首字母大写
        System.out.println("\n--- 练习4 参考 ---");
        String str4 = "hello java";
        String[] words = str4.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0)))
                  .append(word.substring(1))
                  .append(" ");
        }
        System.out.println("首字母大写：" + result.toString().trim());

        // 练习5：单词统计
        System.out.println("\n--- 练习5 参考 ---");
        String sentence = "hello java hello world";
        String[] wordArr = sentence.split(" ");
        java.util.Map<String, Integer> wordCount = new java.util.HashMap<>();
        for (String word : wordArr) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("词频统计：" + wordCount);

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - String 是不可变对象，每次操作都创建新字符串
         * - 常用方法：length/charAt/substring/contains/replace/split
         * - StringBuilder 可变，适合大量拼接操作
         *
         * 常见陷阱：
         * - 字符串比较用 == 只比较引用，应用 .equals()
         * - 大量拼接用 String 会产生大量临时对象
         * - substring 的结束索引是不包含的
         *
         * 下节课预告：
         * - 学习集合框架，用 ArrayList、HashMap 管理数据
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 10 课：字符串操作！");
        System.out.println("下节课我们将学习集合框架。");
    }
}
