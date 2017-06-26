package sample.dummy;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import sample.InboxMessagesController;
import sample.InboxMessagesModel;
import sample.MessageComposeController;
import sample.MessageDisplayController;

import java.util.Date;

/**
 * Created by stepan on 6/24/2017.
 */
public class DummyMainPanel {

    public enum ActivePanel{ INBOX, REPLY, COMPOSE_NEW, QUIT_MESSAGER;  }

    InboxMessagesModel inboxMessagesModel;
    //ViewMessageModel viewMessageModel = new ViewMessageModel(Long messageID)
    //ComposeMessageModel viewMessageModel = new ComposeMessageModel(Long messageID)  //if reply - get parent id. If new message  -  create plank


    private ActivePanel currentPanel;

    private InboxMessagesController inboxMessagesController;
    private MessageDisplayController selectedMessage;
    private MessageComposeController compose;


    private BorderPane mainPane = new BorderPane();
    private String inboxLabel = "Inbox";


    //on pressing reply or new message
    //compose = new MessageComposeController(Long isReply);


    private HBox buttonBox = new HBox();
    private HBox mainBox = new HBox();
    private HBox inBox = new HBox();
    private HBox readBox = new HBox();
    private HBox composeBox = new HBox();
    private Button mainView;
    private Button inboxButton;
    private Button viewMessage;
    private Button composeButton;
    private Button refreshButton;


    public DummyMainPanel() {
        inboxMessagesController = new InboxMessagesController(this);
        inboxMessagesController.getModel().getUnreadMessagesCount();


        inboxLabel = getInboxLabel();

        mainView = new Button("Main");
        inboxButton = new Button(inboxLabel);
        viewMessage = new Button("Read message");
        composeButton = new Button("Compose");
        refreshButton = new Button("Refresh");

        mainView.setOnAction(event -> showPanel(0));
        inboxButton.setOnAction(event -> showPanel(1));
        viewMessage.setOnAction(event -> showPanel(2));
        composeButton.setOnAction(event -> showPanel(3));
        refreshButton.setOnAction(event -> showPanel(4));

        mainBox.getChildren().add(new Label("This is the main box: User starts from here"));


        buttonBox.getChildren().addAll(inboxButton, viewMessage, composeButton, refreshButton,mainView);
        buttonBox.setSpacing(20);
        mainPane.setTop(buttonBox);
        mainPane.setCenter(mainBox);


    }


    public void showPanel( ActivePanel selectedPanel){

        switch (selectedPanel) {
            /*
            case :
                mainPane.setCenter(mainBox);
                break; // optional
                */

            case INBOX:

                inboxMessagesController = new InboxMessagesController(this);
                Label inbox = new Label("Inbox");

                if(null == inboxMessagesController.getView().getPane()){
                    System.out.println("NULL HERE in DUMMY");

                }
                mainPane.setCenter(inboxMessagesController.getView().getPane());
                mainPane.setBottom(inbox);
                break; // optional]

            case REPLY:
                Label readLabel = new Label("Read message");
                mainPane.setBottom(readLabel);
                break; // optional

            case COMPOSE_NEW:
                compose = new MessageComposeController(this, -1L);

                Label writeLabel = new Label("Write message");
                mainPane.setBottom(writeLabel);
                mainPane.setCenter(compose.getView().getPane());
                break; // optional


            /*
            case 4 :
                // inboxMessagesModel = new InboxMessagesModel(this);
                Label inboxRefreshed = new Label("Inbox refreshed on " + new Date() );

                inboxLabel = getInboxLabel();

                mainPane.setBottom(inboxRefreshed);
                break; // optional
                */

            // You can have any number of case statements.
            default: // Optional
                // Statements
        }

    }


    public void showPanel(int i) {

        switch (i) {
            case 0:
                mainPane.setCenter(mainBox);
                break; // optional

            case 1:

                inboxMessagesController = new InboxMessagesController(this);
                Label inbox = new Label("Inbox");

                if(null == inboxMessagesController.getView().getPane()){
                    System.out.println("NULL HERE in DUMMY");

                }
                mainPane.setCenter(inboxMessagesController.getView().getPane());
                mainPane.setBottom(inbox);
                break; // optional]

            case 2:
                Label readLabel = new Label("Read message");
                mainPane.setBottom(readLabel);
                break; // optional

            case 3:
                compose = new MessageComposeController(this, -1L);

                Label writeLabel = new Label("Write message");
                mainPane.setBottom(writeLabel);
                mainPane.setCenter(compose.getView().getPane());
                break; // optional


            case 4 :
               // inboxMessagesModel = new InboxMessagesModel(this);
                Label inboxRefreshed = new Label("Inbox refreshed on " + new Date() );

                inboxLabel = getInboxLabel();

                mainPane.setBottom(inboxRefreshed);
                break; // optional

            // You can have any number of case statements.
            default: // Optional
                // Statements
        }

    }


    public String getInboxLabel() {

        if (null == inboxMessagesController) {
            return "Inbox: no Inbox Model";
        }
        if (null == inboxMessagesController) {
            inboxMessagesController = new InboxMessagesController(this);
        }
        int count = inboxMessagesController.getModel().countUnreadMessages();

        if (count == -1) {
            return "Inbox: Message Exception";
        }

        if (count == -2) {
            return "Inbox: Message filter exception";

        }
        if (count == 0) {
            return "Inbox";
        }
        return "Inbox (" + count + ")";


    }


// Getters and setters


    public void setInboxMessagesModel(InboxMessagesModel inboxMessagesModel) {
        this.inboxMessagesModel = inboxMessagesModel;
    }



    public void setInboxMessagesController(InboxMessagesController inboxMessagesController) {
        this.inboxMessagesController = inboxMessagesController;
    }

    public void setSelectedMessage(MessageDisplayController selectedMessage) {
        this.selectedMessage = selectedMessage;
    }

    public void setCompose(MessageComposeController compose) {
        this.compose = compose;
    }

    public void setInboxLabel(String inboxLabel) {
        this.inboxLabel = inboxLabel;
    }

    public void setButtonBox(HBox buttonBox) {
        this.buttonBox = buttonBox;
    }

    public void setMainBox(HBox mainBox) {
        this.mainBox = mainBox;
    }

    public void setInBox(HBox inBox) {
        this.inBox = inBox;
    }

    public void setReadBox(HBox readBox) {
        this.readBox = readBox;
    }

    public void setComposeBox(HBox composeBox) {
        this.composeBox = composeBox;
    }

    public Button getMainView() {
        return mainView;
    }

    public void setMainView(Button mainView) {
        this.mainView = mainView;
    }

    public Button getInboxButton() {
        return inboxButton;
    }

    public void setInboxButton(Button inboxButton) {
        this.inboxButton = inboxButton;
    }

    public Button getViewMessage() {
        return viewMessage;
    }

    public void setViewMessage(Button viewMessage) {
        this.viewMessage = viewMessage;
    }

    public Button getComposeButton() {
        return composeButton;
    }

    public void setComposeButton(Button composeButton) {
        this.composeButton = composeButton;
    }

    public Button getRefreshButton() {
        return refreshButton;
    }

    public void setRefreshButton(Button refreshButton) {
        this.refreshButton = refreshButton;
    }


    public BorderPane getMainPane() {
        return mainPane;
    }

    public HBox getInBox() {
        return inBox;
    }
}