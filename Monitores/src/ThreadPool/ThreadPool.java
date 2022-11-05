package src.ThreadPool;

import src.Buffer.Buffer;

public class ThreadPool {

    private int tasks;
    private int workers;

    private int working = 0;

    private Buffer buffer;

    public ThreadPool(int capacidad, int workers, int tasks){
        this.buffer = new Buffer(capacidad);
        this.tasks = tasks;
        this.workers = workers;
        for(int i = 0; i<workers; i++){
            ThreadWorker worker = new ThreadWorker(this.buffer);
            worker.start();
        }
    }

    public synchronized void beginWork() throws InterruptedException {
        while(this.working == this.workers){
            wait();
        }
        working++;
    }

    public synchronized void finishWork(){
        working--;
        notify();
    }

    public synchronized void launch(){
        DummyTask task = new DummyTask();
        this.buffer.write(task);
    }

    public synchronized void stop() throws InterruptedException {
        PoisonPill poison = new PoisonPill();
        while(!(tasks == 0)){
            wait();
        }
        for(int i = 0; i < this.workers; i++){
            this.buffer.write(poison);
        }
    }
}
