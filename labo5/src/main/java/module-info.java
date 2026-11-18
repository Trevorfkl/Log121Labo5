module com.example {
    requires javafx.controls;
    requires javafx.fxml;

    requires transitive javafx.graphics;

    opens com.example.app to javafx.fxml;
    
    
    exports com.example.app;

    
    exports com.example.modele;
    exports com.example.vue;
    exports com.example.controleur;
    exports com.example.commande;
    exports com.example.observer;
}