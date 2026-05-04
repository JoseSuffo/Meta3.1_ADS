package tabernaComponentes;

import tabernaBus.EventBus;
import tabernaBus.Suscriptor;
import tabernaEventos.ComidaPreparadaEvent;
import tabernaEventos.PedidoRealizadoEvent;
import java.util.concurrent.CompletableFuture;

public class Cocina implements Suscriptor<PedidoRealizadoEvent> {
    private final EventBus bus;

    public Cocina(EventBus bus) {
        this.bus = bus;
    }

    @Override
    public void onEvent(PedidoRealizadoEvent evento) {
        for (String item : evento.items()) {
            if (item.equalsIgnoreCase("Hamburguesa") || item.equalsIgnoreCase("Pizza")) {
                CompletableFuture.runAsync(() -> {
                    try {
                        System.out.println("[COCINA] Cocinando " + item + " del pedido " + evento.pedidoId() + "...");
                        Thread.sleep(5000);
                        bus.publicar(new ComidaPreparadaEvent(evento.pedidoId(), item));
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        }
    }
}
