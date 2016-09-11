function IsEmpty() {
	if (document.forms['add'].subject.value === "") {
		alert("Question can't be empty");
		return false;
	}
	return true;
}