package tabernaEventos;
import tabernaBus.Evento;

public record BandaTocandoEvent(String nombreBanda, String nombreCancion, int duracion) implements Evento {
    //Java genera automáticamente constructor, toString, getters y setters.
}