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
    var dataTable = document.getElementById("datatable");
    var link = dataTable.children[0].attributes[0].value;

    window.location.href = window.location.host + link;
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


angular.module('modUser', []).controller('permBoxes', function ($scope, $http, $location) {

    $scope.save = function () {
        var data = {
            'uid': $location.$$absUrl.split('.')[2],
            'perms': $scope.userPermissions
        };

        console.log(angular.toJson(data));
        $http.post('/admin.modifyUser.updatePerm', angular.toJson(data)).then(function onSuccess(response) {
            console.log(response);
        });
    };

    $http.get('/api/permissions').then(function onSuccess(response) {
        $scope.permissionsTable = response.data;
    });

    $http.get('/api/userPermissions/' + $location.$$absUrl.split('.')[2]).then(function onSuccess(response) {
        $scope.userPermissions = response.data;
    });

    $scope.update = function (id) {
        var idx = $scope.userPermissions.indexOf(id);

        if (idx > -1) {
            $scope.userPermissions.splice(idx, 1);
        } else {
            $scope.userPermissions.push(id);
        }
    };
});