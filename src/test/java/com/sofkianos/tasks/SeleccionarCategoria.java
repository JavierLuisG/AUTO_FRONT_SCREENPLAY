package com.sofkianos.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.sofkianos.ui.FormularioReconocimiento;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class SeleccionarCategoria implements Task {

    private final String nombre;

    public SeleccionarCategoria(String nombre) {
        this.nombre = nombre;
    }

    public static SeleccionarCategoria conNombre(String nombre) {
        return instrumented(SeleccionarCategoria.class, nombre);
    }

    @Override
    @Step("seleccionar la categoria {0}")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FormularioReconocimiento.SELECTOR_CATEGORIA),
                SelectFromOptions.byVisibleText(nombre).from(FormularioReconocimiento.SELECTOR_CATEGORIA)
        );
    }
}