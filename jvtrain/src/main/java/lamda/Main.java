package lamda;

public class Main {
    public static void main(String[] args) {
        Export pdfExport = new PdfExport();
        pdfExport.export("I have learnt interesting topics");

        Export powerPoint = new PptExport();
        powerPoint.export("I am becoming.....");

        // anonymous implementation

        Export htmlExport = new Export() {
            public void export(String content) {
                System.out.println("Exporting to HTML " + content);

            }

        };

        htmlExport.export("Java is awesome though challenging");

        Export pngExport = (content) -> System.out.println("Exporting to HTML " + content);
        pngExport.export("This is an awesome image");

        Printer printerInLamda = (content, path) -> {

            System.out.println("Printing " + content + " to " + path);
            return "success";

        };

        printerInLamda.print("love", "flash");

    }

}
