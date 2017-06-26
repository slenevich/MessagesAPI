package sample;

import sample.dummy.DummyMessages;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stepan on 6/24/2017.
 */
public class MessageComposeModel {

    private MessageComposeController controller;
    MessageComposeView view;
    private Message message;
    private List<Message> messageChain;
    private Long parentID;

    private List<String> validRecipients;
    private List<String> invalidRecipients;

    private boolean isMessageTitleValid;
    private boolean isMessageBodyValid;



    public MessageComposeModel(MessageComposeController messageComposeController){
        this(messageComposeController, -1L);
    }

    //if reply to is used
    public MessageComposeModel(MessageComposeController messageComposeController, Long parentMessageID){

        parentID = parentMessageID;
        controller = messageComposeController;
        message = new Message(parentMessageID);
        populateReplyToSender();
    }

    private void populateReplyToSender() {
        if(parentID > 0 ) {
            Message parentMessage = DummyMessages.getMessageByID(parentID);
            if (null != parentMessage && null != parentMessage.getSenderID()) {
                message.getRecipientIDs().add(parentMessage.getSenderID());
            } else {
                System.out.println("cannot resolve sender");
            }
        }
    }

    public List<Message> getParentMessages(){
    List<Message>  parentMessages = new ArrayList<>();

    Long parentID = message.getParentID();

    while(parentID > 0){
        Message parent = DummyMessages.getMessageByID(parentID);
        if(null == parent) {
            return sort(parentMessages);
        }else{
            parentMessages.add(parent);
            parentID = parent.getParentID();
        }

    }
        return sort(parentMessages);
    }

    private List<Message> sort(List<Message> parentMessages) {
        if (parentMessages.isEmpty()){
            return parentMessages;
        }
        List<Message> orderedFromFirstToLast = new ArrayList<>();
        for (int i = parentMessages.size()-1 ;  i >=0;i-=1){
            orderedFromFirstToLast.add(parentMessages.get(i));
        }
    return orderedFromFirstToLast;
    }



    public void verifyTitle(String title){
        if(null == title || title.isEmpty()){
            isMessageTitleValid = false;
        }else{
            isMessageTitleValid = true;
        }
    }

    public void verifyBody(String body){
        if(null == body || body.isEmpty()){
            isMessageBodyValid = false;
        }else{
            isMessageBodyValid = true;
        }
    }



    public void verifyRecipients(String recipientIDs) {
        parseRecepients(recipientIDs);
    }

    /*
    public void verifyRecipients(String recipientIDs) {
        recipientIDs
    }*/


    public static boolean isValidEmailAddress(String email) {

            return true; //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    public void parseRecepients(String recipients){

        validRecipients = new ArrayList<>();
        invalidRecipients = new ArrayList<>();

        String[] parsedRecipientIDs = recipients.split(";");
        for (String s : parsedRecipientIDs){
            System.out.println(s);
        }
    }






    //getters and setters

    public MessageComposeController getController() {
        return controller;
    }

    public void setController(MessageComposeController controller) {
        this.controller = controller;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public List<Message> getMessageChain() {
        return messageChain;
    }

    public void setMessageChain(List<Message> messageChain) {
        this.messageChain = messageChain;
    }

    public Long getParentID() {
        return parentID;
    }

    public void setParentID(Long parentID) {
        this.parentID = parentID;
    }

    public void setMessageComposeView(MessageComposeView messageComposeView) {
        view = messageComposeView;
    }

    public List<String> getValidRecipients() {
        return validRecipients;
    }

    public void setValidRecipients(List<String> validRecipients) {
        this.validRecipients = validRecipients;
    }

    public List<String> getInvalidRecipients() {
        return invalidRecipients;
    }

    public void setInvalidRecipients(List<String> invalidRecipients) {
        this.invalidRecipients = invalidRecipients;
    }

    public boolean isMessageTitleValid() {
        return isMessageTitleValid;
    }

    public void setMessageTitleValid(boolean messageTitleValid) {
        isMessageTitleValid = messageTitleValid;
    }

    public boolean isMessageBodyValid() {
        return isMessageBodyValid;
    }

    public void setMessageBodyValid(boolean messageBodyValid) {
        isMessageBodyValid = messageBodyValid;
    }


    // public getParentMessages

}
