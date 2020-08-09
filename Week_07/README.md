学习笔记

## 递归代码模版

```java
public void recur(int level, int param){ 

// terminator

if(level > MAX_LEVEL){

// process result

return;

}

// precess current logic

process(level,param);

// drill down

recur(level: level + 1,newParam);   

// restore current status

}

```



## 分治模版

```python
def divide_conquer(problem,param1,param2,…):
  # recursion terminator
  if problem is None:
    print_result
    return
  # prepare data
  data = prepare_data(problem)
  subproblems = split_problem(problem,data)
  
  # conquer subproblems
  subresult1 = self divide_conquer(subproblems[0],p1,...)
  subresult1 = self divide_conquer(subproblems[0],p1,...)
  subresult1 = self divide_conquer(subproblems[0],p1,...)
  ...
  
  #process and generate the final result
  result = process_result(subresult1,subresult2,subresult3,...)
  
  # revert the current level states
  
  
```

## DFS

```
void dfs(TreeNode root) {
    if (root == null) {
        return;
    }
    dfs(root.left);
    dfs(root.right);
}
```



## BFS

```java
void bfs(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
}
```



## 动态规划关关键点

1. 最优子结构 opt[n] = best_of(opt[n-1],opt[n-2],...)

2. 存储中间状态：opt[i]

3. 递推公式(美其名曰：状态转移方程或者DP方程)

   Fib：opt[i] = opt[n-1] + opt[n-2]

   二维路径：opt[i,j] = opt[i+1,j] +opt[i,j+1] (且判断a[i,j]是否空地)

   


## 并查集代码模版

 ```java
/ Java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
 ```



