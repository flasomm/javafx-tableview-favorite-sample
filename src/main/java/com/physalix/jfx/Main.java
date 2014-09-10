package com.physalix.jfx;

import com.physalix.jfx.model.Contact;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Main class.
 */
public class Main extends Application {

    private static final String STYLESHEET_PATH = "/styles/styles.css";

    private TableView table = new TableView();

    private final ObservableList<Contact> data
            = FXCollections.observableArrayList(
                    new Contact("Jacob", true),
                    new Contact("Isabella", true),
                    new Contact("Ethan", true),
                    new Contact("Emma", true),
                    new Contact("Michael", true));

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        scene.getStylesheets().add(STYLESHEET_PATH);
        stage.setTitle("Table View Sample");
        stage.setWidth(300);
        stage.setHeight(500);

        Label label = new Label("My Favorite Book");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("name"));

        TableColumn favoriteCol = new TableColumn("Favorite");
        favoriteCol.setCellValueFactory(
                new PropertyValueFactory<Contact, String>("favorite"));

        table.getColumns().addAll(nameCol, favoriteCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        table.setItems(data);

        stage.setScene(scene);
        stage.show();
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
