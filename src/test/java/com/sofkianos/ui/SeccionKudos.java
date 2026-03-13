package com.sofkianos.ui;

import net.serenitybdd.screenplay.targets.Target;

public class SeccionKudos {

    public static final Target BOTON_EXPLORAR_KUDOS = Target.the("boton explorar kudos")
            .locatedBy("//button[contains(.,'Explorar Kudos')]");

    public static final Target INPUT_BUSQUEDA = Target.the("input de busqueda")
            .locatedBy("//input[@aria-label='Buscar kudos']");

    public static final Target BOTON_APLICAR_FILTROS = Target.the("boton aplicar filtros")
            .locatedBy("//button[normalize-space()='Aplicar Filtros']");

    public static final Target FILAS_KUDOS = Target.the("filas de kudos")
            .locatedBy("(//tbody/tr)[1]");

    private SeccionKudos() {
    }
}