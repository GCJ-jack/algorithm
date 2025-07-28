package com.itheima.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseOrder {

    int[] visited;

    boolean valid = true;

    int[] order;

    List<List<Integer>> courses;

    int index;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];

        order = new int[numCourses];

        courses = new ArrayList<List<Integer>>();

        index = numCourses - 1;

        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }

        for(int[] lecture:prerequisites){
            courses.get(lecture[1]).add(lecture[0]);
        }


        for (int i = 0; i < numCourses&&valid; i++) {
            if(visited[i]==0){
                dfs(i);
            }
        }

        return valid? order:new int[]{};
    }

    public void dfs(int n){
        visited[n] = 1;


        for(int lecture:courses.get(n)){
            if(visited[lecture]==0){
                dfs(lecture);
                if(!valid){
                    return;
                }
            }else if(visited[lecture]==1){
                valid = false;
                return;
            }
        }

        visited[n] = 2;
        order[index] = n;
        index--;
    }


    public static void main(String[] args) {


    }
}
