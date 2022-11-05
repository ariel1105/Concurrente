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
            ThreadWorker worker = new ThreadWorker(this.buffer, this);
            worker.start();
        }
    }
    public synchronized void beginWork(){
        this.working++;
    }
    public synchronized void finishWork(){
        this.working--;
        this.tasks--;
        System.out.println("tasks: "+ this.tasks);
        notify();
    }
    public Boolean isDone(){
        return this.tasks == 0;
    }

    public Boolean idleExists(){
        return this.working < this.workers;
    }

    public synchronized void launch() throws InterruptedException {
        while(!idleExists()){
            wait();
        }
        DummyTask task = new DummyTask();
        this.buffer.write(task);
        notify();
    }

    public synchronized void stop() throws InterruptedException {
        PoisonPill poison = new PoisonPill();
        while(!(isDone())){
            wait();
        }
        for(int i = 0; i < this.workers; i++){
            this.buffer.write(poison);
            notify();
        }
    }
}
