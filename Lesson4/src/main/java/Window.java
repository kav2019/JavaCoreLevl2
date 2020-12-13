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
        StringBuilder text = new StringBuilder();

        button.addActionListener(e -> {
            send(textField, textSend, text);
        });
        textField.addActionListener(e -> {
            send(textField,textSend, text);
        });

        add(textSend);
        add(textField);
        add(button);
        setVisible(true);
    }


    private void send(JTextField textField, JTextArea textSend, StringBuilder text){
        try{
            String[] strings = textField.getText().split("Введите сообщение:    ");
            text.append(strings[1]);
            text.append("\n");
            textSend.setText(text.toString());
            textField.setText("Введите сообщение:    ");
        }catch (Exception e1){
            textSend.setText("Вы не ввели сообщение!!!");
        }
    }
}
