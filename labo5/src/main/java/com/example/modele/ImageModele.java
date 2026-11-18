package com.example.modele;

import com.example.observer.Observable;
import javafx.scene.image.Image;
import java.io.Serializable;

public class ImageModele extends Observable implements Serializable {
    private String chemin;
    private transient Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(String chemin) {
        this.chemin = chemin;
        this.image = new Image("file:" + chemin);
        notifyObservers();
    }
    
    public String getChemin() {
        return chemin;
    }
}
