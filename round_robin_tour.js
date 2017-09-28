var size = 4;
var teams = [0, 1, 2, 3];

function Team(name) {
	this.name = name;
	this.game = 0;
	this.win = 0;
	this.lose = 0;
	this.draw = 0;
    this.gf = 0;
	this.ga = 0;
	this.gd = 0;
	this.points = 0;
}

var teamsInfo = [];
var barca = new Team('Barcelona');
var rm = new Team('RealMadrid');
var psg = new Team('PSG');
var chelsea = new Team('Chelsea');
teamsInfo.push(barca, rm, psg, chelsea);

function swap() {
	var temp = teams[size - 1];
	for (var i = size - 1; i > 0; i--) {
		teams[i] = teams[i - 1];
	}
	teams[1] = temp;
}

for (var i = 1; i < size; i++) {
	var str = '';
	for (var j = 0; j < size / 2; j++) {
		var gA = Math.floor((Math.random() * 5));
		var gB = Math.floor((Math.random() * 5));
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
//console.log(teamsInfo);
for (var i = 0; i < size; i++) {
	var row = document.createElement("tr");
	for (var key in teamsInfo[i]) {
		var col = document.createElement("td");
		if (key === 'gd') {
			col.appendChild(document.createTextNode(teamsInfo[i]['gf'] - teamsInfo[i]['ga']));
		} else {
			col.appendChild(document.createTextNode(teamsInfo[i][key]));
		}
		row.appendChild(col);
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