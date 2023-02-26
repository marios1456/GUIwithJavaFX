package com.example.repeatprojekt;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class MyFotoViewer extends Application {
    private TextField activFilters;
    private Image image;
    private Stage globalStage;
    private ImageView rightImage;
    private ImageView leftImage;
    private ArrayList<ImageDatastructure> loadedImages = new ArrayList();
    private ComboBox combo;

    @Override
    public void start(Stage stage){
        globalStage = stage;
        BorderPane bp = new BorderPane();

        // Top, Menu
        VBox topBox = new VBox();
        MenuBar menuBar = new MenuBar();

        Menu file = fileMenu();
        Menu filters = filtersMenu();
        Menu about = aboutMenu();

        menuBar.getMenus().addAll(file,filters,about);
        //bp.setTop(menuBar);

        // Top ComboBox
        HBox comboBoxContainer = new HBox();
        Label comboLabel = new Label("Images:  ");
        combo = new ComboBox<>();
        combo.getItems().addAll("default.jpg");
        comboBoxContainer.getChildren().addAll(comboLabel,combo);
        comboBoxContainer.setAlignment(Pos.CENTER);

        topBox.getChildren().addAll(menuBar,comboBoxContainer);
        bp.setTop(topBox);
        // Center

        HBox center = new HBox();
        loadedImages.add(new ImageDatastructure(new File("src\\main\\resources\\com\\images\\default.jpg")));
        combo.getItems().addAll("default.jpg");
        VBox leftVBox = new VBox();
        leftImage = new ImageView();
        loadedImages.get(0).loadToImageViews(leftImage);
        Label original = new Label("Original");
        leftVBox.getChildren().addAll(leftImage,original);
        leftVBox.setAlignment(Pos.CENTER);

        VBox rightVBox = new VBox();
        rightImage = new ImageView();
        loadedImages.get(0).loadToImageViews(rightImage);
        Label preview = new Label("Preview");
        rightVBox.getChildren().addAll(rightImage,preview);
        rightVBox.setAlignment(Pos.CENTER);



        center.getChildren().addAll(leftVBox,rightVBox);
        bp.setCenter(center);


        // Bottom
        HBox bottom = new HBox();
        CheckBox activAllFilters = new CheckBox("activate all filters");
        activAllFilters.setOnAction(e->{
            // add All Filters
            if (activAllFilters.isSelected()){
                activFilters.setText("");
                for (int i = 0; i < filters.getItems().size(); i++){
                    ((CheckMenuItem)filters.getItems().get(i)).setSelected(true);
                    activFilters.appendText(filters.getItems().get(i).getText() + ", ");
                }
            }else { // remove all filters
                for (int i = 0; i < filters.getItems().size(); i++){
                    ((CheckMenuItem)filters.getItems().get(i)).setSelected(false);
                    activFilters.setText("");
                }
            }

        });
        Button random = new Button("Random");
        activFilters = new TextField();
        activFilters.setEditable(false);


        bottom.getChildren().addAll(activAllFilters,random,activFilters);
        bottom.setAlignment(Pos.CENTER);
        bottom.setSpacing(5);
        bp.setBottom(bottom);


        Scene scene = new Scene(bp,1000,367);
        stage.setScene(scene);
        stage.show();

        leftImage.setFitHeight(200);
        leftImage.setFitWidth(500);
        rightImage.setFitHeight(200);
        rightImage.setFitWidth(500);

        scene.heightProperty().addListener((obs,old,n)->{
            leftImage.setFitHeight(scene.getHeight()-67);
            rightImage.setFitHeight(scene.getHeight()-67);
        });
        scene.widthProperty().addListener((obs,old,n)->{
            leftImage.setFitWidth(scene.getWidth()/2);
            rightImage.setFitWidth(scene.getWidth()/2);
        });


        loadedImages.add(new ImageDatastructure(new File("src\\main\\resources\\com\\images\\default.jpg")));
    }

    private Menu fileMenu(){
        Menu file = new Menu("_File");
        MenuItem loadFile = new MenuItem("Load File");
        loadFile.setOnAction(e->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Image File");

            ImageDatastructure imDS = new ImageDatastructure(fileChooser.showOpenDialog(globalStage));

            imDS.loadToImageViews(leftImage);
            imDS.loadToImageViews(rightImage);

            loadedImages.add(imDS);

        });
        MenuItem exit = new MenuItem("Exit");
        file.getItems().addAll(loadFile,exit);
        return file;
    }

    private Menu filtersMenu(){
        Menu filters = new Menu("Filters");
        String[] menuItems = {"Blur", "BoxBlur", "MotionBlur", "Contrast", "Sepia", "Bloom", "Glow"};

        for (int i = 0; i < menuItems.length; i++){
            CheckMenuItem temp = new CheckMenuItem(menuItems[i]);
            temp.setOnAction(e->{
                if (temp.isSelected()){
                    activFilters.appendText(temp.getText() + ", ");
                }else {
                    activFilters.setText("");
                    for (int j = 0; j < filters.getItems().size(); j++){
                        if (((CheckMenuItem)filters.getItems().get(j)).isSelected()){
                            activFilters.appendText(temp.getText() + ", ");
                        }
                    }
                }
            });
            filters.getItems().add(temp);
        }
        return filters;
    }
    private Menu aboutMenu(){
        Menu about = new Menu("About");
        MenuItem help = new MenuItem("Help");
        about.getItems().add(help);
        return about;
    }
}
