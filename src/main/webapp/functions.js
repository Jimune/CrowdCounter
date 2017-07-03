function fetchData() {
    var input = document.getElementById("finduserinput").value;
    var table = document.getElementById("datatable");

    if (input.length <= 0) {
        table.innerHTML = "";
        return;
    }

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            table.innerHTML = xhttp.responseText;
        }
    };

    xhttp.open("POST", "/admin.modifyUser.fetchuser", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("name=" + input);
}

function checkEnter() {

}

function updatePerm(user, perm, checkbox) {
    var add = checkbox.checked;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            //table.innerHTML = xhttp.responseText;
        }
    };

    xhttp.open("POST", "/admin.modifyUser.updatePerm", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("user=" + user + "&perm=" + perm + "&enabled=" + add);
}