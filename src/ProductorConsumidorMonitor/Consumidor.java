package ProductorConsumidorMonitor;

import java.util.Random;

public class Consumidor implements Runnable {
    Buffer buffer;
    Random rnd = new Random();

    @Override
    public void run() {
        while (true) {
            try {
                this.buffer.sacarProducto();
                Thread.sleep(500 * (rnd.nextInt(10) + 1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }
}
