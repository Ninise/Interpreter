import javax.script.ScriptException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class If extends Operator {

    public If(String code) {
        super(code);
    }

    @Override
    public void exex(Interpreter inter) {
        Pattern pattern = Pattern.compile("(.*) THEN GOTO (.*)");
        Matcher matcher = pattern.matcher(code);

        inter.next();

        if (!matcher.find()) {
            System.out.println("Bad operator if");
        } else {
            String cond = matcher.group(1);
            int line  = Integer.parseInt(matcher.group(2));

            try {
                Object res = Expression.eval(inter.getVars(), cond.replace("=","=="));
                if (res instanceof Boolean && res.equals(true)) {
                    inter.goTo(line);
                }
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }
    }
}
