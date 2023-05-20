package com.example.practice.array;

import com.example.practice.util.TrackExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReverseArray {

    /** Problem:-
     * Given an array (or string), the task is to reverse the array/string.
     * Input  : arr[] = {1, 2, 3}
     * Output : arr[] = {3, 2, 1}
     */

    @TrackExecutionTime
    public void iterativeSolution(int[] arr) {
        log.info("Original Array: {}", arr);
        int temp;
        int start = 0;
        int end = arr.length - 1;

        while(start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }

        log.info("Reversed Array: {}", arr);
    }

    public void recursiveSolution(int[] arr, int start, int end) {
        log.info("Original Array: {}", arr);
        int temp;

        if(start >= end)
            return;

        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        recursiveSolution(arr, start+1, end-1);

        log.info("Reversed Array: {}", arr);
    }

}
