package com.physalix.jfx.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author fabrice
 */
public class Contact {

    private final StringProperty nameProperty = new SimpleStringProperty();
    
    private final ObjectProperty<FavoriteImage> favoriteImageProperty
            = new SimpleObjectProperty();
    
    
    private final String BOOKMARK_IMG = "/images/valid.png";

    /**
     * 
     * @param name
     * @param favorite 
     */
    public Contact(String name, boolean favorite) {
        setName(name);
    }            
            
    /**
     * @return the favoriteImageProperty
     */
    public Object getFavoriteImage() {
        return this.favoriteImageProperty.get();
    }

    /**
     * @return the favoriteImageProperty
     */
    public ObjectProperty<FavoriteImage> favoriteImageProperty() {
        return favoriteImageProperty;
    }

    /**
     * @param favoriteImage the favoriteImage to set
     */
    public void setFavoriteImage(FavoriteImage favoriteImage) {
        this.favoriteImageProperty.set(favoriteImage);
    }

    /**
     * Update the favorite image if cell selected.
     *
     * @param image
     */
    public void hasFavoriteImage(boolean image) {
        if (image) {
            setFavoriteImage(new FavoriteImage(BOOKMARK_IMG));
        } else {
            setFavoriteImage(null);
        }
    }    
    
    /**
     * Getter for the name's value.
     *
     * @return
     */
    public final String getName() {
        return nameProperty.get();
    }

    /**
     * Setter for the name's value.
     *
     * @param name
     */
    public final void setName(String name) {
        this.nameProperty.set(name);
    }

    /**
     * Getter for the property name itself.
     *
     * @return
     */
    public StringProperty textProperty() {
        return nameProperty;
    }    
}
