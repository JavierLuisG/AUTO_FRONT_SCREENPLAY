package com.sofkianos.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.sofkianos.interactions.DeslizarOvalo;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static com.sofkianos.ui.FormularioReconocimiento.CONTROL_DESLIZANTE_ENVIO;
import static com.sofkianos.ui.FormularioReconocimiento.OVALO_ENVIO;

public class EnviarReconocimiento implements Task {

    public static EnviarReconocimiento ahora() {
        return instrumented(EnviarReconocimiento.class);
    }

    @Override
    @Step("enviar el reconocimiento")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                DeslizarOvalo.desde(OVALO_ENVIO).hastaElFinalDe(CONTROL_DESLIZANTE_ENVIO)
        );
    }
}