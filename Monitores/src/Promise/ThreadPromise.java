package src.Promise;

import src.Promise.Promise;

public class ThreadPromise extends Thread{

    private Promise promise;
    private int a;
    private int b;

    public ThreadPromise(Promise promise, int a, int b){
        this.a = a;
        this.b = b;
        this.promise = promise;
    }

    public void run(){
        int result = a + b;
        this.promise.set(result);
    }
}
