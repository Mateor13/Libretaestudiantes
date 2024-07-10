import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 extends JFrame {
    private JButton inse;
    private JButton bus;
    private JPanel mainPanel;
    private JButton cerrar;

    public form1() {
        setTitle("Menú Principal");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700, 300));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        inse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new form2();
                dispose();
            }
        });
        bus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new form3();
                dispose();
            }
        });
        cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
