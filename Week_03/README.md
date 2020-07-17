学习笔记
知识点1
递归通用模板
```
// Java
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
递归写法
第一步 确定递归终结条件
第二步 当前任务出库
第三步 下探到下一层
第四步 递归结束存储递归结果

知识点2
算法中剪枝操作的应用
最优性剪枝，又称为上下界剪枝，是一种重要的搜索剪枝策略。它记录当前得到的最优值，如果当前结点已经无法产生比当前最优解更优的解时，可以提前回溯。
http://poj.org/problem?id=3900

