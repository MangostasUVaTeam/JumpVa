(function (){

    var app = angular.module('search-deliveries', ['jumpva']);

    app.controller('SearchDeliveriesController', function ($scope, $uibModalInstance,$uibModal  ) {

        $scope.unassignedDeliveries = [
                {
                    origen: "Valladolid",
                    destino: "Palencia",
                    distancia: 50,
                    puja: 0
                },
                {
                    origen: "Valladolid",
                    destino: "Santander",
                    distancia: 50,
                    puja: 0
                },
                {
                    origen: "Valladolid",
                    destino: "Galicia",
                    distancia: 50,
                    puja: 0
                },
                {
                    origen: "Valladolid",
                    destino: "LLanes",
                    distancia: 50,
                    puja:0
                },
                {
                    origen: "Valladolid",
                    destino: "Valencia",
                    distancia: 50,
                    puja:0
                },
                {
                    origen: "Valladolid",
                    destino: "Cadiz",
                    distancia: 50,
                    puja:0
                },
                {
                    origen: "Valladolid",
                    destino: "Pamplona",
                    distancia: 50,
                    puja:0
                }
        ];
        $scope.origen = "Valladolid"

        $scope.cancel = function () {
            $uibModalInstance.close();
        };

        $scope.setOver = function(delivery) {
            $scope.origen = delivery.origen;
            $scope.destino = delivery.destino;
        }

        $scope.bid = function(delivery){
            var modalInstance = $uibModal.open({
              templateUrl: 'includes/confirm-bid.html',
              controller: 'ConfirmBidController',
              resolve: {
                  delivery: function () {
                    return delivery;
                  },

              }
            });


            modalInstance.result.then(function (selectedItem) {
                $scope.selected = selectedItem;

                if (selectedItem === 'confirm'){
                    $scope.unassignedDeliveries.splice(
                        $scope.unassignedDeliveries.indexOf(delivery),
                        1
                    );
                }
            });

        }
    });

    app.controller('ConfirmBidController', function ($scope, $uibModalInstance, delivery) {
      $scope.delivery = delivery;

      $scope.confirm = function(){
        console.log('Confimado');
        $uibModalInstance.close('confirm');
      };

      $scope.cancel = function() {
        console.log('No Confimado');
        $uibModalInstance.close('cancel');
      };
    });


})();
