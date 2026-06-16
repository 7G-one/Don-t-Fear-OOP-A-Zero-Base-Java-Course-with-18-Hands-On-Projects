// =============================================
// 第 12 课：泛型与接口
// =============================================
// 上节课我们学了集合框架。
// 这节课我们要学习"泛型"和"接口"——Java 的抽象机制。
//
// 生活类比：
//   泛型就像万能盒子——不管放苹果还是放橘子，
//   只要你告诉它放什么类型，它就能安全地放进去取出来。
//   接口就像合同——规定了"你必须做哪些事"，
//   签了合同（implements）的类必须把这些事都做到。

import java.util.*;

class GenericsAndInterfaces {
    public static void main(String[] args) {
        // =============================================
        // 第一节：泛型类
        // =============================================

        System.out.println("=== 泛型类 ===");

        Box<String> stringBox = new Box<>("Hello");
        Box<Integer> intBox = new Box<>(42);

        System.out.println("字符串盒子：" + stringBox.get());
        System.out.println("整数盒子：" + intBox.get());

        // =============================================
        // 第二节：泛型方法
        // =============================================

        System.out.println("\n=== 泛型方法 ===");

        Integer[] intArr = {1, 2, 3, 4, 5};
        String[] strArr = {"a", "b", "c"};

        System.out.println("整数数组第一个：" + Utils.getFirst(intArr));
        System.out.println("字符串数组第一个：" + Utils.getFirst(strArr));

        // =============================================
        // 第三节：接口定义
        // =============================================

        System.out.println("\n=== 接口定义 ===");

        // 创建实现接口的对象
        Drawable circle = new Circle3(5);
        Drawable rect = new Rectangle3(4, 6);

        circle.draw();
        rect.draw();

        // =============================================
        // 第四节：接口作为参数
        // =============================================

        System.out.println("\n=== 接口作为参数 ===");

        drawShape(new Circle3(3));
        drawShape(new Rectangle3(2, 4));

        // =============================================
        // 第五节：多接口实现
        // =============================================

        System.out.println("\n=== 多接口实现 ===");

        SmartPhone phone = new SmartPhone();
        phone.call("123456");
        phone.takePhoto();
        phone.playGame();

        // =============================================
        // 第六节：Comparable 接口
        // =============================================

        System.out.println("\n=== Comparable 接口 ===");

        Student3[] students = {
            new Student3("小明", 85),
            new Student3("小红", 92),
            new Student3("小刚", 78)
        };

        Arrays.sort(students);
        System.out.println("按成绩排序：");
        for (Student3 s : students) {
            System.out.println("  " + s.name + "：" + s.score);
        }

        // =============================================
        // 【练习题】
        // =============================================

        System.out.println("\n==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：泛型栈
        System.out.println("--- 练习1 参考 ---");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("栈顶：" + stack.peek());
        System.out.println("弹出：" + stack.pop());
        System.out.println("大小：" + stack.size());

        // 练习2：接口实现
        System.out.println("\n--- 练习2 参考 ---");
        Printable doc = new Document("报告");
        doc.print();

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - 泛型类和泛型方法实现类型安全的通用代码
         * - 接口定义行为规范，类通过 implements 实现接口
         * - 一个类可以实现多个接口
         *
         * 常见陷阱：
         * - 泛型不支持基本类型（用 Integer 不用 int）
         * - 接口方法默认 public，实现时不能降低权限
         * - 接口中 default 方法需要 Java 8+
         *
         * 下节课预告：
         * - 学习文件操作，让程序能读写文件
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 12 课：泛型与接口！");
        System.out.println("下节课我们将学习文件操作。");
    }

    // 接口作为参数的方法
    static void drawShape(Drawable shape) {
        shape.draw();
    }
}

// =============================================
// 泛型类
// =============================================

class Box<T> {
    private T value;

    Box(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }

    void set(T value) {
        this.value = value;
    }
}

// 泛型方法
class Utils {
    static <T> T getFirst(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        return array[0];
    }
}

// =============================================
// 接口定义
// =============================================

interface Drawable {
    void draw();
}

interface Resizable {
    void resize(double factor);
}

interface Callable {
    void call(String number);
}

interface Photographable {
    void takePhoto();
}

interface Playable {
    void playGame();
}

// =============================================
// 接口实现
// =============================================

class Circle3 implements Drawable, Resizable {
    double radius;

    Circle3(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("画一个圆，半径：" + radius);
    }

    @Override
    public void resize(double factor) {
        radius *= factor;
    }
}

class Rectangle3 implements Drawable {
    double width, height;

    Rectangle3(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("画一个矩形：" + width + "x" + height);
    }
}

class SmartPhone implements Callable, Photographable, Playable {
    @Override
    public void call(String number) {
        System.out.println("打电话给：" + number);
    }

    @Override
    public void takePhoto() {
        System.out.println("拍照");
    }

    @Override
    public void playGame() {
        System.out.println("玩游戏");
    }
}

// =============================================
// Comparable 接口
// =============================================

class Student3 implements Comparable<Student3> {
    String name;
    int score;

    Student3(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student3 other) {
        return this.score - other.score;  // 升序
    }
}

// =============================================
// Printable 接口
// =============================================

interface Printable {
    void print();
}

class Document implements Printable {
    String name;

    Document(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println("打印文档：" + name);
    }
}

// 泛型栈
class Stack<T> {
    private java.util.List<T> elements = new ArrayList<>();

    void push(T item) {
        elements.add(item);
    }

    T pop() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.remove(elements.size() - 1);
    }

    T peek() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.get(elements.size() - 1);
    }

    int size() {
        return elements.size();
    }
}
