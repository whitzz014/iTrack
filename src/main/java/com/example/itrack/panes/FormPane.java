package com.example.itrack.panes;

import com.example.itrack.MainApplication;
import com.example.itrack.Pojo.Food;
import com.example.itrack.Pojo.PersonInfo;
import com.example.itrack.Tables.PersonTable;
import com.example.itrack.database.DBConst;
import com.example.itrack.scenes.FormScene;
import com.example.itrack.tabs.TrackerTab;
import com.example.itrack.Tables.FoodTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Window;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.example.itrack.MainApplication.menu;
import static com.example.itrack.database.Const.*;

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
    private File file;





    public FormPane()  {



                //TODO->FileIO for signup & get rid of signup page
        /**
         * Records persons info into file
         * If user has already signed into the computer it will automatically go to the tracker page and display their info
         */
       File file = new File("person_info.txt");

       //signup info
        Popup popup = new Popup();
        //Fonts
        Font textFont = Font.font("Trebuchet MS", 14);
        Font titleFont = Font.font("Trebuchet MS", 18);
        Font errorFont = new Font("Times New Roman", 12);

        //Sign Up
        //Title
        Text title = new Text("Sign Up");
        title.setFont(titleFont);

        //USERNAME
        Text usernameTitle = new Text("Username: ");
        usernameTitle.setFont(textFont);

        TextField username = new TextField();
        username.setPromptText("Whitzz14");
        username.setFont(textFont);
        // String userName = username.getText();

        //HBox -- username
        HBox usernameBox = new HBox();
        usernameBox.setAlignment(Pos.CENTER);
        usernameBox.getChildren().addAll(usernameTitle,username);

        //PASSWORD
        Text passTitle = new Text("Password: ");
        passTitle.setFont(textFont);

        TextField password = new TextField();
        password.setPromptText("********");
        password.setFont(textFont);
        // String passWord = password.getText();
        //HBox -- username
        HBox passBox = new HBox();
        passBox.setAlignment(Pos.CENTER);
        passBox.getChildren().addAll(passTitle,password);

        //Name
        Text nameTitle = new Text("Name: ");
        nameTitle.setFont(textFont);

        TextField name = new TextField();
        name.setPromptText("Brock Whitson");
        name.setFont(textFont);

        //HBox for name
        HBox nameBox = new HBox();
        nameBox.setAlignment(Pos.CENTER);
        nameBox.getChildren().addAll(nameTitle,name);
        // String personName = name.getText();
        //Age
        Text ageTitle = new Text("Age: ");
        ageTitle.setFont(textFont);

        TextField age = new TextField();
        age.setPromptText("21");
        age.setFont(textFont);
        //   String personAge = age.getText();
        //HBox for name
        HBox ageBox = new HBox();
        ageBox.setAlignment(Pos.CENTER);
        ageBox.getChildren().addAll(ageTitle,age);

        //GENDER
        Text genderTitle = new Text("Gender: ");
        genderTitle.setFont(textFont);
        ComboBox<String> gender = new ComboBox();
        gender.getItems().addAll("Male", "Female");

        // String personGender = gender.getValue();

        //HBox for name
        HBox genderBox = new HBox();
        genderBox.setAlignment(Pos.CENTER);
        genderBox.getChildren().addAll(genderTitle,gender);

        //HEIGHT
        Text heightTitle = new Text("Height: ");
        heightTitle.setFont(textFont);
        TextField height = new TextField();
        height.setPromptText("190");
        height.setFont(textFont);
        Text measurement = new Text("cm");
        measurement.setFont(textFont);
        //String userHeight = height.getText();

        //HBox for name
        HBox heightBox = new HBox();
        heightBox.setAlignment(Pos.CENTER);
        heightBox.getChildren().addAll(heightTitle,height,measurement);

        //WEIGHT
        Text weightTitle = new Text("Weight: ");
        weightTitle.setFont(textFont);
        TextField weight = new TextField();
        weight.setPromptText("83");
        weight.setFont(textFont);
        Text weightMeasure = new Text("kg");
        weightMeasure.setFont(textFont);
        //  int userWeight = Integer.parseInt(weight.getText());
        //HBox for name
        HBox weightBox = new HBox();
        weightBox.setAlignment(Pos.CENTER);
        weightBox.getChildren().addAll(weightTitle,weight,weightMeasure);

        //GOAL WEIGHT
        Text goalWeightTitle = new Text("Goal Weight: ");
        goalWeightTitle.setFont(textFont);
        TextField goalWeight = new TextField();
        goalWeight.setPromptText("102");
        goalWeight.setFont(textFont);
        Text gWeightMeasure = new Text("kg");
        gWeightMeasure.setFont(textFont);
        // String userGoal = goalWeight.getText();

        //HBox for name
        HBox goalWeightBox = new HBox();
        goalWeightBox.setAlignment(Pos.CENTER);
        goalWeightBox.getChildren().addAll(goalWeightTitle,goalWeight,gWeightMeasure);

        //Button
        Button signupButton = new Button("Enter");
        signupButton.setOnAction(e-> {
            try {
                PrintWriter signup = new PrintWriter("person_info.txt");
                signup.println(name.getText());
                signup.println(age.getText());
                signup.println(gender.getValue());
                signup.println(height.getText());
                signup.println(weight.getText());
                signup.println(goalWeight.getText());
                signup.close();
            } catch (IOException ex) {
                System.err.println("Error writing to " + file.getName() + ": " + ex.getMessage());
            }

        });
        //VBox for info
        VBox signUpBox = new VBox();
        signUpBox.setAlignment(Pos.CENTER);
        signUpBox.getChildren().addAll(title,usernameBox, passBox, nameBox,ageBox, genderBox, heightBox,weightBox,goalWeightBox, signupButton);



        /**
         * checks to see if file is empty
         * if it is empty it displays a pop window for the user to input info
         * when the signup button is clicked the users info is inputted to `person_info.txt`
         * If user is already filled out it is sends the user to tracker tab and displays all the info
         */
       if (file.length() == 0){

       }

//       if (file.exists()){
//           System.out.println("FILE EXISTS!");
//        }else{
//           System.out.println("FILE DOESNT EXIST!");
//       }






        // Create a GridPane for food tracking
        GridPane gridPane = createGridPane();

        // Add the GridPane to the center of the BorderPane
        //testing out tabs
    TabPane tabPane = new TabPane();

       VBox navOrder = new VBox();
       navOrder.getChildren().addAll(menu, tabPane);


       // Create tabs and add them to the TabPane
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
        //PersonTable personTable = new PersonTable();
        Tab personTab = new Tab("Personal Info");
//        ArrayList<PersonInfo> persons = personTable.getAllPersonInfo();
//        for (PersonInfo person : persons) {
//            Text nameText = new Text("Name: " + person.getName());
//            Text ageText = new Text("Age: " + person.getAge());
//            Text genderText = new Text("Gender: " + person.getGender());
//            Text heightText = new Text("Height: " + person.getHeight());
//            Text weightText = new Text("Weight: " + person.getWeight());
//            Text goalWeightText = new Text("Goal Weight: " + person.getGoalWeight());

        //display info on personTab
        String[] info = readPersonInfo();
        Label nameLabel = new Label( info[0]);
        Label ageLabel = new Label(info[1]);
        Label genderLabel = new Label(info[2]);
        Label heightLabel = new Label(info[3]);
        Label weightLabel = new Label(info[4]);
        Label goalWeightLabel = new Label(info[5]);


            VBox vbox = new VBox();
            vbox.getChildren().addAll(nameLabel,ageLabel,genderLabel,heightLabel,weightLabel,goalWeightLabel);
            personPane.setCenter(vbox);
            personTab.setContent(personPane);
            personTab.setClosable(false);


        // Weekly tab
        Tab weeklyTab = new Tab("Weekly Report");



        // Create a TabPane
        tabPane.getTabs().addAll(personTab, addItemTab, weeklyTab);

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
        addButton.setOnAction(e->{
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/"+ DB_NAME +
                                "?serverTimezone=UTC",
                        DB_USER,
                        DB_PASS);){
                String insertQuery = "INSERT INTO " + DBConst.TABLE_MEAL + " (" +
                        DBConst.MEAL_COLUMN_NAME + ", " +
                        DBConst.MEAL_COLUMN_CALORIES + ", " +
                        DBConst.MEAL_COLUMN_PROTEIN + ", " +
                        DBConst.MEAL_COLUMN_FAT + ", " +
                        DBConst.MEAL_COLUMN_CARBS + ", " +
                        DBConst. MEAL_COLUMN_TIMESTAMP +
                        ") VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";

                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    // Set values for the parameters
                    String selectedMeal = String.valueOf(foodComboBox.getSelectionModel().getSelectedItem());
//                    preparedStatement.setString(1, );
//                    preparedStatement.setInt(2, valueForCalories);
//                    preparedStatement.setInt(3, valueForProtein);
//                    preparedStatement.setInt(4, valueForFat);
//                    preparedStatement.setInt(5, valueForCarbs);

                    // Execute the query
                    preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }});
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

    private String[] readPersonInfo(){
        String[] info = new String[6];
        try (BufferedReader br = new BufferedReader(new FileReader("person_info.txt"))) {
            info[0] = "Name: " + br.readLine().trim();
            info[1] = "Age: " + br.readLine().trim();
            info[2] = "Gender: " + br.readLine().trim();
            info[3] = "Height: " + br.readLine().trim();
            info[4] = "Weight: " + br.readLine().trim();
            info[5] = "Goal Weight: " + br.readLine().trim();
        }catch(IOException e){
            e.printStackTrace();
        }
        return info;
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
