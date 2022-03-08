// importing Applet class from applet pachake
import java.applet.Applet;
// importing Graphics class from awt package
import java.awt.Graphics;

public class HelloApplet extends Applet {
    // reference from Graphics to object g that represents applet
    public void paint(Graphics g) {
        // call method from reference or object Graphics with position x=50, y=100
        g.drawString("Hello from java Applet", 50, 100);
    }
}