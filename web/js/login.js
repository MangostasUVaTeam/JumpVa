(function (){

    var app = angular.module('login', []);


    app.controller("LoginController", function($scope,$location,$uibModalInstance,logedUser, apiRequest){

        var loginCtrl = this;

        $scope.credentials = null;

        $scope.login = function(loginRequest){
            $location.path('/main');
            $uibModalInstance.close('main');
        

            console.log($scope.credentials);
            apiRequest.authenticate($scope.credentials,
                function(dataResponse) {
                    logedUser = dataResponse;
                    console.log(logedUser);
                }
            );

        };

        $scope.cancel = function(){
            $uibModalInstance.close('cancel');
        };

    });
})();
