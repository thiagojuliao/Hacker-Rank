public static String getSmallestAndLargest(String s, int k) {
	String smallest = "";
	String largest = "";
	
	for (int i = 0; i <= s.length() - k; i++){

		String substr = s.substring(i, i + k);
		int isSmall = substr.compareTo(smallest);
		int isLarge = substr.compareTo(largest);

		if (smallest.isEmpty() || isSmall < 0){
			
			smallest = substr;
		}

		if (isLarge > 0){

			largest = substr;
		}
	}
	
	return smallest + "\n" + largest;
}

