# 学习总结

## 一、心得

 非科班出生的我虽然已有几年的程序开发经验，但是还没有系统的学习过数据结构与算法相关的知识。参加本课程最初的目的的是希望借此夯实自己算法与数据结构方面的知识，十周时间很快就过去了，前半程由于时安排的得当，老师讲解的知识点也进行了反复的练习，经过前五周的学习发现自己算法与数据结构的功底有了很大的提升，每天也想着多刷题。但是后面由于公司产品策略调整，需要加班加点的赶需求，重构项目。导致很多知识未能及时吃透，现将视频教程中讲到的知识总结在第二部分，知识小结的章节。师傅领进门修行在个人，参加了算法训练营之后我的修行之路将不再孤独。

## 二 、知识小结

### 1. 数据结构

### 一维

- 基础: 数组 array (string)，链表 linked list
- 高级: 栈 stack，队列 queue，双端队列 deque，集合 set，映射 map (hash or map)，etc

涉及题目： 栈 stack： 括号匹配问题、直方图、接雨水 队列 queue： 滑动窗口

### 二维

- 基础: 树 tree，图 graph
- 高级: 二叉搜索树 binary search tree (red-black tree,AVL)，堆 heap，并查集 disjoint set，字典树 Trie，etc

### 特殊

- 位运算 Bitwise，布隆过滤器 BloomFilter
- LRU Cache

### 2. 算法

- if-else，switch ——> branch
- for，while loop ——> literation
- 递归 Recursion (Divide & Conquer ,Backtrace)

所有高级算法或数据结构最后都会转换成以上三种

- 搜索 Search:深度优先搜索 Depth first search, 广度优先搜索 Breadth first search，A*,etc
- 动态规划 Dynamic Programming (递归+备忘录 或 迭代+DP方程)
- 二分查找 Binary Search
- 贪心 Greedy
- 数学 Math，几何 Geometry

![算法训练营总结](/Users/himmy/algorithm011-class02/算法训练营总结.jpg)

### 3. 刻意练习

基本功是区别业余和职业选手的根本。深厚功底来自于 — 过遍数

最大的误区：只做一遍

五毒神掌

刻意练习 - 练习缺陷弱点地方、不舒服、枯燥

反馈 - 看题解、看国际版的高票回答

### 4.切题四件套

clarification 明确题⽬意思、边界、数据规模

possible solutions 穷尽所有可能的解法

compare（time/space）

optimal（学习最优解加强）

coding（多写）代码简洁、⾼性能、美感

test cases

### 5.五毒神掌

**第一遍** 五分钟：读题 + 思考 直接看解法：多看几种，比较解法优劣 背诵、默写好的解法 

**第二遍** 马上自己写 ——> Leetcode提交 多种解法比较、体会 ——> 优化！ 

**第三遍** 过了一天后，再重复做题 不同解法的熟练程度——>专项练习 

**第四遍** 过了一周后：反复回来练习相同的题目 

**第五遍** 面试前一周恢复性训练

### 6. 递归 （Recursion）

递归 – 循环 通过函数体来进行循环 四个条件：

- 递回终止条件
- 处理当前层逻辑
- 下探到下一层
- 清理当前层

**思维要求**

- 不要再进行人肉递归（最大误区）
- 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
- 数学归纳法

递归代码模板

```
public void recur(int level, int param) { 

  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  } 

  // process current logic 
  process(level, param); 

  // drill down 
  recur( level: level + 1, newParam); 

  // restore current status 
 
}
```

**分治思维：**

- 递归终止条件
- 拆分子问题
- 调子问题的递归函数
- 合并结果，有可能要恢复当前层的状态

分治代码模板

```
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 

  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 

  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …

  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```

### 7. 动态规划

动态规划和递归或者分治，没有根本上的区别（关键看有无最优子结构） 共性：找到重复子问题 差异性：最优子结构，中途可以淘汰次优解

**动态规划关键点：**

- 最优子结构 `opt[n] = best_of(opt [n-1], opt[n-2],....)`（子问题）
- 储存中间状态:`opt[i]` (状态定义）
- 递归公式（状态转移方程或者DP方程）

**高阶dp**

- 状态拥有更多维度
- 状态方程更加复杂

**例题：LeetCode 72. 编辑距离**

给定两个单词 word 1 和 word 2，计算出将 word 1 转换成 word 2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符 删除一个字符 替换一个字符

```
示例 1:
输入: word1 = "horse", word2 = "ros"
输出: 3
解释: 
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')

示例 2:
输入: word1 = "intention", word2 = "execution"
输出: 5
解释: 
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
```

**思路：升级维度**

- 如果`word1[i]与word2[j]相同，显然 dp[i][j] = dp[i-1][j-1]`

- 如果

  ```
  word1[i]与word2[j]不同，那么dp[i][j]
  ```

  可以通过

  - 在`dp[i-1][j-1]` 的基础上做replace 操作来达到目的
  - 在`dp[i-1][j]` 的基础上做insert操作来达到目的
  - 在`dp[i][j-1]` 的基础上做insert操作来达到目的

- 取三者最小情况即可

**代码示例**

```
	public int minDistance(String word1, String word2) {

		int len1 = word1.length();
		int len2 = word2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];

		for (int i = 1; i <= len2; i++) {
			dp[0][i] = dp[0][i - 1] + 1;
		}
		for (int j = 1; j <= len1; j++) {
			dp[j][0] = dp[j - 1][0] + 1;
		}
		for (int i = 1; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
				}
			}
		}
		return dp[len1][len2];

	}
```

### 8. 字典树 （Trie）

字典树，即Trie树，又称单词查找树或键树，是一种数据结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。

优点在于：最大限度的减少无谓的字符串比较，查找效率比哈希表高。

基本性质：

- 节点本身不存完整单词；
- 从根节点到某一节点路径上经过的字符链接起来，为该节点的字符串；
- 每个节点的所有子节点路径代表字符都不相同。

**核心思想** Trie树的核心思想就是空间换时间 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的

**Trie代码模板**

```
class TrieNode {
	private TrieNode[] links;
	private final int R = 26;
	private boolean isEnd;

	public TrieNode() {
		links = new TrieNode[R];
	}

	public boolean containskey(char ch) {
		return links[ch - 'a'] != null;
	}

	public TrieNode get(char ch) {
		return links[ch - 'a'];
	}

	public void put(char ch, TrieNode node) {
		links[ch - 'a'] = node;
	}

	public void setEnd() {
		isEnd = true;
	}

	public boolean isEnd() {
		return isEnd;
	}
}

public class Trie208 {

	private TrieNode root;

	public Trie208() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (!node.containskey(ch)) {
				node.put(ch, new TrieNode());
			}
			node = node.get(ch);
		}
		node.setEnd();
	}

	public boolean search(String word) {
		TrieNode node = searchprefix(word);
		return node != null && node.isEnd();
	}

	private TrieNode searchprefix(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (node.containskey(ch)) {
				node = node.get(ch);
			} else {
				return null;
			}
		}
		return node;
	}

	public boolean startwith(String prefix) {
		TrieNode node = searchprefix(prefix);
		return node != null;
	}
}
```

### 9. 并查集

**适用场景** 组团、配对问题 适用场景：组团、配对问题

**基本操作：** makeset(s)：建立一个新的并查集，其中包括s个单位元素集合； unionset(s):把元素x和y所在的元素集合合并，要求x和y所在的集合不相交，如果相交则不合并； find(x):找到元素x所在的集合的代表，该操作也可以用于判断两个元素是否位于同一个集合，只要将他们各自的代表比较一下即可；

**并查集代码模板**

```
class Unionimpl{
	private int count = 0;
	private int []parent;
	public Unionimpl(int n){
		count = n;
		parent = new int[n];
		for(int i = 0; i < n; i++){
			parent[i] = i;
		}	
	}
	public int getcount(){
		return count;
	}
	public int find(int p){
		while( p != parent[i]){
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}
	public void union(int p ,int q){
		int rootp = find(p);
		int rootq = find(q);
		if(rootp ==rootq){
			return;
		}
		parent[rootp] = rootq;
		count --;
	}
}
```

### 10. LRU Cache缓存

**最少最近使用**

两个要素：大小、替换策略 HashTable + Double LinkedList

**代码模板**

```
public class LRUCache {

	class LRUCache {
		// key -> Node(key, val)
		private HashMap<Integer, Node> map;
		// Node(k1, v1) <-> Node(k2, v2)...
		private DoubleList cache;
		// 最大容量
		private int cap;

		public LRUCache(int capacity) {
			this.cap = capacity;
			map = new HashMap<>();
			cache = new DoubleList();
		}

		public int get(int key) {
			if (!map.containsKey(key))
				return -1;
			int val = map.get(key).val;
			// 利用 put 方法把该数据提前
			put(key, val);
			return val;
		}

		public void put(int key, int val) {
			// 先把新节点 x 做出来
			Node x = new Node(key, val);

			if (map.containsKey(key)) {
				// 删除旧的节点，新的插到头部
				cache.remove(map.get(key));
				cache.addFirst(x);
				// 更新 map 中对应的数据
				map.put(key, x);
			} else {
				if (cap == cache.size()) {
					// 删除链表最后一个数据
					Node last = cache.removeLast();
					map.remove(last.key);
				}
				// 直接添加到头部
				cache.addFirst(x);
				map.put(key, x);
			}
		}
	}

}

class Node {
	public int key, val;
	public Node next, prev;

	public Node(int k, int v) {
		this.key = k;
		this.val = v;
	}
}

class DoubleList {
	private Node head, tail; // 头尾虚节点
	private int size; // 链表元素数

	public DoubleList() {
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	// 在链表头部添加节点 x
	public void addFirst(Node x) {
		x.next = head.next;
		x.prev = head;
		head.next.prev = x;
		head.next = x;
		size++;
	}

	// 删除链表中的 x 节点（x 一定存在）
	public void remove(Node x) {
		x.prev.next = x.next;
		x.next.prev = x.prev;
		size--;
	}

	// 删除链表中最后一个节点，并返回该节点
	public Node removeLast() {
		if (tail.prev == head)
			return null;
		Node last = tail.prev;
		remove(last);
		return last;
	}

	// 返回链表长度
	public int size() {
		return size;
	}
}
```

**LeetCode146. LRU缓存机制** 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

```
示例:

LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4
```

**题解代码**

```
class LRUCache extends LinkedHashMap<Integer, Integer> {
	private int capacity;

	public LRUCache(int capacity) {
		super(capacity, 0.75F, true);
		this.capacity = capacity;
	}

	public int get(int key) {
		return super.getOrDefault(key, -1);
	}

	public void put(int key, int value) {
		super.put(key, value);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}
}
```

### 11. 布隆过滤器

本质上布隆过滤器是一种数据结构，比较巧妙的概率型数据结构（probabilistic data structure），特点是高效地插入和查询，可以用来告诉你 “某样东西一定不存在或者可能存在”。

相比于传统的 List、Set、Map 等数据结构，它更高效、占用空间更少，但是缺点是其返回的结果是概率性的，而不是确切的

**实现原理**

HashMap 的问题 讲述布隆过滤器的原理之前，我们先思考一下，通常你判断某个元素是否存在用的是什么？应该蛮多人回答 HashMap 吧，确实可以将值映射到 HashMap 的 Key，然后可以在 O(1) 的时间复杂度内返回结果，效率奇高。但是 HashMap 的实现也有缺点，例如存储容量占比高，考虑到负载因子的存在，通常空间是不能被用满的，而一旦你的值很多例如上亿的时候，那 HashMap 占据的内存大小就变得很可观了。

还比如说你的数据集存储在远程服务器上，本地服务接受输入，而数据集非常大不可能一次性读进内存构建 HashMap 的时候，也会存在问题。

**布隆过滤器数据结构** 对于上图而言c元素肯定不在布隆过滤器的索引里面，但是B的索引对应的二进制位刚好都为1，所以二进制位都为1并不代表就存在；但是二进制有0就一定不存在；

结论：布隆过滤器是存在于缓存中用来较粗的过滤，布隆过滤器中查不到的元素一定不存在，查的到的元素不一定存在。

### 12. 位运算

[![在这里插入图片描述](https://camo.githubusercontent.com/b630f1bd441d2477f939f4d6e5462b284d98720f/68747470733a2f2f696d672d626c6f672e6373646e696d672e636e2f32303139313231373231333632333130342e706e673f782d6f73732d70726f636573733d696d6167652f77617465726d61726b2c747970655f5a6d46755a33706f5a57356e6147567064476b2c736861646f775f31302c746578745f6148523063484d364c7939696247396e4c6d4e7a5a473475626d56304c3031705957397a61485676643256752c73697a655f31362c636f6c6f725f4646464646462c745f3730)](https://camo.githubusercontent.com/b630f1bd441d2477f939f4d6e5462b284d98720f/68747470733a2f2f696d672d626c6f672e6373646e696d672e636e2f32303139313231373231333632333130342e706e673f782d6f73732d70726f636573733d696d6167652f77617465726d61726b2c747970655f5a6d46755a33706f5a57356e6147567064476b2c736861646f775f31302c746578745f6148523063484d364c7939696247396e4c6d4e7a5a473475626d56304c3031705957397a61485676643256752c73697a655f31362c636f6c6f725f4646464646462c745f3730) [![在这里插入图片描述](https://camo.githubusercontent.com/a6f2f03dc01163eb10df59443f4cecac1c8b20e4/68747470733a2f2f696d672d626c6f672e6373646e696d672e636e2f32303139313231373231333533303235352e706e673f782d6f73732d70726f636573733d696d6167652f77617465726d61726b2c747970655f5a6d46755a33706f5a57356e6147567064476b2c736861646f775f31302c746578745f6148523063484d364c7939696247396e4c6d4e7a5a473475626d56304c3031705957397a61485676643256752c73697a655f31362c636f6c6f725f4646464646462c745f3730)](https://camo.githubusercontent.com/a6f2f03dc01163eb10df59443f4cecac1c8b20e4/68747470733a2f2f696d672d626c6f672e6373646e696d672e636e2f32303139313231373231333533303235352e706e673f782d6f73732d70726f636573733d696d6167652f77617465726d61726b2c747970655f5a6d46755a33706f5a57356e6147567064476b2c736861646f775f31302c746578745f6148523063484d364c7939696247396e4c6d4e7a5a473475626d56304c3031705957397a61485676643256752c73697a655f31362c636f6c6f725f4646464646462c745f3730)按位异或的一些特殊情况

| x^0                 | x                         |
| ------------------- | ------------------------- |
| x ^ 1s( 1s表示全1） | ~x                        |
| x^(~x)              | 1s                        |
| x ^ x               | 0                         |
| c = a ^ b           | a ^ c = b， b ^ c =a      |
| a ^ b ^ c           | a ^ (b ^ c) = (a ^ b) ^ c |

指定位置的位运算

| 将x最右边的n位清零         | x&（~0<<n）             |
| -------------------------- | ----------------------- |
| 获取x的第n位的幂值         | x &（1<< (n-1) ）       |
| 获取x的第n位值（0或1）     | （x >> n） & 1          |
| 仅将第n位置为1             | x `                     |
| 仅将第n位置为0             | x & (~1 <<n ))          |
| 将x最高位至第n位（含）清零 | x & （（1<<n）-1）      |
| 将第n位至第0位（含）清零   | x &(~（（1<<(n+1）-1）) |

位运算实际应用

| 判断奇偶    |               |
| ----------- | ------------- |
| x % 2 ==1   | （x &1）==1   |
| x %2 ==0    | （x&1） == 0  |
| x>>1        | x/2           |
| x = x&(x-1) | 清零最低位的1 |
| x & -x      | 得到最低位的1 |
| x& ~x       | 0             |

### 13. 排序算法

十种常见排序算法可以分为两大类：

- 比较类排序：通过比较来决定元素间的相对次序，由于其时间复杂度不能突破O(nlogn)，因此也称为非线性时间比较类排序。

- 非比较类排序：不通过比较来决定元素间的相对次序，它可以突破基于比较排序的时间下界，以线性时间运行，因此也称为线性时间非比较类排序。

  **算法复杂度**

- 稳定：如果a原本在b前面，而a=b，排序之后a仍然在b的前面。

- 不稳定：如果a原本在b的前面，而a=b，排序之后 a 可能会出现在 b 的后面。

- 时间复杂度：对排序数据的总的操作次数。反映当n变化时，操作次数呈现什么规律。

- 空间复杂度：是指算法在计算机内执行时所需存储空间的度量，它也是数据规模n的函数。

**①冒泡排序–Bubble Sort**

冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。

**算法描述**

- 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
- 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
- 针对所有的元素重复以上的步骤，除了最后一个； 重复步骤1~3，直到排序完成。

#### ②选择排序（Selection Sort）

选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。

**算法描述** n个记录的直接选择排序可经过n-1趟直接选择排序得到有序结果。具体算法描述如下：

- 初始状态：无序区为R[1…n]，有序区为空；
- 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1…i-1]和R(i…n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，将它与无序区的第1个记录R交换，使R[1…i]和R[i+1…n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
- n-1趟结束，数组有序化了。

#### 算法分析

表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法了吧。

**③插入排序（Insertion Sort）**

插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。 **算法描述** 一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：

- 从第一个元素开始，该元素可以认为已经被排序；
- 取出下一个元素，在已经排序的元素序列中从后向前扫描；
- 如果该元素（已排序）大于新元素，将该元素移到下一位置；
- 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
- 将新元素插入到该位置后；
- 重复步骤2~5。

#### 算法分析

插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。

**④希尔排序（Shell Sort）**

1959年Shell发明，第一个突破O(n2)的排序算法，是简单插入排序的改进版。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序。

**算法描述** 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：

- 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
- 按增量序列个数k，对序列进行k 趟排序；
- 每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。

**代码示例**

```
function shellSort(arr) {
    var len = arr.length;
    for (var gap = Math.floor(len / 2); gap > 0; gap = Math.floor(gap / 2)) {
        // 注意：这里和动图演示的不一样，动图是分组执行，实际操作是多个分组交替执行
        for (var i = gap; i < len; i++) {
            var j = i;
            var current = arr[i];
            while (j - gap >= 0 && current < arr[j - gap]) {
                 arr[j] = arr[j - gap];
                 j = j - gap;
            }
            arr[j] = current;
        }
    }
    return arr;
}
```

希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态的定义间隔序列。

**⑤归并排序（Merge Sort）**

归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2路归并

**算法描述**

- 把长度为n的输入序列分成两个长度为n/2的子序列；
- 对这两个子序列分别采用归并排序；
- 将两个排序好的子序列合并成一个最终的排序序列。

**代码示例**

```
function mergeSort(arr) {
    var len = arr.length;
    if (len < 2) {
        return arr;
    }
    var middle = Math.floor(len / 2),
        left = arr.slice(0, middle),
        right = arr.slice(middle);
    return merge(mergeSort(left), mergeSort(right));
}
 
function merge(left, right) {
    var result = [];
 
    while (left.length>0 && right.length>0) {
        if (left[0] <= right[0]) {
            result.push(left.shift());
        } else {
            result.push(right.shift());
        }
    }
 
    while (left.length)
        result.push(left.shift());
 
    while (right.length)
        result.push(right.shift());
 
    return result;
}
```

**算法分析** 归并排序是一种稳定的排序方法。和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(nlogn）的时间复杂度。代价是需要额外的内存空间。

**⑥快速排序（Quick Sort）**

快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。

**算法描述：** 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：

- 从数列中挑出一个元素，称为 “基准”（pivot）；

- 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；

- 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。

  **代码示例**

```
function quickSort(arr, left, right) {
    var len = arr.length,
        partitionIndex,
        left = typeof left != 'number' ? 0 : left,
        right = typeof right != 'number' ? len - 1 : right;
 
    if (left < right) {
        partitionIndex = partition(arr, left, right);
        quickSort(arr, left, partitionIndex-1);
        quickSort(arr, partitionIndex+1, right);
    }
    return arr;
}
 
function partition(arr, left ,right) {     // 分区操作
    var pivot = left,                      // 设定基准值（pivot）
        index = pivot + 1;
    for (var i = index; i <= right; i++) {
        if (arr[i] < arr[pivot]) {
            swap(arr, i, index);
            index++;
        }       
    }
    swap(arr, pivot, index - 1);
    return index-1;
}
 
function swap(arr, i, j) {
    var temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
```

**⑦堆排序（Heap Sort）**

堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。

**算法描述**

- 将初始待排序关键字序列(R1,R2….Rn)构建成大顶堆，此堆为初始的无序区；
- 将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,……Rn-1)和新的有序区(Rn),且满足R[1,2…n-1]<=R[n]；
- 由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,……Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2….Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。

**代码示例**

```
var len;    // 因为声明的多个函数都需要数据长度，所以把len设置成为全局变量
 
function buildMaxHeap(arr) {   // 建立大顶堆
    len = arr.length;
    for (var i = Math.floor(len/2); i >= 0; i--) {
        heapify(arr, i);
    }
}
 
function heapify(arr, i) {     // 堆调整
    var left = 2 * i + 1,
        right = 2 * i + 2,
        largest = i;
 
    if (left < len && arr[left] > arr[largest]) {
        largest = left;
    }
 
    if (right < len && arr[right] > arr[largest]) {
        largest = right;
    }
 
    if (largest != i) {
        swap(arr, i, largest);
        heapify(arr, largest);
    }
}
 
function swap(arr, i, j) {
    var temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
 
function heapSort(arr) {
    buildMaxHeap(arr);
 
    for (var i = arr.length - 1; i > 0; i--) {
        swap(arr, 0, i);
        len--;
        heapify(arr, 0);
    }
    return arr;
}
```

**⑧计数排序（Counting Sort）**

计数排序不是基于比较的排序算法，其核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。

**算法描述**

- 找出待排序的数组中最大和最小的元素；
- 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
- 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
- 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。

**代码示例**

```
function countingSort(arr, maxValue) {
    var bucket = new Array(maxValue + 1),
        sortedIndex = 0;
        arrLen = arr.length,
        bucketLen = maxValue + 1;
 
    for (var i = 0; i < arrLen; i++) {
        if (!bucket[arr[i]]) {
            bucket[arr[i]] = 0;
        }
        bucket[arr[i]]++;
    }
 
    for (var j = 0; j < bucketLen; j++) {
        while(bucket[j] > 0) {
            arr[sortedIndex++] = j;
            bucket[j]--;
        }
    }
 
    return arr;
}
```

**算法分析**

计数排序是一个稳定的排序算法。当输入的元素是 n 个 0到 k 之间的整数时，时间复杂度是O(n+k)，空间复杂度也是O(n+k)，其排序速度快于任何比较排序算法。当k不是很大并且序列比较集中时，计数排序是一个很有效的排序算法。

**⑨桶排序（Bucket Sort）**

桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排）。

**算法描述**

- 设置一个定量的数组当作空桶；
- 遍历输入数据，并且把数据一个一个放到对应的桶里去；
- 对每个不是空的桶进行排序；
- 从不是空的桶里把排好序的数据拼接起来

**代码示例**

```
function bucketSort(arr, bucketSize) {
    if (arr.length === 0) {
      return arr;
    }
 
    var i;
    var minValue = arr[0];
    var maxValue = arr[0];
    for (i = 1; i < arr.length; i++) {
      if (arr[i] < minValue) {
          minValue = arr[i];                // 输入数据的最小值
      } else if (arr[i] > maxValue) {
          maxValue = arr[i];                // 输入数据的最大值
      }
    }
 
    // 桶的初始化
    var DEFAULT_BUCKET_SIZE = 5;            // 设置桶的默认数量为5
    bucketSize = bucketSize || DEFAULT_BUCKET_SIZE;
    var bucketCount = Math.floor((maxValue - minValue) / bucketSize) + 1;  
    var buckets = new Array(bucketCount);
    for (i = 0; i < buckets.length; i++) {
        buckets[i] = [];
    }
 
    // 利用映射函数将数据分配到各个桶中
    for (i = 0; i < arr.length; i++) {
        buckets[Math.floor((arr[i] - minValue) / bucketSize)].push(arr[i]);
    }
 
    arr.length = 0;
    for (i = 0; i < buckets.length; i++) {
        insertionSort(buckets[i]);                      // 对每个桶进行排序，这里使用了插入排序
        for (var j = 0; j < buckets[i].length; j++) {
            arr.push(buckets[i][j]);                     
        }
    }
 
    return arr;
}
```

**算法分析**

桶排序最好情况下使用线性时间O(n)，桶排序的时间复杂度，取决与对各个桶之间数据进行排序的时间复杂度，因为其它部分的时间复杂度都为O(n)。很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。

**⑩基数排序（Radix Sort）**

基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。

**算法描述**

- 取得数组中的最大数，并取得位数；
- arr为原始数组，从最低位开始取每个位组成radix数组；
- 对radix进行计数排序（利用计数排序适用于小范围数的特点）；

**代码示例**

```
var counter = [];
function radixSort(arr, maxDigit) {
    var mod = 10;
    var dev = 1;
    for (var i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
        for(var j = 0; j < arr.length; j++) {
            var bucket = parseInt((arr[j] % mod) / dev);
            if(counter[bucket]==null) {
                counter[bucket] = [];
            }
            counter[bucket].push(arr[j]);
        }
        var pos = 0;
        for(var j = 0; j < counter.length; j++) {
            var value = null;
            if(counter[j]!=null) {
                while ((value = counter[j].shift()) != null) {
                      arr[pos++] = value;
                }
          }
        }
    }
    return arr;
}
```

**算法分析**

基数排序基于分别排序，分别收集，所以是稳定的。但基数排序的性能比桶排序要略差，每一次关键字的桶分配都需要O(n)的时间复杂度，而且分配之后得到新的关键字序列又需要O(n)的时间复杂度。假如待排数据可以分为d个关键字，则基数排序的时间复杂度将是O(d*2n) ，当然d要远远小于n，因此基本上还是线性级别的。

基数排序的空间复杂度为O(n+k)，其中k为桶的数量。一般来说n>>k，因此额外空间需要大概n个左右。

### 14. 经典题

爬楼梯: https://leetcode-cn.com/problems/climbing-stairs/

硬币兑换: https://leetcode-cn.com/problems/coin-change/

有效括号: https://leetcode-cn.com/problems/valid-parentheses/

括号生成: https://leetcode-cn.com/problems/generate-parentheses/

柱状图中最大的矩形: https://leetcode-cn.com/problems/largest-rectangle-in-histogram/

滑动窗口最大值: https://leetcode-cn.com/problems/sliding-window-maximum/

二叉树遍历:

- 二叉树的层次遍历:https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
- 二叉树的前序遍历: https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
- 二叉树的中序遍历: https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
- 二叉树的后序遍历: https://leetcode-cn.com/problems/binary-tree-postorder-traversal/

验证二叉搜索树: https://leetcode-cn.com/problems/validate-binary-search-tree/submissions/

股票买卖:

- 买卖股票的最佳时机 IV https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/

打家劫舍:

- 打家劫舍 II: https://leetcode-cn.com/problems/house-robber-ii/

编辑距离: https://leetcode-cn.com/problems/edit-distance/

最长上升子序列: https://leetcode-cn.com/problems/longest-increasing-subsequence/

最长公共子序列: https://leetcode-cn.com/problems/longest-common-subsequence/

字母异位词分组: https://leetcode-cn.com/problems/group-anagrams/

回文串:

- 最长回文子串: https://leetcode-cn.com/problems/longest-palindromic-substring/

通配符匹配: https://leetcode-cn.com/problems/wildcard-matching/

高级数据结构（Trie、 BloomFilter、 LRU cache、 etc）