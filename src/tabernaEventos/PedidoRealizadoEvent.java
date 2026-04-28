package tabernaEventos;

import tabernaBus.Evento;
import java.util.List;

/* Representa un pedido hecho por un cliente. Al ser un record, es inmutable por defecto. */
public record PedidoRealizadoEvent(String mesaId, String pedidoId, List<String> items) implements Evento {
    //Java genera automáticamente constructor, toString, getters y setters.
}
