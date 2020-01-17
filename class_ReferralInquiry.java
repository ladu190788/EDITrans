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

public class class_ReferralInquiry {
	public Pane ReferralInquiryCode (Pane ReferralEnquiry,Stage primaryStage,Scene sceneBase)
	{
		/////////////////////////////////////////////Referral Inquiry
		//Top Border RE
		Rectangle rectReferralInqTop = new Rectangle();
		rectReferralInqTop.setX(0.0f);
		rectReferralInqTop.setY(0.0f);
		rectReferralInqTop.setWidth(1360.0f);
		rectReferralInqTop.setHeight(60.0f);
		rectReferralInqTop.setFill(Color.STEELBLUE);
		rectReferralInqTop.setStroke(Color.STEELBLUE);
		//Boundary
		Rectangle rectReferralInqBorder = new Rectangle();
		rectReferralInqBorder.setX(1.5f);
		rectReferralInqBorder.setY(0.0f);
		rectReferralInqBorder.setWidth(1356.0f);
		rectReferralInqBorder.setHeight(682.0f);
		rectReferralInqBorder.setFill(Color.WHITE);
		rectReferralInqBorder.setStroke(Color.STEELBLUE);
		//Top Text Ref Inq
		Text textReferralInqTop = new Text();
		textReferralInqTop.setText("Referral Inquiry");
		textReferralInqTop.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 24));
		textReferralInqTop.setFill(Color.WHITE);
		textReferralInqTop.setLayoutX(605);
		textReferralInqTop.setLayoutY(40);
		//HomeLink ReferralInq
		Hyperlink HomelinkReferralInq = new Hyperlink();
		HomelinkReferralInq.setText("Home");
		HomelinkReferralInq.setStyle("-fx-text-fill: YELLOW;");
		HomelinkReferralInq.setLayoutX(1300);
		HomelinkReferralInq.setLayoutY(2);
		HomelinkReferralInq.setUnderline(false);
		HomelinkReferralInq.setFocusTraversable(false);
		HomelinkReferralInq.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 14));
		//Text payer Name Referral Inq
		Text textReqerralInqReqProviderNPI = new Text();
		textReqerralInqReqProviderNPI.setText("Requesting "+'\n'+"Provider NPI");
		textReqerralInqReqProviderNPI.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReqerralInqReqProviderNPI.setFill(Color.BLACK);
		textReqerralInqReqProviderNPI.setLayoutX(100);
		textReqerralInqReqProviderNPI.setLayoutY(95);
		//* mark
		Text textReferralInqProviderNPIstar = new Text();
		textReferralInqProviderNPIstar.setText("*");
		textReferralInqProviderNPIstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralInqProviderNPIstar.setFill(Color.RED);
		textReferralInqProviderNPIstar.setLayoutX(200);
		textReferralInqProviderNPIstar.setLayoutY(115);
		//TextField Payer
		TextField textFieldReferralInqProviderNPI = new TextField();
		textFieldReferralInqProviderNPI.setLayoutX(250);
		textFieldReferralInqProviderNPI.setLayoutY(84);
		textFieldReferralInqProviderNPI.setPrefWidth(300);
		textFieldReferralInqProviderNPI.setPrefHeight(35);
		textFieldReferralInqProviderNPI.setEditable(true);
		textFieldReferralInqProviderNPI.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldReferralInqProviderNPI.setTooltip(new Tooltip("Enter Provider NPI : Numeric Values Only"));
		textFieldReferralInqProviderNPI.setPromptText("Provider NPI");
		//Provider name Referral Inq Text
		Text textReferralInqProviderName = new Text();
		textReferralInqProviderName.setText("Provider Name");
		textReferralInqProviderName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralInqProviderName.setFill(Color.BLACK);
		textReferralInqProviderName.setLayoutX(775);
		textReferralInqProviderName.setLayoutY(105);
		//Provider name textfield
		TextField textFieldProviderNameProviderInq = new TextField();
		textFieldProviderNameProviderInq.setLayoutX(925);
		textFieldProviderNameProviderInq.setLayoutY(84);
		textFieldProviderNameProviderInq.setPrefWidth(300);
		textFieldProviderNameProviderInq.setPrefHeight(35);
		textFieldProviderNameProviderInq.setEditable(true);
		textFieldProviderNameProviderInq.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldProviderNameProviderInq.setTooltip(new Tooltip("Provider Name"));
		textFieldProviderNameProviderInq.setText("GATEWAYQES");
		textFieldProviderNameProviderInq.setEditable(false);
		//Member F name Referral Inq Text
		Text textReferralInqMemberFName = new Text();
		textReferralInqMemberFName.setText("Member "+'\n'+"First Name");
		textReferralInqMemberFName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralInqMemberFName.setFill(Color.BLACK);
		textReferralInqMemberFName.setLayoutX(100);
		textReferralInqMemberFName.setLayoutY(155);
		//Member F name textfield
		TextField textFieldMemberFNameProviderInq = new TextField();
		textFieldMemberFNameProviderInq.setLayoutX(250);
		textFieldMemberFNameProviderInq.setLayoutY(144);
		textFieldMemberFNameProviderInq.setPrefWidth(300);
		textFieldMemberFNameProviderInq.setPrefHeight(35);
		textFieldMemberFNameProviderInq.setEditable(true);
		textFieldMemberFNameProviderInq.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldMemberFNameProviderInq.setTooltip(new Tooltip("Enter First Name"));
		textFieldMemberFNameProviderInq.setPromptText("Member First Name");
		//Member L name Referral Inq Text
		Text textReferralInqMemberLName = new Text();
		textReferralInqMemberLName.setText("Member "+'\n'+"Last Name");
		textReferralInqMemberLName.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralInqMemberLName.setFill(Color.BLACK);
		textReferralInqMemberLName.setLayoutX(775);
		textReferralInqMemberLName.setLayoutY(155);
		//Member L name textfield
		TextField textFieldMemberLNameProviderInq = new TextField();
		textFieldMemberLNameProviderInq.setLayoutX(925);
		textFieldMemberLNameProviderInq.setLayoutY(144);
		textFieldMemberLNameProviderInq.setPrefWidth(300);
		textFieldMemberLNameProviderInq.setPrefHeight(35);
		textFieldMemberLNameProviderInq.setEditable(true);
		textFieldMemberLNameProviderInq.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldMemberLNameProviderInq.setTooltip(new Tooltip("Enter Last Name"));
		textFieldMemberLNameProviderInq.setPromptText("Member Last Name");
		//Provider NPI
		textFieldReferralInqProviderNPI.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldReferralInqProviderNPI.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldReferralInqProviderNPI.setText(oldValue);
					}
				}
				catch(Exception e)
				{
				}
			}
		});
		//
		textFieldMemberFNameProviderInq.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldMemberFNameProviderInq.getText().length() >= 35) {
						textFieldMemberFNameProviderInq.setText(textFieldMemberFNameProviderInq.getText().substring(0, 35));
					}
				}
			}
		});
		textFieldMemberLNameProviderInq.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldMemberLNameProviderInq.getText().length() >= 60) {
						textFieldMemberLNameProviderInq.setText(textFieldMemberLNameProviderInq.getText().substring(0, 60));
					}
				}
			}
		});
		//Text Member IS Name Referral Inq
		Text textReqerralInqReqMemberIs = new Text();
		textReqerralInqReqMemberIs.setText("Member Is");
		textReqerralInqReqMemberIs.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReqerralInqReqMemberIs.setFill(Color.BLACK);
		textReqerralInqReqMemberIs.setLayoutX(100);
		textReqerralInqReqMemberIs.setLayoutY(225);
		//Combobix Member Is
		ComboBox<String> IsMemberComboBox = new ComboBox<String>();
		IsMemberComboBox.getItems().addAll("Subscriber","Dependent");
		IsMemberComboBox.setEditable(false); 
		IsMemberComboBox.setMinWidth(300);
		IsMemberComboBox.setMinHeight(35);
		IsMemberComboBox.setLayoutX(250);
		IsMemberComboBox.setLayoutY(203);
		IsMemberComboBox.setTooltip(new Tooltip("Select Member Type"));
		IsMemberComboBox.setValue("Subscriber");;
		IsMemberComboBox.setStyle("-fx-font: 18px \"Calibri\";");
		//Text Member ID Name Referral Inq
		Text textReqerralInqReqMemberID = new Text();
		textReqerralInqReqMemberID.setText("Member ID");
		textReqerralInqReqMemberID.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReqerralInqReqMemberID.setFill(Color.BLACK);
		textReqerralInqReqMemberID.setLayoutX(775);
		textReqerralInqReqMemberID.setLayoutY(225);
		//* mark
		Text textReferralInqMemberIDstar = new Text();
		textReferralInqMemberIDstar.setText("*");
		textReferralInqMemberIDstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralInqMemberIDstar.setFill(Color.RED);
		textReferralInqMemberIDstar.setLayoutX(865);
		textReferralInqMemberIDstar.setLayoutY(225);
		TextField textFieldMemberIDProviderInq = new TextField();
		textFieldMemberIDProviderInq.setLayoutX(925);
		textFieldMemberIDProviderInq.setLayoutY(203);
		textFieldMemberIDProviderInq.setPrefWidth(300);
		textFieldMemberIDProviderInq.setPrefHeight(35);
		textFieldMemberIDProviderInq.setEditable(true);
		textFieldMemberIDProviderInq.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldMemberIDProviderInq.setTooltip(new Tooltip("Enter Member ID"));
		textFieldMemberIDProviderInq.setPromptText("Member ID");
		//Member ID Limit
		textFieldMemberIDProviderInq.lengthProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable,
					Number oldValue, Number newValue) {
				if (newValue.intValue() > oldValue.intValue()) {
					if (textFieldMemberIDProviderInq.getText().length() >= 10) {
						textFieldMemberIDProviderInq.setText(textFieldMemberIDProviderInq.getText().substring(0, 10));
					}
				}
			}
		});
		//Text MemberDOB Name Eligibility
		Text texReferralInqMemberDOB = new Text();
		texReferralInqMemberDOB.setText("Member DOB");
		texReferralInqMemberDOB.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		texReferralInqMemberDOB.setFill(Color.BLACK);
		texReferralInqMemberDOB.setLayoutX(100);
		texReferralInqMemberDOB.setLayoutY(285);
		//* mark
		Text textReferralInqMemerDOBstar = new Text();
		textReferralInqMemerDOBstar.setText("*");
		textReferralInqMemerDOBstar.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReferralInqMemerDOBstar.setFill(Color.RED);
		textReferralInqMemerDOBstar.setLayoutX(207);
		textReferralInqMemerDOBstar.setLayoutY(285);
		//Date Picker
		DatePicker ReferralInqMemberDOBPicker = new DatePicker();
		ReferralInqMemberDOBPicker.setLayoutX(250);
		ReferralInqMemberDOBPicker.setLayoutY(263);
		ReferralInqMemberDOBPicker.setPrefWidth(300);
		ReferralInqMemberDOBPicker.setPrefHeight(35);
		ReferralInqMemberDOBPicker.setPromptText("MM/DD/YYYY");
		ReferralInqMemberDOBPicker.setTooltip(new Tooltip("Enter Member DOB"));
		ReferralInqMemberDOBPicker.setEditable(false);
		ReferralInqMemberDOBPicker.setStyle("-fx-font: 18px \"Calibri\";");
		ReferralInqMemberDOBPicker.setOnAction(e ->
		{
			LocalDate date = ReferralInqMemberDOBPicker.getValue();
		});
		//Text Review ID Name Referral Inq
		Text textReqerralInqReqReviewID = new Text();
		textReqerralInqReqReviewID.setText("Review ID Number");
		textReqerralInqReqReviewID.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textReqerralInqReqReviewID.setFill(Color.BLACK);
		textReqerralInqReqReviewID.setLayoutX(775);
		textReqerralInqReqReviewID.setLayoutY(285);
		//TextFiedl ReviewId Number
		TextField textFieldReviewIDProviderInq = new TextField();
		textFieldReviewIDProviderInq.setLayoutX(925);
		textFieldReviewIDProviderInq.setLayoutY(263);
		textFieldReviewIDProviderInq.setPrefWidth(300);
		textFieldReviewIDProviderInq.setPrefHeight(35);
		textFieldReviewIDProviderInq.setEditable(true);
		textFieldReviewIDProviderInq.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldReviewIDProviderInq.setTooltip(new Tooltip("Enter Review ID Number: Numeric Values Only"));
		textFieldReviewIDProviderInq.setPromptText("Review Identification Number");
		//Member ID
		textFieldReviewIDProviderInq.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldReviewIDProviderInq.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldReviewIDProviderInq.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});
		//Validate Data ReferralInq Button
		Button validateDataReferralInq = new Button();
		validateDataReferralInq.setText("Validate Data");
		validateDataReferralInq.setLayoutX(430);
		validateDataReferralInq.setLayoutY(350);
		validateDataReferralInq.setMinWidth(150);
		validateDataReferralInq.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		validateDataReferralInq.setTextFill(Color.STEELBLUE);
		validateDataReferralInq.setStyle("-fx-background-color:STEELBLUE");
		validateDataReferralInq.setTextFill(Color.WHITE);
		//Validate Data ReferralInq Button
		Button createESIDataReferralInq = new Button();
		createESIDataReferralInq.setText("Create EDI File");
		createESIDataReferralInq.setLayoutX(600);
		createESIDataReferralInq.setLayoutY(350);
		createESIDataReferralInq.setMinWidth(150);
		createESIDataReferralInq.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		createESIDataReferralInq.setTextFill(Color.STEELBLUE);
		createESIDataReferralInq.setStyle("-fx-background-color:STEELBLUE");
		createESIDataReferralInq.setTextFill(Color.WHITE);
		//Process Data ReferralInq Button
		Button processDataReferralInq = new Button();
		processDataReferralInq.setText("Process EDI File");
		processDataReferralInq.setLayoutX(770);
		processDataReferralInq.setLayoutY(350);
		processDataReferralInq.setMinWidth(150);
		processDataReferralInq.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		processDataReferralInq.setStyle("-fx-background-color:STEELBLUE");
		processDataReferralInq.setTextFill(Color.WHITE);
		//Validate Data Event
		validateDataReferralInq.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(textFieldReferralInqProviderNPI.getText().isEmpty()==true || 
						textFieldMemberIDProviderInq.getText().isEmpty()==true ||
						ReferralInqMemberDOBPicker.getValue()==null)
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
		createESIDataReferralInq.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(textFieldReferralInqProviderNPI.getText().isEmpty()==true || 
						textFieldMemberIDProviderInq.getText().isEmpty()==true ||
						ReferralInqMemberDOBPicker.getValue()==null)
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
						if(IsMemberComboBox.getValue().equalsIgnoreCase("Subscriber") && textFieldReviewIDProviderInq.getText().isEmpty())
						{
							try
							{	
								Files.deleteIfExists(Paths.get(pathm+"Subscriber_Referral.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"Subscriber_Referral.txt"));
								out.writeBytes("ISA*00*          *00*          *ZZ*GATEWAYQES     *ZZ*042064683      *070612*1041*^*00501*745180027*0*T*:");
								String newLine = System.getProperty("line.separator");
								out.writeBytes(newLine);
								out.writeBytes("GS*HI*GATEWAYQES*RTRC_INQ_5010*20080318*1846*39*X*005010X215");
								out.writeBytes(newLine);
								out.writeBytes("ST*278*0001*005010X215");
								out.writeBytes(newLine);
								out.writeBytes("BHT*0007*28*123456789OTHER*20050502*1525");
								out.writeBytes(newLine);
								out.writeBytes("HL*1**20*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*X3*2*AETNA*****PI*953402799");
								out.writeBytes(newLine);
								out.writeBytes("HL*2*1*21*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*1P*1*P.C.*SLATE*BELT FAMILY PRACTICE***XX*"+textFieldReferralInqProviderNPI.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*3*2*22*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*IL*1*"+textFieldMemberLNameProviderInq.getText()+"*"+textFieldMemberFNameProviderInq.getText()+"****MI*"+textFieldMemberIDProviderInq.getText());
								out.writeBytes(newLine);
								out.writeBytes("DMG*D8*"+ReferralInqMemberDOBPicker.getValue().toString().replace("-",""));
								out.writeBytes(newLine);
								out.writeBytes("HL*4*3*EV*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*SJ*1*DO*PARSONS,*ROBERT L.,***XX*1871645127");
								out.writeBytes(newLine);
								out.writeBytes("SE*12*0001");
								out.writeBytes(newLine);
								out.writeBytes("GE*1*39");
								out.writeBytes(newLine);
								out.writeBytes("IEA*1*745180027");
								out.writeBytes(newLine);
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create Subscriber_Referral File");
							}
						}
						else if(IsMemberComboBox.getValue().equalsIgnoreCase("Subscriber") && !(textFieldReviewIDProviderInq.getText().isEmpty()))
						{
							try
							{	
								Files.deleteIfExists(Paths.get(pathm+"Subscriber+Referral_ID.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"Subscriber+Referral_ID.txt"));
								out.writeBytes("ISA*00*          *00*          *ZZ*GATEWAYQES     *ZZ*042064683      *070612*1041*^*00501*745180027*0*T*:");
								String newLine = System.getProperty("line.separator");
								out.writeBytes(newLine);
								out.writeBytes("GS*HI*GATEWAYQES*RTRC_INQ_5010*20080318*1846*39*X*005010X215");
								out.writeBytes(newLine);
								out.writeBytes("ST*278*0001*005010X215");
								out.writeBytes(newLine);
								out.writeBytes("BHT*0007*28*123456789OTHER*20050502*1525");
								out.writeBytes(newLine);
								out.writeBytes("HL*1**20*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*X3*2*AETNA*****PI*953402799");
								out.writeBytes(newLine);
								out.writeBytes("HL*2*1*21*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*1P*1*P.C.*SLATE*BELT FAMILY PRACTICE***XX*"+textFieldReferralInqProviderNPI.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*3*2*22*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*IL*1*"+textFieldMemberLNameProviderInq.getText()+"*"+textFieldMemberFNameProviderInq.getText()+"****MI*"+textFieldMemberIDProviderInq.getText());
								out.writeBytes(newLine);
								out.writeBytes("DMG*D8*"+ReferralInqMemberDOBPicker.getValue().toString().replace("-",""));
								out.writeBytes(newLine);
								out.writeBytes("HL*4*3*EV*1");
								out.writeBytes(newLine);
								out.writeBytes("REF*BB*"+textFieldReviewIDProviderInq.getText());
								out.writeBytes(newLine);
								out.writeBytes("NM1*SJ*1*DO*PARSONS,*ROBERT L.,***XX*1871645127");
								out.writeBytes(newLine);
								out.writeBytes("SE*13*0001");
								out.writeBytes(newLine);
								out.writeBytes("GE*1*39");
								out.writeBytes(newLine);
								out.writeBytes("IEA*1*745180027");
								out.writeBytes(newLine);
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create Subscriber+Referral_ID File");
							}
						}
						else if(IsMemberComboBox.getValue().equalsIgnoreCase("Dependent") && (textFieldReviewIDProviderInq.getText().isEmpty()))
						{
							try
							{	
								Files.deleteIfExists(Paths.get(pathm+"Dependent_Referral.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"Dependent_Referral.txt"));
								out.writeBytes("ISA*00*          *00*          *ZZ*GATEWAYQES     *ZZ*042064683      *070612*1041*^*00501*745180027*0*T*:");
								String newLine = System.getProperty("line.separator");
								out.writeBytes(newLine);
								out.writeBytes("GS*HI*GATEWAYQES*RTRC_INQ_5010*20080318*1846*39*X*005010X215");
								out.writeBytes(newLine);
								out.writeBytes("ST*278*0001*005010X215");
								out.writeBytes(newLine);
								out.writeBytes("BHT*0007*28*123456789OTHER*20050502*1525");
								out.writeBytes(newLine);
								out.writeBytes("HL*1**20*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*X3*2*AETNA*****PI*953402799");
								out.writeBytes(newLine);
								out.writeBytes("HL*2*1*21*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*1P*1*P.C.*SLATE*BELT FAMILY PRACTICE***XX*"+textFieldReferralInqProviderNPI.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*3*2*22*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*IL*1*"+textFieldMemberLNameProviderInq.getText()+"*"+textFieldMemberFNameProviderInq.getText()+"****MI*"+textFieldMemberIDProviderInq.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*4*3*23*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*QC*1*PHILLIPS*CHANEY");
								out.writeBytes(newLine);
								out.writeBytes("DMG*D8*"+ReferralInqMemberDOBPicker.getValue().toString().replace("-",""));
								out.writeBytes(newLine);
								out.writeBytes("HL*4*3*EV*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*SJ*1*DO*PARSONS,*ROBERT L.,***XX*1871645127");
								out.writeBytes(newLine);
								out.writeBytes("SE*14*0001");
								out.writeBytes(newLine);
								out.writeBytes("GE*1*39");
								out.writeBytes(newLine);
								out.writeBytes("IEA*1*745180027");
								out.writeBytes(newLine);
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create Dependent_Referral File");
							}
						}
						else if(IsMemberComboBox.getValue().equalsIgnoreCase("Dependent") && !(textFieldReviewIDProviderInq.getText().isEmpty()))
						{
							try
							{	
								Files.deleteIfExists(Paths.get(pathm+"Dependent+Referral_ID.txt"));
								DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"Dependent+Referral_ID.txt"));
								out.writeBytes("ISA*00*          *00*          *ZZ*GATEWAYQES     *ZZ*042064683      *070612*1041*^*00501*745180027*0*T*:");
								String newLine = System.getProperty("line.separator");
								out.writeBytes(newLine);
								out.writeBytes("GS*HI*GATEWAYQES*RTRC_INQ_5010*20080318*1846*39*X*005010X215");
								out.writeBytes(newLine);
								out.writeBytes("ST*278*0001*005010X215");
								out.writeBytes(newLine);
								out.writeBytes("BHT*0007*28*123456789OTHER*20050502*1525");
								out.writeBytes(newLine);
								out.writeBytes("HL*1**20*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*X3*2*AETNA*****PI*953402799");
								out.writeBytes(newLine);
								out.writeBytes("HL*2*1*21*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*1P*1*P.C.*SLATE*BELT FAMILY PRACTICE***XX*"+textFieldReferralInqProviderNPI.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*3*2*22*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*IL*1*"+textFieldMemberLNameProviderInq.getText()+"*"+textFieldMemberFNameProviderInq.getText()+"****MI*"+textFieldMemberIDProviderInq.getText());
								out.writeBytes(newLine);
								out.writeBytes("HL*4*3*23*1");
								out.writeBytes(newLine);
								out.writeBytes("NM1*QC*1*PHILLIPS*CHANEY");
								out.writeBytes(newLine);
								out.writeBytes("DMG*D8*"+ReferralInqMemberDOBPicker.getValue().toString().replace("-",""));
								out.writeBytes(newLine);
								out.writeBytes("HL*4*3*EV*1");
								out.writeBytes(newLine);
								out.writeBytes("REF*BB*"+textFieldReviewIDProviderInq.getText());
								out.writeBytes(newLine);
								out.writeBytes("NM1*SJ*1*DO*PARSONS,*ROBERT L.,***XX*1871645127");
								out.writeBytes(newLine);
								out.writeBytes("SE*15*0001");
								out.writeBytes(newLine);
								out.writeBytes("GE*1*39");
								out.writeBytes(newLine);
								out.writeBytes("IEA*1*745180027");
								out.writeBytes(newLine);
								out.close();
							}
							catch(Exception e)
							{
								System.out.println("Unable to Create Dependent+Referral_ID File");
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
		//Home Button Referral Inq Inquiry Link Event Handler
		HomelinkReferralInq.setOnAction(new EventHandler<ActionEvent>() 	{
			public void handle(ActionEvent event) 
			{
				primaryStage.setScene(sceneBase);
				textFieldMemberFNameProviderInq.clear();
				textFieldMemberLNameProviderInq.clear();
				IsMemberComboBox.setValue("Subscriber");
				textFieldMemberIDProviderInq.clear();
				ReferralInqMemberDOBPicker.getEditor().clear();
				ReferralInqMemberDOBPicker.setPromptText("MM/DD/YYYY");
				textFieldReviewIDProviderInq.clear();
				textFieldReferralInqProviderNPI.clear();
			}
		});
		ReferralEnquiry.getChildren().addAll(rectReferralInqBorder,rectReferralInqTop,textReferralInqTop,HomelinkReferralInq,
				textReqerralInqReqProviderNPI,textReferralInqProviderNPIstar,textFieldReferralInqProviderNPI,textReferralInqProviderName,
				textFieldProviderNameProviderInq,textReferralInqMemberFName,textFieldMemberFNameProviderInq,textReferralInqMemberLName
				,textFieldMemberLNameProviderInq,textReqerralInqReqMemberIs,IsMemberComboBox,
				textReqerralInqReqMemberID,textReferralInqMemberIDstar,textFieldMemberIDProviderInq,texReferralInqMemberDOB,textReferralInqMemerDOBstar,
				ReferralInqMemberDOBPicker,textReqerralInqReqReviewID,textFieldReviewIDProviderInq,validateDataReferralInq,createESIDataReferralInq,processDataReferralInq);
		ReferralEnquiry.setStyle("-fx-background-color:WHITE");
		return ReferralEnquiry;
	}
}
