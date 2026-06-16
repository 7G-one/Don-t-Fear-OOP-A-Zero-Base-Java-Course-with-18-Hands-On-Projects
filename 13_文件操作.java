// =============================================
// 第 13 课：文件操作
// =============================================
// 上节课我们学了泛型与接口。
// 这节课我们要学习"文件操作"——让程序读写文件。
//
// 生活类比：
//   文件操作就像读写笔记本——
//   打开笔记本（打开文件），写上内容（写入），
//   翻开看看之前写了什么（读取），用完记得合上（关闭）。
//   如果忘了合上，别人就没法用这本笔记本了。

import java.io.*;
import java.nio.file.*;
import java.util.*;

class FileOperations {
    public static void main(String[] args) {
        // =============================================
        // 第一节：写入文件
        // =============================================

        System.out.println("=== 写入文件 ===");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"))) {
            writer.write("Hello, Java!");
            writer.newLine();
            writer.write("这是第二行");
            writer.newLine();
            writer.write("这是第三行");
            System.out.println("文件写入成功！");
        } catch (IOException e) {
            System.out.println("写入失败：" + e.getMessage());
        }

        // =============================================
        // 第二节：读取文件
        // =============================================

        System.out.println("\n=== 读取文件 ===");

        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            String line;
            System.out.println("文件内容：");
            while ((line = reader.readLine()) != null) {
                System.out.println("  " + line);
            }
        } catch (IOException e) {
            System.out.println("读取失败：" + e.getMessage());
        }

        // =============================================
        // 第三节：追加写入
        // =============================================

        System.out.println("\n=== 追加写入 ===");

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("test.txt", true))) {
            writer.write("这是追加的内容");
            writer.newLine();
            System.out.println("追加成功！");
        } catch (IOException e) {
            System.out.println("追加失败：" + e.getMessage());
        }

        // =============================================
        // 第四节：NIO 文件操作
        // =============================================

        System.out.println("\n=== NIO 文件操作 ===");

        try {
            // 写入
            Files.writeString(Path.of("nio_test.txt"), "Hello NIO!");
            System.out.println("NIO写入成功！");

            // 读取
            String content = Files.readString(Path.of("nio_test.txt"));
            System.out.println("NIO读取：" + content);

            // 读取所有行
            List<String> lines = Files.readAllLines(Path.of("test.txt"));
            System.out.println("所有行：" + lines);

        } catch (IOException e) {
            System.out.println("NIO操作失败：" + e.getMessage());
        }

        // =============================================
        // 第五节：文件信息
        // =============================================

        System.out.println("\n=== 文件信息 ===");

        File file = new File("test.txt");
        System.out.println("文件名：" + file.getName());
        System.out.println("大小：" + file.length() + " 字节");
        System.out.println("存在：" + file.exists());
        System.out.println("是文件：" + file.isFile());
        System.out.println("是目录：" + file.isDirectory());

        // =============================================
        // 【练习题】
        // =============================================

        System.out.println("\n==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：成绩管理
        System.out.println("--- 练习1 参考 ---");
        try {
            // 写入成绩
            Files.writeString(Path.of("scores.txt"),
                "小明,85\n小红,92\n小刚,78\n");

            // 读取并计算平均分
            List<String> scoreLines = Files.readAllLines(Path.of("scores.txt"));
            int total = 0;
            for (String line : scoreLines) {
                String[] parts = line.split(",");
                total += Integer.parseInt(parts[1]);
            }
            System.out.println("平均分：" + total / scoreLines.size());
        } catch (IOException e) {
            System.out.println("错误：" + e.getMessage());
        }

        // 练习2：配置文件
        System.out.println("\n--- 练习2 参考 ---");
        try {
            // 写入JSON配置
            Files.writeString(Path.of("config.json"),
                "{\"name\":\"MyApp\",\"version\":\"1.0\"}");

            // 读取配置
            String config = Files.readString(Path.of("config.json"));
            System.out.println("配置：" + config);
        } catch (IOException e) {
            System.out.println("错误：" + e.getMessage());
        }

        // 练习3：日志系统
        System.out.println("\n--- 练习3 参考 ---");
        log("程序启动");
        log("用户登录");
        log("数据处理完成");

        // 清理测试文件
        new File("test.txt").delete();
        new File("nio_test.txt").delete();
        new File("scores.txt").delete();
        new File("config.json").delete();
        new File("app.log").delete();

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - FileReader/FileWriter + BufferedReader/BufferedWriter 读写文件
         * - NIO 的 Files.readString/writeString 简化操作（Java 11+）
         * - try-with-resources 自动关闭资源
         *
         * 常见陷阱：
         * - 忘记关闭资源导致文件句柄泄漏
         * - 文件路径问题：相对路径 vs 绝对路径
         * - 编码问题：中文文件需要指定 UTF-8
         *
         * 下节课预告：
         * - 学习 Lambda 与 Stream，体验函数式编程的魅力
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 13 课：文件操作！");
        System.out.println("下节课我们将学习Lambda与Stream。");
    }

    static void log(String message) {
        String timestamp = java.time.LocalDateTime.now().toString();
        String logLine = "[" + timestamp + "] " + message;
        System.out.println(logLine);
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("app.log", true))) {
            writer.write(logLine);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("日志写入失败");
        }
    }
}
