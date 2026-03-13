package com.sofkianos.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.sofkianos.ui.FormularioReconocimiento;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class SeleccionarRemitente implements Task {

    private final String nombre;

    public SeleccionarRemitente(String nombre) {
        this.nombre = nombre;
    }

    public static SeleccionarRemitente conNombre(String nombre) {
        return instrumented(SeleccionarRemitente.class, nombre);
    }

    @Override
    @Step("seleccionar el remitente {0}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FormularioReconocimiento.SELECTOR_REMITENTE),
                SelectFromOptions.byVisibleText(nombre).from(FormularioReconocimiento.SELECTOR_REMITENTE)
        );
    }
}