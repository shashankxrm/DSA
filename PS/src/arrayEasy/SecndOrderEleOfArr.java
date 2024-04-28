package arrayEasy;

public class SecndOrderEleOfArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = findSecondLargestAndSmallest(arr);
        System.out.println("Second Largest: " + result[0]);
        System.out.println("Second Smallest: " + result[1]);
    }
    public static int[] findSecondLargestAndSmallest(int[] a) {
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > largest) {
                secondLargest = largest;
                largest = a[i];
            } else if (a[i] > secondLargest && a[i] != largest) {
                secondLargest = a[i];
            }

            if (a[i] < smallest) {
                secondSmallest = smallest;
                smallest = a[i];
            } else if (a[i] < secondSmallest && a[i] != smallest) {
                secondSmallest = a[i];
            }
        }

        return new int[]{secondLargest, secondSmallest};
    }
}
