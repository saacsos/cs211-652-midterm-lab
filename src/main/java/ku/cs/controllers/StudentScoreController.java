package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.models.Student;
import ku.cs.models.StudentList;
import ku.cs.services.Datasource;
import ku.cs.services.FXRouter;
import ku.cs.services.StudentListFileDatasource;

import java.io.IOException;

public class StudentScoreController {
    @FXML private Label nameLabel;
    @FXML private Label idLabel;
    @FXML private Label scoreLabel;
    @FXML private Label errorLabel;
    @FXML private TextField scoreTextField;

    private Datasource<StudentList> datasource;
    private StudentList studentList;
    private Student student;

    @FXML
    public void initialize() {
        datasource = new StudentListFileDatasource("data", "student-list.csv");
        studentList = datasource.readData();

        String studentId = (String) FXRouter.getData();
        student = studentList.findStudentById(studentId);

        showStudent(student);

        errorLabel.setText("");
    }

    private void showStudent(Student student) {
        nameLabel.setText(student.getName());
        idLabel.setText(student.getId());
        scoreLabel.setText("" + student.getScore());
    }

    @FXML
    public void handleGiveScoreButton() {
        String scoreString = scoreTextField.getText().trim();
        if (scoreString.equals("")) {
            errorLabel.setText("score is required");
            return;
        }
        try {
            double score = Double.parseDouble(scoreString);
            if (score < 0) {
                errorLabel.setText("score must be positive number");
                return;
            }
            errorLabel.setText("");
            studentList.giveScoreToId(student.getId(), score);
            scoreTextField.clear();
            datasource.writeData(studentList);
            showStudent(student);
        } catch (NumberFormatException e) {
            errorLabel.setText("score must be number");
        }
    }

    @FXML
    public void handleBackToStudentsTableButton() {
        try {
            FXRouter.goTo("students-table");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
