package ActividadObligatoriaSalaExposicion.ejercicio03;

public class Main {
    public static void main(String[] args) {
        int cantidadComedores = 4;
        int tasa = 4;
        int cantidadPerros = 5;
        int cantidadGatos = 3;

        Comedor comedor = new Comedor(cantidadComedores, tasa);

        Animal[] perros = new Animal[cantidadPerros];
        for (int i = 0; i < cantidadPerros; i++) {
            perros[i] = new Animal("Perro", "Perro" + i, comedor);
            Thread t = new Thread(perros[i]);
            t.start();
        }
        Animal[] gatos = new Animal[cantidadGatos];
        for (int i = 0; i < cantidadGatos; i++) {
            gatos[i] = new Animal("Gato", "Gato" + i, comedor);
            Thread t = new Thread(gatos[i]);
            t.start();
        }

    }
}
