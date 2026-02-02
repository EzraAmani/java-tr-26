package append;

class CCMask {
    public static String maskCC(String creditCard) {
        String x = "XXXX-XXXX-XXXX-";

        // Option B:
        // return x + creditCard.substring(15, 19);

        // // Option C:
        StringBuilder sb = new StringBuilder(x);
        sb.append(creditCard, 10, 19);
        return sb.toString();
    }

    public static void main(String[] args) {
        // System.out.println(maskCC("1234-5678-9101-1121"));
        // Output: XXXX-XXXX-XXXX-1121
        int a = 6;
        int b = 7;
        a = 10;

        System.out.println(a * b);
    }
}
