package lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WinMain extends JFrame implements KeyListener {
    private JTextArea outtext = new JTextArea("ПЕРЕПИСКА: \n");
    private JButton sentbutton = new JButton("Отпправить сообщение");
    private JTextField message = new JTextField("Введите Ваше сообщение...");
    private JPanel chatmanager = new JPanel(new GridLayout(1, 4));
    private JScrollPane textscroll = new JScrollPane(outtext);

    WinMain() {
        super("Chat Brains");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLookAndFeel();
        outtext.setLineWrap(true);
        outtext.setWrapStyleWord(true);
        outtext.setEditable(false);
        outtext.setBackground(Color.CYAN);
        outtext.setFont(new Font("Dialog", Font.BOLD, 18));
        sentbutton.setBackground(Color.green);
        setLayout(new BorderLayout());
        add(textscroll, BorderLayout.CENTER);
        chatmanager.add(message);
        chatmanager.add(sentbutton);
        add(chatmanager, BorderLayout.SOUTH);
        setVisible(true);
        message.addKeyListener(this);
        outtext.addKeyListener(this);

        sentbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outtext.append(message.getText() + "\n");
            }
        });
    }


    public void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ex) {

        }
    }


    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.outtext.append(this.message.getText() + "\n");
            this.message.setText("");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
