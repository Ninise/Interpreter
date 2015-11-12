import javax.script.ScriptException;

public class Print extends Operator {

    public Print(String code) {
        super(code);
    }

    @Override
    public void exex(Interpreter inter) {
        Object result = null;

        inter.next();

        String trim = code.trim();
        if (trim.startsWith("\"")) {
            if (trim.endsWith(";")) {
                System.out.print(trim.substring(1, trim.length() - 2));
            } else {
                System.out.print(trim.substring(1, trim.length() - 1));
            }
            return;
        }

        try {
            result = Expression.eval(inter.getVars(), code);
            System.out.println(result);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
