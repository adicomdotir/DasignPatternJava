'use strict';

var groupCount = 8;
var groupTeamCount = 4;
var teams = [];
var treeTeams16 = [];
var treeTeams8 = [];
var treeTeams4 = [];
var treeTeams2 = [];

function init() {
	var obj;
	// for (var i = 0; i < groupCount; i++) {
	// 	for (var j = 0; j < groupTeamCount; j++) {
	// 		var overal = Math.round(Math.random() * 10) + 50;
	// 		var team = new Team('Team' + ((i * 4) + j), overal, i);
	// 		teams.push(team);
	// 	}
	// }
	let team01 = new Team('Brazil', 84, 0);
	let team02 = new Team('Croatia', 79, 0);
	let team03 = new Team('Mexico', 79, 0);
	let team04 = new Team('Cameroon', 69, 0);
	teams.push(team01, team02, team03, team04);

	team01 = new Team('Australia', 73, 1);
	team02 = new Team('Netherlands', 81, 1);
	team03 = new Team('Spain', 86, 1);
	team04 = new Team('Chile', 79, 1);
	teams.push(team01, team02, team03, team04);

	team01 = new Team('Japan', 76, 2);
	team02 = new Team('Colombia', 79, 2);
	team03 = new Team('Greece', 78, 2);
	team04 = new Team('IvoryCoast', 75, 2);
	teams.push(team01, team02, team03, team04);

	team01 = new Team('Italy', 83, 3);
	team02 = new Team('Uruguay', 80, 3);
	team03 = new Team('CostaRica', 75, 3);
	team04 = new Team('England', 82, 3);
	teams.push(team01, team02, team03, team04);

	team01 = new Team('Honduras', 68, 4);
	team02 = new Team('Switzerland', 79, 4);
	team03 = new Team('Ecuador', 75, 4);
	team04 = new Team('France', 83, 4);
	teams.push(team01, team02, team03, team04);

	team01 = new Team('Nigeria', 68, 5);
	team02 = new Team('Argentina', 83, 5);
	team03 = new Team('Bosnia', 78, 5);
	team04 = new Team('Iran', 68, 5);
	teams.push(team01, team02, team03, team04);

	team01 = new Team('Germany', 85, 6);
	team02 = new Team('Portugal', 83, 6);
	team03 = new Team('Ghana', 74, 6);
	team04 = new Team('USA', 76, 6);
	teams.push(team01, team02, team03, team04);

	team01 = new Team('Belgium', 83, 7);
	team02 = new Team('Algeria', 77, 7);
	team03 = new Team('Russia', 77, 7);
	team04 = new Team('SouthKorea', 73, 7);
	teams.push(team01, team02, team03, team04);

	var elem = document.getElementById('begin');
	elem.parentElement.removeChild(elem);
	createTableHtml();
	var elem = document.getElementById('hidden');
	elem.removeAttribute('hidden');
	elem = document.getElementById('hidden02');
	elem.removeAttribute('hidden');

	var arr = [6, 8, 2, 4, 5, 11, 9, -6];
	console.log(arr);
	mergeSort(arr, 0, 7);
	console.log(arr);
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
	var select = document.getElementsByTagName('select')[0];
	var divTable = document.createElement('div');
	divTable.setAttribute('class', 'col-md-12');
	var table = document.getElementsByTagName('table')[0];
	for (var i = 0; i < groupCount; i++) {
		var option = document.createElement('option');
		option.setAttribute('value', i);
		option.appendChild(document.createTextNode('Group ' + (i + 1)));
		select.appendChild(option);
	}
	var tbody = document.getElementsByTagName('tbody')[0];
	insertGroupToTable(tbody, 0);
	container.appendChild(div);
	container.appendChild(divTable);
}

function insertGroupToTable(tbody, index) {
	for (var j = 0; j < groupTeamCount; j++) {
		insertTeamToTable(tbody, index, j);
	}
}

function insertTeamToTable(tbody, groupId, index) {
	var teamId = groupId * 4 + index;
	var tr = document.createElement('tr');
	var td = document.createElement('td');
	td.appendChild(document.createTextNode('' + (index + 1)));
	tr.appendChild(td);
	var td = document.createElement('td');
	td.appendChild(document.createTextNode(teams[teamId].name + '[' + teams[teamId].overall + ']'));
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
	selectGroupFire(event.target.value);
}

function selectGroupFire(index) {
	var tbody = document.getElementsByTagName('tbody');
	var rows = document.getElementsByTagName('tr');
	for (var i = 0; i < groupTeamCount; i++) {
		var tr = rows[1];
		tbody[0].removeChild(tr);
	}
	insertGroupToTable(tbody[0], index);
	fixture(index);
}

function result() {
	for (var gId = 0; gId < groupCount; gId++) {
		var teamsId = [];
		var teamId = gId * 4;
		for (var i = 0; i < 4; i++, teamId++) {
			teamsId[i] = teamId;
		}
		var col = 0;
		for (var i = 1; i < groupTeamCount; i++) {
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
					teams[teamsId[j]].table.gd = teams[teamsId[j]].table.gf - teams[teamsId[j]].table.ga;
					teams[teamsId[groupTeamCount - j - 1]].table.game++;
					teams[teamsId[groupTeamCount - j - 1]].table.lose++;
					teams[teamsId[groupTeamCount - j - 1]].table.gf += gB;
					teams[teamsId[groupTeamCount - j - 1]].table.ga += gA;
					teams[teamsId[groupTeamCount - j - 1]].table.gd = teams[teamsId[groupTeamCount - j - 1]].table.gf - teams[teamsId[groupTeamCount - j - 1]].table.ga;
				} else {
					teams[teamsId[j]].table.game++;
					teams[teamsId[j]].table.lose++;
					teams[teamsId[j]].table.gf += gA;
					teams[teamsId[j]].table.ga += gB;
					teams[teamsId[j]].table.gd = teams[teamsId[j]].table.gf - teams[teamsId[j]].table.ga;
					teams[teamsId[groupTeamCount - j - 1]].table.game++;
					teams[teamsId[groupTeamCount - j - 1]].table.win++;
					teams[teamsId[groupTeamCount - j - 1]].table.points += 3;
					teams[teamsId[groupTeamCount - j - 1]].table.gf += gB;
					teams[teamsId[groupTeamCount - j - 1]].table.ga += gA;
					teams[teamsId[groupTeamCount - j - 1]].table.gd = teams[teamsId[groupTeamCount - j - 1]].table.gf - teams[teamsId[groupTeamCount - j - 1]].table.ga;
				}
				let obj = {};
				obj.A = teams[teamsId[j]].name;
				obj.GA = gA;
				obj.GB = gB;
				obj.B = teams[teamsId[groupTeamCount - j - 1]].name;
				localStorage.setItem(gId * 12 + (i * 2) + j, JSON.stringify(obj));
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
	sort();
	selectGroupFire(0);
	treeView();
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

function fixture(groupId) {
	var col = 0;
	var list = document.getElementById('figure01');
	while (list.hasChildNodes()) {
		list.removeChild(list.childNodes[0]);
	}
	list = document.getElementById('figure02');
	while (list.hasChildNodes()) {
		list.removeChild(list.childNodes[0]);
	}
	list = document.getElementById('figure03');
	while (list.hasChildNodes()) {
		list.removeChild(list.childNodes[0]);
	}
	for (var i = 1; i < groupTeamCount; i++) {
		var str = '';
		var header = document.createElement("div");
		var bold = document.createElement("b");
		bold.appendChild(document.createTextNode("Matchday " + i));
		header.appendChild(bold);
		if (col === 0) {
			document.getElementById('figure03').appendChild(header);
		} else if (col === 1) {
			document.getElementById('figure02').appendChild(header);
		} else if (col === 2) {
			document.getElementById('figure01').appendChild(header);
		}

		for (let j = 0; j < groupTeamCount / 2; j++) {
			var id = groupId * 12 + (i * 2) + j;
			var obj = JSON.parse(localStorage.getItem('' + id));
			// console.log(id);
			var div1 = document.createElement("div");
			div1.setAttribute('class', 'col-md-4');
			addAttributeColor(obj.GA, obj.GB, div1);
			div1.appendChild(document.createTextNode(obj.A));
			var div2 = document.createElement("div");
			div2.setAttribute('class', 'col-md-4');
			div2.appendChild(document.createTextNode(obj.GA + '-' + obj.GB));
			var div3 = document.createElement("div");
			div3.setAttribute('class', 'col-md-4');
			addAttributeColor(obj.GB, obj.GA, div3);
			div3.appendChild(document.createTextNode(obj.B));
			if (col === 0) {
				document.getElementById('figure03').appendChild(div1);
				document.getElementById('figure03').appendChild(div2);
				document.getElementById('figure03').appendChild(div3);
			} else if (col === 1) {
				document.getElementById('figure02').appendChild(div1);
				document.getElementById('figure02').appendChild(div2);
				document.getElementById('figure02').appendChild(div3);
			} else if (col === 2) {
				document.getElementById('figure01').appendChild(div1);
				document.getElementById('figure01').appendChild(div2);
				document.getElementById('figure01').appendChild(div3);
			}
		}

		col++;
		if (col === 3) {
			col = 0;
		}
	}
}

function sort() {
	for (var gId = 0; gId < groupCount; gId++) {
		var teamsId = [];
		var teamId = gId * 4;
		for (var i = 0; i < 4; i++, teamId++) {
			teamsId[i] = teamId;
		}
		// This loop for sort points
		for (var i = 0; i < groupTeamCount; i++) {
			for (var j = i + 1; j < groupTeamCount; j++) {
				if (teams[teamsId[j]].table.points > teams[teamsId[i]].table.points) {
					var temp = teams[teamsId[j]];
					teams[teamsId[j]] = teams[teamsId[i]];
					teams[teamsId[i]] = temp;
				}
			}
		}

		// This loop for sort GD
		for (var i = 0; i < groupTeamCount; i++) {
			for (var j = i + 1; j < groupTeamCount; j++) {
				if (teams[teamsId[j]].table.points === teams[teamsId[i]].table.points) {
					if (teams[teamsId[j]].table.gd > teams[teamsId[i]].table.gd) {
						var temp = teams[teamsId[j]];
						teams[teamsId[j]] = teams[teamsId[i]];
						teams[teamsId[i]] = temp;
					}
				}
			}
		}
		// This loop for sort GF
		for (var i = 0; i < groupTeamCount; i++) {
			for (var j = i + 1; j < groupTeamCount; j++) {
				if (teams[teamsId[j]].table.points === teams[teamsId[i]].table.points) {
					if (teams[teamsId[j]].table.gd === teams[teamsId[i]].table.gd) {
						if (teams[teamsId[j]].table.gf > teams[teamsId[i]].table.gf) {
							var temp = teams[teamsId[j]];
							teams[teamsId[j]] = teams[teamsId[i]];
							teams[teamsId[i]] = temp;
						}
					}
				}
			}
		}
	}
}

function mergeSort(arr, l, r) {
    if (l < r) {
        let m = Math.floor(l + (r - l) / 2);

        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
 
        merge(arr, l, m, r);
    }
}


function merge(arr, l, m, r) {
    let i, j, k;
    let n1 = m - l + 1;
    let n2 =  r - m;
 
    /* create temp arrays */
    let L = [];
    let R = [];
 
    /* Copy data to temp arrays L[] and R[] */
    for (i = 0; i < n1; i++)
        L[i] = teams[teamsId[l + i]].table.points;
    for (j = 0; j < n2; j++)
        R[j] = teams[teamsId[m + 1+ j]].table.points;
 
    /* Merge the temp arrays back into arr[l..r]*/
    i = 0; // Initial index of first subarray
    j = 0; // Initial index of second subarray
    k = l; // Initial index of merged subarray
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
 
    /* Copy the remaining elements of L[], if there
       are any */
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
 
    /* Copy the remaining elements of R[], if there
       are any */
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}

function treeView() {
	for (var gId = 0; gId < groupCount; gId++) {
		var teamId = gId * 4;
		treeTeams16.push(teams[teamId], teams[teamId + 1]);
	}
	for (let i = 0; i < treeTeams16.length / 2; i++) {
		var elem = document.getElementById('tree-16');
		var diff = treeTeams16[i].overall - treeTeams16[treeTeams16.length - i - 1].overall;
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
		while (gA == gB) {
			gA += Math.floor(Math.random() * 2);
			gB += Math.floor(Math.random() * 2);
		}
		var div01 = document.createElement('div');
		div01.setAttribute('class', 'col-md-4');
		addAttributeColor(gA, gB, div01);
		div01.appendChild(document.createTextNode(treeTeams16[i].name));
		elem.appendChild(div01);
		div01 = document.createElement('div');
		div01.setAttribute('class', 'col-md-4');
		div01.appendChild(document.createTextNode(gA + '-' + gB));
		elem.appendChild(div01);
		div01 = document.createElement('div');
		div01.setAttribute('class', 'col-md-4');
		addAttributeColor(gB, gA, div01);
		div01.appendChild(document.createTextNode(treeTeams16[treeTeams16.length - i - 1].name));
		elem.appendChild(div01);
		if (gA > gB) {
			treeTeams8.push(treeTeams16[i]);
		} else {
			treeTeams8.push(treeTeams16[treeTeams16.length - i - 1]);
		}
	}
	for (let i = 0; i < treeTeams8.length / 2; i++) {
		var elem = document.getElementById('tree-8');
		var diff = treeTeams8[i].overall - treeTeams8[treeTeams8.length - i - 1].overall;
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
		while (gA == gB) {
			gA += Math.floor(Math.random() * 2);
			gB += Math.floor(Math.random() * 2);
		}
		var div01 = document.createElement('div');
		div01.setAttribute('class', 'col-md-4');
		addAttributeColor(gA, gB, div01);
		div01.appendChild(document.createTextNode(treeTeams8[i].name));
		elem.appendChild(div01);
		div01 = document.createElement('div');
		div01.setAttribute('class', 'col-md-4');
		div01.appendChild(document.createTextNode(gA + '-' + gB));
		elem.appendChild(div01);
		div01 = document.createElement('div');
		div01.setAttribute('class', 'col-md-4');
		addAttributeColor(gB, gA, div01);
		div01.appendChild(document.createTextNode(treeTeams8[treeTeams8.length - i - 1].name));
		elem.appendChild(div01);
		if (gA > gB) {
			treeTeams4.push(treeTeams8[i]);
		} else {
			treeTeams4.push(treeTeams8[treeTeams8.length - i - 1]);
		}
	}
	for (let i = 0; i < treeTeams4.length / 2; i++) {
		var elem = document.getElementById('tree-4');
		var diff = treeTeams4[i].overall - treeTeams4[treeTeams4.length - i - 1].overall;
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
		while (gA == gB) {
			gA += Math.floor(Math.random() * 2);
			gB += Math.floor(Math.random() * 2);
		}
		var div01 = document.createElement('div');
		div01.setAttribute('class', 'col-md-4');
		addAttributeColor(gA, gB, div01);
		div01.appendChild(document.createTextNode(treeTeams4[i].name));
		elem.appendChild(div01);
		div01 = document.createElement('div');
		div01.setAttribute('class', 'col-md-4');
		div01.appendChild(document.createTextNode(gA + '-' + gB));
		elem.appendChild(div01);
		div01 = document.createElement('div');
		div01.setAttribute('class', 'col-md-4');
		addAttributeColor(gB, gA, div01);
		div01.appendChild(document.createTextNode(treeTeams4[treeTeams4.length - i - 1].name));
		elem.appendChild(div01);
		if (gA > gB) {
			treeTeams2.push(treeTeams4[i]);
		} else {
			treeTeams2.push(treeTeams4[treeTeams4.length - i - 1]);
		}
	}
	for (let i = 0; i < treeTeams2.length / 2; i++) {
		var elem = document.getElementById('tree-2');
		var diff = treeTeams2[i].overall - treeTeams2[treeTeams2.length - i - 1].overall;
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
		while (gA == gB) {
			gA += Math.floor(Math.random() * 2);
			gB += Math.floor(Math.random() * 2);
		}
		var div01 = document.createElement('div');
		div01.setAttribute('class', 'col-md-4');
		addAttributeColor(gA, gB, div01);
		div01.appendChild(document.createTextNode(treeTeams2[i].name));
		elem.appendChild(div01);
		div01 = document.createElement('div');
		div01.setAttribute('class', 'col-md-4');
		div01.appendChild(document.createTextNode(gA + '-' + gB));
		elem.appendChild(div01);
		div01 = document.createElement('div');
		div01.setAttribute('class', 'col-md-4');
		addAttributeColor(gB, gA, div01);
		div01.appendChild(document.createTextNode(treeTeams2[treeTeams2.length - i - 1].name));
		elem.appendChild(div01);
	}
}
