// =============================================
// 第 16 课：开发实战入门
// =============================================
// 前面的课程你已经学会了 Java 的各种语法。
// 这节课教你如何把学到的知识"组合"起来，做出真正有用的程序。
//
// 生活类比：
//   开发实战就像期末考试——
//   之前学的每个知识点（变量、循环、类...）就是一道道练习题，
//   现在要把它们全组合起来，解决一个完整的实际问题。
//   别怕，你已经准备好了！

import java.util.ArrayList;
import java.util.Scanner;

class DevPractice {
    public static void main(String[] args) {
        // =============================================
        // 第一个项目：简易计算器
        // =============================================

        System.out.println("========================================");
        System.out.println("项目1：简易计算器");
        System.out.println("========================================");

        /*
         * 【需求分析】
         * 做一个计算器，功能：
         * 1. 能做加法
         * 2. 能做减法
         * 3. 能做乘法
         * 4. 能做除法
         * 5. 能退出程序
         *
         * 【设计思路】
         * 1. 显示菜单让用户选择运算
         * 2. 用户输入两个数字
         * 3. 根据选择进行计算
         * 4. 显示结果
         * 5. 循环直到用户选择退出
         *
         * 【调用思路】
         * main() 主函数
         *     → 显示菜单
         *     → 获取用户选择
         *     → 调用 calculate() 做计算
         *     → 显示结果
         *     → 循环
         */

        // 创建 Scanner 对象用于读取输入
        Scanner scanner = new Scanner(System.in);

        // 无限循环
        while (true) {
            // 显示菜单
            System.out.println("\n================================");
            System.out.println("简易计算器");
            System.out.println("================================");
            System.out.println("1. 加法");
            System.out.println("2. 减法");
            System.out.println("3. 乘法");
            System.out.println("4. 除法");
            System.out.println("5. 退出");
            System.out.println("================================");

            // 获取用户选择
            System.out.print("请选择(1-5): ");
            String choice = scanner.nextLine();

            // 处理退出
            if (choice.equals("5")) {
                System.out.println("感谢使用，再见！");
                break;
            }

            // 验证选择
            if (!choice.matches("[1-4]")) {
                System.out.println("无效选择，请重试！");
                continue;
            }

            // 获取数字
            System.out.print("请输入第一个数字: ");
            double num1;
            try {
                num1 = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("输入的不是有效数字！");
                continue;
            }

            System.out.print("请输入第二个数字: ");
            double num2;
            try {
                num2 = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("输入的不是有效数字！");
                continue;
            }

            // 计算
            double result;
            String op;
            switch (choice) {
                case "1":
                    result = num1 + num2;
                    op = "+";
                    break;
                case "2":
                    result = num1 - num2;
                    op = "-";
                    break;
                case "3":
                    result = num1 * num2;
                    op = "×";
                    break;
                case "4":
                    if (num2 == 0) {
                        System.out.println("错误：除数不能为零！");
                        continue;
                    }
                    result = num1 / num2;
                    op = "÷";
                    break;
                default:
                    continue;
            }

            // 显示结果
            System.out.printf("\n%.2f %s %.2f = %.2f%n", num1, op, num2, result);
        }

        scanner.close();
    }
}

// =============================================
// 第二个项目：学生成绩管理
// =============================================

/*
 * 【需求分析】
 * 管理学生成绩，功能：
 * 1. 添加学生和成绩
 * 2. 查看所有学生
 * 3. 查找某个学生
 * 4. 统计平均分、最高分、最低分
 *
 * 【设计思路】
 * 1. 创建 StudentInfo 类存储学生信息
 * 2. 创建 StudentInfoManager 类管理学生
 * 3. 用 ArrayList 存储学生列表
 *
 * 【调用思路】
 * StudentInfoManager manager = new StudentInfoManager();
 *     → manager.addStudent() 添加学生
 *     → manager.showAll() 查看所有
 *     → manager.findStudent() 查找
 *     → manager.getStatistics() 统计
 */

class StudentInfo {
    /*
     * 学生类
     *
     * 【属性】
     * - name: 姓名
     * - age: 年龄
     * - score: 成绩
     *
     * 【方法】
     * - getName(): 获取姓名
     * - getScore(): 获取成绩
     * - toString(): 转为字符串
     */

    private String name;
    private int age;
    private double score;

    /**
     * 构造方法
     *
     * @param name  字符串，学生姓名
     * @param age   整数，学生年龄
     * @param score 浮点数，学生成绩
     *
     * 调用示例：
     * StudentInfo s = new StudentInfo("小明", 18, 85.5);
     */
    public StudentInfo(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // getter 方法
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getScore() { return score; }

    // setter 方法
    public void setScore(double score) { this.score = score; }

    @Override
    public String toString() {
        return String.format("%s, %d岁, %.1f分", name, age, score);
    }
}

class StudentInfoManager {
    /*
     * 学生管理类
     *
     * 【属性】
     * - students: ArrayList，存储所有学生
     *
     * 【方法】
     * - addStudent(student): 添加学生
     * - showAll(): 显示所有学生
     * - findStudent(name): 查找学生
     * - getStatistics(): 统计分析
     */

    private ArrayList<StudentInfo> students;

    /**
     * 构造方法
     *
     * 调用时机：创建对象时自动调用
     */
    public StudentInfoManager() {
        this.students = new ArrayList<>();
    }

    /**
     * 添加学生
     *
     * @param student StudentInfo 对象
     *
     * 调用示例：
     * manager.addStudent(new StudentInfo("小明", 18, 85));
     */
    public void addStudent(StudentInfo student) {
        students.add(student);
        System.out.println("✓ 已添加: " + student);
    }

    /**
     * 显示所有学生
     *
     * 调用示例：
     * manager.showAll();
     */
    public void showAll() {
        if (students.isEmpty()) {
            System.out.println("暂无学生数据！");
            return;
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.printf("%-6s%-12s%-8s%-8s%n", "序号", "姓名", "年龄", "成绩");
        System.out.println("=".repeat(50));

        for (int i = 0; i < students.size(); i++) {
            StudentInfo s = students.get(i);
            System.out.printf("%-6d%-12s%-8d%-8.1f%n", i + 1, s.getName(), s.getAge(), s.getScore());
        }

        System.out.println("=".repeat(50));
        System.out.println("共 " + students.size() + " 名学生");
    }

    /**
     * 查找学生
     *
     * @param name 字符串，学生姓名
     * @return StudentInfo 对象或 null
     *
     * 调用示例：
     * StudentInfo s = manager.findStudent("小明");
     */
    public StudentInfo findStudent(String name) {
        for (StudentInfo s : students) {
            if (s.getName().equals(name)) {
                return s;
            }
        }
        return null;
    }

    /**
     * 统计分析
     *
     * 调用示例：
     * manager.getStatistics();
     */
    public void getStatistics() {
        if (students.isEmpty()) {
            System.out.println("暂无数据！");
            return;
        }

        double sum = 0;
        double max = students.get(0).getScore();
        double min = students.get(0).getScore();

        for (StudentInfo s : students) {
            sum += s.getScore();
            if (s.getScore() > max) max = s.getScore();
            if (s.getScore() < min) min = s.getScore();
        }

        System.out.println("\n" + "=".repeat(30));
        System.out.println("统计分析");
        System.out.println("=".repeat(30));
        System.out.printf("学生总数: %d%n", students.size());
        System.out.printf("平均分: %.1f%n", sum / students.size());
        System.out.printf("最高分: %.1f%n", max);
        System.out.printf("最低分: %.1f%n", min);
    }
}

// 测试类
class StudentInfoManagerTest {
    public static void main(String[] args) {
        System.out.println("\n========================================");
        System.out.println("项目2：学生成绩管理");
        System.out.println("========================================");

        // 创建管理器
        StudentInfoManager manager = new StudentInfoManager();

        // 添加学生
        manager.addStudent(new StudentInfo("小明", 18, 85));
        manager.addStudent(new StudentInfo("小红", 19, 92));
        manager.addStudent(new StudentInfo("小刚", 20, 78));
        manager.addStudent(new StudentInfo("小丽", 18, 95));

        // 显示所有
        manager.showAll();

        // 查找
        StudentInfo found = manager.findStudent("小红");
        if (found != null) {
            System.out.println("\n找到: " + found);
        }

        // 统计
        manager.getStatistics();
    }
}

// =============================================
// 第三个项目：待办清单
// =============================================

/*
 * 【需求分析】
 * 管理待办事项，功能：
 * 1. 添加任务
 * 2. 完成任务
 * 3. 查看所有任务
 * 4. 查看未完成任务
 *
 * 【设计思路】
 * 1. 创建 Task 类
 * 2. 创建 TodoList 类
 * 3. 用 ArrayList 存储任务
 */

class Task {
    /*
     * 任务类
     *
     * 【属性】
     * - name: 任务名称
     * - done: 是否完成
     */

    private String name;
    private boolean done;

    /**
     * 构造方法
     *
     * @param name 字符串，任务名称
     */
    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    public String getName() { return name; }
    public boolean isDone() { return done; }
    public void setDone(boolean done) { this.done = done; }

    @Override
    public String toString() {
        String status = done ? "✓" : "○";
        return String.format("[%s] %s", status, name);
    }
}

class TodoList {
    /*
     * 待办清单类
     *
     * 【属性】
     * - tasks: ArrayList，存储任务
     *
     * 【方法】
     * - addTask(name): 添加任务
     * - completeTask(index): 完成任务
     * - showTasks(): 显示所有任务
     * - getPending(): 获取未完成任务
     */

    private ArrayList<Task> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * 添加任务
     *
     * @param name 字符串，任务名称
     *
     * 调用示例：
     * todo.addTask("学习 Java");
     */
    public void addTask(String name) {
        tasks.add(new Task(name));
        System.out.println("✓ 已添加任务: " + name);
    }

    /**
     * 完成任务
     *
     * @param index 整数，任务索引（从0开始）
     *
     * 调用示例：
     * todo.completeTask(0);
     */
    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setDone(true);
            System.out.println("✓ 已完成: " + tasks.get(index).getName());
        } else {
            System.out.println("无效的任务编号！");
        }
    }

    /**
     * 显示所有任务
     *
     * 调用示例：
     * todo.showTasks();
     */
    public void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("暂无任务！");
            return;
        }

        System.out.println("\n待办清单:");
        System.out.println("-".repeat(40));

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    /**
     * 获取未完成任务数量
     *
     * @return 整数，未完成任务数量
     */
    public int getPendingCount() {
        int count = 0;
        for (Task t : tasks) {
            if (!t.isDone()) count++;
        }
        return count;
    }
}

class TodoListTest {
    public static void main(String[] args) {
        System.out.println("\n========================================");
        System.out.println("项目3：待办清单");
        System.out.println("========================================");

        // 创建待办清单
        TodoList todo = new TodoList();

        // 添加任务
        todo.addTask("学习 Java");
        todo.addTask("做练习题");
        todo.addTask("复习笔记");

        // 显示所有任务
        todo.showTasks();

        // 完成第一个任务
        todo.completeTask(0);

        // 再次显示
        todo.showTasks();

        // 未完成任务
        System.out.println("\n未完成任务: " + todo.getPendingCount() + " 个");
    }
}

// =============================================
// 开发技巧总结
// =============================================

/*
 * 【开发技巧】
 *
 * 1. 先想后写
 *    - 动手前先想清楚要做什么
 *    - 画个流程图或写伪代码
 *
 * 2. 小步快跑
 *    - 不要一次写太多
 *    - 写一点，测试一点
 *
 * 3. 善用类和方法
 *    - 把相关的数据和方法放在一起
 *    - 一个方法只做一件事
 *
 * 4. 处理异常
 *    - 不要假设用户会按规矩输入
 *    - 用 try-catch 处理可能的错误
 *
 * 5. 写注释
 *    - 解释代码的用途
 *    - 说明参数和返回值
 *
 * 6. 命名规范
 *    - 类名用大驼峰（StudentInfoManager）
 *    - 方法名用小驼峰（addStudent）
 *    - 常量用全大写（MAX_SIZE）
 */

// =============================================
// 课程总结
// =============================================
/*
 * 核心收获：
 * - 开发流程：需求分析 → 设计 → 编码 → 测试 → 优化
 * - 用类和方法组织代码，一个方法只做一件事
 * - 用集合管理数据，用异常处理错误
 *
 * 常见陷阱：
 * - 不做需求分析就开始写代码
 * - 一个方法写了太多功能，难以维护
 * - 不处理用户输入的异常情况
 *
 * 下节课预告：
 * - 综合运用所有知识，完成一个完整的图书管理系统项目
 */

// =============================================
// 恭喜完成
// =============================================
// 恭喜你完成了第 16 课：开发实战入门！
// 下节课我们将学习项目实战。
