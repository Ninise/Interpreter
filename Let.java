import javax.script.ScriptException;

/**
 * Created by ninise on 10.11.15.
 */
public class Let extends Operator {
    public Let(String code) {
        super(code);
    }

    @Override
    public void exex(Interpreter inter) {
        String[] parts = code.split("=");
        try {
            Object val = Expression.eval(inter.getVars(), parts[1]);
            inter.getVars().put(parts[0],Double.parseDouble(val.toString()));
        } catch (ScriptException e) {
            e.printStackTrace();
        }

        inter.next();
    }
}
