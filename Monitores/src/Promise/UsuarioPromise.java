package src.Promise;

import src.Promise.Promise;
import src.Promise.ThreadPromise;

public class UsuarioPromise extends Thread{

    private int id;
    private int a;
    private int b;

    public UsuarioPromise(int id, int a, int b){
        this.id = id;
        this.a = a;
        this.b = b;
    }

    Future asynch(){
        Promise promise = new Promise();
        ThreadPromise thread = new ThreadPromise(promise, this.a, this.b);
        thread.start();
        return promise;
    }

    public void run(){
        Object result;
        try {
            Future promise = this.asynch();
            result = promise.get();
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("id: "+ this.id + " resultado: " + result);
    }

}
