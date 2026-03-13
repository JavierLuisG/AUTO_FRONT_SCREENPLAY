package com.sofkianos.ui;

import net.serenitybdd.screenplay.targets.Target;

public class SeccionKudos {

    public static final Target BOTON_EXPLORAR_KUDOS = Target.the("boton explorar kudos")
            .locatedBy("//a[contains(normalize-space(),'Kudos') or contains(normalize-space(),'Explorar')] | //button[contains(normalize-space(),'Kudos') or contains(normalize-space(),'Explorar')]");

    public static final Target INPUT_BUSQUEDA = Target.the("input de busqueda")
            .locatedBy("//input[@type='search' or contains(@placeholder,'Buscar') or contains(@placeholder,'Filtrar') or @name='search']");

    public static final Target BOTON_APLICAR_FILTROS = Target.the("boton aplicar filtros")
            .locatedBy("//button[contains(normalize-space(),'Aplicar') or contains(normalize-space(),'Buscar') or contains(normalize-space(),'Filtrar')]");

    public static final Target FILAS_KUDOS = Target.the("filas de kudos")
            .locatedBy("//table//tbody/tr | //section[contains(@class,'kudos')]//article | //div[contains(@class,'kudo-card') or contains(@class,'recognition-card')]");

    private SeccionKudos() {
    }
}