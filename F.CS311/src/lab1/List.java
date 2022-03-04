package lab1;

import java.util.Scanner;

public class List {
	private Object[] elements;
	private int size = 0;
	
	public List(int capacity) {
		elements = new Object[capacity];
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

	public void add(int index, Object element) {
		if(size == elements.length)
			elements = changeArrayLength(elements, 2 * size);
		
		if(index > size)
			index = size;
		
		for (int i = size - 1; i >= index; i--)
	         elements[i + 1] = elements[i];
		
		elements[index] = element;
		size++;
	}
	
	private Object[] changeArrayLength(Object[] oldArray, int size) {
		Object[] newArray = new Object[size];
		
		for (int i=0; i<size; i++) {
			newArray[i] = oldArray[i];
		}
		
		return newArray;
	}

	public Object get(int index) {
		try {
			checkIndex(index);
		}
		catch (Exception e) {
			System.out.println("Wrong Index");
		}
		return elements[index];
	}
	
	public void remove(int index) {
		try {
			checkIndex(index);
		}
		catch (Exception e) {
			System.out.println("Wrong Index");
		}
			
		for(int i = index; i < elements.length - 1; i++)
			elements[i] = elements[i + 1];  
			
		elements[elements.length - 1] = null;
			
		size--;
	}

	public int indexOf(Object element) {
		for(int i = 0; i < elements.length; i++) {
			if(elements[i].equals(element))
				return i;
		}
		return -1;
	}

	public void checkIndex(int index) {
		if(index < 0 || index >= size) 
			throw new IndexOutOfBoundsException("index = " + index + "  size = " + size);
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
	
	public static void main(String args[]) {
		List list = new List();
		list.add(0, "S");
		Scanner sc = new Scanner(System.in);
		System.out.println("add \"Index\" \"Object\", remove \"Index\", get \"Index\", size, print, end");
		String cmd = sc.nextLine();
		
		while (cmd != "end") {
			switch(cmd.split(" ")[0]) {
			case "add":
				list.add(Integer.parseInt(cmd.split(" ")[1]), cmd.split(" ")[2]);
				break;
			case "remove":
				list.remove(Integer.parseInt(cmd.split(" ")[1]));
				break;
			case "get":
				System.out.println(list.get(Integer.parseInt(cmd.split(" ")[1])));
				break;
			case "indexOf":
				System.out.println(list.indexOf(cmd.split(" ")[1]));
				break;
			case "size":
				System.out.println(list.size);
				break;
			case "print":
				System.out.println(list);
				break;
			}
			
			System.out.println("add \"Index\" \"Object\", remove \"Index\", get \"Index\", size, print, end");
			cmd = sc.nextLine();
		}
		
		sc.close();
	}


}
