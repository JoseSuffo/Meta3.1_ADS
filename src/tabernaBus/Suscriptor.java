package tabernaBus;

/* Interfaz genérica para cualquier componente que desee escuchar eventos.
  @param <T> El tipo de evento específico que este suscriptor manejar. */
public interface Suscriptor<T extends Evento> {
    void onEvent(T evento);
}