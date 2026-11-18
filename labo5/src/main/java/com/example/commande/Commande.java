package com.example.commande;

import com.example.modele.Perspective;

public interface Commande {
    void execute();
    void defaire();
    Perspective getPerspective();
}
