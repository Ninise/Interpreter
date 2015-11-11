import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Map;

/**
 * Created by ninise on 10.11.15.
 */
public class Expression {
    public static Object eval(Map<String, Double> vars, String code) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        for (String var : vars.keySet()) {
            code = code.replace(var, vars.get(var).toString());
        }
        return engine.eval(code);
    }
}
