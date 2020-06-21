package cn.yetis.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 继承 RecursiveTask 来创建可以用于"分支/合并"框架的任务
 *
 * @author fyyang
 * @since 2020-6-21
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    public static void main(String[] args) {
        long n = 10000000;
        long startTime = System.currentTimeMillis();
        long forkJoinSum = forkJoinSum(n);
        long endTime = System.currentTimeMillis();
        System.out.println("sum = " + forkJoinSum + ", 1~" + n + "求和计算共耗时" + (endTime - startTime) + "ms");

    }

    /**
     * 主任务待求和的数组
     */
    private final long[] numbers;

    /**
     * 子任务处理的数组的起始位置
     */
    private final int start;
    private final int end;

    /**
     * 不再将任务分解为子任务的数组大小。
     */
    public static final long THRESHOLD = 10_000;

    /**
     * 公共构造函数用于创建主任务
     *
     * @param numbers 主任务待求和的数组
     */
    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    /**
     * 私有构造函数用于以递归方式为主任务创建子任务
     *
     * @param numbers 主任务求和的数组
     * @param start   子任务处理的数组部分的开始位置
     * @param end     子任务处理的数组部分的结束位置
     */
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }


    /**
     * 该任务负责求和的部分的大小
     *
     * @return 子任务求和结果
     */
    @Override
    protected Long compute() {
        // 如果子任务处理的数组长度小于或等于阈值，顺序计算结果
        int length = end - start;
        if (length <= THRESHOLD) {
            // 在子任务不再可分时计算结果的简单算法
            return computeSequentially();
        }

        // 创建一个子任务来为数组的前一半求和
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);

        // 利用另一个 ForkJoinPool 线程异步执行新创建的子任务
        leftTask.fork();

        // 创建一个任务为数组的后一半求和
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);

        // 同步执行第二个子任务，有可能允许进一步递归划分
        Long rightResult = rightTask.compute();

        // 读取第一个子任务的结果，如果尚未完成就等待
        Long leftResult = leftTask.join();

        // 该任务的结果是两个子任务结果的组合
        return leftResult + rightResult;
    }

    /**
     * 在子任务不再可分时计算结果的简单算法
     *
     * @return 计算结果
     */
    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            {
                sum += numbers[i];
            }
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        // 生成数组，连续整数数值
        long[] numbers = LongStream.rangeClosed(1, n).toArray();

        // 创建任务
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);

        // 任务交给线程池，进行计算，并返回结果
        return new ForkJoinPool().invoke(task);
    }
}

/*
    默认的无参数构造函数，这意味着想让线程池使用JVM能够使用的所有处理器。
    更确切地说，该构造函数将使用 Runtime.availableProcessors() 的返回值来决定线程池使用的线程数。

    请注意 availableProcessors() 方法虽然看起来是处理器，但它实际上返回的是可用内核的数量，包括超线程生成的虚拟内核。

    public ForkJoinPool() {
        this(Math.min(MAX_CAP, Runtime.getRuntime().availableProcessors()),
             defaultForkJoinWorkerThreadFactory, null, false);
    }
 */
