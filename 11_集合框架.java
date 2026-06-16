// =============================================
// 第 11 课：集合框架
// =============================================
// 上节课我们学了字符串操作。
// 这节课我们要学习"集合框架"——存储数据的容器。
//
// 生活类比：
//   集合就像不同种类的容器——
//   ArrayList 像书架，按顺序排列，随时拿取；
//   HashMap 像字典，通过词条（key）查释义（value）；
//   HashSet 像标签盒，自动去重，不放重复标签。

import java.util.*;

class CollectionsDemo {
    public static void main(String[] args) {
        // =============================================
        // 第一节：ArrayList
        // =============================================

        System.out.println("=== ArrayList ===");

        // 创建 ArrayList
        List<String> fruits = new ArrayList<>();
        fruits.add("苹果");
        fruits.add("香蕉");
        fruits.add("橘子");

        System.out.println("列表：" + fruits);
        System.out.println("长度：" + fruits.size());
        System.out.println("第一个：" + fruits.get(0));

        // 修改
        fruits.set(1, "芒果");
        System.out.println("修改后：" + fruits);

        // 删除
        fruits.remove(0);
        System.out.println("删除后：" + fruits);

        // 遍历
        System.out.println("遍历：");
        for (String fruit : fruits) {
            System.out.println("  " + fruit);
        }

        // =============================================
        // 第二节：LinkedList
        // =============================================

        System.out.println("\n=== LinkedList ===");

        LinkedList<String> list = new LinkedList<>();
        list.addFirst("第一个");
        list.addLast("最后一个");
        list.add("中间");

        System.out.println("列表：" + list);
        System.out.println("第一个：" + list.getFirst());
        System.out.println("最后一个：" + list.getLast());

        // =============================================
        // 第二节补充：ArrayList vs LinkedList 选型指南
        // =============================================

        System.out.println("\n=== ArrayList vs LinkedList ===");

        /*
         * ArrayList：底层是数组
         *   - 随机访问 get(i)：O(1)，直接用下标定位，非常快
         *   - 插入/删除：O(n)，需要移动后续所有元素
         *   - 适合：频繁读取、遍历的场景
         *
         * LinkedList：底层是双向链表
         *   - 随机访问 get(i)：O(n)，需要从头/尾一个个找
         *   - 插入/删除：O(1)，只要找到位置，改两个指针就行
         *   - 适合：频繁在头部插入删除的场景
         *
         * 结论：99% 的情况用 ArrayList 就够了
         * 只有频繁在列表头部插入/删除时才考虑 LinkedList
         */

        // 性能对比演示
        List<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        // 头部插入：LinkedList 更快
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            arrayList.add(0, "元素" + i);  // 每次插入头部，后面所有元素要移动
        }
        long arrayListTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            linkedList.addFirst("元素" + i);  // 插入头部，只改指针
        }
        long linkedListTime = System.nanoTime() - start;

        System.out.println("头部插入 10000 次：");
        System.out.println("  ArrayList 耗时：" + arrayListTime / 1_000_000 + " ms");
        System.out.println("  LinkedList 耗时：" + linkedListTime / 1_000_000 + " ms");
        System.out.println("  -> 头部插入场景，LinkedList 更快");

        // =============================================
        // 第三节：HashMap
        // =============================================

        System.out.println("\n=== HashMap ===");

        // 创建 HashMap
        Map<String, Integer> scores = new HashMap<>();
        scores.put("小明", 85);
        scores.put("小红", 92);
        scores.put("小刚", 78);

        System.out.println("字典：" + scores);
        System.out.println("小明的成绩：" + scores.get("小明"));
        System.out.println("包含小红：" + scores.containsKey("小红"));

        // 遍历
        System.out.println("遍历：");
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println("  " + entry.getKey() + "：" + entry.getValue());
        }

        // =============================================
        // 第三节补充：HashMap 底层原理（简要）
        // =============================================

        System.out.println("\n=== HashMap 底层原理 ===");

        /*
         * HashMap 底层结构：数组 + 链表 + 红黑树（JDK 8+）
         *
         * 存取过程：
         * 1. 调用 key 的 hashCode() 方法，得到一个哈希值
         * 2. 用哈希值对数组长度取模，确定放在哪个"桶"（bucket）里
         * 3. 如果桶里没有元素，直接放入
         * 4. 如果桶里已有元素（哈希冲突），用链表存储
         * 5. 当链表长度超过 8 时，自动转为红黑树（查找更快）
         *
         * 时间复杂度：
         * - put / get：平均 O(1)，最坏 O(log n)（红黑树）
         * - 前提：hashCode() 实现得足够好，冲突少
         *
         * 为什么 HashMap 的 key 要重写 hashCode() 和 equals()？
         * - hashCode() 决定放在哪个桶
         * - equals() 决定桶内是否是同一个 key
         * - 两个方法配合才能正确判断 key 是否重复
         */

        // 演示：两个字符串 hashCode 相同 → 放在同一个桶
        String key1 = "Aa";
        String key2 = "BB";
        System.out.println("\"Aa\".hashCode() = " + key1.hashCode());
        System.out.println("\"BB\".hashCode() = " + key2.hashCode());
        System.out.println("hashCode 相同？" + (key1.hashCode() == key2.hashCode()));
        System.out.println("equals？" + key1.equals(key2));
        System.out.println("-> hashCode 相同但 equals 不同，两个都能存入 HashMap");

        // 演示：key 重复时覆盖旧值
        Map<String, Integer> map = new HashMap<>();
        map.put("小明", 80);
        System.out.println("第一次 put：小明 = " + map.get("小明"));
        map.put("小明", 95);  // key 相同，覆盖旧值
        System.out.println("第二次 put：小明 = " + map.get("小明"));
        System.out.println("-> key 重复时，新值会覆盖旧值");

        // =============================================
        // 第四节：HashSet
        // =============================================

        System.out.println("\n=== HashSet ===");

        Set<String> names = new HashSet<>();
        names.add("小明");
        names.add("小红");
        names.add("小刚");
        names.add("小明");  // 重复，不会添加

        System.out.println("集合：" + names);
        System.out.println("大小：" + names.size());
        System.out.println("包含小明：" + names.contains("小明"));

        // =============================================
        // 第四节补充：HashSet 去重原理
        // =============================================

        System.out.println("\n=== HashSet 去重原理 ===");

        /*
         * HashSet 底层其实就是一个 HashMap！
         * - 每个元素作为 HashMap 的 key
         * - value 统一用一个固定的占位对象
         *
         * 去重判断流程：
         * 1. 先调用元素的 hashCode()，定位到哪个桶
         * 2. 再用 equals() 和桶里的元素逐个比较
         * 3. 如果 hashCode 相同 且 equals 返回 true → 认为是重复元素，不添加
         *
         * 重要推论：
         * - 如果你把自定义对象放入 HashSet，必须重写 hashCode() 和 equals()
         * - 否则每个对象都是"不同的"（用的是 Object 默认的地址比较）
         */

        // 演示：不重写 hashCode/equals 的后果
        System.out.println("未重写 hashCode/equals：");
        Set<NoOverridePoint> points1 = new HashSet<>();
        points1.add(new NoOverridePoint(1, 2));
        points1.add(new NoOverridePoint(1, 2));  // 逻辑上重复，但不会去重
        System.out.println("  大小：" + points1.size() + "（应该是 1，实际是 2）");

        // 演示：重写 hashCode/equals 后
        System.out.println("重写 hashCode/equals：");
        Set<Point> points2 = new HashSet<>();
        points2.add(new Point(1, 2));
        points2.add(new Point(1, 2));  // 这次能正确去重
        System.out.println("  大小：" + points2.size() + "（正确去重为 1）");

        // =============================================
        // 第五节：Collections 工具类
        // =============================================

        System.out.println("\n=== Collections 工具类 ===");

        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 1, 4, 2));

        // 排序
        Collections.sort(numbers);
        System.out.println("排序后：" + numbers);

        // 反转
        Collections.reverse(numbers);
        System.out.println("反转后：" + numbers);

        // 最大值最小值
        System.out.println("最大值：" + Collections.max(numbers));
        System.out.println("最小值：" + Collections.min(numbers));

        // =============================================
        // 第六节：遍历方式
        // =============================================

        System.out.println("\n=== 遍历方式 ===");

        List<String> cities = Arrays.asList("北京", "上海", "广州", "深圳");

        // 方式1：for-each
        System.out.println("for-each：");
        for (String city : cities) {
            System.out.println("  " + city);
        }

        // 方式2：索引遍历
        System.out.println("索引遍历：");
        for (int i = 0; i < cities.size(); i++) {
            System.out.println("  " + i + ": " + cities.get(i));
        }

        // 方式3：迭代器
        System.out.println("迭代器：");
        Iterator<String> it = cities.iterator();
        while (it.hasNext()) {
            System.out.println("  " + it.next());
        }

        // 方式4：Lambda（Java 8+）
        System.out.println("Lambda：");
        cities.forEach(city -> System.out.println("  " + city));

        // =============================================
        // 第七节：TreeMap / TreeSet（有序集合）
        // =============================================

        System.out.println("\n=== TreeMap / TreeSet ===");

        /*
         * TreeMap - 按 key 自动排序的 Map
         *   - 底层是红黑树
         *   - 遍历时 key 按自然顺序（字母/数字）排列
         *   - 不能存 null 作为 key
         *
         * TreeSet - 按元素自动排序的 Set
         *   - 底层也是红黑树
         *   - 自动去重 + 自动排序
         *   - 不能存 null 元素
         */

        // TreeMap 示例
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("banana", 3);
        treeMap.put("apple", 1);
        treeMap.put("cherry", 2);

        System.out.println("TreeMap 遍历（按 key 排序）：");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " = " + entry.getValue());
        }
        // 输出顺序：apple -> banana -> cherry（按字母排序）

        // TreeMap 常用方法
        System.out.println("第一个 key：" + treeMap.firstKey());
        System.out.println("最后一个 key：" + treeMap.lastKey());

        // TreeSet 示例
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("banana");
        treeSet.add("apple");
        treeSet.add("cherry");
        treeSet.add("apple");  // 重复，不会添加

        System.out.println("TreeSet（去重+排序）：" + treeSet);
        System.out.println("第一个：" + treeSet.first());
        System.out.println("最后一个：" + treeSet.last());

        // TreeSet 自然排序：数字按大小排
        TreeSet<Integer> numberSet = new TreeSet<>(Arrays.asList(5, 3, 1, 4, 2, 2));
        System.out.println("数字 TreeSet：" + numberSet);

        // =============================================
        // 第八节：Queue / Deque（队列 / 双端队列）
        // =============================================

        System.out.println("\n=== Queue / Deque ===");

        /*
         * Queue（队列）- 先进先出（FIFO）
         *   - offer() 入队，poll() 出队，peek() 查看队首
         *   - 常用实现：LinkedList、ArrayDeque
         *   - 应用场景：任务排队、消息队列、BFS 广度优先搜索
         *
         * Deque（双端队列）- 两头都能进出
         *   - offerFirst() / offerLast() 从头/尾入队
         *   - pollFirst() / pollLast() 从头/尾出队
         *   - 常用实现：ArrayDeque（比 LinkedList 更快）
         *   - 也可以当栈用：push() 入栈，pop() 出栈
         */

        // Queue 示例：任务排队
        Queue<String> taskQueue = new LinkedList<>();
        taskQueue.offer("任务A");  // 入队
        taskQueue.offer("任务B");
        taskQueue.offer("任务C");
        System.out.println("任务队列：" + taskQueue);

        String first = taskQueue.poll();  // 出队（取出并移除队首）
        System.out.println("执行：" + first);
        System.out.println("剩余队列：" + taskQueue);

        String next = taskQueue.peek();  // 查看队首（不移除）
        System.out.println("下一个待执行：" + next);

        // Deque 示例：双端队列
        Deque<String> deque = new ArrayDeque<>();
        deque.offerLast("尾部1");   // 从尾部入队
        deque.offerLast("尾部2");
        deque.offerFirst("头部1");  // 从头部入队
        System.out.println("双端队列：" + deque);

        String head = deque.pollFirst();  // 从头部出队
        String tail = deque.pollLast();   // 从尾部出队
        System.out.println("头部出队：" + head);
        System.out.println("尾部出队：" + tail);
        System.out.println("剩余：" + deque);

        // Deque 当栈用（后进先出 LIFO）
        Deque<String> stack = new ArrayDeque<>();
        stack.push("底部");
        stack.push("中间");
        stack.push("顶部");
        System.out.println("当栈用：" + stack);
        System.out.println("弹出：" + stack.pop());    // 顶部（后进先出）
        System.out.println("查看：" + stack.peek());    // 中间

        // =============================================
        // 第九节：自定义排序（Comparator）
        // =============================================

        System.out.println("\n=== 自定义排序 ===");

        /*
         * 排序方式：
         * 1. Collections.sort(list)          - 自然排序（元素实现 Comparable）
         * 2. Collections.sort(list, comp)    - 自定义比较器
         * 3. list.sort(comp)                 - List 自带的 sort 方法
         *
         * Comparator 常用方法：
         * - Comparator.comparing(key)        - 按某个字段排序
         * - .reversed()                      - 反转排序
         * - .thenComparing(key)              - 第二排序条件
         *
         * Lambda 写法：
         * - (a, b) -> a - b       升序
         * - (a, b) -> b - a       降序
         * - Comparator.comparing(x -> x.getField())  按字段排序
         */

        // 准备测试数据
        List<Student2> studentList = new ArrayList<>();
        studentList.add(new Student2("小明", 85));
        studentList.add(new Student2("小红", 92));
        studentList.add(new Student2("小刚", 78));
        studentList.add(new Student2("小丽", 92));

        // 方式1：Lambda 按成绩升序
        studentList.sort((a, b) -> a.score - b.score);
        System.out.println("按成绩升序：");
        for (Student2 s : studentList) {
            System.out.println("  " + s.name + "：" + s.score);
        }

        // 方式2：Lambda 按成绩降序
        studentList.sort((a, b) -> b.score - a.score);
        System.out.println("按成绩降序：");
        for (Student2 s : studentList) {
            System.out.println("  " + s.name + "：" + s.score);
        }

        // 方式3：Comparator.comparing（推荐写法，更清晰）
        studentList.sort(Comparator.comparingInt(Student2::getScore).reversed());
        System.out.println("Comparator.comparing 降序：");
        for (Student2 s : studentList) {
            System.out.println("  " + s.name + "：" + s.score);
        }

        // 方式4：多条件排序（先按成绩降序，成绩相同按名字升序）
        studentList.sort(Comparator
                .comparingInt(Student2::getScore).reversed()  // 成绩降序
                .thenComparing(Student2::getName));            // 名字升序
        System.out.println("多条件排序（成绩降序 + 名字升序）：");
        for (Student2 s : studentList) {
            System.out.println("  " + s.name + "：" + s.score);
        }

        // =============================================
        // 第十节：不可变集合（Java 9+）
        // =============================================

        System.out.println("\n=== 不可变集合 ===");

        /*
         * 不可变集合 = 创建后不能修改（不能 add / remove / set）
         * 优点：
         * - 线程安全（多线程随便读）
         * - 防止意外修改（方法参数传进去不怕被改）
         * - 适合作为常量配置
         *
         * 创建方式（Java 9+）：
         * - List.of(...)      不可变 List
         * - Set.of(...)       不可变 Set
         * - Map.of(...)       不可变 Map
         * - Map.ofEntries(...) 不可变 Map（更多键值对时用）
         */

        // 不可变 List
        List<String> immutableList = List.of("苹果", "香蕉", "橘子");
        System.out.println("不可变 List：" + immutableList);
        // immutableList.add("芒果");     // 抛出 UnsupportedOperationException
        // immutableList.remove(0);       // 抛出 UnsupportedOperationException
        System.out.println("不可变 List 不能 add/remove，只读");

        // 不可变 Set
        Set<String> immutableSet = Set.of("北京", "上海", "广州");
        System.out.println("不可变 Set：" + immutableSet);

        // 不可变 Map（最多 10 个键值对用 Map.of）
        Map<String, Integer> immutableMap = Map.of(
                "苹果", 5,
                "香蕉", 3,
                "橘子", 8
        );
        System.out.println("不可变 Map：" + immutableMap);

        // 不可变 Map（超过 10 个键值对用 Map.ofEntries）
        Map<String, Integer> bigMap = Map.ofEntries(
                Map.entry("语文", 90),
                Map.entry("数学", 85),
                Map.entry("英语", 92),
                Map.entry("物理", 78),
                Map.entry("化学", 88)
        );
        System.out.println("Map.ofEntries：" + bigMap);

        // 从已有集合创建不可变副本
        List<String> mutableList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> copy = List.copyOf(mutableList);  // Java 10+
        System.out.println("List.copyOf 副本：" + copy);

        // =============================================
        // 【练习题】
        // =============================================

        System.out.println("\n==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：成绩管理
        System.out.println("--- 练习1 参考 ---");
        Map<String, Integer> studentScores = new HashMap<>();
        studentScores.put("小明", 85);
        studentScores.put("小红", 92);
        studentScores.put("小刚", 78);
        studentScores.put("小丽", 95);

        // 找最高分
        String topStudent = "";
        int maxScore = 0;
        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                topStudent = entry.getKey();
            }
        }
        System.out.println("最高分学生：" + topStudent + "（" + maxScore + "分）");

        // 练习2：去重
        System.out.println("\n--- 练习2 参考 ---");
        List<Integer> list2 = Arrays.asList(1, 2, 3, 2, 1, 4, 5, 4);
        Set<Integer> unique = new LinkedHashSet<>(list2);
        System.out.println("原列表：" + list2);
        System.out.println("去重后：" + unique);

        // 练习3：词频统计
        System.out.println("\n--- 练习3 参考 ---");
        String text = "hello java hello world java hello";
        String[] words = text.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println("词频：" + wordCount);

        // 练习4：排序
        System.out.println("\n--- 练习4 参考 ---");
        List<Student2> students = new ArrayList<>();
        students.add(new Student2("小明", 85));
        students.add(new Student2("小红", 92));
        students.add(new Student2("小刚", 78));

        students.sort((a, b) -> b.score - a.score);
        System.out.println("按成绩降序：");
        for (Student2 s : students) {
            System.out.println("  " + s.name + "：" + s.score);
        }

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - ArrayList 动态数组，随机访问 O(1)
         * - LinkedList 双向链表，头部插入 O(1)
         * - HashMap 键值对，底层 数组+链表+红黑树，查找 O(1)
         * - HashSet 自动去重，靠 hashCode() + equals()
         * - TreeMap/TreeSet 自动排序，底层红黑树
         * - Queue 先进先出，Deque 双端队列
         * - Collections 工具类 + Comparator 自定义排序
         * - 不可变集合（List.of / Set.of / Map.of）线程安全
         *
         * 集合选型速查：
         * - 要键值对？→ HashMap
         * - 要自动去重？→ HashSet
         * - 要排序？→ TreeMap / TreeSet
         * - 要有序列表？→ ArrayList
         * - 要频繁头部操作？→ LinkedList
         * - 要队列？→ ArrayDeque
         * - 要不可变？→ List.of / Set.of / Map.of
         *
         * 常见陷阱：
         * - ArrayList 的 remove(index) 和 remove(object) 混淆
         * - HashMap 的 key 重复时会覆盖旧值
         * - 遍历时删除元素要用 Iterator，否则抛异常
         * - HashSet 存自定义对象必须重写 hashCode() 和 equals()
         * - 不可变集合不能 add/remove/set，会抛 UnsupportedOperationException
         *
         * 下节课预告：
         * - 学习泛型与接口，实现更灵活的代码抽象
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 11 课：集合框架！");
        System.out.println("下节课我们将学习泛型与接口。");
    }
}

class Student2 {
    String name;
    int score;

    Student2(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // getter 方法，供 Comparator.comparing 使用
    String getName() { return name; }
    int getScore() { return score; }
}

// 未重写 hashCode/equals 的类（用于演示 HashSet 去重失败）
class NoOverridePoint {
    int x, y;
    NoOverridePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // 没有重写 hashCode() 和 equals()
    // 每个对象用的是 Object 的默认实现（比较地址），所以不会去重
}

// 重写了 hashCode/equals 的类（用于演示 HashSet 正确去重）
class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);  // 用 Objects 工具类生成 hashCode
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;            // 同一个对象
        if (obj == null || getClass() != obj.getClass()) return false;  // 类型不同
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;  // 字段相同
    }
}
