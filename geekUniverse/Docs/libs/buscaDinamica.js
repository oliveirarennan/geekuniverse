$(document).ready(function(){
	$('#txtBuscaNome').keyup(function(){
		
		
		$('form').submit(function(){
			var dados = $(this).serialize();
			$.ajax({
				url: 'busca.php',
				type: 'POST',
				dataType: 'html',
				data: dados,
				success: function(data){
						$('#resultado').empty().html(data);
				}
				
			});
			return false;
		});
		$('form').trigger('submit');
	});
	
	
	
});


