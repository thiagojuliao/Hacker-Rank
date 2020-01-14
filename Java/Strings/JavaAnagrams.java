static boolean isAnagram(String a, String b) {
	
	String A = a.toLowerCase();
	String B = b.toLowerCase();

	if (A.length() != B.length()){

		return false;
	}
	
	for (int i = 0; i < A.length(); i ++){

		char c = A.charAt(i);
		int freqA = 0;
		int freqB = 0;

		for (int j = 0; j < A.length(); j ++){

			freqA += c==A.charAt(j)?1:0;
			freqB += c==B.charAt(j)?1:0;
		}

		if (freqA != freqB){

			return false;
		}
	}

	return true;
}

