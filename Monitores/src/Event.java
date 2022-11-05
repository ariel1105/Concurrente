package src;

public class Event {

    int epoch = 0;

    public synchronized void publish(String publicacion){
        epoch++;
        notifyAll();
    }

    public synchronized void suscribe(){
        int current = epoch;
        while(current==epoch){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }


}
