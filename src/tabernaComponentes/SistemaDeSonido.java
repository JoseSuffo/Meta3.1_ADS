package tabernaComponentes;

import tabernaBus.Suscriptor;
import tabernaEventos.BandaTocandoEvent;

public class SistemaDeSonido implements Suscriptor<BandaTocandoEvent> {
    @Override
    public void onEvent(BandaTocandoEvent evento) {
        System.out.println("[SONIDO] Ajustando ecualizador para: [" + evento.nombreCancion() + "] de " + evento.nombreBanda());
    }
}
