package com.learn.ds.stack;

public class ArrayAsStack {

	private final int a[];
	int size;
	//stack to maintain available indexes in array.
	private AStack indexes;
	private AStack stackOne;
	private AStack stackTwo;
	private AStack stackThree;

	public ArrayAsStack(final int size) {
		this.size = size;
		indexes = new AStack();
		stackOne = new AStack();
		stackTwo = new AStack();
		stackThree = new AStack();
		a = new int[size];
		// pushing all indexes into stack in decreasing order, so that on
		// polling stack minimum index will come.
		for (int i = size - 1; i >= 0; i--) {
			indexes.push(i);
		}
	}

	public void pushOne(final int k) {
		push(stackOne, k);
	}

	public void pushTwo(final int k) {
		push(stackTwo, k);
	}

	public void pushThree(final int k) {
		push(stackThree, k);
	}

	private void push(final AStack stack, final int k) {
		if (indexes.peek() == null || indexes.peek() == size - 1) {
			System.out.println("Stack overflow");
			return;
		}

		final int index = indexes.pop();
		stack.push(index);
		a[index] = k;
	}

	public int popOne() {
		return pop(stackOne);
	}

	public int popTwo() {
		return pop(stackTwo);
	}

	public Integer popThree() {
		return pop(stackThree);
	}

	public Integer peekOne() {
		return peek(stackOne);
	}

	public Integer peekTwo() {
		return peek(stackTwo);
	}

	public Integer peekThree() {
		return peek(stackThree);
	}

	private Integer peek(final AStack stack) {
		return stack.peek();
	}

	private Integer pop(final AStack stack) {
		final Integer index = stack.pop();
		Integer item = null;
		if (index != null) {
			item = a[index];
			indexes.push(index);
		}

		return item;
	}

	public static void main(final String[] args) {
		final ArrayAsStack arrayAsStack = new ArrayAsStack(12);
		arrayAsStack.pushOne(2);
		arrayAsStack.pushTwo(4);
		arrayAsStack.pushThree(6);

		arrayAsStack.pushOne(5);
		arrayAsStack.pushTwo(8);
		arrayAsStack.pushThree(12);

		arrayAsStack.pushOne(11);
		arrayAsStack.pushTwo(13);
		arrayAsStack.pushThree(1);

		arrayAsStack.pushOne(21);
		arrayAsStack.pushTwo(41);
		arrayAsStack.pushThree(16);

		while (arrayAsStack.peekOne() != null) {
			System.out.println(arrayAsStack.popOne());
			System.out.println(arrayAsStack.popTwo());
			System.out.println(arrayAsStack.popThree());
		}
	}

}
