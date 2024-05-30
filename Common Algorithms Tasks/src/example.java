public class example {

    // sort elements of an array in ascending order
    public static void main(String args[]) {
        String[] a = new String[]{"Sam", "Claudia", "Josh", "Toby", "Donna"};
        int[] b = new int[]{1, 2, 3, 4, 5};

        System.out.println(" ");

        java.util.Arrays.sort(a);

        for (int n = 0; n < 5; n++) {
            System.out.print(a[n] + " by ");
            System.out.println(b[n]);
        }
    }
}