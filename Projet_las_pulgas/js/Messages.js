function Message(id,login,text,date,comments){
	this.id=id;
	this.auteur=auteur;
	this.text=text;
	this.date=date;
	if(comments == undefined )
		comments=[];
	this.comments=comments;
}
Message.prototype.getHTML=function () {
	return "<div id= \"message_"+ this.id+"\ class= message\> \
			<div class=\" text_message\">"+this.text+"</div>\
			<div class=\"infos_message\">\
			<span> Post de <span class=\"link"\" onclick==\" javascript :pageUser("+this.auteur.id+")\
			</span></span></div></div>";

}

function Commentaire(id,auteur,text,date,score) {
	this.id=id;
	this.auteur=auteur;
	this.text=text;
	this.date=date;
}
Commentaire.prototype.getHTML=function(){
	return "<div id= \"commentaire_"+ this.id+"\ class= commentaire\> \
			<div class=\" text_commentaire\">"+this.text+"</div>\
			<div class=\"infos_commentaire\">\
			<span> Commentaire de <span class=\"link"\" onclick==\" javascript :pageUser("+this.auteur.id+")\
			</span></span></div></div>";

}

function revival1(key,value){
	if(value.comments != undefined){
		var c = new Message(value.id,value.auteur,value.text, value.date, value.comments);
		return c;
	} else if(value.text != undefined){
		var c= new Commentaire(value.id,value.auteur,value.text,value.date);
		return c;
	}else if (key == id){
		var d = new Date(value);
		return d;
	}
	return value;
}

message = JSON.parse(monJSON,revival1);

<body onload ="javascript:init()">
function seVirtualDB(){
	localdb=[];
	follows=[];
	var u1={"id":1,"login":"sly"};
	var u2={"id":2,"login":"fab"};
	var u3={"id":3,"login":"joe"};
	follows[1]=[2,4];
	follows[2]= new set();
	follows[2].add(4);
	follows[4]=[1];
	var c1 = new Commentaire(1,user3,"hum",new Date());
	var c2 = new Commentaire(2,user1,"blabla",new Date());
	localdb[2]= new Message(2,user1,"blabla",new Date(),[c1,c2]);
	localdb[4] = new Message(4,user2,"Hello",new Date(), []);
}

function init(){
	noConnection= true;
	env=new Object();
	seVirtualDB();
	return getHTML();
}

function makeMainPanel(fromId,fromLogin,query){
	env.msgs=[];
	if(fromId== undefined)
		fromId=-1;

	env.fromId=fromId;
	env.fromLogin=fromLogin;
	console.log(env.fromLogin);
	env.query=query;
	var s=

	if(env.fromId <0){
		s+=

	}else{
		if( ! env.follows.has(env.fromId)){
			s+=

		}else{
			s+=
		}
	}
	s+=


	// A compléter en fonction de notre code
	}
	}
}