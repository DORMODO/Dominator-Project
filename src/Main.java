public class Main {
    public static void main(String[] args) {
        int[] A = { 3, 4, 3, 2, 3, -1, 3, 3 };

        // Test Recursive solution
        int result1 = DominatorRecursive.findDominator(A);
        System.out.println("Recursive Solution Result: " + result1);

        // Test Non-Recursive solution
        int result2 = DominatorNonRecursive.findDominator(A);
        System.out.println("NonRecursive Solution Result: " + result2);
    }
}
