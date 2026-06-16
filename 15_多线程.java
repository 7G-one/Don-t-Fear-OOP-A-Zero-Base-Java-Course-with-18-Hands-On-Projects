// =============================================
// 第 15 课：多线程
// =============================================
// 上节课我们学了 Lambda 与 Stream。
// 这节课我们要学习"多线程"——让程序同时做多件事。
//
// 生活类比：
//   多线程就像多个厨师同时做菜——
//   一个厨师炒菜，一个厨师煮汤，一个厨师蒸饭，
//   三个人同时干活，比一个人串行做快多了。
//   但要注意：共用一口锅（共享资源）时得排队（同步）！

class Multithreading {
    public static void main(String[] args) {
        // =============================================
        // 第一节：创建线程
        // =============================================

        System.out.println("=== 创建线程 ===");

        // 方式1：继承 Thread
        MyThread thread1 = new MyThread();
        thread1.start();

        // 方式2：实现 Runnable
        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();

        // 方式3：Lambda
        Thread thread3 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Lambda线程：" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();

        // 主线程
        for (int i = 1; i <= 3; i++) {
            System.out.println("主线程：" + i);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // =============================================
        // 第二节：线程同步
        // =============================================

        System.out.println("\n=== 线程同步 ===");

        // synchronized 关键字
        Counter2 counter = new Counter2();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("计数器：" + counter.getCount());

        // =============================================
        // 第三节：线程池
        // =============================================

        System.out.println("\n=== 线程池 ===");

        java.util.concurrent.ExecutorService executor =
            java.util.concurrent.Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("任务" + taskId + "由" +
                    Thread.currentThread().getName() + "执行");
            });
        }

        executor.shutdown();

        // =============================================
        // 第四节：volatile 关键字（保证可见性）
        // =============================================

        System.out.println("\n=== volatile 关键字 ===");

        // 问题背景：
        // 每个线程都有自己的一份"工作内存"（CPU 缓存），
        // 线程读变量时会把主内存的值拷贝到工作内存。
        // 如果一个线程改了变量，其他线程可能还在用旧的缓存值！
        //
        // volatile 的作用：
        // 被 volatile 修饰的变量，每次读写都直接操作主内存，
        // 保证一个线程修改后，其他线程"立即可见"。

        // 不加 volatile 的危险示例（可能死循环）：
        // private static boolean running = true;  // 不加 volatile

        // 加 volatile 的安全示例：
        VolatileDemo volatileDemo = new VolatileDemo();
        volatileDemo.start();

        // =============================================
        // 第五节：wait/notify（线程间通信）
        // =============================================

        System.out.println("\n=== wait/notify ===");

        // 生产者-消费者模型：
        // 生产者往"仓库"放数据，消费者从"仓库"取数据。
        // 如果仓库满了，生产者要等；如果仓库空了，消费者要等。
        // wait() —— 让当前线程释放锁并进入等待状态
        // notify() —— 唤醒一个正在等待的线程
        // notifyAll() —— 唤醒所有正在等待的线程
        //
        // 注意：wait/notify 必须在 synchronized 块内调用！
        // 因为它们操作的是"锁对象"的等待队列。

        // 容量为 5 的仓库
        java.util.LinkedList<Integer> warehouse = new java.util.LinkedList<>();
        int capacity = 5;

        // 生产者线程
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                synchronized (warehouse) {
                    // 仓库满了，生产者等待
                    while (warehouse.size() >= capacity) {
                        try {
                            warehouse.wait();  // 释放锁，进入等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 生产一个产品
                    warehouse.add(i);
                    System.out.println("生产者放入：" + i +
                        " | 仓库库存：" + warehouse.size());
                    warehouse.notify();  // 通知消费者
                }
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 消费者线程
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                synchronized (warehouse) {
                    // 仓库空了，消费者等待
                    while (warehouse.isEmpty()) {
                        try {
                            warehouse.wait();  // 释放锁，进入等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 消费一个产品
                    int product = warehouse.removeFirst();
                    System.out.println("消费者取出：" + product +
                        " | 仓库库存：" + warehouse.size());
                    warehouse.notify();  // 通知生产者
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // =============================================
        // 第六节：死锁演示
        // =============================================

        System.out.println("\n=== 死锁演示 ===");

        // 什么是死锁？
        // 两个线程各持有一把锁，同时又想获取对方的锁，
        // 谁也不肯放手 → 永远等下去 → 程序卡死。
        //
        // 死锁的四个必要条件（缺一不可）：
        // 1. 互斥：资源同一时刻只能被一个线程占用
        // 2. 占有并等待：线程持有资源的同时等待其他资源
        // 3. 不可抢占：线程持有的资源不能被强行夺走
        // 4. 循环等待：线程之间形成环形的等待关系
        //
        // 预防死锁的方法：
        // → 破坏条件3：用 tryLock() 尝试获取锁，获取不到就放弃
        // → 破坏条件4：所有线程按相同顺序获取锁

        // 先演示死锁（程序会卡住，所以只演示一小会儿）
        final Object lockA = new Object();
        final Object lockB = new Object();

        // 线程1：先锁A → 再锁B
        Thread deadlock1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("线程1：持有锁A，等待锁B...");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB) {
                    System.out.println("线程1：同时持有锁A和锁B");
                }
            }
        });

        // 线程2：先锁B → 再锁A（顺序相反！）
        Thread deadlock2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("线程2：持有锁B，等待锁A...");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockA) {
                    System.out.println("线程2：同时持有锁B和锁A");
                }
            }
        });

        deadlock1.start();
        deadlock2.start();

        // 等 1 秒看看是否死锁了
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 检测死锁状态
        if (deadlock1.getState() == Thread.State.BLOCKED &&
            deadlock2.getState() == Thread.State.BLOCKED) {
            System.out.println("检测到死锁！两个线程都在等待对方释放锁。");
            // 中断死锁线程
            deadlock1.interrupt();
            deadlock2.interrupt();
            System.out.println("已中断死锁线程。");
        }

        // =============================================
        // 第七节：Callable 和 Future（带返回值的线程任务）
        // =============================================

        System.out.println("\n=== Callable 和 Future ===");

        // Runnable 的 run() 没有返回值，也不能抛异常。
        // 如果我们需要线程执行完后返回一个结果，就要用 Callable。
        //
        // Callable<V> —— 类似 Runnable，但 call() 可以返回结果并抛异常
        // Future<V> —— 用来获取 Callable 的执行结果
        // FutureTask<V> —— 既是 Runnable 又是 Future，可以交给 Thread 执行

        // 方式1：用 FutureTask + Thread
        java.util.concurrent.Callable<Integer> task = () -> {
            System.out.println("Callable 任务开始计算...");
            Thread.sleep(300);  // 模拟耗时计算
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            System.out.println("Callable 任务计算完毕！");
            return sum;  // 返回计算结果
        };

        java.util.concurrent.FutureTask<Integer> futureTask =
            new java.util.concurrent.FutureTask<>(task);
        new Thread(futureTask).start();

        try {
            // get() 会阻塞当前线程，直到 Callable 执行完毕并返回结果
            int result = futureTask.get();
            System.out.println("Callable 返回结果：" + result);  // 5050
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 方式2：用线程池提交 Callable（更常用）
        java.util.concurrent.ExecutorService executor2 =
            java.util.concurrent.Executors.newFixedThreadPool(2);

        // submit() 返回 Future 对象
        java.util.concurrent.Future<String> future1 = executor2.submit(() -> {
            Thread.sleep(200);
            return "任务A的结果";
        });

        java.util.concurrent.Future<String> future2 = executor2.submit(() -> {
            Thread.sleep(100);
            return "任务B的结果";
        });

        try {
            // 分别获取两个任务的结果
            System.out.println("Future1：" + future1.get());  // 阻塞等待
            System.out.println("Future2：" + future2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor2.shutdown();

        // =============================================
        // 第八节：线程安全的集合
        // =============================================

        System.out.println("\n=== 线程安全的集合 ===");

        // 普通集合（ArrayList、HashMap）在多线程下不安全！
        // 多个线程同时读写可能导致数据丢失、死循环、甚至程序崩溃。
        //
        // 解决方案1：Collections.synchronizedXxx() —— 简单但性能差
        // 解决方案2：java.util.concurrent 包下的并发集合 —— 性能好

        // --- ConcurrentHashMap：线程安全的 HashMap ---
        // 内部使用"分段锁"（JDK8 后改为 CAS + synchronized），
        // 不同 key 可以同时写入，比 Hashtable 性能好得多。

        java.util.concurrent.ConcurrentHashMap<String, Integer> wordCount =
            new java.util.concurrent.ConcurrentHashMap<>();

        // 多线程并发统计词频
        String[] words = {"Java", "Python", "Java", "C++", "Python",
            "Java", "Go", "C++", "Python", "Java"};

        Thread[] countThreads = new Thread[words.length];
        for (int i = 0; i < words.length; i++) {
            final String word = words[i];
            countThreads[i] = new Thread(() -> {
                // computeIfAbsent：key 不存在就计算默认值并放入
                // 这里的 merge 是线程安全的：key 对应的值 +1
                wordCount.merge(word, 1, Integer::sum);
            });
            countThreads[i].start();
        }

        for (Thread t : countThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("词频统计：" + wordCount);

        // --- CopyOnWriteArrayList：线程安全的 List ---
        // 原理：每次写入时，复制一份新数组，写完后替换引用。
        // 适合"读多写少"的场景（比如事件监听器列表）。
        java.util.concurrent.CopyOnWriteArrayList<String> eventList =
            new java.util.concurrent.CopyOnWriteArrayList<>();

        // 多线程添加事件
        Thread[] eventThreads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            final int id = i;
            eventThreads[i] = new Thread(() -> {
                eventList.add("事件" + id);
            });
            eventThreads[i].start();
        }

        for (Thread t : eventThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("事件列表：" + eventList);

        // =============================================
        // 第九节：ReentrantLock（更灵活的锁）
        // =============================================

        System.out.println("\n=== ReentrantLock ===");

        // synchronized 的问题：
        // - 获取不到锁只能傻等（阻塞）
        // - 不能设置超时时间
        // - 不能尝试获取锁
        //
        // ReentrantLock 的优势：
        // - tryLock()：尝试获取锁，获取不到就返回 false（非阻塞）
        // - tryLock(timeout)：限时等待
        // - lockInterruptibly()：等待时可以被中断
        // - 可以实现公平锁（先来先得）
        //
        // 注意：必须在 finally 块中 unlock()，否则异常时锁不会释放！

        java.util.concurrent.locks.ReentrantLock reentrantLock =
            new java.util.concurrent.locks.ReentrantLock();
        int[] sharedCounter = {0};  // 用数组包装，方便在 Lambda 中修改

        // 用 ReentrantLock 保护共享资源
        Thread[] lockThreads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            lockThreads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    reentrantLock.lock();  // 获取锁
                    try {
                        sharedCounter[0]++;  // 临界区：安全地修改共享数据
                    } finally {
                        reentrantLock.unlock();  // 无论如何都要释放锁！
                    }
                }
            });
            lockThreads[i].start();
        }

        for (Thread t : lockThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ReentrantLock 计数器：" + sharedCounter[0]);  // 1000

        // tryLock 演示：尝试获取锁，获取不到就不等了
        System.out.println("\n--- tryLock 演示 ---");
        Thread tryLockDemo = new Thread(() -> {
            reentrantLock.lock();  // 先占住锁
            try {
                System.out.println("子线程持有锁，睡 2 秒...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
                System.out.println("子线程释放锁。");
            }
        });
        tryLockDemo.start();

        try {
            Thread.sleep(100);  // 确保子线程先拿到锁
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 主线程尝试获取锁，最多等 500 毫秒
        try {
            boolean gotLock = reentrantLock.tryLock(500,
                java.util.concurrent.TimeUnit.MILLISECONDS);
            if (gotLock) {
                System.out.println("主线程成功获取锁！");
                reentrantLock.unlock();
            } else {
                System.out.println("主线程 500ms 内没拿到锁，放弃等待。");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            tryLockDemo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // =============================================
        // 【练习题】
        // =============================================

        System.out.println("\n==========================================");
        System.out.println("练习参考答案");
        System.out.println("==========================================\n");

        // 练习1：并发计数
        System.out.println("--- 练习1 参考 ---");
        Counter2 counter2 = new Counter2();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    counter2.increment();
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("最终计数：" + counter2.getCount());

        // =============================================
        // 课程总结
        // =============================================
        /*
         * 核心收获：
         * - 三种创建线程的方式：Thread、Runnable、Lambda
         * - synchronized 关键字保证线程安全
         * - 线程池 ExecutorService 管理线程生命周期
         * - volatile 保证变量的可见性（每次读写都走主内存）
         * - wait/notify 实现线程间通信（生产者-消费者模型）
         * - 死锁的四个条件及预防方法（按顺序加锁、tryLock）
         * - Callable/Future 获取线程执行结果（比 Runnable 更强大）
         * - 并发集合：ConcurrentHashMap、CopyOnWriteArrayList
         * - ReentrantLock：比 synchronized 更灵活（tryLock、超时、中断）
         *
         * 常见陷阱：
         * - 直接调用 run() 不会启动新线程，必须调 start()
         * - 多线程访问共享变量不加同步会导致数据不一致
         * - 忘记调用 shutdown() 导致线程池不释放资源
         * - wait/notify 不在 synchronized 块内调用会抛异常
         * - ReentrantLock 忘记在 finally 中 unlock() 导致死锁
         * - volatile 只保证可见性，不保证原子性（i++ 仍不安全）
         *
         * 下节课预告：
         * - 学习开发实战，把所学知识组合起来做项目
         */

        // =============================================
        // 恭喜完成
        // =============================================
        System.out.println("\n恭喜你完成了第 15 课：多线程！");
        System.out.println("下节课我们将学习开发实战入门。");
    }
}

// =============================================
// 线程类
// =============================================

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread线程：" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Runnable线程：" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// 线程安全的计数器
class Counter2 {
    private int count = 0;

    synchronized void increment() {
        count++;
    }

    int getCount() {
        return count;
    }
}

// =============================================
// volatile 演示类
// =============================================

class VolatileDemo {
    // 不加 volatile：子线程可能看不到主线程的修改，一直循环
    // 加了 volatile：子线程能立即看到主线程的修改，正常退出
    private volatile boolean running = true;

    public void start() {
        // 子线程：不停地检查 running 的值
        Thread worker = new Thread(() -> {
            int count = 0;
            while (running) {
                count++;
                // 忙等待（实际项目中不应该这样，这里只是演示）
            }
            System.out.println("子线程检测到 running = false，退出循环。" +
                "（循环了约 " + count + " 次）");
        });
        worker.start();

        // 主线程：睡 200 毫秒后把 running 改为 false
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        running = false;  // 如果没有 volatile，子线程可能永远看不到这个修改！
        System.out.println("主线程已将 running 设为 false。");

        try {
            worker.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
