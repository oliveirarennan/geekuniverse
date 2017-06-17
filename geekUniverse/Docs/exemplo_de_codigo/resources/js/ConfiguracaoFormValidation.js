//Configuração da Validação dos Formularios usando o Plugin Jquery Validade
//link para download https://github.com/jquery-validation/jquery-validation/releases/tag/1.16.0 ; exemplos de uso http://www.devmedia.com.br/validacao-com-jquery-como-usar-o-plugin-validation/33670
//Mais exemplos http://www.linhadecodigo.com.br/artigo/3706/jquery-validate-validacao-de-formularios-html.aspx

$(function(){
    $('#frmTeste').validate(
        {
            rules : {
                nome:{  
                    required:true,
                    rangelength:[3,50]
                },
                email:{
                    required: true,
                    email: true
                },
                data:{
                    required: true,
                    date: true
                },
                valor:{
                    required: true,
                    //Devido ao MaskMoney Não pode ser limitado a números
                    //number: true
                },
                quantidade:{
                    required: true,
                    digits: true,
                    range:[0, 9999]
                }


            },
            messages:{
                nome:{
                    required: "Você precisa digitar seu nome",
                    rangelength: "Seu nome precisar ter entre 3 a 50 caracteres"
                },
                email:{
                    required:"Você precisa digitar seu email",
                    email:"Formato de email invalido"
                },
                data:{
                    required:"Você precisa informar uma data",
                    date: "Formato de data incorreto"
                },
                valor:{
                    required:"Você precisa informar o valor",
                    number: "Você só pode digitar números"
                },
                quantidade:{
                    required: "Você precisa informar uma quantidade.",
                    digits: "Você só pode digitar números",
                    range: "Você só pode entrar valores entre 0 e 9999"
                }
            }/*,
            errorElement: "em",
            errorPlacement: function(error, errorElement){
                //Adiciona a classe help-block na classe de erro em
                error.addClass("help-block");
                //adiciona a classe had-feedback nos filhos da classe testeError
                element.parents( ".testeErro" ).addClass( "has-feedback" );

                //Ajusta o erro quando o elemento é checkbox
                if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {    
						error.insertAfter( element );
					}

                    // Adiciona uma spam para mostrar o icone de erro. Só funciona se tiver o bootstrap.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
					}
            },
            success: function ( label, element ) {
					// Adiciona um spam para mostrar o icine de sucesso .Só funciona se usar o bootstrap.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
					}
				},
                //Destaca o campo 
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".testeErro" ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
				},
                //Tira o destaque do campo
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".testeErro" ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
				}
                */

        }
    )
})