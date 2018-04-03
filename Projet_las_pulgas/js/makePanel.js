function makeConnexionPanel()
{
	$("body").load("html_css/connexion.html");
}
function makeEnregistrementPanel()
{
$("body").load("/users/Etu8/3202238/Documents/L3/3I017/Projet_las_pulgas/html_css/enregistrement.html");
}
function makeMdpLostPanel()
{
	$("body").load("html_css/mdp_lost.html");
}
function makeMainPanel(fromId,fromLogin,query)
{
	$("body").load("html_css/main.html");
}
function makeProfilPanel()
{
	$("body").load("/users/Etu8/3202238/Documents/L3/3I017/Projet_las_pulgas/html_css/enregistrement.html");
}
function makeProfilPanel2(fromId,fromLogin,query)
{
	if (fromId==undefined)
		fromId=-1;
	env.fromId=fromId;
	env.msg=[]
	env.query=query;
	env.fromLogin=fromLogin;
	console.log(env.fromLogin);
	var s="";
//HEADER
s+="<header>";
s+="<div id=\"logo\">";
s+="<a href=\"javascript:makeMainPanel()\"><img src=\"images/ks.jpg\" alt=\"\" height=\"42\" width=\"42\"></a></a>";
s+="</div>";
s+="<div id=\"search\">";
s+="<br/>";
s+="<input type=\"text\" id=\"recherche\"/> ";
s+="<input type=\"submit\" value=\"Recherche\"/>";
s+="</div>";
s+="<div id=\"connect\">";
s+="<br/>";
s+="<a href=\"javascript:makeProfilPanel()\"> Profil </a> | ";
s+="<a href=\"javascript:makeConnexionPanel()\"> Deconnexion </a>";
s+="</div>";
s+="</header>";
s+="<nav></nav>";
s+="<section id=\"main\">"
s+="<div id=\"profil\">";
if (env.fromId < 0)
	$("body").load("html_css/main.html");
else
{
	if (!env.follows.has(env.fromId))
	{
		s+="<br/>";
		s+="<br/>";
		s+="<div id=\"title\"><h1 style=\"color:white;\">Page de " + fromLogin + "</h1></div>";
		s+="<div class = \"add\">";
		s+="<input type=\"button\" value=\"suivre\" onclick='Javascript:follow()' />";
		s+="</div></div>";
	}
	else
	{
		s+="<br/>";
		s+="<br/>";
		s+="<div id=\"title\"><h1 style=\"color:white;\">Page de " + fromLogin + "</h1></div>"
		s+="<div class = \"remove\">";
		s+="<input type=\"button\" value=\"ne_plus_suivre\" onclick='Javascript:stopfollow()' />";
		s+="</div></div>";
	}
}
s+="<div id=\"connect\"> <span id=\"log\" pageUser("+env.id+","+env.login+")>";
s+="<br/>";
s+="</div>";
s+="<div id=\"message_users\">";
s+="</div>";
s+="</div>";
s+="</section>";
$("body").html(s);
completeMessages();
}