package ActividadObligatoriaSalaExposicion;

import java.util.Random;

public class Visitante implements Runnable {

    private String tipo;
    private Sala sala;
    private Random rnd = new Random();

    @Override
    public void run() {
        try {
            while (true) {
                switch (tipo) {
                    case "visitante":
                        sala.entraVisitante();
                        System.out.println(Colors.GREEN + Thread.currentThread().getName() + " ha ingresado a la sala");
                        Thread.sleep(500 * (rnd.nextInt(15) + 1));
                        sala.saleVisitante();
                        break;
                    case "responsable":
                        sala.entraResponsable();
                        System.out.println(Colors.YELLOW + Thread.currentThread().getName()
                                + " ha ingresado a la controlar la sala");
                        Thread.sleep(500 * (rnd.nextInt(15) + 1));
                        sala.saleResponsable();
                        break;
                    case "critico":
                        sala.entraCritico();
                        System.out.println(
                                Colors.RED + Thread.currentThread().getName()
                                        + " ha ingresado a criticar las obras de la sala");
                        Thread.sleep(500 * (rnd.nextInt(15) + 1));
                        sala.saleCritico();
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Visitante(String tipo, Sala sala) {
        this.tipo = tipo;
        this.sala = sala;
    }
}
