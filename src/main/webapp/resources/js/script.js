$( document ).ready(function() {
	
	$("#addNewCriteria").click(function() {
		$('#insertModal').modal('show');
	});
	
	$("#closeModal").click(function() {
		$('#insertModal').modal('hide');
	});
	
	$("#buttonClose").click(function() {
		$('#insertModal').modal('hide');
	});
	
	$("#showTypesApps").click(function() {
		$('#showTypesAppModal').modal('show');
	})
	
	$("#closeModalTypeAppModal").click(function() {
		$('#showTypesAppModal').modal('hide');
	});
	
	$("#buttonCloseTypesAppModal").click(function() {
		$('#showTypesAppModal').modal('hide');
	});
	
});


function compareTools() {
	window.location.href = '/VersusTools/vs/' + $('#appSelect1').val() + '/versus/' + $('#appSelect2').val();
}