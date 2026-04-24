package Kamus;

import javax.swing.*;
import java.awt.*;

public class Notepad extends JFrame {
    public Notepad(){
        super("Notepad");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Area Text
        JTextArea textarea = new JTextArea() ;
        textarea.setFont(new Font("arial", Font.PLAIN, 14));
        JScrollPane scrollpane = new JScrollPane(textarea) ;

        add(scrollpane, BorderLayout.CENTER);

        JButton btnClear = new JButton("Bersihkan catatan");
        btnClear.addActionListener( e -> textarea.setText(""));
        add(btnClear, BorderLayout.SOUTH);
    }
}
