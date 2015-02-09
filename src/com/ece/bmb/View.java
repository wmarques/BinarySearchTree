package com.ece.bmb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ece.bmb.Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {

	private Stage primaryStage;
	
	NumberAxis x = new NumberAxis (1 , 4 , 1);
	NumberAxis y = new NumberAxis ();

	ObservableList<XYChart . Data < Number , Number >> data =FXCollections.observableArrayList(
			 new XYChart . Data < >(1 , 10) ,
			 new XYChart . Data < >(2 , 7) ,
			 new XYChart . Data < >(3 , 5) ,
			 new XYChart . Data < >(4 , 4.1));
	
	ObservableList < XYChart . Series < Number , Number > > series =
			FXCollections . observableArrayList (
			new XYChart . Series < >( data ));
			


	public View(Stage primaryStage){
		this.primaryStage=primaryStage;

	}

	public void start() {

		Scene vb = new Scene(new VBox(),800,600);
		Label labelNbValue = new Label("Number of Value to Add");
		TextField nbValue = new TextField();
		Label labelMaxThread = new Label("Number of Thread");
		TextField maxThread = new TextField();	

		Button launchBenchmark = new Button("Launch Benchmark");
		launchBenchmark.setOnAction(new EventHandler<ActionEvent>() {		 
			@Override
			public void handle(ActionEvent event) {

			}
		});

		HBox hbTop = new HBox();
		hbTop.getChildren().addAll(labelNbValue,nbValue,labelMaxThread, maxThread,launchBenchmark);
		
		LineChart < Number , Number > chart = new LineChart < >(x , y , series);
		chart.setTitle("Time according to thread number ");
		
		
		ProgressBar pb = new ProgressBar(0.6);
		ProgressIndicator pi = new ProgressIndicator(0.6);
		
		HBox hbBottom = new HBox();
		hbBottom.getChildren().addAll(pi,pb);
		
		((VBox) vb.getRoot()).getChildren().addAll(hbTop,chart,hbBottom);

		primaryStage.setScene(vb);
		primaryStage.show();
	}
}