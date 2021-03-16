package pachetController;

import pachetModel.MonoDouble;
import pachetModel.Monom;
import pachetModel.Polinom;
import pachetView.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controllerv2 {
    private final View v;

    public Controllerv2(View v) {
        this.v = v;

        this.v.addAdunareListener(new AdunareC());
        this.v.addScadereListener(new ScadereC());
        this.v.addImpartireListener(new ImpartireC());
        this.v.addInmultireListener(new InmultireC());
        this.v.addIntegrareListener(new IntegrareC());
        this.v.addDerivareListener(new DerivareC());
        this.v.addResetListener(new ResetC());
        this.v.addQuitListener(new QuitC());
    }

    class AdunareC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String op1 = v.getOperand1();
                String op2 = v.getOperand2();
                List<Monom> coefs1 = Polinom.convertirePolinomNou(op1);
                List<Monom> coefs2 = Polinom.convertirePolinomNou(op2);
                Polinom p1 = null;
                Polinom p2 = null;
                if (coefs1 != null && coefs2 != null) {
                    p1 = new Polinom(coefs1);
                    p2 = new Polinom(coefs2);
                }
                assert p1 != null;
                p2 = p1.adunarePolinom(p2);
                String rezultat = p2.afisarePolinomNou();
                v.schimbareRezultat(rezultat);
                v.setSemn("+");
            } catch (Exception f) {
                JOptionPane.showMessageDialog(null, "Va rugam sa introduceti datele conform regulilor", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class ScadereC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String op1 = v.getOperand1();
                String op2 = v.getOperand2();
                List<Monom> coefs1 = Polinom.convertirePolinomNou(op1);
                List<Monom> coefs2 = Polinom.convertirePolinomNou(op2);
                Polinom p1 = null;
                Polinom p2 = null;
                if (coefs1 != null && coefs2 != null) {
                    p1 = new Polinom(coefs1);
                    p2 = new Polinom(coefs2);
                }
                assert p1 != null;
                p2 = p1.scaderePolinom(p2);
                String rezultat = p2.afisarePolinomNou();
                v.schimbareRezultat(rezultat);
                v.setSemn("-");
            } catch (Exception f) {
                JOptionPane.showMessageDialog(null, "Va rugam sa introduceti datele conform regulilor", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class InmultireC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String op1 = v.getOperand1();
                String op2 = v.getOperand2();
                List<Monom> coefs1 = Polinom.convertirePolinomNou(op1);
                List<Monom> coefs2 = Polinom.convertirePolinomNou(op2);
                Polinom p1 = null;
                Polinom p2 = null;
                if (coefs1 != null && coefs2 != null) {
                    p1 = new Polinom(coefs1);
                    p2 = new Polinom(coefs2);
                }
                assert p1 != null;
                p2 = p1.inmultirePolinom(p2);
                String rezultat = p2.afisarePolinomNou();
                v.schimbareRezultat(rezultat);
                v.setSemn("*");
            } catch (Exception f) {
                JOptionPane.showMessageDialog(null, "Va rugam sa introduceti datele conform regulilor", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class ImpartireC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String op1 = v.getOperand1();
                List<Monom> coefs1 = Polinom.convertirePolinomNou(op1);
                List<Monom> coefs1Double = new ArrayList<>();
                for (Monom m : coefs1) {
                    int putere = m.getPutere();
                    int coeI = (int) m.getCoeficient();
                    double coeDo = (double) coeI;
                    Monom<Double> m1 = new MonoDouble(putere, coeDo);
                    coefs1Double.add(m1);
                }
                Polinom p1 = null;
                p1 = new Polinom(coefs1Double);


                String op2 = v.getOperand2();
                List<Monom> coefs2 = Polinom.convertirePolinomNou(op2);
                List<Monom> coefs2Double = new ArrayList<>();
                for (Monom m : coefs2) {
                    int putere = m.getPutere();
                    int coeI = (int) m.getCoeficient();
                    double coeDo = (double) coeI;
                    Monom<Double> m1 = new MonoDouble(putere, coeDo);
                    coefs2Double.add(m1);
                }
                Polinom p2 = null;
                p2 = new Polinom(coefs2Double);
                String s = p1.impartirePolinom(p2);
                String rezultat = s;
                v.schimbareRezultat(rezultat);
                v.setSemn("/");
            } catch (Exception f) {
                JOptionPane.showMessageDialog(null, "Va rugam sa introduceti datele conform regulilor", "ERROR", JOptionPane.ERROR_MESSAGE);
                f.printStackTrace();
            }
        }
    }

    class IntegrareC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String op1 = v.getOperand1();
                List<Monom> coefs1 = Polinom.convertirePolinomNou(op1);
                List<Monom> coefs1Double = new ArrayList<>();
                for (Monom m : coefs1) {
                    int putere = m.getPutere();
                    int coeI = (int) m.getCoeficient();
                    double coeDo = (double) coeI;
                    Monom<Double> m1 = new MonoDouble(putere, coeDo);
                    coefs1Double.add(m1);
                }
                Polinom p1 = null;
                p1 = new Polinom(coefs1Double);
                p1 = p1.integrarePolinom();
                String rezultat = p1.afisarePolinomNou();
                v.schimbareRezultat(rezultat);
                v.setSemn("Sdx");
            } catch (Exception f) {
                JOptionPane.showMessageDialog(null, "Va rugam sa introduceti datele conform regulilor", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class DerivareC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String op1 = v.getOperand1();
                List<Monom> coefs1 = Polinom.convertirePolinomNou(op1);
                Polinom p1 = null;
                if (coefs1 != null) {
                    p1 = new Polinom(coefs1);
                }
                assert p1 != null;
                p1 = p1.derivarePolinom();
                p1.getPol().remove(-1);
                String rezultat = p1.afisarePolinomNou();
                v.schimbareRezultat(rezultat);
                v.setSemn("dy/dx");
            } catch (Exception f) {
                JOptionPane.showMessageDialog(null, "Va rugam sa introduceti datele conform regulilor", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class ResetC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                v.resetOperand();
                v.setSemn("Semn");
            } catch (Exception f) {
                f.printStackTrace();
            }
        }
    }

    class QuitC implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                v.quitAplicatie();
            } catch (Exception f) {
                f.printStackTrace();
            }
        }
    }
}
