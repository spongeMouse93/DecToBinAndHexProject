import javax.swing.*;
import java.awt.event.*;

public class DecToBinAndHex extends JFrame {
    public DecToBinAndHex() {
        JFrame f = new JFrame("Decimal to Binary and Hexadecimal Converter");
        f.setVisible(true);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(423, 271);
        f.setResizable(false);
        JTextField tf = new JTextField();
        tf.setBounds(196, 30, 125, 27);
        JLabel l1 = new JLabel("Enter positive integer"), l2 = new JLabel("Binary: "), l3 = new JLabel(),
                l4 = new JLabel("Hexadecimal: "), l5 = new JLabel();
        l1.setBounds(12, 33, 153, 20);
        l2.setBounds(196, 88, 57, 20);
        l4.setBounds(150, 160, 103, 20);
        l3.setBounds(300, 88, 100, 20);
        l5.setBounds(300, 160, 100, 20);
        JButton b = new JButton("Convert");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int num = Integer.parseInt(tf.getText());
                    if (num <= 0)
                        JOptionPane.showMessageDialog(f, "Enter only positive integer");
                    else {
                        l3.setText(decToBin(num));
                        l5.setText(decToHex(num));
                    }
                } catch (NumberFormatException ev) {
                    JOptionPane.showMessageDialog(f, "Enter only positive integer");
                }
            }
        });
        b.setBounds(12, 168, 94, 29);
        f.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        f.add(l5);
        f.add(tf);
        f.add(b);
    }

    private static String decToBin(int num) {
        int[] binaryNum = new int[1000];
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            binaryNum[i] = num % 2;
            num /= 2;
            i++;
        }
        for (int j = i - 1; j >= 0; j--)
            sb.append(binaryNum[j]);
        return sb.toString();
    }

    private static String decToHex(int num) {
        StringBuilder sb = new StringBuilder();
        int[] hexNum = new int[100];
        int i = 0;
        while (num != 0) {
            hexNum[i] = num % 16;
            num /= 16;
            i++;
        }
        for (int j = i - 1; j >= 0; j--)
            if (hexNum[j] > 9)
                sb.append((char) (55 + hexNum[j]));
            else
                sb.append(hexNum[j]);
        return sb.toString();
    }

    public static void main(String[] args) {
        new DecToBinAndHex();
    }
}