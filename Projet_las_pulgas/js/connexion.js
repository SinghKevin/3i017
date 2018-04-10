function connexion (formulaire){

	var login=formulaire.login.value;
	var pass=formulaire.pass.value;
	var ok=verif_formulaire_connexion(login,pass);
	if (ok)
		connecte(login,pass);
}


function verif_formulaire_connexion(login,pass){

	if (login.length==0) {
		func_erreur("Login obligatoire");
		return false;
	}

	if (pass.length==0) {
		func_erreur("Mot de passe obligatoire")
		return false;
	}

	if (login.length>20){
		func_erreur("Login trop long");
		return false;
	}

	return true;
}

function connecte(login,pass) {
	console.log("connexion de " + login + ", mdp: " + pass);
	var id=78;
	var key="ABCD";
	if (!noConnection){}
	else{
		responseConnexion({"key":key,"id":id,"login":login,"follows":[2]});
	}
}

function responseConnexion(rep) {
		if (rep.erreur==undefined) {
			env.key=rep.key;
			env.id=rep.id;
			env.login=rep.login;
			env.follows=new Set();
			for (var i=0;i<rep.follows.length;i++)
				env.follows.add(rep.follows[i]);
		}

		if (noConnection) {
			follows[rep.id]=new Set();
			for (var i=0;i<rep.follows.length;i++)
				follows[rep.id].add(rep.follows[i]);
			makeProfilPanel2(rep.id,rep.login);
		}
		
		else
			func_erreur(rep.erreur);
	}
