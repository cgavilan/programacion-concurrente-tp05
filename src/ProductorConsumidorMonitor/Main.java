package ProductorConsumidorMonitor;

public class Main {
    public static void main(String[] args) {
        int maxProductos = 4;
        Buffer buffer = new Buffer(maxProductos);
        Productor productor = new Productor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        Thread tproductor = new Thread(productor, "Productor");
        tproductor.start();
        Thread tconsumidor = new Thread(consumidor, "Consumidor");
        tconsumidor.start();

    }
}
