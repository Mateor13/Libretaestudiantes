import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form3 extends JFrame {
    private JPanel menu2;
    private JTextField ced;
    private JButton busc;
    private JLabel nm;
    private JLabel ci;
    private JLabel b1;
    private JLabel b2;
    private JButton regresar;
    private JLabel avg;

    public form3() {
        setTitle("Buscar Estudiante");
        setContentPane(menu2);
        setPreferredSize(new Dimension(500, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        busc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = ced.getText();
                String url = "jdbc:mysql://localhost:3306/clase";
                String usuario = "root";
                String clave = "123456";
                try (Connection con = DriverManager.getConnection(url, usuario, clave)) {
                    String querry = "SELECT * FROM estudiantes WHERE cedula = '" + cedula + "'";
                    Statement ps = con.createStatement();
                    ResultSet rs = ps.executeQuery(querry);
                    if (rs.next()) {
                        nm.setText("Nombre: " + rs.getString("nombre"));
                        ci.setText("Cédula: " + rs.getString("cedula"));
                        b1.setText("Nota del primer bimestre: " + rs.getString("b1"));
                        b2.setText("Nota del segundo bimestre: " + rs.getString("b2"));
                        double noti1 = rs.getDouble("b1");
                        double noti2 = rs.getDouble("b2");
                        double promedio = (noti1 + noti2) / 2;
                        avg.setText("Promedio: " + String.valueOf(promedio));
                        setPreferredSize(new Dimension(500,350));
                        pack();
                        setLocationRelativeTo(null);
                    } else {
                        avg.setText("Estudiante no encontrado");
                        setPreferredSize(new Dimension(500,230));
                        pack();
                        setLocationRelativeTo(null);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                    avg.setText("Error al buscar en la Base de Datos");
                }
            }
        });
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new form1();
                dispose();
            }
        });
    }
}
