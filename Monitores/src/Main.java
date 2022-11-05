package src;

import src.ThreadPool.ThreadPool;

public class Main {
    public static void main(String[] args) {

        /*
        Buffer buffer = new Buffer(2);
        Productor p = new Productor(buffer);
        Consumidor c = new Consumidor(buffer);

        p.start();
        c.start();
        */

        /*
        Barrera barrera = new Barrera();
        ThreadBarrera t1 = new ThreadBarrera(barrera, "a", 1);
        ThreadBarrera t2 = new ThreadBarrera(barrera, "b", 2);
        ThreadBarrera t3 = new ThreadBarrera(barrera, "c", 3);

        t1.start();
        t2.start();
        t3.start();
        */

        /*
        UsuarioPromise usuarioPromise1 = new UsuarioPromise(1, 2, 2);
        UsuarioPromise usuarioPromise2 = new UsuarioPromise(2, 10, 2);
        UsuarioPromise usuarioPromise3 = new UsuarioPromise(3, 40, 50);
        UsuarioPromise usuarioPromise4 = new UsuarioPromise(4, 5, 34);

        usuarioPromise1.start();
        usuarioPromise2.start();
        usuarioPromise3.start();
        usuarioPromise4.start();
        */

        class UserPool extends Thread{

            ThreadPool pool;
            public UserPool(ThreadPool pool){
                this.pool = pool;
            }
            public void run(){
                for(int i=0; i<20; i++){
                    try {
                        pool.launch();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                this.pool.stop();
            }
        }
        
        ThreadPool pool = new ThreadPool(5, 8, 20);
        UserPool user = new UserPool(pool);
        user.start();


    }
}
