(function (){

    var app = angular.module('unassigned-delivery', ['jumpva']);

    app.controller("UnassignedController", function($scope,$uibModal){
        this.assign = function(delivery, bid){
            $uibModal.open({
                templateUrl: 'includes/assign-delivery.html',
                controller: 'AssignDeliveryController',
                resolve: {
                    delivery: function () {
                      return delivery;
                    },
                    bid: function () {
                      return bid;
                    }
                }
            });
        };
    });

    app.controller('AssignDeliveryController', function ($scope, $uibModalInstance,delivery, bid ) {

        $scope.bid = bid;
        $scope.delivery = delivery;

        $scope.asignar = function(){
            delivery.transportista = bid.transportista;
            $uibModalInstance.dismiss();
        }
    });

})();
