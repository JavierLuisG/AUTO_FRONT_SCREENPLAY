package com.sofkianos.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaInicio {

    public static final Target BOTON_ACCEDER = Target.the("boton acceder")
            .locatedBy("//a[normalize-space()='Acceder'] | //button[normalize-space()='Acceder']");

    private PaginaInicio() {
    }
}