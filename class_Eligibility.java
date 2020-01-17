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
import javafx.scene.control.ComboBox;
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

public class class_Eligibility {
	public Pane EligibilityCode (Pane RTE,Stage primaryStage,Scene sceneBase)
	{
		///////////////////////////////////////Eligibility Pane
		//Rectangle Eligibility
		Rectangle rectEligibilityTop = new Rectangle();
		rectEligibilityTop.setX(0.0f);
		rectEligibilityTop.setY(0.0f);
		rectEligibilityTop.setWidth(1360.0f);
		rectEligibilityTop.setHeight(60.0f);
		rectEligibilityTop.setFill(Color.STEELBLUE);
		rectEligibilityTop.setStroke(Color.STEELBLUE);
		//Boundary
		Rectangle rectEligibilityBorder = new Rectangle();
		rectEligibilityBorder.setX(1.5f);
		rectEligibilityBorder.setY(0.0f);
		rectEligibilityBorder.setWidth(1356.0f);
		rectEligibilityBorder.setHeight(682.0f);
		rectEligibilityBorder.setFill(Color.WHITE);
		rectEligibilityBorder.setStroke(Color.STEELBLUE);
		//Text Top Eligibility
		Text textEligibilityTop = new Text();
		textEligibilityTop.setText("           Real Time Eligibility");
		textEligibilityTop.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 24));
		textEligibilityTop.setFill(Color.WHITE);
		textEligibilityTop.setLayoutX(530);
		textEligibilityTop.setLayoutY(40);
		//Rectangle Eligibility
		Rectangle rectEligibilityMid = new Rectangle();
		rectEligibilityMid.setX(0.0f);
		rectEligibilityMid.setY(205.0f);
		rectEligibilityMid.setWidth(1360.0f);
		rectEligibilityMid.setHeight(60.0f);
		rectEligibilityMid.setFill(Color.STEELBLUE);
		rectEligibilityMid.setStroke(Color.STEELBLUE);
		//Text Top Eligibility
		Text textEligibilityMid = new Text();
		textEligibilityMid.setText("Subscriber / Patient");
		textEligibilityMid.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 24));
		textEligibilityMid.setFill(Color.WHITE);
		textEligibilityMid.setLayoutX(595);
		textEligibilityMid.setLayoutY(242);
		//Home Link
		Hyperlink HomelinkEligibility = new Hyperlink();
		HomelinkEligibility.setText("Home");
		HomelinkEligibility.setStyle("-fx-text-fill: YELLOW;");
		HomelinkEligibility.setLayoutX(1300);
		HomelinkEligibility.setLayoutY(2);
		HomelinkEligibility.setUnderline(false);
		HomelinkEligibility.setFocusTraversable(false);
		HomelinkEligibility.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 14));
		//Text payer Name Eligibility
		Text textEligibilityPayer = new Text();
		textEligibilityPayer.setText("Payer Name");
		textEligibilityPayer.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilityPayer.setFill(Color.BLACK);
		textEligibilityPayer.setLayoutX(100);
		textEligibilityPayer.setLayoutY(105);
		Text textEligibilityPayerstar = new Text();
		textEligibilityPayerstar.setText("*");
		textEligibilityPayerstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilityPayerstar.setFill(Color.RED);
		textEligibilityPayerstar.setLayoutX(200);
		textEligibilityPayerstar.setLayoutY(105);
		//TextField Payer
		TextField textFieldPayerEligibility = new TextField();
		textFieldPayerEligibility.setLayoutX(250);
		textFieldPayerEligibility.setLayoutY(84);
		textFieldPayerEligibility.setPrefWidth(300);
		textFieldPayerEligibility.setPrefHeight(35);
		textFieldPayerEligibility.setEditable(true);
		textFieldPayerEligibility.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldPayerEligibility.setTooltip(new Tooltip("Enter Payer Name"));
		textFieldPayerEligibility.setPromptText("Payer Name");
		////Text Provider NPI Eligibility
		Text textEligibilityProviderNPI = new Text();
		textEligibilityProviderNPI.setText("Provider NPI");
		textEligibilityProviderNPI.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilityProviderNPI.setFill(Color.BLACK);
		textEligibilityProviderNPI.setLayoutX(100);
		textEligibilityProviderNPI.setLayoutY(165);
		//* mark
		Text textEligibilityProviderNPIstar = new Text();
		textEligibilityProviderNPIstar.setText("*");
		textEligibilityProviderNPIstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilityProviderNPIstar.setFill(Color.RED);
		textEligibilityProviderNPIstar.setLayoutX(200);
		textEligibilityProviderNPIstar.setLayoutY(165);
		//TextField Payer
		TextField textFieldProviderNPIEligibility = new TextField();
		textFieldProviderNPIEligibility.setLayoutX(250);
		textFieldProviderNPIEligibility.setLayoutY(144);
		textFieldProviderNPIEligibility.setPrefWidth(300);
		textFieldProviderNPIEligibility.setPrefHeight(35);
		textFieldProviderNPIEligibility.setEditable(true);
		textFieldProviderNPIEligibility.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldProviderNPIEligibility.setTooltip(new Tooltip("Enter Provider NPI : Numeric Values Only"));
		textFieldProviderNPIEligibility.setPromptText("Provider NPI");
		//Provider name Text
		Text textEligibilityProviderName = new Text();
		textEligibilityProviderName.setText("Provider Name");
		textEligibilityProviderName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilityProviderName.setFill(Color.BLACK);
		textEligibilityProviderName.setLayoutX(775);
		textEligibilityProviderName.setLayoutY(165);
		//Provider name textfield
		TextField textFieldProviderNameEligibility = new TextField();
		textFieldProviderNameEligibility.setLayoutX(925);
		textFieldProviderNameEligibility.setLayoutY(144);
		textFieldProviderNameEligibility.setPrefWidth(300);
		textFieldProviderNameEligibility.setPrefHeight(35);
		textFieldProviderNameEligibility.setEditable(true);
		textFieldProviderNameEligibility.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldProviderNameEligibility.setTooltip(new Tooltip("Provider Name"));
		textFieldProviderNameEligibility.setText("GATEWAYQES");
		textFieldProviderNameEligibility.setEditable(false);
		///////////
		int LIMITPayer = 120;
		textFieldPayerEligibility.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldPayerEligibility.getText().length() >= LIMITPayer) {
						textFieldPayerEligibility.setText(textFieldPayerEligibility.getText().substring(0, LIMITPayer));
					}}}});
		///Provider NPI Only Numbers
		textFieldProviderNPIEligibility.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue,String newValue) {try{if (newValue.matches("\\d*") && textFieldProviderNPIEligibility.getText().length()<=10) {int value = Integer.parseInt(newValue);} else {textFieldProviderNPIEligibility.setText(oldValue);}}catch(Exception e){}}});
		//Text payer Name Eligibility
		Text textEligibilityDOS = new Text();
		textEligibilityDOS.setText("Date of Service");
		textEligibilityDOS.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilityDOS.setFill(Color.BLACK);
		textEligibilityDOS.setLayoutX(100);
		textEligibilityDOS.setLayoutY(310);
		//* mark
		Text textEligibilityDOSstar = new Text();
		textEligibilityDOSstar.setText("*");
		textEligibilityDOSstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilityDOSstar.setFill(Color.RED);
		textEligibilityDOSstar.setLayoutX(220);
		textEligibilityDOSstar.setLayoutY(310);
		//Date Picker
		DatePicker startDatePicker = new DatePicker();
		startDatePicker.setLayoutX(250);
		startDatePicker.setLayoutY(289);
		startDatePicker.setPrefWidth(300);
		startDatePicker.setPrefHeight(35);
		startDatePicker.setPromptText("MM/DD/YYYY");
		startDatePicker.setTooltip(new Tooltip("Choose Date of Service"));
		startDatePicker.setEditable(false);
		startDatePicker.setStyle("-fx-font: 18px \"Calibri\";");

		startDatePicker.setOnAction(e ->
		{
			LocalDate date = startDatePicker.getValue();
		});

		//Text Benefit/searchType Code Eligibility
		Text textEligibilityBSTC = new Text();
		textEligibilityBSTC.setText("Benefit / Service "+"\n"+"Type Code");
		textEligibilityBSTC.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilityBSTC.setFill(Color.BLACK);
		textEligibilityBSTC.setLayoutX(775);
		textEligibilityBSTC.setLayoutY(310);
		//* mark
		Text textEligibilityBSTCstar = new Text();
		textEligibilityBSTCstar.setText("*");
		textEligibilityBSTCstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilityBSTCstar.setFill(Color.RED);
		textEligibilityBSTCstar.setLayoutX(860);
		textEligibilityBSTCstar.setLayoutY(330);
		//ComboBox
		ComboBox<String> EligibilityComboBox = new ComboBox<String>();
		EligibilityComboBox.getItems().addAll("01- Medical Care","02- Surgical","03- Consultation","04- Diagnostic X-Ray","05- Diagnostic Lab","06- Radiation Therapy","07- Anesthesia",
				"08- Surgical Assistance","09- Other Medical","10- Blood Charges","11- Used Durable Medical Equipment","12- Durable Medical Equipment Purchase","13- Ambulatory Service Center Facility",
				"14- Renal Supplies in the Home","15- Alternate Method Dialysis","16- Chronic Renal Disease (CRD) Equipment","17- Pre-Admission Testing","18- Durable Medical Equipment Rental",
				"19- Pneumonia Vaccine","20- Second Surgical Opinion","21- Third Surgical Opinion","22- Social Work","23- Diagnostic Dental","24- Periodontics",
				"25- Restorative","26- Endodontics","27- Maxillofacial Prosthetics","28- Adjunctive Dental Services","30- Health Benefit Plan Coverage",
				"32- Plan Waiting Period","33- Chiropractic","34- Chiropractic Office Visits","35- Dental Care","36- Dental Crowns","37- Dental Accident",
				"38- Orthodontics","39- Prosthodontics","40- Oral Surgery","41- Routine (Preventive) Dental","42- Home Health Care","43- Home Health Prescriptions","44- Home Health Visits",
				"45- Hospice","46- Respite Care","47- Hospital","48- Hospital - Inpatient","49- Hospital - Room and Board","50- Hospital - Outpatient","51- Hospital - Emergency Accident",
				"52- Hospital - Emergency Medical","53- Hospital - Ambulatory Surgical","54- Long Term Care","55- Major Medical","56- Medically Related Transportation","57- Air Transportation",
				"58- Cabulance","59- Licensed Ambulance","60- General Benefits","61- In-vitro Fertilization","62- MRI/CAT Scan","63- Donor Procedures","64- Acupuncture","65- Newborn Care",
				"66- Pathology","67- Smoking Cessation","68- Well Baby Care","69- Maternity","70- Transplants","71- Audiology Exam","72- Inhalation Therapy",
				"73- Diagnostic Medical","74- Private Duty Nursing","75- Prosthetic Device","76- Dialysis","77- Otological Exam","78- Chemotherapy","79- Allergy Testing","80- Immunizations",
				"81- Routine Physical","82- Family Planning","83- Infertility","84- Abortion","85- AIDS","86- Emergency Services","87- Cancer","88- Pharmacy",
				"89- Free Standing Prescription Drug","90- Mail Order Prescription Drug","91- Brand Name Prescription Drug","92- Generic Prescription Drug",
				"93- Podiatry","94- Podiatry - Office Visits","95- Podiatry - Nursing Home Visits","96- Professional (Physician)","97- Anesthesiologist","98- Professional (Physician) Visit - Office","99- Professional (Physician) Visit - Inpatient",
				"A0- Professional (Physician) Visit - Outpatient","A1- Professional (Physician) Visit - Nursing Home","A2- Professional (Physician) Visit - Skilled Nursing Facility","A3- Professional (Physician) Visit - Home",
				"A4- Psychiatric","A5- Psychiatric - Room and Board","A6- Psychotherapy","A7- Psychiatric - Inpatient","A8- Psychiatric - Outpatient","A9- Rehabilitation",
				"AA- Rehabilitation - Room and Board","AB- Rehabilitation - Inpatient","AC- Rehabilitation - Outpatient","AD- Occupational Therapy","AE- Physical Medicine","AF- Speech Therapy","AG- Skilled Nursing Care","AH-  Skilled Nursing Care - Room and Board",
				"AI- Substance Abuse","AJ- Alcoholism","AK- Drug Addiction","AL- Vision (Optometry)","AM- Frames","AO- Lenses","AQ- Nonmedically Necessary Physical","AR- Experimental Drug Therapy",
				"B1- Burn Care","B2- Brand Name Prescription Drug - Formulary","B3- Brand Name Prescription Drug - Non-Formulary","BA- Independent Medical Evaluation","BB- Partial Hospitalization (Psychiatric)","BC- Day Care (Psychiatric)","BD- Cognitive Therapy","BE- Massage Therapy",
				"BF- Pulmonary Rehabilitation","BG- Cardiac Rehabilitation","BH- Pediatric","BI- Nursery","BJ- Skin","BK- Orthopedic","BL- Cardiac","BM- Lymphatic","BN- Gastrointestinal","BP- Endocrine","BQ- Neurology","BR- Eye","BS- Invasive Procedures",
				"BT- Gynecological","BU- Obstetrical","BV- Obstetrical/Gynecological","BW- Mail Order Prescription Drug: Brand Name","BX- Mail Order Prescription Drug: Generic","BY- Physician Visit - Office: Sick","BZ- Physician Visit - Office: Well","C1- Coronary Care","CA- Private Duty Nursing - Inpatient",
				"CB- Private Duty Nursing - Home","CC- Surgical Benefits - Professional (Physician)","CD- Surgical Benefits - Facility","CE- Mental Health Provider - Inpatient","CF- Mental Health Provider - Outpatient","CG- Mental Health Facility - Inpatient","CH- Mental Health Facility - Outpatient",
				"CI- Substance Abuse Facility - Inpatient","CJ- Substance Abuse Facility - Outpatient","CK- Screening X-ray","CL- Screening laboratory","CM- Mammogram, High Risk Patient","CN- Mammogram, Low Risk Patient","CO- Flu Vaccination","CP- Eyewear and Eyewear Accessories","CQ- Case Management","DG- Dermatology","DM- Durable Medical Equipment",
				"DS- Diabetic Supplies","GF- Generic Prescription Drug - Formulary","GN- Generic Prescription Drug - Non-Formulary","GY- Allergy","IC- Intensive Care","MH- Mental Health","NI- Neonatal Intensive Care","ON- Oncology","PT- Physical Therapy","PU- Pulmonary","RN- Renal","RT- Residential Psychiatric Treatment","TC- Transitional Care","TN- Transitional Nursery Care","UC- Urgent Care");
		EligibilityComboBox.setEditable(false); 
		EligibilityComboBox.setMinWidth(300);
		EligibilityComboBox.setMaxWidth(300);
		EligibilityComboBox.setMinHeight(35);
		EligibilityComboBox.setLayoutX(925);
		EligibilityComboBox.setLayoutY(295);
		EligibilityComboBox.setTooltip(new Tooltip("Select an Option"));
		EligibilityComboBox.setPromptText("Select       ");
		EligibilityComboBox.setStyle("-fx-font: 18px \"Calibri\";");
		//Text Search Option Eligibility
		Text textEligibilitySearchOption = new Text();
		textEligibilitySearchOption.setText("Search Option");
		textEligibilitySearchOption.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilitySearchOption.setFill(Color.BLACK);
		textEligibilitySearchOption.setLayoutX(100);
		textEligibilitySearchOption.setLayoutY(370);
		//* mark
		Text textEligibilitySearchOptionstar = new Text();
		textEligibilitySearchOptionstar.setText("*");
		textEligibilitySearchOptionstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilitySearchOptionstar.setFill(Color.RED);
		textEligibilitySearchOptionstar.setLayoutX(213);
		textEligibilitySearchOptionstar.setLayoutY(370);
		//ComboBox
		ComboBox<String> EligibilitySearchComboBox = new ComboBox<String>();
		EligibilitySearchComboBox.getItems().addAll("Member Id, Last Name, First Name & Patient DOB","Member Id, Last Name & Patient DOB","Member Id, First Name & Patient DOB","Member Id & Patient DOB","Member Id, Last Name & First Name","Last Name, First Name & Patient DOB");
		EligibilitySearchComboBox.setEditable(false); 
		EligibilitySearchComboBox.setMinWidth(975);
		EligibilitySearchComboBox.setMinHeight(35);
		EligibilitySearchComboBox.setLayoutX(250);
		EligibilitySearchComboBox.setLayoutY(350);
		EligibilitySearchComboBox.setTooltip(new Tooltip("Select a Search Criteria"));
		EligibilitySearchComboBox.setPromptText("                                                                                                  Select");
		EligibilitySearchComboBox.setStyle("-fx-font: 18px \"Calibri\";");
		//Text Search Option Eligibility
		Text textEligibilitySearchOptionOne = new Text();
		textEligibilitySearchOptionOne.setText("Subscriber's / "+"\n"+"Patient First Name");
		textEligibilitySearchOptionOne.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilitySearchOptionOne.setFill(Color.BLACK);
		textEligibilitySearchOptionOne.setLayoutX(100);
		textEligibilitySearchOptionOne.setLayoutY(430);
		//TextField Payer
		TextField textFieldEligibilitySearchOptionOne = new TextField();
		textFieldEligibilitySearchOptionOne.setLayoutX(250);
		textFieldEligibilitySearchOptionOne.setLayoutY(420);
		textFieldEligibilitySearchOptionOne.setPrefWidth(300);
		textFieldEligibilitySearchOptionOne.setPrefHeight(35);
		textFieldEligibilitySearchOptionOne.setEditable(true);
		textFieldEligibilitySearchOptionOne.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldEligibilitySearchOptionOne.setTooltip(new Tooltip("Enter First Name"));
		textFieldEligibilitySearchOptionOne.setPromptText("Subscriber's / Patient First Name");
		textFieldEligibilitySearchOptionOne.setDisable(true);
		//Text Search Option Eligibility
		Text textEligibilitySearchOptionTwo = new Text();
		textEligibilitySearchOptionTwo.setText("Subscriber's / "+"\n"+"Patient Last Name");
		textEligibilitySearchOptionTwo.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilitySearchOptionTwo.setFill(Color.BLACK);
		textEligibilitySearchOptionTwo.setLayoutX(775);
		textEligibilitySearchOptionTwo.setLayoutY(430);
		//TextField Payer
		TextField textFieldEligibilitySearchOptionTwo = new TextField();
		textFieldEligibilitySearchOptionTwo.setLayoutX(925);
		textFieldEligibilitySearchOptionTwo.setLayoutY(420);
		textFieldEligibilitySearchOptionTwo.setPrefWidth(300);
		textFieldEligibilitySearchOptionTwo.setPrefHeight(35);
		textFieldEligibilitySearchOptionTwo.setEditable(true);
		textFieldEligibilitySearchOptionTwo.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldEligibilitySearchOptionTwo.setTooltip(new Tooltip("Enter Last Name"));
		textFieldEligibilitySearchOptionTwo.setPromptText("Subscriber's / Patient Last Name");
		textFieldEligibilitySearchOptionTwo.setDisable(true);
		//Text Search Option Eligibility
		Text textEligibilitySearchOptionThree = new Text();
		textEligibilitySearchOptionThree.setText("Subscriber "+"\n"+"Member ID");
		textEligibilitySearchOptionThree.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilitySearchOptionThree.setFill(Color.BLACK);
		textEligibilitySearchOptionThree.setLayoutX(100);
		textEligibilitySearchOptionThree.setLayoutY(490);
		//TextField Payer
		TextField textFieldEligibilitySearchOptionThree = new TextField();
		textFieldEligibilitySearchOptionThree.setLayoutX(250);
		textFieldEligibilitySearchOptionThree.setLayoutY(480);
		textFieldEligibilitySearchOptionThree.setPrefWidth(300);
		textFieldEligibilitySearchOptionThree.setPrefHeight(35);
		textFieldEligibilitySearchOptionThree.setEditable(true);
		textFieldEligibilitySearchOptionThree.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldEligibilitySearchOptionThree.setTooltip(new Tooltip("Enter Member ID"));
		textFieldEligibilitySearchOptionThree.setPromptText("Subscriber Member ID");
		textFieldEligibilitySearchOptionThree.setDisable(true);
		//Text Search Option Eligibility
		Text textEligibilitySearchOptionFour = new Text();
		textEligibilitySearchOptionFour.setText("Subscriber / "+"\n"+"Patient DOB ");
		textEligibilitySearchOptionFour.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textEligibilitySearchOptionFour.setFill(Color.BLACK);
		textEligibilitySearchOptionFour.setLayoutX(775);
		textEligibilitySearchOptionFour.setLayoutY(490);
		//Date Picker
		DatePicker textFieldEligibilitySearchOptionFour = new DatePicker();
		textFieldEligibilitySearchOptionFour.setLayoutX(925);
		textFieldEligibilitySearchOptionFour.setLayoutY(480);
		textFieldEligibilitySearchOptionFour.setPrefWidth(300);
		textFieldEligibilitySearchOptionFour.setPrefHeight(35);
		textFieldEligibilitySearchOptionFour.setPromptText("MM/DD/YYYY");
		textFieldEligibilitySearchOptionFour.setTooltip(new Tooltip("Enter DOB"));
		textFieldEligibilitySearchOptionFour.setEditable(false);
		textFieldEligibilitySearchOptionFour.setStyle("-fx-font: 18px \"Calibri\";");
		textFieldEligibilitySearchOptionFour.setDisable(true);
		//SearchOption One Limit
		textFieldEligibilitySearchOptionOne.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldEligibilitySearchOptionOne.getText().length() >= 35) {
						textFieldEligibilitySearchOptionOne.setText(textFieldEligibilitySearchOptionOne.getText().substring(0, 35));
					}
				}
			}
		});
		//SearchOption Two Limit
		textFieldEligibilitySearchOptionTwo.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldEligibilitySearchOptionTwo.getText().length() >= 60) {
						textFieldEligibilitySearchOptionTwo.setText(textFieldEligibilitySearchOptionTwo.getText().substring(0, 60));
					}
				}
			}
		});
		//SearchOption Three Limit
		textFieldEligibilitySearchOptionThree.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldEligibilitySearchOptionThree.getText().length() >= 10) {
						textFieldEligibilitySearchOptionThree.setText(textFieldEligibilitySearchOptionThree.getText().substring(0, 10));
					}
				}
			}
		});
		textFieldEligibilitySearchOptionFour.setOnAction(e ->
		{
			LocalDate dateDOB = startDatePicker.getValue();
		});
		EligibilitySearchComboBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(EligibilitySearchComboBox.getValue().equalsIgnoreCase("Member Id, Last Name, First Name & Patient DOB"))
				{
					textFieldEligibilitySearchOptionOne.setDisable(false);
					textFieldEligibilitySearchOptionTwo.setDisable(false);
					textFieldEligibilitySearchOptionThree.setDisable(false);
					textFieldEligibilitySearchOptionFour.setDisable(false);
				}
				else if(EligibilitySearchComboBox.getValue().equalsIgnoreCase("Member Id, Last Name & Patient DOB"))
				{
					textFieldEligibilitySearchOptionOne.setDisable(true);
					textFieldEligibilitySearchOptionTwo.setDisable(false);
					textFieldEligibilitySearchOptionThree.setDisable(false);
					textFieldEligibilitySearchOptionFour.setDisable(false);
				}
				else if(EligibilitySearchComboBox.getValue().equalsIgnoreCase("Member Id, First Name & Patient DOB"))
				{
					textFieldEligibilitySearchOptionOne.setDisable(false);
					textFieldEligibilitySearchOptionTwo.setDisable(true);
					textFieldEligibilitySearchOptionThree.setDisable(false);
					textFieldEligibilitySearchOptionFour.setDisable(false);
				}
				else if(EligibilitySearchComboBox.getValue().equalsIgnoreCase("Member Id & Patient DOB"))
				{
					textFieldEligibilitySearchOptionOne.setDisable(true);
					textFieldEligibilitySearchOptionTwo.setDisable(true);
					textFieldEligibilitySearchOptionThree.setDisable(false);
					textFieldEligibilitySearchOptionFour.setDisable(false);
				}
				else if(EligibilitySearchComboBox.getValue().equalsIgnoreCase("Member Id, Last Name & First Name"))
				{
					textFieldEligibilitySearchOptionOne.setDisable(false);
					textFieldEligibilitySearchOptionTwo.setDisable(false);
					textFieldEligibilitySearchOptionThree.setDisable(false);
					textFieldEligibilitySearchOptionFour.setDisable(true);
				}
				else if(EligibilitySearchComboBox.getValue().equalsIgnoreCase("Last Name, First Name & Patient DOB"))
				{
					textFieldEligibilitySearchOptionOne.setDisable(false);
					textFieldEligibilitySearchOptionTwo.setDisable(false);
					textFieldEligibilitySearchOptionThree.setDisable(true);
					textFieldEligibilitySearchOptionFour.setDisable(false);
				}
				else
				{
					textFieldEligibilitySearchOptionOne.setDisable(true);
					textFieldEligibilitySearchOptionTwo.setDisable(true);
					textFieldEligibilitySearchOptionThree.setDisable(true);
					textFieldEligibilitySearchOptionFour.setDisable(true);
				}
			}
		});
		//Validate Data Button
		Button validateDataEligibility = new Button();
		validateDataEligibility.setText("Validate Data");
		validateDataEligibility.setLayoutX(430);
		validateDataEligibility.setLayoutY(600);
		validateDataEligibility.setMinWidth(150);
		validateDataEligibility.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		validateDataEligibility.setTextFill(Color.STEELBLUE);
		validateDataEligibility.setStyle("-fx-background-color:STEELBLUE");
		validateDataEligibility.setTextFill(Color.WHITE);
		//Create EDI File Button
		Button CreateEDIFileEligibility = new Button();
		CreateEDIFileEligibility.setText("Create EDI Data");
		CreateEDIFileEligibility.setLayoutX(600);
		CreateEDIFileEligibility.setLayoutY(600);
		CreateEDIFileEligibility.setMinWidth(150);
		CreateEDIFileEligibility.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		CreateEDIFileEligibility.setStyle("-fx-background-color:STEELBLUE");
		CreateEDIFileEligibility.setTextFill(Color.WHITE);
		//Process EDI File Button
		Button ProcessEDIFileEligibility = new Button();
		ProcessEDIFileEligibility.setText("Process EDI Data");
		ProcessEDIFileEligibility.setLayoutX(770);
		ProcessEDIFileEligibility.setLayoutY(600);
		ProcessEDIFileEligibility.setMinWidth(150);
		ProcessEDIFileEligibility.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		ProcessEDIFileEligibility.setStyle("-fx-background-color:STEELBLUE");
		ProcessEDIFileEligibility.setTextFill(Color.WHITE);
		//Validate Data Event
		validateDataEligibility.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(textFieldPayerEligibility.getText().isEmpty()==true || 
						textFieldProviderNPIEligibility.getText().isEmpty()==true ||
						EligibilityComboBox.getSelectionModel().getSelectedIndex()==-1 ||
						EligibilitySearchComboBox.getSelectionModel().getSelectedIndex()==-1 ||
						startDatePicker.getValue()==null)
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
		//Process Data Event handler
		CreateEDIFileEligibility.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(textFieldPayerEligibility.getText().isEmpty()==true || 
						textFieldProviderNPIEligibility.getText().isEmpty()==true ||
						EligibilityComboBox.getSelectionModel().getSelectedIndex()==-1 ||
						EligibilitySearchComboBox.getSelectionModel().getSelectedIndex()==-1 ||
						startDatePicker.getValue()==null)
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
						if(EligibilitySearchComboBox.getValue().equalsIgnoreCase("Member Id, Last Name, First Name & Patient DOB"))
						{
							try
							{	
								Files.deleteIfExists(Paths.get(pathm+"FName_LName_MID_DOB.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"FName_LName_MID_DOB.txt"));
								out.writeBytes("ISA*00*          *00*          *30*GATEWAYQES     *01*042064683      *120210*1613*^*00501*111199999*0*T*:");
								String newLine = System.getProperty("line.separator");
								out.writeBytes(newLine);
								out.writeBytes("GS*HS*GATEWAYQES*RTE_5010*20120210*1613*28494605*X*005010X279A1");
								out.writeBytes(newLine);
								out.writeBytes("ST*270*0001*005010X279A1");
								out.writeBytes(newLine);
								out.writeBytes("BHT*0022*13*204321322*20120210*1613");
								out.writeBytes(newLine);
								out.writeBytes("HL*1**20*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*PR*1*"+textFieldPayerEligibility.getText()+"*****46*953402799");
								out.writeBytes(newLine);
								out.writeBytes("HL*2*1*21*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*1P*1*"+textFieldProviderNameEligibility.getText()+"*****XX*"+textFieldProviderNPIEligibility.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*3*2*22*0");
								out.writeBytes(newLine);
								out.writeBytes("NM1*IL*1*"+textFieldEligibilitySearchOptionTwo.getText()+"*"+textFieldEligibilitySearchOptionOne.getText()+"****MI*"+textFieldEligibilitySearchOptionThree.getText());
								out.writeBytes(newLine);
								out.writeBytes("DMG*D8*"+textFieldEligibilitySearchOptionFour.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("DTP*291*D8*"+startDatePicker.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("EQ*"+EligibilityComboBox.getValue().toString().substring(0, 2));
								out.writeBytes(newLine);
								out.writeBytes("SE*12*0001");
								out.writeBytes(newLine);
								out.writeBytes("GE*1*28494605");
								out.writeBytes(newLine);
								out.writeBytes("IEA*1*111199999");
								out.writeBytes(newLine);
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create FName_LName_MID_DOB.txt File");
							}
						}
						else if(EligibilitySearchComboBox.getValue().equalsIgnoreCase("Member Id, Last Name & Patient DOB"))
						{
							try
							{	
								Files.deleteIfExists(Paths.get(pathm+"LName_MID_DOB.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"LName_MID_DOB.txt"));
								out.writeBytes("ISA*00*          *00*          *30*GATEWAYQES     *01*042064683      *120210*1613*^*00501*111199999*0*T*:");
								String newLine = System.getProperty("line.separator");
								out.writeBytes(newLine);
								out.writeBytes("GS*HS*GATEWAYQES*RTE_5010*20120210*1613*28494605*X*005010X279A1");
								out.writeBytes(newLine);
								out.writeBytes("ST*270*0001*005010X279A1");
								out.writeBytes(newLine);
								out.writeBytes("BHT*0022*13*204321322*20120210*1613");
								out.writeBytes(newLine);
								out.writeBytes("HL*1**20*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*PR*1*"+textFieldPayerEligibility.getText()+"*****46*953402799");
								out.writeBytes(newLine);
								out.writeBytes("HL*2*1*21*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*1P*1*"+textFieldProviderNameEligibility.getText()+"*****XX*"+textFieldProviderNPIEligibility.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*3*2*22*0");
								out.writeBytes(newLine);
								out.writeBytes("NM1*IL*1*"+textFieldEligibilitySearchOptionTwo.getText()+"*****MI*"+textFieldEligibilitySearchOptionThree.getText());
								out.writeBytes(newLine);
								out.writeBytes("DMG*D8*"+textFieldEligibilitySearchOptionFour.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("DTP*291*D8*"+startDatePicker.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("EQ*"+EligibilityComboBox.getValue().toString().substring(0, 2));
								out.writeBytes(newLine);
								out.writeBytes("SE*12*0001");
								out.writeBytes(newLine);
								out.writeBytes("GE*1*28494605");
								out.writeBytes(newLine);
								out.writeBytes("IEA*1*111199999");
								out.writeBytes(newLine);
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create LName_MID_DOB.txt File");
							}
						}
						else if(EligibilitySearchComboBox.getValue().equalsIgnoreCase("Member Id, First Name & Patient DOB"))
						{
							try
							{	
								Files.deleteIfExists(Paths.get(pathm+"FName_MID_DOB.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"FName_MID_DOB.txt"));
								out.writeBytes("ISA*00*          *00*          *30*GATEWAYQES     *01*042064683      *120210*1613*^*00501*111199999*0*T*:");
								String newLine = System.getProperty("line.separator");
								out.writeBytes(newLine);
								out.writeBytes("GS*HS*GATEWAYQES*RTE_5010*20120210*1613*28494605*X*005010X279A1");
								out.writeBytes(newLine);
								out.writeBytes("ST*270*0001*005010X279A1");
								out.writeBytes(newLine);
								out.writeBytes("BHT*0022*13*204321322*20120210*1613");
								out.writeBytes(newLine);
								out.writeBytes("HL*1**20*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*PR*1*"+textFieldPayerEligibility.getText()+"*****46*953402799");
								out.writeBytes(newLine);
								out.writeBytes("HL*2*1*21*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*1P*1*"+textFieldProviderNameEligibility.getText()+"*****XX*"+textFieldProviderNPIEligibility.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*3*2*22*0");
								out.writeBytes(newLine);
								out.writeBytes("NM1*IL*1**"+textFieldEligibilitySearchOptionOne.getText()+"****MI*"+textFieldEligibilitySearchOptionThree.getText());
								out.writeBytes(newLine);
								out.writeBytes("DMG*D8*"+textFieldEligibilitySearchOptionFour.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("DTP*291*D8*"+startDatePicker.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("EQ*"+EligibilityComboBox.getValue().toString().substring(0, 2));
								out.writeBytes(newLine);
								out.writeBytes("SE*12*0001");
								out.writeBytes(newLine);
								out.writeBytes("GE*1*28494605");
								out.writeBytes(newLine);
								out.writeBytes("IEA*1*111199999");
								out.writeBytes(newLine);
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create FName_MID_DOB.txt File");
							}
						}
						else if(EligibilitySearchComboBox.getValue().equalsIgnoreCase("Member Id & Patient DOB"))
						{
							try
							{	
								Files.deleteIfExists(Paths.get(pathm+"MID_DOB.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"MID_DOB.txt"));
								out.writeBytes("ISA*00*          *00*          *30*GATEWAYQES     *01*042064683      *120210*1613*^*00501*111199999*0*T*:");
								String newLine = System.getProperty("line.separator");
								out.writeBytes(newLine);
								out.writeBytes("GS*HS*GATEWAYQES*RTE_5010*20120210*1613*28494605*X*005010X279A1");
								out.writeBytes(newLine);
								out.writeBytes("ST*270*0001*005010X279A1");
								out.writeBytes(newLine);
								out.writeBytes("BHT*0022*13*204321322*20120210*1613");
								out.writeBytes(newLine);
								out.writeBytes("HL*1**20*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*PR*1*"+textFieldPayerEligibility.getText()+"*****46*953402799");
								out.writeBytes(newLine);
								out.writeBytes("HL*2*1*21*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*1P*1*"+textFieldProviderNameEligibility.getText()+"*****XX*"+textFieldProviderNPIEligibility.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*3*2*22*0");
								out.writeBytes(newLine);
								out.writeBytes("NM1*IL*1******MI*"+textFieldEligibilitySearchOptionThree.getText());
								out.writeBytes(newLine);
								out.writeBytes("DMG*D8*"+textFieldEligibilitySearchOptionFour.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("DTP*291*D8*"+startDatePicker.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("EQ*"+EligibilityComboBox.getValue().toString().substring(0, 2));
								out.writeBytes(newLine);
								out.writeBytes("SE*12*0001");
								out.writeBytes(newLine);
								out.writeBytes("GE*1*28494605");
								out.writeBytes(newLine);
								out.writeBytes("IEA*1*111199999");
								out.writeBytes(newLine);
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create MID_DOB.txt File");
							}
						}
						else if(EligibilitySearchComboBox.getValue().equalsIgnoreCase("Member Id, Last Name & First Name"))
						{
							try
							{	
								Files.deleteIfExists(Paths.get(pathm+"FName_LName_MID.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"FName_LName_MID.txt"));
								out.writeBytes("ISA*00*          *00*          *30*GATEWAYQES     *01*042064683      *120210*1613*^*00501*111199999*0*T*:");
								String newLine = System.getProperty("line.separator");
								out.writeBytes(newLine);
								out.writeBytes("GS*HS*GATEWAYQES*RTE_5010*20120210*1613*28494605*X*005010X279A1");
								out.writeBytes(newLine);
								out.writeBytes("ST*270*0001*005010X279A1");
								out.writeBytes(newLine);
								out.writeBytes("BHT*0022*13*204321322*20120210*1613");
								out.writeBytes(newLine);
								out.writeBytes("HL*1**20*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*PR*1*"+textFieldPayerEligibility.getText()+"*****46*953402799");
								out.writeBytes(newLine);
								out.writeBytes("HL*2*1*21*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*1P*1*"+textFieldProviderNameEligibility.getText()+"*****XX*"+textFieldProviderNPIEligibility.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*3*2*22*0");
								out.writeBytes(newLine);
								out.writeBytes("NM1*IL*1*"+textFieldEligibilitySearchOptionTwo.getText()+"*"+textFieldEligibilitySearchOptionOne.getText()+"****MI*"+textFieldEligibilitySearchOptionThree.getText());
								out.writeBytes(newLine);
								out.writeBytes("DTP*291*D8*"+startDatePicker.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("EQ*"+EligibilityComboBox.getValue().toString().substring(0, 2));
								out.writeBytes(newLine);
								out.writeBytes("SE*11*0001");
								out.writeBytes(newLine);
								out.writeBytes("GE*1*28494605");
								out.writeBytes(newLine);
								out.writeBytes("IEA*1*111199999");
								out.writeBytes(newLine);
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create FName_LName_MID.txt File");
							}
						}
						else if(EligibilitySearchComboBox.getValue().equalsIgnoreCase("Last Name, First Name & Patient DOB"))
						{
							try
							{	
								Files.deleteIfExists(Paths.get(pathm+"FName_LName_DOB.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"FName_LName_DOB.txt"));
								out.writeBytes("ISA*00*          *00*          *30*GATEWAYQES     *01*042064683      *120210*1613*^*00501*111199999*0*T*:");
								String newLine = System.getProperty("line.separator");
								out.writeBytes(newLine);
								out.writeBytes("GS*HS*GATEWAYQES*RTE_5010*20120210*1613*28494605*X*005010X279A1");
								out.writeBytes(newLine);
								out.writeBytes("ST*270*0001*005010X279A1");
								out.writeBytes(newLine);
								out.writeBytes("BHT*0022*13*204321322*20120210*1613");
								out.writeBytes(newLine);
								out.writeBytes("HL*1**20*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*PR*1*"+textFieldPayerEligibility.getText()+"*****46*953402799");
								out.writeBytes(newLine);
								out.writeBytes("HL*2*1*21*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*1P*1*"+textFieldProviderNameEligibility.getText()+"*****XX*"+textFieldProviderNPIEligibility.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*3*2*22*0");
								out.writeBytes(newLine);
								out.writeBytes("NM1*IL*1*"+textFieldEligibilitySearchOptionTwo.getText()+"*"+textFieldEligibilitySearchOptionOne.getText());
								out.writeBytes(newLine);
								out.writeBytes("DMG*D8*"+textFieldEligibilitySearchOptionFour.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("DTP*291*D8*"+startDatePicker.getValue().toString().replace("-", ""));
								out.writeBytes(newLine);
								out.writeBytes("EQ*"+EligibilityComboBox.getValue().toString().substring(0, 2));
								out.writeBytes(newLine);
								out.writeBytes("SE*12*0001");
								out.writeBytes(newLine);
								out.writeBytes("GE*1*28494605");
								out.writeBytes(newLine);
								out.writeBytes("IEA*1*111199999");
								out.writeBytes(newLine);
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create FName_LName_DOB.txt File");
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
		//HomeButton Eligibility Link Event Handler
		HomelinkEligibility.setOnAction(new EventHandler<ActionEvent>() 	{
			public void handle(ActionEvent event) 
			{
				primaryStage.setScene(sceneBase);

				textFieldPayerEligibility.setPromptText("Payer Name");
				textFieldProviderNPIEligibility.clear();
				textFieldProviderNPIEligibility.setPromptText("Provider NPI");
				startDatePicker.getEditor().clear();
				startDatePicker.setPromptText("MM/DD/YYYY");
				EligibilityComboBox.setValue("Select");
				EligibilitySearchComboBox.setValue("                                                                                                  Select");
				textFieldEligibilitySearchOptionOne.clear();
				textFieldEligibilitySearchOptionTwo.clear();
				textFieldEligibilitySearchOptionThree.clear();
				textFieldEligibilitySearchOptionFour.getEditor().clear();
				textFieldEligibilitySearchOptionFour.setPromptText("MM/DD/YYYY");
				textFieldPayerEligibility.clear();
			}
		});

		RTE.getChildren().addAll(rectEligibilityBorder,rectEligibilityTop,textEligibilityTop,rectEligibilityMid,textEligibilityMid,
				textEligibilityPayer,textFieldPayerEligibility,textEligibilityPayerstar,textEligibilityProviderNPI,
				textEligibilityProviderNPIstar,textFieldProviderNPIEligibility,textEligibilityProviderName,textFieldProviderNameEligibility,
				textEligibilityDOS,textEligibilityDOSstar,startDatePicker,textEligibilityBSTC,textEligibilityBSTCstar,EligibilityComboBox,
				textEligibilitySearchOption,textEligibilitySearchOptionstar,EligibilitySearchComboBox,textEligibilitySearchOptionOne,textEligibilitySearchOptionTwo,
				textEligibilitySearchOptionThree,textEligibilitySearchOptionFour,textFieldEligibilitySearchOptionOne,textFieldEligibilitySearchOptionTwo,
				textFieldEligibilitySearchOptionThree,textFieldEligibilitySearchOptionFour,validateDataEligibility,CreateEDIFileEligibility,ProcessEDIFileEligibility,HomelinkEligibility);
		RTE.setStyle("-fx-background-color:WHITE");

		return RTE;
	}

}
