function func_erreur(msg) {

	var msg_box="<div id=\"msg_erreur\">"+msg+"<br><br></div>";
	var old_msg=$("#msg_erreur");
	if (old_msg.length==0)
		$("form").prepend(msg_box); //ajoute_msg en 1er element du formulaire (prepend en premier element)

	else	
		old_msg.replaceWith(msg_box);
	$("#msg_erreur").css({"color":"red"})
}

function revival(key,value) {

	if (value.comments!=undefined){
		var c= new Message(value.id,value.auteur,value.date,value.comments);
		return c;
	}
	
		else if (value.text!=undefined) {
		var c = new commentaire(value.id,value.auteur,value.text,value.date);
		return c;
	}

	else if (key=="date") {
		var d=new Date(value);
		return d;
	}
	
	return value;
}