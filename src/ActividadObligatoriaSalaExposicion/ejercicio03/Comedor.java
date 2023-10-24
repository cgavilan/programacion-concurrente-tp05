package ActividadObligatoriaSalaExposicion.ejercicio03;

import java.util.concurrent.Semaphore;

public class Comedor {
    private int cantidadComederos, salaEsperaGatos, salaEsperaPerros, perrosComidos, gatosComidos, tasaMaxima,
            contadorAnimales;
    Semaphore semaEntradaPerros, semaEntradaGatos, semaComedores, semaSalidaPerros, semaSalidaGatos;

    public void entrarAComer(String tipo) {
        try {
            // Verificar el primer animal que define quienes comen primero
            // El resto se frena en la sala de espera
            switch (tipo) {
                case "Perro":
                    salaEsperaPerros++;
                    if (contadorAnimales == 0) {
                        semaEntradaGatos.acquire();
                        semaEntradaPerros.acquire();
                    } else {
                        semaEntradaPerros.acquire();
                    }
                    break;
                case "Gato":
                    salaEsperaGatos++;
                    if (contadorAnimales == 0) {
                        semaEntradaPerros.acquire();
                        semaEntradaGatos.acquire();
                    } else {
                        semaEntradaGatos.acquire();
                    }
                    break;
            }
            // Se cuentan los animales que van pasando
            contadorAnimales++;
            // Se evalua si hay platos disponibles para dejar pasar otro animal
            switch (tipo) {
                case "Perro":
                    if (contadorAnimales < cantidadComederos) {
                        // Animales toman el plato
                        semaComedores.acquire();

                        semaEntradaPerros.release();
                    }
                    break;

                case "Gato":
                    if (contadorAnimales < cantidadComederos) {
                        semaEntradaGatos.release();
                        // Animales toman el plato
                        semaComedores.acquire();
                    }
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void salirDeComedor2(int tipo) {
        this.semaComedores.release();

    }

    public void salirDeComedor(String tipo) {
        // Se libera un plato
        this.semaComedores.release();
        // se descuenta un animal
        contadorAnimales--;
        switch (tipo) {
            case "Perro":
                // se saca un perro de la sala de espera y se asume comido
                salaEsperaPerros--;
                perrosComidos++;
                // Se busca al ultimo de la tanda
                if (contadorAnimales == 0) {
                    // Se evalua de acuerdo a la tasa
                    if (perrosComidos < tasaMaxima) {
                        // Se verifica si quedan perros esperando
                        if (salaEsperaGatos > 0) {
                            semaEntradaGatos.release();
                        } else {
                            semaEntradaPerros.release();
                        }
                    } else {
                        semaEntradaGatos.release();
                    }
                }
                break;
            case "Gato":
                // se saca un gato de la sala de espera y se asume comido
                salaEsperaGatos--;
                gatosComidos++;
                // Se busca al ultimo de la tanda
                if (contadorAnimales == 0) {
                    // Se evalua de acuerdo a la tasa
                    if (gatosComidos < tasaMaxima) {
                        // Se verifica si quedan perros esperando
                        if (salaEsperaPerros > 0) {
                            semaEntradaPerros.release();
                        } else {
                            semaEntradaGatos.release();
                        }
                    } else {
                        semaEntradaPerros.release();
                    }
                }
                break;

        }
    }

    public Comedor(int cc, int tasa) {
        this.cantidadComederos = cc;
        this.salaEsperaGatos = 0;
        this.salaEsperaPerros = 0;
        this.perrosComidos = 0;
        this.gatosComidos = 0;
        this.contadorAnimales = 0;
        this.tasaMaxima = tasa;
        this.semaComedores = new Semaphore(cc);
        this.semaEntradaPerros = new Semaphore(1);
        this.semaEntradaGatos = new Semaphore(1);
        this.semaSalidaPerros = new Semaphore(1);
        this.semaSalidaGatos = new Semaphore(1);
    }

}
