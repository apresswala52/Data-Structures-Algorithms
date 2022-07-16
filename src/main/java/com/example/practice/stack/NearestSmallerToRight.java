package com.example.practice.stack;

import com.example.practice.util.TrackExecutionTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

@Slf4j
@Component
public class NearestSmallerToRight {

    /** Problem:-
     * Given an array, print the Next Smaller Element (NSE) for every element.
     * The Next smaller Element for an element x is the first smaller element on the right side of x in the array.
     * Elements for which no smaller element exist, consider the next smaller element as -1.
    */
    @TrackExecutionTime
    public void bruteForceSolution(int arr [], int size) {
        log.info("------------------------------------");
        log.info("Input List :: {}", arr);
        ArrayList<Integer> NSEList = new ArrayList<>();

        for(int i = 0; i < size ; i++) {
            int NSE = -1;
            for (int j = i+1; j < size; j++) {
                if (arr[j] < arr[i]) {
                    NSE = arr[j];
                    break;
                }
            }
            NSEList.add(NSE);
        }

        log.info("NSEList :: {}", NSEList);
        log.info("------------------------------------");
    }

    @TrackExecutionTime
    public void stackBasedSolution(int arr [], int size) {
        log.info("------------------------------------");
        log.info("Input List :: {}", arr);
        Stack<Integer> stack = new Stack<>();
        List<Integer> NSEList = new ArrayList<>();

        for (int i = size-1; i >= 0; i--) {
            if (stack.size()==0) {
                NSEList.add(-1);
            }
            else if (stack.size() > 0 && stack.peek() < arr[i]) {
                NSEList.add(stack.peek());
            }
            else if (stack.size() > 0 && stack.peek() >= arr[i]) {
                while(stack.size() > 0 && stack.peek() >= arr[i]) {
                    if (stack.peek() >= arr[i]) {
                        stack.pop();
                    }
                }
                if (stack.size() == 0) {
                    NSEList.add(-1);
                }
                else {
                    NSEList.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }

        Collections.reverse(NSEList);
        log.info("NSEList :: {}", NSEList);
        log.info("------------------------------------");
    }

}
