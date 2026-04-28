package tabernaMain;

import tabernaBus.EventBus;
import tabernaComponentes.Barra;
import tabernaEventos.PedidoRealizadoEvent;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciar el EventBus (El motor central)
        EventBus bus = new EventBus();

        // 2. Instanciar los Componentes
        // Nota: Por ahora la Barra no necesita el bus en el constructor
        // porque solo está escuchando, pero lo necesitaremos más adelante.
        Barra barra = new Barra();

        // 3. Suscribir los componentes al Bus
        // Le decimos al bus: "Cuando pase un PedidoRealizadoEvent, avísale a la barra"
        bus.suscribir(PedidoRealizadoEvent.class, barra);

        System.out.println("\n--- INICIANDO SIMULACIÓN DE LA TABERNA ---\n");

        // 4. Crear un evento manualmente y publicarlo
        // Simulamos que un cliente pide una Cerveza y un Mezcal en la Mesa 5
        PedidoRealizadoEvent primerPedido = new PedidoRealizadoEvent(
                "Mesa 5",
                "ORD-001",
                List.of("Cerveza", "Mezcal")
        );

        System.out.println("[SISTEMA] Publicando pedido...");
        bus.publicar(primerPedido);
    }
}