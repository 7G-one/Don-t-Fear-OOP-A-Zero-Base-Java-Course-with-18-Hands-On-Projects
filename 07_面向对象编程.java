// =============================================
// 第 07 课：面向对象编程
// =============================================
// 上节课我们学了方法。
// 这节课我们要学习"面向对象编程"——Java 的核心思想。
//
// 生活类比：
//   类 = 图纸，对象 = 实物；类 = 饼干模具，对象 = 饼干。
//   你先画好图纸（定义类），然后照着图纸做出实物（创建对象）。
//   一张图纸可以做出很多个实物，每个实物都独立存在。

class OOP {
    public static void main(String[] args) {
        // =============================================
        // 第一节：类和对象
        // =============================================

        System.out.println("=== 类和对象 ===");

        /*
         * 【类和对象的关系】
         *
         * 类（Class）：模板、蓝图
         * 对象（Object）：用模板做出来的东西
         *
         * 比喻：
         * - 类：饼干模具
         * - 对象：用模具做出来的饼干
         *
         * 【类的组成部分】
         * 1. 属性（数据）：对象有什么
         * 2. 方法（行为）：对象能做什么
         */

        // 创建对象
        Dog dog1 = new Dog("旺财", 3);
        Dog dog2 = new Dog("小白", 2);

        // 调用方法
        dog1.bark();
        dog2.bark();
        dog1.showInfo();

        // =============================================
        // 第二节：构造方法
        // =============================================

        System.out.println("\n=== 构造方法 ===");

        /*
         * 【什么是构造方法？】
         * 创建对象时自动调用的方法
         * 用于初始化对象的属性
         *
         * 【特点】
         * 1. 方法名与类名相同
         * 2. 没有返回值
         * 3. 可以有多个（重载）
         */

        // 使用有参构造
        Student s1 = new Student("小明", 18);
        s1.showInfo();

        // 使用无参构造
        Student s2 = new Student();
        s2.showInfo();

        // =============================================
        // 第三节：getter 和 setter
        // =============================================

        System.out.println("\n=== getter 和 setter ===");

        /*
         * 【为什么需要 getter 和 setter？】
         * 1. 控制属性的访问权限
         * 2. 添加验证逻辑
         * 3. 保持封装性
         */

        Person person = new Person();
        person.setName("小红");
        person.setAge(20);
        System.out.println("姓名：" + person.getName());
        System.out.println("年龄：" + person.getAge());

        // =============================================
        // 第四节：this 关键字
        // =============================================

        System.out.println("\n=== this 关键字 ===");

        /*
         * 【this 是什么？】
         * this 代表"当前对象"
         * 用于区分同名的属性和参数
         */

        Calculator calc = new Calculator();
        calc.add(10).add(20).add(30);
        System.out.println("结果：" + calc.getResult());

        // =============================================
        // 第五节：static 关键字
        // =============================================

        System.out.println("\n=== static 关键字 ===");

        /*
         * 【static 是什么？】
         * static 表示"静态的"、"属于类的"
         *
         * 【静态成员 vs 实例成员】
         * - 静态：属于类，所有对象共享
         * - 实例：属于对象，每个对象独有
         */

        // 静态方法直接通过类名调用
        System.out.println("最大值：" + MathUtils.max(10, 20));
        System.out.println("最小值：" + MathUtils.min(10, 20));

        // =============================================
        // 练习题
        // =============================================

        System.out.println("\n==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：矩形类
        System.out.println("--- 练习1 参考 ---");
        Rectangle rect = new Rectangle(10, 20);
        System.out.println("面积：" + rect.area());
        System.out.println("周长：" + rect.perimeter());

        // 练习2：银行账户
        System.out.println("\n--- 练习2 参考 ---");
        BankAccount account = new BankAccount("小明", 1000);
        account.deposit(500);
        account.withdraw(200);
        account.showBalance();

        // 练习3：学生管理
        System.out.println("\n--- 练习3 参考 ---");
        StudentManager manager = new StudentManager();
        manager.addStudent(new Student("小明", "85"));
        manager.addStudent(new Student("小红", "92"));
        manager.addStudent(new Student("小刚", "78"));
        manager.showAll();

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - 类是模板，对象是实例，构造方法用于初始化
         * - getter/setter 实现封装，保护内部数据
         * - this 指向当前对象，static 属于类本身
         *
         * 常见陷阱：
         * - 构造方法签名冲突（参数类型列表必须不同）
         * - 忘记用 this 区分同名的属性和参数
         * - 静态方法中不能直接访问实例变量
         *
         * 下节课预告：
         * - 学习继承与多态，构建类之间的层次关系
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 07 课：面向对象编程！");
        System.out.println("下节课我们将学习继承与多态。");
    }
}

// =============================================
// 类定义
// =============================================

class Dog {
    /*
     * 狗类
     *
     * 【属性】
     * - name: 名字
     * - age: 年龄
     *
     * 【方法】
     * - bark(): 叫
     * - showInfo(): 显示信息
     */

    String name;
    int age;

    // 构造方法
    Dog(String name, int age) {
        /*
         * 初始化方法
         *
         * 【参数】
         * - name: 字符串，狗的名字
         * - age: 整数，狗的年龄
         *
         * 【调用时机】
         * 创建对象时自动调用
         *
         * 【调用示例】
         * Dog dog = new Dog("旺财", 3);
         */

        this.name = name;
        this.age = age;
    }

    void bark() {
        /*
         * 叫
         *
         * 【作用】
         * 打印狗叫的声音
         *
         * 【调用示例】
         * dog.bark();  // 输出: 旺财: 汪汪汪！
         */

        System.out.println(name + ": 汪汪汪！");
    }

    void showInfo() {
        /*
         * 显示信息
         *
         * 【作用】
         * 打印狗的名字和年龄
         *
         * 【调用示例】
         * dog.showInfo();  // 输出: 旺财，3岁
         */

        System.out.println(name + "，" + age + "岁");
    }
}

class Student {
    /*
     * 学生类
     *
     * 【属性】
     * - name: 姓名
     * - age: 年龄
     * - score: 成绩
     *
     * 【方法】
     * - showInfo(): 显示信息
     */

    String name;
    int age;
    int score;

    // 无参构造
    Student() {
        this.name = "未知";
        this.age = 0;
    }

    // 有参构造
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 有参构造（带成绩，使用 String 类型避免与年龄构造函数冲突）
    Student(String name, String scoreStr) {
        this.name = name;
        this.score = Integer.parseInt(scoreStr);
    }

    void showInfo() {
        System.out.println(name + "，" + age + "岁");
    }
}

class Person {
    /*
     * 人类
     *
     * 【属性】
     * - name: 姓名（私有）
     * - age: 年龄（私有）
     *
     * 【方法】
     * - getter/setter
     */

    private String name;
    private int age;

    // getter
    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    // setter
    void setName(String name) {
        this.name = name;
    }

    void setAge(int age) {
        if (age >= 0 && age <= 150) {
            this.age = age;
        }
    }
}

class Calculator {
    /*
     * 计算器类
     *
     * 【属性】
     * - result: 计算结果
     *
     * 【方法】
     * - add(n): 加法
     * - getResult(): 获取结果
     */

    private int result = 0;

    Calculator add(int n) {
        /*
         * 加法
         *
         * 【参数】
         * - n: 整数，要加的数
         *
         * 【返回值】
         * Calculator，支持链式调用
         *
         * 【调用示例】
         * calc.add(10).add(20).add(30);
         */

        result += n;
        return this;  // 返回自己，支持链式调用
    }

    int getResult() {
        return result;
    }
}

class MathUtils {
    /*
     * 数学工具类
     *
     * 【方法】
     * - max(a, b): 最大值
     * - min(a, b): 最小值
     */

    static int max(int a, int b) {
        /*
         * 最大值
         *
         * 【参数】
         * - a: 整数
         * - b: 整数
         *
         * 【返回值】
         * 整数，a 和 b 中的较大值
         *
         * 【调用示例】
         * MathUtils.max(10, 20)  // 返回 20
         */

        return a > b ? a : b;
    }

    static int min(int a, int b) {
        return a < b ? a : b;
    }
}

class Rectangle {
    /*
     * 矩形类
     *
     * 【属性】
     * - width: 宽度
     * - height: 高度
     *
     * 【方法】
     * - area(): 面积
     * - perimeter(): 周长
     */

    double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double area() {
        /*
         * 计算面积
         *
         * 【返回值】
         * 浮点数，矩形的面积
         *
         * 【调用示例】
         * rect.area()  // 返回 width * height
         */

        return width * height;
    }

    double perimeter() {
        /*
         * 计算周长
         *
         * 【返回值】
         * 浮点数，矩形的周长
         *
         * 【调用示例】
         * rect.perimeter()  // 返回 2 * (width + height)
         */

        return 2 * (width + height);
    }
}

class BankAccount {
    /*
     * 银行账户类
     *
     * 【属性】
     * - owner: 户主
     * - balance: 余额
     *
     * 【方法】
     * - deposit(amount): 存款
     * - withdraw(amount): 取款
     * - showBalance(): 显示余额
     */

    String owner;
    double balance;

    BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    void deposit(double amount) {
        /*
         * 存款
         *
         * 【参数】
         * - amount: 数字，存款金额
         *
         * 【调用示例】
         * account.deposit(500);
         */

        balance += amount;
        System.out.println("存入" + amount + "元");
    }

    void withdraw(double amount) {
        /*
         * 取款
         *
         * 【参数】
         * - amount: 数字，取款金额
         *
         * 【调用示例】
         * account.withdraw(200);
         */

        if (amount <= balance) {
            balance -= amount;
            System.out.println("取出" + amount + "元");
        } else {
            System.out.println("余额不足");
        }
    }

    void showBalance() {
        System.out.println(owner + "的余额：" + balance + "元");
    }
}

class StudentManager {
    /*
     * 学生管理类
     *
     * 【属性】
     * - students: 学生数组
     * - count: 学生数量
     *
     * 【方法】
     * - addStudent(student): 添加学生
     * - showAll(): 显示所有学生
     */

    Student[] students = new Student[100];
    int count = 0;

    void addStudent(Student s) {
        /*
         * 添加学生
         *
         * 【参数】
         * - s: Student 对象
         *
         * 【调用示例】
         * manager.addStudent(new Student("小明", 85));
         */

        students[count++] = s;
    }

    void showAll() {
        /*
         * 显示所有学生
         *
         * 【调用示例】
         * manager.showAll();
         */

        for (int i = 0; i < count; i++) {
            System.out.println(students[i].name + "：" + students[i].score + "分");
        }
    }
}
