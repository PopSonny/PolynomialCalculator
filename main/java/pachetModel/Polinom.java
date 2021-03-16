package pachetModel;

import java.util.*;

public class Polinom {

    private final Map<Integer, Monom> pol = new TreeMap<>();
    private int grad;

    public Polinom(List<Monom> lista) {
        int putere = 0;
        for (Monom m : lista) {
            putere = m.getPutere();
            pol.put(putere, m);
        }
        this.grad = putere;
    }

    public Polinom adunarePolinom(Polinom p) {
        Map<Integer, Monom> aux = p.getPol();
        for (Monom m : pol.values()) {
            if (aux.containsKey(m.getPutere())) {
                aux.put(m.getPutere(), pol.get(m.getPutere()).adunareMonom(aux.get(m.getPutere())));
            } else
                p.appendMonom(m);
        }
        return p;
    }

    public Polinom scaderePolinom(Polinom p) {
        Map<Integer, Monom> aux = p.getPol();
        for (Monom m : pol.values()) {
            if (aux.containsKey(m.getPutere())) {
                aux.put(m.getPutere(), pol.get(m.getPutere()).scadereMonom(aux.get(m.getPutere())));
            } else
                p.appendMonom(m);
        }
        for (Monom m : p.getPol().values()) {
            if (!this.pol.containsKey(m.getPutere())) {
                int minusI = 0;
                double minusD = 0;
                if (m instanceof MonomInt)
                    minusI = (int) m.getCoeficient();
                else
                    minusD = (double) m.getCoeficient();
                minusI *= (-1);
                minusD *= (-1);

                Monom mMinus = null;

                if (m instanceof MonomInt)
                    mMinus = new MonomInt(m.getPutere(), minusI);
                else
                    mMinus = new MonoDouble(m.getPutere(), minusD);

                p.getPol().put(m.getPutere(), mMinus);
            }
        }
        return p;
    }

    public Polinom inmultirePolinom(Polinom p) {
        Polinom returnat = new Polinom(new ArrayList<>());
        Map<Integer, Monom> aux = p.getPol();
        for (Monom m1 : pol.values()) {
            for (Monom m2 : aux.values()) {
                Monom m3 = m1.inmultireMonom(m2);
                if (returnat.getPol().containsKey(m3.getPutere())) {
                    returnat.getPol().put(m3.getPutere(), returnat.getPol().get(m3.getPutere()).adunareMonom(m3));
                } else
                    returnat.appendMonom(m3);
            }
        }
        return returnat;
    }

    public String impartirePolinom(Polinom d) {
        Polinom q = new Polinom(new ArrayList<>());
        Polinom r = this;

        for (Monom m1 : r.getPol().values()) {
            r.setGrad(m1.getPutere());
        }
        for (Monom m1 : d.getPol().values()) {
            d.setGrad(m1.getPutere());
        }
        while (!r.getPol().isEmpty() && r.grad >= d.grad) {
            Monom monomR = null;
            Monom monomD = null;
            for (Monom m1 : r.getPol().values()) {
                monomR = m1;
            }
            for (Monom m1 : d.getPol().values()) {
                monomD = m1;
            }

            Monom rezultat = monomR.impartireMonom(monomD);

            // t ← lead(r) / lead(d);
            List<Monom> lista = new ArrayList<>(Arrays.asList(rezultat));
            Polinom t = new Polinom((lista));
            q = q.adunarePolinom(t);
            Polinom aux = t.inmultirePolinom(d);
            r = r.scaderePolinom(aux);
            q.refacerePolinom();
            r.refacerePolinom();

        }
        String s = q.afisarePolinomNou() + " si restul " + r.afisarePolinomNou();
        return s;
    }

    public Polinom derivarePolinom() {
        Polinom returnat = new Polinom(new ArrayList<>());
        for (Monom m : pol.values()) {
            returnat.appendMonom(m.derivareMonom());
        }
        return returnat;
    }

    public Polinom integrarePolinom() {
        Polinom returnat = new Polinom(new ArrayList<>());
        for (Monom m : pol.values()) {
            returnat.appendMonom(m.integrareMonom());
        }
        return returnat;
    }


    public void appendMonom(Monom m) {
        if (m.getPutere() > this.grad) {
            this.grad = m.getPutere();
        }
        pol.put(m.getPutere(), m);
    }

    public String afisarePolinomNou() {
        String s = "";

        for (Monom m : pol.values()) {
            s = m.toString() + "+" + s;
        }
        s = s.substring(0, s.length() - 1);
        s = s.replace("+-", "-");
        return s;
    }

    public static List<Monom> convertirePolinomNou(String s) {
        List<Monom> listaMonom = new ArrayList<>();
        s = s.replaceAll("\\s+", "");
        s = s.replace("-", "+-");
        if (s.charAt(0) == '+') {
            s = s.substring(1);
        }
        try {
            for (String aux : s.split("\\+")) {
                String[] cp = aux.split("\\*");
                int coeficient = Integer.parseInt(cp[0].trim());
                int putere = Integer.parseInt(cp[1].split("\\^")[1].trim());
                Monom m = new MonomInt(putere, coeficient);
                listaMonom.add(m);
            }
            return listaMonom;
        } catch (Exception e) {
            System.out.println("Gresit input");
        }
        return null;
    }


    public Map<Integer, Monom> getPol() {
        return pol;
    }

    public int getGrad() {
        return grad;
    }

    public void refacerePolinom() {
        for (Monom m : this.pol.values()) {
            MonoDouble aux = (MonoDouble) m;
            if (aux.getCoeficient() == 0.0) {
                int put = m.getPutere();
                this.pol.remove(put);
            }
        }
        for (Monom m : this.pol.values()) {
            this.setGrad(m.getPutere());
        }
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polinom that = (Polinom) o;
        return grad == that.grad && Objects.equals(pol, that.pol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pol, grad);
    }

}
