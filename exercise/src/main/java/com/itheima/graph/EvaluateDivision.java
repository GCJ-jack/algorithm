package com.itheima.graph;

import java.util.*;

public class EvaluateDivision {

    Map<String,Map<String,Double>> map = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        double[] res = new double[queries.size()];
        //step1 build the map
        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);

            double val = values[i];

            map.putIfAbsent(from,new HashMap<>());
            map.putIfAbsent(to,new HashMap<>());

            map.get(from).put(to,val);

            map.get(to).put(from,1.0/val);
        }
        //step2 dfs for every node

        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if(!map.containsKey(start)||!map.containsKey(end)){
                res[i] = -1.0;
            }else if(start.equals(end)){
                res[i] = 1.0;
            }else{
                Set<String> visited = new HashSet<>();
                res[i] = dfs(start,end,1.0,visited);
            }
        }
        //step3 return the result
        return res;
    }


    // DFS 搜索从当前节点到目标节点的路径，累计乘积
    private double dfs(String current, String target, double acc, Set<String> visited) {

        if(current.equals(target)){
            return acc;
        }

        visited.add(current);

        for(Map.Entry<String,Double> path:map.get(current).entrySet()){
            String neighbor = path.getKey();
            double value = path.getValue();

            if(visited.contains(neighbor)){
                continue;
            }



            double result = dfs(neighbor,target,acc * value, visited);
            if (result != -1.0) return result;
        }

        return -1.0;
    }



    public static void main(String[] args) {
        EvaluateDivision solution = new EvaluateDivision();

        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c")); // 6.0
        queries.add(Arrays.asList("b", "a")); // 0.5
        queries.add(Arrays.asList("a", "e")); // -1.0
        queries.add(Arrays.asList("a", "a")); // 1.0
        queries.add(Arrays.asList("x", "x")); // -1.0

        double[] results = solution.calcEquation(equations, values, queries);

        System.out.println("Results:");
        for (double r : results) {
            System.out.println(r);
        }
    }
}
