var select_app = angular.module('selectUser', []);
select_app.controller('findUser', function($scope, $http) {
    $http.post('/admin.modifyUser.fetchuser', {
        name: $scope.finduserinput
    }).then(function(success, response) {
        $scope.users = response;
    });
});