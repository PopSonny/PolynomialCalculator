package pachetView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    //panouri
    private final JPanel panouMaster = new JPanel();
    private final JPanel panouNume = new JPanel();
    private final JPanel panouIntroducereDate = new JPanel();
    private final JPanel panouButoane = new JPanel();

    //panouNume
    private final JLabel labelNume = new JLabel("Calculator");

    //panouIntroducereDate
    private final JTextField primulOperand = new JTextField("6*X^7+ 6*X^2 + 8*X^1 + 3*X^0");
    private final JTextField alDoileaOperand = new JTextField("12*X^7+ 3*X^2 + 7*X^1 + 2*X^0");
    //private final JTextField primulOperand = new JTextField("3*X^2+5*X^1+2*X^0");
    //private final JTextField alDoileaOperand = new JTextField("2*X^1+1*X^0");
    private final JLabel semnulOperatiei = new JLabel("Semn");
    private final JLabel labelEgal = new JLabel("=");
    private final JTextArea rezultatOperatie = new JTextArea("Rezultatul o sa apara aici");

    //panouButoane
    private final JButton butonAdunare = new JButton("Adunare");
    private final JButton butonScadere = new JButton("Scadere");
    private final JButton butonInmultire = new JButton("Inmultire");
    private final JButton butonImpartire = new JButton("Impartire");
    private final JButton butonIntegrare = new JButton("Integrare");
    private final JButton butonDerivare = new JButton("Derivare");
    private final JButton butonReset = new JButton("Reset");
    private final JButton butonQuit = new JButton("Quit");


    public View() {
        rezultatOperatie.setLineWrap(true);
        rezultatOperatie.setEditable(false);
        this.setResizable(false);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        metodaPanouNume();
        metodaPanouDate();
        metodaPanouButoane();
        metodaPanouMaster();
        this.setContentPane(panouMaster);
        this.setVisible(true);
    }

    private void metodaPanouNume() {
        panouNume.setLayout(new FlowLayout());
        panouNume.add(labelNume);
    }

    private void metodaPanouDate() {

        semnulOperatiei.setFont(new Font("Serif", Font.BOLD, 24));
        panouIntroducereDate.setLayout(new BoxLayout(panouIntroducereDate, BoxLayout.Y_AXIS));
        panouIntroducereDate.add(primulOperand);
        panouIntroducereDate.add(Box.createRigidArea(new Dimension(0, 20)));
        semnulOperatiei.setAlignmentX(Component.CENTER_ALIGNMENT);
        panouIntroducereDate.add(semnulOperatiei);
        panouIntroducereDate.add(Box.createRigidArea(new Dimension(0, 20)));
        alDoileaOperand.setAlignmentX(Component.CENTER_ALIGNMENT);
        panouIntroducereDate.add(alDoileaOperand);
        panouIntroducereDate.add(Box.createRigidArea(new Dimension(0, 20)));
        labelEgal.setAlignmentX(Component.CENTER_ALIGNMENT);
        panouIntroducereDate.add(labelEgal);
        panouIntroducereDate.add(Box.createRigidArea(new Dimension(0, 20)));
        rezultatOperatie.setAlignmentX(Component.CENTER_ALIGNMENT);
        panouIntroducereDate.add(rezultatOperatie);

    }

    private void metodaPanouButoane() {
        panouButoane.setLayout(new GridLayout(2, 4));
        panouButoane.add(butonAdunare);
        panouButoane.add(butonScadere);
        panouButoane.add(butonInmultire);
        panouButoane.add(butonImpartire);
        panouButoane.add(butonIntegrare);
        panouButoane.add(butonDerivare);
        panouButoane.add(butonReset);
        panouButoane.add(butonQuit);

    }

    private void metodaPanouMaster() {
        panouMaster.setLayout(new BoxLayout(panouMaster, BoxLayout.Y_AXIS));
        panouMaster.add(Box.createRigidArea(new Dimension(0, 20)));
        panouNume.setAlignmentX(Component.CENTER_ALIGNMENT);
        panouMaster.add(panouNume);
        panouMaster.add(Box.createRigidArea(new Dimension(0, 20)));
        panouIntroducereDate.setAlignmentX(Component.CENTER_ALIGNMENT);
        panouMaster.add(panouIntroducereDate);
        panouMaster.add(Box.createRigidArea(new Dimension(0, 20)));
        panouButoane.setAlignmentX(Component.CENTER_ALIGNMENT);
        panouMaster.add(panouButoane);

    }

    public void addAdunareListener(ActionListener a) {
        butonAdunare.addActionListener(a);
    }

    public void addScadereListener(ActionListener a) {
        butonScadere.addActionListener(a);
    }

    public void addInmultireListener(ActionListener a) {
        butonInmultire.addActionListener(a);
    }

    public void addImpartireListener(ActionListener a) {
        butonImpartire.addActionListener(a);
    }

    public void addIntegrareListener(ActionListener a) {
        butonIntegrare.addActionListener(a);
    }

    public void addDerivareListener(ActionListener a) {
        butonDerivare.addActionListener(a);
    }

    public void addResetListener(ActionListener a) {
        butonReset.addActionListener(a);
    }

    public void addQuitListener(ActionListener a) {
        butonQuit.addActionListener(a);
    }

    public String getOperand1() {
        return this.primulOperand.getText();
    }

    public String getOperand2() {
        return this.alDoileaOperand.getText();
    }

    public void resetOperand() {
        this.primulOperand.setText("");
        this.alDoileaOperand.setText("");
        this.rezultatOperatie.setText("Rezultatul o sa apara aici");
    }

    public void quitAplicatie() {
        this.dispose();
    }

    public void setSemn(String s) {
        this.semnulOperatiei.setText(s);
    }

    public void schimbareRezultat(String s) {
        this.rezultatOperatie.setText(s);
    }
}
