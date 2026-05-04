package tabernaMain;

import tabernaBus.EventBus;
import tabernaComponentes.*;
import tabernaEventos.BandaTocandoEvent;
import tabernaEventos.BebidaServidaEvent;
import tabernaEventos.ComidaPreparadaEvent;
import tabernaEventos.PedidoRealizadoEvent;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EventBus bus = new EventBus();

        Barra barra = new Barra(bus);
        Cocina cocina = new Cocina(bus);
        Banda banda = new Banda(bus);

        PanelLED panel = new PanelLED();
        SistemaDeSonido sonido = new SistemaDeSonido();
        SistemaDeHumo humo = new SistemaDeHumo();

        bus.suscribir(PedidoRealizadoEvent.class, barra);
        bus.suscribir(PedidoRealizadoEvent.class, cocina);

        bus.suscribir(BebidaServidaEvent.class, panel);
        bus.suscribir(ComidaPreparadaEvent.class, panel);

        bus.suscribir(BandaTocandoEvent.class, sonido);
        bus.suscribir(BandaTocandoEvent.class, panel);
        bus.suscribir(BandaTocandoEvent.class, humo);

        System.out.println("==================================================");
        System.out.println("   BIENVENIDOS A LA TABERNA EL GÓLEM ALQUÍMICO   ");
        System.out.println("==================================================\n");

        banda.tocarCancion("Queen", "Tie Your Mother Down", 180);

        System.out.println("\n[SISTEMA] Registrando pedido de la Mesa 5...");
        bus.publicar(new PedidoRealizadoEvent(
                "Mesa 5",
                "PED-001",
                List.of("Cerveza", "Hamburguesa")
        ));

        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        System.out.println("\n");
        banda.tocarCancion("The Beatles", "Let It Be", 300);

        System.out.println("\n[SISTEMA] Registrando pedido de la Mesa 7...");
        bus.publicar(new PedidoRealizadoEvent(
                "Mesa 7",
                "PED-002",
                List.of("Soda", "Papas Fritas")
        ));

        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        System.out.println("\n[SISTEMA] ¡La banda cambia el ritmo!");
        banda.tocarCancion("DragonForce", "Through the Fire and Flames", 440);

        try {
            System.out.println("\n[SISTEMA] Esperando a que terminen los procesos asíncronos...");
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n==================================================");
        System.out.println("=             FIN DE LA SIMULACIÓN               =");
        System.out.println("==================================================");
    }
}