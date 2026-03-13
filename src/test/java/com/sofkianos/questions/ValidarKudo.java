package com.sofkianos.questions;

import com.sofkianos.ui.SeccionKudos;
import com.sofkianos.util.Constantes;

import java.time.Duration;
import java.util.Collection;
import java.util.Locale;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@Subject("el reconocimiento creado con el mensaje")
public class ValidarKudo implements Question<Boolean> {

    private final String mensaje;

    public ValidarKudo(String mensaje) {
        this.mensaje = mensaje;
    }

    public static ValidarKudo conDatos(String mensaje) {
        return new ValidarKudo(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(SeccionKudos.FILAS_KUDOS, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(10))
        );

        Collection<String> filas = Text.ofEach(SeccionKudos.FILAS_KUDOS).answeredBy(actor);

        String mensajeNormalizado = normalizar(mensaje);

        return filas.stream()
                .map(this::normalizar)
                .anyMatch(fila -> fila.contains(mensajeNormalizado));
    }

    private String normalizar(String texto) {
        return texto == null
                ? ""
                : texto.trim().replaceAll(Constantes.REGEX_ESPACIOS, Constantes.ESPACIO_SIMPLE).toLowerCase(Locale.ROOT);
    }
}