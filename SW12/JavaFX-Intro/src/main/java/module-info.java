module hslu.oop.sw12.javafxintro {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;

    exports hslu.oop.sw12.javafxintro;

    opens hslu.oop.sw12.javafxintro to javafx.fxml;
    opens hslu.oop.sw12.javafxintro.entity;
}
