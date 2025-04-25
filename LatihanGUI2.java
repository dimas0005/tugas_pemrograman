/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihan_console;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LatihanGUI2 {
    private JFrame frame;
    private JTextField tfNim, tfNama, tfUts, tfUas;
    private JTextArea resultArea;
    private JButton btnCalculate;

    public LatihanGUI2() {
        frame = new JFrame("GUI Perhitungan Nilai");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Label dan TextField
        JLabel lblNim = new JLabel("NIM:");
        lblNim.setBounds(20, 20, 80, 25);
        frame.add(lblNim);

        tfNim = new JTextField();
        tfNim.setBounds(120, 20, 200, 25);
        frame.add(tfNim);

        JLabel lblNama = new JLabel("Nama:");
        lblNama.setBounds(20, 50, 80, 25);
        frame.add(lblNama);

        tfNama = new JTextField();
        tfNama.setBounds(120, 50, 200, 25);
        frame.add(tfNama);

        JLabel lblUts = new JLabel("UTS:");
        lblUts.setBounds(20, 80, 80, 25);
        frame.add(lblUts);

        tfUts = new JTextField();
        tfUts.setBounds(120, 80, 200, 25);
        frame.add(tfUts);

        JLabel lblUas = new JLabel("UAS:");
        lblUas.setBounds(20, 110, 80, 25);
        frame.add(lblUas);

        tfUas = new JTextField();
        tfUas.setBounds(120, 110, 200, 25);
        frame.add(tfUas);

        // Tombol
        btnCalculate = new JButton("Hitung");
        btnCalculate.setBounds(120, 140, 100, 30);
        frame.add(btnCalculate);

        // Area hasil
        resultArea = new JTextArea();
        resultArea.setBounds(20, 180, 540, 80);
        frame.add(resultArea);

        // ActionListener untuk tombol
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nim = tfNim.getText();
                    String nama = tfNama.getText();
                    double uts = Double.parseDouble(tfUts.getText());
                    double uas = Double.parseDouble(tfUas.getText());
                    double rata = (uts + uas) / 2;

                    String grade;
                    if (rata < 50) grade = "E";
                    else if (rata < 60) grade = "D";
                    else if (rata < 70) grade = "C";
                    else if (rata < 80) grade = "B";
                    else grade = "A";

                    // Menampilkan hasil
                    resultArea.setText("========================================================\n" +
                                       "NIM\tNama\tUTS\tUAS\tRata2\tGrade\n" +
                                       "========================================================\n" +
                                       nim + "\t" + nama + "\t" + uts + "\t" + uas + "\t" + rata + "\t" + grade + "\n");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Harap masukkan angka yang valid untuk UTS dan UAS.",
                                                  "Kesalahan Input", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LatihanGUI2();
    }
}