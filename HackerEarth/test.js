function hack1(hV1, hV2){
	var hArr = [];
	for (var i = hV1; i<= hV2, i++){
		hArr.push(i);
	}
	var replaceArr = []
	hArr.forEach(
		function(hV3){
			if(hack2(hV3))
				replaceArr.push(hV3);
		}
	);
	
	return replaceArr;
}

function hack2(hV3){
	if((hV3%4 == 0 && hV3 % 100 !=0) || (hV3%100===0 && hV3%400 === 0)){
		return hV3;
	}
	else {
		return false;
	}
}
document.write(hack1(5000,5012));
