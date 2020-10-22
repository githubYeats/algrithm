package cn.yetis.datastructure.queue;

/**
 * “队列”的数组实现,队列有两个最基本的原则：
 * 1）只能从队列尾端添加数据，只能从队列最前端查看数据；
 * 2）遵循先进先出原则（FIFO）。
 * <p>
 * 队列的基本运算有5个：
 * 1.Create 建立空队列
 * 2.Add	将新数据加入队列的尾端，并返回新队列
 * 3.Delete	删除队列最前端的数据，返回新队列
 * 4.Front	取出队列最前端的数据
 * 5.Empty	若队列为空，返回true；否则，返回false
 *
 * @author fyyang
 * @since 2020-10-22
 */
public class QueueByArray {
    /**
     * 队列，用于存放数据
     */
    private final Object[] queue;

    /**
     * 队列的大小
     */
    private int size;

    /**
     * 索引：指向队列最前端
     */
    private int front;

    /**
     * 索引：指向队列尾端
     */
    private int rear;

    /**
     * 构造器
     *
     * @param initialCapacity 队列初始大小
     */
    public QueueByArray(int initialCapacity) {
        this.queue = new Object[initialCapacity];
        this.front = -1;
        this.rear = -1;
    }

    /**
     * 获取队列大小，即存放的元素个数
     *
     * @return 队列大小
     */
    public int size() {
        return size;
    }

    /**
     * 判断队列是否为空
     *
     * @return 队列为空，返回true；否则，返回false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向队列尾端添加一个数据
     *
     * @param data 需要添加的数据
     */
    public void add(Object data) {
        if (this.isEmpty()) {
            front = 0;
            rear = 0;
            // 数组下标从0开始
            queue[rear] = data;
        } else {
            queue[++rear] = data;
        }
        size++;
    }

    /**
     * 从队列最前端删除一个数据
     */
    public void delete() {
        if (this.isEmpty()) {
            System.out.println("This queue is empty.");
            return;
        }
//        for (int i = front; i <= rear - 1; i++) {
//            queue[i] = queue[i + 1];
//        }
        if (rear - front >= 0) {
            System.arraycopy(queue, front + 1, queue, front, rear - front);
        }
        size--;
        rear--;
    }

    /**
     * 返回队列最前端的数据
     *
     * @return 返回的数据对象
     */
    public Object front() {
        return queue[front];
    }

    /**
     * 输出队列中的所有数据
     */
    public void print() {
        if (this.isEmpty()) {
            System.out.println("This queue is empty.");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueByArray queue = new QueueByArray(20);
        System.out.println(queue.front);
        System.out.println(queue.rear);
        System.out.println(queue.size);
        queue.print();

        System.out.println("===========");
        queue.add(123);
        queue.add("hello");
        queue.add(new Object());
        queue.add(123123);
        queue.add("hello world");
        queue.add(new Object());
        System.out.println(queue.front);
        System.out.println(queue.rear);
        System.out.println(queue.size);
        System.out.println(queue.front());
        queue.print();

        System.out.println("===========");
        queue.delete();
        queue.delete();
        System.out.println(queue.front);
        System.out.println(queue.rear);
        System.out.println(queue.size);
        System.out.println(queue.front());
        queue.print();
    }
}

