package menu;

import javax.swing.*;
import java.awt.*;

public class Sobre extends JFrame {
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JLabel j_Label_Curso;
    private JLabel j_Label_Faculdade;
    private JLabel j_Label_NetBeans;
    private JLabel j_Label_Nome;
    private JLabel j_Label_Periodo;
    private JLabel j_Label_SistemaOperacional;
    private JLabel j_Label_VersaoData;
    private JLabel j_Label_VersaoTexto;
    private JPanel j_Panel_Programador;
    private JPanel j_Panel_Sistema;

    public Sobre() {
        initComponents();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sobre().setVisible(true);
            }
        });
    }

    private void initComponents() {
        this.j_Panel_Programador = new JPanel();
        this.j_Label_Faculdade = new JLabel();
        this.j_Label_Curso = new JLabel();
        this.j_Label_Periodo = new JLabel();
        this.j_Label_Nome = new JLabel();
        this.jLabel1 = new JLabel();
        this.j_Panel_Sistema = new JPanel();
        this.j_Label_SistemaOperacional = new JLabel();
        this.j_Label_NetBeans = new JLabel();
        this.j_Label_VersaoTexto = new JLabel();
        this.j_Label_VersaoData = new JLabel();
        this.jLabel3 = new JLabel();
        setTitle("Sobre");
        setBackground(new Color(255, 255, 255));
        setBounds(new Rectangle(0, 0, 0, 0));
        setName("Sobre");
        setResizable(false);
        this.j_Panel_Programador.setBorder(BorderFactory.createTitledBorder(null, "Programadores", 0, 0, new Font("Times New Roman", 1, 14)));
        this.j_Panel_Programador.setFont(new Font("Times New Roman", 0, 14));
        this.j_Label_Faculdade.setFont(new Font("Times New Roman", 0, 18));
        this.j_Label_Faculdade.setText("FACTO");
        this.j_Label_Faculdade.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_Faculdade.setMaximumSize(new Dimension(50, 50));
        this.j_Label_Faculdade.setMinimumSize(new Dimension(50, 50));
        this.j_Label_Faculdade.setPreferredSize(new Dimension(50, 50));
        this.j_Label_Curso.setFont(new Font("Times New Roman", 0, 18));
        this.j_Label_Curso.setText("4º Período");
        this.j_Label_Curso.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_Curso.setMaximumSize(new Dimension(50, 50));
        this.j_Label_Curso.setMinimumSize(new Dimension(50, 50));
        this.j_Label_Curso.setPreferredSize(new Dimension(50, 50));
        this.j_Label_Periodo.setFont(new Font("Times New Roman", 0, 18));
        this.j_Label_Periodo.setText("Aspectos Teóricos da Computação");
        this.j_Label_Periodo.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_Periodo.setMaximumSize(new Dimension(50, 50));
        this.j_Label_Periodo.setMinimumSize(new Dimension(50, 50));
        this.j_Label_Periodo.setPreferredSize(new Dimension(50, 50));
        this.j_Label_Nome.setFont(new Font("Times New Roman", 0, 18));
        this.j_Label_Nome.setText("Hirohito Pereira Gonçalves");
        this.j_Label_Nome.setBorder(BorderFactory.createEtchedBorder());
        this.jLabel1.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel1.setText("Heitor Vinicius Vieira Mariano");
        this.jLabel1.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout j_Panel_ProgramadorLayout = new GroupLayout(this.j_Panel_Programador);
        this.j_Panel_Programador.setLayout(j_Panel_ProgramadorLayout);
        j_Panel_ProgramadorLayout.setHorizontalGroup(j_Panel_ProgramadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(j_Panel_ProgramadorLayout.createSequentialGroup().addGroup(j_Panel_ProgramadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.j_Label_Periodo, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.j_Label_Curso, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.j_Label_Faculdade, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.j_Label_Nome, -1, -1, 32767).addComponent(this.jLabel1, -1, 256, 32767)).addContainerGap()));
        j_Panel_ProgramadorLayout.setVerticalGroup(j_Panel_ProgramadorLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(j_Panel_ProgramadorLayout.createSequentialGroup().addComponent(this.j_Label_Nome, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel1, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.j_Label_Faculdade, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.j_Label_Curso, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.j_Label_Periodo, -2, 30, -2).addContainerGap(-1, 32767)));
        this.j_Label_Faculdade.getAccessibleContext().setAccessibleName("");
        this.j_Label_Curso.getAccessibleContext().setAccessibleName("");
        this.j_Label_Periodo.getAccessibleContext().setAccessibleName("");
        this.j_Label_Nome.getAccessibleContext().setAccessibleName("");
        this.j_Panel_Sistema.setBorder(BorderFactory.createTitledBorder(null, "Sistemas", 0, 0, new Font("Times New Roman", 1, 14)));
        this.j_Label_SistemaOperacional.setFont(new Font("Times New Roman", 0, 18));
        this.j_Label_SistemaOperacional.setText("Windows 7");
        this.j_Label_SistemaOperacional.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_SistemaOperacional.setMaximumSize(new Dimension(50, 50));
        this.j_Label_SistemaOperacional.setMinimumSize(new Dimension(50, 50));
        this.j_Label_SistemaOperacional.setPreferredSize(new Dimension(50, 50));
        this.j_Label_NetBeans.setFont(new Font("Times New Roman", 0, 18));
        this.j_Label_NetBeans.setText("NetBeans IDE 7.2");
        this.j_Label_NetBeans.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_NetBeans.setMaximumSize(new Dimension(50, 50));
        this.j_Label_NetBeans.setMinimumSize(new Dimension(50, 50));
        this.j_Label_NetBeans.setPreferredSize(new Dimension(50, 50));
        this.j_Label_VersaoTexto.setFont(new Font("Times New Roman", 0, 18));
        this.j_Label_VersaoTexto.setText("Ultima versão em :");
        this.j_Label_VersaoTexto.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_VersaoTexto.setMaximumSize(new Dimension(50, 50));
        this.j_Label_VersaoTexto.setMinimumSize(new Dimension(50, 50));
        this.j_Label_VersaoTexto.setPreferredSize(new Dimension(50, 50));
        this.j_Label_VersaoData.setFont(new Font("Times New Roman", 0, 18));
        this.j_Label_VersaoData.setText("Terça, 23 de outubro de 2012");
        this.j_Label_VersaoData.setBorder(BorderFactory.createEtchedBorder());
        this.j_Label_VersaoData.setMaximumSize(new Dimension(50, 50));
        this.j_Label_VersaoData.setMinimumSize(new Dimension(50, 50));
        this.j_Label_VersaoData.setPreferredSize(new Dimension(50, 50));
        this.jLabel3.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel3.setText("Sistemas de Informação");
        this.jLabel3.setBorder(BorderFactory.createEtchedBorder());
        GroupLayout j_Panel_SistemaLayout = new GroupLayout(this.j_Panel_Sistema);
        this.j_Panel_Sistema.setLayout(j_Panel_SistemaLayout);
        j_Panel_SistemaLayout.setHorizontalGroup(j_Panel_SistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.j_Label_SistemaOperacional, -1, 223, 32767).addComponent(this.j_Label_NetBeans, -1, -1, 32767).addComponent(this.j_Label_VersaoTexto, -1, -1, 32767).addComponent(this.j_Label_VersaoData, -1, -1, 32767).addComponent(this.jLabel3, -1, -1, 32767));
        j_Panel_SistemaLayout.setVerticalGroup(j_Panel_SistemaLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(j_Panel_SistemaLayout.createSequentialGroup().addComponent(this.j_Label_SistemaOperacional, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.j_Label_NetBeans, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel3, -1, -1, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.j_Label_VersaoTexto, -2, 30, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.j_Label_VersaoData, -2, 30, -2).addContainerGap()));
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.j_Panel_Programador, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.j_Panel_Sistema, -2, -1, -2).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.j_Panel_Sistema, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.j_Panel_Programador, -2, -1, -2));
        pack();
    }
}