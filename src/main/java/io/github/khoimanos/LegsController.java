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

public class LegsController {
    ObservableList<Session> sessionList;
    @FXML
    private TableView<Session> tableView;
    @FXML
    private TableColumn<Session, String> squats;
    @FXML
    private TableColumn<Session, String> legCurl;
    @FXML
    private TableColumn<Session, String> legExtensions;
    @FXML
    private TableColumn<Session, String> calfRaises;
    @FXML
    private TextField textOne;
    @FXML
    private TextField textTwo;
    @FXML
    private TextField textThree;
    @FXML
    private TextField textFour;



    public void initialize() {
        squats.setCellValueFactory(new PropertyValueFactory<>("excersizeOne"));
        legCurl.setCellValueFactory(new PropertyValueFactory<>("excersizeTwo"));
        legExtensions.setCellValueFactory(new PropertyValueFactory<>("excersizeThree"));
        calfRaises.setCellValueFactory(new PropertyValueFactory<>("excersizeFour"));
        tableView.setItems(getSessionData());
    }

    private ObservableList<Session> getSessionData() {
        sessionList = FXCollections.observableArrayList();
        String sqlAnfrage = "SELECT squats, legCurl, legExtensions, calfRaise FROM legs_sessions";

        try (Connection conn = Database.connect();
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery(sqlAnfrage)) {

            while (rs.next()) {
                sessionList.add(new Session(
                        rs.getString("squats"),
                        rs.getString("legCurl"),
                        rs.getString("legExtensions"),
                        rs.getString("calfRaise")));

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

        String sqlEintrag = "INSERT INTO legs_sessions (squats, legCurl, legExtensions, calfRaise) VALUES (?, ?, ?, ?);";

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

