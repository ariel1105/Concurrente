package src.Buffer;

import src.Buffer.Buffer;

public class Productor extends Thread{

    private final Buffer buffer;

    public Productor(Buffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        int i = 1;
        while(true){
            buffer.write(i);
            i++;
        }
    }
}
