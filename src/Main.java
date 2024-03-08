
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.BorderFactory; import javax.swing.BoxLayout; import javax.swing.JButton; import javax.swing.JFrame;
import javax.swing.JLabel; import javax.swing.JPanel; import javax.swing.JTextField;

/**
 * This class is the main for building the program.
 * This class has the method for building the GUI.
 * @author Tam Ngo Hin
 * @version 1.0
 * @since 2023-04-07
 */
public class Main  {
    public boolean ended = false;
    private Label label_money;
    private int current_bet;
    private int total =100;
    private Label txt_inputbet;
    JLabel label_Image1 ;    JLabel label_Image2 ;    JLabel label_Image3 ;    JLabel label_Image4;    JLabel label_Image5 ;    JLabel label_Image6 ;
    ImageIcon Image1;   ImageIcon Image2;    ImageIcon Image3;    ImageIcon Image4;    ImageIcon Image5;    ImageIcon Image6;
    boolean start = false;

    /**
     * This is the main method which makes use of go method.
     * @param args Unused.
     * @exception IOException On input error.
     * @see IOException
     */
    public static void main(String[] args) throws IOException {
        Main t = new Main();
        t.go();
    }

    /**
     * This is the method which build the GUI it which makes use of get_replacedtime, replace, draw and makedeck method.
     */
    public void go(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Control");
        JMenuItem menuItem = new JMenuItem("Exit");
        menu.add(menuItem);
        menuBar.add(menu);
        menuItem.addActionListener(new Listener());


        JPanel panel_bet = new JPanel();


        JFrame frame = new JFrame("A Simple Card Game");

        label_Image1 = new JLabel();
        label_Image2 = new JLabel();
        label_Image3 = new JLabel();
        label_Image4 = new JLabel();
        label_Image5 = new JLabel();
        label_Image6 = new JLabel();

        JButton btn_rpcard1 = new JButton("Replace Card 1");
        JButton btn_rpcard2 = new JButton("Replace Card 2");
        JButton btn_rpcard3 = new JButton("Replace Card 3");
        JButton btn_start = new JButton("Start");
        JButton btn_result = new JButton("Result");


        JLabel label_bet = new JLabel("Bet$ ");
        JLabel label_info = new JLabel("Please place your bet!"+" Amount of money you have: $" + total);
        JLabel label_money = new JLabel();

        JTextField txt_inputbet = new JTextField(10);
        panel_bet.add(label_bet);
        panel_bet.add(txt_inputbet);

        Image1 = new ImageIcon("Images/card_back.gif");
        Image2 = new ImageIcon("Images/card_back.gif");
        Image3 = new ImageIcon("Images/card_back.gif");
        Image4 = new ImageIcon("Images/card_back.gif");
        Image5 = new ImageIcon("Images/card_back.gif");
        Image6 = new ImageIcon("Images/card_back.gif");
        label_Image1.setIcon(Image1);
        label_Image2.setIcon(Image2);
        label_Image3.setIcon(Image3);
        label_Image4.setIcon(Image4);
        label_Image5.setIcon(Image5);
        label_Image6.setIcon(Image6);


        JPanel MainPanel = new JPanel();
        JPanel DealerPanel = new JPanel();
        JPanel PlayerPanel = new JPanel();
        JPanel RpCardBtnPanel = new JPanel();
        JPanel ButtonPanel = new JPanel();
        JPanel InfoPanel = new JPanel();

        DealerPanel.add(label_Image1);
        DealerPanel.add(label_Image2);
        DealerPanel.add(label_Image3);
        PlayerPanel.add(label_Image4);
        PlayerPanel.add(label_Image5);
        PlayerPanel.add(label_Image6);

        RpCardBtnPanel.add(btn_rpcard1);
        RpCardBtnPanel.add(btn_rpcard2);
        RpCardBtnPanel.add(btn_rpcard3);
        ButtonPanel.add(panel_bet);
        ButtonPanel.add(btn_start);
        ButtonPanel.add(btn_result);


//        label_info = new JLabel("You have no more money! Please start a new game!");

        InfoPanel.add(label_info);
        DealerPanel.setBackground(Color.green);
        PlayerPanel.setBackground(Color.green);
        RpCardBtnPanel.setBackground(Color.green);

        MainPanel.setLayout(new GridLayout(5,1));
        MainPanel.add(DealerPanel);
        MainPanel.add(PlayerPanel);
        MainPanel.add(RpCardBtnPanel);
        MainPanel.add(ButtonPanel);
        MainPanel.add(InfoPanel);

        frame.setJMenuBar(menuBar);

        btn_rpcard1.setEnabled(false);
        btn_rpcard2.setEnabled(false);
        btn_rpcard3.setEnabled(false);
        btn_result.setEnabled(false);

// Repeat this for other sub-panels
// Optional background color setting DealerPanel.setBackground(Color.green); PlayerPanel.setBackground(Color.green); RpCardBtnPanel.setBackground(Color.green);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(MainPanel);
        frame.setTitle("A Simple Card Game");
        frame.setSize(400, 700);
        frame.setVisible(true);



        Card c= new Card();
        Player p= new Player();
        Check check = new Check();
        if( !start ) {
            btn_start.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    btn_start.setEnabled(false);
                    btn_result.setEnabled(true);
                    start = true;
                    current_bet = Integer.parseInt(txt_inputbet.getText());
                    label_info.setText("Your current bet is: $" + current_bet + " Amount of money you have: $" + total);
                    c.MakeDeck();
                    for (int i=0;i<3;i++){
                        p.setDealerdeck(c.draw());
                    }
                    for (int i=0;i<3;i++){
                        p.setPlayerdeck(c.draw());
                    }

                    Image4 = new ImageIcon("Images/card_"+p.getPlayerdeck(0)+".gif");
                    Image5 = new ImageIcon("Images/card_"+p.getPlayerdeck(1)+".gif");
                    Image6 = new ImageIcon("Images/card_"+p.getPlayerdeck(2)+".gif");
                    label_Image4.setIcon(Image4);
                    label_Image5.setIcon(Image5);
                    label_Image6.setIcon(Image6);
                    btn_rpcard1.setEnabled(true);
                    btn_rpcard2.setEnabled(true);
                    btn_rpcard3.setEnabled(true);
                    check.reset_replacedtime();

                }
            });
        }
        btn_rpcard1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (check.get_replacedtime() <2){
                    check.replaced();
                    p.replace(0,c.draw());
                    Image4 = new ImageIcon("Images/card_"+p.getPlayerdeck(0)+".gif");
                    label_Image4.setIcon(Image4);}
            }

        });
        btn_rpcard2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (check.get_replacedtime() <2){
                    p.replace(1,c.draw());
                    Image5 = new ImageIcon("Images/card_"+p.getPlayerdeck(1)+".gif");
                    label_Image5.setIcon(Image5);
                    check.replaced();}

            }
        });
        btn_rpcard3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (check.get_replacedtime() <2){
                    p.replace(2,c.draw());
                    Image6 = new ImageIcon("Images/card_"+p.getPlayerdeck(2)+".gif");
                    label_Image6.setIcon(Image6);
                    check.replaced();}

            }
        });
        btn_result.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btn_rpcard1.setEnabled(false);
                btn_rpcard2.setEnabled(false);
                btn_rpcard3.setEnabled(false);
                if (start){
                
                    Image1 = new ImageIcon("Images/card_"+p.getDealerdeck(0)+".gif");
                    Image2 = new ImageIcon("Images/card_"+p.getDealerdeck(1)+".gif");
                    Image3 = new ImageIcon("Images/card_"+p.getDealerdeck(2)+".gif");
                    label_Image1.setIcon(Image1);
                    label_Image2.setIcon(Image2);
                    label_Image3.setIcon(Image3);


                    if(total >0){
                        if (p.result() && total >0){
                            total += current_bet;
                            JOptionPane.showMessageDialog(null,"Congratulations! You win this round!");
                            Image1 = new ImageIcon("Images/card_back.gif");
                            Image2 = new ImageIcon("Images/card_back.gif");
                            Image3 = new ImageIcon("Images/card_back.gif");
                            Image4 = new ImageIcon("Images/card_back.gif");
                            Image5 = new ImageIcon("Images/card_back.gif");
                            Image6 = new ImageIcon("Images/card_back.gif");
                            label_Image1.setIcon(Image1);
                            label_Image2.setIcon(Image2);
                            label_Image3.setIcon(Image3);
                            label_Image4.setIcon(Image4);
                            label_Image5.setIcon(Image5);
                            label_Image6.setIcon(Image6);
                            label_info.setText("Your current bet is: $" + current_bet + " Amount of money you have: $" + total);

                        }
                        else{
                            total -= current_bet;
                            if (total >0) {
                                JOptionPane.showMessageDialog(null,"Sorry! The Dealer wins this round!");
                                Image1 = new ImageIcon("Images/card_back.gif");
                                Image2 = new ImageIcon("Images/card_back.gif");
                                Image3 = new ImageIcon("Images/card_back.gif");
                                Image4 = new ImageIcon("Images/card_back.gif");
                                Image5 = new ImageIcon("Images/card_back.gif");
                                Image6 = new ImageIcon("Images/card_back.gif");
                                label_Image1.setIcon(Image1);
                                label_Image2.setIcon(Image2);
                                label_Image3.setIcon(Image3);
                                label_Image4.setIcon(Image4);
                                label_Image5.setIcon(Image5);
                                label_Image6.setIcon(Image6);
                                label_info.setText("Your current bet is: $" + current_bet + " Amount of money you have: $" + total);

                            }
                            else{
                                ended = true;
                                label_info.setText("You have no more money! Please start a new game!");
                                JOptionPane.showMessageDialog(null,"Game over!\n" +"You have no more money!\n" +
                                        "Please start a new game!");
                                btn_start.setEnabled(false);
                                btn_result.setEnabled(false);

                            }
                        }

                        if(ended == false){btn_start.setEnabled(true);}
                        btn_result.setEnabled(false);
                    }
                }}
        });

    }

}



