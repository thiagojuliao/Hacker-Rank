//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Solution{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
        Map<String, Integer> phoneBook = new HashMap<>();

		int n=in.nextInt();
		in.nextLine();

		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();

            phoneBook.put(name, phone);
			in.nextLine();
		}

		while(in.hasNext())
		{
			String s=in.nextLine();
            int phone = phoneBook.getOrDefault(s, -1);
            
            System.out.println(phone != -1?s+"="+phone:
            "Not found");
		}
	}
}
