package com.sofkianos.ui;

import net.serenitybdd.screenplay.targets.Target;

public class FormularioReconocimiento {

    public static final Target SELECTOR_REMITENTE = Target.the("selector de remitente")
            .locatedBy("//label[contains(normalize-space(),'De') or contains(normalize-space(),'From')]/following::div[contains(@class,'select') or @role='combobox'][1]");

    public static final Target SELECTOR_DESTINATARIO = Target.the("selector de destinatario")
            .locatedBy("//label[contains(normalize-space(),'Para') or contains(normalize-space(),'To')]/following::div[contains(@class,'select') or @role='combobox'][1]");

    public static final Target SELECTOR_CATEGORIA = Target.the("selector de categoria")
            .locatedBy("//label[contains(normalize-space(),'Categoria') or contains(normalize-space(),'Category')]/following::div[contains(@class,'select') or @role='combobox'][1]");

    public static final Target CAMPO_MENSAJE = Target.the("campo de mensaje")
            .locatedBy("//textarea[contains(@placeholder,'mensaje') or contains(@placeholder,'felicit') or @name='message']");

    public static final Target CONTROL_DESLIZANTE_ENVIO = Target.the("control deslizante de envio")
            .locatedBy("//div[contains(@class,'slider') or contains(@class,'swipe') or @data-testid='send-slider']");

    public static final Target OVALO_ENVIO = Target.the("ovalo de envio")
            .locatedBy("//div[(contains(@class,'thumb') or contains(@class,'handle') or contains(@class,'knob')) and ancestor::*[contains(@class,'slider') or contains(@class,'swipe') or @data-testid='send-slider']]");

    private FormularioReconocimiento() {
    }
}