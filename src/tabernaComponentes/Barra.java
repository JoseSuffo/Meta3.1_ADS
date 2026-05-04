package tabernaComponentes;

import tabernaBus.EventBus;
import tabernaBus.Suscriptor;
import tabernaEventos.BebidaServidaEvent;
import tabernaEventos.PedidoRealizadoEvent;
import java.util.concurrent.CompletableFuture;

public class Barra implements Suscriptor<PedidoRealizadoEvent> {
    private final EventBus bus;

    public Barra(EventBus bus) {
        this.bus = bus;
    }

    @Override
    public void onEvent(PedidoRealizadoEvent evento) {
        for (String item : evento.items()) {
            if (item.equalsIgnoreCase("Cerveza") || item.equalsIgnoreCase("Vino")) {
                CompletableFuture.runAsync(() -> {
                    try {
                        System.out.println("[BARRA] Preparando " + item + " para la " + evento.mesaId() + "...");
                        Thread.sleep(2000);
                        bus.publicar(new BebidaServidaEvent(evento.mesaId(), item));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
    }
}