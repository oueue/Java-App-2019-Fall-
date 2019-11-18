package fileencryption;
import javax.swing.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
public class InputCode extends JDialog {
    protected JTextField tf = new JTextField();
    protected JLabel lb = new JLabel("Please input the code:");
    protected JButton cmdCfm = new JButton("Confirm");
    protected JButton cmdCan = new JButton("Cancel");
    public static int code;
    public InputCode()
    {
        JPanel  p = new JPanel(new BorderLayout());
        setSize(new Dimension(300, 180));
        setLocation(260, 400);
        tf.setPreferredSize(new Dimension(260,50));
        tf.setFont(new Font("Segoe Print", Font.PLAIN, 18));
        tf.setBackground(new Color(255, 255, 255));
        tf.setForeground(new Color(140, 147, 155));
        lb.setFont(new Font("Segoe Print", Font.PLAIN, 17));
        lb.setForeground(new Color(140, 147, 155));
        JPanel pf = new JPanel(new FlowLayout(2, 10, 10));
        pf.setBackground(new Color(255, 255, 255));
        pf.add(tf);pf.add(cmdCfm);pf.add(cmdCan);
        p.add(pf, BorderLayout.CENTER);
        p.add(lb, BorderLayout.NORTH);
        p.setBackground(new Color(255, 255, 255));
        add(p);
        addListeners();
        setVisible(true);
        setResizable(false);
    }
    private void addListeners()
    {
        cmdCfm.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                code = Integer.parseInt(tf.getText());
                new Encryption();
                dispose();
            }
        });
    }
}
