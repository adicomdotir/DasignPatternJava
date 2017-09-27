var size = 4;
var teams = [1, 2, 3, 4];
for (var i = 1; i < size; i++) {
	var str = '';
	for (var j = 0; j < size / 2; j++) {
		str += teams[j] + '-' + teams[size - j - 1] + ',';
	}
    alert(str);
    swap();
}

function swap() {
	var temp = teams[size - 1];
	for (var i = size - 1; i > 0; i--) {
		teams[i] = teams[i - 1];
	}
	teams[1] = temp;
};