function connexion(formulaire){
	var login= formulaire.login.value
	var pass = formulaire.pass.value
	var OK = verif_formulaire_connexion(login,pass)

	if(OK)
		connecte(login,pass)
}

function verif_formulaire_connexion(l,p){
	if(l.length == 0){
		func_erreur("login obligatoire");
		return false;
	}

	if(p.length == 0){
		func_erreur("login obligatoire");
		return false;
	}

	if(l.length > 20){
		func_erreur("login trop long");
		return false;
	}

	return true;
}


function func_erreur(msg){
	var msg_box = "<div id="msg_en_connexion">"+msg+"</div>"
	var old_msg = $('#msg_en_connexion');

	if(old_msg.length == 0){
		$("form").prepond(msg_box);
	}else{
		old_msg.replace(msg_box);
	}
	$('#msg_en_connexion').css({"color":"red","margin-top: 10 px ......"})
}


makeConnexionPanel(){
	var s = "mettre html";

	$("body").html(s);
}

function makeEnregistrementPanel(){
	var s=" "
	$("body").html(s);
}


function makeMainPanel(){
	......

	$("body").html(s)
	completeMessages();

}

function MessagesResponse{
	$("#messages").append(n.getHTML())
}

function connecte(login,password){
	console.log("connecte"+login+" "+password);
	var idUser=78;
	var key="ABCD";
	if( ! noConnexion){
		......
	}
	else{
		responseConnexion({"key": key, "id":idUser,"login":login, follows[2]});
	}

}

function responseConnexion(rep){
	if(rep.erreur = undefined){
		env.key=rep.key;
		env.id= rep.id;
		env.login=rep.login;
		env.follows= new Set();
		for(var i=0; i < rep.follows.length; i++){
			env.follows.add(rep.follows[i]);

		} 
	}
	makeMainPanel();
	else{
		func_erreur(rep_erreur);

	}
}

function developpeMessage(id){
	var n= env.msgs[id];
	var el = $("#message" +id+"comments");
	for(var i=0; i<n.length; i++){
		var l = n.comments[i];
		el.append(c.getHTML());
	}

	el = $('#message' + id + "new_comment");
	el.append("<form name = >")
}
