package com.example.practice.stack;

import com.example.practice.util.TrackExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class NearestGreaterToRight {

    /** Problem:-
     * Given an array, print the Next Greater Element (NGE) for every element.
     * The Next greater Element for an element x is the first greater element on the right side of x in the array.
     * Elements for which no greater element exist, consider the next greater element as -1.
    */
    @TrackExecutionTime
    public void bruteForceSolution(int arr [], int size) {
        ArrayList<Integer> NGEList = new ArrayList<>();

        for(int i = 0; i < size ; i++) {
            int NGE = -1;
            for (int j = i+1; j < size; j++) {
                if (arr[j] > arr[i]) {
                    NGE = arr[j];
                    NGEList.add(NGE);
                    break;
                }
            }
            NGEList.add(NGE);
        }
        NGEList.add(-1);

        log.info("NGEList :: {}", NGEList);

    }

}
