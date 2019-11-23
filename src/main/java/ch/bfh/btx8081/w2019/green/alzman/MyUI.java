package ch.bfh.btx8081.w2019.green.alzman;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class MyUI extends VerticalLayout {

    public MyUI() {
        Button button = new Button("Click me",
                event -> Notification.show("Clicked!"));
        add(button);
    }
    
}

