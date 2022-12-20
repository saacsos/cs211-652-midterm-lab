module ku.cs.lab03collectionclass {
    requires javafx.controls;
    requires javafx.fxml;

    exports ku.cs.controllers;
    opens ku.cs.controllers to javafx.fxml;
    exports ku.cs;
    opens ku.cs to javafx.fxml;
}