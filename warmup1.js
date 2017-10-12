nearHundred = function(n) { 
	return (Math.abs(100 - n) <= 10) || (Math.abs(200 - n) <= 10);
}

var diff21 = function(n) { 
	if (n < 21) return 21 - n;
  	else return (n - 21) * 2;
}

missingChar = function(str, n) { 
	return str.substring(0, n) + str.substring(n + 1);
}

var backAround = function(str) { 
	return str.substring(str.length - 1) + str + str.substring(str.length - 1);
}
