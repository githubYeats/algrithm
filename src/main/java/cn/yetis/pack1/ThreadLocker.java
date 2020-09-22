package cn.yetis.pack1;

import com.sun.istack.internal.logging.Logger;
import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

import java.util.*;

/**
 * @author fyyang
 * @since 2020-9-13
 */
@Data
public class ThreadLocker {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                MyThread t = new MyThread(i);
                t.start();
            }
            List<String> taskList = ThreadLocker.listTask();
            if (ObjectUtils.isNotEmpty(taskList)) {
                for (String taskInfo : taskList) {
                    logger.info(taskInfo);
                }
            }
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            logger.info(e.getMessage());
        }
    }


    private static final Logger logger = Logger.getLogger(ThreadLocker.class);

    private static final Map<String, String> TASK_MAP = new HashMap<>();

    /**
     * 提交任务
     *
     * @param taskName 任务名称
     * @param status   任务状态
     * @return 发现重名提交失败 返回false 否则为true
     */
    public static boolean submitTask(String taskName, String status) {
        synchronized (TASK_MAP) {
            if (TASK_MAP.containsKey(taskName)) {
                return false;
            } else {
                TASK_MAP.put(taskName, status);
                return true;
            }
        }
    }

    /**
     * 更新任务状态
     *
     * @param taskName 任务名称
     * @param status   任务状态
     * @return 无指定任务返回false 否则更新状态后返回true
     */
    public static boolean updateTask(String taskName, String status) {
        synchronized (TASK_MAP) {
            if (TASK_MAP.containsKey(taskName)) {
                TASK_MAP.put(taskName, status);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 移除指定任务
     */
    public static void removeTask(String taskName) {
        synchronized (TASK_MAP) {
            TASK_MAP.remove(taskName);
        }
    }

    /**
     * 列出当前正在执行的任务
     */
    public static List<String> listTask() {
        synchronized (TASK_MAP) {
            if (ObjectUtils.isNotEmpty(TASK_MAP)) {
                Set<Map.Entry<String, String>> entrySet = TASK_MAP.entrySet();
                List<String> retVal = new LinkedList<>();
                for (Map.Entry<String, String> entry : entrySet) {
                    retVal.add(String.format("任务:%s, 状态:%s", entry.getKey(), entry.getValue()));
                }
                return retVal;
            } else {
                return null;
            }
        }
    }
}
