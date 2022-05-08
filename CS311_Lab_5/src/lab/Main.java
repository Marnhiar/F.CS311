package lab;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		List<Integer> list = new List<Integer>();
		list.add(0, 0);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println((Object)list.get(0).getClass().getSimpleName() + " List");
		System.out.println("add \"Index\" \"Object\", remove \"Index\", get \"Index\", size, print, end");
		String cmd = sc.nextLine();
		
		while (cmd != "end") {
			switch(cmd.split(" ")[0]) {
			case "add":
				try {
					list.add(Integer.parseInt(cmd.split(" ")[1]), Integer.parseInt(cmd.split(" ")[2]));
				} catch (AssertionError e2) {
					System.err.println(e2);
				}
				break;
			case "remove":
				list.remove(Integer.parseInt(cmd.split(" ")[1]));
				break;
			case "get":
				System.out.println(list.get(Integer.parseInt(cmd.split(" ")[1])));
				break;
			case "indexOf":
				System.out.println(list.indexOf(Integer.parseInt(cmd.split(" ")[1])));
				break;
			case "size":
				System.out.println(list.size());
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
