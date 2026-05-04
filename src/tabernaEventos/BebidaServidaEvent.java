package tabernaEventos;
import tabernaBus.Evento;

public record BebidaServidaEvent(String mesaId, String bebida) implements Evento {
    //Java genera automáticamente constructor, toString, getters y setters.
}