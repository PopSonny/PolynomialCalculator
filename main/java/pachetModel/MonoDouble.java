package pachetModel;

public class MonoDouble extends Monom<Double> {

    public MonoDouble() {
    }

    public MonoDouble(int putere, Double coeficient) {
        super(putere, coeficient);
    }

    @Override
    public Monom<Double> adunareMonom(Monom<Double> m1) {
        return null;
    }

    @Override
    public Monom<Double> scadereMonom(Monom<Double> m1) {
        return new MonoDouble(this.getPutere(), this.getCoeficient() - m1.getCoeficient());
    }

    @Override
    public Monom<Double> inmultireMonom(Monom<Double> m1) {
        return new MonoDouble(this.getPutere() + m1.getPutere(), this.getCoeficient() * m1.getCoeficient());
    }

    @Override
    public Monom<Double> integrareMonom() {
        int a = this.getPutere();
        if (this.getPutere() != 0)
            return new MonoDouble(a + 1, Math.round((this.getCoeficient() / this.getPutere()) * 100.0) / 100.0);
        else
            return new MonoDouble(a + 1, this.getCoeficient());
    }

    @Override
    public Monom<Double> impartireMonom(Monom<Double> m1) {
        return new MonoDouble(this.getPutere() - m1.getPutere(), this.getCoeficient() / m1.getCoeficient());
    }
}
