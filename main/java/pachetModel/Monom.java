package pachetModel;

import java.util.Objects;

public abstract class Monom<E> {
    private int putere;
    private E coeficient;

    public Monom() {
    }

    public Monom(int putere, E coeficient) {
        this.putere = putere;
        this.coeficient = coeficient;
    }

    public abstract Monom<E> adunareMonom(Monom<E> m1);

    public abstract Monom<E> scadereMonom(Monom<E> m1);

    public abstract Monom<E> inmultireMonom(Monom<E> m1);


    public Monom<E> impartireMonom(Monom<E> m1) {
        return null;
    }

    public Monom<E> derivareMonom() {
        return null;
    }

    public Monom<E> integrareMonom() {
        return null;
    }


    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public E getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(E coeficient) {
        this.coeficient = coeficient;
    }

    @Override
    public String toString() {
        return coeficient + "*X^" + putere;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monom<?> monom = (Monom<?>) o;
        return putere == monom.putere && Objects.equals(coeficient, monom.coeficient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(putere, coeficient);
    }
}
