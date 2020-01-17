package EDI_Package;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import EDI_Package.Tool.PreAuthCol;
import EDI_Package.Tool.PreAuthRow;

public class class_PreCertAdd {
	static int dateofservicediffdays=0;
	public Pane PreCertAddCode (Pane PreAuthAdd,Stage primaryStage,Scene sceneBase)
	{
		Rectangle rectPreAuthAddTop = new Rectangle();
		rectPreAuthAddTop.setX(0.0f);
		rectPreAuthAddTop.setY(0.0f);
		rectPreAuthAddTop.setWidth(1360.0f);
		rectPreAuthAddTop.setHeight(60.0f);
		rectPreAuthAddTop.setFill(Color.STEELBLUE);
		rectPreAuthAddTop.setStroke(Color.STEELBLUE);
		//Boundary
		Rectangle rectPreAuthAddBorder = new Rectangle();
		rectPreAuthAddBorder.setX(1.5f);
		rectPreAuthAddBorder.setY(0.0f);
		rectPreAuthAddBorder.setWidth(1356.0f);
		rectPreAuthAddBorder.setHeight(682.0f);
		rectPreAuthAddBorder.setFill(Color.WHITE);
		rectPreAuthAddBorder.setStroke(Color.STEELBLUE);
		//Text Top Eligibility
		Text textPreAuthAddTop = new Text();
		textPreAuthAddTop.setText("Pre-Authorization Add");
		textPreAuthAddTop.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 24));
		textPreAuthAddTop.setFill(Color.WHITE);
		textPreAuthAddTop.setLayoutX(560);
		textPreAuthAddTop.setLayoutY(40);

		//Home Link
		Hyperlink HomelinkPreAuthAdd = new Hyperlink();
		HomelinkPreAuthAdd.setText("Home");
		HomelinkPreAuthAdd.setStyle("-fx-text-fill: YELLOW;");
		HomelinkPreAuthAdd.setLayoutX(1300);
		HomelinkPreAuthAdd.setLayoutY(2);
		HomelinkPreAuthAdd.setUnderline(false);
		HomelinkPreAuthAdd.setFocusTraversable(false);
		HomelinkPreAuthAdd.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 14));

		//Member F name Referral Inq Text
		Text textPreAuthAddMemberFName = new Text();
		textPreAuthAddMemberFName.setText("Member "+'\n'+"First Name");
		textPreAuthAddMemberFName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddMemberFName.setFill(Color.BLACK);
		textPreAuthAddMemberFName.setLayoutX(100);
		textPreAuthAddMemberFName.setLayoutY(95);
		//Member F name textfield
		TextField textFieldMemberFNamePreAuthAdd = new TextField();
		textFieldMemberFNamePreAuthAdd.setLayoutX(250);
		textFieldMemberFNamePreAuthAdd.setLayoutY(84);
		textFieldMemberFNamePreAuthAdd.setPrefWidth(300);
		textFieldMemberFNamePreAuthAdd.setPrefHeight(35);
		textFieldMemberFNamePreAuthAdd.setEditable(true);
		textFieldMemberFNamePreAuthAdd.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldProviderNameProviderInq.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldMemberFNamePreAuthAdd.setTooltip(new Tooltip("Enter First Name"));
		textFieldMemberFNamePreAuthAdd.setPromptText("Member First Name");
		//textFieldMemberFNameProviderInq.setText("GATEWAY QES");

		//Member L name Referral Inq Text
		Text textPreAuthAddMemberLName = new Text();
		textPreAuthAddMemberLName.setText("Member "+'\n'+"Last Name");
		textPreAuthAddMemberLName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddMemberLName.setFill(Color.BLACK);
		textPreAuthAddMemberLName.setLayoutX(775);
		textPreAuthAddMemberLName.setLayoutY(95);
		//Member L name textfield
		TextField textFieldMemberLNamePreAuthAdd = new TextField();
		textFieldMemberLNamePreAuthAdd.setLayoutX(925);
		textFieldMemberLNamePreAuthAdd.setLayoutY(84);
		textFieldMemberLNamePreAuthAdd.setPrefWidth(300);
		textFieldMemberLNamePreAuthAdd.setPrefHeight(35);
		textFieldMemberLNamePreAuthAdd.setEditable(true);
		textFieldMemberLNamePreAuthAdd.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldProviderNameProviderInq.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldMemberLNamePreAuthAdd.setTooltip(new Tooltip("Enter Last Name"));
		textFieldMemberLNamePreAuthAdd.setPromptText("Member Last Name");
		//textFieldMemberFNameProviderInq.setText("GATEWAY QES");


		textFieldMemberFNamePreAuthAdd.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldMemberFNamePreAuthAdd.getText().length() >= 35) {
						textFieldMemberFNamePreAuthAdd.setText(textFieldMemberFNamePreAuthAdd.getText().substring(0, 35));
					}
				}
			}
		});
		textFieldMemberLNamePreAuthAdd.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldMemberLNamePreAuthAdd.getText().length() >= 60) {
						textFieldMemberLNamePreAuthAdd.setText(textFieldMemberLNamePreAuthAdd.getText().substring(0, 60));
					}
				}
			}
		});


		//Text Member ID Name Referral Inq
		Text textPreAuthAddMemberID = new Text();
		textPreAuthAddMemberID.setText("Member ID");
		textPreAuthAddMemberID.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddMemberID.setFill(Color.BLACK);
		textPreAuthAddMemberID.setLayoutX(100);
		textPreAuthAddMemberID.setLayoutY(165);
		//* mark
		Text textPreAuthAddMemberIDstar = new Text();
		textPreAuthAddMemberIDstar.setText("*");
		textPreAuthAddMemberIDstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddMemberIDstar.setFill(Color.RED);
		textPreAuthAddMemberIDstar.setLayoutX(190);
		textPreAuthAddMemberIDstar.setLayoutY(165);

		TextField textFieldMemberIDPreAuthAdd = new TextField();
		textFieldMemberIDPreAuthAdd.setLayoutX(250);
		textFieldMemberIDPreAuthAdd.setLayoutY(144);
		textFieldMemberIDPreAuthAdd.setPrefWidth(300);
		textFieldMemberIDPreAuthAdd.setPrefHeight(35);
		textFieldMemberIDPreAuthAdd.setEditable(true);
		textFieldMemberIDPreAuthAdd.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldProviderNameProviderInq.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldMemberIDPreAuthAdd.setTooltip(new Tooltip("Enter Member ID"));
		textFieldMemberIDPreAuthAdd.setPromptText("Member ID");
		//textFieldMemberFNameProviderInq.setText("GATEWAY QES");

		//Member ID Limit
		textFieldMemberIDPreAuthAdd.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldMemberIDPreAuthAdd.getText().length() >= 10) {
						textFieldMemberIDPreAuthAdd.setText(textFieldMemberIDPreAuthAdd.getText().substring(0, 10));
					}
				}
			}
		});



		//Text MemberDOB Name Eligibility
		Text textPreAuthAddMemberDOB = new Text();
		textPreAuthAddMemberDOB.setText("Member /"+'\n'+"Dependent DOB");
		textPreAuthAddMemberDOB.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddMemberDOB.setFill(Color.BLACK);
		textPreAuthAddMemberDOB.setLayoutX(100);
		textPreAuthAddMemberDOB.setLayoutY(215);
		//* mark
		Text textPreAuthAddMemerDOBstar = new Text();
		textPreAuthAddMemerDOBstar.setText("*");
		textPreAuthAddMemerDOBstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddMemerDOBstar.setFill(Color.RED);
		textPreAuthAddMemerDOBstar.setLayoutX(180);
		textPreAuthAddMemerDOBstar.setLayoutY(215);
		//Date Picker
		DatePicker PreAuthAddMemberDOBPicker = new DatePicker();
		PreAuthAddMemberDOBPicker.setLayoutX(250);
		PreAuthAddMemberDOBPicker.setLayoutY(204);
		PreAuthAddMemberDOBPicker.setPrefWidth(300);
		PreAuthAddMemberDOBPicker.setPrefHeight(35);
		PreAuthAddMemberDOBPicker.setPromptText("MM/DD/YYYY");
		PreAuthAddMemberDOBPicker.setTooltip(new Tooltip("Enter Member DOB"));
		PreAuthAddMemberDOBPicker.setEditable(false);
		PreAuthAddMemberDOBPicker.setStyle("-fx-font: 18px \"Calibri\";");
		PreAuthAddMemberDOBPicker.setOnAction(e ->
		{
			LocalDate date = PreAuthAddMemberDOBPicker.getValue();
		});


		//Text Member IS Name Referral Inq
		Text textPreAuthAddReqMemberIs = new Text();
		textPreAuthAddReqMemberIs.setText("Member Is");
		textPreAuthAddReqMemberIs.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddReqMemberIs.setFill(Color.BLACK);
		textPreAuthAddReqMemberIs.setLayoutX(775);
		textPreAuthAddReqMemberIs.setLayoutY(165);
		//Combobix Member Is
		ComboBox<String> IsMemberComboBoxPreAuthAdd = new ComboBox<String>();
		IsMemberComboBoxPreAuthAdd.getItems().addAll("Subscriber","Dependent");
		IsMemberComboBoxPreAuthAdd.setEditable(false); 
		IsMemberComboBoxPreAuthAdd.setMinWidth(300);
		IsMemberComboBoxPreAuthAdd.setMinHeight(35);
		IsMemberComboBoxPreAuthAdd.setLayoutX(925);
		IsMemberComboBoxPreAuthAdd.setLayoutY(144);
		IsMemberComboBoxPreAuthAdd.setTooltip(new Tooltip("Select Member Type"));
		IsMemberComboBoxPreAuthAdd.setValue("Subscriber");;
		IsMemberComboBoxPreAuthAdd.setStyle("-fx-font: 18px \"Calibri\";");



		//Member F name Referral Inq Text
		Text textPreAuthAddDependentFName = new Text();
		textPreAuthAddDependentFName.setText("Dependent "+'\n'+"First Name");
		textPreAuthAddDependentFName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddDependentFName.setFill(Color.BLACK);
		textPreAuthAddDependentFName.setLayoutX(775);
		textPreAuthAddDependentFName.setLayoutY(215);

		Text textPreAuthAddDependentFNAmestar = new Text();
		textPreAuthAddDependentFNAmestar.setText("*");
		textPreAuthAddDependentFNAmestar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddDependentFNAmestar.setFill(Color.RED);
		textPreAuthAddDependentFNAmestar.setLayoutX(865);
		textPreAuthAddDependentFNAmestar.setLayoutY(215);
		//Member F name textfield
		TextField textFieldDependentFNamePreAuthAdd = new TextField();
		textFieldDependentFNamePreAuthAdd.setLayoutX(925);
		textFieldDependentFNamePreAuthAdd.setLayoutY(204);
		textFieldDependentFNamePreAuthAdd.setPrefWidth(300);
		textFieldDependentFNamePreAuthAdd.setPrefHeight(35);
		textFieldDependentFNamePreAuthAdd.setEditable(true);
		textFieldDependentFNamePreAuthAdd.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldProviderNameProviderInq.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldDependentFNamePreAuthAdd.setTooltip(new Tooltip("Enter First Name"));
		textFieldDependentFNamePreAuthAdd.setPromptText("Dependent First Name");
		//textFieldMemberFNameProviderInq.setText("GATEWAY QES");

		//Member L name Referral Inq Text
		Text textPreAuthAddDependentLName = new Text();
		textPreAuthAddDependentLName.setText("Dependent "+'\n'+"Last Name");
		textPreAuthAddDependentLName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddDependentLName.setFill(Color.BLACK);
		textPreAuthAddDependentLName.setLayoutX(100);
		textPreAuthAddDependentLName.setLayoutY(275);
		//Member L name textfield
		TextField textFieldDependentLNamePreAuthAdd = new TextField();
		textFieldDependentLNamePreAuthAdd.setLayoutX(250);
		textFieldDependentLNamePreAuthAdd.setLayoutY(264);
		textFieldDependentLNamePreAuthAdd.setPrefWidth(300);
		textFieldDependentLNamePreAuthAdd.setPrefHeight(35);
		textFieldDependentLNamePreAuthAdd.setEditable(true);
		textFieldDependentLNamePreAuthAdd.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldDependentLNamePreAuthAdd.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldDependentLNamePreAuthAdd.setTooltip(new Tooltip("Enter Last Name"));
		textFieldDependentLNamePreAuthAdd.setPromptText("Dependent Last Name");
		//textFieldMemberFNameProviderInq.setText("GATEWAY QES");


		textFieldDependentFNamePreAuthAdd.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldDependentFNamePreAuthAdd.getText().length() >= 35) {
						textFieldDependentFNamePreAuthAdd.setText(textFieldDependentFNamePreAuthAdd.getText().substring(0, 35));
					}
				}
			}
		});
		textFieldDependentLNamePreAuthAdd.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldDependentLNamePreAuthAdd.getText().length() >= 60) {
						textFieldDependentLNamePreAuthAdd.setText(textFieldDependentLNamePreAuthAdd.getText().substring(0, 60));
					}
				}
			}
		});

		textFieldDependentLNamePreAuthAdd.setDisable(true);
		textFieldDependentFNamePreAuthAdd.setDisable(true);

		IsMemberComboBoxPreAuthAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(IsMemberComboBoxPreAuthAdd.getValue().equalsIgnoreCase("Dependent"))
				{
					textFieldDependentLNamePreAuthAdd.setDisable(false);
					textFieldDependentFNamePreAuthAdd.setDisable(false);					
				}
				else
				{
					textFieldDependentLNamePreAuthAdd.setDisable(true);
					textFieldDependentFNamePreAuthAdd.setDisable(true);
				}
			}
		});

		//Text MemberDOB Name Eligibility
		Text textPreAuthAddDOS = new Text();
		textPreAuthAddDOS.setText("Date Of Service");
		textPreAuthAddDOS.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddDOS.setFill(Color.BLACK);
		textPreAuthAddDOS.setLayoutX(775);
		textPreAuthAddDOS.setLayoutY(285);
		//* mark
		Text textPreAuthAddDOSstar = new Text();
		textPreAuthAddDOSstar.setText("*");
		textPreAuthAddDOSstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddDOSstar.setFill(Color.RED);
		textPreAuthAddDOSstar.setLayoutX(893);
		textPreAuthAddDOSstar.setLayoutY(285);
		//Date Picker
		DatePicker PreAuthAddMemberDOSPicker = new DatePicker();
		PreAuthAddMemberDOSPicker.setLayoutX(925);
		PreAuthAddMemberDOSPicker.setLayoutY(264);
		PreAuthAddMemberDOSPicker.setPrefWidth(300);
		PreAuthAddMemberDOSPicker.setPrefHeight(35);
		PreAuthAddMemberDOSPicker.setPromptText("MM/DD/YYYY");
		//startDatePicker.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		PreAuthAddMemberDOSPicker.setTooltip(new Tooltip("Enter Member DOB"));
		PreAuthAddMemberDOSPicker.setEditable(false);
		PreAuthAddMemberDOSPicker.setStyle("-fx-font: 18px \"Calibri\";");

		PreAuthAddMemberDOSPicker.setOnAction(e ->
		{
			LocalDate date = PreAuthAddMemberDOSPicker.getValue();
			Date date1 = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
			Date date2 = new Date(System.currentTimeMillis());
			long diff = date1.getTime() - date2.getTime();
			dateofservicediffdays = (int) (diff / (1000*60*60*24));
			if(!(dateofservicediffdays>=0 && dateofservicediffdays<=90))
			{
				Alert alert=new Alert(AlertType.WARNING);
				alert.setTitle("Date Of Service");
				alert.setContentText("Date Of Service should be within 90 days from today.");
				alert.showAndWait();
			}
		});


		//Member F name Referral Inq Text
		Text textPreAuthAddReqProvFName = new Text();
		textPreAuthAddReqProvFName.setText("Requesting Provider"+'\n'+"First Name");
		textPreAuthAddReqProvFName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddReqProvFName.setFill(Color.BLACK);
		textPreAuthAddReqProvFName.setLayoutX(95);
		textPreAuthAddReqProvFName.setLayoutY(335);
		//Member F name textfield
		TextField textFieldReqProvFNamePreAuthAdd = new TextField();
		textFieldReqProvFNamePreAuthAdd.setLayoutX(250);
		textFieldReqProvFNamePreAuthAdd.setLayoutY(324);
		textFieldReqProvFNamePreAuthAdd.setPrefWidth(300);
		textFieldReqProvFNamePreAuthAdd.setPrefHeight(35);
		textFieldReqProvFNamePreAuthAdd.setEditable(true);
		textFieldReqProvFNamePreAuthAdd.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldProviderNameProviderInq.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldReqProvFNamePreAuthAdd.setTooltip(new Tooltip("Enter First Name"));
		textFieldReqProvFNamePreAuthAdd.setPromptText("Requesting Provider First Name");
		//textFieldMemberFNameProviderInq.setText("GATEWAY QES");

		//Member L name Referral Inq Text
		Text textPreAuthAddReqProvLName = new Text();
		textPreAuthAddReqProvLName.setText("Requesting Provider"+'\n'+"Last Name");
		textPreAuthAddReqProvLName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddReqProvLName.setFill(Color.BLACK);
		textPreAuthAddReqProvLName.setLayoutX(770);
		textPreAuthAddReqProvLName.setLayoutY(335);
		//Member L name textfield
		TextField textFieldReqProvLNamePreAuthAdd = new TextField();
		textFieldReqProvLNamePreAuthAdd.setLayoutX(925);
		textFieldReqProvLNamePreAuthAdd.setLayoutY(324);
		textFieldReqProvLNamePreAuthAdd.setPrefWidth(300);
		textFieldReqProvLNamePreAuthAdd.setPrefHeight(35);
		textFieldReqProvLNamePreAuthAdd.setEditable(true);
		textFieldReqProvLNamePreAuthAdd.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldProviderNameProviderInq.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldReqProvLNamePreAuthAdd.setTooltip(new Tooltip("Enter Last Name"));
		textFieldReqProvLNamePreAuthAdd.setPromptText("Requesting Provider Last Name");
		//textFieldMemberFNameProviderInq.setText("GATEWAY QES");


		textFieldReqProvFNamePreAuthAdd.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldReqProvFNamePreAuthAdd.getText().length() >= 35) {
						textFieldReqProvFNamePreAuthAdd.setText(textFieldReqProvFNamePreAuthAdd.getText().substring(0, 35));
					}
				}
			}
		});
		textFieldReqProvLNamePreAuthAdd.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldReqProvLNamePreAuthAdd.getText().length() >= 60) {
						textFieldReqProvLNamePreAuthAdd.setText(textFieldReqProvLNamePreAuthAdd.getText().substring(0, 60));
					}
				}
			}
		});


		//Text payer Name Referral Inq
		Text textPreAuthAddReqProviderNPI = new Text();
		textPreAuthAddReqProviderNPI.setText("Requesting "+'\n'+"Provider NPI");
		textPreAuthAddReqProviderNPI.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddReqProviderNPI.setFill(Color.BLACK);
		textPreAuthAddReqProviderNPI.setLayoutX(100);
		textPreAuthAddReqProviderNPI.setLayoutY(395);

		Text textPreAuthAddReqProviderstar = new Text();
		textPreAuthAddReqProviderstar.setText("*");
		textPreAuthAddReqProviderstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textPreAuthAddReqProviderstar.setFill(Color.RED);
		textPreAuthAddReqProviderstar.setLayoutX(188);
		textPreAuthAddReqProviderstar.setLayoutY(395);

		//TextField Payer
		TextField textFieldPreAuthAddProviderNPI = new TextField();
		textFieldPreAuthAddProviderNPI.setLayoutX(250);
		textFieldPreAuthAddProviderNPI.setLayoutY(384);
		textFieldPreAuthAddProviderNPI.setPrefWidth(300);
		textFieldPreAuthAddProviderNPI.setPrefHeight(35);
		textFieldPreAuthAddProviderNPI.setEditable(true);
		textFieldPreAuthAddProviderNPI.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		//textFieldPreAuthAddProviderNPI.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldPreAuthAddProviderNPI.setTooltip(new Tooltip("Enter Requesting Provider NPI : Numeric Values Only"));
		textFieldPreAuthAddProviderNPI.setPromptText("Requesting Provider NPI");

		textFieldPreAuthAddProviderNPI.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldPreAuthAddProviderNPI.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldPreAuthAddProviderNPI.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});


		//Text State ClaimOne
		Text textPreAuthAddPOS = new Text();
		textPreAuthAddPOS.setText("Place of Service");
		textPreAuthAddPOS.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textPreAuthAddPOS.setFill(Color.BLACK);
		textPreAuthAddPOS.setLayoutX(775);
		textPreAuthAddPOS.setLayoutY(405);
		textPreAuthAddPOS.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		//Combobox Patient State Claim One
		ComboBox<String> PreAuthAddPOSCombo = new ComboBox<String>();
		PreAuthAddPOSCombo.getItems().addAll("Office","Inpatient Hospital","On Campus-Outpatient Hospital","Ambulatory Surgical Center","Skilled Nursing Facility");
		PreAuthAddPOSCombo.setEditable(false); 
		PreAuthAddPOSCombo.setMinWidth(300);
		PreAuthAddPOSCombo.setMinHeight(35);
		PreAuthAddPOSCombo.setLayoutX(925);
		PreAuthAddPOSCombo.setLayoutY(384);
		PreAuthAddPOSCombo.setTooltip(new Tooltip("Select Place of Service"));
		PreAuthAddPOSCombo.setValue("Select");;
		PreAuthAddPOSCombo.setStyle("-fx-font: 18px \"Calibri\";");


		TableView<PreAuthCol> tablePreAuthAddOne = new TableView<>();
		tablePreAuthAddOne.setEditable(true);
		ObservableList<PreAuthCol> datatablePreAuthAddOne =FXCollections.observableArrayList(new PreAuthCol("05/05/2017", "08/08/2017", "ABC","DEF"));

		tablePreAuthAddOne.setLayoutX(100);
		tablePreAuthAddOne.setLayoutY(430);

		TableColumn PreAuthAddfirstcol = new TableColumn("");
		PreAuthAddfirstcol.setMinWidth(150);
		PreAuthAddfirstcol.setCellValueFactory(new PropertyValueFactory<>("blank"));

		TableColumn PreAuthAddSecondcol = new TableColumn("Attending Provider");
		PreAuthAddSecondcol.setMinWidth(200);
		PreAuthAddSecondcol.setCellValueFactory(new PropertyValueFactory<>("AttendingProvider"));

		TableColumn PreAuthAddThirdcol = new TableColumn("Facility Provider");
		PreAuthAddThirdcol.setMinWidth(200);
		PreAuthAddThirdcol.setCellValueFactory(new PropertyValueFactory<>("FacilityProvider"));

		TableColumn PreAuthAddFourthcol = new TableColumn("Admitting Provider");
		PreAuthAddFourthcol.setMinWidth(200);
		PreAuthAddFourthcol.setCellValueFactory(new PropertyValueFactory<>("AdmittingProvider"));		

		tablePreAuthAddOne.setItems(datatablePreAuthAddOne);
		tablePreAuthAddOne.setMaxHeight(20);
		tablePreAuthAddOne.getColumns().addAll(PreAuthAddfirstcol, PreAuthAddSecondcol,PreAuthAddThirdcol,PreAuthAddFourthcol);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		TableView<PreAuthRow> tablePreAuthAddTwo= new TableView<>();
		tablePreAuthAddTwo.setEditable(false);
		ObservableList<PreAuthRow> datatablePreAuthAddTwo =FXCollections.observableArrayList(new PreAuthRow("EF"));
		tablePreAuthAddTwo.setLayoutX(100);
		tablePreAuthAddTwo.setLayoutY(455);
		TableColumn PreAuthAddfirstrow = new TableColumn("First Name");
		PreAuthAddfirstrow.setMinWidth(150);
		PreAuthAddfirstrow.setMaxWidth(150);
		PreAuthAddfirstrow.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
		tablePreAuthAddTwo.setItems(datatablePreAuthAddTwo);
		tablePreAuthAddTwo.setMaxHeight(20);
		tablePreAuthAddTwo.setMaxWidth(151);
		tablePreAuthAddTwo.setMinWidth(151);
		tablePreAuthAddTwo.getColumns().add(PreAuthAddfirstrow);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		TableView<PreAuthRow> tablePreAuthAddThree= new TableView<>();
		tablePreAuthAddThree.setEditable(false);
		ObservableList<PreAuthRow> datatablePreAuthAddThree =FXCollections.observableArrayList(new PreAuthRow("EF"));
		tablePreAuthAddThree.setLayoutX(100);
		tablePreAuthAddThree.setLayoutY(480);
		TableColumn PreAuthAddSecondrow = new TableColumn("Last Name");
		PreAuthAddSecondrow.setMinWidth(150);
		PreAuthAddSecondrow.setMaxWidth(150);
		PreAuthAddSecondrow.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
		tablePreAuthAddThree.setItems(datatablePreAuthAddThree);
		tablePreAuthAddThree.setMaxHeight(20);
		tablePreAuthAddThree.setMaxWidth(151);
		tablePreAuthAddThree.setMinWidth(151);
		tablePreAuthAddThree.getColumns().add(PreAuthAddSecondrow);
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		TableView<PreAuthRow> tablePreAuthAddFour= new TableView<>();
		tablePreAuthAddFour.setEditable(false);
		ObservableList<PreAuthRow> datatablePreAuthAddFour =FXCollections.observableArrayList(new PreAuthRow("EF"));
		tablePreAuthAddFour.setLayoutX(100);
		tablePreAuthAddFour.setLayoutY(505);
		TableColumn PreAuthAddThirdrow = new TableColumn("NPI");
		PreAuthAddThirdrow.setMinWidth(150);
		PreAuthAddThirdrow.setMaxWidth(150);
		PreAuthAddThirdrow.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
		tablePreAuthAddFour.setItems(datatablePreAuthAddFour);
		tablePreAuthAddFour.setMaxHeight(20);
		tablePreAuthAddFour.setMaxWidth(151);
		tablePreAuthAddFour.setMinWidth(151);
		tablePreAuthAddFour.getColumns().add(PreAuthAddThirdrow);
		////////////////////////

		Text textPreAuthAddNPItablestar = new Text();
		textPreAuthAddNPItablestar.setText("*");
		textPreAuthAddNPItablestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textPreAuthAddNPItablestar.setFill(Color.RED);
		textPreAuthAddNPItablestar.setLayoutX(190);
		textPreAuthAddNPItablestar.setLayoutY(520);


		TextField PreAuthAddRow1col1 = new TextField();
		PreAuthAddRow1col1.setLayoutX(251);
		PreAuthAddRow1col1.setLayoutY(455);
		PreAuthAddRow1col1.setPrefWidth(201);
		PreAuthAddRow1col1.setPrefHeight(19);
		PreAuthAddRow1col1.setEditable(true);
		PreAuthAddRow1col1.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		PreAuthAddRow1col1.setTooltip(new Tooltip("Enter Attending Provider First Name"));
		PreAuthAddRow1col1.setPromptText("Attending Provider First Name");

		TextField PreAuthAddRow1col2 = new TextField();
		PreAuthAddRow1col2.setLayoutX(452);
		PreAuthAddRow1col2.setLayoutY(455);
		PreAuthAddRow1col2.setPrefWidth(200);
		PreAuthAddRow1col2.setPrefHeight(19);
		PreAuthAddRow1col2.setEditable(true);
		PreAuthAddRow1col2.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		PreAuthAddRow1col2.setTooltip(new Tooltip("Enter Facility Provider First Name"));
		PreAuthAddRow1col2.setPromptText("Facility Provider First Name");

		TextField PreAuthAddRow1col3 = new TextField();
		PreAuthAddRow1col3.setLayoutX(652);
		PreAuthAddRow1col3.setLayoutY(455);
		PreAuthAddRow1col3.setPrefWidth(200);
		PreAuthAddRow1col3.setPrefHeight(19);
		PreAuthAddRow1col3.setEditable(true);
		PreAuthAddRow1col3.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		PreAuthAddRow1col3.setTooltip(new Tooltip("Enter Admitting Provider First Name"));
		PreAuthAddRow1col3.setPromptText("Admitting Provider First Name");

		TextField PreAuthAddRow2col1 = new TextField();
		PreAuthAddRow2col1.setLayoutX(251);
		PreAuthAddRow2col1.setLayoutY(480);
		PreAuthAddRow2col1.setPrefWidth(201);
		PreAuthAddRow2col1.setPrefHeight(19);
		PreAuthAddRow2col1.setEditable(true);
		PreAuthAddRow2col1.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		PreAuthAddRow2col1.setTooltip(new Tooltip("Enter Attending Provider Last Name"));
		PreAuthAddRow2col1.setPromptText("Attending Provider Last Name");

		TextField PreAuthAddRow2col2 = new TextField();
		PreAuthAddRow2col2.setLayoutX(452);
		PreAuthAddRow2col2.setLayoutY(480);
		PreAuthAddRow2col2.setPrefWidth(200);
		PreAuthAddRow2col2.setPrefHeight(19);
		PreAuthAddRow2col2.setEditable(true);
		PreAuthAddRow2col2.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		PreAuthAddRow2col2.setTooltip(new Tooltip("Enter Facility Provider Last Name"));
		PreAuthAddRow2col2.setPromptText("Facility Provider Last Name");

		TextField PreAuthAddRow2col3 = new TextField();
		PreAuthAddRow2col3.setLayoutX(652);
		PreAuthAddRow2col3.setLayoutY(480);
		PreAuthAddRow2col3.setPrefWidth(200);
		PreAuthAddRow2col3.setPrefHeight(19);
		PreAuthAddRow2col3.setEditable(true);
		PreAuthAddRow2col3.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		PreAuthAddRow2col3.setTooltip(new Tooltip("Enter Admitting Provider Last Name"));
		PreAuthAddRow2col3.setPromptText("Admitting Provider Last Name");

		TextField PreAuthAddRow3col1 = new TextField();
		PreAuthAddRow3col1.setLayoutX(251);
		PreAuthAddRow3col1.setLayoutY(505);
		PreAuthAddRow3col1.setPrefWidth(201);
		PreAuthAddRow3col1.setPrefHeight(19);
		PreAuthAddRow3col1.setEditable(true);
		PreAuthAddRow3col1.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		PreAuthAddRow3col1.setTooltip(new Tooltip("Enter Attending Provider NPI"));
		PreAuthAddRow3col1.setPromptText("Attending Provider NPI");

		TextField PreAuthAddRow3col2 = new TextField();
		PreAuthAddRow3col2.setLayoutX(452);
		PreAuthAddRow3col2.setLayoutY(505);
		PreAuthAddRow3col2.setPrefWidth(200);
		PreAuthAddRow3col2.setPrefHeight(19);
		PreAuthAddRow3col2.setEditable(true);
		PreAuthAddRow3col2.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		PreAuthAddRow3col2.setTooltip(new Tooltip("Enter Facility Provider NPI"));
		PreAuthAddRow3col2.setPromptText("Facility Provider NPI");

		TextField PreAuthAddRow3col3 = new TextField();
		PreAuthAddRow3col3.setLayoutX(652);
		PreAuthAddRow3col3.setLayoutY(505);
		PreAuthAddRow3col3.setPrefWidth(200);
		PreAuthAddRow3col3.setPrefHeight(19);
		PreAuthAddRow3col3.setEditable(true);
		PreAuthAddRow3col3.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		PreAuthAddRow3col3.setTooltip(new Tooltip("Enter Admitting Provider NPI"));
		PreAuthAddRow3col3.setPromptText("Admitting Provider NPI");

		PreAuthAddRow3col1.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && PreAuthAddRow3col1.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						PreAuthAddRow3col1.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});

		PreAuthAddRow3col2.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && PreAuthAddRow3col2.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						PreAuthAddRow3col2.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});

		PreAuthAddRow3col3.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && PreAuthAddRow3col3.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						PreAuthAddRow3col3.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});

		PreAuthAddRow1col1.setDisable(true);
		PreAuthAddRow1col2.setDisable(true);
		PreAuthAddRow1col3.setDisable(true);
		PreAuthAddRow2col1.setDisable(true);
		PreAuthAddRow2col2.setDisable(true);
		PreAuthAddRow2col3.setDisable(true);
		PreAuthAddRow3col1.setDisable(true);
		PreAuthAddRow3col2.setDisable(true);
		PreAuthAddRow3col3.setDisable(true);

		Text textPreAuthAddBedType = new Text();
		textPreAuthAddBedType.setText("Bed Type");
		textPreAuthAddBedType.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textPreAuthAddBedType.setFill(Color.BLACK);
		textPreAuthAddBedType.setLayoutX(920);
		textPreAuthAddBedType.setLayoutY(468);
		//textPreAuthAddBedType.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		//Combobox Patient State Claim One
		ComboBox<String> PreAuthAddPOSBedType = new ComboBox<String>();
		PreAuthAddPOSBedType.getItems().addAll("01- Medical Care","02- Surgical","03- Consultation","04- Diagnostic X-Ray","05- Diagnostic Lab","06- Radiation Therapy","07- Anesthesia","08- Surgical Assistance","11- Used Durable Medical Equipment","12- Durable Medical Equipment Purchase","14- Renal Supplies in the Home","15- Alternate Method Dialysis","16- Chronic Renal Disease (CRD) Equipment","17- Pre-Admission Testing","18- Durable Medical Equipment Rental","20- Second Surgical Opinion","21- Third Surgical Opinion","23- Diagnostic Dental","24- Periodontics","25- Restorative","26- Endodontics","27- Maxillofacial Prosthetics","28- Adjunctive Dental Services","33- Chiropractic","35- Dental Care","36- Dental Crowns","37- Dental Accident","38- Orthodontics","39- Prosthodontics","40- Oral Surgery","42- Home Health Care","44- Home Health Visits","45- Hospice","46- Respite Care","54- Long Term Care",
				"56- Medically Related Transportation","61- In-vitro Fertilization","62- MRI/CAT Scan","63- Donor Procedures","64- Acupuncture","65-Newborn Care","66- Pathology","67- Smoking Cessation","68- Well Baby Care","69- Maternity","70- Transplants","71- Audiology Exam","72- Inhalation Therapy","73- Diagnostic Medical","74- Private Duty Nursing","75- Prosthetic Device","76- Dialysis","77- Otological Exam","78- Chemotherapy","79- Allergy Testing","80- Immunizations","82- Family Planning","83- Infertility","84- Abortion","85- AIDS","86- Emergency Services","88- Pharmacy","93- Podiatry","A4- Psychiatric","A6- Psychotherapy","A9- Rehabilitation","AD- Occupational Therapy","AE- Physical Medicine","AF- Speech Therapy","AG- Skilled Nursing Care","AI- Substance Abuse","AJ- Alcoholism","AK- Drug Addiction","AL- Vision (Optometry)","AR- Experimental Drug Therapy","B1- Burn Care","BB- Partial Hospitalization (Psychiatric)",
				"BC- Day Care (Psychiatric)","BD- Cognitive Therapy","BE- Massage Therapy","BF- Pulmonary Rehabilitation","BG- Cardiac Rehabilitation","BL- Cardiac","BN- Gastrointestinal","BP- Endocrine","BQ- Neurology","BS- Invasive Procedures","BY- Physician Visit - Office: Sick","BZ- Physician Visit - Office: Well","C1- Coronary Care","CQ- Case Management","GY- Allergy","IC- Intensive Care","MH- Mental Health","NI- Neonatal Intensive Care","ON- Oncology","PT- Physical Therapy","PU- Pulmonary","RN- Renal","RT- Residential Psychiatric Treatment","TC- Transitional Care","TN- Transitional Nursery Care");
		PreAuthAddPOSBedType.setEditable(false); 
		PreAuthAddPOSBedType.setMinWidth(190);
		PreAuthAddPOSBedType.setMaxWidth(190);
		PreAuthAddPOSBedType.setMinHeight(20);
		PreAuthAddPOSBedType.setLayoutX(1035);
		PreAuthAddPOSBedType.setLayoutY(449);
		PreAuthAddPOSBedType.setTooltip(new Tooltip("Select Bed Type"));
		PreAuthAddPOSBedType.setValue("Select");
		PreAuthAddPOSBedType.setStyle("-fx-font: 14px \"Calibri\";");
		PreAuthAddPOSBedType.setDisable(true);


		PreAuthAddPOSCombo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(PreAuthAddPOSCombo.getValue().equalsIgnoreCase("Office"))
				{
					PreAuthAddRow1col1.setDisable(false);
					PreAuthAddRow1col2.setDisable(false);
					PreAuthAddRow1col3.setDisable(false);
					PreAuthAddRow2col1.setDisable(false);
					PreAuthAddRow2col2.setDisable(false);
					PreAuthAddRow2col3.setDisable(false);
					PreAuthAddRow3col1.setDisable(false);
					PreAuthAddRow3col2.setDisable(false);
					PreAuthAddRow3col3.setDisable(false);
					PreAuthAddPOSBedType.setDisable(false);
				}
				else if(PreAuthAddPOSCombo.getValue().equalsIgnoreCase("Inpatient Hospital"))
				{
					PreAuthAddRow1col1.setDisable(false);
					PreAuthAddRow1col2.setDisable(false);
					PreAuthAddRow1col3.setDisable(false);
					PreAuthAddRow2col1.setDisable(false);
					PreAuthAddRow2col2.setDisable(false);
					PreAuthAddRow2col3.setDisable(false);
					PreAuthAddRow3col1.setDisable(false);
					PreAuthAddRow3col2.setDisable(false);
					PreAuthAddRow3col3.setDisable(false);
					PreAuthAddPOSBedType.setDisable(false);
				}
				else if(PreAuthAddPOSCombo.getValue().equalsIgnoreCase("On Campus-Outpatient Hospital"))
				{
					PreAuthAddRow1col1.setDisable(false);
					PreAuthAddRow1col2.setDisable(false);
					PreAuthAddRow1col3.setDisable(true);
					PreAuthAddRow2col1.setDisable(false);
					PreAuthAddRow2col2.setDisable(false);
					PreAuthAddRow2col3.setDisable(true);
					PreAuthAddRow3col1.setDisable(false);
					PreAuthAddRow3col2.setDisable(false);
					PreAuthAddRow3col3.setDisable(true);
					PreAuthAddPOSBedType.setDisable(true);
				}
				else if(PreAuthAddPOSCombo.getValue().equalsIgnoreCase("Ambulatory Surgical Center"))
				{
					PreAuthAddRow1col1.setDisable(false);
					PreAuthAddRow1col2.setDisable(false);
					PreAuthAddRow1col3.setDisable(false);
					PreAuthAddRow2col1.setDisable(false);
					PreAuthAddRow2col2.setDisable(false);
					PreAuthAddRow2col3.setDisable(false);
					PreAuthAddRow3col1.setDisable(false);
					PreAuthAddRow3col2.setDisable(false);
					PreAuthAddRow3col3.setDisable(false);
					PreAuthAddPOSBedType.setDisable(false);
				}
				else if(PreAuthAddPOSCombo.getValue().equalsIgnoreCase("Skilled Nursing Facility"))
				{
					PreAuthAddRow1col1.setDisable(false);
					PreAuthAddRow1col2.setDisable(false);
					PreAuthAddRow1col3.setDisable(false);
					PreAuthAddRow2col1.setDisable(false);
					PreAuthAddRow2col2.setDisable(false);
					PreAuthAddRow2col3.setDisable(false);
					PreAuthAddRow3col1.setDisable(false);
					PreAuthAddRow3col2.setDisable(false);
					PreAuthAddRow3col3.setDisable(false);
					PreAuthAddPOSBedType.setDisable(false);
				}	
				else
				{
					PreAuthAddRow1col1.setDisable(true);
					PreAuthAddRow1col2.setDisable(true);
					PreAuthAddRow1col3.setDisable(true);
					PreAuthAddRow2col1.setDisable(true);
					PreAuthAddRow2col2.setDisable(true);
					PreAuthAddRow2col3.setDisable(true);
					PreAuthAddRow3col1.setDisable(true);
					PreAuthAddRow3col2.setDisable(true);
					PreAuthAddRow3col3.setDisable(true);
					PreAuthAddPOSBedType.setDisable(true);
				}
			}
		});

		Text textPreAuthAddHealthCareServices = new Text();
		textPreAuthAddHealthCareServices.setText("Health Care"+'\n'+"Services Delivery");
		textPreAuthAddHealthCareServices.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textPreAuthAddHealthCareServices.setFill(Color.BLACK);
		textPreAuthAddHealthCareServices.setLayoutX(920);
		textPreAuthAddHealthCareServices.setLayoutY(500);

		ComboBox<String> PreAuthAddPOSHealthServicesType = new ComboBox<String>();
		PreAuthAddPOSHealthServicesType.getItems().addAll("Days","Units","Hours","Month","Visits");
		PreAuthAddPOSHealthServicesType.setEditable(false); 
		PreAuthAddPOSHealthServicesType.setMinWidth(90);
		PreAuthAddPOSHealthServicesType.setMaxWidth(90);
		PreAuthAddPOSHealthServicesType.setMinHeight(20);
		PreAuthAddPOSHealthServicesType.setLayoutX(1035);
		PreAuthAddPOSHealthServicesType.setLayoutY(489);
		PreAuthAddPOSHealthServicesType.setTooltip(new Tooltip("Select Health Care Services Delivery"));
		PreAuthAddPOSHealthServicesType.setValue("Select");
		PreAuthAddPOSHealthServicesType.setStyle("-fx-font: 14px \"Calibri\";");
		//PreAuthAddPOSHealthServicesType.setDisable(true);

		//TextField Payer
		TextField textFieldPreAuthAddHealthServicesUnit = new TextField();
		textFieldPreAuthAddHealthServicesUnit.setLayoutX(1135);
		textFieldPreAuthAddHealthServicesUnit.setLayoutY(489);
		textFieldPreAuthAddHealthServicesUnit.setPrefWidth(90);
		textFieldPreAuthAddHealthServicesUnit.setPrefHeight(20);
		textFieldPreAuthAddHealthServicesUnit.setEditable(true);
		textFieldPreAuthAddHealthServicesUnit.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		//textFieldPreAuthAddProviderNPI.setStyle("-fx-text-inner-color: STEELBLUE;");
		textFieldPreAuthAddHealthServicesUnit.setTooltip(new Tooltip("Enter value"));
		textFieldPreAuthAddHealthServicesUnit.setPromptText("Value");
		textFieldPreAuthAddHealthServicesUnit.setDisable(true);

		textFieldPreAuthAddHealthServicesUnit.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldPreAuthAddHealthServicesUnit.getText().length()<=6) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldPreAuthAddHealthServicesUnit.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});

		PreAuthAddPOSHealthServicesType.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(PreAuthAddPOSHealthServicesType.getValue().equalsIgnoreCase("Select"))
				{
					textFieldPreAuthAddHealthServicesUnit.setDisable(true);
				}
				else
				{
					textFieldPreAuthAddHealthServicesUnit.setDisable(false);
				}
			}
		});

		Text textPreAuthAddDiagnosisProc = new Text();
		textPreAuthAddDiagnosisProc.setText("Procedure Codes");
		textPreAuthAddDiagnosisProc.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textPreAuthAddDiagnosisProc.setFill(Color.BLACK);
		textPreAuthAddDiagnosisProc.setLayoutX(100);
		textPreAuthAddDiagnosisProc.setLayoutY(595);

		Text textPreAuthAddProcCodeNameOne = new Text();
		textPreAuthAddProcCodeNameOne.setText("1.");
		textPreAuthAddProcCodeNameOne.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textPreAuthAddProcCodeNameOne.setFill(Color.BLACK);
		textPreAuthAddProcCodeNameOne.setLayoutX(130);
		textPreAuthAddProcCodeNameOne.setLayoutY(620);
		TextField textFieldPreAuthAddProcCodeOne = new TextField();
		textFieldPreAuthAddProcCodeOne.setLayoutX(150);
		textFieldPreAuthAddProcCodeOne.setLayoutY(603);
		textFieldPreAuthAddProcCodeOne.setPrefWidth(140);
		textFieldPreAuthAddProcCodeOne.setPrefHeight(25);
		textFieldPreAuthAddProcCodeOne.setEditable(true);
		textFieldPreAuthAddProcCodeOne.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldPreAuthAddProcCodeOne.setTooltip(new Tooltip("1st Procedure Code"));
		textFieldPreAuthAddProcCodeOne.setPromptText("1st Procedure Code");
		textFieldPreAuthAddProcCodeOne.setDisable(false);
		//
		Text textPreAuthAddProcCodeNameTwo = new Text();
		textPreAuthAddProcCodeNameTwo.setText("2.");
		textPreAuthAddProcCodeNameTwo.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textPreAuthAddProcCodeNameTwo.setFill(Color.BLACK);
		textPreAuthAddProcCodeNameTwo.setLayoutX(317);
		textPreAuthAddProcCodeNameTwo.setLayoutY(620);
		TextField textFieldPreAuthAddProcCodeTwo = new TextField();
		textFieldPreAuthAddProcCodeTwo.setLayoutX(337);
		textFieldPreAuthAddProcCodeTwo.setLayoutY(603);
		textFieldPreAuthAddProcCodeTwo.setPrefWidth(140);
		textFieldPreAuthAddProcCodeTwo.setPrefHeight(25);
		textFieldPreAuthAddProcCodeTwo.setEditable(true);
		textFieldPreAuthAddProcCodeTwo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldPreAuthAddProcCodeTwo.setTooltip(new Tooltip("2nd Procedure Code"));
		textFieldPreAuthAddProcCodeTwo.setPromptText("2nd Procedure Code");
		textFieldPreAuthAddProcCodeTwo.setDisable(true);
		//
		Text textPreAuthAddProcCodeNameThree = new Text();
		textPreAuthAddProcCodeNameThree.setText("3.");
		textPreAuthAddProcCodeNameThree.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textPreAuthAddProcCodeNameThree.setFill(Color.BLACK);
		textPreAuthAddProcCodeNameThree.setLayoutX(504);
		textPreAuthAddProcCodeNameThree.setLayoutY(620);
		TextField textFieldPreAuthAddProcCodeThree = new TextField();
		textFieldPreAuthAddProcCodeThree.setLayoutX(524);
		textFieldPreAuthAddProcCodeThree.setLayoutY(603);
		textFieldPreAuthAddProcCodeThree.setPrefWidth(140);
		textFieldPreAuthAddProcCodeThree.setPrefHeight(25);
		textFieldPreAuthAddProcCodeThree.setEditable(true);
		textFieldPreAuthAddProcCodeThree.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldPreAuthAddProcCodeThree.setTooltip(new Tooltip("3rd Procedure Code"));
		textFieldPreAuthAddProcCodeThree.setPromptText("3rd Procedure Code");
		textFieldPreAuthAddProcCodeThree.setDisable(true);
		//
		Text textPreAuthAddProcCodeNameFour = new Text();
		textPreAuthAddProcCodeNameFour.setText("4.");
		textPreAuthAddProcCodeNameFour.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textPreAuthAddProcCodeNameFour.setFill(Color.BLACK);
		textPreAuthAddProcCodeNameFour.setLayoutX(691);
		textPreAuthAddProcCodeNameFour.setLayoutY(620);
		TextField textFieldPreAuthAddProcCodeFour = new TextField();
		textFieldPreAuthAddProcCodeFour.setLayoutX(711);
		textFieldPreAuthAddProcCodeFour.setLayoutY(603);
		textFieldPreAuthAddProcCodeFour.setPrefWidth(140);
		textFieldPreAuthAddProcCodeFour.setPrefHeight(25);
		textFieldPreAuthAddProcCodeFour.setEditable(true);
		textFieldPreAuthAddProcCodeFour.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldPreAuthAddProcCodeFour.setTooltip(new Tooltip("4th Procedure Code"));
		textFieldPreAuthAddProcCodeFour.setPromptText("4th Procedure Code");
		textFieldPreAuthAddProcCodeFour.setDisable(true);
		//
		Text textPreAuthAddProcCodeNameFive = new Text();
		textPreAuthAddProcCodeNameFive.setText("5.");
		textPreAuthAddProcCodeNameFive.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textPreAuthAddProcCodeNameFive.setFill(Color.BLACK);
		textPreAuthAddProcCodeNameFive.setLayoutX(878);
		textPreAuthAddProcCodeNameFive.setLayoutY(620);
		TextField textFieldPreAuthAddProcCodeFive = new TextField();
		textFieldPreAuthAddProcCodeFive.setLayoutX(898);
		textFieldPreAuthAddProcCodeFive.setLayoutY(603);
		textFieldPreAuthAddProcCodeFive.setPrefWidth(140);
		textFieldPreAuthAddProcCodeFive.setPrefHeight(25);
		textFieldPreAuthAddProcCodeFive.setEditable(true);
		textFieldPreAuthAddProcCodeFive.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldPreAuthAddProcCodeFive.setTooltip(new Tooltip("5th Procedure Code"));
		textFieldPreAuthAddProcCodeFive.setPromptText("5th Procedure Code");
		textFieldPreAuthAddProcCodeFive.setDisable(true);

		textFieldPreAuthAddProcCodeOne.textProperty().addListener((observable, oldValue, newValue) -> {
			textFieldPreAuthAddProcCodeTwo.setDisable(false);
		});

		textFieldPreAuthAddProcCodeTwo.textProperty().addListener((observable, oldValue, newValue) -> {
			textFieldPreAuthAddProcCodeThree.setDisable(false);
		});
		textFieldPreAuthAddProcCodeThree.textProperty().addListener((observable, oldValue, newValue) -> {
			textFieldPreAuthAddProcCodeFour.setDisable(false);
		});
		textFieldPreAuthAddProcCodeFour.textProperty().addListener((observable, oldValue, newValue) -> {
			textFieldPreAuthAddProcCodeFive.setDisable(false);
		});


		Text textPreAuthAddDiagnosisCode = new Text();
		textPreAuthAddDiagnosisCode.setText("Diagnosis Codes");
		textPreAuthAddDiagnosisCode.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textPreAuthAddDiagnosisCode.setFill(Color.BLACK);
		textPreAuthAddDiagnosisCode.setLayoutX(100);
		textPreAuthAddDiagnosisCode.setLayoutY(545);

		Text textPreAuthAddDiacCodeNameOne = new Text();
		textPreAuthAddDiacCodeNameOne.setText("1.");
		textPreAuthAddDiacCodeNameOne.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textPreAuthAddDiacCodeNameOne.setFill(Color.BLACK);
		textPreAuthAddDiacCodeNameOne.setLayoutX(130);
		textPreAuthAddDiacCodeNameOne.setLayoutY(570);
		TextField textFieldPreAuthAddDiacCodeOne = new TextField();
		textFieldPreAuthAddDiacCodeOne.setLayoutX(150);
		textFieldPreAuthAddDiacCodeOne.setLayoutY(553);
		textFieldPreAuthAddDiacCodeOne.setPrefWidth(140);
		textFieldPreAuthAddDiacCodeOne.setPrefHeight(25);
		textFieldPreAuthAddDiacCodeOne.setEditable(true);
		textFieldPreAuthAddDiacCodeOne.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldPreAuthAddDiacCodeOne.setTooltip(new Tooltip("1st Diagnosis Code"));
		textFieldPreAuthAddDiacCodeOne.setPromptText("1st Diagnosis Code");
		textFieldPreAuthAddDiacCodeOne.setDisable(false);
		//
		Text textPreAuthAddDiacCodeNameTwo = new Text();
		textPreAuthAddDiacCodeNameTwo.setText("2.");
		textPreAuthAddDiacCodeNameTwo.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textPreAuthAddDiacCodeNameTwo.setFill(Color.BLACK);
		textPreAuthAddDiacCodeNameTwo.setLayoutX(317);
		textPreAuthAddDiacCodeNameTwo.setLayoutY(570);
		TextField textFieldPreAuthAddDiacCodeTwo = new TextField();
		textFieldPreAuthAddDiacCodeTwo.setLayoutX(337);
		textFieldPreAuthAddDiacCodeTwo.setLayoutY(553);
		textFieldPreAuthAddDiacCodeTwo.setPrefWidth(140);
		textFieldPreAuthAddDiacCodeTwo.setPrefHeight(25);
		textFieldPreAuthAddDiacCodeTwo.setEditable(true);
		textFieldPreAuthAddDiacCodeTwo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldPreAuthAddDiacCodeTwo.setTooltip(new Tooltip("2nd Diagnosis Code"));
		textFieldPreAuthAddDiacCodeTwo.setPromptText("2nd Diagnosis Code");
		textFieldPreAuthAddDiacCodeTwo.setDisable(true);
		//
		Text textPreAuthAddDiacCodeNameThree = new Text();
		textPreAuthAddDiacCodeNameThree.setText("3.");
		textPreAuthAddDiacCodeNameThree.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textPreAuthAddDiacCodeNameThree.setFill(Color.BLACK);
		textPreAuthAddDiacCodeNameThree.setLayoutX(504);
		textPreAuthAddDiacCodeNameThree.setLayoutY(570);
		TextField textFieldPreAuthAddDiacCodeThree = new TextField();
		textFieldPreAuthAddDiacCodeThree.setLayoutX(524);
		textFieldPreAuthAddDiacCodeThree.setLayoutY(553);
		textFieldPreAuthAddDiacCodeThree.setPrefWidth(140);
		textFieldPreAuthAddDiacCodeThree.setPrefHeight(25);
		textFieldPreAuthAddDiacCodeThree.setEditable(true);
		textFieldPreAuthAddDiacCodeThree.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldPreAuthAddDiacCodeThree.setTooltip(new Tooltip("3rd Diagnosis Code"));
		textFieldPreAuthAddDiacCodeThree.setPromptText("3rd Diagnosis Code");
		textFieldPreAuthAddDiacCodeThree.setDisable(true);

		textFieldPreAuthAddDiacCodeOne.textProperty().addListener((observable, oldValue, newValue) -> {
			textFieldPreAuthAddDiacCodeTwo.setDisable(false);
		});

		textFieldPreAuthAddDiacCodeTwo.textProperty().addListener((observable, oldValue, newValue) -> {
			textFieldPreAuthAddDiacCodeThree.setDisable(false);
		});

		//Validate Data Button
		Button validateDataPreAuthAdd = new Button();
		validateDataPreAuthAdd.setText("Validate Data");
		validateDataPreAuthAdd.setLayoutX(430);
		validateDataPreAuthAdd.setLayoutY(640);
		validateDataPreAuthAdd.setMinWidth(150);
		validateDataPreAuthAdd.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		validateDataPreAuthAdd.setTextFill(Color.STEELBLUE);
		validateDataPreAuthAdd.setStyle("-fx-background-color:STEELBLUE");
		validateDataPreAuthAdd.setTextFill(Color.WHITE);
		//Create EDI File Button
		Button CreateEDIFilePreAuthAdd = new Button();
		CreateEDIFilePreAuthAdd.setText("Create EDI Data");
		CreateEDIFilePreAuthAdd.setLayoutX(600);
		CreateEDIFilePreAuthAdd.setLayoutY(640);
		CreateEDIFilePreAuthAdd.setMinWidth(150);
		CreateEDIFilePreAuthAdd.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		CreateEDIFilePreAuthAdd.setStyle("-fx-background-color:STEELBLUE");
		CreateEDIFilePreAuthAdd.setTextFill(Color.WHITE);
		//Process EDI File Button
		Button ProcessEDIFilePreAuthAdd = new Button();
		ProcessEDIFilePreAuthAdd.setText("Process EDI Data");
		ProcessEDIFilePreAuthAdd.setLayoutX(770);
		ProcessEDIFilePreAuthAdd.setLayoutY(640);
		ProcessEDIFilePreAuthAdd.setMinWidth(150);
		ProcessEDIFilePreAuthAdd.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		ProcessEDIFilePreAuthAdd.setStyle("-fx-background-color:STEELBLUE");
		ProcessEDIFilePreAuthAdd.setTextFill(Color.WHITE);

		validateDataPreAuthAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(textFieldMemberIDPreAuthAdd.getText().isEmpty()==true ||
						(IsMemberComboBoxPreAuthAdd.getSelectionModel().getSelectedItem().equalsIgnoreCase("Dependent") 
								&& textFieldDependentFNamePreAuthAdd.getText().isEmpty()==true)||
								PreAuthAddMemberDOBPicker.getValue()==null ||
								PreAuthAddMemberDOSPicker.getValue()==null||
								textFieldPreAuthAddProviderNPI.getText().isEmpty()==true
								||(PreAuthAddRow3col1.isDisable()==false && PreAuthAddRow3col1.getText().isEmpty()==true)
								||(PreAuthAddRow3col2.isDisable()==false && PreAuthAddRow3col2.getText().isEmpty()==true)
								||(PreAuthAddRow3col3.isDisable()==false && PreAuthAddRow3col3.getText().isEmpty()==true))
				{
					Alert alert=new Alert(AlertType.WARNING);
					alert.setTitle("Enter Data");
					alert.setContentText("Please Enter all Mandatory Fields.");
					alert.showAndWait();
				}
				else if(textFieldMemberIDPreAuthAdd.getText().isEmpty()==false &&
						PreAuthAddMemberDOBPicker.getValue()!=null &&
						PreAuthAddMemberDOSPicker.getValue()!=null &&
						dateofservicediffdays<0 ||
						dateofservicediffdays>90)
				{

					Alert alert=new Alert(AlertType.WARNING);
					alert.setTitle("Date Of Service");
					alert.setContentText("Date Of Service should be within 90 days from today.");
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


		CreateEDIFilePreAuthAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(textFieldMemberIDPreAuthAdd.getText().isEmpty()==true ||
						(IsMemberComboBoxPreAuthAdd.getSelectionModel().getSelectedItem().equalsIgnoreCase("Dependent") 
								&& textFieldDependentFNamePreAuthAdd.getText().isEmpty()==true)||
								PreAuthAddMemberDOBPicker.getValue()==null ||
								PreAuthAddMemberDOSPicker.getValue()==null||
								textFieldPreAuthAddProviderNPI.getText().isEmpty()==true
								||(PreAuthAddRow3col1.isDisable()==false && PreAuthAddRow3col1.getText().isEmpty()==true)
								||(PreAuthAddRow3col2.isDisable()==false && PreAuthAddRow3col2.getText().isEmpty()==true)
								||(PreAuthAddRow3col3.isDisable()==false && PreAuthAddRow3col3.getText().isEmpty()==true))
				{
					Alert alert=new Alert(AlertType.WARNING);
					alert.setTitle("Enter Data");
					alert.setContentText("Please Enter all Mandatory Fields.");
					alert.showAndWait();
				}
				else if(textFieldMemberIDPreAuthAdd.getText().isEmpty()==false &&
						PreAuthAddMemberDOBPicker.getValue()!=null &&
						PreAuthAddMemberDOSPicker.getValue()!=null &&
						dateofservicediffdays<0 ||
						dateofservicediffdays>90)
				{

					Alert alert=new Alert(AlertType.WARNING);
					alert.setTitle("Date Of Service");
					alert.setContentText("Date Of Service should be within 90 days from today.");
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
						if(!(PreAuthAddPOSCombo.getValue().equalsIgnoreCase("On Campus-Outpatient Hospital")))
						{
							try
							{	
								Files.deleteIfExists(Paths.get(pathm+"IP.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"IP.txt"));
								String newLine = System.getProperty("line.separator");
								out.writeBytes("ISA*00*0000000000*00*0000000000*30*GATEWAYQES     *01*042064683      *130116*0219*^*00501*000000001*1*T*:");
								out.writeBytes(newLine);
								out.writeBytes("GS*HI*GATEWAYQES*RTPC_ENT_5010*20130116*021930*20000001*X*005010X217");
								out.writeBytes(newLine);
								out.writeBytes("ST*278*30001*005010X217");
								out.writeBytes(newLine);
								out.writeBytes("BHT*0007*13*549234885WEB*20150509*130503");
								out.writeBytes(newLine);
								out.writeBytes("HL*1**20*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*X3*2******PI*1548293343");
								out.writeBytes(newLine);
								out.writeBytes("HL*2*1*21*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*1P*1*"+textFieldReqProvLNamePreAuthAdd.getText().toString()+"*"+textFieldReqProvFNamePreAuthAdd.getText().toString()+"****XX*"+textFieldPreAuthAddProviderNPI.getText().toString());
								out.writeBytes(newLine);
								out.writeBytes("PER*IC*SYLVIA*TE*7243495440");
								out.writeBytes(newLine);
								out.writeBytes("HL*3*2*22*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*IL*1*"+textFieldMemberLNamePreAuthAdd.getText().toString()+"*"+textFieldMemberFNamePreAuthAdd.getText().toString()+"*****"+textFieldMemberIDPreAuthAdd.getText().toString());
								out.writeBytes(newLine);
								out.writeBytes("DMG*D8*"+PreAuthAddMemberDOBPicker.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								if(IsMemberComboBoxPreAuthAdd.getValue().equalsIgnoreCase("Dependent"))
								{
									out.writeBytes("HL*4*3*23*1");
									out.writeBytes(newLine);
									out.writeBytes("NM1*QC*1*"+textFieldDependentLNamePreAuthAdd.getText().toString()+"*"+textFieldDependentFNamePreAuthAdd.getText().toString());
									out.writeBytes(newLine);
									out.writeBytes("DMG*D8*"+PreAuthAddMemberDOBPicker.getValue().toString().replace("-", ""));
									out.writeBytes(newLine);
								}
								out.writeBytes("HL*5*4*EV*1");
								out.writeBytes(newLine);
								String poscode;

								if(PreAuthAddPOSCombo.getValue().equalsIgnoreCase("Office"))
								{
									poscode="11";
								}
								else if(PreAuthAddPOSCombo.getValue().equalsIgnoreCase("Ambulatory Surgical Center"))
								{
									poscode="24";
								}
								else if(PreAuthAddPOSCombo.getValue().equalsIgnoreCase("Inpatient Hospital"))
								{
									poscode="21";
								}
								else if(PreAuthAddPOSCombo.getValue().equalsIgnoreCase("Skilled Nursing Facility"))
								{
									poscode="31";
								}
								else
								{
									poscode="22";
								}
								if(PreAuthAddPOSBedType.getValue().equalsIgnoreCase("Select"))
								{
									out.writeBytes("UM*AR*I**"+poscode+":B**E");
								}
								else
								{
									out.writeBytes("UM*AR*I*"+PreAuthAddPOSBedType.getValue().toString().substring(0, 2)+"*"+poscode+":B**E");
								}
								out.writeBytes(newLine);
								out.writeBytes("DTP*435*D8*20171028");
								out.writeBytes(newLine);
								if(textFieldPreAuthAddDiacCodeTwo.getText().isEmpty()==true)
								{
									out.writeBytes("HI*ABF:"+textFieldPreAuthAddDiacCodeOne.getText().toString());
								}
								else if(textFieldPreAuthAddDiacCodeThree.getText().isEmpty()==true)
								{
									out.writeBytes("HI*ABF:"+textFieldPreAuthAddDiacCodeOne.getText().toString()+"*ABF:"+textFieldPreAuthAddDiacCodeTwo.getText().toString());
								}
								else if(textFieldPreAuthAddDiacCodeThree.getText().isEmpty()==false)
								{
									out.writeBytes("HI*ABF:"+textFieldPreAuthAddDiacCodeOne.getText().toString()+"*ABF:"+textFieldPreAuthAddDiacCodeTwo.getText().toString()+"*ABF:"+textFieldPreAuthAddDiacCodeThree.getText().toString());
								}
								else
								{
									out.writeBytes("HI*ABF:"+textFieldPreAuthAddDiacCodeOne.getText().toString());
								}									
								out.writeBytes(newLine);
								out.writeBytes("NM1*71*1*"+PreAuthAddRow2col1.getText().toString()+"*"+PreAuthAddRow1col1.getText().toString()+"****XX*"+PreAuthAddRow3col1.getText().toString());
								out.writeBytes(newLine);
								out.writeBytes("NM1*AAJ*2*"+PreAuthAddRow2col3.getText().toString()+"*"+PreAuthAddRow1col3.getText().toString()+"****XX*"+PreAuthAddRow3col3.getText().toString());
								out.writeBytes(newLine);
								out.writeBytes("NM1*FA*2*"+PreAuthAddRow2col2.getText().toString()+"*"+PreAuthAddRow1col2.getText().toString()+"****XX*"+PreAuthAddRow3col2.getText().toString());
								out.writeBytes(newLine);
								out.writeBytes("HL*6*5*SS*0");
								out.writeBytes(newLine);
								out.writeBytes("UM*HS*S");
								out.writeBytes(newLine);
								out.writeBytes("DTP*472*D8*"+PreAuthAddMemberDOSPicker.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("SV1*HC:"+textFieldPreAuthAddProcCodeOne.getText().toString());
								out.writeBytes(newLine);
								String HSDCode;
								if(PreAuthAddPOSHealthServicesType.getValue().toString().equalsIgnoreCase("Days"))
								{
									HSDCode="DY";
								}
								else if(PreAuthAddPOSHealthServicesType.getValue().toString().equalsIgnoreCase("Units"))
								{
									HSDCode="FL";
								}
								else if(PreAuthAddPOSHealthServicesType.getValue().toString().equalsIgnoreCase("Hours"))
								{
									HSDCode="HS";
								}
								else if(PreAuthAddPOSHealthServicesType.getValue().toString().equalsIgnoreCase("Month"))
								{
									HSDCode="MN";
								}
								else if(PreAuthAddPOSHealthServicesType.getValue().toString().equalsIgnoreCase("Visits"))
								{
									HSDCode="VS";
								}
								else
								{
									HSDCode="";
								}
								out.writeBytes("HSD*"+HSDCode+"*"+textFieldPreAuthAddHealthServicesUnit.getText().toString());
								out.writeBytes(newLine);
								if(IsMemberComboBoxPreAuthAdd.getValue().equalsIgnoreCase("Dependent"))
								{
									out.writeBytes("SE*26*30001");
								}
								else
								{
									out.writeBytes("SE*23*30001");
								}
								out.writeBytes(newLine);
								out.writeBytes("GE*1*20000001");
								out.writeBytes(newLine);
								out.writeBytes("IEA*1*000000001");
								out.writeBytes(newLine);
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to IP.txt File");
							}
						}

						else if(PreAuthAddPOSCombo.getValue().equalsIgnoreCase("On Campus-Outpatient Hospital"))
						{
							try
							{	
								Files.deleteIfExists(Paths.get(pathm+"OP.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"OP.txt"));
								String newLine = System.getProperty("line.separator");
								out.writeBytes("ISA*00*0000000000*00*0000000000*30*GATEWAYQES     *01*042064683      *130116*0219*^*00501*000000001*1*T*:");
								out.writeBytes(newLine);
								out.writeBytes("GS*HI*GATEWAYQES*RTPC_ENT_5010*20130116*021930*20000001*X*005010X217");
								out.writeBytes(newLine);
								out.writeBytes("ST*278*30001*005010X217");
								out.writeBytes(newLine);
								out.writeBytes("BHT*0007*13*549234885WEB*20150509*130503");
								out.writeBytes(newLine);
								out.writeBytes("HL*1**20*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*X3*2******PI*1548293343");
								out.writeBytes(newLine);
								out.writeBytes("HL*2*1*21*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*1P*1*"+textFieldReqProvLNamePreAuthAdd.getText().toString()+"*"+textFieldReqProvFNamePreAuthAdd.getText().toString()+"****XX*"+textFieldPreAuthAddProviderNPI.getText().toString());
								out.writeBytes(newLine);
								out.writeBytes("PER*IC*SYLVIA*TE*7243495440");
								out.writeBytes(newLine);
								out.writeBytes("HL*3*2*22*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*IL*1*"+textFieldMemberLNamePreAuthAdd.getText().toString()+"*"+textFieldMemberFNamePreAuthAdd.getText().toString()+"*****"+textFieldMemberIDPreAuthAdd.getText().toString());
								out.writeBytes(newLine);
								out.writeBytes("DMG*D8*"+PreAuthAddMemberDOBPicker.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								if(IsMemberComboBoxPreAuthAdd.getValue().equalsIgnoreCase("Dependent"))
								{
									out.writeBytes("HL*4*3*23*1");
									out.writeBytes(newLine);
									out.writeBytes("NM1*QC*1*"+textFieldDependentLNamePreAuthAdd.getText().toString()+"*"+textFieldDependentFNamePreAuthAdd.getText().toString());
									out.writeBytes(newLine);
									out.writeBytes("DMG*D8*"+PreAuthAddMemberDOBPicker.getValue().toString().replace("-", ""));
									out.writeBytes(newLine);
								}
								out.writeBytes("HL*5*4*EV*1");
								out.writeBytes(newLine);
								out.writeBytes("UM*HS*I**22:B**E");
								out.writeBytes(newLine);
								out.writeBytes("DTP*435*D8*20171028");
								out.writeBytes(newLine);
								if(textFieldPreAuthAddDiacCodeTwo.getText().isEmpty()==true)
								{
									out.writeBytes("HI*ABF:"+textFieldPreAuthAddDiacCodeOne.getText().toString());
								}
								else if(textFieldPreAuthAddDiacCodeThree.getText().isEmpty()==true)
								{
									out.writeBytes("HI*ABF:"+textFieldPreAuthAddDiacCodeOne.getText().toString()+"*ABF:"+textFieldPreAuthAddDiacCodeTwo.getText().toString());
								}
								else if(textFieldPreAuthAddDiacCodeThree.getText().isEmpty()==false)
								{
									out.writeBytes("HI*ABF:"+textFieldPreAuthAddDiacCodeOne.getText().toString()+"*ABF:"+textFieldPreAuthAddDiacCodeTwo.getText().toString()+"*ABF:"+textFieldPreAuthAddDiacCodeThree.getText().toString());
								}
								else
								{
									out.writeBytes("HI*ABF:"+textFieldPreAuthAddDiacCodeOne.getText().toString());
								}									
								out.writeBytes(newLine);
								out.writeBytes("NM1*71*1*"+PreAuthAddRow2col1.getText().toString()+"*"+PreAuthAddRow1col1.getText().toString()+"****XX*"+PreAuthAddRow3col1.getText().toString());
								out.writeBytes(newLine);
								out.writeBytes("NM1*FA*2*"+PreAuthAddRow2col2.getText().toString()+"*"+PreAuthAddRow1col2.getText().toString()+"****XX*"+PreAuthAddRow3col2.getText().toString());
								out.writeBytes(newLine);
								out.writeBytes("HL*6*5*SS*0");
								out.writeBytes(newLine);
								out.writeBytes("UM*HS*S");
								out.writeBytes(newLine);
								out.writeBytes("DTP*472*D8*"+PreAuthAddMemberDOSPicker.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("SV1*HC:"+textFieldPreAuthAddProcCodeOne.getText().toString());
								out.writeBytes(newLine);
								String HSDCode;
								if(PreAuthAddPOSHealthServicesType.getValue().toString().equalsIgnoreCase("Days"))
								{
									HSDCode="DY";
								}
								else if(PreAuthAddPOSHealthServicesType.getValue().toString().equalsIgnoreCase("Units"))
								{
									HSDCode="FL";
								}
								else if(PreAuthAddPOSHealthServicesType.getValue().toString().equalsIgnoreCase("Hours"))
								{
									HSDCode="HS";
								}
								else if(PreAuthAddPOSHealthServicesType.getValue().toString().equalsIgnoreCase("Month"))
								{
									HSDCode="MN";
								}
								else if(PreAuthAddPOSHealthServicesType.getValue().toString().equalsIgnoreCase("Visits"))
								{
									HSDCode="VS";
								}
								else
								{
									HSDCode="";
								}
								out.writeBytes("HSD*"+HSDCode+"*"+textFieldPreAuthAddHealthServicesUnit.getText().toString());
								out.writeBytes(newLine);
								if(IsMemberComboBoxPreAuthAdd.getValue().equalsIgnoreCase("Dependent"))
								{
									out.writeBytes("SE*25*30001");
								}
								else
								{
									out.writeBytes("SE*22*30001");
								}
								out.writeBytes(newLine);
								out.writeBytes("GE*1*20000001");
								out.writeBytes(newLine);
								out.writeBytes("IEA*1*000000001"); 
								out.writeBytes(newLine);
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to create OP.txt File");
							}
						}

						else
						{
							System.out.println("No Catagory Match");
						}
						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("Successful");
						alert.setContentText("File Created Successfully.");
						alert.showAndWait();
					}
				}
			}
		});
		//Home Button preAuth Add Link Event Handler
		HomelinkPreAuthAdd.setOnAction(new EventHandler<ActionEvent>() 	{
			public void handle(ActionEvent event) 
			{
				primaryStage.setScene(sceneBase);
				textFieldMemberLNamePreAuthAdd.clear();
				PreAuthAddMemberDOBPicker.getEditor().clear();
				PreAuthAddMemberDOBPicker.setPromptText("MM/DD/YYYY");
				IsMemberComboBoxPreAuthAdd.setValue("Subscriber");
				textFieldMemberIDPreAuthAdd.clear();
				textFieldDependentFNamePreAuthAdd.clear();
				textFieldDependentLNamePreAuthAdd.clear();
				PreAuthAddMemberDOSPicker.getEditor().clear();
				PreAuthAddMemberDOSPicker.setPromptText("MM/DD/YYYY");
				textFieldReqProvFNamePreAuthAdd.clear();
				textFieldReqProvLNamePreAuthAdd.clear();
				textFieldPreAuthAddProviderNPI.clear();
				PreAuthAddPOSCombo.setValue("Select");
				PreAuthAddPOSBedType.setValue("Select");
				PreAuthAddPOSHealthServicesType.setValue("Select");
				PreAuthAddRow1col1.clear();
				PreAuthAddRow1col2.clear();
				PreAuthAddRow1col3.clear();
				PreAuthAddRow2col1.clear();
				PreAuthAddRow2col2.clear();
				PreAuthAddRow2col3.clear();
				PreAuthAddRow3col1.clear();
				PreAuthAddRow3col2.clear();
				PreAuthAddRow3col3.clear();
				textFieldPreAuthAddHealthServicesUnit.clear();
				textFieldPreAuthAddProcCodeOne.clear();
				textFieldPreAuthAddProcCodeTwo.clear();
				textFieldPreAuthAddProcCodeThree.clear();
				textFieldPreAuthAddProcCodeFour.clear();
				textFieldPreAuthAddProcCodeFive.clear();
				textFieldPreAuthAddDiacCodeOne.clear();
				textFieldPreAuthAddDiacCodeTwo.clear();
				textFieldPreAuthAddDiacCodeThree.clear();
				textFieldMemberFNamePreAuthAdd.clear();
			}
		});

		PreAuthAdd.getChildren().addAll(rectPreAuthAddBorder,rectPreAuthAddTop,textPreAuthAddTop,HomelinkPreAuthAdd,textPreAuthAddMemberFName,
				textFieldMemberFNamePreAuthAdd,textPreAuthAddMemberLName,textFieldMemberLNamePreAuthAdd,textPreAuthAddMemberDOB,textPreAuthAddMemerDOBstar,PreAuthAddMemberDOBPicker,
				textPreAuthAddReqMemberIs,IsMemberComboBoxPreAuthAdd,textPreAuthAddMemberID,textPreAuthAddMemberIDstar,textFieldMemberIDPreAuthAdd,
				textPreAuthAddDependentFName,textFieldDependentFNamePreAuthAdd,textPreAuthAddDependentLName,textFieldDependentLNamePreAuthAdd,textPreAuthAddDependentFNAmestar,
				textPreAuthAddDOS,textPreAuthAddDOSstar,PreAuthAddMemberDOSPicker,textPreAuthAddReqProvFName,textFieldReqProvFNamePreAuthAdd,textPreAuthAddReqProvLName,textFieldReqProvLNamePreAuthAdd,
				textPreAuthAddReqProviderNPI,textFieldPreAuthAddProviderNPI,textPreAuthAddPOS,PreAuthAddPOSCombo,tablePreAuthAddOne,tablePreAuthAddTwo,tablePreAuthAddThree,tablePreAuthAddFour,
				PreAuthAddRow1col1,PreAuthAddRow1col2,PreAuthAddRow1col3,PreAuthAddRow2col1,PreAuthAddRow2col2,PreAuthAddRow2col3,PreAuthAddRow3col1,PreAuthAddRow3col2,PreAuthAddRow3col3,textPreAuthAddBedType,PreAuthAddPOSBedType,
				textPreAuthAddHealthCareServices,PreAuthAddPOSHealthServicesType,textFieldPreAuthAddHealthServicesUnit,validateDataPreAuthAdd,CreateEDIFilePreAuthAdd,ProcessEDIFilePreAuthAdd,
				textPreAuthAddDiagnosisProc,textPreAuthAddProcCodeNameOne,textFieldPreAuthAddProcCodeOne,textPreAuthAddProcCodeNameTwo,textFieldPreAuthAddProcCodeTwo,textPreAuthAddProcCodeNameThree,textFieldPreAuthAddProcCodeThree,
				textPreAuthAddProcCodeNameFour,textFieldPreAuthAddProcCodeFour,textPreAuthAddProcCodeNameFive,textFieldPreAuthAddProcCodeFive,
				textPreAuthAddDiagnosisCode,textPreAuthAddDiacCodeNameOne,textFieldPreAuthAddDiacCodeOne,textPreAuthAddDiacCodeNameTwo,textFieldPreAuthAddDiacCodeTwo,
				textPreAuthAddDiacCodeNameThree,textFieldPreAuthAddDiacCodeThree,textPreAuthAddReqProviderstar,textPreAuthAddNPItablestar);
		PreAuthAdd.setStyle("-fx-background-color:WHITE");
		return PreAuthAdd;
	}

}
