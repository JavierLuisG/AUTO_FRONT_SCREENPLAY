package com.sofkianos.ui;

import net.serenitybdd.core.annotations.findby.By;
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

    public static final Target CONTROL_DESLIZANTE_ENVIO =
            Target.the("control deslizante de envio")
                    .located(By.xpath("//*[@id='root']/div/main/div/div[2]/section/div[3]/div/div[5]/div/div[1]"));

    public static final Target OVALO_ENVIO =
            Target.the("ovalo de envio")
                    .located(By.xpath("//*[@id='root']/div/main/div/div[2]/section/div[3]/div/div[5]/div/div[3]"));
    private FormularioReconocimiento() {
    }
}