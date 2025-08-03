package com.mycompany.trabalhofisica_2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tela extends JFrame {
    private JTextArea txtEnunciado;
    private JLabel lbl1, lbl2, lbl3, lblEixoX, lblEixoY, lblParticula1, lblParticula2, lblParticula3, lblParticula4;
    private JPanel painel1;
    private JTextField txtField1, txtField2, txtField3, txtField4, txtField5, txtField6;
    private JButton btnLimparCampos, btnCalcular;

    public Tela() {
        super("Exercício de Física Cap.22 - Problema 9");
        String enunciado = """
        A Fig. 22-32 mostra duas partículas carregadas mantidas fixas no eixo x:
        -q = -3,20 × 10⁻¹⁹ C no ponto x = -3,00 m
         q = +3,20 × 10⁻¹⁹ C no ponto x = +3,00 m

        Determine:
        (a) o módulo
        (b) a orientação (em relação ao semieixo x positivo) do campo elétrico no ponto P,
        para o qual y = 4,00 m.
        """;

        txtEnunciado = new JTextArea(enunciado);
        txtEnunciado.setEditable(false);
        txtEnunciado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        txtEnunciado.setLineWrap(true);
        txtEnunciado.setWrapStyleWord(true);
        txtEnunciado.setBackground(new Color(235, 235, 235));
        txtEnunciado.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setLayout(new BorderLayout());
        JScrollPane scrollEnunciado = new JScrollPane(txtEnunciado);
        scrollEnunciado.setPreferredSize(new Dimension(580, 130));
        add(scrollEnunciado, BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        painel1 = new JPanel(new GridBagLayout());
        painel1.setBackground(Color.lightGray);

        Font fonte = new Font("Monospaced", Font.BOLD, 15);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 60, 10, 30);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        lbl1 = new JLabel("Informe a posição das partículas sobre o eixo X:");
        lbl1.setFont(fonte);
        gbc.gridy = 0;
        painel1.add(lbl1, gbc);

        lblParticula1 = new JLabel("Partícula 1 (x1):");
        lblParticula1.setFont(fonte);
        gbc.gridy = 1;
        painel1.add(lblParticula1, gbc);

        txtField1 = new JTextField(12);
        gbc.gridy = 2;
        painel1.add(txtField1, gbc);

        lblParticula2 = new JLabel("Partícula 2 (x2):");
        lblParticula2.setFont(fonte);
        gbc.gridy = 3;
        painel1.add(lblParticula2, gbc);

        txtField2 = new JTextField(12);
        gbc.gridy = 4;
        painel1.add(txtField2, gbc);

        lbl2 = new JLabel("Informe as cargas das partículas (em Coulombs):");
        lbl2.setFont(fonte);
        gbc.gridy = 5;
        painel1.add(lbl2, gbc);

        lblParticula3 = new JLabel("Carga 1:");
        lblParticula3.setFont(fonte);
        gbc.gridy = 6;
        painel1.add(lblParticula3, gbc);

        txtField3 = new JTextField(12);
        gbc.gridy = 7;
        painel1.add(txtField3, gbc);

        lblParticula4 = new JLabel("Carga 2:");
        lblParticula4.setFont(fonte);
        gbc.gridy = 8;
        painel1.add(lblParticula4, gbc);

        txtField4 = new JTextField(12);
        gbc.gridy = 9;
        painel1.add(txtField4, gbc);

        lbl3 = new JLabel("Informe a coordenada do ponto P:");
        lbl3.setFont(fonte);
        gbc.gridy = 10;
        painel1.add(lbl3, gbc);

        lblEixoX = new JLabel("Eixo X:");
        lblEixoX.setFont(fonte);
        gbc.gridy = 11;
        painel1.add(lblEixoX, gbc);

        txtField5 = new JTextField(12);
        gbc.gridy = 12;
        painel1.add(txtField5, gbc);

        lblEixoY = new JLabel("Eixo Y:");
        lblEixoY.setFont(fonte);
        gbc.gridy = 13;
        painel1.add(lblEixoY, gbc);

        txtField6 = new JTextField(12);
        gbc.gridy = 14;
        painel1.add(txtField6, gbc);

        btnCalcular = new JButton("Calcular");
        gbc.gridy = 15;
        gbc.insets = new Insets(20, 60, 10, 10);
        painel1.add(btnCalcular, gbc);

        btnLimparCampos = new JButton("Apagar");
        gbc.gridx = 1;
        gbc.insets = new Insets(20, 10, 10, 60);
        painel1.add(btnLimparCampos, gbc);

        btnCalcular.addActionListener((ActionEvent e) -> {
            try {
                double x1 = Double.parseDouble(txtField1.getText());
                double x2 = Double.parseDouble(txtField2.getText());
                double q1 = Double.parseDouble(txtField3.getText());
                double q2 = Double.parseDouble(txtField4.getText());
                double xp = Double.parseDouble(txtField5.getText());
                double yp = Double.parseDouble(txtField6.getText());

                Ponto p1 = new Ponto(x1, 0);
                Ponto p2 = new Ponto(x2, 0);
                Ponto pontoP = new Ponto(xp, yp);

                Vetor E1 = campoEletrico(q1, p1, pontoP);
                Vetor E2 = campoEletrico(q2, p2, pontoP);
                Vetor Eres = E1.somar(E2);

                double modulo = Eres.modulo();
                double angulo = Eres.anguloEmGraus();

                JOptionPane.showMessageDialog(this,
                    String.format("Módulo do campo elétrico: %.2e N/C\nÂngulo: %.2f°", modulo, angulo),
                    "Resultado", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                invalidInputs();
            }
        });

        btnLimparCampos.addActionListener((ActionEvent e) -> limparCampos());

        add(painel1);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Vetor campoEletrico(double carga, Ponto origem, Ponto destino) {
        final double K = 8.99e9; // Constante eletrostática
        double dx = destino.x - origem.x;
        double dy = destino.y - origem.y;
        double r2 = dx * dx + dy * dy;
        double r = Math.sqrt(r2);
        double modulo = K * Math.abs(carga) / r2;

        double ex = modulo * (dx / r);
        double ey = modulo * (dy / r);
        if (carga < 0) {
            ex = -ex;
            ey = -ey;
        }

        return new Vetor(ex, ey);
    }

    private void invalidInputs() {
        JOptionPane.showMessageDialog(this,
            "Você deve informar valores válidos!",
            "Aviso",
            JOptionPane.WARNING_MESSAGE);
    }

    private void limparCampos() {
        txtField1.setText("");
        txtField2.setText("");
        txtField3.setText("");
        txtField4.setText("");
        txtField5.setText("");
        txtField6.setText("");
    }
}
