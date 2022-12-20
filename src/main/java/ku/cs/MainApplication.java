package ku.cs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "");
        configRoute();
        FXRouter.goTo("hello");
    }

    private static void configRoute() {
        String viewPath = "ku/cs/views/";
        FXRouter.when("hello", viewPath + "hello-view.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}