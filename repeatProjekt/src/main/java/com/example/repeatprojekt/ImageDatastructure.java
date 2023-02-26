package com.example.repeatprojekt;

import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImageDatastructure{
    private String extension;
    private String name;
    private File file;
    public ImageDatastructure(File filePath){
       this.file = filePath;
    }
    public String getPath(){
        return file.getPath();
    }
    public String getName(){
        return file.getName();
    }
    public String getExtension(){
        return file.toString().split("\\.")[file.toString().split("\\.").length -1];
    }

    public void loadToImageViews(ImageView imageView){
        Image image = null;
        try {
            image = new Image(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            System.out.println("Not an Image File");
            return;
        }
        imageView.setImage(image);
    }
    public void addToComboBox(ComboBox comboBox){
        //comboBox.getItems().add(    );
    }
}
