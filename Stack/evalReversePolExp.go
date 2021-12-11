/**
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. 
That means the expression would always evaluate to a result, and there will not be any division by zero operation.

Example:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

*/

func evalRPN(tokens []string) int {
    st := make([]int, 0)
    
    for _, tok := range tokens {
        if operand, ok := isOperand(tok); ok {
            st = append(st, operand)
            continue
        }
        
        op1, op2 := st[len(st)-2], st[len(st)-1]
        st = st[:len(st)-2]
        
        res := operate(op1, op2, tok)
        st = append(st, res)
    }
    
    return st[0]
}

func isOperand(s string) (int, bool) {
    op, err := strconv.Atoi(s)
    if err != nil {
        return 0, false
    }
    
    return op, true
}

func operate(op1, op2 int, operation string) int {
    switch operation {
        case "+":
            return op1 + op2
        case "-":
            return op1 - op2
        case "*":
            return op1 * op2
        case "/":
            return op1 / op2
        default:
            return 0
    }
}
