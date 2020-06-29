class MyCircularDeque {

    int[] items;
    int front,rear;
    int size;
    int capacity;
    /** Initialize your data structure here. Set the size of the deque to be k. */

    public MyCircularDeque(int k) {
        this.items = new int[k];
        this.capacity = k;
        this.size = 0;
        this.front = 0;
        this.rear = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(this.size == this.capacity){
            return false;
        }else{
            if(this.size != 0){
                for(int i = this.size - 1; i >= 0; i --){
                    this.items[i+1] = this.items[i];
                }
            }
            this.items[0] = value;
            this.size ++;
            return true;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(this.size == this.capacity){
            return false;
        }else{
            this.items[this.size] = value;
            this.size ++;
            return true;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(this.size == 0){
            return false;
        }else{
            for(int i = 1; i < this.size; i++){
                this.items[i-1] = this.items[i];
            }
            this.items[this.size -1] = -1;
            this.size --;
            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(this.size == 0){
            return false;
        }else{
            this.items[this.size -1] = -1;
            this.size --;
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(this.size == 0){
            return -1;
        }else{
            return this.items[0];
        }
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(this.size == 0){
            return -1;
        }else{
            return this.items[this.size -1];
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.size == this.capacity;
    }
}


// 基本操作实现了,但是线程安全什么的并没有考虑,请问老师这边出题者是否也有考察线程安全的意图