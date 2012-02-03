var fbtoken = undefined;
var fbuserid = undefined;
window.fbAsyncInit = function() {
  FB.init({ appId: '161596347286085', 
	    status: true, 
	    cookie: true,
	    xfbml: true,
	    oauth: true});


  function updateButton(response) {
    var button = document.getElementById('fb-auth');
		
    if (response.authResponse) {
    	fbtoken = response.authResponse.accessToken;
      //user is already logged in and connected
      var userInfo = document.getElementById('user-info');
      FB.api('/me', function(response) {
    	  fbuserid = response.id;
        userInfo.innerHTML = '<img src="https://graph.facebook.com/' 
	  + response.id + '/picture">' + response.name;
        button.innerHTML = 'Logout';
      });
      button.onclick = function() {
        FB.logout(function(response) {
          var userInfo = document.getElementById('user-info');
          userInfo.innerHTML="";
	});
      };
    } else {
      //user is not connected to your app or logged out
      button.innerHTML = 'Login';
      button.onclick = function() {
        FB.login(function(response) {
	  if (response.authResponse) {
		  fbtoken = response.authResponse.accessToken;
           FB.api('/me', function(response) {
        	   fbuserid = response.id;
        	   var userInfo = document.getElementById('user-info');
	      userInfo.innerHTML = 
                '<img src="https://graph.facebook.com/' 
	        + response.id + '/picture" style="margin-right:5px"/>' 
	        + response.name;
	    });	   
          } else {
            //user cancelled login or did not grant authorization
          }
        }, {scope:'email,publish_actions'});  	
      };
    }
  }

  // run once with current status and whenever the status changes
  FB.getLoginStatus(updateButton);
  FB.Event.subscribe('auth.statusChange', updateButton);	
};
	
(function() {
  var e = document.createElement('script'); e.async = true;
  e.src = document.location.protocol 
    + '//connect.facebook.net/en_US/all.js';
  document.getElementById('fb-root').appendChild(e);
}());


