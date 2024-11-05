package io.github.khoimanos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class PullController {
    ObservableList<Session> sessionList;
    @FXML
    private TableView<Session> tableView;
    @FXML
    private TableColumn<Session, String> MusclePullUps;
    @FXML
    private TableColumn<Session, String> PreacherCurls;
    @FXML
    private TableColumn<Session, String> FacePulls;
    @FXML
    private TableColumn<Session, String> ReverseCurls;
    @FXML
    private TextField textOne;
    @FXML
    private TextField textTwo;
    @FXML
    private TextField textThree;
    @FXML
    private TextField textFour;

    public void initialize(){
        MusclePullUps.setCellValueFactory(new PropertyValueFactory<>("excersizeOne"));
        PreacherCurls.setCellValueFactory(new PropertyValueFactory<>("excersizeTwo"));
        FacePulls.setCellValueFactory(new PropertyValueFactory<>("excersizeThree"));
        ReverseCurls.setCellValueFactory(new PropertyValueFactory<>("excersizeFour"));
        tableView.setItems(getSessionData());
    }

    private ObservableList<Session> getSessionData() {
        sessionList = FXCollections.observableArrayList();
        String sqlAnfrage = "SELECT musclePullUps, preacherCurls, facePull, reverseCurls FROM pull_sessions";

        try (Connection conn = Database.connect();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sqlAnfrage)) {

            while (rs.next()) {
                sessionList.add(new Session(
                        rs.getString("musclePullUps"),
                        rs.getString("preacherCurls"),
                        rs.getString("facePull"),
                        rs.getString("reverseCurls")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return sessionList;
    }

    public void initializee(ActionEvent actionEvent){
        String one = textOne.getText();
        String two = textTwo.getText();
        String three = textThree.getText();
        String four = textFour.getText();

        sessionList.add(new Session(one, two, three, four));

        String sqlEintrag = "INSERT INTO pull_sessions (musclePullUps, preacherCurls, facePull, reverseCurls) VALUES (?, ?, ?, ?);";

        try(Connection conn = Database.connect(); PreparedStatement preparedStatement = conn.prepareStatement(sqlEintrag)){

            preparedStatement.setString(1, one);
            preparedStatement.setString(2, two);
            preparedStatement.setString(3, three);
            preparedStatement.setString(4, four);

            // Execute the insert command
            preparedStatement.executeUpdate();
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
