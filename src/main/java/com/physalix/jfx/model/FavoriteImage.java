package com.physalix.jfx.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Favorite image model class.
 * 
 * @author Fabrice Sommavilla <fs@physalix.com>
 */
public class FavoriteImage {

    private final SimpleStringProperty favoriteImage = new SimpleStringProperty();

    /**
     * Constructor.
     *
     * @param imagePath
     */
    public FavoriteImage(String imagePath) {
        setFavoriteImage(imagePath);
    }

    /**
     * @param favoriteImageFile
     */
    public void setFavoriteImage(String favoriteImageFile) {
        favoriteImage.set(favoriteImageFile);
    }

    /**
     * @return
     */
    public String getFavoriteImage() {
        return favoriteImage.get();
    }
}
