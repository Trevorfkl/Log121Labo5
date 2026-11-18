package com.example.commande;

import com.example.modele.Perspective;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GestionnaireCommande {
    private static GestionnaireCommande instance;
    private Map<Perspective, Stack<Commande>> historique;

    private GestionnaireCommande() {
        historique = new HashMap<>();
    }

    public static GestionnaireCommande getInstance() {
        if (instance == null) {
            instance = new GestionnaireCommande();
        }
        return instance;
    }

    public void executeCommande(Commande c) {
        c.execute();
        Perspective p = c.getPerspective();
        historique.putIfAbsent(p, new Stack<>());
        historique.get(p).push(c);
    }

    public void commandeDefaire(Perspective p) {
        if (historique.containsKey(p) && !historique.get(p).isEmpty()) {
            Commande c = historique.get(p).pop();
            c.defaire();
        }
    }
}
