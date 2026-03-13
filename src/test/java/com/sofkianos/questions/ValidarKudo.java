package com.sofkianos.questions;

import com.sofkianos.util.Constantes;
import com.sofkianos.ui.SeccionKudos;
import java.util.Collection;
import java.util.Locale;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

@Subject("el reconocimiento creado con mensaje {3}")
public class ValidarKudo implements Question<Boolean> {

    private final String remitente;
    private final String destinatario;
    private final String categoria;
    private final String mensaje;

    public ValidarKudo(String remitente, String destinatario, String categoria, String mensaje) {
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.categoria = categoria;
        this.mensaje = mensaje;
    }

    public static ValidarKudo conDatos(String remitente, String destinatario, String categoria, String mensaje) {
        return new ValidarKudo(remitente, destinatario, categoria, mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Collection<String> filasVisibles = Text.ofEach(SeccionKudos.FILAS_KUDOS).answeredBy(actor);
        String remitenteNormalizado = normalizar(remitente);
        String destinatarioNormalizado = normalizar(destinatario);
        String categoriaNormalizada = normalizar(categoria);
        String mensajeNormalizado = normalizar(mensaje);

        return filasVisibles.stream()
                .map(this::normalizar)
                .anyMatch(fila -> fila.contains(remitenteNormalizado)
                        && fila.contains(destinatarioNormalizado)
                        && fila.contains(categoriaNormalizada)
                        && fila.contains(mensajeNormalizado));
    }

    private String normalizar(String texto) {
        return texto == null
                ? ""
                : texto.trim().replaceAll(Constantes.REGEX_ESPACIOS, Constantes.ESPACIO_SIMPLE).toLowerCase(Locale.ROOT);
    }
}