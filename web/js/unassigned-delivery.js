(function (){

    var app = angular.module('unassigned-delivery', ['jumpva']);

    app.controller("UnassignedController", function ($scope,$uibModal) {
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

    app.controller('AssignDeliveryController', function ($scope, $uibModalInstance,$uibModal,delivery, bid ) {

        $scope.bid = bid;
        $scope.delivery = delivery;

        $scope.asignar = function(delivery, bid){
          console.log("hola");
          $uibModal.open({
              templateUrl: 'includes/confirm-assign.html',
              controller: 'ConfirmAssignController',
              resolve: {
                  delivery: function () {
                    return delivery;
                  },
                  bid: function () {
                    return bid;
                  }
              }
          });
          $uibModalInstance.dismiss('cancel');
        };
        $scope.cancel = function () {
          $uibModalInstance.dismiss('cancel');
        };
    });

    app.controller('ConfirmAssignController', function ($scope, $uibModalInstance, delivery, bid) {
      $scope.bid = bid;
      $scope.delivery = delivery;
      console.log("Confirmacion");
      $scope.confirm = function(){
        delivery.completado=1;
        delivery.transportista = bid.transportista;
        $uibModalInstance.dismiss('cancel');
      };

      $scope.cancel = function() {
        $uibModalInstance.dismiss('cancel');
      };
    });

})();
