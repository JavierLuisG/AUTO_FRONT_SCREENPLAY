package com.sofkianos.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.sofkianos.hooks.AbrirNavegador;
import com.sofkianos.util.Constantes;
import com.sofkianos.ui.PaginaInicio;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class AbrirAplicacion implements Task {

    public static AbrirAplicacion deReconocimientos() {
        return instrumented(AbrirAplicacion.class);
    }

    @Override
    @Step("abrir la aplicacion de reconocimientos")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                AbrirNavegador.abrirUrl(Constantes.URL),
                Click.on(PaginaInicio.BOTON_ACCEDER)
        );
    }
}