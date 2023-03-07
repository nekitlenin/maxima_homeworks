
const animBlocks = document.querySelectorAll('.anim-blocks');

if (animBlocks.length > 0) {
	window.addEventListener('scroll', animScroll);
	function animScroll(params) {
		for (let i = 0; i < animBlocks.length; i++) {
			const animBlock = animBlocks[i];

			// высота объекта
			const animBlockHeight = animBlock.offsetHeight;

			// позиция объекта относительно верха страницы
			const animBlockOffset = offset(animBlock).top;

			// коеф регулирующий момент старта анимации
			const animStart = 4;

			let animBlockPoint = window.innerHeight - animBlockHeight / animStart;
			
			if (animBlockHeight > window.innerHeight) {
				animBlockPoint = window.innerHeight - window.innerHeight / animStart;
			}

			if ((scrollY > animBlockOffset - animBlockPoint) && scrollY < (animBlockOffset + animBlockHeight)) {
				animBlock.classList.add('active');
			} else {
				if (!animBlock.classList.contains('anim-no-hide')) {
					animBlock.classList.remove('active');
				}
			}
		}
	}
	
	function offset(el) {
		const rect = el.getBoundingClientRect(),
		scrollLeft = window.scrollX || document.documentElement.scrollLeft,
		scrollTop = window.scrollY || document.documentElement.scrollTop;
		return { top: rect.top + scrollTop, left: rect.left + scrollLeft}
	}

	setTimeout(() => {
		animScroll();
	}, 300);
}