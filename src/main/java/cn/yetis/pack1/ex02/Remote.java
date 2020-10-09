package cn.yetis.pack1.ex02;

import lombok.Data;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 远程控制狗门的遥控器
 *
 * @author fyyang
 * @since 2020-10-4
 */
@Data
public class Remote {

    private DogDoor dogDoor;

    public Remote(DogDoor dogDoor) {
        this.dogDoor = dogDoor;
    }

    public void pressButton() {
        System.out.println("Pressing the remote control button...");
        if (dogDoor.isOpen()) {
            dogDoor.close();
        } else {
            dogDoor.open();
            final Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    dogDoor.close();
                    timer.cancel();
                }
            }, 5000);

            /*//org.apache.commons.lang3.concurrent.BasicThreadFactory
            ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
                    new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    //do something
                    System.out.println("**");
                }
            }, 5000, 3000, TimeUnit.MILLISECONDS);*/

        }
    }
}
