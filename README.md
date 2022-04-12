# algorithms

## week01 数组、栈、链表、队列

[20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/) stack

[394. 字符串解码](https://leetcode-cn.com/problems/decode-string/)  stack

[88. 合并有序数组](https://leetcode-cn.com/problems/merge-sorted-array/) 数组

[66. 加一](https://leetcode-cn.com/problems/plus-one/)

[21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

[641. 设计循环双端队列](https://leetcode-cn.com/problems/design-circular-deque/)

[85. 最大矩形](https://leetcode-cn.com/problems/maximal-rectangle/)

[88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

[26. 删除有序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

[84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)

[42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

## week02  哈希表、集合、映射、前缀和、查分、双指针扫描

[811. 子域名访问计数](https://leetcode-cn.com/problems/subdomain-visit-count/) map

[697. 数组的度](https://leetcode-cn.com/problems/degree-of-an-array/) map

[1074. 元素和为目标值的子矩阵数量](https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/)

- 前缀和

- 两数之和

[560. 和为 K 的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k/)

前缀和(与1074类似)

```java
// 前缀和数组
// s[0] = 0; s[1] = s[0] + nums[0]int s[] = new int[n+1];
s[0] = 0;
for (int i = 1; i < s.length; i++) {
    s[i] = s[i - 1] + nums[i - 1];
}
```

[874. 模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/)

- 方向数组

- set 记录所有障碍物

[49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)

- map

[30. 串联所有单词的子串](https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/)

[30. 串联所有单词的子串](https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/)

- 两个map，一个放数组存在单词和对应的数量，一个存放从字符串中找到的数组的单词数量

```java
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String ss : words) {
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int len = words[0].length();
        int num = words.length;
        for (int i = 0; i < n - (len * num) + 1; i++) {
            Map<String, Integer> seen = new HashMap<>();
            // 第几个单词, 一个一个匹配
            int j = 0;
            while (j < num) {
                String word = s.substring(i + j * len, i + len + j * len);
                if (map.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.getOrDefault(word, 0) > map.getOrDefault(word, 0)) {
                        break;       
                    }
                    j++;
                } else {
                    break;
                }
            }
            if (j == num) {
                ans.add(i);
            }
        }
        return  ans;
    }
}
```

## week03 递归、分支、树、图

[23. 合并K个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)  

- 解法一：归并

- 使用优先级队列

- 自己实现二叉堆，提到优先级队列

[47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/)

- 递归，

- 数组sort：在判断是否与前一个元素重复时使用，

- used[] 用来记录数组的某一个元素是否使用过

```java
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> a = new ArrayList<>();
    boolean[] used = null;
    int n = 0;
    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        used = new boolean[n];
        Arrays.sort(nums);
        recur(nums, 0);
        return ans;
    }

    private void recur(int[] nums, int pos) {
        if (pos == n) {
            ans.add(new ArrayList<>(a));
            return;
        }
        for (int i = 0; i < n; i++) {
            // 当前预算元素已经使用过或者上一个元素相等并且没有访问过
            if(used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            a.add(nums[i]);
            used[i] = true;
            // 找下一个位置对应的元素
            recur(nums, pos + 1);
            // 还原全局信息
            used[i] = false;
            a.remove(a.size() - 1);

        }
    }

}
```

[106. 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

[105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

[207. 课程表](https://leetcode-cn.com/problems/course-schedule/)

> a课程依赖b课程，标识b到a可到达即为有向图；to数组
> 
> 1. 构建这个图；
> 
> 2. 构建每门课程的度；
> 
> 3. 找到度为0的一个课程，从他开始进行广度优先遍历（使用 while(!queue.isEmpty())），每学完一门课将他的度减一，如果度为0代表这门课没有依赖其他的课程了，可以直接学习。。。

[210. 课程表 II](https://leetcode-cn.com/problems/course-schedule-ii/)

[684. 冗余连接](https://leetcode-cn.com/problems/redundant-connection/)

求环，无向图的构建遍历

出边数组：

`List<List<Integer>> to = new ArrayList<>(n + 1)`  

```java
class Solution {
    /**
     * 总节点数 
     */
    int n = 0;
    List<List<Integer>> to;
    boolean[] visited = null;
    boolean hasCycle = false;

    public int[] findRedundantConnection(int[][] edges) {
        // 求n的值
        for (int [] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            n = Math.max(n, Math.max(x, y));
        }

        visited = new boolean[n + 1];
        to = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            to.add( new ArrayList<>());
        }

        for (int [] edge : edges) {
            hasCycle = false;
            int x = edge[0];
            int y = edge[1];
            // 出边数组构建
            to.get(x).add(y);
            to.get(y).add(x);
            visited[x] = true;
            dfs(x, 0);
        visited[x] = false;
            if (hasCycle) {
                return edge;
            }
        }
        return new int[0];
    }
    /**
    图的深度优先遍历找环
     */
    private void dfs(int x, int fa) {
        // 出边数组访问 x能到周围点的方法
        for (int y : to.get(x)) {
            if(y == fa) continue;
            if (!visited[y]) dfs(y, x);
            else hasCycle = true;
        }

    }
}
```

[685. 冗余连接 II](https://leetcode-cn.com/problems/redundant-connection-ii/)

树、二叉树、树的遍历

[589. N 叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)

[297. 二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)

- [ ] todo 0328

[236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)

## week04 深度优先搜索、广度优先搜索、二叉堆、二叉搜索树

[130. 被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)

> 求矩阵中被'X'围绕的区域
> 
> 1. 对区域的四条边进行深度优先遍历，将 'O' 染色为 'A';
> 
> 2. 遍历整个矩阵，修改 'O' -> 'X', 'A'->'O'

[538. 把二叉搜索树转换为累加树](https://leetcode-cn.com/problems/convert-bst-to-greater-tree/)

层序逆序遍历 右、root、左

[355. 设计推特](https://leetcode-cn.com/problems/design-twitter/)

- [x] todo 

[17. 电话号码的字母组合](https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/)

#### [51. N 皇后](https://leetcode-cn.com/problems/n-queens/)

#### [200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)

> 二维矩阵深度优先遍历，发现一个陆地就针对他进行深度遍历（使用方向数组），期间需要对访问过的点进行标记为已读 `visited[][]` 

#### [433. 最小基因变化](https://leetcode-cn.com/problems/minimum-genetic-mutation/)

> 中等
> 
> 层序遍历，改其中一个char然后看基因库是否存在，存在&& 没有访问过就加入层序的队列

## week05 二分、排序

### 二分查找

> 二分查找前提：
> 
> - 有界
> 
> - “条件” 单调（）
> 
> - 能够通过索引访问

二分模板一：

```java
public int search(int[] nums) {
    int left = 0, right = nums.length - 1;
    while(left <= right) {
        int mid = (left + right) / 2;
        if(nums[mid] == target) return mid;
        if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    // 无解
    return -1;
}
```

更通用的二分模板：

- 1 前驱

```java
// 查找第一个 >= target的数字， 如果没有找到返回n, right初始值为 n
int left = 0, right = n;
while(left < right) {
    int mid = (left + right) / 2;
    if (nums[mid] >= target) { // 符合条件，
        right = mid;
    } else {
        left = mid + 1;
    }
}
return right;
```

- 2 后继

```java
// 查找最后一个 <= target的数字， 如果没有找到返回 -1, left初始值为 -1
public int binarySearch(int[] nums, int target) {
    int left = -1, right = n - 1;
    while(left < right) {
        // mid的计算要取 余数+ 1； 注意：只要出现使用 right = mid - 1时，计算mid需要+ 1
        int mid = (left + right + 1) / 2;
        if (nums[mid] <= target) { // 符合条件，
            left = mid;
        } else {
            right = mid - 1;
        }
    }
    return right;
}
```

| 相关题目                                                                                                                   | 思路                                                                     |
|:----------------------------------------------------------------------------------------------------------------------:| ---------------------------------------------------------------------- |
| [704. 二分查找](https://leetcode-cn.com/problems/binary-search/)                                                           | 模板1                                                                    |
| [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/)                           | 找第一个小于等于最右侧元素的索引值；旋转之后数组本身不是单调，但是可以把序列分成一半满足一半不满足，满足是1不满足是0，就转化成单调的序列了 |
| [154. 寻找旋转排序数组中的最小值 II](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/)                     |                                                                        |
| [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | 前驱+后继                                                                  |
| [69. x 的平方根](https://leetcode-cn.com/problems/sqrtx/)                                                                  |                                                                        |

### 三分查找

| 相关题目                                                             | 思路  |
|:----------------------------------------------------------------:| --- |
| [162. 寻找峰值](https://leetcode-cn.com/problems/find-peak-element/) |     |
|                                                                  |     |

#### [1011. 在 D 天内送达包裹的能力](https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/)

> - 题目需要找出在 D 天内运完包裹**最小载重量**
> 
> - 货物需要按照顺序搬运，可以使用二分查找  `maxWeight` 即 `left` ；   `sumWeight` 即right；每次判断 `(left + right) / 2` 是否可以满足答案

#### [875. 爱吃香蕉的珂珂](https://leetcode-cn.com/problems/koko-eating-bananas/)

> 类似 1011题

#### [327. 区间和的个数](https://leetcode-cn.com/problems/count-of-range-sum/)

线段树

excalldraw.com

#### [911. 在线选举](https://leetcode-cn.com/problems/online-election/)

## week06 贪心、动规1

#### [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

> 1. 递归解法：
>    
>    1. 递推公式： f(n) = f(n - 1) + f(n -2); // 到达终点的走法 = 走到上一个台阶的走法+ 走到上上个台阶的走法总数
> 
> 2. 动态规划

```java
// 1.1. 最朴素的递归
class Solution {
    public int climbStairs(int n) {
        return recursion(n);
    }

    private int recursion(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return recursion(n - 2) + recursion(n - 1);
    }
}


```



```java
// 1.2.记忆化搜索
class Solution {
    int[] mem = null;
    public int climbStairs(int n) {
        mem = new int[n + 1];
        return recursion(n);
    }

    private int recursion(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (mem[n] > 0) return mem[n];
        int res = recursion(n - 2) + recursion(n - 1);
        mem[n] = res;
        return res;
    }
}
```



```java
class Solution {
    int [] dp = null;
    public int climbStairs(int n) {
        dp = new int[n + 1];
        return recursion(n);
    }

    private int recursion(int n) {
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }
}
```



```java
// 2.2 压缩数组
class Solution {
    int [] dp = null;
    public int climbStairs(int n) {
        dp = new int[2];
        return recursion(n);
    }

    private int recursion(int n) {
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i&1] = dp[i - 1 &1] + dp[i - 2&1];
        }
        return dp[n - 1&1];
    }
}
```



#### [120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle/)

todo 

## week07 动规2、3

## week08 字典树、并查集、图论算法

## week09 字符串处理、高级搜索

[8. 字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi/)

跟着题目要求一步一步写

最大最小值比较是注意越界，使用减法代替加法、除法代替乘法

[387. 字符串中的第一个唯一字符](https://leetcode-cn.com/problems/first-unique-character-in-a-string/)

map存储每个字符的出现次数，循环字符串找出出现次数为1

[14. 最长公共前缀](https://leetcode-cn.com/problems/longest-common-prefix/)

两两求最长前缀

[344. 反转字符串](https://leetcode-cn.com/problems/reverse-string/)

## week10 平衡二叉树、跳表、实战技巧、树状数组与线段树

## 刷题路径