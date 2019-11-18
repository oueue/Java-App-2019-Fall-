package fileencryption;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class Compare extends JDialog
{
    FileDialog op, sa; JTextField tf1 = new JTextField(); JTextField tf2 = new JTextField();
    protected JButton cmdOpn1 = new JButton("Open");
    protected JButton cmdOpn2 = new JButton("Open");
    private JButton cmdCmp = new JButton("Compare files");
    protected JLabel lb = new JLabel("Choose a file (press open to load)");
    protected JButton cmdCan = new JButton("Cancel");
    public int code = InputCode.code;
    public Compare()
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
        cmdCmp.setEnabled(false);
        p.add(lb); p.add(tf1);p.add(cmdOpn1); p.add(tf2);p.add(cmdOpn2); p.add(cmdCmp); p.add(cmdCan);
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
                    cmdCmp.setEnabled(true);
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
                    cmdCmp.setEnabled(true);
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
        cmdCmp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                File f1 = new File(tf1.getText());
               if (!f1.exists())
               {
                   tf1.setText("File not found!");
               }
               File f2 = new File(tf2.getText());
               if (!f2.exists())
               {
                   tf2.setText("File not found!");
               }
               try{
                   FileInputStream fis1 = new FileInputStream(f1);
                   FileInputStream fis2 = new FileInputStream(f2);
                   BufferedInputStream in1 = new BufferedInputStream(fis1);
                   BufferedInputStream in2 = new BufferedInputStream(fis2);
                   int ch1, ch2;
                   while(true){
                       ch1 = in1.read();
                       ch2 = in2.read();
                       if(ch1 == -1 || ch2 == -1) break;
                       if (ch1!=ch2) break;
                   }
                   if (ch1==-1 && ch2==-1) 
                   {
                        JOptionPane.showMessageDialog(null, "Same files!","",
                        JOptionPane.INFORMATION_MESSAGE);
                   }
                   else
                   {
                            JOptionPane.showMessageDialog(null, "Different files!","",
                            JOptionPane.ERROR_MESSAGE);
                   }
                   System.out.println(ch1);
                    System.out.println(ch2);
                   in1.close();in2.close();
               }catch(Exception ex){}
            }
        });
    }
}

