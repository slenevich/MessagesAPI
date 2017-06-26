package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import sample.dummy.DummyMainPanel;

/**
 * Created by stepan on 6/24/2017.
 */
public class InboxMessagesController {

    private final DummyMainPanel dummyMainPanel;
    private InboxMessagesModel model;
    private InboxMessagesView view;

    public InboxMessagesController(DummyMainPanel dummyMainPanel){
        this.dummyMainPanel = dummyMainPanel;
        model = new InboxMessagesModel(this);
        view = new InboxMessagesView(this, model);
        model.setInboxMessagesView(view);

        view.getCompose().setOnAction(ea -> dummyMainPanel.showPanel(3));


        view.getSelectedMessages().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    System.out.println(view.getSelectedMessages().getSelectionModel().getSelectedItem());
                }
            }
        });
    }

    public InboxMessagesView getView() {
        if(view == null){
            System.out.println("NULL view");
        }
        return view;
    }



    public void selectPersonalMessages() {
   }










    public DummyMainPanel getDummyMainPanel() {
        return dummyMainPanel;
    }

    public InboxMessagesModel getModel() {
        return model;
    }

    public void setModel(InboxMessagesModel model) {
        this.model = model;
    }

    public void setView(InboxMessagesView view) {
        this.view = view;
    }

    public void composeMessageButtonClicked() {
        dummyMainPanel.showPanel(3);
    }


}
