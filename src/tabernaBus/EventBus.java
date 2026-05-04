package tabernaBus;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {
    // El mapa usa la Clase del evento como llave y una lista de suscriptores como valor
    private final Map<Class<? extends Evento>, List<Suscriptor>> suscriptores = new ConcurrentHashMap<>();

    /* Registra un suscriptor para un tipo de evento específico. */
    public <T extends Evento> void suscribir(Class<T> tipoEvento, Suscriptor<? super T> suscriptor) {
        suscriptores.computeIfAbsent(tipoEvento, k -> new CopyOnWriteArrayList<>())
                .add((Suscriptor<Evento>) suscriptor); // Cast seguro para el mapa interno

        System.out.println("[EVENT BUS] Nuevo suscriptor registrado para: " + tipoEvento.getSimpleName());
    }

    /* Notifica a todos los suscriptores interesados en el tipo de este evento. */
    @SuppressWarnings("unchecked")
    public void publicar(Evento evento) {
        Class<? extends Evento> tipoEvento = evento.getClass();
        List<Suscriptor> lista = suscriptores.get(tipoEvento);

        if (lista != null && !lista.isEmpty()) {
            for (Suscriptor s : lista) {
                s.onEvent(evento);
            }
        } else {
            System.out.println("[EVENT BUS] Evento publicado pero nadie está escuchando: " + tipoEvento.getSimpleName());
        }
    }

    /* Remueve un suscriptor de un tipo de evento. */
    public <T extends Evento> void desuscribir(Class<T> tipoEvento, Suscriptor<T> suscriptor) {
        List<Suscriptor> lista = suscriptores.get(tipoEvento);
        if (lista != null) {
            lista.remove(suscriptor);
        }
    }
}