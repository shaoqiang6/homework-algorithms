# algorithms

## week01 数组、栈、链表、队列





## week02  哈希表、集合、映射、前缀和、查分、双指针扫描

## week03 递归、分支、树、图

## week04 深度优先搜索、广度优先搜索、二叉堆、二叉搜索树

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