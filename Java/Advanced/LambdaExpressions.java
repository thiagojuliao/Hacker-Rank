public PerformOperation isOdd(){
	return num -> num % 2 != 0;
}

public PerformOperation isPrime(){
	return num -> {
		if (num == 1) return false;
		for (int i = 2; i < num/2; i++){
			if (num % i == 0) return false;
		}
		return true;
	};
}

public PerformOperation isPalindrome(){
	return num -> {
		String s = String.valueOf(num);
		char[] c = s.toCharArray();

		for (int i = 0; i < s.length(); i++){
			if (c[i] != c[s.length() - 1 - i]) return false;
		}
		return true;
	};
}

