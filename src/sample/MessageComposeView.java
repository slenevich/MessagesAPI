package sample;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Created by stepan on 6/24/2017.
 */
public class MessageComposeView {

    private BorderPane pane = new BorderPane();

    private VBox top;


    private TextArea previousMessagesBrief;
    private TextArea previousMessagesFull;


    private MessageComposeModel model;
    private MessageComposeController controller;
    private VBox composeBox;
    private TextField titleField = new TextField();
    private TextField sendToField = new TextField();
    private TextArea messageBody = new TextArea();
    private Button sendMessageBotton = new Button("Send");
    private TextField statusField = new TextField();


    public MessageComposeView(MessageComposeController messageComposeController, MessageComposeModel messageComposeModel) {
        controller = messageComposeController;
        model = messageComposeModel;

        composeBox = new VBox();

        if(!messageComposeModel.getParentMessages().isEmpty()){
            addParentMessagesPanel();//top
        }

        titleField = new TextField();
        titleField.setPromptText("Title:");
        titleField.setText("");
        sendToField = new TextField();
        sendToField.setPromptText("Send to:");
        sendToField.setText("");
        messageBody = new TextArea();
        messageBody.setText("");
        sendMessageBotton = new Button("Send");
        sendMessageBotton.setOnAction(ea -> controller.processPostMessageRequest());
        //sendMessageBotton.setSp.setSpacing(10);
        statusField = new TextField();
        statusField.setVisible(false);
        composeBox.getChildren().addAll(titleField, sendToField,  messageBody, sendMessageBotton, statusField);
        pane.setCenter(composeBox);
    }



    private void addParentMessagesPanel() {
    }


    public BorderPane getPane() {
        return pane;
    }

    public void setPane(BorderPane pane) {
        this.pane = pane;
    }

    public VBox getTop() {
        return top;
    }

    public void setTop(VBox top) {
        this.top = top;
    }

    public TextArea getPreviousMessagesBrief() {
        return previousMessagesBrief;
    }

    public void setPreviousMessagesBrief(TextArea previousMessagesBrief) {
        this.previousMessagesBrief = previousMessagesBrief;
    }

    public TextArea getPreviousMessagesFull() {
        return previousMessagesFull;
    }

    public void setPreviousMessagesFull(TextArea previousMessagesFull) {
        this.previousMessagesFull = previousMessagesFull;
    }

    public MessageComposeModel getModel() {
        return model;
    }

    public void setModel(MessageComposeModel model) {
        this.model = model;
    }

    public MessageComposeController getController() {
        return controller;
    }

    public void setController(MessageComposeController controller) {
        this.controller = controller;
    }

    public VBox getComposeBox() {
        return composeBox;
    }

    public void setComposeBox(VBox composeBox) {
        this.composeBox = composeBox;
    }

    public TextField getTitleField() {
        return titleField;
    }

    public void setTitleField(TextField titleField) {
        this.titleField = titleField;
    }

    public TextField getSendToField() {
        return sendToField;
    }

    public void setSendToField(TextField sendToField) {
        this.sendToField = sendToField;
    }

    public TextArea getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(TextArea messageBody) {
        this.messageBody = messageBody;
    }

    public Button getSendMessageBotton() {
        return sendMessageBotton;
    }

    public void setSendMessageBotton(Button sendMessageBotton) {
        this.sendMessageBotton = sendMessageBotton;
    }

    public TextField getStatusField() {
        return statusField;
    }

    public void setStatusField(TextField statusField) {
        this.statusField = statusField;
    }
}


/*
TextFlow flow = new TextFlow();

Text text1=new Text("Some Text");
text1.setStyle("-fx-font-weight: bold");

Text text2=new Text("Some Text");
text2.setStyle("-fx-font-weight: regular");

flow.getChildren().addAll(text1, text2);
 */
