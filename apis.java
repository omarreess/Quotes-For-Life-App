Api  get raondom Qoute
 
 
 
 
 var req = unirest("GET", "https://quotes15.p.rapidapi.com/quotes/random/");

req.query({
	"language_code": "en"
});

req.headers({
	"x-rapidapi-host": "quotes15.p.rapidapi.com",
	"x-rapidapi-key": "9c02043f1bmsh93142affc502ca3p1b04fdjsn9dc9469a24f7",
	"useQueryString": true
});






































