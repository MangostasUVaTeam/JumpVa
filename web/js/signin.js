(function (){

    var app = angular.module('signin', ['jumpva']);


    app.controller("SigninController", function($scope,$location,$uibModalInstance,logedUser){

        var signinCtrl = this;

        $scope.cancel = function(){
            console.log("gola");
            $uibModalInstance.close('cancel');
        };

        $scope.createAccount = function(){
            $location.path('/main');
            $uibModalInstance.close('main');
        };

    });
})();
