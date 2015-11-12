import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Interpreter {

    private TreeMap<Integer, Operator> code = new TreeMap<>();
    private Map<String, Double> vars = new HashMap<>();

    private Integer curLine;

    public void run() {
        curLine = code.firstKey();
        while (true) {
            Operator operator = code.get(curLine);
            operator.exex(this);
            if (curLine == null) {
                break;
            }
        }
    }

    public void next() {
        curLine = code.higherKey(curLine);
    }

    public void goTo(int line) {
        curLine = line;
    }

    public void parse(String line) {
        if (line.equalsIgnoreCase("RUN")) {
            this.run();
            return;
        }

        if (line.equalsIgnoreCase("LIST")) {
            for (int lin : code.keySet()) {
                System.out.println(lin + " " + code.get(lin ));
            }
            return;
        }
        try {
            String parts[] = line.split(" ");
            int lineNumber = Integer.parseInt(parts[0]);
            String opName = parts[1];
            Operator operator = OperatorFactory.createOperator(opName,
                    line.substring(parts[0].length() + parts[1].length() + 2));
            code.put(lineNumber, operator);
        } catch (RuntimeException e) {
            System.out.println("Wrong operation!");
        }

    }

    public Map<String, Double> getVars() {
        return vars;
    }
}
