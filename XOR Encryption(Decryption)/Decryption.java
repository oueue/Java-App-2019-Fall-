package fileencryption;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class Decryption extends JDialog
{
    FileDialog op, sa; JTextField tf1 = new JTextField(); JTextField tf2 = new JTextField();
    protected JButton cmdOpn1 = new JButton("Open");
    protected JButton cmdOpn2 = new JButton("Open");
    private JButton cmdEpt = new JButton("Decrypt file");
    protected JLabel lb = new JLabel("Choose a file (press open to load)");
    protected JButton cmdCan = new JButton("Cancel");
    public int code = InputCode.code;
    public Decryption()
    {
        setTitle("Loading File...");
        op = new FileDialog(this, "open",FileDialog.LOAD);
        setSize(new Dimension(300, 190));
        lb.setFont(new Font("Segoe Print", Font.PLAIN, 16));
        lb.setForeground(new Color(140, 147, 155));
        tf1.setPreferredSize(new Dimension(180, 25));
        tf1.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        tf1.setBackground(new Color(255, 255, 255));
        tf1.setForeground(new Color(140, 147, 155));
        tf2.setPreferredSize(new Dimension(180, 25));
        tf2.setFont(new Font("Segoe Print", Font.PLAIN, 15));
        tf2.setBackground(new Color(255, 255, 255));
        tf2.setForeground(new Color(140, 147, 155));
        setLocation(260, 400);
        JPanel p = new JPanel(new FlowLayout(2, 10, 10));
        addListeners();
        cmdEpt.setEnabled(false);
        p.add(lb); p.add(tf1);p.add(cmdOpn1); p.add(tf2);p.add(cmdOpn2); p.add(cmdEpt); p.add(cmdCan);
        p.setBackground(new Color(255, 255, 255));
        add(p);
        setVisible(true); 
    }
    private void addListeners()
    {
        cmdOpn1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                op.setVisible(true);
                if(op.getFile()!=null)
                {
                    cmdEpt.setEnabled(true);
                    String dir = op.getDirectory();
                    String file = op.getFile();
                    tf1.setText(dir+file);
                    tf2.setText(dir);
                }
            }
        });
        cmdOpn2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                op.setVisible(true);
                if(op.getFile()!=null)
                {
                    cmdEpt.setEnabled(true);
                    String dir = op.getDirectory();
                    String file = op.getFile();
                    tf2.setText(dir+file);
                }
            }
        });
         cmdCan.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
        cmdEpt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                File fin = new File(tf1.getText());
               if (!fin.exists())
               {
                   tf1.setText("File not found!");
               }
               File fout = new File(tf2.getText());
               try{
                   FileInputStream fis = new FileInputStream(fin);
                   FileOutputStream fos = new FileOutputStream(fout);
                   BufferedInputStream in = new BufferedInputStream(fis);
                   BufferedOutputStream out = new BufferedOutputStream(fos);
                   while(true){
                       int ch = in.read();
                       if(ch == -1) break;
                       int encoded = code^ch;
                       out.write(encoded);
                   }
                   in.close();out.close();
               }catch(Exception ex){}
            }
        });
    }
}
