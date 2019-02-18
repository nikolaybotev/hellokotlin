class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        {
            int ans = s.findKthLargest(new int[]{3, 0, 1, 2}, 2);
            System.out.printf("%d %n", ans);
        }

        {
            int ans = s.findKthLargest(new int[]{3, 4, 3}, 1);
            System.out.printf("%d %n", ans);
        }

        {
            int ans = s.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
            System.out.printf("%d %n", ans);
        }

        {
            int ans = s.findKthLargest(new int[]{99, 99}, 2);
            System.out.printf("%d %n", ans);
        }

        {
            int ans = s.findKthLargest(new int[]{99}, 1);
            System.out.printf("%d %n", ans);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int ki = nums.length - k;

        int lo = 0;
        int hi = nums.length - 1;
        while (true) {
            // partition
            int pivot = nums[ki];
            int lop = lo - 1;
            int hip = hi + 1;
            while (true) {
                do { lop++; } while (nums[lop] < pivot);
                do { hip--; } while (nums[hip] > pivot);

                if (lop >= hip) break;

                int tmp = nums[lop];
                nums[lop] = nums[hip];
                nums[hip] = tmp;
            }

            if (ki == hip && nums[ki] == pivot) return nums[ki];
            //if (hip == ki - 1) return nums[ki];

            if (hip >= ki) {
                hi = hip;
            } else {
                lo = hip + 1;
            }
        }
    }
}
