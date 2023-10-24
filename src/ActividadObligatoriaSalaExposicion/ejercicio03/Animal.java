package ActividadObligatoriaSalaExposicion.ejercicio03;

import java.util.Random;

public class Animal implements Runnable {
    Random rnd = new Random();
    String tipo;
    String name;
    Comedor comedor;

    @Override
    public void run() {
        try {
            // entrar a comer
            this.comedor.entrarAComer(this.tipo);
            System.out.println(this.name + " esta comiendo");
            Thread.sleep(300 * (rnd.nextInt(20) + 1));
            // salir de comedor
            this.comedor.salirDeComedor(this.tipo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Animal(String tipo, String name, Comedor comedor) {
        this.tipo = tipo;
        this.name = name;
        this.comedor = comedor;
    }

}
