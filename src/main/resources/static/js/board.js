let index = {
	init: function () {
		$("#btn-save").on("click", () => { //function{} 대신 () => {} 를 쓰는 이유는 this를 바인딩 하기위해서 
			this.save();
		});
		$("#btn-delete").on("click", () => { //function{} 대신 () => {} 를 쓰는 이유는 this를 바인딩 하기위해서 
			this.deleteById();
		});
		$("#btn-update").on("click", () => { //function{} 대신 () => {} 를 쓰는 이유는 this를 바인딩 하기위해서 
			this.update();
		});
		$("#btn-reply-save").on("click", () => { //function{} 대신 () => {} 를 쓰는 이유는 this를 바인딩 하기위해서 
			this.replySave();
		});
	},
	save: function () {
		//alert("user의 save함수 호출됨")
		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};

		// ajax호출시 default는 비동기 호출
		// ajax통신을 이용해서 저 3개의 데이터를 json으로 변경하여 insert요청
		// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바스크립트 오브젝트로 변환
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data), //http body 데이터
			contentType: "application/json;charset=utf-8", //body데이터가 어떤 타입인지(MIME)
			dataType: "json"//요청을 서버로해서 응답이 왔을 때 , 기본적으로 응답은 문자열이다 (근데 생긴게 json이라면 => javascript오브젝트로 변경)
		}).done(function (resp) {
			//정상이면
			alert("글쓰기가 완료되었습니다");
			console.log(resp);
			location.href = "/";
		}).fail(function (error) {
			//실패하면
			alert(JSON.stringify(error));
		});
	},
	
	deleteById: function () {
		let id = $('#id').text();

		$.ajax({
			type: "DELETE",
			url: "/api/board/" + id,
			dataType: "json"//요청을 서버로해서 응답이 왔을 때 , 기본적으로 응답은 문자열이다 (근데 생긴게 json이라면 => javascript오브젝트로 변경)
		}).done(function (resp) {
			//정상이면
			alert("삭제가 완료되었습니다");
			console.log(resp);
			location.href = "/";
		}).fail(function (error) {
			//실패하면
			alert(JSON.stringify(error));
		});
	},
	
	update: function () {
		let id = $("#id").val();

		let data = {
			title: $("#title").val(),
			content: $("#content").val(),
		};

		$.ajax({
			type: "PUT",
			url: "/api/board/" + id,
			data: JSON.stringify(data), //http body 데이터
			contentType: "application/json;charset=utf-8", //body데이터가 어떤 타입인지(MIME)
			dataType: "json"//요청을 서버로해서 응답이 왔을 때 , 기본적으로 응답은 문자열이다 (근데 생긴게 json이라면 => javascript오브젝트로 변경)
		}).done(function (resp) {
			//정상이면
			alert("글수정이 완료되었습니다");
			location.href = "/";
		}).fail(function (error) {
			//실패하면
			alert(JSON.stringify(error));
		});
	},
	
	replySave: function () {
		//alert("user의 save함수 호출됨");
		let data = {
			userId: $("#userId").val(),
			 boardId: $("#boardId").val(),
			content: $("#reply-content").val(),
		};
		// ajax호출시 default는 비동기 호출
		// ajax통신을 이용해서 저 3개의 데이터를 json으로 변경하여 insert요청
		// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바스크립트 오브젝트로 변환
		$.ajax({
			type: "POST",
			url: `/api/board/${data.boardId}/reply`,
			data: JSON.stringify(data), //http body 데이터
			contentType: "application/json;charset=utf-8", //body데이터가 어떤 타입인지(MIME)
			dataType: "json"//요청을 서버로해서 응답이 왔을 때 , 기본적으로 응답은 문자열이다 (근데 생긴게 json이라면 => javascript오브젝트로 변경)
		}).done(function (resp) {
			//정상이면
			alert("댓글 작성이 완료되었습니다");
			console.log(resp);
			location.href = `/board/${data.boardId}`;
		}).fail(function (error) {
			//실패하면
			alert(JSON.stringify(error));
		});
	},
	replyDelete: function (boardId,replyId) {
		$.ajax({
			type: "DELETE",
			url: `/api/board/${boardId}/reply/${replyId}`,
			dataType: "json"//요청을 서버로해서 응답이 왔을 때 , 기본적으로 응답은 문자열이다 (근데 생긴게 json이라면 => javascript오브젝트로 변경)
		}).done(function (resp) {
			//정상이면
			alert("댓글삭제가 완료되었습니다");
			console.log(resp);
			location.href = `/board/${boardId}`;
		}).fail(function (error) {
			//실패하면
			alert(JSON.stringify(error));
		});
	},
}
index.init();