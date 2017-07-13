  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js" charset="UTF-8"></script>
    <script src="resources/js/jquery.maskMoney.min.js" charset="UTF-8"></script>
    <script src="resources/js/jquery.validate.min.js" charset="UTF-8"></script>
   <script src="resources/js/additional-methods.min.js" charset="UTF-8"></script>
   <script src="resources/js/ConfiguracaoMaskMoney.js" charset="UTF-8"></script>
    <script src="resources/js/jquery.maskedinput.min.js" charset="UTF-8"></script>
    <script src="resources/js/ConfiguracaoMaskInput.js" charset="UTF-8"></script>
    <script src="resources/js/scripts.js" charset="UTF-8"></script>
    
    <script type="text/javascript" charset="UTF-8">
    $(function() {

    	  // We can attach the `fileselect` event to all file inputs on the page
    	  $(document).on('change', ':file', function() {
    	    var input = $(this),
    	        numFiles = input.get(0).files ? input.get(0).files.length : 1,
    	        label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
    	    input.trigger('fileselect', [numFiles, label]);
    	  });

    	  // We can watch for our custom `fileselect` event like this
    	  $(document).ready( function() {
    	      $(':file').on('fileselect', function(event, numFiles, label) {

    	          var input = $(this).parents('.input-group').find(':text'),
    	              log = numFiles > 1 ? numFiles + ' files selected' : label;

    	          if( input.length ) {
    	              input.val(log);
    	          } else {
    	              if( log ) alert(log);
    	          }

    	      });
    	  });
    	  
    	});
    </script>
    
  </body>
</html>

  