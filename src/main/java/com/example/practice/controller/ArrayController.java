package com.example.practice.controller;

import com.example.practice.array.ReverseArray;
import com.example.practice.stack.NearestGreaterToRight;
import com.example.practice.util.TrackExecutionTime;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/array")
public class ArrayController {

    private final ReverseArray reverseArray;

    @GetMapping("/reverse")
    public String reverseArrayProblems() {
        int arr [] = { 11, 13, 21, 3 };
        //int arr[] = { 6, 8, 0, 1, 3 };

        //reverseArray.iterativeSolution(arr);
        reverseArray.recursiveSolution(arr, 0, arr.length-1);

        return "reverseArrayProblems function executed successfully";
    }

}
