package com.sofkianos.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.sofkianos.ui.SeccionKudos;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ExplorarKudos implements Task {

    public static ExplorarKudos deReconocimientos() {
        return instrumented(ExplorarKudos.class);
    }

    @Override
    @Step("explorar la seccion de kudos")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SeccionKudos.BOTON_EXPLORAR_KUDOS),
                WaitUntil.the(SeccionKudos.INPUT_BUSQUEDA, isVisible())
        );
    }
}