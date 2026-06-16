// =============================================
// 第 14 课：Lambda 与 Stream
// =============================================
// 上节课我们学了文件操作。
// 这节课我们要学习"Lambda"和"Stream"——Java 的函数式编程。
//
// 生活类比：
//   Lambda 就像便携式工具箱——小巧精炼，
//   随用随拿，用完就扔，不用每次都搬一整套工具。
//   Stream 就像传送带——数据在传送带上流动，
//   你可以在传送带上加滤网（filter）、贴标签（map），
//   最后把处理好的东西装箱（collect）。

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class LambdaAndStream {
    public static void main(String[] args) {
        // =============================================
        // 第一节：Lambda 表达式
        // =============================================

        System.out.println("=== Lambda 表达式 ===");

        // 传统写法
        List<String> names = Arrays.asList("小明", "小红", "小刚");

        // Lambda 写法
        names.forEach(name -> System.out.println("  " + name));

        // Lambda 作为参数
        List<Integer> numbers = Arrays.asList(5, 3, 1, 4, 2);
        Collections.sort(numbers, (a, b) -> a - b);
        System.out.println("排序后：" + numbers);

        // =============================================
        // 第二节：函数式接口
        // =============================================

        System.out.println("\n=== 函数式接口 ===");

        // Predicate：判断
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("4是偶数：" + isEven.test(4));
        System.out.println("5是偶数：" + isEven.test(5));

        // Function：转换
        Function<String, Integer> strLength = s -> s.length();
        System.out.println("Hello长度：" + strLength.apply("Hello"));

        // Consumer：消费
        Consumer<String> printer = s -> System.out.println("打印：" + s);
        printer.accept("测试");

        // Supplier：供给
        Supplier<Double> random = () -> Math.random();
        System.out.println("随机数：" + random.get());

        // =============================================
        // 第三节：Stream 基础
        // =============================================

        System.out.println("\n=== Stream 基础 ===");

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // filter：过滤
        List<Integer> evens = nums.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());
        System.out.println("偶数：" + evens);

        // map：转换
        List<Integer> doubled = nums.stream()
            .map(n -> n * 2)
            .collect(Collectors.toList());
        System.out.println("翻倍：" + doubled);

        // sorted：排序
        List<Integer> sorted = nums.stream()
            .sorted()
            .collect(Collectors.toList());
        System.out.println("排序：" + sorted);

        // =============================================
        // 第四节：Stream 聚合操作
        // =============================================

        System.out.println("\n=== Stream 聚合操作 ===");

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);

        // 求和
        int sum = numbers2.stream().mapToInt(Integer::intValue).sum();
        System.out.println("求和：" + sum);

        // 平均值
        double avg = numbers2.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("平均值：" + avg);

        // 最大值
        int max = numbers2.stream().mapToInt(Integer::intValue).max().orElse(0);
        System.out.println("最大值：" + max);

        // 计数
        long count = numbers2.stream().count();
        System.out.println("计数：" + count);

        // =============================================
        // 第五节：Stream 链式操作
        // =============================================

        System.out.println("\n=== Stream 链式操作 ===");

        List<String> words = Arrays.asList("hello", "java", "world", "stream");

        // 转大写，过滤长度>4，排序
        List<String> result = words.stream()
            .map(String::toUpperCase)
            .filter(w -> w.length() > 4)
            .sorted()
            .collect(Collectors.toList());
        System.out.println("结果：" + result);

        // =============================================
        // 第六节：Collectors 收集器
        // =============================================

        System.out.println("\n=== Collectors 收集器 ===");

        List<String> fruits = Arrays.asList("苹果", "香蕉", "橘子", "苹果", "香蕉");

        // 转为 Set（去重）
        Set<String> uniqueFruits = fruits.stream().collect(Collectors.toSet());
        System.out.println("去重：" + uniqueFruits);

        // 分组
        Map<Integer, List<String>> groupByLength = fruits.stream()
            .collect(Collectors.groupingBy(String::length));
        System.out.println("按长度分组：" + groupByLength);

        // 拼接
        String joined = fruits.stream().collect(Collectors.joining(", "));
        System.out.println("拼接：" + joined);

        // =============================================
        // 【练习题】
        // =============================================

        System.out.println("\n==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：成绩统计
        System.out.println("--- 练习1 参考 ---");
        List<Student4> students = Arrays.asList(
            new Student4("小明", 85),
            new Student4("小红", 92),
            new Student4("小刚", 78),
            new Student4("小丽", 95)
        );

        // 找90分以上的学生
        List<String> excellent = students.stream()
            .filter(s -> s.score >= 90)
            .map(s -> s.name)
            .collect(Collectors.toList());
        System.out.println("90分以上：" + excellent);

        // 计算平均分
        double avgScore = students.stream()
            .mapToInt(s -> s.score)
            .average()
            .orElse(0);
        System.out.println("平均分：" + String.format("%.1f", avgScore));

        // 练习2：单词处理
        System.out.println("\n--- 练习2 参考 ---");
        String sentence = "hello java world hello stream java";
        Map<String, Long> wordCount = Arrays.stream(sentence.split(" "))
            .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
        System.out.println("词频：" + wordCount);

        // 练习3：数字处理
        System.out.println("\n--- 练习3 参考 ---");
        List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 偶数平方和
        int evenSquareSum = nums2.stream()
            .filter(n -> n % 2 == 0)
            .map(n -> n * n)
            .mapToInt(Integer::intValue)
            .sum();
        System.out.println("偶数平方和：" + evenSquareSum);

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - Lambda 表达式简化匿名类写法
         * - Stream 的 filter/map/sorted/collect 链式操作
         * - Predicate/Function/Consumer 等函数式接口
         *
         * 常见陷阱：
         * - Stream 只能消费一次，不能重复使用
         * - Lambda 中引用的外部变量必须是 effectively final
         * - collect 操作是终端操作，会触发整个流水线执行
         *
         * 下节课预告：
         * - 学习多线程，让程序同时做多件事
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 14 课：Lambda与Stream！");
        System.out.println("下节课我们将学习多线程。");
    }
}

class Student4 {
    String name;
    int score;

    Student4(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
