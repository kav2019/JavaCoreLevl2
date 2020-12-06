import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Window extends JFrame {
    public Window(){
        setBounds(300, 300, 500, 400);
        setTitle("Simple Masseger");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
//        setLayout(new GridLayout(2,2));
        JTextField textField = new JTextField("Введите сообщение:    ");
        JButton button = new JButton("Отправить");
        JTextArea textSend = new JTextArea("Полученное сообщение:    ");

        button.addActionListener(e -> {
            send(textField, textSend);
        });
        textField.addActionListener(e -> {
            send(textField,textSend);
        });

        add(textSend);
        add(textField);
        add(button);
        setVisible(true);
    }


    private void send(JTextField textField, JTextArea textSend){
        try{
            String[] strings = textField.getText().split("Введите сообщение:    ");
            textSend.setText(strings[1]);
        }catch (Exception e1){
            textSend.setText("Вы не ввели сообщение!!!");
        }
    }
}
