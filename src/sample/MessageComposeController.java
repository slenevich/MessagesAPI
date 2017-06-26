package sample;

import sample.dummy.DummyMainPanel;

/**
 * Created by stepan on 6/24/2017.
 */
public class MessageComposeController {
    private MessageComposeModel model;
    private MessageComposeView view;
    private  Long parentMessageID;
    private final DummyMainPanel dummyMainPanel;


    public MessageComposeController(DummyMainPanel dummyMainPanel, Long parentMessageID) {
        this.dummyMainPanel = dummyMainPanel;
        this.parentMessageID = parentMessageID;

        model = new MessageComposeModel(this, parentMessageID);
        view = new MessageComposeView(this, model);
        model.setMessageComposeView(view);
         //this.view.addCalculateListener(new composeListener());
    }

    public void processPostMessageRequest(){

        /*
        try{


            model.validateTitle();
            model.validateBody();
            model.validateRecipients();

            firstNumber = theView.getFirstNumber();
            secondNumber = theView.getSecondNumber();

            theModel.addTwoNumbers(firstNumber, secondNumber);

            theView.setCalcSolution(theModel.getCalculationValue());

        }

        catch(NumberFormatException ex){

            System.out.println(ex);

            theView.displayErrorMessage("You Need to Enter 2 Integers");

        }*/





        String status = "";

        String title = view.getTitleField().getText();
        System.out.println(title);
        String recipients = view.getSendToField().getText();
        System.out.println(recipients);
        String body = view.getMessageBody().getText();
        System.out.println(body);
        if(title.isEmpty()){
            //showEmptyTitleVarning();

            status = status + "Title cannot be empty. ";
        }
        if(recipients.isEmpty()){
            status = status + "Recipients cannot be empty. ";
        }

        if(body.isEmpty()){
            status = status + "Message body cannot be empty. ";
        }

        if(status.compareTo("")==0){

            view.getStatusField().setText(status);
            view.getStatusField().setVisible(true);
            dummyMainPanel.showPanel(1);
            dummyMainPanel.getInBox().requestFocus();
        }else{

            view.getStatusField().setText(status);
            view.getStatusField().setVisible(true);
        }




        //model.getMessage().sendMessage();

    }

    public MessageComposeModel getModel() {
        return model;
    }

    public void setModel(MessageComposeModel model) {
        this.model = model;
    }

    public MessageComposeView getView() {
        return view;
    }

    public void setView(MessageComposeView view) {
        this.view = view;
    }

    public Long getParentMessageID() {
        return parentMessageID;
    }

    public void setParentMessageID(Long parentMessageID) {
        this.parentMessageID = parentMessageID;
    }
}
