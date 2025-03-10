package org.example;

public class TestThread {


    public static Thread childThread() {
        Thread running = new Thread(() -> {
            while (true) {
                System.out.println("running");
            }
        });
        return running;
    }

    public static void main(String[] args) {
        System.out.println("start");
        Thread thread = childThread();
        thread.start();

        System.out.println("end");
    }
}
