package ActividadObligatoriaSalaExposicion;

public class Sala {
    private String nombre, lastVisitante, lastResponsable, lastCritico;
    private int visitantes, responsables, criticos;

    private void printStatus() {
        System.out.println(Colors.WHITE
                + String.format("En sala: %s hay %d visitantes, %d responsables, %d criticos",
                        this.nombre,
                        this.visitantes,
                        this.responsables,
                        this.criticos));
    }

    public synchronized void entraVisitante() {
        try {
            while (this.criticos != 0 || lastVisitante == Thread.currentThread().getName()) {
                this.wait();
            }
            this.visitantes++;
            lastVisitante = Thread.currentThread().getName();
            printStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void saleVisitante() {
        this.visitantes--;
        this.notifyAll();
    }

    public synchronized void entraResponsable() {
        try {
            while (this.responsables != 0 || this.criticos != 0
                    || lastResponsable == Thread.currentThread().getName()) {
                this.wait();
            }
            this.responsables++;
            lastResponsable = Thread.currentThread().getName();
            printStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void saleResponsable() {
        this.responsables--;
        this.notifyAll();
    }

    public synchronized void entraCritico() {
        try {
            while (this.visitantes != 0 || this.responsables != 0 || this.criticos != 0
                    || lastCritico == Thread.currentThread().getName()) {
                this.wait();
            }
            this.criticos++;
            lastCritico = Thread.currentThread().getName();
            printStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void saleCritico() {
        this.criticos--;
        this.notifyAll();
    }

    public Sala(String nombre) {
        this.nombre = nombre;
        this.visitantes = 0;
        this.responsables = 0;
        this.criticos = 0;
    }
}
