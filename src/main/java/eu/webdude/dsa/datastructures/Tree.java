package eu.webdude.dsa.datastructures;

import java.util.*;
import java.util.function.Consumer;

public class Tree<T extends Comparable<T>> implements Comparable<Tree<T>> {

	private final T value;

	private final List<Tree<T>> children;

	public Tree(T value, Tree<T>... children) {
		this.value = value;
		this.children = Arrays.asList(children);
	}

	public String print(int indent, StringBuilder builder) {
		builder.append(new String(new char[indent]).replace("\0", "  "));
		builder.append(getValue());
		builder.append(System.lineSeparator());
		getChildren().forEach(x -> x.print(indent + 1, builder));
		return builder.toString();
	}

	public void each(Consumer<T> consumer) {
		consumer.accept(getValue());
		getChildren().forEach(x -> x.each(consumer));
	}

	public Iterable<T> orderDFS() {
		LinkedList<T> result = new LinkedList<>();
		Stack<Tree<T>> stack = new Stack<>();
		stack.push(this);

		while (stack.size() > 0) {
			Tree<T> currentOne = stack.pop();
			result.addFirst(currentOne.getValue());
			currentOne.getChildren().forEach(stack::push);
		}

		return result;
	}

	public Iterable<T> orderBFS() {
		ArrayList<T> result = new ArrayList<>();
		Queue<Tree<T>> queue = new ArrayDeque<>();
		queue.add(this);

		while (queue.size() > 0) {
			Tree<T> currentOne = queue.remove();
			result.add(currentOne.getValue());
			queue.addAll(currentOne.getChildren());
		}

		return result;
	}

	public List<Tree<T>> getChildren() {
		return children;
	}

	public T getValue() {
		return value;
	}

	@Override
	public int compareTo(Tree<T> o) {
		return this.getValue().compareTo(o.getValue());
	}
}