List<BigDecimal> bds = new ArrayList<>();
String[] ls = new String[n];

for (int i = 0; i < n; i++){
	bds.add(new BigDecimal(s[i]));
}

Collections.sort(bds);

for (int i = n - 1; i >= 0; i--){
	for (int j = 0; j < n; j++){
		if (s[j] != ""){
			int equals = new BigDecimal(s[j]).compareTo(bds.get(i));
			if (equals == 0){
				ls[n - 1 - i] = s[j];
				s[j] = "";
				break;
			}
		}
	}
}

for (int i = 0; i < n; i ++){
	s[i] = ls[i];
}

