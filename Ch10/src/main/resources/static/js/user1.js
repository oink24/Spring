/**
 * User1
 */

$(function(){

	$('#btnUser1s').click(function(){
		$.ajax({
			url: '/Ch10/user1',
			type: 'GET', // 리스트 조회
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});

	$('#btnUser1').click(function(){
		$.ajax({
			url: '/Ch10/user1/A102',
			type: 'GET', // 해당 유저 조회
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});

	$('#btnUser1Register').click(function(){
		const jsonData = {
			id: 'B101',
			name: '홍길동',
			hp: '010-1111-1001',
			age: 22
		};

		$.ajax({
			url: '/Ch10/user1',
			type: 'POST', // 등록
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});

	$('#btnUser1Modify').click(function(){
		const jsonData = {
			id: 'B101',
			name: '홍길동',
			hp: '010-2222-2002',
			age: 33
		};

		$.ajax({
			url: '/Ch10/user1',
			type: 'PUT', // 수정
			data: jsonData,
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});

	$('#btnUser1Delete').click(function(){
		$.ajax({
			url: '/Ch10/user1/B101',
			type: 'DELETE',
			dataType: 'json',
			success: function(data){
				console.log(data);
			}
		});
	});
});