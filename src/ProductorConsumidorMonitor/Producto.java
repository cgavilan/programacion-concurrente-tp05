package ProductorConsumidorMonitor;

public class Producto {
    public int id;

    public Producto(int id) {
        this.id = id;
    }

    public String toString() {
        return String.format("Producto #%d", this.id);
    }
}
