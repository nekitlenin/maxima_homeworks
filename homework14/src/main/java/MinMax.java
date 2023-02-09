/**
 * Project: homework14
 *
 * @author nikita
 * Email:  nekitlenin@gmail.com |
 * Create: 08.02.2023 17:37 |
 * Created with IntelliJ IDEA
 */
public class MinMax<I, A> {
    private I min;
    private A max;

    public MinMax(I min, A max) {
        this.min = min;
        this.max = max;
    }

    public I getMin() {
        return min;
    }

    public A getMax() {
        return max;
    }

    public void setMin(I min) {
        this.min = min;
    }

    public void setMax(A max) {
        this.max = max;
    }
}
