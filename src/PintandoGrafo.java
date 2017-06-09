import javax.swing.*;
import java.awt.*;

public final class PintandoGrafo extends JFrame {
    private AtributosGrafo grafo = new AtributosGrafo(1L);

    public PintandoGrafo(int[][] VerticeLigacao, int[] VerticeCores, int TotalVertice, int MaiorGrau) {
        initComponents();
        setLocation(5, 30);
        criarDesenho(VerticeLigacao, VerticeCores, TotalVertice, MaiorGrau);
    }

    public void criarPosicoes() {
        getGrafo().setPosicao(new int[20][2]);
        getGrafo().getPosicao()[0][0] = 315;
        getGrafo().getPosicao()[0][1] = 50;
        getGrafo().getPosicao()[1][0] = 'Ò';
        getGrafo().getPosicao()[1][1] = 65;
        getGrafo().getPosicao()[2][0] = 420;
        getGrafo().getPosicao()[2][1] = 65;
        getGrafo().getPosicao()[3][0] = '';
        getGrafo().getPosicao()[3][1] = 105;
        getGrafo().getPosicao()[4][0] = 500;
        getGrafo().getPosicao()[4][1] = 105;
        getGrafo().getPosicao()[5][0] = 75;
        getGrafo().getPosicao()[5][1] = '¥';
        getGrafo().getPosicao()[6][0] = 550;
        getGrafo().getPosicao()[6][1] = '¥';
        getGrafo().getPosicao()[7][0] = 40;
        getGrafo().getPosicao()[7][1] = 'ð';
        getGrafo().getPosicao()[8][0] = 575;
        getGrafo().getPosicao()[8][1] = 'ð';
        getGrafo().getPosicao()[9][0] = 20;
        getGrafo().getPosicao()[9][1] = 330;
        getGrafo().getPosicao()[10][0] = 595;
        getGrafo().getPosicao()[10][1] = 330;
        getGrafo().getPosicao()[11][0] = 40;
        getGrafo().getPosicao()[11][1] = 420;
        getGrafo().getPosicao()[12][0] = 575;
        getGrafo().getPosicao()[12][1] = 420;
        getGrafo().getPosicao()[13][0] = 75;
        getGrafo().getPosicao()[13][1] = 495;
        getGrafo().getPosicao()[14][0] = 550;
        getGrafo().getPosicao()[14][1] = 495;
        getGrafo().getPosicao()[15][0] = '';
        getGrafo().getPosicao()[15][1] = 555;
        getGrafo().getPosicao()[16][0] = 500;
        getGrafo().getPosicao()[16][1] = 555;
        getGrafo().getPosicao()[17][0] = 'Ò';
        getGrafo().getPosicao()[17][1] = 595;
        getGrafo().getPosicao()[18][0] = 420;
        getGrafo().getPosicao()[18][1] = 595;
        getGrafo().getPosicao()[19][0] = 315;
        getGrafo().getPosicao()[19][1] = 610;
    }

    public void criarDesenho(int[][] VerticeLigacao, int[] VerticeCores, int TotalVertice, int MaiorGrau) {
        criarPosicoes();
        getGrafo().setVerticeLigacao(VerticeLigacao);
        getGrafo().setVerticeCores(VerticeCores);
        getGrafo().setTotalVertice(TotalVertice);
        getGrafo().setMaiorGrau(MaiorGrau);
    }

    public final void paint(Graphics g) {
        g.setColor(Color.black);
        for (int i = 0; i < getGrafo().getTotalVertice(); i++) {
            for (int j = 0; j < getGrafo().getMaiorGrau(); j++) {
                if (getGrafo().getVerticeLigacao()[i][j] != 0) {
                    g.drawLine(getGrafo().getPosicao()[i][0] + 10, getGrafo().getPosicao()[i][1] + 10, getGrafo().getPosicao()[(getGrafo().getVerticeLigacao()[i][j] - 1)][0] + 10, getGrafo().getPosicao()[(getGrafo().getVerticeLigacao()[i][j] - 1)][1] + 10);
                }
            }
        }
        for (int i = 0; i < getGrafo().getTotalVertice(); i++) {
            int cor = 0;
            if (i == 0) cor = getGrafo().getVerticeCores()[i];
            else {
                cor = getGrafo().getVerticeCores()[i];
            }
            if (cor == 1) g.setColor(Color.blue);
            else if (cor == 2) g.setColor(Color.red);
            else if (cor == 3) g.setColor(Color.green);
            else if (cor == 4) {
                g.setColor(Color.yellow);
            }
            g.fillOval(getGrafo().getPosicao()[i][0], getGrafo().getPosicao()[i][1], 20, 20);
            g.setColor(Color.black);
            int p = i + 1;
            g.drawString("" + p, getGrafo().getPosicao()[i][0] + 5, getGrafo().getPosicao()[i][1] + 15);
        }
    }

    private void initComponents() {
        setTitle("Desenho");
        setBounds(new Rectangle(0, 0, 0, 0));
        setMaximumSize(null);
        setResizable(false);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 800, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 650, 32767));
        pack();
    }

    private AtributosGrafo getGrafo() {
        return this.grafo;
    }

    private void setGrafo(AtributosGrafo grafo) {
        this.grafo = grafo;
    }
}