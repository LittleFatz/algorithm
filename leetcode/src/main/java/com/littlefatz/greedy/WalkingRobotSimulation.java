package com.littlefatz.greedy;


import java.util.HashSet;
import java.util.Set;

//https://leetcode-cn.com/problems/walking-robot-simulation/description/
public class WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Set<String> obstacleSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstacleSet.add(obstacles[i][0] + "-" + obstacles[i][1]);
        }

        int direction = 0;
        int x = 0;
        int y = 0;
        int result = Integer.MIN_VALUE;
        for (int command : commands) {
            if (command == -1) {
                direction = (direction + 1) % 4;

            } else if (command == -2) {
                direction--;
                if (direction == -1) {
                    direction = 3;
                }
            } else {
                while(command > 0
                        && !obstacleSet.contains((x + directions[direction][0]) + "-" + (y + directions[direction][1]))) {
                    x += directions[direction][0];
                    y += directions[direction][1];
                    command--;
                }
            }

            result = Math.max(result, x*x + y*y);
        }

        return result;

    }

    public static void main(String[] args) {
        int[] command = new int[]{4,-1,4,-2,4};
        int[][] obs = new int[][]{{2,4}};
        WalkingRobotSimulation test = new WalkingRobotSimulation();
        System.out.println(test.robotSim(command, obs));;
    }

}
