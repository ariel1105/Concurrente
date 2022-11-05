package src.ThreadPool;

import src.Buffer.Buffer;

public class ThreadWorker extends Thread{

    private Buffer buffer;

    private ThreadPool threadPool;

    public ThreadWorker(Buffer buffer, ThreadPool threadPool){
        this.threadPool = threadPool;
        this.buffer = buffer;
    }

    public Buffer getBuffer() {
        return buffer;
    }

    public void run(){
        while (true){
            Runnable task = (Runnable) this.buffer.read();
            task.run();
        }
    }
}
