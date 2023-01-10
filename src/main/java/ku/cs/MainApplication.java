package ku.cs;

import javafx.application.Application;
import javafx.stage.Stage;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "", 800, 600);
        configRoute();
//        FXRouter.goTo("hello");
        FXRouter.goTo("students-table");
    }

    private static void configRoute() {
        String viewPath = "ku/cs/views/";
        FXRouter.when("hello", viewPath + "hello-view.fxml");
        FXRouter.when("student-list", viewPath + "student-list.fxml");
        FXRouter.when("students-table", viewPath + "students-table.fxml");
        FXRouter.when("student-score", viewPath + "student-score.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}