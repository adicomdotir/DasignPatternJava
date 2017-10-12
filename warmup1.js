nearHundred = function(n) { 
	return (Math.abs(100 - n) <= 10) || (Math.abs(200 - n) <= 10);
}

var diff21 = function(n) { 
	if (n < 21) return 21 - n;
  	else return (n - 21) * 2;
} 
