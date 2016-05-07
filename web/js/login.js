(function (){

    var app = angular.module('login', []);


    app.controller("LoginController", function($scope,$location,$uibModalInstance,logedUser, apiRequest){

        var loginCtrl = this;


        $scope.login = function(loginRequest){
            $location.path('/main');
            $uibModalInstance.close('main');
            //apiRequest.getData();
        };
        
        apiRequest.getData(function(dataResponse) {
            console.log(dataResponse);
        });

        $scope.cancel = function(){
            $uibModalInstance.close('cancel');
        };

    });
})();
