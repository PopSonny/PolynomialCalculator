package pachetModel;

public class MonomInt extends Monom<Integer> {
    public MonomInt() {
    }

    public MonomInt(int putere, Integer coeficient) {
        super(putere, coeficient);
    }

    @Override
    public Monom<Integer> adunareMonom(Monom<Integer> m1) {
        return new MonomInt(this.getPutere(), this.getCoeficient() + m1.getCoeficient());
    }

    @Override
    public Monom<Integer> scadereMonom(Monom<Integer> m1) {
        return new MonomInt(this.getPutere(), this.getCoeficient() - m1.getCoeficient());
    }

    @Override
    public Monom<Integer> inmultireMonom(Monom<Integer> m1) {
        return new MonomInt(this.getPutere() + m1.getPutere(), this.getCoeficient() * m1.getCoeficient());
    }

    @Override
    public Monom<Integer> derivareMonom() {
        int a = this.getPutere();
        return new MonomInt(a - 1, this.getCoeficient() * this.getPutere());
    }
}
