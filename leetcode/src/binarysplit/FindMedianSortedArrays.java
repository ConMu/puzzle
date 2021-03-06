package binarysplit;
/*https://leetcode-cn.com/problems/median-of-two-sorted-arrays*/
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k = nums1.length + nums2.length;
        double a = 0;
        if ((k & 1) == 1) {
            //奇数
            double res = findNum(nums1, nums2, k / 2 + 1, 0, 0);
            a = res;
        } else {
            //偶数
            double res1 = findNum(nums1, nums2, k / 2, 0, 0);
            double res2 = findNum(nums1, nums2, k / 2 + 1, 0, 0);
            a = (res1 + res2) / 2;
        }
        return a;
    }

    private static double findNum(int[] nums1, int[] nums2, int k, int index1, int index2) {

        if (index1 >= nums1.length) {
            return (double) nums2[index2 + k - 1];
        }
        if (index2 >= nums2.length) {
            return (double) nums1[index1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[index1], nums2[index2]);
        }
        int indexA = Math.min(index1 + k / 2 - 1, nums1.length - 1);
        int indexB = Math.min(index2 + k / 2 - 1, nums2.length - 1);

        if (nums1[indexA] < nums2[indexB]) {
            return findNum(nums1, nums2, k - (indexA - index1 + 1), indexA + 1, index2);
        } else {
            return findNum(nums1, nums2, k - (indexB - index2 + 1), index1, indexB + 1);

        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }


    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {2, 3, 4, 5, 6};
        System.out.println(findMedianSortedArrays(a, b));
    }
}
