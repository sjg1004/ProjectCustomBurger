

$(function(){
	var container = $('.slideshow'),
		slideGroup = container.find('.slideshow_slides'),
		slides = slideGroup.find('a'),
		nav = container.find('.slideshow_nav'),
		indicator = container.find('.indicator'),
		slideCount = slides.length,
		indicatorHtml = '',
		currentIndex = 0,
		duration = 500,
		easing = 'easeInOutExpo',
		interval = 3500,
		timer;
		
		console.log(slides);
		
		// 슬라이드 가로로 배열
		slides.each(function(i){
			var newLeft = i * 100 + '%';
			$(this).css({left:newLeft});
			indicatorHtml += '<a href="">'+ (i+1) + '</a>';
			console.log(indicatorHtml);
			
		});
		
		indicator.html(indicatorHtml);
		
		//슬라이드 이동 함수
		function goToslide(index){
			slideGroup.animate({left:-100*index + '%'},duration);
			currentIndex = index;
			
			updateNav();//슬라이드가 처음인지 마지막인지 검사
		};
		function updateNav(){
			var navPrev = nav.find('.prev');
			var navNext = nav.find('.next');
			if(currentIndex == 0){
				navPrev.addClass('disabled');
			}else{
				navPrev.removeClass('disabled');
			}
			if(currentIndex == slideCount -1){
				navNext.addClass('disabled');
			}else{
				navNext.removeClass('disabled');
			}
			indicator.find('a').removeClass('active');
			indicator.find('a').eq(currentIndex).addClass('active');
			
		}
		
		//자동슬라이드 함수
		
		
		//인디케이터로 이동하기
		indicator.find('a').click(function(e){
			e.preventDefault();
			var idx = $(this).index();
			console.log(idx);
			goToslide(idx);
			
		});
		
		nav.find('a').click(function(e){
			e.preventDefault();
			if($(this).hasClass('prev')){
				goToslide(currentIndex -1);
			}else{
				goToslide(currentIndex +1);
			}
			
		});
		updateNav();
		function startTimer(){
			timer = setInterval(function(){
				
				var nextIndex = (currentIndex +1) % slideCount;
				goToslide(nextIndex);
			},interval)
		}
		startTimer();
		function stopTimer(){
			clearInterval(timer);
		}
		
		container.mouseenter(function(){
			stopTimer();
		})
		.mouseleave(function(){
			startTimer();
		});
		
});

