// Event Handling click on button and change screen with increasing value of x

public class HelloApplet1 extends Applet {
    Button b;
    MyListener li;
    int x;

    public void init() {
        b = new Button("X++");
        li = new MyListener();
        x = 0;

        b.addActionListener(li);
        add(b);
    }

    class MyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            x++;
            repaint();
        }
    }

    public void paint(Graphics g) {
        g.drawString("X = "+x,50,100);
    }
}


/* for the part of init you can make it like this using Anonymous innerclass */
/*
public void init() {
    b = new Button("X++");
    li = new MyListener();
    x = 0;

    b.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            x++;
            repaint();
        }
    });
    add(b);
}
*/