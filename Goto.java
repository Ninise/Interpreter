/**
 * Created by ninise on 10.11.15.
 */
public class Goto extends Operator {
    public Goto(String code) {
        super(code);
    }

    @Override
    public void exex(Interpreter inter) {
        inter.goTo(Integer.parseInt(code));
    }
}
