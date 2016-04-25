(function (){

    var app = angular.module('login', ['jumpva']);


    app.controller("LoginController", function($scope,$location,$uibModalInstance,logedUser){

        var loginCtrl = this;


        $scope.login = function(){
            $location.path('/main');
            $uibModalInstance.close('main');

        };

        $scope.cancel = function(){
            $uibModalInstance.close('cancel');
            $location.path('/home');
        };

    });
})();
