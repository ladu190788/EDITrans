package EDI_Package;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Pair;



public class Tool extends Application 
{
	static String POScode = "11";
	static int dateofservicediffdays=0;
	static String path=null;
	static String pathm=null;
	static String pathenv=null;
	public static void main(String[] args) 
	{
		Application.launch(args);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception
	{
		class_ReferralAdd class_referraladd=new class_ReferralAdd();
		class_CSI class_csi=new class_CSI();
		class_Eligibility class_eligibility=new class_Eligibility();
		class_ReferralInquiry class_referralinquiry=new class_ReferralInquiry();
		class_CSR class_csr=new class_CSR();
		class_PreCertAdd class_precertadd=new class_PreCertAdd();
		class_FSR class_fsr=new class_FSR();


		Pane paneBase = new Pane();
		Pane RTE = new Pane();
		Pane ReferralEnquiry = new Pane();
		Pane CSR = new Pane();
		Pane CSI=new Pane();
		Pane ClaimOne=new Pane();
		Pane ClaimTwo=new Pane();
		Pane ClaimThree=new Pane();
		Pane PreAuthAdd=new Pane();
		Pane ReferralAdd = new Pane();
		Pane FSR= new Pane();

		final Scene sceneBase = 
				new Scene(paneBase, 1360, 690);
		final Scene sceneRTE = 
				new Scene(class_eligibility.EligibilityCode(RTE, primaryStage, sceneBase), 1360, 690);
		final Scene sceneReferralEnquiry = 
				new Scene(class_referralinquiry.ReferralInquiryCode(ReferralEnquiry, primaryStage, sceneBase), 1360, 690);
		final Scene sceneCSR = 
				new Scene(class_csr.CSRCode(CSR, primaryStage, sceneBase), 1360, 690);
		final Scene sceneCSI=
				new Scene(class_csi.CSICode(CSI, primaryStage, sceneBase),1360,690);

		final Scene sceneClaimOne=new Scene(ClaimOne, 1360, 690);
		final Scene sceneClaimTwo=new Scene(ClaimTwo, 1360, 690);
		final Scene sceneClaimThree=new Scene(ClaimThree, 1360, 690);

		final Scene scenePreAuthAdd=
				new Scene(class_precertadd.PreCertAddCode(PreAuthAdd, primaryStage, sceneBase), 1360, 690);
		final Scene sceneReferralAdd = 
				new Scene(class_referraladd.ReferralAddCode(ReferralAdd, primaryStage,sceneBase), 1360, 690);

		final Scene sceneFSR=
				new Scene(class_fsr.FSRCode(FSR, primaryStage, sceneBase),1360,690);



		//Image Baseimg=new Image(getClass().getResource("/Resource/Aetna_logo.png").toURI().toString());
		Image Baseimg=null;
		ImageView Baseiv=new ImageView(Baseimg);
		Baseiv.setFitHeight(170);
		Baseiv.setFitWidth(170);
		Baseiv.setPreserveRatio(true);
		Baseiv.setLayoutX(1080);
		Baseiv.setLayoutY(140);
		Image Baseimg1=new Image(getClass().getResource("/Resource/images.png").toURI().toString());
		ImageView Baseiv1=new ImageView(Baseimg1);
		Baseiv1.setFitHeight(150);
		Baseiv1.setFitWidth(150);
		Baseiv1.setPreserveRatio(true);
		Baseiv1.setLayoutX(600);
		Baseiv1.setLayoutY(570);
		Text textWelcome = new Text();
		textWelcome.setText("Welcome, ");
		textWelcome.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textWelcome.setFill(Color.BLACK);
		textWelcome.setLayoutX(1200);
		textWelcome.setLayoutY(22);
		//NID Text
		Text textNID = new Text();
		//textNID.setText(System.getProperty("user.name").toUpperCase());
		textNID.setText("Dhiren");
		textNID.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textNID.setFill(Color.STEELBLUE);
		textNID.setLayoutX(1285);
		textNID.setLayoutY(22);
		//Rectangle Workflow
		Rectangle rectWorkflow = new Rectangle();
		rectWorkflow.setX(0.0f);
		rectWorkflow.setY(35.0f);
		rectWorkflow.setWidth(1360.0f);
		rectWorkflow.setHeight(30.0f);
		rectWorkflow.setFill(Color.STEELBLUE);
		rectWorkflow.setStroke(Color.STEELBLUE);
		//Workflow Text in Rect
		Text textWorkflowRect = new Text();
		textWorkflowRect.setText("EDITrans Tool");
		textWorkflowRect.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 20));
		textWorkflowRect.setFill(Color.WHITE);
		textWorkflowRect.setLayoutX(625);
		textWorkflowRect.setLayoutY(55);
		//Rectangle Aetna Health Plan
		Rectangle rectAetnaH = new Rectangle();
		rectAetnaH.setX(0.0f);
		rectAetnaH.setY(65.0f);
		rectAetnaH.setWidth(1360.0f);
		rectAetnaH.setHeight(30.0f);
		rectAetnaH.setFill(Color.WHITESMOKE);
		//A Text in Aetna Health Plan
		Text textAetnaH = new Text();
		//textAetnaH.setText("Aetna Health Plan");
		textAetnaH.setText("Health Care Plans");
		textAetnaH.setFont(Font.font("Calibri", FontWeight.BOLD, 15));
		textAetnaH.setFill(Color.GREY);
		textAetnaH.setLayoutX(15);
		textAetnaH.setLayoutY(84);
		//Rectangle WorkFlows
		Rectangle rectWorkflowPlan = new Rectangle();
		rectWorkflowPlan.setX(30.0f);
		rectWorkflowPlan.setY(120.0f);
		rectWorkflowPlan.setWidth(225.0f);
		rectWorkflowPlan.setHeight(400.0f);
		rectWorkflowPlan.setFill(Color.LAVENDER);//SKYBLUE//POWDERBLUE
		Text textWorkflowforthisplan = new Text();
		textWorkflowforthisplan.setText("Workflows for this Plan");
		textWorkflowforthisplan.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 18));
		textWorkflowforthisplan.setFill(Color.BLACK);
		textWorkflowforthisplan.setLayoutX(37);
		textWorkflowforthisplan.setLayoutY(140);

		Text textWorkflowforthisplandown = new Text();
		textWorkflowforthisplandown.setText("HIPAA Standard Transactions");
		textWorkflowforthisplandown.setFont(Font.font("Helvetica", FontWeight.BOLD, 13));
		textWorkflowforthisplandown.setFill(Color.STEELBLUE);
		textWorkflowforthisplandown.setLayoutX(50);
		textWorkflowforthisplandown.setLayoutY(157);



		Text textWorkflowforthisplandownTwo = new Text();
		textWorkflowforthisplandownTwo.setText("Non-Standard Transactions");
		textWorkflowforthisplandownTwo.setFont(Font.font("Helvetica", FontWeight.BOLD, 13));
		textWorkflowforthisplandownTwo.setFill(Color.STEELBLUE);
		textWorkflowforthisplandownTwo.setLayoutX(50);
		textWorkflowforthisplandownTwo.setLayoutY(400);
		////////////////////////////////////////////
		Hyperlink BaselinkEligibility = new Hyperlink();
		BaselinkEligibility.setText("Eligibility                                        ");
		BaselinkEligibility.setStyle("-fx-text-fill: SLATEGREY;");
		BaselinkEligibility.setLayoutX(55);
		BaselinkEligibility.setLayoutY(160);
		BaselinkEligibility.setUnderline(false);
		BaselinkEligibility.setFocusTraversable(false);
		BaselinkEligibility.setFont(Font.font("Calibri", FontWeight.LIGHT, 14));
		Hyperlink BaselinkReferralAdd = new Hyperlink();
		BaselinkReferralAdd.setText("Referral Add                                               ");
		BaselinkReferralAdd.setStyle("-fx-text-fill: SLATEGREY;");
		BaselinkReferralAdd.setLayoutX(55);
		BaselinkReferralAdd.setLayoutY(180);
		BaselinkReferralAdd.setFocusTraversable(false);
		BaselinkReferralAdd.setUnderline(false);
		BaselinkReferralAdd.setFont(Font.font("Calibri", FontWeight.LIGHT, 14));
		Hyperlink BaselinkPreAuthAdd = new Hyperlink();
		BaselinkPreAuthAdd.setText("Pre-Cert Add                         ");
		BaselinkPreAuthAdd.setStyle("-fx-text-fill: SLATEGREY;");
		BaselinkPreAuthAdd.setLayoutX(55);
		BaselinkPreAuthAdd.setLayoutY(220);
		BaselinkPreAuthAdd.setUnderline(false);
		BaselinkPreAuthAdd.setFocusTraversable(false);
		BaselinkPreAuthAdd.setFont(Font.font("Calibri", FontWeight.LIGHT, 14));
		Hyperlink BaselinkPreAuthInq = new Hyperlink();
		BaselinkPreAuthInq.setText("Pre-Cert Inquiry                     ");
		BaselinkPreAuthInq.setStyle("-fx-text-fill: SLATEGREY;");
		BaselinkPreAuthInq.setLayoutX(55);
		BaselinkPreAuthInq.setLayoutY(240);
		BaselinkPreAuthInq.setUnderline(false);
		BaselinkPreAuthInq.setFocusTraversable(false);
		BaselinkPreAuthInq.setFont(Font.font("Calibri", FontWeight.LIGHT, 14));
		Hyperlink BaselinkNOA = new Hyperlink();
		BaselinkNOA.setText("NOA                                              ");
		BaselinkNOA.setStyle("-fx-text-fill: SLATEGREY;");
		BaselinkNOA.setLayoutX(55);
		BaselinkNOA.setLayoutY(260);
		BaselinkNOA.setUnderline(false);
		BaselinkNOA.setFocusTraversable(false);
		BaselinkNOA.setFont(Font.font("Calibri", FontWeight.LIGHT, 14));

		Hyperlink BaselinkReferrals = new Hyperlink();
		BaselinkReferrals.setText("Referral Inquiry                           ");
		BaselinkReferrals.setStyle("-fx-text-fill: SLATEGREY;");
		BaselinkReferrals.setLayoutX(55);
		BaselinkReferrals.setLayoutY(200);
		BaselinkReferrals.setUnderline(false);
		BaselinkReferrals.setFocusTraversable(false);
		BaselinkReferrals.setFont(Font.font("Calibri", FontWeight.LIGHT, 14));
		Hyperlink BaselinkClaims = new Hyperlink();
		BaselinkClaims.setText("Claims - Professional                 ");
		BaselinkClaims.setStyle("-fx-text-fill: SLATEGREY");
		BaselinkClaims.setUnderline(false);
		BaselinkClaims.setLayoutX(55);
		BaselinkClaims.setLayoutY(280);
		BaselinkClaims.setFocusTraversable(false);
		BaselinkClaims.setFont(Font.font("Calibri", FontWeight.LIGHT, 14));
		Hyperlink BaselinkCSI = new Hyperlink();
		BaselinkCSI.setText("Claim Status Inquiry                     ");
		BaselinkCSI.setStyle("-fx-text-fill: SLATEGREY;");
		BaselinkCSI.setLayoutX(55);
		BaselinkCSI.setLayoutY(300);
		BaselinkCSI.setFocusTraversable(false);
		BaselinkCSI.setUnderline(false);
		BaselinkCSI.setFont(Font.font("Calibri", FontWeight.LIGHT, 14));
		Hyperlink BaselinkCSR = new Hyperlink();
		BaselinkCSR.setText("Claim Status Report                      ");
		BaselinkCSR.setStyle("-fx-text-fill: SLATEGREY;");
		BaselinkCSR.setLayoutX(55);
		BaselinkCSR.setLayoutY(320);
		BaselinkCSR.setFocusTraversable(false);
		BaselinkCSR.setUnderline(false);
		BaselinkCSR.setFont(Font.font("Calibri", FontWeight.LIGHT, 14));
		Hyperlink BaselinkFSR = new Hyperlink();
		BaselinkFSR.setText("FSR                                                      ");
		BaselinkFSR.setStyle("-fx-text-fill: SLATEGREY;");
		BaselinkFSR.setLayoutX(55);
		BaselinkFSR.setLayoutY(340);
		BaselinkFSR.setFocusTraversable(false);
		BaselinkFSR.setUnderline(false);
		BaselinkFSR.setFont(Font.font("Calibri", FontWeight.LIGHT, 14));

		///////////////////////
		Hyperlink SharedAcc = new Hyperlink();
		SharedAcc.setText("Shared Accumulator                           ");
		SharedAcc.setStyle("-fx-text-fill: SLATEGREY;");
		SharedAcc.setLayoutX(55);
		SharedAcc.setLayoutY(403);
		SharedAcc.setUnderline(false);
		SharedAcc.setFocusTraversable(false);
		SharedAcc.setFont(Font.font("Calibri", FontWeight.LIGHT, 14));

		Hyperlink NCPDP = new Hyperlink();
		NCPDP.setText("NCPDP                                  ");
		NCPDP.setStyle("-fx-text-fill: SLATEGREY;");
		NCPDP.setLayoutX(55);
		NCPDP.setLayoutY(423);
		NCPDP.setUnderline(false);
		NCPDP.setFocusTraversable(false);
		NCPDP.setFont(Font.font("Calibri", FontWeight.LIGHT, 14));

		Hyperlink E2EClaimTrans = new Hyperlink();
		E2EClaimTrans.setText("E2E Claim Transaction                    ");
		E2EClaimTrans.setStyle("-fx-text-fill: SLATEGREY;");
		E2EClaimTrans.setLayoutX(55);
		E2EClaimTrans.setLayoutY(443);
		E2EClaimTrans.setUnderline(false);
		E2EClaimTrans.setFocusTraversable(false);
		E2EClaimTrans.setFont(Font.font("Calibri", FontWeight.LIGHT, 14));


		///////////////Claims Onepage

		Rectangle rectClaimOneTop = new Rectangle();
		rectClaimOneTop.setX(0.0f);
		rectClaimOneTop.setY(0.0f);
		rectClaimOneTop.setWidth(1360.0f);
		rectClaimOneTop.setHeight(60.0f);
		rectClaimOneTop.setFill(Color.STEELBLUE);
		rectClaimOneTop.setStroke(Color.STEELBLUE);
		Rectangle rectClaimOneMenu = new Rectangle();
		rectClaimOneMenu.setX(0.0f);
		rectClaimOneMenu.setY(60.0f);
		rectClaimOneMenu.setWidth(1356.0f);
		rectClaimOneMenu.setHeight(28.0f);
		rectClaimOneMenu.setFill(Color.DARKTURQUOISE);//DARKSALMON//WHITESMOKE
		rectClaimOneMenu.setStroke(Color.DARKSALMON);
		//Boundary
		Rectangle rectClaimOneBorder = new Rectangle();
		rectClaimOneBorder.setX(1.5f);
		rectClaimOneBorder.setY(0.0f);
		rectClaimOneBorder.setWidth(1356.0f);
		rectClaimOneBorder.setHeight(682.0f);
		rectClaimOneBorder.setFill(Color.WHITE);
		rectClaimOneBorder.setStroke(Color.STEELBLUE);

		//Validate Data ReferralInq Button
		Button ClaimOneMenuTopOne = new Button();
		ClaimOneMenuTopOne.setText("Patient Details");
		ClaimOneMenuTopOne.setLayoutX(400);
		ClaimOneMenuTopOne.setLayoutY(60);
		ClaimOneMenuTopOne.setMinWidth(150);
		ClaimOneMenuTopOne.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		ClaimOneMenuTopOne.setTextFill(Color.STEELBLUE);
		ClaimOneMenuTopOne.setStyle("-fx-background-color:DARKSALMON");
		ClaimOneMenuTopOne.setTextFill(Color.BLACK);

		//Validate Data ReferralInq Button
		Button ClaimOneMenuTopTwo = new Button();
		ClaimOneMenuTopTwo.setText("Provider Details");
		ClaimOneMenuTopTwo.setLayoutX(600);
		ClaimOneMenuTopTwo.setLayoutY(60);
		ClaimOneMenuTopTwo.setMinWidth(150);
		ClaimOneMenuTopTwo.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		ClaimOneMenuTopTwo.setTextFill(Color.STEELBLUE);
		ClaimOneMenuTopTwo.setStyle("-fx-background-color:DARKGREY");
		ClaimOneMenuTopTwo.setTextFill(Color.WHITE);
		//Process Data ReferralInq Button
		Button ClaimOneMenuTopThree = new Button();
		ClaimOneMenuTopThree.setText("Claim Details");
		ClaimOneMenuTopThree.setLayoutX(800);
		ClaimOneMenuTopThree.setLayoutY(60);
		ClaimOneMenuTopThree.setMinWidth(150);
		ClaimOneMenuTopThree.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		ClaimOneMenuTopThree.setStyle("-fx-background-color:DARKGREY");
		ClaimOneMenuTopThree.setTextFill(Color.WHITE);
		//Top Text CSI
		Text textClaimOneTop = new Text();
		textClaimOneTop.setText("Health Insurance Claim Form");
		textClaimOneTop.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 24));
		textClaimOneTop.setFill(Color.WHITE);
		textClaimOneTop.setLayoutX(532);
		textClaimOneTop.setLayoutY(40);
		//HomeLink CSI
		Hyperlink HomelinkClaimOne = new Hyperlink();
		HomelinkClaimOne.setText("Home");
		HomelinkClaimOne.setStyle("-fx-text-fill: YELLOW;");
		HomelinkClaimOne.setLayoutX(1300);
		HomelinkClaimOne.setLayoutY(2);
		HomelinkClaimOne.setUnderline(false);
		HomelinkClaimOne.setFocusTraversable(false);
		HomelinkClaimOne.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 14));

		//Text Member InsuranceProgram ClaimOne
		Text textClaimOneSelectInsProgram = new Text();
		textClaimOneSelectInsProgram.setText("Insurance Program");
		textClaimOneSelectInsProgram.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneSelectInsProgram.setFill(Color.BLACK);
		textClaimOneSelectInsProgram.setLayoutX(100);
		textClaimOneSelectInsProgram.setLayoutY(117);
		//Combobox InsProg Claim One
		ComboBox<String> ClaimOneInsProgCombo = new ComboBox<String>();
		ClaimOneInsProgCombo.getItems().addAll("Medicare (Medicare #)","Medicaid (Medicaid #)","Commercial(Other)","Tricare","ChampVA (Member ID#)","FECA (ID)","Blue Cross-Blue Shield","Health Maintenance Organization (HMO) Medicare Risk","Federal Employees Program","Other Non-Federal Programs","Preferred Provider Organization (PPO)","Point of Service (POS)","Exclusive Provider Organization (EPO)","Indemnity Insurance","Dental Maintenance Organization","Automobile Medical","Disability","Health Maintenance Organization","Liability Medical","Medicare Part A","Title V","Workers' Compensation Health Claim","Mutually Defined");
		ClaimOneInsProgCombo.setEditable(false); 
		ClaimOneInsProgCombo.setMinWidth(200);
		ClaimOneInsProgCombo.setMaxWidth(200);
		ClaimOneInsProgCombo.setMinHeight(25);
		ClaimOneInsProgCombo.setLayoutX(225);
		ClaimOneInsProgCombo.setLayoutY(100);
		ClaimOneInsProgCombo.setTooltip(new Tooltip("Select Insurance Program"));
		ClaimOneInsProgCombo.setValue("Commercial(Other)");
		ClaimOneInsProgCombo.getSelectionModel().select(2);
		ClaimOneInsProgCombo.setStyle("-fx-font: 14px \"Calibri\";");

		//Text InsuredID Number ClaimOne
		Text textClaimOneInsuredIdNumber = new Text();
		textClaimOneInsuredIdNumber.setText("Insured's ID Number");
		textClaimOneInsuredIdNumber.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredIdNumber.setFill(Color.BLACK);
		textClaimOneInsuredIdNumber.setLayoutX(500);
		textClaimOneInsuredIdNumber.setLayoutY(117);

		TextField textFieldClaimOneInsuredIdNumber = new TextField();
		textFieldClaimOneInsuredIdNumber.setLayoutX(625);
		textFieldClaimOneInsuredIdNumber.setLayoutY(100);
		textFieldClaimOneInsuredIdNumber.setPrefWidth(200);
		textFieldClaimOneInsuredIdNumber.setPrefHeight(25);
		textFieldClaimOneInsuredIdNumber.setEditable(true);
		textFieldClaimOneInsuredIdNumber.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneInsuredIdNumber.setTooltip(new Tooltip("Enter Insured's ID Number"));
		textFieldClaimOneInsuredIdNumber.setPromptText("Insured's ID Number");

		Text textClaimOneInsuredIdNumberestar= new Text();
		textClaimOneInsuredIdNumberestar.setText("*");
		textClaimOneInsuredIdNumberestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredIdNumberestar.setFill(Color.RED);
		textClaimOneInsuredIdNumberestar.setLayoutX(830);
		textClaimOneInsuredIdNumberestar.setLayoutY(111);
		textClaimOneInsuredIdNumberestar.setVisible(true);

		textFieldClaimOneInsuredIdNumber.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaimOneInsuredIdNumber.getText().isEmpty()==false)
				textClaimOneInsuredIdNumberestar.setVisible(false);
			else
				textClaimOneInsuredIdNumberestar.setVisible(true);});

		textFieldClaimOneInsuredIdNumber.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOneInsuredIdNumber.getText().length() >= 10) {
						textFieldClaimOneInsuredIdNumber.setText(textFieldClaimOneInsuredIdNumber.getText().substring(0, 10));
					}
				}
			}
		});

		Line line1 = new Line(); 
		line1.setStartX(100); 
		line1.setStartY(135); 
		line1.setEndX(1225); 
		line1.setEndY(135);
		//Text Patient Name ClaimOne
		Text textClaimOnePatientName = new Text();
		textClaimOnePatientName.setText("Patient's Name");
		textClaimOnePatientName.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientName.setFill(Color.BLACK);
		textClaimOnePatientName.setLayoutX(100);
		textClaimOnePatientName.setLayoutY(162);
		//* mark
		Text textClaimOnePatientNamestar= new Text();
		textClaimOnePatientNamestar.setText("*");
		textClaimOnePatientNamestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientNamestar.setFill(Color.RED);
		textClaimOnePatientNamestar.setLayoutX(830);
		textClaimOnePatientNamestar.setLayoutY(157);

		TextField textFieldClaimOnePatientFName = new TextField();
		textFieldClaimOnePatientFName.setLayoutX(225);
		textFieldClaimOnePatientFName.setLayoutY(145);
		textFieldClaimOnePatientFName.setPrefWidth(200);
		textFieldClaimOnePatientFName.setPrefHeight(25);
		textFieldClaimOnePatientFName.setEditable(true);
		textFieldClaimOnePatientFName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOnePatientFName.setTooltip(new Tooltip("Enter First Name"));
		textFieldClaimOnePatientFName.setPromptText("First Name");

		TextField textFieldClaimOnePatientMName = new TextField();
		textFieldClaimOnePatientMName.setLayoutX(500);
		textFieldClaimOnePatientMName.setLayoutY(145);
		textFieldClaimOnePatientMName.setPrefWidth(50);
		textFieldClaimOnePatientMName.setPrefHeight(25);
		textFieldClaimOnePatientMName.setEditable(true);
		textFieldClaimOnePatientMName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOnePatientMName.setTooltip(new Tooltip("Enter Middle Initial"));
		textFieldClaimOnePatientMName.setPromptText("M.I.");
		textFieldClaimOnePatientFName.setPromptText("First Name");

		TextField textFieldClaimOnePatientLName = new TextField();
		textFieldClaimOnePatientLName.setLayoutX(625);
		textFieldClaimOnePatientLName.setLayoutY(145);
		textFieldClaimOnePatientLName.setPrefWidth(200);
		textFieldClaimOnePatientLName.setPrefHeight(25);
		textFieldClaimOnePatientLName.setEditable(true);
		textFieldClaimOnePatientLName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOnePatientLName.setTooltip(new Tooltip("Enter Last Name"));
		textFieldClaimOnePatientLName.setPromptText("Last Name");

		textFieldClaimOnePatientLName.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaimOnePatientLName.getText().isEmpty()==false)
				textClaimOnePatientNamestar.setVisible(false);
			else
				textClaimOnePatientNamestar.setVisible(true);});
		textFieldClaimOnePatientFName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOnePatientFName.getText().length() >= 12) {
						textFieldClaimOnePatientFName.setText(textFieldClaimOnePatientFName.getText().substring(0, 12));
					}
				}
			}
		});
		textFieldClaimOnePatientLName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {if (textFieldClaimOnePatientLName.getText().length() >= 20) {
					textFieldClaimOnePatientLName.setText(textFieldClaimOnePatientLName.getText().substring(0, 20));
				}
				}
			}
		});

		textFieldClaimOnePatientMName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOnePatientMName.getText().length() >= 1) {
						textFieldClaimOnePatientMName.setText(textFieldClaimOnePatientMName.getText().substring(0, 1));
					}
				}
			}
		});
		//Text Patient Name ClaimOne
		Text textClaimOnePatientDOB = new Text();
		textClaimOnePatientDOB.setText("Patient Birth Date");
		textClaimOnePatientDOB.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientDOB.setFill(Color.BLACK);
		textClaimOnePatientDOB.setLayoutX(900);
		textClaimOnePatientDOB.setLayoutY(162);
		//* mark
		Text textClaimOnePatientDOBstar= new Text();
		textClaimOnePatientDOBstar.setText("*");
		textClaimOnePatientDOBstar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientDOBstar.setFill(Color.RED);
		textClaimOnePatientDOBstar.setLayoutX(1230);
		textClaimOnePatientDOBstar.setLayoutY(157);

		//Date Picker
		DatePicker ClaimOnePatientDOB = new DatePicker();
		ClaimOnePatientDOB.setLayoutX(1025);
		ClaimOnePatientDOB.setLayoutY(145);
		ClaimOnePatientDOB.setPrefWidth(200);
		ClaimOnePatientDOB.setPrefHeight(25);
		ClaimOnePatientDOB.setPromptText("MM/DD/YYYY");
		ClaimOnePatientDOB.setTooltip(new Tooltip("Enter Patient Birth Date"));
		ClaimOnePatientDOB.setEditable(false);
		ClaimOnePatientDOB.setStyle("-fx-font: 14px \"Calibri\";");

		ClaimOnePatientDOB.setOnAction(e ->
		{
			LocalDate date = ClaimOnePatientDOB.getValue();
		});

		ClaimOnePatientDOB.valueProperty().addListener((observable, oldValue, newValue) -> {
			if(ClaimOnePatientDOB.getValue().toString().isEmpty()==false)
				textClaimOnePatientDOBstar.setVisible(false);
			else
				textClaimOnePatientDOBstar.setVisible(true);});

		//Text Patient Sex ClaimOne
		Text textClaimOnePatientSEX = new Text();
		textClaimOnePatientSEX.setText("Gender");
		textClaimOnePatientSEX.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientSEX.setFill(Color.BLACK);
		textClaimOnePatientSEX.setLayoutX(900);
		textClaimOnePatientSEX.setLayoutY(207);
		//Combobox Patient Gender Claim One
		ComboBox<String> ClaimOnepatientGenderCombo = new ComboBox<String>();
		ClaimOnepatientGenderCombo.getItems().addAll("Undifferentiated","Male","Female");
		ClaimOnepatientGenderCombo.setEditable(false); 
		ClaimOnepatientGenderCombo.setMinWidth(200);
		ClaimOnepatientGenderCombo.setMaxWidth(200);
		ClaimOnepatientGenderCombo.setMinHeight(25);
		ClaimOnepatientGenderCombo.setLayoutX(1025);
		ClaimOnepatientGenderCombo.setLayoutY(185);
		ClaimOnepatientGenderCombo.setTooltip(new Tooltip("Select Gender"));
		ClaimOnepatientGenderCombo.getSelectionModel().select(0);
		ClaimOnepatientGenderCombo.setStyle("-fx-font: 14px \"Calibri\";");

		//Text Patient Zip ClaimOne
		Text textClaimOnePatientPhnNo = new Text();
		textClaimOnePatientPhnNo.setText("Phone Number");
		textClaimOnePatientPhnNo.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientPhnNo.setFill(Color.BLACK);
		textClaimOnePatientPhnNo.setLayoutX(900);
		textClaimOnePatientPhnNo.setLayoutY(233);
		TextField textFieldClaimOnePatientPhnNo = new TextField();
		textFieldClaimOnePatientPhnNo.setLayoutX(1025);
		textFieldClaimOnePatientPhnNo.setLayoutY(215);
		textFieldClaimOnePatientPhnNo.setPrefWidth(200);
		textFieldClaimOnePatientPhnNo.setPrefHeight(25);
		textFieldClaimOnePatientPhnNo.setEditable(true);
		textFieldClaimOnePatientPhnNo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOnePatientPhnNo.setTooltip(new Tooltip("Enter Telephone(Include Area Code) : XXXXXXXXXX"));
		textFieldClaimOnePatientPhnNo.setPromptText("Telephone");

		textFieldClaimOnePatientPhnNo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldClaimOnePatientPhnNo.getText().length()<=12) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldClaimOnePatientPhnNo.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});
		//Text Patient Name ClaimOne
		Text textClaimOnePatientAddress = new Text();
		textClaimOnePatientAddress.setText("Patient's Address");
		textClaimOnePatientAddress.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientAddress.setFill(Color.BLACK);
		textClaimOnePatientAddress.setLayoutX(100);
		textClaimOnePatientAddress.setLayoutY(217);
		TextField textFieldClaimOnePatientAddressOne = new TextField();
		textFieldClaimOnePatientAddressOne.setLayoutX(225);
		textFieldClaimOnePatientAddressOne.setLayoutY(185);
		textFieldClaimOnePatientAddressOne.setPrefWidth(200);
		textFieldClaimOnePatientAddressOne.setPrefHeight(25);
		textFieldClaimOnePatientAddressOne.setEditable(true);
		textFieldClaimOnePatientAddressOne.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOnePatientAddressOne.setTooltip(new Tooltip("Enter Address Line 1"));
		textFieldClaimOnePatientAddressOne.setPromptText("Address Line 1");
		textFieldClaimOnePatientAddressOne.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOnePatientAddressOne.getText().length() >= 30) {
						textFieldClaimOnePatientAddressOne.setText(textFieldClaimOnePatientAddressOne.getText().substring(0, 30));
					}
				}
			}
		});

		Text textClaimOnePatientAddressOnestar= new Text();
		textClaimOnePatientAddressOnestar.setText("*");
		textClaimOnePatientAddressOnestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientAddressOnestar.setFill(Color.RED);
		textClaimOnePatientAddressOnestar.setLayoutX(430);
		textClaimOnePatientAddressOnestar.setLayoutY(195);

		textFieldClaimOnePatientAddressOne.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaimOnePatientAddressOne.getText().isEmpty()==false)
				textClaimOnePatientAddressOnestar.setVisible(false);
			else
				textClaimOnePatientAddressOnestar.setVisible(true);});

		TextField textFieldClaimOnePatientAddressTwo = new TextField();
		textFieldClaimOnePatientAddressTwo.setLayoutX(225);
		textFieldClaimOnePatientAddressTwo.setLayoutY(215);
		textFieldClaimOnePatientAddressTwo.setPrefWidth(200);
		textFieldClaimOnePatientAddressTwo.setPrefHeight(25);
		textFieldClaimOnePatientAddressTwo.setEditable(true);
		textFieldClaimOnePatientAddressTwo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOnePatientAddressTwo.setTooltip(new Tooltip("Enter Address Line 2"));
		textFieldClaimOnePatientAddressTwo.setPromptText("Address Line 2");

		textFieldClaimOnePatientAddressTwo.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOnePatientAddressTwo.getText().length() >= 30) {
						textFieldClaimOnePatientAddressTwo.setText(textFieldClaimOnePatientAddressTwo.getText().substring(0, 30));
					}
				}
			}
		});
		//Text City ClaimOne
		Text textClaimOnePatientCity = new Text();
		textClaimOnePatientCity.setText("City");
		textClaimOnePatientCity.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientCity.setFill(Color.BLACK);
		textClaimOnePatientCity.setLayoutX(500);
		textClaimOnePatientCity.setLayoutY(205);
		TextField textFieldClaimOnePatientCity = new TextField();
		textFieldClaimOnePatientCity.setLayoutX(625);
		textFieldClaimOnePatientCity.setLayoutY(185);
		textFieldClaimOnePatientCity.setPrefWidth(200);
		textFieldClaimOnePatientCity.setPrefHeight(25);
		textFieldClaimOnePatientCity.setEditable(true);
		textFieldClaimOnePatientCity.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOnePatientCity.setTooltip(new Tooltip("Enter City"));
		textFieldClaimOnePatientCity.setPromptText("City");

		Text textClaimOnePatientCitystar= new Text();
		textClaimOnePatientCitystar.setText("*");
		textClaimOnePatientCitystar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientCitystar.setFill(Color.RED);
		textClaimOnePatientCitystar.setLayoutX(830);
		textClaimOnePatientCitystar.setLayoutY(195);

		textFieldClaimOnePatientCity.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaimOnePatientCity.getText().isEmpty()==false)
				textClaimOnePatientCitystar.setVisible(false);
			else
				textClaimOnePatientCitystar.setVisible(true);});
		textFieldClaimOnePatientCity.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOnePatientCity.getText().length() >= 20) {
						textFieldClaimOnePatientCity.setText(textFieldClaimOnePatientCity.getText().substring(0, 20));
					}
				}
			}
		});
		//Text State ClaimOne
		Text textClaimOnePatientState = new Text();
		textClaimOnePatientState.setText("State / Zip");
		textClaimOnePatientState.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientState.setFill(Color.BLACK);
		textClaimOnePatientState.setLayoutX(500);
		textClaimOnePatientState.setLayoutY(233);
		//Combobox Patient State Claim One
		ComboBox<String> ClaimOnepatientStateCombo = new ComboBox<String>();
		ClaimOnepatientStateCombo.getItems().addAll("AA","AE","AL","AK","AP","AR","AS","AZ","CA","CO","CT","DE","DC","FL","FM","GA","GU","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MH","MI","MN","MS","MO","MP","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WV","WI","WY");
		ClaimOnepatientStateCombo.setEditable(false); 
		ClaimOnepatientStateCombo.setMinWidth(95);
		ClaimOnepatientStateCombo.setMinWidth(95);
		ClaimOnepatientStateCombo.setMinHeight(25);
		ClaimOnepatientStateCombo.setLayoutX(625);
		ClaimOnepatientStateCombo.setLayoutY(215);
		ClaimOnepatientStateCombo.setTooltip(new Tooltip("Select State"));
		ClaimOnepatientStateCombo.setValue("Select");;
		ClaimOnepatientStateCombo.setStyle("-fx-font: 14px \"Calibri\";");

		Text textClaimOnePatientStatestar= new Text();
		textClaimOnePatientStatestar.setText("*");
		textClaimOnePatientStatestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientStatestar.setFill(Color.RED);
		textClaimOnePatientStatestar.setLayoutX(722);
		textClaimOnePatientStatestar.setLayoutY(225);

		ClaimOnepatientStateCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
			if(ClaimOnepatientStateCombo.getSelectionModel().getSelectedIndex()==-1)
				textClaimOnePatientStatestar.setVisible(true);
			else
				textClaimOnePatientStatestar.setVisible(false);});

		TextField textFieldClaimOnePatientZip = new TextField();
		textFieldClaimOnePatientZip.setLayoutX(730);
		textFieldClaimOnePatientZip.setLayoutY(215);
		textFieldClaimOnePatientZip.setPrefWidth(95);
		textFieldClaimOnePatientZip.setPrefHeight(25);
		textFieldClaimOnePatientZip.setMaxWidth(95);
		textFieldClaimOnePatientZip.setEditable(true);
		textFieldClaimOnePatientZip.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOnePatientZip.setTooltip(new Tooltip("Enter Zip Code"));
		textFieldClaimOnePatientZip.setPromptText("Zip Code");

		Text textClaimOnePatientZipstar= new Text();
		textClaimOnePatientZipstar.setText("*");
		textClaimOnePatientZipstar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientZipstar.setFill(Color.RED);
		textClaimOnePatientZipstar.setLayoutX(830);
		textClaimOnePatientZipstar.setLayoutY(225);

		textFieldClaimOnePatientZip.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaimOnePatientZip.getText().isEmpty()==false)
				textClaimOnePatientZipstar.setVisible(false);
			else
				textClaimOnePatientZipstar.setVisible(true);});

		textFieldClaimOnePatientZip.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldClaimOnePatientZip.getText().length()<=9) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldClaimOnePatientZip.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});

		//Text Patient Name ClaimOne
		Text textClaimOneRelationWithInsured = new Text();
		textClaimOneRelationWithInsured.setText("Patient's Relation"+'\n'+ "with Insured");
		textClaimOneRelationWithInsured.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneRelationWithInsured.setFill(Color.BLACK);
		textClaimOneRelationWithInsured.setLayoutX(100);
		textClaimOneRelationWithInsured.setLayoutY(264);

		//Combobox Patient State Claim One
		ComboBox<String> ClaimOneRelationWithInsuredCombo = new ComboBox<String>();
		ClaimOneRelationWithInsuredCombo.getItems().addAll("Self","Spouse","Child");//,"Other");
		ClaimOneRelationWithInsuredCombo.setEditable(false); 
		ClaimOneRelationWithInsuredCombo.setMinWidth(200);
		ClaimOneRelationWithInsuredCombo.setMinHeight(25);
		ClaimOneRelationWithInsuredCombo.setLayoutX(225);
		ClaimOneRelationWithInsuredCombo.setLayoutY(255);
		ClaimOneRelationWithInsuredCombo.setTooltip(new Tooltip("Select Relationship"));
		ClaimOneRelationWithInsuredCombo.getSelectionModel().select(0);
		ClaimOneRelationWithInsuredCombo.setStyle("-fx-font: 14px \"Calibri\";");

		Text textClaimOneInsuredPolicyGroupFECA = new Text();
		textClaimOneInsuredPolicyGroupFECA.setText("Policy Number");
		textClaimOneInsuredPolicyGroupFECA.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredPolicyGroupFECA.setFill(Color.BLACK);
		textClaimOneInsuredPolicyGroupFECA.setLayoutX(500);
		textClaimOneInsuredPolicyGroupFECA.setLayoutY(274);

		TextField textFieldClaimOneInsuredPolicyGroupFECA = new TextField();
		textFieldClaimOneInsuredPolicyGroupFECA.setLayoutX(625);
		textFieldClaimOneInsuredPolicyGroupFECA.setLayoutY(255);
		textFieldClaimOneInsuredPolicyGroupFECA.setPrefWidth(200);
		textFieldClaimOneInsuredPolicyGroupFECA.setPrefHeight(25);
		textFieldClaimOneInsuredPolicyGroupFECA.setEditable(true);
		textFieldClaimOneInsuredPolicyGroupFECA.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneInsuredPolicyGroupFECA.setTooltip(new Tooltip("Enter Insured's Policy Number"));
		textFieldClaimOneInsuredPolicyGroupFECA.setPromptText("Insured's Policy Number");

		textFieldClaimOneInsuredPolicyGroupFECA.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOneInsuredPolicyGroupFECA.getText().length() >= 10) {
						textFieldClaimOneInsuredPolicyGroupFECA.setText(textFieldClaimOneInsuredPolicyGroupFECA.getText().substring(0, 10));
					}
				}
			}
		});

		Line line = new Line(); 
		line.setStartX(100); 
		line.setStartY(300); 
		line.setEndX(1225); 
		line.setEndY(300);

		//Text Patient Name ClaimOne
		Text textClaimOneInsuredName = new Text();
		textClaimOneInsuredName.setText("Insured's Name");
		textClaimOneInsuredName.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredName.setFill(Color.BLACK);
		textClaimOneInsuredName.setLayoutX(100);
		textClaimOneInsuredName.setLayoutY(335);

		TextField textFieldClaimOneInsuredFName = new TextField();
		textFieldClaimOneInsuredFName.setLayoutX(225);
		textFieldClaimOneInsuredFName.setLayoutY(317);
		textFieldClaimOneInsuredFName.setPrefWidth(200);
		textFieldClaimOneInsuredFName.setPrefHeight(25);
		textFieldClaimOneInsuredFName.setEditable(true);
		textFieldClaimOneInsuredFName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneInsuredFName.setTooltip(new Tooltip("Enter First Name"));
		textFieldClaimOneInsuredFName.setPromptText("First Name");
		textFieldClaimOneInsuredFName.setDisable(true);

		TextField textFieldClaimOneInsuredMName = new TextField();
		textFieldClaimOneInsuredMName.setLayoutX(500);
		textFieldClaimOneInsuredMName.setLayoutY(317);
		textFieldClaimOneInsuredMName.setPrefWidth(50);
		textFieldClaimOneInsuredMName.setPrefHeight(25);
		textFieldClaimOneInsuredMName.setEditable(true);
		textFieldClaimOneInsuredMName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneInsuredMName.setTooltip(new Tooltip("Enter Middle Initial"));
		textFieldClaimOneInsuredMName.setPromptText("M.I.");
		textFieldClaimOneInsuredMName.setDisable(true);

		TextField textFieldClaimOneInsuredLName = new TextField();
		textFieldClaimOneInsuredLName.setLayoutX(625);
		textFieldClaimOneInsuredLName.setLayoutY(317);
		textFieldClaimOneInsuredLName.setPrefWidth(200);
		textFieldClaimOneInsuredLName.setPrefHeight(25);
		textFieldClaimOneInsuredLName.setEditable(true);
		textFieldClaimOneInsuredLName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneInsuredLName.setTooltip(new Tooltip("Enter Last Name"));
		textFieldClaimOneInsuredLName.setPromptText("Last Name");
		textFieldClaimOneInsuredLName.setDisable(true);

		Text textClaimOneInsuredLNamestar= new Text();
		textClaimOneInsuredLNamestar.setText("*");
		textClaimOneInsuredLNamestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredLNamestar.setFill(Color.RED);
		textClaimOneInsuredLNamestar.setLayoutX(830);
		textClaimOneInsuredLNamestar.setLayoutY(327);
		textClaimOneInsuredLNamestar.setVisible(false);

		textFieldClaimOneInsuredLName.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaimOneInsuredLName.getText().isEmpty()==false)
				textClaimOneInsuredLNamestar.setVisible(false);
			else
				textClaimOneInsuredLNamestar.setVisible(true);
		});

		textFieldClaimOneInsuredFName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOneInsuredFName.getText().length() >= 12) {
						textFieldClaimOneInsuredFName.setText(textFieldClaimOneInsuredFName.getText().substring(0, 12));
					}
				}
			}
		});
		textFieldClaimOneInsuredLName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOneInsuredLName.getText().length() >= 20) {
						textFieldClaimOneInsuredLName.setText(textFieldClaimOneInsuredLName.getText().substring(0, 20));
					}
				}
			}
		});

		textFieldClaimOneInsuredMName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOneInsuredMName.getText().length() >= 1) {
						textFieldClaimOneInsuredMName.setText(textFieldClaimOneInsuredMName.getText().substring(0, 1));
					}
				}
			}
		});

		//Text Patient Name ClaimOne
		Text textClaimOneInsuredDOB = new Text();
		textClaimOneInsuredDOB.setText("Insured Birth Date");
		textClaimOneInsuredDOB.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredDOB.setFill(Color.BLACK);
		textClaimOneInsuredDOB.setLayoutX(900);
		textClaimOneInsuredDOB.setLayoutY(335);

		//Date Picker
		DatePicker ClaimOneInsuredDOB = new DatePicker();
		ClaimOneInsuredDOB.setLayoutX(1025);
		ClaimOneInsuredDOB.setLayoutY(317);
		ClaimOneInsuredDOB.setPrefWidth(200);
		ClaimOneInsuredDOB.setPrefHeight(25);
		ClaimOneInsuredDOB.setPromptText("MM/DD/YYYY");
		ClaimOneInsuredDOB.setTooltip(new Tooltip("Enter Insured Birth Date"));
		ClaimOneInsuredDOB.setEditable(false);
		ClaimOneInsuredDOB.setStyle("-fx-font: 14px \"Calibri\";");
		ClaimOneInsuredDOB.setDisable(true);

		ClaimOneInsuredDOB.setOnAction(e ->
		{
			LocalDate date = ClaimOneInsuredDOB.getValue();
		});

		Text textClaimOneInsuredDOBstar= new Text();
		textClaimOneInsuredDOBstar.setText("*");
		textClaimOneInsuredDOBstar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredDOBstar.setFill(Color.RED);
		textClaimOneInsuredDOBstar.setLayoutX(1230);
		textClaimOneInsuredDOBstar.setLayoutY(327);
		textClaimOneInsuredDOBstar.setVisible(false);

		ClaimOneInsuredDOB.valueProperty().addListener((observable, oldValue, newValue) -> {
			try
			{
				if(ClaimOneInsuredDOB.getValue().toString().isEmpty()==false)
					textClaimOneInsuredDOBstar.setVisible(false);
				else
					textClaimOneInsuredDOBstar.setVisible(true);
			}
			catch(Exception e){}
		});

		//Text Patient Sex ClaimOne
		Text textClaimOneInsuredSEX = new Text();
		textClaimOneInsuredSEX.setText("Gender");
		textClaimOneInsuredSEX.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredSEX.setFill(Color.BLACK);
		textClaimOneInsuredSEX.setLayoutX(900);
		textClaimOneInsuredSEX.setLayoutY(378);
		//Combobox Patient Gender Claim One
		ComboBox<String> ClaimOneInsuredGenderCombo = new ComboBox<String>();
		ClaimOneInsuredGenderCombo.getItems().addAll("Undifferentiated","Male","Female");
		ClaimOneInsuredGenderCombo.setEditable(false); 
		ClaimOneInsuredGenderCombo.setMinWidth(200);
		ClaimOneInsuredGenderCombo.setMaxWidth(200);
		ClaimOneInsuredGenderCombo.setMinHeight(25);
		ClaimOneInsuredGenderCombo.setLayoutX(1025);
		ClaimOneInsuredGenderCombo.setLayoutY(358);
		ClaimOneInsuredGenderCombo.setTooltip(new Tooltip("Select Gender"));
		ClaimOneInsuredGenderCombo.getSelectionModel().select(0);
		ClaimOneInsuredGenderCombo.setStyle("-fx-font: 14px \"Calibri\";");
		ClaimOneInsuredGenderCombo.setDisable(true);

		//Text Patient Zip ClaimOne
		Text textClaimOneInsuredPhnNo = new Text();
		textClaimOneInsuredPhnNo.setText("Phone Number");
		textClaimOneInsuredPhnNo.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredPhnNo.setFill(Color.BLACK);
		textClaimOneInsuredPhnNo.setLayoutX(900);
		textClaimOneInsuredPhnNo.setLayoutY(405);
		TextField textFieldClaimOneInsuredPhnNo = new TextField();
		textFieldClaimOneInsuredPhnNo.setLayoutX(1025);
		textFieldClaimOneInsuredPhnNo.setLayoutY(388);
		textFieldClaimOneInsuredPhnNo.setPrefWidth(200);
		textFieldClaimOneInsuredPhnNo.setPrefHeight(25);
		textFieldClaimOneInsuredPhnNo.setEditable(true);
		textFieldClaimOneInsuredPhnNo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneInsuredPhnNo.setTooltip(new Tooltip("Enter Telephone(Include Area Code) : XXXXXXXXXX"));
		textFieldClaimOneInsuredPhnNo.setPromptText("Telephone");
		textFieldClaimOneInsuredPhnNo.setDisable(true);

		textFieldClaimOneInsuredPhnNo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldClaimOneInsuredPhnNo.getText().length()<=12) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldClaimOneInsuredPhnNo.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});

		//Text Patient Name ClaimOne
		Text textClaimOneInsuredAddress = new Text();
		textClaimOneInsuredAddress.setText("Insured's Address");
		textClaimOneInsuredAddress.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredAddress.setFill(Color.BLACK);
		textClaimOneInsuredAddress.setLayoutX(100);
		textClaimOneInsuredAddress.setLayoutY(390);
		TextField textFieldClaimOneInsuredAddressOne = new TextField();
		textFieldClaimOneInsuredAddressOne.setLayoutX(225);
		textFieldClaimOneInsuredAddressOne.setLayoutY(358);
		textFieldClaimOneInsuredAddressOne.setPrefWidth(200);
		textFieldClaimOneInsuredAddressOne.setPrefHeight(25);
		textFieldClaimOneInsuredAddressOne.setEditable(true);
		textFieldClaimOneInsuredAddressOne.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneInsuredAddressOne.setTooltip(new Tooltip("Enter Address Line 1"));
		textFieldClaimOneInsuredAddressOne.setPromptText("Address Line 1");
		textFieldClaimOneInsuredAddressOne.setDisable(true);

		Text textClaimOneInsuredAddressOnestar= new Text();
		textClaimOneInsuredAddressOnestar.setText("*");
		textClaimOneInsuredAddressOnestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredAddressOnestar.setFill(Color.RED);
		textClaimOneInsuredAddressOnestar.setLayoutX(430);
		textClaimOneInsuredAddressOnestar.setLayoutY(368);
		textClaimOneInsuredAddressOnestar.setVisible(false);

		textFieldClaimOneInsuredAddressOne.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaimOneInsuredAddressOne.getText().isEmpty()==false)
				textClaimOneInsuredAddressOnestar.setVisible(false);
			else
				textClaimOneInsuredAddressOnestar.setVisible(true);
		});

		textFieldClaimOneInsuredAddressOne.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOneInsuredAddressOne.getText().length() >= 30) {
						textFieldClaimOneInsuredAddressOne.setText(textFieldClaimOneInsuredAddressOne.getText().substring(0, 30));
					}
				}
			}
		});

		TextField textFieldClaimOneInsuredAddressTwo = new TextField();
		textFieldClaimOneInsuredAddressTwo.setLayoutX(225);
		textFieldClaimOneInsuredAddressTwo.setLayoutY(388);
		textFieldClaimOneInsuredAddressTwo.setPrefWidth(200);
		textFieldClaimOneInsuredAddressTwo.setPrefHeight(25);
		textFieldClaimOneInsuredAddressTwo.setEditable(true);
		textFieldClaimOneInsuredAddressTwo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneInsuredAddressTwo.setTooltip(new Tooltip("Enter Address Line 2"));
		textFieldClaimOneInsuredAddressTwo.setPromptText("Address Line 2");
		textFieldClaimOneInsuredAddressTwo.setDisable(true);

		textFieldClaimOneInsuredAddressTwo.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOneInsuredAddressTwo.getText().length() >= 30) {
						textFieldClaimOneInsuredAddressTwo.setText(textFieldClaimOneInsuredAddressTwo.getText().substring(0, 30));
					}
				}
			}
		});

		//Text City ClaimOne
		Text textClaimOneInsuredCity = new Text();
		textClaimOneInsuredCity.setText("City");
		textClaimOneInsuredCity.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredCity.setFill(Color.BLACK);
		textClaimOneInsuredCity.setLayoutX(500);
		textClaimOneInsuredCity.setLayoutY(378);
		TextField textFieldClaimOneInsuredCity = new TextField();
		textFieldClaimOneInsuredCity.setLayoutX(625);
		textFieldClaimOneInsuredCity.setLayoutY(358);
		textFieldClaimOneInsuredCity.setPrefWidth(200);
		textFieldClaimOneInsuredCity.setPrefHeight(25);
		textFieldClaimOneInsuredCity.setEditable(true);
		textFieldClaimOneInsuredCity.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneInsuredCity.setTooltip(new Tooltip("Enter City"));
		textFieldClaimOneInsuredCity.setPromptText("City");
		textFieldClaimOneInsuredCity.setDisable(true);

		Text textClaimOneInsuredCitystar= new Text();
		textClaimOneInsuredCitystar.setText("*");
		textClaimOneInsuredCitystar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredCitystar.setFill(Color.RED);
		textClaimOneInsuredCitystar.setLayoutX(830);
		textClaimOneInsuredCitystar.setLayoutY(368);
		textClaimOneInsuredCitystar.setVisible(false);

		textFieldClaimOneInsuredCity.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaimOneInsuredCity.getText().isEmpty()==false)
				textClaimOneInsuredCitystar.setVisible(false);
			else
				textClaimOneInsuredCitystar.setVisible(true);
		});

		textFieldClaimOneInsuredCity.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOneInsuredCity.getText().length() >= 20) {
						textFieldClaimOneInsuredCity.setText(textFieldClaimOneInsuredCity.getText().substring(0, 20));
					}
				}
			}
		});

		//Text State ClaimOne
		Text textClaimOneInsuredState = new Text();
		textClaimOneInsuredState.setText("State / Zip");
		textClaimOneInsuredState.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredState.setFill(Color.BLACK);
		textClaimOneInsuredState.setLayoutX(500);
		textClaimOneInsuredState.setLayoutY(405);

		//Combobox Patient State Claim One
		ComboBox<String> ClaimOneInsuredStateCombo = new ComboBox<String>();
		ClaimOneInsuredStateCombo.getItems().addAll("AA","AE","AL","AK","AP","AR","AS","AZ","CA","CO","CT","DE","DC","FL","FM","GA","GU","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MH","MI","MN","MS","MO","MP","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WV","WI","WY");
		ClaimOneInsuredStateCombo.setEditable(false); 
		ClaimOneInsuredStateCombo.setMinWidth(95);
		ClaimOneInsuredStateCombo.setMaxWidth(95);
		ClaimOneInsuredStateCombo.setMinHeight(25);
		ClaimOneInsuredStateCombo.setLayoutX(625);
		ClaimOneInsuredStateCombo.setLayoutY(388);
		ClaimOneInsuredStateCombo.setTooltip(new Tooltip("Select State"));
		ClaimOneInsuredStateCombo.setValue("Select");
		ClaimOneInsuredStateCombo.setStyle("-fx-font: 14px \"Calibri\";");
		ClaimOneInsuredStateCombo.setDisable(true);

		Text textClaimOneInsuredStatestar= new Text();
		textClaimOneInsuredStatestar.setText("*");
		textClaimOneInsuredStatestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredStatestar.setFill(Color.RED);
		textClaimOneInsuredStatestar.setLayoutX(722);
		textClaimOneInsuredStatestar.setLayoutY(398);
		textClaimOneInsuredStatestar.setVisible(false);

		ClaimOneInsuredStateCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
			if(ClaimOneInsuredStateCombo.getSelectionModel().getSelectedIndex()==-1)
				textClaimOneInsuredStatestar.setVisible(true);
			else
				textClaimOneInsuredStatestar.setVisible(false);});

		TextField textFieldClaimOneInsuredZip = new TextField();
		textFieldClaimOneInsuredZip.setLayoutX(730);
		textFieldClaimOneInsuredZip.setLayoutY(388);
		textFieldClaimOneInsuredZip.setPrefWidth(95);
		textFieldClaimOneInsuredZip.setMaxWidth(95);
		textFieldClaimOneInsuredZip.setPrefHeight(25);
		textFieldClaimOneInsuredZip.setEditable(true);
		textFieldClaimOneInsuredZip.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneInsuredZip.setTooltip(new Tooltip("Enter Zip Code"));
		textFieldClaimOneInsuredZip.setPromptText("Zip Code");
		textFieldClaimOneInsuredZip.setDisable(true);

		Text textClaimOneInsuredZipstar= new Text();
		textClaimOneInsuredZipstar.setText("*");
		textClaimOneInsuredZipstar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneInsuredZipstar.setFill(Color.RED);
		textClaimOneInsuredZipstar.setLayoutX(830);
		textClaimOneInsuredZipstar.setLayoutY(398);
		textClaimOneInsuredZipstar.setVisible(false);

		textFieldClaimOneInsuredZip.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaimOneInsuredZip.getText().isEmpty()==false)
				textClaimOneInsuredZipstar.setVisible(false);
			else
				textClaimOneInsuredZipstar.setVisible(true);
		});

		textFieldClaimOneInsuredZip.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldClaimOneInsuredZip.getText().length()<=9) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldClaimOneInsuredZip.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});

		ClaimOneRelationWithInsuredCombo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(ClaimOneRelationWithInsuredCombo.getValue().equalsIgnoreCase("Self"))
				{
					textFieldClaimOneInsuredFName.setDisable(true);
					textFieldClaimOneInsuredMName.setDisable(true);
					textFieldClaimOneInsuredLName.setDisable(true);
					textFieldClaimOneInsuredAddressOne.setDisable(true);
					textFieldClaimOneInsuredAddressTwo.setDisable(true);
					textFieldClaimOneInsuredCity.setDisable(true);
					textFieldClaimOneInsuredZip.setDisable(true);
					ClaimOneInsuredDOB.setDisable(true);
					ClaimOneInsuredGenderCombo.setDisable(true);
					ClaimOneInsuredStateCombo.setDisable(true);
					textFieldClaimOneInsuredPhnNo.setDisable(true);
					textClaimOneInsuredLNamestar.setVisible(false);
					textClaimOneInsuredAddressOnestar.setVisible(false);
					textClaimOneInsuredCitystar.setVisible(false);
					textClaimOneInsuredStatestar.setVisible(false);
					textClaimOneInsuredZipstar.setVisible(false);
					textClaimOneInsuredDOBstar.setVisible(false);
				}
				else
				{
					textFieldClaimOneInsuredFName.setDisable(false);
					textFieldClaimOneInsuredMName.setDisable(false);
					textFieldClaimOneInsuredLName.setDisable(false);
					textFieldClaimOneInsuredFName.clear();
					textFieldClaimOneInsuredLName.clear();
					textFieldClaimOneInsuredMName.clear();
					textFieldClaimOneInsuredAddressOne.setDisable(false);
					textFieldClaimOneInsuredAddressTwo.setDisable(false);
					textFieldClaimOneInsuredAddressOne.clear();
					textFieldClaimOneInsuredAddressTwo.clear();
					textFieldClaimOneInsuredCity.setDisable(false);
					textFieldClaimOneInsuredCity.clear();
					textFieldClaimOneInsuredZip.setDisable(false);
					textFieldClaimOneInsuredZip.clear();
					ClaimOneInsuredDOB.setDisable(false);
					ClaimOneInsuredDOB.setValue(null);
					ClaimOneInsuredGenderCombo.setDisable(false);
					ClaimOneInsuredGenderCombo.getSelectionModel().select(0);
					ClaimOneInsuredStateCombo.setDisable(false);
					ClaimOneInsuredStateCombo.setValue("Select");
					textFieldClaimOneInsuredPhnNo.setDisable(false);
					textFieldClaimOneInsuredPhnNo.clear();
					textClaimOneInsuredLNamestar.setVisible(true);
					textClaimOneInsuredAddressOnestar.setVisible(true);
					textClaimOneInsuredCitystar.setVisible(true);
					textClaimOneInsuredStatestar.setVisible(true);
					textClaimOneInsuredZipstar.setVisible(true);
					textClaimOneInsuredDOBstar.setVisible(true);
				}
			}
		});

		Line line2 = new Line(); 
		line2.setStartX(100); 
		line2.setStartY(430); 
		line2.setEndX(1225); 
		line2.setEndY(430);

		//Text Patient Name ClaimOne
		Text textClaimOneOtherInsuredName = new Text();
		textClaimOneOtherInsuredName.setText("Other Insured's"+'\n'+"Name");
		textClaimOneOtherInsuredName.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneOtherInsuredName.setFill(Color.BLACK);
		textClaimOneOtherInsuredName.setLayoutX(100);
		textClaimOneOtherInsuredName.setLayoutY(455);

		TextField textFieldClaimOneOtherInsuredFName = new TextField();
		textFieldClaimOneOtherInsuredFName.setLayoutX(225);
		textFieldClaimOneOtherInsuredFName.setLayoutY(445);
		textFieldClaimOneOtherInsuredFName.setPrefWidth(200);
		textFieldClaimOneOtherInsuredFName.setPrefHeight(25);
		textFieldClaimOneOtherInsuredFName.setEditable(true);
		textFieldClaimOneOtherInsuredFName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneOtherInsuredFName.setTooltip(new Tooltip("Enter First Name"));
		textFieldClaimOneOtherInsuredFName.setPromptText("First Name");
		textFieldClaimOneOtherInsuredFName.setDisable(true);

		TextField textFieldClaimOneOtherInsuredMName = new TextField();
		textFieldClaimOneOtherInsuredMName.setLayoutX(500);
		textFieldClaimOneOtherInsuredMName.setLayoutY(445);
		textFieldClaimOneOtherInsuredMName.setPrefWidth(50);
		textFieldClaimOneOtherInsuredMName.setPrefHeight(25);
		textFieldClaimOneOtherInsuredMName.setEditable(true);
		textFieldClaimOneOtherInsuredMName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneOtherInsuredMName.setTooltip(new Tooltip("Enter Middle Initial"));
		textFieldClaimOneOtherInsuredMName.setPromptText("M.I.");
		textFieldClaimOneOtherInsuredMName.setDisable(true);

		TextField textFieldClaimOneOtherInsuredLName = new TextField();
		textFieldClaimOneOtherInsuredLName.setLayoutX(625);
		textFieldClaimOneOtherInsuredLName.setLayoutY(445);
		textFieldClaimOneOtherInsuredLName.setPrefWidth(200);
		textFieldClaimOneOtherInsuredLName.setPrefHeight(25);
		textFieldClaimOneOtherInsuredLName.setEditable(true);
		textFieldClaimOneOtherInsuredLName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneOtherInsuredLName.setTooltip(new Tooltip("Enter Last Name"));
		textFieldClaimOneOtherInsuredLName.setPromptText("Last Name");
		textFieldClaimOneOtherInsuredLName.setDisable(true);

		textFieldClaimOneOtherInsuredFName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOneOtherInsuredFName.getText().length() >= 35) {
						textFieldClaimOneOtherInsuredFName.setText(textFieldClaimOneOtherInsuredFName.getText().substring(0, 35));
					}
				}
			}
		});
		textFieldClaimOneOtherInsuredLName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOneOtherInsuredLName.getText().length() >= 60) {
						textFieldClaimOneOtherInsuredLName.setText(textFieldClaimOneOtherInsuredLName.getText().substring(0, 60));
					}
				}
			}
		});

		textFieldClaimOneOtherInsuredMName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaimOneOtherInsuredMName.getText().length() >= 1) {
						textFieldClaimOneOtherInsuredMName.setText(textFieldClaimOneOtherInsuredMName.getText().substring(0, 1));
					}
				}
			}
		});

		Text textClaimOneOtherInsuredPolicy = new Text();
		textClaimOneOtherInsuredPolicy.setText("Other Insured's"+'\n'+"Policy #");
		textClaimOneOtherInsuredPolicy.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneOtherInsuredPolicy.setFill(Color.BLACK);
		textClaimOneOtherInsuredPolicy.setLayoutX(100);
		textClaimOneOtherInsuredPolicy.setLayoutY(495);

		TextField textFieldClaimOneOtherInsuredPolNo= new TextField();
		textFieldClaimOneOtherInsuredPolNo.setLayoutX(225);
		textFieldClaimOneOtherInsuredPolNo.setLayoutY(485);
		textFieldClaimOneOtherInsuredPolNo.setPrefWidth(200);
		textFieldClaimOneOtherInsuredPolNo.setPrefHeight(25);
		textFieldClaimOneOtherInsuredPolNo.setEditable(true);
		textFieldClaimOneOtherInsuredPolNo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneOtherInsuredPolNo.setTooltip(new Tooltip("Enter Policy Number"));
		textFieldClaimOneOtherInsuredPolNo.setPromptText("Policy Number");
		textFieldClaimOneOtherInsuredPolNo.setDisable(true);

		Text textClaimOneOtherInsuredGroup = new Text();
		textClaimOneOtherInsuredGroup.setText("Other Insured's"+'\n'+"Group #");
		textClaimOneOtherInsuredGroup.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneOtherInsuredGroup.setFill(Color.BLACK);
		textClaimOneOtherInsuredGroup.setLayoutX(500);
		textClaimOneOtherInsuredGroup.setLayoutY(495);

		TextField textFieldClaimOneOtherInsuredGroupNo= new TextField();
		textFieldClaimOneOtherInsuredGroupNo.setLayoutX(625);
		textFieldClaimOneOtherInsuredGroupNo.setLayoutY(485);
		textFieldClaimOneOtherInsuredGroupNo.setPrefWidth(200);
		textFieldClaimOneOtherInsuredGroupNo.setPrefHeight(25);
		textFieldClaimOneOtherInsuredGroupNo.setEditable(true);
		textFieldClaimOneOtherInsuredGroupNo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaimOneOtherInsuredGroupNo.setTooltip(new Tooltip("Enter Group Number"));
		textFieldClaimOneOtherInsuredGroupNo.setPromptText("Group Number");
		textFieldClaimOneOtherInsuredGroupNo.setDisable(true);

		Line line3 = new Line(); 
		line3.setStartX(100); 
		line3.setStartY(522); 
		line3.setEndX(1225); 
		line3.setEndY(522);

		//Text State ClaimOne
		Text textClaimOnePatientConditionRealtedTo = new Text();
		textClaimOnePatientConditionRealtedTo.setText("Patient's Conditon"+'\n'+"Related To");
		textClaimOnePatientConditionRealtedTo.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientConditionRealtedTo.setFill(Color.BLACK);
		textClaimOnePatientConditionRealtedTo.setLayoutX(100);
		textClaimOnePatientConditionRealtedTo.setLayoutY(545);

		CheckBox ClaimOneCheckPatientConditionRelatedtoEmployment = new CheckBox();
		ClaimOneCheckPatientConditionRelatedtoEmployment.setText("Employment ?");
		ClaimOneCheckPatientConditionRelatedtoEmployment.setLayoutX(250);
		ClaimOneCheckPatientConditionRelatedtoEmployment.setLayoutY(536);
		//ClaimOneCheckPatientConditionRelatedtoEmployment.setStyle("-fx-font: 14px \"Calibri\";");
		ClaimOneCheckPatientConditionRelatedtoEmployment.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		CheckBox ClaimOneCheckPatientConditionRelatedtoAutoAccident = new CheckBox();
		ClaimOneCheckPatientConditionRelatedtoAutoAccident.setText("Auto Accident ?");
		ClaimOneCheckPatientConditionRelatedtoAutoAccident.setLayoutX(375);
		ClaimOneCheckPatientConditionRelatedtoAutoAccident.setLayoutY(536);
		//ClaimOneCheckPatientConditionRelatedtoEmployment.setStyle("-fx-font: 14px \"Calibri\";");
		ClaimOneCheckPatientConditionRelatedtoAutoAccident.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));

		CheckBox ClaimOneCheckPatientConditionRelatedtoOtherAccident = new CheckBox();
		ClaimOneCheckPatientConditionRelatedtoOtherAccident.setText("Other Accident ?");
		ClaimOneCheckPatientConditionRelatedtoOtherAccident.setLayoutX(500);
		ClaimOneCheckPatientConditionRelatedtoOtherAccident.setLayoutY(536);
		ClaimOneCheckPatientConditionRelatedtoOtherAccident.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));

		Text textClaimOnePatientConditionState = new Text();
		textClaimOnePatientConditionState.setText("State");
		textClaimOnePatientConditionState.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOnePatientConditionState.setFill(Color.BLACK);
		textClaimOnePatientConditionState.setLayoutX(900);
		textClaimOnePatientConditionState.setLayoutY(555);
		//Combobox Patient State Claim One
		ComboBox<String> ClaimOnePatientConditionStateCombo = new ComboBox<String>();
		ClaimOnePatientConditionStateCombo.getItems().addAll("AA","AE","AL","AK","AP","AR","AS","AZ","CA","CO","CT","DE","DC","FL","FM","GA","GU","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MH","MI","MN","MS","MO","MP","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WV","WI","WY");
		ClaimOnePatientConditionStateCombo.setEditable(false); 
		ClaimOnePatientConditionStateCombo.setMinWidth(200);
		ClaimOnePatientConditionStateCombo.setMinHeight(25);
		ClaimOnePatientConditionStateCombo.setLayoutX(1025);
		ClaimOnePatientConditionStateCombo.setLayoutY(536);
		ClaimOnePatientConditionStateCombo.setTooltip(new Tooltip("Select State"));
		ClaimOnePatientConditionStateCombo.setValue("Select");;
		ClaimOnePatientConditionStateCombo.setStyle("-fx-font: 14px \"Calibri\";");
		//
		Button ClaimOneAutoFill = new Button("Auto Fill Data");
		ClaimOneAutoFill.setLayoutX(1170);
		ClaimOneAutoFill.setLayoutY(30);
		ClaimOneAutoFill.setTextFill(Color.WHITE);
		ClaimOneAutoFill.setStyle("-fx-background-color:STEELBLUE");
		ClaimOneAutoFill.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		ClaimOneAutoFill.setMaxWidth(100);
		ClaimOneAutoFill.setMinWidth(100);

		Button ClaimOneResetData= new Button("Reset Data");
		ClaimOneResetData.setLayoutX(1270);
		ClaimOneResetData.setLayoutY(30);
		ClaimOneResetData.setTextFill(Color.WHITE);
		ClaimOneResetData.setStyle("-fx-background-color:STEELBLUE");
		ClaimOneResetData.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		ClaimOneResetData.setMaxWidth(100);
		ClaimOneResetData.setMinWidth(100);

		ClaimOne.getChildren().addAll(rectClaimOneBorder,rectClaimOneTop,textClaimOneTop,HomelinkClaimOne,rectClaimOneMenu,ClaimOneMenuTopOne,
				ClaimOneMenuTopTwo,ClaimOneMenuTopThree,textClaimOneSelectInsProgram,ClaimOneInsProgCombo,textClaimOneInsuredIdNumber,
				textFieldClaimOneInsuredIdNumber,textClaimOnePatientName,textClaimOnePatientNamestar,textFieldClaimOnePatientFName,
				textFieldClaimOnePatientLName,textFieldClaimOnePatientMName,textClaimOnePatientDOB,textClaimOnePatientDOBstar,ClaimOnePatientDOB,
				textClaimOnePatientAddress,textFieldClaimOnePatientAddressOne,textFieldClaimOnePatientAddressTwo,textClaimOnePatientCity,textFieldClaimOnePatientCity,
				textClaimOnePatientState,ClaimOnepatientStateCombo,textClaimOnePatientSEX,ClaimOnepatientGenderCombo,
				textFieldClaimOnePatientZip,textClaimOnePatientPhnNo,textFieldClaimOnePatientPhnNo,line,line1,textClaimOneInsuredName,textFieldClaimOneInsuredFName,
				textFieldClaimOneInsuredMName,textFieldClaimOneInsuredLName,textFieldClaimOneInsuredZip,textClaimOneInsuredPhnNo,
				textFieldClaimOneInsuredPhnNo,textClaimOneInsuredAddress,textFieldClaimOneInsuredAddressOne,textFieldClaimOneInsuredAddressTwo,textClaimOneInsuredCity,
				textFieldClaimOneInsuredCity,textClaimOneInsuredState,ClaimOneInsuredStateCombo,textClaimOneInsuredDOB,ClaimOneInsuredDOB,line2,
				textClaimOneOtherInsuredName,textFieldClaimOneOtherInsuredFName,textFieldClaimOneOtherInsuredMName,textFieldClaimOneOtherInsuredLName,
				textClaimOneOtherInsuredPolicy,textFieldClaimOneOtherInsuredPolNo,textClaimOneOtherInsuredGroup,textFieldClaimOneOtherInsuredGroupNo,line3,
				textClaimOnePatientConditionRealtedTo,ClaimOneCheckPatientConditionRelatedtoEmployment,textClaimOnePatientConditionState,ClaimOnePatientConditionStateCombo,
				textClaimOneInsuredPolicyGroupFECA,textFieldClaimOneInsuredPolicyGroupFECA,textClaimOneInsuredSEX,ClaimOneInsuredGenderCombo,
				textClaimOneRelationWithInsured,ClaimOneRelationWithInsuredCombo,ClaimOneCheckPatientConditionRelatedtoAutoAccident,ClaimOneCheckPatientConditionRelatedtoOtherAccident,
				ClaimOneAutoFill,textClaimOneInsuredIdNumberestar,textClaimOnePatientAddressOnestar,textClaimOnePatientCitystar,textClaimOnePatientStatestar,
				textClaimOnePatientZipstar,textClaimOneInsuredLNamestar,textClaimOneInsuredAddressOnestar,textClaimOneInsuredCitystar,textClaimOneInsuredStatestar,
				textClaimOneInsuredZipstar,textClaimOneInsuredDOBstar,ClaimOneResetData);
		ClaimOne.setStyle("-fx-background-color:WHITE");
		////////////////////////
		//Claim Two Screen
		Rectangle rectClaimTwoTop = new Rectangle();
		rectClaimTwoTop.setX(0.0f);
		rectClaimTwoTop.setY(0.0f);
		rectClaimTwoTop.setWidth(1360.0f);
		rectClaimTwoTop.setHeight(60.0f);
		rectClaimTwoTop.setFill(Color.STEELBLUE);
		rectClaimTwoTop.setStroke(Color.STEELBLUE);
		Rectangle rectClaimTwoMenu = new Rectangle();
		rectClaimTwoMenu.setX(0.0f);
		rectClaimTwoMenu.setY(60.0f);
		rectClaimTwoMenu.setWidth(1356.0f);
		rectClaimTwoMenu.setHeight(28.0f);
		rectClaimTwoMenu.setFill(Color.DARKTURQUOISE);//DARKSALMON//WHITESMOKE
		rectClaimTwoMenu.setStroke(Color.DARKSALMON);
		//Boundary
		Rectangle rectClaimTwoBorder = new Rectangle();
		rectClaimTwoBorder.setX(1.5f);
		rectClaimTwoBorder.setY(0.0f);
		rectClaimTwoBorder.setWidth(1356.0f);
		rectClaimTwoBorder.setHeight(682.0f);
		rectClaimTwoBorder.setFill(Color.WHITE);
		rectClaimTwoBorder.setStroke(Color.STEELBLUE);

		//Validate Data ReferralInq Button
		Button ClaimTwoMenuTopOne = new Button();
		ClaimTwoMenuTopOne.setText("Patient Details");
		ClaimTwoMenuTopOne.setLayoutX(400);
		ClaimTwoMenuTopOne.setLayoutY(60);
		ClaimTwoMenuTopOne.setMinWidth(150);
		ClaimTwoMenuTopOne.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		ClaimTwoMenuTopOne.setTextFill(Color.STEELBLUE);
		ClaimTwoMenuTopOne.setStyle("-fx-background-color:DARKGREY");
		ClaimTwoMenuTopOne.setTextFill(Color.WHITE);

		//Validate Data ReferralInq Button
		Button ClaimTwoMenuTopTwo = new Button();
		ClaimTwoMenuTopTwo.setText("Provider Details");
		ClaimTwoMenuTopTwo.setLayoutX(600);
		ClaimTwoMenuTopTwo.setLayoutY(60);
		ClaimTwoMenuTopTwo.setMinWidth(150);
		ClaimTwoMenuTopTwo.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		ClaimTwoMenuTopTwo.setTextFill(Color.STEELBLUE);
		ClaimTwoMenuTopTwo.setStyle("-fx-background-color:DARKSALMON");
		ClaimTwoMenuTopTwo.setTextFill(Color.BLACK);
		//Process Data ReferralInq Button
		Button ClaimTwoMenuTopThree = new Button();
		ClaimTwoMenuTopThree.setText("Claim Details");
		ClaimTwoMenuTopThree.setLayoutX(800);
		ClaimTwoMenuTopThree.setLayoutY(60);
		ClaimTwoMenuTopThree.setMinWidth(150);
		ClaimTwoMenuTopThree.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		ClaimTwoMenuTopThree.setStyle("-fx-background-color:DARKGREY");
		ClaimTwoMenuTopThree.setTextFill(Color.WHITE);
		//Top Text CSI
		Text textClaimTwoTop = new Text();
		textClaimTwoTop.setText("Health Insurance Claim Form");
		textClaimTwoTop.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 24));
		textClaimTwoTop.setFill(Color.WHITE);
		textClaimTwoTop.setLayoutX(532);
		textClaimTwoTop.setLayoutY(40);
		//HomeLink CSI
		Hyperlink HomelinkClaimTwo = new Hyperlink();
		HomelinkClaimTwo.setText("Home");
		HomelinkClaimTwo.setStyle("-fx-text-fill: YELLOW;");
		HomelinkClaimTwo.setLayoutX(1300);
		HomelinkClaimTwo.setLayoutY(2);
		HomelinkClaimTwo.setUnderline(false);
		HomelinkClaimTwo.setFocusTraversable(false);
		HomelinkClaimTwo.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 14));

		Text textClaim2ServicePhysicianName= new Text();
		textClaim2ServicePhysicianName.setText("Billing Provider Name");
		textClaim2ServicePhysicianName.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServicePhysicianName.setFill(Color.BLACK);
		textClaim2ServicePhysicianName.setLayoutX(97);
		textClaim2ServicePhysicianName.setLayoutY(119);

		TextField textFieldClaim2ServicePhysicianName = new TextField();
		textFieldClaim2ServicePhysicianName.setLayoutX(225);
		textFieldClaim2ServicePhysicianName.setLayoutY(101);
		textFieldClaim2ServicePhysicianName.setPrefWidth(200);
		textFieldClaim2ServicePhysicianName.setPrefHeight(25);
		textFieldClaim2ServicePhysicianName.setEditable(true);
		textFieldClaim2ServicePhysicianName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaim2ServicePhysicianName.setTooltip(new Tooltip("Enter Billing Provider Name"));
		textFieldClaim2ServicePhysicianName.setPromptText("Billing Provider Name");

		textFieldClaim2ServicePhysicianName.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaim2ServicePhysicianName.getText().length() >= 95) {
						textFieldClaim2ServicePhysicianName.setText(textFieldClaim2ServicePhysicianName.getText().substring(0, 95));
					}
				}
			}
		});

		Text textClaim2ServicePhysicianNamestar= new Text();
		textClaim2ServicePhysicianNamestar.setText("*");
		textClaim2ServicePhysicianNamestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServicePhysicianNamestar.setFill(Color.RED);
		textClaim2ServicePhysicianNamestar.setLayoutX(430);
		textClaim2ServicePhysicianNamestar.setLayoutY(111);

		textFieldClaim2ServicePhysicianName.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaim2ServicePhysicianName.getText().isEmpty()==false)
				textClaim2ServicePhysicianNamestar.setVisible(false);
			else
				textClaim2ServicePhysicianNamestar.setVisible(true);
		});

		Text textClaim2FederalTaxIDNo = new Text();
		textClaim2FederalTaxIDNo.setText("Federal Tax ID"+'\n'+ "Number");
		textClaim2FederalTaxIDNo.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2FederalTaxIDNo.setFill(Color.BLACK);
		textClaim2FederalTaxIDNo.setLayoutX(100);
		textClaim2FederalTaxIDNo.setLayoutY(142);

		TextField textFieldClaim2FederalTaxIDNo= new TextField();
		textFieldClaim2FederalTaxIDNo.setLayoutX(225);
		textFieldClaim2FederalTaxIDNo.setLayoutY(131);
		textFieldClaim2FederalTaxIDNo.setPrefWidth(200);
		textFieldClaim2FederalTaxIDNo.setPrefHeight(25);
		textFieldClaim2FederalTaxIDNo.setEditable(true);
		textFieldClaim2FederalTaxIDNo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaim2FederalTaxIDNo.setTooltip(new Tooltip("Enter Federal Tax ID Number"));
		textFieldClaim2FederalTaxIDNo.setPromptText("Federal Tax ID Number");

		textFieldClaim2FederalTaxIDNo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldClaim2FederalTaxIDNo.getText().length()<=9) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldClaim2FederalTaxIDNo.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});

		Text textClaim2FederalTINstar= new Text();
		textClaim2FederalTINstar.setText("*");
		textClaim2FederalTINstar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2FederalTINstar.setFill(Color.RED);
		textClaim2FederalTINstar.setLayoutX(430);
		textClaim2FederalTINstar.setLayoutY(141);

		textFieldClaim2FederalTaxIDNo.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaim2FederalTaxIDNo.getText().isEmpty()==false)
				textClaim2FederalTINstar.setVisible(false);
			else
				textClaim2FederalTINstar.setVisible(true);
		});

		Text textClaim2ServicePhysicianPhoneNo= new Text();
		textClaim2ServicePhysicianPhoneNo.setText("Phone Number");
		textClaim2ServicePhysicianPhoneNo.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServicePhysicianPhoneNo.setFill(Color.BLACK);
		textClaim2ServicePhysicianPhoneNo.setLayoutX(900);
		textClaim2ServicePhysicianPhoneNo.setLayoutY(178);

		TextField textFieldClaim2ServicePhysicianPhoneNo = new TextField();
		textFieldClaim2ServicePhysicianPhoneNo.setLayoutX(1025);
		textFieldClaim2ServicePhysicianPhoneNo.setLayoutY(161);
		textFieldClaim2ServicePhysicianPhoneNo.setPrefWidth(200);
		textFieldClaim2ServicePhysicianPhoneNo.setPrefHeight(25);
		textFieldClaim2ServicePhysicianPhoneNo.setEditable(true);
		textFieldClaim2ServicePhysicianPhoneNo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaim2ServicePhysicianPhoneNo.setTooltip(new Tooltip("Enter Physician's, Supplier's Phone Number"));
		textFieldClaim2ServicePhysicianPhoneNo.setPromptText("Phone Number");

		textFieldClaim2ServicePhysicianPhoneNo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldClaim2ServicePhysicianPhoneNo.getText().length()<=12) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldClaim2ServicePhysicianPhoneNo.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});

		Text textClaim2ServicePhysicianNPI= new Text();
		textClaim2ServicePhysicianNPI.setText("Billing Provider"+'\n'+ "NPI");
		textClaim2ServicePhysicianNPI.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServicePhysicianNPI.setFill(Color.BLACK);
		textClaim2ServicePhysicianNPI.setLayoutX(500);
		textClaim2ServicePhysicianNPI.setLayoutY(170);

		TextField textFieldClaim2ServicePhysicianNPI = new TextField();
		textFieldClaim2ServicePhysicianNPI.setLayoutX(625);
		textFieldClaim2ServicePhysicianNPI.setLayoutY(161);
		textFieldClaim2ServicePhysicianNPI.setPrefWidth(200);
		textFieldClaim2ServicePhysicianNPI.setPrefHeight(25);
		textFieldClaim2ServicePhysicianNPI.setEditable(true);
		textFieldClaim2ServicePhysicianNPI.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaim2ServicePhysicianNPI.setTooltip(new Tooltip("Enter Billing Provider NPI"));
		textFieldClaim2ServicePhysicianNPI.setPromptText("Billing Provider NPI");

		textFieldClaim2ServicePhysicianNPI.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldClaim2ServicePhysicianNPI.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldClaim2ServicePhysicianNPI.setText(oldValue);
					}
				}
				catch(Exception e)
				{
				}
			}
		});

		Text textClaim2ServiceFacilityPhysicianAddress= new Text();
		textClaim2ServiceFacilityPhysicianAddress.setText("Billing Provider"+'\n'+"Address");
		textClaim2ServiceFacilityPhysicianAddress.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServiceFacilityPhysicianAddress.setFill(Color.BLACK);
		textClaim2ServiceFacilityPhysicianAddress.setLayoutX(500);
		textClaim2ServiceFacilityPhysicianAddress.setLayoutY(128);

		TextField textFieldClaim2ServiceFacilityPhysicianAddressOne = new TextField();
		textFieldClaim2ServiceFacilityPhysicianAddressOne.setLayoutX(625);
		textFieldClaim2ServiceFacilityPhysicianAddressOne.setLayoutY(101);
		textFieldClaim2ServiceFacilityPhysicianAddressOne.setPrefWidth(200);
		textFieldClaim2ServiceFacilityPhysicianAddressOne.setPrefHeight(25);
		textFieldClaim2ServiceFacilityPhysicianAddressOne.setEditable(true);
		textFieldClaim2ServiceFacilityPhysicianAddressOne.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaim2ServiceFacilityPhysicianAddressOne.setTooltip(new Tooltip("Enter Address Line 1"));
		textFieldClaim2ServiceFacilityPhysicianAddressOne.setPromptText("Address Line 1");

		textFieldClaim2ServiceFacilityPhysicianAddressOne.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaim2ServiceFacilityPhysicianAddressOne.getText().length() >= 55) {
						textFieldClaim2ServiceFacilityPhysicianAddressOne.setText(textFieldClaim2ServiceFacilityPhysicianAddressOne.getText().substring(0, 55));
					}
				}
			}
		});

		Text textClaim2ServiceFacilityPhysicianAddressOnestar= new Text();
		textClaim2ServiceFacilityPhysicianAddressOnestar.setText("*");
		textClaim2ServiceFacilityPhysicianAddressOnestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServiceFacilityPhysicianAddressOnestar.setFill(Color.RED);
		textClaim2ServiceFacilityPhysicianAddressOnestar.setLayoutX(830);
		textClaim2ServiceFacilityPhysicianAddressOnestar.setLayoutY(111);

		textFieldClaim2ServiceFacilityPhysicianAddressOne.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaim2ServiceFacilityPhysicianAddressOne.getText().isEmpty()==false)
				textClaim2ServiceFacilityPhysicianAddressOnestar.setVisible(false);
			else
				textClaim2ServiceFacilityPhysicianAddressOnestar.setVisible(true);
		});
		TextField textFieldClaim2ServiceFacilityPhysicianAddressTwo = new TextField();
		textFieldClaim2ServiceFacilityPhysicianAddressTwo.setLayoutX(625);
		textFieldClaim2ServiceFacilityPhysicianAddressTwo.setLayoutY(131);
		textFieldClaim2ServiceFacilityPhysicianAddressTwo.setPrefWidth(200);
		textFieldClaim2ServiceFacilityPhysicianAddressTwo.setPrefHeight(25);
		textFieldClaim2ServiceFacilityPhysicianAddressTwo.setEditable(true);
		textFieldClaim2ServiceFacilityPhysicianAddressTwo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaim2ServiceFacilityPhysicianAddressTwo.setTooltip(new Tooltip("Enter Address Line 2"));
		textFieldClaim2ServiceFacilityPhysicianAddressTwo.setPromptText("Address Line 2");

		textFieldClaim2ServiceFacilityPhysicianAddressTwo.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaim2ServiceFacilityPhysicianAddressTwo.getText().length() >= 55) {
						textFieldClaim2ServiceFacilityPhysicianAddressTwo.setText(textFieldClaim2ServiceFacilityPhysicianAddressTwo.getText().substring(0, 55));
					}
				}
			}
		});

		Text textClaim2ServiceFacilityPhysicainCity= new Text();
		textClaim2ServiceFacilityPhysicainCity.setText("City");
		textClaim2ServiceFacilityPhysicainCity.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServiceFacilityPhysicainCity.setFill(Color.BLACK);
		textClaim2ServiceFacilityPhysicainCity.setLayoutX(900);
		textClaim2ServiceFacilityPhysicainCity.setLayoutY(118);

		TextField textFieldClaim2ServiceFacilityPhysicianCity = new TextField();
		textFieldClaim2ServiceFacilityPhysicianCity.setLayoutX(1025);
		textFieldClaim2ServiceFacilityPhysicianCity.setLayoutY(101);
		textFieldClaim2ServiceFacilityPhysicianCity.setPrefWidth(200);
		textFieldClaim2ServiceFacilityPhysicianCity.setPrefHeight(25);
		textFieldClaim2ServiceFacilityPhysicianCity.setEditable(true);
		textFieldClaim2ServiceFacilityPhysicianCity.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaim2ServiceFacilityPhysicianCity.setTooltip(new Tooltip("Enter City"));
		textFieldClaim2ServiceFacilityPhysicianCity.setPromptText("City");

		Text textClaim2ServiceFacilityPhysicianCitystar= new Text();
		textClaim2ServiceFacilityPhysicianCitystar.setText("*");
		textClaim2ServiceFacilityPhysicianCitystar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServiceFacilityPhysicianCitystar.setFill(Color.RED);
		textClaim2ServiceFacilityPhysicianCitystar.setLayoutX(1230);
		textClaim2ServiceFacilityPhysicianCitystar.setLayoutY(111);

		textFieldClaim2ServiceFacilityPhysicianCity.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaim2ServiceFacilityPhysicianCity.getText().isEmpty()==false)
				textClaim2ServiceFacilityPhysicianCitystar.setVisible(false);
			else
				textClaim2ServiceFacilityPhysicianCitystar.setVisible(true);
		});

		textFieldClaim2ServiceFacilityPhysicianCity.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaim2ServiceFacilityPhysicianCity.getText().length() >= 30) {
						textFieldClaim2ServiceFacilityPhysicianCity.setText(textFieldClaim2ServiceFacilityPhysicianCity.getText().substring(0, 30));
					}
				}
			}
		});

		Text textClaim2ServiceFacilityPhysicianStateZIp= new Text();
		textClaim2ServiceFacilityPhysicianStateZIp.setText("State / Zip");
		textClaim2ServiceFacilityPhysicianStateZIp.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServiceFacilityPhysicianStateZIp.setFill(Color.BLACK);
		textClaim2ServiceFacilityPhysicianStateZIp.setLayoutX(900);
		textClaim2ServiceFacilityPhysicianStateZIp.setLayoutY(149);

		TextField textFieldClaim2ServiceFacilityPhysicianZip = new TextField();
		textFieldClaim2ServiceFacilityPhysicianZip.setLayoutX(1130);
		textFieldClaim2ServiceFacilityPhysicianZip.setLayoutY(131);
		textFieldClaim2ServiceFacilityPhysicianZip.setPrefWidth(95);
		textFieldClaim2ServiceFacilityPhysicianZip.setPrefHeight(25);
		textFieldClaim2ServiceFacilityPhysicianZip.setEditable(true);
		textFieldClaim2ServiceFacilityPhysicianZip.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaim2ServiceFacilityPhysicianZip.setTooltip(new Tooltip("Enter Zip Code"));
		textFieldClaim2ServiceFacilityPhysicianZip.setPromptText("Zip Code");

		textFieldClaim2ServiceFacilityPhysicianCity.setPromptText("City");
		Text textClaim2ServiceFacilityPhysicianZipstar= new Text();
		textClaim2ServiceFacilityPhysicianZipstar.setText("*");
		textClaim2ServiceFacilityPhysicianZipstar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServiceFacilityPhysicianZipstar.setFill(Color.RED);
		textClaim2ServiceFacilityPhysicianZipstar.setLayoutX(1230);
		textClaim2ServiceFacilityPhysicianZipstar.setLayoutY(141);

		textFieldClaim2ServiceFacilityPhysicianZip.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaim2ServiceFacilityPhysicianZip.getText().isEmpty()==false)
				textClaim2ServiceFacilityPhysicianZipstar.setVisible(false);
			else
				textClaim2ServiceFacilityPhysicianZipstar.setVisible(true);
		});

		textFieldClaim2ServiceFacilityPhysicianZip.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldClaim2ServiceFacilityPhysicianZip.getText().length()<=9) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldClaim2ServiceFacilityPhysicianZip.setText(oldValue);
					}
				}
				catch(Exception e)
				{
				}
			}
		});

		ComboBox<String> Claim2ServiceFacilityPhysicianStateCombo = new ComboBox<String>();
		Claim2ServiceFacilityPhysicianStateCombo.getItems().addAll("AA","AE","AL","AK","AP","AR","AS","AZ","CA","CO","CT","DE","DC","FL","FM","GA","GU","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MH","MI","MN","MS","MO","MP","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WV","WI","WY");
		Claim2ServiceFacilityPhysicianStateCombo.setEditable(false); 
		Claim2ServiceFacilityPhysicianStateCombo.setMinWidth(95);
		Claim2ServiceFacilityPhysicianStateCombo.setMaxWidth(95);
		Claim2ServiceFacilityPhysicianStateCombo.setMinHeight(25);
		Claim2ServiceFacilityPhysicianStateCombo.setLayoutX(1025);
		Claim2ServiceFacilityPhysicianStateCombo.setLayoutY(131);
		Claim2ServiceFacilityPhysicianStateCombo.setTooltip(new Tooltip("Select State"));
		Claim2ServiceFacilityPhysicianStateCombo.setValue("Select");;
		Claim2ServiceFacilityPhysicianStateCombo.setStyle("-fx-font: 14px \"Calibri\";");

		Text textClaimOneServiceFacilityPhysicianStatestar= new Text();
		textClaimOneServiceFacilityPhysicianStatestar.setText("*");
		textClaimOneServiceFacilityPhysicianStatestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaimOneServiceFacilityPhysicianStatestar.setFill(Color.RED);
		textClaimOneServiceFacilityPhysicianStatestar.setLayoutX(1122);
		textClaimOneServiceFacilityPhysicianStatestar.setLayoutY(141);

		Claim2ServiceFacilityPhysicianStateCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
			if(Claim2ServiceFacilityPhysicianStateCombo.getSelectionModel().getSelectedIndex()==-1)
				textClaimOneServiceFacilityPhysicianStatestar.setVisible(true);
			else
				textClaimOneServiceFacilityPhysicianStatestar.setVisible(false);});

		Line line9 = new Line(); 
		line9.setStartX(100); 
		line9.setStartY(198); 
		line9.setEndX(1225); 
		line9.setEndY(198);
		//////////////////////////////////////

		Text textClaim2ServiceFacilitypaytoProviderAddress= new Text();
		textClaim2ServiceFacilitypaytoProviderAddress.setText("Pay To"+'\n'+"Provider Location");
		textClaim2ServiceFacilitypaytoProviderAddress.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServiceFacilitypaytoProviderAddress.setFill(Color.BLACK);
		textClaim2ServiceFacilitypaytoProviderAddress.setLayoutX(100);
		textClaim2ServiceFacilitypaytoProviderAddress.setLayoutY(235);

		TextField textFieldClaim2ServiceFacilityPaytoProvierAddressOne = new TextField();
		textFieldClaim2ServiceFacilityPaytoProvierAddressOne.setLayoutX(225);
		textFieldClaim2ServiceFacilityPaytoProvierAddressOne.setLayoutY(207);
		textFieldClaim2ServiceFacilityPaytoProvierAddressOne.setPrefWidth(200);
		textFieldClaim2ServiceFacilityPaytoProvierAddressOne.setPrefHeight(25);
		textFieldClaim2ServiceFacilityPaytoProvierAddressOne.setEditable(true);
		textFieldClaim2ServiceFacilityPaytoProvierAddressOne.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaim2ServiceFacilityPaytoProvierAddressOne.setTooltip(new Tooltip("Enter Address Line 1"));
		textFieldClaim2ServiceFacilityPaytoProvierAddressOne.setPromptText("Address Line 1");

		Text textClaim2ServiceFacilityPaytoProvierAddressOnestar= new Text();
		textClaim2ServiceFacilityPaytoProvierAddressOnestar.setText("*");
		textClaim2ServiceFacilityPaytoProvierAddressOnestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServiceFacilityPaytoProvierAddressOnestar.setFill(Color.RED);
		textClaim2ServiceFacilityPaytoProvierAddressOnestar.setLayoutX(430);
		textClaim2ServiceFacilityPaytoProvierAddressOnestar.setLayoutY(217);

		textFieldClaim2ServiceFacilityPaytoProvierAddressOne.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().length() >= 55) {
						textFieldClaim2ServiceFacilityPaytoProvierAddressOne.setText(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().substring(0, 55));
					}
				}
			}
		});
		TextField textFieldClaim2ServiceFacilityPayToProviderAddressTwo = new TextField();
		textFieldClaim2ServiceFacilityPayToProviderAddressTwo.setLayoutX(225);
		textFieldClaim2ServiceFacilityPayToProviderAddressTwo.setLayoutY(237);
		textFieldClaim2ServiceFacilityPayToProviderAddressTwo.setPrefWidth(200);
		textFieldClaim2ServiceFacilityPayToProviderAddressTwo.setPrefHeight(25);
		textFieldClaim2ServiceFacilityPayToProviderAddressTwo.setEditable(true);
		textFieldClaim2ServiceFacilityPayToProviderAddressTwo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaim2ServiceFacilityPayToProviderAddressTwo.setTooltip(new Tooltip("Enter Address Line 2"));
		textFieldClaim2ServiceFacilityPayToProviderAddressTwo.setPromptText("Address Line 2");

		textFieldClaim2ServiceFacilityPayToProviderAddressTwo.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().length() >= 55) {
						textFieldClaim2ServiceFacilityPayToProviderAddressTwo.setText(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().substring(0, 55));
					}
				}
			}
		});

		Text textClaim2ServiceFacilityPayToProviderCity= new Text();
		textClaim2ServiceFacilityPayToProviderCity.setText("City");
		textClaim2ServiceFacilityPayToProviderCity.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServiceFacilityPayToProviderCity.setFill(Color.BLACK);
		textClaim2ServiceFacilityPayToProviderCity.setLayoutX(500);
		textClaim2ServiceFacilityPayToProviderCity.setLayoutY(227);

		TextField textFieldClaim2ServiceFacilityPayToProviderCity = new TextField();
		textFieldClaim2ServiceFacilityPayToProviderCity.setLayoutX(625);
		textFieldClaim2ServiceFacilityPayToProviderCity.setLayoutY(207);
		textFieldClaim2ServiceFacilityPayToProviderCity.setPrefWidth(200);
		textFieldClaim2ServiceFacilityPayToProviderCity.setPrefHeight(25);
		textFieldClaim2ServiceFacilityPayToProviderCity.setEditable(true);
		textFieldClaim2ServiceFacilityPayToProviderCity.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaim2ServiceFacilityPayToProviderCity.setTooltip(new Tooltip("Enter City"));
		textFieldClaim2ServiceFacilityPayToProviderCity.setPromptText("City");

		Text textClaim2ServiceFacilityPaytoProvierCitystar= new Text();
		textClaim2ServiceFacilityPaytoProvierCitystar.setText("*");
		textClaim2ServiceFacilityPaytoProvierCitystar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServiceFacilityPaytoProvierCitystar.setFill(Color.RED);
		textClaim2ServiceFacilityPaytoProvierCitystar.setLayoutX(830);
		textClaim2ServiceFacilityPaytoProvierCitystar.setLayoutY(217);

		textFieldClaim2ServiceFacilityPayToProviderCity.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldClaim2ServiceFacilityPayToProviderCity.getText().length() >= 30) {
						textFieldClaim2ServiceFacilityPayToProviderCity.setText(textFieldClaim2ServiceFacilityPayToProviderCity.getText().substring(0, 30));
					}
				}
			}
		});

		Text textClaim2ServiceFacilityPayToProviderStateZIp= new Text();
		textClaim2ServiceFacilityPayToProviderStateZIp.setText("State / Zip");
		textClaim2ServiceFacilityPayToProviderStateZIp.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServiceFacilityPayToProviderStateZIp.setFill(Color.BLACK);
		textClaim2ServiceFacilityPayToProviderStateZIp.setLayoutX(500);
		textClaim2ServiceFacilityPayToProviderStateZIp.setLayoutY(257);

		TextField textFieldClaim2ServiceFacilitypayToProviderfZip = new TextField();
		textFieldClaim2ServiceFacilitypayToProviderfZip.setLayoutX(730);
		textFieldClaim2ServiceFacilitypayToProviderfZip.setLayoutY(237);
		textFieldClaim2ServiceFacilitypayToProviderfZip.setPrefWidth(95);
		textFieldClaim2ServiceFacilitypayToProviderfZip.setPrefHeight(25);
		textFieldClaim2ServiceFacilitypayToProviderfZip.setEditable(true);
		textFieldClaim2ServiceFacilitypayToProviderfZip.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
		textFieldClaim2ServiceFacilitypayToProviderfZip.setTooltip(new Tooltip("Enter Zip Code"));
		textFieldClaim2ServiceFacilitypayToProviderfZip.setPromptText("Zip Code");

		Text textClaim2ServiceFacilityPaytoProvierZipstar= new Text();
		textClaim2ServiceFacilityPaytoProvierZipstar.setText("*");
		textClaim2ServiceFacilityPaytoProvierZipstar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServiceFacilityPaytoProvierZipstar.setFill(Color.RED);
		textClaim2ServiceFacilityPaytoProvierZipstar.setLayoutX(830);
		textClaim2ServiceFacilityPaytoProvierZipstar.setLayoutY(247);

		textFieldClaim2ServiceFacilitypayToProviderfZip.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{if (newValue.matches("\\d*") && textFieldClaim2ServiceFacilitypayToProviderfZip.getText().length()<=9) {
					int value = Integer.parseInt(newValue);}else{textFieldClaim2ServiceFacilitypayToProviderfZip.setText(oldValue);}}catch(Exception e){}}});

		ComboBox<String> Claim2ServiceFacilityPAYTOpROviderStateCombo = new ComboBox<String>();
		Claim2ServiceFacilityPAYTOpROviderStateCombo.getItems().addAll("AA","AE","AL","AK","AP","AR","AS","AZ","CA","CO","CT","DE","DC","FL","FM","GA","GU","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MH","MI","MN","MS","MO","MP","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WV","WI","WY");
		Claim2ServiceFacilityPAYTOpROviderStateCombo.setEditable(false); 
		Claim2ServiceFacilityPAYTOpROviderStateCombo.setMinWidth(95);
		Claim2ServiceFacilityPAYTOpROviderStateCombo.setMaxWidth(95);
		Claim2ServiceFacilityPAYTOpROviderStateCombo.setMinHeight(25);
		Claim2ServiceFacilityPAYTOpROviderStateCombo.setLayoutX(625);
		Claim2ServiceFacilityPAYTOpROviderStateCombo.setLayoutY(237);
		Claim2ServiceFacilityPAYTOpROviderStateCombo.setTooltip(new Tooltip("Select State"));
		Claim2ServiceFacilityPAYTOpROviderStateCombo.setValue("Select");;
		Claim2ServiceFacilityPAYTOpROviderStateCombo.setStyle("-fx-font: 14px \"Calibri\";");

		Text textClaim2ServiceFacilityPaytoProvierStatestar= new Text();
		textClaim2ServiceFacilityPaytoProvierStatestar.setText("*");
		textClaim2ServiceFacilityPaytoProvierStatestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
		textClaim2ServiceFacilityPaytoProvierStatestar.setFill(Color.RED);
		textClaim2ServiceFacilityPaytoProvierStatestar.setLayoutX(722);
		textClaim2ServiceFacilityPaytoProvierStatestar.setLayoutY(247);
		textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
		textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
		textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
		textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);

		textFieldClaim2ServiceFacilityPaytoProvierAddressOne.textProperty().addListener((observable, oldValue, newValue) -> {
			if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
					&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
					&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
					&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
					&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
					&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
					&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
					&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
					&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
					&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
					&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
					&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
					&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
					&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
					&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
					&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
					&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
					&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
			}
			else if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
					&& textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false)
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
			}
			else
			{
				textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
				textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
			}});	textFieldClaim2ServiceFacilityPayToProviderCity.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}

				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
				}
				else
				{
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
			});
			textFieldClaim2ServiceFacilitypayToProviderfZip.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
				}
				else
				{
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
			});
			Claim2ServiceFacilityPAYTOpROviderStateCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
				if(!(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);				
				}
				else if(!(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);	
				}
				else if(!(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);	
				}
				else if(!(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
				}
				else if((Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
				}
			});

			textFieldClaim2ServiceFacilityPayToProviderAddressTwo.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& (Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(true);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityPayToProviderCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilitypayToProviderfZip.getText().isEmpty()==true
						&& (Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityPaytoProvierAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierCitystar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierZipstar.setVisible(false);
					textClaim2ServiceFacilityPaytoProvierStatestar.setVisible(false);
				}});
			Line line10 = new Line(); 
			line10.setStartX(100); 
			line10.setStartY(274); 
			line10.setEndX(1225); 
			line10.setEndY(274);
			Text textClaim3ReferringPhysicianFName = new Text();
			textClaim3ReferringPhysicianFName.setText("Referring Physician"+'\n'+"First Name");
			textClaim3ReferringPhysicianFName.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3ReferringPhysicianFName.setFill(Color.BLACK);
			textClaim3ReferringPhysicianFName.setLayoutX(100);
			textClaim3ReferringPhysicianFName.setLayoutY(293);
			TextField textFieldClaim3ReferringPhysicianFName = new TextField();
			textFieldClaim3ReferringPhysicianFName.setLayoutX(225);
			textFieldClaim3ReferringPhysicianFName.setLayoutY(283);
			textFieldClaim3ReferringPhysicianFName.setPrefWidth(200);
			textFieldClaim3ReferringPhysicianFName.setPrefHeight(25);
			textFieldClaim3ReferringPhysicianFName.setEditable(true);
			textFieldClaim3ReferringPhysicianFName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim3ReferringPhysicianFName.setTooltip(new Tooltip("Enter First Name"));
			textFieldClaim3ReferringPhysicianFName.setPromptText("First Name");
			Text textClaim3ReferringPhysicianLName = new Text();
			textClaim3ReferringPhysicianLName.setText("Referring Physician"+'\n'+"Last Name");
			textClaim3ReferringPhysicianLName.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3ReferringPhysicianLName.setFill(Color.BLACK);
			textClaim3ReferringPhysicianLName.setLayoutX(500);
			textClaim3ReferringPhysicianLName.setLayoutY(293);
			TextField textFieldClaim3ReferringPhysicianLName = new TextField();
			textFieldClaim3ReferringPhysicianLName.setLayoutX(625);
			textFieldClaim3ReferringPhysicianLName.setLayoutY(283);
			textFieldClaim3ReferringPhysicianLName.setPrefWidth(200);
			textFieldClaim3ReferringPhysicianLName.setPrefHeight(25);
			textFieldClaim3ReferringPhysicianLName.setEditable(true);
			textFieldClaim3ReferringPhysicianLName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim3ReferringPhysicianLName.setTooltip(new Tooltip("Enter Last Name"));
			textFieldClaim3ReferringPhysicianLName.setPromptText("Last Name");
			Text textClaim3ReferringPhysicianLNamestar= new Text();
			textClaim3ReferringPhysicianLNamestar.setText("*");
			textClaim3ReferringPhysicianLNamestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3ReferringPhysicianLNamestar.setFill(Color.RED);
			textClaim3ReferringPhysicianLNamestar.setLayoutX(830);
			textClaim3ReferringPhysicianLNamestar.setLayoutY(293);
			textClaim3ReferringPhysicianLNamestar.setVisible(false);

			textFieldClaim3ReferringPhysicianFName.lengthProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if (newValue.intValue() > oldValue.intValue()) {
						if (textFieldClaim3ReferringPhysicianFName.getText().length() >= 35) {
							textFieldClaim3ReferringPhysicianFName.setText(textFieldClaim3ReferringPhysicianFName.getText().substring(0, 35));
						}}}});
			textFieldClaim3ReferringPhysicianLName.lengthProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if (newValue.intValue() > oldValue.intValue()) {
						if (textFieldClaim3ReferringPhysicianLName.getText().length() >= 60) {
							textFieldClaim3ReferringPhysicianLName.setText(textFieldClaim3ReferringPhysicianLName.getText().substring(0, 60));
						}}}});

			Text textClaim3ReferringPhysicianNPI = new Text();
			textClaim3ReferringPhysicianNPI.setText("Referring Physician"+'\n'+"NPI");
			textClaim3ReferringPhysicianNPI.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3ReferringPhysicianNPI.setFill(Color.BLACK);
			textClaim3ReferringPhysicianNPI.setLayoutX(900);
			textClaim3ReferringPhysicianNPI.setLayoutY(293);

			TextField textFieldClaim3ReferringPhysicianNPI = new TextField();
			textFieldClaim3ReferringPhysicianNPI.setLayoutX(1025);
			textFieldClaim3ReferringPhysicianNPI.setLayoutY(283);
			textFieldClaim3ReferringPhysicianNPI.setPrefWidth(200);
			textFieldClaim3ReferringPhysicianNPI.setPrefHeight(25);
			textFieldClaim3ReferringPhysicianNPI.setEditable(true);
			textFieldClaim3ReferringPhysicianNPI.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim3ReferringPhysicianNPI.setTooltip(new Tooltip("Enter Referring Physician NPI"));
			textFieldClaim3ReferringPhysicianNPI.setPromptText("Referring Physician NPI");

			textFieldClaim3ReferringPhysicianFName.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim3ReferringPhysicianFName.getText().isEmpty()==false
						&& textFieldClaim3ReferringPhysicianNPI.getText().isEmpty()==false
						&& textFieldClaim3ReferringPhysicianLName.getText().isEmpty()==true)
				{
					textClaim3ReferringPhysicianLNamestar.setVisible(true);
				}
				else if(textFieldClaim3ReferringPhysicianFName.getText().isEmpty()==true
						&& textFieldClaim3ReferringPhysicianNPI.getText().isEmpty()==false
						&& textFieldClaim3ReferringPhysicianLName.getText().isEmpty()==true)
				{
					textClaim3ReferringPhysicianLNamestar.setVisible(true);
				}
				else if(textFieldClaim3ReferringPhysicianFName.getText().isEmpty()==false
						&& textFieldClaim3ReferringPhysicianNPI.getText().isEmpty()==true
						&& textFieldClaim3ReferringPhysicianLName.getText().isEmpty()==true)
				{
					textClaim3ReferringPhysicianLNamestar.setVisible(true);
				}
				else
				{
					textClaim3ReferringPhysicianLNamestar.setVisible(false);
				}
			});
			textFieldClaim3ReferringPhysicianNPI.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim3ReferringPhysicianFName.getText().isEmpty()==false
						&& textFieldClaim3ReferringPhysicianNPI.getText().isEmpty()==false
						&& textFieldClaim3ReferringPhysicianLName.getText().isEmpty()==true)
				{
					textClaim3ReferringPhysicianLNamestar.setVisible(true);
				}
				else if(textFieldClaim3ReferringPhysicianFName.getText().isEmpty()==true
						&& textFieldClaim3ReferringPhysicianNPI.getText().isEmpty()==false
						&& textFieldClaim3ReferringPhysicianLName.getText().isEmpty()==true)
				{
					textClaim3ReferringPhysicianLNamestar.setVisible(true);
				}
				else if(textFieldClaim3ReferringPhysicianFName.getText().isEmpty()==false
						&& textFieldClaim3ReferringPhysicianNPI.getText().isEmpty()==true
						&& textFieldClaim3ReferringPhysicianLName.getText().isEmpty()==true)
				{
					textClaim3ReferringPhysicianLNamestar.setVisible(true);
				}
				else
				{
					textClaim3ReferringPhysicianLNamestar.setVisible(false);
				}
			});
			textFieldClaim3ReferringPhysicianLName.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim3ReferringPhysicianFName.getText().isEmpty()==false
						&& textFieldClaim3ReferringPhysicianNPI.getText().isEmpty()==false
						&& textFieldClaim3ReferringPhysicianLName.getText().isEmpty()==true)
				{
					textClaim3ReferringPhysicianLNamestar.setVisible(true);
				}
				else if(textFieldClaim3ReferringPhysicianFName.getText().isEmpty()==true
						&& textFieldClaim3ReferringPhysicianNPI.getText().isEmpty()==false
						&& textFieldClaim3ReferringPhysicianLName.getText().isEmpty()==true)
				{
					textClaim3ReferringPhysicianLNamestar.setVisible(true);
				}
				else if(textFieldClaim3ReferringPhysicianFName.getText().isEmpty()==false
						&& textFieldClaim3ReferringPhysicianNPI.getText().isEmpty()==true
						&& textFieldClaim3ReferringPhysicianLName.getText().isEmpty()==true)
				{
					textClaim3ReferringPhysicianLNamestar.setVisible(true);
				}
				else
				{
					textClaim3ReferringPhysicianLNamestar.setVisible(false);
				}
			});
			textFieldClaim3ReferringPhysicianNPI.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, 
						String newValue) {
					try
					{
						if (newValue.matches("\\d*") && textFieldClaim3ReferringPhysicianNPI.getText().length()<=10) {
							int value = Integer.parseInt(newValue);
						} else {
							textFieldClaim3ReferringPhysicianNPI.setText(oldValue);
						}
					}
					catch(Exception e){}}});
			Text textClaim3HospitalizationforCurrentServicesFrom = new Text();
			textClaim3HospitalizationforCurrentServicesFrom.setText("Hospitalization for "+'\n'+"Current Service From");
			textClaim3HospitalizationforCurrentServicesFrom.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3HospitalizationforCurrentServicesFrom.setFill(Color.BLACK);
			textClaim3HospitalizationforCurrentServicesFrom.setLayoutX(100);
			textClaim3HospitalizationforCurrentServicesFrom.setLayoutY(333);

			DatePicker Claim3HospitalizationforCurrentServicesFromPicker = new DatePicker();
			Claim3HospitalizationforCurrentServicesFromPicker.setLayoutX(225);
			Claim3HospitalizationforCurrentServicesFromPicker.setLayoutY(323);
			Claim3HospitalizationforCurrentServicesFromPicker.setPrefWidth(200);
			Claim3HospitalizationforCurrentServicesFromPicker.setPrefHeight(25);
			Claim3HospitalizationforCurrentServicesFromPicker.setPromptText("MM/DD/YYYY");
			Claim3HospitalizationforCurrentServicesFromPicker.setTooltip(new Tooltip("Hospitalization Dates for Current Services From"));
			Claim3HospitalizationforCurrentServicesFromPicker.setEditable(false);
			Claim3HospitalizationforCurrentServicesFromPicker.setStyle("-fx-font: 14px \"Calibri\";");
			Claim3HospitalizationforCurrentServicesFromPicker.setOnAction(e ->
			{
				LocalDate date = Claim3HospitalizationforCurrentServicesFromPicker.getValue();
			});

			Text textClaim3HospitalizationforCurrentServicesTo = new Text();
			textClaim3HospitalizationforCurrentServicesTo.setText("Hospitalization for "+'\n'+"Current Service To");
			textClaim3HospitalizationforCurrentServicesTo.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3HospitalizationforCurrentServicesTo.setFill(Color.BLACK);
			textClaim3HospitalizationforCurrentServicesTo.setLayoutX(500);
			textClaim3HospitalizationforCurrentServicesTo.setLayoutY(333);

			DatePicker Claim3HospitalizationforCurrentServicesToPicker = new DatePicker();
			Claim3HospitalizationforCurrentServicesToPicker.setLayoutX(625);
			Claim3HospitalizationforCurrentServicesToPicker.setLayoutY(323);
			Claim3HospitalizationforCurrentServicesToPicker.setPrefWidth(200);
			Claim3HospitalizationforCurrentServicesToPicker.setPrefHeight(25);
			Claim3HospitalizationforCurrentServicesToPicker.setPromptText("MM/DD/YYYY");
			Claim3HospitalizationforCurrentServicesToPicker.setTooltip(new Tooltip("Hospitalization Dates for Current Services To"));
			Claim3HospitalizationforCurrentServicesToPicker.setEditable(false);
			Claim3HospitalizationforCurrentServicesToPicker.setStyle("-fx-font: 14px \"Calibri\";");
			Claim3HospitalizationforCurrentServicesToPicker.setOnAction(e ->
			{LocalDate date = Claim3HospitalizationforCurrentServicesToPicker.getValue();});
			Line line11 = new Line(); 
			line11.setStartX(100); 
			line11.setStartY(360); 
			line11.setEndX(1225); 
			line11.setEndY(360);
			Text textClaim2ServicingProviderName = new Text();
			textClaim2ServicingProviderName.setText("Servicing(Rendering)"+'\n'+"Provider Name");
			textClaim2ServicingProviderName.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServicingProviderName.setFill(Color.BLACK);
			textClaim2ServicingProviderName.setLayoutX(100);
			textClaim2ServicingProviderName.setLayoutY(380);
			TextField textFieldClaim2ServicingProviderName = new TextField();
			textFieldClaim2ServicingProviderName.setLayoutX(225);
			textFieldClaim2ServicingProviderName.setLayoutY(370);
			textFieldClaim2ServicingProviderName.setPrefWidth(200);
			textFieldClaim2ServicingProviderName.setPrefHeight(25);
			textFieldClaim2ServicingProviderName.setEditable(true);
			textFieldClaim2ServicingProviderName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServicingProviderName.setTooltip(new Tooltip("Enter Servicing (Rendering) Provider Name"));
			textFieldClaim2ServicingProviderName.setPromptText("LastName, FirstName");
			Text textClaim2ServicingProviderNamestar= new Text();
			textClaim2ServicingProviderNamestar.setText("*");
			textClaim2ServicingProviderNamestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServicingProviderNamestar.setFill(Color.RED);
			textClaim2ServicingProviderNamestar.setLayoutX(430);
			textClaim2ServicingProviderNamestar.setLayoutY(380);
			textClaim2ServicingProviderNamestar.setVisible(false);
			textFieldClaim2ServicingProviderName.lengthProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if (newValue.intValue() > oldValue.intValue()) {
						if (textFieldClaim2ServicingProviderName.getText().length() >= 95) {
							textFieldClaim2ServicingProviderName.setText(textFieldClaim2ServicingProviderName.getText().substring(0, 95));
						}}}});

			Text textClaim2ServicingProviderSigned = new Text();
			textClaim2ServicingProviderSigned.setText("Signed ?");
			textClaim2ServicingProviderSigned.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServicingProviderSigned.setFill(Color.BLACK);
			textClaim2ServicingProviderSigned.setLayoutX(500);
			textClaim2ServicingProviderSigned.setLayoutY(388);

			ComboBox<String> Claim2ServicingProviderSignedCombo= new ComboBox<String>();
			Claim2ServicingProviderSignedCombo.getItems().addAll("Yes","No");
			Claim2ServicingProviderSignedCombo.setEditable(false); 
			Claim2ServicingProviderSignedCombo.setMinWidth(200);
			Claim2ServicingProviderSignedCombo.setMinHeight(25);
			Claim2ServicingProviderSignedCombo.setLayoutX(625);
			Claim2ServicingProviderSignedCombo.setLayoutY(370);
			Claim2ServicingProviderSignedCombo.setTooltip(new Tooltip("Select Signed Status"));
			Claim2ServicingProviderSignedCombo.getSelectionModel().select(0);
			Claim2ServicingProviderSignedCombo.setStyle("-fx-font: 14px \"Calibri\";");
			Text textClaim2ServicingProviderSignedDate = new Text();
			textClaim2ServicingProviderSignedDate.setText("Signed Date");
			textClaim2ServicingProviderSignedDate.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServicingProviderSignedDate.setFill(Color.BLACK);
			textClaim2ServicingProviderSignedDate.setLayoutX(900);
			textClaim2ServicingProviderSignedDate.setLayoutY(388);

			DatePicker Claim2ServicingProviderSignedDatePicker = new DatePicker();
			Claim2ServicingProviderSignedDatePicker.setLayoutX(1025);
			Claim2ServicingProviderSignedDatePicker.setLayoutY(370);
			Claim2ServicingProviderSignedDatePicker.setPrefWidth(200);
			Claim2ServicingProviderSignedDatePicker.setPrefHeight(25);
			Claim2ServicingProviderSignedDatePicker.setPromptText("MM/DD/YYYY");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
			LocalDate localDate = LocalDate.now();
			Claim2ServicingProviderSignedDatePicker.setValue(localDate);
			Claim2ServicingProviderSignedDatePicker.setTooltip(new Tooltip("Servicing Provider Signed Date"));
			Claim2ServicingProviderSignedDatePicker.setEditable(false);
			Claim2ServicingProviderSignedDatePicker.setStyle("-fx-font: 14px \"Calibri\";");

			Claim2ServicingProviderSignedDatePicker.setOnAction(e ->
			{
				LocalDate date = Claim2ServicingProviderSignedDatePicker.getValue();
			});


			Text textClaim2ServicingProviderNPI = new Text();
			textClaim2ServicingProviderNPI.setText("NPI");
			textClaim2ServicingProviderNPI.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServicingProviderNPI.setFill(Color.BLACK);
			textClaim2ServicingProviderNPI.setLayoutX(500);
			textClaim2ServicingProviderNPI.setLayoutY(428);


			TextField textFieldClaim2ServicingProviderNPI = new TextField();
			textFieldClaim2ServicingProviderNPI.setLayoutX(625);
			textFieldClaim2ServicingProviderNPI.setLayoutY(410);
			textFieldClaim2ServicingProviderNPI.setPrefWidth(200);
			textFieldClaim2ServicingProviderNPI.setPrefHeight(25);
			textFieldClaim2ServicingProviderNPI.setEditable(true);
			textFieldClaim2ServicingProviderNPI.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServicingProviderNPI.setTooltip(new Tooltip("Enter Servicing (Rendering) Provider NPI"));
			textFieldClaim2ServicingProviderNPI.setPromptText("NPI");

			textFieldClaim2ServicingProviderNPI.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, 
						String newValue) {
					try
					{
						if (newValue.matches("\\d*") && textFieldClaim2ServicingProviderNPI.getText().length()<=10) {
							int value = Integer.parseInt(newValue);
						} else {
							textFieldClaim2ServicingProviderNPI.setText(oldValue);
						}
					}
					catch(Exception e)
					{

					}
				}
			});

			Text textClaim2ServicingProviderPVN = new Text();
			textClaim2ServicingProviderPVN.setText("PVN");
			textClaim2ServicingProviderPVN.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServicingProviderPVN.setFill(Color.BLACK);
			textClaim2ServicingProviderPVN.setLayoutX(900);
			textClaim2ServicingProviderPVN.setLayoutY(428);
			TextField textFieldClaim2ServicingProviderPVN = new TextField();
			textFieldClaim2ServicingProviderPVN.setLayoutX(1025);
			textFieldClaim2ServicingProviderPVN.setLayoutY(410);
			textFieldClaim2ServicingProviderPVN.setPrefWidth(200);
			textFieldClaim2ServicingProviderPVN.setPrefHeight(25);
			textFieldClaim2ServicingProviderPVN.setEditable(true);
			textFieldClaim2ServicingProviderPVN.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServicingProviderPVN.setTooltip(new Tooltip("Enter Servicing (Rendering) Provider PVN"));
			textFieldClaim2ServicingProviderPVN.setPromptText("PVN");
			textFieldClaim2ServicingProviderNPI.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServicingProviderNPI.getText().isEmpty()==false
						&& textFieldClaim2ServicingProviderPVN.getText().isEmpty()==false
						&& textFieldClaim2ServicingProviderName.getText().isEmpty()==true)
				{
					textClaim2ServicingProviderNamestar.setVisible(true);
				}
				else if(textFieldClaim2ServicingProviderNPI.getText().isEmpty()==true
						&& textFieldClaim2ServicingProviderPVN.getText().isEmpty()==false
						&& textFieldClaim2ServicingProviderName.getText().isEmpty()==true)
				{
					textClaim2ServicingProviderNamestar.setVisible(true);
				}
				else if(textFieldClaim2ServicingProviderNPI.getText().isEmpty()==false
						&& textFieldClaim2ServicingProviderPVN.getText().isEmpty()==true
						&& textFieldClaim2ServicingProviderName.getText().isEmpty()==true)
				{
					textClaim2ServicingProviderNamestar.setVisible(true);
				}
				else
				{
					textClaim2ServicingProviderNamestar.setVisible(false);
				}
			});

			textFieldClaim2ServicingProviderPVN.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServicingProviderNPI.getText().isEmpty()==false
						&& textFieldClaim2ServicingProviderPVN.getText().isEmpty()==false
						&& textFieldClaim2ServicingProviderName.getText().isEmpty()==true)
				{
					textClaim2ServicingProviderNamestar.setVisible(true);
				}
				else if(textFieldClaim2ServicingProviderNPI.getText().isEmpty()==true
						&& textFieldClaim2ServicingProviderPVN.getText().isEmpty()==false
						&& textFieldClaim2ServicingProviderName.getText().isEmpty()==true)
				{
					textClaim2ServicingProviderNamestar.setVisible(true);
				}
				else if(textFieldClaim2ServicingProviderNPI.getText().isEmpty()==false
						&& textFieldClaim2ServicingProviderPVN.getText().isEmpty()==true
						&& textFieldClaim2ServicingProviderName.getText().isEmpty()==true)
				{
					textClaim2ServicingProviderNamestar.setVisible(true);
				}
				else
				{
					textClaim2ServicingProviderNamestar.setVisible(false);
				}
			});

			textFieldClaim2ServicingProviderName.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServicingProviderNPI.getText().isEmpty()==false
						&& textFieldClaim2ServicingProviderPVN.getText().isEmpty()==false
						&& textFieldClaim2ServicingProviderName.getText().isEmpty()==true)
				{
					textClaim2ServicingProviderNamestar.setVisible(true);
				}
				else if(textFieldClaim2ServicingProviderNPI.getText().isEmpty()==true
						&& textFieldClaim2ServicingProviderPVN.getText().isEmpty()==false
						&& textFieldClaim2ServicingProviderName.getText().isEmpty()==true)
				{
					textClaim2ServicingProviderNamestar.setVisible(true);
				}
				else if(textFieldClaim2ServicingProviderNPI.getText().isEmpty()==false
						&& textFieldClaim2ServicingProviderPVN.getText().isEmpty()==true
						&& textFieldClaim2ServicingProviderName.getText().isEmpty()==true)
				{
					textClaim2ServicingProviderNamestar.setVisible(true);
				}
				else
				{
					textClaim2ServicingProviderNamestar.setVisible(false);
				}});

			Line line12 = new Line(); 
			line12.setStartX(100); 
			line12.setStartY(447); 
			line12.setEndX(1225); 
			line12.setEndY(447);
			Text textClaim2ServiceFacilityName= new Text();
			textClaim2ServiceFacilityName.setText("Service"+'\n'+"Facility Name");
			textClaim2ServiceFacilityName.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityName.setFill(Color.BLACK);
			textClaim2ServiceFacilityName.setLayoutX(100);
			textClaim2ServiceFacilityName.setLayoutY(477);

			TextField textFieldClaim2ServiceFacilityName = new TextField();
			textFieldClaim2ServiceFacilityName.setLayoutX(225);
			textFieldClaim2ServiceFacilityName.setLayoutY(467);
			textFieldClaim2ServiceFacilityName.setPrefWidth(200);
			textFieldClaim2ServiceFacilityName.setPrefHeight(25);
			textFieldClaim2ServiceFacilityName.setEditable(true);
			textFieldClaim2ServiceFacilityName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityName.setTooltip(new Tooltip("Enter Service Facility Name"));
			textFieldClaim2ServiceFacilityName.setPromptText("Service Facility Name");

			Text textClaim2ServiceFacilityNamestar= new Text();
			textClaim2ServiceFacilityNamestar.setText("*");
			textClaim2ServiceFacilityNamestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityNamestar.setFill(Color.RED);
			textClaim2ServiceFacilityNamestar.setLayoutX(430);
			textClaim2ServiceFacilityNamestar.setLayoutY(477);

			textFieldClaim2ServiceFacilityName.lengthProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if (newValue.intValue() > oldValue.intValue()) {
						if (textFieldClaim2ServiceFacilityName.getText().length() >= 95) {
							textFieldClaim2ServiceFacilityName.setText(textFieldClaim2ServiceFacilityName.getText().substring(0, 95));
						}}}});

			Text textClaim2ServiceFacilityAddress= new Text();
			textClaim2ServiceFacilityAddress.setText("Service"+'\n'+"Facility Address");
			textClaim2ServiceFacilityAddress.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAddress.setFill(Color.BLACK);
			textClaim2ServiceFacilityAddress.setLayoutX(500);
			textClaim2ServiceFacilityAddress.setLayoutY(477);

			TextField textFieldClaim2ServiceFacilityAddressOne = new TextField();
			textFieldClaim2ServiceFacilityAddressOne.setLayoutX(625);
			textFieldClaim2ServiceFacilityAddressOne.setLayoutY(450);
			textFieldClaim2ServiceFacilityAddressOne.setPrefWidth(200);
			textFieldClaim2ServiceFacilityAddressOne.setPrefHeight(25);
			textFieldClaim2ServiceFacilityAddressOne.setEditable(true);
			textFieldClaim2ServiceFacilityAddressOne.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityAddressOne.setTooltip(new Tooltip("Enter Address Line 1"));
			textFieldClaim2ServiceFacilityAddressOne.setPromptText("Address Line 1");

			Text textClaim2ServiceFacilityAddressOnestar= new Text();
			textClaim2ServiceFacilityAddressOnestar.setText("*");
			textClaim2ServiceFacilityAddressOnestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAddressOnestar.setFill(Color.RED);
			textClaim2ServiceFacilityAddressOnestar.setLayoutX(830);
			textClaim2ServiceFacilityAddressOnestar.setLayoutY(460);

			textFieldClaim2ServiceFacilityAddressOne.lengthProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if (newValue.intValue() > oldValue.intValue()) {
						if (textFieldClaim2ServiceFacilityAddressOne.getText().length() >= 55) {
							textFieldClaim2ServiceFacilityAddressOne.setText(textFieldClaim2ServiceFacilityAddressOne.getText().substring(0, 55));
						}
					}
				}
			});

			TextField textFieldClaim2ServiceFacilityAddressTwo = new TextField();
			textFieldClaim2ServiceFacilityAddressTwo.setLayoutX(625);
			textFieldClaim2ServiceFacilityAddressTwo.setLayoutY(480);
			textFieldClaim2ServiceFacilityAddressTwo.setPrefWidth(200);
			textFieldClaim2ServiceFacilityAddressTwo.setPrefHeight(25);
			textFieldClaim2ServiceFacilityAddressTwo.setEditable(true);
			textFieldClaim2ServiceFacilityAddressTwo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityAddressTwo.setTooltip(new Tooltip("Enter Address Line 2"));
			textFieldClaim2ServiceFacilityAddressTwo.setPromptText("Address Line 2");



			textFieldClaim2ServiceFacilityAddressTwo.lengthProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if (newValue.intValue() > oldValue.intValue()) {
						if (textFieldClaim2ServiceFacilityAddressTwo.getText().length() >= 55) {
							textFieldClaim2ServiceFacilityAddressTwo.setText(textFieldClaim2ServiceFacilityAddressTwo.getText().substring(0, 55));
						}}}});

			Text textClaim2ServiceFacilityCity= new Text();
			textClaim2ServiceFacilityCity.setText("City");
			textClaim2ServiceFacilityCity.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityCity.setFill(Color.BLACK);
			textClaim2ServiceFacilityCity.setLayoutX(900);
			textClaim2ServiceFacilityCity.setLayoutY(470);

			TextField textFieldClaim2ServiceFacilityCity = new TextField();
			textFieldClaim2ServiceFacilityCity.setLayoutX(1025);
			textFieldClaim2ServiceFacilityCity.setLayoutY(450);
			textFieldClaim2ServiceFacilityCity.setPrefWidth(200);
			textFieldClaim2ServiceFacilityCity.setPrefHeight(25);
			textFieldClaim2ServiceFacilityCity.setEditable(true);
			textFieldClaim2ServiceFacilityCity.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityCity.setTooltip(new Tooltip("Enter City"));
			textFieldClaim2ServiceFacilityCity.setPromptText("City");

			Text textClaim2ServiceFacilityCitystar= new Text();
			textClaim2ServiceFacilityCitystar.setText("*");
			textClaim2ServiceFacilityCitystar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityCitystar.setFill(Color.RED);
			textClaim2ServiceFacilityCitystar.setLayoutX(1230);
			textClaim2ServiceFacilityCitystar.setLayoutY(460);

			textFieldClaim2ServiceFacilityCity.lengthProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if (newValue.intValue() > oldValue.intValue()) {
						if (textFieldClaim2ServiceFacilityCity.getText().length() >= 30) {
							textFieldClaim2ServiceFacilityCity.setText(textFieldClaim2ServiceFacilityCity.getText().substring(0, 30));
						}}}});

			Text textClaim2ServiceFacilityStateZIp= new Text();
			textClaim2ServiceFacilityStateZIp.setText("State / Zip");
			textClaim2ServiceFacilityStateZIp.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityStateZIp.setFill(Color.BLACK);
			textClaim2ServiceFacilityStateZIp.setLayoutX(900);
			textClaim2ServiceFacilityStateZIp.setLayoutY(500);

			TextField textFieldClaim2ServiceFacilityZip = new TextField();
			textFieldClaim2ServiceFacilityZip.setLayoutX(1130);
			textFieldClaim2ServiceFacilityZip.setLayoutY(480);
			textFieldClaim2ServiceFacilityZip.setPrefWidth(95);
			textFieldClaim2ServiceFacilityZip.setPrefHeight(25);
			textFieldClaim2ServiceFacilityZip.setEditable(true);
			textFieldClaim2ServiceFacilityZip.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityZip.setTooltip(new Tooltip("Enter Zip Code"));
			textFieldClaim2ServiceFacilityZip.setPromptText("Zip Code");

			Text textClaim2ServiceFacilityZipstar= new Text();
			textClaim2ServiceFacilityZipstar.setText("*");
			textClaim2ServiceFacilityZipstar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityZipstar.setFill(Color.RED);
			textClaim2ServiceFacilityZipstar.setLayoutX(1230);
			textClaim2ServiceFacilityZipstar.setLayoutY(490);

			textFieldClaim2ServiceFacilityZip.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, 
						String newValue) {
					try
					{
						if (newValue.matches("\\d*") && textFieldClaim2ServiceFacilityZip.getText().length()<=9) {
							int value = Integer.parseInt(newValue);
						} else {
							textFieldClaim2ServiceFacilityZip.setText(oldValue);
						}
					}
					catch(Exception e){}}});

			ComboBox<String> Claim2ServiceFacilityStateCombo = new ComboBox<String>();
			Claim2ServiceFacilityStateCombo.getItems().addAll("AA","AE","AL","AK","AP","AR","AS","AZ","CA","CO","CT","DE","DC","FL","FM","GA","GU","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MH","MI","MN","MS","MO","MP","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WV","WI","WY");
			Claim2ServiceFacilityStateCombo.setEditable(false); 
			Claim2ServiceFacilityStateCombo.setMinWidth(95);
			Claim2ServiceFacilityStateCombo.setMaxWidth(95);
			Claim2ServiceFacilityStateCombo.setMinHeight(25);
			Claim2ServiceFacilityStateCombo.setLayoutX(1025);
			Claim2ServiceFacilityStateCombo.setLayoutY(480);
			Claim2ServiceFacilityStateCombo.setTooltip(new Tooltip("Select State"));
			Claim2ServiceFacilityStateCombo.setValue("Select");;
			Claim2ServiceFacilityStateCombo.setStyle("-fx-font: 14px \"Calibri\";");

			Text textClaim2ServiceFacilityStatestar= new Text();
			textClaim2ServiceFacilityStatestar.setText("*");
			textClaim2ServiceFacilityStatestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityStatestar.setFill(Color.RED);
			textClaim2ServiceFacilityStatestar.setLayoutX(1122);
			textClaim2ServiceFacilityStatestar.setLayoutY(490);
			Text textClaim2ServiceFacilityNPI= new Text();
			textClaim2ServiceFacilityNPI.setText("Service"+'\n'+"Facility NPI");
			textClaim2ServiceFacilityNPI.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityNPI.setFill(Color.BLACK);
			textClaim2ServiceFacilityNPI.setLayoutX(100);
			textClaim2ServiceFacilityNPI.setLayoutY(535);

			TextField textFieldClaim2ServiceFacilityNPILoc = new TextField();
			textFieldClaim2ServiceFacilityNPILoc.setLayoutX(225);
			textFieldClaim2ServiceFacilityNPILoc.setLayoutY(525);
			textFieldClaim2ServiceFacilityNPILoc.setPrefWidth(200);
			textFieldClaim2ServiceFacilityNPILoc.setPrefHeight(25);
			textFieldClaim2ServiceFacilityNPILoc.setEditable(true);
			textFieldClaim2ServiceFacilityNPILoc.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityNPILoc.setTooltip(new Tooltip("Enter Service Facility NPI"));
			textFieldClaim2ServiceFacilityNPILoc.setPromptText("Service Facility NPI");

			textFieldClaim2ServiceFacilityNPILoc.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, 
						String newValue) {
					try
					{
						if (newValue.matches("\\d*") && textFieldClaim2ServiceFacilityNPILoc.getText().length()<=10) {
							int value = Integer.parseInt(newValue);
						} else {
							textFieldClaim2ServiceFacilityNPILoc.setText(oldValue);
						}
					}
					catch(Exception e)
					{

					}
				}
			});

			textClaim2ServiceFacilityNamestar.setVisible(false);
			textClaim2ServiceFacilityAddressOnestar.setVisible(false);
			textClaim2ServiceFacilityCitystar.setVisible(false);
			textClaim2ServiceFacilityZipstar.setVisible(false);
			textClaim2ServiceFacilityStatestar.setVisible(false);

			textFieldClaim2ServiceFacilityName.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilityName.getText().isEmpty()==false 
						&&textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& (Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityNPILoc.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityNamestar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityName.getText().isEmpty()==true && 
						(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						|| textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						|| textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						|| !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
						||textFieldClaim2ServiceFacilityNPILoc.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityNamestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityName.getText().isEmpty()==true 
						&&textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& (Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityNPILoc.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityNamestar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityName.getText().isEmpty()==false && 
						(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						|| textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						|| textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						|| !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
						||textFieldClaim2ServiceFacilityNPILoc.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityNamestar.setVisible(false);
				}
				else
				{
					textClaim2ServiceFacilityNamestar.setVisible(false);
				}
			});
			textFieldClaim2ServiceFacilityAddressOne.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilityName.getText().isEmpty()==true && textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false )
				{
					textClaim2ServiceFacilityNamestar.setVisible(true);
				}
				if(textFieldClaim2ServiceFacilityName.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& (textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						|| textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						|| !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
						||textFieldClaim2ServiceFacilityNPILoc.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityNamestar.setVisible(true);
				}
				if(textFieldClaim2ServiceFacilityName.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& (textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityNPILoc.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityNamestar.setVisible(false);
				}

				if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityNPILoc.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
				}
				else
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
			});
			textFieldClaim2ServiceFacilityCity.textProperty().addListener((observable, oldValue, newValue) -> {

				if(textFieldClaim2ServiceFacilityName.getText().isEmpty()==true && 
						textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false )
				{
					textClaim2ServiceFacilityNamestar.setVisible(true);
				}
				if(textFieldClaim2ServiceFacilityName.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true 
						&& (textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						|| textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						|| !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
						||textFieldClaim2ServiceFacilityNPILoc.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityNamestar.setVisible(true);
				}
				if(textFieldClaim2ServiceFacilityName.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true 
						&& (textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityNPILoc.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityNamestar.setVisible(false);
				}

				if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				//true address one
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}

				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityCitystar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityNPILoc.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityCitystar.setVisible(true);
				}
				else
				{
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
			});
			textFieldClaim2ServiceFacilityZip.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityZipstar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityNPILoc.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityZipstar.setVisible(true);
				}
				else
				{
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}});
			/////////////////////////////////
			Claim2ServiceFacilityStateCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
				if(!(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityStatestar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(true);				
				}
				else if(!(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityStatestar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(true);	
				}
				else if(!(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityStatestar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityStatestar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(true);	
				}
				else if(!(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityStatestar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityStatestar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityStatestar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityStatestar.setVisible(false);
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(true);
				}
			});


			textFieldClaim2ServiceFacilityAddressTwo.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1
						&& textFieldClaim2ServiceFacilityName.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(true);
					textClaim2ServiceFacilityNamestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				//true address one
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& (Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityCitystar.setVisible(true);
					textClaim2ServiceFacilityZipstar.setVisible(true);
					textClaim2ServiceFacilityStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityZip.getText().isEmpty()==true
						&& (Claim2ServiceFacilityStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityCitystar.setVisible(false);
					textClaim2ServiceFacilityZipstar.setVisible(false);
					textClaim2ServiceFacilityStatestar.setVisible(false);
				}
			});
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			Text textClaim2ServiceFacilityAmulancePickupAddress= new Text();
			textClaim2ServiceFacilityAmulancePickupAddress.setText("Ambulance"+'\n'+"Pickup Location");
			textClaim2ServiceFacilityAmulancePickupAddress.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmulancePickupAddress.setFill(Color.BLACK);
			textClaim2ServiceFacilityAmulancePickupAddress.setLayoutX(500);
			textClaim2ServiceFacilityAmulancePickupAddress.setLayoutY(535);

			TextField textFieldClaim2ServiceFacilityAmbulancePickupAddressOne = new TextField();
			textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.setLayoutX(625);
			textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.setLayoutY(510);
			textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.setPrefWidth(200);
			textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.setPrefHeight(25);
			textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.setEditable(true);
			textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.setTooltip(new Tooltip("Enter Address Line 1"));
			textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.setPromptText("Address Line 1");

			Text textClaim2ServiceFacilityAmbulancePickupAddressOnestar= new Text();
			textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setText("*");
			textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setFill(Color.RED);
			textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setLayoutX(830);
			textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setLayoutY(520);

			textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.lengthProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if (newValue.intValue() > oldValue.intValue()) {
						if (textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().length() >= 55) {
							textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.setText(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().substring(0, 55));
						}
					}
				}
			});
			TextField textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo = new TextField();
			textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.setLayoutX(625);
			textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.setLayoutY(540);
			textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.setPrefWidth(200);
			textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.setPrefHeight(25);
			textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.setEditable(true);
			textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.setTooltip(new Tooltip("Enter Address Line 2"));
			textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.setPromptText("Address Line 2");
			textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.lengthProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,Number oldValue, Number newValue) {	if (newValue.intValue() > oldValue.intValue()) {if (textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().length() >= 55) {
					textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.setText(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().substring(0, 55));
				}}}});

			Text textClaim2ServiceFacilityAmbulancepickupCity= new Text();
			textClaim2ServiceFacilityAmbulancepickupCity.setText("City");
			textClaim2ServiceFacilityAmbulancepickupCity.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmbulancepickupCity.setFill(Color.BLACK);
			textClaim2ServiceFacilityAmbulancepickupCity.setLayoutX(900);
			textClaim2ServiceFacilityAmbulancepickupCity.setLayoutY(530);

			TextField textFieldClaim2ServiceFacilityAmbulancepickupCity = new TextField();
			textFieldClaim2ServiceFacilityAmbulancepickupCity.setLayoutX(1025);
			textFieldClaim2ServiceFacilityAmbulancepickupCity.setLayoutY(510);
			textFieldClaim2ServiceFacilityAmbulancepickupCity.setPrefWidth(200);
			textFieldClaim2ServiceFacilityAmbulancepickupCity.setPrefHeight(25);
			textFieldClaim2ServiceFacilityAmbulancepickupCity.setEditable(true);
			textFieldClaim2ServiceFacilityAmbulancepickupCity.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityAmbulancepickupCity.setTooltip(new Tooltip("Enter City"));
			textFieldClaim2ServiceFacilityAmbulancepickupCity.setPromptText("City");


			Text textClaim2ServiceFacilityAmbulancePickupCitystar= new Text();
			textClaim2ServiceFacilityAmbulancePickupCitystar.setText("*");
			textClaim2ServiceFacilityAmbulancePickupCitystar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmbulancePickupCitystar.setFill(Color.RED);
			textClaim2ServiceFacilityAmbulancePickupCitystar.setLayoutX(1230);
			textClaim2ServiceFacilityAmbulancePickupCitystar.setLayoutY(520);

			textFieldClaim2ServiceFacilityAmbulancepickupCity.lengthProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if (newValue.intValue() > oldValue.intValue()) {
						// Check if the new character is greater than LIMIT
						if (textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().length() >= 30) {
							textFieldClaim2ServiceFacilityAmbulancepickupCity.setText(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().substring(0, 30));
						}
					}
				}
			});

			Text textClaim2ServiceFacilityAmbulancepickupStateZIp= new Text();
			textClaim2ServiceFacilityAmbulancepickupStateZIp.setText("State / Zip");
			textClaim2ServiceFacilityAmbulancepickupStateZIp.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmbulancepickupStateZIp.setFill(Color.BLACK);
			textClaim2ServiceFacilityAmbulancepickupStateZIp.setLayoutX(900);
			textClaim2ServiceFacilityAmbulancepickupStateZIp.setLayoutY(560);

			TextField textFieldClaim2ServiceFacilityAmbulancepickupZip = new TextField();
			textFieldClaim2ServiceFacilityAmbulancepickupZip.setLayoutX(1130);
			textFieldClaim2ServiceFacilityAmbulancepickupZip.setLayoutY(540);
			textFieldClaim2ServiceFacilityAmbulancepickupZip.setPrefWidth(95);
			textFieldClaim2ServiceFacilityAmbulancepickupZip.setPrefHeight(25);
			textFieldClaim2ServiceFacilityAmbulancepickupZip.setEditable(true);
			textFieldClaim2ServiceFacilityAmbulancepickupZip.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityAmbulancepickupZip.setTooltip(new Tooltip("Enter Zip Code"));
			textFieldClaim2ServiceFacilityAmbulancepickupZip.setPromptText("Zip Code");
			Text textClaim2ServiceFacilityAmbulancePickupZipstar= new Text();
			textClaim2ServiceFacilityAmbulancePickupZipstar.setText("*");
			textClaim2ServiceFacilityAmbulancePickupZipstar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmbulancePickupZipstar.setFill(Color.RED);
			textClaim2ServiceFacilityAmbulancePickupZipstar.setLayoutX(1230);
			textClaim2ServiceFacilityAmbulancePickupZipstar.setLayoutY(550);

			textFieldClaim2ServiceFacilityAmbulancepickupZip.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, 
						String newValue) {
					try
					{
						if (newValue.matches("\\d*") && textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().length()<=9) {
							int value = Integer.parseInt(newValue);
						} else {
							textFieldClaim2ServiceFacilityAmbulancepickupZip.setText(oldValue);
						}
					}
					catch(Exception e)
					{

					}
				}
			});

			ComboBox<String> Claim2ServiceFacilityAmbulancepickupStateCombo = new ComboBox<String>();
			Claim2ServiceFacilityAmbulancepickupStateCombo.getItems().addAll("AA","AE","AL","AK","AP","AR","AS","AZ","CA","CO","CT","DE","DC","FL","FM","GA","GU","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MH","MI","MN","MS","MO","MP","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WV","WI","WY");
			Claim2ServiceFacilityAmbulancepickupStateCombo.setEditable(false); 
			Claim2ServiceFacilityAmbulancepickupStateCombo.setMinWidth(95);
			Claim2ServiceFacilityAmbulancepickupStateCombo.setMaxWidth(95);
			Claim2ServiceFacilityAmbulancepickupStateCombo.setMinHeight(25);
			Claim2ServiceFacilityAmbulancepickupStateCombo.setLayoutX(1025);
			Claim2ServiceFacilityAmbulancepickupStateCombo.setLayoutY(540);
			Claim2ServiceFacilityAmbulancepickupStateCombo.setTooltip(new Tooltip("Select State"));
			Claim2ServiceFacilityAmbulancepickupStateCombo.setValue("Select");;
			Claim2ServiceFacilityAmbulancepickupStateCombo.setStyle("-fx-font: 14px \"Calibri\";");

			Text textClaim2ServiceFacilityAmbulancePickupStatestar= new Text();
			textClaim2ServiceFacilityAmbulancePickupStatestar.setText("*");
			textClaim2ServiceFacilityAmbulancePickupStatestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmbulancePickupStatestar.setFill(Color.RED);
			textClaim2ServiceFacilityAmbulancePickupStatestar.setLayoutX(1122);
			textClaim2ServiceFacilityAmbulancePickupStatestar.setLayoutY(550);

			textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
			textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
			textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
			textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);


			textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				//true address one
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
				}
				else
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
			});
			///////////////////////////////////////////////////////////////////////////////////////////////////

			textFieldClaim2ServiceFacilityAmbulancepickupCity.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				//true address one
				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}

				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
				}
				else
				{
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
			});

			textFieldClaim2ServiceFacilityAmbulancepickupZip.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				//true address one
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
				}
				else
				{
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}

			});
			///////////////////////////////////////////////////////////////////////////////////////////////////
			Claim2ServiceFacilityAmbulancepickupStateCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
				if(!(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);				
				}
				else if(!(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);	
				}
				else if(!(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);	
				}
				else if(!(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
				}
			});

			textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				//true address one
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& (Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancepickupCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulancepickupZip.getText().isEmpty()==true
						&& (Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulancePickupAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulancePickupStatestar.setVisible(false);
				}
			});
			///////////////////////////////////////////////////////////////////////////////////////////////////

			//////////////////////////////////////////////////////////////////
			Text textClaim2ServiceFacilityAmbulanceDropoffFacilityName= new Text();
			textClaim2ServiceFacilityAmbulanceDropoffFacilityName.setText("Ambulance Drop"+'\n'+"Off Facility Name");
			textClaim2ServiceFacilityAmbulanceDropoffFacilityName.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmbulanceDropoffFacilityName.setFill(Color.BLACK);
			textClaim2ServiceFacilityAmbulanceDropoffFacilityName.setLayoutX(100);
			textClaim2ServiceFacilityAmbulanceDropoffFacilityName.setLayoutY(593);

			TextField textFieldClaim2ServiceFacilityAmbulanceDropoffFacilityName = new TextField();
			textFieldClaim2ServiceFacilityAmbulanceDropoffFacilityName.setLayoutX(225);
			textFieldClaim2ServiceFacilityAmbulanceDropoffFacilityName.setLayoutY(583);
			textFieldClaim2ServiceFacilityAmbulanceDropoffFacilityName.setPrefWidth(200);
			textFieldClaim2ServiceFacilityAmbulanceDropoffFacilityName.setPrefHeight(25);
			textFieldClaim2ServiceFacilityAmbulanceDropoffFacilityName.setEditable(true);
			textFieldClaim2ServiceFacilityAmbulanceDropoffFacilityName.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityAmbulanceDropoffFacilityName.setTooltip(new Tooltip("Enter Ambulance Drop-off Facility Name"));
			textFieldClaim2ServiceFacilityAmbulanceDropoffFacilityName.setPromptText("Ambulance Drop-off Facility Name");

			textFieldClaim2ServiceFacilityAmbulanceDropoffFacilityName.lengthProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if (newValue.intValue() > oldValue.intValue()) {
						// Check if the new character is greater than LIMIT
						if (textFieldClaim2ServiceFacilityAmbulanceDropoffFacilityName.getText().length() >= 95) {
							textFieldClaim2ServiceFacilityAmbulanceDropoffFacilityName.setText(textFieldClaim2ServiceFacilityAmbulanceDropoffFacilityName.getText().substring(0, 95));
						}
					}
				}
			});

			Text textClaim2ServiceFacilityAmulancedropoffAddress= new Text();
			textClaim2ServiceFacilityAmulancedropoffAddress.setText("Ambulance"+'\n'+"Drop-off Location");
			textClaim2ServiceFacilityAmulancedropoffAddress.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmulancedropoffAddress.setFill(Color.BLACK);
			textClaim2ServiceFacilityAmulancedropoffAddress.setLayoutX(500);
			textClaim2ServiceFacilityAmulancedropoffAddress.setLayoutY(593);

			TextField textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne = new TextField();
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.setLayoutX(625);
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.setLayoutY(570);
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.setPrefWidth(200);
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.setPrefHeight(25);
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.setEditable(true);
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.setTooltip(new Tooltip("Enter Address Line 1"));
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.setPromptText("Address Line 1");

			Text textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar= new Text();
			textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setText("*");
			textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setFill(Color.RED);
			textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setLayoutX(830);
			textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setLayoutY(580);

			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.lengthProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if (newValue.intValue() > oldValue.intValue()) {
						// Check if the new character is greater than LIMIT
						if (textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().length() >= 55) {
							textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.setText(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().substring(0, 55));
						}
					}
				}
			});
			TextField textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo = new TextField();
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.setLayoutX(625);
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.setLayoutY(600);
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.setPrefWidth(200);
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.setPrefHeight(25);
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.setEditable(true);
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.setTooltip(new Tooltip("Enter Address Line 2"));
			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.setPromptText("Address Line 2");


			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.lengthProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if (newValue.intValue() > oldValue.intValue()) {
						// Check if the new character is greater than LIMIT
						if (textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().length() >= 55) {
							textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.setText(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().substring(0, 55));
						}
					}
				}
			});

			Text textClaim2ServiceFacilityAmbulanceDropoffCity= new Text();
			textClaim2ServiceFacilityAmbulanceDropoffCity.setText("City");
			textClaim2ServiceFacilityAmbulanceDropoffCity.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmbulanceDropoffCity.setFill(Color.BLACK);
			textClaim2ServiceFacilityAmbulanceDropoffCity.setLayoutX(900);
			textClaim2ServiceFacilityAmbulanceDropoffCity.setLayoutY(590);

			TextField textFieldClaim2ServiceFacilityAmbulancedropoffCity = new TextField();
			textFieldClaim2ServiceFacilityAmbulancedropoffCity.setLayoutX(1025);
			textFieldClaim2ServiceFacilityAmbulancedropoffCity.setLayoutY(570);
			textFieldClaim2ServiceFacilityAmbulancedropoffCity.setPrefWidth(200);
			textFieldClaim2ServiceFacilityAmbulancedropoffCity.setPrefHeight(25);
			textFieldClaim2ServiceFacilityAmbulancedropoffCity.setEditable(true);
			textFieldClaim2ServiceFacilityAmbulancedropoffCity.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityAmbulancedropoffCity.setTooltip(new Tooltip("Enter City"));
			textFieldClaim2ServiceFacilityAmbulancedropoffCity.setPromptText("City");


			Text textClaim2ServiceFacilityAmbulanceDropoffCitystar= new Text();
			textClaim2ServiceFacilityAmbulanceDropoffCitystar.setText("*");
			textClaim2ServiceFacilityAmbulanceDropoffCitystar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmbulanceDropoffCitystar.setFill(Color.RED);
			textClaim2ServiceFacilityAmbulanceDropoffCitystar.setLayoutX(1230);
			textClaim2ServiceFacilityAmbulanceDropoffCitystar.setLayoutY(580);

			textFieldClaim2ServiceFacilityAmbulancedropoffCity.lengthProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> observable,
						Number oldValue, Number newValue) {
					if (newValue.intValue() > oldValue.intValue()) {
						// Check if the new character is greater than LIMIT
						if (textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().length() >= 30) {
							textFieldClaim2ServiceFacilityAmbulancedropoffCity.setText(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().substring(0, 30));
						}
					}
				}
			});

			Text textClaim2ServiceFacilityAmbulanceDropoffStateZIp= new Text();
			textClaim2ServiceFacilityAmbulanceDropoffStateZIp.setText("State / Zip");
			textClaim2ServiceFacilityAmbulanceDropoffStateZIp.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmbulanceDropoffStateZIp.setFill(Color.BLACK);
			textClaim2ServiceFacilityAmbulanceDropoffStateZIp.setLayoutX(900);
			textClaim2ServiceFacilityAmbulanceDropoffStateZIp.setLayoutY(620);

			TextField textFieldClaim2ServiceFacilityAmbulanceDropoffZip = new TextField();
			textFieldClaim2ServiceFacilityAmbulanceDropoffZip.setLayoutX(1130);
			textFieldClaim2ServiceFacilityAmbulanceDropoffZip.setLayoutY(600);
			textFieldClaim2ServiceFacilityAmbulanceDropoffZip.setPrefWidth(95);
			textFieldClaim2ServiceFacilityAmbulanceDropoffZip.setPrefHeight(25);
			textFieldClaim2ServiceFacilityAmbulanceDropoffZip.setEditable(true);
			textFieldClaim2ServiceFacilityAmbulanceDropoffZip.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim2ServiceFacilityAmbulanceDropoffZip.setTooltip(new Tooltip("Enter Zip Code"));
			textFieldClaim2ServiceFacilityAmbulanceDropoffZip.setPromptText("Zip Code");

			Text textClaim2ServiceFacilityAmbulanceDropoffZipstar= new Text();
			textClaim2ServiceFacilityAmbulanceDropoffZipstar.setText("*");
			textClaim2ServiceFacilityAmbulanceDropoffZipstar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmbulanceDropoffZipstar.setFill(Color.RED);
			textClaim2ServiceFacilityAmbulanceDropoffZipstar.setLayoutX(1230);
			textClaim2ServiceFacilityAmbulanceDropoffZipstar.setLayoutY(610);

			textFieldClaim2ServiceFacilityAmbulanceDropoffZip.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, 
						String newValue) {
					try
					{
						if (newValue.matches("\\d*") && textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().length()<=9) {
							int value = Integer.parseInt(newValue);
						} else {
							textFieldClaim2ServiceFacilityAmbulanceDropoffZip.setText(oldValue);
						}
					}
					catch(Exception e)
					{

					}
				}
			});

			ComboBox<String> Claim2ServiceFacilityAmbulanceDropoffStateCombo = new ComboBox<String>();
			Claim2ServiceFacilityAmbulanceDropoffStateCombo.getItems().addAll("AA","AE","AL","AK","AP","AR","AS","AZ","CA","CO","CT","DE","DC","FL","FM","GA","GU","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MH","MI","MN","MS","MO","MP","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WV","WI","WY");
			Claim2ServiceFacilityAmbulanceDropoffStateCombo.setEditable(false); 
			Claim2ServiceFacilityAmbulanceDropoffStateCombo.setMinWidth(95);
			Claim2ServiceFacilityAmbulanceDropoffStateCombo.setMaxWidth(95);
			Claim2ServiceFacilityAmbulanceDropoffStateCombo.setMinHeight(25);
			Claim2ServiceFacilityAmbulanceDropoffStateCombo.setLayoutX(1025);
			Claim2ServiceFacilityAmbulanceDropoffStateCombo.setLayoutY(600);
			Claim2ServiceFacilityAmbulanceDropoffStateCombo.setTooltip(new Tooltip("Select State"));
			Claim2ServiceFacilityAmbulanceDropoffStateCombo.setValue("Select");;
			Claim2ServiceFacilityAmbulanceDropoffStateCombo.setStyle("-fx-font: 14px \"Calibri\";");

			Text textClaim2ServiceFacilityAmbulanceDropoffStatestar= new Text();
			textClaim2ServiceFacilityAmbulanceDropoffStatestar.setText("*");
			textClaim2ServiceFacilityAmbulanceDropoffStatestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim2ServiceFacilityAmbulanceDropoffStatestar.setFill(Color.RED);
			textClaim2ServiceFacilityAmbulanceDropoffStatestar.setLayoutX(1122);
			textClaim2ServiceFacilityAmbulanceDropoffStatestar.setLayoutY(610);

			////////////////////////////////////////////////////////////////////////////////////////

			textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
			textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
			textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
			textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);


			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				//true address one
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
				}
				else
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
			});
			///////////////////////////////////////////////////////////////////////////////////////////////////

			textFieldClaim2ServiceFacilityAmbulancedropoffCity.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				//true address one
				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}

				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
				}
				else
				{
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
			});

			//////////////////////////////////////////////////////////////////////////////
			textFieldClaim2ServiceFacilityAmbulanceDropoffZip.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				//true address one
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
				}
				else
				{
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}

			});
			///////////////////////////////////////////////////////////////////////////////////////////////////

			Claim2ServiceFacilityAmbulanceDropoffStateCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
				if(!(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);				
				}
				else if(!(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);	
				}
				else if(!(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);	
				}
				else if(!(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false)
				{
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);	
				}
				else if(!(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true)
				{
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
				}
				//tru
			});

			textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				//true address one
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& !(Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==false
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1)
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& (Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(true);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(true);
				}
				else if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==true 
						&& textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText().isEmpty()==true
						&& textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText().isEmpty()==true
						&& (Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().getSelectedIndex()==-1))
				{
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffCitystar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffZipstar.setVisible(false);
					textClaim2ServiceFacilityAmbulanceDropoffStatestar.setVisible(false);
				}
			});
			///////////////////////////////////////////////////////////////////////////////////////////////////

			ClaimTwo.getChildren().addAll(rectClaimTwoBorder,rectClaimTwoTop,textClaimTwoTop,HomelinkClaimTwo,rectClaimTwoMenu,ClaimTwoMenuTopOne,
					ClaimTwoMenuTopTwo,ClaimTwoMenuTopThree,textClaim2FederalTaxIDNo,textFieldClaim2FederalTaxIDNo,line9,textClaim2ServicingProviderName,textFieldClaim2ServicingProviderName,
					textClaim2ServicingProviderSigned,Claim2ServicingProviderSignedCombo,textClaim2ServicingProviderSignedDate,Claim2ServicingProviderSignedDatePicker,
					textClaim2ServicingProviderNPI,textFieldClaim2ServicingProviderNPI,textClaim2ServicingProviderPVN,textFieldClaim2ServicingProviderPVN,line10,textClaim3ReferringPhysicianFName,textFieldClaim3ReferringPhysicianFName,textClaim3ReferringPhysicianLName,textFieldClaim3ReferringPhysicianLName,
					textClaim3ReferringPhysicianNPI,textFieldClaim3ReferringPhysicianNPI,textClaim3HospitalizationforCurrentServicesFrom,Claim3HospitalizationforCurrentServicesFromPicker,
					textClaim3HospitalizationforCurrentServicesTo,Claim3HospitalizationforCurrentServicesToPicker,line12,textClaim2ServiceFacilityName,textFieldClaim2ServiceFacilityName,textClaim2ServiceFacilityAddress,textFieldClaim2ServiceFacilityAddressOne,textFieldClaim2ServiceFacilityAddressTwo,
					textClaim2ServiceFacilityCity,textFieldClaim2ServiceFacilityCity,textClaim2ServiceFacilityStateZIp,textFieldClaim2ServiceFacilityZip,Claim2ServiceFacilityStateCombo,
					textClaim2ServiceFacilityNPI,textFieldClaim2ServiceFacilityNPILoc,textClaim2ServiceFacilityAmulancePickupAddress,textFieldClaim2ServiceFacilityAmbulancePickupAddressOne,
					textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo,textClaim2ServiceFacilityAmbulancepickupCity,textFieldClaim2ServiceFacilityAmbulancepickupCity,
					textClaim2ServiceFacilityAmbulancepickupStateZIp,textFieldClaim2ServiceFacilityAmbulancepickupZip,Claim2ServiceFacilityAmbulancepickupStateCombo,
					textClaim2ServiceFacilityAmbulanceDropoffFacilityName,textFieldClaim2ServiceFacilityAmbulanceDropoffFacilityName,textClaim2ServiceFacilityAmulancedropoffAddress,
					textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne,textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo,textClaim2ServiceFacilityAmbulanceDropoffCity,
					textFieldClaim2ServiceFacilityAmbulancedropoffCity,textClaim2ServiceFacilityAmbulanceDropoffStateZIp,textFieldClaim2ServiceFacilityAmbulanceDropoffZip,
					Claim2ServiceFacilityAmbulanceDropoffStateCombo,line11,textClaim2ServicePhysicianName,textFieldClaim2ServicePhysicianName,textClaim2ServiceFacilityPhysicianAddress,
					textFieldClaim2ServiceFacilityPhysicianAddressTwo,textFieldClaim2ServiceFacilityPhysicianAddressOne,Claim2ServiceFacilityPAYTOpROviderStateCombo,textFieldClaim2ServiceFacilitypayToProviderfZip,
					textClaim2ServiceFacilityPayToProviderStateZIp,textFieldClaim2ServiceFacilityPayToProviderCity,textClaim2ServiceFacilityPayToProviderCity,textFieldClaim2ServiceFacilityPayToProviderAddressTwo,
					textFieldClaim2ServiceFacilityPaytoProvierAddressOne,textClaim2ServiceFacilitypaytoProviderAddress,textClaim2ServicePhysicianNPI,
					Claim2ServiceFacilityPhysicianStateCombo,textFieldClaim2ServiceFacilityPhysicianZip,textClaim2ServiceFacilityPhysicianStateZIp,textFieldClaim2ServiceFacilityPhysicianCity,
					textClaim2ServiceFacilityPhysicainCity,textClaim2ServicePhysicianPhoneNo,textFieldClaim2ServicePhysicianPhoneNo,textFieldClaim2ServicePhysicianNPI,
					textClaim2ServicePhysicianNamestar,textClaim2FederalTINstar,textClaim2ServiceFacilityPhysicianAddressOnestar,textClaim2ServiceFacilityPhysicianCitystar,
					textClaim2ServiceFacilityPhysicianZipstar,textClaimOneServiceFacilityPhysicianStatestar,textClaim2ServiceFacilityPaytoProvierAddressOnestar,
					textClaim2ServiceFacilityPaytoProvierCitystar,textClaim2ServiceFacilityPaytoProvierZipstar,textClaim2ServiceFacilityPaytoProvierStatestar,
					textClaim3ReferringPhysicianLNamestar,textClaim2ServicingProviderNamestar,textClaim2ServiceFacilityAmbulancePickupAddressOnestar,
					textClaim2ServiceFacilityAmbulancePickupCitystar,textClaim2ServiceFacilityAmbulancePickupZipstar,textClaim2ServiceFacilityAmbulancePickupStatestar,
					textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar,textClaim2ServiceFacilityAmbulanceDropoffCitystar,textClaim2ServiceFacilityAmbulanceDropoffZipstar,
					textClaim2ServiceFacilityAmbulanceDropoffStatestar,textClaim2ServiceFacilityNamestar,textClaim2ServiceFacilityAddressOnestar,textClaim2ServiceFacilityCitystar,
					textClaim2ServiceFacilityZipstar,textClaim2ServiceFacilityStatestar);
			ClaimTwo.setStyle("-fx-background-color:WHITE");
			//////////////////////////
			//Claim Three
			///////////////////////
			//Claim Two Screen
			Rectangle rectClaimThreeTop = new Rectangle();
			rectClaimThreeTop.setX(0.0f);
			rectClaimThreeTop.setY(0.0f);
			rectClaimThreeTop.setWidth(1360.0f);
			rectClaimThreeTop.setHeight(60.0f);
			rectClaimThreeTop.setFill(Color.STEELBLUE);
			rectClaimThreeTop.setStroke(Color.STEELBLUE);
			Rectangle rectClaimThreeMenu = new Rectangle();
			rectClaimThreeMenu.setX(0.0f);
			rectClaimThreeMenu.setY(60.0f);
			rectClaimThreeMenu.setWidth(1356.0f);
			rectClaimThreeMenu.setHeight(28.0f);
			rectClaimThreeMenu.setFill(Color.DARKTURQUOISE);//DARKSALMON//WHITESMOKE
			rectClaimThreeMenu.setStroke(Color.DARKSALMON);
			//Boundary
			Rectangle rectClaimThreeBorder = new Rectangle();
			rectClaimThreeBorder.setX(1.5f);
			rectClaimThreeBorder.setY(0.0f);
			rectClaimThreeBorder.setWidth(1356.0f);
			rectClaimThreeBorder.setHeight(682.0f);
			rectClaimThreeBorder.setFill(Color.WHITE);
			rectClaimThreeBorder.setStroke(Color.STEELBLUE);

			//Validate Data ReferralInq Button
			Button ClaimThreeMenuTopOne = new Button();
			ClaimThreeMenuTopOne.setText("Patient Details");
			ClaimThreeMenuTopOne.setLayoutX(400);
			ClaimThreeMenuTopOne.setLayoutY(60);
			ClaimThreeMenuTopOne.setMinWidth(150);
			ClaimThreeMenuTopOne.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			ClaimThreeMenuTopOne.setTextFill(Color.STEELBLUE);
			ClaimThreeMenuTopOne.setStyle("-fx-background-color:DARKGREY");
			ClaimThreeMenuTopOne.setTextFill(Color.WHITE);

			//Validate Data ReferralInq Button
			Button ClaimThreeMenuTopTwo = new Button();
			ClaimThreeMenuTopTwo.setText("Provider Details");
			ClaimThreeMenuTopTwo.setLayoutX(600);
			ClaimThreeMenuTopTwo.setLayoutY(60);
			ClaimThreeMenuTopTwo.setMinWidth(150);
			ClaimThreeMenuTopTwo.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			ClaimThreeMenuTopTwo.setTextFill(Color.STEELBLUE);
			ClaimThreeMenuTopTwo.setStyle("-fx-background-color:DARKGREY");
			ClaimThreeMenuTopTwo.setTextFill(Color.WHITE);
			//Process Data ReferralInq Button
			Button ClaimThreeMenuTopThree = new Button();
			ClaimThreeMenuTopThree.setText("Claim Details");
			ClaimThreeMenuTopThree.setLayoutX(800);
			ClaimThreeMenuTopThree.setLayoutY(60);
			ClaimThreeMenuTopThree.setMinWidth(150);
			ClaimThreeMenuTopThree.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			ClaimThreeMenuTopThree.setStyle("-fx-background-color:DARKSALMON");
			ClaimThreeMenuTopThree.setTextFill(Color.BLACK);
			//Top Text CSI
			Text textClaimThreeTop = new Text();
			textClaimThreeTop.setText("Health Insurance Claim Form");
			textClaimThreeTop.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 24));
			textClaimThreeTop.setFill(Color.WHITE);
			textClaimThreeTop.setLayoutX(532);
			textClaimThreeTop.setLayoutY(40);
			//HomeLink CSI
			Hyperlink HomelinkClaimThree = new Hyperlink();
			HomelinkClaimThree.setText("Home");
			HomelinkClaimThree.setStyle("-fx-text-fill: YELLOW;");
			HomelinkClaimThree.setLayoutX(1300);
			HomelinkClaimThree.setLayoutY(2);
			HomelinkClaimThree.setUnderline(false);
			HomelinkClaimThree.setFocusTraversable(false);
			HomelinkClaimThree.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 14));

			//////////////////////
			//Text Member InsuranceProgram ClaimTwo
			Text textClaim3PatientorAuthorizedPersonSign = new Text();
			textClaim3PatientorAuthorizedPersonSign.setText("Patient / Authorized"+'\n'+"Person Signed");
			textClaim3PatientorAuthorizedPersonSign.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3PatientorAuthorizedPersonSign.setFill(Color.BLACK);
			textClaim3PatientorAuthorizedPersonSign.setLayoutX(100);
			textClaim3PatientorAuthorizedPersonSign.setLayoutY(113);
			//Combobox InsProg Claim One
			ComboBox<String> Claim3PatientorAuthorizedPersonSignedCombo = new ComboBox<String>();
			Claim3PatientorAuthorizedPersonSignedCombo.getItems().addAll("Yes","No");
			Claim3PatientorAuthorizedPersonSignedCombo.setEditable(false); 
			Claim3PatientorAuthorizedPersonSignedCombo.setMinWidth(200);
			Claim3PatientorAuthorizedPersonSignedCombo.setMinHeight(25);
			Claim3PatientorAuthorizedPersonSignedCombo.setLayoutX(225);
			Claim3PatientorAuthorizedPersonSignedCombo.setLayoutY(103);
			Claim3PatientorAuthorizedPersonSignedCombo.setTooltip(new Tooltip("Select Signed Status"));
			Claim3PatientorAuthorizedPersonSignedCombo.getSelectionModel().select(0);
			Claim3PatientorAuthorizedPersonSignedCombo.setStyle("-fx-font: 14px \"Calibri\";");

			Text textClaim3PatientorAuthorizedPersonSignDate = new Text();
			textClaim3PatientorAuthorizedPersonSignDate.setText("Patient / Authorized"+'\n'+"Person Signed Date");
			textClaim3PatientorAuthorizedPersonSignDate.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3PatientorAuthorizedPersonSignDate.setFill(Color.BLACK);
			textClaim3PatientorAuthorizedPersonSignDate.setLayoutX(500);
			textClaim3PatientorAuthorizedPersonSignDate.setLayoutY(113);

			DatePicker Claim3PatientorAuthorizedPersonSignDatePicker = new DatePicker();
			Claim3PatientorAuthorizedPersonSignDatePicker.setLayoutX(625);
			Claim3PatientorAuthorizedPersonSignDatePicker.setLayoutY(103);
			Claim3PatientorAuthorizedPersonSignDatePicker.setPrefWidth(200);
			Claim3PatientorAuthorizedPersonSignDatePicker.setPrefHeight(25);
			Claim3PatientorAuthorizedPersonSignDatePicker.setPromptText("MM/DD/YYYY");
			Claim3PatientorAuthorizedPersonSignDatePicker.setTooltip(new Tooltip("Enter Signed Date"));
			Claim3PatientorAuthorizedPersonSignDatePicker.setEditable(false);
			Claim3PatientorAuthorizedPersonSignDatePicker.setStyle("-fx-font: 14px \"Calibri\";");		

			Claim3PatientorAuthorizedPersonSignDatePicker.setOnAction(e ->
			{
				LocalDate date = Claim3PatientorAuthorizedPersonSignDatePicker.getValue();
			});
			Claim3PatientorAuthorizedPersonSignedCombo.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(Claim3PatientorAuthorizedPersonSignedCombo.getValue().equalsIgnoreCase("Yes"))
					{
						Claim3PatientorAuthorizedPersonSignDatePicker.setDisable(false);
					}
					else
					{
						Claim3PatientorAuthorizedPersonSignDatePicker.setDisable(true);
					}
				}});

			Text textClaim3DateOfCurrentIllness = new Text();
			textClaim3DateOfCurrentIllness.setText("Date of Current"+'\n'+"Illness");
			textClaim3DateOfCurrentIllness.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3DateOfCurrentIllness.setFill(Color.BLACK);
			textClaim3DateOfCurrentIllness.setLayoutX(900);
			textClaim3DateOfCurrentIllness.setLayoutY(113);

			DatePicker Claim3DateofCurrentIllnessPicker = new DatePicker();
			Claim3DateofCurrentIllnessPicker.setLayoutX(1025);
			Claim3DateofCurrentIllnessPicker.setLayoutY(103);
			Claim3DateofCurrentIllnessPicker.setPrefWidth(200);
			Claim3DateofCurrentIllnessPicker.setPrefHeight(25);
			Claim3DateofCurrentIllnessPicker.setPromptText("MM/DD/YYYY");
			Claim3DateofCurrentIllnessPicker.setTooltip(new Tooltip("Enter Current Illness Date"));
			Claim3DateofCurrentIllnessPicker.setEditable(false);
			Claim3DateofCurrentIllnessPicker.setStyle("-fx-font: 14px \"Calibri\";");

			Claim3DateofCurrentIllnessPicker.setOnAction(e ->
			{
				LocalDate date = Claim3DateofCurrentIllnessPicker.getValue();
			});

			Text textClaim3PatientsMedicalProblem = new Text();
			textClaim3PatientsMedicalProblem.setText("Patient's Medical"+'\n'+"Problem");
			textClaim3PatientsMedicalProblem.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3PatientsMedicalProblem.setFill(Color.BLACK);
			textClaim3PatientsMedicalProblem.setLayoutX(100);
			textClaim3PatientsMedicalProblem.setLayoutY(153);
			//Combobox InsProg Claim One
			ComboBox<String> Claim3PatientsMedicalProblemCombo = new ComboBox<String>();
			Claim3PatientsMedicalProblemCombo.getItems().addAll("Hearing and Vision Prescription","Illness (First symptom)","Initial Treatment","Injury (Accident)","Last Worked Date","Pregnancy (LMP)","Return to Work");
			Claim3PatientsMedicalProblemCombo.setEditable(false); 
			Claim3PatientsMedicalProblemCombo.setMinWidth(200);
			Claim3PatientsMedicalProblemCombo.setMaxWidth(200);
			Claim3PatientsMedicalProblemCombo.setMinHeight(25);
			Claim3PatientsMedicalProblemCombo.setLayoutX(225);
			Claim3PatientsMedicalProblemCombo.setLayoutY(143);
			Claim3PatientsMedicalProblemCombo.setTooltip(new Tooltip("Select Medical Problem"));
			Claim3PatientsMedicalProblemCombo.setValue("Select");;
			Claim3PatientsMedicalProblemCombo.setStyle("-fx-font: 14px \"Calibri\";");

			Text textClaim3PatientUnableToWorkFrom = new Text();
			textClaim3PatientUnableToWorkFrom.setText("Date Patient Unable"+'\n'+"to Work From");
			textClaim3PatientUnableToWorkFrom.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3PatientUnableToWorkFrom.setFill(Color.BLACK);
			textClaim3PatientUnableToWorkFrom.setLayoutX(500);
			textClaim3PatientUnableToWorkFrom.setLayoutY(153);

			DatePicker Claim3PatientUnaableToWorkFromPicker = new DatePicker();
			Claim3PatientUnaableToWorkFromPicker.setLayoutX(625);
			Claim3PatientUnaableToWorkFromPicker.setLayoutY(143);
			Claim3PatientUnaableToWorkFromPicker.setPrefWidth(200);
			Claim3PatientUnaableToWorkFromPicker.setPrefHeight(25);
			Claim3PatientUnaableToWorkFromPicker.setPromptText("MM/DD/YYYY");
			Claim3PatientUnaableToWorkFromPicker.setTooltip(new Tooltip("Date Patient Unable to Work From"));
			Claim3PatientUnaableToWorkFromPicker.setEditable(false);
			Claim3PatientUnaableToWorkFromPicker.setStyle("-fx-font: 14px \"Calibri\";");

			Claim3PatientUnaableToWorkFromPicker.setOnAction(e ->
			{
				LocalDate date = Claim3PatientUnaableToWorkFromPicker.getValue();
			});

			Text textClaim3PatientUnableToWorkTo = new Text();
			textClaim3PatientUnableToWorkTo.setText("Date Patient Unable"+'\n'+"to Work To");
			textClaim3PatientUnableToWorkTo.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3PatientUnableToWorkTo.setFill(Color.BLACK);
			textClaim3PatientUnableToWorkTo.setLayoutX(900);
			textClaim3PatientUnableToWorkTo.setLayoutY(153);

			DatePicker Claim3PatientUnaableToWorkToPicker = new DatePicker();
			Claim3PatientUnaableToWorkToPicker.setLayoutX(1025);
			Claim3PatientUnaableToWorkToPicker.setLayoutY(143);
			Claim3PatientUnaableToWorkToPicker.setPrefWidth(200);
			Claim3PatientUnaableToWorkToPicker.setPrefHeight(25);
			Claim3PatientUnaableToWorkToPicker.setPromptText("MM/DD/YYYY");
			Claim3PatientUnaableToWorkToPicker.setTooltip(new Tooltip("Date Patient Unable to Work To"));
			Claim3PatientUnaableToWorkToPicker.setEditable(false);
			Claim3PatientUnaableToWorkToPicker.setStyle("-fx-font: 14px \"Calibri\";");

			Claim3PatientUnaableToWorkToPicker.setOnAction(e ->
			{
				LocalDate date = Claim3PatientUnaableToWorkToPicker.getValue();
			});

			Line line4 = new Line(); 
			line4.setStartX(100); 
			line4.setStartY(180); 
			line4.setEndX(1225); 
			line4.setEndY(180);

			Text textClaim3PatientAccountNo = new Text();
			textClaim3PatientAccountNo.setText("Patient Account"+'\n'+ "Number");
			textClaim3PatientAccountNo.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3PatientAccountNo.setFill(Color.BLACK);
			textClaim3PatientAccountNo.setLayoutX(100);
			textClaim3PatientAccountNo.setLayoutY(200);

			TextField textFieldClaim3PatientAccountNo= new TextField();
			textFieldClaim3PatientAccountNo.setLayoutX(225);
			textFieldClaim3PatientAccountNo.setLayoutY(190);
			textFieldClaim3PatientAccountNo.setPrefWidth(200);
			textFieldClaim3PatientAccountNo.setPrefHeight(25);
			textFieldClaim3PatientAccountNo.setEditable(true);
			textFieldClaim3PatientAccountNo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim3PatientAccountNo.setTooltip(new Tooltip("Enter Patient Account Number"));
			textFieldClaim3PatientAccountNo.setPromptText("Patient Account Number");


			textFieldClaim3PatientAccountNo.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, 
						String newValue) {
					try
					{
						if (newValue.matches("\\d*") && textFieldClaim3PatientAccountNo.getText().length()<=16) {
							int value = Integer.parseInt(newValue);
						} else {
							textFieldClaim3PatientAccountNo.setText(oldValue);
						}
					}
					catch(Exception e)
					{

					}
				}
			});

			Text textClaim3PatientAccountNostar= new Text();
			textClaim3PatientAccountNostar.setText("*");
			textClaim3PatientAccountNostar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3PatientAccountNostar.setFill(Color.RED);
			textClaim3PatientAccountNostar.setLayoutX(430);
			textClaim3PatientAccountNostar.setLayoutY(200);



			textFieldClaim3PatientAccountNo.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim3PatientAccountNo.getText().isEmpty()==false)
					textClaim3PatientAccountNostar.setVisible(false);
				else
					textClaim3PatientAccountNostar.setVisible(true);
			});



			Text textClaim3AcceptAssignment = new Text();
			textClaim3AcceptAssignment.setText("Accept Assignment ?");
			textClaim3AcceptAssignment.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3AcceptAssignment.setFill(Color.BLACK);
			textClaim3AcceptAssignment.setLayoutX(500);
			textClaim3AcceptAssignment.setLayoutY(208);

			ComboBox<String> Claim3AcceptAssignmentCombo= new ComboBox<String>();
			Claim3AcceptAssignmentCombo.getItems().addAll("Yes","No");
			Claim3AcceptAssignmentCombo.setEditable(false); 
			Claim3AcceptAssignmentCombo.setMinWidth(200);
			Claim3AcceptAssignmentCombo.setMinHeight(25);
			Claim3AcceptAssignmentCombo.setLayoutX(625);
			Claim3AcceptAssignmentCombo.setLayoutY(190);
			Claim3AcceptAssignmentCombo.setTooltip(new Tooltip("Select Accept Assignment"));
			Claim3AcceptAssignmentCombo.setValue("Select");;
			Claim3AcceptAssignmentCombo.setStyle("-fx-font: 14px \"Calibri\";");




			Text textClaim3TotalCharges = new Text();
			textClaim3TotalCharges.setText("Total Charges in $");
			textClaim3TotalCharges.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3TotalCharges.setFill(Color.BLACK);
			textClaim3TotalCharges.setLayoutX(100);
			textClaim3TotalCharges.setLayoutY(248);

			TextField textFieldClaim3TotalCharges = new TextField();
			textFieldClaim3TotalCharges.setLayoutX(225);
			textFieldClaim3TotalCharges.setLayoutY(230);
			textFieldClaim3TotalCharges.setPrefWidth(200);
			textFieldClaim3TotalCharges.setPrefHeight(25);
			textFieldClaim3TotalCharges.setEditable(true);
			textFieldClaim3TotalCharges.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim3TotalCharges.setTooltip(new Tooltip("Enter Total Charge Amount"));
			textFieldClaim3TotalCharges.setPromptText("Total Charges in $");

			Text textClaim3TotalChargesstar= new Text();
			textClaim3TotalChargesstar.setText("*");
			textClaim3TotalChargesstar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3TotalChargesstar.setFill(Color.RED);
			textClaim3TotalChargesstar.setLayoutX(430);
			textClaim3TotalChargesstar.setLayoutY(240);

			textFieldClaim3TotalCharges.textProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim3TotalCharges.getText().isEmpty()==false)
					textClaim3TotalChargesstar.setVisible(false);
				else
					textClaim3TotalChargesstar.setVisible(true);
			});

			textFieldClaim3TotalCharges.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					if(!newValue.matches("\\d*(\\.\\d*)?")) {
						textFieldClaim3TotalCharges.setText(oldValue);
					}
				}
			});

			Text textClaim3AmountPaid = new Text();
			textClaim3AmountPaid.setText("Amount Paid in $");
			textClaim3AmountPaid.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3AmountPaid.setFill(Color.BLACK);
			textClaim3AmountPaid.setLayoutX(500);
			textClaim3AmountPaid.setLayoutY(248);

			TextField textFieldClaim3Amountpaid = new TextField();
			textFieldClaim3Amountpaid.setLayoutX(625);
			textFieldClaim3Amountpaid.setLayoutY(230);
			textFieldClaim3Amountpaid.setPrefWidth(200);
			textFieldClaim3Amountpaid.setPrefHeight(25);
			textFieldClaim3Amountpaid.setEditable(true);
			textFieldClaim3Amountpaid.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim3Amountpaid.setTooltip(new Tooltip("Enter Amount Paid"));
			textFieldClaim3Amountpaid.setPromptText("Amount Paid in $");




			textFieldClaim3Amountpaid.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					if(!newValue.matches("\\d*(\\.\\d*)?")) {
						textFieldClaim3Amountpaid.setText(oldValue);
					}
				}
			});

			Line line5 = new Line(); 
			line5.setStartX(100); 
			line5.setStartY(267); 
			line5.setEndX(1225); 
			line5.setEndY(267);

			Text textClaim3ClaimLevelNotes = new Text();
			textClaim3ClaimLevelNotes.setText("Claim Level Notes");
			textClaim3ClaimLevelNotes.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3ClaimLevelNotes.setFill(Color.BLACK);
			textClaim3ClaimLevelNotes.setLayoutX(100);
			textClaim3ClaimLevelNotes.setLayoutY(294);

			TextField textFieldClaim3ClaimLevelNotes = new TextField();
			textFieldClaim3ClaimLevelNotes.setLayoutX(225);
			textFieldClaim3ClaimLevelNotes.setLayoutY(277);
			textFieldClaim3ClaimLevelNotes.setPrefWidth(200);
			textFieldClaim3ClaimLevelNotes.setPrefHeight(25);
			textFieldClaim3ClaimLevelNotes.setEditable(true);
			textFieldClaim3ClaimLevelNotes.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim3ClaimLevelNotes.setTooltip(new Tooltip("Enter Claim Level Notes"));
			textFieldClaim3ClaimLevelNotes.setPromptText("Enter Claim Level Notes to Payer here.");

			Text textClaim3OutsideLab = new Text();
			textClaim3OutsideLab.setText("Outside Lab ?");
			textClaim3OutsideLab.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3OutsideLab.setFill(Color.BLACK);
			textClaim3OutsideLab.setLayoutX(500);
			textClaim3OutsideLab.setLayoutY(294);

			ComboBox<String> Claim3OutSidelabCombo = new ComboBox<String>();
			Claim3OutSidelabCombo.getItems().addAll("Yes","No");
			Claim3OutSidelabCombo.setEditable(false); 
			Claim3OutSidelabCombo.setMinWidth(200);
			Claim3OutSidelabCombo.setMinHeight(25);
			Claim3OutSidelabCombo.setLayoutX(625);
			Claim3OutSidelabCombo.setLayoutY(277);
			Claim3OutSidelabCombo.setTooltip(new Tooltip("Select Answer"));
			Claim3OutSidelabCombo.getSelectionModel().select(1);
			Claim3OutSidelabCombo.setStyle("-fx-font: 14px \"Calibri\";");



			Text textClaim3labCharges = new Text();
			textClaim3labCharges.setText("Charges In $");
			textClaim3labCharges.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3labCharges.setFill(Color.BLACK);
			textClaim3labCharges.setLayoutX(900);
			textClaim3labCharges.setLayoutY(294);

			TextField textFieldClaim3LabCharges = new TextField();
			textFieldClaim3LabCharges.setLayoutX(1025);
			textFieldClaim3LabCharges.setLayoutY(277);
			textFieldClaim3LabCharges.setPrefWidth(200);
			textFieldClaim3LabCharges.setPrefHeight(25);
			textFieldClaim3LabCharges.setEditable(true);
			textFieldClaim3LabCharges.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim3LabCharges.setTooltip(new Tooltip("Enter Charge Amount"));
			textFieldClaim3LabCharges.setPromptText("Charges in $");
			textFieldClaim3LabCharges.setDisable(true);

			textFieldClaim3LabCharges.textProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					if(!newValue.matches("\\d*(\\.\\d*)?")) {
						textFieldClaim3LabCharges.setText(oldValue);
					}
				}
			});

			Claim3OutSidelabCombo.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(Claim3OutSidelabCombo.getValue().equalsIgnoreCase("Yes"))
					{

						textFieldClaim3LabCharges.setDisable(false);
					}
					else
					{
						textFieldClaim3LabCharges.setDisable(true);
					}

				}});

			Line line6 = new Line(); 
			line6.setStartX(100); 
			line6.setStartY(314); 
			line6.setEndX(1225); 
			line6.setEndY(314);

			Text textClaim3DiagnosisorNatureOfInjury = new Text();
			textClaim3DiagnosisorNatureOfInjury.setText("Diagnosis or Nature of Illness or Injury");
			textClaim3DiagnosisorNatureOfInjury.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3DiagnosisorNatureOfInjury.setFill(Color.BLACK);
			textClaim3DiagnosisorNatureOfInjury.setLayoutX(100);
			textClaim3DiagnosisorNatureOfInjury.setLayoutY(334);

			Text textClaim3DiagnosisorNatureOfInjuryDesc = new Text();
			textClaim3DiagnosisorNatureOfInjuryDesc.setText("(Relate Items 1, 2, 3, 4, 5 or 6 to Item 24E by Line)");
			textClaim3DiagnosisorNatureOfInjuryDesc.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
			textClaim3DiagnosisorNatureOfInjuryDesc.setFill(Color.BLACK);
			textClaim3DiagnosisorNatureOfInjuryDesc.setLayoutX(335);
			textClaim3DiagnosisorNatureOfInjuryDesc.setLayoutY(334);
			////
			Text textClaim3DiagnosisNameOne = new Text();
			textClaim3DiagnosisNameOne.setText("1.");
			textClaim3DiagnosisNameOne.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
			textClaim3DiagnosisNameOne.setFill(Color.BLACK);
			textClaim3DiagnosisNameOne.setLayoutX(130);
			textClaim3DiagnosisNameOne.setLayoutY(360);

			ComboBox<String> textFieldClaim3DiagnosisCodeOne = new ComboBox<String>();
			textFieldClaim3DiagnosisCodeOne.getItems().addAll("R69 - Illness, unspecified","A000 - Cholera due to Vibrio cholerae 01, biovar cholerae","A001 - Cholera due to Vibrio cholerae 01, biovar eltor","A009 - Cholera, unspecified","A0100 - Typhoid fever, unspecified","A0101 - Typhoid meningitis","A0102 - Typhoid fever with heart involvement","A0103 - Typhoid pneumonia","A0104 - Typhoid arthritis","A0105 - Typhoid osteomyelitis","A0109 - Typhoid fever with other complications","A011 - Paratyphoid fever A","A012 - Paratyphoid fever B","A013 - Paratyphoid fever C","A014 - Paratyphoid fever, unspecified","A020 - Salmonella enteritis","A021 - Salmonella sepsis","A0220 - Localized salmonella infection, unspecified","A0221 - Salmonella meningitis","A0222 - Salmonella pneumonia","A0223 - Salmonella arthritis");
			textFieldClaim3DiagnosisCodeOne.setEditable(false); 
			textFieldClaim3DiagnosisCodeOne.setMinWidth(140);
			textFieldClaim3DiagnosisCodeOne.setMaxWidth(140);
			textFieldClaim3DiagnosisCodeOne.setMinHeight(25);
			textFieldClaim3DiagnosisCodeOne.setLayoutX(150);
			textFieldClaim3DiagnosisCodeOne.setLayoutY(343);
			textFieldClaim3DiagnosisCodeOne.setTooltip(new Tooltip("1st Diagnosis or Nature of Illness or Injury Code"));
			textFieldClaim3DiagnosisCodeOne.setValue("Select");
			textFieldClaim3DiagnosisCodeOne.setStyle("-fx-font: 14px \"Calibri\";");


			Text textClaim3DiagnosisCodeOnestar= new Text();
			textClaim3DiagnosisCodeOnestar.setText("*");
			textClaim3DiagnosisCodeOnestar.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3DiagnosisCodeOnestar.setFill(Color.RED);
			textClaim3DiagnosisCodeOnestar.setLayoutX(295);
			textClaim3DiagnosisCodeOnestar.setLayoutY(353);
			textClaim3DiagnosisCodeOnestar.setVisible(true);

			textFieldClaim3DiagnosisCodeOne.valueProperty().addListener((observable, oldValue, newValue) -> {
				if(textFieldClaim3DiagnosisCodeOne.getSelectionModel().getSelectedIndex()==-1)
					textClaim3DiagnosisCodeOnestar.setVisible(true);
				else
					textClaim3DiagnosisCodeOnestar.setVisible(false);});
			//
			Text textClaim3DiagnosisNameTwo = new Text();
			textClaim3DiagnosisNameTwo.setText("2.");
			textClaim3DiagnosisNameTwo.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
			textClaim3DiagnosisNameTwo.setFill(Color.BLACK);
			textClaim3DiagnosisNameTwo.setLayoutX(317);
			textClaim3DiagnosisNameTwo.setLayoutY(360);

			ComboBox<String> textFieldClaim3DiagnosisCodeTwo = new ComboBox<String>();
			textFieldClaim3DiagnosisCodeTwo.getItems().addAll("R69 - Illness, unspecified","A000 - Cholera due to Vibrio cholerae 01, biovar cholerae","A001 - Cholera due to Vibrio cholerae 01, biovar eltor","A009 - Cholera, unspecified","A0100 - Typhoid fever, unspecified","A0101 - Typhoid meningitis","A0102 - Typhoid fever with heart involvement","A0103 - Typhoid pneumonia","A0104 - Typhoid arthritis","A0105 - Typhoid osteomyelitis","A0109 - Typhoid fever with other complications","A011 - Paratyphoid fever A","A012 - Paratyphoid fever B","A013 - Paratyphoid fever C","A014 - Paratyphoid fever, unspecified","A020 - Salmonella enteritis","A021 - Salmonella sepsis","A0220 - Localized salmonella infection, unspecified","A0221 - Salmonella meningitis","A0222 - Salmonella pneumonia","A0223 - Salmonella arthritis");
			textFieldClaim3DiagnosisCodeTwo.setEditable(false); 
			textFieldClaim3DiagnosisCodeTwo.setMinWidth(140);
			textFieldClaim3DiagnosisCodeTwo.setMaxWidth(140);
			textFieldClaim3DiagnosisCodeTwo.setMinHeight(25);
			textFieldClaim3DiagnosisCodeTwo.setLayoutX(337);
			textFieldClaim3DiagnosisCodeTwo.setLayoutY(343);
			textFieldClaim3DiagnosisCodeTwo.setTooltip(new Tooltip("2nd Diagnosis or Nature of Illness or Injury Code"));
			textFieldClaim3DiagnosisCodeTwo.setValue("Select");;
			textFieldClaim3DiagnosisCodeTwo.setStyle("-fx-font: 14px \"Calibri\";");
			textFieldClaim3DiagnosisCodeTwo.setDisable(true);
			//
			Text textClaim3DiagnosisNameThree = new Text();
			textClaim3DiagnosisNameThree.setText("3.");
			textClaim3DiagnosisNameThree.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
			textClaim3DiagnosisNameThree.setFill(Color.BLACK);
			textClaim3DiagnosisNameThree.setLayoutX(504);
			textClaim3DiagnosisNameThree.setLayoutY(360);

			ComboBox<String> textFieldClaim3DiagnosisCodeThree = new ComboBox<String>();
			textFieldClaim3DiagnosisCodeThree.getItems().addAll("R69 - Illness, unspecified","A000 - Cholera due to Vibrio cholerae 01, biovar cholerae","A001 - Cholera due to Vibrio cholerae 01, biovar eltor","A009 - Cholera, unspecified","A0100 - Typhoid fever, unspecified","A0101 - Typhoid meningitis","A0102 - Typhoid fever with heart involvement","A0103 - Typhoid pneumonia","A0104 - Typhoid arthritis","A0105 - Typhoid osteomyelitis","A0109 - Typhoid fever with other complications","A011 - Paratyphoid fever A","A012 - Paratyphoid fever B","A013 - Paratyphoid fever C","A014 - Paratyphoid fever, unspecified","A020 - Salmonella enteritis","A021 - Salmonella sepsis","A0220 - Localized salmonella infection, unspecified","A0221 - Salmonella meningitis","A0222 - Salmonella pneumonia","A0223 - Salmonella arthritis");
			textFieldClaim3DiagnosisCodeThree.setEditable(false); 
			textFieldClaim3DiagnosisCodeThree.setMinWidth(140);
			textFieldClaim3DiagnosisCodeThree.setMaxWidth(140);
			textFieldClaim3DiagnosisCodeThree.setMinHeight(25);
			textFieldClaim3DiagnosisCodeThree.setLayoutX(524);
			textFieldClaim3DiagnosisCodeThree.setLayoutY(343);
			textFieldClaim3DiagnosisCodeThree.setTooltip(new Tooltip("3rd Diagnosis or Nature of Illness or Injury Code"));
			textFieldClaim3DiagnosisCodeThree.setValue("Select");;
			textFieldClaim3DiagnosisCodeThree.setStyle("-fx-font: 14px \"Calibri\";");
			textFieldClaim3DiagnosisCodeThree.setDisable(true);
			//
			Text textClaim3DiagnosisNameFour = new Text();
			textClaim3DiagnosisNameFour.setText("4.");
			textClaim3DiagnosisNameFour.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
			textClaim3DiagnosisNameFour.setFill(Color.BLACK);
			textClaim3DiagnosisNameFour.setLayoutX(691);
			textClaim3DiagnosisNameFour.setLayoutY(360);

			ComboBox<String> textFieldClaim3DiagnosisCodeFour = new ComboBox<String>();
			textFieldClaim3DiagnosisCodeFour.getItems().addAll("R69 - Illness, unspecified","A000 - Cholera due to Vibrio cholerae 01, biovar cholerae","A001 - Cholera due to Vibrio cholerae 01, biovar eltor","A009 - Cholera, unspecified","A0100 - Typhoid fever, unspecified","A0101 - Typhoid meningitis","A0102 - Typhoid fever with heart involvement","A0103 - Typhoid pneumonia","A0104 - Typhoid arthritis","A0105 - Typhoid osteomyelitis","A0109 - Typhoid fever with other complications","A011 - Paratyphoid fever A","A012 - Paratyphoid fever B","A013 - Paratyphoid fever C","A014 - Paratyphoid fever, unspecified","A020 - Salmonella enteritis","A021 - Salmonella sepsis","A0220 - Localized salmonella infection, unspecified","A0221 - Salmonella meningitis","A0222 - Salmonella pneumonia","A0223 - Salmonella arthritis");
			textFieldClaim3DiagnosisCodeFour.setEditable(false); 
			textFieldClaim3DiagnosisCodeFour.setMinWidth(140);
			textFieldClaim3DiagnosisCodeFour.setMaxWidth(140);
			textFieldClaim3DiagnosisCodeFour.setMinHeight(25);
			textFieldClaim3DiagnosisCodeFour.setLayoutX(711);
			textFieldClaim3DiagnosisCodeFour.setLayoutY(343);
			textFieldClaim3DiagnosisCodeFour.setTooltip(new Tooltip("4th Diagnosis or Nature of Illness or Injury Code"));
			textFieldClaim3DiagnosisCodeFour.setValue("Select");;
			textFieldClaim3DiagnosisCodeFour.setStyle("-fx-font: 14px \"Calibri\";");
			textFieldClaim3DiagnosisCodeFour.setDisable(true);
			//
			Text textClaim3DiagnosisNameFive = new Text();
			textClaim3DiagnosisNameFive.setText("5.");
			textClaim3DiagnosisNameFive.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
			textClaim3DiagnosisNameFive.setFill(Color.BLACK);
			textClaim3DiagnosisNameFive.setLayoutX(878);
			textClaim3DiagnosisNameFive.setLayoutY(360);

			ComboBox<String> textFieldClaim3DiagnosisCodeFive = new ComboBox<String>();
			textFieldClaim3DiagnosisCodeFive.getItems().addAll("R69 - Illness, unspecified","A000 - Cholera due to Vibrio cholerae 01, biovar cholerae","A001 - Cholera due to Vibrio cholerae 01, biovar eltor","A009 - Cholera, unspecified","A0100 - Typhoid fever, unspecified","A0101 - Typhoid meningitis","A0102 - Typhoid fever with heart involvement","A0103 - Typhoid pneumonia","A0104 - Typhoid arthritis","A0105 - Typhoid osteomyelitis","A0109 - Typhoid fever with other complications","A011 - Paratyphoid fever A","A012 - Paratyphoid fever B","A013 - Paratyphoid fever C","A014 - Paratyphoid fever, unspecified","A020 - Salmonella enteritis","A021 - Salmonella sepsis","A0220 - Localized salmonella infection, unspecified","A0221 - Salmonella meningitis","A0222 - Salmonella pneumonia","A0223 - Salmonella arthritis");
			textFieldClaim3DiagnosisCodeFive.setEditable(false); 
			textFieldClaim3DiagnosisCodeFive.setMinWidth(140);
			textFieldClaim3DiagnosisCodeFive.setMaxWidth(140);
			textFieldClaim3DiagnosisCodeFive.setMinHeight(25);
			textFieldClaim3DiagnosisCodeFive.setLayoutX(898);
			textFieldClaim3DiagnosisCodeFive.setLayoutY(343);
			textFieldClaim3DiagnosisCodeFive.setTooltip(new Tooltip("5th Diagnosis or Nature of Illness or Injury Code"));
			textFieldClaim3DiagnosisCodeFive.setValue("Select");;
			textFieldClaim3DiagnosisCodeFive.setStyle("-fx-font: 14px \"Calibri\";");
			textFieldClaim3DiagnosisCodeFive.setDisable(true);
			//
			Text textClaim3DiagnosisNameSix = new Text();
			textClaim3DiagnosisNameSix.setText("6.");
			textClaim3DiagnosisNameSix.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
			textClaim3DiagnosisNameSix.setFill(Color.BLACK);
			textClaim3DiagnosisNameSix.setLayoutX(1066);
			textClaim3DiagnosisNameSix.setLayoutY(360);

			ComboBox<String> textFieldClaim3DiagnosisCodeSix = new ComboBox<String>();
			textFieldClaim3DiagnosisCodeSix.getItems().addAll("R69 - Illness, unspecified","A000 - Cholera due to Vibrio cholerae 01, biovar cholerae","A001 - Cholera due to Vibrio cholerae 01, biovar eltor","A009 - Cholera, unspecified","A0100 - Typhoid fever, unspecified","A0101 - Typhoid meningitis","A0102 - Typhoid fever with heart involvement","A0103 - Typhoid pneumonia","A0104 - Typhoid arthritis","A0105 - Typhoid osteomyelitis","A0109 - Typhoid fever with other complications","A011 - Paratyphoid fever A","A012 - Paratyphoid fever B","A013 - Paratyphoid fever C","A014 - Paratyphoid fever, unspecified","A020 - Salmonella enteritis","A021 - Salmonella sepsis","A0220 - Localized salmonella infection, unspecified","A0221 - Salmonella meningitis","A0222 - Salmonella pneumonia","A0223 - Salmonella arthritis");
			textFieldClaim3DiagnosisCodeSix.setEditable(false); 
			textFieldClaim3DiagnosisCodeSix.setMinWidth(140);
			textFieldClaim3DiagnosisCodeSix.setMaxWidth(140);
			textFieldClaim3DiagnosisCodeSix.setMinHeight(25);
			textFieldClaim3DiagnosisCodeSix.setLayoutX(1088);
			textFieldClaim3DiagnosisCodeSix.setLayoutY(343);
			textFieldClaim3DiagnosisCodeSix.setTooltip(new Tooltip("6th Diagnosis or Nature of Illness or Injury Code"));
			textFieldClaim3DiagnosisCodeSix.setValue("Select");;
			textFieldClaim3DiagnosisCodeSix.setStyle("-fx-font: 14px \"Calibri\";");
			textFieldClaim3DiagnosisCodeSix.setDisable(true);
			//
			////
			Text textClaim3DiagnosisNameSeven = new Text();
			textClaim3DiagnosisNameSeven.setText("7.");
			textClaim3DiagnosisNameSeven.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
			textClaim3DiagnosisNameSeven.setFill(Color.BLACK);
			textClaim3DiagnosisNameSeven.setLayoutX(130);
			textClaim3DiagnosisNameSeven.setLayoutY(395);

			ComboBox<String> textFieldClaim3DiagnosisCodeSeven = new ComboBox<String>();
			textFieldClaim3DiagnosisCodeSeven.getItems().addAll("R69 - Illness, unspecified","A000 - Cholera due to Vibrio cholerae 01, biovar cholerae","A001 - Cholera due to Vibrio cholerae 01, biovar eltor","A009 - Cholera, unspecified","A0100 - Typhoid fever, unspecified","A0101 - Typhoid meningitis","A0102 - Typhoid fever with heart involvement","A0103 - Typhoid pneumonia","A0104 - Typhoid arthritis","A0105 - Typhoid osteomyelitis","A0109 - Typhoid fever with other complications","A011 - Paratyphoid fever A","A012 - Paratyphoid fever B","A013 - Paratyphoid fever C","A014 - Paratyphoid fever, unspecified","A020 - Salmonella enteritis","A021 - Salmonella sepsis","A0220 - Localized salmonella infection, unspecified","A0221 - Salmonella meningitis","A0222 - Salmonella pneumonia","A0223 - Salmonella arthritis");
			textFieldClaim3DiagnosisCodeSeven.setEditable(false); 
			textFieldClaim3DiagnosisCodeSeven.setMinWidth(140);
			textFieldClaim3DiagnosisCodeSeven.setMaxWidth(140);
			textFieldClaim3DiagnosisCodeSeven.setMinHeight(25);
			textFieldClaim3DiagnosisCodeSeven.setLayoutX(150);
			textFieldClaim3DiagnosisCodeSeven.setLayoutY(378);
			textFieldClaim3DiagnosisCodeSeven.setTooltip(new Tooltip("7th Diagnosis or Nature of Illness or Injury Code"));
			textFieldClaim3DiagnosisCodeSeven.setValue("Select");;
			textFieldClaim3DiagnosisCodeSeven.setStyle("-fx-font: 14px \"Calibri\";");
			textFieldClaim3DiagnosisCodeSeven.setDisable(true);
			//
			Text textClaim3DiagnosisNameEight = new Text();
			textClaim3DiagnosisNameEight.setText("8.");
			textClaim3DiagnosisNameEight.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
			textClaim3DiagnosisNameEight.setFill(Color.BLACK);
			textClaim3DiagnosisNameEight.setLayoutX(317);
			textClaim3DiagnosisNameEight.setLayoutY(395);

			ComboBox<String> textFieldClaim3DiagnosisCodeEight = new ComboBox<String>();
			textFieldClaim3DiagnosisCodeEight.getItems().addAll("R69 - Illness, unspecified","A000 - Cholera due to Vibrio cholerae 01, biovar cholerae","A001 - Cholera due to Vibrio cholerae 01, biovar eltor","A009 - Cholera, unspecified","A0100 - Typhoid fever, unspecified","A0101 - Typhoid meningitis","A0102 - Typhoid fever with heart involvement","A0103 - Typhoid pneumonia","A0104 - Typhoid arthritis","A0105 - Typhoid osteomyelitis","A0109 - Typhoid fever with other complications","A011 - Paratyphoid fever A","A012 - Paratyphoid fever B","A013 - Paratyphoid fever C","A014 - Paratyphoid fever, unspecified","A020 - Salmonella enteritis","A021 - Salmonella sepsis","A0220 - Localized salmonella infection, unspecified","A0221 - Salmonella meningitis","A0222 - Salmonella pneumonia","A0223 - Salmonella arthritis");
			textFieldClaim3DiagnosisCodeEight.setEditable(false); 
			textFieldClaim3DiagnosisCodeEight.setMinWidth(140);
			textFieldClaim3DiagnosisCodeEight.setMaxWidth(140);
			textFieldClaim3DiagnosisCodeEight.setMinHeight(25);
			textFieldClaim3DiagnosisCodeEight.setLayoutX(337);
			textFieldClaim3DiagnosisCodeEight.setLayoutY(378);
			textFieldClaim3DiagnosisCodeEight.setTooltip(new Tooltip("8th Diagnosis or Nature of Illness or Injury Code"));
			textFieldClaim3DiagnosisCodeEight.setValue("Select");;
			textFieldClaim3DiagnosisCodeEight.setStyle("-fx-font: 14px \"Calibri\";");
			textFieldClaim3DiagnosisCodeEight.setDisable(true);
			//
			Text textClaim3DiagnosisNameNine = new Text();
			textClaim3DiagnosisNameNine.setText("9.");
			textClaim3DiagnosisNameNine.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
			textClaim3DiagnosisNameNine.setFill(Color.BLACK);
			textClaim3DiagnosisNameNine.setLayoutX(504);
			textClaim3DiagnosisNameNine.setLayoutY(395);

			ComboBox<String> textFieldClaim3DiagnosisCodeNine = new ComboBox<String>();
			textFieldClaim3DiagnosisCodeNine.getItems().addAll("R69 - Illness, unspecified","A000 - Cholera due to Vibrio cholerae 01, biovar cholerae","A001 - Cholera due to Vibrio cholerae 01, biovar eltor","A009 - Cholera, unspecified","A0100 - Typhoid fever, unspecified","A0101 - Typhoid meningitis","A0102 - Typhoid fever with heart involvement","A0103 - Typhoid pneumonia","A0104 - Typhoid arthritis","A0105 - Typhoid osteomyelitis","A0109 - Typhoid fever with other complications","A011 - Paratyphoid fever A","A012 - Paratyphoid fever B","A013 - Paratyphoid fever C","A014 - Paratyphoid fever, unspecified","A020 - Salmonella enteritis","A021 - Salmonella sepsis","A0220 - Localized salmonella infection, unspecified","A0221 - Salmonella meningitis","A0222 - Salmonella pneumonia","A0223 - Salmonella arthritis");
			textFieldClaim3DiagnosisCodeNine.setEditable(false); 
			textFieldClaim3DiagnosisCodeNine.setMinWidth(140);
			textFieldClaim3DiagnosisCodeNine.setMaxWidth(140);
			textFieldClaim3DiagnosisCodeNine.setMinHeight(25);
			textFieldClaim3DiagnosisCodeNine.setLayoutX(524);
			textFieldClaim3DiagnosisCodeNine.setLayoutY(378);
			textFieldClaim3DiagnosisCodeNine.setTooltip(new Tooltip("9th Diagnosis or Nature of Illness or Injury Code"));
			textFieldClaim3DiagnosisCodeNine.setValue("Select");;
			textFieldClaim3DiagnosisCodeNine.setStyle("-fx-font: 14px \"Calibri\";");
			textFieldClaim3DiagnosisCodeNine.setDisable(true);
			//
			Text textClaim3DiagnosisNameTen = new Text();
			textClaim3DiagnosisNameTen.setText("10.");
			textClaim3DiagnosisNameTen.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
			textClaim3DiagnosisNameTen.setFill(Color.BLACK);
			textClaim3DiagnosisNameTen.setLayoutX(691);
			textClaim3DiagnosisNameTen.setLayoutY(395);

			ComboBox<String> textFieldClaim3DiagnosisCodeTen = new ComboBox<String>();
			textFieldClaim3DiagnosisCodeTen.getItems().addAll("R69 - Illness, unspecified","A000 - Cholera due to Vibrio cholerae 01, biovar cholerae","A001 - Cholera due to Vibrio cholerae 01, biovar eltor","A009 - Cholera, unspecified","A0100 - Typhoid fever, unspecified","A0101 - Typhoid meningitis","A0102 - Typhoid fever with heart involvement","A0103 - Typhoid pneumonia","A0104 - Typhoid arthritis","A0105 - Typhoid osteomyelitis","A0109 - Typhoid fever with other complications","A011 - Paratyphoid fever A","A012 - Paratyphoid fever B","A013 - Paratyphoid fever C","A014 - Paratyphoid fever, unspecified","A020 - Salmonella enteritis","A021 - Salmonella sepsis","A0220 - Localized salmonella infection, unspecified","A0221 - Salmonella meningitis","A0222 - Salmonella pneumonia","A0223 - Salmonella arthritis");
			textFieldClaim3DiagnosisCodeTen.setEditable(false); 
			textFieldClaim3DiagnosisCodeTen.setMinWidth(140);
			textFieldClaim3DiagnosisCodeTen.setMaxWidth(140);
			textFieldClaim3DiagnosisCodeTen.setMinHeight(25);
			textFieldClaim3DiagnosisCodeTen.setLayoutX(711);
			textFieldClaim3DiagnosisCodeTen.setLayoutY(378);
			textFieldClaim3DiagnosisCodeTen.setTooltip(new Tooltip("10th Diagnosis or Nature of Illness or Injury Code"));
			textFieldClaim3DiagnosisCodeTen.setValue("Select");;
			textFieldClaim3DiagnosisCodeTen.setStyle("-fx-font: 14px \"Calibri\";");
			textFieldClaim3DiagnosisCodeTen.setDisable(true);
			//
			Text textClaim3DiagnosisNameEleven = new Text();
			textClaim3DiagnosisNameEleven.setText("11.");
			textClaim3DiagnosisNameEleven.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
			textClaim3DiagnosisNameEleven.setFill(Color.BLACK);
			textClaim3DiagnosisNameEleven.setLayoutX(878);
			textClaim3DiagnosisNameEleven.setLayoutY(395);

			ComboBox<String> textFieldClaim3DiagnosisCodeEleven = new ComboBox<String>();
			textFieldClaim3DiagnosisCodeEleven.getItems().addAll("R69 - Illness, unspecified","A000 - Cholera due to Vibrio cholerae 01, biovar cholerae","A001 - Cholera due to Vibrio cholerae 01, biovar eltor","A009 - Cholera, unspecified","A0100 - Typhoid fever, unspecified","A0101 - Typhoid meningitis","A0102 - Typhoid fever with heart involvement","A0103 - Typhoid pneumonia","A0104 - Typhoid arthritis","A0105 - Typhoid osteomyelitis","A0109 - Typhoid fever with other complications","A011 - Paratyphoid fever A","A012 - Paratyphoid fever B","A013 - Paratyphoid fever C","A014 - Paratyphoid fever, unspecified","A020 - Salmonella enteritis","A021 - Salmonella sepsis","A0220 - Localized salmonella infection, unspecified","A0221 - Salmonella meningitis","A0222 - Salmonella pneumonia","A0223 - Salmonella arthritis");
			textFieldClaim3DiagnosisCodeEleven.setEditable(false); 
			textFieldClaim3DiagnosisCodeEleven.setMinWidth(140);
			textFieldClaim3DiagnosisCodeEleven.setMaxWidth(140);
			textFieldClaim3DiagnosisCodeEleven.setMinHeight(25);
			textFieldClaim3DiagnosisCodeEleven.setLayoutX(898);
			textFieldClaim3DiagnosisCodeEleven.setLayoutY(378);
			textFieldClaim3DiagnosisCodeEleven.setTooltip(new Tooltip("11th Diagnosis or Nature of Illness or Injury Code"));
			textFieldClaim3DiagnosisCodeEleven.setValue("Select");;
			textFieldClaim3DiagnosisCodeEleven.setStyle("-fx-font: 14px \"Calibri\";");
			textFieldClaim3DiagnosisCodeEleven.setDisable(true);
			//
			Text textClaim3DiagnosisNameTwelve = new Text();
			textClaim3DiagnosisNameTwelve.setText("12.");
			textClaim3DiagnosisNameTwelve.setFont(Font.font("Calibri", FontWeight.BOLD, 12));
			textClaim3DiagnosisNameTwelve.setFill(Color.BLACK);
			textClaim3DiagnosisNameTwelve.setLayoutX(1066);
			textClaim3DiagnosisNameTwelve.setLayoutY(395);

			ComboBox<String> textFieldClaim3DiagnosisCodeTwelve = new ComboBox<String>();
			textFieldClaim3DiagnosisCodeTwelve.getItems().addAll("R69 - Illness, unspecified","A000 - Cholera due to Vibrio cholerae 01, biovar cholerae","A001 - Cholera due to Vibrio cholerae 01, biovar eltor","A009 - Cholera, unspecified","A0100 - Typhoid fever, unspecified","A0101 - Typhoid meningitis","A0102 - Typhoid fever with heart involvement","A0103 - Typhoid pneumonia","A0104 - Typhoid arthritis","A0105 - Typhoid osteomyelitis","A0109 - Typhoid fever with other complications","A011 - Paratyphoid fever A","A012 - Paratyphoid fever B","A013 - Paratyphoid fever C","A014 - Paratyphoid fever, unspecified","A020 - Salmonella enteritis","A021 - Salmonella sepsis","A0220 - Localized salmonella infection, unspecified","A0221 - Salmonella meningitis","A0222 - Salmonella pneumonia","A0223 - Salmonella arthritis");
			textFieldClaim3DiagnosisCodeTwelve.setEditable(false); 
			textFieldClaim3DiagnosisCodeTwelve.setMinWidth(140);
			textFieldClaim3DiagnosisCodeTwelve.setMaxWidth(140);
			textFieldClaim3DiagnosisCodeTwelve.setMinHeight(25);
			textFieldClaim3DiagnosisCodeTwelve.setLayoutX(1088);
			textFieldClaim3DiagnosisCodeTwelve.setLayoutY(378);
			textFieldClaim3DiagnosisCodeTwelve.setTooltip(new Tooltip("12th Diagnosis or Nature of Illness or Injury Code"));
			textFieldClaim3DiagnosisCodeTwelve.setValue("Select");;
			textFieldClaim3DiagnosisCodeTwelve.setStyle("-fx-font: 14px \"Calibri\";");
			textFieldClaim3DiagnosisCodeTwelve.setDisable(true);


			textFieldClaim3DiagnosisCodeOne.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(textFieldClaim3DiagnosisCodeOne.getSelectionModel().getSelectedIndex()!=-1)
					{

						textFieldClaim3DiagnosisCodeTwo.setDisable(false);
					}
					else
					{
						textFieldClaim3DiagnosisCodeTwo.setDisable(true);
					}
				}});

			textFieldClaim3DiagnosisCodeTwo.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(textFieldClaim3DiagnosisCodeTwo.getSelectionModel().getSelectedIndex()!=-1)
					{

						textFieldClaim3DiagnosisCodeThree.setDisable(false);
					}
					else
					{
						textFieldClaim3DiagnosisCodeThree.setDisable(true);
					}
				}});

			textFieldClaim3DiagnosisCodeThree.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(textFieldClaim3DiagnosisCodeThree.getSelectionModel().getSelectedIndex()!=-1)
					{

						textFieldClaim3DiagnosisCodeFour.setDisable(false);
					}
					else
					{
						textFieldClaim3DiagnosisCodeFour.setDisable(true);
					}

				}});

			textFieldClaim3DiagnosisCodeFour.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(textFieldClaim3DiagnosisCodeFour.getSelectionModel().getSelectedIndex()!=-1)
					{

						textFieldClaim3DiagnosisCodeFive.setDisable(false);
					}
					else
					{
						textFieldClaim3DiagnosisCodeFive.setDisable(true);
					}
				}});

			textFieldClaim3DiagnosisCodeFive.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(textFieldClaim3DiagnosisCodeFive.getSelectionModel().getSelectedIndex()!=-1)
					{
						textFieldClaim3DiagnosisCodeSix.setDisable(false);
					}
					else
					{
						textFieldClaim3DiagnosisCodeSix.setDisable(true);
					}
				}});

			textFieldClaim3DiagnosisCodeSix.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(textFieldClaim3DiagnosisCodeSix.getSelectionModel().getSelectedIndex()!=-1)
					{

						textFieldClaim3DiagnosisCodeSeven.setDisable(false);
					}
					else
					{
						textFieldClaim3DiagnosisCodeSeven.setDisable(true);
					}
				}});

			textFieldClaim3DiagnosisCodeSeven.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(textFieldClaim3DiagnosisCodeSeven.getSelectionModel().getSelectedIndex()!=-1)
					{

						textFieldClaim3DiagnosisCodeEight.setDisable(false);
					}
					else
					{
						textFieldClaim3DiagnosisCodeEight.setDisable(true);
					}
				}});

			textFieldClaim3DiagnosisCodeEight.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(textFieldClaim3DiagnosisCodeEight.getSelectionModel().getSelectedIndex()!=-1)
					{

						textFieldClaim3DiagnosisCodeNine.setDisable(false);
					}
					else
					{
						textFieldClaim3DiagnosisCodeNine.setDisable(true);
					}
				}});

			textFieldClaim3DiagnosisCodeNine.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(textFieldClaim3DiagnosisCodeNine.getSelectionModel().getSelectedIndex()!=-1)
					{

						textFieldClaim3DiagnosisCodeTen.setDisable(false);
					}
					else
					{
						textFieldClaim3DiagnosisCodeTen.setDisable(true);
					}
				}});

			textFieldClaim3DiagnosisCodeTen.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(textFieldClaim3DiagnosisCodeTen.getSelectionModel().getSelectedIndex()!=-1)
					{

						textFieldClaim3DiagnosisCodeEleven.setDisable(false);
					}
					else
					{
						textFieldClaim3DiagnosisCodeEleven.setDisable(true);
					}
				}});

			textFieldClaim3DiagnosisCodeEleven.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(textFieldClaim3DiagnosisCodeEleven.getSelectionModel().getSelectedIndex()!=-1)
					{

						textFieldClaim3DiagnosisCodeTwelve.setDisable(false);
					}
					else
					{
						textFieldClaim3DiagnosisCodeTwelve.setDisable(true);
					}
				}});


			Line line7 = new Line(); 
			line7.setStartX(100); 
			line7.setStartY(414); 
			line7.setEndX(1225); 
			line7.setEndY(414);

			Text textClaim3ResubmissionCode = new Text();
			textClaim3ResubmissionCode.setText("Resubmission Code");
			textClaim3ResubmissionCode.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3ResubmissionCode.setFill(Color.BLACK);
			textClaim3ResubmissionCode.setLayoutX(100);
			textClaim3ResubmissionCode.setLayoutY(441);

			ComboBox<String> Claim3ResubmissonCoeCombo = new ComboBox<String>();
			Claim3ResubmissonCoeCombo.getItems().addAll("Corrected Claim","Void Claim","Nones");
			Claim3ResubmissonCoeCombo.setEditable(false); 
			Claim3ResubmissonCoeCombo.setMinWidth(200);
			Claim3ResubmissonCoeCombo.setMinHeight(25);
			Claim3ResubmissonCoeCombo.setLayoutX(225);
			Claim3ResubmissonCoeCombo.setLayoutY(424);
			Claim3ResubmissonCoeCombo.setTooltip(new Tooltip("Select Resubmission Code"));
			Claim3ResubmissonCoeCombo.setValue("Select");;
			Claim3ResubmissonCoeCombo.setStyle("-fx-font: 14px \"Calibri\";");

			Text textClaim3OriginalReferencNo = new Text();
			textClaim3OriginalReferencNo.setText("Original Reference"+'\n'+ "Number");
			textClaim3OriginalReferencNo.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3OriginalReferencNo.setFill(Color.BLACK);
			textClaim3OriginalReferencNo.setLayoutX(500);
			textClaim3OriginalReferencNo.setLayoutY(434);

			TextField textFieldClaim3OriginalReferenceNo= new TextField();
			textFieldClaim3OriginalReferenceNo.setLayoutX(625);
			textFieldClaim3OriginalReferenceNo.setLayoutY(424);
			textFieldClaim3OriginalReferenceNo.setPrefWidth(200);
			textFieldClaim3OriginalReferenceNo.setPrefHeight(25);
			textFieldClaim3OriginalReferenceNo.setEditable(true);
			textFieldClaim3OriginalReferenceNo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim3OriginalReferenceNo.setTooltip(new Tooltip("Enter Original Reference Number"));
			textFieldClaim3OriginalReferenceNo.setPromptText("Reference Number");


			Text textClaim3PriorAuthorizationNo = new Text();
			textClaim3PriorAuthorizationNo.setText("Prior Authorization"+'\n'+ "Number");
			textClaim3PriorAuthorizationNo.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3PriorAuthorizationNo.setFill(Color.BLACK);
			textClaim3PriorAuthorizationNo.setLayoutX(900);
			textClaim3PriorAuthorizationNo.setLayoutY(434);

			TextField textFieldClaim3PriorAuthorizationNo= new TextField();
			textFieldClaim3PriorAuthorizationNo.setLayoutX(1025);
			textFieldClaim3PriorAuthorizationNo.setLayoutY(424);
			textFieldClaim3PriorAuthorizationNo.setPrefWidth(200);
			textFieldClaim3PriorAuthorizationNo.setPrefHeight(25);
			textFieldClaim3PriorAuthorizationNo.setEditable(true);
			textFieldClaim3PriorAuthorizationNo.setFont(Font.font("Calibri", FontWeight.NORMAL, 14));
			textFieldClaim3PriorAuthorizationNo.setTooltip(new Tooltip("Enter Prior Authorization Number"));
			textFieldClaim3PriorAuthorizationNo.setPromptText("Prior Authorization Number");

			Claim3ResubmissonCoeCombo.setValue("Select");
			textFieldClaim3OriginalReferenceNo.setPromptText("Reference Number");
			textFieldClaim3PriorAuthorizationNo.setPromptText("Prior Authorization Number");

			Line line8 = new Line(); 
			line8.setStartX(100); 
			line8.setStartY(460); 
			line8.setEndX(1225); 
			line8.setEndY(460);

			///////////////////////////////////////////////////////////

			Text textClaim3AdditionalClaimLevelInfo = new Text();
			textClaim3AdditionalClaimLevelInfo.setText("Additional Information Claim Level");
			textClaim3AdditionalClaimLevelInfo.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3AdditionalClaimLevelInfo.setFill(Color.BLACK);
			textClaim3AdditionalClaimLevelInfo.setLayoutX(100);
			textClaim3AdditionalClaimLevelInfo.setLayoutY(480);

			TableView<Person> table = new TableView<>();
			table.setEditable(true);
			ObservableList<Person> data =FXCollections.observableArrayList(new Person("05/05/2017", "08/08/2017", "ABC","DEF","GHI","JKL","MNO"));

			table.setLayoutX(100);
			table.setLayoutY(490);

			TableColumn firstcol = new TableColumn("Date of Service From");
			firstcol.setMinWidth(160);
			firstcol.setCellValueFactory(new PropertyValueFactory<>("DOSFrom"));

			TableColumn secondcol = new TableColumn("Date of Service To");
			secondcol.setMinWidth(160);
			secondcol.setCellValueFactory(new PropertyValueFactory<>("DOSTo"));

			TableColumn thirdcol = new TableColumn("Place of Service");
			thirdcol.setMinWidth(160);
			thirdcol.setCellValueFactory(new PropertyValueFactory<>("PlaceOfService"));

			TableColumn fourcol = new TableColumn("C.P.T");
			fourcol.setMinWidth(160);
			fourcol.setCellValueFactory(new PropertyValueFactory<>("CPT"));

			TableColumn fivecol = new TableColumn("Modifiers");
			fivecol.setMinWidth(160);
			fivecol.setCellValueFactory(new PropertyValueFactory<>("MOD"));

			TableColumn sixcol = new TableColumn("Charges");
			sixcol.setMinWidth(160);
			sixcol.setCellValueFactory(new PropertyValueFactory<>("Charges"));

			TableColumn sevencol = new TableColumn("Units");
			sevencol.setMinWidth(160);
			sevencol.setCellValueFactory(new PropertyValueFactory<>("Units"));

			table.setItems(data);
			table.setMaxHeight(20);
			table.getColumns().addAll(firstcol, secondcol,thirdcol,fourcol,fivecol,sixcol,sevencol);

			DatePicker row1col1 = new DatePicker();
			row1col1.setLayoutX(100);
			row1col1.setLayoutY(515);
			row1col1.setPrefWidth(161);
			row1col1.setPrefHeight(10);
			row1col1.setPromptText("MM/DD/YYYY");
			row1col1.setTooltip(new Tooltip("Date of Service From"));
			row1col1.setEditable(false);
			row1col1.setStyle("-fx-font: 12px \"Calibri\";");
			row1col1.setOnAction(e ->
			{
				LocalDate date = row1col1.getValue();
			});

			Text textClaimThreerow1col1star= new Text();
			textClaimThreerow1col1star.setText("*");
			textClaimThreerow1col1star.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaimThreerow1col1star.setFill(Color.RED);
			textClaimThreerow1col1star.setLayoutX(255);
			textClaimThreerow1col1star.setLayoutY(518);
			//textClaimThreerow1col1star.setVisible(true);

			row1col1.valueProperty().addListener((observable, oldValue, newValue) -> {
				if(row1col1.getValue().toString().isEmpty()==false)
					textClaimThreerow1col1star.setVisible(false);
				else
					textClaimThreerow1col1star.setVisible(true);});

			DatePicker row1col2 = new DatePicker();
			row1col2.setLayoutX(260);
			row1col2.setLayoutY(515);
			row1col2.setPrefWidth(161);
			row1col2.setPrefHeight(10);
			row1col2.setPromptText("MM/DD/YYYY");
			row1col2.setTooltip(new Tooltip("Date of Service To"));
			row1col2.setEditable(false);
			row1col2.setStyle("-fx-font: 12px \"Calibri\";");

			row1col2.setOnAction(e ->
			{
				LocalDate date = row1col2.getValue();
			});
			TextField row1col3 = new TextField();
			row1col3.setPromptText("Place of Service");
			row1col3.setLayoutX(420);
			row1col3.setMaxWidth(161);
			row1col3.setMinWidth(161);
			row1col3.setLayoutY(515);
			row1col3.setTooltip(new Tooltip("Place of Service"));
			row1col3.setPrefHeight(10);
			row1col3.setEditable(true);
			row1col3.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));

			Text textClaim3row1col3star= new Text();
			textClaim3row1col3star.setText("*");
			textClaim3row1col3star.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3row1col3star.setFill(Color.RED);
			textClaim3row1col3star.setLayoutX(575);
			textClaim3row1col3star.setLayoutY(518);

			row1col3.textProperty().addListener((observable, oldValue, newValue) -> {
				if(row1col3.getText().isEmpty()==false)
					textClaim3row1col3star.setVisible(false);
				else
					textClaim3row1col3star.setVisible(true);
			});

			TextField row1col4 = new TextField();
			row1col4.setPromptText("C.P.T");
			row1col4.setLayoutX(580);
			row1col4.setMaxWidth(161);
			row1col4.setMinWidth(161);
			row1col4.setLayoutY(515);
			row1col4.setTooltip(new Tooltip("C.P.T"));
			row1col4.setPrefHeight(10);
			row1col4.setEditable(true);
			row1col4.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));

			Text textClaim3row1col4star= new Text();
			textClaim3row1col4star.setText("*");
			textClaim3row1col4star.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3row1col4star.setFill(Color.RED);
			textClaim3row1col4star.setLayoutX(735);
			textClaim3row1col4star.setLayoutY(518);

			row1col4.textProperty().addListener((observable, oldValue, newValue) -> {
				if(row1col4.getText().isEmpty()==false)
					textClaim3row1col4star.setVisible(false);
				else
					textClaim3row1col4star.setVisible(true);
			});

			TextField row1col5 = new TextField();
			row1col5.setPromptText("MOD 1,MOD 2,MOD 3,MOD 4");
			row1col5.setLayoutX(740);
			row1col5.setMaxWidth(161);
			row1col5.setMinWidth(161);
			row1col5.setLayoutY(515);
			row1col5.setTooltip(new Tooltip("MOD"));
			row1col5.setPrefHeight(10);
			row1col5.setEditable(true);
			row1col5.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));

			TextField row1col6 = new TextField();
			row1col6.setPromptText("Charges in $");
			row1col6.setLayoutX(900);
			row1col6.setMaxWidth(161);
			row1col6.setMinWidth(161);
			row1col6.setLayoutY(515);
			row1col6.setTooltip(new Tooltip("Charges in $"));
			row1col6.setPrefHeight(10);
			row1col6.setEditable(true);
			row1col6.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));

			Text textClaim3row1col6star= new Text();
			textClaim3row1col6star.setText("*");
			textClaim3row1col6star.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3row1col6star.setFill(Color.RED);
			textClaim3row1col6star.setLayoutX(1055);
			textClaim3row1col6star.setLayoutY(518);

			row1col6.textProperty().addListener((observable, oldValue, newValue) -> {
				if(row1col6.getText().isEmpty()==false)
					textClaim3row1col6star.setVisible(false);
				else
					textClaim3row1col6star.setVisible(true);
			});

			TextField row1col7 = new TextField();
			row1col7.setPromptText("Units");
			row1col7.setLayoutX(1060);
			row1col7.setMaxWidth(162);
			row1col7.setMinWidth(162);
			row1col7.setLayoutY(515);
			row1col7.setTooltip(new Tooltip("Units"));
			row1col7.setPrefHeight(10);
			row1col7.setEditable(true);
			row1col7.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));

			Text textClaim3row1col7star= new Text();
			textClaim3row1col7star.setText("*");
			textClaim3row1col7star.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
			textClaim3row1col7star.setFill(Color.RED);
			textClaim3row1col7star.setLayoutX(1215);
			textClaim3row1col7star.setLayoutY(518);

			row1col7.textProperty().addListener((observable, oldValue, newValue) -> {
				if(row1col7.getText().isEmpty()==false)
					textClaim3row1col7star.setVisible(false);
				else
					textClaim3row1col7star.setVisible(true);
			});

			////////////////////////Row 2
			DatePicker row2col1 = new DatePicker();
			row2col1.setLayoutX(100);
			row2col1.setLayoutY(537);
			row2col1.setPrefWidth(161);
			row2col1.setPrefHeight(10);
			row2col1.setPromptText("MM/DD/YYYY");
			row2col1.setTooltip(new Tooltip("Date of Service From"));
			row2col1.setEditable(false);
			row2col1.setStyle("-fx-font: 12px \"Calibri\";");
			row2col1.setVisible(false);
			row2col1.setOnAction(e ->
			{
				LocalDate date = row2col1.getValue();
			});
			DatePicker row2col2 = new DatePicker();
			row2col2.setLayoutX(260);
			row2col2.setLayoutY(537);
			row2col2.setPrefWidth(161);
			row2col2.setPrefHeight(10);
			row2col2.setPromptText("MM/DD/YYYY");
			row2col2.setTooltip(new Tooltip("Date of Service To"));
			row2col2.setEditable(false);
			row2col2.setVisible(false);
			row2col2.setStyle("-fx-font: 12px \"Calibri\";");

			row2col2.setOnAction(e ->
			{
				LocalDate date = row2col2.getValue();
			});
			TextField row2col3 = new TextField();
			row2col3.setPromptText("Place of Service");
			row2col3.setLayoutX(420);
			row2col3.setMaxWidth(161);
			row2col3.setMinWidth(161);
			row2col3.setLayoutY(537);
			row2col3.setTooltip(new Tooltip("Place of Service"));
			row2col3.setPrefHeight(10);
			row2col3.setEditable(true);
			row2col3.setVisible(false);
			row2col3.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			TextField row2col4 = new TextField();
			row2col4.setPromptText("C.P.T");
			row2col4.setLayoutX(580);
			row2col4.setMaxWidth(161);
			row2col4.setMinWidth(161);
			row2col4.setLayoutY(537);
			row2col4.setTooltip(new Tooltip("C.P.T"));
			row2col4.setPrefHeight(10);
			row2col4.setVisible(false);
			row2col4.setEditable(true);
			row2col4.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			TextField row2col5 = new TextField();
			row2col5.setPromptText("MOD 1,MOD 2,MOD 3,MOD 4");
			row2col5.setLayoutX(740);
			row2col5.setMaxWidth(161);
			row2col5.setMinWidth(161);
			row2col5.setLayoutY(537);
			row2col5.setTooltip(new Tooltip("MOD 1,MOD 2,MOD 3,MOD 4"));
			row2col5.setPrefHeight(10);
			row2col5.setEditable(true);
			row2col5.setVisible(false);
			row2col5.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));		
			TextField row2col6 = new TextField();
			row2col6.setPromptText("Charges in $");
			row2col6.setLayoutX(900);
			row2col6.setMaxWidth(161);
			row2col6.setMinWidth(161);
			row2col6.setLayoutY(537);
			row2col6.setTooltip(new Tooltip("Charges in $"));
			row2col6.setPrefHeight(10);
			row2col6.setVisible(false);
			row2col6.setEditable(true);
			row2col6.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			TextField row2col7 = new TextField();
			row2col7.setPromptText("Units");
			row2col7.setLayoutX(1060);
			row2col7.setMaxWidth(162);
			row2col7.setMinWidth(162);
			row2col7.setLayoutY(537);
			row2col7.setTooltip(new Tooltip("Units"));
			row2col7.setPrefHeight(10);
			row2col7.setEditable(true);
			row2col7.setVisible(false);
			row2col7.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			///////////////////////////////

			////////////////////////Row 3
			DatePicker row3col1 = new DatePicker();
			row3col1.setLayoutX(100);
			row3col1.setLayoutY(559);
			row3col1.setPrefWidth(161);
			row3col1.setPrefHeight(10);
			row3col1.setPromptText("MM/DD/YYYY");
			row3col1.setTooltip(new Tooltip("Date of Service From"));
			row3col1.setEditable(false);
			row3col1.setStyle("-fx-font: 12px \"Calibri\";");
			row3col1.setVisible(false);
			row3col1.setOnAction(e ->
			{
				LocalDate date = row3col1.getValue();
			});
			DatePicker row3col2 = new DatePicker();
			row3col2.setLayoutX(260);
			row3col2.setLayoutY(559);
			row3col2.setPrefWidth(161);
			row3col2.setPrefHeight(10);
			row3col2.setPromptText("MM/DD/YYYY");
			row3col2.setTooltip(new Tooltip("Date of Service To"));
			row3col2.setEditable(false);
			row3col2.setVisible(false);
			row3col2.setStyle("-fx-font: 12px \"Calibri\";");

			row3col2.setOnAction(e ->
			{
				LocalDate date = row3col2.getValue();
			});
			TextField row3col3 = new TextField();
			row3col3.setPromptText("Place of Service");
			row3col3.setLayoutX(420);
			row3col3.setMaxWidth(161);
			row3col3.setMinWidth(161);
			row3col3.setLayoutY(559);
			row3col3.setTooltip(new Tooltip("Place of Service"));
			row3col3.setPrefHeight(10);
			row3col3.setEditable(true);
			row3col3.setVisible(false);
			row3col3.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			TextField row3col4 = new TextField();
			row3col4.setPromptText("C.P.T");
			row3col4.setLayoutX(580);
			row3col4.setMaxWidth(161);
			row3col4.setMinWidth(161);
			row3col4.setLayoutY(559);
			row3col4.setTooltip(new Tooltip("C.P.T"));
			row3col4.setPrefHeight(10);
			row3col4.setVisible(false);
			row3col4.setEditable(true);
			row3col4.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			TextField row3col5 = new TextField();
			row3col5.setPromptText("MOD 1,MOD 2,MOD 3,MOD 4");
			row3col5.setLayoutX(740);
			row3col5.setMaxWidth(161);
			row3col5.setMinWidth(161);
			row3col5.setLayoutY(559);
			row3col5.setTooltip(new Tooltip("MOD 1,MOD 2,MOD 3,MOD 4"));
			row3col5.setPrefHeight(10);
			row3col5.setEditable(true);
			row3col5.setVisible(false);
			row3col5.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));		
			TextField row3col6 = new TextField();
			row3col6.setPromptText("Charges in $");
			row3col6.setLayoutX(900);
			row3col6.setMaxWidth(161);
			row3col6.setMinWidth(161);
			row3col6.setLayoutY(559);
			row3col6.setTooltip(new Tooltip("Charges in $"));
			row3col6.setPrefHeight(10);
			row3col6.setVisible(false);
			row3col6.setEditable(true);
			row3col6.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			TextField row3col7 = new TextField();
			row3col7.setPromptText("Units");
			row3col7.setLayoutX(1060);
			row3col7.setMaxWidth(162);
			row3col7.setMinWidth(162);
			row3col7.setLayoutY(559);
			row3col7.setTooltip(new Tooltip("Units"));
			row3col7.setPrefHeight(10);
			row3col7.setEditable(true);
			row3col7.setVisible(false);
			row3col7.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			///////////////////////////////////////////////////////

			////////////////////////Row 4
			DatePicker row4col1 = new DatePicker();
			row4col1.setLayoutX(100);
			row4col1.setLayoutY(581);
			row4col1.setPrefWidth(161);
			row4col1.setPrefHeight(10);
			row4col1.setPromptText("MM/DD/YYYY");
			row4col1.setTooltip(new Tooltip("Date of Service From"));
			row4col1.setEditable(false);
			row4col1.setStyle("-fx-font: 12px \"Calibri\";");
			row4col1.setVisible(false);
			row4col1.setOnAction(e ->
			{
				LocalDate date = row4col1.getValue();
			});
			DatePicker row4col2 = new DatePicker();
			row4col2.setLayoutX(260);
			row4col2.setLayoutY(581);
			row4col2.setPrefWidth(161);
			row4col2.setPrefHeight(10);
			row4col2.setPromptText("MM/DD/YYYY");
			row4col2.setTooltip(new Tooltip("Date of Service To"));
			row4col2.setEditable(false);
			row4col2.setVisible(false);
			row4col2.setStyle("-fx-font: 12px \"Calibri\";");

			row4col2.setOnAction(e ->
			{
				LocalDate date = row4col2.getValue();
			});
			TextField row4col3 = new TextField();
			row4col3.setPromptText("Place of Service");
			row4col3.setLayoutX(420);
			row4col3.setMaxWidth(161);
			row4col3.setMinWidth(161);
			row4col3.setLayoutY(581);
			row4col3.setTooltip(new Tooltip("Place of Service"));
			row4col3.setPrefHeight(10);
			row4col3.setEditable(true);
			row4col3.setVisible(false);
			row4col3.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			TextField row4col4 = new TextField();
			row4col4.setPromptText("C.P.T");
			row4col4.setLayoutX(580);
			row4col4.setMaxWidth(161);
			row4col4.setMinWidth(161);
			row4col4.setLayoutY(581);
			row4col4.setTooltip(new Tooltip("C.P.T"));
			row4col4.setPrefHeight(10);
			row4col4.setVisible(false);
			row4col4.setEditable(true);
			row4col4.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			TextField row4col5 = new TextField();
			row4col5.setPromptText("MOD 1,MOD 2,MOD 3,MOD 4");
			row4col5.setLayoutX(740);
			row4col5.setMaxWidth(161);
			row4col5.setMinWidth(161);
			row4col5.setLayoutY(581);
			row4col5.setTooltip(new Tooltip("MOD 1,MOD 2,MOD 3,MOD 4"));
			row4col5.setPrefHeight(10);
			row4col5.setEditable(true);
			row4col5.setVisible(false);
			row4col5.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));		
			TextField row4col6 = new TextField();
			row4col6.setPromptText("Charges in $");
			row4col6.setLayoutX(900);
			row4col6.setMaxWidth(161);
			row4col6.setMinWidth(161);
			row4col6.setLayoutY(581);
			row4col6.setTooltip(new Tooltip("Charges in $"));
			row4col6.setPrefHeight(10);
			row4col6.setVisible(false);
			row4col6.setEditable(true);
			row4col6.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			TextField row4col7 = new TextField();
			row4col7.setPromptText("Units");
			row4col7.setLayoutX(1060);
			row4col7.setMaxWidth(162);
			row4col7.setMinWidth(162);
			row4col7.setLayoutY(581);
			row4col7.setTooltip(new Tooltip("Units"));
			row4col7.setPrefHeight(10);
			row4col7.setEditable(true);
			row4col7.setVisible(false);
			row4col7.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			///////////////////////////////////////////////////////

			Button addButtonrow1 = new Button("Add Row");
			addButtonrow1.setLayoutX(1230);
			addButtonrow1.setLayoutY(515);
			addButtonrow1.setMinWidth(60);
			addButtonrow1.setMaxWidth(60);
			addButtonrow1.setMaxHeight(20);
			addButtonrow1.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			addButtonrow1.setMinHeight(20);

			Button addButtonrow2 = new Button("Add Row");
			addButtonrow2.setLayoutX(1230);
			addButtonrow2.setLayoutY(537);
			addButtonrow2.setMinWidth(60);
			addButtonrow2.setMaxWidth(60);
			addButtonrow2.setMaxHeight(20);
			addButtonrow2.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			addButtonrow2.setMinHeight(20);
			addButtonrow2.setVisible(false);

			Button addButtonrow3 = new Button("Add Row");
			addButtonrow3.setLayoutX(1230);
			addButtonrow3.setLayoutY(559);
			addButtonrow3.setMinWidth(60);
			addButtonrow3.setMaxWidth(60);
			addButtonrow3.setMaxHeight(20);
			addButtonrow3.setFont(Font.font("Calibri", FontWeight.NORMAL, 12));
			addButtonrow3.setMinHeight(20);
			addButtonrow3.setVisible(false);

			addButtonrow1.setOnAction(new EventHandler<ActionEvent>() 	{
				public void handle(ActionEvent event) 
				{
					row2col1.setVisible(true);
					row2col2.setVisible(true);
					row2col3.setVisible(true);
					row2col4.setVisible(true);
					row2col5.setVisible(true);
					row2col6.setVisible(true);
					row2col7.setVisible(true);
					addButtonrow1.setVisible(false);
					addButtonrow2.setVisible(true);
				}
			});
			addButtonrow2.setOnAction(new EventHandler<ActionEvent>() 	{
				public void handle(ActionEvent event) 
				{
					row3col1.setVisible(true);
					row3col2.setVisible(true);
					row3col3.setVisible(true);
					row3col4.setVisible(true);
					row3col5.setVisible(true);
					row3col6.setVisible(true);
					row3col7.setVisible(true);
					addButtonrow2.setVisible(false);
					addButtonrow3.setVisible(true);
				}
			});

			addButtonrow3.setOnAction(new EventHandler<ActionEvent>() 	{
				public void handle(ActionEvent event) 
				{
					row4col1.setVisible(true);
					row4col2.setVisible(true);
					row4col3.setVisible(true);
					row4col4.setVisible(true);
					row4col5.setVisible(true);
					row4col6.setVisible(true);
					row4col7.setVisible(true);
					addButtonrow3.setVisible(false);

				}
			});


			ClaimOneAutoFill.setOnAction(new EventHandler<ActionEvent>() 	{
				public void handle(ActionEvent event) 
				{
					//Page 1
					ClaimOneInsProgCombo.getSelectionModel().select(2);
					textFieldClaimOneInsuredIdNumber.setText("763489253");
					textFieldClaimOnePatientFName.setText("FNAME");
					textFieldClaimOnePatientMName.setText("M");
					textFieldClaimOnePatientLName.setText("LNAME");
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyy");
					LocalDate localDate = LocalDate.now();
					ClaimOnePatientDOB.setValue(localDate);
					textFieldClaimOnePatientAddressOne.setText("Aetna Inc.");
					textFieldClaimOnePatientAddressTwo.setText("151 Farmington Avenue");
					textFieldClaimOnePatientCity.setText("Hartford");
					textFieldClaimOnePatientZip.setText("06156");
					ClaimOnepatientStateCombo.getSelectionModel().select("CT");
					ClaimOnepatientGenderCombo.getSelectionModel().select(1);
					textFieldClaimOnePatientPhnNo.setText("18008723862");
					ClaimOneRelationWithInsuredCombo.getSelectionModel().select(0);
					ClaimOnePatientConditionStateCombo.getSelectionModel().select(-1);
					ClaimOnePatientConditionStateCombo.setPromptText("Select");
					ClaimOneCheckPatientConditionRelatedtoAutoAccident.setSelected(false);
					ClaimOneCheckPatientConditionRelatedtoEmployment.setSelected(false);
					ClaimOneCheckPatientConditionRelatedtoOtherAccident.setSelected(false);
					textFieldClaimOneInsuredPolicyGroupFECA.setText("INS0000001");
					//page 2
					textFieldClaim2FederalTaxIDNo.setText("100000001");
					textFieldClaim2ServicePhysicianName.setText("Aetna Inc.");
					textFieldClaim2ServiceFacilityPhysicianAddressOne.setText("Aetna Inc.");
					textFieldClaim2ServiceFacilityPhysicianAddressTwo.setText("151 Farmington Avenue");
					textFieldClaim2ServiceFacilityPhysicianCity.setText("Hartford");
					textFieldClaim2ServiceFacilityPhysicianZip.setText("06156");
					Claim2ServiceFacilityPhysicianStateCombo.getSelectionModel().select("CT");
					textFieldClaim2ServicePhysicianPhoneNo.clear();
					textFieldClaim2ServicePhysicianNPI.clear();
					textFieldClaim2ServiceFacilityPaytoProvierAddressOne.clear();
					textFieldClaim2ServiceFacilityPayToProviderAddressTwo.clear();
					textFieldClaim2ServiceFacilityPayToProviderCity.clear();
					textFieldClaim2ServiceFacilitypayToProviderfZip.clear();
					Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().select(-1);
					Claim2ServiceFacilityPAYTOpROviderStateCombo.setPromptText("Select");
					textFieldClaim3DiagnosisCodeOne.getSelectionModel().select(0);
					textFieldClaim3PatientAccountNo.setText("1000000001");
					textFieldClaim3TotalCharges.setText("99.99");
					row1col1.setValue(localDate);
					row1col2.setValue(localDate);
					row1col3.setText("A1");
					row1col4.setText("99213");
					row1col5.setText("ABC,DEF");
					row1col6.setText("99.99");
					row1col7.setText("10");

				}
			});


			ClaimOneResetData.setOnAction(new EventHandler<ActionEvent>() 	{
				public void handle(ActionEvent event) 
				{
					ClaimOneInsProgCombo.setValue("Commercial(Other)");
					textFieldClaimOneInsuredIdNumber.setText("");
					textFieldClaimOneInsuredIdNumber.setPromptText("Insured's ID Number");
					textFieldClaimOnePatientMName.setText("");
					textFieldClaimOnePatientMName.setPromptText("M.I.");
					textFieldClaimOnePatientFName.setText("");
					textFieldClaimOnePatientFName.setPromptText("First Name");
					textFieldClaimOnePatientLName.setText("");
					textFieldClaimOnePatientLName.setPromptText("Last Name");
					ClaimOnePatientDOB.getEditor().clear();		
					ClaimOnePatientDOB.setPromptText("MM/DD/YYYY");
					textClaimOnePatientDOBstar.setVisible(true);
					ClaimOnepatientGenderCombo.setValue("Undifferentiated");
					textFieldClaimOnePatientPhnNo.setText("");
					textFieldClaimOnePatientPhnNo.setPromptText("Telephone");
					textFieldClaimOnePatientAddressOne.setText("");
					textFieldClaimOnePatientAddressOne.setPromptText("Address Line 1");
					textFieldClaimOnePatientAddressTwo.setText("");
					textFieldClaimOnePatientAddressTwo.setPromptText("Address Line 2");
					textFieldClaimOnePatientCity.setText("");
					textFieldClaimOnePatientCity.setPromptText("City");
					ClaimOnepatientStateCombo.setValue("Select");
					textClaimOnePatientStatestar.setVisible(true);
					textFieldClaimOnePatientZip.setText("");
					textFieldClaimOnePatientZip.setPromptText("Zip Code");
					ClaimOneRelationWithInsuredCombo.setValue("Self");
					textFieldClaimOneInsuredPolicyGroupFECA.setText("");
					textFieldClaimOneInsuredPolicyGroupFECA.setPromptText("Insured's Policy Number");
					textFieldClaimOneInsuredFName.setText("");
					textFieldClaimOneInsuredFName.setPromptText("First Name");
					textFieldClaimOneInsuredMName.setText("");
					textFieldClaimOneInsuredMName.setPromptText("M.I.");
					textFieldClaimOneInsuredLName.setText("");
					textFieldClaimOneInsuredLName.setPromptText("Last Name");
					ClaimOneInsuredDOB.getEditor().clear();		
					ClaimOneInsuredDOB.setPromptText("MM/DD/YYYY");
					ClaimOneInsuredDOB.setVisible(true);
					ClaimOneInsuredGenderCombo.setValue("Undifferentiated");
					textFieldClaimOneInsuredPhnNo.setText("");
					textFieldClaimOneInsuredPhnNo.setPromptText("Telephone");
					textFieldClaimOneInsuredAddressOne.setText("");
					textFieldClaimOneInsuredAddressOne.setPromptText("Address Line 1");
					textFieldClaimOneInsuredAddressTwo.setText("");
					textFieldClaimOneInsuredAddressTwo.setPromptText("Address Line 2");
					textFieldClaimOneInsuredCity.setText("");
					textFieldClaimOneInsuredCity.setPromptText("City");
					ClaimOneInsuredStateCombo.setValue("Select");
					textClaimOneInsuredStatestar.setVisible(true);
					textFieldClaimOneInsuredZip.setText("");
					textFieldClaimOneInsuredZip.setPromptText("Zip Code");
					textClaimOneInsuredLNamestar.setVisible(false);
					textClaimOneInsuredAddressOnestar.setVisible(false);
					textClaimOneInsuredCitystar.setVisible(false);
					textClaimOneInsuredStatestar.setVisible(false);
					textClaimOneInsuredZipstar.setVisible(false);
					textClaimOneInsuredDOBstar.setVisible(false);
					ClaimOneCheckPatientConditionRelatedtoEmployment.setSelected(false);
					ClaimOneCheckPatientConditionRelatedtoAutoAccident.setSelected(false);
					ClaimOneCheckPatientConditionRelatedtoOtherAccident.setSelected(false);
					ClaimOnePatientConditionStateCombo.setValue("Select");
					//Page 2
					textFieldClaim2ServicePhysicianName.setText("");
					textFieldClaim2ServicePhysicianName.setPromptText("Billing Provider Name");
					textFieldClaim2FederalTaxIDNo.setText("");
					textFieldClaim2FederalTaxIDNo.setPromptText("Federal Tax ID Number");
					textFieldClaim2ServicePhysicianPhoneNo.setText("");
					textFieldClaim2ServicePhysicianPhoneNo.setPromptText("Phone Number");
					textFieldClaim2ServicePhysicianNPI.setText("");
					textFieldClaim2ServicePhysicianNPI.setPromptText("Billing Provider NPI");
					textFieldClaim2ServiceFacilityPhysicianAddressOne.setText("");
					textFieldClaim2ServiceFacilityPhysicianAddressOne.setPromptText("Address Line 1");
					textFieldClaim2ServiceFacilityPhysicianAddressTwo.setText("");
					textFieldClaim2ServiceFacilityPhysicianAddressTwo.setPromptText("Address Line 2");
					textFieldClaim2ServiceFacilityPhysicianZip.setText("");
					textFieldClaim2ServiceFacilityPhysicianZip.setPromptText("Zip Code");
					Claim2ServiceFacilityPhysicianStateCombo.setValue("Select");
					textFieldClaim2ServiceFacilityPhysicianCity.setText("");
					textFieldClaim2ServiceFacilityPhysicianCity.setPromptText("City");
					textFieldClaim2ServiceFacilityPaytoProvierAddressOne.setText("");
					textFieldClaim2ServiceFacilityPaytoProvierAddressOne.setPromptText("Address Line 1");
					textFieldClaim2ServiceFacilityPayToProviderAddressTwo.setText("");
					textFieldClaim2ServiceFacilityPayToProviderAddressTwo.setPromptText("Address Line 2");
					textFieldClaim2ServiceFacilityPayToProviderCity.setText("");
					textFieldClaim2ServiceFacilityPayToProviderCity.setPromptText("City");
					textFieldClaim2ServiceFacilitypayToProviderfZip.setText("");
					textFieldClaim2ServiceFacilitypayToProviderfZip.setPromptText("Zip Code");
					Claim2ServiceFacilityPAYTOpROviderStateCombo.getSelectionModel().select(-1);
					Claim2ServiceFacilityPAYTOpROviderStateCombo.setValue("Select");
					textFieldClaim3ReferringPhysicianFName.setText("");
					textFieldClaim3ReferringPhysicianFName.setPromptText("First Name");
					textFieldClaim3ReferringPhysicianLName.setText("");
					textFieldClaim3ReferringPhysicianLName.setPromptText("Last Name");
					textFieldClaim3ReferringPhysicianNPI.setText("");
					textFieldClaim3ReferringPhysicianNPI.setPromptText("Referring Physician NPI");
					Claim3HospitalizationforCurrentServicesFromPicker.getEditor().clear();	
					Claim3HospitalizationforCurrentServicesFromPicker.setPromptText("MM/DD/YYYY");
					Claim3HospitalizationforCurrentServicesToPicker.getEditor().clear();	
					Claim3HospitalizationforCurrentServicesToPicker.setPromptText("MM/DD/YYYY");
					textFieldClaim2ServicingProviderName.setText("");
					textFieldClaim2ServicingProviderName.setPromptText("LastName, FirstName");
					Claim2ServicingProviderSignedCombo.getSelectionModel().select(0);
					Claim2ServicingProviderSignedDatePicker.getEditor().clear();
					Claim2ServicingProviderSignedDatePicker.setPromptText("MM/DD/YYYY");
					textFieldClaim2ServicingProviderNPI.setText("");
					textFieldClaim2ServicingProviderNPI.setPromptText("NPI");
					textFieldClaim2ServicingProviderPVN.setText("");
					textFieldClaim2ServicingProviderPVN.setPromptText("PVN");
					textFieldClaim2ServiceFacilityAddressOne.setText("");
					textFieldClaim2ServiceFacilityAddressOne.setPromptText("Address Line 1");
					textFieldClaim2ServiceFacilityAddressTwo.setText("");
					textFieldClaim2ServiceFacilityAddressTwo.setPromptText("Address Line 2");
					textFieldClaim2ServiceFacilityCity.setText("");
					textFieldClaim2ServiceFacilityCity.setPromptText("City");
					textFieldClaim2ServiceFacilityZip.setText("");
					textFieldClaim2ServiceFacilityZip.setPromptText("Zip Code");
					Claim2ServiceFacilityStateCombo.getSelectionModel().select(-1);
					Claim2ServiceFacilityStateCombo.setValue("Select");
					textFieldClaim2ServiceFacilityNPILoc.setText("");
					textFieldClaim2ServiceFacilityNPILoc.setPromptText("Service Facility NPI");
					textFieldClaim2ServiceFacilityName.setText("a");
					textFieldClaim2ServiceFacilityName.setText("");
					textFieldClaim2ServiceFacilityName.setPromptText("Service Facility Name");
					textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.setText("");
					textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.setPromptText("Address Line 2");
					textFieldClaim2ServiceFacilityAmbulancepickupCity.setText("");
					textFieldClaim2ServiceFacilityAmbulancepickupCity.setPromptText("City");
					textFieldClaim2ServiceFacilityAmbulancepickupZip.setText("");
					textFieldClaim2ServiceFacilityAmbulancepickupZip.setPromptText("Zip Code");
					Claim2ServiceFacilityAmbulancepickupStateCombo.getSelectionModel().select(-1);
					Claim2ServiceFacilityAmbulancepickupStateCombo.setValue("Select");
					textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.setText("a");
					textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.setText("");
					textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.setPromptText("Address Line 1");
					textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.setText("");
					textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.setPromptText("Address Line 2");
					textFieldClaim2ServiceFacilityAmbulancedropoffCity.setText("");
					textFieldClaim2ServiceFacilityAmbulancedropoffCity.setPromptText("City");
					textFieldClaim2ServiceFacilityAmbulanceDropoffZip.setText("");
					textFieldClaim2ServiceFacilityAmbulanceDropoffZip.setPromptText("Zip Code");
					Claim2ServiceFacilityAmbulanceDropoffStateCombo.getSelectionModel().select(-1);
					Claim2ServiceFacilityAmbulanceDropoffStateCombo.setValue("Select");
					textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.setText("a");
					textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.setText("");
					textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.setPromptText("Address Line 1");
					//Page 3
					Claim3PatientorAuthorizedPersonSignedCombo.getSelectionModel().select(0);
					Claim3PatientorAuthorizedPersonSignDatePicker.getEditor().clear();	
					Claim3PatientorAuthorizedPersonSignDatePicker.setPromptText("MM/DD/YYYY");
					Claim3DateofCurrentIllnessPicker.getEditor().clear();
					Claim3DateofCurrentIllnessPicker.setPromptText("MM/DD/YYYY");
					Claim3PatientsMedicalProblemCombo.getSelectionModel().select(-1);
					Claim3PatientsMedicalProblemCombo.setValue("Select");
					Claim3PatientUnaableToWorkFromPicker.getEditor().clear();
					Claim3PatientUnaableToWorkFromPicker.setPromptText("MM/DD/YYYY");
					Claim3PatientUnaableToWorkToPicker.getEditor().clear();
					Claim3PatientUnaableToWorkToPicker.setPromptText("MM/DD/YYYY");
					textFieldClaim3PatientAccountNo.setText("");
					textFieldClaim3PatientAccountNo.setPromptText("Patient Account Number");
					Claim3AcceptAssignmentCombo.getSelectionModel().select(-1);
					Claim3AcceptAssignmentCombo.setValue("Select");
					textFieldClaim3TotalCharges.setText("");
					textFieldClaim3TotalCharges.setPromptText("Total Charges in $");
					textFieldClaim3Amountpaid.setText("");
					textFieldClaim3Amountpaid.setPromptText("Amount Paid in $");
					textFieldClaim3ClaimLevelNotes.setText("");
					textFieldClaim3ClaimLevelNotes.setPromptText("Enter Claim Level Notes to Payer here.");
					Claim3OutSidelabCombo.getSelectionModel().select(1);
					textFieldClaim3LabCharges.setText("");
					textFieldClaim3LabCharges.setPromptText("Charges in $");
					textFieldClaim3DiagnosisCodeOne.getSelectionModel().select(-1);
					textFieldClaim3DiagnosisCodeOne.setValue("Select");
					textFieldClaim3DiagnosisCodeTwo.getSelectionModel().select(-1);
					textFieldClaim3DiagnosisCodeTwo.setValue("Select");
					textFieldClaim3DiagnosisCodeThree.getSelectionModel().select(-1);
					textFieldClaim3DiagnosisCodeThree.setValue("Select");
					textFieldClaim3DiagnosisCodeFour.getSelectionModel().select(-1);
					textFieldClaim3DiagnosisCodeFour.setValue("Select");
					textFieldClaim3DiagnosisCodeFive.getSelectionModel().select(-1);
					textFieldClaim3DiagnosisCodeFive.setValue("Select");
					textFieldClaim3DiagnosisCodeSix.getSelectionModel().select(-1);
					textFieldClaim3DiagnosisCodeSix.setValue("Select");
					textFieldClaim3DiagnosisCodeSeven.getSelectionModel().select(-1);
					textFieldClaim3DiagnosisCodeSeven.setValue("Select");
					textFieldClaim3DiagnosisCodeEight.getSelectionModel().select(-1);
					textFieldClaim3DiagnosisCodeEight.setValue("Select");
					textFieldClaim3DiagnosisCodeNine.getSelectionModel().select(-1);
					textFieldClaim3DiagnosisCodeNine.setValue("Select");
					textFieldClaim3DiagnosisCodeTen.getSelectionModel().select(-1);
					textFieldClaim3DiagnosisCodeTen.setValue("Select");
					textFieldClaim3DiagnosisCodeEleven.getSelectionModel().select(-1);
					textFieldClaim3DiagnosisCodeEleven.setValue("Select");
					textFieldClaim3DiagnosisCodeTwelve.getSelectionModel().select(-1);
					textFieldClaim3DiagnosisCodeTwelve.setValue("Select");
					Claim3ResubmissonCoeCombo.getSelectionModel().select(-1);
					Claim3ResubmissonCoeCombo.setValue("Select");
					textFieldClaim3OriginalReferenceNo.setText("");
					textFieldClaim3OriginalReferenceNo.setPromptText("Reference Number");
					textFieldClaim3PriorAuthorizationNo.setText("");
					textFieldClaim3PriorAuthorizationNo.setPromptText("Prior Authorization Number");
					row1col1.getEditor().clear();	
					row1col1.setPromptText("MM/DD/YYYY");
					row1col2.getEditor().clear();	
					row1col2.setPromptText("MM/DD/YYYY");
					row1col3.setText("");
					row1col3.setPromptText("Place of Service");
					row1col4.setText("");
					row1col4.setPromptText("C.P.T");
					row1col5.setText("");
					row1col5.setPromptText("MOD 1,MOD 2,MOD 3,MOD 4");
					row1col6.setText("");
					row1col6.setPromptText("Charges in $");
					row1col7.setText("");
					row1col7.setPromptText("Units");
					row2col1.setVisible(false);
					row2col2.setVisible(false);
					row2col3.setVisible(false);
					row2col4.setVisible(false);
					row2col5.setVisible(false);
					row2col6.setVisible(false);
					row2col7.setVisible(false);
					row3col1.setVisible(false);
					row3col2.setVisible(false);
					row3col3.setVisible(false);
					row3col4.setVisible(false);
					row3col5.setVisible(false);
					row3col6.setVisible(false);
					row3col7.setVisible(false);
					row4col1.setVisible(false);
					row4col2.setVisible(false);
					row4col3.setVisible(false);
					row4col4.setVisible(false);
					row4col5.setVisible(false);
					row4col6.setVisible(false);
					row4col7.setVisible(false);
				}
			});

			//Buttons
			Button ClaimThreevalidateData = new Button();
			ClaimThreevalidateData.setText("Validate Data");
			ClaimThreevalidateData.setLayoutX(430);
			ClaimThreevalidateData.setLayoutY(620);
			ClaimThreevalidateData.setMinWidth(150);
			ClaimThreevalidateData.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
			ClaimThreevalidateData.setTextFill(Color.STEELBLUE);
			ClaimThreevalidateData.setStyle("-fx-background-color:STEELBLUE");
			ClaimThreevalidateData.setTextFill(Color.WHITE);

			Button processDataClaims = new Button();
			processDataClaims.setText("Create EDI Data");
			processDataClaims.setLayoutX(600);
			processDataClaims.setLayoutY(620);
			processDataClaims.setMinWidth(150);
			processDataClaims.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
			processDataClaims.setStyle("-fx-background-color:STEELBLUE");
			processDataClaims.setTextFill(Color.WHITE);

			//Process EDI File Button
			Button ClaimThreeProcessEDIFile = new Button();
			ClaimThreeProcessEDIFile.setText("Process EDI Data");
			ClaimThreeProcessEDIFile.setLayoutX(770);
			ClaimThreeProcessEDIFile.setLayoutY(620);
			ClaimThreeProcessEDIFile.setMinWidth(150);
			ClaimThreeProcessEDIFile.setFont(Font.font("Calibri", FontWeight.BOLD, 16));
			ClaimThreeProcessEDIFile.setStyle("-fx-background-color:STEELBLUE");
			ClaimThreeProcessEDIFile.setTextFill(Color.WHITE);
			ClaimThreeProcessEDIFile.setDisable(true);
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////


			ClaimThreevalidateData.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(	textClaimOnePatientNamestar.isVisible()==true ||
							textClaimOnePatientDOBstar.isVisible()==true ||
							textClaimOneInsuredIdNumberestar.isVisible()==true ||
							textClaimOnePatientAddressOnestar.isVisible()==true ||
							textClaimOnePatientCitystar.isVisible()==true ||
							textClaimOnePatientStatestar.isVisible()==true ||
							textClaimOnePatientZipstar.isVisible()==true ||
							textClaimOneInsuredLNamestar.isVisible()==true ||
							textClaimOneInsuredAddressOnestar.isVisible()==true ||
							textClaimOneInsuredCitystar.isVisible()==true ||
							textClaimOneInsuredStatestar.isVisible()==true ||
							textClaimOneInsuredZipstar.isVisible()==true ||
							textClaimOneInsuredDOBstar.isVisible()==true ||
							//Page 2
							textClaim2ServicePhysicianNamestar.isVisible()==true ||
							textClaim2FederalTINstar.isVisible()==true ||
							textClaim2ServiceFacilityPhysicianAddressOnestar.isVisible()==true ||
							textClaim2ServiceFacilityPhysicianCitystar.isVisible()==true ||
							textClaim2ServiceFacilityPhysicianZipstar.isVisible()==true ||
							textClaimOneServiceFacilityPhysicianStatestar.isVisible()==true ||
							textClaim2ServiceFacilityPaytoProvierAddressOnestar.isVisible()==true ||
							textClaim2ServiceFacilityPaytoProvierCitystar.isVisible()==true ||
							textClaim2ServiceFacilityPaytoProvierZipstar.isVisible()==true ||
							textClaim2ServiceFacilityPaytoProvierStatestar.isVisible()==true ||
							textClaim3ReferringPhysicianLNamestar.isVisible()==true ||
							textClaim2ServicingProviderNamestar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulancePickupAddressOnestar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulancePickupCitystar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulancePickupZipstar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulancePickupStatestar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulanceDropoffCitystar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulanceDropoffZipstar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulanceDropoffStatestar.isVisible()==true ||
							textClaim2ServiceFacilityNamestar.isVisible()==true ||
							textClaim2ServiceFacilityAddressOnestar.isVisible()==true ||
							textClaim2ServiceFacilityCitystar.isVisible()==true ||
							textClaim2ServiceFacilityZipstar.isVisible()==true ||
							textClaim2ServiceFacilityStatestar.isVisible()==true ||
							//Page 3
							textClaim3DiagnosisCodeOnestar.isVisible()==true ||
							textClaim3PatientAccountNostar.isVisible()==true ||
							textClaim3TotalChargesstar.isVisible()==true ||
							textClaimThreerow1col1star.isVisible()==true ||
							textClaim3row1col3star.isVisible()==true ||
							textClaim3row1col4star.isVisible()==true ||
							textClaim3row1col6star.isVisible()==true ||
							textClaim3row1col7star.isVisible()==true )
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
						alert.setContentText("Please Click Create EDI Data");
						alert.showAndWait();
					}
				}});



			processDataClaims.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					if(	textClaimOnePatientNamestar.isVisible()==true ||
							textClaimOnePatientDOBstar.isVisible()==true ||
							textClaimOneInsuredIdNumberestar.isVisible()==true ||
							textClaimOnePatientAddressOnestar.isVisible()==true ||
							textClaimOnePatientCitystar.isVisible()==true ||
							textClaimOnePatientStatestar.isVisible()==true ||
							textClaimOnePatientZipstar.isVisible()==true ||
							textClaimOneInsuredLNamestar.isVisible()==true ||
							textClaimOneInsuredAddressOnestar.isVisible()==true ||
							textClaimOneInsuredCitystar.isVisible()==true ||
							textClaimOneInsuredStatestar.isVisible()==true ||
							textClaimOneInsuredZipstar.isVisible()==true ||
							textClaimOneInsuredDOBstar.isVisible()==true ||
							//Page 2
							textClaim2ServicePhysicianNamestar.isVisible()==true ||
							textClaim2FederalTINstar.isVisible()==true ||
							textClaim2ServiceFacilityPhysicianAddressOnestar.isVisible()==true ||
							textClaim2ServiceFacilityPhysicianCitystar.isVisible()==true ||
							textClaim2ServiceFacilityPhysicianZipstar.isVisible()==true ||
							textClaimOneServiceFacilityPhysicianStatestar.isVisible()==true ||
							textClaim2ServiceFacilityPaytoProvierAddressOnestar.isVisible()==true ||
							textClaim2ServiceFacilityPaytoProvierCitystar.isVisible()==true ||
							textClaim2ServiceFacilityPaytoProvierZipstar.isVisible()==true ||
							textClaim2ServiceFacilityPaytoProvierStatestar.isVisible()==true ||
							textClaim3ReferringPhysicianLNamestar.isVisible()==true ||
							textClaim2ServicingProviderNamestar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulancePickupAddressOnestar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulancePickupCitystar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulancePickupZipstar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulancePickupStatestar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulanceDropoffAddressOnestar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulanceDropoffCitystar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulanceDropoffZipstar.isVisible()==true ||
							textClaim2ServiceFacilityAmbulanceDropoffStatestar.isVisible()==true ||
							textClaim2ServiceFacilityNamestar.isVisible()==true ||
							textClaim2ServiceFacilityAddressOnestar.isVisible()==true ||
							textClaim2ServiceFacilityCitystar.isVisible()==true ||
							textClaim2ServiceFacilityZipstar.isVisible()==true ||
							textClaim2ServiceFacilityStatestar.isVisible()==true ||
							//Page 3
							textClaim3DiagnosisCodeOnestar.isVisible()==true ||
							textClaim3PatientAccountNostar.isVisible()==true ||
							textClaim3TotalChargesstar.isVisible()==true ||
							textClaimThreerow1col1star.isVisible()==true ||
							textClaim3row1col3star.isVisible()==true ||
							textClaim3row1col4star.isVisible()==true ||
							textClaim3row1col6star.isVisible()==true ||
							textClaim3row1col7star.isVisible()==true )
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
							try
							{
								Files.deleteIfExists(Paths.get(pathm+"Claim.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"Claim.txt"));
								//out.

								out.writeBytes("ISA*00*          *00*          *28*444444444T     *ZZ*024046863      *171229*1746*^*00501*"+uniqueId()+"*1*T*:");
								String newLine = System.getProperty("line.separator");
								out.writeBytes("~");
								out.writeBytes("GS*HC*444444444T*024046863*20171229*1746*1*X*005010X222A1");
								out.writeBytes("~");
								out.writeBytes("ST*837*000000001*005010X222A1");
								out.writeBytes("~");
								out.writeBytes("BHT*0019*00*000000001*20171229*1535*CH");
								out.writeBytes("~");
								out.writeBytes("NM1*41*2*WEBMD*****46*133052274");
								out.writeBytes("~");
								out.writeBytes("PER*IC*WEBMD CUSTOMER SOLUTIONS*TE*18008456592");
								out.writeBytes("~");
								out.writeBytes("NM1*40*2*AETNA*****46*60054");
								out.writeBytes("~");
								out.writeBytes("HL*1**20*1");
								out.writeBytes("~");
								//
								if(textFieldClaim2ServicePhysicianNPI.getText().isEmpty()==false)
									out.writeBytes("NM1*85*2*"+textFieldClaim2ServicePhysicianName.getText()+"*****XX*"+textFieldClaim2ServicePhysicianNPI.getText());
								else
									out.writeBytes("NM1*85*2*"+textFieldClaim2ServicePhysicianName.getText());
								out.writeBytes("~");
								if(textFieldClaim2ServiceFacilityPhysicianAddressTwo.getText().isEmpty()==false)
									out.writeBytes("N3*"+textFieldClaim2ServiceFacilityPhysicianAddressOne.getText()+"*"+textFieldClaim2ServiceFacilityPhysicianAddressTwo.getText());
								else
									out.writeBytes("N3*"+textFieldClaim2ServiceFacilityPhysicianAddressOne.getText());
								out.writeBytes("~");
								out.writeBytes("N4*"+textFieldClaim2ServiceFacilityPhysicianCity.getText()+"*"+Claim2ServiceFacilityPhysicianStateCombo.getValue().toString()+"*"+textFieldClaim2ServiceFacilityPhysicianZip.getText());
								out.writeBytes("~");
								out.writeBytes("REF*EI*"+textFieldClaim2FederalTaxIDNo.getText());

								//10

								//=============== Pay to Provider =====================Conditional
								if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false)
								{
									out.writeBytes("~");
									out.writeBytes("NM1*87*2");
									out.writeBytes("~");
									if(textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText().isEmpty()==false)
										out.writeBytes("N3*"+textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText()+"*"+textFieldClaim2ServiceFacilityPayToProviderAddressTwo.getText());
									else
										out.writeBytes("N3*"+textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText());
									out.writeBytes("~");
									out.writeBytes("N4*"+textFieldClaim2ServiceFacilityPayToProviderCity.getText()+"*"+Claim2ServiceFacilityPAYTOpROviderStateCombo.getValue().toString()+"*"+textFieldClaim2ServiceFacilitypayToProviderfZip.getText());
								}
								//+++++++++++++++++++++++++++++++++++++++++++++++++++++

								//=============================Relation is Self=======================

								if(ClaimOneRelationWithInsuredCombo.getValue().equalsIgnoreCase("Self"))
								{
									out.writeBytes("~");
									out.writeBytes("HL*2*1*22*0");
									out.writeBytes("~");
									out.writeBytes("SBR*P*18*"+textFieldClaimOneInsuredPolicyGroupFECA.getText()+"******CI");
									out.writeBytes("~");
									if(textFieldClaimOnePatientFName.getText().isEmpty()==false)
										out.writeBytes("NM1*IL*1*"+textFieldClaimOnePatientLName.getText()+"*"+textFieldClaimOnePatientFName.getText()+"*"+textFieldClaimOnePatientMName.getText()+"***MI*"+textFieldClaimOneInsuredIdNumber.getText());
									else
										out.writeBytes("NM1*IL*2*"+textFieldClaimOnePatientLName.getText()+"*"+textFieldClaimOnePatientFName.getText()+"*"+textFieldClaimOnePatientMName.getText()+"***MI*"+textFieldClaimOneInsuredIdNumber.getText());
									out.writeBytes("~");
									if(textFieldClaimOnePatientAddressTwo.getText().isEmpty()==false)
										out.writeBytes("N3*"+textFieldClaimOnePatientAddressOne.getText()+"*"+textFieldClaimOnePatientAddressTwo.getText());
									else
										out.writeBytes("N3*"+textFieldClaimOnePatientAddressOne.getText());
									out.writeBytes("~");
									out.writeBytes("N4*"+textFieldClaimOnePatientCity.getText()+"*"+ClaimOnepatientStateCombo.getValue().toString()+"*"+textFieldClaimOnePatientZip.getText());
									out.writeBytes("~");
									out.writeBytes("DMG*D8*"+ClaimOnePatientDOB.getValue().toString().replace("-", "")+"*"+ClaimOnepatientGenderCombo.getValue().charAt(0));
									out.writeBytes("~");
									out.writeBytes("NM1*PR*2*AETNA*****PI*60054");
									out.writeBytes("~");
									out.writeBytes("N4*NORWOOD*MA*02062");
								}							
								//=============== Dependent Info =====================Conditional	
								else
								{
									out.writeBytes("~");
									out.writeBytes("HL*2*1*22*0");
									out.writeBytes("~");
									out.writeBytes("SBR*P*18*"+textFieldClaimOneInsuredPolicyGroupFECA.getText()+"******CI");
									out.writeBytes("~");
									if(textFieldClaimOneInsuredFName.getText().isEmpty()==false)
										out.writeBytes("NM1*IL*1*"+textFieldClaimOneInsuredLName.getText()+"*"+textFieldClaimOneInsuredFName.getText()+"*"+textFieldClaimOneInsuredMName.getText()+"***MI*"+textFieldClaimOneInsuredIdNumber.getText());
									else
										out.writeBytes("NM1*IL*2*"+textFieldClaimOneInsuredLName.getText()+"*"+textFieldClaimOneInsuredFName.getText()+"*"+textFieldClaimOneInsuredMName.getText()+"***MI*"+textFieldClaimOneInsuredIdNumber.getText());
									out.writeBytes("~");
									if(textFieldClaimOneInsuredAddressTwo.getText().isEmpty()==false)
										out.writeBytes("N3*"+textFieldClaimOneInsuredAddressOne.getText()+"*"+textFieldClaimOneInsuredAddressTwo.getText());
									else
										out.writeBytes("N3*"+textFieldClaimOneInsuredAddressOne.getText());
									out.writeBytes("~");
									out.writeBytes("N4*"+textFieldClaimOneInsuredCity.getText()+"*"+ClaimOneInsuredStateCombo.getValue().toString()+"*"+textFieldClaimOneInsuredZip.getText());
									out.writeBytes("~");
									out.writeBytes("DMG*D8*"+ClaimOneInsuredDOB.getValue().toString().replace("-", "")+"*"+ClaimOneInsuredGenderCombo.getValue().charAt(0));
									out.writeBytes("~");
									out.writeBytes("NM1*PR*2*AETNA*****PI*60054");
									out.writeBytes("~");
									out.writeBytes("N4*NORWOOD*MA*02062");
									out.writeBytes("~");
									out.writeBytes("HL*3*2*23*0");
									out.writeBytes("~");
									if(ClaimOneRelationWithInsuredCombo.getValue().equalsIgnoreCase("Child"))
									{
										out.writeBytes("PAT*19");
									}
									if(ClaimOneRelationWithInsuredCombo.getValue().equalsIgnoreCase("Spouse"))
									{
										out.writeBytes("PAT*01");
									}
									out.writeBytes("~");
									if(textFieldClaimOnePatientFName.getText().isEmpty()==false)
										out.writeBytes("NM1*QC*1*"+textFieldClaimOnePatientLName.getText()+"*"+textFieldClaimOnePatientFName.getText()+"*"+textFieldClaimOnePatientMName.getText());
									else
										out.writeBytes("NM1*QC*2*"+textFieldClaimOnePatientLName.getText()+"*"+textFieldClaimOnePatientFName.getText()+"*"+textFieldClaimOnePatientMName.getText());
									out.writeBytes("~");
									if(textFieldClaimOnePatientAddressTwo.getText().isEmpty()==false)
										out.writeBytes("N3*"+textFieldClaimOnePatientAddressOne.getText()+"*"+textFieldClaimOnePatientAddressTwo.getText());
									else
										out.writeBytes("N3*"+textFieldClaimOnePatientAddressOne.getText());
									out.writeBytes("~");
									out.writeBytes("N4*"+textFieldClaimOnePatientCity.getText()+"*"+ClaimOnepatientStateCombo.getValue().toString()+"*"+textFieldClaimOnePatientZip.getText());
									out.writeBytes("~");
									out.writeBytes("DMG*D8*"+ClaimOnePatientDOB.getValue().toString().replace("-", "")+"*"+ClaimOnepatientGenderCombo.getValue().charAt(0));
									if(textFieldClaimOnePatientPhnNo.getText().isEmpty()==false)
									{
										out.writeBytes("~");
										out.writeBytes("PER*IC**TE*"+textFieldClaimOnePatientPhnNo.getText());
									}
								}		
								//+++++++++++++++++++++++++++++++++++++++++++++++++++++

								out.writeBytes("~");
								out.writeBytes("CLM*"+textFieldClaim3PatientAccountNo.getText()+"*"+textFieldClaim3TotalCharges.getText()+"***11:B:1*Y*A*Y*Y");
								out.writeBytes("~");

								//
								if(!(Claim3DateofCurrentIllnessPicker.getValue()==null))
								{
									out.writeBytes("DTP*431*D8*"+Claim3DateofCurrentIllnessPicker.getValue().toString().replace("-", ""));
									out.writeBytes("~");
								}
								if(!(Claim3PatientUnaableToWorkFromPicker.getValue()==null))
								{
									out.writeBytes("DTP*360*D8*"+Claim3PatientUnaableToWorkFromPicker.getValue().toString().replace("-", ""));
									out.writeBytes("~");
								}
								out.writeBytes("DTP*435*D8*"+row1col1.getValue().toString().replace("-", ""));
								out.writeBytes("~");
								//
								if(textFieldClaim3Amountpaid.getText().isEmpty()==false)
								{
									out.writeBytes("AMT*F5*"+textFieldClaim3Amountpaid.getText());
									out.writeBytes("~");
								}

								//
								out.writeBytes("REF*D9*117564126");
								out.writeBytes("~");

								out.writeBytes("HI*ABK:"+textFieldClaim3DiagnosisCodeOne.getValue().toString().substring(0,textFieldClaim3DiagnosisCodeOne.getValue().toString().indexOf('-')-1 ));
								out.writeBytes("~");

								///Condtitioanal Start
								//=============== Referring phy =====================
								if(textFieldClaim3ReferringPhysicianLName.getText().isEmpty()==false)
								{	
									if(textFieldClaim3ReferringPhysicianFName.getText().isEmpty()==false && textFieldClaim3ReferringPhysicianNPI.getText().isEmpty()==false)
										out.writeBytes("NM1*DN*1*"+textFieldClaim3ReferringPhysicianLName.getText()+"*"+textFieldClaim3ReferringPhysicianFName.getText()+"***JR*XX*"+textFieldClaim3ReferringPhysicianNPI.getText());
									else if(textFieldClaim3ReferringPhysicianFName.getText().isEmpty()==true && textFieldClaim3ReferringPhysicianNPI.getText().isEmpty()==true)
										out.writeBytes("NM1*DN*2*"+textFieldClaim3ReferringPhysicianLName.getText());
									else if(textFieldClaim3ReferringPhysicianFName.getText().isEmpty()==false && textFieldClaim3ReferringPhysicianNPI.getText().isEmpty()==true)
										out.writeBytes("NM1*DN*1*"+textFieldClaim3ReferringPhysicianLName.getText()+"*"+textFieldClaim3ReferringPhysicianFName.getText());
									else if(textFieldClaim3ReferringPhysicianFName.getText().isEmpty()==true && textFieldClaim3ReferringPhysicianNPI.getText().isEmpty()==false)
										out.writeBytes("NM1*DN*1*"+textFieldClaim3ReferringPhysicianLName.getText()+"****JR*XX*"+textFieldClaim3ReferringPhysicianNPI.getText());
									out.writeBytes("~");
								}
								//=============== Serving/Rendering =====================
								if(textFieldClaim2ServicingProviderName.getText().isEmpty()==false)
								{	
									if(textFieldClaim2ServicingProviderNPI.getText().isEmpty()==false)
										out.writeBytes("NM1*82*1*"+textFieldClaim2ServicingProviderName.getText()+"****JR*XX*"+textFieldClaim2ServicingProviderNPI.getText());
									else
										out.writeBytes("NM1*82*1*"+textFieldClaim2ServicingProviderName.getText());
									out.writeBytes("~");
								}
								//=============== Service Facility =====================
								if(textFieldClaim2ServiceFacilityName.getText().isEmpty()==false || textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false)
								{
									out.writeBytes("NM1*77*2*"+textFieldClaim2ServiceFacilityName.getText()+"*****XX*"+textFieldClaim2ServiceFacilityNPILoc.getText());
									out.writeBytes("~");
									if(textFieldClaim2ServiceFacilityAddressTwo.getText().isEmpty()==false)
										out.writeBytes("N3*"+textFieldClaim2ServiceFacilityAddressOne.getText()+"*"+textFieldClaim2ServiceFacilityAddressTwo.getText());
									else
										out.writeBytes("N3*"+textFieldClaim2ServiceFacilityAddressOne.getText());
									out.writeBytes("~");
									out.writeBytes("N4*"+textFieldClaim2ServiceFacilityCity.getText()+"*"+Claim2ServiceFacilityStateCombo.getValue().toString()+"*"+textFieldClaim2ServiceFacilityZip.getText());
									out.writeBytes("~");
								}
								//=============== AMBULANCE PICK-UP LOCATION =====================
								if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false)
								{
									out.writeBytes("NM1*PW*2");
									out.writeBytes("~");
									if(textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText().isEmpty()==false)
										out.writeBytes("N3*"+textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText()+"*"+textFieldClaim2ServiceFacilityAmbulancePickupAddressTwo.getText());
									else
										out.writeBytes("N3*"+textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText());
									out.writeBytes("~");
									out.writeBytes("N4*"+textFieldClaim2ServiceFacilityAmbulancepickupCity.getText()+"*"+Claim2ServiceFacilityAmbulancepickupStateCombo.getValue().toString()+"*"+textFieldClaim2ServiceFacilityAmbulancepickupZip.getText());
									out.writeBytes("~");
								}
								//=============== AMBULANCE Drop LOCATION =====================	
								if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false)
								{
									out.writeBytes("NM1*45*2");
									out.writeBytes("~");
									if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText().isEmpty()==false)
										out.writeBytes("N3*"+textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText()+"*"+textFieldClaim2ServiceFacilityAmbulanceDropoffAddressTwo.getText());
									else
										out.writeBytes("N3*"+textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText());
									out.writeBytes("~");
									out.writeBytes("N4*"+textFieldClaim2ServiceFacilityAmbulancedropoffCity.getText()+"*"+Claim2ServiceFacilityAmbulanceDropoffStateCombo.getValue().toString()+"*"+textFieldClaim2ServiceFacilityAmbulanceDropoffZip.getText());
									out.writeBytes("~");
								}

								///Conditional End
								out.writeBytes("LX*1");
								out.writeBytes("~");
								out.writeBytes("SV1*HC:"+row1col4.getText()+"*"+row1col6.getText()+"*UN*"+row1col7.getText()+"*"+row1col3.getText()+"**1");
								out.writeBytes("~");
								out.writeBytes("DTP*472*D8*"+row1col1.getValue().toString().replace("-", ""));
								out.writeBytes("~");


								int segno=18;
								if(textFieldClaim2ServiceFacilityPaytoProvierAddressOne.getText().isEmpty()==false)
								{
									segno=segno+3;
								}
								if(ClaimOneRelationWithInsuredCombo.getValue().equalsIgnoreCase("Self"))
								{
									segno=segno+8;
								}
								else
								{
									if(textFieldClaimOnePatientPhnNo.getText().isEmpty()==false)
									{
										segno=segno+15;
									}
									else
									{
										segno=segno+14;
									}
								}

								if(!(Claim3DateofCurrentIllnessPicker.getValue()==null))
								{
									segno=segno+1;
								}
								if(!(Claim3PatientUnaableToWorkFromPicker.getValue()==null))
								{
									segno=segno+1;
								}
								if(!(Claim3PatientUnaableToWorkToPicker.getValue()==null))
								{
									segno=segno+1;
								}
								if(textFieldClaim3Amountpaid.getText().isEmpty()==false)
								{
									segno=segno+1;
								}
								if(textFieldClaim3ReferringPhysicianLName.getText().isEmpty()==false)
								{
									segno=segno+1;
								}
								if(textFieldClaim2ServicingProviderName.getText().isEmpty()==false)
								{
									segno=segno+1;
								}
								if(textFieldClaim2ServiceFacilityName.getText().isEmpty()==false || textFieldClaim2ServiceFacilityAddressOne.getText().isEmpty()==false)
								{
									segno=segno+3;
								}
								if(textFieldClaim2ServiceFacilityAmbulancePickupAddressOne.getText().isEmpty()==false)
								{
									segno=segno+3;
								}
								if(textFieldClaim2ServiceFacilityAmbulanceDropoffAddressOne.getText().isEmpty()==false)
								{
									segno=segno+3;
								}


								out.writeBytes("SE*"+segno+"*000000001");
								out.writeBytes("~");
								out.writeBytes("GE*1*1");
								out.writeBytes("~");
								out.writeBytes("IEA*1*"+uniqueId());
								out.writeBytes("~");
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create Claim FIle");
							}
						}

						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("Successful");
						alert.setContentText("File Created Successfully.");
						alert.showAndWait();
						ClaimThreeProcessEDIFile.setDisable(false);
					}
				}
			});




			///Process EDI data
			ClaimThreeProcessEDIFile.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event){
                    Dialog<Pair<String, String>> dialog = new Dialog<>();
                    dialog.setTitle("Select Environment..");

                    // Set the button types.
                    ButtonType loginButtonType = new ButtonType("OK", ButtonData.OK_DONE);
                    dialog.getDialogPane().getButtonTypes().addAll(loginButtonType);

                    GridPane gridPane = new GridPane();
                    gridPane.setHgap(10);
                    gridPane.setVgap(10);
                    gridPane.setPadding(new Insets(20, 150, 10, 10));

                    /*TextField from = new TextField();
                    from.setPromptText("NID");
                    PasswordField to = new PasswordField();
                    to.setPromptText("Password");*/
                    ComboBox comboBox = new ComboBox();
                    comboBox.getItems().add("QA 1");
                    comboBox.getItems().add("QA 2");
                    comboBox.getItems().add("QA 3");
                    comboBox.setValue("QA 1");
                    comboBox.setMinWidth(180);
                    

                    /*gridPane.add(new Label("UserName :"), 0, 0);
                    gridPane.add(from, 1, 0);
                    gridPane.add(new Label("Password :"), 0, 1);
                    gridPane.add(to, 1, 1);*/
                    gridPane.add(new Label("Path :"), 0, 0);
                    gridPane.add(comboBox, 1, 0);

                    dialog.getDialogPane().setContent(gridPane);

                    // Request focus on the username field by default.
                    //Platform.runLater(() -> from.requestFocus());

                    // Convert the result to a username-password-pair when the login button is clicked.
                    dialog.setResultConverter(dialogButton -> {
                                    if (dialogButton == loginButtonType) {
                                                    return new Pair<>("user", "pwd");
                                    }
                                    return null;
                    });
                    
                    Optional<Pair<String, String>> result = dialog.showAndWait();

                    result.ifPresent(pair -> {
                                    /*String UserName=pair.getKey();
                                    String Password=pair.getValue();*/
                                   /* String user=System.getProperty("user.name");*/
                    	pathenv=comboBox.getValue().toString();
                    });
                    System.out.println(pathenv);
                    



						
						try {
							String user=System.getProperty("user.name");
							String creduname=null;
							String credpwd=null;
							if(pathenv.equalsIgnoreCase("QA 1"))
							{
								creduname="S050518";
								credpwd="MJ41#W4T";						
							}
							else if(pathenv.equalsIgnoreCase("QA 2"))
							{
								creduname="S010560";
								credpwd="RLKMW#66";
							}
							else if(pathenv.equalsIgnoreCase("QA 3"))
							{
								creduname="S012491";
								credpwd="DS1ZQ#I1";
							}
							
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
							out1.writeBytes(creduname);
							out1.writeBytes(newLine);
							out1.writeBytes(credpwd);
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
							String user=System.getProperty("user.name");
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



						ClaimThree.getChildren().addAll(rectClaimThreeBorder,rectClaimThreeTop,textClaimThreeTop,HomelinkClaimThree,rectClaimThreeMenu,ClaimThreeMenuTopOne,
								ClaimThreeMenuTopTwo,ClaimThreeMenuTopThree,textClaim3PatientorAuthorizedPersonSign,Claim3PatientorAuthorizedPersonSignedCombo,
								textClaim3PatientorAuthorizedPersonSignDate,textClaim3PatientAccountNo,textFieldClaim3PatientAccountNo,textClaim3AcceptAssignment,
								Claim3PatientorAuthorizedPersonSignDatePicker,textClaim3DateOfCurrentIllness,Claim3DateofCurrentIllnessPicker,
								textClaim3PatientsMedicalProblem,Claim3PatientsMedicalProblemCombo,Claim3AcceptAssignmentCombo,textClaim3TotalCharges,textClaim3AmountPaid,
								textClaim3PatientUnableToWorkFrom,Claim3PatientUnaableToWorkFromPicker,textClaim3PatientUnableToWorkTo,Claim3PatientUnaableToWorkToPicker,
								line4,line5,textClaim3ClaimLevelNotes,textFieldClaim3TotalCharges,textFieldClaim3Amountpaid,
								textFieldClaim3ClaimLevelNotes,textClaim3OutsideLab,Claim3OutSidelabCombo,textClaim3labCharges,textFieldClaim3LabCharges,line6,
								textClaim3DiagnosisorNatureOfInjury,textClaim3DiagnosisorNatureOfInjuryDesc,textFieldClaim3DiagnosisCodeOne,textClaim3DiagnosisNameOne,
								textClaim3DiagnosisNameTwo,textFieldClaim3DiagnosisCodeTwo,textClaim3DiagnosisNameThree,textFieldClaim3DiagnosisCodeThree,
								textClaim3DiagnosisNameFour,textClaim3DiagnosisNameFive,textClaim3DiagnosisNameSix,textFieldClaim3DiagnosisCodeFour,textFieldClaim3DiagnosisCodeFive,textFieldClaim3DiagnosisCodeSix,
								textClaim3DiagnosisNameSeven,textClaim3DiagnosisNameEight,textClaim3DiagnosisNameNine,textClaim3DiagnosisNameTen,textClaim3DiagnosisNameEleven,textClaim3DiagnosisNameTwelve,
								textFieldClaim3DiagnosisCodeSeven,textFieldClaim3DiagnosisCodeEight,textFieldClaim3DiagnosisCodeNine,textFieldClaim3DiagnosisCodeTen,textFieldClaim3DiagnosisCodeEleven,textFieldClaim3DiagnosisCodeTwelve,
								line7,textClaim3ResubmissionCode,Claim3ResubmissonCoeCombo,textClaim3OriginalReferencNo,textFieldClaim3OriginalReferenceNo,textClaim3PriorAuthorizationNo,
								textFieldClaim3PriorAuthorizationNo,line8,table,textClaim3AdditionalClaimLevelInfo,addButtonrow1,row1col1,row1col2,row1col3,row1col4,row1col5,row1col6,row1col7,
								row2col1,row2col2,row2col3,row2col4,row2col5,row2col6,row2col7,addButtonrow2,
								row3col1,row3col2,row3col3,row3col4,row3col5,row3col6,row3col7,addButtonrow3,
								row4col1,row4col2,row4col3,row4col4,row4col5,row4col6,row4col7,processDataClaims,textClaim3DiagnosisCodeOnestar,textClaim3PatientAccountNostar,
								textClaim3TotalChargesstar,textClaimThreerow1col1star,textClaim3row1col3star,textClaim3row1col4star,textClaim3row1col6star,textClaim3row1col7star,
								ClaimThreevalidateData,ClaimThreeProcessEDIFile);
						ClaimThree.setStyle("-fx-background-color:WHITE");
						/////////////////////////



						//RTE Link Event Handler
						BaselinkEligibility.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneRTE);}
						});
						//Referral Inquiry Link Event Handler
						BaselinkReferrals.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneReferralEnquiry);}
						});
						//CSR LInk Event Handler
						BaselinkCSR.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneCSR);}
						});

						//CSI LInk Event Handler
						BaselinkCSI.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneCSI);}
						});

						//FSR LInk Event Handler
						BaselinkFSR.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneFSR);}
						});

						//Claim LInk Event Handler
						BaselinkClaims.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneClaimOne);}
						});

						HomelinkClaimOne.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneBase);}
						});
						HomelinkClaimTwo.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneBase);}
						});
						HomelinkClaimThree.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneBase);}
						});
						//Claim One 2nd menu
						ClaimOneMenuTopTwo.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneClaimTwo);}
						});
						//Claim menu 3rd Menu
						ClaimOneMenuTopThree.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneClaimThree);}
						});
						//Claim Two 1st menu
						ClaimTwoMenuTopOne.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneClaimOne);}
						});
						//Claim menu 3rd Menu
						ClaimTwoMenuTopThree.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneClaimThree);}
						});

						//Claim Three 1st menu
						ClaimThreeMenuTopOne.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneClaimOne);}
						});
						//Claim Three 2nd Menu
						ClaimThreeMenuTopTwo.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneClaimTwo);}
						});

						//Pre Authorization Add
						BaselinkPreAuthAdd.setOnAction(new EventHandler<ActionEvent>() 	{
							public void handle(ActionEvent event) {
								primaryStage.setScene(scenePreAuthAdd);}
						});

						BaselinkReferralAdd.setOnAction(new EventHandler<ActionEvent>()           {
							public void handle(ActionEvent event) {
								primaryStage.setScene(sceneReferralAdd);}
						});

						paneBase.getChildren().addAll(textWelcome,textNID,rectWorkflow,textWorkflowRect,rectAetnaH,textAetnaH,rectWorkflowPlan,textWorkflowforthisplan,Baseiv,Baseiv1,BaselinkEligibility,BaselinkPreAuthAdd,BaselinkNOA,BaselinkReferrals,BaselinkClaims,BaselinkCSI,BaselinkCSR,BaselinkFSR,
								textWorkflowforthisplandown,BaselinkReferralAdd,BaselinkPreAuthInq,textWorkflowforthisplandownTwo,SharedAcc,NCPDP,E2EClaimTrans);
						paneBase.setStyle("-fx-background-color:WHITE");
						primaryStage.setScene(sceneBase);
						primaryStage.setTitle("EDITrans_Tool");
						primaryStage.getIcons().add(new Image("Resource/icon.png"));
						primaryStage.show();
			}

			public static class Person{String DOSFrom;String DOSTo;String PlaceOfService;String CPT;String MOD;String Charges;	String Units;
			public Person(String dOSFrom, String dOSTo,String placeOfService, String cPT,String mOD, String charges,String units) 
			{DOSFrom = dOSFrom;DOSTo = dOSTo;PlaceOfService = placeOfService;CPT = cPT;MOD = mOD;Charges = charges;Units = units;}}
			public static class PreAuthCol{String blank;String AttendingProvider;String FacilityProvider;String AdmittingProvider;public PreAuthCol(String blank,String AttendingProvider, String FacilityProvider,String AdmittingProvider) 
			{	blank=this.blank;AttendingProvider = this.AttendingProvider;FacilityProvider=this.FacilityProvider;AdmittingProvider=this.AdmittingProvider;}}

			public static class PreAuthRow{String FirstName;public PreAuthRow(String FirstName){FirstName = this.FirstName;}}
			
			
			public String uniqueId() {
	              long id = Long.parseLong(String.valueOf(System.currentTimeMillis()).substring(0,9));
	              String  str8;
	              str8 = Long.toString(id);
	              String f = str8;
	              

	              return f;
	       }

	}
