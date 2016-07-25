;(function(){
	var Loading = function(){

	};
	Loading.prototype = {
		contractor: Loading,
		show: function(){
			var existingLoader = document.querySelector('.loading-masker');
			if(existingLoader) {
				document.body.removeChild(existingLoader);
			}

			var loader = document.createElement('div');
			loader.className = 'loading-masker';
			loader.innerHTML = '<div class="loading"></div>';
			document.body.appendChild(loader);

			setTimeout(function(){
				document.body.removeChild(loader);
			},3000)
		},
		remove: function(){
			var loader = document.querySelector('.loading-masker');
			if(loader){
				//setTimeout(function(){
					document.body.removeChild(loader);
				//},500)
			}

			var existingScrollLoader = document.querySelector('.scroll-loading');
			if(existingScrollLoader){
				var reg = new RegExp('(\\s|^)scroll-loading(\\s|$)');
				//setTimeout(function(){
					existingScrollLoader.className = existingScrollLoader.className.replace(reg,'');
				//},500)
			}
		}
	};
	window.loading = new Loading();
})();