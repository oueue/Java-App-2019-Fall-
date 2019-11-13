package calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.border.*;
public class MainWindow extends JFrame{
    private JButton cmdClr = new JButton("Clear");
    private JButton cmdBsp = new JButton("BackSpace");
    private JButton cmdAdd = new JButton("+");
    private JButton cmdSub = new JButton("-");
    private JButton cmdMul = new JButton("×");
    private JButton cmdDiv = new JButton("÷");
    private JButton cmdEql = new JButton("=");
    private JButton NUM[] = new JButton[10];
    private JButton BFB = new JButton("<html>BIG<br>FRIENDLY<br>BUTTON</html>");
    private JTextArea display = new JTextArea(3, 10);
    private OpndStack opnd1 = new OpndStack();
    private OpndStack opnd2 = new OpndStack();
    private String optr = null;
    private int f1 = 1;
    private int f2 = 1;
    public MainWindow()
    {
        setTitle("Calculator");
        setSize(250, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        for (int i = 0; i<10; i++)
            NUM[i] = new JButton(""+ i);
        addListeners();
        createWindow();
        setVisible(true);
        setResizable(false);
    }
    private void createWindow()
    {
        JPanel panel = new JPanel(new BorderLayout(0, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(createTop(), BorderLayout.NORTH); 
        panel.add(createWest(),BorderLayout.WEST);
        panel.add(createEast(), BorderLayout.EAST);
        panel.add(createBottom(), BorderLayout.SOUTH);
        panel.setBackground(new Color(250, 250, 255));
        add(panel);
    }
    private JPanel createWest()
    {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(createNUM());
        panel.setBackground(new Color(250, 250, 255));
        return panel;
    }
    private void initNumButton(JButton num)
    {
        num.setPreferredSize(new Dimension(50, 50));
        num.setFont(new Font("ISOCPEUR", Font.BOLD, 27));
        num.setMargin(new Insets(0, 0, 0, 0));
        num.setBorder(BorderFactory.createLineBorder(new Color(150, 149, 155), 3));
        num.setForeground(new Color(150, 145, 160));
        num.setContentAreaFilled(false);
    }
    private void initCmdButton(JButton cmd)
    {
        cmd.setPreferredSize(new Dimension(30, 30));
        cmd.setFont(new Font("ISOCPEUR", Font.PLAIN, 18));
        cmd.setMargin(new Insets(0, 0, 0, 0));
        cmd.setBorder(BorderFactory.createLineBorder(new Color(150, 149, 155), 3));
        cmd.setForeground(new Color(150, 145, 160));
        cmd.setContentAreaFilled(false);
    }
    private JPanel createTop()
    {
        BFB.setPreferredSize(new Dimension(88, 60));
        JPanel p = new JPanel(new FlowLayout(1, 10, 0));
        BFB.setFont(new Font("Verdana", Font.BOLD, 14));
        BFB.setContentAreaFilled(false);
        BFB.setBorder(BorderFactory.createLineBorder(new Color(150, 149, 155), 3));
        BFB.setForeground(new Color(150, 145, 160));
        p.add(BFB);
        display.setBorder(BorderFactory.createLineBorder(new Color(150, 149, 155), 3));
        display.setForeground(new Color(150, 145, 160));
        display.setPreferredSize(new Dimension(80, 60));
        display.setFont(new Font("ISOCPEUR", Font.PLAIN, 18));
        p.add(display);
        p.setBackground(new Color(250, 250, 255));
        p.setForeground(new Color(150, 145, 160));
        return p;
    }
    private JPanel createEast()
    {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(createRight(), BorderLayout.EAST);
        panel.setBackground(new Color(250, 250, 255));
        return panel;
    }
    private JPanel createBottom()
    {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JPanel p = new JPanel(new GridLayout(2, 1, 10, 10));
        initNumButton(NUM[0]);
        panel.add(NUM[0], BorderLayout.WEST);
        cmdClr.setPreferredSize(new Dimension(40, 20));
        cmdClr.setFont(new Font("ISOCPEUR", Font.PLAIN, 20));
        cmdClr.setBorder(BorderFactory.createLineBorder(new Color(150, 149, 155), 3));
        cmdClr.setForeground(new Color(150, 145, 160));
        cmdClr.setContentAreaFilled(false);
        p.add(cmdClr);
        p.setBackground(new Color(250, 250, 255));
        cmdBsp.setPreferredSize(new Dimension(40, 20));
        cmdBsp.setFont(new Font("ISOCPEUR", Font.PLAIN, 20));
        cmdBsp.setBorder(BorderFactory.createLineBorder(new Color(150, 149, 155), 3));
        cmdBsp.setForeground(new Color(150, 145, 160));
        cmdBsp.setContentAreaFilled(false);
        p.add(cmdBsp, BorderLayout.EAST);
        p.setBackground(new Color(250, 250, 255));
        panel.add(p);
        panel.setBackground(new Color(250, 250, 255));
        return panel;
        
    }
    private JPanel createNUM()
    {
        JPanel panel = new JPanel(new GridLayout(3, 3, 10, 10));
        for (int i = 1; i<10; i++)
        {
            initNumButton(NUM[i]);
            panel.add(NUM[i]);
        }
        panel.setBackground(new Color(250, 250, 255));
        return panel;
    }
    private JPanel createRight()
    {
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        initCmdButton(cmdAdd);
        initCmdButton(cmdSub);
        initCmdButton(cmdMul);
        initCmdButton(cmdDiv);
        initCmdButton(cmdEql);
        panel.add(cmdAdd);
        panel.add(cmdSub);
        panel.add(cmdMul);
        panel.add(cmdDiv);
        panel.add(cmdEql);
        panel.setBackground(new Color(250, 250, 255));
        return panel;
    }
    private void addListeners()
    {
        BFB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                 String str = (String)JOptionPane.showInputDialog("Please enter your name:");
                 if(str.equals("Doctor"))
                 {
                     ImageIcon icon = new ImageIcon("C:\\Users\\Administrator\\Desktop\\dw.jpg");
                     JOptionPane.showMessageDialog(null,"Hello, Doctor","",JOptionPane.ERROR_MESSAGE, icon);
                 }
            }
        });
        cmdAdd.addMouseListener(new MouseListener()
        {
            public void mouseClicked(MouseEvent e)
            {
                String txt = display.getText();
                if(optr==null)
                {
                    display.setText(txt+ "+");
                    optr = "+";
                }
            }
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
        });
        cmdSub.addMouseListener(new MouseListener()
        {
            public void mouseClicked(MouseEvent e)
            {
                String txt = display.getText();
                if(optr == null && opnd1.isEmpty())
                {
                    display.setText(txt+ "-");
                    f1 = 0;
                }
                else if(optr==null)
                {
                    display.setText(txt+ "-");
                    optr = "-";
                }
                else if(optr!=null && opnd2.isEmpty())
                {
                    display.setText(txt+ "-");
                    f2 = 0;
                }
            }
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
        });
        cmdMul.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            { 
                String txt = display.getText();
                if(optr==null)
                {
                    display.setText(txt+ "×");
                    optr = "×";
                }
            }
        });
        cmdDiv.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String txt = display.getText();
                if(optr==null)
                {
                    display.setText(txt+ "÷");
                    optr = "÷";
                }
            }
        });
        cmdEql.addMouseListener(new MouseListener()
        {
            public void mouseClicked(MouseEvent e)
            {
                int a = 0;
                if (opnd1.value !=0) a = opnd1.value;
                else a = opnd1.cal();
                if(f1 == 0) a = -a;
                int b = opnd2.cal();
                if(f2 == 0) b = -b;
                while(!opnd1.isEmpty())
                    opnd1.pop();
                while(!opnd2.isEmpty())
                    opnd2.pop();
                String txt = display.getText();
                float answer = 0;
                switch(optr)
                {
                    case "+":
                        answer = a+b;
                        break;
                    case "-":
                        answer = a-b;
                        break;
                    case "×":
                        answer = a*b;
                        break;
                    case "÷":
                        answer = (float)a/b;
                }
                display.setText(txt+"\n="+ answer);
                opnd1 = new OpndStack(); opnd2 = new OpndStack();
                opnd1.value = (int)answer;
                if(answer >= 0) f1 = 1;
                else f1 = 0;
                f2 = 1;
                optr = null;
            }
            public void mouseEntered(MouseEvent e){}
            public void mouseExited(MouseEvent e){}
            public void mousePressed(MouseEvent e){}
            public void mouseReleased(MouseEvent e){}
        });
        cmdClr.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        optr = null;
                        opnd1 = new OpndStack();
                        opnd2 = new OpndStack();
                        display.setText("");
                        f1 = 1;
                        f2 = 1;
                    }
                });
        cmdBsp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String txt = display.getText();
                String last = txt.substring(txt.length()-1, txt.length());
                if(last.equals("-")&&f2 == 0) f2 = 1;
                else if(last.equals("-") && f1 == 0 && optr == null) f1 = 1;
                else if(last.equals("+")||last.equals("-")||last.equals("×")||last.equals("÷")) optr = null;
                else if(optr!=null) opnd2.pop();
                else opnd1.pop();
                txt = txt.substring(0,txt.length()-1);
                display.setText(txt);
            }
        });
        NUM[0].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String txt = display.getText();
                display.setText(txt + '0');
                if (optr == null) opnd1.push(0);
                else opnd2.push(0);
            }
        });
        NUM[1].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String txt = display.getText();
                display.setText( txt + "1");
                if (optr == null) opnd1.push(1);
                else opnd2.push(1);
            }
        });
        NUM[2].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String txt = display.getText();
                display.setText( txt + "2");
                if (optr == null) opnd1.push(2);
                else opnd2.push(2);
            }
        });
        NUM[3].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String txt = display.getText();
                display.setText( txt + "3");
                if (optr == null) opnd1.push(3);
                else opnd2.push(3);
            }
        });
        NUM[4].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String txt = display.getText();
                display.setText( txt + "4");
                if (optr == null) opnd1.push(4);
                else opnd2.push(4);
            }
        });
        NUM[5].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String txt = display.getText();
                display.setText( txt + "5");
                if (optr == null) opnd1.push(5);
                else opnd2.push(5);
            }
        });
        NUM[6].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String txt = display.getText();
                display.setText( txt + "6");
                if (optr == null) opnd1.push(6);
                else opnd2.push(6);
            }
        });
        NUM[7].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String txt = display.getText();
                display.setText(txt + "7");
                if (optr == null) opnd1.push(7);
                else opnd2.push(7);
            }
        });
        NUM[8].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String txt = display.getText();
                display.setText( txt + "8");
                if (optr == null) opnd1.push(8);
                else opnd2.push(8);
            }
        });
        NUM[9].addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String txt = display.getText();
                display.setText( txt + "9");
                if (optr == null) opnd1.push(9);
                else opnd2.push(9);
            }
        });
    }
}

