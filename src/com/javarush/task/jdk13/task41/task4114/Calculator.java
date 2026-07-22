package com.javarush.task.jdk13.task41.task4114;

import java.util.HashMap;
import java.util.Map;

public class Calculator {
    private final Map<String, Operation> operationMap;
    public Calculator() {
        Processor processor = new Processor();
        operationMap = new HashMap<>();
        operationMap.put("+", processor::plus);
        operationMap.put("-", processor::minus);
        operationMap.put("*", processor::multiply);
        operationMap.put("/", processor::divide);
    }

        public void calculate (int x, String operation, int y){
            Operation op = operationMap.get(operation);
            if (op == null) {
                throw new IllegalStateException("no operation registered for '" + operation + "'");
            }
            op.execute(x, y);
        }
    }

