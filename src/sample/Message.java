package sample;

import sample.dummy.DummyMessages;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by stepan on 6/23/2017.
 */
public class Message {

    private Long messageID;   // -1 while composing a letter
    private Long parentID ;   // -1  if this is a first message in a chain
    //
    private String senderID;
    private List<String> recipientIDs = new ArrayList<>();
    private String messageTitle = "";
    private String messageBody = "";
    private Date dateSent;
    private Date dateReceived;

    private MessageFiltersOptions filters;




    //creates new draft message
    public Message() {
        this(-1L);
    }

    public Message(Long replyToMessageID) {

        senderID = DummyMessages.userID;
        messageID = new Long(-1);
        parentID = replyToMessageID;
        filters = new MessageFiltersOptions(true);

    }



    public Message(Long msgID, Long parentID, String senderID, List<String> recipientIDs, String messageTitle, String messageBody, Date dateSent, boolean isRead, boolean isFavorite, boolean isArchived) {
        messageID = msgID;
        this.parentID = parentID;
        this.senderID = senderID;
        this.recipientIDs.addAll(recipientIDs);
        this.messageTitle = messageTitle;
        this.messageBody = messageBody;
        this.dateSent = dateSent;

        boolean isDirectMessage =   null  != messageID && messageID > 0L &&   recipientIDs.size() == 1 && recipientIDs.stream().anyMatch(x -> x.equalsIgnoreCase(DummyMessages.userID)) ;
        boolean isGroupMessage =   null  != messageID && messageID > 0L &&   recipientIDs.size() > 1 && recipientIDs.stream().anyMatch(x -> x.equalsIgnoreCase(DummyMessages.userID)) ;
        boolean isInSentMessagesFolder = DummyMessages.userID.compareToIgnoreCase(senderID) == 0 ;

        filters = new MessageFiltersOptions( isRead,  isFavorite,  isArchived,  isDirectMessage,  isGroupMessage,  isInSentMessagesFolder );

    }

    public Long getMessageID() {
        return messageID;
    }

    public void setMessageID(Long messageID) {
        this.messageID = messageID;
    }

    public Long getParentID() {
        return parentID;
    }

    public void setParentID(Long parentID) {
        this.parentID = parentID;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public List<String> getRecipientIDs() {
        return recipientIDs;
    }

    public void setRecipientIDs(List<String> recipientIDs) {
        this.recipientIDs = recipientIDs;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }


    public MessageFiltersOptions getFilters() {
        return filters;
    }

    public void setFilters(MessageFiltersOptions filters) {
        this.filters = filters;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("");

        sb.append("messageID: ").append(messageID).append("\n");
        sb.append("senderID: ").append(senderID).append("\n");
        sb.append("recipientIDs: ");

        for(String r : recipientIDs){
            sb.append("\t").append(r);

        }

        sb.append("\n");

        sb.append("messageTitle: ").append(messageTitle).append("\n");
        sb.append("messageID: ").append(messageID).append("\n");
        sb.append("messageBody: ").append(messageBody).append("\n");
        sb.append("parentID: ").append(parentID).append("\n");
        sb.append("dateSent: ").append(dateSent.toString()).append("\n");
        String dateReceivedStr = dateReceived == null ? "NA" : dateReceived.toString();
        sb.append("dateReceived: ").append(dateReceivedStr).append("\n");


        sb.append("isRead: ").append(filters.isRead()).append("\t");
        sb.append("isFavorite: ").append( filters.isFavorite()).append("\t");
        sb.append("isArchived: ").append(filters.isArchived()).append("\t");
        sb.append("isDirectMessage: ").append(filters.isDirectMessage() ).append("\t");
        sb.append("isGroupMessage: ").append(filters.isGroupMessage()).append("\n");

        return sb.toString();

    }

    public void sendMessage() {
    }
}
