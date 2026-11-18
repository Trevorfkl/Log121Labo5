package com.example.vue;

import com.example.controleur.Controleur;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import com.example.modele.ImageModele;
import com.example.modele.Perspective;
import com.example.observer.Observable;
import com.example.observer.Observer;

public class VuePerspective extends Pane implements Observer {
    private ImageModele imageModele;
    private Perspective perspective;
    private Controleur controleur;
    private ImageView imageView;

    public VuePerspective(ImageModele imageModele, Perspective perspective) {
        this.imageModele = imageModele;
        this.perspective = perspective;
        
        this.imageModele.addObserver(this);
        this.perspective.addObserver(this);
        
        this.imageView = new ImageView();
        this.getChildren().add(imageView);
    }

    public void setControleur(Controleur c) {
        this.controleur = c;
        this.setOnMousePressed(controleur::mousePressed);
        this.setOnMouseDragged(controleur::mouseDragged);
        this.setOnMouseReleased(controleur::mouseReleased);
    }

    @Override
    public void update(Observable o) {
        paint();
    }

    public void paint() {
        if (imageModele.getImage() != null) {
            imageView.setImage(imageModele.getImage());
            imageView.setScaleX(perspective.getZoom());
            imageView.setScaleY(perspective.getZoom());
            imageView.setTranslateX(perspective.getTranslationX());
            imageView.setTranslateY(perspective.getTranslationY());
        }
    }
}
