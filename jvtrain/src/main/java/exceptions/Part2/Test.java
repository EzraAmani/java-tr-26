package exceptions.Part2;

public class Test {
    public static void main(String[] args) throws Exception { // ✅ A
        X xobj = new X();
        xobj.printFileContent(6);
        xobj.setme();
    }
}