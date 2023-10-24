package ActividadObligatoriaSalaExposicion;

public class Main {
    public static void main(String[] args) {
        int maxVisitantes = 4;
        int maxResponsables = 2;
        int maxCriticos = 2;

        Sala sala = new Sala("Paka Paka");

        Visitante visitante = new Visitante("visitante", sala);
        Visitante responsable = new Visitante("responsable", sala);
        Visitante critico = new Visitante("critico", sala);


        Thread[] tvisitantes = new Thread[maxVisitantes];
        Thread[] tresponsables = new Thread[maxResponsables];
        Thread[] tcriticos = new Thread[maxCriticos];

        for (int i = 0; i < maxCriticos; i++) {
            tcriticos[i] = new Thread(critico, String.format("Critico #%d", i + 1));
            tcriticos[i].start();
        }
        for (int i = 0; i < maxResponsables; i++) {
            tresponsables[i] = new Thread(responsable, String.format("Responsable #%d", i + 1));
            tresponsables[i].start();
        }
        for (int i = 0; i < maxVisitantes; i++) {
            tvisitantes[i] = new Thread(visitante, String.format("Visitante #%d", i + 1));
            tvisitantes[i].start();
        }

    }
}
