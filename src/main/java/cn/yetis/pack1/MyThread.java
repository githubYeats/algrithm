package cn.yetis.pack1;

import com.sun.istack.internal.logging.Logger;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author fyyang
 * @since 2020-9-13
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MyThread extends Thread {
    private static final Logger logger = Logger.getLogger(MyThread.class);

    private final long id;

    private String getTaskName() {
        return "lock_thread";
    }

    public MyThread(int id) {
        this.id = id;
        this.setName(this.getTaskName());
    }

    @Override
    public void run() {
        String taskName = this.getName();
        //上锁
        if (!ThreadLocker.submitTask(taskName, String.format("[id:%d][示例线程]", this.id))) {
            logger.info(String.format("[id:%s][加锁失败]", this.id));
            return;
        } else {
            logger.info(String.format("[id:%s][加锁成功]", this.id));
        }

        try {
            // 线程要做的事情
            for (int i = 0; i < 20; i++) {
                logger.info(String.format("[id:%s][print:%d]", this.id, i));
                Thread.sleep(1L);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        } finally {
            //解锁
            logger.info(String.format("[id:%s][销毁]", this.id));
            ThreadLocker.removeTask(taskName);
        }
    }

}
