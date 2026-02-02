package exceptions.Part2;

//import java.io.IOException;

class X {
    public void printFileContent(int a) throws IOException { // ✅ C
        /* code goes here */
        if (a == 6) {
            System.out.println("Congratulations");
        } else {
            throw new IOException("failure....");
            // any code that comes after this will not work as the system is crashed
        }
    }

    public void setme() {
        System.out.println("I love my life");
    }
}
