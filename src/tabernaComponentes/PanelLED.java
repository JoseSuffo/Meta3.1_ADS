package tabernaComponentes;

import tabernaBus.Evento;
import tabernaBus.Suscriptor;
import tabernaEventos.BebidaServidaEvent;
import tabernaEventos.ComidaPreparadaEvent;

public class PanelLED implements Suscriptor<Evento> {
    @Override
    public void onEvent(Evento evento) {
        if (evento instanceof BebidaServidaEvent e) {
            System.out.println("[PANEL LED] ¡Nueva bebida servida en la Mesa " + e.mesaId() + " (" + e.bebida() + ")!");
        } else if (evento instanceof ComidaPreparadaEvent e) {
            System.out.println("[PANEL LED] ¡Plato listo: " + e.plato() + " para el pedido " + e.pedidoId() + "!");
        }
    }
}