package algorithm;

import java.util.Stack;

//����ջʵ�ֶ���
public class StacksToQueue {
	
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
	
	//���Ԫ�ص���β   --����---
	public void addToTail(int n) {
		stack1.push(n);
	}
	
	//ɾ������      --����---
	public int deleteHead() {
		//�����ǶӲ�Ϊ�ղ���ɾ����������Ϊ�ն��в��ǿ� 
		if(stack1.size() + stack2.size() != 0) {
			if(stack2.isEmpty()) {
				while(!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
			return stack2.pop();
		}
		return -1;
	}
	
	public static void main(String[] args) {
		StacksToQueue q = new StacksToQueue();
		q.addToTail(1);
		q.addToTail(2);
		q.addToTail(3);
		System.out.println(q.deleteHead());
		System.out.println(q.deleteHead());
		q.addToTail(4);
		System.out.println(q.deleteHead());
		System.out.println(q.deleteHead());
		System.out.println(q.deleteHead());
	}
}
