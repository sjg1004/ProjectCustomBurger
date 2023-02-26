
$(function() {
	$.ajax({
		url: "/menu-list2/0",
		success: function(result) {
			$("#cate-hover-list").html(result);
		}
	});
});
