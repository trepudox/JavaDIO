package zzz.testes;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class JavaSwing {
    public static void main(String[] args) {
        new Tela();
    }
}

class Tela {
    
    JFrame janela = new JFrame();

    public Tela() {
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setTitle("oieh");
        janela.setAlwaysOnTop(true);
        
    
        JLabel label = new JLabel("oi");
        // oie.setOpaque(true);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.green);

        JButton button = new JButton("botaow");
        button.setEnabled(true);

        JTextField textField = new JTextField("aaa", 5);
        textField.setEditable(true);

        janela.getContentPane().add(label);
        janela.getContentPane().add(button);
        janela.getContentPane().add(textField);
        janela.getContentPane().setBackground(Color.black);

        System.out.println(
            janela.getContentPane().getFont()

        ); 
    
        janela.pack();
        janela.setSize(300, 300);
        janela.setLayout(null);
        janela.setVisible(true);
    }
    
}
