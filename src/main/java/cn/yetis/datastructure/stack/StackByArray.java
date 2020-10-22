package cn.yetis.datastructure.stack;

/**
 * 自定义实现“栈stack”————用数组实现
 * 实现stack的常用方法：
 * 1.create	创建一个空stack
 * 2.push	存放数据到stack顶端，并更新stack
 * 3.pop	从stack的顶端取数据，并更新stack
 * 4.empty	判断stack是否为空，空则返回true
 * 5.full	判断stack是否已满，已满则返回true
 *
 * @author fyyang
 * @since 2020-10-22
 */
public class StackByArray {

    private Object[] stack;

    /**
     * stack的大小
     */
    private int size;

    /**
     * 指向stack顶端的索引
     */
    private int top;

    /**
     * 构造器
     *
     * @param initialCapacity 初始时设置的stack大小
     */
    public StackByArray(int initialCapacity) {
        // 建立数组，作为stack
        this.stack = new Object[initialCapacity];
        // 初始化时，stack没有数据，top索引设为-1
        this.top = -1;
    }

    /**
     * 返回stack的存储数据的个数——stack的大小
     *
     * @return 栈大小
     */
    public int size() {
        return size;
    }

    /**
     * 存放数据到stack顶端，并更新stack
     *
     * @param data 需要被存入的数据
     * @return true 存储数据成功
     */
    public boolean push(Object data) {
        if (top >= stack.length) {
            System.out.println("stack已满，无法再存入数据！");
            return false;
        } else {
            stack[++top] = data;
            size++;
            return true;
        }
    }

    /**
     * 从stack的顶端取数据，并更新的stack
     *
     * @return 数据对象
     */
    public Object pop() {
        if (isEmpty()) {
            System.out.println("stack为空，无数据可取！");
        }
        return stack[top--];
    }

    /**
     * 判断stack是否为空，空则返回true
     *
     * @return true stack为空
     */
    public boolean isEmpty() {
        if (top == -1) {
            System.out.println("stack为空");
            return true;
        } else {
            System.out.println("stack不为空");
            return false;
        }
    }

    /**
     * 判断一个Stack是否已满，若已满，返回true；否则，返回false。
     *
     * @return true 空；false 非空
     */
    public boolean isFull() {
        if (top >= stack.length) {
            System.out.println("stack已满！");
            return true;
        } else {
            System.out.println("stack未满！");
            return false;
        }
    }
}
