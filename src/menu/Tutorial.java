package menu;

import javax.swing.*;
import java.awt.*;

public class Tutorial extends JFrame {
    private JScrollPane jScrollPane;
    private JTextArea jTextArea_Tutorial;

    public Tutorial() {
        initComponents();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tutorial().setVisible(true);
            }
        });
    }

    private void initComponents() {
        this.jScrollPane = new JScrollPane();
        this.jTextArea_Tutorial = new JTextArea();
        setTitle("Tutorial de Ajuda");
        setBackground(new Color(255, 255, 255));
        setBounds(new Rectangle(0, 0, 0, 0));
        setCursor(new Cursor(0));
        setName("Tutorial");
        setResizable(false);
        this.jTextArea_Tutorial.setEditable(false);
        this.jTextArea_Tutorial.setColumns(20);
        this.jTextArea_Tutorial.setFont(new Font("Times New Roman", 0, 18));
        this.jTextArea_Tutorial.setRows(5);
        this.jTextArea_Tutorial.setText("\n\tTutorial de Ajuda - Manipulação do Programa\n\n  O programa a principio é muito fácil de manusear, a única ação do usuário será\n selecionar um arquivo do formato TXT contendo os dados de uma matriz de\n adjacência dentro. Um detalhe primordial para o programa, como disse antes,\n deve ser uma matriz de adjacência.\n\n  Para efetuar a operação citada acima, basta clicar no botão “Busca Arquivo” e\n selecionar o arquivo.txt desejado. O botão “Limpar Tudo” apenas limpará todos\n os dados que já foram salvos. Após isso será informado os resultados dos cálculos.\n\n  No menu existe uma opção “Mostrar Desenho” para mostrar o grafo desenhado\n com coloração. A opção “Sair” encerrará o programa. No menu, também se pode\n ter acesso aos dados do programador na opção “Sobre”.");
        this.jScrollPane.setViewportView(this.jTextArea_Tutorial);
        this.jTextArea_Tutorial.getAccessibleContext().setAccessibleParent(this);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 627, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane, -2, 627, -2).addGap(0, 0, 32767))));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 442, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane, -2, 442, -2).addGap(0, 0, 32767))));
        pack();
    }
}