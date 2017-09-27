var size = 4;
var teams = [0, 1, 2, 3];

function Team(name) {
	this.name = name;
	this.game = 0;
	this.win = 0;
	this.lose = 0;
	this.draw = 0;
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
};

for (var i = 1; i < size; i++) {
	var str = '';
	for (var j = 0; j < size / 2; j++) {
		var gA = Math.floor((Math.random() * 5));
		var gB = Math.floor((Math.random() * 5));
		if (gA === gB) {
			teamsInfo[teams[j]].game++;
			teamsInfo[teams[j]].draw++;
			teamsInfo[teams[j]].points++;
			teamsInfo[teams[size - j - 1]].game++;
			teamsInfo[teams[size - j - 1]].draw++;
			teamsInfo[teams[size - j - 1]].points++;
		} else if (gA > gB) {
			teamsInfo[teams[j]].game++;
			teamsInfo[teams[j]].win++;
			teamsInfo[teams[j]].points += 3;
			teamsInfo[teams[size - j - 1]].game++;
			teamsInfo[teams[size - j - 1]].lose++;
		} else {
			teamsInfo[teams[j]].game++;
			teamsInfo[teams[j]].lose++;
			teamsInfo[teams[size - j - 1]].game++;
			teamsInfo[teams[size - j - 1]].win++;
			teamsInfo[teams[size - j - 1]].points += 3;
		}
		str += teamsInfo[teams[j]].name + ' ' + gA + '-' + gB + ' ' + teamsInfo[teams[size - j - 1]].name + ',';
	}
	console.log(str);
    swap();
}

console.log(teamsInfo);
