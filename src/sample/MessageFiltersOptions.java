package sample;

/**
 * Created by stepan on 6/23/2017.
 */
public class MessageFiltersOptions {

    private boolean isDraftMessage;
    private boolean isRead;
    private boolean isFavorite;
    private boolean isArchived;
    private boolean isDirectMessage;
    private boolean isGroupMessage; //both can be true
    private boolean isInSentMessagesFolder;

    //Mostly for draft messages
    public MessageFiltersOptions(boolean isDraftMessage){
        this.isDraftMessage = isDraftMessage ;

    }

    //for messages from server
    public MessageFiltersOptions(boolean isRead, boolean isFavorite, boolean isArchived, boolean isDirectMessage, boolean isGroupMessage, boolean isInSentMessagesFolder){
        this.isDraftMessage = false;
        this.isRead = isRead;
        this.isFavorite = isFavorite;
        this.isArchived = isArchived;
        this.isDirectMessage = isDirectMessage;
        this.isGroupMessage = isGroupMessage;
        this.isInSentMessagesFolder = isInSentMessagesFolder;

    }

    public boolean isVisibleInInbox() {
    return isVisibleInInbox(false);
    }

    public boolean isVisibleInInbox(boolean isArchiveIncluded){
        if(isArchived && !isArchiveIncluded){
            return false;
        }
        return isDirectMessage || isGroupMessage;

    }

    public boolean isVisibleInSent() {
        return isVisibleInInbox(false);
    }

    public boolean isVisibleInSent(boolean isArchiveIncluded){
        if(isArchived && !isArchiveIncluded){
            return false;
        }
        return isInSentMessagesFolder;

    }


    public boolean isVisibleInFavorite() {
        return isVisibleInInbox(false);
    }

    public boolean isVisibleInFavorite(boolean isArchiveIncluded){
        if(isArchived && !isArchiveIncluded){
            return false;
        }
        return isFavorite;

    }


    public boolean isVisibleInDirect() {
        return isVisibleInInbox(false);
    }

    public boolean isVisibleInDirect(boolean isArchiveIncluded){
        if(isArchived && !isArchiveIncluded){
            return false;
        }
        return isDirectMessage;

    }


    public boolean isVisibleInGroup() {
        return isVisibleInInbox(false);
    }

    public boolean isVisibleInGroup(boolean isArchiveIncluded){
        if(isArchived && !isArchiveIncluded){
            return false;
        }
        return isGroupMessage;

    }









    public boolean isDraftMessage() {
        return isDraftMessage;
    }

    public void setDraftMessage(boolean draftMessage) {
        isDraftMessage = draftMessage;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public boolean isDirectMessage() {
        return isDirectMessage;
    }

    public void setDirectMessage(boolean directMessage) {
        isDirectMessage = directMessage;
    }

    public boolean isGroupMessage() {
        return isGroupMessage;
    }

    public void setGroupMessage(boolean groupMessage) {
        isGroupMessage = groupMessage;
    }

    public boolean isInSentMessagesFolder() {
        return isInSentMessagesFolder;
    }

    public void setInSentMessagesFolder(boolean inSentMesagesFolder) {
        isInSentMessagesFolder = inSentMesagesFolder;
    }


}
