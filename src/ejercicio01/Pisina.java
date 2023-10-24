package ejercicio01;

import java.util.concurrent.Semaphore;

public class Pisina {
    private int capacidad;
    private Semaphore ingreso, permiso;

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void ingresarPisina() {
        try {
            this.permiso.acquire();
            this.ingreso.acquire();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void analizarCapacidad() {
        try {
            this.permiso.acquire();
            if (capacidad > 0) {
                capacidad--;
                this.ingreso.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void salirPisina() {
    }

    public Pisina(int capacidad) {
        this.capacidad = capacidad;
        this.ingreso = new Semaphore(this.capacidad);
        this.permiso = new Semaphore(1);
    }
}
