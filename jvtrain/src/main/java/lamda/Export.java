package lamda;

public interface Export {

    // a functional interface has only one abstract method

    void export(String content);

    default void print(String content) {

    }

    static void countPages() {

    }

    private void showInfo() {

    }

}