'use strict'

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
	var select = document.createElement('select');
	select.setAttribute('onchange', 'selectGroup()');
	var table = document.createElement('table');
	for (var i = 0; i < groupCount; i++) {
		var option = document.createElement('option');
		option.setAttribute('value', i);
		option.appendChild(document.createTextNode('Group ' + (i + 1)));
		select.appendChild(option);
	}
	createTableHeader(table);
	createGroupTeam(table, 0);
	container.appendChild(select);
	container.appendChild(table);
}

function createTableHeader(table) {
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
	table.appendChild(tr);
}

function createGroupTeam(table, index) {
	for (var j = 0; j < groupTeamCount; j++) {
		createTableTeam(table, index, j);
	}
}

function createTableTeam(table, groupId, index) {
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
	table.appendChild(tr);
}

function selectGroup() {
	var table = document.getElementsByTagName('table');
	var rows = document.getElementsByTagName('tr');
	for (var i = 0; i < 4; i++) {
		var tr = rows[1];
		table[0].removeChild(tr);
	}
	createGroupTeam(table[0], event.target.value);
}
