public class DominatorRecursive {
    // Method to find the dominator using a recursive approach
    // دالة للعثور على المسيطر باستخدام النهج التكراري
    public static int findDominator(int[] A) {
        // If the array is empty, return -1 (no dominator)
        // إذا كانت المصفوفة فارغة، يرجع -1 (لا يوجد مسيطر)
        if (A.length == 0)
            return -1;
        return findDominatorRecursive(A, 0, A.length - 1);
    }

    // Helper method for recursive dominator finding
    // دالة مساعدة للعثور على المسيطر بشكل تكراري
    private static int findDominatorRecursive(int[] A, int left, int right) {
        // Base case: single element, return its index
        // الحالة الأساسية: عنصر واحد، يرجع الفهرس الخاص به
        if (left == right) {
            return left;
        }

        // Divide the array into two halves
        // تقسيم المصفوفة إلى نصفين
        int mid = left + (right - left) / 2;
        int leftIndex = findDominatorRecursive(A, left, mid);
        int rightIndex = findDominatorRecursive(A, mid + 1, right);

        // Get the values of the candidates from both halves
        // الحصول على قيم المرشحين من النصفين
        int leftValue = leftIndex != -1 ? A[leftIndex] : Integer.MIN_VALUE;
        int rightValue = rightIndex != -1 ? A[rightIndex] : Integer.MIN_VALUE;

        // If one side has no candidate, return the other
        // إذا كان أحد الأطراف لا يحتوي على مرشح، يتم إرجاع الآخر
        if (leftValue == Integer.MIN_VALUE)
            return rightIndex;
        if (rightValue == Integer.MIN_VALUE)
            return leftIndex;

        // Count occurrences of both candidates in the full range
        // عد تكرار كل مرشح في النطاق الكامل
        int leftCount = 0, rightCount = 0;
        for (int i = left; i <= right; i++) {
            if (A[i] == leftValue)
                leftCount++;
            if (A[i] == rightValue)
                rightCount++;
        }

        // Determine if either candidate is a dominator
        // تحديد إذا كان أحد المرشحين هو المسيطر
        int threshold = (right - left + 1) / 2;
        if (leftCount > threshold)
            return leftIndex;
        if (rightCount > threshold)
            return rightIndex;

        // No dominator found
        // لم يتم العثور على مسيطر
        return -1;
    }
}