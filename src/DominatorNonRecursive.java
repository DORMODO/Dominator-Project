public class DominatorNonRecursive {
    public static int findDominator(int[] A) {

        if (A.length == 0)
            return -1;

        int candidate = A[0], count = 1, candidateIndex = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = A[i];
                    candidateIndex = i;
                    count = 1;
                }
            }
        }

        count = 0;
        for (int value : A) {
            if (value == candidate) {
                count++;
            }
        }

        return count > A.length / 2 ? candidateIndex : -1;
    }
}