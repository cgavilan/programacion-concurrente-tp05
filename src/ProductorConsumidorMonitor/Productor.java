package ProductorConsumidorMonitor;

import java.util.Random;

public class Productor implements Runnable {
    Buffer buffer;
    Random rnd = new Random();

    @Override
    public void run() {
        while (true) {
            try {
                Producto p = new Producto(rnd.nextInt(10));
                this.buffer.agregarProducto(p);
                Thread.sleep(500 * (rnd.nextInt(10) + 1));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }
}
