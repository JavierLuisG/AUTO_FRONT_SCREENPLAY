package com.sofkianos.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PaginaInicio {

    public static final Target BOTON_ACCEDER = Target.the("boton acceder")
            .locatedBy("//button[contains(.,'Acceder')]");

    private PaginaInicio() {
    }
}