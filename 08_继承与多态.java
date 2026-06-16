// =============================================
// 第 08 课：继承与多态
// =============================================
// 上节课我们学了面向对象编程。
// 这节课我们要学习"继承"和"多态"——OOP 的核心。
//
// 生活类比：
//   继承 = 遗传——孩子从父母那里继承了外貌和性格。
//   多态 = 同一个动作不同表现——
//   同样是"叫"，猫会喵喵叫，狗会汪汪叫。

class Inheritance {
    public static void main(String[] args) {
        // =============================================
        // 第一节：继承
        // =============================================

        System.out.println("=== 继承 ===");

        // 创建子类对象
        Cat cat = new Cat("咪咪", 3, "白色");
        Dog2 dog = new Dog2("旺财", 5);

        // 调用继承的方法
        cat.showInfo();
        dog.showInfo();

        // 调用子类特有的方法
        cat.purr();
        dog.fetch("飞盘");

        // =============================================
        // 第二节：方法重写
        // =============================================

        System.out.println("\n=== 方法重写 ===");

        // 子类重写了父类的方法
        cat.speak();  // 喵~
        dog.speak();  // 汪汪！

        // =============================================
        // 第三节：super 关键字
        // =============================================

        System.out.println("\n=== super 关键字 ===");

        // super 调用父类的构造方法和方法
        Kitten kitten = new Kitten("小咪", 1, "橘色");
        kitten.showInfo();

        // =============================================
        // 第四节：多态
        // =============================================

        System.out.println("\n=== 多态 ===");

        // 父类引用指向子类对象
        Animal animal1 = new Cat("小花", 2, "花色");
        Animal animal2 = new Dog2("小黑", 4);

        // 同样是调用 speak()，但行为不同
        animal1.speak();  // 喵~
        animal2.speak();  // 汪汪！

        // 多态数组
        Animal[] animals = {
            new Cat("猫1", 1, "白"),
            new Dog2("狗1", 2),
            new Cat("猫2", 3, "黑")
        };

        for (Animal a : animals) {
            a.speak();
        }

        // =============================================
        // 第五节：instanceof
        // =============================================

        System.out.println("\n=== instanceof ===");

        Animal animal = new Cat("测试猫", 5, "灰");

        if (animal instanceof Cat) {
            System.out.println(animal.name + " 是猫");
            Cat c = (Cat) animal;  // 向下转型
            c.purr();
        } else if (animal instanceof Dog2) {
            System.out.println(animal.name + " 是狗");
        }

        // =============================================
        // 【练习题】
        // =============================================

        System.out.println("\n==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：形状继承
        System.out.println("--- 练习1 参考 ---");
        Shape circle = new Circle2(5);
        Shape rect = new Rectangle2(4, 6);
        System.out.println("圆面积：" + String.format("%.2f", circle.area()));
        System.out.println("矩形面积：" + rect.area());

        // 练习2：员工系统
        System.out.println("\n--- 练习2 参考 ---");
        Employee emp1 = new Manager("张经理", 15000);
        Employee emp2 = new Developer("李工程师", 12000);
        emp1.showSalary();
        emp2.showSalary();

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - extends 实现继承，子类拥有父类的属性和方法
         * - @Override 重写父类方法，实现多态行为
         * - super 调用父类构造方法和方法
         *
         * 常见陷阱：
         * - 子类构造方法忘记调用 super()
         * - 向下转型前忘记 instanceof 检查
         * - 重写方法的访问权限不能比父类更严格
         *
         * 下节课预告：
         * - 学习异常处理，让程序在出错时也能优雅运行
         */

        // =============================================
        // 接口预告
        // =============================================
        /*
         * 接口（interface）是 Java 实现多态的另一种方式：
         * - 抽象类：可以有具体方法和抽象方法，子类只能继承一个
         * - 接口：只能有抽象方法（Java 8+ 可以有默认方法），类可以实现多个接口
         *
         * 接口就像"合同"——你签了合同，就必须履行合同里的所有条款。
         * 一个类可以签多份合同（实现多个接口），但只能有一个父亲（继承一个类）。
         *
         * 下节课我们将学习异常处理，之后在第 12 课详细讲解接口。
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 08 课：继承与多态！");
        System.out.println("下节课我们将学习异常处理。");
    }
}

// =============================================
// 基类
// =============================================

class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void speak() {
        System.out.println(name + "在叫");
    }

    void showInfo() {
        System.out.println(name + "，" + age + "岁");
    }
}

// =============================================
// 子类
// =============================================

class Cat extends Animal {
    String color;

    Cat(String name, int age, String color) {
        super(name, age);  // 调用父类构造方法
        this.color = color;
    }

    @Override
    void speak() {
        System.out.println(name + ": 喵~");
    }

    void purr() {
        System.out.println(name + ": 呼噜呼噜~");
    }
}

class Dog2 extends Animal {
    Dog2(String name, int age) {
        super(name, age);
    }

    @Override
    void speak() {
        System.out.println(name + ": 汪汪！");
    }

    void fetch(String item) {
        System.out.println(name + "叼回了" + item);
    }
}

class Kitten extends Cat {
    Kitten(String name, int age, String color) {
        super(name, age, color);
    }

    @Override
    void showInfo() {
        super.showInfo();  // 调用父类方法
        System.out.println("颜色：" + color);
    }
}

// =============================================
// 形状继承体系
// =============================================

abstract class Shape {
    abstract double area();
}

class Circle2 extends Shape {
    double radius;

    Circle2(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle2 extends Shape {
    double width, height;

    Rectangle2(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width * height;
    }
}

// =============================================
// 员工继承体系
// =============================================

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void showSalary() {
        System.out.println(name + "的工资：" + salary + "元");
    }
}

class Manager extends Employee {
    Manager(String name, double salary) {
        super(name, salary);
    }

    @Override
    void showSalary() {
        System.out.println(name + "（经理）的工资：" + salary + "元");
    }
}

class Developer extends Employee {
    Developer(String name, double salary) {
        super(name, salary);
    }

    @Override
    void showSalary() {
        System.out.println(name + "（工程师）的工资：" + salary + "元");
    }
}
