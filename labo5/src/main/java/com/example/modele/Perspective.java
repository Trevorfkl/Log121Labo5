package com.example.modele;

import com.example.observer.Observable;
import java.io.Serializable;

public class Perspective extends Observable implements Serializable {
    private double zoom = 1.0;
    private double translationX = 0.0;
    private double translationY = 0.0;

    public double getZoom() { return zoom; }
    
    public void setZoom(double facteurZoom) {
        this.zoom = facteurZoom;
        notifyObservers();
    }

    public double getTranslationX() { return translationX; }
    public double getTranslationY() { return translationY; }

    public void setTranslation(double translationX, double translationY) {
        this.translationX = translationX;
        this.translationY = translationY;
        notifyObservers();
    }
}
