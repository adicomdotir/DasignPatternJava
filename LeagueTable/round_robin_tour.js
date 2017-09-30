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

var size = 18;
var teams = [];
for (var i = 0; i < size; i++) {
	teams[i] = i;
}
var teamsInfo = [];
var t1 = new Team('SL Benfica', 79);
var t2 = new Team('FC Porto', 79);
var t3 = new Team('SC Braga', 75);
var t4 = new Team('Sporting CP', 78);
var t5 = new Team('V. Guimarães', 74);
var t6 = new Team('V. Setúbal', 72);
var t7 = new Team('Arouca', 71);
var t8 = new Team('Ave	Rio Ave', 72);
var t9 = new Team('Chaves', 71);
var t10 = new Team('Paços Ferreira', 71);
var t11 = new Team('Boavista', 71);
var t12 = new Team('Marítimo', 71);
var t13 = new Team('Belenenses', 70);
var t14 = new Team('Estoril Praia', 69);
var t15 = new Team('Moreirense', 69);
var t16 = new Team('F. Santa Maria', 69);
var t17 = new Team('Nacional', 69);
var t18 = new Team('Tondela', 68);
teamsInfo.push(t1, t2, t3, t4, t5, t6,
				t7, t8, t9, t10, t11, t12,
				t13, t14, t15, t16, t17, t18);
// var teamsInfo = [];
// var barca = new Team('Barcelona', 85);
// var rm = new Team('RealMadrid', 86);
// var psg = new Team('PSG', 83);
// var chelsea = new Team('Chelsea', 83);
// var inter = new Team('Inter', 81);
// var milan = new Team('Milan', 79);
// teamsInfo.push(barca, rm, psg, chelsea, inter, milan);

function swap() {
	var temp = teams[size - 1];
	for (var i = size - 1; i > 0; i--) {
		teams[i] = teams[i - 1];
	}
	teams[1] = temp;
}

for (var i = 1; i < size * 2 - 1; i++) {
	var str = '';
  	var header = document.createElement("b");
    header.appendChild(document.createTextNode("Week" + i));
	document.getElementById('figure').appendChild(header);
	for (var j = 0; j < size / 2; j++) {
		var gA = Math.floor(((Math.random() * 5) + (teamsInfo[teams[j]].overall / 20)) / 2);
		var gB = Math.floor(((Math.random() * 5) + (teamsInfo[teams[size - j - 1]].overall / 20)) / 2);
		console.log(gA);
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
		str = teamsInfo[teams[j]].name + ' ' + gA + '-' + gB + ' ' + teamsInfo[teams[size - j - 1]].name;
        var div = document.createElement("div");
        div.appendChild(document.createTextNode(str));
        document.getElementById('figure').appendChild(div);
	}

	// console.log(str);
    swap();
}
sort();
// console.log(teamsInfo);
for (var i = 0; i < size; i++) {
	var row = document.createElement("tr");
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
	for (var i = 0; i < size; i++) {
		for (var j = i + 1; j < size; j++) {
			if (teamsInfo[j].points > teamsInfo[i].points) {
				var temp = teamsInfo[j];
				teamsInfo[j] = teamsInfo[i];
				teamsInfo[i] = temp;
			}
		}
	}
	for (var i = 0; i < size; i++) {
		for (var j = i + 1; j < size; j++) {
			if (teamsInfo[j].points === teamsInfo[i].points) {
				console.log(teamsInfo[j].points + '===' + teamsInfo[i].points);
				if (teamsInfo[j].gd > teamsInfo[i].gd) {
					console.log(teamsInfo[j].gd + '>' + teamsInfo[i].gd);
					var temp = teamsInfo[j];
					teamsInfo[j] = teamsInfo[i];
					teamsInfo[i] = temp;
				}
			}
		}
	}
	for (var i = 0; i < size; i++) {
		for (var j = i + 1; j < size; j++) {
			if (teamsInfo[j].points === teamsInfo[i].points) {
				console.log(teamsInfo[j].points + '===' + teamsInfo[i].points);
				if (teamsInfo[j].gd === teamsInfo[i].gd) {
					console.log(teamsInfo[j].gd + '===' + teamsInfo[i].gd);
					if (teamsInfo[j].gf > teamsInfo[i].gf) {
						console.log(teamsInfo[j].gf + '>' + teamsInfo[i].gf);
						var temp = teamsInfo[j];
						teamsInfo[j] = teamsInfo[i];
						teamsInfo[i] = temp;
					}
				}
			}
		}
	}
}
