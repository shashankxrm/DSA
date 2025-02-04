package stackNqueue;

//You are given an array of ‘N’ integers, you need to find the maximum of minimum for every window size.
// The size of the window should vary from 1 to ‘N’ only.
//
//For example:
//
//ARR = [1,2,3,4]
//Minimums of window size 1 = min(1), min(2), min(3), min(4) = 1,2,3,4
//Maximum among (1,2,3,4)  is 4
//
//Minimums of window size 2 = min(1,2), min(2,3),   min(3,4) = 1,2,3
//Maximum among (1,2,3) is 3
//
//Minimums of window size 3 = min(1,2,3), min(2,3,4) = 1,2
//Maximum among (1,2) is 2
//
//Minimums of window size 4 = min(1,2,3,4) = 1
//Maximum among them is 1
//The output array should be [4,3,2,1].

public class maxforminimumWindowSizes {
    public static int[] maxMinWindow(int[] arr, int n)
    {
        // Definition: answer[i] will store the maximum of minimum of every window of size 'i'.
        int[] answer = new int[n];
        for (int i = 0; i < n; ++i)
        {
            answer[i] = Integer.MIN_VALUE;
        }

        // Sliding on all possible windows
        for (int i = 0; i < n; ++i)
        {
            for (int j = i; j < n; ++j)
            {
                // Start is the starting index of current window
                int start = i;

                //  End is the ending index of current window
                int end = j;

                // Temp will store minimum element for the current window
                int temp = Integer.MAX_VALUE;

                for (int k = start; k <= end; ++k)
                {
                    temp = Math.min(temp, arr[k]);
                }

                int length = end - start;

                // Update the answer of current window length
                answer[length] = Math.max(answer[length], temp);
            }
        }

        return answer;
    }
}
