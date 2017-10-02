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

var size = 4;
var teams = [];
for (var i = 0; i < size; i++) {
	teams[i] = i;
}
var teamsInfo = [];
var t1 = new Team('SL Benfica', 79);
var t2 = new Team('FC Porto', 79);
var t3 = new Team('SC Braga', 75);
var t4 = new Team('Sporting CP', 78);
teamsInfo.push(t1, t2, t3, t4);
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

var col = 0;
for (var i = 1; i < size * 2 - 1; i++) {
	var str = '';
  	var header = document.createElement("div");
    header.appendChild(document.createTextNode("Week " + i));
	if (col === 0) {
		document.getElementById('figure4').appendChild(header);
	} else if (col === 1) {
		document.getElementById('figure3').appendChild(header);
	} else if (col === 2) {
		document.getElementById('figure2').appendChild(header);
	} else if (col === 3) {
		document.getElementById('figure').appendChild(header);
	}
	for (var j = 0; j < size / 2; j++) {
		var gA = Math.floor((Math.random() * teamsInfo[teams[j]].overall / 20));
		var gB = Math.floor((Math.random() * teamsInfo[teams[size - j - 1]].overall / 20));
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
		/*
		<div class="col-md-5">Barcelona</div>
        <div class="col-md-2">2-2</div>
        <div class="col-md-5">RealMadrid</div>
		*/
		// str = teamsInfo[teams[j]].name + ' ' + gA + '-' + gB + ' ' + teamsInfo[teams[size - j - 1]].name;
        var div1 = document.createElement("div");
		div1.setAttribute('class', 'col-md-5');
        div1.appendChild(document.createTextNode(teamsInfo[teams[j]].name));
		var div2 = document.createElement("div");
		div2.setAttribute('class', 'col-md-2');
        div2.appendChild(document.createTextNode(gA + '-' + gB));
		var div3 = document.createElement("div");
		div3.setAttribute('class', 'col-md-5');
        div3.appendChild(document.createTextNode(teamsInfo[teams[size - j - 1]].name));
		if (col === 0) {
			document.getElementById('figure4').appendChild(div1);
			document.getElementById('figure4').appendChild(div2);
			document.getElementById('figure4').appendChild(div3);
		} else if (col === 1) {
			document.getElementById('figure3').appendChild(div1);
			document.getElementById('figure3').appendChild(div2);
			document.getElementById('figure3').appendChild(div3);
		} else if (col === 2) {
			document.getElementById('figure2').appendChild(div1);
			document.getElementById('figure2').appendChild(div2);
			document.getElementById('figure2').appendChild(div3);
		} else if (col === 3) {
			document.getElementById('figure').appendChild(div1);
			document.getElementById('figure').appendChild(div2);
			document.getElementById('figure').appendChild(div3);
		}
	}
	console.log(col);
	col++;
	if (col === 4) {
		col = 0;
	}
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
