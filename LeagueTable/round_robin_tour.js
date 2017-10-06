function Team(name, overall) {
	this.name = name;
	this.game = 0;
	this.win = 0;
	this.lose = 0;
	this.draw = 0;
	this.gf = 0;
	this.ga = 0;
	this.gd = 0;
	this.points = 0;
	this.overall = overall;
}

var teamsInfo = [];
var barca = new Team('Barcelona', 85);
var rm = new Team('RealMadrid', 86);
var psg = new Team('PSG', 83);
var chelsea = new Team('Chelsea', 83);
var inter = new Team('Inter', 81);
var milan = new Team('Milan', 79);
var t1 = new Team('SL Benfica', 79);
var t2 = new Team('FC Porto', 79);
var t3 = new Team('SC Braga', 75);
var t4 = new Team('Sporting CP', 78);
teamsInfo.push(barca, rm, psg, chelsea, inter, milan, t1, t2, t3, t4);

var size = teamsInfo.length;
var teams = [];
for (var i = 0; i < size; i++) {
	teams[i] = i;
}

function swap() {
	var temp = teams[size - 1];
	for (var i = size - 1; i > 0; i--) {
		teams[i] = teams[i - 1];
	}
	teams[1] = temp;
}

var col = 0;
for (var i = 1; i < size * 2 - 1; i++) {
	var str = '';
	var header = document.createElement("div");
	var bold = document.createElement("b");
	bold.appendChild(document.createTextNode("Week " + numberToText(i)));
	header.appendChild(bold);
	if (col === 0) {
		document.getElementById('figure3').appendChild(header);
	} else if (col === 1) {
		document.getElementById('figure2').appendChild(header);
	} else if (col === 2) {
		document.getElementById('figure').appendChild(header);
	}
	for (var j = 0; j < size / 2; j++) {
		var diff = teamsInfo[teams[j]].overall - teamsInfo[teams[size - j - 1]].overall;
		var mulA = 0,
			mulB = 0;
		if (diff > 0) {
			mulA = diff / 2;
			mulB = diff / 4;
		} else if (diff < 0) {
			mulA = diff / 4;
			mulB = diff / 2;
		}
		mulA = Math.floor(Math.abs(mulA));
		mulB = Math.floor(Math.abs(mulB));
		var gA = Math.floor(Math.random() * (mulA + 1));
		var gB = Math.floor(Math.random() * (mulB + 1));
		// console.log(mulA + '[' + gA + ':' + gB + ']' + mulB);
		// console.log(gA);
		if (gA === gB) {
			teamsInfo[teams[j]].game++;
			teamsInfo[teams[j]].draw++;
			teamsInfo[teams[j]].points++;
			teamsInfo[teams[j]].gf += gA;
			teamsInfo[teams[j]].ga += gB;
			teamsInfo[teams[size - j - 1]].game++;
			teamsInfo[teams[size - j - 1]].draw++;
			teamsInfo[teams[size - j - 1]].points++;
			teamsInfo[teams[size - j - 1]].gf += gB;
			teamsInfo[teams[size - j - 1]].ga += gA;
		} else if (gA > gB) {
			teamsInfo[teams[j]].game++;
			teamsInfo[teams[j]].win++;
			teamsInfo[teams[j]].points += 3;
			teamsInfo[teams[j]].gf += gA;
			teamsInfo[teams[j]].ga += gB;
			teamsInfo[teams[size - j - 1]].game++;
			teamsInfo[teams[size - j - 1]].lose++;
			teamsInfo[teams[size - j - 1]].gf += gB;
			teamsInfo[teams[size - j - 1]].ga += gA;
		} else {
			teamsInfo[teams[j]].game++;
			teamsInfo[teams[j]].lose++;
			teamsInfo[teams[j]].gf += gA;
			teamsInfo[teams[j]].ga += gB;
			teamsInfo[teams[size - j - 1]].game++;
			teamsInfo[teams[size - j - 1]].win++;
			teamsInfo[teams[size - j - 1]].points += 3;
			teamsInfo[teams[size - j - 1]].gf += gB;
			teamsInfo[teams[size - j - 1]].ga += gA;
		}
		var div1 = document.createElement("div");
		div1.setAttribute('class', 'col-md-4');
		addAttributeColor(gA, gB, div1);
		div1.appendChild(document.createTextNode(teamsInfo[teams[j]].name));
		var div2 = document.createElement("div");
		div2.setAttribute('class', 'col-md-4');
		div2.appendChild(document.createTextNode(gA + '-' + gB));
		var div3 = document.createElement("div");
		div3.setAttribute('class', 'col-md-4');
		addAttributeColor(gB, gA, div3);
		div3.appendChild(document.createTextNode(teamsInfo[teams[size - j - 1]].name));
		if (col === 0) {
			document.getElementById('figure3').appendChild(div1);
			document.getElementById('figure3').appendChild(div2);
			document.getElementById('figure3').appendChild(div3);
		} else if (col === 1) {
			document.getElementById('figure2').appendChild(div1);
			document.getElementById('figure2').appendChild(div2);
			document.getElementById('figure2').appendChild(div3);
		} else if (col === 2) {
			document.getElementById('figure').appendChild(div1);
			document.getElementById('figure').appendChild(div2);
			document.getElementById('figure').appendChild(div3);
		}
	}
	// console.log(col);
	col++;
	if (col === 3) {
		col = 0;
	}
	swap();
}
sort();

// console.log(teamsInfo);
for (var i = 0; i < size; i++) {
	var row = document.createElement("tr");
	var col = document.createElement("td");
	col.appendChild(document.createTextNode(i + 1));
	row.appendChild(col);
	for (var key in teamsInfo[i]) {
		var col = document.createElement("td");
		if (key === 'gd') {
			col.appendChild(document.createTextNode(teamsInfo[i]['gf'] - teamsInfo[i]['ga']));
			row.appendChild(col);
		} else if (key !== 'overall') {
			col.appendChild(document.createTextNode(teamsInfo[i][key]));
			row.appendChild(col);
		}
	}
	document.getElementById('tbody').appendChild(row);
}

function sort() {
	// For calculate Goal Different
	for (var i = 0; i < size; i++) {
		teamsInfo[i].gd = teamsInfo[i].gf - teamsInfo[i].ga;
	}
	// This loop for sort points
	for (var i = 0; i < size; i++) {
		for (var j = i + 1; j < size; j++) {
			if (teamsInfo[j].points > teamsInfo[i].points) {
				var temp = teamsInfo[j];
				teamsInfo[j] = teamsInfo[i];
				teamsInfo[i] = temp;
			}
		}
	}
	// This loop for sort GD
	for (var i = 0; i < size; i++) {
		for (var j = i + 1; j < size; j++) {
			if (teamsInfo[j].points === teamsInfo[i].points) {
				// console.log(teamsInfo[j].points + '===' + teamsInfo[i].points);
				if (teamsInfo[j].gd > teamsInfo[i].gd) {
					// console.log(teamsInfo[j].gd + '>' + teamsInfo[i].gd);
					var temp = teamsInfo[j];
					teamsInfo[j] = teamsInfo[i];
					teamsInfo[i] = temp;
				}
			}
		}
	}
	// This loop for sort GF
	for (var i = 0; i < size; i++) {
		for (var j = i + 1; j < size; j++) {
			if (teamsInfo[j].points === teamsInfo[i].points) {
				// console.log(teamsInfo[j].points + '===' + teamsInfo[i].points);
				if (teamsInfo[j].gd === teamsInfo[i].gd) {
					// console.log(teamsInfo[j].gd + '===' + teamsInfo[i].gd);
					if (teamsInfo[j].gf > teamsInfo[i].gf) {
						// console.log(teamsInfo[j].gf + '>' + teamsInfo[i].gf);
						var temp = teamsInfo[j];
						teamsInfo[j] = teamsInfo[i];
						teamsInfo[i] = temp;
					}
				}
			}
		}
	}
}

function numberToText(num) {
	if (num > 99) {
		return 'Error';
	}
	if (num > 20 && num % 10 !== 0) {
		var n1 = num % 10;
		var n2 = Math.floor(num / 10) * 10;
		return numberToText(n2) + numberToText(n1);
	}
	switch (num) {
		case 1:
			return 'One';
		case 2:
			return 'Two';
		case 3:
			return 'Three';
		case 4:
			return 'Four';
		case 5:
			return 'Five';
		case 6:
			return 'Six';
		case 7:
			return 'Seven';
		case 8:
			return 'Eight';
		case 9:
			return 'Nine';
		case 10:
			return 'Ten';
		case 11:
			return 'Eleven';
		case 12:
			return 'Twelve';
		case 13:
			return 'Thirteen';
		case 14:
			return 'Fourteen';
		case 15:
			return 'Fifteen';
		case 16:
			return 'Sixteen';
		case 17:
			return 'Seventeen';
		case 18:
			return 'Eightteen';
		case 19:
			return 'Nineteen';
		case 20:
			return 'Twenty';
		case 30:
			return 'Thirty';
		case 40:
			return 'Fourty';
		case 50:
			return 'Fifty';
		case 60:
			return 'Sixty';
		case 70:
			return 'Seventy';
		case 80:
			return 'Eighty';
		case 90:
			return 'Ninety';
	}
}

function addAttributeColor(gObj, gOther, obj) {
	if (gObj > gOther) {
		obj.setAttribute('style', 'color: #2CC990;');
	} else if (gObj < gOther) {
		obj.setAttribute('style', 'color: #E3000E;');
	} else {
		obj.setAttribute('style', 'color: #FEC606;');
	}
}
