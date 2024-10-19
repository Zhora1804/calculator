import java.io.IOException;
import java.util.Scanner;

public class Main {public static String[] calc(String input) throws IOException {
    String[] calc = input.split(" ");
    if (calc.length > 3 )
        throw new IOException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор.");
    else if (calc.length <= 1)
        throw new IOException("Cтрока не является математической операцией.");
    else if (calc.length != 3)
        throw new IOException ("Неверный формат выражения. Введите выражение, разделяя каждый символ пробелом.");
    return calc;
}
    public static void main(String[] args) throws IOException {
        Scanner inputString = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = inputString.nextLine();
        while (!input.isEmpty()) {
            String[] calc_inputString;
            calc_inputString = calc(input);
            String operation = calc_inputString[1];
            Operands values;
            int value1 = Integer.parseInt(calc_inputString[0]);
            int value2 = Integer.parseInt(calc_inputString[2]);
            values = new Operands(value1, value2);
            switch (operation) {
                case "+":
                    values.sum();
                    break;
                case "-":
                    values.sub();
                    break;
                case "/":
                    values.div();
                    break;
                case "*":
                    values.mul();
                    break;
                default:
                    throw new IOException("ни один из оператораторов не определен (+, -, /, *).");
            }
            System.out.println("Ответ: " + values.getResult());
            break;
        }
    }
}
class Operands {
    private int value1;
    private int value2;
    private int result;
    public boolean condition(int value1) throws IOException {
        if(value1 >= 1 && value1 <= 10)
            return true;
        else if(value1 < 1)
            throw new IOException ("первый операнд меньше 1 (см. требования).");
        else if(value1 > 10)
            throw new IOException ("первый операнд больше 10 (см. требования).");
        return false;
    }
    public boolean condition1(int value2) throws IOException {
        if(value2 >= 1 && value2 <= 10)
            return true;
        else if(value2 < 1)
            throw new IOException ("второй операнд меньше 1 (см. требования).");
        else if(value2 > 10)
            throw new IOException ("второй операнд больше 10 (см. требования).");
        return false;
    }
    public Operands(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
    public void sum() throws IOException {
        if (condition(value1) && condition1(value2)) {
            result = value1 + value2;
        }
    }
    public void sub() throws IOException {
        if (condition(value1) && condition1(value2)){
            result = value1 - value2;
        }
    }
    public void div() throws IOException {
        if (condition(value1) && condition1(value2)){
            result = value1 / value2;
        }
    }
    public void mul() throws IOException {
        if (condition(value1) && condition1(value2)){
            result = value1 * value2;
        }
    }
    public int getResult() throws IOException {
        if (result < 0){
            throw new IOException("Результат должен быть положительным.");
        }
        return result;
    }
}