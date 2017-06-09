import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CalculosPrincipal extends JFrame {
    private AtributosGrafo grafo = new AtributosGrafo(-1L);
    private int[][] Mgrafo;
    private JButton jButton_BuscaArquivo;
    private JButton jButton_LimparTudo;
    private JFileChooser jFileChooser_Caminho;
    private JLabel jLabel_EstadoSelecao;
    private JLabel jLabel_Instrucoes1;
    private JLabel jLabel_Instrucoes2;
    private JLabel jLabel_Instrucoes3;
    private JLabel jLabel_Instrucoes4;
    private JLabel jLabel_SelecionarArquivoTXT;
    private JMenuBar jMenuBar_Principal;
    private JMenuItem jMenuItem_ImprimirMatriz;
    private JMenuItem jMenuItem_MostrarDesenho;
    private JMenuItem jMenuItem_Sair;
    private JMenuItem jMenuItem_Sobre;
    private JMenuItem jMenuItem_Tutorial;
    private JMenu jMenu_Ajuda;
    private JMenu jMenu_Arquivos;
    private JScrollPane jScrollPane_TextArea;
    private JTextArea jTextArea_InformarDados;

    public CalculosPrincipal() {
        initComponents();
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CalculosPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalculosPrincipal().setVisible(true);
            }
        });
    }

    public void Reniciar() {
        getGrafo().setCaminho("");
        getGrafo().setNome("");
        getjLabel_EstadoSelecao().setText("");
        getjTextArea_InformarDados().setFont(new Font("Times New Roman", 0, 30));
        getjTextArea_InformarDados().setText("Nenhum Arquivo Selecionado");
        getjLabel_SelecionarArquivoTXT().setText("Selecione um Arquivo.txt Para Realizar os Cálculos Solicitados");
        getjMenuItem_MostrarDesenho().setEnabled(false);
        getjMenuItem_ImprimirMatriz().setEnabled(false);
    }

    public boolean VerificacaoTXT() {
        String formato = ".txt";
        getGrafo().setNome(getjFileChooser_Caminho().getSelectedFile().getName());
        int total = getGrafo().getNome().length();
        String subformato = getGrafo().getNome().substring(total - 4, total);
        if (!subformato.equals(formato)) {
            getjFileChooser_Caminho().setSelectedFile(null);
            return false;
        }
        return true;
    }

    public void IniciarImprimirMatriz() {
        boolean imprimir = false;
        getGrafo().setImprimirMatriz(Boolean.valueOf(false));
        String titulo = getTitle();
        ImprimirMatriz();
        while (getGrafo().getImprimirMatriz().booleanValue() != true) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(CalculosPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        imprimir = true;
        if (imprimir == true) {
            getGrafo().getImprimir_matriz().show();
            setTitle(titulo);
        }
    }

    public void ImprimirMatriz() {
        setTitle("Aguarde, Lendo Dados Para Montar Matriz.....");
        String texto = "";
        int total = RetornaQuantidadeTotalVertice(getGrafo().getPrimeiraLinha());
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                texto = texto + getMgrafo()[i][j] + "  ";
            }
            texto = texto + "\n";
        }
        getGrafo().setImprimir_matriz(new MatrizAdjacencia(texto));
        getGrafo().setImprimirMatriz(Boolean.valueOf(true));
    }

    public int RetornaVerticeMaiorGrau() {
        int q = 0;
        int maior = 0;
        int MaiorGrau = 0;
        int total = RetornaQuantidadeTotalVertice(getGrafo().getPrimeiraLinha());
        for (int i = 0; i <= total - 1; i++) {
            for (int j = 0; j <= total - 1; j++) {
                if (getMgrafo()[i][j] == 1) {
                    q++;
                }
            }
            if (q > maior) {
                maior = q;
                MaiorGrau = i;
            }
            q = 0;
        }
        return MaiorGrau + 1;
    }

    public int RetornaMaiorGrauGrafo() {
        int q = 0;
        int MaiorGrau = 0;
        int total = RetornaQuantidadeTotalVertice(getGrafo().getPrimeiraLinha());
        for (int i = 0; i <= total - 1; i++) {
            for (int j = 0; j <= total - 1; j++) {
                if (getMgrafo()[i][j] == 1) {
                    q++;
                }
            }
            if (q > MaiorGrau) {
                MaiorGrau = q;
            }
            q = 0;
        }
        return MaiorGrau;
    }

    public String RetornaSemEspacoFim(String linha) {
        boolean estado = false;
        while (!estado) {
            int length = linha.length();
            Character caracterio = Character.valueOf(linha.charAt(length - 1));
            if ((!"0".equals(caracterio.toString())) && (!"1".equals(caracterio.toString())) && (!"2".equals(caracterio.toString())) && (!"3".equals(caracterio.toString())) && (!"4".equals(caracterio.toString())) && (!"5".equals(caracterio.toString())) && (!"6".equals(caracterio.toString())) && (!"7".equals(caracterio.toString())) && (!"8".equals(caracterio.toString())) && (!"9".equals(caracterio.toString())))
                linha = linha.substring(0, linha.length() - 1);
            else {
                estado = true;
            }
        }
        return linha;
    }

    public String RetornaSemEspacoInicio_Final(String linha) {
        boolean estado = false;
        while (!estado) {
            Character caracterio = Character.valueOf(linha.charAt(0));
            if ((!"0".equals(caracterio.toString())) && (!"1".equals(caracterio.toString())) && (!"2".equals(caracterio.toString())) && (!"3".equals(caracterio.toString())) && (!"4".equals(caracterio.toString())) && (!"5".equals(caracterio.toString())) && (!"6".equals(caracterio.toString())) && (!"7".equals(caracterio.toString())) && (!"8".equals(caracterio.toString())) && (!"9".equals(caracterio.toString())))
                linha = linha.substring(1);
            else {
                estado = true;
            }
        }
        return linha;
    }

    public int RetornaQuantidadeTotalVertice(String linha) {
        linha = RetornaSemEspacoInicio_Final(RetornaSemEspacoFim(linha));
        int length = linha.length();
        int total = 0;
        int l = 0;
        while (l <= length) {
            if (l == length) {
                total++;
            } else {
                Character caracterio = Character.valueOf(linha.charAt(l));
                if ((!"0".equals(caracterio.toString())) && (!"1".equals(caracterio.toString())) && (!"2".equals(caracterio.toString())) && (!"3".equals(caracterio.toString())) && (!"4".equals(caracterio.toString())) && (!"5".equals(caracterio.toString())) && (!"6".equals(caracterio.toString())) && (!"7".equals(caracterio.toString())) && (!"8".equals(caracterio.toString())) && (!"9".equals(caracterio.toString())) && (l != length - 1)) {
                    total++;
                }
            }
            l++;
        }
        return total;
    }

    public int[][] RetornaMatrizLigacao() {
        int total = RetornaQuantidadeTotalVertice(getGrafo().getPrimeiraLinha());
        int maior = RetornaMaiorGrauGrafo();
        int[][] MLigacoes = new int[total][maior];
        int posicao = 0;
        for (int i = 0; i < total; i++) {
            for (int j = 0; j < total; j++) {
                if (getMgrafo()[i][j] == 1) {
                    MLigacoes[i][posicao] = (j + 1);
                    posicao++;
                }
            }
            posicao = 0;
        }
        return MLigacoes;
    }

    public int[] RetornaVetorCalculoCoresGrafo() {
        int[][] matriz = RetornaMatrizLigacao();
        int total = RetornaQuantidadeTotalVertice(getGrafo().getPrimeiraLinha());
        int maior = RetornaMaiorGrauGrafo();
        int[] cores = new int[total];
        ArrayList CoresUsadas = new ArrayList();
        for (int i = 0; i < total; i++) {
            if (i == 0) {
                cores[0] = 1;
            } else if (cores[i] == 0) {
                int cor1 = 0;
                int cor2 = 0;
                int cor3 = 0;
                int cor4 = 0;
                int p = 0;
                for (int v = 0; v < 4; v++) {
                    CoresUsadas.add(0, Integer.valueOf(0));
                }
                for (int j = 0; j < maior; j++) {
                    if (matriz[i][j] != 0) {
                        int valor = matriz[i][j];
                        if (cores[(valor - 1)] != 0) {
                            CoresUsadas.add(p, Integer.valueOf(cores[(valor - 1)]));
                            p++;
                        }
                    } else {
                        if (matriz[i][0] == 0) {
                            break;
                        }
                    }
                }
                if (((Integer) CoresUsadas.get(0)).intValue() == 0) {
                    cores[i] = 1;
                } else {
                    for (int c = 0; c < 4; c++) {
                        if (((Integer) CoresUsadas.get(c)).intValue() != 0) {
                            if (((Integer) CoresUsadas.get(c)).intValue() == 1) cor1++;
                            else if (((Integer) CoresUsadas.get(c)).intValue() == 2) cor2++;
                            else if (((Integer) CoresUsadas.get(c)).intValue() == 3) cor3++;
                            else if (((Integer) CoresUsadas.get(c)).intValue() == 4) {
                                cor4++;
                            }
                        }
                    }
                    if (cor1 == 0) cores[i] = 1;
                    else if (cor2 == 0) cores[i] = 2;
                    else if (cor3 == 0) cores[i] = 3;
                    else if (cor4 == 0) {
                        cores[i] = 4;
                    }
                }
            }
        }
        return cores;
    }

    public int RetornaMenorQuantidadeCores() {
        int maior = 0;
        int total = RetornaQuantidadeTotalVertice(getGrafo().getPrimeiraLinha());
        int[] vetor = RetornaVetorCalculoCoresGrafo();
        for (int i = 0; i < total; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }
        getGrafo().setTempoFinal(System.currentTimeMillis());
        return maior;
    }

    public void Iniciar_Leitura() {
        File arquivo = new File(getGrafo().getCaminho());
        try {
            Ler_e_AdicionarParaMatriz(arquivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CalculosPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CalculosPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Ler_e_AdicionarParaMatriz(File file) throws IOException {
        FileReader ArquivoLeitura = new FileReader(file);
        FileReader fileReader = new FileReader(file);
        Throwable localThrowable2 = null;
        try {
            BufferedReader reader = new BufferedReader(fileReader);
            BufferedReader LerVertice = new BufferedReader(ArquivoLeitura);
            String data = null;
            getGrafo().setPrimeiraLinha(LerVertice.readLine());
            if ((getGrafo().getPrimeiraLinha() == null) || ("".equals(getGrafo().getPrimeiraLinha()))) {
                getGrafo().setValoresGrafoTXTCorreto(Boolean.valueOf(true));
            } else {
                int total = RetornaQuantidadeTotalVertice(getGrafo().getPrimeiraLinha());
                setMgrafo(new int[total][total]);
                int vertice = 0;
                while ((data = reader.readLine()) != null) {
                    data = RetornaSemEspacoInicio_Final(RetornaSemEspacoFim(data));
                    int length = data.length();
                    int PLinha = 0;
                    int linha = 0;
                    int valor = 0;
                    String juncao = "";
                    int espaco = 0;
                    while (PLinha <= length) {
                        if (PLinha == length) {
                            getMgrafo()[vertice][linha] = valor;
                            vertice++;
                        } else {
                            Character caracterio = Character.valueOf(data.charAt(PLinha));
                            if (("0".equals(caracterio.toString())) || ("1".equals(caracterio.toString()))) {
                                espaco = 0;
                                Integer v = Integer.valueOf(Integer.parseInt(caracterio.toString()));
                                juncao = juncao + v;
                                valor = Integer.parseInt(juncao);
                            } else {
                                espaco++;
                                if (PLinha != length - 1) {
                                    getMgrafo()[vertice][linha] = valor;
                                    linha++;
                                    juncao = "";
                                }
                            }
                            if (("2".equals(caracterio.toString())) || ("3".equals(caracterio.toString())) || ("4".equals(caracterio.toString())) || ("5".equals(caracterio.toString())) || ("6".equals(caracterio.toString())) || ("7".equals(caracterio.toString())) || ("8".equals(caracterio.toString())) || ("9".equals(caracterio.toString())) || ("-".equals(caracterio.toString())) || (valor > 1) || (espaco > 1)) {
                                getGrafo().setValoresGrafoTXTCorreto(Boolean.valueOf(true));
                                return;
                            }
                        }
                        PLinha++;
                    }
                }
                reader.close();
            }
        } catch (Throwable localThrowable1) {
            localThrowable2 = localThrowable1;
            throw localThrowable1;
        } finally {
            if (fileReader != null) if (localThrowable2 != null) try {
                fileReader.close();
            } catch (Throwable x2) {
                localThrowable2.addSuppressed(x2);
            }
            else fileReader.close();
        }
    }

    public void IniciarAcaoBotao_BuscarArquivo() {
        Reniciar();
        int retorno = getjFileChooser_Caminho().showOpenDialog(null);
        if ((retorno == 0) && (getjFileChooser_Caminho().getSelectedFile() != null)) if (VerificacaoTXT()) {
            getGrafo().setTempoInicio(System.currentTimeMillis());
            AcaoBotao_BuscarArquivo();
        } else {
            Reniciar();
            JOptionPane.showMessageDialog(null, "Formato do Arquivo Inválido\nSelecione um Arquivo.txt", "Erro", 0);
        }
    }

    public void AcaoBotao_BuscarArquivo() {
        getGrafo().setCaminho(getjFileChooser_Caminho().getSelectedFile().getPath());
        getjTextArea_InformarDados().setText(null);
        getGrafo().setValoresGrafoTXTCorreto(Boolean.valueOf(false));
        Iniciar_Leitura();
        if (getGrafo().getValoresGrafoTXTCorreto().booleanValue() != true) {
            int TotalNome = getGrafo().getNome().length();
            int TotalCaminho = getGrafo().getCaminho().length();
            int TotalVertice = RetornaQuantidadeTotalVertice(getGrafo().getPrimeiraLinha());
            int maior = RetornaMaiorGrauGrafo();
            int menor = RetornaMenorQuantidadeCores();
            getjLabel_EstadoSelecao().setText("Arquivo: ''" + getGrafo().getNome().substring(0, TotalNome - 4) + "''");
            getjTextArea_InformarDados().setFont(new Font("Times New Roman", 0, 18));
            getjTextArea_InformarDados().setText(" Quantidade Total de Vértices: " + TotalVertice + "  \n");
            getjTextArea_InformarDados().setText(getjTextArea_InformarDados().getText() + " Maior Grau do Grafo: " + maior + "  \n");
            getjTextArea_InformarDados().setText(getjTextArea_InformarDados().getText() + " Vértice Com Maior Grau: " + RetornaVerticeMaiorGrau() + "  \n");
            getjTextArea_InformarDados().setText(getjTextArea_InformarDados().getText() + " Quantidade Mínima de Cores Necessária: " + menor + "  \n");
            for (int v = 0; v == 0; ) {
                if (getGrafo().getTempoFinal() != -1L) {
                    getGrafo().setTempoSegundos(Double.valueOf((getGrafo().getTempoFinal() - getGrafo().getTempoInicio()) / 1000.0D));
                    v = 1;
                }
            }
            getjTextArea_InformarDados().setText(getjTextArea_InformarDados().getText() + " Tempo Gasto: " + getGrafo().getTempoSegundos() + " segundos  \n");
            getjTextArea_InformarDados().setText(getjTextArea_InformarDados().getText() + " Diretório: " + getGrafo().getCaminho().substring(0, TotalCaminho - TotalNome) + "  \n");
            getjLabel_SelecionarArquivoTXT().setText("Arquivo.txt Selecionado Com Êxito");
            getjMenuItem_MostrarDesenho().setEnabled(true);
            getjMenuItem_ImprimirMatriz().setEnabled(true);
        } else {
            getjFileChooser_Caminho().setSelectedFile(null);
            JOptionPane.showMessageDialog(null, "Dados da Matriz TXT Incorretos", "Erro", 0);
            Reniciar();
        }
    }

    private void initComponents() {
        this.jFileChooser_Caminho = new JFileChooser();
        this.jScrollPane_TextArea = new JScrollPane();
        this.jTextArea_InformarDados = new JTextArea();
        this.jLabel_SelecionarArquivoTXT = new JLabel();
        this.jButton_BuscaArquivo = new JButton();
        this.jLabel_EstadoSelecao = new JLabel();
        this.jLabel_Instrucoes1 = new JLabel();
        this.jLabel_Instrucoes2 = new JLabel();
        this.jLabel_Instrucoes3 = new JLabel();
        this.jLabel_Instrucoes4 = new JLabel();
        this.jButton_LimparTudo = new JButton();
        this.jMenuBar_Principal = new JMenuBar();
        this.jMenu_Arquivos = new JMenu();
        this.jMenuItem_MostrarDesenho = new JMenuItem();
        this.jMenuItem_ImprimirMatriz = new JMenuItem();
        this.jMenuItem_Sair = new JMenuItem();
        this.jMenu_Ajuda = new JMenu();
        this.jMenuItem_Sobre = new JMenuItem();
        this.jMenuItem_Tutorial = new JMenuItem();
        this.jFileChooser_Caminho.setBackground(new Color(0, 0, 204));
        this.jFileChooser_Caminho.setCurrentDirectory(new File("E:\\Novos\\Arquivos Para Grafos"));
        setDefaultCloseOperation(3);
        setTitle("Cálculos de Grafo");
        setResizable(false);
        this.jTextArea_InformarDados.setEditable(false);
        this.jTextArea_InformarDados.setColumns(20);
        this.jTextArea_InformarDados.setFont(new Font("Times New Roman", 0, 30));
        this.jTextArea_InformarDados.setRows(5);
        this.jTextArea_InformarDados.setText("Nenhum Arquivo Selecionado");
        this.jTextArea_InformarDados.setBorder(BorderFactory.createEtchedBorder());
        this.jScrollPane_TextArea.setViewportView(this.jTextArea_InformarDados);
        this.jLabel_SelecionarArquivoTXT.setFont(new Font("Times New Roman", 1, 16));
        this.jLabel_SelecionarArquivoTXT.setText("Selecione um arquivo.txt para realizar os cálculos solicitados");
        this.jButton_BuscaArquivo.setFont(new Font("Times New Roman", 0, 14));
        this.jButton_BuscaArquivo.setText("Buscar Arquivo");
        this.jButton_BuscaArquivo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosPrincipal.this.jButton_BuscaArquivoActionPerformed(evt);
            }
        });
        this.jLabel_EstadoSelecao.setFont(new Font("Times New Roman", 0, 16));
        this.jLabel_Instrucoes1.setFont(new Font("Times New Roman", 0, 14));
        this.jLabel_Instrucoes1.setText("Este software tem o propósito de:");
        this.jLabel_Instrucoes2.setFont(new Font("Times New Roman", 0, 14));
        this.jLabel_Instrucoes2.setText("Etapa 1 - Calcular o número de coloração do grafo;");
        this.jLabel_Instrucoes3.setFont(new Font("Times New Roman", 0, 14));
        this.jLabel_Instrucoes3.setText("Etapa 2 - Desenhar o caminho do grafo;");
        this.jLabel_Instrucoes4.setFont(new Font("Times New Roman", 0, 14));
        this.jLabel_Instrucoes4.setText("Etapa 3 - Colorir os vértices do grafo.");
        this.jButton_LimparTudo.setFont(new Font("Times New Roman", 0, 14));
        this.jButton_LimparTudo.setText("Limpar Tudo");
        this.jButton_LimparTudo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosPrincipal.this.jButton_LimparTudoActionPerformed(evt);
            }
        });
        this.jMenu_Arquivos.setText("Arquivos");
        this.jMenuItem_MostrarDesenho.setFont(new Font("Times New Roman", 0, 14));
        this.jMenuItem_MostrarDesenho.setIcon(new ImageIcon(getClass().getResource("/imagens/grafo.png")));
        this.jMenuItem_MostrarDesenho.setText("Mostrar Grafo Desenhado");
        this.jMenuItem_MostrarDesenho.setEnabled(false);
        this.jMenuItem_MostrarDesenho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosPrincipal.this.jMenuItem_MostrarDesenhoActionPerformed(evt);
            }
        });
        this.jMenu_Arquivos.add(this.jMenuItem_MostrarDesenho);
        this.jMenuItem_ImprimirMatriz.setFont(new Font("Times New Roman", 0, 14));
        this.jMenuItem_ImprimirMatriz.setIcon(new ImageIcon(getClass().getResource("/imagens/matriz.png")));
        this.jMenuItem_ImprimirMatriz.setText("Imprimir Matriz");
        this.jMenuItem_ImprimirMatriz.setEnabled(false);
        this.jMenuItem_ImprimirMatriz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosPrincipal.this.jMenuItem_ImprimirMatrizActionPerformed(evt);
            }
        });
        this.jMenu_Arquivos.add(this.jMenuItem_ImprimirMatriz);
        this.jMenuItem_Sair.setFont(new Font("Times New Roman", 0, 14));
        this.jMenuItem_Sair.setIcon(new ImageIcon(getClass().getResource("/imagens/sair.png")));
        this.jMenuItem_Sair.setText("Sair");
        this.jMenuItem_Sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosPrincipal.this.jMenuItem_SairActionPerformed(evt);
            }
        });
        this.jMenu_Arquivos.add(this.jMenuItem_Sair);
        this.jMenuBar_Principal.add(this.jMenu_Arquivos);
        this.jMenu_Ajuda.setText("Ajuda");
        this.jMenuItem_Sobre.setFont(new Font("Times New Roman", 0, 14));
        this.jMenuItem_Sobre.setIcon(new ImageIcon(getClass().getResource("/imagens/sobre.png")));
        this.jMenuItem_Sobre.setText("Sobre");
        this.jMenuItem_Sobre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosPrincipal.this.jMenuItem_SobreActionPerformed(evt);
            }
        });
        this.jMenu_Ajuda.add(this.jMenuItem_Sobre);
        this.jMenuItem_Tutorial.setFont(new Font("Times New Roman", 0, 14));
        this.jMenuItem_Tutorial.setIcon(new ImageIcon(getClass().getResource("/imagens/tutorial.png")));
        this.jMenuItem_Tutorial.setText("Tutorial");
        this.jMenuItem_Tutorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                CalculosPrincipal.this.jMenuItem_TutorialActionPerformed(evt);
            }
        });
        this.jMenu_Ajuda.add(this.jMenuItem_Tutorial);
        this.jMenuBar_Principal.add(this.jMenu_Ajuda);
        setJMenuBar(this.jMenuBar_Principal);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane_TextArea).addComponent(this.jLabel_Instrucoes4, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jLabel_Instrucoes3, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jLabel_Instrucoes2, GroupLayout.Alignment.TRAILING, -1, -1, 32767).addComponent(this.jLabel_Instrucoes1, -1, -1, 32767).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(0, 0, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jButton_BuscaArquivo, -2, 135, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel_EstadoSelecao, -2, 472, -2)).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel_SelecionarArquivoTXT, -2, 438, -2).addGap(18, 18, 18).addComponent(this.jButton_LimparTudo, -2, 155, -2))))).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel_Instrucoes1, -2, 17, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel_Instrucoes2, -2, 17, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel_Instrucoes3).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel_Instrucoes4, -2, 19, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane_TextArea, -2, 177, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jButton_LimparTudo, -2, 41, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jLabel_EstadoSelecao, -2, 62, -2)).addGroup(layout.createSequentialGroup().addComponent(this.jLabel_SelecionarArquivoTXT, -2, 41, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton_BuscaArquivo, -2, 62, -2))).addContainerGap()));
        pack();
        setLocationRelativeTo(null);
    }

    private void jMenuItem_SobreActionPerformed(ActionEvent evt) {
        getGrafo().getCsobre().show();
    }

    private void jMenuItem_SairActionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Obrigado Pelo Seu Tempo", "Agradecimentos", 1);
        System.exit(0);
    }

    private void jMenuItem_TutorialActionPerformed(ActionEvent evt) {
        getGrafo().getCtutorial().show();
    }

    private void jButton_BuscaArquivoActionPerformed(ActionEvent evt) {
        IniciarAcaoBotao_BuscarArquivo();
    }

    private void jButton_LimparTudoActionPerformed(ActionEvent evt) {
        Reniciar();
    }

    private void jMenuItem_MostrarDesenhoActionPerformed(ActionEvent evt) {
        if (RetornaQuantidadeTotalVertice(getGrafo().getPrimeiraLinha()) > 20) {
            JOptionPane.showMessageDialog(null, "Não Foi Possível Imprimir o Desenho\nQuantidade de Vértices Maior que 20", "Aviso", 1);
        } else {
            PintandoGrafo pintando_grafo = new PintandoGrafo(RetornaMatrizLigacao(), RetornaVetorCalculoCoresGrafo(), RetornaQuantidadeTotalVertice(getGrafo().getPrimeiraLinha()), RetornaMaiorGrauGrafo());
            pintando_grafo.show();
        }
    }

    private void jMenuItem_ImprimirMatrizActionPerformed(ActionEvent evt) {
        IniciarImprimirMatriz();
    }

    public AtributosGrafo getGrafo() {
        return this.grafo;
    }

    public JButton getjButton_BuscaArquivo() {
        return this.jButton_BuscaArquivo;
    }

    public void setjButton_BuscaArquivo(JButton jButton_BuscaArquivo) {
        this.jButton_BuscaArquivo = jButton_BuscaArquivo;
    }

    public JButton getjButton_LimparTudo() {
        return this.jButton_LimparTudo;
    }

    public void setjButton_LimparTudo(JButton jButton_LimparTudo) {
        this.jButton_LimparTudo = jButton_LimparTudo;
    }

    public JFileChooser getjFileChooser_Caminho() {
        return this.jFileChooser_Caminho;
    }

    public void setjFileChooser_Caminho(JFileChooser jFileChooser_Caminho) {
        this.jFileChooser_Caminho = jFileChooser_Caminho;
    }

    public JLabel getjLabel_EstadoSelecao() {
        return this.jLabel_EstadoSelecao;
    }

    public void setjLabel_EstadoSelecao(JLabel jLabel_EstadoSelecao) {
        this.jLabel_EstadoSelecao = jLabel_EstadoSelecao;
    }

    public JLabel getjLabel_Instrucoes1() {
        return this.jLabel_Instrucoes1;
    }

    public void setjLabel_Instrucoes1(JLabel jLabel_Instrucoes1) {
        this.jLabel_Instrucoes1 = jLabel_Instrucoes1;
    }

    public JLabel getjLabel_Instrucoes2() {
        return this.jLabel_Instrucoes2;
    }

    public void setjLabel_Instrucoes2(JLabel jLabel_Instrucoes2) {
        this.jLabel_Instrucoes2 = jLabel_Instrucoes2;
    }

    public JLabel getjLabel_Instrucoes3() {
        return this.jLabel_Instrucoes3;
    }

    public void setjLabel_Instrucoes3(JLabel jLabel_Instrucoes3) {
        this.jLabel_Instrucoes3 = jLabel_Instrucoes3;
    }

    public JLabel getjLabel_Instrucoes4() {
        return this.jLabel_Instrucoes4;
    }

    public void setjLabel_Instrucoes4(JLabel jLabel_Instrucoes4) {
        this.jLabel_Instrucoes4 = jLabel_Instrucoes4;
    }

    public JLabel getjLabel_SelecionarArquivoTXT() {
        return this.jLabel_SelecionarArquivoTXT;
    }

    public void setjLabel_SelecionarArquivoTXT(JLabel jLabel_SelecionarArquivoTXT) {
        this.jLabel_SelecionarArquivoTXT = jLabel_SelecionarArquivoTXT;
    }

    public JMenuBar getjMenuBar_Principal() {
        return this.jMenuBar_Principal;
    }

    public void setjMenuBar_Principal(JMenuBar jMenuBar_Principal) {
        this.jMenuBar_Principal = jMenuBar_Principal;
    }

    public JMenuItem getjMenuItem_ImprimirMatriz() {
        return this.jMenuItem_ImprimirMatriz;
    }

    public void setjMenuItem_ImprimirMatriz(JMenuItem jMenuItem_ImprimirMatriz) {
        this.jMenuItem_ImprimirMatriz = jMenuItem_ImprimirMatriz;
    }

    public JMenuItem getjMenuItem_MostrarDesenho() {
        return this.jMenuItem_MostrarDesenho;
    }

    public void setjMenuItem_MostrarDesenho(JMenuItem jMenuItem_MostrarDesenho) {
        this.jMenuItem_MostrarDesenho = jMenuItem_MostrarDesenho;
    }

    public JMenuItem getjMenuItem_Sair() {
        return this.jMenuItem_Sair;
    }

    public void setjMenuItem_Sair(JMenuItem jMenuItem_Sair) {
        this.jMenuItem_Sair = jMenuItem_Sair;
    }

    public JMenuItem getjMenuItem_Sobre() {
        return this.jMenuItem_Sobre;
    }

    public void setjMenuItem_Sobre(JMenuItem jMenuItem_Sobre) {
        this.jMenuItem_Sobre = jMenuItem_Sobre;
    }

    public JMenuItem getjMenuItem_Tutorial() {
        return this.jMenuItem_Tutorial;
    }

    public void setjMenuItem_Tutorial(JMenuItem jMenuItem_Tutorial) {
        this.jMenuItem_Tutorial = jMenuItem_Tutorial;
    }

    public JMenu getjMenu_Ajuda() {
        return this.jMenu_Ajuda;
    }

    public void setjMenu_Ajuda(JMenu jMenu_Ajuda) {
        this.jMenu_Ajuda = jMenu_Ajuda;
    }

    public JMenu getjMenu_Arquivos() {
        return this.jMenu_Arquivos;
    }

    public void setjMenu_Arquivos(JMenu jMenu_Arquivos) {
        this.jMenu_Arquivos = jMenu_Arquivos;
    }

    public JScrollPane getjScrollPane_TextArea() {
        return this.jScrollPane_TextArea;
    }

    public void setjScrollPane_TextArea(JScrollPane jScrollPane_TextArea) {
        this.jScrollPane_TextArea = jScrollPane_TextArea;
    }

    public JTextArea getjTextArea_InformarDados() {
        return this.jTextArea_InformarDados;
    }

    public void setjTextArea_InformarDados(JTextArea jTextArea_InformarDados) {
        this.jTextArea_InformarDados = jTextArea_InformarDados;
    }

    private int[][] getMgrafo() {
        return this.Mgrafo;
    }

    private void setMgrafo(int[][] Mgrafo) {
        this.Mgrafo = Mgrafo;
    }
}