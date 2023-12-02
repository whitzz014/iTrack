package com.example.itrack.panes;

import com.example.itrack.MainApplication;
import com.example.itrack.Pojo.Food;

import com.example.itrack.Pojo.MealItem;
import com.example.itrack.database.DBConst;
import com.example.itrack.math.CalCalc;
import com.example.itrack.scenes.SignupScene;
import com.example.itrack.tabs.MealsTab;
import com.example.itrack.tabs.TrackerTab;
import com.example.itrack.Tables.FoodTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.*;
import java.sql.*;
import java.util.Optional;

import static com.example.itrack.MainApplication.menu;
import static com.example.itrack.database.Const.*;

public class FormPane extends BorderPane {

    private ComboBox<Food> foodComboBox;
    private TextField caloriesTextField;
    private TextField proteinTextField;
    private TextField fatTextField;
    private TextField carbsTextField;
    private Text error;
    private double bmiCalculator;
    private CalCalc calCalc;

    private  double personHeight;
    private int personWeight;


    PieChart macroChart = new PieChart();
    PieChart totalMacroChart = new PieChart();
    TableView<MealItem> mealTable = createMealTable();

//dubles for total macros
    private double tprotein = 0;
    private double tfat = 0;
    private double tcarbs = 0;


    public FormPane()  {



                //TODO->FileIO for signup & get rid of signup page
        /**
         * Records persons info into file
         * If user has already signed into the computer it will automatically go to the tracker page and display their info
         */
       File file = new File("person_info.txt");


        //Fonts
        Font textFont = Font.font("Trebuchet MS", 14);
        Font titleFont = Font.font("Trebuchet MS", 18);
        Font errorFont = new Font("Times New Roman", 12);


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
        GridPane mealsGrid = createMealsGrid();
        MealsTab mealsTab = MealsTab.getInstance();
        mealsTab.setClosable(false);
        mealsTab.setContent(mealsGrid);

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

        String[] info = readPersonInfo();
        Text nameLabel = new Text("Name: " + info[0]);
        Text ageLabel = new Text("Age: " + info[1]);
        Text genderLabel = new Text("Gender: " + info[2]);
        Text heightLabel = new Text("Height: " + info[3]);
        Text weightLabel = new Text("Weight: " + info[4]);
        Text goalWeightLabel = new Text("Goal Weight: " + info[5]);
        Text activityText = new Text("Activity: " + info[6]);


        String[] measurements = readMeasurements();

//converts feet to cm
        if ("Feet".equals(measurements[1].trim())){
            feetToCm();
        }
//converts lbs to kg
        if ("lbs".equals(measurements[0].trim())){
            lbsToKg();
        }

        //   System.out.println("height in cm: " + personHeight);

        bmiCalculator = personWeight / ((personHeight / 100.0) * (personHeight / 100.0));
         String fitLevel = "";
         String formatBMI = String.format("%.2f", bmiCalculator);
        Text bmiLabel;

        if (bmiCalculator <= 18.5){
            fitLevel = "Underweight";
        } else if (bmiCalculator >= 25 && bmiCalculator <= 29.9) {
            fitLevel = "Overweight";
        }else if ((bmiCalculator >= 30)){
            if (bmiCalculator < 34.9){
                fitLevel = "Class I (Moderate) Obesity";
            } else if (bmiCalculator >= 35 && bmiCalculator < 40) {
                fitLevel = "Class II (Severe) Obesity";
            } else if (bmiCalculator >= 40) {
                fitLevel = "Class III (Very Severe or Morbid) Obesity";
            }
        }else{
            fitLevel = "Normal Weight";
        }

        bmiLabel = new Text("BMI: " + formatBMI + " : " + fitLevel);

        if (bmiCalculator <= 18.5){
            bmiLabel.setFill(Color.ORANGERED);
        } else if (bmiCalculator >= 25 && bmiCalculator <= 29.9) {
            bmiLabel.setFill(Color.RED);
        }else if ((bmiCalculator >= 30)){
            bmiLabel.setFill(Color.DARKRED);
        }else{
            bmiLabel.setFill(Color.GREEN);
        }

        //cal intake calc
        calCalc = new CalCalc(Integer.parseInt(info[1]),info[2], Double.parseDouble(info[3]), Double.parseDouble(info[4]),Double.parseDouble(info[5]), info[6]);
        String totalCals = String.valueOf(calCalc.getTotalCal());
        Text calIntake =new Text("Calories Needed: " + totalCals);


        Button deleteButton = new Button("DELETE");

        Button updateButton = new Button("UPDATE");
        updateButton.setOnAction(e->{
            MainApplication.mainStage.setScene(new SignupScene());
            MainApplication.mainStage.setTitle("Update Info");
        });



            VBox vbox = new VBox();
            vbox.setAlignment(Pos.CENTER);
            vbox.getChildren().addAll(nameLabel,ageLabel,genderLabel,heightLabel,weightLabel,goalWeightLabel, activityText, calIntake, bmiLabel,updateButton, deleteButton);
            personPane.setCenter(vbox);
            personTab.setContent(personPane);
            personTab.setClosable(false);

        deleteButton.setOnAction(e->{
            if(file.length() == 0){
                error = new Text("THERE IS NO INFO TO DELETE");
                vbox.getChildren().add(error);
            }else{
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("person_info.txt"));
                    writer.write("");
                    writer.close();
                    MainApplication.mainStage.setScene(new SignupScene());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        // Weekly tab
        Tab weeklyTab = new Tab("Weekly Report");
        int weeklyCals = calCalc.getTotalCal();
        int consumedCals = intakeCalories();
        int proteinNeeded = recProteinAmount();
        int fatsNeed = recFatAmount();
        int carbsNeed = recCarbAmount();

        System.out.println("Calories: " + weeklyCals + "\nProtein: " + proteinNeeded + "\nFats: " + fatsNeed + "\nCarbs: " + carbsNeed);
        System.out.println(consumedCals);

        // Create a TabPane
        tabPane.getTabs().addAll(personTab, addItemTab,mealsTab, weeklyTab);

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
            insertFoodIntoMeals();

            updateMacroChart();

            updateTotalMacros();
});
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

        //make pi chart
//        Text hello = new Text("hello world");
//        gridPane.add(hello, 0, 6);

        macroChart.setTitle("Macro Distribution");

        // Add components to the GridPane
        gridPane.add(macroChart, 2, 0, 2, 6);



        return gridPane;
    }

    private String[] readPersonInfo(){
        String[] info = new String[7];
        try (BufferedReader br = new BufferedReader(new FileReader("person_info.txt"))) {
            info[0] = br.readLine().trim(); //name
            info[1] = br.readLine().trim();//age
            info[2] = br.readLine().trim();//gender
            info[3] = br.readLine().trim();//height
            info[4] = br.readLine().trim();//weight
            info[5] = br.readLine().trim();//goal weight
            info[6] = br.readLine().trim();//activity level

            try {
                personHeight = Double.parseDouble(info[3]);
                System.out.println(personHeight);
            } catch (NumberFormatException e) {
                // Handle the case where height is not a valid double
                System.out.println("Error: Invalid height format in person_info.txt");
                personHeight = 0; // Set a default value or take appropriate action
            }

            // Convert weight to an integer value
            try {
                personWeight = Integer.parseInt(info[4]);
                System.out.println(personWeight);
            } catch (NumberFormatException e) {
                // Handle the case where weight is not a valid integer
                System.out.println("Error: Invalid weight format in person_info.txt");
                personWeight = 0; // Set a default value or take appropriate action
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return info;
    }
    private String[] readMeasurements(){
        String[] measurements = new String[2];
        try ( BufferedReader measurementReader = new BufferedReader(new FileReader("measurements.txt"))) {
            measurements[0] = measurementReader.readLine().trim();
            measurements[1] = measurementReader.readLine().trim();
        }catch (IOException e){
            e.printStackTrace();
        }
        return measurements;
    }


    //hello


    private double feetToCm(){
        //calcs just feet
        int feetOnly = (int) personHeight;
        //takes just the inches
        double inchesPart = (personHeight - feetOnly) * 100;
        //  System.out.println("IN: " + inchesPart);
        double heightCm = feetOnly * 30.48;
        heightCm += inchesPart * 2.54;
        personHeight = heightCm;
        return personHeight;
    }

    private int lbsToKg(){
        double  weightKg = personWeight * 0.453592;
        personWeight = (int) weightKg;
        return personWeight;
    }

private GridPane createMealsGrid() {
    GridPane gridPane = new GridPane();
    // Load data for the current day from the database
    ObservableList<MealItem> mealsForCurrentDay = loadMealsForCurrentDay();

    // Set up the TableView
    mealTable.setItems(mealsForCurrentDay);

    totalMacroChart.setTitle("Total Macro Distribution");

    // Add components to the GridPane
    gridPane.add(mealTable, 0, 0);
    gridPane.add(totalMacroChart, 2, 0, 2, 6);

    return gridPane;
}
    private ObservableList<MealItem> loadMealsForCurrentDay() {
        ObservableList<MealItem> meals = FXCollections.observableArrayList();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" + DB_NAME +
                        "?serverTimezone=UTC",
                DB_USER,
                DB_PASS)) {

            String selectQuery = "SELECT * FROM " + DBConst.TABLE_MEAL +
                    " WHERE DATE(" + DBConst.MEAL_COLUMN_TIMESTAMP + ") = CURDATE()";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    String foodName = resultSet.getString(DBConst.MEAL_COLUMN_NAME);
                    double calories = resultSet.getDouble(DBConst.MEAL_COLUMN_CALORIES);
                    double protein = resultSet.getDouble(DBConst.MEAL_COLUMN_PROTEIN);
                    double fat = resultSet.getDouble(DBConst.MEAL_COLUMN_FAT);
                    double carbs = resultSet.getDouble(DBConst.MEAL_COLUMN_CARBS);

                    // Create a new MealItem
                    MealItem mealItem = new MealItem(foodName, calories, protein, fat, carbs);

                    // Add the MealItem to the list
                    meals.add(mealItem);
                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return meals;
    }

    private TableView<MealItem> createMealTable() {
        TableView<MealItem> table = new TableView<>();

        TableColumn<MealItem, String> nameColumn = new TableColumn<>("Food Name");
        TableColumn<MealItem, Double> caloriesColumn = new TableColumn<>("Calories");
        TableColumn<MealItem, Double> proteinColumn = new TableColumn<>("Protein");
        TableColumn<MealItem, Double> fatColumn = new TableColumn<>("Fat");
        TableColumn<MealItem, Double> carbsColumn = new TableColumn<>("Carbs");
        TableColumn<MealItem, Void> actionColumn = new TableColumn<>("Actions");

        // Set cell value factories
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        caloriesColumn.setCellValueFactory(new PropertyValueFactory<>("calories"));
        proteinColumn.setCellValueFactory(new PropertyValueFactory<>("protein"));
        fatColumn.setCellValueFactory(new PropertyValueFactory<>("fat"));
        carbsColumn.setCellValueFactory(new PropertyValueFactory<>("carbs"));

        // Create a cell factory for the action column
        actionColumn.setCellFactory(param -> new TableCell<>() {
            private final Button updateButton = new Button("Update");
            private final Button deleteButton = new Button("Delete");

            {
                // Set actions for the buttons
                updateButton.setOnAction(event -> {
                    MealItem mealItem = getTableView().getItems().get(getIndex());
                    // Call a method to handle the update logic
                    updateMealItem(mealItem);



                });

                deleteButton.setOnAction(event -> {
                    MealItem mealItem = getTableView().getItems().get(getIndex());
                    // Call a method to handle the delete logic
                    deleteMealItem(mealItem);

                   deleteTotalMacros(mealItem);

                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);

                if (empty) {
                    setGraphic(null);
                } else {
                    HBox buttons = new HBox(updateButton, deleteButton);
                    buttons.setSpacing(5);
                    setGraphic(buttons);
                }
            }
        });

        table.getColumns().addAll(nameColumn, caloriesColumn, proteinColumn, fatColumn, carbsColumn, actionColumn);

        return table;
    }

    private void updateMealItem(MealItem mealItem) {

    }

    private void deleteMealItem(MealItem mealItem) {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Delete Confirmation");
        confirmationDialog.setHeaderText(null);
        confirmationDialog.setContentText("Are you sure you want to delete this item?");

        Optional<ButtonType> result = confirmationDialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            // User confirmed deletion
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" + DB_NAME +
                            "?serverTimezone=UTC",
                    DB_USER,
                    DB_PASS);) {

                String deleteQuery = "DELETE FROM " + DBConst.TABLE_MEAL + " WHERE " +
                        DBConst.MEAL_COLUMN_NAME + " = ? AND " +
                        DBConst.MEAL_COLUMN_CALORIES + " = ? AND " +
                        DBConst.MEAL_COLUMN_PROTEIN + " = ? AND " +
                        DBConst.MEAL_COLUMN_FAT + " = ? AND " +
                        DBConst.MEAL_COLUMN_CARBS + " = ?";

                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    // Set values for the parameters
                    preparedStatement.setString(1, mealItem.getFoodName());
                    preparedStatement.setDouble(2, mealItem.getCalories());
                    preparedStatement.setDouble(3, mealItem.getProtein());
                    preparedStatement.setDouble(4, mealItem.getFat());
                    preparedStatement.setDouble(5, mealItem.getCarbs());

                    // Execute the query
                    preparedStatement.executeUpdate();

                    // Remove the item from the table
                    mealTable.getItems().remove(mealItem);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    private void updateMacroChart() {
        double calories = Double.parseDouble(caloriesTextField.getText());
        double protein = Double.parseDouble(proteinTextField.getText());
        double fat = Double.parseDouble(fatTextField.getText());
        double carbs = Double.parseDouble(carbsTextField.getText());

        macroChart.getData().clear(); // Clear existing data

        macroChart.getData().add(new PieChart.Data("Protein", protein));
        macroChart.getData().add(new PieChart.Data("Fat", fat));
        macroChart.getData().add(new PieChart.Data("Carbs", carbs));
    }

    private void updateTotalMacros() {
//        double calories = Double.parseDouble(caloriesTextField.getText());

        tprotein += Double.parseDouble(proteinTextField.getText());
        tfat += Double.parseDouble(fatTextField.getText());
        tcarbs += Double.parseDouble(carbsTextField.getText());

        totalMacroChart.getData().clear(); // Clear existing data

        totalMacroChart.getData().add(new PieChart.Data("Protein", tprotein));
        totalMacroChart.getData().add(new PieChart.Data("Fat", tfat));
        totalMacroChart.getData().add(new PieChart.Data("Carbs", tcarbs));
    }
    private void deleteTotalMacros(MealItem meals) {


        tprotein -= meals.getProtein();
        tfat -= meals.getFat();
        tcarbs -= meals.getCarbs();

//        totalMacroChart.getData().clear(); // Clear existing data

        totalMacroChart.getData().remove(new PieChart.Data("Protein", meals.getProtein()));
        totalMacroChart.getData().remove(new PieChart.Data("Fat", meals.getFat()));
        totalMacroChart.getData().remove(new PieChart.Data("Carbs", meals.getCarbs()));

        totalMacroChart.getData().clear(); // Clear existing data


        totalMacroChart.getData().add(new PieChart.Data("Protein", tprotein));
        totalMacroChart.getData().add(new PieChart.Data("Fat", tfat));
        totalMacroChart.getData().add(new PieChart.Data("Carbs", tcarbs));
    }


    private void insertFoodIntoMeals() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" + DB_NAME +
                        "?serverTimezone=UTC",
                DB_USER,
                DB_PASS);) {

            String insertQuery = "INSERT INTO " + DBConst.TABLE_MEAL + " (" +
                    DBConst.MEAL_COLUMN_NAME + ", " +
                    DBConst.MEAL_COLUMN_CALORIES + ", " +
                    DBConst.MEAL_COLUMN_PROTEIN + ", " +
                    DBConst.MEAL_COLUMN_FAT + ", " +
                    DBConst.MEAL_COLUMN_CARBS + ", " +
                    DBConst.MEAL_COLUMN_TIMESTAMP +
                    ") VALUES (?, ?, ?, ?, ?, CURRENT_TIMESTAMP)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Set values for the parameters
                String selectedFoodName = String.valueOf(foodComboBox.getSelectionModel().getSelectedItem().getName());
                double selectedCalories = Double.parseDouble(caloriesTextField.getText());
                double selectedProtein = Double.parseDouble(proteinTextField.getText());
                double selectedFat = Double.parseDouble(fatTextField.getText());
                double selectedCarbs = Double.parseDouble(carbsTextField.getText());

                preparedStatement.setString(1, selectedFoodName);
                preparedStatement.setDouble(2, selectedCalories);
                preparedStatement.setDouble(3, selectedProtein);
                preparedStatement.setDouble(4, selectedFat);
                preparedStatement.setDouble(5, selectedCarbs);

                // Execute the query
                preparedStatement.executeUpdate();

                // Create a new MealItem
                MealItem mealItem = new MealItem(selectedFoodName, selectedCalories, selectedProtein, selectedFat, selectedCarbs);

                // Add the MealItem to the TableView
                mealTable.getItems().add(mealItem);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    private int intakeCalories(){
        TableView<MealItem> table = new TableView<MealItem>();
        int calsIntaked = 0;

        for (MealItem mealItem : table.getItems()){
            calsIntaked += mealItem.getCalories();
        }
        return calsIntaked;

    }
     private int proteinIntake(){
         TableView<MealItem> table = new TableView<MealItem>();
         int proteinIntake = 0;

         for (MealItem mealItem : table.getItems()){
             proteinIntake += mealItem.getCalories();
         }
         return proteinIntake;
     }
     private int fatIntake(){
         TableView<MealItem> table = new TableView<MealItem>();
         int fatIntake = 0;

         for (MealItem mealItem : table.getItems()){
             fatIntake += mealItem.getCalories();
         }
         return fatIntake;
     }
     private int carbsIntake(){
         TableView<MealItem> table = new TableView<MealItem>();
         int carbsIntake = 0;

         for (MealItem mealItem : table.getItems()){
             carbsIntake += mealItem.getCalories();
         }
         return carbsIntake;
     }

     private int recProteinAmount(){
         return (int) ((0.25 * calCalc.getTdee())/4);
     }
     private int recCarbAmount() {
         return (int) ((0.50 * calCalc.getTdee()) / 4);
     }
     private int recFatAmount(){
            return (int) ((0.25 * calCalc.getTdee()) / 9);
         }
     }



