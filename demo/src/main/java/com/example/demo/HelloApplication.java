package com.example.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        VBox rootNode = fxmlLoader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);
        stage.setTitle("Temperature Converter Tool");
        stage.setScene(scene);
        stage.show();
        stage.isFullScreen();
    }

    private MenuBar createMenu()

    {
        Menu fileMenu = new Menu("file");
        Menu newMenu = new Menu("new");
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        Menu quitMenu = new Menu("quit");
        quitMenu.setOnAction(actionEvent -> quitApp());


        fileMenu.getItems().addAll(newMenu,separatorMenuItem,quitMenu);
        Menu helpMenu = new Menu("help");
        Menu aboutMenu = new Menu("About");

        aboutMenu.setOnAction(actionEvent -> aboutApp());

        helpMenu.getItems().addAll(aboutMenu);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;

    }
    public static void aboutApp()
    {
        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop Application");
        alertDialog.setHeaderText("Learning javaFX");
        alertDialog.setContentText(" I am just a beginner!!!");
        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");
        alertDialog.getButtonTypes().setAll(yesBtn,noBtn);
        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

        if (clickedBtn.isPresent() && clickedBtn.get()== yesBtn)
        {
            System.out.println("Yes button clicked");
        }
        if (clickedBtn.isPresent() && clickedBtn.get()==noBtn)
        {
            System.out.println("No button clicked");
        }
    }

    public static void quitApp()
    {
        Alert alertDialog = new Alert(Alert.AlertType.NONE);
        alertDialog.setTitle("Quit App?");
        alertDialog.setHeaderText("Do you want to quit ?");
        alertDialog.setContentText("Do you want to quit the App");
        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");
        alertDialog.getButtonTypes().addAll(yesBtn,noBtn);

        Optional<ButtonType> clickedBtn = alertDialog.showAndWait();

        if(clickedBtn.isPresent() && clickedBtn.get()==yesBtn){
            Platform.exit();
            System.exit(0);
        }

        if(clickedBtn.isPresent() && clickedBtn.get()==noBtn)
        {
            alertDialog.close();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}