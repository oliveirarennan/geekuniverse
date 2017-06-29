//Configuração da Validação dos Formularios usando o Plugin Jquery Validade
//link para download https://github.com/jquery-validation/jquery-validation/releases/tag/1.16.0 ; exemplos de uso http://www.devmedia.com.br/validacao-com-jquery-como-usar-o-plugin-validation/33670
//Mais exemplos http://www.linhadecodigo.com.br/artigo/3706/jquery-validate-validacao-de-formularios-html.aspx

$(function(){
    $('#frmCadastrarUsuario').validate(
            {
                rules : {
                    nome:{  
                        required:true,
                        rangelength:[3,100]
                    },
                    sobrenome:{  
                        required:true,
                        rangelength:[3,100]
                    },
                    pais:{  
                        required:true,
                        rangelength:[3,100]
                    },
                    estado:{  
                        required:true,
                    },
                    cidade:{  
                        required:true,
                        rangelength:[3,100]
                    },
                    bairro:{  
                        required:true,
                        rangelength:[3,100]
                    },
                    rua:{  
                        required:true,
                        rangelength:[3,100]
                    },
                    numero:{  
                        required:true,
                        rangelength:[1,100]
                    },
                    complemento:{  
                        required:true,
                        rangelength:[3,100]
                    },
                    cep:{  
                        required:true,
                    },
                    dataNascimento:{  
                        required:true,
                    },
                    celular:{  
                        required:true,
                    },
                    telefoneFixo:{  
                        required:true,
                    },
                    cpf:{  
                        required:true,
                    },
                    rg:{  
                        required:true,
                    },
                    email:{  
                        required:true,
                    },
                    senha:{  
                        rangelength:[8,20]
                    },
                    status:{
                        required: true,
                    }
                },
                messages:{
                    nome:{  
                        required:"Você precisa digitar seu nome",
                        rangelength:"Você precisa digitar no mínimo 3 caracteres",
                    },
                    sobrenome:{  
                        required:"Você precisa digitar seu sobrenome",
                        rangelength:"Você precisa digitar no mínimo 3 caracteres",
                    },
                    pais:{  
                        required:"Você precisa digitar seu pais",
                        rangelength:"Você precisa digitar no mínimo 3 caracteres",
                    },
                    estado:{  
                        required:"Você precisa digitar seu estado",
                    },
                    cidade:{  
                        required:"Você precisa digitar sua cidade",
                        rangelength:"Você precisa digitar no mínimo 3 caracteres",
                    },
                    bairro:{  
                        required:"Você precisa digitar seu bairro",
                        rangelength:"Você precisa digitar no mínimo 3 caracteres",
                    },
                    rua:{  
                        required:"Você precisa digitar sua rua",
                        rangelength:"Você precisa digitar no mínimo 3 caracteres",
                    },
                    numero:{  
                        required:"Você precisa digitar seu numero",
                        rangelength:"Você precisa digitar no mínimo 3 caracteres",
                    },
                    complemento:{  
                        required:"Você precisa digitar seu complemento",
                        rangelength:"Você precisa digitar no mínimo 3 caracteres",
                    },
                    cep:{  
                        required:"Você precisa digitar seu cep",
                    },
                    dataNascimento:{  
                        required:"Você precisa digitar sua data de nascimento",
                    },
                    celular:{  
                        required:"Você precisa digitar seu celular",
                    },
                    telFixo:{  
                        required:"Você precisa digitar seu telefone fixo",
                    },
                    cpf:{  
                        required:"Você precisa digitar seu cpf",
                    },
                    rg:{  
                        required:"Você precisa digitar seu rg",
                    },
                    email:{  
                        required:"Você precisa digitar seu email",
                    },
                    senha:{  
                        required:"Você precisa digitar sua senha",
                        rangelength:"Você precisa digitar no mínimo 3 caracteres",
                    },
                    status:{
                        required: true,
                    },
                   status:{
                        required: "Você precisa escolher um fabricante",
                    }
                },errorElement: "em",
    				errorPlacement: function ( error, element ) {
    					// Add the `help-block` class to the error element
    					error.addClass( "help-block" );

    					// Add `has-feedback` class to the parent div.form-group
    					// in order to add icons to inputs
    					element.parents( ".validateError" ).addClass( "has-feedback" );

    					if ( element.prop( "type" ) === "checkbox" ) {
    						error.insertAfter( element.parent( "label" ) );
    					} else {
    						error.insertAfter( element );
    					}

    					// Add the span element, if doesn't exists, and apply the icon classes to it.
    					if ( !element.next( "span" )[ 0 ] ) {
    						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
    					}
    				},
    				success: function ( label, element ) {
    					// Add the span element, if doesn't exists, and apply the icon classes to it.
    					if ( !$( element ).next( "span" )[ 0 ] ) {
    						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
    					}
    				},
    				highlight: function ( element, errorClass, validClass ) {
    					$( element ).parents( ".validateError" ).addClass( "has-error" ).removeClass( "has-success" );
    					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
    				},
    				unhighlight: function ( element, errorClass, validClass ) {
    					$( element ).parents( ".validateError" ).addClass( "has-success" ).removeClass( "has-error" );
    					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
    				}
    			} );
    
		} );