(function (){

    var app = angular.module('unassigned-delivery', ['jumpva']);

    app.controller("UnassignedController", function ($scope,$uibModal) {
        this.assign = function(delivery, bid){
            
            $uibModal.open({
                templateUrl: 'includes/assign-delivery.html',
                controller: 'AssignDeliveryController',
                size: 'lg',
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
      $scope.confirm = function(){
          //TODO
        $uibModalInstance.dismiss('confirm');
      };

      $scope.cancel = function() {
        $uibModalInstance.dismiss('cancel');
      };
    });

})();
