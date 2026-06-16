// =============================================
// 第 05 课：数组
// =============================================
// 上节课我们学了循环语句。
// 这节课我们要学习"数组"——存储多个值的容器。
//
// 生活类比：
//   数组就像一排储物柜——每个柜子有编号（从 0 开始），
//   你可以把东西放进某个柜子，也可以随时取出来。
//   所有柜子大小一样，只能放同一种东西。

class ArraysDemo {
    public static void main(String[] args) {
        // =============================================
        // 第一节：创建数组
        // =============================================

        // 【创建数组的两种方式】
        System.out.println("=== 创建数组 ===");

        // 方式1：先创建，后赋值
        int[] numbers1 = new int[5];  // 创建长度为5的数组
        numbers1[0] = 10;
        numbers1[1] = 20;
        numbers1[2] = 30;
        numbers1[3] = 40;
        numbers1[4] = 50;
        System.out.println("numbers1[0] = " + numbers1[0]);

        // 方式2：直接初始化
        int[] numbers2 = {10, 20, 30, 40, 50};
        System.out.println("numbers2[0] = " + numbers2[0]);

        // 获取数组长度
        System.out.println("数组长度：" + numbers2.length);

        // =============================================
        // 第二节：访问数组元素
        // =============================================

        System.out.println("\n=== 访问数组元素 ===");

        String[] fruits = {"苹果", "香蕉", "橘子", "葡萄"};
        System.out.println("水果列表：");
        for (int i = 0; i < fruits.length; i++) {
            System.out.println("  fruits[" + i + "] = " + fruits[i]);
        }

        // =============================================
        // 第三节：遍历数组
        // =============================================

        System.out.println("\n=== 遍历数组 ===");

        int[] scores = {85, 92, 78, 95, 88};

        // 方式1：普通 for 循环
        System.out.println("普通for循环：");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();

        // 方式2：增强 for 循环（for-each）
        System.out.println("增强for循环：");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();

        // =============================================
        // 第四节：数组常用操作
        // =============================================

        System.out.println("\n=== 数组常用操作 ===");

        int[] nums = {34, 67, 12, 89, 45, 23, 78};

        // 求和
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        System.out.println("总和：" + sum);

        // 求平均值
        double avg = (double) sum / nums.length;
        System.out.println("平均值：" + String.format("%.1f", avg));

        // 找最大值
        int max = nums[0];
        for (int n : nums) {
            if (n > max) {
                max = n;
            }
        }
        System.out.println("最大值：" + max);

        // 找最小值
        int min = nums[0];
        for (int n : nums) {
            if (n < min) {
                min = n;
            }
        }
        System.out.println("最小值：" + min);

        // =============================================
        // 第五节：二维数组
        // =============================================

        System.out.println("\n=== 二维数组 ===");

        // 创建二维数组
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // 遍历二维数组
        System.out.println("矩阵：");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // =============================================
        // 【练习题】
        // =============================================

        System.out.println("\n==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：成绩统计
        System.out.println("--- 练习1 参考 ---");
        int[] scores2 = {85, 92, 78, 95, 88, 76, 90};
        int total = 0;
        int maxScore = scores2[0];
        int minScore = scores2[0];
        for (int s : scores2) {
            total += s;
            if (s > maxScore) maxScore = s;
            if (s < minScore) minScore = s;
        }
        System.out.println("平均分：" + (double) total / scores2.length);
        System.out.println("最高分：" + maxScore);
        System.out.println("最低分：" + minScore);

        // 练习2：数组反转
        System.out.println("\n--- 练习2 参考 ---");
        int[] arr = {1, 2, 3, 4, 5};
        System.out.print("原数组：");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.print("反转后：");
        for (int n : arr) System.out.print(n + " ");
        System.out.println();

        // 练习3：冒泡排序
        System.out.println("\n--- 练习3 参考 ---");
        int[] bubbleArr = {64, 34, 25, 12, 22, 11, 90};
        System.out.print("排序前：");
        for (int n : bubbleArr) System.out.print(n + " ");
        System.out.println();
        for (int i = 0; i < bubbleArr.length - 1; i++) {
            for (int j = 0; j < bubbleArr.length - i - 1; j++) {
                if (bubbleArr[j] > bubbleArr[j + 1]) {
                    int temp = bubbleArr[j];
                    bubbleArr[j] = bubbleArr[j + 1];
                    bubbleArr[j + 1] = temp;
                }
            }
        }
        System.out.print("排序后：");
        for (int n : bubbleArr) System.out.print(n + " ");
        System.out.println();

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - 数组的两种创建方式：new 和直接初始化
         * - 索引从 0 开始，length 属性获取长度
         * - 普通 for 和增强 for-each 两种遍历方式
         *
         * 常见陷阱：
         * - 数组越界：索引 >= length 会抛异常
         * - 数组长度固定，创建后不能改变
         * - 数组变量只是引用，赋值是共享同一数组
         *
         * 下节课预告：
         * - 学习方法（函数），把代码封装成可复用的"积木"
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 05 课：数组！");
        System.out.println("下节课我们将学习方法。");
    }
}
