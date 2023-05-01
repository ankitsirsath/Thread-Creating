PROBLEM:
Write a Java Program for Thread Creating and use of its various methods.
CODE:
1.MyThread.Java
package Threads;
class MyThread extends Thread {
 public MyThread(String name) {
 super(name);
 }
 public void run() {
 // print thread start message
 System.out.println(getName() + " starting.");
 // loop until interrupted
 while (!isInterrupted()) {
 try {
 Thread.sleep(500);
 } catch (InterruptedException e) {
 // print interrupt message and exit loop
 System.out.println(getName() + " interrupted.");
 interrupt();
 }
 // print loop message
 System.out.println(getName() + " looping.");
 }
 // print thread end message
 System.out.println(getName() + " exiting.");
 }
}
2.Thread.Java
package Threads;
public class ThreadDemo {
 public static void main(String[] args) {
 // create two threads
 Thread t1 = new MyThread("Thread 1");
 Thread t2 = new MyThread("Thread 2");
 // start the threads
 t1.start();
 t2.start();
 // sleep for 3 seconds
 try {
 Thread.sleep(3000);
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 // interrupt both threads
 t1.interrupt();
 t2.interrupt();
 // wait for both threads to finish
 try {
 t1.join();
 t2.join();
 } catch (InterruptedException e) {
 e.printStackTrace();
 }
 // print the end message
 System.out.println("Main thread exiting.");
 }
}
