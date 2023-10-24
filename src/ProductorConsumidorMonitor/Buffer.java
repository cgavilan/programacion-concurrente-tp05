package ProductorConsumidorMonitor;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
    private List<Producto> productos;
    private int maxProductos;

    private synchronized void listBuffer() {
        String list = "BufferEmpty";
        for (int i = 0; i < productos.size(); i++) {
            if (i == 0) {
                list = productos.get(i).toString();
            } else {
                list += " - " + productos.get(i).toString();
            }
        }
        System.out.println(Colors.YELLOW + list);
    }

    public synchronized void agregarProducto(Producto prod) {
        while (productos.size() == maxProductos) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Colors.GREEN + Thread.currentThread().getName() + " coloca " + prod);
        this.productos.add(prod);
        listBuffer();
        this.notifyAll();
    }

    public synchronized void sacarProducto() {
        while (this.productos.isEmpty()) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(Colors.RED + Thread.currentThread().getName() + " extrae " + this.productos.remove(0));
        listBuffer();
        this.notifyAll();
    }

    public Buffer(int mp) {
        this.productos = new ArrayList<>();
        this.maxProductos = mp;
    }
}
