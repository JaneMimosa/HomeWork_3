package HomeWork2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchThreads {

    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        SynchThreads synchThreads = new SynchThreads();
        Thread thread1 = new Thread(() -> synchThreads.methodA());
        Thread thread2 = new Thread(() -> synchThreads.methodB());
        Thread thread3 = new Thread(() -> synchThreads.methodC());
        ExecutorService service = Executors.newFixedThreadPool(3);
        service.execute(thread1);
        service.execute(thread2);
        service.execute(thread3);
    }

    private void methodA() {
        try {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    while(currentLetter != 'A') {
                        wait();
                    }
                    System.out.print('A');
                    currentLetter = 'B';
                    notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void methodB() {
        try {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    while(currentLetter != 'B') {
                        wait();
                    }
                    System.out.print('B');
                    currentLetter = 'C';
                    notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void methodC() {
        try {
            synchronized (this) {
                for (int i = 0; i < 5; i++) {
                    while(currentLetter != 'C') {
                        wait();
                    }
                    System.out.print('C');
                    currentLetter = 'A';
                    notifyAll();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
