package org.example.interpretermode;

import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xianr
 * @date 2023-09-16
 * @Description TODO
 */
public class InterpreterPattern {
    private String[] citys = {"杭州", "绍兴"};
    private String[] local = {"老人", "学生"};
    private String[] card = {"市民卡", "交通卡"};
    private String[] global = {"孕妇", "儿童", "残疾人", "军人"};
    private String s1 = "本次乘车免费~";
    private String s2 = "请付费！";
    private Expression free;

    public String freeRide(String passenger) {
        return free.interpret(passenger)? s1: s2;
    }

    // write your code here
    public InterpreterPattern(){
        free = new OrExpression(
                new TerminalExpression(global),
                new AndExpression(new TerminalExpression(citys),
                                  new AndExpression(
                                      new TerminalExpression(local),
                                      new TerminalExpression(card)))
        );
    }

    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public  static void a() throws InterruptedException {
        lock1.lock();
        Thread.sleep(1000);
        b(2);
        lock1.unlock();
    }

    public  static void b(int i) throws InterruptedException {
        int a = 1;
        System.out.println(lock2.tryLock());

        System.out.println("b" + i);
        Thread.sleep(4000);
        System.out.println(i + "线程结束");
        lock2.unlock();

    }

    public static void main(String[] args) {
        // 创建(注意：通常我们使用匿名内部类的方式，创建和启动线程)
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    a();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    b(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable1);
//        Thread t3 = new Thread(runnable);
//        Thread t4 = new Thread(runnable);
        t1.start();

        t2.start();
//        t3.start();
//        t4.start();

        CopyOnWriteArrayList<Integer> objects = new CopyOnWriteArrayList<>();
        String text = "杭州, 老人, 交通卡";
        InterpreterPattern interpreterPattern = new InterpreterPattern();
        String s = interpreterPattern.freeRide(text);
        System.out.println(s);
    }
}
