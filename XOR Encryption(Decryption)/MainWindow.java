package fileencryption;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainWindow extends JFrame
{
    private JButton cmdEpt = new JButton("Encrypt");
    private JButton cmdDcp = new JButton("Decrypt");
    private JButton cmdCmp = new JButton("Compare");
    private JButton cmdExt = new JButton("Exit");
    public MainWindow()
    {
        setTitle("File Encryption   @copyright WeiYue");
        setSize(410, 650); setLocation(200, 200);
        setBg();
        JPanel p = new JPanel();
        p.setOpaque(false);
        Container c = getContentPane();
        c.add(p);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addListeners();
        createWindow();
        setVisible(true);
        setResizable(false);
    }
    public void setBg(){
        ((JPanel)this.getContentPane()).setOpaque(false);
        ImageIcon img= new ImageIcon("C:\\Users\\Administrator\\Desktop\\wy.jpg");
        JLabel bg = new JLabel(img);
        this.getLayeredPane().add(bg, new Integer(Integer.MIN_VALUE));
        bg.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
    }
    public void createWindow()
    {
        add(createLabel("File Encryption",Color.white,
                new Font("Segoe Print", Font.PLAIN,  40), 100, 200),
        BorderLayout.NORTH);
        add(createBottom(), BorderLayout.SOUTH);
    }
    private void initButton(JButton cmd)
    {   
        cmd.setPreferredSize(new Dimension(260, 50));
        cmd.setFont(new Font("Segoe Print", Font.PLAIN, 18));
        cmd.setBorderPainted(false);
        cmd.setForeground(new Color(255, 255, 255));
        cmd.setContentAreaFilled(true);
        cmd.setBackground(new Color(0, 0, 0, 50));
    }
    public JPanel createBottom()
    {
        JPanel panel = new JPanel(new FlowLayout(1, 10, 10));
        panel.setPreferredSize(new Dimension(410, 260));
        initButton(cmdEpt);
        initButton(cmdDcp);
        initButton(cmdCmp);
        initButton(cmdExt);
        panel.add(cmdEpt);
        panel.add(cmdDcp);
        panel.add(cmdCmp);
        panel.add(cmdExt);
        panel.setBackground(new Color(0, 0, 0, 0));
        return panel;
    }
    public JLabel createLabel(String txt, Color fg, Font font, 
            int width, int height)
    {
        JLabel label = new JLabel(txt);
        label.setOpaque(true);
        label.setForeground(fg);
        label.setBackground(new Color(255, 255, 255, 0));
        label.setFont(font);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setPreferredSize(new Dimension(width, height));
        return label;
    }
    private void addListeners()
    {
        cmdEpt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new InputCode();
            }
        });
         cmdDcp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new DcpCode();
            }
        });
         cmdCmp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new Compare();
            }
        });
         cmdExt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
    }
}
