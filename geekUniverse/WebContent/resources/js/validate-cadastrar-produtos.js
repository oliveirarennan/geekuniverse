//Configuração da Validação dos Formularios usando o Plugin Jquery Validade
//link para download https://github.com/jquery-validation/jquery-validation/releases/tag/1.16.0 ; exemplos de uso http://www.devmedia.com.br/validacao-com-jquery-como-usar-o-plugin-validation/33670
//Mais exemplos http://www.linhadecodigo.com.br/artigo/3706/jquery-validate-validacao-de-formularios-html.aspx

$(function(){
    $('#frmCadastrarProduto').validate(
            {
                rules : {
                    nome:{  
                        required:true,
                        rangelength:[3,100],
                    },
                    descicao:{
                        required: true,
                        rangelength:[3,255],
                    },
                    valor:{
                        required: true,
                    },
                    estoque:{
                        required: true,
                        digits: true,
                        range: [0, 999] ,       
                    },
                    imagem:{
                        required: true

                    }
                },

                messages:{
                    nome:{
                        required: "Você precisa digitar o nome do Produto",
                        rangelength: "O nome do produto precisa ter entre 3 a 100 caracteres",
                    },
                    descricao:{
                        required:"Você precisa digitar a descrição do Produto",
                        rangelength: "O descrição do produto precisa ter entre 3 a 255 caracteres",
                    },
                    valor:{
                        required:"Você precisa digitar um valor",
                    },
                    estoque:{
                        required: "Você precisa digitar o número de itens que tem no estoque",
                        digits: "Digite Apenas Números Inteiros",
                        range: "Digite um numero entre 0 e 1000",
                    },
                    imagem:{
                        required:"Você precisa selecionar um arquivo."
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