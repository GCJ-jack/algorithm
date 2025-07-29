package com.itheima.graph;

import com.itheima.tree.Queue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {

        //将基因库存入 set中更方便确认是否存在
        Set<String> set = new HashSet<>(Arrays.asList(bank));

        //记录已经发现过的基因
        Set<String> visited = new HashSet<>();

        //创建队列记录已经出现过的基因d
        Queue<String> queue =new Queue<>();

        visited.add(start);

        queue.enqueue(start);

        char[] chars = new char[]{'A','C','G','T'};

        int steps = 0;

        while (!queue.isEmpty()){

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String current = queue.dequeue();

                if(current.equals(end)){
                    return steps;
                }

                char[] currentChars = current.toCharArray();
                for (int j = 0; j < current.length(); j++) {

                    char originalChar = currentChars[j];

                    for(char c:chars){
                        if (c==originalChar){
                            continue;
                        }

                        currentChars[j] = c;

                        String nextSeq = new String(currentChars);

                        if(!visited.contains(nextSeq)&&set.contains(nextSeq)){
                            queue.enqueue(nextSeq);
                            visited.add(nextSeq);
                        }
                    }

                    currentChars[j] = originalChar;

                    currentChars[j] = originalChar;
                }
            }
            steps++;
        }

        return -1;
    }
}
