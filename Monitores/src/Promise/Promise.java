package src.Promise;

public class Promise implements Future {

    Object result;

    public synchronized Object get() throws InterruptedException {
        while(result == null){
            wait();
        }
        return result;
    }

    public synchronized void set(Object o){
        result = o;
        notify();
    }
}
