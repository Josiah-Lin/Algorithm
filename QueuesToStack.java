package algorithm;

import java.util.LinkedList;

//��������ʵ��һ��ջ
public class QueuesToStack {
	
	LinkedList<Integer> queue1 = new LinkedList<Integer>();
	LinkedList<Integer> queue2 = new LinkedList<Integer>();
	
	//��ջ
	public void pushStack(int n) {
		queue1.addLast(n);
	}
	
	//��ջ�������Ƿǿյ�ջ���ܳ�ջ
	public int popStack() {
		if(queue1.size() + queue2.size() != 0) {
			
			//�ѷǿն��е�n-1��ѹ��ն��У�ʣ�ĵ�n������,����һ������Ϊ�ա�
			if(queue1.isEmpty()) {
				while(queue2.size() > 1) {
					queue1.addLast(queue2.removeFirst());
				}
				return queue2.removeFirst();
			}else {
				while(queue1.size() > 1) {
					queue2.addLast(queue1.removeFirst());
				}
				return queue1.removeFirst();
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		QueuesToStack stack = new QueuesToStack();
		stack.pushStack(1);
		stack.pushStack(2);
		stack.pushStack(3);
		System.out.println(stack.popStack());
		System.out.println(stack.popStack());
		stack.pushStack(4);
		stack.pushStack(5);
		System.out.println(stack.popStack());
		System.out.println(stack.popStack());
		System.out.println(stack.popStack());
		System.out.println(stack.popStack());
	}
	
}
