import java.util.Objects;

public class Interval {
    int i, j;

    public Interval() {
    }

    public Interval(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval interval)) return false;
        return getI() == interval.getI() && getJ() == interval.getJ();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getI(), getJ());
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
