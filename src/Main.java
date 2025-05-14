public class Main {
    public static void main(String[] args) {
        int[] A = { 3, 4, 3, 2, 3, -1, 3, 3 }; // Dominator
        int[] B = { 3, 4, 3, 2, 3, -1, 1, 1 }; // No Dominator

        // Test Recursive
        int result1 = DominatorRecursive.findDominator(A);
        System.out.println("\nRecursive Solution Result: " + result1);

        // Test Non-Recursive
        int result2 = DominatorNonRecursive.findDominator(B);
        System.out.println("Non-Recursive Solution Result: " + result2);
    }
}
