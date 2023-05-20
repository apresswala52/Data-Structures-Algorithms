package com.example.practice.controller;

import com.example.practice.stack.NearestGreaterToLeft;
import com.example.practice.stack.NearestGreaterToRight;
import com.example.practice.stack.NearestSmallerToLeft;
import com.example.practice.stack.NearestSmallerToRight;
import com.example.practice.util.TrackExecutionTime;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/stack")
public class StackController {

    private final NearestGreaterToRight nearestGreaterToRight;
    private final NearestGreaterToLeft nearestGreaterToLeft;
    private final NearestSmallerToRight nearestSmallerToRight;
    private final NearestSmallerToLeft nearestSmallerToLeft;

    @GetMapping("/nearestGreaterToRight")
    @TrackExecutionTime
    public String nearestGreaterToRightProblems() {
        //int arr [] = { 11, 13, 21, 3 };
        int arr[] = { 6, 8, 0, 1, 3 };

        nearestGreaterToRight.bruteForceSolution(arr, arr.length);
        nearestGreaterToRight.stackBasedSolution(arr, arr.length);

        return "nearestGreaterToRightProblems function executed successfully";
    }

    @GetMapping("/nearestGreaterToLeft")
    public String nearestGreaterToLeftProblems() {
        //int arr [] = { 11, 13, 21, 3 };
        int arr[] = { 6, 8, 0, 1, 3 };

        nearestGreaterToLeft.bruteForceSolution(arr, arr.length);
        nearestGreaterToLeft.stackBasedSolution(arr, arr.length);

        return "nearestGreaterToLeftProblems function executed successfully";
    }

    @GetMapping("/nearestSmallerToRight")
    public String nearestSmallerToRightProblems() {
        //int arr [] = { 11, 13, 21, 3 };
        int arr[] = { 6, 8, 0, 1, 3 };

        nearestSmallerToRight.bruteForceSolution(arr, arr.length);
        nearestSmallerToRight.stackBasedSolution(arr, arr.length);

        return "nearestSmallerToRightProblems function executed successfully";
    }

    @GetMapping("/nearestSmallerToLeft")
    public String nearestSmallerToLeftProblems() {
        //int arr [] = { 11, 13, 21, 3 };
        int arr[] = { 6, 8, 0, 1, 3 };

        nearestSmallerToLeft.bruteForceSolution(arr, arr.length);
        nearestSmallerToLeft.stackBasedSolution(arr, arr.length);

        return "nearestSmallerToLeftProblems function executed successfully";
    }

}
