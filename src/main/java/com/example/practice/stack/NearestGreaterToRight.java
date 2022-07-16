package com.example.practice.stack;

import com.example.practice.util.TrackExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;

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
        log.info("--------------");
        log.info("Input List :: {}", arr);
        ArrayList<Integer> NGEList = new ArrayList<>();

        for(int i = 0; i < size ; i++) {
            int NGE = -1;
            for (int j = i+1; j < size; j++) {
                if (arr[j] > arr[i]) {
                    NGE = arr[j];
                    break;
                }
            }
            NGEList.add(NGE);
        }

        log.info("NGEList :: {}", NGEList);
        log.info("--------------");
    }

    @TrackExecutionTime
    public void stackBasedSolution(int arr [], int size) {
        log.info("--------------");
        log.info("Input List :: {}", arr);
        Stack<Integer> stack = new Stack<>();
        List<Integer> NGEList = new ArrayList<>();

        for (int i = size-1; i >= 0; i--) {
            if (stack.size()==0) {
                NGEList.add(-1);
            }
            else if (stack.size() > 0 && stack.peek() > arr[i]) {
                NGEList.add(stack.peek());
            }
            else if (stack.size() > 0 && stack.peek() <= arr[i]) {
                while(stack.size() > 0 && stack.peek() <= arr[i]) {
                    if (stack.peek() <= arr[i]) {
                        stack.pop();
                    }
                }
                if (stack.size() == 0) {
                    NGEList.add(-1);
                }
                else {
                    NGEList.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }

        Collections.reverse(NGEList);
        log.info("NGEList :: {}", NGEList);
        log.info("--------------");
    }

}
