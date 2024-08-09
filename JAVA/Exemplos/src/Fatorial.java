public class Fatorial {

    public static void main(String[] args) {

        for (int i=0; i<100; i++) {
            int a = fatIt(i);
            int b = fatRec(i);

            String iStr = Integer.toString(i);
            String aStr = Integer.toString(a);
            String bStr = Integer.toString(b);

            System.out.println(iStr + " - " + aStr + " - " + bStr);

        }
        
    }

    public static int fatIt(int n) {
        int rv = 1;

        for (int i=1; i<=n; i++) {
            rv = i*rv;
        }
        return rv;
    }

    public static int fatRec(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n*fatRec(n-1);
        }
    }

}
