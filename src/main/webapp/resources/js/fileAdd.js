/**
 * 글 작성 시 첨부파일 관리하는 js
 */
 let count=0;	 		//count는 add, delete할때 둘다 쓰려고 전역변수로 선언
 
 function fileDeleteInit(){
	$(".del").click(function(){
		let check = window.confirm("영구적으로 삭제됩니다. 삭제하시겠습니까?");
		if(!check){
			return;
		}
		let fileNum=$(this).attr("data-num");
		let selector=$(this);
		//console.log(this);			//event의 타겟 (클릭한 element) 
		console.log(selector);
		
		$.ajax({
			type:"POST",
			url: "./fileDelete",
			data:{
				fileNum:fileNum
			},
			success:function(data){			//0또는1이들어옴(productController의 setFileDelete에서 넘어옴)
				//console.log(this);	//ajax객체를 얘기함 this를 써도 9번줄과 다르다.
				console.log(selector);
				if(data.trim()=='1'){
					$(selector).parent().remove();
					count--;	
					alert("파일 삭제 성공");
				}else{
					alert("파일 삭제 실패");
				}
			},
			error:function(){
				alert("파일 삭제 실패");
			}
		})
	})
} 
 
 function fileAddInit(c){
	count=c;
 
	$("#fileAdd").click(function() {
		if (count > 4) {
			alert('첨부파일은 최대 5개 까지만 가능합니다.');
			return;
		}
		let f = ' <div class="row mb-3">';
							
		f = f + '<div class="col-sm-10">';
		f = f + '<div class="input-group">';
		f = f + '<input type="file" class="form-control files" id="files" name="files" aria-describedby="inputGroupFileAddon04" aria-label="Upload">';
		f = f + '<button class="btn btn-outline-secondary del" type="button" id="inputGroupFileAddon04">X</button>';
		f = f + '</div>';
		f = f + '</div>';
		f = f + '</div>';
		
		$("#fileResult").append(f)
		count++;
	});
	//속성 안에 ""이 있어서 ''으로 묶는다

	$("#fileResult").on("click", ".del", function() {
		$(this).parent().remove();
		count--;
	})
}