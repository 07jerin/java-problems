package com.jerin.javaprogramming.commonporblems;

public class ReverseLinkedListInplace {

	public static void main(String[] args) {
		LL<Integer> ll = new LL<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);

		System.out.println(ll.reverse());
		System.out.println(ll.reverse());
		ll.add(5);
		System.out.println(ll.getContent());
		System.out.println(ll.reverse());
		System.out.println(ll.reverse());
	}

	static class LL<T> {
		T value;
		LL<T> next;
		LL<T> head;
		LL<T> tail;

		public LL() {
			head = this;
			tail = this;
		}

		void add(T t) {
			if (tail.value == null) {
				tail.value = t;
			} else {
				tail.next = new LL<>();
				tail = tail.next;
				tail.value = t;
			}

		}

		String getContent() {
			StringBuilder sb = new StringBuilder();
			LL<T> current = head;
			while (current != null) {
				sb.append(current.value);
				current = current.next;
			}

			return sb.toString();
		}

		String reverse() {
			reverseList(head);
			return this.getContent();
		}

		private LL<T> reverseList(LL<T> current) {
			if (current.next == null) {
				head = current;
				return current;
			}
			LL<T> prev = current;
			current = reverseList(current.next);
			current.next = prev;
			prev.next = null;

			return prev;
		}
	}

}
