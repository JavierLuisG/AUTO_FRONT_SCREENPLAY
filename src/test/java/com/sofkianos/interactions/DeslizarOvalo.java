package com.sofkianos.interactions;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DeslizarOvalo implements Interaction {

    private final Target ovalo;
    private final Target contenedor;

    public DeslizarOvalo(Target ovalo, Target contenedor) {
        this.ovalo = ovalo;
        this.contenedor = contenedor;
    }

    public static ConstructorDeslizamiento desde(Target ovalo) {
        return new ConstructorDeslizamiento(ovalo);
    }

    @Override
    @Step("{0} desliza el envio hasta confirmar")
    public <T extends Actor> void performAs(T actor) {
        WebDriver navegador = BrowseTheWeb.as(actor).getDriver();
        WebElement elementoOvalo = ovalo.resolveFor(actor);
        WebElement elementoContenedor = contenedor.resolveFor(actor);
        int desplazamientoHorizontal = elementoContenedor.getRect().getWidth() - elementoOvalo.getRect().getWidth();

        new Actions(navegador)
                .clickAndHold(elementoOvalo)
                .moveByOffset(desplazamientoHorizontal, 0)
                .release()
                .perform();
    }

    public static class ConstructorDeslizamiento {

        private final Target ovalo;

        public ConstructorDeslizamiento(Target ovalo) {
            this.ovalo = ovalo;
        }

        public DeslizarOvalo hastaElFinalDe(Target control) {
            return instrumented(DeslizarOvalo.class, ovalo, control);
        }
    }
}