package HomeWork3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private final ReentrantLock locker;
    CountDownLatch cdl;
    CountDownLatch finish;


    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch cdl, CountDownLatch finish, ReentrantLock locker) {
        this.race = race;
        this.speed = speed;
        this.cdl = cdl;
        this.finish = finish;
        this.locker = locker;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            cdl.countDown();
            System.out.println(this.name + " готов");
            cdl.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        finish.countDown();

        if(locker.tryLock()) {
            System.out.println(this.name + " - WIN");
        }
    }
}
