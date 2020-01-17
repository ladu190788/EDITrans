package EDI_Package;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class class_FSR {
	public Pane FSRCode (Pane FSR,Stage primaryStage,Scene sceneBase)
	{
		//////////////////////////////////////////////////////
		//FSR SCreen
		//Top Border RE
		Rectangle rectFSRTop = new Rectangle();
		rectFSRTop.setX(0.0f);
		rectFSRTop.setY(0.0f);
		rectFSRTop.setWidth(1360.0f);
		rectFSRTop.setHeight(60.0f);
		rectFSRTop.setFill(Color.STEELBLUE);
		rectFSRTop.setStroke(Color.STEELBLUE);
		//Boundary
		Rectangle rectFSRBorder = new Rectangle();
		rectFSRBorder.setX(1.5f);
		rectFSRBorder.setY(0.0f);
		rectFSRBorder.setWidth(1356.0f);
		rectFSRBorder.setHeight(682.0f);
		rectFSRBorder.setFill(Color.WHITE);
		rectFSRBorder.setStroke(Color.STEELBLUE);
		//Top Text FSR
		Text textFSRTop = new Text();
		textFSRTop.setText("F S R");
		textFSRTop.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 24));
		textFSRTop.setFill(Color.WHITE);
		textFSRTop.setLayoutX(635);
		textFSRTop.setLayoutY(40);
		//HomeLink FSR
		Hyperlink HomelinkFSR = new Hyperlink();
		HomelinkFSR.setText("Home");
		HomelinkFSR.setStyle("-fx-text-fill: YELLOW;");
		HomelinkFSR.setLayoutX(1300);
		HomelinkFSR.setLayoutY(2);
		HomelinkFSR.setUnderline(false);
		HomelinkFSR.setFocusTraversable(false);
		HomelinkFSR.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 14));

		//Text Billing Provider Name CSR
		Text textFSRBillingProvider = new Text();
		textFSRBillingProvider.setText("Billing "+'\n'+"Provider NPI");
		textFSRBillingProvider.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRBillingProvider.setFill(Color.BLACK);
		textFSRBillingProvider.setLayoutX(100);
		textFSRBillingProvider.setLayoutY(95);

		//* mark
		Text textFSRBillingProv = new Text();
		textFSRBillingProv.setText("*");
		textFSRBillingProv.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRBillingProv.setFill(Color.RED);
		textFSRBillingProv.setLayoutX(200);
		textFSRBillingProv.setLayoutY(110);

		//TextField Billing Provider
		TextField textFieldFSRBillingProvider = new TextField();
		textFieldFSRBillingProvider.setLayoutX(250);
		textFieldFSRBillingProvider.setLayoutY(84);
		textFieldFSRBillingProvider.setPrefWidth(300);
		textFieldFSRBillingProvider.setPrefHeight(35);
		textFieldFSRBillingProvider.setEditable(true);
		textFieldFSRBillingProvider.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldFSRBillingProvider.setTooltip(new Tooltip("Enter Billing Provider NPI : Numeric Values Only"));
		textFieldFSRBillingProvider.setPromptText("Billing Provider NPI");
		////
		textFieldFSRBillingProvider.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldFSRBillingProvider.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldFSRBillingProvider.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});

		//Text memberF Name CSR
		Text textFSRBillingProvFName = new Text();
		textFSRBillingProvFName.setText("Billing Provider"+'\n'+"First Name");
		textFSRBillingProvFName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRBillingProvFName.setFill(Color.BLACK);
		textFSRBillingProvFName.setLayoutX(775);
		textFSRBillingProvFName.setLayoutY(95);

		//TextField Billing Provider
		TextField textFieldFSRBillingProvFName = new TextField();
		textFieldFSRBillingProvFName.setLayoutX(925);
		textFieldFSRBillingProvFName.setLayoutY(84);
		textFieldFSRBillingProvFName.setPrefWidth(300);
		textFieldFSRBillingProvFName.setPrefHeight(35);
		textFieldFSRBillingProvFName.setEditable(true);
		textFieldFSRBillingProvFName.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldPayerEligibility.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldFSRBillingProvFName.setTooltip(new Tooltip("Enter Billing Provider First Name"));
		textFieldFSRBillingProvFName.setPromptText("Billing Provider First Name");


		//Text memberF Name CSR
		Text textFSRBillingProvLName = new Text();
		textFSRBillingProvLName.setText("Billing Provider"+'\n'+"Last Name");
		textFSRBillingProvLName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRBillingProvLName.setFill(Color.BLACK);
		textFSRBillingProvLName.setLayoutX(100);
		textFSRBillingProvLName.setLayoutY(155);

		//TextField Billing Provider
		TextField textFieldFSRBillingProvLName = new TextField();
		textFieldFSRBillingProvLName.setLayoutX(250);
		textFieldFSRBillingProvLName.setLayoutY(144);
		textFieldFSRBillingProvLName.setPrefWidth(300);
		textFieldFSRBillingProvLName.setPrefHeight(35);
		textFieldFSRBillingProvLName.setEditable(true);
		textFieldFSRBillingProvLName.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldPayerEligibility.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldFSRBillingProvLName.setTooltip(new Tooltip("Enter Billing Provider Last Name"));
		textFieldFSRBillingProvLName.setPromptText("Billing Provider Last Name");



		textFieldFSRBillingProvFName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldFSRBillingProvFName.getText().length() >= 35) {
						textFieldFSRBillingProvFName.setText(textFieldFSRBillingProvFName.getText().substring(0, 35));
					}
				}
			}
		});
		textFieldFSRBillingProvLName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldFSRBillingProvLName.getText().length() >= 60) {
						textFieldFSRBillingProvLName.setText(textFieldFSRBillingProvLName.getText().substring(0, 60));
					}
				}
			}
		});


		//Text Servicing Provider Name CSR
		Text textFSRServicingProvider = new Text();
		textFSRServicingProvider.setText("Servicing "+'\n'+"Provider NPI");
		textFSRServicingProvider.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRServicingProvider.setFill(Color.BLACK);
		textFSRServicingProvider.setLayoutX(775);
		textFSRServicingProvider.setLayoutY(155);
		//* mark
		Text textFSRServicingProv = new Text();
		textFSRServicingProv.setText("*");
		textFSRServicingProv.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRServicingProv.setFill(Color.RED);
		textFSRServicingProv.setLayoutX(875);
		textFSRServicingProv.setLayoutY(170);
		//TextField Billing Provider
		TextField textFieldFSRServicingProvider = new TextField();
		textFieldFSRServicingProvider.setLayoutX(925);
		textFieldFSRServicingProvider.setLayoutY(144);
		textFieldFSRServicingProvider.setPrefWidth(300);
		textFieldFSRServicingProvider.setPrefHeight(35);
		textFieldFSRServicingProvider.setEditable(true);
		textFieldFSRServicingProvider.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldPayerEligibility.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldFSRServicingProvider.setTooltip(new Tooltip("Enter Servicing Provider NPI : Numeric Values Only"));
		textFieldFSRServicingProvider.setPromptText("Servicing Provider NPI");

		textFieldFSRServicingProvider.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldFSRServicingProvider.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldFSRServicingProvider.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});



		//Text memberF Name CSR
		Text textFSRServProvFName = new Text();
		textFSRServProvFName.setText("Servicing Provider"+'\n'+"First Name");
		textFSRServProvFName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRServProvFName.setFill(Color.BLACK);
		textFSRServProvFName.setLayoutX(100);
		textFSRServProvFName.setLayoutY(215);

		//TextField Billing Provider
		TextField textFieldFSRServProvFName = new TextField();
		textFieldFSRServProvFName.setLayoutX(250);
		textFieldFSRServProvFName.setLayoutY(204);
		textFieldFSRServProvFName.setPrefWidth(300);
		textFieldFSRServProvFName.setPrefHeight(35);
		textFieldFSRServProvFName.setEditable(true);
		textFieldFSRServProvFName.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldFSRServProvFName.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldFSRServProvFName.setTooltip(new Tooltip("Enter Servicing Provider First Name"));
		textFieldFSRServProvFName.setPromptText("Servicing Provider First Name");


		//Text memberF Name CSR
		Text textFSRServProvLName = new Text();
		textFSRServProvLName.setText("Servicing Provider"+'\n'+"Last Name");
		textFSRServProvLName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRServProvLName.setFill(Color.BLACK);
		textFSRServProvLName.setLayoutX(775);
		textFSRServProvLName.setLayoutY(215);

		//TextField Billing Provider
		TextField textFieldFSRServProvLName = new TextField();
		textFieldFSRServProvLName.setLayoutX(925);
		textFieldFSRServProvLName.setLayoutY(204);
		textFieldFSRServProvLName.setPrefWidth(300);
		textFieldFSRServProvLName.setPrefHeight(35);
		textFieldFSRServProvLName.setEditable(true);
		textFieldFSRServProvLName.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldFSRServProvLName.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldFSRServProvLName.setTooltip(new Tooltip("Enter Servicing Provider Last Name"));
		textFieldFSRServProvLName.setPromptText("Servicing Provider Last Name");


		textFieldFSRServProvFName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldFSRServProvFName.getText().length() >= 35) {
						textFieldFSRServProvFName.setText(textFieldFSRServProvFName.getText().substring(0, 35));
					}
				}
			}
		});
		textFieldFSRServProvLName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldFSRServProvLName.getText().length() >= 60) {
						textFieldFSRServProvLName.setText(textFieldFSRServProvLName.getText().substring(0, 60));
					}
				}
			}
		});

		//Text memberF Name CSR
		Text textFSRMemberFName = new Text();
		textFSRMemberFName.setText("Member "+'\n'+"First Name");
		textFSRMemberFName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRMemberFName.setFill(Color.BLACK);
		textFSRMemberFName.setLayoutX(100);
		textFSRMemberFName.setLayoutY(270);

		//TextField Billing Provider
		TextField textFieldFSRMemberFName = new TextField();
		textFieldFSRMemberFName.setLayoutX(250);
		textFieldFSRMemberFName.setLayoutY(259);
		textFieldFSRMemberFName.setPrefWidth(300);
		textFieldFSRMemberFName.setPrefHeight(35);
		textFieldFSRMemberFName.setEditable(true);
		textFieldFSRMemberFName.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldPayerEligibility.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldFSRMemberFName.setTooltip(new Tooltip("Enter Member First Name"));
		textFieldFSRMemberFName.setPromptText("Member First Name");

		//Text Servicing Provider Name CSR
		Text textFSRMemberLName = new Text();
		textFSRMemberLName.setText("Member "+'\n'+"Last Name");
		textFSRMemberLName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRMemberLName.setFill(Color.BLACK);
		textFSRMemberLName.setLayoutX(775);
		textFSRMemberLName.setLayoutY(270);

		//TextField Billing Provider
		TextField textFieldFSRMemberLName = new TextField();
		textFieldFSRMemberLName.setLayoutX(925);
		textFieldFSRMemberLName.setLayoutY(259);
		textFieldFSRMemberLName.setPrefWidth(300);
		textFieldFSRMemberLName.setPrefHeight(35);
		textFieldFSRMemberLName.setEditable(true);
		textFieldFSRMemberLName.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldFSRMemberLName.setTooltip(new Tooltip("Enter Member Last Name"));
		textFieldFSRMemberLName.setPromptText("Member Last Name");

		textFieldFSRMemberFName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldFSRMemberFName.getText().length() >= 35) {
						textFieldFSRMemberFName.setText(textFieldFSRMemberFName.getText().substring(0, 35));
					}
				}
			}
		});
		textFieldFSRMemberLName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldFSRMemberLName.getText().length() >= 60) {
						textFieldFSRMemberLName.setText(textFieldFSRMemberLName.getText().substring(0, 60));
					}
				}
			}
		});


		//Text Search Option Eligibility
		Text textFSRMemberID = new Text();
		textFSRMemberID.setText("Member ID");
		textFSRMemberID.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRMemberID.setFill(Color.BLACK);
		textFSRMemberID.setLayoutX(100);
		textFSRMemberID.setLayoutY(340);
		//* mark
		Text textFSRstarMemID= new Text();
		textFSRstarMemID.setText("*");
		textFSRstarMemID.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRstarMemID.setFill(Color.RED);
		textFSRstarMemID.setLayoutX(190);
		textFSRstarMemID.setLayoutY(337);
		//TextField Payer
		TextField textFieldFSRMemberID = new TextField();
		textFieldFSRMemberID.setLayoutX(250);
		textFieldFSRMemberID.setLayoutY(314);
		textFieldFSRMemberID.setPrefWidth(300);
		textFieldFSRMemberID.setPrefHeight(35);
		textFieldFSRMemberID.setEditable(true);
		textFieldFSRMemberID.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldFSRMemberID.setTooltip(new Tooltip("Enter Member ID"));
		textFieldFSRMemberID.setPromptText("Member ID");

		//Member ID Limit
		textFieldFSRMemberID.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldFSRMemberID.getText().length() >= 17) {
						textFieldFSRMemberID.setText(textFieldFSRMemberID.getText().substring(0, 17));
					}
				}
			}
		});

		//Text Search Option Eligibility
		Text textFSRMemberDOB = new Text();
		textFSRMemberDOB.setText("Member DOB");
		textFSRMemberDOB.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRMemberDOB.setFill(Color.BLACK);
		textFSRMemberDOB.setLayoutX(775);
		textFSRMemberDOB.setLayoutY(340);

		//* mark
		Text textFSRstarMemDOB= new Text();
		textFSRstarMemDOB.setText("*");
		textFSRstarMemDOB.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRstarMemDOB.setFill(Color.RED);
		textFSRstarMemDOB.setLayoutX(880);
		textFSRstarMemDOB.setLayoutY(337);
		//Date Picker
		DatePicker textFieldFSRMemberDOB = new DatePicker();
		textFieldFSRMemberDOB.setLayoutX(925);
		textFieldFSRMemberDOB.setLayoutY(314);
		textFieldFSRMemberDOB.setPrefWidth(300);
		textFieldFSRMemberDOB.setPrefHeight(35);
		textFieldFSRMemberDOB.setPromptText("MM/DD/YYYY");
		//startDatePicker.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldFSRMemberDOB.setTooltip(new Tooltip("Enter Member DOB"));
		textFieldFSRMemberDOB.setEditable(false);
		textFieldFSRMemberDOB.setStyle("-fx-font: 18px \"Calibri\";");

		textFieldFSRMemberDOB.setOnAction(e ->
		{
			LocalDate date = textFieldFSRMemberDOB.getValue();
		});


		Text textFSRServiceStartDT = new Text();
		textFSRServiceStartDT.setText("Service "+'\n'+"Start Date");
		textFSRServiceStartDT.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRServiceStartDT.setFill(Color.BLACK);
		textFSRServiceStartDT.setLayoutX(100);
		textFSRServiceStartDT.setLayoutY(380);
		//* mark
		Text textFSRServiceStart= new Text();
		textFSRServiceStart.setText("*");
		textFSRServiceStart.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRServiceStart.setFill(Color.RED);
		textFSRServiceStart.setLayoutX(185);
		textFSRServiceStart.setLayoutY(395);
		//Date Picker
		DatePicker FSRServiceStartDtPicker = new DatePicker();
		FSRServiceStartDtPicker.setLayoutX(250);
		FSRServiceStartDtPicker.setLayoutY(368);
		FSRServiceStartDtPicker.setPrefWidth(300);
		FSRServiceStartDtPicker.setPrefHeight(35);
		FSRServiceStartDtPicker.setPromptText("MM/DD/YYYY");
		//startDatePicker.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		FSRServiceStartDtPicker.setTooltip(new Tooltip("Enter Service Start Date"));
		FSRServiceStartDtPicker.setEditable(false);
		FSRServiceStartDtPicker.setStyle("-fx-font: 18px \"Calibri\";");

		FSRServiceStartDtPicker.setOnAction(e ->
		{
			LocalDate date = FSRServiceStartDtPicker.getValue();
		});

		Text textFSRServiceEndDT = new Text();
		textFSRServiceEndDT.setText("Service "+'\n'+"End Date");
		textFSRServiceEndDT.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRServiceEndDT.setFill(Color.BLACK);
		textFSRServiceEndDT.setLayoutX(775);
		textFSRServiceEndDT.setLayoutY(380);
		//* mark
		Text textFSRServiceEnd= new Text();
		textFSRServiceEnd.setText("*");
		textFSRServiceEnd.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRServiceEnd.setFill(Color.RED);
		textFSRServiceEnd.setLayoutX(855);
		textFSRServiceEnd.setLayoutY(395);
		//Date Picker
		DatePicker FSRServiceEndDtPicker = new DatePicker();
		FSRServiceEndDtPicker.setLayoutX(925);
		FSRServiceEndDtPicker.setLayoutY(368);
		FSRServiceEndDtPicker.setPrefWidth(300);
		FSRServiceEndDtPicker.setPrefHeight(35);
		FSRServiceEndDtPicker.setPromptText("MM/DD/YYYY");
		FSRServiceEndDtPicker.setTooltip(new Tooltip("Enter Service End Date"));
		FSRServiceEndDtPicker.setEditable(false);
		FSRServiceEndDtPicker.setStyle("-fx-font: 18px \"Calibri\";");

		FSRServiceEndDtPicker.setOnAction(e ->
		{
			LocalDate date = FSRServiceEndDtPicker.getValue();
		});

		//Text Clain Status Provider Name CSR
		Text textFSRClaimID = new Text();
		textFSRClaimID.setText("Claim ID");
		textFSRClaimID.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRClaimID.setFill(Color.BLACK);
		textFSRClaimID.setLayoutX(100);
		textFSRClaimID.setLayoutY(448);

		//* mark
		Text textFSRClaimIDstar = new Text();
		textFSRClaimIDstar.setText("*");
		textFSRClaimIDstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textFSRClaimIDstar.setFill(Color.RED);
		textFSRClaimIDstar.setLayoutX(165);
		textFSRClaimIDstar.setLayoutY(443);

		TextField textFieldFSRClaimID = new TextField();
		textFieldFSRClaimID.setLayoutX(250);
		textFieldFSRClaimID.setLayoutY(424);
		textFieldFSRClaimID.setPrefWidth(300);
		textFieldFSRClaimID.setPrefHeight(35);
		textFieldFSRClaimID.setEditable(true);
		textFieldFSRClaimID.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldFSRClaimID.setTooltip(new Tooltip("Enter Claim ID"));
		textFieldFSRClaimID.setPromptText("Claim ID");

		//Member ID Limit
		textFieldFSRClaimID.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldFSRClaimID.getText().length() >= 11) {
						textFieldFSRClaimID.setText(textFieldFSRClaimID.getText().substring(0, 11));
					}
				}
			}
		});

		//Validate Data ReferralInq Button
		Button validateDataFSR = new Button();
		validateDataFSR.setText("Validate Data");
		validateDataFSR.setLayoutX(430);
		validateDataFSR.setLayoutY(520);
		validateDataFSR.setMinWidth(150);
		validateDataFSR.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		validateDataFSR.setTextFill(Color.STEELBLUE);
		validateDataFSR.setStyle("-fx-background-color:STEELBLUE");
		validateDataFSR.setTextFill(Color.WHITE);
		//Validate Data ReferralInq Button
		Button createESIDataFSR = new Button();
		createESIDataFSR.setText("Create EDI File");
		createESIDataFSR.setLayoutX(600);
		createESIDataFSR.setLayoutY(520);
		createESIDataFSR.setMinWidth(150);
		createESIDataFSR.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		createESIDataFSR.setTextFill(Color.STEELBLUE);
		createESIDataFSR.setStyle("-fx-background-color:STEELBLUE");
		createESIDataFSR.setTextFill(Color.WHITE);
		//Process Data ReferralInq Button
		Button processDataFSR = new Button();
		processDataFSR.setText("Process EDI File");
		processDataFSR.setLayoutX(770);
		processDataFSR.setLayoutY(520);
		processDataFSR.setMinWidth(150);
		processDataFSR.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		processDataFSR.setStyle("-fx-background-color:STEELBLUE");
		processDataFSR.setTextFill(Color.WHITE);

		//Validate Data Event
		validateDataFSR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(textFieldFSRBillingProvider.getText().isEmpty()==true || 
						textFieldFSRServicingProvider.getText().isEmpty()==true ||
						textFieldFSRMemberID.getText().isEmpty()==true ||
						textFieldFSRMemberDOB.getValue()==null ||
						FSRServiceEndDtPicker.getValue()==null ||
						FSRServiceStartDtPicker.getValue()==null||
						textFieldFSRClaimID.getText().isEmpty()==true)
				{
					Alert alert=new Alert(AlertType.WARNING);
					alert.setTitle("Enter Data");
					alert.setContentText("Please Enter all Mandatory Fields.");
					alert.showAndWait();
				}
				else
				{
					Alert alert=new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Data Validation Successful");
					alert.setContentText("Please Click Create EDI Data to Create Files.");
					alert.showAndWait();
				}
			}
		});

		//Create EDI Data Event handler
		createESIDataFSR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(textFieldFSRBillingProvider.getText().isEmpty()==true || 
						textFieldFSRServicingProvider.getText().isEmpty()==true ||
						textFieldFSRMemberID.getText().isEmpty()==true ||
						textFieldFSRMemberDOB.getValue()==null ||
						FSRServiceEndDtPicker.getValue()==null ||
						FSRServiceStartDtPicker.getValue()==null||
						textFieldFSRClaimID.getText().isEmpty()==true)
				{
					Alert alert=new Alert(AlertType.WARNING);
					alert.setTitle("Enter Data");
					alert.setContentText("Please Enter all Mandatory Fields.");
					alert.showAndWait();
				}
				else
				{
					DirectoryChooser directoryChooser = new DirectoryChooser();
					File selectedDirectory = directoryChooser.showDialog(primaryStage);
					if(selectedDirectory == null)
					{
						Alert alert=new Alert(AlertType.WARNING);
						alert.setTitle("Alert");
						alert.setContentText("Please Select a Directory.");
						alert.showAndWait();
					}
					else
					{
						String path=selectedDirectory.getAbsolutePath();
						path=path+"\\";
						String pathm=path.replaceAll("\\\\", "\\\\\\\\");
						try
						{
							Files.deleteIfExists(Paths.get(pathm+"FSR.txt"));
							DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"FSR.txt"));
							out.writeBytes("ISA*00*          *00*          *ZZ*GATEWAYQES     *ZZ*222222222      *010806*1200*^*00501*000000006*0*T*:");
							String newLine = System.getProperty("line.separator");
							out.writeBytes(newLine);
							out.writeBytes("GS*HR*GATEWAYQES*RTCS_DET_5010*20070826*23010101*1*X*005010X212");
							out.writeBytes(newLine);
							out.writeBytes("ST*276*000000001*005010X212");
							out.writeBytes(newLine);
							out.writeBytes("BHT*0010*13*ABC276XXX*20050915*1425");
							out.writeBytes(newLine);
							out.writeBytes("HL*1**20*1");
							out.writeBytes(newLine);
							out.writeBytes("NM1*PR*2*AETNA*****PI*953402799");
							out.writeBytes(newLine);
							out.writeBytes("HL*2*1*21*1");
							out.writeBytes(newLine);
							out.writeBytes("NM1*41*1*"+textFieldFSRBillingProvLName.getText()+"*"+textFieldFSRBillingProvFName.getText()+"****46*"+textFieldFSRBillingProvider.getText());
							out.writeBytes(newLine);
							out.writeBytes("HL*3*2*19*1");
							out.writeBytes(newLine);
							out.writeBytes("NM1*1P*1*"+textFieldFSRServProvLName.getText()+"*"+textFieldFSRServProvFName.getText()+"****XX*"+textFieldFSRServicingProvider.getText());
							out.writeBytes(newLine);
							out.writeBytes("HL*4*3*22*0");
							out.writeBytes(newLine);
							out.writeBytes("DMG*D8*"+textFieldFSRMemberDOB.getValue().toString().replace("-", ""));
							out.writeBytes(newLine);
							out.writeBytes("NM1*IL*1*"+textFieldFSRMemberLName.getText()+"*"+textFieldFSRMemberFName.getText()+"****MI*"+textFieldFSRMemberID.getText());
							out.writeBytes(newLine);
							out.writeBytes("TRN*1*123456789111");
							out.writeBytes(newLine);
							out.writeBytes("REF*1K*"+textFieldFSRClaimID.getText());
							out.writeBytes(newLine);
							out.writeBytes("DTP*472*RD8*"+FSRServiceStartDtPicker.getValue().toString().replace("-", "")+"-"+FSRServiceEndDtPicker.getValue().toString().replace("-", ""));
							out.writeBytes(newLine);
							out.writeBytes("SE*15*000000001");
							out.writeBytes(newLine);
							out.writeBytes("GE*1*1");
							out.writeBytes(newLine);
							out.writeBytes("IEA*1*000000006");
							out.writeBytes(newLine);
							out.close();
						}
						catch(Exception e)
						{
							System.out.println("Unable to Create FSR Claim FIle");
						}
					}
					Alert alert=new Alert(AlertType.INFORMATION);
					alert.setTitle("Successful");
					alert.setContentText("File Created Successfully.");
					alert.showAndWait();

				}
			}
		});
		//Home Button FSR Link Event Handle
		HomelinkFSR.setOnAction(new EventHandler<ActionEvent>() 	{
			public void handle(ActionEvent event) 
			{
				primaryStage.setScene(sceneBase);
				textFieldFSRServicingProvider.clear();
				FSRServiceStartDtPicker.getEditor().clear();
				FSRServiceStartDtPicker.setPromptText("MM/DD/YYYY");
				FSRServiceEndDtPicker.getEditor().clear();
				FSRServiceEndDtPicker.setPromptText("MM/DD/YYYY");
				textFieldFSRMemberID.clear();
				textFieldFSRMemberDOB.getEditor().clear();
				textFieldFSRMemberDOB.setPromptText("MM/DD/YYYY");
				textFieldFSRClaimID.clear();
				textFieldFSRMemberFName.clear();
				textFieldFSRMemberLName.clear();
				textFieldFSRServProvLName.clear();
				textFieldFSRServProvFName.clear();
				textFieldFSRBillingProvLName.clear();
				textFieldFSRBillingProvFName.clear();
				textFieldFSRBillingProvider.clear();
			}
		});
		FSR.getChildren().addAll(rectFSRBorder,rectFSRTop,textFSRTop,HomelinkFSR,textFSRBillingProvider,textFieldFSRBillingProvider,textFSRServicingProvider,textFieldFSRServicingProvider,
				textFSRServiceStartDT,FSRServiceStartDtPicker,textFSRServiceEndDT,FSRServiceEndDtPicker,textFSRBillingProv,textFSRServicingProv,textFSRServiceStart,textFSRServiceEnd,
				validateDataFSR,createESIDataFSR,processDataFSR,textFSRMemberFName,textFieldFSRMemberFName,textFSRMemberLName,textFieldFSRMemberLName
				,textFSRMemberID,textFieldFSRMemberID,textFSRMemberDOB,textFieldFSRMemberDOB,textFSRClaimID,textFieldFSRClaimID,textFSRstarMemID,textFSRstarMemDOB,
				textFSRBillingProvFName,textFieldFSRBillingProvFName,textFSRBillingProvLName,textFieldFSRBillingProvLName,textFSRServProvFName,
				textFieldFSRServProvFName,textFSRServProvLName,textFieldFSRServProvLName,textFSRClaimIDstar);
		FSR.setStyle("-fx-background-color:WHITE");
		return FSR;
	}

}
