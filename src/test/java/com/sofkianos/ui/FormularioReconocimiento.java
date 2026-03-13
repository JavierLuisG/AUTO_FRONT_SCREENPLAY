package com.sofkianos.ui;

import net.serenitybdd.screenplay.targets.Target;

public class FormularioReconocimiento {

    public static final Target SELECTOR_REMITENTE = Target.the("selector de remitente")
            .locatedBy("//select[@name='from']");

    public static final Target SELECTOR_DESTINATARIO = Target.the("selector de destinatario")
            .locatedBy("//select[@name='to']");

    public static final Target SELECTOR_CATEGORIA = Target.the("selector de categoria")
            .locatedBy("//select[@name='category']");

    public static final Target CAMPO_MENSAJE = Target.the("campo de mensaje")
            .locatedBy("//textarea[@name='message']");

    public static final Target CONTROL_DESLIZANTE_ENVIO = Target.the("control deslizante de envio")
            .locatedBy("//span[normalize-space()='Desliza para enviar']");

    public static final Target OVALO_ENVIO = Target.the("ovalo de envio")
            .locatedBy("//div[contains(@class,'bg-brand') and contains(@class,'rounded-full')]");

    private FormularioReconocimiento() {
    }
}