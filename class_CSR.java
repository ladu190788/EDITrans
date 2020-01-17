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

public class class_CSR {
	public Pane CSRCode (Pane CSR,Stage primaryStage,Scene sceneBase)
	{
		//Top Border RE
		Rectangle rectCSRTop = new Rectangle();
		rectCSRTop.setX(0.0f);
		rectCSRTop.setY(0.0f);
		rectCSRTop.setWidth(1360.0f);
		rectCSRTop.setHeight(60.0f);
		rectCSRTop.setFill(Color.STEELBLUE);
		rectCSRTop.setStroke(Color.STEELBLUE);
		//Boundary
		Rectangle rectCSRBorder = new Rectangle();
		rectCSRBorder.setX(1.5f);
		rectCSRBorder.setY(0.0f);
		rectCSRBorder.setWidth(1356.0f);
		rectCSRBorder.setHeight(682.0f);
		rectCSRBorder.setFill(Color.WHITE);
		rectCSRBorder.setStroke(Color.STEELBLUE);
		//Top Text Ref Inq
		Text textCSRTop = new Text();
		textCSRTop.setText("Claim Status Report");
		textCSRTop.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 24));
		textCSRTop.setFill(Color.WHITE);
		textCSRTop.setLayoutX(585);
		textCSRTop.setLayoutY(40);
		//HomeLink ReferralInq
		Hyperlink HomelinkCSR = new Hyperlink();
		HomelinkCSR.setText("Home");
		HomelinkCSR.setStyle("-fx-text-fill: YELLOW;");
		HomelinkCSR.setLayoutX(1300);
		HomelinkCSR.setLayoutY(2);
		HomelinkCSR.setUnderline(false);
		HomelinkCSR.setFocusTraversable(false);
		HomelinkCSR.setFont(Font.font("Calibri", FontWeight.EXTRA_BOLD, 14));
		//Text Billing Provider Name CSR
		Text textCSRBillingProvider = new Text();
		textCSRBillingProvider.setText("Billing "+'\n'+"Provider NPI");
		textCSRBillingProvider.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSRBillingProvider.setFill(Color.BLACK);
		textCSRBillingProvider.setLayoutX(100);
		textCSRBillingProvider.setLayoutY(95);
		//* mark
		Text textCSRBillingProv = new Text();
		textCSRBillingProv.setText("*");
		textCSRBillingProv.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSRBillingProv.setFill(Color.RED);
		textCSRBillingProv.setLayoutX(200);
		textCSRBillingProv.setLayoutY(110);
		//TextField Billing Provider
		TextField textFieldCSRBillingProvider = new TextField();
		textFieldCSRBillingProvider.setLayoutX(250);
		textFieldCSRBillingProvider.setLayoutY(84);
		textFieldCSRBillingProvider.setPrefWidth(300);
		textFieldCSRBillingProvider.setPrefHeight(35);
		textFieldCSRBillingProvider.setEditable(true);
		textFieldCSRBillingProvider.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldCSRBillingProvider.setTooltip(new Tooltip("Enter Billing Provider NPI : Numeric Values Only"));
		textFieldCSRBillingProvider.setPromptText("Billing Provider NPI");
		////
		textFieldCSRBillingProvider.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldCSRBillingProvider.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldCSRBillingProvider.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});

		//Text Servicing Provider Name CSR
		Text textCSRServicingProvider = new Text();
		textCSRServicingProvider.setText("Servicing "+'\n'+"Provider NPI");
		textCSRServicingProvider.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSRServicingProvider.setFill(Color.BLACK);
		textCSRServicingProvider.setLayoutX(775);
		textCSRServicingProvider.setLayoutY(95);
		//* mark
		Text textCSRServicingProv = new Text();
		textCSRServicingProv.setText("*");
		textCSRServicingProv.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSRServicingProv.setFill(Color.RED);
		textCSRServicingProv.setLayoutX(875);
		textCSRServicingProv.setLayoutY(110);

		//TextField Billing Provider
		TextField textFieldCSRServicingProvider = new TextField();
		textFieldCSRServicingProvider.setLayoutX(925);
		textFieldCSRServicingProvider.setLayoutY(84);
		textFieldCSRServicingProvider.setPrefWidth(300);
		textFieldCSRServicingProvider.setPrefHeight(35);
		textFieldCSRServicingProvider.setEditable(true);
		textFieldCSRServicingProvider.setFont(Font.font("Calibri", FontWeight.NORMAL, 18));
		textFieldCSRServicingProvider.setTooltip(new Tooltip("Enter Servicing Provider NPI : Numeric Values Only"));
		textFieldCSRServicingProvider.setPromptText("Servicing Provider NPI");

		textFieldCSRServicingProvider.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, 
					String newValue) {
				try
				{
					if (newValue.matches("\\d*") && textFieldCSRServicingProvider.getText().length()<=10) {
						int value = Integer.parseInt(newValue);
					} else {
						textFieldCSRServicingProvider.setText(oldValue);
					}
				}
				catch(Exception e)
				{

				}
			}
		});

		Text textCSRServiceStartDT = new Text();
		textCSRServiceStartDT.setText("Service "+'\n'+"Start Date");
		textCSRServiceStartDT.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSRServiceStartDT.setFill(Color.BLACK);
		textCSRServiceStartDT.setLayoutX(100);
		textCSRServiceStartDT.setLayoutY(150);
		//* mark
		Text textCSRServiceStart= new Text();
		textCSRServiceStart.setText("*");
		textCSRServiceStart.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSRServiceStart.setFill(Color.RED);
		textCSRServiceStart.setLayoutX(185);
		textCSRServiceStart.setLayoutY(165);
		//Date Picker
		DatePicker CSRServiceStartDtPicker = new DatePicker();
		CSRServiceStartDtPicker.setLayoutX(250);
		CSRServiceStartDtPicker.setLayoutY(138);
		CSRServiceStartDtPicker.setPrefWidth(300);
		CSRServiceStartDtPicker.setPrefHeight(35);
		CSRServiceStartDtPicker.setPromptText("MM/DD/YYYY");
		CSRServiceStartDtPicker.setTooltip(new Tooltip("Enter Service Start Date"));
		CSRServiceStartDtPicker.setEditable(false);
		CSRServiceStartDtPicker.setStyle("-fx-font: 18px \"Calibri\";");
		CSRServiceStartDtPicker.setOnAction(e ->
		{
			LocalDate date = CSRServiceStartDtPicker.getValue();
		});

		Text textCSRServiceEndDT = new Text();
		textCSRServiceEndDT.setText("Service "+'\n'+"End Date");
		textCSRServiceEndDT.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSRServiceEndDT.setFill(Color.BLACK);
		textCSRServiceEndDT.setLayoutX(775);
		textCSRServiceEndDT.setLayoutY(150);
		//* mark
		Text textCSRServiceEnd= new Text();
		textCSRServiceEnd.setText("*");
		textCSRServiceEnd.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		textCSRServiceEnd.setFill(Color.RED);
		textCSRServiceEnd.setLayoutX(855);
		textCSRServiceEnd.setLayoutY(165);
		//Date Picker
		DatePicker CSRServiceEndDtPicker = new DatePicker();
		CSRServiceEndDtPicker.setLayoutX(925);
		CSRServiceEndDtPicker.setLayoutY(138);
		CSRServiceEndDtPicker.setPrefWidth(300);
		CSRServiceEndDtPicker.setPrefHeight(35);
		CSRServiceEndDtPicker.setPromptText("MM/DD/YYYY");
		CSRServiceEndDtPicker.setTooltip(new Tooltip("Enter Service End Date"));
		CSRServiceEndDtPicker.setEditable(false);
		CSRServiceEndDtPicker.setStyle("-fx-font: 18px \"Calibri\";");

		CSRServiceEndDtPicker.setOnAction(e ->
		{
			LocalDate date = CSRServiceEndDtPicker.getValue();
		});
		//Validate Data ReferralInq Button
		Button validateDataCSR = new Button();
		validateDataCSR.setText("Validate Data");
		validateDataCSR.setLayoutX(430);
		validateDataCSR.setLayoutY(350);
		validateDataCSR.setMinWidth(150);
		validateDataCSR.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		validateDataCSR.setTextFill(Color.STEELBLUE);
		validateDataCSR.setStyle("-fx-background-color:STEELBLUE");
		validateDataCSR.setTextFill(Color.WHITE);
		//Validate Data ReferralInq Button
		Button createESIDataCSR = new Button();
		createESIDataCSR.setText("Create EDI File");
		createESIDataCSR.setLayoutX(600);
		createESIDataCSR.setLayoutY(350);
		createESIDataCSR.setMinWidth(150);
		createESIDataCSR.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		createESIDataCSR.setTextFill(Color.STEELBLUE);
		createESIDataCSR.setStyle("-fx-background-color:STEELBLUE");
		createESIDataCSR.setTextFill(Color.WHITE);
		//Process Data ReferralInq Button
		Button processDataCSR = new Button();
		processDataCSR.setText("Process EDI File");
		processDataCSR.setLayoutX(770);
		processDataCSR.setLayoutY(350);
		processDataCSR.setMinWidth(150);
		processDataCSR.setFont(Font.font("Calibri", FontWeight.BOLD, 18));
		processDataCSR.setStyle("-fx-background-color:STEELBLUE");
		processDataCSR.setTextFill(Color.WHITE);

		//Validate Data Event
		validateDataCSR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(textFieldCSRBillingProvider.getText().isEmpty()==true || 
						textFieldCSRServicingProvider.getText().isEmpty()==true ||
						CSRServiceEndDtPicker.getValue()==null ||
						CSRServiceStartDtPicker.getValue()==null)
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
		createESIDataCSR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) 
			{	
				if(textFieldCSRBillingProvider.getText().isEmpty()==true || 
						textFieldCSRServicingProvider.getText().isEmpty()==true ||
						CSRServiceEndDtPicker.getValue()==null ||
						CSRServiceStartDtPicker.getValue()==null)
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
							Files.deleteIfExists(Paths.get(pathm+"CSR.txt"));
							DataOutputStream out = new DataOutputStream(new FileOutputStream(pathm+"CSR.txt"));
							out.writeBytes("ISA*00*          *00*          *30*GATEWAYQES     *01*042064683      *100527*0851*^*00501*000000006*0*T*:");
							String newLine = System.getProperty("line.separator");
							out.writeBytes(newLine);
							out.writeBytes("GS*HR*GATEWAYQES*AS_CSR_5010*20100527*085127*3406*X*005010CSR276");
							out.writeBytes(newLine);
							out.writeBytes("ST*276*0001*005010CSR276");
							out.writeBytes(newLine);
							out.writeBytes("BHT*0010*13*000212654WEB*20100527*112244");
							out.writeBytes(newLine);
							out.writeBytes("HL*1**20*1");
							out.writeBytes(newLine);
							out.writeBytes("NM1*PR*2*AETNA*****PI*953402799");
							out.writeBytes(newLine);
							out.writeBytes("HL*2*1*21*1");
							out.writeBytes(newLine);
							out.writeBytes("NM1*41*2*City Place Modern Dentistry, LLP*****46*"+textFieldCSRBillingProvider.getText());
							out.writeBytes(newLine);
							out.writeBytes("HL*3*2*19*0");
							out.writeBytes(newLine);
							out.writeBytes("NM1*1P*2*City Place Modern Dentistry, LLP*****XX*"+textFieldCSRServicingProvider.getText());
							out.writeBytes(newLine);
							out.writeBytes("TRN*1*123456789111");
							out.writeBytes(newLine);
							out.writeBytes("REF*1K*PM34AK0VL00");
							out.writeBytes(newLine);
							out.writeBytes("DTP*472*RD8*"+CSRServiceStartDtPicker.getValue().toString().replace("-", "")+"-"+CSRServiceEndDtPicker.getValue().toString().replace("-", ""));
							out.writeBytes(newLine);
							out.writeBytes("SE*12*0001");
							out.writeBytes(newLine);
							out.writeBytes("GE*1*3406");
							out.writeBytes(newLine);
							out.writeBytes("IEA*1*000000006");
							out.writeBytes(newLine);
							out.close();
						}
						catch(Exception e)
						{
							System.out.println("Unable to Create CSR FIle");
						}

						Alert alert=new Alert(AlertType.INFORMATION);
						alert.setTitle("Successful");
						alert.setContentText("File Created Successfully.");
						alert.showAndWait();
					}
				}

			}
		});

		//Home Button CSR Link Event Handler
		HomelinkCSR.setOnAction(new EventHandler<ActionEvent>() 	{
			public void handle(ActionEvent event) 
			{
				primaryStage.setScene(sceneBase);
				textFieldCSRBillingProvider.clear();
				textFieldCSRServicingProvider.clear();
				CSRServiceStartDtPicker.getEditor().clear();
				CSRServiceStartDtPicker.setPromptText("MM/DD/YYYY");
				CSRServiceEndDtPicker.getEditor().clear();
				CSRServiceEndDtPicker.setPromptText("MM/DD/YYYY");

			}
		});
		CSR.getChildren().addAll(rectCSRBorder,rectCSRTop,textCSRTop,HomelinkCSR,textCSRBillingProvider,textFieldCSRBillingProvider,textCSRServicingProvider,textFieldCSRServicingProvider,
				textCSRServiceStartDT,CSRServiceStartDtPicker,textCSRServiceEndDT,CSRServiceEndDtPicker,textCSRBillingProv,textCSRServicingProv,textCSRServiceStart,textCSRServiceEnd,
				validateDataCSR,createESIDataCSR,processDataCSR);
		CSR.setStyle("-fx-background-color:WHITE");
		/////////////////////
		return CSR;
	}

}
