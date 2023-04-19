package calc.operation;

public class SubtractOperation implements Operation {
    private final Operation arg1;
    private final Operation arg2;

    public SubtractOperation(Number arg1, Number arg2) {
        this(new ConstOperation(arg1), new ConstOperation(arg2));
    }

    public SubtractOperation(Operation arg1, Number arg2) {
        this(arg1, new ConstOperation(arg2));
    }

    public SubtractOperation(Operation arg1, Operation arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    private Number subNumber(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() - b.doubleValue();
        } else if (a instanceof Float || b instanceof Float) {
            return a.floatValue() - b.floatValue();
        } else if (a instanceof Long || b instanceof Long) {
            return a.longValue() - b.longValue();
        } else {
            return a.intValue() - b.intValue();
        }
    }

    @Override
    public Number operate() {
        return subNumber(arg1.operate(), arg2.operate());

    }
}
