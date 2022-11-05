# Concurrente
Practica de monitores
Process Timer(int freq, Channel timerChannel, int min){
    List<Channel> registros = new ArrayList<Channel>();
    Channel chLista = new Channel()
    Thread(registros){
        while(true){
            Channel c = timerChannel.receive.ch;
            registros.add(c);
        }
    }
    while(true){
        ready.receive()
        while(true){
            sleep(freq)
            registros = chLista.receive()
            chLista.send(registros);
            registros.foreach(v -> v.send("tick"));    
        }
        
    }
}

Process Cell(List<Channel> vecinos, Channel c, Channel timerChannel, Boolean state){
    //registro
    Channel ch = new Channel();
        timerChannel.send(new Request(ch, "registro"))
    while(true){
        //esperar tick
        String s = ch.receive()
        if(s == "tick"){
            vecinos.foreach(v -> v.send(this.state))
            repeat(8){
                vivos += c.receive()
            }
        }
        mySTate.setState(mySTate+vivos)
    }
}

