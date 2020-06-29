// stack LIFO

Deque<String> deque = new LinkedList<String>();
deque.addFirst('a'); // deque.push('a');
deque.addFirst('b');
deque.addFirst('c');
System.out.println(deque); //abc

String str = deque.peekFirst(); // deque.peek();
System.out.println(str);  //c
System.out.println(deque);  // abc

while(deque.size() > 0){
    System.out.println(deque.removeFirst());
    // c
    // b
    // a
}
System.out.println(deque);  // ""
