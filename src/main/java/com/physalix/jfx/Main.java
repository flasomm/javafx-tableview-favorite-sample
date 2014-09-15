package com.physalix.jfx;

import com.physalix.jfx.model.Contact;
import com.physalix.jfx.model.FavoriteImage;
import com.physalix.jfx.model.ImageClickCellFactory;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Main class.
 *
 * @author Fabrice Sommavilla <fs@physalix.com>
 */
public class Main extends Application {

    private static final String STYLESHEET_PATH = "/styles/styles.css";

    private ObservableList<Contact> dataList;

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        scene.getStylesheets().add(STYLESHEET_PATH);
        stage.setTitle("Table View Favorite Sample");
        stage.setWidth(300);
        stage.setHeight(500);

        dataList = FXCollections.observableArrayList(
                new Contact("Jacob", true),
                new Contact("Isabella", true),
                new Contact("Ethan", true),
                new Contact("Emma", true),
                new Contact("Michael", true));

        TableView table = new TableView();
        table.setEditable(true);

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setPrefWidth(90);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("name"));

        TableColumn favoriteCol = new TableColumn("Favorite");
        favoriteCol.setPrefWidth(90);
        favoriteCol.setCellValueFactory(
                new PropertyValueFactory<Contact, FavoriteImage>("favoriteImage"));

        ImageClickCellFactory cellFactory
                = new ImageClickCellFactory(
                        new CreateFavoriteClickMouseEventHandler());

        favoriteCol.setCellFactory(cellFactory);
        
        table.getColumns().addAll(nameCol, favoriteCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().add(table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        table.setItems(dataList);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * Simple class to handle mouse's click event.
     */
    private class CreateFavoriteClickMouseEventHandler
            implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            if (event.getClickCount() == 1) {

                try {
                    Contact contact = dataList.get(
                            ((TableCell) event.getSource()).getIndex());

                    if (contact.getFavorite()) {
                        contact.setFavorite(Boolean.FALSE);
                        contact.hasFavoriteImage(Boolean.FALSE);

                    } else {
                        contact.setFavorite(Boolean.TRUE);
                        contact.hasFavoriteImage(Boolean.TRUE);
                    }

                    // do something here...
                    
                } catch (IndexOutOfBoundsException e) {
                }
            }
        }
    }

    // ---------- ---------- ---------- ---------- ----------
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
