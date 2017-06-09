import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MatrizAdjacencia extends JFrame {
    public JLabel jLabel_DadosMatrizAdjacencia;
    public JScrollPane jScrollPane1;
    public JTextArea jTextArea_MatrizAdjacencia;

    public MatrizAdjacencia(String texto) {
        initComponents();
        this.jTextArea_MatrizAdjacencia.setText(texto);
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MatrizAdjacencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.jTextArea_MatrizAdjacencia = new JTextArea();
        this.jLabel_DadosMatrizAdjacencia = new JLabel();
        setTitle("Impressão da Matriz");
        setResizable(false);
        this.jTextArea_MatrizAdjacencia.setEditable(false);
        this.jTextArea_MatrizAdjacencia.setColumns(20);
        this.jTextArea_MatrizAdjacencia.setFont(new Font("Times New Roman", 0, 16));
        this.jTextArea_MatrizAdjacencia.setRows(5);
        this.jScrollPane1.setViewportView(this.jTextArea_MatrizAdjacencia);
        this.jLabel_DadosMatrizAdjacencia.setFont(new Font("Times New Roman", 0, 18));
        this.jLabel_DadosMatrizAdjacencia.setHorizontalAlignment(0);
        this.jLabel_DadosMatrizAdjacencia.setText("Dados da Matriz de Adjacência");
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jLabel_DadosMatrizAdjacencia, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane1, -2, 950, -2).addGap(0, 0, 32767))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel_DadosMatrizAdjacencia, -2, 59, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 520, -2).addContainerGap(-1, 32767)));
        pack();
    }
}