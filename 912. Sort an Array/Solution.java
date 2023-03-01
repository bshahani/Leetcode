class Solution {
    public int[] sortArray(int[] nums) {

        int l = 0;
        int r = nums.length-1;

        if(l < r) {
            int midpt = (nums.length)/2;
            int left[] = new int[midpt];
            int right[] = new int[nums.length - midpt];

            for(int i = 0; i<midpt; i++) {
                left[i] = nums[i];
            }

            for(int i = midpt; i < nums.length; i++) {
                right[i - midpt] = nums[i];
            }

            left = sortArray(left);
            right = sortArray(right);

            nums = merge(left, right);
        }

        return nums;
    }

    public int[] merge(int left[], int right[]) {

        int array[] = new int[left.length+right.length];
        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }

        return array;
    }

}