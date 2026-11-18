package com.example.app;

import com.example.commande.GestionnaireCommande;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import com.example.modele.ImageModele;
import com.example.modele.Perspective;
import com.example.vue.VuePerspective;
import com.example.vue.VueVignette;

public class MainController {

    @FXML private BorderPane panneauVignette;
    @FXML private BorderPane panneauPerspective1;
    @FXML private BorderPane panneauPerspective2;

    private ImageModele imageModele;
    private Perspective perspective1;
    private Perspective perspective2;
    private Perspective perspectiveActive;

    @FXML
    public void initialize() {
        imageModele = new ImageModele();
        perspective1 = new Perspective();
        perspective2 = new Perspective();

        VueVignette vueVignette = new VueVignette(imageModele);
        VuePerspective vuePersp1 = new VuePerspective(imageModele, perspective1);
        VuePerspective vuePersp2 = new VuePerspective(imageModele, perspective2);

        panneauVignette.setCenter(vueVignette);
        panneauPerspective1.setCenter(vuePersp1);
        panneauPerspective2.setCenter(vuePersp2);
        
        perspectiveActive = perspective1; 
    }

    @FXML
    public void ouvrirImage() {
        String chemin = "chemin/vers/image.jpg";
        imageModele.setImage(chemin);
    }

    @FXML
    public void defaireAction() {
        GestionnaireCommande.getInstance().commandeDefaire(perspectiveActive);
    }
    
    @FXML
    public void sauvegarder() {
    }
}
