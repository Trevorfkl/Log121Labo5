package com.example.vue;

import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import com.example.modele.ImageModele;
import com.example.observer.Observable;
import com.example.observer.Observer;

public class VueVignette extends Pane implements Observer {
    private ImageModele imageModele;
    private ImageView imageView;

    public VueVignette(ImageModele imageModele) {
        this.imageModele = imageModele;
        this.imageModele.addObserver(this);
        this.imageView = new ImageView();
        this.getChildren().add(imageView);
    }

    @Override
    public void update(Observable o) {
        paint();
    }

    public void paint() {
        if (imageModele.getImage() != null) {
            imageView.setImage(imageModele.getImage());
        }
    }
}
