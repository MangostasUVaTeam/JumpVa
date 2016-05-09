(function (){

    var app = angular.module('login', []);


    app.controller("LoginController", function($scope,$location,$uibModalInstance,logedUser, apiRequest,$http){

        var loginCtrl = this;
        $scope.credentials = null;

        $scope.login = function(loginRequest, logedUser){
            $location.path('/main');
            $uibModalInstance.close('main');

            /*
            apiRequest.authenticate($scope.credentials,
                function(dataResponse) {
                    logedUser = dataResponse;
                }
            );
            */
            $http({
                method: 'POST',
                url:  'http://localhost:8080/JumpVa/api/authentication',
                data: $scope.credentials
            }).success(function(data, logedUser){
                // With the data succesfully returned, call our callback
                logedUser = data;
                console.log(logedUser);

            }).error(function(){
                alert("error");
            });
            console.log(logedUser);



        };

        $scope.cancel = function(){
            $uibModalInstance.close('cancel');
        };

    });
})();
