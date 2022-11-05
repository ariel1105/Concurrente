package src.Barrera;

import src.Barrera.Barrera;

public class ThreadBarrera extends Thread {
    Barrera barrera;
    String letra;
    int numero;

    public ThreadBarrera(Barrera barrera, String letra, int numero){
        this.barrera = barrera;
        this.letra = letra;
        this.numero = numero;
    }

    public void run(){
        System.out.println(this.letra);
        try {
            this.barrera.esperar();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.numero);
    }
}


