package com.lab.lab_ta;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import soluteinter.Sortingtype;
import sortpack.Buble;
import sortpack.Insertion;

import java.util.Arrays;

public class HelloApplication extends Application {
    private LineChart<Number, Number> lineChart;
    private XYChart.Series<Number, Number> bubbleSeries;
    private XYChart.Series<Number, Number> insertionSeries;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sorting Algorithms Performance");
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Elements");
        yAxis.setLabel("Time (nanoseconds)");
        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Sorting Algorithms Performance");
        bubbleSeries = new XYChart.Series<>();
        bubbleSeries.setName("Bubble Sort Time");
        insertionSeries = new XYChart.Series<>();
        insertionSeries.setName("Insertion Sort Time");
        lineChart.getData().addAll(bubbleSeries, insertionSeries);

        ToggleGroup sortingMethodToggleGroup = new ToggleGroup();
        RadioButton bubbleSortRadioButton = new RadioButton("Bubble Sort");
        bubbleSortRadioButton.setToggleGroup(sortingMethodToggleGroup);
        RadioButton insertionSortRadioButton = new RadioButton("Insertion Sort");
        insertionSortRadioButton.setToggleGroup(sortingMethodToggleGroup);
        bubbleSortRadioButton.setSelected(true);

        Button createButton = new Button("Create Chart");
        createButton.setOnAction(event -> {
            try {
                createSortingChart(sortingMethodToggleGroup, 100); // Example: 100 - array size
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        HBox sortingMethodHBox = new HBox(bubbleSortRadioButton, insertionSortRadioButton);
        HBox hbox = new HBox(sortingMethodHBox, createButton);
        HBox chartBox = new HBox(lineChart);
        HBox root = new HBox(hbox, chartBox);

        Scene scene = new Scene(root, 800, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createSortingChart(ToggleGroup sortingMethodToggleGroup, int arraySize) {
        bubbleSeries.getData().clear();
        insertionSeries.getData().clear();
        RadioButton selectedRadioButton = (RadioButton) sortingMethodToggleGroup.getSelectedToggle();
        String selectedSortingMethod = selectedRadioButton.getText();

        if (selectedSortingMethod.equals("Bubble Sort")) {
            Buble bubble = new Buble(arraySize, Sortingtype.Ascending);
            long bubbleSortTime = measureSortingTime(bubble);
            bubbleSeries.getData().add(new XYChart.Data<>(arraySize, bubbleSortTime));
        } else if (selectedSortingMethod.equals("Insertion Sort")) {
            Insertion insertion = new Insertion(arraySize, Sortingtype.Ascending);
            long insertionSortTime = measureSortingTime(insertion);
            insertionSeries.getData().add(new XYChart.Data<>(arraySize, insertionSortTime));
        }
    }

    private long measureSortingTime(Buble bubble) {
        long startTime = System.nanoTime();
        bubble.solve();
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort Result: " + Arrays.toString(bubble.array));
        return endTime - startTime;
    }

    private long measureSortingTime(Insertion insertion) {
        long startTime = System.nanoTime();
        insertion.solve();
        long endTime = System.nanoTime();
        System.out.println("Insertion Sort Result: " + Arrays.toString(insertion.array));
        return endTime - startTime;
    }
}
