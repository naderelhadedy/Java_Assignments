// Event Handling for click button


import java.applet.Applet;
import java.awt.*;

public class HelloApplet extends Applet {
    // event source
    Button b = new Button("ok");

    // event listener
    MyListener li = new MyListener();

    // combine between source and listener
    public HelloApplet() {
        // type of event is action
        b.addActionListener(li);
    }


    // listener interface for event
    class MyListener implements ActionListener {
        // should call the method of interface
        public void actionPerformed(ActionEvent e) {
            System.out.println("button clicked");
        }
    }
}
