<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="${pageContext.request.contextPath}/style/default.css" type="text/css" rel="stylesheet" />
		<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/interface/DiceScript.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/engine.js'></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/dwr/util.js'></script> 
		<title>Web Dice Roller</title>
		<script type="text/javascript">
// Variables
var resultFieldId;
var count = 0;
var facesArray;
var partialResults;

var dices = [
			 	{id: '4', name: 'd4'}, 
			 	{id: '6', name: 'd6'}, 
			 	{id: '8', name: 'd8'}, 
			 	{id: '10', name: 'd10'}, 
			 	{id: '12', name: 'd12'}, 
			 	{id: '20', name: 'd20'}
			];

// Common Methods
function rollDice(resultId) {
	resultFieldId = resultId;
	
	var faces = document.getElementById("diceChoiceSingle").value;
	
	DiceScript.roll(faces, rollDiceCallBack);
}

function rollMultipleDices(timesId, resultId){
	resultFieldId = resultId;

	var faces = document.getElementById("diceChoiceSingle").value;
	var times = document.getElementById(timesId).value;

	if(times == '' || times == 0) {
		times = 1;
	}
	
	DiceScript.rollMultipleTimes(faces, times, rollDiceCallBack);
}

function addDice() {
	var diceCup = document.getElementById("diceCup");

	var row = document.createElement("tr");

	var td1 = document.createElement("td");
	td1.setAttribute("align", "center");

	count++;
	
	td1.innerHTML = count;

	var td2 = document.createElement("td");
	td2.setAttribute("align", "center");

    var diceSelector = document.createElement("select");
    var selectName = "diceChoiceCup-" + count;
	diceSelector.setAttribute("id", selectName);
	
	td2.appendChild(diceSelector);

	row.appendChild(td1);
	row.appendChild(td2);

	diceCup.appendChild(row);

	fillDiceSelector(selectName);
}

function fillDiceSelector(selectName) {
	dwr.util.addOptions(selectName, dices, 'id', 'name');
}

function emptyCup() {
	dwr.util.removeAllRows("diceCup");
	document.getElementById("timesRollCup").value = '1';
	document.getElementById("diceCupResult").value = '';
	count = 0;
}

function rollDiceCup() {
	var table = document.getElementById("diceCup");
	var dicesInCup = new Array();

	var times = document.getElementById("timesRollCup").value;

	if(times == '' || times == 0) {
		times = 1;
	}

	if(table != null) {
		for(var r = 0; r < table.rows.length; r++) {
			var dice = table.rows[r].cells[1].childNodes[0];
			dicesInCup.push(dice.options[dice.selectedIndex].value);
		}

		if(times == 1) {
			DiceScript.rollDiceCup(dicesInCup, rollDiceCupCallBack);
		} else {
			DiceScript.rollDiceCupMultipleTimes(dicesInCup, times, rollDiceCupCallBack);
		}
	}
}

// CallBacks
function rollDiceCallBack(diceRolled) {
	document.getElementById(resultFieldId).value = diceRolled.result;
	
	facesArray = diceRolled.faces;
	partialResults = diceRolled.partialResults;
	times = document.getElementById("timesRoll").value;

	dwr.util.removeAllRows("partialResults");
	
	if(times == null || times == '') {
		times = 1;
	}

	var partialResultsTable = document.getElementById("partialResults");

	for(var f in facesArray) {
		var row = document.createElement("tr");

		var tdFace = document.createElement("td");
		tdFace.setAttribute("align", "center");
		tdFace.className = "header";

		tdFace.innerHTML = facesArray[f];

		row.appendChild(tdFace);
		
		for(var p = 0; p < times; p++) {
			var tdResult = document.createElement("td");
			tdResult.setAttribute("align", "center");

			tdResult.innerHTML = partialResults[f][p];

			row.appendChild(tdResult);
		}
		
		partialResultsTable.appendChild(row);
	}
}

function rollDiceCupCallBack(diceRolled) {
	document.getElementById("diceCupResult").value = diceRolled.result;

	dwr.util.removeAllRows("partialResultsDiceCup");
}
</script>
	</head>
	<body>
		<h2>Dice Roller Test</h2>
		
		<form id="diceRollerForm">

		<fieldset>
			<legend>Single Dice Roll</legend>
			<div>Using a&nbsp; 
				<select id="diceChoiceSingle">
					<option value="4" selected>d4</option>
					<option value="6">d6</option>
					<option value="8">d8</option>
					<option value="10">d10</option>
					<option value="12">d12</option>
					<option value="20">d20</option>
				</select>
				&nbsp;Dice
			</div>
			<table width="100%">
				<tr>
					<td width="25%" align="center">Simple Roll</td>
					<td width="25%" align="center"></td>
					<td width="25%" align="center"><input type="button" onClick="rollDice('simpleRoll')" value="Roll!"/></td>
					<td width="25%" align="center"><input type="text" id="simpleRoll" readonly/></td>
				</tr>
				<tr>
					<td width="25%" align="center">Times Roll</td>
					<td width="25%" align="center"><input type="text" id="timesRoll"/></td>
					<td width="25%" align="center"><input type="button" onClick="rollMultipleDices('timesRoll', 'multipleRoll')" value="Roll!"/></td>
					<td width="25%" align="center"><input type="text" id="multipleRoll" readonly/></td>
				</tr>
				<tr>
					<td width="25%" align="center">Partial Results Map</td>
					<td colspan="3">
						<table id="partialResults">
						</table>
					</td>
				</tr>
			</table>
		</fieldset>
		
		<fieldset>
			<legend>Dice Cup Roll</legend>
			<div>
				Times&nbsp;<input type="text" value="1" id="timesRollCup"/>&nbsp;
				<input type="button" value="Add" onClick="addDice()"/>&nbsp;
				<input type="button" value="Empty Cup" onClick="emptyCup()"/>&nbsp;
				<input type="button" value="Roll!" onClick="rollDiceCup()"/>
			</div>
			
			<table width="40%">
				<thead>
					<tr class="header">
						<td width="5%" align="center">#</td>
						<td width="95%" align="center">Dice	</td>
					</tr>
				</thead>
				<tbody id="diceCup">
				</tbody>
			</table>
			
			<h3>Cup Result is&nbsp;<input type="text" id="diceCupResult" readonly/></h3>
			<p align="center">
			<b>Partial Results Map</b>
			<br/>Under Construction
			<table>
				<tbody id="partialResultsDiceCup">
				</tbody>
			</table>
			</p>
		</fieldset>
		
		</form>
	</body>
</html>