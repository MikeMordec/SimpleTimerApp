import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;  // Import JButton
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TestTimer {
    private int count = 0;
    private Timer timer;
    private JLabel label1, label2;
    private JTextField text1, text2;
    private JButton startButton;  // Declare JButton

    private void initUI() {
        JFrame frame = new JFrame("Flip Flop Java GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1 = new JLabel();
        label2 = new JLabel();
        text1 = new JTextField(10);
        text2 = new JTextField(10);
        text1.setEnabled(false);
        text2.setEnabled(false);

        frame.setLayout(new GridLayout(5, 2));  // Increase the number of rows to accommodate the button

        // Add labels and text fields
        frame.add(label1);
        frame.add(text1);
        frame.add(label2);
        frame.add(text2);

        // Create and add the start button
        startButton = new JButton("Start");
        frame.add(startButton);

        frame.pack();
        frame.setSize(300, 400);  // Increased the height to accommodate the button
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        timer = new Timer(1250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count++;
                if (count % 2 == 0) {
                    label1.setForeground(Color.BLUE);
                    label2.setForeground(Color.RED);
                    text1.setBackground(Color.RED);
                    text2.setBackground(Color.BLUE);
                    label1.setText("Flop");
                } else {
                    label1.setForeground(Color.RED);
                    label2.setForeground(Color.BLUE);
                    text1.setBackground(Color.BLUE);
                    text2.setBackground(Color.RED);
                    label1.setText("Flip");
                }
                if (count == 10) {
                    timer.stop();
                }
            }
        });

        // Add ActionListener to the start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count = 0;  // Reset count when the button is clicked
                timer.start();  // Start the timer when the button is clicked
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TestTimer().initUI();
            }
        });
    }
}