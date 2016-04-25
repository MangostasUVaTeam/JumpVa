(function (){

    var app = angular.module('create-delivery', ['jumpva']);


    app.controller("CreateDeliveryController", function($scope,$location,$uibModalInstance,logedUser){

        var loginCtrl = this;


        $scope.login = function(){
            $location.path('/main');
            $uibModalInstance.close('main');

        };

        $scope.cancel = function(){
            $uibModalInstance.close('cancel');
        };

    });
})();
