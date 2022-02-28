package ch07;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/** 最短距离 P108
 * 迪克斯特拉算法
 * @author shaoqiangyan
 */
public class MinimalPath {
    private static Character start = 's';

    private Map<Character, Map<Character, Integer>> graph;
    // 记录到达每个节点的花费时间,
    private Map<Character, Integer> costMap = new HashMap<>();
    // 记录最终路线
    private Map<Character, Character> parent = new HashMap<>();
    private Set<Character> visited = new HashSet<>();

    public int find() {
        // 构造数据
        init();
        char s = findLowestCostNode();
        while (s != 'f') {
            Integer cost = costMap.get(s);
            Map<Character, Integer> neighbors = graph.get(s);
            for (Map.Entry<Character, Integer> entry : neighbors.entrySet()) {
                int newCost = cost + entry.getValue();
                if (costMap.get(entry.getKey()) > newCost) {
                    costMap.put(entry.getKey(), newCost);
                    parent.put(entry.getKey(), s);
                }
            }
            visited.add(s);
            s = findLowestCostNode();
        }
        return costMap.get('f');
    }

    @Test
    public void test() {
        final int i = find();
        Assert.assertTrue(i == 6);
    }

    private char findLowestCostNode() {
        char res = 'z';
        int currCost = 1 << 7;
        for (Map.Entry<Character, Integer> entry : costMap.entrySet()) {
            if (entry.getValue() < currCost && !visited.contains(entry.getKey())) {
                currCost = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }





    public void init() {
        graph = buildGraph();
        for (Map.Entry<Character, Integer> entry : graph.get('s').entrySet()) {
            costMap.put(entry.getKey(), entry.getValue());
        }
        costMap.put('f', 1 << 7);

        parent.put('a', 's');
        parent.put('b', 's');

    }
    /**
     * P108
     * f final
     * s 起点
     * @return
     */
    private Map<Character, Map<Character, Integer>> buildGraph() {
        Map<Character, Map<Character, Integer>> map = new HashMap<>(4, 1);
        Map<Character, Integer> sToMap = new HashMap<>(2, 1);
        sToMap.put('a', 6);
        sToMap.put('b', 2);
        map.put(start, sToMap);

        Map<Character, Integer> aToMap = new HashMap<>(2, 1);
        aToMap.put('f', 1);
        map.put('a', aToMap);

        Map<Character, Integer> bToMap = new HashMap<>(2, 1);
        bToMap.put('a', 3);
        bToMap.put('f', 5);
        map.put('b', bToMap);
        return map;
    }


}
