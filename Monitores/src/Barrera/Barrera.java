package src.Barrera;

public class Barrera {

    int esperando = 0;
    public synchronized void esperar() throws InterruptedException {
        while(esperando <= 0){
            esperando++;
            try {
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        notify();
    }
}
