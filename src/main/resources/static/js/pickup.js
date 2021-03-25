$(document).ready(function(){
	
	 function Save(){
			var d = new Date();
			var impl = "";
			impl = ('Hora:' + d.getHours() + ' Minutos: ' + d.getMinutes()
					+ ' segundos: ' + d.getSeconds());

			$("p").append(impl);
	 }
	
	
	
	
  });






