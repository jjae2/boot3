//textarea의 id가 다를경우 summernote를 초기화해주는 함수를 만들어줘라
 function summernoteInit(selector, code){   //selector라고 되어있는 부분에 id를 보낼것이다.
   
    //summernote   
	  $("#"+selector).summernote({
		  height: 400,
		  placeholder:"내용을 입력해주세요.",
		  callbacks:{
			  onImageUpload:function(files){
				 //files upload한 이미지 파일객체
				let formData= new FormData();
				formData.append("files",files[0]);
				
				//   /board/summerFileUpload
				$.ajax({
			        type:"POST",
			        url :"./summerFileUpload",
			        data:formData,
			        processData:false,
			        contentType:false,
			        success:function(data){
			        	$(".note-image-input").val('')
			        	$("#"+selector).summernote('editor.insertImage',data.trim());
			        }
				})
			  }, //onImageUpload 끝
			  
			  onMediaDelete:function(files){
				  let fileName=$(files[0]).attr("src");
				  console.log(fileName);
				  $.ajax({
					  type:"GET",
					  url:"./summerFileDelete",
					  data:{
						  fileName:fileName
					  },
					  success:function(data){
						  console.log(data);
					  }
					  
				  });
			  }//onMediaDelete 끝
		  }
	  });
   $("#"+selector).summernote("code",code);
   //$('#detail').summernote("code","${vo.productDetail}");  //textarea태그안에 써도되고 , 이렇게써도 됨  
}
