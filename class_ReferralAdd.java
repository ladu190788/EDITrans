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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class class_ReferralAdd {
	static String POScode = "11";
	static String path=null;
	static String pathm=null;
	public Pane ReferralAddCode (Pane ReferralAdd,Stage primaryStage,Scene sceneBase)
	{
		//Top Border RA
		Rectangle rectReferralAddTop = new Rectangle();
		rectReferralAddTop.setX(0.0f);
		rectReferralAddTop.setY(0.0f);
		rectReferralAddTop.setWidth(1360.0f);
		rectReferralAddTop.setHeight(60.0f);
		rectReferralAddTop.setFill(Color.STEELBLUE);
		rectReferralAddTop.setStroke(Color.STEELBLUE);
		//Boundary
		Rectangle rectReferralAddBorder = new Rectangle();
		rectReferralAddBorder.setX(1.5f);
		rectReferralAddBorder.setY(0.0f);
		rectReferralAddBorder.setWidth(1356.0f);
		rectReferralAddBorder.setHeight(682.0f);
		rectReferralAddBorder.setFill(Color.WHITE);
		rectReferralAddBorder.setStroke(Color.STEELBLUE);
		//Top Text Ref Add
		Text textReferralAddTop = new Text();
		textReferralAddTop.setText("Referral Add");
		textReferralAddTop.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 24));
		textReferralAddTop.setFill(Color.WHITE);
		textReferralAddTop.setLayoutX(605);
		textReferralAddTop.setLayoutY(40);
		//HomeLink ReferralAdd
		Hyperlink HomelinkReferralAdd = new Hyperlink();
		HomelinkReferralAdd.setText("Home");
		HomelinkReferralAdd.setStyle("-fx-text-fill: YELLOW;");
		HomelinkReferralAdd.setLayoutX(1300);
		HomelinkReferralAdd.setLayoutY(2);
		HomelinkReferralAdd.setUnderline(false);
		HomelinkReferralAdd.setFocusTraversable(false);
		HomelinkReferralAdd.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 14));
		//Member F name Referral Add Text
		Text textReferralAddMemberFName = new Text();
		textReferralAddMemberFName.setText("Member "+'\n'+"First Name");
		textReferralAddMemberFName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddMemberFName.setFill(Color.BLACK);
		textReferralAddMemberFName.setLayoutX(100);
		textReferralAddMemberFName.setLayoutY(95);
		//Member F name textfield
		TextField textFieldMemberFNameReferralAdd = new TextField();
		textFieldMemberFNameReferralAdd.setLayoutX(250);
		textFieldMemberFNameReferralAdd.setLayoutY(84);
		textFieldMemberFNameReferralAdd.setPrefWidth(300);
		textFieldMemberFNameReferralAdd.setPrefHeight(35);
		textFieldMemberFNameReferralAdd.setEditable(true);
		textFieldMemberFNameReferralAdd.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldMemberFNameReferralAdd.setTooltip(new Tooltip("Enter First Name"));
		textFieldMemberFNameReferralAdd.setPromptText("Member First Name");

		//Member L name Referral Add Text
		Text textReferralAddMemberLName = new Text();
		textReferralAddMemberLName.setText("Member "+'\n'+"Last Name");
		textReferralAddMemberLName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddMemberLName.setFill(Color.BLACK);
		textReferralAddMemberLName.setLayoutX(775);
		textReferralAddMemberLName.setLayoutY(95);
		//Member L name textfield
		TextField textFieldMemberLNameReferralAdd = new TextField();
		textFieldMemberLNameReferralAdd.setLayoutX(925);
		textFieldMemberLNameReferralAdd.setLayoutY(84);
		textFieldMemberLNameReferralAdd.setPrefWidth(300);
		textFieldMemberLNameReferralAdd.setPrefHeight(35);
		textFieldMemberLNameReferralAdd.setEditable(true);
		textFieldMemberLNameReferralAdd.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldMemberLNameReferralAdd.setTooltip(new Tooltip("Enter Last Name"));
		textFieldMemberLNameReferralAdd.setPromptText("Member Last Name");
		//textFieldMemberFNameProviderInq.setText("GATEWAY QES");

		//Referral AddMemebr FN LN length validation
		textFieldMemberFNameReferralAdd.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldMemberFNameReferralAdd.getText().length() >= 35) {
						textFieldMemberFNameReferralAdd.setText(textFieldMemberFNameReferralAdd.getText().substring(0, 35));
					}
				}
			}
		});
		textFieldMemberLNameReferralAdd.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldMemberLNameReferralAdd.getText().length() >= 60) {
						textFieldMemberLNameReferralAdd.setText(textFieldMemberLNameReferralAdd.getText().substring(0, 60));
					}
				}
			}
		});

		//Text Member ID Name Referral Add
		Text textReferralAddReqMemberID = new Text();
		textReferralAddReqMemberID.setText("Member ID");
		textReferralAddReqMemberID.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddReqMemberID.setFill(Color.BLACK);
		textReferralAddReqMemberID.setLayoutX(100);
		textReferralAddReqMemberID.setLayoutY(170);
		//* mark
		Text textReferralAddMemberIDstar = new Text();
		textReferralAddMemberIDstar.setText("*");
		textReferralAddMemberIDstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddMemberIDstar.setFill(Color.RED);
		textReferralAddMemberIDstar.setLayoutX(188);
		textReferralAddMemberIDstar.setLayoutY(170);

		TextField textFieldMemberIDReferralAdd = new TextField();
		textFieldMemberIDReferralAdd.setLayoutX(250);
		textFieldMemberIDReferralAdd.setLayoutY(145);
		textFieldMemberIDReferralAdd.setPrefWidth(300);
		textFieldMemberIDReferralAdd.setPrefHeight(35);
		textFieldMemberIDReferralAdd.setEditable(true);
		textFieldMemberIDReferralAdd.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldMemberIDReferralAdd.setTooltip(new Tooltip("Enter Member ID"));
		textFieldMemberIDReferralAdd.setPromptText("Member ID");

		//Referral Add Member ID Limit
		textFieldMemberIDReferralAdd.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldMemberIDReferralAdd.getText().length() >= 17) {
						textFieldMemberIDReferralAdd.setText(textFieldMemberIDReferralAdd.getText().substring(0, 17));
					}
				}
			}
		});

		//Text Member IS Name Referral Add
		Text textReqerralAddReqMemberIs = new Text();
		textReqerralAddReqMemberIs.setText("Member Is");
		textReqerralAddReqMemberIs.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReqerralAddReqMemberIs.setFill(Color.BLACK);
		textReqerralAddReqMemberIs.setLayoutX(775);
		textReqerralAddReqMemberIs.setLayoutY(170);
		//Combobix Member Is
		ComboBox<String> IsMemberAddComboBox = new ComboBox<String>();
		IsMemberAddComboBox.getItems().addAll("Subscriber","Dependent");
		IsMemberAddComboBox.setEditable(false); 
		IsMemberAddComboBox.setMinWidth(300);
		IsMemberAddComboBox.setMinHeight(35);
		IsMemberAddComboBox.setLayoutX(925);
		IsMemberAddComboBox.setLayoutY(144);
		IsMemberAddComboBox.setTooltip(new Tooltip("Select Member Type"));
		IsMemberAddComboBox.setValue("Subscriber");;
		IsMemberAddComboBox.setStyle("-fx-font: 18px \"Calibri\";");

		//Text MemberDOB Referral Add
		Text texReferralAddMemberDOB = new Text();
		texReferralAddMemberDOB.setText("Member /"+'\n'+"Dependent DOB");
		texReferralAddMemberDOB.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		texReferralAddMemberDOB.setFill(Color.BLACK);
		texReferralAddMemberDOB.setLayoutX(100);
		texReferralAddMemberDOB.setLayoutY(215);
		//* mark
		Text textReferralAddMemerDOBstar = new Text();
		textReferralAddMemerDOBstar.setText("*");
		textReferralAddMemerDOBstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddMemerDOBstar.setFill(Color.RED);
		textReferralAddMemerDOBstar.setLayoutX(182);
		textReferralAddMemerDOBstar.setLayoutY(213);
		//Date Picker
		DatePicker ReferralAddMemberDOBPicker = new DatePicker();
		ReferralAddMemberDOBPicker.setLayoutX(250);
		ReferralAddMemberDOBPicker.setLayoutY(205);
		ReferralAddMemberDOBPicker.setPrefWidth(300);
		ReferralAddMemberDOBPicker.setPrefHeight(35);
		ReferralAddMemberDOBPicker.setPromptText("MM/DD/YYYY");
		ReferralAddMemberDOBPicker.setTooltip(new Tooltip("Enter Member DOB"));
		ReferralAddMemberDOBPicker.setEditable(false);
		ReferralAddMemberDOBPicker.setStyle("-fx-font: 18px \"Calibri\";");

		ReferralAddMemberDOBPicker.setOnAction(e ->
		{
			LocalDate date = ReferralAddMemberDOBPicker.getValue();
		});

		//Dependent F name Referral Add Text
		Text textReferralAddDependentFName = new Text();
		textReferralAddDependentFName.setText("Dependent "+'\n'+"First Name");
		textReferralAddDependentFName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddDependentFName.setFill(Color.BLACK);
		textReferralAddDependentFName.setLayoutX(775);
		textReferralAddDependentFName.setLayoutY(215);
		//Dependent F name textfield
		TextField textFieldDependentFNameReferralAdd = new TextField();
		textFieldDependentFNameReferralAdd.setLayoutX(925);
		textFieldDependentFNameReferralAdd.setLayoutY(204);
		textFieldDependentFNameReferralAdd.setPrefWidth(300);
		textFieldDependentFNameReferralAdd.setPrefHeight(35);
		textFieldDependentFNameReferralAdd.setEditable(true);
		textFieldDependentFNameReferralAdd.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldDependentFNameReferralAdd.setTooltip(new Tooltip("First Name needed for Twins when Member is Dependent"));
		textFieldDependentFNameReferralAdd.setPromptText("Dependent First Name");
		textFieldDependentFNameReferralAdd.setDisable(true);

		//Dependent L name Referral Add Text
		Text textReferralAddDepLName = new Text();
		textReferralAddDepLName.setText("Dependent "+'\n'+"Last Name");
		textReferralAddDepLName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddDepLName.setFill(Color.BLACK);
		textReferralAddDepLName.setLayoutX(100);
		textReferralAddDepLName.setLayoutY(280);
		//Dependent L name textfield
		TextField textFieldDepLNameReferralAdd = new TextField();
		textFieldDepLNameReferralAdd.setLayoutX(250);
		textFieldDepLNameReferralAdd.setLayoutY(265);
		textFieldDepLNameReferralAdd.setPrefWidth(300);
		textFieldDepLNameReferralAdd.setPrefHeight(35);
		textFieldDepLNameReferralAdd.setEditable(true);
		textFieldDepLNameReferralAdd.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldDepLNameReferralAdd.setTooltip(new Tooltip("Enter Last Name"));
		textFieldDepLNameReferralAdd.setPromptText("Dependent Last Name");
		textFieldDepLNameReferralAdd.setDisable(true);

		IsMemberAddComboBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{              
				if(IsMemberAddComboBox.getValue().equalsIgnoreCase("Dependent"))
				{
					textFieldDependentFNameReferralAdd.setDisable(false);
					textFieldDepLNameReferralAdd.setDisable(false);
				}
				else if(IsMemberAddComboBox.getValue().equalsIgnoreCase("Subscriber"))
				{
					textFieldDependentFNameReferralAdd.clear();
					textFieldDepLNameReferralAdd.clear();
					textFieldDependentFNameReferralAdd.setDisable(true);
					textFieldDepLNameReferralAdd.setDisable(true);
				}                

			}});

		//Referral AddDependent FN LN length validation
		textFieldDependentFNameReferralAdd.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldDependentFNameReferralAdd.getText().length() >= 35) {
						textFieldDependentFNameReferralAdd.setText(textFieldDependentFNameReferralAdd.getText().substring(0, 35));
					}
				}
			}
		});
		textFieldDepLNameReferralAdd.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldDepLNameReferralAdd.getText().length() >= 60) {
						textFieldDepLNameReferralAdd.setText(textFieldDepLNameReferralAdd.getText().substring(0, 60));
					}
				}
			}
		});
		//Text DOS Referral Add
		Text texReferralAddMemberDOS = new Text();
		texReferralAddMemberDOS.setText("Date of Service");
		texReferralAddMemberDOS.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		texReferralAddMemberDOS.setFill(Color.BLACK);
		texReferralAddMemberDOS.setLayoutX(775);
		texReferralAddMemberDOS.setLayoutY(295);
		//* mark
		Text textReferralAddMemerDOSstar = new Text();
		textReferralAddMemerDOSstar.setText("*");
		textReferralAddMemerDOSstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddMemerDOSstar.setFill(Color.RED);
		textReferralAddMemerDOSstar.setLayoutX(890);
		textReferralAddMemerDOSstar.setLayoutY(295);
		//Date Picker
		DatePicker ReferralAddMemberDOSPicker = new DatePicker();
		ReferralAddMemberDOSPicker.setLayoutX(925);
		ReferralAddMemberDOSPicker.setLayoutY(265);
		ReferralAddMemberDOSPicker.setPrefWidth(300);
		ReferralAddMemberDOSPicker.setPrefHeight(35);
		ReferralAddMemberDOSPicker.setPromptText("MM/DD/YYYY");
		ReferralAddMemberDOSPicker.setTooltip(new Tooltip("Enter Date Of Service"));
		ReferralAddMemberDOSPicker.setEditable(false);
		ReferralAddMemberDOSPicker.setStyle("-fx-font: 18px \"Calibri\";");

		ReferralAddMemberDOSPicker.setOnAction(e ->
		{
			LocalDate date = ReferralAddMemberDOSPicker.getValue();
		});

		Line Rline1 = new Line(); 
		Rline1.setStartX(100); 
		Rline1.setStartY(315); 
		Rline1.setEndX(1225); 
		Rline1.setEndY(315);

		//Text payer Name Referral Add Referring Provider
		Text textReferralAddReferringProviderNPI = new Text();
		textReferralAddReferringProviderNPI.setText("Referring  "+'\n'+"Provider NPI");
		textReferralAddReferringProviderNPI.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddReferringProviderNPI.setFill(Color.BLACK);
		textReferralAddReferringProviderNPI.setLayoutX(100);
		textReferralAddReferringProviderNPI.setLayoutY(340);
		//* mark
		Text textReferralAddReferringProviderNPIstar = new Text();
		textReferralAddReferringProviderNPIstar.setText("*");
		textReferralAddReferringProviderNPIstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddReferringProviderNPIstar.setFill(Color.RED);
		textReferralAddReferringProviderNPIstar.setLayoutX(175);
		textReferralAddReferringProviderNPIstar.setLayoutY(340);

		//TextField Payer
		TextField textReferralAddReferringProviderNPItextbox = new TextField();
		textReferralAddReferringProviderNPItextbox.setLayoutX(250);
		textReferralAddReferringProviderNPItextbox.setLayoutY(325);
		textReferralAddReferringProviderNPItextbox.setPrefWidth(300);
		textReferralAddReferringProviderNPItextbox.setPrefHeight(35);
		textReferralAddReferringProviderNPItextbox.setEditable(true);
		textReferralAddReferringProviderNPItextbox.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textReferralAddReferringProviderNPItextbox.setTooltip(new Tooltip("Enter Provider NPI : Numeric Values Only"));
		textReferralAddReferringProviderNPItextbox.setPromptText("Provider NPI");

		//TextField Payer
		TextField textReferralAddReferringProviderFNtextbox = new TextField();
		textReferralAddReferringProviderFNtextbox.setLayoutX(575);
		textReferralAddReferringProviderFNtextbox.setLayoutY(325);
		textReferralAddReferringProviderFNtextbox.setPrefWidth(300);
		textReferralAddReferringProviderFNtextbox.setPrefHeight(35);
		textReferralAddReferringProviderFNtextbox.setEditable(true);
		textReferralAddReferringProviderFNtextbox.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textReferralAddReferringProviderFNtextbox.setTooltip(new Tooltip("Enter Provider First Name"));
		textReferralAddReferringProviderFNtextbox.setPromptText("Provider First Name");

		//TextField Payer
		TextField textReferralAddReferringProviderLNtextbox = new TextField();
		textReferralAddReferringProviderLNtextbox.setLayoutX(925);
		textReferralAddReferringProviderLNtextbox.setLayoutY(325);
		textReferralAddReferringProviderLNtextbox.setPrefWidth(300);
		textReferralAddReferringProviderLNtextbox.setPrefHeight(35);
		textReferralAddReferringProviderLNtextbox.setEditable(true);
		textReferralAddReferringProviderLNtextbox.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textReferralAddReferringProviderLNtextbox.setTooltip(new Tooltip("Enter Provider Last Name"));
		textReferralAddReferringProviderLNtextbox.setPromptText("Provider Last Name");

		//Referral Add Provider NPI FN LN Validation
		textReferralAddReferringProviderNPItextbox.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textReferralAddReferringProviderNPItextbox.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						textReferralAddReferringProviderNPItextbox.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});
		//
		textReferralAddReferringProviderFNtextbox.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textReferralAddReferringProviderFNtextbox.getText().length() >= 35) {
						textReferralAddReferringProviderFNtextbox.setText(textReferralAddReferringProviderFNtextbox.getText().substring(0, 35));
					}
				}
			}
		});
		textReferralAddReferringProviderLNtextbox.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textReferralAddReferringProviderLNtextbox.getText().length() >= 60) {
						textReferralAddReferringProviderLNtextbox.setText(textReferralAddReferringProviderLNtextbox.getText().substring(0, 60));
					}
				}
			}
		});
		Line Rline2 = new Line(); 
		Rline2.setStartX(100); 
		Rline2.setStartY(375); 
		Rline2.setEndX(1225); 
		Rline2.setEndY(375);

		//Text payer Name Referral Add ReferredTo Provider
		Text textReferralAddReferredToProviderNPI = new Text();
		textReferralAddReferredToProviderNPI.setText("ReferredTo  "+'\n'+"Details");
		textReferralAddReferredToProviderNPI.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddReferredToProviderNPI.setFill(Color.BLACK);
		textReferralAddReferredToProviderNPI.setLayoutX(100);
		textReferralAddReferredToProviderNPI.setLayoutY(400);
		//* mark
		//Toggle group declaration
		ToggleGroup group1 = new ToggleGroup();
		RadioButton TaxonomyCode = new RadioButton();//Radio button declaration
		TaxonomyCode.setText("Enter Taxonomy Code");
		TaxonomyCode.setLayoutX(250);
		TaxonomyCode.setLayoutY(395);
		TaxonomyCode.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		TaxonomyCode.setTooltip(new Tooltip("Enter either Taxonomy code or ReferredTo Provider Details"));
		TaxonomyCode.setToggleGroup(group1);//for adding in toggle group

		TaxonomyCode.setSelected(true); // setting up the value by default to taxonomy code

		RadioButton ProviderDetails = new RadioButton();
		ProviderDetails.setText("Enter Provider Details");
		ProviderDetails.setLayoutX(575);
		ProviderDetails.setLayoutY(395);
		ProviderDetails.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		ProviderDetails.setTooltip(new Tooltip("Enter either Taxonomy code or ReferredTo Provider Details"));
		ProviderDetails.setToggleGroup(group1);
		//Referral Add Taxonomy Code
		Text textReferralAddTaxonomyCode = new Text();
		textReferralAddTaxonomyCode.setText("Taxonomy Code");
		textReferralAddTaxonomyCode.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddTaxonomyCode.setFill(Color.BLACK);
		textReferralAddTaxonomyCode.setLayoutX(775);
		textReferralAddTaxonomyCode.setLayoutY(410);
		// Referral Add Taxonomy textfield
		TextField textReferralAddTaxonomyCodeTextBox = new TextField();
		textReferralAddTaxonomyCodeTextBox.setLayoutX(925);
		textReferralAddTaxonomyCodeTextBox.setLayoutY(385);
		textReferralAddTaxonomyCodeTextBox.setPrefWidth(300);
		textReferralAddTaxonomyCodeTextBox.setPrefHeight(35);
		textReferralAddTaxonomyCodeTextBox.setEditable(true);
		textReferralAddTaxonomyCodeTextBox.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textReferralAddTaxonomyCodeTextBox.setTooltip(new Tooltip("Enter Taxonomy Code"));
		textReferralAddTaxonomyCodeTextBox.setPromptText("Example: 261QR0200X");
		//* mark for Refer to Taxonomy Code
		Text textReferralAddTaxonomyCodestar = new Text();
		textReferralAddTaxonomyCodestar.setText("*");
		textReferralAddTaxonomyCodestar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddTaxonomyCodestar.setFill(Color.RED);
		textReferralAddTaxonomyCodestar.setLayoutX(897);
		textReferralAddTaxonomyCodestar.setLayoutY(410);
		textReferralAddTaxonomyCodestar.setVisible(true);
		textReferralAddTaxonomyCodeTextBox.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textReferralAddTaxonomyCodeTextBox.getText().length() >= 10) {
						textReferralAddTaxonomyCodeTextBox.setText(textReferralAddTaxonomyCodeTextBox.getText().substring(0, 10));
					}
				}
			}
		});
		//Text payer Name Referral Add Referred TO Provider
		Text textReferralAddReferredToProviderNPIID = new Text();
		textReferralAddReferredToProviderNPIID.setText("Referred To "+'\n'+"Provider NPI");
		textReferralAddReferredToProviderNPIID.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddReferredToProviderNPIID.setFill(Color.BLACK);
		textReferralAddReferredToProviderNPIID.setLayoutX(100);
		textReferralAddReferredToProviderNPIID.setLayoutY(450);

		//* mark for Refer to Provider NPI
		Text textReferralAddReferredToProviderNPIstar = new Text();
		textReferralAddReferredToProviderNPIstar.setText("*");
		textReferralAddReferredToProviderNPIstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddReferredToProviderNPIstar.setFill(Color.RED);
		textReferralAddReferredToProviderNPIstar.setLayoutX(200);
		textReferralAddReferredToProviderNPIstar.setLayoutY(450);
		textReferralAddReferredToProviderNPIstar.setVisible(false);

		//TextField Payer
		TextField textReferralAddReferredToProviderNPItextbox = new TextField();
		textReferralAddReferredToProviderNPItextbox.setLayoutX(250);
		textReferralAddReferredToProviderNPItextbox.setLayoutY(435);
		textReferralAddReferredToProviderNPItextbox.setPrefWidth(300);
		textReferralAddReferredToProviderNPItextbox.setPrefHeight(35);
		textReferralAddReferredToProviderNPItextbox.setEditable(true);
		textReferralAddReferredToProviderNPItextbox.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textReferralAddReferredToProviderNPItextbox.setTooltip(new Tooltip("NPI is mandatory Enter Provider Details is Selected"));
		textReferralAddReferredToProviderNPItextbox.setPromptText("Provider NPI");
		textReferralAddReferredToProviderNPItextbox.setDisable(true);

		//TextField Payer
		TextField textReferralAddReferredToProviderFNtextbox = new TextField();
		textReferralAddReferredToProviderFNtextbox.setLayoutX(575);
		textReferralAddReferredToProviderFNtextbox.setLayoutY(435);
		textReferralAddReferredToProviderFNtextbox.setPrefWidth(300);
		textReferralAddReferredToProviderFNtextbox.setPrefHeight(35);
		textReferralAddReferredToProviderFNtextbox.setEditable(true);
		textReferralAddReferredToProviderFNtextbox.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textReferralAddReferredToProviderFNtextbox.setTooltip(new Tooltip("Enter Provider First Name"));
		textReferralAddReferredToProviderFNtextbox.setPromptText("Provider First Name");
		textReferralAddReferredToProviderFNtextbox.setDisable(true);
		//TextField Payer
		TextField textReferralAddReferredToProviderLNtextbox = new TextField();
		textReferralAddReferredToProviderLNtextbox.setLayoutX(925);
		textReferralAddReferredToProviderLNtextbox.setLayoutY(435);
		textReferralAddReferredToProviderLNtextbox.setPrefWidth(300);
		textReferralAddReferredToProviderLNtextbox.setPrefHeight(35);
		textReferralAddReferredToProviderLNtextbox.setEditable(true);
		textReferralAddReferredToProviderLNtextbox.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textReferralAddReferredToProviderLNtextbox.setTooltip(new Tooltip("Enter Provider Last Name"));
		textReferralAddReferredToProviderLNtextbox.setPromptText("Provider Last Name");
		textReferralAddReferredToProviderLNtextbox.setDisable(true);
		//Referral Add Referred To Provider NPI FN LN Validation
		textReferralAddReferredToProviderNPItextbox.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textReferralAddReferredToProviderNPItextbox.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						textReferralAddReferredToProviderNPItextbox.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});
		//
		textReferralAddReferredToProviderFNtextbox.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textReferralAddReferredToProviderFNtextbox.getText().length() >= 35) {
						textReferralAddReferredToProviderFNtextbox.setText(textReferralAddReferredToProviderFNtextbox.getText().substring(0, 35));
					}
				}
			}
		});
		textReferralAddReferredToProviderLNtextbox.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textReferralAddReferredToProviderLNtextbox.getText().length() >= 60) {
						textReferralAddReferredToProviderLNtextbox.setText(textReferralAddReferredToProviderLNtextbox.getText().substring(0, 60));
					}
				}
			}
		});



		//Enable and Disabale of referring provider details
		ProviderDetails.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{
				if (ProviderDetails.isSelected())
				{

					textReferralAddReferredToProviderNPItextbox.setDisable(false);
					textReferralAddReferredToProviderFNtextbox.setDisable(false);
					textReferralAddReferredToProviderLNtextbox.setDisable(false);
					textReferralAddReferredToProviderNPIstar.setVisible(true);
					textReferralAddTaxonomyCodeTextBox.clear();
					textReferralAddTaxonomyCodeTextBox.setDisable(true);
					textReferralAddTaxonomyCodestar.setVisible(false);
				}

			}}
				);

		TaxonomyCode.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{
				if (TaxonomyCode.isSelected())
				{

					textReferralAddReferredToProviderNPItextbox.clear();
					textReferralAddReferredToProviderFNtextbox.clear();
					textReferralAddReferredToProviderLNtextbox.clear();	
					textReferralAddReferredToProviderNPIstar.setVisible(false);

					textReferralAddReferredToProviderNPItextbox.setDisable(true);
					textReferralAddReferredToProviderFNtextbox.setDisable(true);
					textReferralAddReferredToProviderLNtextbox.setDisable(true);
					textReferralAddTaxonomyCodeTextBox.setDisable(false);
					textReferralAddTaxonomyCodestar.setVisible(true);
				}
			}}
				);

		Line Rline3 = new Line(); 
		Rline3.setStartX(100); 
		Rline3.setStartY(485); 
		Rline3.setEndX(1225); 
		Rline3.setEndY(485);

		//Service Type
		Text textReqerralAddServiceTypeIs = new Text();
		textReqerralAddServiceTypeIs.setText("Service Type");
		textReqerralAddServiceTypeIs.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReqerralAddServiceTypeIs.setFill(Color.BLACK);
		textReqerralAddServiceTypeIs.setLayoutX(100);
		textReqerralAddServiceTypeIs.setLayoutY(520);
		//Combobox Service Type Is
		ComboBox<String> IsServiceTypeComboBox = new ComboBox<String>();
		IsServiceTypeComboBox.getItems().addAll("Medical Care","Consultation","Dialysis","Therapy");
		IsServiceTypeComboBox.setEditable(false); 
		IsServiceTypeComboBox.setMinWidth(300);
		IsServiceTypeComboBox.setMinHeight(35);
		IsServiceTypeComboBox.setLayoutX(250);
		IsServiceTypeComboBox.setLayoutY(500);
		IsServiceTypeComboBox.setTooltip(new Tooltip("Select Service Type"));
		IsServiceTypeComboBox.setValue("Medical Care");;
		IsServiceTypeComboBox.setStyle("-fx-font: 14px \"Calibri\";");

		//Place of Service Type
		Text textReqerralAddPOSTypeIs = new Text();
		textReqerralAddPOSTypeIs.setText("Place Of"+'\n'+"Service");
		textReqerralAddPOSTypeIs.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReqerralAddPOSTypeIs.setFill(Color.BLACK);
		textReqerralAddPOSTypeIs.setLayoutX(775);
		textReqerralAddPOSTypeIs.setLayoutY(510);

		//Combobox Service Type Is
		ComboBox<String> ISAddPOSComboBox = new ComboBox<String>();
		ISAddPOSComboBox.getItems().addAll("Hospital Inpatient Medicare Part A","Hospital Inpatient Medicare Part B","Hospital Outpatient","Hospital Laboratory Services OP","Hospital Swing Beds IP","Skilled Nursing IP Medicare Part A","Skilled Nursing IP Medicare Part B","Skilled Nursing Outpatient OP","Skilled Nursing Swing Beds IP","Home Health Inpatient","Home Health Outpatient ","Home Health Other","Religious Non-Medical Hospital IP","Religious Non-Medical Institutions OP","Intermediate Care Level I","Intermediate Care Level II","Clinic Rural Health","Clinic Hospital Based","Clinic Independent Renal Dialysis","Clinic Freestanding","Clinic Outpatient Rehabilitation","Clinic Comprehensive OP Rehabilitation ","Clinic Community Mental Health Center","Clinic Federally Qualified Health Center","Clinic Other","Special Facility Hospice non-hospital","Special Facility Hospice hospital","Special Facility Ambulatory Surgery","Special Facility Free Standing Birthing","Special Facility Critical Access Hospital","Special Facility Residential Facility","Special Facility Other");
		ISAddPOSComboBox.setEditable(false); 
		ISAddPOSComboBox.setMinWidth(290);
		ISAddPOSComboBox.setMinHeight(35);
		ISAddPOSComboBox.setLayoutX(925);
		ISAddPOSComboBox.setLayoutY(500);
		ISAddPOSComboBox.setTooltip(new Tooltip("Enter Place of Service from Drop Down"));
		ISAddPOSComboBox.setValue("Hospital Inpatient Medicare Part A");;
		ISAddPOSComboBox.setStyle("-fx-font: 14px \"Calibri\";");

		String strPOS = "11-Hospital Inpatient Medicare Part A,12-Hospital Inpatient Medicare Part B,13-Hospital Outpatient,14-Hospital Laboratory Services OP,18-Hospital Swing Beds IP,21-Skilled Nursing IP Medicare Part A,22-Skilled Nursing IP Medicare Part B,23-Skilled Nursing Outpatient OP,28-Skilled Nursing Swing Beds IP,32-Home Health Inpatient,33-Home Health Outpatient ,34-Home Health Other,41-Religious Non-Medical Hospital IP,43-Religious Non-Medical Institutions OP,65-Intermediate Care Level I,66-Intermediate Care Level II,71-Clinic Rural Health,72-Clinic Hospital Based,72-Clinic Independent Renal Dialysis,73-Clinic Freestanding,74-Clinic Outpatient Rehabilitation,75-Clinic Comprehensive OP Rehabilitation ,76-Clinic Community Mental Health Center,77-Clinic Federally Qualified Health Center,79-Clinic Other,81-Special Facility Hospice non-hospital,82-Special Facility Hospice hospital,83-Special Facility Ambulatory Surgery,84-Special Facility Free Standing Birthing,85-Special Facility Critical Access Hospital,86-Special Facility Residential Facility,89-Special Facility Other";

		ISAddPOSComboBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{              
				String strPOSValue =    ISAddPOSComboBox.getValue();      
				int index = strPOS.indexOf(strPOSValue);
				POScode = strPOS.substring(index-3, index-1);						
			}});


		Text textReferralAddDiagCodeNameZero = new Text();
		textReferralAddDiagCodeNameZero.setText("Diagnosis Codes");
		textReferralAddDiagCodeNameZero.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddDiagCodeNameZero.setFill(Color.BLACK);
		textReferralAddDiagCodeNameZero.setLayoutX(100);
		textReferralAddDiagCodeNameZero.setLayoutY(565);

		//* mark for Refer to Provider NPI
		Text textReferralAddDiagCodestar = new Text();
		textReferralAddDiagCodestar.setText("*");
		textReferralAddDiagCodestar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddDiagCodestar.setFill(Color.RED);
		textReferralAddDiagCodestar.setLayoutX(222);
		textReferralAddDiagCodestar.setLayoutY(565);


		Text textReferralAddDiagCodeNameOne = new Text();
		textReferralAddDiagCodeNameOne.setText("1.");
		textReferralAddDiagCodeNameOne.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textReferralAddDiagCodeNameOne.setFill(Color.BLACK);
		textReferralAddDiagCodeNameOne.setLayoutX(250);
		textReferralAddDiagCodeNameOne.setLayoutY(565);
		TextField textFieldReferralAddDiagCodeOne = new TextField();
		textFieldReferralAddDiagCodeOne.setLayoutX(270);
		textFieldReferralAddDiagCodeOne.setLayoutY(548);
		textFieldReferralAddDiagCodeOne.setPrefWidth(140);
		textFieldReferralAddDiagCodeOne.setPrefHeight(25);
		textFieldReferralAddDiagCodeOne.setEditable(true);
		textFieldReferralAddDiagCodeOne.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldReferralAddDiagCodeOne.setTooltip(new Tooltip("1st Diag Code"));
		textFieldReferralAddDiagCodeOne.setPromptText("1st Diag Code");
		textFieldReferralAddDiagCodeOne.setDisable(false);

		//Referral Add  Diagcode1 Limit
		textFieldReferralAddDiagCodeOne.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldReferralAddDiagCodeOne.getText().length() >= 7) {
						textFieldReferralAddDiagCodeOne.setText(textFieldReferralAddDiagCodeOne.getText().substring(0, 5));
					}
				}
			}
		});

		//
		Text textReferralAddDiagCodeNameTwo = new Text();
		textReferralAddDiagCodeNameTwo.setText("2.");
		textReferralAddDiagCodeNameTwo.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textReferralAddDiagCodeNameTwo.setFill(Color.BLACK);
		textReferralAddDiagCodeNameTwo.setLayoutX(437);
		textReferralAddDiagCodeNameTwo.setLayoutY(565);
		TextField textFieldReferralAddDiagCodeTwo = new TextField();
		textFieldReferralAddDiagCodeTwo.setLayoutX(457);
		textFieldReferralAddDiagCodeTwo.setLayoutY(548);
		textFieldReferralAddDiagCodeTwo.setPrefWidth(140);
		textFieldReferralAddDiagCodeTwo.setPrefHeight(25);
		textFieldReferralAddDiagCodeTwo.setEditable(true);
		textFieldReferralAddDiagCodeTwo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldReferralAddDiagCodeTwo.setTooltip(new Tooltip("2nd Diag Code"));
		textFieldReferralAddDiagCodeTwo.setPromptText("2nd Diag Code");
		textFieldReferralAddDiagCodeTwo.setDisable(true);
		//

		//Referral Add  Diagcode2 Limit
		textFieldReferralAddDiagCodeTwo.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldReferralAddDiagCodeTwo.getText().length() >= 7) {
						textFieldReferralAddDiagCodeTwo.setText(textFieldReferralAddDiagCodeTwo.getText().substring(0, 5));
					}
				}
			}
		});


		Text textReferralAddDiagCodeNameThree = new Text();
		textReferralAddDiagCodeNameThree.setText("3.");
		textReferralAddDiagCodeNameThree.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textReferralAddDiagCodeNameThree.setFill(Color.BLACK);
		textReferralAddDiagCodeNameThree.setLayoutX(624);
		textReferralAddDiagCodeNameThree.setLayoutY(565);
		TextField textFieldReferralAddDiagCodeThree = new TextField();
		textFieldReferralAddDiagCodeThree.setLayoutX(644);
		textFieldReferralAddDiagCodeThree.setLayoutY(548);
		textFieldReferralAddDiagCodeThree.setPrefWidth(140);
		textFieldReferralAddDiagCodeThree.setPrefHeight(25);
		textFieldReferralAddDiagCodeThree.setEditable(true);
		textFieldReferralAddDiagCodeThree.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldReferralAddDiagCodeThree.setTooltip(new Tooltip("3rd Diag Code"));
		textFieldReferralAddDiagCodeThree.setPromptText("3rd Diag Code");
		textFieldReferralAddDiagCodeThree.setDisable(true);


		//Referral Add  Diagcode3 Limit
		textFieldReferralAddDiagCodeThree.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldReferralAddDiagCodeThree.getText().length() >= 7) {
						textFieldReferralAddDiagCodeThree.setText(textFieldReferralAddDiagCodeThree.getText().substring(0, 5));
					}
				}
			}
		});


		textFieldReferralAddDiagCodeOne.textProperty().addListener((observable, oldValue, newValue) -> {
			textFieldReferralAddDiagCodeTwo.setDisable(false);
		});

		textFieldReferralAddDiagCodeTwo.textProperty().addListener((observable, oldValue, newValue) -> {
			textFieldReferralAddDiagCodeThree.setDisable(false);
		});


		Text textReferralAddProcCodeNameZero = new Text();
		textReferralAddProcCodeNameZero.setText("Procedure Codes");
		textReferralAddProcCodeNameZero.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddProcCodeNameZero.setFill(Color.BLACK);
		textReferralAddProcCodeNameZero.setLayoutX(100);
		textReferralAddProcCodeNameZero.setLayoutY(605);

		//* mark for Refer to Provider NPI
		Text textReferralAddProcCodestar = new Text();
		textReferralAddProcCodestar.setText("*");
		textReferralAddProcCodestar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralAddProcCodestar.setFill(Color.RED);
		textReferralAddProcCodestar.setLayoutX(227);
		textReferralAddProcCodestar.setLayoutY(605);


		Text textReferralAddProcCodeNameOne = new Text();
		textReferralAddProcCodeNameOne.setText("1.");
		textReferralAddProcCodeNameOne.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textReferralAddProcCodeNameOne.setFill(Color.BLACK);
		textReferralAddProcCodeNameOne.setLayoutX(250);
		textReferralAddProcCodeNameOne.setLayoutY(605);
		TextField textFieldReferralAddProcCodeOne = new TextField();
		textFieldReferralAddProcCodeOne.setLayoutX(270);
		textFieldReferralAddProcCodeOne.setLayoutY(588);
		textFieldReferralAddProcCodeOne.setPrefWidth(140);
		textFieldReferralAddProcCodeOne.setPrefHeight(25);
		textFieldReferralAddProcCodeOne.setEditable(true);
		textFieldReferralAddProcCodeOne.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldReferralAddProcCodeOne.setTooltip(new Tooltip("1st Procedure Code"));
		textFieldReferralAddProcCodeOne.setPromptText("1st Procedure Code");
		textFieldReferralAddProcCodeOne.setDisable(false);
		//Referral Add  Procedurecode1 Limit
		textFieldReferralAddProcCodeOne.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldReferralAddProcCodeOne.getText().length() >= 5) {
						textFieldReferralAddProcCodeOne.setText(textFieldReferralAddProcCodeOne.getText().substring(0, 5));
					}
				}
			}
		});

		Text textReferralAddProcCodeNameTwo = new Text();
		textReferralAddProcCodeNameTwo.setText("2.");
		textReferralAddProcCodeNameTwo.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textReferralAddProcCodeNameTwo.setFill(Color.BLACK);
		textReferralAddProcCodeNameTwo.setLayoutX(437);
		textReferralAddProcCodeNameTwo.setLayoutY(605);
		TextField textFieldReferralAddProcCodeTwo = new TextField();
		textFieldReferralAddProcCodeTwo.setLayoutX(457);
		textFieldReferralAddProcCodeTwo.setLayoutY(588);
		textFieldReferralAddProcCodeTwo.setPrefWidth(140);
		textFieldReferralAddProcCodeTwo.setPrefHeight(25);
		textFieldReferralAddProcCodeTwo.setEditable(true);
		textFieldReferralAddProcCodeTwo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldReferralAddProcCodeTwo.setTooltip(new Tooltip("2nd Procedure Code"));
		textFieldReferralAddProcCodeTwo.setPromptText("2nd Procedure Code");
		textFieldReferralAddProcCodeTwo.setDisable(true);
		//Referral Add  Procedurecode2 Limit
		textFieldReferralAddProcCodeTwo.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					// Check if the new character is greater than LIMIT
					if (textFieldReferralAddProcCodeTwo.getText().length() >= 5) {
						textFieldReferralAddProcCodeTwo.setText(textFieldReferralAddProcCodeTwo.getText().substring(0, 5));
					}
				}
			}
		});

		Text textReferralAddProcCodeNameThree = new Text();
		textReferralAddProcCodeNameThree.setText("3.");
		textReferralAddProcCodeNameThree.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textReferralAddProcCodeNameThree.setFill(Color.BLACK);
		textReferralAddProcCodeNameThree.setLayoutX(624);
		textReferralAddProcCodeNameThree.setLayoutY(605);
		TextField textFieldReferralAddProcCodeThree = new TextField();
		textFieldReferralAddProcCodeThree.setLayoutX(644);
		textFieldReferralAddProcCodeThree.setLayoutY(588);
		textFieldReferralAddProcCodeThree.setPrefWidth(140);
		textFieldReferralAddProcCodeThree.setPrefHeight(25);
		textFieldReferralAddProcCodeThree.setEditable(true);
		textFieldReferralAddProcCodeThree.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldReferralAddProcCodeThree.setTooltip(new Tooltip("3rd Procedure Code"));
		textFieldReferralAddProcCodeThree.setPromptText("3rd Procedure Code");
		textFieldReferralAddProcCodeThree.setDisable(true);
		//Referral Add  Procedurecode2 Limit
		textFieldReferralAddProcCodeThree.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {if (newValue.intValue() > oldValue.intValue()) {
						if (textFieldReferralAddProcCodeThree.getText().length() >= 5) {
							textFieldReferralAddProcCodeThree.setText(textFieldReferralAddProcCodeThree.getText().substring(0, 5));
						}}}});
		Text textReferralAddProcCodeNameFour = new Text();
		textReferralAddProcCodeNameFour.setText("4.");
		textReferralAddProcCodeNameFour.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textReferralAddProcCodeNameFour.setFill(Color.BLACK);
		textReferralAddProcCodeNameFour.setLayoutX(811);
		textReferralAddProcCodeNameFour.setLayoutY(605);
		TextField textFieldReferralAddProcCodeFour = new TextField();
		textFieldReferralAddProcCodeFour.setLayoutX(831);
		textFieldReferralAddProcCodeFour.setLayoutY(588);
		textFieldReferralAddProcCodeFour.setPrefWidth(140);
		textFieldReferralAddProcCodeFour.setPrefHeight(25);
		textFieldReferralAddProcCodeFour.setEditable(true);
		textFieldReferralAddProcCodeFour.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldReferralAddProcCodeFour.setTooltip(new Tooltip("4th Procedure Code"));
		textFieldReferralAddProcCodeFour.setPromptText("4th Procedure Code");
		textFieldReferralAddProcCodeFour.setDisable(true);
		textFieldReferralAddProcCodeFour.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {if (newValue.intValue() > oldValue.intValue()) {
						if (textFieldReferralAddProcCodeFour.getText().length() >= 5) {
							textFieldReferralAddProcCodeFour.setText(textFieldReferralAddProcCodeFour.getText().substring(0, 5));
						}}}});

		Text textReferralAddProcCodeNameFive = new Text();
		textReferralAddProcCodeNameFive.setText("5.");
		textReferralAddProcCodeNameFive.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
		textReferralAddProcCodeNameFive.setFill(Color.BLACK);
		textReferralAddProcCodeNameFive.setLayoutX(998);
		textReferralAddProcCodeNameFive.setLayoutY(605);
		TextField textFieldReferralAddProcCodeFive = new TextField();
		textFieldReferralAddProcCodeFive.setLayoutX(1018);
		textFieldReferralAddProcCodeFive.setLayoutY(588);
		textFieldReferralAddProcCodeFive.setPrefWidth(140);
		textFieldReferralAddProcCodeFive.setPrefHeight(25);
		textFieldReferralAddProcCodeFive.setEditable(true);
		textFieldReferralAddProcCodeFive.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldReferralAddProcCodeFive.setTooltip(new Tooltip("5th Procedure Code"));
		textFieldReferralAddProcCodeFive.setPromptText("5th Procedure Code");
		textFieldReferralAddProcCodeFive.setDisable(true);
		textFieldReferralAddProcCodeFive.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldReferralAddProcCodeFive.getText().length() >= 5) {
						textFieldReferralAddProcCodeFive.setText(textFieldReferralAddProcCodeFive.getText().substring(0, 5));
					}}}});

		textFieldReferralAddProcCodeOne.textProperty().addListener((observable, oldValue, newValue) -> {
			textFieldReferralAddProcCodeTwo.setDisable(false);
		});

		textFieldReferralAddProcCodeTwo.textProperty().addListener((observable, oldValue, newValue) -> {
			textFieldReferralAddProcCodeThree.setDisable(false);
		});
		textFieldReferralAddProcCodeThree.textProperty().addListener((observable, oldValue, newValue) -> {
			textFieldReferralAddProcCodeFour.setDisable(false);
		});
		textFieldReferralAddProcCodeFour.textProperty().addListener((observable, oldValue, newValue) -> {
			textFieldReferralAddProcCodeFive.setDisable(false);
		});
		//Validate Data Button
		Button ReferralAddvalidateDataEligibility = new Button();
		ReferralAddvalidateDataEligibility.setText("Validate Data");
		ReferralAddvalidateDataEligibility.setLayoutX(430);
		ReferralAddvalidateDataEligibility.setLayoutY(625);
		ReferralAddvalidateDataEligibility.setMinWidth(150);
		ReferralAddvalidateDataEligibility.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
		ReferralAddvalidateDataEligibility.setTextFill(Color.STEELBLUE);
		ReferralAddvalidateDataEligibility.setStyle("-fx-background-color:STEELBLUE");
		ReferralAddvalidateDataEligibility.setTextFill(Color.WHITE);
		//Create EDI File Button
		Button ReferralAddCreateEDIFileEligibility = new Button();
		ReferralAddCreateEDIFileEligibility.setText("Create EDI Data");
		ReferralAddCreateEDIFileEligibility.setLayoutX(600);
		ReferralAddCreateEDIFileEligibility.setLayoutY(625);
		ReferralAddCreateEDIFileEligibility.setMinWidth(150);
		ReferralAddCreateEDIFileEligibility.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
		ReferralAddCreateEDIFileEligibility.setStyle("-fx-background-color:STEELBLUE");
		ReferralAddCreateEDIFileEligibility.setTextFill(Color.WHITE);
		//Process EDI File Button
		Button ReferralAddProcessEDIFileEligibility = new Button();
		ReferralAddProcessEDIFileEligibility.setText("Process EDI Data");
		ReferralAddProcessEDIFileEligibility.setLayoutX(770);
		ReferralAddProcessEDIFileEligibility.setLayoutY(625);
		ReferralAddProcessEDIFileEligibility.setMinWidth(150);
		ReferralAddProcessEDIFileEligibility.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
		ReferralAddProcessEDIFileEligibility.setStyle("-fx-background-color:STEELBLUE");
		ReferralAddProcessEDIFileEligibility.setTextFill(Color.WHITE);
		// EDI Referral Add Data Validator
		ReferralAddvalidateDataEligibility.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{              
				if(textFieldMemberIDReferralAdd.getText().isEmpty()==true || ReferralAddMemberDOBPicker.getValue()==null ||
						ReferralAddMemberDOSPicker.getValue()==null ||
						textReferralAddReferringProviderNPItextbox.getText().isEmpty()==true ||
						textFieldReferralAddDiagCodeOne.getText().isEmpty()==true ||
						textFieldReferralAddProcCodeOne.getText().isEmpty()==true ||
						((TaxonomyCode.isSelected()==true) && (textReferralAddTaxonomyCodeTextBox.getText().isEmpty()==true)) ||
						((ProviderDetails.isSelected()==true) && (textReferralAddReferredToProviderNPItextbox.getText().isEmpty()==true))
						)
				{
					Alert alert=new Alert(AlertType.WARNING);
					alert.setTitle("Enter Data");
					alert.setContentText("Please Enter all Mandatory Fields.");
					alert.showAndWait();
				}
				else{
					Alert alert=new Alert(AlertType.CONFIRMATION);
					alert.setTitle("Data Validation Successful");
					alert.setContentText("Please Click Create EDI Data");
					alert.showAndWait();
				}}});
		//Create EDI Referral Add Data Event handler
		ReferralAddCreateEDIFileEligibility.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{              
				if(textFieldMemberIDReferralAdd.getText().isEmpty()==true || ReferralAddMemberDOBPicker.getValue()==null ||
						ReferralAddMemberDOSPicker.getValue()==null ||
						textReferralAddReferringProviderNPItextbox.getText().isEmpty()==true ||
						textFieldReferralAddDiagCodeOne.getText().isEmpty()==true ||
						textFieldReferralAddProcCodeOne.getText().isEmpty()==true ||
						((TaxonomyCode.isSelected()==true) && (textReferralAddTaxonomyCodeTextBox.getText().isEmpty()==true)) ||
						((ProviderDetails.isSelected()==true) && (textReferralAddReferredToProviderNPItextbox.getText().isEmpty()==true))
						)
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
						path=selectedDirectory.getAbsolutePath();
						path=path+"\\";
						pathm=path.replaceAll("\\\\", "\\\\\\\\");
						if(IsMemberAddComboBox.getValue().equalsIgnoreCase("Subscriber") && TaxonomyCode.isSelected()==true)
						{
							try
							{              
								Files.deleteIfExists(Paths.get(pathm+"Subscriber_Referral.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"Subscriber_Referral.txt"));
								out.writeBytes("ISA*00*          *00*          *ZZ*GATEWAYQES     *ZZ*042064683      *070612*1041*^*00501*745180001*0*T*:~GS*HI*GATEWAYQES*RTRC_ENT_5010*20080318*1846*39*X*005010X217~ST*278*000000001*005010X217~BHT*0007*13*216074187WEB*20130120*112806~HL*1**20*1~NM1*X3*2*AETNA*****PI*953402799~HL*2*1*21*1~NM1*1P*1*"+textReferralAddReferringProviderLNtextbox.getText()+"*"+textReferralAddReferringProviderFNtextbox.getText()+"****XX*"+textReferralAddReferringProviderNPItextbox.getText()+"~HL*3*2*22*1~NM1*IL*1*"+textFieldMemberLNameReferralAdd.getText()+"*"+textFieldMemberFNameReferralAdd.getText()+"****MI*"+textFieldMemberIDReferralAdd.getText()+"~DMG*D8*"+ReferralAddMemberDOBPicker.getValue().toString().replace("-","")+"*M~HL*4*3*EV*1~UM*SC*I*56*"+POScode+":B~");
								if (textFieldReferralAddDiagCodeThree.getText().isEmpty()==false) 
								{
									out.writeBytes("HI*ABF:"+textFieldReferralAddDiagCodeOne.getText()+"*ABK:"+textFieldReferralAddDiagCodeTwo.getText()+"*ABF:"+textFieldReferralAddDiagCodeThree.getText()+"~");
								}
								else if ((textFieldReferralAddDiagCodeThree.getText().isEmpty()==true)&&(textFieldReferralAddDiagCodeTwo.getText().isEmpty()==false))
								{
									out.writeBytes("HI*ABF:"+textFieldReferralAddDiagCodeOne.getText()+"*ABK:"+textFieldReferralAddDiagCodeTwo.getText()+"~");
								}
								else 
								{
									out.writeBytes("HI*ABF:"+textFieldReferralAddDiagCodeOne.getText()+"~");
								}
								out.writeBytes("HSD*VS*10~NM1*SJ*2*DHIREN~PRV*PE*PXC*"+textReferralAddTaxonomyCodeTextBox.getText()+"~");
								if (textFieldReferralAddProcCodeFive.getText().isEmpty()==false) 
								{
									out.writeBytes("HL*5*4*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~HL*7*6*SS*0~SV1*HC:"+textFieldReferralAddProcCodeThree.getText()+"~HL*8*7*SS*0~SV1*HC:"+textFieldReferralAddProcCodeFour.getText()+"~HL*9*8*SS*0~SV1*HC:"+textFieldReferralAddProcCodeFive.getText()+"~");
								}
								else if ((textFieldReferralAddProcCodeFive.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeFour.getText().isEmpty()==false))
								{
									out.writeBytes("HL*5*4*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~HL*7*6*SS*0~SV1*HC:"+textFieldReferralAddProcCodeThree.getText()+"~HL*8*7*SS*0~SV1*HC:"+textFieldReferralAddProcCodeFour.getText()+"~");
								}
								else if ((textFieldReferralAddProcCodeFive.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeFour.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeThree.getText().isEmpty()==false))
								{
									out.writeBytes("HL*5*4*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~HL*7*6*SS*0~SV1*HC:"+textFieldReferralAddProcCodeThree.getText()+"~");
								}
								else if  ((textFieldReferralAddProcCodeFive.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeFour.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeThree.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeTwo.getText().isEmpty()==false))
								{
									out.writeBytes("HL*5*4*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~");
								}
								else
								{
									out.writeBytes("HL*5*4*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~");
								}
								out.writeBytes("SE*26*000000001~GE*1*39~IEA*1*745180001");
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create Subscriber_Referral File");
							}
						}
						else if(IsMemberAddComboBox.getValue().equalsIgnoreCase("Subscriber") && ProviderDetails.isSelected()==true)
						{
							try
							{              
								Files.deleteIfExists(Paths.get(pathm+"Subscriber_Referral.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"Subscriber_Referral.txt"));
								out.writeBytes("ISA*00*          *00*          *ZZ*GATEWAYQES     *ZZ*042064683      *070612*1041*^*00501*745180001*0*T*:~GS*HI*GATEWAYQES*RTRC_ENT_5010*20080318*1846*39*X*005010X217~ST*278*000000001*005010X217~BHT*0007*13*216074187WEB*20130120*112806~HL*1**20*1~NM1*X3*2*AETNA*****PI*953402799~HL*2*1*21*1~NM1*1P*1*"+textReferralAddReferringProviderLNtextbox.getText()+"*"+textReferralAddReferringProviderFNtextbox.getText()+"****XX*"+textReferralAddReferringProviderNPItextbox.getText()+"~HL*3*2*22*1~NM1*IL*1*"+textFieldMemberLNameReferralAdd.getText()+"*"+textFieldMemberFNameReferralAdd.getText()+"****MI*"+textFieldMemberIDReferralAdd.getText()+"~DMG*D8*"+ReferralAddMemberDOBPicker.getValue().toString().replace("-","")+"*M~HL*4*3*EV*1~UM*SC*I*56*"+POScode+":B~");
								if (textFieldReferralAddDiagCodeThree.getText().isEmpty()==false) 
								{
									out.writeBytes("HI*ABF:"+textFieldReferralAddDiagCodeOne.getText()+"*ABK:"+textFieldReferralAddDiagCodeTwo.getText()+"*ABF:"+textFieldReferralAddDiagCodeThree.getText()+"~");
								}
								else if ((textFieldReferralAddDiagCodeThree.getText().isEmpty()==true)&&(textFieldReferralAddDiagCodeTwo.getText().isEmpty()==false))
								{
									out.writeBytes("HI*ABF:"+textFieldReferralAddDiagCodeOne.getText()+"*ABK:"+textFieldReferralAddDiagCodeTwo.getText()+"~");
								}
								else 
								{
									out.writeBytes("HI*ABF:"+textFieldReferralAddDiagCodeOne.getText()+"~");
								}
								// Refer To Provider code segment creation
								out.writeBytes("HSD*VS*10~NM1*SJ*2*"+textReferralAddReferredToProviderLNtextbox.getText()+"*"+textReferralAddReferredToProviderFNtextbox.getText()+"****XX*"+textReferralAddReferredToProviderNPItextbox.getText()+"~");
								// Procedure Code segment creation
								if (textFieldReferralAddProcCodeFive.getText().isEmpty()==false) 

								{
									out.writeBytes("HL*5*4*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~HL*7*6*SS*0~SV1*HC:"+textFieldReferralAddProcCodeThree.getText()+"~HL*8*7*SS*0~SV1*HC:"+textFieldReferralAddProcCodeFour.getText()+"~HL*9*8*SS*0~SV1*HC:"+textFieldReferralAddProcCodeFive.getText()+"~");
								}

								else if ((textFieldReferralAddProcCodeFive.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeFour.getText().isEmpty()==false))
								{
									out.writeBytes("HL*5*4*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~HL*7*6*SS*0~SV1*HC:"+textFieldReferralAddProcCodeThree.getText()+"~HL*8*7*SS*0~SV1*HC:"+textFieldReferralAddProcCodeFour.getText()+"~");
								}

								else if ((textFieldReferralAddProcCodeFive.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeFour.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeThree.getText().isEmpty()==false))

								{
									out.writeBytes("HL*5*4*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~HL*7*6*SS*0~SV1*HC:"+textFieldReferralAddProcCodeThree.getText()+"~");
								}

								else if  ((textFieldReferralAddProcCodeFive.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeFour.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeThree.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeTwo.getText().isEmpty()==false))
								{
									out.writeBytes("HL*5*4*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~");
								}

								else
								{
									out.writeBytes("HL*5*4*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~");
								}

								out.writeBytes("SE*26*000000001~GE*1*39~IEA*1*745180001");

								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create Subscriber+Referral_ID File");
							}
						}
						else if(IsMemberAddComboBox.getValue().equalsIgnoreCase("Dependent") && (TaxonomyCode.isSelected()==true))
						{
							try
							{              
								Files.deleteIfExists(Paths.get(pathm+"Subscriber_Referral.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"Subscriber_Referral.txt"));
								out.writeBytes("ISA*00*          *00*          *ZZ*GATEWAYQES     *ZZ*042064683      *070612*1041*^*00501*745180070*0*T*:~GS*HI*GATEWAYQES*RTRC_ENT_5010*20080318*1846*39*X*005010X217~ST*278*000000001*005010X217~BHT*0007*13*216074187WEB*20130120*112806~HL*1**20*1~NM1*X3*2*AETNA*****PI*953402799~HL*2*1*21*1~NM1*1P*1*"+textReferralAddReferringProviderLNtextbox.getText()+"*"+textReferralAddReferringProviderFNtextbox.getText()+"****XX*"+textReferralAddReferringProviderNPItextbox.getText()+"~HL*3*2*22*1~NM1*IL*1*"+textFieldMemberLNameReferralAdd.getText()+"*"+textFieldMemberFNameReferralAdd.getText()+"****MI*"+textFieldMemberIDReferralAdd.getText()+"~HL*4*3*23*0~NM1*QC*1*"+textFieldDepLNameReferralAdd.getText()+"*"+textFieldDependentFNameReferralAdd.getText()+"~DMG*D8*"+ReferralAddMemberDOBPicker.getValue().toString().replace("-","")+"~HL*5*4*EV*1~UM*SC*I*56*"+POScode+":B");
								if (textFieldReferralAddDiagCodeThree.getText().isEmpty()==false) 
								{
									out.writeBytes("HI*ABF:"+textFieldReferralAddDiagCodeOne.getText()+"*ABK:"+textFieldReferralAddDiagCodeTwo.getText()+"*ABF:"+textFieldReferralAddDiagCodeThree.getText()+"~");
								}
								else if ((textFieldReferralAddDiagCodeThree.getText().isEmpty()==true)&&(textFieldReferralAddDiagCodeTwo.getText().isEmpty()==false))
								{
									out.writeBytes("HI*ABF:"+textFieldReferralAddDiagCodeOne.getText()+"*ABK:"+textFieldReferralAddDiagCodeTwo.getText()+"~");
								}
								else 
								{
									out.writeBytes("HI*ABF:"+textFieldReferralAddDiagCodeOne.getText()+"~");
								}
								out.writeBytes("HSD*VS*10~NM1*SJ*2*DHIREN~PRV*PE*PXC*"+textReferralAddTaxonomyCodeTextBox.getText()+"~");
								if (textFieldReferralAddProcCodeFive.getText().isEmpty()==false) 
								{
									out.writeBytes("HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*7*6*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~HL*8*7*SS*0~SV1*HC:"+textFieldReferralAddProcCodeThree.getText()+"~HL*9*8*SS*0~SV1*HC:"+textFieldReferralAddProcCodeFour.getText()+"~HL*10*9*SS*0~SV1*HC:"+textFieldReferralAddProcCodeFive.getText()+"~");
								}
								else if ((textFieldReferralAddProcCodeFive.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeFour.getText().isEmpty()==false))
								{
									out.writeBytes("HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*7*6*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~HL*8*7*SS*0~SV1*HC:"+textFieldReferralAddProcCodeThree.getText()+"~HL*9*8*SS*0~SV1*HC:"+textFieldReferralAddProcCodeFour.getText()+"~");
								}
								else if ((textFieldReferralAddProcCodeFive.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeFour.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeThree.getText().isEmpty()==false))

								{
									out.writeBytes("HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*7*6*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~HL*8*7*SS*0~SV1*HC:"+textFieldReferralAddProcCodeThree.getText()+"~");
								}

								else if  ((textFieldReferralAddProcCodeFive.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeFour.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeThree.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeTwo.getText().isEmpty()==false))
								{
									out.writeBytes("HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*7*6*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~");
								}
								else
								{
									out.writeBytes("HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~");
								}
								out.writeBytes("SE*26*000000001~GE*1*39~IEA*1*745180070");
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create Dependent_Referral File");
							}
						}
						else if(IsMemberAddComboBox.getValue().equalsIgnoreCase("Dependent") && ProviderDetails.isSelected()==true)
						{
							try
							{              
								Files.deleteIfExists(Paths.get(pathm+"Subscriber_Referral.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"Subscriber_Referral.txt"));
								out.writeBytes("ISA*00*          *00*          *ZZ*GATEWAYQES     *ZZ*042064683      *070612*1041*^*00501*745180070*0*T*:~GS*HI*GATEWAYQES*RTRC_ENT_5010*20080318*1846*39*X*005010X217~ST*278*000000001*005010X217~BHT*0007*13*216074187WEB*20130120*112806~HL*1**20*1~NM1*X3*2*AETNA*****PI*953402799~HL*2*1*21*1~NM1*1P*1*"+textReferralAddReferringProviderLNtextbox.getText()+"*"+textReferralAddReferringProviderFNtextbox.getText()+"****XX*"+textReferralAddReferringProviderNPItextbox.getText()+"~HL*3*2*22*1~NM1*IL*1*"+textFieldMemberLNameReferralAdd.getText()+"*"+textFieldMemberFNameReferralAdd.getText()+"****MI*"+textFieldMemberIDReferralAdd.getText()+"~HL*4*3*23*0~NM1*QC*1*"+textFieldDepLNameReferralAdd.getText()+"*"+textFieldDependentFNameReferralAdd.getText()+"~DMG*D8*"+ReferralAddMemberDOBPicker.getValue().toString().replace("-","")+"~HL*5*4*EV*1~UM*SC*I*56*"+POScode+":B");
								if (textFieldReferralAddDiagCodeThree.getText().isEmpty()==false) 
								{
									out.writeBytes("HI*ABF:"+textFieldReferralAddDiagCodeOne.getText()+"*ABK:"+textFieldReferralAddDiagCodeTwo.getText()+"*ABF:"+textFieldReferralAddDiagCodeThree.getText()+"~");
								}
								else if ((textFieldReferralAddDiagCodeThree.getText().isEmpty()==true)&&(textFieldReferralAddDiagCodeTwo.getText().isEmpty()==false))
								{
									out.writeBytes("HI*ABF:"+textFieldReferralAddDiagCodeOne.getText()+"*ABK:"+textFieldReferralAddDiagCodeTwo.getText()+"~");
								}
								else 
								{
									out.writeBytes("HI*ABF:"+textFieldReferralAddDiagCodeOne.getText()+"~");
								}
								out.writeBytes("NM1*SJ*2*"+textReferralAddReferredToProviderLNtextbox.getText()+"*"+textReferralAddReferredToProviderFNtextbox.getText()+"****XX*"+textReferralAddReferredToProviderNPItextbox.getText()+"~");
								if (textFieldReferralAddProcCodeFive.getText().isEmpty()==false) 
								{
									out.writeBytes("HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*7*6*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~HL*8*7*SS*0~SV1*HC:"+textFieldReferralAddProcCodeThree.getText()+"~HL*9*8*SS*0~SV1*HC:"+textFieldReferralAddProcCodeFour.getText()+"~HL*10*9*SS*0~SV1*HC:"+textFieldReferralAddProcCodeFive.getText()+"~");
								}
								else if ((textFieldReferralAddProcCodeFive.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeFour.getText().isEmpty()==false))
								{
									out.writeBytes("HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*7*6*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~HL*8*7*SS*0~SV1*HC:"+textFieldReferralAddProcCodeThree.getText()+"~HL*9*8*SS*0~SV1*HC:"+textFieldReferralAddProcCodeFour.getText()+"~");
								}
								else if ((textFieldReferralAddProcCodeFive.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeFour.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeThree.getText().isEmpty()==false))
								{
									out.writeBytes("HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*7*6*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~HL*8*7*SS*0~SV1*HC:"+textFieldReferralAddProcCodeThree.getText()+"~");
								}
								else if  ((textFieldReferralAddProcCodeFive.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeFour.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeThree.getText().isEmpty()==true)&&(textFieldReferralAddProcCodeTwo.getText().isEmpty()==false))
								{
									out.writeBytes("HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~HL*7*6*SS*0~SV1*HC:"+textFieldReferralAddProcCodeTwo.getText()+"~");
								}
								else
								{
									out.writeBytes("HL*6*5*SS*0~SV1*HC:"+textFieldReferralAddProcCodeOne.getText()+"~");
								}
								out.writeBytes("SE*26*000000001~GE*1*39~IEA*1*745180070");
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create Dependent+Referral_ID File");
							}
						}
						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("Successful");
						alert.setContentText("File Created Successfully");
						alert.showAndWait();
					}
				}
			}
		});
		
		
		
		
		///////////////////////////////////////////////
		
		ReferralAddProcessEDIFileEligibility.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				String user=System.getProperty("user.name");
				try {
					DataOutputStream out = new DataOutputStream(new FileOutputStream("C:\\Users\\"+user+"\\Desktop\\Run.bat"));
					out.writeBytes("cd "+path);
					String newLine = System.getProperty("line.separator");
					out.writeBytes(newLine);
					out.writeBytes("ftp -s:cred.txt");
					out.writeBytes(newLine);
					out.writeBytes("exit");
					out.close();
					//Credentials and write to excel
					String smodified=path.replaceAll("\\\\", "\\\\\\\\");
					smodified=smodified+"Claim.txt";
					//System.out.println(smodified);
					DataOutputStream out1 = new DataOutputStream(new FileOutputStream(path+"cred.txt"));
					out1.writeBytes("open 167.69.210.90");
					newLine = System.getProperty("line.separator");
					out1.writeBytes(newLine);
					out1.writeBytes("S050518");
					out1.writeBytes(newLine);
					out1.writeBytes("MJ41#W4T");
					out1.writeBytes(newLine);
					out1.writeBytes("bin");
					out1.writeBytes(newLine);
					out1.writeBytes("put "+path+"Claim.txt test837.837");
					out1.writeBytes(newLine);
					out1.writeBytes("quit");
					out1.writeBytes(newLine);
					out1.close();
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				///////////////////////////////////////////////////////
				Runtime rt = Runtime.getRuntime();
				try {
					user=System.getProperty("user.name");
					String argu="C:\\Users\\"+user+"\\Desktop\\Run.bat";
					Runtime.getRuntime().exec("cmd /c start \"\" "+argu);
					Thread.sleep(1000);
					
					//
					user=System.getProperty("user.name");
					Files.deleteIfExists(Paths.get(path+"cred.txt"));
					Files.deleteIfExists(Paths.get("C:\\Users\\"+user+"\\Desktop\\Run.bat"));
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				Alert alert=new Alert(AlertType.INFORMATION);
				alert.setTitle("Successful");
				alert.setContentText("Selected Files FTPed Successfully.");
				alert.showAndWait();
			}});

		//Home Button Referral Add Inquiry Link Event Handler
		HomelinkReferralAdd.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) 
			{
				primaryStage.setScene(sceneBase);
				
				textFieldMemberLNameReferralAdd.clear();
				textFieldMemberIDReferralAdd.clear();
				IsMemberAddComboBox.setValue("Subscriber");
				ReferralAddMemberDOBPicker.getEditor().clear();
				ReferralAddMemberDOBPicker.setPromptText("MM/DD/YYYY");
				textFieldDependentFNameReferralAdd.clear();
				textFieldDepLNameReferralAdd.clear();
				ReferralAddMemberDOSPicker.getEditor().clear();
				ReferralAddMemberDOSPicker.setPromptText("MM/DD/YYYY");
				textReferralAddReferringProviderNPItextbox.clear();
				textReferralAddReferringProviderFNtextbox.clear();
				textReferralAddReferringProviderLNtextbox.clear();
				textReferralAddTaxonomyCodeTextBox.clear();
				textReferralAddReferredToProviderNPItextbox.clear();
				textReferralAddReferredToProviderFNtextbox.clear();
				textReferralAddReferredToProviderLNtextbox.clear();
				IsServiceTypeComboBox.setValue("Medical Care");
				ISAddPOSComboBox.setValue("Hospital Inpatient Medicare Part A");
				textFieldReferralAddDiagCodeOne.clear();
				textFieldReferralAddDiagCodeTwo.clear();
				textFieldReferralAddDiagCodeThree.clear();
				textFieldReferralAddProcCodeOne.clear();
				textFieldReferralAddProcCodeTwo.clear();
				textFieldReferralAddProcCodeThree.clear();
				textFieldReferralAddProcCodeFour.clear();
				textFieldReferralAddProcCodeFive.clear();
				textFieldMemberFNameReferralAdd.clear();
			}
		});

		ReferralAdd.getChildren().addAll(rectReferralAddBorder,rectReferralAddTop,textReferralAddTop,HomelinkReferralAdd,textReferralAddMemberFName,textFieldMemberFNameReferralAdd,textReferralAddMemberLName,textFieldMemberLNameReferralAdd,
				textReferralAddReqMemberID,textReferralAddMemberIDstar,textFieldMemberIDReferralAdd,textReqerralAddReqMemberIs,IsMemberAddComboBox,texReferralAddMemberDOB,
				textReferralAddMemerDOBstar, ReferralAddMemberDOBPicker,textReferralAddDependentFName, textFieldDependentFNameReferralAdd, textReferralAddDepLName,textFieldDepLNameReferralAdd,
				texReferralAddMemberDOS,textReferralAddMemerDOSstar,ReferralAddMemberDOSPicker,Rline1,textReferralAddReferringProviderNPI,textReferralAddReferringProviderNPIstar,textReferralAddReferringProviderNPItextbox,
				textReferralAddReferringProviderFNtextbox,textReferralAddReferringProviderLNtextbox,Rline2,textReferralAddReferredToProviderNPI,TaxonomyCode,ProviderDetails,textReferralAddTaxonomyCode,textReferralAddTaxonomyCodestar,textReferralAddTaxonomyCodeTextBox,
				textReferralAddReferredToProviderNPIID,textReferralAddReferredToProviderNPIstar,textReferralAddReferredToProviderNPItextbox,textReferralAddReferredToProviderFNtextbox,textReferralAddReferredToProviderLNtextbox,Rline3,
				textReqerralAddServiceTypeIs,IsServiceTypeComboBox,textReqerralAddPOSTypeIs,ISAddPOSComboBox,textReferralAddDiagCodeNameZero,textReferralAddDiagCodeNameOne,textFieldReferralAddDiagCodeOne,
				textReferralAddDiagCodeNameTwo,textFieldReferralAddDiagCodeTwo,textReferralAddDiagCodeNameThree,textFieldReferralAddDiagCodeThree,textReferralAddProcCodeNameZero,textReferralAddProcCodeNameOne,textFieldReferralAddProcCodeOne,textReferralAddProcCodeNameTwo,textFieldReferralAddProcCodeTwo,
				textReferralAddProcCodeNameThree,textFieldReferralAddProcCodeThree,textReferralAddProcCodeNameFour,textFieldReferralAddProcCodeFour,textReferralAddProcCodeNameFive,textFieldReferralAddProcCodeFive,
				ReferralAddvalidateDataEligibility,ReferralAddCreateEDIFileEligibility,ReferralAddProcessEDIFileEligibility,
				textReferralAddDiagCodestar,textReferralAddProcCodestar);
		return ReferralAdd;
	}

}
