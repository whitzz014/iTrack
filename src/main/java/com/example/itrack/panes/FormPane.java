package com.example.itrack.panes;

import com.example.itrack.Pojo.Food;
import com.example.itrack.Pojo.PersonInfo;
import com.example.itrack.Tables.PersonTable;
import com.example.itrack.tabs.TrackerTab;
import com.example.itrack.Tables.FoodTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;

import static com.example.itrack.MainApplication.menu;

public class FormPane extends BorderPane {

    private ComboBox<Food> foodComboBox;
    private TextField caloriesTextField;
    private TextField proteinTextField;
    private TextField fatTextField;
    private TextField carbsTextField;
    private Text nameText;
    private Text ageText;
    private Text genderText;
    private Text heightText;
    private Text weightText;
    private Text goalWeightText;



    public FormPane() {
        // Create a GridPane for food tracking
        GridPane gridPane = createGridPane();

        // Add the GridPane to the center of the BorderPane
        //testing out tabs

        TabPane tabPane = new TabPane();

       VBox navOrder = new VBox();
       navOrder.getChildren().addAll(menu, tabPane);

//
//        // Create tabs and add them to the TabPane
       TrackerTab addItemTab = TrackerTab.getInstance();
        addItemTab.setClosable(false);
        addItemTab.setContent(gridPane);
//        Tab anotherTab = new Tab("Another Tab");

        //Fill Tracker Tab with info

        // Populate foodComboBox with data from the FoodTable
        FoodTable foodTable = new FoodTable();
        ObservableList<Food> foodList = FXCollections.observableArrayList(foodTable.getAllFoods());
        foodComboBox.setItems(foodList);

        // Set up event handler for foodComboBox selection
        foodComboBox.setOnAction(event -> {
            Food selectedFood = foodComboBox.getValue();
            if (selectedFood != null) {
                // Set the macros based on the selected food
                caloriesTextField.setText(String.valueOf(selectedFood.getCalories()));
                proteinTextField.setText(String.valueOf(selectedFood.getProtein()));
                fatTextField.setText(String.valueOf(selectedFood.getFat()));
                carbsTextField.setText(String.valueOf(selectedFood.getCarbs()));
            }
        });

        //Create Person Info
        BorderPane personPane = new BorderPane();
        PersonTable personTable = new PersonTable();
        Tab personTab = new Tab("Personal Info");
        ArrayList<PersonInfo> persons = personTable.getAllPersonInfo();
        for (PersonInfo person : persons) {
            Text nameText = new Text("Name: " + person.getName());
            Text ageText = new Text("Age: " + person.getAge());
            Text genderText = new Text("Gender: " + person.getGender());
            Text heightText = new Text("Height: " + person.getHeight());
            Text weightText = new Text("Weight: " + person.getWeight());
            Text goalWeightText = new Text("Goal Weight: " + person.getGoalWeight());

            VBox vbox = new VBox();
            vbox.getChildren().addAll(nameText,ageText,genderText,heightText,weightText,goalWeightText);
            personPane.setCenter(vbox);
            personTab.setContent(personPane);
            personTab.setClosable(false);
       }


        // Create a TabPane
        tabPane.getTabs().addAll(personTab, addItemTab);

        // Add the TabPane to the bottom of the BorderPane


        // Add menu
        this.setTop(navOrder);
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        // Create labels
        Label foodLabel = new Label("Food:");
        Label caloriesLabel = new Label("Calories:");
        Label proteinLabel = new Label("Protein:");
        Label fatLabel = new Label("Fat:");
        Label carbsLabel = new Label("Carbs:");

        // Create text fields
        foodComboBox = new ComboBox<>();
        caloriesTextField = new TextField();
        proteinTextField = new TextField();
        fatTextField = new TextField();
        carbsTextField = new TextField();

        // Create a button for adding the food to the database
        Button addButton = new Button("Add Food");

        // Add components to the GridPane
        gridPane.add(foodLabel, 0, 0);
        gridPane.add(foodComboBox, 1, 0);
        gridPane.add(caloriesLabel, 0, 1);
        gridPane.add(caloriesTextField, 1, 1);
        gridPane.add(proteinLabel, 0, 2);
        gridPane.add(proteinTextField, 1, 2);
        gridPane.add(fatLabel, 0, 3);
        gridPane.add(fatTextField, 1, 3);
        gridPane.add(carbsLabel, 0, 4);
        gridPane.add(carbsTextField, 1, 4);
        gridPane.add(addButton, 1, 5);

        return gridPane;
    }

//    private TabPane createTabPane() {
//        TabPane tabPane = new TabPane();
//
//        // Create tabs and add them to the TabPane
//        TrackerTab addItemTab = TrackerTab.getInstance();
//        addItemTab.setClosable(false);
//
//        Tab anotherTab = new Tab("Another Tab");
//        // Add content to the additional tabs as needed
//        tabPane.getTabs().addAll(addItemTab, anotherTab);
//
//        return tabPane;
//    }
    //hello
}
