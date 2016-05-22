(function (){

    var app = angular.module('create-delivery', ['jumpva']);


    app.controller("CreateDeliveryController", function($scope,$location,$uibModalInstance,user){

        var self = this;

        self.cancel = function(){
            $uibModalInstance.close('cancel');
        };

        self.createDelivery = function(){
            user.postCreatedShipment(self.newShipment).then(handleRequest);
        };

        function handleRequest(res) {
            $uibModalInstance.close('createDelivery');
        };

    });
})();
