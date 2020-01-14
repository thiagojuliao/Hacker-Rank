Set<String> set = new HashSet<>();
String input;

for (int i = 0; i < t; i++){

	input = "(" + pair_left[i] + ", " + pair_right[i] + ")";
	set.add(input);
	
	System.out.println(set.size());
}
