package APP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class HyperlinkAlgebra extends JFrame {
        private String text = "Learn more about Algebra here";
        private JLabel hyperlink = new JLabel(text);

        public HyperlinkAlgebra() throws HeadlessException {
            super();
            setTitle("Hyperlink Demo");

            hyperlink.setForeground(Color.BLUE.darker());
            hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));

            hyperlink.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        Desktop.getDesktop().browse(new URI("https://www.splashlearn.com/math-vocabulary/algebra/algebra#:~:text=Algebra%20is%20the%20part%20of,a%20definite%20or%20fixed%20value."));
                    } catch (IOException | URISyntaxException e1) {
                        e1.printStackTrace();
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    hyperlink.setText(text);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    hyperlink.setText("<html><a href=''>" + text + "</a></html>");
                }

            });
        }
        public JLabel algebraLink() {
            return hyperlink;
        }
}

