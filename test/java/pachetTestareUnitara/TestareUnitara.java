package pachetTestareUnitara;

import pachetModel.MonoDouble;
import pachetModel.Monom;
import pachetModel.MonomInt;
import pachetModel.Polinom;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestareUnitara extends TestCase {

    public void testAdunare() {
        String s = "6*X^7+ 6*X^2 + 8*X^1 + 3*X^0";
        s = s.replaceAll("\\s+", "");
        s = s.replace("-", "+-");
        List<Monom> coefs1 = Polinom.convertirePolinomNou(s);
        assert coefs1 != null;
        Polinom p1 = new Polinom(coefs1);
        String s1 = "12*X^7+ 3*X^2 + 7*X^1 + 2*X^0 ";
        s1 = s1.replaceAll("\\s+", "");
        s1 = s1.replace("-", "+-");
        List<Monom> coefs2 = Polinom.convertirePolinomNou(s1);
        Polinom p2 = new Polinom(coefs2);
        p2 = p1.adunarePolinom(p2);
        String rezultat = p2.afisarePolinomNou();
        assertEquals(rezultat, "18*X^7+9*X^2+15*X^1+5*X^0");
    }

    public void testScadere() {
        String s = "6*X^7+ 6*X^2 + 8*X^1 + 3*X^0";
        s = s.replaceAll("\\s+", "");
        s = s.replace("-", "+-");
        List<Monom> coefs1 = Polinom.convertirePolinomNou(s);
        assert coefs1 != null;
        Polinom p1 = new Polinom(coefs1);
        String s1 = "12*X^7+ 3*X^2 + 7*X^1 + 2*X^0 ";
        s1 = s1.replaceAll("\\s+", "");
        s1 = s1.replace("-", "+-");
        List<Monom> coefs2 = Polinom.convertirePolinomNou(s1);
        Polinom p2 = new Polinom(coefs2);
        p2 = p1.scaderePolinom(p2);
        String rezultat = p2.afisarePolinomNou();
        assertEquals(rezultat, "-6*X^7+3*X^2+1*X^1+1*X^0");
    }

    public void testInmultire() {
        String s = "6*X^7+ 6*X^2 + 8*X^1 + 3*X^0";
        s = s.replaceAll("\\s+", "");
        s = s.replace("-", "+-");
        List<Monom> coefs1 = Polinom.convertirePolinomNou(s);
        assert coefs1 != null;
        Polinom p1 = new Polinom(coefs1);
        String s1 = "12*X^7+ 3*X^2 + 7*X^1 + 2*X^0 ";
        s1 = s1.replaceAll("\\s+", "");
        s1 = s1.replace("-", "+-");
        List<Monom> coefs2 = Polinom.convertirePolinomNou(s1);
        Polinom p2 = new Polinom(coefs2);
        p2 = p1.inmultirePolinom(p2);
        String rezultat = p2.afisarePolinomNou();
        assertEquals(rezultat, "72*X^14+90*X^9+138*X^8+48*X^7+18*X^4+66*X^3+77*X^2+37*X^1+6*X^0");
    }

    public void testDerivare() {
        String s = "6*X^7+ 6*X^2 + 8*X^1 + 3*X^0";
        s = s.replaceAll("\\s+", "");
        s = s.replace("-", "+-");
        List<Monom> coefs1 = Polinom.convertirePolinomNou(s);
        assert coefs1 != null;
        Polinom p1 = new Polinom(coefs1);
        p1 = p1.derivarePolinom();
        String rezultat = p1.afisarePolinomNou();
        assertEquals(rezultat, "42*X^6+12*X^1+8*X^0+0*X^-1");
    }

    public void testIntegrare() {
        String op1 = "6*X^7+ 6*X^2 + 8*X^1 + 3*X^0";
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
        assertEquals(rezultat, "0.86*X^8+3.0*X^3+8.0*X^2+3.0*X^1");
    }

    public void testCrearePolinom() {
        String s = "6*X^7+ 6*X^2 + 8*X^1 + 3*X^0";
        s = s.replaceAll("\\s+", "");
        s = s.replace("-", "+-");
        List<Monom> coefs1 = Polinom.convertirePolinomNou(s);
        assert coefs1 != null;
        Polinom p1 = new Polinom(coefs1);
        String rezultat = p1.afisarePolinomNou();
        Monom<Integer> m1 = new MonomInt(0, 3);
        Monom<Integer> m2 = new MonomInt(1, 8);
        Monom<Integer> m3 = new MonomInt(2, 6);
        Monom<Integer> m4 = new MonomInt(7, 6);
        List<Monom> lista = new ArrayList<>(Arrays.asList(m1, m2, m3, m4));
        Polinom p = new Polinom(lista);
        String rezultat2 = p.afisarePolinomNou();
        assertEquals(rezultat, rezultat2);
    }
}
