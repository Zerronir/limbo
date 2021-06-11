import com.limbo.DAO.ClientAccess;
import com.limbo.entities.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio {
    private JPanel Inici;
    private JTextField userName;
    private JButton iniciarSessióButton;
    private JButton registreButton;
    private JPasswordField passwordField;

    public Inicio() {
        iniciarSessióButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String username = userName.getText();
                    String password = passwordField.getText();

                    ClientAccess cs = new ClientAccess();
                    Client c = cs.findByUsernameEqualsAndPasswordEquals(username, password);
                    JOptionPane.showMessageDialog(null, c.getNom()+" "+c.getCognom1());

                }catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        registreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "CLICK EN REGISTRE");
            }
        });
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Inici");
        jFrame.setContentPane(new Inicio().Inici);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
