import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form2 extends JFrame {
    private JPanel menu1;
    private JTextField nm;
    private JTextField ci;
    private JTextField b1;
    private JTextField b2;
    private JButton insertar;
    private JLabel resultado;
    private JButton regresarButton;

    public form2() {
        setTitle("Insercción de Datos");
        setContentPane(menu1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 450));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        insertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nm.getText();
                String cedula = ci.getText();
                String nota1 = b1.getText();
                String nota2 = b2.getText();
                String url = "jdbc:mysql://localhost:3306/clase";
                String usuario = "root";
                String clave = "123456";
                try (Connection con = DriverManager.getConnection(url,usuario,clave)){
                    String querry="insert into estudiantes (cedula, nombre, b1, b2) values (?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(querry);
                    ps.setString(1, cedula);
                    ps.setString(2, nombre);
                    ps.setString(3, nota1);
                    ps.setString(4, nota2);
                    ps.executeUpdate();
                    resultado.setText("Datos insertados correctamente");
                }catch(SQLException e1){
                    e1.printStackTrace();
                    resultado.setText("Error al insertar datos");
                    setPreferredSize(new Dimension(500, 500));
                    pack();
                    setLocationRelativeTo(null);
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new form1();
                dispose();
            }
        });
    }
}
