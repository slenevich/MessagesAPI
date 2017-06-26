package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Stepan on 6/22/2017.
 */
public class InboxMessagesView {
    private InboxMessagesController controller;
    private InboxMessagesModel model;


    private TableView<Message> selectedMessages;

    private TableColumn<Message, String> isArchivedColumn;
    private TableColumn<Message, String> isFavoriteColumn;
    private TableColumn<Message, String> senderIDColumn;
    private TableColumn<Message, Long> titleColumn;
    private TableColumn<Message, SimpleStringProperty> dateColumn;
    //private TableColumn<Message, SimpleStringProperty> dateColumn;


    private TextField messageID;
    private TextField senderID;
    private TextField messageTitle;
    private TextField dateSent;

    private VBox inboxVBox;
    private BorderPane pane;
    private VBox buttonsPanel;
    private Button composeMessageButton;
    private Button favoriteMessagesButton;
    private Button personalMessagesButton;
    private Button sentMessagesButton;
    private Button showArchivedMEssagesButton;
    //private Button compose;

    private Button deleteButton;

    private Stage window;




    public InboxMessagesView(InboxMessagesController inboxMessagesController, InboxMessagesModel inboxMessagesModel) {
        controller = inboxMessagesController;
        model = inboxMessagesModel;

        pane = new BorderPane();
        inboxVBox = new VBox();


        //TableColumn<Message, String> isArchivedColumn = new TableColumn<>("Archived" );
        isArchivedColumn = new TableColumn<>("Archived" );
        isArchivedColumn.setMinWidth(30);
        isArchivedColumn.setCellValueFactory(new PropertyValueFactory<>("isArchived"));

        //TableColumn<Message, String> isFavoriteColumn = new TableColumn<>("Starred");
        isFavoriteColumn = new TableColumn<>("Starred");
        isFavoriteColumn.setMinWidth(30);
        isFavoriteColumn.setCellValueFactory(new PropertyValueFactory<>("isFavorite"));

        //TableColumn<Message, String> senderIDColumn = new TableColumn<>("Sender");
        senderIDColumn = new TableColumn<>("Sender");
        senderIDColumn.setMinWidth(200);
        senderIDColumn.setCellValueFactory(new PropertyValueFactory<>("senderID"));

        //Message Title column
        //TableColumn<Message, Long> titleColumn = new TableColumn<>("Title");
        titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(300);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("messageTitle"));

        //Date sent column
        //TableColumn<Message, Date> dateColumn = new TableColumn<>("Date sent");

        TableColumn<Message, String> dateColumn;
        dateColumn = new TableColumn<>("Date sent");
        dateColumn.setMinWidth(100);
        //dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateSent"));




        dateColumn.setCellValueFactory(
                Job -> {
                    SimpleStringProperty property = new SimpleStringProperty();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    property.setValue(dateFormat.format(Job.getValue().getDateSent()));
                    return property;
                });


        senderID = new TextField();
        senderID.setPromptText("Sender");
        senderID.setMinWidth(100);

        messageTitle = new TextField();
        messageTitle.setPromptText("Title");

        //Quantity input
        dateSent = new TextField();
        dateSent.setPromptText("Sent on");



        // ImageView imageView = new ImageView();
        //("Archived"); with image
        //TableColumn<Message, String> isArchivedColumn = new TableColumn<>(imageView );



        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(senderID, messageTitle, dateSent);

        selectedMessages = new TableView<>();
        selectedMessages.setItems(model.getMessages());
        selectedMessages.getColumns().addAll(isArchivedColumn,  isFavoriteColumn, senderIDColumn, titleColumn, dateColumn);

        inboxVBox = new VBox();
        inboxVBox.getChildren().addAll(selectedMessages, hBox);
        pane.setCenter(inboxVBox);





        buttonsPanel = new VBox();
        composeMessageButton = new Button("Compose");
        composeMessageButton.setOnAction(ea -> controller.composeMessageButtonClicked());

        favoriteMessagesButton= new Button("Important");
        favoriteMessagesButton.setOnAction(e -> controller.selectPersonalMessages()); //selectFavoriteMessages()
        personalMessagesButton= new Button("Group");
//        deleteButton.setOnAction(e -> deleteButtonClicked());
        sentMessagesButton= new Button("Sent");
     //   deleteButton.setOnAction(e -> deleteButtonClicked());
        showArchivedMEssagesButton= new Button("Archived");
      //  deleteButton.setOnAction(e -> deleteButtonClicked());


        deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());
        buttonsPanel.getChildren().addAll(composeMessageButton, favoriteMessagesButton, personalMessagesButton,sentMessagesButton, showArchivedMEssagesButton,deleteButton);
        buttonsPanel.setSpacing(20);
        pane.setLeft(buttonsPanel);


            /*
            Scene scene = new Scene(inboxVBox);
            getWindow().setScene(scene);
            getWindow().show();*/

    }

    //Add button clicked
    public void addButtonClicked() {
        Message msg = new Message();
        msg.setSenderID(getSenderID().getText());
        msg.setMessageTitle((getMessageTitle().getText()));


        int delta = Integer.parseInt(getDateSent().getText());
        Long dif = new Long(delta);
        dif = dif * 1000000;


        msg.setDateSent(new Date(System.currentTimeMillis() - dif));
        getSelectedMessages().getItems().add(msg);
        getSenderID().clear();
        getMessageTitle().clear();
        getDateSent().clear();
    }

    //Delete button clicked
    public void deleteButtonClicked() {
        ObservableList<Message> productSelected, allProducts;
        allProducts = getSelectedMessages().getItems();
        productSelected = getSelectedMessages().getSelectionModel().getSelectedItems();

        productSelected.forEach(allProducts::remove);
    }

    //Get all of the products



    public VBox getInboxVBox() {
        return inboxVBox;
    }

    public void setInboxVBox(VBox inboxVBox) {
        this.inboxVBox = inboxVBox;
    }

    public Stage getWindow() {
        return window;
    }

    public void setWindow(Stage window) {
        this.window = window;
    }

    public TableView<Message> getSelectedMessages() {
        return selectedMessages;
    }

    public void setSelectedMessages(TableView<Message> selectedMessages) {
        this.selectedMessages = selectedMessages;
    }

    public TextField getMessageID() {
        return messageID;
    }

    public void setMessageID(TextField messageID) {
        this.messageID = messageID;
    }

    public TextField getSenderID() {
        return senderID;
    }

    public void setSenderID(TextField senderID) {
        this.senderID = senderID;
    }

    public TextField getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(TextField messageTitle) {
        this.messageTitle = messageTitle;
    }

    public TextField getDateSent() {
        return dateSent;
    }

    public void setDateSent(TextField dateSent) {
        this.dateSent = dateSent;
    }

    public BorderPane getMessagePane() {
        return pane;
    }

    public BorderPane getPane() {
        return pane;
    }
    public InboxMessagesController getController() {
        return controller;
    }

    public void setController(InboxMessagesController controller) {
        this.controller = controller;
    }

    public InboxMessagesModel getModel() {
        return model;
    }

    public void setModel(InboxMessagesModel model) {
        this.model = model;
    }

    public TableColumn<Message, String> getIsArchivedColumn() {
        return isArchivedColumn;
    }

    public void setIsArchivedColumn(TableColumn<Message, String> isArchivedColumn) {
        this.isArchivedColumn = isArchivedColumn;
    }

    public TableColumn<Message, String> getIsFavoriteColumn() {
        return isFavoriteColumn;
    }

    public void setIsFavoriteColumn(TableColumn<Message, String> isFavoriteColumn) {
        this.isFavoriteColumn = isFavoriteColumn;
    }

    public TableColumn<Message, String> getSenderIDColumn() {
        return senderIDColumn;
    }

    public void setSenderIDColumn(TableColumn<Message, String> senderIDColumn) {
        this.senderIDColumn = senderIDColumn;
    }

    public TableColumn<Message, Long> getTitleColumn() {
        return titleColumn;
    }

    public void setTitleColumn(TableColumn<Message, Long> titleColumn) {
        this.titleColumn = titleColumn;
    }

    public TableColumn<Message, SimpleStringProperty> getDateColumn(){
        return dateColumn;
    }

    public void setDateColumn(TableColumn<Message, SimpleStringProperty> dateColumn) {
        this.dateColumn = dateColumn;
    }

    public void setPane(BorderPane pane) {
        this.pane = pane;
    }


    public VBox getButtonsPanel() {
        return buttonsPanel;
    }

    public void setButtonsPanel(VBox buttonsPanel) {
        this.buttonsPanel = buttonsPanel;
    }

    public Button getCompose() {
        return composeMessageButton;
    }

    public void setCompose(Button compose) {
        this.composeMessageButton = compose;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public Button getComposeMessageButton() {
        return composeMessageButton;
    }

    public void setComposeMessageButton(Button composeMessageButton) {
        this.composeMessageButton = composeMessageButton;
    }

    public Button getFavoriteMessagesButton() {
        return favoriteMessagesButton;
    }

    public void setFavoriteMessagesButton(Button favoriteMessagesButton) {
        this.favoriteMessagesButton = favoriteMessagesButton;
    }

    public Button getPersonalMessagesButton() {
        return personalMessagesButton;
    }

    public void setPersonalMessagesButton(Button personalMessagesButton) {
        this.personalMessagesButton = personalMessagesButton;
    }

    public Button getSentMessagesButton() {
        return sentMessagesButton;
    }

    public void setSentMessagesButton(Button sentMessagesButton) {
        this.sentMessagesButton = sentMessagesButton;
    }

    public Button getShowArchivedMEssagesButton() {
        return showArchivedMEssagesButton;
    }

    public void setShowArchivedMEssagesButton(Button showArchivedMEssagesButton) {
        this.showArchivedMEssagesButton = showArchivedMEssagesButton;
    }
}