import javax.script.ScriptException;

/**
 * Created by ninise on 10.11.15.
 */
public class Print extends Operator {

    public Print(String code) {
        super(code);
    }

    @Override
    public void exex(Interpreter inter) {
        Object result = null;
        try {
            result = Expression.eval(inter.getVars(), code);
            System.out.println(result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        inter.next();
    }
}
