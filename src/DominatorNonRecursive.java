public class DominatorNonRecursive {
    // Method to find the dominator using a non-recursive approach
    // دالة للعثور على المسيطر باستخدام النهج غير التكراري
    public static int findDominator(int[] A) {
        // If the array is empty, return -1 (no dominator)
        // إذا كانت المصفوفة فارغة، يرجع -1 (لا يوجد مسيطر)
        if (A.length == 0)
            return -1;

        // Initialize the first candidate for dominator
        // تهيئة المرشح الأول ليكون المسيطر
        int candidate = A[0];
        int count = 1;
        int candidateIndex = 0;

        // Find the potential dominator using the Boyer-Moore Voting Algorithm
        // العثور على المسيطر المحتمل باستخدام خوارزمية التصويت لبوير-مور
        for (int i = 1; i < A.length; i++) {
            if (A[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    // Update the candidate when count reaches zero
                    // تحديث المرشح عند وصول العدد إلى الصفر
                    candidate = A[i];
                    candidateIndex = i;
                    count = 1;
                }
            }
        }

        // Verify if the candidate is a true dominator
        // التحقق إذا كان المرشح هو المسيطر الحقيقي
        count = 0;
        for (int value : A) {
            if (value == candidate) {
                count++;
            }
        }

        // Return the index if the candidate is a dominator, otherwise return -1
        // إرجاع الفهرس إذا كان المرشح مسيطراً، وإلا يرجع -1
        return count > A.length / 2 ? candidateIndex : -1;
    }
}