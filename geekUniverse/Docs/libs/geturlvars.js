function getUrlVars()
{
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
}
window.onload=function(){
	var vetor = getUrlVars();
	divSucesso = document.getElementById("msgSucesso");
	divFalha = document.getElementById("msgFalha");
	divError = document.getElementById("msgError");
	divLogOut = document.getElementById("msgLogOut");
	divUsuarioNaoEncontrado = document.getElementById("msgUsuarioNaoEncontrado");
	resposta = vetor["resposta"];
	
	if(resposta == "sucesso"){
		divSucesso.className="alert alert-success alert-dismissible displayAbsolute";
	}else if(resposta == "falha"){
		divFalha.className="alert alert-warning alert-dismissible displayAbsolute";
	}else if(resposta == "error"){
		divError.className="alert alert-danger alert-dismissible displayAbsolute";
	}else if(resposta == "logout"){
		divLogOut.className ="alert alert-info alert-dismissible displayAbsolute";	
	}else if(resposta == "usuarioNaoEncontrado"){
			divUsuarioNaoEncontrado.className="alert alert-danger alert-dismissible displayAbsolute";
	}else{
		divSucesso.className="alert alert-success alert-dismissible displayNone";
		divFalha.className="alert alert-warning alert-dismissible displayNone";
		divError.className="alert alert-danger alert-dismissible displayNone";
		divLogOut.className ="alert alert-info alert-dismissible displayNone";
		divUsuarioNaoEncontrado.className="alert alert-danger alert-dismissible displayNone";
	}
}