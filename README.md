# algorithms

## week01 数组、栈、链表、队列

[20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/) stack

[394. 字符串解码](https://leetcode-cn.com/problems/decode-string/)  stack

[88. 合并有序数组](https://leetcode-cn.com/problems/merge-sorted-array/) 数组

#### [66. 加一](https://leetcode-cn.com/problems/plus-one/)

#### [21. 合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/)

[641. 设计循环双端队列](https://leetcode-cn.com/problems/design-circular-deque/)

[85. 最大矩形](https://leetcode-cn.com/problems/maximal-rectangle/)

[88. 合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)

#### [26. 删除有序数组中的重复项](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

#### [84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)

#### [42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

## week02  哈希表、集合、映射、前缀和、查分、双指针扫描

#### [811. 子域名访问计数](https://leetcode-cn.com/problems/subdomain-visit-count/) map

#### [697. 数组的度](https://leetcode-cn.com/problems/degree-of-an-array/) map

#### [1074. 元素和为目标值的子矩阵数量](https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/) 前缀和

#### [560. 和为 K 的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k/)  前缀和

#### [874. 模拟行走机器人](https://leetcode-cn.com/problems/walking-robot-simulation/)

- 方向数组

- set 记录所有障碍物

#### [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)

- map

## week03 递归、分支、树、图

#### [23. 合并K个升序链表](https://leetcode-cn.com/problems/merge-k-sorted-lists/)  归并

#### [47. 全排列 II](https://leetcode-cn.com/problems/permutations-ii/)

- 递归，

- 数组sort，used[]

#### [106. 从中序与后序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

#### [105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

#### [210. 课程表 II](https://leetcode-cn.com/problems/course-schedule-ii/)

#### [684. 冗余连接](https://leetcode-cn.com/problems/redundant-connection/)

#### [685. 冗余连接 II](https://leetcode-cn.com/problems/redundant-connection-ii/)



#### 树、二叉树、树的遍历

#### [589. N 叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/)

#### [297. 二叉树的序列化与反序列化](https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/)

- [x]  todo 0328



#### [236. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/)







## week04 深度优先搜索、广度优先搜索、二叉堆、二叉搜索树

#### [130. 被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)

#### [538. 把二叉搜索树转换为累加树](https://leetcode-cn.com/problems/convert-bst-to-greater-tree/)

层序逆序遍历 右、root、左



## week05 二分、排序

## search 05

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

### sort

## week06 贪心、动规1

## week07 动规2、3

## week08 字典树、并查集、图论算法

## week09 字符串处理、高级搜索

## week10 平衡二叉树、跳表、实战技巧、树状数组与线段树

## 刷题路径