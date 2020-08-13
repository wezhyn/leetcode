package com.code.bilibili;

/**
 * @author wezhyn
 * @since 08.13.2020
 */
public class TwentyFour {


    public boolean Game24Points(int[] arr) {
        return back(arr, false, 0, 0);

    }

    private boolean back(int[] arr, boolean useAnother, int i, double r) {

        if (i == 4) {
            return Math.abs(24 - r) < 0.00001;
        }
        if (useAnother) {
            return back(arr, false, i + 1, r);
        }
        if (i < 3) {
            if (back(arr, true, i + 1, r + arr[i] * arr[i + 1]) ||
                    back(arr, true, i + 1, r + (double) arr[i] / arr[i + 1])) {
                return true;
            }
        }
        return back(arr, false, i + 1, r + arr[i]) || back(arr, false, i + 1, r - arr[i]) ||
                back(arr, false, i + 1, r * arr[i]) || back(arr, false, i + 1, r / arr[i]);
    }


}
