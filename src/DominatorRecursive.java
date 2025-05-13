public class DominatorRecursive {
    public static int findDominator(int[] A) {
        if (A.length == 0)
            return -1;
        return findDominatorRecursive(A, 0, A.length - 1);
    }

    private static int findDominatorRecursive(int[] A, int left, int right) {
        if (left == right)
            return left;

        int mid = left + (right - left) / 2;
        int leftIndex = findDominatorRecursive(A, left, mid);
        int rightIndex = findDominatorRecursive(A, mid + 1, right);

        int leftValue = leftIndex != -1 ? A[leftIndex] : Integer.MIN_VALUE;
        int rightValue = rightIndex != -1 ? A[rightIndex] : Integer.MIN_VALUE;

        int leftCount = 0, rightCount = 0;
        for (int i = left; i <= right; i++) {
            if (A[i] == leftValue)
                leftCount++;
            if (A[i] == rightValue)
                rightCount++;
        }

        int threshold = (right - left + 1) / 2;
        if (leftCount > threshold)
            return leftIndex;
        if (rightCount > threshold)
            return rightIndex;

        return -1;
    }
}