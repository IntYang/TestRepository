/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study0412;

/**
 *
 * @author Administrator
 */
public class ThreadB extends Thread {
//Field

    public boolean stop = false;
    public boolean work = true;

    @Override
    public void run() {
        while (!stop) {
            if (work) {
                System.out.println("ThreadB 작업 내용");
            } else {
//여기 작성하세요(1줄)
                Thread.yield();
            }
        }
        System.out.println("ThreadB 종료");
    }
}
