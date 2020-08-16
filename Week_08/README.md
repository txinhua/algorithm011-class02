学习笔记

### 位运算

最低位设置为1

```java
pos & (-pos)
```

去最高位的1

```java
n&(n-1)
 
/*
若 n = 2^x 且x为自然数（即n为2的幂），则一定满足以下条件：
1.恒有 n & (n - 1) == 0，这是因为：
  n 二进制最高位为1，其余所有位为0；
  n−1 二进制最高位为0，其余所有位为1；
2.一定满足 n > 0。
*/
```



### 排序算法的时间复杂度

![849589-20180402133438219-1946132192](/Users/himmy/algorithm011-class02/Week_08/849589-20180402133438219-1946132192.png)

### 快速排序(quickSort O(nlog2n))

```java
public static void quickSort(int[] array,int begin, int end){
    if( end <= begain ) return;
    int pivot = partition(array,begain,end);
    quickSort(array,begain,pivot - 1);
    quickSort(array,pivot + 1,end);
}
static int partition(int[] a,int begain, int end){
  // pivot: 标杆位置，counter： 小于pivot的元素的个数
  int pivot= end，counter= begain;
  for(int i = begain;i<end;i++){
    if(a[i] < a[pivot]){
      int temp = a[counter];a[counter] = a[i]; a[i]=temp;
      counter++;
    }
  }
  int temp a[pivot];a[pivot] = a[counter];a[counter]=temp;
  return counter;
}
```

### 归并排序(O(nlog2n))

```java
public static void mergeSort(int[] array,int left,int right){
  if(right <= left) return;
  int mid = (left + right) >> 1;
  mergeSort(array,left,mid);
  mergeSort(array,mid+1,right);
  merge(array,left,mid,right);
}

public static void merge(int[] arr,int left,int mid, int right){
  int[] temp = new int[right-left+1];
  int i = left,j= mid+1,k=0;
  while(i <= mid && j <= right){
    temp[k++] = arr[i] <= arr[j] ? arr[i++]:arr[j++];
  }
  while(i <= mid) temp[k++] = arr[i++];
  while(j <= right)temp[k++] = arr[j++];
  for(int p = 0;p<temp.lenght;p++){
    arr[left+p] = temp[p];
  }
}
```

### 堆排序(O(nlog2n))

```java
static void heapify(int[] array,int length,int i){
  int left=2*i+1,right=2*i+2;
  int largest = i;
  if(left<length&&array[left]>array[largest]){
    largest = left;
  }
  if(right < length&&array[right]>array[largest]){
    largest = right;
  }
  if(largest != i){
    int temp = array[i];array[i]=array[largest];array[largest]=temp;
    heapify(array,length,largest);
  }
}

public static void heapSort(int[] array){
  if(array.length == 0)return;
  int length = array.length;
  for(int i = length/2 -1;i >= 0;i--){
    heapify(array,length,i);
  }
  for(int i = length-1;i >=0;i--){
    int temp = array[0];array[0]=array[i];array[i]=temp;
    heapify(array,i,0);
  }
}
```

### LRU

```java
class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
```



### 参考链接

[十大经典排序算法](https://www.cnblogs.com/onepixel/p/7674659.html)

[9种经典算法可视化动画](https://www.bilibili.com/video/av25136272)

[15种排序算法动画展示](https://www.bilibili.com/video/av63851336)

