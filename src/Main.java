public class Main {
    public static void main(String[] args) {
        int[] A = { 5, 6 };

        // Test Recursive solution
        int result1 = DominatorRecursive.findDominator(A);
        System.out.println("\nRecursive Solution Result: " + result1);

        // Test Non-Recursive solution
        int result2 = DominatorNonRecursive.findDominator(A);
        System.out.println("NonRecursive Solution Result: " + result2);
    }
}
