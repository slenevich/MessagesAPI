package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.dummy.DummyMessages;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by stepan on 6/23/2017.
 */
public class InboxMessagesModel {




    public enum MessageStatus {
        CLIENT_DRAFT, SERVER_DRAFT, MESSAGE_SENT
    }
    
    private final InboxMessagesController controller;
    private InboxMessagesView view;
    private List<Message> initialMessages;
    private MessageStatus messageStatus;

    private boolean areOnlyStarredMessagesIncluded = false;
    private boolean arePersonalMessagesIncluded = true;
    private boolean areGroupMessagesIncluded = true;
    private boolean areSentMessagesIncluded = false;
    private boolean areArchivedMessagesIncluded = false;


    private int unreadMessagesCount;

    public InboxMessagesModel(InboxMessagesController inboxMessagesController){
        controller = inboxMessagesController;
        initialMessages =  DummyMessages.initialMessages;
        unreadMessagesCount = countUnreadMessages();

    }


    public int countUnreadMessages() {
        int totalUndread = 0;

        if(null == initialMessages){
            return -1;
        }

        for(Message m  : initialMessages){

            if(null == m.getFilters()){
                return -2;
            }

            if(!m.getFilters().isRead()){
                totalUndread +=1;
            }
        }
        return totalUndread;
    }





    private void verifyMessageBody() {
    }

    private void verifyTitle() {

    }


    public ObservableList<Message> getMessages() {
        ObservableList<Message> messages = FXCollections.observableArrayList();

        for(Message m: initialMessages){

            boolean doesMessagePassUserFilters = checkFilters(m);





            if(m.getSenderID().compareToIgnoreCase(DummyMessages.userID)==0 || m.getRecipientIDs().contains(DummyMessages.userID)){
                messages.add(m);
            }
        }

        return messages;
    }

    private boolean checkFilters(Message m) {

        if(areOnlyStarredMessagesIncluded && !m.getFilters().isFavorite()){
            return false;
        }
        if(!arePersonalMessagesIncluded && m.getFilters().isDirectMessage()){
            return false;
        }
        if(!areGroupMessagesIncluded && m.getFilters().isGroupMessage()){
            return false;
        }
        if(!areSentMessagesIncluded && m.getFilters().isInSentMessagesFolder()){
            return false;
        }
        if(!areArchivedMessagesIncluded && m.getFilters().isArchived()){
            return false;
        }
        return true;
    }


    // Getters and setters


    public InboxMessagesController getController() {
        return controller;
    }

    public InboxMessagesView getView() {
        return view;
    }

    public void setView(InboxMessagesView view) {
        this.view = view;
    }


    public void setInboxMessagesView(InboxMessagesView inboxMessagesView) {
        this.view = inboxMessagesView;
    }

    public List<Message> getInitialMessages() {
        return initialMessages;
    }

    public void setInitialMessages(List<Message> initialMessages) {
        this.initialMessages = initialMessages;
    }

    public int getUnreadMessagesCount() {
        return unreadMessagesCount;
    }

    public void setUnreadMessagesCount(int unreadMessagesCount) {
        this.unreadMessagesCount = unreadMessagesCount;
    }

    public MessageStatus getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(MessageStatus messageStatus) {
        this.messageStatus = messageStatus;
    }

    public boolean isAreOnlyStarredMessagesIncluded() {
        return areOnlyStarredMessagesIncluded;
    }

    public void setAreOnlyStarredMessagesIncluded(boolean areOnlyStarredMessagesIncluded) {
        this.areOnlyStarredMessagesIncluded = areOnlyStarredMessagesIncluded;
    }

    public boolean arePersonalMessagesIncluded() {
        return arePersonalMessagesIncluded;
    }

    public void setArePersonalMessagesIncluded(boolean arePersonalMessagesIncluded) {
        this.arePersonalMessagesIncluded = arePersonalMessagesIncluded;
    }

    public boolean isAreGroupMessagesIncluded() {
        return areGroupMessagesIncluded;
    }

    public void setAreGroupMessagesIncluded(boolean areGroupMessagesIncluded) {
        this.areGroupMessagesIncluded = areGroupMessagesIncluded;
    }

    public boolean isAreSentMessagesIncluded() {
        return areSentMessagesIncluded;
    }

    public void setAreSentMessagesIncluded(boolean areSentMessagesIncluded) {
        this.areSentMessagesIncluded = areSentMessagesIncluded;
    }

    public boolean isAreArchivedMessagesIncluded() {
        return areArchivedMessagesIncluded;
    }

    public void setAreArchivedMessagesIncluded(boolean areArchivedMessagesIncluded) {
        this.areArchivedMessagesIncluded = areArchivedMessagesIncluded;
    }

}