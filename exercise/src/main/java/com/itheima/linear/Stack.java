package com.itheima.linear;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {


    //记录首节点
    private Node<T> head;
    //记录链表中元素个数
    private Integer N;

    public Stack() {
        head = new Node<>(null, null);
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    //把元素压入栈中
    public void push(T t) {
        Node oldNode = head.next;
        Node node = new Node<>(t, oldNode);
        head.next = node;
        N++;
    }

    //把元素弹出栈中
    public T pop() {
        Node oldNode = head.next;
        if (oldNode == null) {
            return null;
        }
        head.next = oldNode.next;

        N--;

        return (T) oldNode.item;
    }
    //获取栈中元素的个数
    public int size(){
        return N;
    }

    //判断string中的左右括号数量是否匹配
    //利用栈来储存左括号
    //遍历string如果是左括号就存入
    //如果是文字就略过
    //如果是右括号就弹出
    //如果栈的大小小于0就返回false
    public static boolean match(String str){
        //创建一个栈来储存左括号
        Stack<String> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if(c + ""=="("){
                stack.push(c+"");
            }else if(c+""==")"){
                String s = stack.pop();
                if(s==null){
                    return false;
                }
            }
            if(stack.size()<0){
                return false;
            }
        }
        //循环结束后如果stack的size大于0就返回false
        if(stack.size()>0){
            return false;
        }
        return true;
    }

    public static int caculate(String[] str){
        if(str.length ==0 && str==null){
            return 0;
        }
        Integer o1;
        Integer o2;
        Integer result;
        Stack<Integer> oprand = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            String c = str[i];
            switch (c) {
                case "+":
                    o1 = oprand.pop();
                    o2 = oprand.pop();
                    result = o1+o2;
                    oprand.push(result);
                    break;
                case "-":
                    o1 = oprand.pop();
                    o2 = oprand.pop();
                    result = o2 - o1;
                    oprand.push(result);
                    break;
                case "*":
                    o1 = oprand.pop();
                    o2 = oprand.pop();
                    result = o1*o2;
                    oprand.push(result);
                    break;
                case "/":
                    o1 = oprand.pop();
                    o2 = oprand.pop();
                    result = o2/o1;
                    oprand.push(result);
                    break;
                case "%":
                    o1 = oprand.pop();
                    o2 = oprand.pop();
                    result = o1%o2;
                    oprand.push(result);
                    break;
                case "^":
                    o1 = oprand.pop();
                    o2 = oprand.pop();
                    result = (int) Math.pow(o2, o1); // 幂运算
                    oprand.push(result);
                    break;
                default:
                    oprand.push(Integer.parseInt(c+""));
                    break;
            }
        }
        return oprand.pop();
    }


    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator<T>{
        private Node n = head;
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }
        @Override
        public T next() {
            Node node = n.next;
            n = n.next;
            return (T) node.item;
        }
    }

    public static void main(String[] args) {

//        Stack<String> stack = new Stack<>();
//        stack.push("a");
//        stack.push("b");
//        stack.push("c");
//        stack.push("d");
//        for (String str : stack) {
//            System.out.print(str+" ");
//        }
//        System.out.println("-----------------------------");
//        String result = stack.pop();
//        System.out.println("弹出了元素："+result);
//        System.out.println(stack.size());

//        String str = "(fdafds(fafds)())";
//        boolean match = match(str);
//        System.out.println(str + "中的括号是否匹配：" + match);


        //中缀表达式3*（17-15）+18/6的逆波兰表达式如下
        //中缀表达式3*（17-15）+18/6的逆波兰表达式如下
        String[] notation = {"3", "17", "15", "-","*","18","6","/","+"};
        int result = caculate(notation) ;


        System.out.println("逆波兰表达式的结果为："+ result);
    }
}
