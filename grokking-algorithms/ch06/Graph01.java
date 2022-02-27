package ch06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author shaoqiangyan
 */
public class Graph01 {




    Map<String, String[]> graph;
    List<String> res;
    Set<String> visitedSet;
    public boolean findM(String root, Map<String, String[]> graph) {
        this.graph = graph;
        this.res = new ArrayList<>(2);
        visitedSet = new HashSet<>(5);
        dfs(root);
        System.out.println(res);
        return !res.isEmpty();
    }

    private void dfs(String root) {
        if (null == root) {
            return;
        }
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            final String poll = queue.poll();
            if (poll.contains("m")) {
                res.add(poll);
                return;
            }
            final String[] strings = graph.get(poll);
            if (strings == null) {
                continue;
            }
            for (String name : strings) {
                if (!visitedSet.add(name)) {
                    continue;
                }
                // 找到芒果商就不再往队列中加入了, 不需要在往下找了即使下一级还有可能是芒果商
                if (name.contains("m")) {
                    res.add(name);
                } else {
                    queue.addLast(name);
                }
            }

        }
    }

    @Test
    public void test() {
        final boolean found = findM("a", buildGraph());
        System.out.println(found);

    }


    private Map<String, String[]> buildGraph() {
        Map<String, String[]> res = new HashMap<>(4, 1);
        res.put("a",new String[]{"bob", "adf"});
        // a 和 bob 互为朋友, 但是仅需要访问一遍, 需要有判断是否已经访问过
        res.put("bob",new String[]{"a", "adf"});
        res.put("adf",new String[]{"asdf1", "1233m"});
        res.put("asdf1",new String[]{"m", "1"});
        res.put("m",new String[]{"mm", "1mm"});
        return res;
    }
}
