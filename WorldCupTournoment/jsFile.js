'use strict';

var groupCount = 8;
var groupTeamCount = 4;
var teams = [];

function init() {
	var obj;
	for (var i = 0; i < groupCount; i++) {
		for (var j = 0; j < groupTeamCount; j++) {
			var overal = Math.round(Math.random() * 10) + 50;
			var team = new Team('Team' + ((i * 4) + j), overal, i);
			teams.push(team);
		}
	}
	var elem = document.getElementById('begin');
	elem.parentElement.removeChild(elem);
	createTableHtml();
	var elem = document.getElementById('divBtn');
	elem.removeAttribute('hidden');
}

function Team(name, overall, group) {
	this.name = name;
	this.overall = overall;
	this.group = group;
	this.table = {
		game: 0,
		win: 0,
		draw: 0,
		lose: 0,
		gf: 0,
		ga: 0,
		gd: 0,
		points: 0
	};
}

function createTableHtml() {
	var container = document.getElementById('container');
	var div = document.createElement('div');
	div.setAttribute('class', 'col-md-3');
	var select = document.createElement('select');
	select.setAttribute('class', 'form-control');
	select.setAttribute('onchange', 'selectGroup()');
	var divTable = document.createElement('div');
	divTable.setAttribute('class', 'col-md-12');
	var table = document.createElement('table');
	table.setAttribute('class', 'table table-bordered table-striped');
	for (var i = 0; i < groupCount; i++) {
		var option = document.createElement('option');
		option.setAttribute('value', i);
		option.appendChild(document.createTextNode('Group ' + (i + 1)));
		select.appendChild(option);
	}
	createTableHeader(table);
	var tbody = document.createElement('tbody');
	table.appendChild(tbody);
	createGroupTeam(tbody, 0);
	div.appendChild(select);
	divTable.appendChild(table);
	container.appendChild(div);
	container.appendChild(divTable);
}

function createTableHeader(table) {
	var thead = document.createElement('thead');
	var tr = document.createElement('tr');
	var th = document.createElement('th');
	th.appendChild(document.createTextNode('#'));
	tr.appendChild(th);
	var th = document.createElement('th');
	th.appendChild(document.createTextNode('Name'));
	tr.appendChild(th);
	var th = document.createElement('th');
	th.appendChild(document.createTextNode('Game'));
	tr.appendChild(th);
	var th = document.createElement('th');
	th.appendChild(document.createTextNode('Win'));
	tr.appendChild(th);
	var th = document.createElement('th');
	th.appendChild(document.createTextNode('Draw'));
	tr.appendChild(th);
	var th = document.createElement('th');
	th.appendChild(document.createTextNode('Lose'));
	tr.appendChild(th);
	var th = document.createElement('th');
	th.appendChild(document.createTextNode('GF'));
	tr.appendChild(th);
	var th = document.createElement('th');
	th.appendChild(document.createTextNode('GA'));
	tr.appendChild(th);
	var th = document.createElement('th');
	th.appendChild(document.createTextNode('GD'));
	tr.appendChild(th);
	var th = document.createElement('th');
	th.appendChild(document.createTextNode('Points'));
	tr.appendChild(th);
	thead.appendChild(tr);
	table.appendChild(thead);
}

function createGroupTeam(tbody, index) {
	for (var j = 0; j < groupTeamCount; j++) {
		createTableTeam(tbody, index, j);
	}
}

function createTableTeam(tbody, groupId, index) {
	var teamId = groupId * 4 + index;
	var tr = document.createElement('tr');
	var td = document.createElement('td');
	td.appendChild(document.createTextNode('' + (index + 1)));
	tr.appendChild(td);
	var td = document.createElement('td');
	td.appendChild(document.createTextNode(teams[teamId].name));
	tr.appendChild(td);
	var td = document.createElement('td');
	td.appendChild(document.createTextNode(teams[teamId].table['game']));
	tr.appendChild(td);
	var td = document.createElement('td');
	td.appendChild(document.createTextNode(teams[teamId].table['win']));
	tr.appendChild(td);
	var td = document.createElement('td');
	td.appendChild(document.createTextNode(teams[teamId].table['draw']));
	tr.appendChild(td);
	var td = document.createElement('td');
	td.appendChild(document.createTextNode(teams[teamId].table['lose']));
	tr.appendChild(td);
	var td = document.createElement('td');
	td.appendChild(document.createTextNode(teams[teamId].table['gf']));
	tr.appendChild(td);
	var td = document.createElement('td');
	td.appendChild(document.createTextNode(teams[teamId].table['ga']));
	tr.appendChild(td);
	var td = document.createElement('td');
	td.appendChild(document.createTextNode(teams[teamId].table['gd']));
	tr.appendChild(td);
	var td = document.createElement('td');
	td.appendChild(document.createTextNode(teams[teamId].table['points']));
	tr.appendChild(td);
	tbody.appendChild(tr);
}

function selectGroup() {
	var tbody = document.getElementsByTagName('tbody');
	var rows = document.getElementsByTagName('tr');
	for (var i = 0; i < 4; i++) {
		var tr = rows[1];
		tbody[0].removeChild(tr);
	}
	createGroupTeam(tbody[0], event.target.value);
}

function result() {
	for (var gId = 0; gId < groupCount; gId++) {
		var teamsId = [];
		var teamId = gId * 4;
		for (var i = 0; i < 4; i++, teamId++) {
			teamsId[i] = teamId;
		}
		for (var i = 1; i < groupTeamCount * 2 - 1; i++) {
			for (var j = 0; j < groupTeamCount / 2; j++) {
				var diff = teams[teamsId[j]].overall - teams[teamsId[groupTeamCount - j - 1]].overall;
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
				if (gA === gB) {
					teams[teamsId[j]].table.game++;
					teams[teamsId[j]].table.draw++;
					teams[teamsId[j]].table.points++;
					teams[teamsId[j]].table.gf += gA;
					teams[teamsId[j]].table.ga += gB;
					teams[teamsId[groupTeamCount - j - 1]].table.game++;
					teams[teamsId[groupTeamCount - j - 1]].table.draw++;
					teams[teamsId[groupTeamCount - j - 1]].table.points++;
					teams[teamsId[groupTeamCount - j - 1]].table.gf += gB;
					teams[teamsId[groupTeamCount - j - 1]].table.ga += gA;
				} else if (gA > gB) {
					teams[teamsId[j]].table.game++;
					teams[teamsId[j]].table.win++;
					teams[teamsId[j]].table.points += 3;
					teams[teamsId[j]].table.gf += gA;
					teams[teamsId[j]].table.ga += gB;
					teams[teamsId[groupTeamCount - j - 1]].table.game++;
					teams[teamsId[groupTeamCount - j - 1]].table.lose++;
					teams[teamsId[groupTeamCount - j - 1]].table.gf += gB;
					teams[teamsId[groupTeamCount - j - 1]].table.ga += gA;
				} else {
					teams[teamsId[j]].table.game++;
					teams[teamsId[j]].table.lose++;
					teams[teamsId[j]].table.gf += gA;
					teams[teamsId[j]].table.ga += gB;
					teams[teamsId[groupTeamCount - j - 1]].table.game++;
					teams[teamsId[groupTeamCount - j - 1]].table.win++;
					teams[teamsId[groupTeamCount - j - 1]].table.points += 3;
					teams[teamsId[groupTeamCount - j - 1]].table.gf += gB;
					teams[teamsId[groupTeamCount - j - 1]].table.ga += gA;
				}
			}
			////////////////
			// Swap Block //
			var temp = teamsId[3];
			for (var k = groupTeamCount - 1; k > 0; k--) {
				teamsId[k] = teamsId[k - 1];
			}
			teamsId[1] = temp;
			// End Block //
			///////////////
		}
	}
	var elem = document.getElementById('divBtn');
	elem.setAttribute('hidden', 'true');
}

function result() {
	for (var gId = 0; gId < groupCount; gId++) {
		var teamsId = [];
		var teamId = gId * 4;
		for (var i = 0; i < 4; i++, teamId++) {
			teamsId[i] = teamId;
		}
		for (var i = 1; i < groupTeamCount * 2 - 1; i++) {
			console.log(i);
			for (var j = 0; j < groupTeamCount / 2; j++) {
				console.log(teams[teamsId[j]]);
				console.log(teams[teamsId[groupTeamCount - j - 1]]);
				var diff = teams[teamsId[j]].overall - teams[teamsId[groupTeamCount - j - 1]].overall;
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
				if (gA === gB) {
					teams[teamsId[j]].table.game++;
					teams[teamsId[j]].table.draw++;
					teams[teamsId[j]].table.points++;
					teams[teamsId[j]].table.gf += gA;
					teams[teamsId[j]].table.ga += gB;
					teams[teamsId[groupTeamCount - j - 1]].table.game++;
					teams[teamsId[groupTeamCount - j - 1]].table.draw++;
					teams[teamsId[groupTeamCount - j - 1]].table.points++;
					teams[teamsId[groupTeamCount - j - 1]].table.gf += gB;
					teams[teamsId[groupTeamCount - j - 1]].table.ga += gA;
				} else if (gA > gB) {
					teams[teamsId[j]].table.game++;
					teams[teamsId[j]].table.win++;
					teams[teamsId[j]].table.points += 3;
					teams[teamsId[j]].table.gf += gA;
					teams[teamsId[j]].table.ga += gB;
					teams[teamsId[groupTeamCount - j - 1]].table.game++;
					teams[teamsId[groupTeamCount - j - 1]].table.lose++;
					teams[teamsId[groupTeamCount - j - 1]].table.gf += gB;
					teams[teamsId[groupTeamCount - j - 1]].table.ga += gA;
				} else {
					teams[teamsId[j]].table.game++;
					teams[teamsId[j]].table.lose++;
					teams[teamsId[j]].table.gf += gA;
					teams[teamsId[j]].table.ga += gB;
					teams[teamsId[groupTeamCount - j - 1]].table.game++;
					teams[teamsId[groupTeamCount - j - 1]].table.win++;
					teams[teamsId[groupTeamCount - j - 1]].table.points += 3;
					teams[teamsId[groupTeamCount - j - 1]].table.gf += gB;
					teams[teamsId[groupTeamCount - j - 1]].table.ga += gA;
				}
			}
			////////////////
			// Swap Block //
			var temp = teamsId[3];
			for (var k = groupTeamCount - 1; k > 0; k--) {
				teamsId[k] = teamsId[k - 1];
			}
			teamsId[1] = temp;
			// End Block //
			///////////////
		}
	}
	var elem = document.getElementById('divBtn');
	elem.setAttribute('hidden', 'true');
}
