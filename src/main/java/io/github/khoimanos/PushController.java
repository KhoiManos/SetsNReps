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

public class PushController {
    ObservableList<Session> sessionList;
    @FXML
    private TableView<Session> tableView;
    @FXML
    private TableColumn<Session, String> flyCol;
    @FXML
    private TableColumn<Session, String> benchCol;
    @FXML
    private TableColumn<Session, String> tricepsCol;
    @FXML
    private TableColumn<Session, String> lateralCol;
    @FXML
    private TextField textOne;
    @FXML
    private TextField textTwo;
    @FXML
    private TextField textThree;
    @FXML
    private TextField textFour;



    public void initialize() {
        flyCol.setCellValueFactory(new PropertyValueFactory<>("chestflys"));
        benchCol.setCellValueFactory(new PropertyValueFactory<>("bench"));
        tricepsCol.setCellValueFactory(new PropertyValueFactory<>("triceps"));
        lateralCol.setCellValueFactory(new PropertyValueFactory<>("lateralRaises"));
        tableView.setItems(getSessionData());
    }

    private ObservableList<Session> getSessionData() {
        sessionList = FXCollections.observableArrayList();
        String sqlAnfrage = "SELECT chestflys, bench, triceps, lateralRaises FROM push_sessions";

        try (Connection conn = Database.connect();
              Statement statement = conn.createStatement();
              ResultSet rs = statement.executeQuery(sqlAnfrage)) {

                while (rs.next()) {
                    sessionList.add(new Session(
                            rs.getString("chestflys"),
                            rs.getString("bench"),
                            rs.getString("triceps"),
                            rs.getString("lateralRaises")));
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

        String sqlEintrag = "INSERT INTO push_sessions (chestflys, bench, triceps, lateralRaises) VALUES (?, ?, ?, ?);";

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

