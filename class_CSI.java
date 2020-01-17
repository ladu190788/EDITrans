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

public class class_CSI {
	public Pane CSICode (Pane CSI,Stage primaryStage,Scene sceneBase)
	{
		//////////////////////////////////////////////////////
		//CSI SCreen
		//Top Border RE
		Rectangle rectCSITop = new Rectangle();
		rectCSITop.setX(0.0f);
		rectCSITop.setY(0.0f);
		rectCSITop.setWidth(1360.0f);
		rectCSITop.setHeight(60.0f);
		rectCSITop.setFill(Color.STEELBLUE);
		rectCSITop.setStroke(Color.STEELBLUE);
		//Boundary
		Rectangle rectCSIBorder = new Rectangle();
		rectCSIBorder.setX(1.5f);
		rectCSIBorder.setY(0.0f);
		rectCSIBorder.setWidth(1356.0f);
		rectCSIBorder.setHeight(682.0f);
		rectCSIBorder.setFill(Color.WHITE);
		rectCSIBorder.setStroke(Color.STEELBLUE);
		//Top Text CSI
		Text textCSITop = new Text();
		textCSITop.setText("Claim Status Inquiry");
		textCSITop.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 24));
		textCSITop.setFill(Color.WHITE);
		textCSITop.setLayoutX(585);
		textCSITop.setLayoutY(40);
		//HomeLink CSI
		Hyperlink HomelinkCSI = new Hyperlink();
		HomelinkCSI.setText("Home");
		HomelinkCSI.setStyle("-fx-text-fill: YELLOW;");
		HomelinkCSI.setLayoutX(1300);
		HomelinkCSI.setLayoutY(2);
		HomelinkCSI.setUnderline(false);
		HomelinkCSI.setFocusTraversable(false);
		HomelinkCSI.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 14));

		//Text Billing Provider Name CSR
		Text textCSIBillingProvider = new Text();
		textCSIBillingProvider.setText("Billing "+'\n'+"Provider NPI");
		textCSIBillingProvider.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIBillingProvider.setFill(Color.BLACK);
		textCSIBillingProvider.setLayoutX(100);
		textCSIBillingProvider.setLayoutY(95);

		//* mark
		Text textCSIBillingProv = new Text();
		textCSIBillingProv.setText("*");
		textCSIBillingProv.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIBillingProv.setFill(Color.RED);
		textCSIBillingProv.setLayoutX(200);
		textCSIBillingProv.setLayoutY(110);

		//TextField Billing Provider
		TextField textFieldCSIBillingProvider = new TextField();
		textFieldCSIBillingProvider.setLayoutX(250);
		textFieldCSIBillingProvider.setLayoutY(84);
		textFieldCSIBillingProvider.setPrefWidth(300);
		textFieldCSIBillingProvider.setPrefHeight(35);
		textFieldCSIBillingProvider.setEditable(true);
		textFieldCSIBillingProvider.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldCSIBillingProvider.setTooltip(new Tooltip("Enter Billing Provider NPI : Numeric Values Only"));
		textFieldCSIBillingProvider.setPromptText("Billing Provider NPI");
		////
		textFieldCSIBillingProvider.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldCSIBillingProvider.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldCSIBillingProvider.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});

		//Text memberF Name CSR
		Text textCSIBillingProvFName = new Text();
		textCSIBillingProvFName.setText("Billing Provider"+'\n'+"First Name");
		textCSIBillingProvFName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIBillingProvFName.setFill(Color.BLACK);
		textCSIBillingProvFName.setLayoutX(775);
		textCSIBillingProvFName.setLayoutY(95);

		//TextField Billing Provider
		TextField textFieldCSIBillingProvFName = new TextField();
		textFieldCSIBillingProvFName.setLayoutX(925);
		textFieldCSIBillingProvFName.setLayoutY(84);
		textFieldCSIBillingProvFName.setPrefWidth(300);
		textFieldCSIBillingProvFName.setPrefHeight(35);
		textFieldCSIBillingProvFName.setEditable(true);
		textFieldCSIBillingProvFName.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldPayerEligibility.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldCSIBillingProvFName.setTooltip(new Tooltip("Enter Billing Provider First Name"));
		textFieldCSIBillingProvFName.setPromptText("Billing Provider First Name");


		//Text memberF Name CSR
		Text textCSIBillingProvLName = new Text();
		textCSIBillingProvLName.setText("Billing Provider"+'\n'+"Last Name");
		textCSIBillingProvLName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIBillingProvLName.setFill(Color.BLACK);
		textCSIBillingProvLName.setLayoutX(100);
		textCSIBillingProvLName.setLayoutY(155);

		//TextField Billing Provider
		TextField textFieldCSIBillingProvLName = new TextField();
		textFieldCSIBillingProvLName.setLayoutX(250);
		textFieldCSIBillingProvLName.setLayoutY(144);
		textFieldCSIBillingProvLName.setPrefWidth(300);
		textFieldCSIBillingProvLName.setPrefHeight(35);
		textFieldCSIBillingProvLName.setEditable(true);
		textFieldCSIBillingProvLName.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldPayerEligibility.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldCSIBillingProvLName.setTooltip(new Tooltip("Enter Billing Provider Last Name"));
		textFieldCSIBillingProvLName.setPromptText("Billing Provider Last Name");
		
		
		
		textFieldCSIBillingProvFName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldCSIBillingProvFName.getText().length() >= 35) {
						textFieldCSIBillingProvFName.setText(textFieldCSIBillingProvFName.getText().substring(0, 35));
					}
				}
			}
		});
		textFieldCSIBillingProvLName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldCSIBillingProvLName.getText().length() >= 60) {
						textFieldCSIBillingProvLName.setText(textFieldCSIBillingProvLName.getText().substring(0, 60));
					}
				}
			}
		});


		//Text Servicing Provider Name CSR
		Text textCSIServicingProvider = new Text();
		textCSIServicingProvider.setText("Servicing "+'\n'+"Provider NPI");
		textCSIServicingProvider.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIServicingProvider.setFill(Color.BLACK);
		textCSIServicingProvider.setLayoutX(775);
		textCSIServicingProvider.setLayoutY(155);
		//* mark
		Text textCSIServicingProv = new Text();
		textCSIServicingProv.setText("*");
		textCSIServicingProv.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIServicingProv.setFill(Color.RED);
		textCSIServicingProv.setLayoutX(875);
		textCSIServicingProv.setLayoutY(170);
		//TextField Billing Provider
		TextField textFieldCSIServicingProvider = new TextField();
		textFieldCSIServicingProvider.setLayoutX(925);
		textFieldCSIServicingProvider.setLayoutY(144);
		textFieldCSIServicingProvider.setPrefWidth(300);
		textFieldCSIServicingProvider.setPrefHeight(35);
		textFieldCSIServicingProvider.setEditable(true);
		textFieldCSIServicingProvider.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldPayerEligibility.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldCSIServicingProvider.setTooltip(new Tooltip("Enter Servicing Provider NPI : Numeric Values Only"));
		textFieldCSIServicingProvider.setPromptText("Servicing Provider NPI");

		textFieldCSIServicingProvider.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldCSIServicingProvider.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldCSIServicingProvider.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});



		//Text memberF Name CSR
		Text textCSIServProvFName = new Text();
		textCSIServProvFName.setText("Servicing Provider"+'\n'+"First Name");
		textCSIServProvFName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIServProvFName.setFill(Color.BLACK);
		textCSIServProvFName.setLayoutX(100);
		textCSIServProvFName.setLayoutY(215);

		//TextField Billing Provider
		TextField textFieldCSIServProvFName = new TextField();
		textFieldCSIServProvFName.setLayoutX(250);
		textFieldCSIServProvFName.setLayoutY(204);
		textFieldCSIServProvFName.setPrefWidth(300);
		textFieldCSIServProvFName.setPrefHeight(35);
		textFieldCSIServProvFName.setEditable(true);
		textFieldCSIServProvFName.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldCSIServProvFName.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldCSIServProvFName.setTooltip(new Tooltip("Enter Servicing Provider First Name"));
		textFieldCSIServProvFName.setPromptText("Servicing Provider First Name");


		//Text memberF Name CSR
		Text textCSIServProvLName = new Text();
		textCSIServProvLName.setText("Servicing Provider"+'\n'+"Last Name");
		textCSIServProvLName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIServProvLName.setFill(Color.BLACK);
		textCSIServProvLName.setLayoutX(775);
		textCSIServProvLName.setLayoutY(215);

		//TextField Billing Provider
		TextField textFieldCSIServProvLName = new TextField();
		textFieldCSIServProvLName.setLayoutX(925);
		textFieldCSIServProvLName.setLayoutY(204);
		textFieldCSIServProvLName.setPrefWidth(300);
		textFieldCSIServProvLName.setPrefHeight(35);
		textFieldCSIServProvLName.setEditable(true);
		textFieldCSIServProvLName.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldCSIServProvLName.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldCSIServProvLName.setTooltip(new Tooltip("Enter Servicing Provider Last Name"));
		textFieldCSIServProvLName.setPromptText("Servicing Provider Last Name");
		
		
		textFieldCSIServProvFName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldCSIServProvFName.getText().length() >= 35) {
						textFieldCSIServProvFName.setText(textFieldCSIServProvFName.getText().substring(0, 35));
					}
				}
			}
		});
		textFieldCSIServProvLName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldCSIServProvLName.getText().length() >= 60) {
						textFieldCSIServProvLName.setText(textFieldCSIServProvLName.getText().substring(0, 60));
					}
				}
			}
		});

		//Text memberF Name CSR
		Text textCSIMemberFName = new Text();
		textCSIMemberFName.setText("Member "+'\n'+"First Name");
		textCSIMemberFName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIMemberFName.setFill(Color.BLACK);
		textCSIMemberFName.setLayoutX(100);
		textCSIMemberFName.setLayoutY(270);

		//TextField Billing Provider
		TextField textFieldCSIMemberFName = new TextField();
		textFieldCSIMemberFName.setLayoutX(250);
		textFieldCSIMemberFName.setLayoutY(259);
		textFieldCSIMemberFName.setPrefWidth(300);
		textFieldCSIMemberFName.setPrefHeight(35);
		textFieldCSIMemberFName.setEditable(true);
		textFieldCSIMemberFName.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldPayerEligibility.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldCSIMemberFName.setTooltip(new Tooltip("Enter Member First Name"));
		textFieldCSIMemberFName.setPromptText("Member First Name");

		//Text Servicing Provider Name CSR
		Text textCSIMemberLName = new Text();
		textCSIMemberLName.setText("Member "+'\n'+"Last Name");
		textCSIMemberLName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIMemberLName.setFill(Color.BLACK);
		textCSIMemberLName.setLayoutX(775);
		textCSIMemberLName.setLayoutY(270);

		//TextField Billing Provider
		TextField textFieldCSIMemberLName = new TextField();
		textFieldCSIMemberLName.setLayoutX(925);
		textFieldCSIMemberLName.setLayoutY(259);
		textFieldCSIMemberLName.setPrefWidth(300);
		textFieldCSIMemberLName.setPrefHeight(35);
		textFieldCSIMemberLName.setEditable(true);
		textFieldCSIMemberLName.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldCSIMemberLName.setTooltip(new Tooltip("Enter Member Last Name"));
		textFieldCSIMemberLName.setPromptText("Member Last Name");

		textFieldCSIMemberFName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldCSIMemberFName.getText().length() >= 35) {
						textFieldCSIMemberFName.setText(textFieldCSIMemberFName.getText().substring(0, 35));
					}
				}
			}
		});
		textFieldCSIMemberLName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldCSIMemberLName.getText().length() >= 60) {
						textFieldCSIMemberLName.setText(textFieldCSIMemberLName.getText().substring(0, 60));
					}
				}
			}
		});


		//Text Search Option Eligibility
		Text textCSIMemberID = new Text();
		textCSIMemberID.setText("Member ID");
		textCSIMemberID.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIMemberID.setFill(Color.BLACK);
		textCSIMemberID.setLayoutX(100);
		textCSIMemberID.setLayoutY(340);
		//* mark
		Text textCSIstarMemID= new Text();
		textCSIstarMemID.setText("*");
		textCSIstarMemID.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIstarMemID.setFill(Color.RED);
		textCSIstarMemID.setLayoutX(190);
		textCSIstarMemID.setLayoutY(337);
		//TextField Payer
		TextField textFieldCSIMemberID = new TextField();
		textFieldCSIMemberID.setLayoutX(250);
		textFieldCSIMemberID.setLayoutY(314);
		textFieldCSIMemberID.setPrefWidth(300);
		textFieldCSIMemberID.setPrefHeight(35);
		textFieldCSIMemberID.setEditable(true);
		textFieldCSIMemberID.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldCSIMemberID.setTooltip(new Tooltip("Enter Member ID"));
		textFieldCSIMemberID.setPromptText("Member ID");

		//Member ID Limit
		textFieldCSIMemberID.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldCSIMemberID.getText().length() >= 17) {
						textFieldCSIMemberID.setText(textFieldCSIMemberID.getText().substring(0, 17));
					}
				}
			}
		});

		//Text Search Option Eligibility
		Text textCSIMemberDOB = new Text();
		textCSIMemberDOB.setText("Member DOB");
		textCSIMemberDOB.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIMemberDOB.setFill(Color.BLACK);
		textCSIMemberDOB.setLayoutX(775);
		textCSIMemberDOB.setLayoutY(340);

		//* mark
		Text textCSIstarMemDOB= new Text();
		textCSIstarMemDOB.setText("*");
		textCSIstarMemDOB.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIstarMemDOB.setFill(Color.RED);
		textCSIstarMemDOB.setLayoutX(880);
		textCSIstarMemDOB.setLayoutY(337);
		//Date Picker
		DatePicker textFieldCSIMemberDOB = new DatePicker();
		textFieldCSIMemberDOB.setLayoutX(925);
		textFieldCSIMemberDOB.setLayoutY(314);
		textFieldCSIMemberDOB.setPrefWidth(300);
		textFieldCSIMemberDOB.setPrefHeight(35);
		textFieldCSIMemberDOB.setPromptText("MM/DD/YYYY");
		//startDatePicker.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldCSIMemberDOB.setTooltip(new Tooltip("Enter Member DOB"));
		textFieldCSIMemberDOB.setEditable(false);
		textFieldCSIMemberDOB.setStyle("-fx-font: 18px \"Calibri\";");

		textFieldCSIMemberDOB.setOnAction(e ->
		{
			LocalDate date = textFieldCSIMemberDOB.getValue();
		});


		Text textCSIServiceStartDT = new Text();
		textCSIServiceStartDT.setText("Service "+'\n'+"Start Date");
		textCSIServiceStartDT.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIServiceStartDT.setFill(Color.BLACK);
		textCSIServiceStartDT.setLayoutX(100);
		textCSIServiceStartDT.setLayoutY(380);
		//* mark
		Text textCSIServiceStart= new Text();
		textCSIServiceStart.setText("*");
		textCSIServiceStart.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIServiceStart.setFill(Color.RED);
		textCSIServiceStart.setLayoutX(185);
		textCSIServiceStart.setLayoutY(395);
		//Date Picker
		DatePicker CSIServiceStartDtPicker = new DatePicker();
		CSIServiceStartDtPicker.setLayoutX(250);
		CSIServiceStartDtPicker.setLayoutY(368);
		CSIServiceStartDtPicker.setPrefWidth(300);
		CSIServiceStartDtPicker.setPrefHeight(35);
		CSIServiceStartDtPicker.setPromptText("MM/DD/YYYY");
		//startDatePicker.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		CSIServiceStartDtPicker.setTooltip(new Tooltip("Enter Service Start Date"));
		CSIServiceStartDtPicker.setEditable(false);
		CSIServiceStartDtPicker.setStyle("-fx-font: 18px \"Calibri\";");

		CSIServiceStartDtPicker.setOnAction(e ->
		{
			LocalDate date = CSIServiceStartDtPicker.getValue();
		});

		Text textCSIServiceEndDT = new Text();
		textCSIServiceEndDT.setText("Service "+'\n'+"End Date");
		textCSIServiceEndDT.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIServiceEndDT.setFill(Color.BLACK);
		textCSIServiceEndDT.setLayoutX(775);
		textCSIServiceEndDT.setLayoutY(380);
		//* mark
		Text textCSIServiceEnd= new Text();
		textCSIServiceEnd.setText("*");
		textCSIServiceEnd.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIServiceEnd.setFill(Color.RED);
		textCSIServiceEnd.setLayoutX(855);
		textCSIServiceEnd.setLayoutY(395);
		//Date Picker
		DatePicker CSIServiceEndDtPicker = new DatePicker();
		CSIServiceEndDtPicker.setLayoutX(925);
		CSIServiceEndDtPicker.setLayoutY(368);
		CSIServiceEndDtPicker.setPrefWidth(300);
		CSIServiceEndDtPicker.setPrefHeight(35);
		CSIServiceEndDtPicker.setPromptText("MM/DD/YYYY");
		CSIServiceEndDtPicker.setTooltip(new Tooltip("Enter Service End Date"));
		CSIServiceEndDtPicker.setEditable(false);
		CSIServiceEndDtPicker.setStyle("-fx-font: 18px \"Calibri\";");

		CSIServiceEndDtPicker.setOnAction(e ->
		{
			LocalDate date = CSIServiceEndDtPicker.getValue();
		});

		//Text Clain Status Provider Name CSR
		Text textCSIClaimID = new Text();
		textCSIClaimID.setText("Claim ID");
		textCSIClaimID.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSIClaimID.setFill(Color.BLACK);
		textCSIClaimID.setLayoutX(100);
		textCSIClaimID.setLayoutY(448);

		TextField textFieldCSIClaimID = new TextField();
		textFieldCSIClaimID.setLayoutX(250);
		textFieldCSIClaimID.setLayoutY(424);
		textFieldCSIClaimID.setPrefWidth(300);
		textFieldCSIClaimID.setPrefHeight(35);
		textFieldCSIClaimID.setEditable(true);
		textFieldCSIClaimID.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldCSIClaimID.setTooltip(new Tooltip("Enter Claim ID"));
		textFieldCSIClaimID.setPromptText("Claim ID");

		//Member ID Limit
		textFieldCSIClaimID.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldCSIClaimID.getText().length() >= 11) {
						textFieldCSIClaimID.setText(textFieldCSIClaimID.getText().substring(0, 11));
					}
				}
			}
		});

		//Validate Data ReferralInq Button
		Button validateDataCSI = new Button();
		validateDataCSI.setText("Validate Data");
		validateDataCSI.setLayoutX(430);
		validateDataCSI.setLayoutY(520);
		validateDataCSI.setMinWidth(150);
		validateDataCSI.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		validateDataCSI.setTextFill(Color.STEELBLUE);
		validateDataCSI.setStyle("-fx-background-color:STEELBLUE");
		validateDataCSI.setTextFill(Color.WHITE);
		//Validate Data ReferralInq Button
		Button createESIDataCSI = new Button();
		createESIDataCSI.setText("Create EDI File");
		createESIDataCSI.setLayoutX(600);
		createESIDataCSI.setLayoutY(520);
		createESIDataCSI.setMinWidth(150);
		createESIDataCSI.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		createESIDataCSI.setTextFill(Color.STEELBLUE);
		createESIDataCSI.setStyle("-fx-background-color:STEELBLUE");
		createESIDataCSI.setTextFill(Color.WHITE);
		//Process Data ReferralInq Button
		Button processDataCSI = new Button();
		processDataCSI.setText("Process EDI File");
		processDataCSI.setLayoutX(770);
		processDataCSI.setLayoutY(520);
		processDataCSI.setMinWidth(150);
		processDataCSI.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		processDataCSI.setStyle("-fx-background-color:STEELBLUE");
		processDataCSI.setTextFill(Color.WHITE);

		//Validate Data Event
		validateDataCSI.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(textFieldCSIBillingProvider.getText().isEmpty()==true || 
						textFieldCSIServicingProvider.getText().isEmpty()==true ||
						textFieldCSIMemberID.getText().isEmpty()==true ||
						textFieldCSIMemberDOB.getValue()==null ||
						CSIServiceEndDtPicker.getValue()==null ||
						CSIServiceStartDtPicker.getValue()==null)
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
		createESIDataCSI.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(textFieldCSIBillingProvider.getText().isEmpty()==true || 
						textFieldCSIServicingProvider.getText().isEmpty()==true ||
						textFieldCSIMemberID.getText().isEmpty()==true ||
						textFieldCSIMemberDOB.getValue()==null ||
						CSIServiceEndDtPicker.getValue()==null ||
						CSIServiceStartDtPicker.getValue()==null)
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
						if(textFieldCSIClaimID.getText().isEmpty()==true)
						{
							try
							{
								Files.deleteIfExists(Paths.get(pathm+"CSI_WithoutClaimId.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"CSI_WithoutClaimId.txt"));

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
								out.writeBytes("NM1*41*1*"+textFieldCSIBillingProvLName.getText()+"*"+textFieldCSIBillingProvFName.getText()+"****46*"+textFieldCSIBillingProvider.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*3*2*19*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*1P*1*"+textFieldCSIServProvLName.getText()+"*"+textFieldCSIServProvFName.getText()+"****XX*"+textFieldCSIServicingProvider.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*4*3*22*0");
								out.writeBytes(newLine);
								out.writeBytes("DMG*D8*"+textFieldCSIMemberDOB.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("NM1*IL*1*"+textFieldCSIMemberLName.getText()+"*"+textFieldCSIMemberFName.getText()+"****MI*"+textFieldCSIMemberID.getText());
								out.writeBytes(newLine);
								out.writeBytes("TRN*1*123456789111");
								out.writeBytes(newLine);
								out.writeBytes("DTP*472*RD8*"+CSIServiceStartDtPicker.getValue().toString().replace("-", "")+"-"+CSIServiceEndDtPicker.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("SE*14*000000001");
								out.writeBytes(newLine);
								out.writeBytes("GE*1*1");
								out.writeBytes(newLine);
								out.writeBytes("IEA*1*000000006");
								out.writeBytes(newLine);
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create CSI No Claim FIle");
							}
						}
						else
						{
							try
							{
								Files.deleteIfExists(Paths.get(pathm+"CSI_ClaimId.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"CSI_ClaimId.txt"));
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
								out.writeBytes("NM1*41*1*"+textFieldCSIBillingProvLName.getText()+"*"+textFieldCSIBillingProvFName.getText()+"****46*"+textFieldCSIBillingProvider.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*3*2*19*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*1P*1*"+textFieldCSIServProvLName.getText()+"*"+textFieldCSIServProvFName.getText()+"****XX*"+textFieldCSIServicingProvider.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*4*3*22*0");
								out.writeBytes(newLine);
								out.writeBytes("DMG*D8*"+textFieldCSIMemberDOB.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("NM1*IL*1*"+textFieldCSIMemberLName.getText()+"*"+textFieldCSIMemberFName.getText()+"****MI*"+textFieldCSIMemberID.getText());
								out.writeBytes(newLine);
								out.writeBytes("TRN*1*123456789111");
								out.writeBytes(newLine);
								out.writeBytes("REF*1K*"+textFieldCSIClaimID.getText());
								out.writeBytes(newLine);
								out.writeBytes("DTP*472*RD8*"+CSIServiceStartDtPicker.getValue().toString().replace("-", "")+"-"+CSIServiceEndDtPicker.getValue().toString().replace("-", ""));
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
								System.out.println("Unable to Create CSI Claim FIle");
							}
						}
						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("Successful");
						alert.setContentText("File Created Successfully.");
						alert.showAndWait();
					}
				}
			}
		});
		//Home Button CSI Link Event Handle
		HomelinkCSI.setOnAction(new EventHandler<ActionEvent>() 	{
			public void handle(ActionEvent event) 
			{
				primaryStage.setScene(sceneBase);
				textFieldCSIServicingProvider.clear();
				CSIServiceStartDtPicker.getEditor().clear();
				CSIServiceStartDtPicker.setPromptText("MM/DD/YYYY");
				CSIServiceEndDtPicker.getEditor().clear();
				CSIServiceEndDtPicker.setPromptText("MM/DD/YYYY");
				textFieldCSIMemberID.clear();
				textFieldCSIMemberDOB.getEditor().clear();
				textFieldCSIMemberDOB.setPromptText("MM/DD/YYYY");
				textFieldCSIClaimID.clear();
				textFieldCSIMemberFName.clear();
				textFieldCSIMemberLName.clear();
				textFieldCSIServProvLName.clear();
				textFieldCSIServProvFName.clear();
				textFieldCSIBillingProvLName.clear();
				textFieldCSIBillingProvFName.clear();
				textFieldCSIBillingProvider.clear();
			}
		});
		CSI.getChildren().addAll(rectCSIBorder,rectCSITop,textCSITop,HomelinkCSI,textCSIBillingProvider,textFieldCSIBillingProvider,textCSIServicingProvider,textFieldCSIServicingProvider,
				textCSIServiceStartDT,CSIServiceStartDtPicker,textCSIServiceEndDT,CSIServiceEndDtPicker,textCSIBillingProv,textCSIServicingProv,textCSIServiceStart,textCSIServiceEnd,
				validateDataCSI,createESIDataCSI,processDataCSI,textCSIMemberFName,textFieldCSIMemberFName,textCSIMemberLName,textFieldCSIMemberLName
				,textCSIMemberID,textFieldCSIMemberID,textCSIMemberDOB,textFieldCSIMemberDOB,textCSIClaimID,textFieldCSIClaimID,textCSIstarMemID,textCSIstarMemDOB,
				textCSIBillingProvFName,textFieldCSIBillingProvFName,textCSIBillingProvLName,textFieldCSIBillingProvLName,textCSIServProvFName,
				textFieldCSIServProvFName,textCSIServProvLName,textFieldCSIServProvLName);
		CSI.setStyle("-fx-background-color:WHITE");
		return CSI;
	}

}
