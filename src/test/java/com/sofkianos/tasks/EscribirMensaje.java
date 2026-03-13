package com.sofkianos.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.sofkianos.ui.FormularioReconocimiento;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

public class EscribirMensaje implements Task {

    private final String mensaje;

    public EscribirMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public static EscribirMensaje deFelicitacion(String mensaje) {
        return instrumented(EscribirMensaje.class, mensaje);
    }

    @Override
    @Step("escribir el mensaje de felicitacion {0}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(mensaje).into(FormularioReconocimiento.CAMPO_MENSAJE)
        );
    }
}