package com.sofkianos.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import com.sofkianos.questions.ValidarKudo;
import com.sofkianos.tasks.AbrirAplicacion;
import com.sofkianos.tasks.EnviarReconocimiento;
import com.sofkianos.tasks.EscribirMensaje;
import com.sofkianos.tasks.ExplorarKudos;
import com.sofkianos.tasks.SeleccionarCategoria;
import com.sofkianos.tasks.SeleccionarDestinatario;
import com.sofkianos.tasks.SeleccionarRemitente;
import com.sofkianos.util.Constantes;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;

public class ReconocimientoStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver navegador;

    private String remitente;
    private String destinatario;
    private String categoria;
    private String mensaje;

    @Before
    public void prepararEscenario() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(Constantes.NOMBRE_ACTOR).can(BrowseTheWeb.with(navegador));
    }

    @Given("que el usuario ingresa a la pagina de generacion de reconocimientos")
    public void queElUsuarioIngresaALaPaginaDeGeneracionDeReconocimientos() {
        actorEnEscena().attemptsTo(AbrirAplicacion.deReconocimientos());
    }

    @When("crea un reconocimiento seleccionando el remitente {string}")
    public void creaUnReconocimientoSeleccionandoElRemitente(String remitente) {
        this.remitente = remitente;
        actorEnEscena().attemptsTo(SeleccionarRemitente.conNombre(remitente));
    }

    @And("selecciona al destinatario {string}")
    public void seleccionaAlDestinatario(String destinatario) {
        this.destinatario = destinatario;
        actorEnEscena().attemptsTo(SeleccionarDestinatario.conNombre(destinatario));
    }

    @And("selecciona la categoria {string}")
    public void seleccionaLaCategoria(String categoria) {
        this.categoria = categoria;
        actorEnEscena().attemptsTo(SeleccionarCategoria.conNombre(categoria));
    }

    @And("escribe un mensaje de felicitacion {string}")
    public void escribeUnMensajeDeFelicitacion(String mensaje) {
        this.mensaje = mensaje;
        actorEnEscena().attemptsTo(EscribirMensaje.deFelicitacion(mensaje));
    }

    @And("envia el reconocimiento")
    public void enviaElReconocimiento() {
        actorEnEscena().attemptsTo(EnviarReconocimiento.ahora());
    }

    @Then("explora la seccion de Kudos y verifica que el reconocimiento fue creado")
    public void exploraLaSeccionDeKudosYVerificaQueElReconocimientoFueCreado() {
        actorEnEscena().attemptsTo(ExplorarKudos.deReconocimientos());
        actorEnEscena().should(
                seeThat(ValidarKudo.conDatos(mensaje)));
    }

    private Actor actorEnEscena() {
        return OnStage.theActorInTheSpotlight();
    }
}