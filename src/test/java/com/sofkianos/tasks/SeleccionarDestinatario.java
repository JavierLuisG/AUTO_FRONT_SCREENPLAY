package com.sofkianos.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.sofkianos.ui.FormularioReconocimiento;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class SeleccionarDestinatario implements Task {

    private final String nombre;

    public SeleccionarDestinatario(String nombre) {
        this.nombre = nombre;
    }

    public static SeleccionarDestinatario conNombre(String nombre) {
        return instrumented(SeleccionarDestinatario.class, nombre);
    }

    @Override
    @Step("seleccionar el destinatario {0}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FormularioReconocimiento.SELECTOR_DESTINATARIO),
                SelectFromOptions.byVisibleText(nombre).from(FormularioReconocimiento.SELECTOR_DESTINATARIO)
        );
    }
}