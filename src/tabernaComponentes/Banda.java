package tabernaComponentes;

import tabernaBus.EventBus;
import tabernaEventos.BandaTocandoEvent;

public class Banda {
    private final EventBus bus;

    public Banda(EventBus bus) {
        this.bus = bus;
    }

    public void tocarCancion(String banda, String cancion, int duracion) {
        System.out.println("[BANDA] ¡Empieza una nueva canción!");
        bus.publicar(new BandaTocandoEvent(banda, cancion, duracion));
    }
}