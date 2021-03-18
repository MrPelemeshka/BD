//Рекурсивный компилятор формул.
public class RecursCompf {
    private static final int DEFSIZE = 255;
    private char[] str;
    private int index;
    private String test;

    private void compileF() {
        if(str[index] == '\n') {
            index++;
        }
        compileT();

        if (index >= str.length)
            return;

        if (str[index] == '+') {
            index++;
            compileF();
            test += "+";
            System.out.print("+");
            return;
        }

        if (str[index] == '-') {
            index++;
            compileF();
            test += "-";
            System.out.print("-");
        }
    }

    private void compileT() {
        if(str[index] == '\n') {
            index++;
        }
        compileM();

        if (index >= str.length)
            return;
        if(str[index] == '\n') {
            index++;
        }

        if (str[index] == '*') {
            index++;
            compileT();
            test += "*";
            System.out.print("*");
            return;
        }

        if (str[index] == '/') {
            index++;
            compileT();
            test += "/";
            System.out.print("/");
        }
    }

    private void compileM() {
        if(str[index] == '\n') {
            index++;
        }

        if (str[index] == '(') {
            index++;
            compileF();
            index++;
        } else
            compileV();
    }

    private void compileV() {
        if(str[index] == '\n') {
            index++;
        }
        test += "" + str[index] + " ";
        System.out.print("" + str[index++] + " ");
    }

    public void RecursCompf() {
        str = new char[DEFSIZE];
    }

    public String compile(char[] str) {
        this.test = "";
        this.str = str;
        index = 0;
        compileF();
        System.out.print("\n");
        return this.test;
    }
}