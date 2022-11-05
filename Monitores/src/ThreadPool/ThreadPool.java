package src.ThreadPool;

import src.Buffer.Buffer;

public class ThreadPool {

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

    public synchronized void launch() throws InterruptedException {
        DummyTask task = new DummyTask();
        this.buffer.write(task);
    }

    public synchronized void stop() throws RuntimeException {
        PoisonPill poison = new PoisonPill();
        for(int i = 0; i < this.workers; i++){
            this.buffer.write(poison);
        }
    }
}
