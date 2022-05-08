package lab;

import com.google.java.contract.*;

@Invariant({"0 <= index && index <= size"})
public class List<T> {
	private T[] elements;
	private int size = 0;
	
	public List(int capacity) {
		elements = (T[]) new Object[capacity];
	}
	
	public List() {
		this(10);
	}
	
	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0 ? true:false;
	}
	
	@Requires({"0 <= index && index <= size"})
	public void add(int index, T element) {
		if(size == elements.length)
			elements = (T[]) changeArrayLength(elements, 2 * size);
		
		assert 0 <= index && index <= size: "Wrong Index";
		
		for (int i = size - 1; i >= index; i--)
	         elements[i + 1] = elements[i];
		
		elements[index] = element;
		size++;
	}
	
	private T[] changeArrayLength(T[] oldArray, int size) {
		T[] newArray = (T[]) new Object[size];
		
		for (int i=0; i<size; i++) {
			newArray[i] = oldArray[i];
		}
		
		return newArray;
	}

	@Requires({"0 <= index && index <= size"})
	public T get(int index) {
		assert 0 <= index && index <= size: "Wrong Index";
		
		return elements[index];
	}
	
	@Requires({"0 <= index && index <= size"})
	public void remove(int index) {
		assert 0 <= index && index < size: "Wrong index";
			
		for(int i = index; i < elements.length - 1; i++)
			elements[i] = elements[i + 1];  
			
		elements[elements.length - 1] = null;
			
		size--;
	}

	public int indexOf(T element) {
		for(int i = 0; i < elements.length; i++) {
			if(elements[i].equals(element))
				return i;
		}
		return -1;
	}
	
	@Override
	public String toString() {
		String result = "{";
		if (size > 0) {
			result += elements[0].toString();
			for(int i = 1 ; i < size; i++) {
				result += ", "+elements[i].toString();
			}
		}
		result += "}";
		return result;
	}
}

