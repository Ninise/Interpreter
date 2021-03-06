abstract public class Operator {

    String code;

    public Operator(String code) {
        this.code = code;
    }

    abstract public void exex(Interpreter inter);

    @Override
    public String toString() {
        return getClass().getName() + " " + code;
    }
}
