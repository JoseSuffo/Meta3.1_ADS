package tabernaComponentes;

import tabernaBus.Suscriptor;
import tabernaEventos.BandaTocandoEvent;

public class SistemaDeHumo implements Suscriptor<BandaTocandoEvent> {

    @Override
    public void onEvent(BandaTocandoEvent evento) {
        if (evento.nombreCancion().equalsIgnoreCase("Through the Fire and Flames")) {
            System.out.println("\n[SISTEMA DE HUMO] ¡ATENCIÓN! Se detectó una canción legendaria.");
            System.out.println("[SISTEMA DE HUMO] DISPARANDO RÁFAGAS DE HUMO Y FUEGO... ¡ESTO ES ÉPICO! \n");
        } else {
            System.out.println("[SISTEMA DE HUMO] (En espera... esta canción no es lo suficientemente épica)");
        }
    }
}