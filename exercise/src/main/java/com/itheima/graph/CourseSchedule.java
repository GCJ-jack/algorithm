package com.itheima.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    //final answer loop existed?
    boolean valid = true;
    //check the course
    int[] visited;
    //course graph
    List<List<Integer>> edge;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new int[numCourses];

        edge = new ArrayList<List<Integer>>();

        for (int i = 0; i < numCourses; i++) {
            edge.add(new ArrayList<>());
        }

        for(int[] lectures:prerequisites){
            edge.get(lectures[1]).add(lectures[0]);
        }

        for (int i = 0; i < numCourses&&valid; i++) {
            if(visited[i]==0){
                dfs(i);
            }
        }

        return  valid;

    }

    public void dfs(int n){
        visited[n] = 1;

        for(int u:edge.get(n)){
            if(visited[u]==0){
                dfs(u);
                if(!valid){
                    return;
                }
            }else if(visited[u]==1){
                valid = false;
                return;
            }

        }

        visited[n] = 2;
    }

    public static void main(String[] args) {

    }
}
