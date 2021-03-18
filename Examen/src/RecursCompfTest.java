import java.util.Scanner;

//Тест для рекурсивного компилятора формул.
public class RecursCompfTest{
    public static void main(String[] args) throws Exception{
        RecursCompf c = new RecursCompf();

        Scanner in = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        while(true){
            System.out.print("Введите формулу -> ");
            while (true)
            {
                String s = in.next();
                if (s.contains(";")) {
                    str.append(s + "\n");
                    break;
                }
                else {
                    str.append(s + "\n");

                }
            }
            c.compile(str.toString().toCharArray());
        }
    }
}