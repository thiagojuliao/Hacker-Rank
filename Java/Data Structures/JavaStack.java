import java.util.*;
class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		String[] base = {"()", "{}", "[]"};
        int aux;
        int index;
        int breakpoint;

		while (sc.hasNext()) {
			String input=sc.next();
            aux = 0;
            index = 0;
            breakpoint = 0;

            while (breakpoint < 3){
                
                aux = input.length();
                input = input.replace(base[index], "");
                // System.out.println("Replace " + base[index] + " --> " + input + ", " + aux + "x" + input.length());

                if (input.length() == 0) break;
                if (input.length() < aux){
                    index = 0;
                    breakpoint = 0;
                }else{
                    index++;
                    breakpoint++;
                }
            }
                
            System.out.println(input.length() == 0?"true":"false");
		}
		
	}
}