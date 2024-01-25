package com.kh.list;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class B_Other {

	public static void main(String[] args) {
		B_Other b = new B_Other();
		b.method1();
//					b.method2();
//					b.method3();

	}

	/*
	 * Vector - 동기화(synahronized) 메서드로 구성 개면을 스레프면)
	 * 
	 */
//		public void metod1() {
//			Vector v = new Vector();
//				v.add(0);
//				v.add(1);
//				System.out.println(v);
//				System.out.println("size : " + v.size()); // 2
//				System.out.println("capacity : " + v.capacit()); //10
//				
//				v.trimToSize();
//				System.out.println("size : " + v.size());
//				System.out.println("capacity : " + v.capacit()); // 2
//		}
//		
	// 스택(마기막) : 마지막에 저장한 것을 제일 먼저 꺼내는 LIFO(Last In First Out)구조
	public void method1() {
		Stack s = new Stack();
		s.push(0);
		s.push(1);
		s.push(3);
		s.pop();
		s.push(4);
		s.pop();
		s.push(5);
		s.push(6);
		s.push(7);
		s.pop();
		System.out.println(s);
	}

	// 큐(Queue) : 처음에 저장한것을 제일 먼저 꺼내느 FIFO(First In First Out)
	public void method2() {
		// 큐는 인터페이스

		Queue q = new LinkedList();

		q.offer(0);
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.poll();
		q.add(4);
		q.remove();
		q.add(5);
		q.add(6);
		q.add(7);
		q.remove();

		System.out.println(q); // 3, 4, 5, 6, 7
	}
}