package com.example.hellofx;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Button button = new Button("最小化到系统托盘");
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(button);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(400);
        stage.centerOnScreen();
        stage.setTitle("javaFX系统托盘");
        stage.show();

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                java.awt.SystemTray systemTray = SystemTray.getSystemTray();
                Image image = Toolkit.getDefaultToolkit().getImage("app_icon.png");
                String s = "javaFX系统托盘";
                PopupMenu  popupMenu = new PopupMenu();
                MenuItem menuItem1 = new MenuItem("item1");
                MenuItem menuItem2 = new MenuItem("item2");
                popupMenu.add(menuItem1);
                popupMenu.add(menuItem2);
                TrayIcon trayIcon = new TrayIcon(image,s,popupMenu);
                try {
                    systemTray.add(trayIcon);
                } catch (AWTException e) {
                    e.printStackTrace();
                }
                stage.hide();
            }
        });

    }

    public static void main(String[] args) {
        launch();
    }
}