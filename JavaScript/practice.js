function User(){
	var username, password;
	function doLogin(user,pw) {
		username = user;
		password = pw;

		// do the rest of the login work
	}
	var publicAPI = {
		login: doLogin
	};
	return publicAPI;
}

// create a `User` module instance
var fred = User();
fred.login( "adicom", "12Battery34!" );

//--------------------//
(function IIFE(){
	console.log( "Hello!" );
})();
// "Hello!"

function makeNum(x) {
	function add(y) {
		return y + x;
	};
	return add;
}

var addOne = makeNum(1);
var addTen = makeNum(10);

addOne(3);		// 4  <-- 1 + 3
addOne(41);		// 42 <-- 1 + 41
addTen(13);		// 23 <-- 10 + 13