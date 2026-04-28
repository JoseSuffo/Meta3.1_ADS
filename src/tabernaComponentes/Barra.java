package tabernaComponentes;

import tabernaBus.Suscriptor;
import tabernaEventos.PedidoRealizadoEvent;

/* La Barra es un componente que escucha pedidos para servir bebidas. */
public class Barra implements Suscriptor<PedidoRealizadoEvent> {

    @Override
    public void onEvent(PedidoRealizadoEvent evento) {
        System.out.println("--------------------------------------------------");
        System.out.println("[BARRA] ¡Recibí un pedido!");
        System.out.println("[BARRA] Mesa: " + evento.mesaId());
        System.out.println("[BARRA] ID Pedido: " + evento.pedidoId());
        System.out.println("[BARRA] Items a revisar: " + evento.items());
        System.out.println("--------------------------------------------------");
    }
}