package tabernaEventos;
import tabernaBus.Evento;

public record ComidaPreparadaEvent(String pedidoId, String plato) implements Evento {
    //Java genera automáticamente constructor, toString, getters y setters.
}