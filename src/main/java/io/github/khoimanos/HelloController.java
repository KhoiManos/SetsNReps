package io.github.khoimanos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    public void openPushView(ActionEvent actionEvent) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("push.fxml"));
        try {
            Parent root = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Your Pushday");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    public void openPullView(ActionEvent actionEvent) {
        FXMLLoader pullLoad = new FXMLLoader(getClass().getResource("pull.fxml"));
        try {
            Parent rooot = pullLoad.load();

            Stage stage = new Stage();
            stage.setTitle("Your Pullday");
            stage.setScene(new Scene(rooot));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openLegsView(ActionEvent actionEvent) {
        FXMLLoader pullLoad = new FXMLLoader(getClass().getResource("legs.fxml"));
        try {
            Parent roooot = pullLoad.load();

            Stage stage = new Stage();
            stage.setTitle("Your Legday (u r cooked)");
            stage.setScene(new Scene(roooot));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

